package com.ss.android.lark.passportc.internal;

import android.os.SystemClock;
import com.larksuite.framework.utils.k0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.log.trace.StepTrace;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.api.ReturnType;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.task.ComponentTaskScheduler;
import com.ss.android.lark.passportc.task.TaskType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.ExceptionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class PassportStateManagerImpl implements com.ss.android.lark.passportc.api.l {
    public static final /* synthetic */ int r = 0;
    public final z a;
    public final p b;
    public final com.ss.android.lark.log.c c;
    public final Set<com.ss.android.lark.passportc.task.d> d;
    public final com.ss.android.lark.passportc.task.g e;
    public final l0c.d f;
    public final com.ss.android.lark.passportc.api.i g;
    public final com.ss.android.lark.passportc.api.f h;
    public final l0c.c i;
    public final t j;
    public final Set<Function1<f0c.b, Unit>> k;
    public final List<f0c.d> l;
    public final Executor m;
    public final Executor n;
    public final ReentrantLock o;
    public final AtomicBoolean p;
    public final ConcurrentLinkedQueue<e> q;

    public final class BackgroundOfflineTransfer extends com.ss.android.lark.passportc.internal.f {
        public final User b;
        public final /* synthetic */ PassportStateManagerImpl c;

        @Override // com.ss.android.lark.passportc.internal.u
        public final j0c.a a(com.ss.android.lark.passportc.api.d r12) {
            Intrinsics.checkNotNullParameter(r12, "executeMode");
            PassportStateManagerImpl r0 = this.c;
            List<f0c.d> r1 = r0.l;
            monitor-enter(r1);
            Iterator r2 = ((ArrayList) r0.l).iterator();     // Catch: Throwable -> L53
        L5:
            Set<com.ss.android.lark.passportc.task.c> r3 = null;
            if (r2.hasNext() == false) goto L17;
            Object r4 = r2.next();     // Catch: Throwable -> L53
            f0c.d r5 = (f0c.d) r4;     // Catch: Throwable -> L53
            if (Intrinsics.areEqual(r5.b, this.b.userId) == true) goto L10;
        L14:
            boolean r6 = false;
        L15:
            if (r6 == false) goto L5;
        L18:
            f0c.d r7 = (f0c.d) r4;     // Catch: Throwable -> L53
            if (r7 == null) goto L22;
            final UserSession r8 = r7.a;     // Catch: Throwable -> L53
        L23:
            monitor-exit(r1);
            StringBuilder r9 = new StringBuilder("background offline transfer start uid:");
            r9.append(this.b.userId);
            r9.append(", executeMode.scene :");
            r9.append(r12.d);
            r9.append(" ,targetSession = ");
            if (r8 == null) goto L27;
            String r10 = r8.a;
        L28:
            r9.append(r10);
            Log.i("ComponentTask", r9.toString());
            if (r8 == null) goto L44;
            final PassportStateManagerImpl r11 = this.c;
            PassportStateManagerImpl.t(r11, null, new PassportStateManagerImpl$BackgroundOfflineTransfer$transfer$1(r11, r8), 3);
            j0c.e r13 = new j0c.e(new f0c.g(this.b, r8), r12.d, null);
            e0c.a r14 = this.c.a.f(r8);
            if (r14 == null) goto L33;
            r3 = ((com.ss.android.lark.passportc.task.j) r14).g();
        L33:
            Set<com.ss.android.lark.passportc.task.c> r15 = r3;
            if (r15 != null) goto L60;
            Log.e("ComponentTask", "background offline transfer error : background offline task is null");
            this.c.a.d(r8);
            return new j0c.a(false, "background offline transfer error : background offline task is null", null, null, 28);
        L60:
            TaskType r16 = TaskType.OFFLINE;     // Catch: NoSuchElementException -> L39
            List<j0c.b> r17 = this.c.e.a();     // Catch: NoSuchElementException -> L39
            PassportStateManagerImpl r18 = this.c;     // Catch: NoSuchElementException -> L39
            j0c.a r19 = (j0c.a) new ComponentTaskScheduler(r15, r16, r17, r18.j, r18.f, r18.i).b(r13, r12.b, r12.c).blockingFirst();     // Catch: NoSuchElementException -> L39
        L41:
            this.c.a.d(r8);
            Log.i("ComponentTask", "background offline transfer result = " + r19.a + " , targetUser" + this.b.userId);
            Intrinsics.checkNotNull(r19);
            return r19;
        L39:
            e = move-exception;
            Log.e("ComponentTask", "background offline transfer error get execute task  result error :" + e.getMessage());
            r19 = new j0c.a(false, "background offline transfer error get execute task  result error :" + e.getMessage(), null, null, 28);
            goto L41
        L44:
            if (PassportStateManagerImpl.e(this.c, this.b.userId) == false) goto L58;
            Log.i("ComponentTask", "background offline transfer skip , targetUser" + this.b.userId + " already foreground online");
            return com.ss.android.lark.passportc.task.i.a;
        L58:
            Boolean r110 = (Boolean) this.c.h.a(this.b.userId).blockingFirst();     // Catch: NoSuchElementException -> L49
        L51:
            Log.i("ComponentTask", "background offline transfer end result = " + r110 + " , targetUser" + this.b.userId + " session is null");
            Intrinsics.checkNotNull(r110);
            return new j0c.a(r110.booleanValue(), "background offline transfer result = " + r110 + " , targetUser" + this.b.userId + " session is null", null, null, 28);
        L49:
            e = move-exception;
            Log.e("ComponentTask", "background offline transfer error makeUserBackgroundOffline error :" + e.getMessage());
            r110 = Boolean.FALSE;
            goto L51
        L27:
            r10 = null;
            goto L28
        L22:
            r8 = null;
            goto L23
        L10:
            if (r5.c.a != UserState.ONLINE) goto L14;
            if (r5.d == true) goto L14;
            r6 = true;
            goto L15
        L17:
            r4 = null;
        L53:
            th = move-exception;
            throw th;
        }

        public BackgroundOfflineTransfer(PassportStateManagerImpl r2, User r3) {
            Intrinsics.checkNotNullParameter(r3, "targetUser");
            this.c = r2;
            super(StateTransferType.Offline);
            this.b = r3;
        }
    }

    public final class BackgroundOnlineTransfer extends com.ss.android.lark.passportc.internal.f {
        public final UserSession b;
        public final User c;
        public final Function1<User, Unit> d;
        public final lzb.a e;
        public final /* synthetic */ PassportStateManagerImpl f;

        @Override // com.ss.android.lark.passportc.internal.u
        public final j0c.a a(final com.ss.android.lark.passportc.api.d r13) {
            Intrinsics.checkNotNullParameter(r13, "executeMode");
            final PassportStateManagerImpl r0 = this.f;
            PassportStateManagerImpl.t(r0, null, new PassportStateManagerImpl$BackgroundOnlineTransfer$transfer$1(this, r13, r0), 3);
            j0c.e r1 = new j0c.e(new f0c.g(this.c, this.b), r13.d, null);
            Log.i("ComponentTask", "background online transfer start uid :" + this.c.userId + ", executeMode.scene :" + r13.d + ",targetSession: " + this.b.a);
            e0c.a r2 = this.f.a.f(this.b);
            if (r2 == null) goto L5;
            Set<com.ss.android.lark.passportc.task.d> r6 = ((com.ss.android.lark.passportc.task.j) r2).R();
        L6:
            if (r6 != null) goto L19;
            Log.e("ComponentTask", "background online transfer error : background online task is null");
            return new j0c.a(false, "backgroundOnline transfer error : background online task is null", null, null, 28);
        L19:
            TaskType r7 = TaskType.ONLINE;     // Catch: NoSuchElementException -> L11
            List<j0c.b> r8 = this.f.e.b();     // Catch: NoSuchElementException -> L11
            PassportStateManagerImpl r5 = this.f;     // Catch: NoSuchElementException -> L11
            j0c.a r3 = (j0c.a) new ComponentTaskScheduler(r6, r7, r8, r5.j, r5.f, r5.i).b(r1, r13.b, r13.c).blockingFirst();     // Catch: NoSuchElementException -> L11
        L14:
            if (r3.a == false) goto L16;
            PassportStateManagerImpl.t(this.f, null, new PassportStateManagerImpl$BackgroundOnlineTransfer$transfer$2(this, r13), 3);
        L17:
            Log.i("ComponentTask", "background online end execute task result :" + r3.a);
            Intrinsics.checkNotNull(r3);
            return r3;
        L16:
            final PassportStateManagerImpl r14 = this.f;
            PassportStateManagerImpl.t(r14, null, new PassportStateManagerImpl$BackgroundOnlineTransfer$transfer$3(r14, this), 3);
            this.f.a.d(this.b);
        L11:
            e = move-exception;
            Log.e("ComponentTask", "get execute task error :" + e.getMessage());
            r3 = new j0c.a(false, "backgroundOnline transfer error :" + e.getMessage(), null, null, 28);
            goto L14
        L5:
            r6 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BackgroundOnlineTransfer(PassportStateManagerImpl r2, UserSession r3, User r4, Function1<? super User, Unit> r5, lzb.a r6) {
            Intrinsics.checkNotNullParameter(r3, "targetSession");
            Intrinsics.checkNotNullParameter(r4, "targetUser");
            Intrinsics.checkNotNullParameter(r6, "userActionContext");
            this.f = r2;
            super(StateTransferType.Online);
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public final class CleanTransfer extends com.ss.android.lark.passportc.internal.f {
        @Override // com.ss.android.lark.passportc.internal.u
        public final j0c.a a(com.ss.android.lark.passportc.api.d r3) {
            Intrinsics.checkNotNullParameter(r3, "executeMode");
            final PassportStateManagerImpl r0 = null;
            PassportStateManagerImpl.t(null, null, new PassportStateManagerImpl$CleanTransfer$transfer$cleanRet$1(r0, this), 3);
            throw null;
        }
    }

    public final class OfflineTransfer extends com.ss.android.lark.passportc.internal.f {
        public final f0c.g b;
        public final lzb.a c;
        public final /* synthetic */ PassportStateManagerImpl d;

        @Override // com.ss.android.lark.passportc.internal.u
        public final j0c.a a(final com.ss.android.lark.passportc.api.d r15) {
            Intrinsics.checkNotNullParameter(r15, "executeMode");
            Log.i("ComponentTask", "foreground offline transfer start targetSession = " + this.b.b.a + ", executeMode-scene :" + r15.d);
            com.ss.android.lark.log.trace.b r0 = m0c.d.a;
            com.ss.android.lark.log.trace.b r1 = m0c.d.a(r15.d);
            if (r1 == null) goto L5;
            StepTrace r2 = r1.a(m0c.d.c);
            StepTrace.f(r2);
        L6:
            this.d.i.b("rust_infra_transfer_offline");
            if (r15.a == false) goto L24;
            Set<com.ss.android.lark.passportc.task.c> r7 = this.d.a.b(this.b.b);
            if (r7.isEmpty() == false) goto L12;
            Log.e("ComponentTask", "foreground offline transfer error : offline task is null");
            this.d.i.i("rust_infra_transfer_offline");
            return new j0c.a(false, "foreground offline transfer error : offline task is null", null, null, 28);
        L12:
            j0c.e r3 = new j0c.e(this.b, r15.d, null);
            com.ss.android.lark.log.trace.b r5 = m0c.d.a(r15.d);     // Catch: NoSuchElementException -> L22
            if (r5 == null) goto L16;
            StepTrace r6 = r5.a(m0c.d.g);     // Catch: NoSuchElementException -> L22
            StepTrace.f(r6);     // Catch: NoSuchElementException -> L22
        L17:
            TaskType r8 = TaskType.OFFLINE;     // Catch: NoSuchElementException -> L22
            List<j0c.b> r9 = this.d.e.f();     // Catch: NoSuchElementException -> L22
            PassportStateManagerImpl r10 = this.d;     // Catch: NoSuchElementException -> L22
            Object r4 = new ComponentTaskScheduler(r7, r8, r9, r10.j, r10.f, r10.i).b(r3, r15.b, r15.c).blockingFirst();     // Catch: NoSuchElementException -> L22
            j0c.a r11 = (j0c.a) r4;     // Catch: NoSuchElementException -> L22
            if (r6 == null) goto L20;
            StepTrace.g(r6);     // Catch: NoSuchElementException -> L22
        L20:
            j0c.a r12 = (j0c.a) r4;     // Catch: NoSuchElementException -> L22
        L26:
            if (r15.a == true) goto L28;
        L31:
            com.ss.android.lark.log.trace.b r13 = m0c.d.a;
            com.ss.android.lark.log.trace.b r14 = m0c.d.a(r15.d);
            if (r14 == null) goto L34;
            StepTrace r16 = r14.a(m0c.d.h);
            StepTrace.f(r16);
        L35:
            this.d.i.e();
            PassportStateManagerImpl.t(this.d, null, new PassportStateManagerImpl$OfflineTransfer$transfer$offlineRet$1(this, r15), 3);
            this.d.i.h();
            if (r16 == null) goto L38;
            StepTrace.g(r16);
        L38:
            this.d.i.i("rust_infra_transfer_offline");
            if (r2 == null) goto L41;
            StepTrace.g(r2);
        L41:
            Log.i("ComponentTask", "foreground offline transfer end execute task result = " + r12.a);
            Intrinsics.checkNotNull(r12);
            return r12;
        L34:
            r16 = null;
            goto L35
        L28:
            if (r12.a == false) goto L38;
            if (r15.b == ExecuteStrategy.ROLLBACK) goto L38;
        L16:
            r6 = null;
        L22:
            e = move-exception;
            Log.e("ComponentTask", String.valueOf(e));
            r12 = new j0c.a(false, "offline transfer error :" + e.getMessage(), null, null, 28);
            goto L26
        L24:
            r12 = com.ss.android.lark.passportc.task.i.a;
            goto L26
        L5:
            r2 = null;
            goto L6
        }

        public OfflineTransfer(PassportStateManagerImpl r2, f0c.g r3, lzb.a r4) {
            Intrinsics.checkNotNullParameter(r3, "offlineUserPayload");
            Intrinsics.checkNotNullParameter(r4, "userActionContext");
            this.d = r2;
            super(StateTransferType.Offline);
            this.b = r3;
            this.c = r4;
        }
    }

    public final class OnlineTransfer extends com.ss.android.lark.passportc.internal.f {
        public final UserSession b;
        public final User c;
        public final lzb.a d;
        public final /* synthetic */ PassportStateManagerImpl e;

        @Override // com.ss.android.lark.passportc.internal.u
        public final j0c.a a(final com.ss.android.lark.passportc.api.d r20) {
            Intrinsics.checkNotNullParameter(r20, "executeMode");
            Log.i("ComponentTask", "foreground online transfer start, uid :" + this.c.userId + ", executeMode-scene :" + r20.d + " ,targetSession :" + this.b.a);
            long r6 = SystemClock.elapsedRealtime();
            com.ss.android.lark.log.trace.b r0 = m0c.d.a;
            com.ss.android.lark.log.trace.b r1 = m0c.d.a(r20.d);
            if (r1 == null) goto L5;
            StepTrace r2 = r1.a(m0c.d.f);
            StepTrace.f(r2);
            StepTrace r9 = r2;
        L6:
            this.e.i.b("rust_infra_transfer_online");
            j0c.a r3 = com.ss.android.lark.passportc.task.i.a;
            if (r20.a == false) goto L21;
            r6 = SystemClock.elapsedRealtime();
            com.ss.android.lark.log.trace.b r4 = m0c.d.a(r20.d);
            if (r4 == null) goto L11;
            StepTrace r5 = r4.a(m0c.d.g);
            StepTrace.f(r5);
            StepTrace r11 = r5;
        L12:
            Set r13 = CollectionsKt.toMutableSet(this.e.d);
            CollectionsKt.addAll(r13, this.e.a.c(this.b));
            j0c.e r7 = new j0c.e(new f0c.g(this.c, this.b), r20.d, null);
            Log.i("ComponentTask", "foreground online start uid :" + this.c.userId + ", executeMode-scene :" + r20.d + " ,targetSession :" + this.b.a);
            TaskType r14 = TaskType.ONLINE;     // Catch: NoSuchElementException -> L15
            List<j0c.b> r15 = this.e.e.g();     // Catch: NoSuchElementException -> L15
            PassportStateManagerImpl r8 = this.e;     // Catch: NoSuchElementException -> L15
            Object r10 = new ComponentTaskScheduler(r13, r14, r15, r8.j, r8.f, r8.i).b(r7, r20.b, r20.c).blockingFirst();     // Catch: NoSuchElementException -> L15
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.ss.android.lark.passportc.task.entity.ExecuteTaskResult");     // Catch: NoSuchElementException -> L15
            r3 = (j0c.a) r10;     // Catch: NoSuchElementException -> L15
        L17:
            if (r11 == null) goto L19;
            StepTrace.g(r11);
        L19:
            Log.i("ComponentTask", "foreground online transfer, component task cost:" + (SystemClock.elapsedRealtime() - r6));
        L15:
            e = move-exception;
            Log.e("ComponentTask", "get execute task error :" + e.getMessage());
            r3 = new j0c.a(false, "online transfer error :" + e.getMessage(), null, null, 28);
            goto L17
        L11:
            r11 = null;
        L21:
            if (r20.a == true) goto L23;
        L26:
            long r12 = SystemClock.elapsedRealtime();
            com.ss.android.lark.log.trace.b r16 = m0c.d.a;
            com.ss.android.lark.log.trace.b r17 = m0c.d.a(r20.d);
            if (r17 == null) goto L29;
            StepTrace r18 = r17.a(m0c.d.h);
            StepTrace.f(r18);
        L30:
            PassportStateManagerImpl.t(this.e, PassportStateManagerImpl$OnlineTransfer$transfer$onlineRet$1.INSTANCE, new PassportStateManagerImpl$OnlineTransfer$transfer$onlineRet$2(this, r20), 2);
            if (r18 == null) goto L33;
            StepTrace.g(r18);
        L33:
            long r19 = SystemClock.elapsedRealtime() - r12;
            this.e.i.g(r19);
            Log.i("ComponentTask", "foreground online transfer, notifyConvention cost:" + r19);
        L34:
            this.e.i.i("rust_infra_transfer_online");
            if (r9 == null) goto L37;
            StepTrace.g(r9);
        L37:
            Log.i("ComponentTask", "foreground online transfer end, cost=" + (SystemClock.elapsedRealtime() - r6));
            return r3;
        L29:
            r18 = null;
            goto L30
        L23:
            if (r3.a == false) goto L34;
            if (r20.b == ExecuteStrategy.ROLLBACK) goto L34;
        L5:
            r9 = null;
            goto L6
        }

        public OnlineTransfer(PassportStateManagerImpl r2, UserSession r3, User r4, lzb.a r5) {
            Intrinsics.checkNotNullParameter(r3, "targetSession");
            Intrinsics.checkNotNullParameter(r4, "targetUser");
            Intrinsics.checkNotNullParameter(r5, "userActionContext");
            this.e = r2;
            super(StateTransferType.Online);
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public final class SwapTransfer extends com.ss.android.lark.passportc.internal.f {
        public final UserSession b;
        public final UserSession c;
        public final User d;
        public final lzb.a e;
        public final /* synthetic */ PassportStateManagerImpl f;

        @Override // com.ss.android.lark.passportc.internal.u
        public final j0c.a a(final com.ss.android.lark.passportc.api.d r9) {
            Intrinsics.checkNotNullParameter(r9, "executeMode");
            Log.i("ComponentTask", "foreground swap transfer start targetSession = " + this.c.a + ", executeMode-scene :" + r9.d);
            long r2 = SystemClock.elapsedRealtime();
            com.ss.android.lark.log.trace.b r0 = m0c.d.a;
            com.ss.android.lark.log.trace.b r1 = m0c.d.a(r9.d);
            if (r1 == null) goto L5;
            StepTrace r3 = r1.a(m0c.d.e);
            StepTrace.f(r3);
        L6:
            this.f.i.b("rust_infra_transfer_swap");
            this.f.i.e();
            final PassportStateManagerImpl r5 = this.f;
            PassportStateManagerImpl.t(r5, null, new PassportStateManagerImpl$SwapTransfer$transfer$1(this, r9, r5), 3);
            if (this.b == null) goto L9;
            final PassportStateManagerImpl r6 = this.f;
            PassportStateManagerImpl.t(r6, null, new PassportStateManagerImpl$SwapTransfer$transfer$2$1(r6, this), 3);
            r6.a.a(this.b);
        L9:
            this.f.i.h();
            this.f.i.i("rust_infra_transfer_swap");
            if (r3 == null) goto L12;
            StepTrace.g(r3);
        L12:
            Log.i("ComponentTask", "foreground swap transfer end, cost=" + (SystemClock.elapsedRealtime() - r2));
            return com.ss.android.lark.passportc.task.i.a;
        L5:
            r3 = null;
            goto L6
        }

        public SwapTransfer(PassportStateManagerImpl r2, UserSession r3, UserSession r4, User r5, lzb.a r6) {
            Intrinsics.checkNotNullParameter(r4, "targetSession");
            Intrinsics.checkNotNullParameter(r5, "targetUser");
            Intrinsics.checkNotNullParameter(r6, "userActionContext");
            this.f = r2;
            super(StateTransferType.Swap);
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class a {
        public static UserSession a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            return new UserSession(k0.a(10), r2);
        }
    }

    public final class b extends u {
        public final List<u> a;

        public b(u... r2) {
            Intrinsics.checkNotNullParameter(r2, "transfers");
            this.a = ArraysKt.asList(r2);
        }

        @Override // com.ss.android.lark.passportc.internal.u
        public final j0c.a a(com.ss.android.lark.passportc.api.d r5) {
            Intrinsics.checkNotNullParameter(r5, "executeMode");
            j0c.a r0 = com.ss.android.lark.passportc.task.i.a;
            j0c.a r1 = com.ss.android.lark.passportc.task.i.a;
            Iterator<u> r2 = this.a.iterator();
        L4:
            if (r2.hasNext() == false) goto L10;
            j0c.a r3 = r2.next().a(r5);
            j0c.a r4 = com.ss.android.lark.passportc.task.i.a;
            if (r3 == com.ss.android.lark.passportc.task.i.a) goto L9;
            r1 = r3;
        L9:
            if (r1.a == true) goto L4;
        L10:
            return r1;
        }
    }

    public final class c extends com.ss.android.lark.passportc.internal.f {
        public final String b;

        public c() {
            Intrinsics.checkNotNullParameter("user already foreground online, can't background online again", "reason");
            super(StateTransferType.Illegal);
            this.b = "user already foreground online, can't background online again";
        }

        @Override // com.ss.android.lark.passportc.internal.u
        public final j0c.a a(com.ss.android.lark.passportc.api.d r8) {
            Intrinsics.checkNotNullParameter(r8, "executeMode");
            return new j0c.a(false, this.b, null, null, 28);
        }
    }

    public final class d extends com.ss.android.lark.passportc.internal.f {
        public final String b;

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            super(StateTransferType.Illegal);
            this.b = r2;
        }

        @Override // com.ss.android.lark.passportc.internal.u
        public final j0c.a a(com.ss.android.lark.passportc.api.d r2) {
            Intrinsics.checkNotNullParameter(r2, "executeMode");
            throw new IllegalStateException(this.b);
        }
    }

    public static final class e {
        public final com.ss.android.lark.passportc.api.z a;
        public final com.ss.android.lark.passportc.api.d b;
        public final BehaviorSubject<j0c.d> c;
        public final lzb.a d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "UpdateActionCache(action=" + this.a + ", executeMode=" + this.b + ", subject=" + this.c + ", context=" + this.d + ')';
        }

        public final lzb.a getContext() {
            return this.d;
        }

        public e(com.ss.android.lark.passportc.api.z r2, com.ss.android.lark.passportc.api.d r3, BehaviorSubject<j0c.d> r4, lzb.a r5) {
            Intrinsics.checkNotNullParameter(r2, "action");
            Intrinsics.checkNotNullParameter(r3, "executeMode");
            Intrinsics.checkNotNullParameter(r4, "subject");
            Intrinsics.checkNotNullParameter(r5, "context");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public final class f extends com.ss.android.lark.passportc.internal.f {
        public f() {
            super(StateTransferType.UpdateToDate);
        }

        @Override // com.ss.android.lark.passportc.internal.u
        public final j0c.a a(com.ss.android.lark.passportc.api.d r2) {
            Intrinsics.checkNotNullParameter(r2, "executeMode");
            j0c.a r3 = com.ss.android.lark.passportc.task.i.a;
            return com.ss.android.lark.passportc.task.i.a;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ u a;
        public final /* synthetic */ com.ss.android.lark.passportc.api.d b;
        public final /* synthetic */ List<u> c;
        public final /* synthetic */ Ref.IntRef d;
        public final /* synthetic */ Ref.ObjectRef<j0c.a> e;
        public final /* synthetic */ int f;
        public final /* synthetic */ Function1<j0c.a, Unit> g;

        /* JADX WARN: Multi-variable type inference failed */
        public g(u r1, com.ss.android.lark.passportc.api.d r2, List<? extends u> r3, Ref.IntRef r4, Ref.ObjectRef<j0c.a> r5, int r6, Function1<? super j0c.a, Unit> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void a() {
            Log.i("n_action_cm_global_manager_impl", "execute background transfer thread = " + ThreadMethodProxy.currentThread().getName());
            j0c.a r1 = this.a.a(this.b);
            List<u> r2 = this.c;
            Ref.IntRef r3 = this.d;
            Ref.ObjectRef<j0c.a> r4 = this.e;
            int r5 = this.f;
            Function1<j0c.a, Unit> r6 = this.g;
            monitor-enter(r2);
            r3.element++;     // Catch: Throwable -> L10
            r4.element = ((j0c.a) r4.element).a(r1);     // Catch: Throwable -> L10
            if (r3.element != r5) goto L7;
            Log.i("n_action_cm_global_manager_impl", "execute background finish size = " + r3.element);     // Catch: Throwable -> L10
            r6.invoke(r4.element);     // Catch: Throwable -> L10
        L7:
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r2);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Action {
        public final /* synthetic */ PassportStateManagerImpl a;
        public final /* synthetic */ com.ss.android.lark.passportc.api.z b;
        public final /* synthetic */ com.ss.android.lark.passportc.api.d c;
        public final /* synthetic */ BehaviorSubject<j0c.d> d;
        public final /* synthetic */ lzb.a e;

        public h(PassportStateManagerImpl r1, com.ss.android.lark.passportc.api.z r2, com.ss.android.lark.passportc.api.d r3, BehaviorSubject<j0c.d> r4, lzb.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void run() {
            this.a.u(this.b, this.c, this.d, this.e);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ PassportStateManagerImpl b;
        public final /* synthetic */ com.ss.android.lark.passportc.api.z c;

        public i(long r1, PassportStateManagerImpl r3, com.ss.android.lark.passportc.api.z r4) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
        }

        public final void accept(Object r5) {
            Log.i("n_action_cm_global_manager_impl", "updateUser, onNext, isSuccess=" + ((j0c.d) r5).b.a + " cost=" + (SystemClock.elapsedRealtime() - this.a));
            l0c.c r6 = this.b.i;
            StringBuilder r0 = new StringBuilder("rust_infra_update_user_");
            r0.append(this.c.a());
            r6.i(r0.toString());
        }
    }

    public static final class j<T> implements Consumer {
        public static final j<T> a = null;

        static {
            a = new j();
        }

        public j() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Log.i("n_action_cm_global_manager_impl", "updateUser, doOnError, error:" + r4.getMessage(), r4);
        }
    }

    public static final class k implements Action {
        public final /* synthetic */ PassportStateManagerImpl a;
        public final /* synthetic */ StepTrace b;
        public final /* synthetic */ long c;

        public k(PassportStateManagerImpl r1, StepTrace r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            this.a.i.d();
            StepTrace r0 = this.b;
            if (r0 == null) goto L5;
            StepTrace.d(r0);
        L5:
            Log.i("n_action_cm_global_manager_impl", "updateUser, doOnComplete, cost=" + (SystemClock.elapsedRealtime() - this.c));
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ PassportStateManagerImpl a;
        public final /* synthetic */ com.ss.android.lark.passportc.api.z b;
        public final /* synthetic */ com.ss.android.lark.passportc.api.d c;
        public final /* synthetic */ BehaviorSubject<j0c.d> d;
        public final /* synthetic */ lzb.a e;

        public l(PassportStateManagerImpl r1, com.ss.android.lark.passportc.api.z r2, com.ss.android.lark.passportc.api.d r3, BehaviorSubject<j0c.d> r4, lzb.a r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            PassportStateManagerImpl r5 = this.a;
            ReentrantLock r6 = r5.o;
            com.ss.android.lark.passportc.api.z r7 = this.b;
            com.ss.android.lark.passportc.api.d r8 = this.c;
            BehaviorSubject<j0c.d> r9 = this.d;
            lzb.a r10 = this.e;
            r6.lock();
            Log.i("ExecuteUpdateAction", "execute update action{" + r7 + "} , currentThread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L16
            if (r5.p.get() == false) goto L7;
            Log.i("ExecuteUpdateAction", "isUpdating is true, add action{" + r7 + "} to cache queue , currentThread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L16
            r5.q.add(new e(r7, r8, r9, r10));     // Catch: Throwable -> L16
        L13:
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L16
            r6.unlock();
            return;
        L7:
            if ((!r5.q.isEmpty()) == false) goto L9;
            Log.i("ExecuteUpdateAction", "isUpdating is false, cache queue not empty, add action{" + r7 + "} to cache queue, currentThread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L16
            r5.q.add(new e(r7, r8, r9, r10));     // Catch: Throwable -> L16
            goto L13
        L9:
            Log.i("ExecuteUpdateAction", "begin update action{" + r7 + "} , isUpdating set true , currentThread = " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L16
            r5.p.set(true);     // Catch: Throwable -> L16
            if (PassportStateManagerImpl.s(r7) == false) goto L12;
            PassportStateManagerImpl.g(r5, r7, r8, r9, r10);     // Catch: Throwable -> L16
            goto L13
        L12:
            PassportStateManagerImpl.f(r5, r7, r8, r9, r10);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            r6.unlock();
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.passportc.api.e
    public final List<f0c.b> a() {
        List<f0c.d> r0 = this.l;
        monitor-enter(r0);
        List r1 = CollectionsKt.toMutableList(this.l);     // Catch: Throwable -> L11
        monitor-exit(r0);
        List r2 = r1;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r3.add(h((f0c.d) r4.next()));
        goto L8
    L10:
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    public final void j() {
        int r2 = 0;
        this.p.set(false);
        Log.i("ExecuteUpdateAction", "finish update , isUpdating set false,currentThread = " + ThreadMethodProxy.currentThread().getName());
        ConcurrentLinkedQueue r1 = new ConcurrentLinkedQueue();
        r1.addAll(this.q);
        this.q.clear();
        if ((!r1.isEmpty()) == false) goto L30;
        Iterator r3 = r1.iterator();
        int r4 = -1;
        e r6 = null;
        int r5 = -1;
    L6:
        if (r3.hasNext() == false) goto L22;
        Object r7 = r3.next();
        int r9 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        e r8 = (e) r7;
        if (s(r8.a) == false) goto L13;
        Log.i("ExecuteUpdateAction", "execute foreground cache action{" + r8.a + " ,currentThread = " + ThreadMethodProxy.currentThread().getName());
        u(r8.a, r8.b, r8.c, r8.getContext());
        r5 = r2;
    L21:
        r2 = r9;
        goto L6
    L13:
        if (r6 == null) goto L20;
        Log.i("ExecuteUpdateAction", "skip background cache action{" + r6.a + ",currentThread = " + ThreadMethodProxy.currentThread().getName());
        BehaviorSubject<j0c.d> r10 = r6.c;
        if (r10 == null) goto L17;
        r10.onNext(new j0c.d(o(), new j0c.a(false, "update background too often ,skip current action", null, null, 28), l()));
    L17:
        BehaviorSubject<j0c.d> r11 = r6.c;
        if (r11 == null) goto L20;
        r11.onComplete();
    L20:
        r4 = r2;
        r6 = r8;
        goto L21
    L22:
        if (r6 == null) goto L31;
        if (r4 <= r5) goto L25;
        Log.i("ExecuteUpdateAction", "execute background cache action{" + r6.a + " ,currentThread = " + ThreadMethodProxy.currentThread().getName());
        u(r6.a, r6.b, r6.c, r6.getContext());
        return;
    L25:
        Log.i("ExecuteUpdateAction", "skip last background cache action{" + r6.a + " ,currentThread = " + ThreadMethodProxy.currentThread().getName());
        r6.c.onNext(new j0c.d(o(), new j0c.a(false, "update background too often ,skip current action", null, null, 28), l()));
        r6.c.onComplete();
        return;
    L31:
        return;
    }

    public final void k() {
        ReentrantLock r0 = this.o;
        r0.lock();
        j();     // Catch: Throwable -> L6
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final List<f0c.b> l() {
        List<f0c.d> r0 = this.l;
        monitor-enter(r0);
        List<f0c.d> r1 = this.l;     // Catch: Throwable -> L17
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L17
        Iterator<T> r3 = r1.iterator();     // Catch: Throwable -> L17
    L6:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();     // Catch: Throwable -> L17
        if ((!((f0c.d) r4).d) == false) goto L6;
        r2.add(r4);     // Catch: Throwable -> L17
        goto L6
    L11:
        monitor-exit(r0);
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r6 = r2.iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        r5.add(h((f0c.d) r6.next()));
        goto L14
    L16:
        return r5;
    L17:
        th = move-exception;
        throw th;
    }

    public final f0c.b o() {
        List<f0c.d> r0 = this.l;
        monitor-enter(r0);
        Iterator<T> r1 = this.l.iterator();     // Catch: Throwable -> L17
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();     // Catch: Throwable -> L17
        if (((f0c.d) r2).d == false) goto L6;
    L11:
        f0c.d r3 = (f0c.d) r2;     // Catch: Throwable -> L17
        monitor-exit(r0);
        if (r3 == null) goto L16;
        return h(r3);
    L16:
        return f0c.c.a;
    L10:
        r2 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public static boolean s(com.ss.android.lark.passportc.api.z r1) {
        if ((r1 instanceof com.ss.android.lark.passportc.api.x) == false) goto L5;
    L16:
        return true;
    L5:
        if ((r1 instanceof com.ss.android.lark.passportc.api.w) == true) goto L16;
        if ((r1 instanceof com.ss.android.lark.passportc.api.b) == true) goto L16;
        if ((r1 instanceof com.ss.android.lark.passportc.api.a) == true) goto L16;
        if ((r1 instanceof com.ss.android.lark.passportc.api.a0) == false) goto L15;
        return false;
    L15:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.ss.android.lark.passportc.api.e
    public final void d(final Function1<? super f0c.b, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (this.g.c() == true) goto L7;
        this.k.add(r3);
        final f0c.b r0 = o();
        new PassportStateManagerImpl$addGlobalStateObserver$1(this, r0, r3).invoke();
        return;
    L7:
        throw new IllegalArgumentException("user online refactor is enable, updateUser V1 is not allowed");
    }

    public final f0c.b h(f0c.d r4) {
        UserSession r0 = r4.a;
        User r1 = this.b.a(r4.b);
        if (r1 != null) goto L5;
        r1 = r4.e.getUser();
    L5:
        f0c.g r2 = new f0c.g(r1, r0);
        f0c.h r5 = r4.c;
        lzb.a r3 = r5.getContext();
        return f0c.b.a.a(r2, UserState.OFFLINE, r5, r3);
    }

    public static final boolean e(PassportStateManagerImpl r7, String r8) {
        List<f0c.d> r0 = r7.l;
        monitor-enter(r0);
        Iterator r9 = ((ArrayList) r7.l).iterator();     // Catch: Throwable -> L23
    L6:
        if (r9.hasNext() == false) goto L17;
        Object r1 = r9.next();     // Catch: Throwable -> L23
        f0c.d r4 = (f0c.d) r1;     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r4.b, r8) == true) goto L10;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == false) goto L6;
    L18:
        f0c.d r2 = (f0c.d) r1;     // Catch: Throwable -> L23
        monitor-exit(r0);
        if (r2 == null) goto L33;
        return true;
    L33:
        return false;
    L10:
        if (r4.c.a != UserState.ONLINE) goto L14;
        if (r4.d == false) goto L14;
        r5 = true;
        goto L15
    L17:
        r1 = null;
    L23:
        th = move-exception;
        throw th;
    }

    public final com.ss.android.lark.passportc.internal.f p(f0c.b r2, User r3) {
        if ((r2 instanceof f0c.a) == true) goto L13;
        if ((r2 instanceof f0c.e) == true) goto L13;
        if ((r2 instanceof f0c.f) == false) goto L11;
        return new BackgroundOfflineTransfer(this, r3);
    L11:
        throw new NoWhenBranchMatchedException();
    L13:
        return new f();
    }

    @Override // com.ss.android.lark.passportc.api.l
    public final Observable<j0c.d> b(com.ss.android.lark.passportc.api.z r12, com.ss.android.lark.passportc.api.d r13, lzb.a r14) {
        Intrinsics.checkNotNullParameter(r12, "action");
        Intrinsics.checkNotNullParameter(r13, "executeMode");
        Intrinsics.checkNotNullParameter(r14, "context");
        if (this.g.c() == true) goto L18;
        BehaviorSubject r6 = BehaviorSubject.create();
        Log.i("n_action_cm_global_manager_impl", "updateUser, update_type =" + r12 + " scene=" + r13.d + " executeTask=" + r13.a);
        long r8 = SystemClock.elapsedRealtime();
        com.ss.android.lark.log.trace.b r1 = m0c.d.a;
        Scene r2 = r13.d;
        Intrinsics.checkNotNullParameter(r12, "action");
        com.ss.android.lark.log.trace.b r0 = m0c.d.a(r2);
        StepTrace r3 = null;
        if (r0 != null) goto L7;
    L12:
        StepTrace r4 = null;
    L13:
        if (r4 == null) goto L15;
        StepTrace.b(r4);
        r3 = r4;
    L15:
        this.i.f();
        this.i.b("rust_infra_update_user_" + r12.a());
        return r6.hide().lift(new com.ss.android.lark.utils.rxjava.c(new Throwable().getStackTrace())).mergeWith(Completable.fromAction(new h(this, r12, r13, r6, r14))).doOnNext(new i(r8, this, r12)).doOnError(j.a).doOnComplete(new k(this, r3, r8));
    L7:
        if ((r12 instanceof com.ss.android.lark.passportc.api.w) == false) goto L10;
        r4 = r0.a(m0c.d.b);
        goto L13
    L10:
        if ((r12 instanceof com.ss.android.lark.passportc.api.a) == false) goto L12;
        r4 = r0.a(m0c.d.d);
        goto L13
    L18:
        throw new IllegalArgumentException("user online refactor is enable, updateUser V1 is not allowed");
    }

    public final void m(ArrayList<u> r2, List<? extends User> r3, lzb.a r4) {
        monitor-enter(r2);
        r2.addAll(n(r3, null, r4));     // Catch: Throwable -> L7
        monitor-exit(r2);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<u> n(List<? extends User> r10, Function1<? super User, Unit> r11, lzb.a r12) {
        ArrayList r0 = new ArrayList();
        if (r10.isEmpty() == false) goto L14;
        Iterator r13 = ((ArrayList) l()).iterator();
    L6:
        if (r13.hasNext() == false) goto L75;
        f0c.b r14 = (f0c.b) r13.next();
        f0c.g r15 = r14.a();
        if (r15 == null) goto L10;
        User r16 = r15.a;
    L11:
        if (r16 != null) goto L12;
        r0.add(new d("offline background , user is null"));
        goto L6
    L12:
        r0.add(p(r14, r16));
        goto L6
    L10:
        r16 = null;
    L75:
        return r0;
    L14:
        Iterator<? extends User> r1 = r10.iterator();
    L16:
        if (r1.hasNext() == false) goto L49;
        User r3 = r1.next();
        String r4 = r3.userId;
        f0c.g r5 = o().a();
        if (r5 == null) goto L22;
        UserSession r6 = r5.b;
        if (r6 == null) goto L22;
        String r7 = r6.b;
    L24:
        if (Intrinsics.areEqual(r4, r7) == false) goto L28;
        if (o().b.a != UserState.ONLINE) goto L28;
        r0.add(new c());
    L28:
        Iterator r8 = ((ArrayList) l()).iterator();
    L30:
        if (r8.hasNext() == false) goto L45;
        Object r9 = r8.next();
        f0c.b r17 = (f0c.b) r9;
        f0c.g r18 = r17.a();
        if (r18 == null) goto L36;
        User r19 = r18.a;
        if (r19 == null) goto L36;
        String r20 = r19.userId;
    L38:
        if (Intrinsics.areEqual(r20, r3.userId) == true) goto L40;
    L42:
        boolean r21 = false;
    L43:
        if (r21 == false) goto L30;
    L47:
        if (((f0c.b) r9) != null) goto L16;
        r0.add(q(f0c.c.a, r3, r11, r12));
        goto L16
    L40:
        if (r17.b.a != UserState.ONLINE) goto L42;
        r21 = true;
    L36:
        r20 = null;
        goto L38
    L45:
        r9 = null;
    L22:
        r7 = null;
        goto L24
    L49:
        Iterator r2 = ((ArrayList) l()).iterator();
    L51:
        if (r2.hasNext() == false) goto L75;
        f0c.b r22 = (f0c.b) r2.next();
        Iterator<T> r23 = r10.iterator();
    L54:
        if (r23.hasNext() == false) goto L64;
        Object r24 = r23.next();
        String r25 = ((User) r24).userId;
        f0c.g r26 = r22.a();
        if (r26 == null) goto L60;
        User r27 = r26.a;
        if (r27 == null) goto L60;
        String r28 = r27.userId;
    L62:
        if (Intrinsics.areEqual(r25, r28) == false) goto L54;
    L65:
        User r29 = (User) r24;
        if (r29 != null) goto L67;
        f0c.g r30 = r22.a();
        if (r30 == null) goto L71;
        User r31 = r30.a;
    L72:
        if (r31 != null) goto L73;
        r0.add(new d("offline background,user is null"));
        goto L51
    L73:
        r0.add(p(r22, r31));
        goto L51
    L71:
        r31 = null;
        goto L72
    L67:
        r0.add(q(r22, r29, r11, r12));
    L60:
        r28 = null;
        goto L62
    L64:
        r24 = null;
        goto L65
    }

    public final Map<String, List<u>> r(com.ss.android.lark.passportc.api.z r16, com.ss.android.lark.passportc.api.d r17, lzb.a r18) {
        f0c.b r9 = o();
        ArrayList r10 = new ArrayList();
        ArrayList<u> r1 = new ArrayList();
        HashMap r11 = new HashMap();
        r11.put("foreground user transfer", r10);
        r11.put("background user transfer", r1);
        monitor-enter(r10);
    L84:
        th = move-exception;
        throw th;
    L5:
        if ((r16 instanceof com.ss.android.lark.passportc.api.x) == true) goto L7;
        boolean r12 = false;
        UserSession r3 = null;
        Object r4 = null;
        if ((r16 instanceof com.ss.android.lark.passportc.api.w) == false) goto L52;
        if ((r9 instanceof f0c.a) == false) goto L28;
    L47:
        r10.add(new f());     // Catch: Throwable -> L84
        if (r16.b == false) goto L50;
        m(r1, r16.a, r18);     // Catch: Throwable -> L84
    L50:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L84
    L82:
        monitor-exit(r10);
        return r11;
    L28:
        if ((r9 instanceof f0c.e) == true) goto L47;
        if ((r9 instanceof f0c.f) == false) goto L46;
        r10.add(new OfflineTransfer(this, ((f0c.f) r9).c, r18));     // Catch: Throwable -> L84
        Iterator<T> r2 = r16.a.iterator();     // Catch: Throwable -> L84
    L34:
        if (r2.hasNext() == false) goto L38;
        Object r5 = r2.next();     // Catch: Throwable -> L84
        if (Intrinsics.areEqual(((User) r5).userId, ((f0c.f) r9).c.a.userId) == false) goto L34;
        r4 = r5;
    L38:
        if (r4 == null) goto L40;
        r12 = true;
    L40:
        if (r12 == false) goto L43;
        r17.d = Scene.SWITCH_BACKGROUND;     // Catch: Throwable -> L84
    L43:
        if (r16.b == false) goto L50;
        m(r1, r16.a, r18);     // Catch: Throwable -> L84
        goto L50
    L46:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L84
    L52:
        if ((r16 instanceof com.ss.android.lark.passportc.api.b) == false) goto L66;
        if ((r9 instanceof f0c.a) == false) goto L56;
    L63:
        ((com.ss.android.lark.passportc.api.b) r16).getClass();     // Catch: Throwable -> L84
        throw null;     // Catch: Throwable -> L84
    L56:
        if ((r9 instanceof f0c.e) == true) goto L63;
        if ((r9 instanceof f0c.f) == false) goto L62;
        String r6 = ((f0c.f) r9).c.b.b;     // Catch: Throwable -> L84
        ((com.ss.android.lark.passportc.api.b) r16).getClass();     // Catch: Throwable -> L84
        throw null;     // Catch: Throwable -> L84
    L62:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L84
    L66:
        if ((r16 instanceof com.ss.android.lark.passportc.api.a) == false) goto L81;
        f0c.g r7 = r9.a();     // Catch: Throwable -> L84
        if (r7 == null) goto L70;
        r3 = r7.b;     // Catch: Throwable -> L84
    L70:
        SwapTransfer r14 = new SwapTransfer(this, r3, a.a(((com.ss.android.lark.passportc.api.a) r16).c.userId), ((com.ss.android.lark.passportc.api.a) r16).c, r18);     // Catch: Throwable -> L84
        if ((r9 instanceof f0c.a) == false) goto L73;
    L80:
        r10.add(r14);     // Catch: Throwable -> L84
        goto L82
    L73:
        if ((r9 instanceof f0c.e) == true) goto L80;
        if ((r9 instanceof f0c.f) == false) goto L79;
        this.h.b(((com.ss.android.lark.passportc.api.a) r16).c.userId);     // Catch: Throwable -> L84
        r10.add(new b(new u[]{new OfflineTransfer(this, ((f0c.f) r9).c, r18), r14}));     // Catch: Throwable -> L84
        goto L82
    L79:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L84
    L81:
        r10.add(new d("updateAction should be foreground"));     // Catch: Throwable -> L84
        goto L82
    L7:
        if ((r9 instanceof f0c.a) == false) goto L10;
        r10.add(new d("current foreground user is null, can't make it online."));     // Catch: Throwable -> L84
        goto L82
    L10:
        if ((r9 instanceof f0c.f) == false) goto L16;
        r10.add(new f());     // Catch: Throwable -> L84
        if (r16.b == false) goto L14;
        m(r1, r16.a, r18);     // Catch: Throwable -> L84
    L14:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L84
        goto L82
    L16:
        if ((r9 instanceof f0c.e) == false) goto L22;
        r10.add(new OnlineTransfer(this, ((f0c.e) r9).c.b, ((f0c.e) r9).c.a, r18));     // Catch: Throwable -> L84
        if (r16.b == false) goto L20;
        m(r1, r16.a, r18);     // Catch: Throwable -> L84
    L20:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L84
        goto L82
    L22:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L84
    }

    public static void t(final PassportStateManagerImpl r10, Function0 r11, Function1 r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        r11 = PassportStateManagerImpl$updateUserContextList$1.INSTANCE;
    L5:
        UserSession r0 = null;
        if ((r13 & 2) == 0) goto L8;
        PassportStateManagerImpl$updateUserContextList$2 r14 = PassportStateManagerImpl$updateUserContextList$2.INSTANCE;
    L9:
        r10.getClass();
        if (((Boolean) r11.invoke()).booleanValue() == false) goto L72;
        List<f0c.d> r15 = r10.l;
        monitor-enter(r15);
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L58
        List<f0c.d> r2 = r10.l;     // Catch: Throwable -> L58
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));     // Catch: Throwable -> L58
        Iterator r3 = ((ArrayList) r2).iterator();     // Catch: Throwable -> L58
    L16:
        if (r3.hasNext() == false) goto L18;
        f0c.d r4 = (f0c.d) r3.next();     // Catch: Throwable -> L58
        Pair r5 = TuplesKt.to(r4.a, r4.e);     // Catch: Throwable -> L58
        r6.put(r5.getFirst(), r5.getSecond());     // Catch: Throwable -> L58
        goto L16
    L18:
        r1.putAll(r6);     // Catch: Throwable -> L58
        f0c.b r7 = r10.o();     // Catch: Throwable -> L58
        List<f0c.d> r8 = r10.l;     // Catch: Throwable -> L58
        LinkedHashMap r9 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));     // Catch: Throwable -> L58
        Iterator r16 = ((ArrayList) r8).iterator();     // Catch: Throwable -> L58
    L20:
        if (r16.hasNext() == false) goto L22;
        f0c.d r17 = (f0c.d) r16.next();     // Catch: Throwable -> L58
        Pair r18 = TuplesKt.to(r17.a, r17.c);     // Catch: Throwable -> L58
        r9.put(r18.getFirst(), r18.getSecond());     // Catch: Throwable -> L58
        goto L20
    L22:
        m0c.b.a(r10.c, "n_action_cm_global_manager_impl", "updateAction start: " + r10.l);     // Catch: Throwable -> L58
        r12.invoke(r10.l);     // Catch: Throwable -> L58
        List<f0c.d> r19 = r10.l;     // Catch: Throwable -> L58
        LinkedHashMap r20 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r19, 10)), 16));     // Catch: Throwable -> L58
        Iterator r110 = ((ArrayList) r19).iterator();     // Catch: Throwable -> L58
    L24:
        if (r110.hasNext() == false) goto L26;
        f0c.d r21 = (f0c.d) r110.next();     // Catch: Throwable -> L58
        Pair r22 = TuplesKt.to(r21.a, r21.e);     // Catch: Throwable -> L58
        r20.put(r22.getFirst(), r22.getSecond());     // Catch: Throwable -> L58
        goto L24
    L26:
        r1.putAll(r20);     // Catch: Throwable -> L58
        m0c.b.a(r10.c, "n_action_cm_global_manager_impl", "updateAction end: " + r10.l);     // Catch: Throwable -> L58
        final f0c.b r111 = r10.o();     // Catch: Throwable -> L58
        List<f0c.d> r23 = r10.l;     // Catch: Throwable -> L58
        LinkedHashMap r24 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r23, 10)), 16));     // Catch: Throwable -> L58
        Iterator r25 = ((ArrayList) r23).iterator();     // Catch: Throwable -> L58
    L28:
        if (r25.hasNext() == false) goto L30;
        f0c.d r26 = (f0c.d) r25.next();     // Catch: Throwable -> L58
        Pair r27 = TuplesKt.to(r26.a, r26.c);     // Catch: Throwable -> L58
        r24.put(r27.getFirst(), r27.getSecond());     // Catch: Throwable -> L58
        goto L28
    L30:
        Intrinsics.checkNotNullParameter(r7, "foregroundSnapshot");     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r9, "userSnapshots");     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r111, "currentForegroundState");     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r24, "currentUserStates");     // Catch: Throwable -> L58
        Intrinsics.checkNotNullParameter(r1, "userMap");     // Catch: Throwable -> L58
        monitor-exit(r15);
        if (r7.b.a != r111.b.a) goto L43;
        f0c.g r112 = r7.a();
        if (r112 == null) goto L37;
        UserSession r113 = r112.b;
    L38:
        f0c.g r28 = r111.a();
        if (r28 == null) goto L42;
        r0 = r28.b;
    L42:
        if (com.ss.android.lark.passportc.convention.d.a(r113, r0) == true) goto L43;
    L44:
        Iterator r114 = r1.entrySet().iterator();
    L46:
        if (r114.hasNext() == false) goto L56;
        Map.Entry r115 = (Map.Entry) r114.next();
        UserSession r29 = (UserSession) r115.getKey();
        final g0 r116 = (g0) r115.getValue();
        f0c.h r30 = (f0c.h) r9.get(r29);
        if (r30 != null) goto L50;
        r30 = f0c.i.a;
    L50:
        final f0c.h r31 = (f0c.h) r24.get(r29);
        if (r31 != null) goto L54;
        r31 = f0c.i.a;
    L54:
        if (Intrinsics.areEqual(r31, r30) == true) goto L46;
        m0c.b.a(r10.c, "n_action_cm_global_manager_impl", "notifyUserState,userSession= " + r29 + ", currentState: " + r31);
        Log.i("n_action_cm_global_manager_impl", "notifyUserState, state=" + r31.a + ", scene=" + r31.b);
        new PassportStateManagerImpl$notifyUserState$1(r116, r31).invoke();
        goto L46
    L56:
        ((Boolean) r14.invoke()).booleanValue();
        return;
    L37:
        r113 = null;
    L43:
        m0c.b.a(r10.c, "n_action_cm_global_manager_impl", "notifyGlobalState currentForegroundState: " + r111);
        new PassportStateManagerImpl$notifyGlobalState$1(r10, r111).invoke();
    L58:
        th = move-exception;
        throw th;
    L72:
        return;
    L8:
        r14 = null;
        goto L9
    }

    public final void i(List<? extends u> r17, com.ss.android.lark.passportc.api.d r18, j0c.a r19, Function1<? super j0c.a, Unit> r20) {
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = r19;
        List<? extends u> r0 = r17;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        r20.invoke(r8.element);
    L16:
        return;
    L12:
        int r10 = r17.size();
        Ref.IntRef r11 = new Ref.IntRef();
        Iterator<T> r12 = r17.iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        u r2 = (u) r12.next();
        this.n.execute(new g(r2, r18, r17, r11, r8, r10, r20));
        goto L14
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final com.ss.android.lark.passportc.internal.f q(f0c.b r7, User r8, Function1 r9, lzb.a r10) {
        if ((r7 instanceof f0c.f) == false) goto L6;
        return new f();
    L6:
        if ((r7 instanceof f0c.a) == true) goto L13;
        if ((r7 instanceof f0c.e) == true) goto L13;
        throw new NoWhenBranchMatchedException();
    L13:
        return new BackgroundOnlineTransfer(this, a.a(r8.userId), r8, r9, r10);
    }

    public final void u(com.ss.android.lark.passportc.api.z r9, com.ss.android.lark.passportc.api.d r10, BehaviorSubject<j0c.d> r11, lzb.a r12) {
        Log.i("n_action_cm_global_manager_impl", "before execute updateUserV2");
        this.m.execute(new l(this, r9, r10, r11, r12));
    }

    public static final void f(final PassportStateManagerImpl r3, com.ss.android.lark.passportc.api.z r4, com.ss.android.lark.passportc.api.d r5, final BehaviorSubject r6, lzb.a r7) {
        Log.i("n_action_cm_global_manager_impl", "updateBackgroundUser, update_type = " + r4);
        Function1<? super User, Unit> r0 = PassportStateManagerImpl$updateBackgroundUsers$backgroundTransfers$1.INSTANCE;
        ArrayList r1 = new ArrayList();
        monitor-enter(r1);
    L17:
        th = move-exception;
        throw th;
    L5:
        if ((r4 instanceof com.ss.android.lark.passportc.api.a0) == false) goto L7;
        r1.addAll(r3.n(r4.a, r0, r7));     // Catch: Throwable -> L17
    L8:
        monitor-exit(r1);
        j0c.a r8 = com.ss.android.lark.passportc.task.i.a;     // Catch: Throwable -> L14
        if (r5.e != ReturnType.Foreground) goto L12;
        Log.i("n_action_cm_global_manager_impl", "updateBackgroundUser, return Foreground");     // Catch: Throwable -> L14
        r6.onNext(new j0c.d(r3.o(), r8, r3.l()));     // Catch: Throwable -> L14
    L12:
        r3.i(r1, r5, r8, new PassportStateManagerImpl$updateBackgroundUsers$1(r6, r3));     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Log.i("n_action_cm_global_manager_impl", "updateBackgroundUser error = " + ExceptionsKt.stackTraceToString(th));
        r6.onError(th);
        r3.k();
        return;
    L7:
        r1.add(new d("background can‘t resolve foreground action"));     // Catch: Throwable -> L17
        goto L8
    }

    public static final void g(final PassportStateManagerImpl r4, com.ss.android.lark.passportc.api.z r5, com.ss.android.lark.passportc.api.d r6, final BehaviorSubject r7, lzb.a r8) {
        Log.i("n_action_cm_global_manager_impl", "updateMultiUsers, action :{" + r5 + '}');
        HashMap r9 = (HashMap) r4.r(r5, r6, r8);     // Catch: Throwable -> L25
        List r10 = (List) r9.get("foreground user transfer");     // Catch: Throwable -> L25
        j0c.a r1 = com.ss.android.lark.passportc.task.i.a;     // Catch: Throwable -> L25
        if (r10 == null) goto L18;
        monitor-enter(r10);     // Catch: Throwable -> L25
        Iterator r2 = r10.iterator();     // Catch: Throwable -> L14
    L8:
        if (r2.hasNext() == false) goto L11;
        r1 = r1.a(((u) r2.next()).a(r6));     // Catch: Throwable -> L14
        if (r1.a == true) goto L8;
    L11:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L25
        goto L18
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L18:
        if (r1.a == true) goto L21;
        r7.onNext(new j0c.d(r4.o(), r1));     // Catch: Throwable -> L25
        r7.onComplete();     // Catch: Throwable -> L25
        r4.j();     // Catch: Throwable -> L25
        return;
    L21:
        if (r6.e != ReturnType.Foreground) goto L23;
        r7.onNext(new j0c.d(r4.o(), r1));     // Catch: Throwable -> L25
    L23:
        r4.i((List) r9.get("background user transfer"), r6, r1, new PassportStateManagerImpl$updateMultiUsers$2(r7, r4));     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        Log.i("n_action_cm_global_manager_impl", "updateMultiUsers error = " + ExceptionsKt.stackTraceToString(th));
        r7.onError(th);
        if (0 == 0) goto L29;
        r4.k();
        return;
    L29:
        r4.j();
    }

    @Inject
    public PassportStateManagerImpl(z r2, p r3, com.ss.android.lark.log.c r4, Set<com.ss.android.lark.passportc.task.d> r5, com.ss.android.lark.passportc.task.g r6, l0c.d r7, com.ss.android.lark.passportc.api.i r8, com.ss.android.lark.passportc.api.f r9, l0c.c r10, t r11) {
        Intrinsics.checkNotNullParameter(r2, "userComponentManagerDelegate");
        Intrinsics.checkNotNullParameter(r3, "userDataSource");
        Intrinsics.checkNotNullParameter(r4, "logger");
        Intrinsics.checkNotNullParameter(r5, "globalOnlineTasks");
        Intrinsics.checkNotNullParameter(r6, "taskOrder");
        Intrinsics.checkNotNullParameter(r7, "taskMonitor");
        Intrinsics.checkNotNullParameter(r8, "multiOnlineFg");
        Intrinsics.checkNotNullParameter(r9, "backgroundUserService");
        Intrinsics.checkNotNullParameter(r10, "userFlowMonitor");
        Intrinsics.checkNotNullParameter(r11, "executors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = Collections.synchronizedSet(new LinkedHashSet());
        this.l = new ArrayList();
        this.m = r11.h();
        this.n = r11.f();
        this.o = new ReentrantLock();
        this.p = new AtomicBoolean(false);
        this.q = new ConcurrentLinkedQueue();
    }
}
