package j4;

import androidx.annotation.NonNull;
import com.bytedance.news.common.settings.internal.h;
import f4.i;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f9762b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f9763c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f9764a;

    static {
        f9762b = new ConcurrentHashMap();
    }

    private b(i r10) {
        this.f9764a = r10;
    }

    public static b c(i r10) {
        if (f9763c != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9763c != null) goto L9;
        f9763c = new b(r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f9763c;
    }

    @Override // f4.i
    public f4.h a(@NonNull String r10, boolean r11) {
        ConcurrentHashMap<String, a> r12 = f9762b;
        a r13 = r12.get(r10);
        if (r13 == null) goto L5;
        return r13;
    L5:
        a r14 = new a(r10, this.f9764a.b(r10));
        r12.put(r10, r14);
        return r14;
    }

    @Override // f4.i
    public f4.h b(@NonNull String r10) {
        return a(r10, false);
    }
}
