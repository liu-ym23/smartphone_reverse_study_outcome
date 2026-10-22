package com.ss.android.lark.officewebview.webview_api.adapter;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import com.ss.android.lark.officewebview.webview_api.bridge.Status;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import xwb.f;
import xwb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements qxb.b {
    public final OfficeWebView a;
    public final xwb.a b;

    /* JADX INFO: renamed from: com.ss.android.lark.officewebview.webview_api.adapter.a$a, reason: collision with other inner class name */
    public static final class C0082a implements qxb.c {
        public final j a;

        public C0082a(xwb.d r2) {
            Intrinsics.checkNotNullParameter(r2, "officeCb");
            this.a = r2;
        }

        @Override // qxb.c
        public final void a(Status r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "status");
            j r0 = this.a;
            int r5 = com.ss.android.lark.officewebview.webview_api.adapter.b.a[r3.ordinal()];
            if (r5 != 1) goto L5;
            com.ss.android.lark.officewebview.bridge.Status r6 = com.ss.android.lark.officewebview.bridge.Status.SUCCESS;
        L19:
            r0.a(r6, r4);
            return;
        L5:
            if (r5 != 2) goto L7;
            r6 = com.ss.android.lark.officewebview.bridge.Status.FAILURE;
            goto L19
        L7:
            if (r5 != 3) goto L9;
            r6 = com.ss.android.lark.officewebview.bridge.Status.CANCEL;
            goto L19
        L9:
            if (r5 != 4) goto L11;
            r6 = com.ss.android.lark.officewebview.bridge.Status.TIMEOUT;
            goto L19
        L11:
            if (r5 != 5) goto L14;
            r6 = com.ss.android.lark.officewebview.bridge.Status.PROGRESS;
            goto L19
        L14:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b implements f<String, OfficeWebView> {
        public final /* synthetic */ a a;
        public final /* synthetic */ qxb.a<String, pxb.a> b;

        @Override // xwb.f
        public final boolean shouldRunInUIThread() {
            this.b.shouldRunInUIThread();
            return true;
        }

        @Override // xwb.f
        public final BridgeAuthType authType() {
            return BridgeAuthType.Public;
        }

        public b(a r1, qxb.a<String, pxb.a> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // xwb.f
        public final void a(Object r1, xwb.d r2, String r3, OfficeWebView r4) {
            String r5 = (String) r1;
            Intrinsics.checkNotNullParameter(r2, "callback");
            C0082a r6 = new C0082a(r2);
            if (r4 != null) goto L5;
            r4 = this.a.a;
        L5:
            OfficeWebViewAdapter r7 = new OfficeWebViewAdapter(r4);
            this.b.a(r5, r6, r7);
        }
    }

    public a(OfficeWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "officeWebView");
        this.a = r2;
        this.b = r2.getBridge();
    }

    @Override // qxb.b
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "handlerName");
        this.b.c(r2);
    }

    @Override // qxb.b
    public final void a(String r3, qxb.a<String, pxb.a> r4) {
        Intrinsics.checkNotNullParameter(r3, "handlerName");
        Intrinsics.checkNotNullParameter(r4, "handler");
        this.b.b(r3, new b(this, r4));
    }
}
