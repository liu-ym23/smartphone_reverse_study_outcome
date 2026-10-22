package yh8;

import com.larus.im.bean.message.Message;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements yh8.a {
    public static final c a = null;
    public static volatile Message b;
    public static volatile String c;
    public static final ArrayList<a> d = null;

    public interface a {
        void a();
    }

    public c() {
    }

    @Override // yh8.a
    public final synchronized void a() {
        monitor-enter(this);
        b = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static {
        a = new c();
        c = "";
        d = new ArrayList();
    }

    @Override // yh8.a
    public final Message b() {
        return b;
    }
}
