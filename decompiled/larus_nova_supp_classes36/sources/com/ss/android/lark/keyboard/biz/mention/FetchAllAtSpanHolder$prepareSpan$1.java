package com.ss.android.lark.keyboard.biz.mention;

import android.text.Editable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/keyboard/edittext2/base/FunctionEditText;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class FetchAllAtSpanHolder$prepareSpan$1 extends Lambda implements Function1<FunctionEditText, Unit> {
    final /* synthetic */ hob.c $replaceData;
    final /* synthetic */ h this$0;

    public FetchAllAtSpanHolder$prepareSpan$1(h r1, hob.c r2) {
        this.this$0 = r1;
        this.$replaceData = r2;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public final void invoke(FunctionEditText r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        Editable r0 = r8.getEditableText();
        h r1 = this.this$0;
        Intrinsics.checkNotNull(r0);
        int r2 = h.e;
        if (r1.i(r0) == false) goto L5;
        return;
    L5:
        Pair<Integer, Integer> r3 = this.this$0.g(r0);
        int r4 = ((Number) r3.component1()).intValue();
        int r5 = ((Number) r3.component2()).intValue();
        String r6 = f.a;
        hob.c r7 = this.$replaceData;
        f.a(r7, r7.a);
        hob.c r9 = this.$replaceData;
        g r10 = (g) this.this$0.b;
        r9.f = r10.f;
        r9.h = r10.h;
        IMCommonAtSpanHolder r11 = new IMCommonAtSpanHolder(null, this.this$0.c, this.$replaceData);
        this.this$0.getClass();
        r0.setSpan(r11, r4, r5, 33);
        h r12 = this.this$0;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r0, "editable");
        r0.removeSpan(r12);
        r11.c(r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((FunctionEditText) r1);
        return Unit.INSTANCE;
    }
}
