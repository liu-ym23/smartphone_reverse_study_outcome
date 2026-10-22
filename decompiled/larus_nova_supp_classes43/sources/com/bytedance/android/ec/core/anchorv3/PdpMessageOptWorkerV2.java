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
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PdpMessageOptWorkerV2 extends BasePdpMessageOptWorker {
    public int k;
    public boolean l;
    public int m;
    public final PdpMessageOptImageHelper n;
    public volatile boolean o;
    public Message p;
    public Long q;
    public final b r;
    public final boolean s;

    public static final class a {
    }

    public static final class b implements Choreographer.FrameCallback {
        public final /* synthetic */ PdpMessageOptWorkerV2 a;

        public b(PdpMessageOptWorkerV2 r1) {
            this.a = r1;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r10) {
            PdpMessageOptWorkerV2 r11 = this.a;
            r11.d = false;
            int r12 = r11.k;
            if (r12 < 3) goto L6;
            r11.m++;
        L6:
            if (r11.l == false) goto L9;
            if (r12 <= 1) goto L9;
            r11.j();
        L9:
            boolean r13 = PdpMessageOpt.a;
            PdpMessageOpt.e("doFrame count=" + this.a.m);
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void g() {
        this.l = true;
        if (this.s == true) goto L5;
        return;
    L5:
        if (PdpMessageOpt.c() == true) goto L7;
        return;
    L7:
        if (this.l == false) goto L13;
        h();
        return;
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void b() {
        boolean r0 = PdpMessageOpt.a;
        Intrinsics.checkNotNullParameter("call onCreate", MessageIndication.MESSAGE_TYPE_MSG);
        this.k = 1;
        Boolean r1 = PdpMessageOpt.b.c();
        if (r1 == null) goto L5;
        boolean r10 = r1.booleanValue();
    L6:
        if (r10 == false) goto L9;
        f();
        j();
        return;
    L9:
        return;
    L5:
        r10 = PdpMessageOpt.c();
        goto L6
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void d() {
        int r0 = this.k;
        if (r0 == 0) goto L26;
        if (r0 != 2) goto L7;
        boolean r1 = this.n.a();
        if (r1 == false) goto L23;
        this.n.b();
        f();
    L23:
        if (PdpMessageOpt.a == false) goto L99;
        PdpMessageOpt.e("call monitorMessage state=PRELOAD_RENDER hasPendingMsg=" + r1);
        return;
    L99:
        return;
    L7:
        if (r0 != 3) goto L104;
        boolean r10 = this.n.a();
        if (this.m >= 3) goto L14;
        if (r10 == false) goto L13;
        this.n.b();
    L13:
        f();
    L17:
        if (PdpMessageOpt.a == false) goto L97;
        PdpMessageOpt.e("call monitorMessage state=STATE_FULL_RENDER hasPendingMsg=" + r10 + " frameCount=" + this.m);
        return;
    L97:
        return;
    L14:
        if (r10 == false) goto L17;
        this.n.b();
        f();
        goto L17
    L104:
        return;
    L26:
        if (this.s == true) goto L28;
        return;
    L28:
        if (PdpMessageOpt.c() == false) goto L102;
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = null;
        final Ref.IntRef r12 = new Ref.IntRef();
        int r13 = 0;
        r12.element = 0;
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = null;
        Message r15 = this.p;
        Long r16 = this.q;
        Function2<Message, Integer, Boolean> r17 = new PdpMessageOptWorkerV2$onMonitorMessage$1(this, r14, r11, r12);
        Intrinsics.checkNotNullParameter(r17, "action");
        if (Build.VERSION.SDK_INT < 23) goto L32;
        MessageQueue r18 = Looper.getMainLooper().getQueue();
    L33:
        if (r18 == null) goto L74;
        if (r15 == null) goto L45;
        long r19 = r15.getWhen();
        if (r16 != null) goto L40;
    L42:
        boolean r20 = false;
    L43:
        if (r20 == false) goto L45;
    L46:
        if (r15 != null) goto L92;
        r15 = BasePdpMessageOptWorker.a.a(BasePdpMessageOptWorker.j, r18);
        if (r15 == null) goto L74;
    L92:
        monitor-enter(r18);     // Catch: Exception -> L73
    L51:
        if (r15 == null) goto L67;
    L70:
        th = move-exception;
        throw th;     // Catch: Exception -> L73
    L53:
        if (((Boolean) r17.invoke(r15, Integer.valueOf(r13))).booleanValue() == true) goto L67;
        BasePdpMessageOptWorker.j.getClass();     // Catch: Throwable -> L70
        Field r21 = (Field) BasePdpMessageOptWorker.h.getValue();     // Catch: Exception -> L65 Throwable -> L70
        if (r21 == null) goto L59;
        Object r22 = r21.get(r15);     // Catch: Exception -> L65 Throwable -> L70
    L61:
        if ((r22 instanceof Message) == true) goto L63;
        r22 = null;
    L63:
        r15 = (Message) r22;     // Catch: Exception -> L65 Throwable -> L70
    L66:
        r13 = r13 + 1;
        goto L51
    L59:
        r22 = null;
    L65:
        r15 = null;
    L67:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L70
        monitor-exit(r18);     // Catch: Exception -> L73
        goto L74
        goto L74
    L40:
        if (r19 != r16.longValue()) goto L42;
        r20 = true;
    L45:
        r15 = null;
    L74:
        Message r24 = (Message) r14.element;
        if (r24 == null) goto L80;
        Intrinsics.checkNotNullParameter(r24, com.bytedance.android.ec.core.event.a.KEY_MSG);
        Handler r25 = r24.getTarget();
        if (r25 == null) goto L80;
        Message r26 = Message.obtain(r24);
        r25.removeMessages(r24.what, r24.obj);
        r25.sendMessageAtFrontOfQueue(r26);
    L80:
        if (PdpMessageOpt.a == false) goto L103;
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L83
        PdpMessageOpt.e("call monitorMessage state=INIT messageToMove=" + ((Message) r14.element) + " loopTimes=" + r12.element);     // Catch: Throwable -> L83
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L83
        return;
    L83:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L103:
        return;
    L32:
        r18 = null;
        goto L33
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
        PdpMessageOptImageHelper r1 = this.n;
        r1.a = Boolean.FALSE;
        r1.b();
        Lazy r10 = UIUtils.a;
        UIUtils.e(new l(this));
    }

    public final void j() {
        Choreographer.getInstance().removeFrameCallback(this.r);
        Choreographer.getInstance().postFrameCallback(this.r);
    }

    public PdpMessageOptWorkerV2(boolean r1) {
        this.s = r1;
        this.n = new PdpMessageOptImageHelper();
        this.r = new b(this);
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void a(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
        if (this.l == true) goto L5;
        return;
    L5:
        if (this.o == false) goto L13;
        PdpMessageOptImageHelper r1 = this.n;
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
        if (this.k < 3) goto L5;
        return;
    L5:
        boolean r0 = PdpMessageOpt.a;
        PdpMessageOpt.e("call onFirstFrame fromPreload=" + r10);
        if (r10 == true) goto L8;
        this.k = 3;
    L12:
        j();
        h();
        return;
    L8:
        if (PdpMessageOpt.d() == true) goto L10;
        return;
    L10:
        this.k = 2;
        goto L12
    }

    @Override // com.bytedance.android.ec.core.anchorv3.BasePdpMessageOptWorker
    public final void e(boolean r10) {
        boolean r0 = PdpMessageOpt.a;
        PdpMessageOpt.e("call onSubmitData fromPreload=" + r10);
        if (PdpMessageOpt.d() == true) goto L6;
        if (r10 == false) goto L6;
        return;
    L6:
        PdpMessageOptImageHelper r11 = this.n;
        if (r11.a != null) goto L9;
        r11.a = Boolean.TRUE;
    L9:
        this.o = true;
    }
}
