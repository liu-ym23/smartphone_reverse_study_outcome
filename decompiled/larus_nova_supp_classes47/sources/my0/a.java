package my0;

import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.scope.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements ly0.a, o {
    public final Map<sq2.a, IHostAppMonitorListener.Stub> a;

    /* JADX INFO: renamed from: my0.a$a, reason: collision with other inner class name */
    public static final class C0275a extends IHostAppMonitorListener.Stub {
        public final /* synthetic */ sq2.a a;

        public C0275a(sq2.a r1) {
            this.a = r1;
        }

        public final void appEnterBackground(boolean r1, boolean r2) {
            this.a.a(r1);
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a() {
        this.a = new LinkedHashMap();
    }

    @Override // ly0.a
    public final void o5(sq2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        IHostAppMonitorListener.Stub r3 = this.a.remove(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        Lazy r0 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().b(r3);
    }

    @Override // ly0.a
    public final void y0(sq2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        C0275a r0 = new C0275a(r3);
        this.a.put(r3, r0);
        Lazy r4 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().a(r0);
    }
}
