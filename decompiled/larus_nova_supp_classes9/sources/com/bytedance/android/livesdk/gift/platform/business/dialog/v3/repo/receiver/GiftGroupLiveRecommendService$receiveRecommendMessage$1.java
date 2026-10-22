package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.livesdk.message.model.u7;
import com.bytedance.android.livesdk.message.model.v7;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/u7;", "p1", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/message/model/u7;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class GiftGroupLiveRecommendService$receiveRecommendMessage$1 extends FunctionReferenceImpl implements Function1<u7, Unit> {
    public GiftGroupLiveRecommendService$receiveRecommendMessage$1(d r8) {
        super(1, r8, d.class, "onReceiveMessage", "onReceiveMessage(Lcom/bytedance/android/livesdk/message/model/IGroupLiveGiftRecipientRecommendMessage;)V", 0);
    }

    public final void invoke(u7 r6) {
        Intrinsics.checkNotNullParameter(r6, "p1");
        d r0 = (d) ((CallableReference) this).receiver;
        r0.getClass();
        LinkedHashMap r1 = new LinkedHashMap();
        Map r2 = r6.getExtra();
        if (r2 == null) goto L5;
        r1.putAll(r2);
    L5:
        r1.put("group_live_to_user_st", "rec");
        jy0.b.d("GiftReceiver", "GiftGroupLiveRecommendService onReceiveMessage ".concat(v7.a(r6)));
        r0.c.c(v7.a(r6), String.valueOf(r6.getReason()), r6.getExtra(), r1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((u7) r1);
        return Unit.INSTANCE;
    }
}
