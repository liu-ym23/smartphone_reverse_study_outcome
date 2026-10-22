package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "p1", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class GiftMessageService$onRtcRoomStop$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    public GiftMessageService$onRtcRoomStop$1(GiftMessageService r8) {
        super(1, r8, GiftMessageService.class, "onRtcRoomConnectStatusChange", "onRtcRoomConnectStatusChange(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean r2) {
        ((GiftMessageService) ((CallableReference) this).receiver).i(r2);
    }
}
