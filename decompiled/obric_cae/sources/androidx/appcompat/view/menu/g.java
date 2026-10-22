package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public final class g implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.appcompat.app.d f841b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f842m;

    public g(f r8) {
        this.f840a = r8;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public final void a(f r8, boolean r10) {
        if (r10 == false) goto L4;
    L5:
        androidx.appcompat.app.d r11 = this.f841b;
        if (r11 == null) goto L10;
        r11.dismiss();
        return;
    L10:
        return;
    L4:
        if (r8 == this.f840a) goto L5;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public final boolean b(f r8) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r8, int r10) {
        h r11 = (h) this.f842m.i().getItem(r10);
        this.f840a.r(0, r11);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r8) {
        this.f842m.a(this.f840a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r8, int r10, KeyEvent r11) {
        f r12 = this.f840a;
        if (r10 == 82) goto L7;
        if (r10 == 4) goto L7;
    L33:
        return r12.performShortcut(r10, r11, 0);
    L7:
        if (r11.getAction() != 0) goto L19;
        if (r11.getRepeatCount() != 0) goto L19;
        Window r13 = this.f841b.getWindow();
        if (r13 == null) goto L33;
        View r14 = r13.getDecorView();
        if (r14 == null) goto L33;
        KeyEvent.DispatcherState r15 = r14.getKeyDispatcherState();
        if (r15 == null) goto L33;
        r15.startTracking(r11, this);
        return true;
    L19:
        if (r11.getAction() != 1) goto L33;
        if (r11.isCanceled() == true) goto L33;
        Window r16 = this.f841b.getWindow();
        if (r16 == null) goto L33;
        View r17 = r16.getDecorView();
        if (r17 == null) goto L33;
        KeyEvent.DispatcherState r18 = r17.getKeyDispatcherState();
        if (r18 == null) goto L33;
        if (r18.isTracking(r11) == false) goto L33;
        r12.d(true);
        r8.dismiss();
        return true;
    }
}
