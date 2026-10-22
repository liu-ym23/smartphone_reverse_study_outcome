package a3;

import android.os.Handler;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f83a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f84b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f85c = null;
    public static final k d = null;
    public static final com.bytedance.sdk.xbridge.cn.auth.g e = null;
    public static final com.lynx.tasm.behavior.d f = null;
    public static final com.lynx.tasm.utils.c g = null;

    static {
        f83a = new i();
        f84b = new LinkedHashMap();
        f85c = LazyKt.lazy(new f(0));
        d = new k();
        e = new com.bytedance.sdk.xbridge.cn.auth.g(1);
        f = new com.lynx.tasm.behavior.d(1);
        g = new com.lynx.tasm.utils.c(1);
    }

    public static void a(Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "runnable");
        ((Handler) f85c.getValue()).post(new g(0, r5));
    }
}
