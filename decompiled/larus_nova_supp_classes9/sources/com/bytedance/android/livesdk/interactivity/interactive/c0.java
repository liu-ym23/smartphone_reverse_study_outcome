package com.bytedance.android.livesdk.interactivity.interactive;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.depend.model.live.IBannerInfo;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 extends b7.a {
    public final /* synthetic */ o82.g a;
    public final /* synthetic */ Uri b;
    public final /* synthetic */ LiveInteractiveHelper c;
    public final /* synthetic */ IBannerInfo d;

    public final void onLoadSuccess(View r11) {
        super.onLoadSuccess(r11);
        o82.g r0 = this.a;
        this.b.toString();
        r0.getClass();
        System.currentTimeMillis();
        LiveInteractiveHelper r1 = this.c;
        IBannerInfo r2 = this.d;
        int r3 = LiveInteractiveHelper.r;
        r1.getClass();
        o82.h.b("[" + r1.hashCode() + "]on hybrid view page finished");
        if (r1.q.isVisible() == false) goto L16;
        if (r11 == null) goto L16;
        r11.setVisibility(0);
        if (r1.c == null) goto L16;
        if (((oq1.b) nq1.a.a.getValue()).a() == false) goto L15;
        km1.a r13 = r1.h();
        if (r13 == null) goto L15;
        HybridCard r14 = r13.d;
        if (r14 == null) goto L15;
        r14.release();
    L15:
        r1.t(new km1.a(r2, r1.n, r1.c));
    L16:
        LiveInteractiveHelper r15 = this.c;
        String r4 = this.b.toString();
        r15.getClass();
        vr1.o r5 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
        Pair[] r16 = new Pair[1];
        if (r4 != null) goto L19;
        r4 = BuildConfig.FLAVOR;
    L19:
        r16[0] = TuplesKt.to("load_url", r4);
        r5.s("livesdk_flexinteract_view_loaded", MapsKt.mutableMapOf(r16), "live", "other", "live_detail");
    }

    public final void onInnerFallback(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        super.onInnerFallback(r3, r4);
        this.a.a("fall back, error:" + r4);
    }

    public final void onLoadFail(View r7, String r8, String r9) {
        super.onLoadFail(r7, r8, r9);
        this.a.a(this.b.toString());
        View r10 = this.c.f;
        if (r10 == null) goto L5;
        UtilityKotlinExtentionsKt.u(r10);
    L5:
        LiveInteractiveHelper r11 = this.c;
        String r13 = this.b.toString();
        r11.getClass();
        vr1.o r0 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
        Pair[] r14 = new Pair[2];
        if (r9 != null) goto L8;
        r9 = BuildConfig.FLAVOR;
    L8:
        r14[0] = TuplesKt.to("error_msg", r9);
        if (r13 != null) goto L11;
        r13 = BuildConfig.FLAVOR;
    L11:
        r14[1] = TuplesKt.to("load_url", r13);
        r0.s("livesdk_flexinteract_view_load_error", MapsKt.mutableMapOf(r14), "live", "other", "live_detail");
    }

    public c0(o82.g r1, Uri r2, LiveInteractiveHelper r3, IBannerInfo r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
