package com.larus.dora.impl.noti_v3.special_contacts.ui;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3SpecialContactsEmptyBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k<T> implements FlowCollector {
    public final /* synthetic */ NotificationBroadcastV3SpecialContactsFragment a;

    public k(NotificationBroadcastV3SpecialContactsFragment r1) {
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
    public final Object emit(Object r4, Continuation r5) {
        boolean r6 = ((Boolean) r4).booleanValue();
        LarusDoraPageNotiV3SpecialContactsEmptyBinding r7 = this.a.f;
        int r0 = 8;
        if (r7 == null) goto L10;
        Group r8 = r7.c;
        if (r8 == null) goto L10;
        if (r6 == false) goto L8;
        int r2 = 0;
    L9:
        r8.setVisibility(r2);
        goto L10
    L8:
        r2 = 8;
    L10:
        LarusDoraPageNotiV3SpecialContactsEmptyBinding r9 = this.a.f;
        if (r9 == null) goto L18;
        RecyclerView r10 = r9.d;
        if (r10 == null) goto L18;
        if (r6 == false) goto L16;
        int r3 = 8;
    L17:
        r10.setVisibility(r3);
        goto L18
    L16:
        r3 = 0;
    L18:
        LarusDoraPageNotiV3SpecialContactsEmptyBinding r11 = this.a.f;
        if (r11 == null) goto L27;
        AppCompatTextView r12 = r11.f;
        if (r12 == null) goto L27;
        if (r6 == true) goto L25;
        r0 = 0;
    L25:
        r12.setVisibility(r0);
    L27:
        return Unit.INSTANCE;
    }
}
