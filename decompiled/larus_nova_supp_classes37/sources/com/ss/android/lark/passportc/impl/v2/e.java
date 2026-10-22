package com.ss.android.lark.passportc.impl.v2;

import android.os.SystemClock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import com.ss.android.lark.passportc.impl.v2.state.AllUserState;
import f0c.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class e implements d {
    public final l0c.c a;
    public final ConcurrentHashMap<Integer, b> b;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public long b;
        public long c;
        public long d;
        public long e;
        public long f;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            long r1 = this.b;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r3 = this.c;
            int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r5 = this.d;
            int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
            long r7 = this.e;
            int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
            long r9 = this.f;
            return r8 + ((int) (r9 ^ (r9 >>> 32)));
        }

        public final String toString() {
            return "UpdateRequestVisitContext(requestId=" + this.a + ", requestStartTime=" + this.b + ", onlineStartTime=" + this.c + ", offlineStartTime=" + this.d + ", updateOnlineStartTime=" + this.e + ", updateOfflineStartTime=" + this.f + ')';
        }

        public b(int r3) {
            this.a = r3;
            this.b = Long.MAX_VALUE;
            this.c = Long.MAX_VALUE;
            this.d = Long.MAX_VALUE;
            this.e = Long.MAX_VALUE;
            this.f = Long.MAX_VALUE;
        }
    }

    static {
    }

    @Inject
    public e(l0c.c r2) {
        Intrinsics.checkNotNullParameter(r2, "userFlowMonitor");
        this.a = r2;
        this.b = new ConcurrentHashMap();
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void q(com.ss.android.lark.passportc.impl.v2.entity.a r3) {
        Intrinsics.checkNotNullParameter(r3, "stateDiffResult");
        Log.i("UserUpdateVisitor", "[updateUser], diffResult: " + r3);
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void c(UpdateUserRequest r5, com.ss.android.lark.passportc.api.d r6) {
        Intrinsics.checkNotNullParameter(r5, "updateRequest");
        Intrinsics.checkNotNullParameter(r6, "executeMode");
        b r7 = this.b.get(Integer.valueOf(r5.c));
        if (r7 == null) goto L5;
        long r0 = SystemClock.elapsedRealtime() - r7.b;
    L6:
        Log.i("UserUpdateVisitor", "[updateUser], disposed, reqId:" + r5.c + ", cost:" + r0 + "ms");
        Log.i("UserUpdateVisitor", "[updateUser], ----------------");
        this.b.remove(Integer.valueOf(r5.c));
        this.a.d();
        return;
    L5:
        r0 = -1;
        goto L6
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void e(AllUserState r2, AllUserState r3) {
        Intrinsics.checkNotNullParameter(r2, "oldState");
        Intrinsics.checkNotNullParameter(r3, "newState");
        if (Intrinsics.areEqual(r3, r2) == false) goto L5;
        return;
    L5:
        Log.i("UserUpdateVisitor", "[stateUpdate], newState: count=" + r3.a.size() + " \n" + r3);
    }

    @Override // h0c.f
    public final void f(UpdateUserContext r3, i0c.d r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "transition");
        Log.i("UserUpdateVisitor", "[stateTransit], state transition start, reqId:" + r3.a + ", context:" + r3.hashCode() + ", uid:" + r3.c.userId + ", transition:{" + r4.getFrom() + " -> " + r4.getTo() + '}');
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void i(UpdateUserRequest r4, com.ss.android.lark.passportc.api.d r5) {
        Intrinsics.checkNotNullParameter(r4, "updateRequest");
        Intrinsics.checkNotNullParameter(r5, "executeMode");
        Log.i("UserUpdateVisitor", "[updateUser], ----------------");
        Log.i("UserUpdateVisitor", "[updateUser], start, request:" + r4 + ", executeMode:{scene:" + r5.d + ", strategy:" + r5.b + '}');
        ConcurrentHashMap<Integer, b> r6 = this.b;
        Integer r0 = Integer.valueOf(r4.c);
        b r1 = r6.get(r0);
        if (r1 != null) goto L8;
        r1 = new b(r4.c);
        b r7 = r6.putIfAbsent(r0, r1);
        if (r7 == null) goto L8;
        r1 = r7;
    L8:
        r1.b = SystemClock.elapsedRealtime();
        this.a.f();
        this.a.b("rust_infra_update_user_");
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void r(UpdateUserRequest r5, com.ss.android.lark.passportc.api.d r6) {
        Intrinsics.checkNotNullParameter(r5, "updateRequest");
        Intrinsics.checkNotNullParameter(r6, "executeMode");
        b r7 = this.b.get(Integer.valueOf(r5.c));
        if (r7 == null) goto L5;
        long r0 = SystemClock.elapsedRealtime() - r7.b;
    L6:
        Log.i("UserUpdateVisitor", "[updateUser], complete, reqId:" + r5.c + ", cost:" + r0 + "ms");
        Log.i("UserUpdateVisitor", "[updateUser], ----------------");
        this.b.remove(Integer.valueOf(r5.c));
        this.a.d();
        return;
    L5:
        r0 = -1;
        goto L6
    }

    @Override // h0c.f
    public final void d(UpdateUserContext r3, UserState r4, UserState r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "fromState");
        Intrinsics.checkNotNullParameter(r5, "toState");
        Log.i("UserUpdateVisitor", "[stateTransit], fireState start, reqId:" + r3.a + ", context:" + r3.hashCode() + ", uid:" + r3.c.userId + ", " + r4 + " -> " + r5);
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void h(UpdateUserRequest r5, com.ss.android.lark.passportc.api.d r6, com.ss.android.lark.passportc.impl.v2.entity.c r7) {
        Intrinsics.checkNotNullParameter(r5, "updateRequest");
        Intrinsics.checkNotNullParameter(r6, "executeMode");
        Intrinsics.checkNotNullParameter(r7, "updateResult");
        b r8 = this.b.get(Integer.valueOf(r5.c));
        if (r8 == null) goto L5;
        long r0 = SystemClock.elapsedRealtime() - r8.b;
    L6:
        StringBuilder r9 = new StringBuilder("[updateUser], next, reqId:");
        r9.append(r5.c);
        r9.append(", result:{");
        f0c.b r10 = r7.a;
        StringBuilder r11 = new StringBuilder("{uid=");
        g r2 = r10.a();
        if (r2 == null) goto L11;
        User r3 = r2.a;
        if (r3 == null) goto L11;
        String r4 = r3.userId;
    L12:
        r11.append(r4);
        r11.append(", state:");
        r11.append(r10.b.a);
        r11.append("}}");
        r9.append(r11.toString());
        r9.append(", cost:");
        r9.append(r0);
        r9.append("ms}");
        Log.i("UserUpdateVisitor", r9.toString());
        this.a.i("rust_infra_update_user_");
        return;
    L11:
        r4 = null;
        goto L12
    L5:
        r0 = -1;
        goto L6
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void j(UpdateUserRequest r5, com.ss.android.lark.passportc.api.d r6, Throwable r7) {
        Intrinsics.checkNotNullParameter(r5, "updateRequest");
        Intrinsics.checkNotNullParameter(r6, "executeMode");
        Intrinsics.checkNotNullParameter(r7, "error");
        b r8 = this.b.get(Integer.valueOf(r5.c));
        if (r8 == null) goto L5;
        long r0 = SystemClock.elapsedRealtime() - r8.b;
    L6:
        Log.e("UserUpdateVisitor", "[updateUser], error, reqId:" + r5.c + ", cost:" + r0 + "ms", r7);
        Log.i("UserUpdateVisitor", "[updateUser], ----------------");
        this.b.remove(Integer.valueOf(r5.c));
        this.a.d();
        return;
    L5:
        r0 = -1;
        goto L6
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void m(UpdateUserContext r2, UserState r3, UserState r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "from");
        Intrinsics.checkNotNullParameter(r4, "to");
        b r5 = this.b.get(Integer.valueOf(r2.a));
        if (r5 == null) goto L5;
        r5.d = SystemClock.elapsedRealtime();
    L5:
        this.a.b("rust_infra_transfer_offline");
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void p(UpdateUserContext r2, UserState r3, UserState r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "from");
        Intrinsics.checkNotNullParameter(r4, "to");
        b r5 = this.b.get(Integer.valueOf(r2.a));
        if (r5 == null) goto L5;
        r5.c = SystemClock.elapsedRealtime();
    L5:
        this.a.b("rust_infra_transfer_online");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h0c.f
    public final void s(UpdateUserContext r9, i0c.d r10, h0c.b r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "transition");
        Intrinsics.checkNotNullParameter(r11, "result");
        r11.getClass();
        if ((r11 instanceof h0c.b.c) == false) goto L12;
        j0c.a r12 = (j0c.a) r11.a;
        if (r12 == null) goto L9;
        boolean r5 = true;
        if (r12.a != true) goto L9;
    L10:
        if (r5 == false) goto L12;
        Log.i("UserUpdateVisitor", "[stateTransit], state transition end, reqId:" + r9.a + ", context:" + r9.hashCode() + ", uid:" + r9.c.userId + ", result:{isSuccess=true, errorMessage=" + ((j0c.a) r11.a).b + '}');
        return;
    L9:
        r5 = false;
    L12:
        j0c.a r6 = (j0c.a) r11.a;
        if (r6 == null) goto L16;
        String r7 = r6.b;
        if (r7 == null) goto L16;
    L17:
        StringBuilder r13 = new StringBuilder(r7);
        j0c.a r14 = (j0c.a) r11.a;
        if (r14 == null) goto L25;
        List<j0c.c> r15 = r14.d;
        if (r15 == null) goto L25;
        Iterator<T> r16 = r15.iterator();
    L23:
        if (r16.hasNext() == false) goto L25;
        j0c.c r8 = (j0c.c) r16.next();
        r13.append(r8.a + ", " + r8.d + "; ");
    L25:
        Log.e("UserUpdateVisitor", "[stateTransit], state transition end, reqId:" + r9.a + ", context:" + r9.hashCode() + ", uid:" + r9.c.userId + ", result:{isSuccess=false, errorMessage=" + r13 + '}');
        return;
    L16:
        r7 = "";
        goto L17
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void a(UpdateUserContext r3, UserState r4, UserState r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "to");
        if (r6 == true) goto L5;
        return;
    L5:
        b r7 = this.b.get(Integer.valueOf(r3.a));
        if (r7 == null) goto L8;
        long r8 = SystemClock.elapsedRealtime() - r7.f;
    L9:
        this.a.g(r8);
        Log.i("UserUpdateVisitor", "foreground offline transfer, notifyConvention cost:" + r8 + "ms");
        return;
    L8:
        r8 = -1;
        goto L9
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void b(UpdateUserContext r2, UserState r3, UserState r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "from");
        Intrinsics.checkNotNullParameter(r4, "to");
        if (r5 == true) goto L5;
        return;
    L5:
        b r6 = this.b.get(Integer.valueOf(r2.a));
        if (r6 == null) goto L9;
        r6.f = SystemClock.elapsedRealtime();
        return;
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void g(UpdateUserContext r3, UserState r4, UserState r5, h0c.b<j0c.a> r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "to");
        Intrinsics.checkNotNullParameter(r6, "result");
        this.a.i("rust_infra_transfer_online");
        b r7 = this.b.get(Integer.valueOf(r3.a));
        if (r7 == null) goto L5;
        long r8 = SystemClock.elapsedRealtime() - r7.c;
    L6:
        Log.i("UserUpdateVisitor", "foreground online transfer, component task cost:" + r8 + "ms");
        return;
    L5:
        r8 = -1;
        goto L6
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void k(UpdateUserContext r3, UserState r4, UserState r5, h0c.b.c r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "to");
        Intrinsics.checkNotNullParameter(r6, "result");
        b r7 = this.b.get(Integer.valueOf(r3.a));
        if (r7 == null) goto L5;
        long r8 = SystemClock.elapsedRealtime() - r7.d;
    L6:
        Log.i("UserUpdateVisitor", "foreground offline transfer, component task cost:" + r8 + "ms");
        this.a.i("rust_infra_transfer_offline");
        return;
    L5:
        r8 = -1;
        goto L6
    }

    @Override // h0c.f
    public final void l(UpdateUserContext r2, UserState r3, UserState r4, h0c.b r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fromState");
        Intrinsics.checkNotNullParameter(r4, "toState");
        Intrinsics.checkNotNullParameter(r5, "results");
        Log.i("UserUpdateVisitor", "[stateTransit], fireState end, reqId:" + r2.a + ", context:" + r2.hashCode() + ", uid:" + r2.c.userId + ", result:{success:" + (r5 instanceof h0c.b.c) + '}');
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void n(UpdateUserContext r3, UserState r4, UserState r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "from");
        Intrinsics.checkNotNullParameter(r5, "to");
        if (r6 == true) goto L5;
        return;
    L5:
        b r7 = this.b.get(Integer.valueOf(r3.a));
        if (r7 == null) goto L8;
        long r8 = SystemClock.elapsedRealtime() - r7.e;
    L9:
        this.a.g(r8);
        Log.i("UserUpdateVisitor", "foreground online transfer, notifyConvention cost:" + r8 + "ms");
        return;
    L8:
        r8 = -1;
        goto L9
    }

    @Override // com.ss.android.lark.passportc.impl.v2.d
    public final void o(UpdateUserContext r2, UserState r3, UserState r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "from");
        Intrinsics.checkNotNullParameter(r4, "to");
        if (r5 == true) goto L5;
        return;
    L5:
        b r6 = this.b.get(Integer.valueOf(r2.a));
        if (r6 == null) goto L9;
        r6.e = SystemClock.elapsedRealtime();
        return;
    }
}
