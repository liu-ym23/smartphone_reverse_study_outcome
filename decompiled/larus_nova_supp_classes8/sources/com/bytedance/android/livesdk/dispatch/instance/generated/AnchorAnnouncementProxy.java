package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import st1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class AnchorAnnouncementProxy extends a {
    public final tt1.a a;
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> b;

    @Override // st1.a
    public final void c() {
    }

    public AnchorAnnouncementProxy() {
        this.a = new tt1.a();
        this.b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("open", new AnchorAnnouncementProxy$funcMap$1(this))});
    }

    @Override // st1.a
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> a() {
        return this.b;
    }
}
