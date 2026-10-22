package ai;

import java.util.concurrent.Executor;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f180a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f181b = false;

    static {
        boolean r5 = true;
        Class.forName("android.os.Build");     // Catch: ClassNotFoundException -> L5
        b0 r10 = new z(0);     // Catch: ClassNotFoundException -> L5
    L8:
        f180a = r10;
        new Retrofit.Builder();     // Catch: NoClassDefFoundError -> L11
    L12:
        f181b = r5;
        return;
    L11:
        r5 = false;
    L5:
        Class.forName("org.robovm.apple.foundation.NSObject");     // Catch: ClassNotFoundException -> L7
        r10 = new z(1);     // Catch: ClassNotFoundException -> L7
    L7:
        r10 = new b0();
        goto L8
    }

    public d a(Executor r5) {
        if (r5 == null) goto L6;
        return new m(r5);
    L6:
        return j.f238a;
    }

    public Executor b() {
        return null;
    }
}
