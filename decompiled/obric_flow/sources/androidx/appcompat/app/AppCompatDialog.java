package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialog extends ComponentDialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.Component mKeyDispatcher;

    public AppCompatDialog(@NonNull Context r5) {
        this(r5, 0);
    }

    private static int getThemeResId(Context r5, int r10) {
        if (r10 != 0) goto L5;
        TypedValue r11 = new TypedValue();
        r5.getTheme().resolveAttribute(R.attr.dialogTheme, r11, true);
        return r11.resourceId;
    L5:
        return r10;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void addContentView(@NonNull View r5, ViewGroup.LayoutParams r10) {
        getDelegate().addContentView(r5, r10);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().onDestroy();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r5) {
        View r10 = getWindow().getDecorView();
        return KeyEventDispatcher.dispatchKeyEvent(this.mKeyDispatcher, r10, this, r5);
    }

    @Override // android.app.Dialog
    @Nullable
    public <T extends View> T findViewById(@IdRes int r5) {
        return (T) getDelegate().findViewById(r5);
    }

    @NonNull
    public AppCompatDelegate getDelegate() {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = AppCompatDelegate.create(this, this);
    L6:
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @Override // android.app.Dialog
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r5) {
        getDelegate().installViewFactory();
        super.onCreate(r5);
        getDelegate().onCreate(r5);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode r5) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode r5) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    @Nullable
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r5) {
        return null;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@LayoutRes int r5) {
        getDelegate().setContentView(r5);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r5) {
        super.setTitle(r5);
        getDelegate().setTitle(r5);
    }

    public boolean superDispatchKeyEvent(KeyEvent r5) {
        return super.dispatchKeyEvent(r5);
    }

    public boolean supportRequestWindowFeature(int r5) {
        return getDelegate().requestWindowFeature(r5);
    }

    public AppCompatDialog(@NonNull Context r5, int r10) {
        super(r5, getThemeResId(r5, r10));
        this.mKeyDispatcher = new c(this);
        AppCompatDelegate r11 = getDelegate();
        r11.setTheme(getThemeResId(r5, r10));
        r11.onCreate(null);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@NonNull View r5) {
        getDelegate().setContentView(r5);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(@NonNull View r5, ViewGroup.LayoutParams r10) {
        getDelegate().setContentView(r5, r10);
    }

    @Override // android.app.Dialog
    public void setTitle(int r5) {
        super.setTitle(r5);
        getDelegate().setTitle(getContext().getString(r5));
    }

    public AppCompatDialog(@NonNull Context r5, boolean r10, @Nullable DialogInterface.OnCancelListener r11) {
        super(r5);
        this.mKeyDispatcher = new c(this);
        setCancelable(r10);
        setOnCancelListener(r11);
    }
}
