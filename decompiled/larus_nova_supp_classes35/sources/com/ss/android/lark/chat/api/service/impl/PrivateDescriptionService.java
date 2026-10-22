package com.ss.android.lark.chat.api.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.api.service.PrivateDescriptionSource;
import com.ss.android.lark.chat.api.service.Strategy;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class PrivateDescriptionService implements a2b.h {
    public final a2b.g a;

    public static final class a {
    }

    static {
    }

    @Inject
    public PrivateDescriptionService(a2b.g r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.a = r2;
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
    @Override // a2b.h
    public final Object S0(List<String> r12, PrivateDescriptionSource r13, Strategy r14, Continuation<? super Result<? extends Map<String, UserPrivateDescription>>> r15) {
        if ((r15 instanceof PrivateDescriptionService$pullPrivateDescriptions$1) == false) goto L7;
        PrivateDescriptionService$pullPrivateDescriptions$1 r0 = (PrivateDescriptionService$pullPrivateDescriptions$1) r15;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        List r17 = (List) r0.L$1;
        r13 = (PrivateDescriptionSource) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L14 ErrorResult -> L16
    L36:
    L60:
        return Result.constructor-impl(r16);
    L16:
        ErrorResult e = e;
        List r18 = r17;
    L48:
        Log.e("PrivateDescriptionService", "pullPrivateDescriptions failed, source=" + r13 + ", userIds=" + r18, e);
        Result.Companion r19 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(e));
    L14:
        Throwable th = th;
        List r110 = r17;
    L42:
        Log.e("PrivateDescriptionService", "pullPrivateDescriptions unexpected failed, source=" + r13 + ", userIds=" + r110, th);
        Result.Companion r111 = Result.Companion;
        String r112 = th.getMessage();
        if (r112 != null) goto L59;
        r112 = "pullPrivateDescriptions failed";
    L59:
        return Result.constructor-impl(ResultKt.createFailure(new ErrorResult(r112)));
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r16);
        List r113 = CollectionsKt.distinct(r12);
        ArrayList r114 = new ArrayList();
        Iterator r115 = r113.iterator();
    L22:
        if (r115.hasNext() == false) goto L29;
        Object r4 = r115.next();
        String r6 = (String) r4;
        boolean r7 = !StringsKt.isBlank(r6);
        if (r7 == true) goto L26;
        Log.e("PrivateDescriptionService", "pullPrivateDescriptions invalid userId=" + r6 + ", source=" + r13);
    L26:
        if (r7 == false) goto L22;
        r114.add(r4);
        goto L22
    L29:
        if (r114.isEmpty() == false) goto L50;
        Result.Companion r116 = Result.Companion;
        return Result.constructor-impl(MapsKt.emptyMap());
    L50:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L40 ErrorResult -> L46
        a2b.g r118 = this.a;     // Catch: Throwable -> L40 ErrorResult -> L46
        r0.L$0 = r13;     // Catch: Throwable -> L40 ErrorResult -> L46
        r0.L$1 = r114;     // Catch: Throwable -> L40 ErrorResult -> L46
        r0.label = 1;     // Catch: Throwable -> L40 ErrorResult -> L46
        Object r119 = r118.a(r114, r13, r14);     // Catch: Throwable -> L40 ErrorResult -> L46
        if (r119 != r2) goto L35;
        return r2;
    L35:
        r16 = r119;
        goto L36
    L46:
        e = move-exception;
        e = e;
        r18 = r114;
    L40:
        th = move-exception;
        th = th;
        r110 = r114;
    L7:
        r0 = new PrivateDescriptionService$pullPrivateDescriptions$1(this, r15);
        goto L8
    }
}
