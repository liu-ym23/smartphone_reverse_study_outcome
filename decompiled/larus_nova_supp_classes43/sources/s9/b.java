package s9;

import android.content.Context;
import android.os.MessageQueue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements MessageQueue.IdleHandler {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ e e;

    public b(Context r1, String r10, String r11, int r12, e r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        ConcurrentHashMap<Integer, f> r0 = a.a;
        a.c(this.a, this.b, this.c, this.d, this.e);
        return false;
    }
}
