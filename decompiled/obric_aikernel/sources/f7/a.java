package f7;

import android.annotation.SuppressLint;
import com.obric.aikernel.sdk.AIKernelConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8866a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static AIKernelConfig f8867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f8868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f8869d;

    static {
        f8866a = new a();
        f8868c = "";
    }

    private a() {
    }

    public final AIKernelConfig a() {
        return f8867b;
    }

    public final String b() {
        return f8868c;
    }

    public final boolean c() {
        return f8869d;
    }

    public final void d(AIKernelConfig r10) {
        f8867b = r10;
    }

    public final void e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        f8868c = r10;
    }

    public final void f(boolean r10) {
        f8869d = r10;
    }
}
