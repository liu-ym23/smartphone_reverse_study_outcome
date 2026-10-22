package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public class o extends androidx.activity.l implements f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AppCompatDelegateImpl f663n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final n f664o;

    public o(Context r8, int r10) {
        if (r10 != 0) goto L5;
        TypedValue r11 = new TypedValue();
        r8.getTheme().resolveAttribute(R.attr.dialogTheme, r11, true);
        int r12 = r11.resourceId;
    L6:
        super(r8, r12);
        this.f664o = new n((d) this);
        h r13 = b();
        if (r10 != 0) goto L9;
        TypedValue r14 = new TypedValue();
        r8.getTheme().resolveAttribute(R.attr.dialogTheme, r14, true);
        r10 = r14.resourceId;
    L9:
        ((AppCompatDelegateImpl) r13).f580e0 = r10;
        r13.o();
        return;
    L5:
        r12 = r10;
        goto L6
    }

    @Override // android.app.Dialog
    public final void addContentView(View r8, ViewGroup.LayoutParams r10) {
        b().c(r8, r10);
    }

    public final h b() {
        if (this.f663n != null) goto L6;
        s.a r8 = h.f648a;
        this.f663n = new AppCompatDelegateImpl(getContext(), getWindow(), this, this);
    L6:
        return this.f663n;
    }

    public final boolean c(KeyEvent r8) {
        return super.dispatchKeyEvent(r8);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        b().p();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r8) {
        getWindow().getDecorView();
        n r10 = this.f664o;
        if (r10 != null) goto L6;
        return false;
    L6:
        return r10.superDispatchKeyEvent(r8);
    }

    @Override // android.app.Dialog
    public final <T extends View> T findViewById(int r8) {
        return (T) b().e(r8);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        b().l();
    }

    @Override // androidx.activity.l, android.app.Dialog
    public void onCreate(Bundle r8) {
        b().k();
        super.onCreate(r8);
        b().o();
    }

    @Override // androidx.activity.l, android.app.Dialog
    public final void onStop() {
        super.onStop();
        b().u();
    }

    @Override // androidx.appcompat.app.f
    public final void onSupportActionModeFinished(g.b r8) {
    }

    @Override // androidx.appcompat.app.f
    public final void onSupportActionModeStarted(g.b r8) {
    }

    @Override // androidx.appcompat.app.f
    public final g.b onWindowStartingSupportActionMode(g.b.a r8) {
        return null;
    }

    @Override // android.app.Dialog
    public final void setContentView(int r8) {
        b().x(r8);
    }

    @Override // android.app.Dialog
    public final void setTitle(int r8) {
        super.setTitle(r8);
        b().C(getContext().getString(r8));
    }

    @Override // android.app.Dialog
    public final void setContentView(View r8) {
        b().y(r8);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r8) {
        super.setTitle(r8);
        b().C(r8);
    }

    @Override // android.app.Dialog
    public final void setContentView(View r8, ViewGroup.LayoutParams r10) {
        b().z(r8, r10);
    }
}
