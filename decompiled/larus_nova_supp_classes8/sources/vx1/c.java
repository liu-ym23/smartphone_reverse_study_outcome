package vx1;

import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends BaseJsBridgeMethodFactory {
    public final /* synthetic */ fw.a a;

    public c(fw.a r1) {
        this.a = r1;
    }

    public final Map<String, n56.c> provideLegacyMethods(IJsBridgeManager r4) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        fw.a r1 = this.a;
        int r2 = e.a;
        b r3 = new b(r4);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "manager");
        Map r5 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r3, "manager");
        return MapsKt.plus(r5, MapsKt.emptyMap());
    }

    public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        fw.a r0 = this.a;
        int r1 = e.a;
        return r0.a(new b(r3));
    }

    public final Map<String, g<?, ?>> provideStatelessMethods(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        fw.a r0 = this.a;
        int r1 = e.a;
        return r0.b(new b(r3));
    }
}
