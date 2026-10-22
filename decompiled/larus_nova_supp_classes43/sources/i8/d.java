package i8;

import com.bytedance.android.annie.monitor.common.timing.jsb.GetPerfTimingMethod;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d extends y6.a {
    public final String b;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ y6.c a;

        public a(y6.c r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f a() {
            return new GetPerfTimingMethod(this.a);
        }
    }

    public d() {
        this.b = "AnnieMonitorCommonEnv";
    }

    @Override // y6.a
    public final String a() {
        return this.b;
    }

    @Override // y6.a
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> l(y6.c r10) {
        Intrinsics.checkNotNullParameter(r10, "manager");
        return MapsKt.mapOf(TuplesKt.to("getPerfTiming", new a(r10)));
    }
}
