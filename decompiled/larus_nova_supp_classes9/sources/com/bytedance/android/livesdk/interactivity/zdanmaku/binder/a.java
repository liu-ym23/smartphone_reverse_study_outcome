package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends com.bytedance.live.zdanmaku.data.b<com.bytedance.android.livesdk.interactivity.zdanmaku.k> {
    public final b a;
    public final BarrageWidgetContext b;

    public final List b(Object r3) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.k r4 = (com.bytedance.android.livesdk.interactivity.zdanmaku.k) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        return CollectionsKt.listOf(new tk6.b(r4, this.a));
    }

    public final void a(RenderEntity r14, Object r15) {
        com.bytedance.android.livesdk.interactivity.zdanmaku.k r16 = (com.bytedance.android.livesdk.interactivity.zdanmaku.k) r15;
        Intrinsics.checkNotNullParameter(r14, "entity");
        Intrinsics.checkNotNullParameter(r16, "data");
        r14.b(DanmakuType.Admin);
        BarrageWidgetContext r0 = this.b;
        if (r0 == null) goto L14;
        if (r0.isPortrait() == true) goto L14;
        BarrageWidgetContext r1 = this.b;
        if (r1 == null) goto L14;
        com.bytedance.live.datacontext.j<pk6.a> r2 = r1.getDanmakuAlpha();
        if (r2 == null) goto L14;
        pk6.a r3 = (pk6.a) r2.getValue();
        if (r3 == null) goto L14;
        r14.a(pk6.a.class, r3);
    L14:
        if (r16.a.isInsert() == false) goto L19;
        String r4 = com.bytedance.android.livesdk.interactivity.api.monitor.a.a(r16.a);
        long r5 = r16.a.getHttpSendTime();
        long r6 = r16.a.getReceiveTime();
        long r7 = r16.a.getStartSendTime();
        long r9 = r16.a.getApiSuccessTime();
        String r8 = r16.a.getMessageMethod();
        if (r8 != null) goto L18;
        r8 = "--default--";
    L18:
        r14.a(tc2.j.class, new tc2.j(r4, r5, r6, r7, r9, r8, 64));
    L19:
        r14.a(tc2.e.class, new tc2.e(r16.a.getReceiveTime(), r16.a.getConsumeTime(), r16.a.getDanmakuReceiveTime()));
    }

    public a(View r2, h80.d<p22.a> r3, BarrageWidgetContext r4) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        Intrinsics.checkNotNullParameter(r3, "danmakuSettingConfigSupplier");
        this.b = r4;
        this.a = new b(r2, r3);
    }
}
