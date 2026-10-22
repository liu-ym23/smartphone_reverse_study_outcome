package r2;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import mn.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f21643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f21644b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f21645c = null;
    public static volatile Application d;
    public static volatile a e;
    public static String f;
    public static final j g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f3.a f21646h = null;

    static {
        f21643a = new b();
        f21644b = new AtomicBoolean(false);
        f21645c = new Handler(Looper.getMainLooper());
        f = "init";
        g = new j(1);
        f21646h = new f3.a(4);
    }
}
