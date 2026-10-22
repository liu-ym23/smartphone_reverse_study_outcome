package com.larus.drive.sdk.impl.store;

import android.os.SystemClock;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.larus.drive.sdk.impl.preview.b;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DrivePreviewRequestStore {
    public static final DrivePreviewRequestStore a = null;
    public static final LinkedHashMap<String, a> b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/drive/sdk/impl/store/DrivePreviewRequestStore$EntryState;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "ACTIVE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EntryState extends Enum<EntryState> {
        public static final EntryState ACTIVE = null;
        public static final EntryState PENDING = null;
        public static final /* synthetic */ EntryState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<EntryState> getEntries() {
            return b;
        }

        static {
            EntryState r0 = new EntryState("PENDING", 0);
            PENDING = r0;
            EntryState r1 = new EntryState("ACTIVE", 1);
            ACTIVE = r1;
            EntryState[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static EntryState[] values() {
            return (EntryState[]) a.clone();
        }

        public static EntryState valueOf(String r1) {
            return (EntryState) r27.a.a(EntryState.class, r1);
        }

        public EntryState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final DrivePreviewOpenRequest a;
        public EntryState b;
        public final long c;
        public final com.larus.drive.sdk.impl.store.a d;
        public Function0<Unit> e;
        public Function0<Boolean> f;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            com.larus.drive.sdk.impl.store.a r3 = this.d;
            int r4 = 0;
            if (r3 != null) goto L5;
            int r5 = 0;
        L6:
            int r6 = (r2 + r5) * 31;
            Function0<Unit> r7 = this.e;
            if (r7 != null) goto L9;
            int r8 = 0;
        L10:
            int r9 = (r6 + r8) * 31;
            Function0<Boolean> r10 = this.f;
            if (r10 == null) goto L15;
            r4 = r10.hashCode();
        L15:
            return r9 + r4;
        L9:
            r8 = r7.hashCode();
            goto L10
        L5:
            r5 = r3.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entry(request=" + this.a + ", state=" + this.b + ", createdAtMs=" + this.c + ", aiSession=" + this.d + ", launchFailureFallback=" + this.e + ", isLaunchActive=" + this.f + ')';
        }

        public a(DrivePreviewOpenRequest r2, EntryState r3, long r4, com.larus.drive.sdk.impl.store.a r6, com.larus.drive.sdk.impl.preview.a r7, b r8) {
            Intrinsics.checkNotNullParameter(r2, "request");
            Intrinsics.checkNotNullParameter(r3, "state");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }
    }

    public DrivePreviewRequestStore() {
    }

    static {
        a = new DrivePreviewRequestStore();
        b = new LinkedHashMap(20, 0.75f, true);
    }

    public static int b() {
        Collection<a> r0 = b.values();
        if (r0.isEmpty() == true) goto L25;
        Iterator<T> r1 = r0.iterator();
        int r2 = 0;
    L7:
        if (r1.hasNext() == false) goto L17;
        if (((a) r1.next()).b != EntryState.ACTIVE) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
        r2 = r2 + 1;
        if (r2 >= 0) goto L7;
        CollectionsKt.throwCountOverflow();
        goto L7
    L11:
        r3 = false;
        goto L12
    L17:
        return r2;
    L25:
        return 0;
    }

    public static int e() {
        Collection<a> r0 = b.values();
        if (r0.isEmpty() == true) goto L25;
        Iterator<T> r1 = r0.iterator();
        int r2 = 0;
    L7:
        if (r1.hasNext() == false) goto L17;
        if (((a) r1.next()).b != EntryState.PENDING) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L7;
        r2 = r2 + 1;
        if (r2 >= 0) goto L7;
        CollectionsKt.throwCountOverflow();
        goto L7
    L11:
        r3 = false;
        goto L12
    L17:
        return r2;
    L25:
        return 0;
    }

    public static List i() {
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L4:
        if (e() <= 20) goto L25;
        Iterator<T> r3 = b.entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L14;
        Object r4 = r3.next();
        if (((a) ((Map.Entry) r4).getValue()).b != EntryState.PENDING) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L7;
    L15:
        Map.Entry r6 = (Map.Entry) r4;
        if (r6 == null) goto L25;
        String r7 = (String) r6.getKey();
        if (r7 == null) goto L25;
        a r8 = b.remove(r7);
        if (r8 == null) goto L24;
        Function0<Unit> r9 = r8.e;
        if (r9 == null) goto L24;
        r0.add(r9);
    L24:
        r2 = r2 + 1;
        goto L4
    L11:
        r5 = false;
        goto L12
    L14:
        r4 = null;
    L25:
        if (r2 <= 0) goto L27;
        FLogger.a.w("DrivePreviewRequestStore", "evict pending requests by capacity, removedCount=" + r2);
    L27:
        return r0;
    }

    public static void h(long r7) {
        Iterator<Map.Entry<String, a>> r0 = b.entrySet().iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L12;
        a r2 = r0.next().getValue();
        if (r2.b != EntryState.PENDING) goto L4;
        if (r2.e != null) goto L4;
        if ((r7 - r2.c) < 300000) goto L4;
        r0.remove();
        r1 = r1 + 1;
        goto L4
    L12:
        if (r1 <= 0) goto L24;
        FLogger.a.i("DrivePreviewRequestStore", "remove expired pending requests, removedCount=" + r1);
        return;
    }

    public final synchronized boolean c(String r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r6, "requestId");     // Catch: Throwable -> L18
        h(SystemClock.elapsedRealtime());     // Catch: Throwable -> L18
        LinkedHashMap<String, a> r1 = b;     // Catch: Throwable -> L18
        a r2 = r1.get(r6);     // Catch: Throwable -> L18
        if (r2 != null) goto L10;
        monitor-exit(this);
        return false;
    L10:
        if (r2.e != null) goto L14;
        monitor-exit(this);
        return false;
    L14:
        r2.e = null;     // Catch: Throwable -> L18
        r2.f = null;     // Catch: Throwable -> L18
        r1.remove(r6);     // Catch: Throwable -> L18
        FLogger.a.i("DrivePreviewRequestStore", "cancel launch, pendingCount=" + e() + ", activeCount=" + b());     // Catch: Throwable -> L18
        monitor-exit(this);
        return true;
    L18:
        th = move-exception;
        throw th;
    }

    public final boolean d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "requestId");
        monitor-enter(this);
        h(SystemClock.elapsedRealtime());     // Catch: Throwable -> L25
        LinkedHashMap<String, a> r0 = b;     // Catch: Throwable -> L25
        a r1 = r0.get(r5);     // Catch: Throwable -> L25
        Function0<Unit> r2 = null;
        if (r1 == null) goto L12;
        Function0<Unit> r3 = r1.e;     // Catch: Throwable -> L25
        if (r3 == null) goto L12;
        r1.e = null;     // Catch: Throwable -> L25
        r1.f = null;     // Catch: Throwable -> L25
        r0.remove(r5);     // Catch: Throwable -> L25
        r2 = r3;
    L12:
        monitor-exit(this);
        if (r2 != null) goto L30;
        return false;
    L30:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L18
        Object r7 = Result.constructor-impl(r2.invoke());     // Catch: Throwable -> L18
    L20:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L32;
        FLogger.a.e("DrivePreviewRequestStore", "launch fallback failed, errorType=".concat(r8.getClass().getSimpleName()));
        return true;
    L32:
        return true;
    L18:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
    L25:
        th = move-exception;
        throw th;
    }

    public final synchronized void g(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "requestId");     // Catch: Throwable -> L11
        h(SystemClock.elapsedRealtime());     // Catch: Throwable -> L11
        if (b.remove(r5) == null) goto L7;
        boolean r6 = true;
    L8:
        FLogger.a.i("DrivePreviewRequestStore", "release request, removed=" + r6 + ", pendingCount=" + e() + ", activeCount=" + b());     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        r6 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public static a a(String r9, boolean r10) {
        h(SystemClock.elapsedRealtime());
        LinkedHashMap<String, a> r0 = b;
        a r1 = r0.get(r9);
        if (r1 != null) goto L6;
        FLogger.a.w("DrivePreviewRequestStore", "acquire request missed, pendingCount=" + e() + ", activeCount=" + b());
        return null;
    L6:
        com.larus.drive.sdk.impl.store.a r5 = r1.d;
        boolean r6 = false;
        if (r5 == null) goto L9;
        boolean r8 = true;
    L10:
        if (r8 == r10) goto L13;
        FLogger.a.w("DrivePreviewRequestStore", "acquire request type mismatched");
        return null;
    L13:
        if (r5 == null) goto L22;
        Function0<Boolean> r11 = r1.f;
        if (r11 != null) goto L17;
    L19:
        if (r6 == false) goto L22;
        r0.remove(r9);
        FLogger.a.i("DrivePreviewRequestStore", "cancel inactive launch on acquire, pendingCount=" + e() + ", activeCount=" + b());
        return null;
    L17:
        if (((Boolean) r11.invoke()).booleanValue() == true) goto L19;
        r6 = true;
    L22:
        EntryState r12 = EntryState.ACTIVE;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r1.b = r12;
        int r13 = b();
        FLogger r14 = FLogger.a;
        r14.i("DrivePreviewRequestStore", "acquire request succeeded, pendingCount=" + e() + ", activeCount=" + r13);
        if (r13 <= 20) goto L25;
        r14.w("DrivePreviewRequestStore", "active request count exceeds warning threshold, activeCount=" + r13);
    L25:
        return r1;
    L9:
        r8 = false;
        goto L10
    }

    public final String f(DrivePreviewOpenRequest r13, com.larus.drive.sdk.impl.store.a r14, com.larus.drive.sdk.impl.preview.a r15, b r16) {
        monitor-enter(this);
        long r4 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        h(r4);     // Catch: Throwable -> L18
        String r9 = UUID.randomUUID().toString();     // Catch: Throwable -> L18
        b.put(r9, new a(r13, EntryState.PENDING, r4, r14, r15, r16));     // Catch: Throwable -> L18
        List r1 = i();     // Catch: Throwable -> L18
        FLogger.a.i("DrivePreviewRequestStore", "put request, pendingCount=" + e() + ", activeCount=" + b());     // Catch: Throwable -> L18
        Pair r0 = TuplesKt.to(r9, r1);     // Catch: Throwable -> L18
        monitor-exit(this);
        String r2 = (String) r0.component1();
        Iterator r3 = ((List) r0.component2()).iterator();
    L8:
        if (r3.hasNext() == false) goto L17;
        Function0 r5 = (Function0) r3.next();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L12
        Object r7 = Result.constructor-impl(r5.invoke());     // Catch: Throwable -> L12
    L14:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L8;
        FLogger.a.e("DrivePreviewRequestStore", "capacity fallback failed, errorType=".concat(r8.getClass().getSimpleName()));
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L17:
        return r2;
    L18:
        th = move-exception;
        throw th;
    }
}
