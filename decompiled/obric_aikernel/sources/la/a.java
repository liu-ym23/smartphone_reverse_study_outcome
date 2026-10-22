package la;

import android.annotation.SuppressLint;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"StaticFieldLeak"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10917a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ka.a f10918b;

    static {
        f10917a = new a();
    }

    private a() {
    }

    public final ka.a a() {
        return f10918b;
    }

    public final void b(Context r10) {
    }

    public final void c(ka.a r10) {
        Intrinsics.checkNotNullParameter(r10, "logger");
        f10918b = r10;
    }
}
