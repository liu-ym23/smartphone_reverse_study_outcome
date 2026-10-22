package gxb;

import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import otb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements otb.c {
    public final String a;
    public final i b;
    public final exb.d c;
    public final ViewGroup d;
    public final exb.a e;
    public View f;
    public c g;

    public static final class a {
    }

    static {
    }

    @Override // otb.c
    public final void destroy() {
        this.e.getClass();
        exb.a.c("OverlayPlatformViewPlugin", "destroy");
        View r0 = this.f;
        if (r0 == null) goto L5;
        this.d.removeView(r0);
    L5:
        this.f = null;
        this.b.destroy();
        this.c.a(this.a);
    }

    @Override // otb.c
    public final i a() {
        return this.b;
    }

    @Override // otb.c
    public final String getViewId() {
        return this.a;
    }

    public e(String r2, i r3, exb.d r4, gxb.a r5) {
        Intrinsics.checkNotNullParameter(r2, "viewId");
        Intrinsics.checkNotNullParameter(r3, "platformViewFactory");
        Intrinsics.checkNotNullParameter(r4, "platformViewRegistry");
        Intrinsics.checkNotNullParameter(r5, "container");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r4.a;
    }
}
