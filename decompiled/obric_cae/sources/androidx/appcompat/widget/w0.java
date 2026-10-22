package androidx.appcompat.widget;

import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public final class w0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h.a f1294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f1295b;

    public w0(x0 r8) {
        this.f1295b = r8;
        this.f1294a = new h.a(r8.f1299a.getContext(), r8.f1307i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        x0 r10 = this.f1295b;
        Window.Callback r11 = r10.f1310l;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10.f1311m == false) goto L9;
        r11.onMenuItemSelected(0, this.f1294a);
        return;
    }
}
