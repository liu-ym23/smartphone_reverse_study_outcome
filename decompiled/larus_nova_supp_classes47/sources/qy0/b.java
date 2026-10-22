package qy0;

import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import cy0.e;
import cy0.j;
import i57.d;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import k57.c;
import k57.f;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final String a;
    public final Map<String, Object> b;

    public b(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "lynxCreateParams");
        this.a = r2;
        this.b = r3;
    }

    public final Object a(c r9, Map<String, k57.b> r10) {
        Intrinsics.checkNotNullParameter(r9, "aioInitialRpcInfo");
        Intrinsics.checkNotNullParameter(r10, "initialPropMap");
        String r0 = r9.getId();
        String r4 = (String) CollectionsKt.last(StringsKt.split$default(r0, new char[]{'.'}, false, 0, 6, null));
        String r3 = StringsKt.removeSuffix(r0, "." + r4);
        Intrinsics.checkNotNullParameter(r3, "interfaceId");
        Intrinsics.checkNotNullParameter(r4, "methodId");
        e.a.getClass();
        j r1 = e.a.a;
        m.e.getClass();
        Object r2 = m.b(r1).a(Reflection.getOrCreateKotlinClass(ny0.a.class));
        Intrinsics.checkNotNull(r2);
        ny0.a r5 = (ny0.a) ((f80.a) r2);
        JsonObject r6 = new JsonObject();
        Iterator r12 = r9.P3().iterator();
    L4:
        if (r12.hasNext() == false) goto L21;
        f r7 = (f) r12.next();
        String r8 = r7.getSource();
        int r13 = r8.hashCode();
        if (r13 == (-2035517098)) goto L16;
        if (r13 != (-422276785)) goto L20;
        if (r8.equals("constants") == false) goto L20;
        k57.b r14 = (k57.b) ((LinkedHashMap) r10).get(r7.P6());
        if (r14 == null) goto L14;
        Object r15 = r14.a();
    L18:
        r6.add(r7.o0(), GsonProtectorUtils.toJsonTree(l97.a.a, r15));
        goto L4
    L14:
        r15 = null;
    L20:
        throw new IllegalArgumentException("unsupported source : " + r7.getSource());
    L16:
        if (r8.equals("arguments") == false) goto L20;
        r15 = this.b.get(r7.P6());
        goto L18
    L21:
        String r16 = this.a;
        int r17 = i57.c.a;
        i57.b r18 = new i57.b();
        Unit r19 = Unit.INSTANCE;
        return r5.A(r3, r4, r6, r16, d.a(r18));
    }
}
