package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.chat.gallery.api.PreviewSourceAction;
import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SourceOwnerAction implements o {
    public final com.larus.chat.gallery.api.q a;
    public final PreviewSourceAction b;
    public final o c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.chat.gallery.impl.preview.toolbar.action.k0] */
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
    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(final l0 r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof SourceOwnerAction$execute$1) == false) goto L7;
        SourceOwnerAction$execute$1 r0 = (SourceOwnerAction$execute$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L22:
        if (this.c != null) goto L24;
        FLogger.a.w("SourceOwnerAction", "unsupported source action: action=" + this.b);
        return Unit.INSTANCE;
    L24:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        String r10 = r7.a.b;
        if (this.a.l(this.b, r10) == true) goto L28;
        o r11 = this.c;
        if (r11 == null) goto L22;
        r0.label = 1;
        if (r11.a(r7, r0) != r2) goto L22;
        return r2;
    L28:
        if (this.a.v(this.b, r10, new k0(r7)) == true) goto L31;
        FLogger.a.w("SourceOwnerAction", "source rejected action: action=" + this.b);
    L31:
        return Unit.INSTANCE;
    L7:
        r0 = new SourceOwnerAction$execute$1(this, r8);
        goto L8
    }

    public SourceOwnerAction(com.larus.chat.gallery.api.q r2, PreviewSourceAction r3, o r4) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "action");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
