package com.larus.account.base.impl;

import com.google.gson.Gson;
import com.larus.login.impl.switchbind.SwitchBindViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import ua7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k extends a<xa7.c> {
    public final /* synthetic */ n38.n a;

    public k(SwitchBindViewModel.fetchAccountInfo.1.2 r1) {
        this.a = r1;
    }

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
    public final void onResponse(ua7.b r7) {
        xa7.c r8 = (xa7.c) r7;
        if (r8 == null) goto L7;
        boolean r4 = true;
        if (((ua7.b) r8).c != true) goto L7;
    L8:
        Object r3 = null;
        String r5 = null;
        if (r4 == true) goto L35;
        n38.n r0 = this.a;
        if (r8 == null) goto L28;
        int r1 = ((ua7.b) r8).g;
    L29:
        if (r8 == null) goto L31;
        r5 = ((ua7.b) r8).i;
    L31:
        if (r5 != null) goto L33;
        r5 = "";
    L33:
        r0.onFailure(r1, r5);
        return;
    L28:
        r1 = -1;
        goto L29
    L35:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L12
        String r9 = r8.z.toString();     // Catch: Throwable -> L12
        FLogger.a.i("getBindConflictUserInfo", "jsonStr:" + r9);     // Catch: Throwable -> L12
        Object r10 = Result.constructor-impl((q38.h) new Gson().fromJson(r9, q38.h.class));     // Catch: Throwable -> L12
    L14:
        Throwable r2 = Result.exceptionOrNull-impl(r10);
        if (r2 == null) goto L18;
        FLogger.a.e("getBindConflictUserInfo", String.valueOf(r2));
    L18:
        if (Result.isFailure-impl(r10) == true) goto L21;
        r3 = r10;
    L21:
        q38.h r11 = (q38.h) r3;
        if (r11 != null) goto L24;
        r11 = new q38.h(0);
    L24:
        this.a.a(r11);
        return;
    L12:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r4 = false;
        goto L8
    }
}
