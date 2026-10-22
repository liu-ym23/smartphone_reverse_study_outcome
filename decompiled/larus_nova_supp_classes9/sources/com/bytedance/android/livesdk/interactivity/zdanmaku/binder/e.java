package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import com.bytedance.android.livesdk.chatroom.vs_impl.message.BusinessMsgView;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessBarrageConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessResourceConfigure;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends com.bytedance.live.zdanmaku.data.b<BusinessConfigure> {
    public final eq1.b a;
    public final h80.d<p22.c> b;
    public final BarrageWidgetContext c;

    public final List b(Object r5) {
        BusinessConfigure r6 = (BusinessConfigure) r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        dq1.c r0 = pm1.f.k();
        if (r0 == null) goto L9;
        BusinessMsgView r1 = r0.d(jc1.a.b(), null, 0);
        if (r1 == null) goto L9;
        List r7 = CollectionsKt.listOf(new tk6.b(r6, new f(r1, this.b)));
        if (r7 == null) goto L9;
        return r7;
    L9:
        return CollectionsKt.emptyList();
    }

    public e(h80.d<p22.c> r2, BarrageWidgetContext r3) {
        Intrinsics.checkNotNullParameter(r2, "businessDanmakuSettingConfigSupplier");
        this.b = r2;
        this.c = r3;
        if (r3 == null) goto L5;
        boolean r0 = r3.isPortrait();
    L6:
        if (r3 == null) goto L8;
        boolean r4 = r3.isVSVerticalStream();
    L9:
        this.a = new eq1.b(r0, r4);
        return;
    L8:
        r4 = false;
        goto L9
    L5:
        r0 = true;
        goto L6
    }

    public final void a(final RenderEntity r3, Object r4) {
        final BusinessConfigure r5 = (BusinessConfigure) r4;
        Intrinsics.checkNotNullParameter(r3, "entity");
        Intrinsics.checkNotNullParameter(r5, "data");
        r3.b(DanmakuType.Business);
        BarrageWidgetContext r0 = this.c;
        if (r0 != null) goto L5;
    L9:
        BusinessResourceConfigure r1 = r5.resourceConfig;
        if (r1 == null) goto L25;
        BusinessBarrageConfigure r2 = r1.barrageConfig;
        if (r2 == null) goto L26;
        final String r6 = r2.getSchema();
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.length() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L22;
        r6 = null;
    L22:
        if (r6 == null) goto L28;
        com.bytedance.android.livesdk.interactivity.utils.u.a(r3, new BusinessDanmakuRenderBinder$onBindEntity$$inlined$let$lambda$1(r6, this, r3, r5));
        return;
    L28:
        return;
    L18:
        r7 = false;
        goto L19
    L26:
        return;
    L25:
        return;
    L5:
        if (r0.isPortrait() == true) goto L9;
        pk6.a r8 = (pk6.a) this.c.getDanmakuAlpha().getValue();
        if (r8 == null) goto L9;
        r3.a(pk6.a.class, r8);
        goto L9
    }
}
