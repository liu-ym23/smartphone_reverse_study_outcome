package olc;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Handler.Callback {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r3) {
        b r4 = this.a;
        ReentrantLock r0 = r4.b;
        r0.lock();
        Iterator<Bitmap> r5 = r4.a.descendingIterator();     // Catch: Throwable -> L11
        if (r5.hasNext() == true) goto L7;
        r5 = null;
    L7:
        if (r5 == null) goto L9;
        r5.next().recycle();     // Catch: Throwable -> L11
        r5.remove();     // Catch: Throwable -> L11
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        r0.unlock();
        this.a.b();
        return true;
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
