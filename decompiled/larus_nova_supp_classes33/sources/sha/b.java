package sha;

import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningMainProcessManager;
import com.obric.assistant.activation.presentation.runtime.manager.k1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, sha.a] */
    static {
        ObricListeningMainProcessManager r0 = ObricListeningMainProcessManager.a;
        ?? r1 = new a();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "handler");
        ObricListeningMainProcessManager.k(new k1(r1));
    }

    public static boolean a() {
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.c r0 = (ObricListeningMainProcessManager.c) ObricListeningMainProcessManager.t.get();
        if (r0 == null) goto L11;
        if (r0.b == true) goto L8;
        return false;
    L8:
        if (r0.c.isValid() == false) goto L11;
        return true;
    L11:
        return ObricListeningMainProcessManager.f;
    }

    public static boolean b() {
        ObricListeningMainProcessManager.a.getClass();
        ObricListeningMainProcessManager.c r0 = (ObricListeningMainProcessManager.c) ObricListeningMainProcessManager.t.get();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L12:
        boolean r2 = ObricListeningMainProcessManager.f;
        ObricListeningVisualMode r4 = ObricListeningMainProcessManager.g.e.a;
        Intrinsics.checkNotNullParameter(r4, "visualMode");
        if (r2 == true) goto L15;
    L17:
        r1 = false;
    L19:
        return r1;
    L15:
        if (r4 == ObricListeningVisualMode.HIDDEN) goto L17;
    L5:
        if (r0.b == true) goto L8;
        return false;
    L8:
        if (r0.c.isValid() == false) goto L12;
        ObricListeningVisualMode r3 = r0.c.e.a;
        Intrinsics.checkNotNullParameter(r3, "visualMode");
        if (r3 == ObricListeningVisualMode.HIDDEN) goto L17;
        goto L17
    }
}
