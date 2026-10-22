package com.larus.dora.obric.device_management.setting.g.ota;

import com.larus.utils.j0;
import com.obric.oui.lisitem.OCardListItem;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e0<T> implements FlowCollector {
    public final /* synthetic */ DoraObricGOTAFragment a;

    public e0(DoraObricGOTAFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.dora.obric.device_management.setting.g.ota.y] */
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
    public final Object emit(Object r9, Continuation r10) {
        com.larus.dora.impl.ota.g.x r11 = (com.larus.dora.impl.ota.g.x) r9;
        g49.d.a("DoraObricGOTAFragment", "otaUiStateFlow collect " + r11);
        if (Intrinsics.areEqual(r11, com.larus.dora.impl.ota.g.x.l.a) == true) goto L49;
        if (Intrinsics.areEqual(r11, com.larus.dora.impl.ota.g.x.d.a) == false) goto L11;
        DoraObricGOTAFragment r12 = this.a;
        int r13 = DoraObricGOTAFragment.N;
        r12.ma0(true);
        OCardListItem r14 = r12.u;
        if (r14 == null) goto L9;
        r14.setVisibility(8);
    L9:
        r12.ka0();
        r12.qa0(r12.getString(2131903813), false, null);
        goto L49
    L11:
        if (Intrinsics.areEqual(r11, com.larus.dora.impl.ota.g.x.a.a) == false) goto L17;
        final DoraObricGOTAFragment r15 = this.a;
        int r16 = DoraObricGOTAFragment.N;
        r15.ma0(true);
        OCardListItem r17 = r15.u;
        if (r17 == null) goto L15;
        r17.setVisibility(8);
    L15:
        r15.ka0();
        r15.qa0(r15.getString(2131903812), true, new y(r15));
        goto L49
    L17:
        if ((r11 instanceof com.larus.dora.impl.ota.g.x.c) == false) goto L20;
        final DoraObricGOTAFragment r18 = this.a;
        final e49.a r20 = ((com.larus.dora.impl.ota.g.x.c) r11).a;
        int r3 = DoraObricGOTAFragment.N;
        r18.ma0(true);
        r18.ea0(r20);
        r18.na0(r18.getString(2131902856), true, null, new f(r20, r18));
        goto L49
    L20:
        if ((r11 instanceof com.larus.dora.impl.ota.g.x.b) == false) goto L23;
        DoraObricGOTAFragment.Y90(this.a, ((com.larus.dora.impl.ota.g.x.b) r11).a);
        goto L49
    L23:
        if ((r11 instanceof com.larus.dora.impl.ota.g.x.k) == false) goto L26;
        DoraObricGOTAFragment r110 = this.a;
        com.larus.dora.impl.ota.g.x.k r21 = (com.larus.dora.impl.ota.g.x.k) r11;
        e49.a r2 = r21.a;
        int r22 = r21.b;
        int r4 = DoraObricGOTAFragment.N;
        r110.ma0(true);
        r110.ea0(r2);
        r110.oa0(((String) r110.k.getValue()) + ' ' + r22 + '%', r22, null);
        goto L49
    L26:
        if ((r11 instanceof com.larus.dora.impl.ota.g.x.j) == false) goto L29;
        final DoraObricGOTAFragment r111 = this.a;
        final e49.a r23 = ((com.larus.dora.impl.ota.g.x.j) r11).a;
        int r5 = DoraObricGOTAFragment.N;
        r111.ma0(true);
        r111.ea0(r23);
        r111.na0(r111.getString(2131902857), true, null, new w(r23, r111));
        goto L49
    L29:
        if ((r11 instanceof com.larus.dora.impl.ota.g.x.e) == false) goto L32;
        DoraObricGOTAFragment r112 = this.a;
        e49.a r24 = ((com.larus.dora.impl.ota.g.x.e) r11).a;
        int r6 = DoraObricGOTAFragment.N;
        r112.ma0(true);
        r112.ea0(r24);
        r112.na0(r112.getString(2131903813), false, null, null);
        goto L49
    L32:
        if ((r11 instanceof com.larus.dora.impl.ota.g.x.g) == false) goto L35;
        DoraObricGOTAFragment r113 = this.a;
        com.larus.dora.impl.ota.g.x.g r25 = (com.larus.dora.impl.ota.g.x.g) r11;
        e49.a r0 = r25.a;
        int r26 = r25.b;
        int r1 = DoraObricGOTAFragment.N;
        r113.ma0(false);
        r113.ea0(r0);
        r113.oa0(((String) r113.l.getValue()) + ' ' + r26 + '%', r26, r113.getString(2131902878));
        goto L49
    L35:
        if ((r11 instanceof com.larus.dora.impl.ota.g.x.h) == false) goto L38;
        DoraObricGOTAFragment r114 = this.a;
        e49.a r27 = ((com.larus.dora.impl.ota.g.x.h) r11).a;
        int r7 = DoraObricGOTAFragment.N;
        r114.ma0(true);
        r114.ea0(r27);
        String r28 = r114.getString(2131902870);
        int r8 = j0.a;
        r114.na0(r28, false, StringsKt.trim(j0.d(2131902871)).toString(), null);
        goto L49
    L38:
        if ((r11 instanceof com.larus.dora.impl.ota.g.x.m) == false) goto L41;
        DoraObricGOTAFragment.Y90(this.a, ((com.larus.dora.impl.ota.g.x.m) r11).a);
        goto L49
    L41:
        if ((r11 instanceof com.larus.dora.impl.ota.g.x.i) == false) goto L44;
        final DoraObricGOTAFragment r115 = this.a;
        final e49.a r30 = ((com.larus.dora.impl.ota.g.x.i) r11).a;
        int r31 = DoraObricGOTAFragment.N;
        r115.ma0(true);
        r115.ea0(r30);
        r115.na0(r115.getString(2131902856), true, null, new f(r30, r115));
        goto L49
    L44:
        if ((r11 instanceof com.larus.dora.impl.ota.g.x.f) == false) goto L47;
        final DoraObricGOTAFragment r116 = this.a;
        final e49.a r32 = ((com.larus.dora.impl.ota.g.x.f) r11).a;
        int r33 = DoraObricGOTAFragment.N;
        r116.ma0(true);
        r116.ea0(r32);
        r116.na0(r116.getString(2131902857), true, null, new w(r32, r116));
        goto L49
    L47:
        throw new NoWhenBranchMatchedException();
    L49:
        return Unit.INSTANCE;
    }
}
