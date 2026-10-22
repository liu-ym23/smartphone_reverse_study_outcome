package r7;

import com.obric.aikernel.middleware.api.obric.IAssistantStateService;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IAssistantStateService f12700a = null;

    static {
        f12700a = (IAssistantStateService) d4.a.a(Reflection.getOrCreateKotlinClass(IAssistantStateService.class));
    }

    public static final IAssistantStateService a() {
        return f12700a;
    }
}
