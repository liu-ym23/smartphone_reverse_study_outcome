package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuPresenter;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class SimpleCommonTextDanmakuShooter extends h {
    public SimpleCommonTextDanmakuShooter(PortraitSimpleZDanmakuPresenter.e r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h, r22.a
    public final /* bridge */ /* synthetic */ void e(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r1) {
        l(r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h
    public final void l(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r2) {
        Intrinsics.checkNotNullParameter(r2, "danmaku");
        ((LinkedList) this.c).add(r2);
        k();
    }

    public final void n(final long r3, final long r5) {
        CollectionsKt.removeAll(this.c, new SimpleCommonTextDanmakuShooter$onDanmakuTimeout$1(r5, r3));
    }
}
