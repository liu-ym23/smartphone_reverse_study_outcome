package k1;

import android.content.Context;
import com.bytedance.ai.model.LynxWorkerRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.lynx.tasm.t;
import com.lynx.tasm.u;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f18579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxWorkerRuntime f18580b;

    public a(Context r5, Applet r10, Map r11) {
        Intrinsics.checkNotNullParameter(r5, "appContext");
        Intrinsics.checkNotNullParameter(r10, "applet");
        t r12 = new t();
        r12.f10963c = r10.i();
        r12.f10962b = true;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        AtomicBoolean r13 = s0.a.f21798a;
        u r14 = new u(r12);
        this.f18579a = r14;
        this.f18580b = new LynxWorkerRuntime(r5, r10, r11, r14);
    }
}
