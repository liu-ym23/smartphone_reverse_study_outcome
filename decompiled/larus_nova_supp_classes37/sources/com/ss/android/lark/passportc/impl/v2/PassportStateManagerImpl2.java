package com.ss.android.lark.passportc.impl.v2;

import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.api.k;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import com.ss.android.lark.passportc.impl.v2.state.AllUserState;
import com.ss.android.lark.passportc.impl.v2.state.UserStateModel;
import com.ss.android.lark.passportc.internal.p;
import com.ss.android.lark.passportc.internal.t;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class PassportStateManagerImpl2 implements k {
    public final i a;
    public final com.ss.android.lark.passportc.api.f b;
    public final com.ss.android.lark.passportc.impl.v2.state.a c;
    public final com.ss.android.lark.passportc.impl.v2.d d;
    public final UserStateModel e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Executor i;
    public final Executor j;
    public Function1<? super f0c.b, Unit> k;

    public static final class a {
    }

    public static final class b implements Action {
        public final /* synthetic */ PassportStateManagerImpl2 a;
        public final /* synthetic */ com.ss.android.lark.passportc.api.d b;

        public b(PassportStateManagerImpl2 r1, com.ss.android.lark.passportc.api.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            final PassportStateManagerImpl2 r0 = this.a;
            if (this.b.d != Scene.CREATE_USER_COMPONENT) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L10;
            r0.getClass();
            LarkAppContext.Companion.getClass();
            if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L10;
            Executor r2 = com.ss.android.lark.passportc.impl.v2.b.a;
        L11:
            r2.execute(new PassportStateManagerImpl2$enqueueUpdateUser$1(r0));
            return;
        L10:
            r2 = r0.i;
            goto L11
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ PassportStateManagerImpl2 a;
        public final /* synthetic */ UpdateUserRequest b;
        public final /* synthetic */ com.ss.android.lark.passportc.api.d c;

        public c(PassportStateManagerImpl2 r1, UpdateUserRequest r2, com.ss.android.lark.passportc.api.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            com.ss.android.lark.passportc.impl.v2.entity.c r5 = (com.ss.android.lark.passportc.impl.v2.entity.c) r4;
            com.ss.android.lark.passportc.impl.v2.d r0 = this.a.d;
            if (r0 == null) goto L6;
            UpdateUserRequest r1 = this.b;
            com.ss.android.lark.passportc.api.d r2 = this.c;
            Intrinsics.checkNotNull(r5);
            r0.h(r1, r2, r5);
            return;
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ PassportStateManagerImpl2 a;
        public final /* synthetic */ UpdateUserRequest b;
        public final /* synthetic */ com.ss.android.lark.passportc.api.d c;

        public d(PassportStateManagerImpl2 r1, UpdateUserRequest r2, com.ss.android.lark.passportc.api.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            com.ss.android.lark.passportc.impl.v2.d r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.c(this.b, this.c);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ PassportStateManagerImpl2 a;
        public final /* synthetic */ UpdateUserRequest b;
        public final /* synthetic */ com.ss.android.lark.passportc.api.d c;

        public e(PassportStateManagerImpl2 r1, UpdateUserRequest r2, com.ss.android.lark.passportc.api.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            com.ss.android.lark.passportc.impl.v2.d r0 = this.a.d;
            if (r0 == null) goto L6;
            UpdateUserRequest r1 = this.b;
            com.ss.android.lark.passportc.api.d r2 = this.c;
            Intrinsics.checkNotNull(r5);
            r0.j(r1, r2, r5);
            return;
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ PassportStateManagerImpl2 a;
        public final /* synthetic */ UpdateUserRequest b;
        public final /* synthetic */ com.ss.android.lark.passportc.api.d c;

        public f(PassportStateManagerImpl2 r1, UpdateUserRequest r2, com.ss.android.lark.passportc.api.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            com.ss.android.lark.passportc.impl.v2.d r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.r(this.b, this.c);
            return;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.e
    public final List<f0c.b> a() {
        return (List) this.e.b(PassportStateManagerImpl2$allStates$1.INSTANCE);
    }

    @Override // com.ss.android.lark.passportc.api.e
    public final void d(Function1<? super f0c.b, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.e.c(r2);
    }

    public static final j0c.a e(PassportStateManagerImpl2 r1, List r2) {
        r1.getClass();
        j0c.a r3 = com.ss.android.lark.passportc.task.i.a;
        if (r2 == null) goto L8;
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r3 = r3.a((j0c.a) r4.next());
    L8:
        return r3;
    }

    @Override // com.ss.android.lark.passportc.api.k
    public final Observable<com.ss.android.lark.passportc.impl.v2.entity.c> c(UpdateUserRequest r11, com.ss.android.lark.passportc.api.d r12, lzb.a r13) {
        Intrinsics.checkNotNullParameter(r11, "updateRequest");
        Intrinsics.checkNotNullParameter(r12, "executeMode");
        Intrinsics.checkNotNullParameter(r13, "actionContext");
        if (this.a.c() == false) goto L17;
        com.ss.android.lark.passportc.impl.v2.d r0 = this.d;
        if (r0 == null) goto L7;
        r0.i(r11, r12);
    L7:
        com.ss.android.lark.passportc.impl.v2.c r1 = (com.ss.android.lark.passportc.impl.v2.c) this.h.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "request");
        Intrinsics.checkNotNullParameter(r12, "executeMode");
        Intrinsics.checkNotNullParameter(r13, "actionContext");
        BehaviorSubject r2 = BehaviorSubject.create();
        LinkedList<com.ss.android.lark.passportc.impl.v2.c.b> r8 = r1.b;
        monitor-enter(r8);
        r1.b.add(new com.ss.android.lark.passportc.impl.v2.c.b(r11, r2, r12, r13, CollectionsKt.emptyList()));     // Catch: Throwable -> L13
        monitor-exit(r8);
        return r2.hide().lift(new com.ss.android.lark.utils.rxjava.c(new Throwable().getStackTrace())).mergeWith(Completable.fromAction(new b(this, r12))).doOnNext(new c(this, r11, r12)).doOnDispose(new d(this, r11, r12)).doOnError(new e(this, r11, r12)).doOnComplete(new f(this, r11, r12));
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalArgumentException("user online refactor is disable, updateUser V2 not allowed");
    }

    public static final void f(PassportStateManagerImpl2 r1, String r2, UserState r3, UserState r4) {
        r1.getClass();
        if (r3 == r4) goto L6;
        Log.w("UserUpdateVisitor", "state match expect:" + r3 + ", actual:" + r4 + ", userId:" + r2);
        return;
    }

    @Inject
    public PassportStateManagerImpl2(p r2, t r3, i r4, com.ss.android.lark.passportc.api.f r5, com.ss.android.lark.passportc.impl.v2.state.a r6, com.ss.android.lark.passportc.impl.v2.d r7) {
        Intrinsics.checkNotNullParameter(r2, "userDataSource");
        Intrinsics.checkNotNullParameter(r3, "executors");
        Intrinsics.checkNotNullParameter(r4, "multiOnlineFG");
        Intrinsics.checkNotNullParameter(r5, "backgroundUserService");
        Intrinsics.checkNotNullParameter(r6, "stateMachineFactory");
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        UserStateModel r8 = new UserStateModel(r2, r3.h());
        this.e = r8;
        this.f = LazyKt.lazy(new PassportStateManagerImpl2$foregroundStateMachine$2(this));
        this.g = LazyKt.lazy(new PassportStateManagerImpl2$backgroundStateMachine$2(this));
        this.h = LazyKt.lazy(new PassportStateManagerImpl2$stateDiffer$2(this));
        this.i = r3.h();
        this.j = r3.f();
        Function2<AllUserState, AllUserState, Unit> r9 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r9, "subscriber");
        Collection r10 = r8.b;
        monitor-enter(r10);
        ((ArrayList) r8.b).add(r9);     // Catch: Throwable -> L8
        monitor-exit(r10);
        Intrinsics.checkNotNullParameter(r8.b, "subscriberList");
        Intrinsics.checkNotNullParameter(r9, "subscriber");
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
