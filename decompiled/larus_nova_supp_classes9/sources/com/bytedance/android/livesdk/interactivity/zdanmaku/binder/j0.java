package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.Colorful;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j0 extends com.bytedance.live.zdanmaku.data.b<q72.f> {
    public final k0 a;
    public final BarrageWidgetContext b;

    public final List b(Object r3) {
        q72.f r4 = (q72.f) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        return CollectionsKt.listOf(new tk6.b(r4, this.a));
    }

    public final void a(RenderEntity r21, Object r23) {
        q72.f r2 = (q72.f) r23;
        Intrinsics.checkNotNullParameter(r21, "entity");
        Intrinsics.checkNotNullParameter(r2, "data");
        r21.b(DanmakuType.Talent);
        r21.a(tc2.h.class, new tc2.h(r2.getMessageId()));
        if (r2.g() == false) goto L5;
        r21.b(Colorful.Multi);
    L5:
        BarrageWidgetContext r3 = this.b;
        if (r3 != null) goto L8;
    L16:
        com.bytedance.android.live.base.model.message.t r4 = r2.getMessage();
        if (r4.isInsert() == true) goto L19;
    L23:
        r21.a(tc2.e.class, new tc2.e(r4.getReceiveTime(), r4.getConsumeTime(), 0, 4));
        return;
    L19:
        if (r4.getHttpSendTime() <= 0) goto L23;
        if (r4.getReceiveTime() <= r4.getHttpSendTime()) goto L23;
        r21.a(tc2.j.class, new tc2.j(com.bytedance.android.livesdk.interactivity.api.monitor.a.a(r4), r4.getHttpSendTime(), r4.getReceiveTime(), 0, 0, null, 120));
        goto L23
    L8:
        if (r3.isPortrait() == true) goto L16;
        BarrageWidgetContext r5 = this.b;
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.j<pk6.a> r6 = r5.getDanmakuAlpha();
        if (r6 == null) goto L16;
        pk6.a r7 = (pk6.a) r6.getValue();
        if (r7 == null) goto L16;
        r21.a(pk6.a.class, r7);
        goto L16
    }

    public j0(View r2, h80.d<p22.p> r3, BarrageWidgetContext r4) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        Intrinsics.checkNotNullParameter(r3, "danmakuSettingConfigSupplier");
        this.b = r4;
        this.a = new k0(r2, r3);
    }
}
