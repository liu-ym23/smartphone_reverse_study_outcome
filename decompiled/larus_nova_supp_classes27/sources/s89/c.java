package s89;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.larus.e_commerce.impl.bridge.ECCloseAppletMethod;
import com.larus.e_commerce.impl.bridge.ECSendAppletLogMethod;
import com.larus.e_commerce.impl.bridge.ECShowAppletPanelMethod;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import ti.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c implements i {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public static List a() {
        return CollectionsKt.listOf(new ECBaseBridgeMethod[]{new ECSendAppletLogMethod(), new ECShowAppletPanelMethod(), new ECCloseAppletMethod()});
    }

    public final Function0<List<ECBaseBridgeMethod>> b() {
        return new a();
    }

    public final Function0<List<ECBaseBridgeMethod>> c() {
        return new b();
    }
}
