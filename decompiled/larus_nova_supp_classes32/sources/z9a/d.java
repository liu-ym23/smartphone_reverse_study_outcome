package z9a;

import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import kotlin.jvm.internal.Intrinsics;
import v9a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements a {
    public static final d a = null;
    public static final a b = null;

    public d() {
    }

    static {
        a = new d();
    L15:
        th = move-exception;
        ILogDepend.a.e("VibrateFeedback", "init failed", th);
    L17:
        b = (a) ServiceManager.get().getService(a.class, false);
        return;
    L4:
        if (f.h.a().b() == false) goto L21;
        ServiceManager.get().bind(a.class, new SingletonProvider(new b()));     // Catch: Throwable -> L7
        ILogDepend.a.i("VibrateFeedback", "bind PacificVibrateFeedback");     // Catch: Throwable -> L7
    L23:
    L7:
        th = move-exception;
        ILogDepend.a.e("VibrateFeedback", "bind PacificVibrateFeedback failed", th);     // Catch: Throwable -> L15
        goto L23
    L21:
        ServiceManager.get().bind(a.class, new SingletonProvider(new c()));     // Catch: Throwable -> L12
        ILogDepend.a.i("VibrateFeedback", "bind CommonVibrateFeedback");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        ILogDepend.a.e("VibrateFeedback", "bind CommonVibrateFeedback failed", th);     // Catch: Throwable -> L15
        goto L23
    }

    @Override // z9a.a
    public final void a(FeedbackType r2) {
        Intrinsics.checkNotNullParameter(r2, "feedbackType");
        a r0 = b;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
