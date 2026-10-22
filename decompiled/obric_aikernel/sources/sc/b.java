package sc;

import android.text.TextUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.x;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f12806b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<String> f12807a;

    public b() {
        this.f12807a = new CopyOnWriteArrayList();
    }

    public static b a() {
        if (f12806b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12806b != null) goto L9;
        f12806b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f12806b;
    }

    public void b(x r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.l() != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10.l().h()) == true) goto L16;
        String r12 = r10.l().h();
        CopyOnWriteArrayList<String> r13 = this.f12807a;
        if (r11 == false) goto L11;
        r13.add(r12);
        return;
    L11:
        r13.remove(r12);
        return;
    }
}
