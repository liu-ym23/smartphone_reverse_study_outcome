package gxb;

import android.content.Context;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.service.listener.OnViewScrollListener;
import kotlin.jvm.internal.Intrinsics;
import oxb.h;
import oxb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements OnViewScrollListener {
    public final exb.b a;
    public final exb.a b;
    public final gxb.a c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.officewebview.service.listener.OnViewScrollListener
    public final void a() {
    }

    @Override // com.ss.android.lark.officewebview.service.listener.OnViewScrollListener
    public final void b() {
    }

    @Override // com.ss.android.lark.officewebview.service.listener.OnViewScrollListener
    public final void c(int r2, int r3) {
        gxb.a r0 = this.c;
        r0.a = r2;
        r0.b = r3;
        r0.requestLayout();
    }

    public d(Context r2, exb.b r3, OfficeWebView r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "manager");
        Intrinsics.checkNotNullParameter(r4, "webView");
        this.a = r3;
        this.b = r3.a;
        this.c = new gxb.a(r2);
        n r5 = r4.getServiceManager();
        if (r5 == null) goto L8;
        h r6 = (h) r5.a(h.class);
        if (r6 == null) goto L9;
        r6.K(this);
        return;
    L9:
        return;
    }
}
