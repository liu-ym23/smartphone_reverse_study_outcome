package zyb;

import com.ss.android.lark.log.Log;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a implements c {
    public final d a;
    public final e b;
    public final b c;

    /* JADX INFO: renamed from: zyb.a$a, reason: collision with other inner class name */
    public static final class C0211a {
    }

    public static final class b implements zyb.b {
        public final /* synthetic */ a a;

        public final zyb.b e() {
            this.a.a.a();
            this.a.b.a();
            return null;
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // zyb.b
        public final void b(String r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            zyb.b r0 = e();
            if (r0 == null) goto L5;
            r0.b(r3);
            return;
        L5:
            Log.i("ContainerFlowMonitorService", "no active trace. step:" + r3);
        }

        public final void d(String r3) {
            Intrinsics.checkNotNullParameter("rust_online_scenario", "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            e();
            Log.i("ContainerFlowMonitorService", "no active trace. ck:rust_online_scenario,cv:" + r3);
        }

        @Override // zyb.b
        public final void a(String r3, Number r4) {
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, "value");
            zyb.b r0 = e();
            if (r0 == null) goto L5;
            r0.a(r3, r4);
            return;
        L5:
            Log.i("ContainerFlowMonitorService", "no active trace. mk:" + r3 + ",mv:" + r4);
        }

        @Override // zyb.b
        public final void c(String r3, Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, "value");
            zyb.b r0 = e();
            if (r0 == null) goto L5;
            r0.c(r3, r4);
            return;
        L5:
            Log.i("ContainerFlowMonitorService", "no active trace. step:" + r3 + ",value:" + r4);
        }
    }

    static {
    }

    @Override // zyb.c
    public final b a() {
        return this.c;
    }

    @Inject
    public a(d r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "enterAppFlowMonitorService");
        Intrinsics.checkNotNullParameter(r3, "switchMonitorService");
        this.a = r2;
        this.b = r3;
        this.c = new b(this);
    }
}
