package com.larus.dora.impl.ota;

import com.bytedance.dora.device.DoraDevice;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ DoraOTATask a;
    public final /* synthetic */ e49.a b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ DoraDevice d;
    public final /* synthetic */ String e;

    public /* synthetic */ e(DoraOTATask r1, e49.a r2, boolean r3, DoraDevice r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.dora.impl.ota.h] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invoke() {
        DoraOTATask r0 = this.a;
        e49.a r1 = this.b;
        boolean r2 = this.c;
        final DoraDevice r3 = this.d;
        final String r4 = this.e;
        r0.n(r1, r2, new h(r3, r4));
        return Unit.INSTANCE;
    }
}
