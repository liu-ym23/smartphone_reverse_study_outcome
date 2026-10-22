package av;

import java.util.regex.Pattern;
import org.sqlite.core.NativeDB;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f785c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f787b;

    static {
        f785c = Pattern.compile("restore(\\s+(\"[^\"]*\"|'[^']*'|\\S+))?\\s+from\\s+(\"[^\"]*\"|'[^']*'|\\S+)", 2);
    }

    public b(String r5, String r10) {
        this.f786a = r5;
        this.f787b = r10;
    }

    @Override // av.c
    public final void a(NativeDB r5) {
        String r10 = this.f786a;
        String r11 = this.f787b;
        monitor-enter(r5);
        r5.restore(NativeDB.o(r10), NativeDB.o(r11), null);     // Catch: Throwable -> L7
        monitor-exit(r5);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
