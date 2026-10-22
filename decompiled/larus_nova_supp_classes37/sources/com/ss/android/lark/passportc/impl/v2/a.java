package com.ss.android.lark.passportc.impl.v2;

import com.ss.android.lark.passportc.impl.v2.state.AllUserState;
import f0c.f;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements Function1<f0c.b, Unit> {
    public final /* synthetic */ PassportStateManagerImpl2 a;
    public final /* synthetic */ com.ss.android.lark.passportc.impl.v2.entity.a b;
    public final /* synthetic */ BehaviorSubject<com.ss.android.lark.passportc.impl.v2.entity.c> c;
    public final /* synthetic */ Ref.BooleanRef d;
    public final /* synthetic */ Ref.ObjectRef<j0c.a> e;

    public final Object invoke(Object r4) {
        f0c.b r5 = (f0c.b) r4;
        Intrinsics.checkNotNullParameter(r5, "state");
        if ((r5 instanceof f) == false) goto L10;
        AllUserState r6 = this.a.e.a();
        Ref.ObjectRef<j0c.a> r0 = this.e;
        AllUserState r7 = r6;
        com.ss.android.lark.passportc.impl.v2.entity.c r1 = new com.ss.android.lark.passportc.impl.v2.entity.c(r7.d(), (j0c.a) r0.element, r7.c());
        Iterator<T> r8 = this.b.e.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        ((BehaviorSubject) r8.next()).onNext(r1);
        goto L6
    L8:
        this.c.onNext(r1);
        this.d.element = true;
        this.a.e.e = null;
    L10:
        return Unit.INSTANCE;
    }

    public a(PassportStateManagerImpl2 r1, com.ss.android.lark.passportc.impl.v2.entity.a r2, BehaviorSubject<com.ss.android.lark.passportc.impl.v2.entity.c> r3, Ref.BooleanRef r4, Ref.ObjectRef<j0c.a> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
