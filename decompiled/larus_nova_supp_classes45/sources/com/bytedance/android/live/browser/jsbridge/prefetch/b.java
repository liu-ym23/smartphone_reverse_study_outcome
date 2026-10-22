package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.live.browser.UtilsKt;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<V> implements Callable {
    public final /* synthetic */ a.c a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ JSONObject c;
    public final /* synthetic */ String d;

    public b(a.c r1, JSONObject r2, JSONObject r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.concurrent.Callable
    public final Pair<JSONObject, Object> call() {
        JSONObject r0 = this.b;
        JSONObject r1 = this.c;
        Lazy r2 = UtilsKt.a;
        Intrinsics.checkNotNullParameter(r0, "$this$filterJSONObject");
        if (r1 == null) goto L6;
        JSONObject r3 = new JSONObject();
        UtilsKt.d(r0, r3, r1);
        r0 = r3;
    L6:
        String r4 = this.d;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L15;
        Object r6 = this.a.a.g.map2TemplateData(UtilsKt.g(r0), this.d);
    L17:
        return new Pair(r0, r6);
    L15:
        r6 = null;
        goto L17
    L9:
        if (StringsKt.isBlank(r4) == true) goto L12;
        r5 = false;
        goto L13
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
