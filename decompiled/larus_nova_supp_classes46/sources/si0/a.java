package si0;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final int a;
    public b b;
    public final Handler c;
    public final c d;

    /* JADX INFO: renamed from: si0.a$a, reason: collision with other inner class name */
    public static final class C0269a {
    }

    public interface b {
        void a();
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ALogger.i("CustomVideoMixerDetector", "detectFirstFrameTask run");     // Catch: Throwable -> L6
            this.a.getClass();     // Catch: Throwable -> L6
            ALogger.e("CustomVideoMixerDetector", "detectFirstFrameTask failed");     // Catch: Throwable -> L6
            b r0 = this.a.b;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public a() {
        this.a = ((Number) vm2.d.r3.getValue(null, vm2.d.a[223(0xdf, float:3.12E-43)])).intValue();
        this.c = new Handler(Looper.getMainLooper());
        this.d = new c(this);
    }
}
