package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class StatusPanelProxy extends a {
    public final c a;
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> b;
    public final Map<String, Function1<Object, Unit>> c;

    @Override // st1.a
    public final void c() {
        this.a.a = null;
    }

    public StatusPanelProxy() {
        this.a = new c();
        this.b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("open", new StatusPanelProxy$funcMap$1(this))});
        this.c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("AnchorStatusPanel", new StatusPanelProxy$injectObjMap$1(this))});
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
