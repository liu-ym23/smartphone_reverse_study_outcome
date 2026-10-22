package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import com.bytedance.android.live.base.model.push.LivePushInfo;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ GiftRoomCleanCacheService a;

    public e(GiftRoomCleanCacheService r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        if (((Boolean) r5).booleanValue() == false) goto L6;
        final GiftRoomCleanCacheService r6 = this.a;
        r6.getClass();
        dr2.b r0 = vh6.c.b(dr2.b.class);
        int r1 = LivePushInfo.e;
        com.bytedance.android.live.base.model.push.b r2 = new com.bytedance.android.live.base.model.push.b();
        r2.setTitle("建议清理缓存");
        r2.setContent("当前缓存占用过高，建议及时清理");
        r2.setButtonText("立即清理");
        r2.setDuration(5000);
        r2.setScene("cache");
        Unit r3 = Unit.INSTANCE;
        LivePushInfo.a r4 = LivePushInfo.c.a(r2);
        Function1<LivePushInfo.b, Unit> r7 = new GiftRoomCleanCacheService$realShowPush$2(r6);
        Intrinsics.checkNotNullParameter(r7, "callback");
        r4.a = r7;
        r4.c(r6.c);
        r0.showLiveCommonInnerPush(new LivePushInfo(r4));
        return;
    }
}
