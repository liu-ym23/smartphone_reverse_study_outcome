package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import com.bytedance.android.live.base.model.user.r0;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.StickerEffectClosed;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ Function1 b;

    public b(d r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        d r0 = this.a;
        r0 r10 = (r0) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r9)).data;
        long r1 = r10.faceGiftSwitch;
        long r3 = r10.giftDiamondLevel;
        r0.getClass();
        Object r11 = null;
        if (r1 != 2) goto L6;
        String r2 = "主播已关闭「跟随人脸或肢体」的礼物特效展示，但仍可送出";
    L15:
        r0.b = r2;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(this.a.b) == false) goto L23;
        i12.d r4 = i12.m.e2.a();
        if (r4 == null) goto L20;
        r11 = com.bytedance.android.scope.m.e.d(r4, uz1.a.class);
    L20:
        uz1.a r13 = (uz1.a) r11;
        if (r13 == null) goto L23;
        String r5 = this.a.b;
        Intrinsics.checkNotNull(r5);
        r13.a(new StickerEffectClosed(r5));
    L23:
        Function1 r14 = this.b;
        if (r14 == null) goto L27;
        r14.invoke(this.a.b);
        return;
    L27:
        return;
    L6:
        if (r3 != 4) goto L9;
        String r6 = "499";
    L12:
        if (r6 == null) goto L14;
        r2 = "主播已关闭" + r6 + "钻石以下礼物的展示，但仍可以送出";
        goto L15
    L14:
        r2 = null;
        goto L15
    L9:
        if (r3 != 5) goto L11;
        r6 = "2999";
        goto L12
    L11:
        r6 = null;
        goto L12
    }
}
