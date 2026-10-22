package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.jsbridge.base.CheckEffectInUsedResultModel;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "checkEffectInUsed")
public final class w1 extends w20.s<w20.c8, CheckEffectInUsedResultModel> {
    public w1() {
    }

    public final void invoke(Object r9, CallContext r11) {
        w20.c8 r12 = (w20.c8) r9;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r13 = r12.b();
        if (Intrinsics.areEqual(r13, com.bytedance.android.live.effect.api.d0.e) == false) goto L5;
    L8:
        String r14 = com.bytedance.android.live.effect.api.d0.c;
    L9:
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        String r15 = r12.a();
        if (r15 == null) goto L16;
        Long r16 = StringsKt.toLongOrNull(r15);
        if (r16 == null) goto L16;
        long r2 = r16.longValue();
    L17:
        boolean r4 = false;
        if (r14.length() != 0) goto L20;
        boolean r17 = true;
    L21:
        if (r17 == false) goto L23;
    L52:
        finishWithFailure();
        return;
    L23:
        if (r2 == 0) goto L52;
        if (RoomContext.a.c(RoomContext.Companion, null, 0, 3) != null) goto L34;
        IBroadcastService r18 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r18 == null) goto L30;
        LiveMode r19 = r18.getPreviewLiveMode();
    L32:
        if (r19 != LiveMode.VIDEO) goto L34;
        boolean r21 = true;
    L35:
        if (r21 == true) goto L44;
        RoomContext r22 = RoomContext.a.a(null, 0);
        if (r22 == null) goto L43;
        com.bytedance.live.datacontext.i r23 = r22.isAnchor();
        if (r23 == null) goto L43;
        if (((Boolean) r23.getValue()).booleanValue() == true) goto L44;
    L43:
        LiveEffectContextFactoryDelegate$Type r24 = LiveEffectContextFactoryDelegate$Type.LINK;
    L45:
        List<String> r0 = LiveEffectContext.h;
        Iterator<Sticker> r25 = LiveEffectContext.a.a(r24).a().o(r14).iterator();
    L47:
        if (r25.hasNext() == false) goto L51;
        if (r25.next().getId() != r2) goto L47;
        r4 = true;
    L51:
        CheckEffectInUsedResultModel r26 = new CheckEffectInUsedResultModel();
        r26.a(CheckEffectInUsedResultModel.Code.Success);
        CheckEffectInUsedResultModel.a r110 = new CheckEffectInUsedResultModel.a();
        r110.a(Boolean.valueOf(r4));
        Unit r1 = Unit.INSTANCE;
        r26.b(r110);
        finishWithResult(r26);
        return;
    L44:
        r24 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        goto L45
    L30:
        r19 = null;
    L34:
        r21 = false;
        goto L35
    L20:
        r17 = false;
    L16:
        r2 = 0;
        goto L17
    L5:
        if (Intrinsics.areEqual(r13, com.bytedance.android.live.effect.api.d0.f) == true) goto L8;
        r14 = r12.b();
        goto L9
    }
}
