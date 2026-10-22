package com.larus.dora.impl.nl.notification_rule.ui;

import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.larus.dora.impl.databinding.LarusDoraFragmentAddRuleClarificationBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c<T> implements FlowCollector {
    public final /* synthetic */ AddRuleClarificationFragment a;

    public c(AddRuleClarificationFragment r1) {
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
    public final Object emit(Object r2, Continuation r3) {
        boolean r4 = ((Boolean) r2).booleanValue();
        LarusDoraFragmentAddRuleClarificationBinding r5 = this.a.d;
        if (r5 == null) goto L7;
        LinearLayoutCompat r6 = r5.b;
        if (r6 == null) goto L7;
        r6.setEnabled(!r4);
    L7:
        LarusDoraFragmentAddRuleClarificationBinding r7 = this.a.d;
        if (r7 == null) goto L15;
        ProgressBar r8 = r7.c;
        if (r8 == null) goto L15;
        if (r4 == false) goto L13;
        int r0 = 0;
    L14:
        r8.setVisibility(r0);
        goto L15
    L13:
        r0 = 8;
    L15:
        LarusDoraFragmentAddRuleClarificationBinding r9 = this.a.d;
        if (r9 == null) goto L21;
        AppCompatTextView r10 = r9.g;
        if (r10 == null) goto L21;
        r10.setEnabled(!r4);
    L21:
        return Unit.INSTANCE;
    }
}
