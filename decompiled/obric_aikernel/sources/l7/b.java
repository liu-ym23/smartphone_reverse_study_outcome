package l7;

import com.obric.aikernel.memory_collect.api.MemoryCollectApi;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final MemoryCollectApi f10909a = null;

    static {
        f10909a = (MemoryCollectApi) d4.a.a(Reflection.getOrCreateKotlinClass(MemoryCollectApi.class));
    }

    public static final MemoryCollectApi a() {
        return f10909a;
    }
}
