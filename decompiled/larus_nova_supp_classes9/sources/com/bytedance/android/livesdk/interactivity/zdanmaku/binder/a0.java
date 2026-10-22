package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a0 extends com.bytedance.live.zdanmaku.data.b<q72.e> {
    public final b0 a;
    public final eq1.b b;
    public int c;
    public final BarrageWidgetContext d;

    public final List b(Object r3) {
        q72.e r4 = (q72.e) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        return CollectionsKt.listOf(new tk6.b(r4, this.a));
    }

    public final void a(final RenderEntity r23, Object r24) {
        q72.e r2 = (q72.e) r24;
        Intrinsics.checkNotNullParameter(r23, "entity");
        Intrinsics.checkNotNullParameter(r2, "data");
        r23.b(DanmakuType.Official);
        BarrageWidgetContext r3 = this.d;
        if (r3 != null) goto L5;
    L9:
        com.bytedance.android.live.base.model.message.t r4 = r2.getMessage();
        if (r4.isInsert() == true) goto L12;
    L16:
        r23.a(tc2.e.class, new tc2.e(r4.getReceiveTime(), r4.getConsumeTime(), 0, 4));
        com.bytedance.android.live.base.model.data.k r5 = r2.getContentExt();
        if (r5 == null) goto L20;
        Integer r6 = r5.a();
        if (r6 == null) goto L20;
    L21:
        boolean r7 = true;
        final String r8 = null;
        if (r6 != null) goto L24;
    L32:
        com.bytedance.android.live.base.model.data.k r9 = r2.getContentExt();
        if (r9 == null) goto L46;
        String r10 = r9.c();
        if (r10 != null) goto L37;
    L44:
        r23.a(tc2.c.class, new tc2.c(-1));
        return;
    L37:
        if (r10.length() > 0) goto L40;
        r7 = false;
    L40:
        if (r7 == false) goto L42;
        r8 = r10;
    L42:
        if (r8 == null) goto L44;
        r23.a(tc2.c.class, new tc2.c(0));
        com.bytedance.android.livesdk.interactivity.utils.u.a(r23, new OfficialDanmakuRenderBinder$onBindEntity$$inlined$let$lambda$1(r8, this, r23));
        return;
    L46:
        return;
    L24:
        if (r6.intValue() <= 0) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == true) goto L30;
        r6 = null;
    L30:
        if (r6 == null) goto L32;
        r23.a(tc2.b.class, new tc2.b(r6.intValue() * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        goto L32
    L26:
        r11 = false;
    L20:
        r6 = 5;
        goto L21
    L12:
        if (r4.getHttpSendTime() <= 0) goto L16;
        if (r4.getReceiveTime() <= r4.getHttpSendTime()) goto L16;
        r23.a(tc2.j.class, new tc2.j(com.bytedance.android.livesdk.interactivity.api.monitor.a.a(r4), r4.getHttpSendTime(), r4.getReceiveTime(), 0, 0, null, 120));
        goto L16
    L5:
        if (r3.isPortrait() == true) goto L9;
        pk6.a r13 = (pk6.a) this.d.getDanmakuAlpha().getValue();
        if (r13 == null) goto L9;
        r23.a(pk6.a.class, r13);
        goto L9
    }

    public a0(View r2, h80.d<p22.p> r3, BarrageWidgetContext r4) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        Intrinsics.checkNotNullParameter(r3, "danmakuSettingConfigSupplier");
        this.d = r4;
        this.a = new b0(r2, r3);
        if (r4 == null) goto L5;
        boolean r5 = r4.isPortrait();
    L6:
        if (r4 == null) goto L8;
        boolean r6 = r4.isVSVerticalStream();
    L9:
        this.b = new eq1.b(r5, r6);
        return;
    L8:
        r6 = false;
        goto L9
    L5:
        r5 = true;
        goto L6
    }
}
