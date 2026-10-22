package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.utils.logger.FLogger;
import cy8.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b<T> implements FlowCollector {
    public final /* synthetic */ ny8.c a;
    public final /* synthetic */ ky8.c b;

    public b(CanvasGenerator$startStreamGenerate$1.b r1, ky8.c r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayList] */
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
    public final Object emit(Object r4, Continuation r5) {
        u r6 = (u) r4;
        int r7 = i.a;
        Intrinsics.checkNotNullParameter(r6, "event");
        boolean r8 = r6 instanceof u.a;
        if (r8 == false) goto L9;
        List<cy8.b> r1 = ((u.a) r6).a.a;
        List r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r0 = r1.iterator();
    L6:
        if (r0.hasNext() == false) goto L31;
        r2.add(i.c((cy8.b) r0.next()));
    L31:
        if (r2 != 0) goto L33;
        r2 = CollectionsKt.emptyList();
    L33:
        if (r8 == false) goto L36;
        this.a.a(r2);
    L48:
        return Unit.INSTANCE;
    L36:
        if ((r6 instanceof u.c) == false) goto L39;
        this.a.b(r2);
        goto L48
    L39:
        if ((r6 instanceof u.d) == false) goto L45;
        FLogger r9 = FLogger.a;
        StringBuilder r3 = new StringBuilder("SSE_KMP onError, localId=");
        r3.append(this.b.c);
        r3.append(", code=");
        u.d r10 = (u.d) r6;
        r3.append(r10.a);
        r3.append(", msg=");
        r3.append(r10.b);
        r9.e("CanvasGenerator", r3.toString());
        ny8.c r11 = this.a;
        int r12 = r10.a;
        String r13 = r10.b;
        if (r13 != null) goto L43;
        r13 = "";
    L43:
        r11.onError(r12, r13);
        goto L48
    L45:
        if (Intrinsics.areEqual(r6, u.b.a) == false) goto L50;
        this.a.onCancel();
        goto L48
    L50:
        throw new NoWhenBranchMatchedException();
    L9:
        if ((r6 instanceof u.c) == false) goto L19;
        cy8.c r14 = ((u.c) r6).a;
        if (r14 == null) goto L30;
        List<cy8.b> r15 = r14.a;
        if (r15 == null) goto L30;
        List<cy8.b> r16 = r15;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r17 = r16.iterator();
    L16:
        if (r17.hasNext() == false) goto L31;
        r2.add(i.c((cy8.b) r17.next()));
    L30:
        r2 = 0;
        goto L31
    L19:
        if ((r6 instanceof u.d) == false) goto L29;
        cy8.c r18 = ((u.d) r6).c;
        if (r18 == null) goto L30;
        List<cy8.b> r19 = r18.a;
        if (r19 == null) goto L30;
        List<cy8.b> r20 = r19;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator<T> r21 = r20.iterator();
    L26:
        if (r21.hasNext() == false) goto L31;
        r2.add(i.c((cy8.b) r21.next()));
        goto L26
    L29:
        if (Intrinsics.areEqual(r6, u.b.a) == true) goto L30;
        throw new NoWhenBranchMatchedException();
    }
}
