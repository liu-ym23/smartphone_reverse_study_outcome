package h8;

import com.obric.aikernel.tob.api.IToBStrategyManager;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IToBStrategyManager f9195a = null;

    static {
        f9195a = (IToBStrategyManager) d4.a.a(Reflection.getOrCreateKotlinClass(IToBStrategyManager.class));
    }

    public static final IToBStrategyManager a() {
        return f9195a;
    }
}
