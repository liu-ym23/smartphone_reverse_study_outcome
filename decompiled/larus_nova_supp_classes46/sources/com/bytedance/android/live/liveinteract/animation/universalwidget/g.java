package com.bytedance.android.live.liveinteract.animation.universalwidget;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h2;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends ka0.a {
    public final /* synthetic */ MultiLinkUniversalAnimWidget c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Function2 e;
    public final /* synthetic */ String f;
    public final /* synthetic */ long g;

    public final void a(HybridCard r5, String r6) {
        this.c.e = null;
        this.e.invoke(Boolean.FALSE, "onLoadFailed(" + r5 + ',' + r6 + ')');
        yc0.b.a r7 = new yc0.b.a();
        Intrinsics.checkNotNullParameter("load_lynx_failed", "reason");
        r7.a = "load_lynx_failed";
        r7.a();
    }

    public final void b(HybridCard r4, View r5, int r6) {
        ALogger.d("MultiLinkEffect.Widget", "createLynxComponent.onViewCreated(" + r4 + ',' + r5 + ',' + r6 + ')');
        ViewGroup.LayoutParams r7 = new ViewGroup.LayoutParams(-1, -1);
        if (r4 == null) goto L5;
        r4.setId(2131389674);
    L5:
        boolean r8 = this.d;
        MultiLinkUniversalAnimWidget r0 = this.c;
        if (r8 == false) goto L8;
        FrameLayout r1 = r0.c;
    L10:
        if (r1 != null) goto L25;
        if (r8 == false) goto L19;
        int r9 = MultiLinkUniversalAnimWidget.x;
        if (r0.u == true) goto L21;
        if (r0.Gq() == false) goto L18;
        r0.Jq();
        r0.u = true;
        goto L21
    L18:
        r0.u = false;
    L21:
        if (this.d == false) goto L23;
        FrameLayout r10 = this.c.c;
    L24:
        r1 = r10;
        goto L25
    L23:
        r10 = this.c.d;
        goto L24
    L19:
        int r11 = MultiLinkUniversalAnimWidget.x;
        r0.zq();
    L25:
        h2 r12 = null;
        if (r4 == null) goto L40;
        if (r1 == null) goto L40;
        r1.setVisibility(0);
        r1.addView(r4, r7);
        this.e.invoke(Boolean.TRUE, "success!");
        MultiLinkEventModule r13 = yc0.a.a;
        yc0.b.a r14 = new yc0.b.a();
        if (Intrinsics.areEqual(this.f, "sar") == false) goto L33;
        String r15 = "lynx-sar";
    L36:
        Intrinsics.checkNotNullParameter(r15, "flymicType");
        r14.c = r15;
        Intrinsics.checkNotNullParameter("success", "reason");
        r14.a = "success";
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r16 = this.c.p;
        r14.e = r16;
        if (r16 == null) goto L39;
        r12 = r16.k;
    L39:
        r14.b = r12;
        r14.d = System.currentTimeMillis() - this.g;
        yc0.a.d(new yc0.b(r14));
        return;
    L33:
        if (Intrinsics.areEqual(this.f, "amaz") == false) goto L35;
        r15 = "lynx-amaz";
        goto L36
    L35:
        r15 = PbRequest.SwitchType.OTHER;
    L40:
        this.e.invoke(Boolean.FALSE, "view == null || topAnimContainer == null");
        MultiLinkEventModule r17 = yc0.a.a;
        yc0.b.a r18 = new yc0.b.a();
        Intrinsics.checkNotNullParameter("container_empty", "reason");
        r18.a = "container_empty";
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r19 = this.c.p;
        r18.e = r19;
        if (r19 == null) goto L43;
        r12 = r19.k;
    L43:
        r18.b = r12;
        yc0.a.b(new yc0.b(r18));
        return;
    L8:
        r1 = r0.d;
        goto L10
    }

    public g(MultiLinkUniversalAnimWidget r1, boolean r2, Function2 r3, String r4, long r5, Context r7, Uri r8, int r9) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        super(r7, r8, r9);
    }
}
