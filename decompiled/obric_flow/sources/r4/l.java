package r4;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21691c;
    public float d;

    public /* synthetic */ l(int r5) {
        this.f21690b = r5;
    }

    @Override // r4.a
    public final String d() {
        switch(this.f21690b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return "ts";
    L6:
        return "sc";
    }

    @Override // r4.a
    public final void e(HashMap r5, q4.c r10) {
        switch(this.f21690b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        this.f21691c = a.b("dx", r5);
        this.d = a.b("dy", r5);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "dataManager");
        this.f21691c = a.b("sX", r5);
        this.d = a.b("sY", r5);
    }

    @Override // r4.a
    public final void f(q4.b r5) {
        switch(this.f21690b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.a().translate(this.f21691c, this.d);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.a().scale(this.f21691c, this.d);
    }
}
