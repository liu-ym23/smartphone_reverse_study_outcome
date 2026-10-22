package com.larus.ui.arch.vm.internal;

import java.lang.reflect.Field;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ ComponentStateOperator b;

    public /* synthetic */ c(Function1 r1, ComponentStateOperator r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r7) {
        Function1 r0 = this.a;
        ComponentStateOperator r1 = this.b;
        w1a.b r8 = (w1a.b) r7;
        Intrinsics.checkNotNullParameter(r8, "$this$set");
        w1a.b r2 = (w1a.b) r0.invoke(r8);
        w1a.b r3 = (w1a.b) r0.invoke(r8);
        if (Intrinsics.areEqual(r2, r3) == true) goto L20;
        Iterator r4 = SequencesKt.onEach(ArraysKt.asSequence(r2.getClass().getDeclaredFields()), new h()).iterator();
    L6:
        if (r4.hasNext() == false) goto L13;
        Object r5 = r4.next();
        Field r6 = (Field) r5;
        boolean r9 = !Intrinsics.areEqual(r6.get(r2), r6.get(r3));
    L11:
        if (r9 == false) goto L6;
    L14:
        Field r10 = (Field) r5;
        if (r10 == null) goto L19;
        throw new IllegalArgumentException("Impure reducer set on " + r8.getClass().getSimpleName() + "! " + r10.getName() + " changed from " + r10.get(r2) + " to " + r10.get(r3) + ". Ensure that your state properties properly implement hashCode. Contact Afree or Jianbin if you need help.");
    L19:
        throw new IllegalArgumentException("Impure reducer set on " + r8.getClass().getSimpleName() + "! Differing states were provided by the same reducer.Ensure that your state properties properly implement hashCode. First state: " + r2 + " -> Second state: " + r3 + ". Contact Afree or Jianbin if you need help.");
    L10:
        r9 = false;
        goto L11
    L13:
        r5 = null;
        goto L14
    L20:
        v1a.b<S> r11 = r1.h;
        if (r11 == 0) goto L26;
        Intrinsics.checkNotNullParameter(r2, "newState");
        v1a.b.a<S> r12 = r11.b;
        if (r12.b == r12.hashCode()) goto L25;
        int r13 = y1a.a.a;
        y1a.a.b("MutableStateChecker", r12.a.getClass().getSimpleName().concat(" was mutated. State classes should be immutable. Contact Afree or Jianbin if you need help."));
    L25:
        r11.b = new v1a.b.a(r2);
    L26:
        return r2;
    }
}
