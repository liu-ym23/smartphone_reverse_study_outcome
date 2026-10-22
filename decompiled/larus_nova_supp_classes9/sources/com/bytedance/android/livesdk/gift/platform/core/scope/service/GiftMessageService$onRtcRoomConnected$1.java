package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", BuildConfig.FLAVOR, "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class GiftMessageService$onRtcRoomConnected$1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
    public GiftMessageService$onRtcRoomConnected$1(GiftMessageService r8) {
        super(1, r8, GiftMessageService.class, "onRtcRoomMessage", "onRtcRoomMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    public final void invoke(yh6.c r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        GiftMessageService r0 = (GiftMessageService) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r9, "message");
        if ((r9 instanceof o7) == false) goto L27;
        o7 r1 = (o7) r9;
        IRoom r2 = r0.i;
        if (r2 == null) goto L19;
        String r3 = r2.getAnchorId();
        if (r3 == null) goto L19;
        if (r1 == null) goto L19;
        List r4 = r1.getToUserIdStrings();
        IBaseUser r5 = r1.getToUser();
        List r6 = r1.getToUserIds();
        if ((!r4.isEmpty()) == false) goto L13;
        boolean r7 = r4.contains(r3);
    L20:
        if (r7 == false) goto L28;
        StringBuilder r8 = new StringBuilder("rtcRoom onMessage IGiftMessage: ");
        com.bytedance.android.livesdk.gift.model.h1 r10 = r1.getGift();
        if (r10 == null) goto L24;
        String r11 = r10.getName();
    L25:
        r8.append(r11);
        jy0.b.c("GiftMessageService", r8.toString(), null, 4);
        r1.setRtcRoomMessage(true);
        r0.h(r9);
        return;
    L24:
        r11 = null;
        goto L25
    L28:
        return;
    L13:
        if (r5 == null) goto L15;
        r7 = Intrinsics.areEqual(r5.getIdString(), r3);
        goto L20
    L15:
        if (r6 == null) goto L19;
        if ((!r6.isEmpty()) == false) goto L19;
        r7 = r6.contains(r3);
    L19:
        r7 = false;
        goto L20
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yh6.c) r1);
        return Unit.INSTANCE;
    }
}
