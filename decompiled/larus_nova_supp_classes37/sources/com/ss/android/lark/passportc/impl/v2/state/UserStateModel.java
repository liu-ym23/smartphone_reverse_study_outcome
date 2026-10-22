package com.ss.android.lark.passportc.impl.v2.state;

import com.ss.android.lark.passportc.internal.p;
import f0c.c;
import f0c.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UserStateModel extends StateModel<AllUserState> {
    public static final /* synthetic */ int f = 0;
    public final Executor c;
    public final Set<Function1<f0c.b, Unit>> d;
    public Function1<? super f0c.b, Unit> e;

    public static final class a {
    }

    public static final class b {
        public final Function1<d, Boolean> a;
        public final Function1<d, d> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "UpdateReducer(find=" + this.a + ", action=" + this.b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super d, Boolean> r2, Function1<? super d, d> r3) {
            Intrinsics.checkNotNullParameter(r2, "find");
            Intrinsics.checkNotNullParameter(r3, "action");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final void c(Function1<? super f0c.b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        f0c.b r0 = (f0c.b) b(UserStateModel$addGlobalStateObserver$1.INSTANCE);
        if ((r0 instanceof f0c.a) == false) goto L5;
        r3.invoke(c.a);
    L6:
        Set<Function1<f0c.b, Unit>> r1 = this.d;
        monitor-enter(r1);
        this.d.add(r3);     // Catch: Throwable -> L11
        monitor-exit(r1);
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r3.invoke(r0);
        goto L6
    }

    public final void d(Function1<? super f0c.b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        Set<Function1<f0c.b, Unit>> r0 = this.d;
        monitor-enter(r0);
        this.d.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [State, java.lang.Object] */
    public final void e(final b... r4) {
        Intrinsics.checkNotNullParameter(r4, "updates");
        Function1<AllUserState, AllUserState> r0 = new UserStateModel$updateMultiItem$1(r4);
        Intrinsics.checkNotNullParameter(r0, "reducer");
        monitor-enter(this);
        State r5 = this.a;     // Catch: Throwable -> L11
        this.a = r0.invoke(r5);     // Catch: Throwable -> L11
        Iterator r1 = ((ArrayList) this.b).iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((Function2) r1.next()).invoke(r5, this.a);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public UserStateModel(p r3, Executor r4) {
        Intrinsics.checkNotNullParameter(r3, "userDataSource");
        Intrinsics.checkNotNullParameter(r4, "globalStateNotifyExecutor");
        super(new AllUserState(CollectionsKt.emptyList(), r3));
        this.c = r4;
        this.d = Collections.synchronizedSet(new LinkedHashSet());
        Function2<AllUserState, AllUserState, Unit> r5 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r5, "subscriber");
        Collection r6 = this.b;
        monitor-enter(r6);
        ((ArrayList) this.b).add(r5);     // Catch: Throwable -> L8
        monitor-exit(r6);
        Intrinsics.checkNotNullParameter(this.b, "subscriberList");
        Intrinsics.checkNotNullParameter(r5, "subscriber");
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
