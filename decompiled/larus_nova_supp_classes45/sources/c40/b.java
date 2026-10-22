package c40;

import com.bytedance.android.live.liveinteract.jsbridge.method.e0;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.web.jsbridge2.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends BaseJsBridgeMethodFactory {

    public static final class a implements f.b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final f<Object, Object> a() {
            return new e0();
        }
    }

    public b() {
    }

    public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("live.cloudCollaborateAction", a.a);
        return r4;
    }
}
