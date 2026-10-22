package z6a;

import android.graphics.Picture;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u extends PthreadHandlerThreadV2 {

    public static final class a extends Handler {
        public final Picture a;

        public a(Looper r1) {
            super(r1);
            Picture r2 = new Picture();     // Catch: RuntimeException -> L5
        L6:
            this.a = r2;
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r4) {
            if (this.a != null) goto L13;
            return;
        L13:
            if (r4.what != 0) goto L15;
            Layout r5 = (Layout) ((WeakReference) r4.obj).get();     // Catch: Exception -> L12
            if (r5 != null) goto L10;
            return;
        L10:
            r5.draw(this.a.beginRecording(r5.getWidth(), r5.getHeight()));     // Catch: Exception -> L12
            this.a.endRecording();     // Catch: Exception -> L12
            return;
        L15:
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u() {
        super("TextLayoutWarmer", 10);
        ThreadMethodProxy.start(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLooperPrepared() {
        super/*android.os.HandlerThread*/.onLooperPrepared();
        new a(Looper.myLooper());
    }
}
