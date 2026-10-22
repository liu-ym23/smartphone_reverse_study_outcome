package ye;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        EnsureManager.ensureNotReachHere("EC_SDK " + r10);
    }

    public static void b(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, "throwable");
        EnsureManager.ensureNotReachHere(r1, "EC_SDK ");
    }
}
