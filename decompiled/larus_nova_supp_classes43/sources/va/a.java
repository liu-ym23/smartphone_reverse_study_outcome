package va;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.ai.event.MessageIndication;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final C0207a g = null;
    public static volatile a h;
    public final String a;
    public b b;
    public boolean c;
    public va.b d;
    public d e;
    public c f;

    /* JADX INFO: renamed from: va.a$a, reason: collision with other inner class name */
    public static final class C0207a {
        public final a a() {
            a r0 = a.h;
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = a.h;     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new a();     // Catch: Throwable -> L10
            a.h = r0;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }

        public C0207a() {
        }
    }

    public static final class b extends Handler {
        public final /* synthetic */ a a;

        @Override // android.os.Handler
        public final void handleMessage(Message r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            switch(r10.what) {
                case 1: goto L26;
                case 2: goto L23;
                case 3: goto L20;
                case 4: goto L17;
                case 5: goto L14;
                case 6: goto L45;
                case 7: goto L11;
                case 8: goto L8;
                case 9: goto L5;
                default: goto L45;
            };
        L5:
            c r0 = this.a.f;
            if (r0 == null) goto L30;
            r0.b(r10);
            return;
        L30:
            return;
        L8:
            c r1 = this.a.f;
            if (r1 == null) goto L32;
            r1.c(r10);
            return;
        L32:
            return;
        L11:
            c r11 = this.a.f;
            if (r11 == null) goto L34;
            r11.a(r10);
            return;
        L34:
            return;
        L14:
            d r12 = this.a.e;
            if (r12 == null) goto L36;
            r12.a(r10);
            return;
        L36:
            return;
        L17:
            d r13 = this.a.e;
            if (r13 == null) goto L38;
            r13.b(r10);
            return;
        L38:
            return;
        L20:
            va.b r14 = this.a.d;
            if (r14 == null) goto L40;
            r14.b(r10);
            return;
        L40:
            return;
        L23:
            va.b r15 = this.a.d;
            if (r15 == null) goto L42;
            r15.c(r10);
            return;
        L42:
            return;
        L26:
            va.b r16 = this.a.d;
            if (r16 == null) goto L44;
            r16.a(r10);
            return;
        L44:
            return;
        }

        public b(a r1, Looper r10) {
            this.a = r1;
            super(r10);
        }
    }

    static {
        g = new C0207a();
    }

    public a() {
        Intrinsics.checkNotNullParameter("AnnieX-AI", com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        this.a = "AnnieX-AI";
    }

    public final void a() {
        if (this.c == true) goto L5;
    L7:
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2(this.a, 0);
        ThreadMethodProxy.start(r0);
        this.b = new b(this, r0.getLooper());
        this.c = true;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
    }
}
