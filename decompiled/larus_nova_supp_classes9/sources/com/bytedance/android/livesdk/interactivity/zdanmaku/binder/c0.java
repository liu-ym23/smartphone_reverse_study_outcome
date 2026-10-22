package com.bytedance.android.livesdk.interactivity.zdanmaku.binder;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuWidget;
import com.bytedance.live.artist.render.RenderEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 extends com.bytedance.live.zdanmaku.data.b<q72.e> {
    public final d0 a;
    public final eq1.b b;
    public int c;

    public final List b(Object r3) {
        q72.e r4 = (q72.e) r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        return CollectionsKt.listOf(new tk6.b(r4, this.a));
    }

    public final void a(final RenderEntity r6, Object r7) {
        q72.e r8 = (q72.e) r7;
        Intrinsics.checkNotNullParameter(r6, "entity");
        Intrinsics.checkNotNullParameter(r8, "data");
        r6.b(DanmakuType.Official);
        com.bytedance.android.live.base.model.data.k r9 = r8.getContentExt();
        if (r9 == null) goto L27;
        Integer r0 = r9.a();
        boolean r1 = true;
        final String r3 = null;
        if (r0 != null) goto L7;
    L15:
        String r10 = r9.c();
        if (r10 != null) goto L18;
    L25:
        r6.a(tc2.c.class, new tc2.c(-1));
        return;
    L18:
        if (r10.length() > 0) goto L21;
        r1 = false;
    L21:
        if (r1 == false) goto L23;
        r3 = r10;
    L23:
        if (r3 == null) goto L25;
        r6.a(tc2.c.class, new tc2.c(0));
        com.bytedance.android.livesdk.interactivity.utils.u.a(r6, new PortraitOfficialDanmakuRenderBinder$onBindEntity$$inlined$let$lambda$1(r3, this, r6));
        return;
    L7:
        if (r0.intValue() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L15;
        r6.a(tc2.b.class, new tc2.b(r0.intValue() * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        goto L15
    L9:
        r4 = false;
        goto L10
    }

    public c0(View r2, PortraitZDanmakuWidget.f r3, BarrageWidgetContext r4) {
        Intrinsics.checkNotNullParameter(r2, "templateView");
        Intrinsics.checkNotNullParameter(r3, "danmakuSettingConfigSupplier");
        this.a = new d0(r2);
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
