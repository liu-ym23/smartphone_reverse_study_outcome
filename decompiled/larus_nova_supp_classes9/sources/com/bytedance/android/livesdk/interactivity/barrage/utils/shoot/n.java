package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends f {
    public final r22.b<q72.c> f;
    public final BarrageWidgetContext g;

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.f, r22.a
    public final r22.b<q72.c> f() {
        return this.f;
    }

    public n(CarnivalDanmakuPresenter.d r2, BarrageWidgetContext r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2, r3);
        this.f = r2;
        this.g = r3;
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.f, r22.a
    public final /* bridge */ /* synthetic */ void b(q72.c r1, r22.a.b<q72.c> r2) {
        l(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.f
    public final void l(q72.c r6, r22.a.b<q72.c> r7) {
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r7, "notifier");
        com.bytedance.android.livesdk.interactivity.api.barrage.data.c r8 = r6.g;
        if (r8 != null) goto L22;
        int r9 = r6.j;
        BarrageWidgetContext r0 = this.g;
        if (r0 == null) goto L17;
        com.bytedance.live.datacontext.j<GeneralCarnivalDataSyncModel> r1 = r0.getGeneralCarnivalSyncModel();
        if (r1 == null) goto L17;
        GeneralCarnivalDataSyncModel r2 = (GeneralCarnivalDataSyncModel) r1.getValue();
        if (r2 == null) goto L17;
        dc2.c<com.bytedance.android.livesdk.interactivity.api.barrage.data.k> r3 = r2.getCarnivalMessage();
        if (r3 == null) goto L17;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.k r4 = r3.c();
        if (r4 == null) goto L17;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.j r5 = r4.a();
        if (r5 == null) goto L17;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.c> r10 = r5.u();
    L18:
        if (r10 == null) goto L21;
        r8 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.c) CollectionsKt.getOrNull(r10, r9);
        if (r8 != null) goto L22;
        return;
    L21:
        return;
    L17:
        r10 = null;
    L22:
        long r11 = r8.f();
        int r13 = com.bytedance.android.livesdk.interactivity.api.barrage.data.i.a;
        if (r11 != 1) goto L25;
        boolean r14 = true;
    L26:
        r6.b = r14;
        r6.c = r8.d();
        m(r6, r8.a(), UtilityKotlinExtentionsKt.i((int) r8.c()), UtilityKotlinExtentionsKt.i((int) r8.b()));
        return;
    L25:
        r14 = false;
        goto L26
    }
}
