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

    public DialogFragment(@LayoutRes int r10) {
        super(r10);
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

    static /* synthetic */ Dialog access$000(DialogFragment r10) {
        return r10.mDialog;
    }

    static /* synthetic */ DialogInterface.OnDismissListener access$100(DialogFragment r10) {
        return r10.mOnDismissListener;
    }

    static /* synthetic */ boolean access$200(DialogFragment r10) {
        return r10.mShowsDialog;
    }

    private void dismissInternal(boolean r10, boolean r11) {
        if (this.mDismissed == false) goto L5;
        return;
    L5:
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog r12 = this.mDialog;
        if (r12 == null) goto L13;
        r12.setOnDismissListener(null);
        this.mDialog.dismiss();
        if (r11 == true) goto L13;
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L12;
        onDismiss(this.mDialog);
        goto L13
    L12:
        this.mHandler.post(this.mDismissRunnable);
    L13:
        this.mViewDestroyed = true;
        if (this.mBackStackId < 0) goto L16;
        getParentFragmentManager().popBackStack(this.mBackStackId, 1);
        this.mBackStackId = -1;
        return;
    L16:
        FragmentTransaction r13 = getParentFragmentManager().beginTransaction();
        r13.remove(this);
        if (r10 == false) goto L19;
        r13.commitAllowingStateLoss();
        return;
    L19:
        r13.commit();
    }

    private void prepareDialog(@Nullable Bundle r10) {
        if (this.mShowsDialog == true) goto L6;
        return;
    L6:
        if (this.mDialogCreated == false) goto L20;
        return;
    L20:
        this.mCreatingDialog = true;     // Catch: Throwable -> L16
        Dialog r11 = onCreateDialog(r10);     // Catch: Throwable -> L16
        this.mDialog = r11;     // Catch: Throwable -> L16
        if (this.mShowsDialog == false) goto L14;
        setupDialog(r11, this.mStyle);     // Catch: Throwable -> L16
        Context r12 = getContext();     // Catch: Throwable -> L16
        if ((r12 instanceof Activity) == false) goto L13;
        this.mDialog.setOwnerActivity((Activity) r12);     // Catch: Throwable -> L16
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
    @NonNull
    FragmentContainer createFragmentContainer() {
        final FragmentContainer r10 = super.createFragmentContainer();
        return new AnonymousClass5(this, r10);
    }

    public void dismiss() {
        dismissInternal(false, false);
    }

    public void dismissAllowingStateLoss() {
        dismissInternal(true, false);
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
    public void onAttach(@NonNull Context r10) {
        super.onAttach(r10);
        getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (this.mShownByMe == true) goto L6;
        this.mDismissed = false;
        return;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@NonNull DialogInterface r10) {
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        this.mHandler = new Handler();
        if (this.mContainerId != 0) goto L5;
        boolean r11 = true;
    L6:
        this.mShowsDialog = r11;
        if (r10 == null) goto L10;
        this.mStyle = r10.getInt(SAVED_STYLE, 0);
        this.mTheme = r10.getInt(SAVED_THEME, 0);
        this.mCancelable = r10.getBoolean(SAVED_CANCELABLE, true);
        this.mShowsDialog = r10.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
        this.mBackStackId = r10.getInt(SAVED_BACK_STACK_ID, -1);
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @NonNull
    @MainThread
    public Dialog onCreateDialog(@Nullable Bundle r10) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
    L6:
        return new Dialog(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onDestroyView() {
        super.onDestroyView();
        Dialog r10 = this.mDialog;
        if (r10 == null) goto L9;
        this.mViewDestroyed = true;
        r10.setOnDismissListener(null);
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
    public void onDismiss(@NonNull DialogInterface r10) {
        if (this.mViewDestroyed == false) goto L5;
        return;
    L5:
        if (FragmentManager.isLoggingEnabled(3) == false) goto L7;
        Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
    L7:
        dismissInternal(true, true);
    }

    @Nullable
    View onFindViewById(int r10) {
        Dialog r11 = this.mDialog;
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.findViewById(r10);
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle r10) {
        LayoutInflater r11 = super.onGetLayoutInflater(r10);
        if (this.mShowsDialog == false) goto L15;
        if (this.mCreatingDialog == true) goto L15;
        prepareDialog(r10);
        if (FragmentManager.isLoggingEnabled(2) == false) goto L10;
        Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
    L10:
        Dialog r12 = this.mDialog;
        if (r12 != null) goto L13;
        return r11;
    L13:
        return r11.cloneInContext(r12.getContext());
    L15:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L21;
        String r13 = "getting layout inflater for DialogFragment " + this;
        if (this.mShowsDialog == true) goto L19;
        StringBuilder r14 = new StringBuilder();
        String r15 = "mShowsDialog = false: ";
    L20:
        r14.append(r15);
        r14.append(r13);
        Log.d("FragmentManager", r14.toString());
        goto L21
    L19:
        r14 = new StringBuilder();
        r15 = "mCreatingDialog = true: ";
    L21:
        return r11;
    }

    boolean onHasView() {
        return this.mDialogCreated;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onSaveInstanceState(@NonNull Bundle r10) {
        super.onSaveInstanceState(r10);
        Dialog r11 = this.mDialog;
        if (r11 == null) goto L5;
        Bundle r12 = r11.onSaveInstanceState();
        r12.putBoolean(SAVED_INTERNAL_DIALOG_SHOWING, false);
        r10.putBundle(SAVED_DIALOG_STATE_TAG, r12);
    L5:
        int r13 = this.mStyle;
        if (r13 == 0) goto L8;
        r10.putInt(SAVED_STYLE, r13);
    L8:
        int r14 = this.mTheme;
        if (r14 == 0) goto L11;
        r10.putInt(SAVED_THEME, r14);
    L11:
        boolean r15 = this.mCancelable;
        if (r15 == true) goto L14;
        r10.putBoolean(SAVED_CANCELABLE, r15);
    L14:
        boolean r16 = this.mShowsDialog;
        if (r16 == true) goto L17;
        r10.putBoolean(SAVED_SHOWS_DIALOG, r16);
    L17:
        int r17 = this.mBackStackId;
        if (r17 == (-1)) goto L21;
        r10.putInt(SAVED_BACK_STACK_ID, r17);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStart() {
        super.onStart();
        Dialog r10 = this.mDialog;
        if (r10 == null) goto L6;
        this.mViewDestroyed = false;
        r10.show();
        View r11 = this.mDialog.getWindow().getDecorView();
        ViewTreeLifecycleOwner.set(r11, this);
        ViewTreeViewModelStoreOwner.set(r11, this);
        ViewTreeSavedStateRegistryOwner.set(r11, this);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onStop() {
        super.onStop();
        Dialog r10 = this.mDialog;
        if (r10 == null) goto L6;
        r10.hide();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    @MainThread
    public void onViewStateRestored(@Nullable Bundle r10) {
        super.onViewStateRestored(r10);
        if (this.mDialog == null) goto L9;
        if (r10 == null) goto L10;
        Bundle r11 = r10.getBundle(SAVED_DIALOG_STATE_TAG);
        if (r11 == null) goto L11;
        this.mDialog.onRestoreInstanceState(r11);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    void performCreateView(@NonNull LayoutInflater r10, @Nullable ViewGroup r11, @Nullable Bundle r12) {
        super.performCreateView(r10, r11, r12);
        if (this.mView == null) goto L5;
        return;
    L5:
        if (this.mDialog == null) goto L12;
        if (r12 == null) goto L13;
        Bundle r13 = r12.getBundle(SAVED_DIALOG_STATE_TAG);
        if (r13 == null) goto L14;
        this.mDialog.onRestoreInstanceState(r13);
        return;
    L14:
        return;
    L13:
        return;
    }

    @NonNull
    public final Dialog requireDialog() {
        Dialog r10 = getDialog();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void setCancelable(boolean r10) {
        this.mCancelable = r10;
        Dialog r11 = this.mDialog;
        if (r11 == null) goto L6;
        r11.setCancelable(r10);
        return;
    }

    public void setShowsDialog(boolean r10) {
        this.mShowsDialog = r10;
    }

    public void setStyle(int r10, @StyleRes int r11) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.d("FragmentManager", "Setting style and theme for DialogFragment " + this + " to " + r10 + ", " + r11);
    L5:
        this.mStyle = r10;
        if (r10 != 2) goto L8;
    L9:
        this.mTheme = R.style.Theme.Panel;
    L10:
        if (r11 == 0) goto L13;
        this.mTheme = r11;
        return;
    L13:
        return;
    L8:
        if (r10 != 3) goto L10;
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setupDialog(@NonNull Dialog r10, int r11) {
        if (r11 != 1) goto L5;
    L12:
        r10.requestWindowFeature(1);
        return;
    L5:
        if (r11 == 2) goto L12;
        if (r11 != 3) goto L14;
        Window r12 = r10.getWindow();
        if (r12 == null) goto L12;
        r12.addFlags(24);
        goto L12
    }

    public int show(@NonNull FragmentTransaction r10, @Nullable String r11) {
        this.mDismissed = false;
        this.mShownByMe = true;
        r10.add(this, r11);
        this.mViewDestroyed = false;
        int r12 = r10.commit();
        this.mBackStackId = r12;
        return r12;
    }

    public void show(@NonNull FragmentManager r10, @Nullable String r11) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r12 = r10.beginTransaction();
        r12.add(this, r11);
        r12.commit();
    }

    public void showNow(@NonNull FragmentManager r10, @Nullable String r11) {
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r12 = r10.beginTransaction();
        r12.add(this, r11);
        r12.commitNow();
    }
}
