package ig0;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements Runnable {
    public final /* synthetic */ b a;

    public d(b r1, int r2) {
        this.a = r1;
    }

    public final void a() {
        this.a.getClass();
        b r0 = this.a;
        MicSeatScene r1 = r0.b;
        if (r1 == MicSeatScene.VIDEO_LINK) goto L13;
        if (r1 == MicSeatScene.VIDEO_LINK_EQUAL) goto L13;
        if (r1 == MicSeatScene.AUDIO_LINK_C_POSITION_V2) goto L13;
        if (r1 == MicSeatScene.AUDIO_LINK_C_POSITION) goto L13;
        if (r1 == MicSeatScene.AUDIO_LINK_HEAD_RADIO) goto L13;
        return;
    L13:
        if ((!(r0 instanceof a)) == false) goto L33;
        int r2 = Math.min(r0.q().getWidth(), r0.q().getHeight());
        SeatAnimationView r3 = r0.f;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L17:
        double r4 = r2;
        int r5 = (int) (0.528d * r4);
        r3.m = r5;
        r3.n = r5;
        SeatAnimationView.f(r3.d, r5, r5);
        if ((r0 instanceof qg0.c) == false) goto L23;
        SeatAnimationView r6 = r0.f;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L22:
        int r7 = s1.f(62.0f);
        int r8 = s1.f(62.0f);
        r6.o = r7;
        r6.p = r8;
        SeatAnimationView.f(r6.e, r7, r8);
    L27:
        SeatAnimationView r9 = r0.f;
        if (r9 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L30:
        r9.q = r5;
        r9.r = r5;
        SeatAnimationView.f(r9.f, r5, r5);
        return;
    L23:
        SeatAnimationView r10 = r0.f;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L26:
        int r11 = (int) (r4 * 0.71d);
        r10.o = r11;
        r10.p = r11;
        SeatAnimationView.f(r10.e, r11, r11);
        goto L27
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
