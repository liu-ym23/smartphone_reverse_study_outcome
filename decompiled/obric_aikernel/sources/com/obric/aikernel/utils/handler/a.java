package com.obric.aikernel.utils.handler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f5598b;

    /* JADX INFO: renamed from: com.obric.aikernel.utils.handler.a$a, reason: collision with other inner class name */
    public static final class C0122a {
        private C0122a() {
        }

        public /* synthetic */ C0122a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f5599a;

        public b(a r10, Looper r11) {
            Intrinsics.checkNotNullParameter(r11, "looper");
            this.f5599a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            Intrinsics.checkNotNullParameter(r10, "message");
            if (r10.what == 1) goto L6;
            AIKLog r11 = AIKLog.INSTANCE;
            String r12 = a.a(this.f5599a);
            Intrinsics.checkNotNull(r12);
            r11.e(r12, "unHandled msg : " + r10.what);
            return;
        L6:
            Object r13 = r10.obj;
            Intrinsics.checkNotNullExpressionValue(r13, "message.obj");
            if ((r13 instanceof Runnable) == true) goto L9;
            AIKLog r14 = AIKLog.INSTANCE;
            String r15 = a.a(this.f5599a);
            Intrinsics.checkNotNull(r15);
            r14.e(r15, "it's not instanceOf Runnable");
            return;
        L9:
            ((Runnable) r13).run();
        }
    }

    static {
        new C0122a(null);
    }

    public a() {
        this.f5597a = b();
        Looper r10 = c();
        if (r10 != null) goto L5;
        AIKLog r11 = AIKLog.INSTANCE;
        String r12 = this.f5597a;
        Intrinsics.checkNotNull(r12);
        r11.e(r12, "initHandler: getLooper is null");
        return;
    L5:
        new b(this, r10);
    }

    public static final /* synthetic */ String a(a r10) {
        return r10.f5597a;
    }

    protected abstract String b();

    public final synchronized Looper c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f5598b != null) goto L6;
        HandlerThread r10 = new HandlerThread(b());     // Catch: Throwable -> L9
        this.f5598b = r10;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L9
        r10.setDaemon(true);     // Catch: Throwable -> L9
        HandlerThread r11 = this.f5598b;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L9
        r11.start();     // Catch: Throwable -> L9
    L6:
        HandlerThread r12 = this.f5598b;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L9
        Looper r13 = r12.getLooper();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r13;
    }
}
