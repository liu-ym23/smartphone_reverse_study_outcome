package kh0;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public final Map<String, kh0.a> a;
    public final boolean b;

    public static final class a implements kh0.a.InterfaceC0226a {
        public a() {
        }

        @Override // kh0.a.InterfaceC0226a
        public final boolean a() {
            return true;
        }
    }

    public final kh0.a a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "panelId");
        Object r0 = ((LinkedHashMap) this.a).get(r5);
        if (r0 != null) goto L7;
        kh0.a r1 = new kh0.a(this.b, new a(), r5, null);
        r1.d();
        return r1;
    L7:
        return (kh0.a) r0;
    }

    public h(boolean r1, com.bytedance.android.live.liveinteract.plantform.dynamicframe.e r2) {
        this.b = r1;
        this.a = new LinkedHashMap();
    }
}
