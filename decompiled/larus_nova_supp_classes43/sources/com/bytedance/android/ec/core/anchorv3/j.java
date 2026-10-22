package com.bytedance.android.ec.core.anchorv3;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.view.Choreographer;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j extends BasePdpMessageOptWorker {
    public static int u;
    public int k;
    public boolean l;
    public int m;
    public boolean n;
    public Long o;
    public int p;
    public final PdpMessageOptImageHelper q;
    public volatile boolean r;
    public final b s;
    public final boolean t;

    public static final class a {
    }

    public static final class b implements Choreographer.FrameCallback {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r10) {
            if (this.a.l == true) goto L5;
            return;
        L5:
            long r11 = System.currentTimeMillis();
            Long r0 = this.a.o;
            if (r0 == null) goto L13;
            long r1 = r11 - r0.longValue();
            long r12 = 8;
            long r13 = j.u;
            if (r12 > r1) goto L13;
            if (r13 <= r1) goto L13;
            j.u = (int) r1;
        L13:
            this.a.o = Long.valueOf(r11);
            j r14 = this.a;
            int r15 = r14.m + 1;
            r14.m = r15;
            if (r15 >= 3) goto L16;
        L19:
            r14.n = false;
            r14.d = false;
            Choreographer.getInstance().postFrameCallback(r14.s);
            boolean r16 = PdpMessageOpt.a;
            PdpMessageOpt.e("doFrame count=" + this.a.m + " duration=" + j.u);
            return;
        L16:
            if (r14.n == false) goto L18;
            r14.p = 0;
            goto L19
        L18:
            r14.p++;
            goto L19
        }
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void g() {
        this.l = true;
    }

    static {
        u = 16;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void b() {
        boolean r0 = PdpMessageOpt.a;
        Intrinsics.checkNotNullParameter("call onCreate", MessageIndication.MESSAGE_TYPE_MSG);
        this.k = 1;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void d() {
        if (this.k != 2) goto L88;
        boolean r10 = false;
        long r11 = 0;
        if (this.d == true) goto L31;
        if (this.n == false) goto L10;
    L13:
        boolean r0 = true;
    L14:
        this.n = r0;
        long r12 = System.currentTimeMillis();
        Long r1 = this.o;
        if (r1 == null) goto L17;
        long r13 = r1.longValue();
    L18:
        long r14 = r12 - r13;
        if (this.m >= 3) goto L26;
        if (r14 < u) goto L23;
    L24:
        this.q.b();
        f();
        goto L31
    L23:
        if (this.q.a() == false) goto L31;
    L26:
        if (r14 < u) goto L31;
        if (this.q.a() == false) goto L31;
        this.q.b();
        f();
        goto L31
    L17:
        r13 = 0;
        goto L18
    L10:
        if (this.q.a() == true) goto L13;
        r0 = false;
    L31:
        if (PdpMessageOpt.b.a() == false) goto L76;
        if (this.t == false) goto L76;
        if (this.m >= 3) goto L76;
        if (this.d == true) goto L76;
        int r15 = Build.VERSION.SDK_INT;
        if (r15 < 23) goto L41;
        MessageQueue r16 = Looper.getMainLooper().getQueue();
    L42:
        if (r16 == null) goto L72;
        Message r17 = BasePdpMessageOptWorker.a.a(BasePdpMessageOptWorker.j, r16);
        if (r17 == null) goto L72;
        Intrinsics.checkNotNullParameter(r17, com.bytedance.android.ec.core.event.a.KEY_MSG);
        if (r15 >= 28) goto L52;
        int r18 = r17.what;
        if (r18 != 103) goto L50;
    L65:
        boolean r19 = true;
    L67:
        if (r19 == false) goto L72;
        Intrinsics.checkNotNullParameter(r17, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Handler r20 = r17.getTarget();
        if (r20 == null) goto L71;
        Message r21 = Message.obtain(r17);
        r20.removeMessages(r17.what, r17.obj);
        r20.sendMessage(r21);
    L71:
        boolean r22 = true;
    L73:
        if (r22 == false) goto L76;
        r10 = true;
        goto L76
    L50:
        if (r18 == 104) goto L65;
    L66:
        r19 = false;
        goto L67
    L52:
        if (28 > r15) goto L66;
        if (34 < r15) goto L66;
        if (r17.what != 159) goto L66;
        Object r23 = BasePdpMessageOptWorker.a.b(r17);
        if (r23 == null) goto L61;
        String r24 = r23.getClass().getName();
    L62:
        if (r24 == null) goto L66;
        if (StringsKt.endsWith$default(r24, "StopActivityItem", false, 2, null) != true) goto L66;
    L61:
        r24 = null;
    L72:
        r22 = false;
        goto L73
    L41:
        r16 = null;
    L76:
        if (PdpMessageOpt.a == false) goto L82;
        StringBuilder r25 = new StringBuilder("call monitorMessage state=FIRST_FRAME delayStop=");
        r25.append(r10);
        r25.append(" noFrescoMsgFrameCount=");
        r25.append(this.p);
        r25.append(" hasPendingFrescoMessage=");
        r25.append(this.n);
        r25.append(" frameCount=");
        r25.append(this.m);
        r25.append(" hasScheduledForceDoFrame=");
        r25.append(this.d);
        r25.append(" duration=");
        r25.append(u);
        r25.append(" diff=");
        long r26 = System.currentTimeMillis();
        Long r27 = this.o;
        if (r27 == null) goto L80;
        r11 = r27.longValue();
    L80:
        r25.append(r26 - r11);
        PdpMessageOpt.e(r25.toString());
    L82:
        if (this.m < 10) goto L84;
    L85:
        i();
        return;
    L84:
        if (this.p >= 3) goto L85;
        return;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void i() {
        if (this.l == true) goto L5;
        return;
    L5:
        boolean r0 = PdpMessageOpt.a;
        Intrinsics.checkNotNullParameter("call stop", MessageIndication.MESSAGE_TYPE_MSG);
        if (this.a == false) goto L8;
        Looper.getMainLooper().setMessageLogging(this.b);
    L8:
        this.a = false;
        this.l = false;
        PdpMessageOptImageHelper r1 = this.q;
        r1.a = Boolean.FALSE;
        r1.b();
        Lazy r10 = UIUtils.a;
        UIUtils.e(new k(this));
    }

    public j(boolean r1) {
        this.t = r1;
        this.q = new PdpMessageOptImageHelper();
        this.s = new b(this);
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void a(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
        if (this.l == true) goto L5;
        return;
    L5:
        if (this.r == false) goto L13;
        PdpMessageOptImageHelper r1 = this.q;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "controller");
        PdpMessageOptImageHelper.b r0 = PdpMessageOptImageHelper.g;     // Catch: Exception -> L9
        HandlerExecutorServiceImpl r11 = r1.d;     // Catch: Exception -> L9
        r0.getClass();     // Catch: Exception -> L9
        PdpMessageOptImageHelper.b.a(r10, r11);     // Catch: Exception -> L9
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void c(boolean r10) {
        if (this.k < 2) goto L5;
        return;
    L5:
        boolean r0 = PdpMessageOpt.a;
        PdpMessageOpt.e("call onFirstFrame fromPreload=" + r10);
        if (r10 == false) goto L8;
        return;
    L8:
        this.k = 2;
        Choreographer.getInstance().postFrameCallback(this.s);
        if (this.l == false) goto L13;
        h();
        return;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void e(boolean r10) {
        boolean r0 = PdpMessageOpt.a;
        PdpMessageOpt.e("call onSubmitData fromPreload=" + r10);
        if (r10 == true) goto L7;
        PdpMessageOptImageHelper r11 = this.q;
        if (r11.a != null) goto L7;
        r11.a = Boolean.TRUE;
    L7:
        this.r = true;
    }
}
