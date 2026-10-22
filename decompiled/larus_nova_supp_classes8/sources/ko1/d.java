package ko1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.ViewConfiguration;
import com.bytedance.android.livesdk.config.LiveGestureConfig;
import com.bytedance.android.livesdk.config.qy;
import com.bytedance.common.utility.reflect.Reflect;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public boolean a;
    public final LiveGestureConfig b;
    public final int c;
    public final a d;
    public final c e;

    public static final class a extends Handler {
        public final /* synthetic */ d a;
        public final /* synthetic */ Handler b;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            this.b.handleMessage(r2);
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message r6, long r7) {
            Intrinsics.checkNotNullParameter(r6, "msg");
            if (this.a.b.b() == false) goto L21;
            if (this.a.a == false) goto L21;
            if (Intrinsics.areEqual(r6.getCallback(), this.a.e) == true) goto L21;
            if (r6.what != 2) goto L21;
            if ((r7 - SystemClock.uptimeMillis()) <= 100) goto L21;
            int r0 = this.a.b.a();
            int r1 = this.a.c;
            if (r0 <= r1) goto L21;
            r7 = r7 + ((long) (r0 - r1));
        L21:
            return super.sendMessageAtTime(r6, r7);
        }

        public a(d r1, Handler r2, Looper r3) {
            this.a = r1;
            this.b = r2;
            super(r3);
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public d(GestureDetector r5) {
        Intrinsics.checkNotNullParameter(r5, "detector");
        this.b = qy.a.getValue();
        this.c = ViewConfiguration.getLongPressTimeout();
        Reflect r6 = Reflect.on(r5);     // Catch: Exception -> L15
        if (r6 != null) goto L7;
        Handler r1 = null;
    L9:
        if (r1 == null) goto L13;
        a r2 = new a(this, r1, r1.getLooper());     // Catch: Exception -> L15
        this.d = r2;     // Catch: Exception -> L15
        if (r6 == null) goto L13;
        r6.set("mHandler", r2);     // Catch: Exception -> L15
        goto L13
    L7:
        r1 = (Handler) r6.get("mHandler", new Class[0]);     // Catch: Exception -> L15
    L13:
        this.e = new c(this);
    }
}
