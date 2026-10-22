package com.ss.android.lark.passportc.impl.v2.state;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.internal.p;
import com.ss.android.lark.passportc.internal.r;
import f0c.d;
import f0c.g;
import f0c.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AllUserState {
    public final List<d> a;
    public final p b;

    public final List<f0c.b> c() {
        List<d> r0 = this.a;
        monitor-enter(r0);
        List<d> r1 = this.a;     // Catch: Throwable -> L17
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L17
        Iterator<T> r3 = r1.iterator();     // Catch: Throwable -> L17
    L6:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();     // Catch: Throwable -> L17
        if ((!((d) r4).d) == false) goto L6;
        r2.add(r4);     // Catch: Throwable -> L17
        goto L6
    L11:
        monitor-exit(r0);
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r6 = r2.iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        r5.add(a((d) r6.next()));
        goto L14
    L16:
        return r5;
    L17:
        th = move-exception;
        throw th;
    }

    public final f0c.b d() {
        List<d> r0 = this.a;
        monitor-enter(r0);
        Iterator<T> r1 = this.a.iterator();     // Catch: Throwable -> L17
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();     // Catch: Throwable -> L17
        if (((d) r2).d == false) goto L6;
    L11:
        d r3 = (d) r2;     // Catch: Throwable -> L17
        monitor-exit(r0);
        if (r3 == null) goto L16;
        return a(r3);
    L16:
        return new f0c.a(null, UserState.ABSENT, r.a);
    L10:
        r2 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        List r0 = CollectionsKt.toMutableList(this.a);
        CollectionsKt.sort(r0);
        return "[" + CollectionsKt.joinToString$default(r0, "\n", null, null, 0, null, new AnonymousClass1(this), 30, null) + ']';
    }

    public final f0c.b a(d r4) {
        UserSession r0 = r4.a;
        User r1 = this.b.a(r4.b);
        if (r1 != null) goto L5;
        r1 = r4.e.getUser();
    L5:
        g r2 = new g(r1, r0);
        UserState r3 = UserState.ABSENT;
        h r5 = r4.c;
        return f0c.b.a.a(r2, r3, r5, r5.getContext());
    }

    public final d e(Function1<? super d, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "find");
        List<d> r0 = this.a;
        monitor-enter(r0);
        Iterator<T> r1 = this.a.iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L10;
        Object r2 = r1.next();     // Catch: Throwable -> L14
        if (((Boolean) r5.invoke(r2)).booleanValue() == false) goto L6;
    L11:
        d r3 = (d) r2;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return r3;
    L10:
        r2 = null;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if ((r9 instanceof AllUserState) == true) goto L8;
        return false;
    L8:
        AllUserState r10 = (AllUserState) r9;
        if (this.a.size() == r10.a.size()) goto L11;
        return false;
    L11:
        List<d> r1 = this.a;
        LinkedHashMap r4 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r1, 10)), 16));
        Iterator<T> r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        r4.put(((d) r3).a.b, r3);
        goto L13
    L15:
        Iterator r5 = r4.entrySet().iterator();
    L17:
        if (r5.hasNext() == false) goto L37;
        Map.Entry r6 = (Map.Entry) r5.next();
        String r7 = (String) r6.getKey();
        d r8 = (d) r6.getValue();
        Iterator<T> r11 = r10.a.iterator();
    L20:
        if (r11.hasNext() == false) goto L24;
        Object r12 = r11.next();
        if (Intrinsics.areEqual(((d) r12).a.b, r7) == false) goto L20;
    L25:
        d r13 = (d) r12;
        if (r13 == null) goto L27;
        if (r8.d != r13.d) goto L30;
        if (r8.c.a != r13.c.a) goto L33;
        if (Intrinsics.areEqual(r8.a, r13.a) == true) goto L17;
        return false;
    L33:
        return false;
    L30:
        return false;
    L27:
        return false;
    L24:
        r12 = null;
        goto L25
    L37:
        return true;
    }

    public AllUserState(List<d> r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "stateContextList");
        Intrinsics.checkNotNullParameter(r3, "userDataSource");
        this.a = r2;
        this.b = r3;
    }

    public static AllUserState b(AllUserState r1, List r2) {
        p r3 = r1.b;
        Intrinsics.checkNotNullParameter(r2, "stateContextList");
        Intrinsics.checkNotNullParameter(r3, "userDataSource");
        return new AllUserState(r2, r3);
    }
}
