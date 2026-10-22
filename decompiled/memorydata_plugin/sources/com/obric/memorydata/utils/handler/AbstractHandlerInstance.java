package com.obric.memorydata.utils.handler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b'\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H$J\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u001b\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u001c\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/utils/handler/AbstractHandlerInstance;", "", "<init>", "()V", "logTag", "", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThreadName", "getLooper", "Landroid/os/Looper;", "postDelay", "", "runnable", "Ljava/lang/Runnable;", OaidModel.KEY_TIME, "", "removeCallbacks", "removeMsg", "removeMsgId", "msgId", "", "sendMsg", "sendMsgDelay", "delay", "sendMsgFast", "removeCallbacksAndMessages", "token", "Companion", "MyHandler", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractHandlerInstance {
    public static final a Companion = null;
    public static final int MSG_DO = 1;
    private Handler handler;
    private HandlerThread handlerThread;
    private String logTag;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/utils/handler/AbstractHandlerInstance$Companion;", "", "<init>", "()V", "MSG_DO", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/utils/handler/AbstractHandlerInstance$MyHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "<init>", "(Lcom/obric/memorydata/utils/handler/AbstractHandlerInstance;Landroid/os/Looper;)V", "handleMessage", "", "message", "Landroid/os/Message;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractHandlerInstance f13227a;

        public b(AbstractHandlerInstance r2, Looper r3) {
            Intrinsics.checkNotNullParameter(r3, "looper");
            this.f13227a = r2;
            super(r3);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r7) {
            Intrinsics.checkNotNullParameter(r7, "message");
            Object r8 = r7.obj;
            Intrinsics.checkNotNullExpressionValue(r8, "obj");
            if (ZeusTransformUtils.instanceOf(r8, Runnable.class) == true) goto L5;
            IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            String r1 = AbstractHandlerInstance.access$getLogTag$p(this.f13227a);
            Intrinsics.checkNotNull(r1);
            IRunLog.a.b(r0, r1, "it's not instanceOf Runnable", null, 4, null);
            return;
        L5:
            ((Runnable) ZeusTransformUtils.preCheckCast(r8, Runnable.class, "com.obric.memorydata.plugin")).run();
        }
    }

    static {
        Companion = new a(null);
    }

    public AbstractHandlerInstance() {
        this.logTag = getHandlerThreadName();
        Looper r0 = getLooper();
        if (r0 != null) goto L5;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r2 = this.logTag;
        Intrinsics.checkNotNull(r2);
        IRunLog.a.b(r1, r2, "initHandler: getLooper is null", null, 4, null);
        return;
    L5:
        this.handler = (Handler) ZeusTransformUtils.preCheckCast(new b(this, r0), Handler.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ String access$getLogTag$p(AbstractHandlerInstance r0) {
        return r0.logTag;
    }

    public abstract String getHandlerThreadName();

    public final synchronized Looper getLooper() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.handlerThread != null) goto L6;
        HandlerThread r0 = new HandlerThread(getHandlerThreadName());     // Catch: Throwable -> L9
        this.handlerThread = r0;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L9
        r0.setDaemon(true);     // Catch: Throwable -> L9
        HandlerThread r1 = this.handlerThread;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L9
        r1.start();     // Catch: Throwable -> L9
    L6:
        HandlerThread r2 = this.handlerThread;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L9
        Looper r3 = r2.getLooper();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r3;
    }

    public final void postDelay(long r3, Runnable r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "runnable");
        Handler r2 = this.handler;
        if (r2 == null) goto L6;
        r2.postDelayed(r6, r3);
        return;
    }

    @Deprecated(message = "请使用尾随 Lambda 表达式对应的方法")
    public final void postDelay(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "runnable");
        Handler r2 = this.handler;
        if (r2 == null) goto L6;
        r2.postDelayed(r5, r4);
        return;
    }

    public final void removeCallbacks(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "runnable");
        Handler r2 = this.handler;
        if (r2 == null) goto L6;
        r2.removeCallbacks(r4);
        return;
    }

    public final void removeCallbacksAndMessages(Object r1) {
        Handler r0 = this.handler;
        if (r0 == null) goto L6;
        r0.removeCallbacksAndMessages(r1);
        return;
    }

    public final void removeMsg() {
        Handler r1 = this.handler;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNull(r1);
        r1.removeMessages(1);
        return;
    }

    public final void removeMsgId(int r1) {
        Handler r0 = this.handler;
        if (r0 == null) goto L6;
        r0.removeMessages(r1);
        return;
    }

    public final void sendMsg(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Handler r2 = this.handler;
        if (r2 == null) goto L8;
        Message r5 = r2.obtainMessage(1, r4);
        if (r5 == null) goto L9;
        r5.sendToTarget();
        return;
    L9:
        return;
    }

    public final void sendMsgDelay(int r3, long r4, Runnable r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "runnable");
        Message r0 = Message.obtain();
        r0.what = r3;
        r0.obj = r7;
        Handler r2 = this.handler;
        if (r2 == null) goto L6;
        r2.sendMessageDelayed(r0, r4);
        return;
    }

    public void sendMsgDelay(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "runnable");
        Handler r2 = this.handler;
        if (r2 == null) goto L6;
        Intrinsics.checkNotNull(r2);
        r2.sendMessageDelayed(r2.obtainMessage(1, r5), r4);
        return;
    }

    public final void sendMsgFast(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        Handler r2 = this.handler;
        if (r2 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(Looper.myLooper(), r2.getLooper()) == false) goto L10;
        r4.run();
        return;
    L10:
        r2.obtainMessage(1, r4).sendToTarget();
    }
}
