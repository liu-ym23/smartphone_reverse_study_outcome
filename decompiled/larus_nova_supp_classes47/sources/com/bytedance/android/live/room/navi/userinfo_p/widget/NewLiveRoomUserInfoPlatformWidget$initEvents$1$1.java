package com.bytedance.android.live.room.navi.userinfo_p.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import zg1.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzg1/x0;", "p1", "", "invoke", "(Lzg1/x0;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class NewLiveRoomUserInfoPlatformWidget$initEvents$1$1 extends FunctionReferenceImpl implements Function1<x0, Unit> {
    public NewLiveRoomUserInfoPlatformWidget$initEvents$1$1(NewLiveRoomUserInfoPlatformWidget r8) {
        super(1, r8, NewLiveRoomUserInfoPlatformWidget.class, "onEvent", "onEvent(Lcom/bytedance/android/livesdk/chatroom/event/LandscapeRootViewChangeEvent;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((x0) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(x0 r2) {
        ((NewLiveRoomUserInfoPlatformWidget) ((CallableReference) this).receiver).onEvent(r2);
    }
}
