package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.config.na0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public ih0.c a;
    public final Context b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;
    public final String g;
    public final d h;

    public static final class a {
    }

    public static final class b extends b7.a {
        public final /* synthetic */ h a;
        public final /* synthetic */ Uri b;
        public final /* synthetic */ long c;

        public final void onRelease() {
            super.onRelease();
            ALogger.i("MultiLinkDynamicWidget", "HybridCard onRelease, url:" + this.a.d);
            d r0 = this.a.h;
            if (r0 == null) goto L5;
            r0.onRelease();
        L5:
            int r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
            String r2 = this.b.toString();
            h r3 = this.a;
            com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.e(r2, r3.g, r3.f, System.currentTimeMillis() - this.c);
        }

        public final void onLoadSuccess(View r7) {
            super.onLoadSuccess(r7);
            ALogger.i("MultiLinkDynamicWidget", "HybridCard load success:" + this.a.d);
            d r8 = this.a.h;
            if (r8 == null) goto L5;
            r8.onSuccess();
        L5:
            int r9 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
            String r10 = this.b.toString();
            h r0 = this.a;
            com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.d(r10, r0.g, r0.f, System.currentTimeMillis() - this.c);
        }

        public final void onInnerFallback(int r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "errorMessage");
            super.onInnerFallback(r10, r11);
            ALogger.e("MultiLinkDynamicWidget", "HybridCard onInnerFallback errorMessage=" + r11 + ", url:" + this.a.d);
            d r0 = this.a.h;
            if (r0 == null) goto L5;
            r0.a(r11);
        L5:
            int r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
            String r2 = this.b.toString();
            h r3 = this.a;
            com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.a("card_inner_error", r2, r3.g, r3.f, r10, r11, System.currentTimeMillis() - this.c);
        }

        public b(h r1, Uri r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onLoadFail(View r7, String r8, String r9) {
            super.onLoadFail(r7, r8, r9);
            ALogger.e("MultiLinkDynamicWidget", "HybridCard load fail reason=" + r9 + ", url:" + this.a.d);
            d r10 = this.a.h;
            if (r10 == null) goto L5;
            r10.onFail();
        L5:
            int r11 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
            String r0 = this.b.toString();
            h r12 = this.a;
            com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b(r0, r12.g, r12.f, System.currentTimeMillis() - this.c, r9);
        }
    }

    static {
    }

    public final void b() {
        ALogger.i("MultiLinkDynamicWidget", "MultiLinkHybridCardManager onDestroy");
        ih0.c r0 = this.a;
        if (r0 == null) goto L18;
        if (r0 == null) goto L6;
        r0.release();
    L6:
        ih0.c r1 = this.a;
        if (r1 == null) goto L19;
        View r2 = r1.S0();
        if (r2 == null) goto L20;
        ViewGroup r3 = UtilityKotlinExtentionsKt.p(r2);
        if (r3 == null) goto L21;
        ih0.c r4 = this.a;
        if (r4 == null) goto L15;
        View r5 = r4.S0();
    L16:
        r3.removeView(r5);
        return;
    L15:
        r5 = null;
        goto L16
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    public final ih0.c a(DataCenter r11) {
        ih0.c r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r1 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.c.a;
        String r2 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.c.a(this.d, 0, 6);
        if (this.e == false) goto L8;
        Uri r3 = UriProtector.parse(this.c);
    L9:
        Uri r4 = r3;
        long r5 = System.currentTimeMillis();
        int r6 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.b;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.u.c(r4.toString(), this.g, this.f);
        ALogger.i("MultiLinkDynamicWidget", "lynx url: " + r2);
        b r7 = new b(this, r4, r5);
        long r8 = System.currentTimeMillis();
        if (((Boolean) na0.a.getValue()).booleanValue() == false) goto L12;
        int r9 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.a;
        ih0.c r12 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q.b(this.b, r4, r7, r8, r11, 32);
    L13:
        this.a = r12;
        ih0.c.a.a(r12, null, null, 7);
        ALogger.i("MultiLinkDynamicWidget", "create HybridCard, lynx url: " + r2);
        return this.a;
    L12:
        r12 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.b(jc1.k.n(IBaseBrowserService.class).getHybridCard(this.b, r4, r7));
        goto L13
    L8:
        r3 = x6.a.d(r2);
        goto L9
    }

    public h(Context r3, String r4, String r5, boolean r6, String r7, d r8) {
        Intrinsics.checkNotNullParameter(r3, "mContext");
        Intrinsics.checkNotNullParameter(r4, "lynxSchema");
        Intrinsics.checkNotNullParameter(r5, "lynxUrl");
        Intrinsics.checkNotNullParameter(r7, "mBizId");
        Intrinsics.checkNotNullParameter("layer_element", "mCardType");
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = "layer_element";
        this.h = r8;
        a(null);
    }
}
