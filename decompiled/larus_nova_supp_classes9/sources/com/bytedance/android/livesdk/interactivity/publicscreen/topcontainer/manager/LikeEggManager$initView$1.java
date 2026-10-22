package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager;

import android.content.Context;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.EasterEggAnimationDialog;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/likeegg/a;", "p1", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/chatroom/likeegg/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LikeEggManager$initView$1 extends FunctionReferenceImpl implements Function1<com.bytedance.android.livesdk.chatroom.likeegg.a, Unit> {
    public LikeEggManager$initView$1(c r8) {
        super(1, r8, c.class, "onFinish", "onFinish(Lcom/bytedance/android/livesdk/chatroom/likeegg/LikeEggMessage;)V", 0);
    }

    public final void invoke(final com.bytedance.android.livesdk.chatroom.likeegg.a r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        final c r0 = (c) ((CallableReference) this).receiver;
        int r1 = c.f;
        r0.getClass();
        final Context r2 = com.bytedance.android.live.core.utils.a.d();
        if (r2 != null) goto L6;
        r2 = r0.d.getContext();
    L6:
        EasterEggAnimationDialog.a r3 = EasterEggAnimationDialog.i;
        Function0<Unit> r4 = new LikeEggManager$onFinish$1(r0, r2, r5);
        r3.getClass();
        EasterEggAnimationDialog.a.a(r2, r4);
        GuideTray r6 = GuideTray.HotMsgGather;
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((com.bytedance.android.livesdk.chatroom.likeegg.a) r1);
        return Unit.INSTANCE;
    }
}
