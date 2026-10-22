package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class w implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f4739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f4740b;

    public w(x r8, MaterialCalendarGridView r10) {
        this.f4740b = r8;
        this.f4739a = r10;
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
    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r8, View r10, int r11, long r12) {
        MaterialCalendarGridView r13 = this.f4739a;
        v r14 = r13.a();
        if (r11 >= r14.b()) goto L5;
    L7:
        boolean r15 = false;
    L8:
        if (r15 == false) goto L20;
        i.f r16 = this.f4740b.f4744f;
        long r17 = r13.a().c(r11).longValue();
        i r18 = ((i.d) r16).f4699a;
        if (r18.f4686n.f4601m.c(r17) == false) goto L21;
        r18.f4685m.r(r17);
        Iterator r19 = r18.f4748a.iterator();
    L13:
        if (r19.hasNext() == false) goto L15;
        ((y) r19.next()).b(r18.f4685m.p());
        goto L13
    L15:
        r18.f4692t.getAdapter().f2302a.b();
        RecyclerView r20 = r18.f4691s;
        if (r20 == null) goto L22;
        r20.getAdapter().f2302a.b();
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (r11 > ((r14.b() + r14.f4733a.f4625o) - 1)) goto L7;
        r15 = true;
        goto L8
    }
}
