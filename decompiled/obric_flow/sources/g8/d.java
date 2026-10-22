package g8;

import android.os.HandlerThread;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.message.PushThreadHandlerManager;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d f17064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakHandler f17065b;

    public d() {
        if (f17065b != null) goto L10;
        f17065b = PushThreadHandlerManager.inst().getHandler();     // Catch: Throwable -> L6
        return;
    L6:
        HandlerThread r5 = new HandlerThread("WsHT");
        r5.start();
        f17065b = new WeakHandler(r5.getLooper(), this);
        return;
    }

    public static d a() {
        if (f17064a != null) goto L16;
        monitor-enter(d.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f17064a != null) goto L11;
        f17064a = new d();     // Catch: Throwable -> L9
    L11:
        monitor-exit(d.class);     // Catch: Throwable -> L9
    L16:
        return f17064a;
    }
}
