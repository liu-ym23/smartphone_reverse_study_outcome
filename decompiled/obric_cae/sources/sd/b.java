package sd;

import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f12110b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakHandler f12111a;

    public b() {
        HandlerThread r8 = new HandlerThread("PushThreadHandler");
        r8.start();
        this.f12111a = new WeakHandler(r8.getLooper(), this);
    }

    public static b a() {
        if (f12110b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12110b != null) goto L9;
        f12110b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f12110b;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r8) {
    }
}
