package com.bytedance.android.livesdk.gift.platform.core.sticker;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/o7;", "p1", "p2", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/message/model/o7;Lcom/bytedance/android/livesdk/message/model/o7;)I", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class StickerMessageInfo$otherMessages$1 extends FunctionReferenceImpl implements Function2<o7, o7, Integer> {
    public StickerMessageInfo$otherMessages$1(StickerMessageInfo r8) {
        super(2, r8, StickerMessageInfo.class, "compare", "compare(Lcom/bytedance/android/livesdk/message/model/IGiftMessage;Lcom/bytedance/android/livesdk/message/model/IGiftMessage;)I", 0);
    }

    public final int invoke(o7 r6, o7 r7) {
        ((StickerMessageInfo) ((CallableReference) this).receiver).getClass();
        if (r6 == null) goto L19;
        if (r7 == null) goto L19;
        int r1 = 0;
        if (r6.getGift() == null) goto L9;
        h1 r0 = r6.getGift();
        Intrinsics.checkNotNull(r0);
        int r2 = r0.getDiamondCount();
    L10:
        long r3 = r2;
        if (r7.getGift() == null) goto L13;
        h1 r4 = r7.getGift();
        Intrinsics.checkNotNull(r4);
        r1 = r4.getDiamondCount();
    L13:
        long r5 = r1;
        if (r3 != r5) goto L21;
        Intrinsics.checkNotNullParameter(r6, "$this$getGiftTimeStamp");
        long r8 = r6.getGiftTimeStamp();
        Intrinsics.checkNotNullParameter(r7, "$this$getGiftTimeStamp");
        if ((r8 - r7.getGiftTimeStamp()) <= 0) goto L19;
        return 1;
    L21:
        return (int) (r5 - r3);
    L9:
        r2 = 0;
    L19:
        return -1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return Integer.valueOf(invoke((o7) r1, (o7) r2));
    }
}
