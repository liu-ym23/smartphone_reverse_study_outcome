package com.bytedance.android.ec.common.impl.sku.utils;

import android.view.Choreographer;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.bytedance.android.ec.model.sku.OrderComponent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ SkuViewModel a;
        public final /* synthetic */ QContext b;

        public a(SkuViewModel r1, QContext r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = p.a;     // Catch: Throwable -> L4
            p.a(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ SkuViewModel a;
        public final /* synthetic */ QContext b;

        public b(SkuViewModel r1, QContext r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = p.a;     // Catch: Throwable -> L4
            p.a(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static String c(SkuViewModel r10) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        SkuInfoVO r0 = (SkuInfoVO) r10.getSkuInfo().a();
        if (r0 == null) goto L8;
        OrderComponent r1 = r0.getOrderComponent();
        if (r1 == null) goto L8;
        String r11 = r1.getOrderUrl();
        if (r11 == null) goto L8;
    L11:
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (StringsKt.contains$default(r11, "webcast_webview", false, 2, null) == true) goto L14;
        return null;
    L14:
        return r11;
    L8:
        r11 = r10.getSkuParams().getH5Url();
        if (r11 != null) goto L11;
        r11 = "";
        goto L11
    }

    public static void a(SkuViewModel r10, QContext r11) {
        String r0 = c(r10);     // Catch: Throwable -> L15
        if (r0 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L11;
        return;
    L11:
        boolean r13 = ECServiceManager.a;     // Catch: Throwable -> L15
        pd.e r14 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();     // Catch: Throwable -> L15
        String r15 = b(r0, r10.getSkuParams().isLiveSkuCheck(), 1);     // Catch: Throwable -> L15
        if (r14 == null) goto L20;
        r14.prerenderAnnieWithSchema(r11.c(), r15, "webcast", Integer.valueOf(FontWeight.WEIGHT_600), "onidle", null);     // Catch: Throwable -> L15
        return;
    L20:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r12 = false;
    L15:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
    }

    public static void d(SkuViewModel r10, QContext r11) {
        Intrinsics.checkNotNullParameter(r10, "viewModel");
        Intrinsics.checkNotNullParameter(r11, "qContext");
        String r0 = UriProtector.getQueryParameter(UriProtector.parse(c(r10)), "prerender_type");     // Catch: Throwable -> L5
    L7:
        if (r0 != null) goto L10;
        return;
    L10:
        switch(r0.hashCode()) {
            case 49: goto L19;
            case 50: goto L16;
            case 51: goto L13;
            default: goto L30;
        };
    L30:
        return;
    L13:
        if (r0.equals(com.bytedance.android.ec.core.event.a.VALUE_ENTER_THIRD_PART) == false) goto L24;
        r10.registerSkuNextChangeCallback(new b(r10, r11));
        return;
    L24:
        return;
    L16:
        if (r0.equals("2") == false) goto L26;
        f r1 = new f(new a(r10, r11));
        Intrinsics.checkNotNullParameter(r1, "runner");
        Choreographer.getInstance().postFrameCallback(new o(r1));
        return;
    L26:
        return;
    L19:
        if (r0.equals("1") == false) goto L28;
        a(r10, r11);
        return;
    L28:
        return;
    L5:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        r0 = "0";
        goto L7
    }

    public static String b(String r1, boolean r10, int r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r10 == false) goto L5;
        String r12 = "buy_now_yata_pre_render_live";
    L7:
        return jg.e.b(jg.e.b(r1, "prerender_cache_key", r12), "is_pre_render", String.valueOf(r11));
    L5:
        r12 = "buy_now_yata_pre_render_pdp";
        goto L7
    }
}
