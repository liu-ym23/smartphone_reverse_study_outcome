package az0;

import com.bytedance.ies.web.jsbridge2.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wy0.f;
import wy0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends y6.a {
    public final f b;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
        public final /* synthetic */ Map.Entry a;

        public a(Map.Entry r1) {
            this.a = r1;
        }

        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return ((h) this.a.getValue()).a();
        }
    }

    public b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "originalFactory");
        this.b = r2;
    }

    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> k(y6.c r6) {
        Intrinsics.checkNotNullParameter(r6, "manager");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.b.a(r6));
        Map<String, h<Object, ?>> r7 = this.b.c(r6);
        ArrayList r1 = new ArrayList(r7.size());
        Iterator<Map.Entry<String, h<Object, ?>>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry<String, h<Object, ?>> r2 = r8.next();
        r1.add(TuplesKt.to(r2.getKey(), new a(r2)));
        goto L4
    L6:
        MapsKt.putAll(r0, r1);
        return r0;
    }

    public final Map<String, g<?, ?>> n(y6.c r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(this.b.d(r3));
        r0.putAll(this.b.f(r3));
        return r0;
    }
}
