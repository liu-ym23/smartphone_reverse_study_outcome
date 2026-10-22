package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.android.livesdkapi.room.controller.ILiveMergeRoomController;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "controller", "Lcom/bytedance/android/livesdkapi/room/controller/ILiveRoomController;", "invoke"}, k = 3, mv = {1, 4, 3})
final class InteractionRoomControllerManager$notifyControllerResume$1 extends Lambda implements Function1<ILiveRoomController, Unit> {
    public static final InteractionRoomControllerManager$notifyControllerResume$1 INSTANCE = null;

    static {
        INSTANCE = new InteractionRoomControllerManager$notifyControllerResume$1();
    }

    public InteractionRoomControllerManager$notifyControllerResume$1() {
        super(1);
    }

    public final void invoke(ILiveRoomController r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        if ((r2 instanceof ILiveMergeRoomController) == false) goto L6;
        ((ILiveMergeRoomController) r2).onResume();
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ILiveRoomController) r1);
        return Unit.INSTANCE;
    }
}
