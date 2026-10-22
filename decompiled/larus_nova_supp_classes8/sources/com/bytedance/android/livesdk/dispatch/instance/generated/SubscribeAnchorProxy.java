package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SubscribeAnchorProxy extends a {
    public final k a;
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> b;
    public final Map<String, Function1<Object, Unit>> c;

    @Override // st1.a
    public final void c() {
        this.a.a.clear();
    }

    public SubscribeAnchorProxy() {
        this.a = new k();
        this.b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("subscribePlay", new SubscribeAnchorProxy$funcMap$1(this)), TuplesKt.to("unsubscribePlay", new SubscribeAnchorProxy$funcMap$2(this))});
        this.c = new LinkedHashMap();
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.b;
    }

    @Override // st1.a
    public final Map<String, Function1<Object, Unit>> b() {
        return this.c;
    }
}
