package com.bytedance.android.livesdk.dispatch.instance.generated;

import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import st1.a;
import tt1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class UserProxy extends a {
    public final o a;
    public final Map<String, Function3<rt1.a, IBaseCallbackSchemaHandler.SchemaCallback<String>, String, Unit>> b;
    public final Map<String, Function1<Object, Unit>> c;

    @Override // st1.a
    public final void c() {
        o r0 = this.a;
        Disposable r1 = r0.a;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        Disposable r2 = r0.b;
        if (r2 == null) goto L9;
        r2.dispose();
        return;
    }

    public UserProxy() {
        this.a = new o();
        this.b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("follow", new UserProxy$funcMap$1(this)), TuplesKt.to("unfollow", new UserProxy$funcMap$2(this))});
        this.c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("LiveActivity", new UserProxy$injectObjMap$1(this))});
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
