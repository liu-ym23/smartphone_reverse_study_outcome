package fc;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewParent;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f7372a;

    public b(a r8, Looper r10) {
        this.f7372a = r8;
        super(r10);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r8) {
        i.f(r8, "msg");
        super.handleMessage(r8);
        if (r8.what != 101) goto L28;
        a r10 = this.f7372a;
        String r11 = r10.f7358a;
        Object r12 = null;
        View r13 = r10.f7362o;
        if (r13 != null) goto L7;
        i.j("rootView");     // Catch: Exception -> L21
        throw null;     // Catch: Exception -> L21
    L7:
        if (ad.a.a(r13) <= 0) goto L9;
        return;
    L9:
        if (r10.f7367t == false) goto L30;
        ViewParent r14 = r13.getParent();     // Catch: Exception -> L21
        if (r14 != null) goto L14;
    L16:
        View r15 = (View) r12;     // Catch: Exception -> L21
        if (r15 != null) goto L19;
        return;
    L19:
        if (r15.getHeight() <= r13.getHeight()) goto L32;
        r13.requestLayout();     // Catch: Exception -> L21
        zc.b.g(r11, "recheckInset, requestLayout, parentView.height: " + r15.getHeight() + ", rootView.height: " + r13.getHeight());     // Catch: Exception -> L21
        return;
    L32:
        return;
    L14:
        if ((r14 instanceof View) == false) goto L16;
        r12 = r14;
        goto L16
    L30:
        return;
    L21:
        e = move-exception;
        zc.b.c(r11, "recheckInset failed", e);
        return;
    }
}
