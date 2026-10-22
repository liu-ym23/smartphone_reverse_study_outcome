package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class TopRightBannerWidget$onReceiveError$1 extends MutablePropertyReference0Impl {
    public TopRightBannerWidget$onReceiveError$1(TopRightBannerWidget r7) {
        super(r7, TopRightBannerWidget.class, "room", "getRoom()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", 0);
    }

    public Object get() {
        Room r0 = ((TopRightBannerWidget) ((CallableReference) this).receiver).d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L5:
        return r0;
    }

    public void set(Object r2) {
        Room r3 = (Room) r2;
        ((TopRightBannerWidget) ((CallableReference) this).receiver).d = r3;
    }
}
