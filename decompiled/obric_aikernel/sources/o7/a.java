package o7;

import com.obric.aikernel.middleware.api.commonmonitor.IApmManager;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IApmManager f11501a = null;

    static {
        f11501a = (IApmManager) d4.a.a(Reflection.getOrCreateKotlinClass(IApmManager.class));
    }

    public static final IApmManager a() {
        return f11501a;
    }
}
