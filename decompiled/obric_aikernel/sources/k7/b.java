package k7;

import com.obric.aikernel.isolate.api.IIsolateApi;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IIsolateApi f10131a = null;

    static {
        f10131a = (IIsolateApi) d4.a.a(Reflection.getOrCreateKotlinClass(IIsolateApi.class));
    }

    public static final IIsolateApi a() {
        return f10131a;
    }
}
