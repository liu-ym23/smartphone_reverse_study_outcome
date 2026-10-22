package f92;

import com.bytedance.android.livesdk.chatroom.model.interact.MultiAnchorLinkmicLiveCoreInfo;
import com.bytedance.android.livesdk.config.ma0;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.WindowLayoutType;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends f {

    /* JADX INFO: renamed from: f92.a$a, reason: collision with other inner class name */
    public static final class C0230a {
    }

    static {
    }

    @Override // f92.f
    public final void e() {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        i r2 = new i();
        r2.k(0.0d);
        r2.l(0.0d);
        r2.j(1.0d);
        r2.g(1.0d);
        r2.i(1);
        Unit r5 = Unit.INSTANCE;
        r1.add(r2);
        h r3 = new h();
        r3.d(r1);
        r0.add(r3);
        ArrayList r4 = new ArrayList();
        i r6 = new i();
        r6.k(0.0d);
        int r7 = c.i;
        r6.l(0.19d);
        r6.j(0.49583333333333335d);
        r6.g(0.40286458333333336d);
        ma0 r11 = ma0.a;
        if (((Boolean) r11.getValue()).booleanValue() == false) goto L5;
        int r13 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V1.ordinal();
    L6:
        r6.i(r13);
        r4.add(r6);
        i r8 = new i();
        r8.k(0.5041666666666667d);
        r8.l(0.19d);
        r8.j(0.49583333333333335d);
        r8.g(0.40286458333333336d);
        if (((Boolean) r11.getValue()).booleanValue() == false) goto L9;
        int r9 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V1.ordinal();
    L10:
        r8.i(r9);
        r4.add(r8);
        h r10 = new h();
        r10.d(r4);
        r0.add(r10);
        ArrayList r14 = new ArrayList();
        i r15 = new i();
        r15.k(0.0d);
        r15.l(0.19d);
        r15.j(0.49583333333333335d);
        r15.g(0.49583333333333335d);
        r15.i(MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V2ForLargest.ordinal());
        r14.add(r15);
        i r16 = new i();
        r16.k(0.5041666666666667d);
        r16.l(0.19d);
        r16.j(0.49583333333333335d);
        r16.g(0.24557291666666667d);
        MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode r17 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode2V2Equal;
        r16.i(r17.ordinal());
        r14.add(r16);
        i r18 = new i();
        r18.k(0.5041666666666667d);
        r18.l(0.44026041666666665d);
        r18.j(0.49583333333333335d);
        r18.g(0.24557291666666667d);
        r18.i(r17.ordinal());
        r14.add(r18);
        h r19 = new h();
        r19.d(r14);
        r0.add(r19);
        ArrayList r20 = new ArrayList();
        i r21 = new i();
        r21.k(0.0d);
        r21.l(0.19d);
        r21.j(0.6613333333333333d);
        r21.g(0.693d);
        r21.i(MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V3ForLargest.ordinal());
        r21.h(WindowLayoutType.EnlargeBig.ordinal());
        r20.add(r21);
        i r23 = new i();
        r23.k(0.6696666666666666d);
        r23.l(0.19d);
        r23.j(0.3303333333333333d);
        r23.g(0.22787499999999997d);
        MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode r24 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V3ForSecond;
        r23.i(r24.ordinal());
        WindowLayoutType r110 = WindowLayoutType.EnlargeSmall;
        r23.h(r110.ordinal());
        r20.add(r23);
        i r25 = new i();
        r25.k(0.6696666666666666d);
        r25.l(0.4225625d);
        r25.j(0.3303333333333333d);
        r25.g(0.22787499999999997d);
        r25.i(r24.ordinal());
        r25.h(r110.ordinal());
        r20.add(r25);
        i r26 = new i();
        r26.k(0.6696666666666666d);
        r26.l(0.655125d);
        r26.j(0.3303333333333333d);
        r26.g(0.22787499999999997d);
        r26.i(r24.ordinal());
        r26.h(r110.ordinal());
        r20.add(r26);
        h r27 = new h();
        r27.d(r20);
        r0.add(r27);
        f(r0);
        return;
    L9:
        r9 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V2ForLargest.ordinal();
        goto L10
    L5:
        r13 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V2ForLargest.ordinal();
        goto L6
    }

    public a() {
    }
}
