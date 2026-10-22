package gt8;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements d.b {
    public final /* synthetic */ d a;

    @Override // gt8.d.b
    public int getType() {
        return 2;
    }

    public e(d r1) {
        this.a = r1;
    }

    @Override // gt8.d.b
    public final void a(MotionEvent r15) {
        Intrinsics.checkNotNullParameter(r15, "event");
        b0 r1 = this.a.h;
        Intrinsics.checkNotNull(r15);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r15, "event");
        int r0 = r15.getPointerCount();
        int r2 = r15.getAction() & 255;
        if (r2 == 0) goto L54;
        PointF r4 = null;
        if (r2 != 1) goto L7;
        r1.c = null;
        r1.b = null;
        r1.a.d();
        r1.a.a();
        return;
    L7:
        if (r2 == 2) goto L22;
        if (r2 != 5) goto L11;
        r1.b = new a0(r15.getX(), r15.getY(), r15.getX(1), r15.getY(1));
        r1.a(r15);
        a0 r16 = r1.b;
        if (r16 == null) goto L17;
        r4 = r16.c;
    L17:
        r1.d = r4;
        r1.a.f();
        if (r1.f == true) goto L20;
        r1.a.onTransformStart();
        r1.f = true;
    L20:
        FLogger.a.d("TransformActionHandler", "ACTION_POINTER_DOWN");
        return;
    L11:
        if (r2 != 6) goto L60;
        FLogger.a.d("TransformActionHandler", "ACTION_POINTER_UP");
        r1.a.c();
        return;
    L60:
        return;
    L22:
        if (r1.f == true) goto L24;
        r1.f = true;
        r1.a.onTransformStart();
    L24:
        float r3 = 0.0f;
        float r7 = 1.0f;
        if (r0 == 1) goto L44;
        if (r0 != 2) goto L43;
        r1.e = null;
        r1.a(r15);
        if (r1.b != null) goto L31;
        a0 r5 = new a0(r15.getX(), r15.getY(), r15.getX(1), r15.getY(1));
        r1.b = r5;
        r1.d = r5.c;
    L31:
        a0 r17 = r1.b;
        if (r17 == null) goto L43;
        a0 r6 = r1.c;
        if (r6 == null) goto L43;
        Intrinsics.checkNotNullParameter(r6, "nextPoint");
        r7 = r6.a() / r17.a();
        Intrinsics.checkNotNullParameter(r6, "nextPoint");
        float r8 = r17.a.x;
        float r9 = r6.a.x;
        float r10 = r17.b.x;
        float r11 = r6.b.x;
        if (((r8 - r9) * (r10 - r11)) < 0.0f) goto L38;
        float r12 = ((r9 - r8) + (r11 - r10)) / 2;
    L39:
        Intrinsics.checkNotNullParameter(r6, "nextPoint");
        float r13 = r17.a.y;
        float r14 = r6.a.y;
        float r18 = r17.b.y;
        float r19 = r6.b.y;
        if (((r13 - r14) * (r18 - r19)) < 0.0f) goto L42;
        r3 = ((r14 - r13) + (r19 - r18)) / 2;
    L42:
        Intrinsics.checkNotNullParameter(r6, "points");
        PointF r20 = r17.a;
        PointF r21 = r6.a;
        r20.x = r21.x;
        r20.y = r21.y;
        PointF r22 = r17.b;
        PointF r23 = r6.b;
        float r24 = r23.x;
        r22.x = r24;
        float r25 = r23.y;
        r22.y = r25;
        PointF r110 = r17.c;
        float r26 = 2;
        r110.x = (r20.x + r24) / r26;
        r110.y = (r20.y + r25) / r26;
        float r111 = r3;
        r3 = r12;
    L52:
        FLogger.a.d("TransformActionHandler", "ACTION_MOVE, scale = " + r7 + ", translateX = " + r3 + ", translateY = " + r111);
        r1.a.e(r1.d, r7, r3, r111);
        r1.a.g();
        return;
    L38:
        r12 = 0.0f;
    L43:
        r111 = 0.0f;
        goto L52
    L44:
        PointF r27 = r1.e;
        if (r27 != null) goto L50;
        PointF r28 = new PointF();
        r1.e = r28;
        r28.x = r15.getX();
        PointF r29 = r1.e;
        if (r29 == null) goto L49;
        r29.y = r15.getY();
    L49:
        float r112 = 0.0f;
    L51:
        r1.b = null;
        float r113 = r3;
        r3 = r112;
        r111 = r113;
        goto L52
    L50:
        float r30 = r15.getX() - r27.x;
        float r31 = r15.getY() - r27.y;
        r27.x = r15.getX();
        r27.y = r15.getY();
        r112 = r30;
        r3 = r31;
        goto L51
    L54:
        r1.a.b();
    }
}
