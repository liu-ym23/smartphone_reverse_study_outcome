package j9;

import com.bytedance.android.annie.Annie;
import com.bytedance.ies.web.jsbridge2.u;
import java.util.List;
import java.util.Map;
import k9.e;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a implements h8.b {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        @Override // h8.b
        public final void f(Map r10) {
            Intrinsics.checkNotNullParameter("livesdk_live_jsbridge_call", "eventName");
            if (r10 == null) goto L6;
            ((x9.b) Annie.getService(x9.b.class, this.a)).logV3("livesdk_live_jsbridge_call", r10);
            return;
        }
    }

    static {
    }

    public static List a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bizKey");
        List r11 = CollectionsKt.mutableListOf(new u[]{new h8.a(new a(r10))});
        r11.addAll(((e) Annie.getService$default(e.class, null, 2, null)).Z0());
        return r11;
    }
}
