package com.bytedance.android.livesdk.chatroom.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/d;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/api/d;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class PlayerControlWidget$registerPlayerEvent$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.vsplayer.api.d, Unit> {
    public static final PlayerControlWidget$registerPlayerEvent$1 INSTANCE = null;

    static {
        INSTANCE = new PlayerControlWidget$registerPlayerEvent$1();
    }

    public PlayerControlWidget$registerPlayerEvent$1() {
        super(1, com.bytedance.android.livesdk.chatroom.vsplayer.api.d.class, "onPlayResume", "onPlayResume()V", 0);
    }

    public final void invoke(com.bytedance.android.livesdk.chatroom.vsplayer.api.d r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        r2.k2();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.chatroom.vsplayer.api.d) r1);
        return Unit.INSTANCE;
    }
}
