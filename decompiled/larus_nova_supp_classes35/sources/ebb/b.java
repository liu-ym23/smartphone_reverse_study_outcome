package ebb;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.diskmanage.Biz;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final /* synthetic */ int c = 0;
    public final ConcurrentHashMap<Biz, g> a;
    public final ExecutorService b;

    public static final class a {
    }

    /* JADX INFO: renamed from: ebb.b$b, reason: collision with other inner class name */
    public static final class C0218b {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    static {
    }

    public b() {
        this.a = new ConcurrentHashMap();
        this.b = CoreThreadPool.getDefault().newSerialIODensityThreadPool("lk-disk-clean");
    }
}
