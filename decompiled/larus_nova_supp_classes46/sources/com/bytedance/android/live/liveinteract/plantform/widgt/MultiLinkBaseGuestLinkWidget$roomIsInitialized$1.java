package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiLinkBaseGuestLinkWidget$roomIsInitialized$1 extends MutablePropertyReference0Impl {
    public MultiLinkBaseGuestLinkWidget$roomIsInitialized$1(MultiLinkBaseGuestLinkWidget r7) {
        super(r7, MultiLinkBaseGuestLinkWidget.class, "mRoom", "getMRoom()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", 0);
    }

    public Object get() {
        return ((MultiLinkBaseGuestLinkWidget) ((CallableReference) this).receiver).getMRoom();
    }

    public void set(Object r3) {
        MultiLinkBaseGuestLinkWidget r0 = (MultiLinkBaseGuestLinkWidget) ((CallableReference) this).receiver;
        IRoom r4 = (IRoom) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.a = r4;
    }
}
