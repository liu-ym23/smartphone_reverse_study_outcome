package a01;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zz0.c;
import zz0.f;
import zz0.g;
import zz0.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends com.bytedance.android.live.revenue.platform.router.impl.b implements c, g, com.bytedance.android.live.revenue.a, o {
    public final Map<String, a> d;
    public final vy0.c e;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public b(vy0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridServiceImpl");
        super(r2);
        this.e = r2;
        this.d = new LinkedHashMap();
    }

    @Override // zz0.d
    public final i T3(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uriString");
        Class r0 = i.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L12;
        r2 = r0.getConstructor(new Class[0]);
        if (r2 == null) goto L11;
        Object r3 = r1.putIfAbsent(r0, r2);
        if (r3 == null) goto L12;
        r2 = r3;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r4 == null) goto L17;
        i r6 = (i) r4;
        S2(s1.getContext(), r5);
        return r6;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.schema.api.OpenSchemaResponse");
    }

    @Override // com.bytedance.android.live.revenue.a
    public final boolean p5(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        String r3 = r2.getHost();
        if (r3 != null) goto L5;
        return false;
    L5:
        return this.d.containsKey(r3);
    }

    @Override // com.bytedance.android.live.revenue.a
    public final void J3(Context r5, Uri r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "uri");
        if (r6.getHost() != null) goto L5;
        return;
    L5:
        Map<String, a> r7 = this.d;
        String r0 = r6.getHost();
        if (r0 == null) goto L20;
        if (((a) ((LinkedHashMap) r7).get(r0)) != null) goto L10;
        return;
    L10:
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = UriProtector.getQueryParameterNames(r6).iterator();
    L12:
        if (r2.hasNext() == false) goto L17;
        String r3 = (String) r2.next();
        String r4 = UriProtector.getQueryParameter(r6, r3);
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r1.put(r3, r4);
        goto L12
    L17:
        JSONObject r8 = new JSONObject(r1);
        f r9 = (f) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r8.toString(), null);
        throw null;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // zz0.g
    public final boolean S2(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uriString");
        return vh6.c.b(pq2.a.class).handleSchema(r2, r3);
    }

    @Override // zz0.g
    public final boolean Y(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return vh6.c.b(pq2.a.class).handleSchema(r2, r3);
    }
}
