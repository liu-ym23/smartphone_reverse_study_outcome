package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class AnchorPerfWidgetInstanceProxy extends a {
    public final b a;
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> b;

    @Override // st1.a
    public final void c() {
    }

    public AnchorPerfWidgetInstanceProxy() {
        this.a = new b();
        this.b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("open", new AnchorPerfWidgetInstanceProxy$funcMap$1(this))});
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.b;
    }
}
