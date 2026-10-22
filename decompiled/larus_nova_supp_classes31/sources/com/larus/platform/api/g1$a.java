package com.larus.platform.api;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g1$a {
    public static /* synthetic */ void c(Fragment r6, FragmentActivity r7, List r8, g1$c r9) {
        com.larus.platform.service.i2.b.j(r6, r7, r8, null, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(Fragment r6, List r7, g1$c r8, Map r9, JSONObject r10, int r11) {
        com.larus.platform.service.i2 r0 = com.larus.platform.service.i2.b;
        if ((r11 & 8) == 0) goto L5;
        Map r4 = null;
    L7:
        if ((r11 & 16) == 0) goto L9;
        JSONObject r5 = null;
    L10:
        r0.k(r6, r7, r8, r4, r5);
        return;
    L9:
        r5 = r10;
        goto L10
    L5:
        r4 = r9;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public static /* synthetic */ void b(FragmentActivity r7, List r8, g1$c r9, Map r10, JSONObject r11, int r12) {
        com.larus.platform.service.i2 r0 = com.larus.platform.service.i2.b;
        if ((r12 & 8) == 0) goto L5;
        Map r4 = null;
    L7:
        if ((r12 & 16) == 0) goto L9;
        JSONObject r5 = null;
    L11:
        if ((r12 & 32) == 0) goto L13;
        boolean r6 = true;
    L14:
        r0.g(r7, r8, r9, r4, r5, r6);
        return;
    L13:
        r6 = false;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
