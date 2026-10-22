package androidx.fragment.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String SAVED_BACK_STACK_ID = "android:backStackId";
    private static final String SAVED_CANCELABLE = "android:cancelable";
    private static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    private static final String SAVED_INTERNAL_DIALOG_SHOWING = "android:dialogShowing";
    private static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    private static final String SAVED_STYLE = "android:style";
    private static final String SAVED_THEME = "android:theme";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private int mBackStackId;
    private boolean mCancelable;
    private boolean mCreatingDialog;
    private Dialog mDialog;
    private boolean mDialogCreated;
    private Runnable mDismissRunnable;
    private boolean mDismissed;
    private Handler mHandler;
    private Observer<LifecycleOwner> mObserver;
    private DialogInterface.OnCancelListener mOnCancelListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private boolean mShownByMe;
    private boolean mShowsDialog;
    private int mStyle;
    private int mTheme;
    private boolean mViewDestroyed;

    public DialogFragment() {
        this.mDismissRunnable = new AnonymousClass1(this);
        this.mOnCancelListener = new AnonymousClass2(this);
        this.mOnDismissListener = new AnonymousClass3(this);
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new AnonymousClass4(this);
        this.mDialogCreated = false;
    }

    public DialogFragment(int r2) {
        super(r2);
        this.mDismissRunnable = new AnonymousClass1(this);
        this.mOnCancelListener = new AnonymousClass2(this);
        this.mOnDismissListener = new AnonymousClass3(this);
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new AnonymousClass4(this);
        this.mDialogCreated = false;
    }

    static /* synthetic */ Dialog access$000(DialogFragment r0) {
        return r0.mDialog;
    }

    static /* synthetic */ DialogInterface.OnDismissListener access$100(DialogFragment r0) {
        return r0.mOnDismissListener;
    }

    static /* synthetic */ boolean access$200(DialogFragment r0) {
        return r0.mShowsDialog;
    }

    private void dismissInternal(boolean r4, boolean r5, boolean r6) {
        if (this.mDismissed == false) goto L5;
        return;
    L5:
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog r1 = this.mDialog;
        if (r1 == null) goto L13;
        r1.setOnDismissListener(null);
        this.mDialog.dismiss();
        if (r5 == true) goto L13;
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L12;
        onDismiss(this.mDialog);
        goto L13
    L12:
        this.mHandler.post(this.mDismissRunnable);
    L13:
        this.mViewDestroyed = true;
        if (this.mBackStackId < 0) goto L19;
        if (r6 == false) goto L17;
        getParentFragmentManager().popBackStackImmediate(this.mBackStackId, 1);
    L18:
        this.mBackStackId = -1;
        return;
    L17:
        getParentFragmentManager().popBackStack(this.mBackStackId, 1, r4);
        goto L18
    L19:
        FragmentTransaction r7 = getParentFragmentManager().beginTransaction();
        r7.setReorderingAllowed(true);
        r7.remove(this);
        if (r6 == false) goto L22;
        r7.commitNow();
        return;
    L22:
        if (r4 == false) goto L24;
        r7.commitAllowingStateLoss();
        return;
    L24:
        r7.commit();
    }

    private void prepareDialog(Bundle r6) {
        if (this.mShowsDialog == true) goto L6;
        return;
    L6:
        if (this.mDialogCreated == false) goto L20;
        return;
    L20:
        this.mCreatingDialog = true;     // Catch: Throwable -> L16
        Dialog r7 = onCreateDialog(r6);     // Catch: Throwable -> L16
        this.mDialog = r7;     // Catch: Throwable -> L16
        if (this.mShowsDialog == false) goto L14;
        setupDialog(r7, this.mStyle);     // Catch: Throwable -> L16
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (ZeusTransformUtils.instanceOf(r8, Activity.class) == false) goto L13;
        this.mDialog.setOwnerActivity((Activity) ZeusTransformUtils.preCheckCast(r8, Activity.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
    L13:
        this.mDialog.setCancelable(this.mCancelable);     // Catch: Throwable -> L16
        this.mDialog.setOnCancelListener(this.mOnCancelListener);     // Catch: Throwable -> L16
        this.mDialog.setOnDismissListener(this.mOnDismissListener);     // Catch: Throwable -> L16
        this.mDialogCreated = true;     // Catch: Throwable -> L16
    L15:
        this.mCreatingDialog = false;
        return;
    L14:
        this.mDialog = null;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mCreatingDialog = false;
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    FragmentContainer createFragmentContainer() {
        final FragmentContainer r0 = super.createFragmentContainer();
        return new AnonymousClass5(this, r0);
    }

    public void dismiss() {
        dismissInternal(false, false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false, false);
    }

    public void dismissNow() {
        dismissInternal(false, false, true);
    }

    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r3) {
        super.onAttach((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (this.mShownByMe == true) goto L6;
        this.mDismissed = false;
        return;
    }

    public void onCancel(DialogInterface r2) {
        DialogInterface r1 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.mHandler = new Handler();
        if (this.mContainerId != 0) goto L5;
        boolean r0 = true;
    L6:
        this.mShowsDialog = r0;
        if (r4 == null) goto L10;
        this.mStyle = r4.getInt(SAVED_STYLE, 0);
        this.mTheme = r4.getInt(SAVED_THEME, 0);
        this.mCancelable = r4.getBoolean(SAVED_CANCELABLE, true);
        this.mShowsDialog = r4.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
        this.mBackStackId = r4.getInt(SAVED_BACK_STACK_ID, -1);
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public Dialog onCreateDialog(Bundle r4) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d(FragmentManager.TAG, "onCreateDialog called for DialogFragment " + this);
    L6:
        return new ComponentDialog((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L9;
        this.mViewDestroyed = true;
        r0.setOnDismissListener(null);
        this.mDialog.dismiss();
        if (this.mDismissed == true) goto L7;
        onDismiss(this.mDialog);
    L7:
        this.mDialog = null;
        this.mDialogCreated = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mShownByMe == false) goto L5;
    L7:
        getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
        return;
    L5:
        if (this.mDismissed == true) goto L7;
        this.mDismissed = true;
        goto L7
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r3) {
        DialogInterface r4 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        if (this.mViewDestroyed == false) goto L5;
        return;
    L5:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L7;
        Log.d(FragmentManager.TAG, "onDismiss called for DialogFragment " + this);
    L7:
        dismissInternal(true, true, false);
    }

    View onFindViewById(int r1) {
        Dialog r0 = this.mDialog;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.findViewById(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle r5) {
        LayoutInflater r0 = super.onGetLayoutInflater(r5);
        if (this.mShowsDialog == false) goto L15;
        if (this.mCreatingDialog == true) goto L15;
        prepareDialog(r5);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L10;
        Log.d(FragmentManager.TAG, "get layout inflater for DialogFragment " + this + " from dialog context");
    L10:
        Dialog r4 = this.mDialog;
        if (r4 != null) goto L13;
        return r0;
    L13:
        return r0.cloneInContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L15:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L21;
        String r6 = "getting layout inflater for DialogFragment " + this;
        if (this.mShowsDialog == true) goto L19;
        StringBuilder r7 = new StringBuilder();
        String r1 = "mShowsDialog = false: ";
    L20:
        Log.d(FragmentManager.TAG, r7.append(r1).append(r6).toString());
        goto L21
    L19:
        r7 = new StringBuilder();
        r1 = "mCreatingDialog = true: ";
    L21:
        return r0;
    }

    boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r4) {
        super.onSaveInstanceState(r4);
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L5;
        Bundle r1 = r0.onSaveInstanceState();
        r1.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
        r4.putBundle(SAVED_DIALOG_STATE_TAG, r1);
    L5:
        int r2 = this.mStyle;
        if (r2 == 0) goto L8;
        r4.putInt(SAVED_STYLE, r2);
    L8:
        int r3 = this.mTheme;
        if (r3 == 0) goto L11;
        r4.putInt(SAVED_THEME, r3);
    L11:
        boolean r5 = this.mCancelable;
        if (r5 == true) goto L14;
        r4.putBoolean(SAVED_CANCELABLE, r5);
    L14:
        boolean r6 = this.mShowsDialog;
        if (r6 == true) goto L17;
        r4.putBoolean(SAVED_SHOWS_DIALOG, r6);
    L17:
        int r7 = this.mBackStackId;
        if (r7 == (-1)) goto L21;
        r4.putInt(SAVED_BACK_STACK_ID, r7);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        this.mViewDestroyed = false;
        r0.show();
        View r1 = this.mDialog.getWindow().getDecorView();
        ViewTreeLifecycleOwner.set(r1, this);
        ViewTreeViewModelStoreOwner.set(r1, this);
        ViewTreeSavedStateRegistryOwner.set(r1, this);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.hide();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        if (this.mDialog == null) goto L9;
        if (r2 == null) goto L10;
        Bundle r3 = r2.getBundle(SAVED_DIALOG_STATE_TAG);
        if (r3 == null) goto L11;
        this.mDialog.onRestoreInstanceState(r3);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    void performCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        super.performCreateView(r1, r2, r3);
        if (this.mView == null) goto L5;
        return;
    L5:
        if (this.mDialog == null) goto L12;
        if (r3 == null) goto L13;
        Bundle r4 = r3.getBundle(SAVED_DIALOG_STATE_TAG);
        if (r4 == null) goto L14;
        this.mDialog.onRestoreInstanceState(r4);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final Dialog requireDialog() {
        Dialog r0 = getDialog();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean r1) {
        this.mCancelable = r1;
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.setCancelable(r1);
        return;
    }

    public void setShowsDialog(boolean r1) {
        this.mShowsDialog = r1;
    }

    public void setStyle(int r4, int r5) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.d(FragmentManager.TAG, "Setting style and theme for DialogFragment " + this + " to " + r4 + ", " + r5);
    L5:
        this.mStyle = r4;
        if (r4 != 2) goto L8;
    L9:
        this.mTheme = R.style.Theme.Panel;
    L10:
        if (r5 == 0) goto L13;
        this.mTheme = r5;
        return;
    L13:
        return;
    L8:
        if (r4 != 3) goto L10;
        goto L9
    }

    public void setupDialog(Dialog r2, int r3) {
        if (r3 != 1) goto L5;
    L12:
        r2.requestWindowFeature(1);
        return;
    L5:
        if (r3 == 2) goto L12;
        if (r3 != 3) goto L14;
        Window r4 = r2.getWindow();
        if (r4 == null) goto L12;
        r4.addFlags(24);
        goto L12
    }

    public int show(FragmentTransaction r3, String r4) {
        this.mDismissed = false;
        this.mShownByMe = true;
        r3.add(this, r4);
        this.mViewDestroyed = false;
        int r5 = r3.commit();
        this.mBackStackId = r5;
        return r5;
    }

    public void show(FragmentManager r2, String r3) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r4 = r2.beginTransaction();
        r4.setReorderingAllowed(true);
        r4.add(this, r3);
        r4.commit();
    }

    public void showNow(FragmentManager r2, String r3) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r4 = r2.beginTransaction();
        r4.setReorderingAllowed(true);
        r4.add(this, r3);
        r4.commitNow();
    }
}
