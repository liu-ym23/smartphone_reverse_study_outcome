package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.Colorful;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends com.bytedance.live.zdanmaku.data.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
    public final l a;
    public final h80.d<p22.p> b;
    public final BarrageWidgetContext c;

    public final List b(Object r3) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r4 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        p22.p r0 = (p22.p) this.b.get();
        ((ArrayList) ab2.a.d(r4.getChatContent())).isEmpty();
        return CollectionsKt.listOf(new tk6.b(r4, this.a));
    }

    public final void a(RenderEntity r20, Object r21) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r2 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) r21;
        Intrinsics.checkNotNullParameter(r20, "entity");
        Intrinsics.checkNotNullParameter(r2, "data");
        r20.b(DanmakuType.Chat);
        if (r2.g() == false) goto L5;
        r20.b(Colorful.Multi);
    L5:
        BarrageWidgetContext r3 = this.c;
        if (r3 == null) goto L17;
        if (r3.isPortrait() == true) goto L17;
        BarrageWidgetContext r4 = this.c;
        if (r4 == null) goto L17;
        com.bytedance.live.datacontext.j<pk6.a> r5 = r4.getDanmakuAlpha();
        if (r5 == null) goto L17;
        pk6.a r6 = (pk6.a) r5.getValue();
        if (r6 == null) goto L17;
        r20.a(pk6.a.class, r6);
    L17:
        if ((r2 instanceof com.bytedance.android.livesdk.interactivity.api.publicscreen.e) == false) goto L19;
        r20.a(m.class, new m((com.bytedance.android.livesdk.interactivity.api.publicscreen.e) r2));
    L19:
        com.bytedance.android.live.base.model.message.k0 r7 = r2.getMessage();
        long r8 = 0;
        if (r7.isInsert() == true) goto L22;
    L49:
        long r9 = r7.getReceiveTime();
        long r11 = r7.getConsumeTime();
        if ((r7 instanceof com.bytedance.android.live.base.model.message.k0) == true) goto L52;
        r7 = null;
    L52:
        com.bytedance.android.live.base.model.message.k0 r10 = r7;
        if (r10 == null) goto L55;
        r8 = r10.getDanmakuReceiveTime();
    L55:
        r20.a(tc2.e.class, new tc2.e(r9, r11, r8));
        return;
    L22:
        if (r7.getHttpSendTime() <= 0) goto L49;
        if (r7.getReceiveTime() <= r7.getHttpSendTime()) goto L49;
        String r13 = com.bytedance.android.livesdk.interactivity.api.monitor.a.a(r7);
        long r14 = r7.getHttpSendTime();
        long r15 = r7.getReceiveTime();
        boolean r16 = r7 instanceof com.bytedance.android.live.base.model.message.k0;
        if (r16 == true) goto L28;
        com.bytedance.android.live.base.model.message.k0 r17 = null;
    L29:
        com.bytedance.android.live.base.model.message.k0 r18 = r17;
        if (r18 == null) goto L32;
        long r19 = r18.startSendTime();
    L33:
        if (r16 == true) goto L35;
        com.bytedance.android.live.base.model.message.k0 r110 = null;
    L36:
        com.bytedance.android.live.base.model.message.k0 r111 = r110;
        if (r111 == null) goto L39;
        long r112 = r111.getHttpSuccessTimestamps();
    L40:
        String r113 = r7.getMessageMethod();
        if (r16 == true) goto L43;
        com.bytedance.android.live.base.model.message.k0 r23 = null;
    L44:
        com.bytedance.android.live.base.model.message.k0 r24 = r23;
        if (r24 == null) goto L47;
        boolean r114 = r24.isSelfClickSend();
    L48:
        r20.a(tc2.j.class, new tc2.j(r13, r14, r15, r19, r112, r113, r114));
        goto L49
    L47:
        r114 = false;
        goto L48
    L43:
        r23 = r7;
        goto L44
    L39:
        r112 = 0;
        goto L40
    L35:
        r110 = r7;
        goto L36
    L32:
        r19 = 0;
        goto L33
    L28:
        r17 = r7;
        goto L29
    }

    public k(View r2, h80.d<p22.p> r3, BarrageWidgetContext r4) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        Intrinsics.checkNotNullParameter(r3, "danmakuSettingConfigSupplier");
        this.b = r3;
        this.c = r4;
        this.a = new l(r2, r3);
    }
}
