package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class StableModeContextProxy extends a {
    public final f a;
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> b;

    @Override // st1.a
    public final void c() {
    }

    public StableModeContextProxy() {
        this.a = new f();
        this.b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("updateSwitch", new StableModeContextProxy$funcMap$1(this))});
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.b;
    }
}
