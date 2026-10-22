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
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

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

    @Nullable
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

    public static /* synthetic */ Dialog access$000(DialogFragment r5) {
        return r5.mDialog;
    }

    public static /* synthetic */ DialogInterface.OnDismissListener access$100(DialogFragment r5) {
        return r5.mOnDismissListener;
    }

    public static /* synthetic */ boolean access$200(DialogFragment r5) {
        return r5.mShowsDialog;
    }

    private void dismissInternal(boolean r5, boolean r10, boolean r11) {
        if (this.mDismissed == false) goto L5;
        return;
    L5:
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog r12 = this.mDialog;
        if (r12 == null) goto L13;
        r12.setOnDismissListener(null);
        this.mDialog.dismiss();
        if (r10 == true) goto L13;
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L12;
        onDismiss(this.mDialog);
        goto L13
    L12:
        this.mHandler.post(this.mDismissRunnable);
    L13:
        this.mViewDestroyed = true;
        if (this.mBackStackId < 0) goto L19;
        if (r11 == false) goto L17;
        getParentFragmentManager().popBackStackImmediate(this.mBackStackId, 1);
    L18:
        this.mBackStackId = -1;
        return;
    L17:
        getParentFragmentManager().popBackStack(this.mBackStackId, 1, r5);
        goto L18
    L19:
        FragmentTransaction r13 = getParentFragmentManager().beginTransaction();
        r13.setReorderingAllowed(true);
        r13.remove(this);
        if (r11 == false) goto L22;
        r13.commitNow();
        return;
    L22:
        if (r5 == false) goto L24;
        r13.commitAllowingStateLoss();
        return;
    L24:
        r13.commit();
    }

    private void prepareDialog(@Nullable Bundle r5) {
        if (this.mShowsDialog == true) goto L6;
        return;
    L6:
        if (this.mDialogCreated == false) goto L21;
        return;
    L21:
        this.mCreatingDialog = true;     // Catch: Throwable -> L13
        Dialog r10 = onCreateDialog(r5);     // Catch: Throwable -> L13
        this.mDialog = r10;     // Catch: Throwable -> L13
        if (this.mShowsDialog == false) goto L16;
        setupDialog(r10, this.mStyle);     // Catch: Throwable -> L13
        Context r11 = getContext();     // Catch: Throwable -> L13
        if ((r11 instanceof Activity) == false) goto L15;
        this.mDialog.setOwnerActivity((Activity) r11);     // Catch: Throwable -> L13
    L15:
        this.mDialog.setCancelable(this.mCancelable);     // Catch: Throwable -> L13
        this.mDialog.setOnCancelListener(this.mOnCancelListener);     // Catch: Throwable -> L13
        this.mDialog.setOnDismissListener(this.mOnDismissListener);     // Catch: Throwable -> L13
        this.mDialogCreated = true;     // Catch: Throwable -> L13
    L17:
        this.mCreatingDialog = false;
        return;
    L16:
        this.mDialog = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.mCreatingDialog = false;
        throw th;
    }

    public void close() {
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public FragmentContainer createFragmentContainer() {
        final FragmentContainer r5 = super.createFragmentContainer();
        return new AnonymousClass5(this, r5);
    }

    public void dismiss() {
        dismissInternal(false, false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false, false);
    }

    @MainThread
    public void dismissNow() {
        dismissInternal(false, false, true);
    }

    @Nullable
    public Dialog getDialog() {
        return this.mDialog;
    }

    public boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    @StyleRes
    public int getTheme() {
        return this.mTheme;
    }

    public boolean isCancelable() {
        return this.mCancelable;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    @Deprecated
    public void onActivityCreated(@Nullable Bundle r5) {
        super.onActivityCreated(r5);
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onAttach(@NonNull Context r5) {
        super.onAttach(r5);
        getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (this.mShownByMe == true) goto L6;
        this.mDismissed = false;
        return;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface r5) {
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onCreate(@Nullable Bundle r5) {
        super.onCreate(r5);
        this.mHandler = new Handler();
        if (this.mContainerId != 0) goto L5;
        boolean r10 = true;
    L6:
        this.mShowsDialog = r10;
        if (r5 == null) goto L10;
        this.mStyle = r5.getInt(SAVED_STYLE, 0);
        this.mTheme = r5.getInt(SAVED_THEME, 0);
        this.mCancelable = r5.getBoolean(SAVED_CANCELABLE, true);
        this.mShowsDialog = r5.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
        this.mBackStackId = r5.getInt(SAVED_BACK_STACK_ID, -1);
        return;
    L10:
        return;
    L5:
        r10 = false;
        goto L6
    }

    @NonNull
    @MainThread
    public Dialog onCreateDialog(@Nullable Bundle r5) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d(FragmentManager.TAG, "onCreateDialog called for DialogFragment " + this);
    L6:
        return new ComponentDialog(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onDestroyView() {
        super.onDestroyView();
        Dialog r5 = this.mDialog;
        if (r5 == null) goto L9;
        this.mViewDestroyed = true;
        r5.setOnDismissListener(null);
        this.mDialog.dismiss();
        if (this.mDismissed == true) goto L7;
        onDismiss(this.mDialog);
    L7:
        this.mDialog = null;
        this.mDialogCreated = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
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
    @CallSuper
    public void onDismiss(@NonNull DialogInterface r5) {
        if (this.mViewDestroyed == false) goto L5;
        return;
    L5:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L7;
        Log.d(FragmentManager.TAG, "onDismiss called for DialogFragment " + this);
    L7:
        dismissInternal(true, true, false);
    }

    @Nullable
    public View onFindViewById(int r5) {
        Dialog r10 = this.mDialog;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.findViewById(r5);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle r5) {
        LayoutInflater r10 = super.onGetLayoutInflater(r5);
        if (this.mShowsDialog == false) goto L15;
        if (this.mCreatingDialog == true) goto L15;
        prepareDialog(r5);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L10;
        Log.d(FragmentManager.TAG, "get layout inflater for DialogFragment " + this + " from dialog context");
    L10:
        Dialog r11 = this.mDialog;
        if (r11 != null) goto L13;
        return r10;
    L13:
        return r10.cloneInContext(r11.getContext());
    L15:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L20;
        String r12 = "getting layout inflater for DialogFragment " + this;
        if (this.mShowsDialog == true) goto L19;
        androidx.constraintlayout.motion.widget.a.A("mShowsDialog = false: ", r12, FragmentManager.TAG);
        goto L20
    L19:
        androidx.constraintlayout.motion.widget.a.A("mCreatingDialog = true: ", r12, FragmentManager.TAG);
    L20:
        return r10;
    }

    public boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onSaveInstanceState(@NonNull Bundle r5) {
        super.onSaveInstanceState(r5);
        Dialog r10 = this.mDialog;
        if (r10 == null) goto L5;
        Bundle r11 = r10.onSaveInstanceState();
        r11.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
        r5.putBundle(SAVED_DIALOG_STATE_TAG, r11);
    L5:
        int r12 = this.mStyle;
        if (r12 == 0) goto L8;
        r5.putInt(SAVED_STYLE, r12);
    L8:
        int r13 = this.mTheme;
        if (r13 == 0) goto L11;
        r5.putInt(SAVED_THEME, r13);
    L11:
        boolean r14 = this.mCancelable;
        if (r14 == true) goto L14;
        r5.putBoolean(SAVED_CANCELABLE, r14);
    L14:
        boolean r15 = this.mShowsDialog;
        if (r15 == true) goto L17;
        r5.putBoolean(SAVED_SHOWS_DIALOG, r15);
    L17:
        int r16 = this.mBackStackId;
        if (r16 == (-1)) goto L21;
        r5.putInt(SAVED_BACK_STACK_ID, r16);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStart() {
        super.onStart();
        Dialog r5 = this.mDialog;
        if (r5 == null) goto L6;
        this.mViewDestroyed = false;
        r5.show();
        View r10 = this.mDialog.getWindow().getDecorView();
        ViewTreeLifecycleOwner.set(r10, this);
        ViewTreeViewModelStoreOwner.set(r10, this);
        ViewTreeSavedStateRegistryOwner.set(r10, this);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStop() {
        super.onStop();
        Dialog r5 = this.mDialog;
        if (r5 == null) goto L6;
        r5.hide();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onViewStateRestored(@Nullable Bundle r5) {
        super.onViewStateRestored(r5);
        if (this.mDialog == null) goto L9;
        if (r5 == null) goto L10;
        Bundle r10 = r5.getBundle(SAVED_DIALOG_STATE_TAG);
        if (r10 == null) goto L11;
        this.mDialog.onRestoreInstanceState(r10);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void performCreateView(@NonNull LayoutInflater r5, @Nullable ViewGroup r10, @Nullable Bundle r11) {
        super.performCreateView(r5, r10, r11);
        if (this.mView == null) goto L5;
        return;
    L5:
        if (this.mDialog == null) goto L12;
        if (r11 == null) goto L13;
        Bundle r12 = r11.getBundle(SAVED_DIALOG_STATE_TAG);
        if (r12 == null) goto L14;
        this.mDialog.onRestoreInstanceState(r12);
        return;
    L14:
        return;
    L13:
        return;
    }

    @NonNull
    public final ComponentDialog requireComponentDialog() {
        Dialog r5 = requireDialog();
        if ((r5 instanceof ComponentDialog) == false) goto L7;
        return (ComponentDialog) r5;
    L7:
        throw new IllegalStateException("DialogFragment " + this + " did not return a ComponentDialog instance from requireDialog(). The actual Dialog is " + r5);
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog r5 = getDialog();
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean r5) {
        this.mCancelable = r5;
        Dialog r10 = this.mDialog;
        if (r10 == null) goto L6;
        r10.setCancelable(r5);
        return;
    }

    public void setShowsDialog(boolean r5) {
        this.mShowsDialog = r5;
    }

    public void setStyle(int r5, @StyleRes int r10) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.d(FragmentManager.TAG, "Setting style and theme for DialogFragment " + this + " to " + r5 + ", " + r10);
    L5:
        this.mStyle = r5;
        if (r5 != 2) goto L8;
    L9:
        this.mTheme = R.style.Theme.Panel;
    L10:
        if (r10 == 0) goto L13;
        this.mTheme = r10;
        return;
    L13:
        return;
    L8:
        if (r5 != 3) goto L10;
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog r5, int r10) {
        if (r10 != 1) goto L5;
    L12:
        r5.requestWindowFeature(1);
        return;
    L5:
        if (r10 == 2) goto L12;
        if (r10 != 3) goto L14;
        Window r11 = r5.getWindow();
        if (r11 == null) goto L12;
        r11.addFlags(24);
        goto L12
    }

    public void show(@NonNull FragmentManager r5, @Nullable String r10) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r11 = r5.beginTransaction();
        r11.setReorderingAllowed(true);
        r11.add(this, r10);
        r11.commit();
    }

    public void showNow(@NonNull FragmentManager r5, @Nullable String r10) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r11 = r5.beginTransaction();
        r11.setReorderingAllowed(true);
        r11.add(this, r10);
        r11.commitNow();
    }

    public int show(@NonNull FragmentTransaction r5, @Nullable String r10) {
        this.mDismissed = false;
        this.mShownByMe = true;
        r5.add(this, r10);
        this.mViewDestroyed = false;
        int r11 = r5.commit();
        this.mBackStackId = r11;
        return r11;
    }

    public DialogFragment(@LayoutRes int r5) {
        super(r5);
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
}
