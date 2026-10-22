package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialog extends ComponentDialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.Component mKeyDispatcher;

    public AppCompatDialog(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 0);
    }

    public AppCompatDialog(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r5, getThemeResId(r5, r4));
        this.mKeyDispatcher = new $$Lambda$gEImWHTHIXmQ0UWdr4025_K_nos(this);
        AppCompatDelegate r2 = getDelegate();
        r2.setTheme(getThemeResId(r5, r4));
        r2.onCreate(null);
    }

    public AppCompatDialog(Context r3, boolean r4, DialogInterface.OnCancelListener r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        DialogInterface.OnCancelListener r7 = (DialogInterface.OnCancelListener) ZeusTransformUtils.wrapperContextForParams(r5, DialogInterface.OnCancelListener.class, "com.obric.memorydata.plugin");
        super(r6);
        this.mKeyDispatcher = new $$Lambda$gEImWHTHIXmQ0UWdr4025_K_nos(this);
        setCancelable(r4);
        setOnCancelListener(r7);
    }

    private static int getThemeResId(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != 0) goto L6;
        TypedValue r6 = new TypedValue();
        r5.getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.dialogTheme, "attr", "dialogTheme"), r6, true);
        return r6.resourceId;
    L6:
        return r4;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void addContentView(View r1, ViewGroup.LayoutParams r2) {
        getDelegate().addContentView(r1, r2);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().onDestroy();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r3) {
        View r0 = getWindow().getDecorView();
        return KeyEventDispatcher.dispatchKeyEvent(this.mKeyDispatcher, r0, this, r3);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int r1) {
        return (T) getDelegate().findViewById(r1);
    }

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
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r2) {
        getDelegate().installViewFactory();
        super.onCreate(r2);
        getDelegate().onCreate(r2);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode r1) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode r1) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r2) {
        ActionMode.Callback r1 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r2, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        return null;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r1) {
        getDelegate().setContentView(r1);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r1) {
        getDelegate().setContentView(r1);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r1, ViewGroup.LayoutParams r2) {
        getDelegate().setContentView(r1, r2);
    }

    @Override // android.app.Dialog
    public void setTitle(int r4) {
        super.setTitle(r4);
        getDelegate().setTitle(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r4));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        super.setTitle(r4);
        getDelegate().setTitle(r4);
    }

    boolean superDispatchKeyEvent(KeyEvent r1) {
        return super.dispatchKeyEvent(r1);
    }

    public boolean supportRequestWindowFeature(int r1) {
        return getDelegate().requestWindowFeature(r1);
    }
}
