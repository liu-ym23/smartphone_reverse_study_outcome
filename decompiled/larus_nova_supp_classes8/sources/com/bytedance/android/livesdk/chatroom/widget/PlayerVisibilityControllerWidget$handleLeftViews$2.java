package com.bytedance.android.livesdk.chatroom.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class PlayerVisibilityControllerWidget$handleLeftViews$2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.vsplayer.model.c, Unit> {
    final /* synthetic */ PlayerVisibilityControllerWidget$handleLeftViews$1 $realHandle$1;

    public PlayerVisibilityControllerWidget$handleLeftViews$2(PlayerVisibilityControllerWidget$handleLeftViews$1 r7) {
        this.$realHandle$1 = r7;
        super(1, null, "realHandle", "invoke(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/VSPlayerViewControlItem;)V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        this.$realHandle$1.invoke(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.chatroom.vsplayer.model.c) r1);
        return Unit.INSTANCE;
    }
}
