package com.larus.dora.impl.dynamic.quicknote;

import androidx.appcompat.widget.AppCompatTextView;
import com.larus.dora.impl.databinding.LarusDoraPageQuickNoteDetailBinding;
import com.larus.dora.impl.dynamic.quicknote.entity.QuickNoteItemState;
import com.larus.dora.impl.dynamic.quicknote.views.QuickNoteItemTextSelectorSubTitle;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g<T> implements FlowCollector {
    public final /* synthetic */ QuickNoteDetailFragment a;

    public g(QuickNoteDetailFragment r1) {
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
    public final Object emit(Object r9, Continuation r10) {
        k r11 = (k) r9;
        QuickNoteDetailFragment r12 = this.a;
        List<f59.a> r0 = r11.a;
        int r1 = QuickNoteDetailFragment.i;
        r12.getClass();
        Iterator<T> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L27;
        T r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        f59.a r6 = (f59.a) r4;
        int r7 = QuickNoteDetailFragment.b.a[r6.b.ordinal()];
        if (r7 != 1) goto L11;
        QuickNoteItemTextSelectorSubTitle r8 = (QuickNoteItemTextSelectorSubTitle) CollectionsKt.getOrNull(r12.h, r3);
        if (r8 == null) goto L26;
        r8.setSelected(false);
    L26:
        r3 = r5;
        goto L4
    L11:
        if (r7 != 2) goto L13;
        QuickNoteItemTextSelectorSubTitle r13 = (QuickNoteItemTextSelectorSubTitle) CollectionsKt.getOrNull(r12.h, r3);
        if (r13 == null) goto L26;
        r13.setSelected(true);
        goto L26
    L13:
        if (r7 != 3) goto L19;
        QuickNoteItemTextSelectorSubTitle r14 = (QuickNoteItemTextSelectorSubTitle) CollectionsKt.getOrNull(r12.h, r3);
        if (r14 == null) goto L16;
        r14.getBinding().b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2131240848, 0);
        e1.x(r14.getBinding().b);
        e1.q(r14.getBinding().d);
        e1.o(r14.getBinding().e);
        goto L26
    L16:
        g49.d.b("QuickNoteDetailFragment", "item view is null. index:" + r3 + ", state:" + r6);
        goto L27
    L19:
        throw new NoWhenBranchMatchedException();
    L27:
        List<f59.a> r15 = r11.a;
        ArrayList r16 = new ArrayList();
        Iterator<T> r17 = r15.iterator();
    L29:
        if (r17.hasNext() == false) goto L36;
        T r18 = r17.next();
        if (((f59.a) r18).b != QuickNoteItemState.SELECTED) goto L33;
        boolean r20 = true;
    L34:
        if (r20 == false) goto L29;
        r16.add(r18);
        goto L29
    L33:
        r20 = false;
        goto L34
    L36:
        boolean r21 = r16.isEmpty();
        LarusDoraPageQuickNoteDetailBinding r110 = this.a.f;
        if (r110 == null) goto L44;
        AppCompatTextView r111 = r110.b;
        if (r111 == null) goto L44;
        if (r21 == false) goto L42;
        float r22 = 0.4f;
    L43:
        r111.setAlpha(r22);
        goto L44
    L42:
        r22 = 1.0f;
    L44:
        LarusDoraPageQuickNoteDetailBinding r112 = this.a.f;
        if (r112 == null) goto L50;
        AppCompatTextView r113 = r112.b;
        if (r113 == null) goto L50;
        r113.setEnabled(!r21);
    L50:
        return Unit.INSTANCE;
    }
}
