package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class BaseGuestLinkWidget$roomIsInitialized$1 extends MutablePropertyReference0Impl {
    public BaseGuestLinkWidget$roomIsInitialized$1(BaseGuestLinkWidget r7) {
        super(r7, BaseGuestLinkWidget.class, PbRequest.SwitchType.ROOM, "getRoom()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", 0);
    }

    public Object get() {
        return ((BaseGuestLinkWidget) ((CallableReference) this).receiver).getRoom();
    }

    public void set(Object r3) {
        BaseGuestLinkWidget r0 = (BaseGuestLinkWidget) ((CallableReference) this).receiver;
        IRoom r4 = (IRoom) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.a = r4;
    }
}
