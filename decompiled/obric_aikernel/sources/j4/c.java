package j4;

import androidx.annotation.NonNull;
import f4.h;
import f4.i;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, d> f9765a = null;

    static {
        f9765a = new ConcurrentHashMap();
    }

    public c() {
    }

    @Override // f4.i
    public h a(@NonNull String r10, boolean r11) {
        ConcurrentHashMap<String, d> r12 = f9765a;
        d r13 = r12.get(r10);
        if (r13 == null) goto L5;
        return r13;
    L5:
        d r14 = new d(com.bytedance.news.common.settings.internal.b.b(), r10, r11);
        r12.put(r10, r14);
        return r14;
    }

    @Override // f4.i
    public h b(@NonNull String r10) {
        return a(r10, false);
    }
}
