package r4;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f21689b;

    @Override // r4.a
    public final String d() {
        return "ro";
    }

    @Override // r4.a
    public final void e(HashMap r5, q4.c r10) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        this.f21689b = (float) ((((double) a.b("degree", r5)) / 3.141592653589793d) * ((double) 180));
    }

    @Override // r4.a
    public final void f(q4.b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.a().rotate(this.f21689b);
    }
}
