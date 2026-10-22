package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.Colorful;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuWidget;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h0 extends com.bytedance.live.zdanmaku.data.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
    public final i0 a;
    public final h80.d<p22.n> b;
    public final h80.d<BarrageWidgetContext> c;

    public final List b(Object r3) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        return CollectionsKt.listOf(new tk6.b(r4, this.a));
    }

    public final void a(RenderEntity r20, Object r21) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r1 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) r21;
        Intrinsics.checkNotNullParameter(r20, "entity");
        Intrinsics.checkNotNullParameter(r1, "data");
        r20.b(DanmakuType.Chat);
        r20.a(tc2.h.class, new tc2.h(r1.getMessageId()));
        if (r1.g() == false) goto L5;
        r20.b(Colorful.Multi);
    L5:
        h80.d<BarrageWidgetContext> r3 = this.c;
        if (r3 == null) goto L13;
        BarrageWidgetContext r4 = (BarrageWidgetContext) r3.get();
        if (r4 == null) goto L13;
        pk6.a r5 = (pk6.a) r4.getDanmakuAlpha().getValue();
        if (r5 == null) goto L13;
        r20.a(pk6.a.class, r5);
    L13:
        if ((r1 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.e) == false) goto L15;
        r20.a(m.class, new m((com.bytedance.android.livesdk.interactivity.api.publicscreen.e) r1));
    L15:
        com.bytedance.android.live.base.model.message.k0 r2 = r1.getMessage();
        long r6 = 0;
        if (r2.isInsert() == true) goto L18;
    L45:
        long r9 = r2.getReceiveTime();
        long r11 = r2.getConsumeTime();
        if ((r2 instanceof com.bytedance.android.live.base.model.message.k0) == true) goto L48;
        r2 = null;
    L48:
        com.bytedance.android.live.base.model.message.k0 r7 = r2;
        if (r7 == null) goto L51;
        r6 = r7.getDanmakuReceiveTime();
    L51:
        r20.a(tc2.e.class, new tc2.e(r9, r11, r6));
        return;
    L18:
        if (r2.getHttpSendTime() <= 0) goto L45;
        if (r2.getReceiveTime() <= r2.getHttpSendTime()) goto L45;
        String r8 = com.bytedance.android.livesdk.interactivity.api.monitor.a.a(r2);
        long r10 = r2.getHttpSendTime();
        long r13 = r2.getReceiveTime();
        boolean r14 = r2 instanceof com.bytedance.android.live.base.model.message.k0;
        if (r14 == true) goto L24;
        com.bytedance.android.live.base.model.message.k0 r15 = null;
    L25:
        com.bytedance.android.live.base.model.message.k0 r16 = r15;
        if (r16 == null) goto L28;
        long r17 = r16.startSendTime();
    L29:
        if (r14 == true) goto L31;
        com.bytedance.android.live.base.model.message.k0 r18 = null;
    L32:
        com.bytedance.android.live.base.model.message.k0 r19 = r18;
        if (r19 == null) goto L35;
        long r110 = r19.getHttpSuccessTimestamps();
    L36:
        String r111 = r2.getMessageMethod();
        if (r14 == true) goto L39;
        com.bytedance.android.live.base.model.message.k0 r23 = null;
    L40:
        com.bytedance.android.live.base.model.message.k0 r24 = r23;
        if (r24 == null) goto L43;
        boolean r112 = r24.isSelfClickSend();
    L44:
        r20.a(tc2.j.class, new tc2.j(r8, r10, r13, r17, r110, r111, r112));
        goto L45
    L43:
        r112 = false;
        goto L44
    L39:
        r23 = r2;
        goto L40
    L35:
        r110 = 0;
        goto L36
    L31:
        r18 = r2;
        goto L32
    L28:
        r17 = 0;
        goto L29
    L24:
        r15 = r2;
        goto L25
    }

    public h0(View r2, PortraitSimpleZDanmakuWidget.c r3, PortraitSimpleZDanmakuWidget.d r4) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        Intrinsics.checkNotNullParameter(r3, "danmakuSettingConfigSupplier");
        this.b = r3;
        this.c = r4;
        this.a = new i0(r2, r3);
    }
}
