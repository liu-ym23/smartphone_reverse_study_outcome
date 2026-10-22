package com.larus.community.api.tracker;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class CreationFeedBehaviorTracker<T> {
    public final Function1<T, String> a;
    public final Function0<Long> b;
    public final long c;
    public final LinkedHashMap<String, T> d;
    public final LinkedHashMap<String, a<T>> e;
    public boolean f;
    public boolean g;
    public final Set<ExposurePauseReason> h;

    /* JADX INFO: renamed from: com.larus.community.api.tracker.CreationFeedBehaviorTracker$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
        }

        public final Long invoke() {
            return Long.valueOf(SystemClock.elapsedRealtime());
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m7invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/community/api/tracker/CreationFeedBehaviorTracker$ExposurePauseReason;", "", "<init>", "(Ljava/lang/String;I)V", "PAGE_HIDDEN", "DATA_REFRESH", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ExposurePauseReason extends Enum<ExposurePauseReason> {
        public static final ExposurePauseReason DATA_REFRESH = null;
        public static final ExposurePauseReason PAGE_HIDDEN = null;
        public static final /* synthetic */ ExposurePauseReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ExposurePauseReason> getEntries() {
            return b;
        }

        static {
            ExposurePauseReason r0 = new ExposurePauseReason("PAGE_HIDDEN", 0);
            PAGE_HIDDEN = r0;
            ExposurePauseReason r1 = new ExposurePauseReason("DATA_REFRESH", 1);
            DATA_REFRESH = r1;
            ExposurePauseReason[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static ExposurePauseReason[] values() {
            return (ExposurePauseReason[]) a.clone();
        }

        public static ExposurePauseReason valueOf(String r1) {
            return (ExposurePauseReason) r27.a.a(ExposurePauseReason.class, r1);
        }

        public ExposurePauseReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a<T> {
        public final T a;
        public final long b;

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
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            long r2 = this.b;
            return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActiveExposure(item=" + this.a + ", startTimeMs=" + this.b + ')';
        }

        public a(T r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
    }

    public static final class c<T> {
        public final T a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            long r2 = this.b;
            return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "StayTimeResult(item=" + this.a + ", durationMs=" + this.b + ')';
        }

        public c(T r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d<T> {
        public final List<T> a;
        public final List<c<T>> b;

        public d() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
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
            return "UpdateResult(firstScreenSlideItems=" + this.a + ", stayTimeResults=" + this.b + ')';
        }

        public /* synthetic */ d(int r2) {
            this(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends T> r2, List<c<T>> r3) {
            Intrinsics.checkNotNullParameter(r2, "firstScreenSlideItems");
            Intrinsics.checkNotNullParameter(r3, "stayTimeResults");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public CreationFeedBehaviorTracker(Function1 r3) {
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "itemId");
        Intrinsics.checkNotNullParameter(r0, "clock");
        this.a = r3;
        this.b = r0;
        this.c = 500;
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.g = true;
        this.h = new LinkedHashSet();
    }

    public final void a(ExposurePauseReason r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.h.add(r2);
        this.e.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r15v3, types: [java.util.ArrayList] */
    public final d<T> b(List<? extends T> r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "visibleItems");
        boolean r1 = true;
        int r2 = 0;
        if ((!this.h.isEmpty()) == true) goto L5;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r16 = r13.iterator();
    L8:
        if (r16.hasNext() == false) goto L20;
        T r3 = r16.next();
        String r4 = (String) this.a.invoke(r3);
        if (r4 == null) goto L8;
        if ((!StringsKt.isBlank(r4)) == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L8;
        if (r0.get(r4) != null) goto L8;
        r0.put(r4, r3);
        goto L8
    L20:
        if (r0.isEmpty() == true) goto L22;
    L25:
        long r5 = ((Number) this.b.invoke()).longValue();
        if (this.f == true) goto L28;
        this.f = true;
        this.d.putAll(r0);
    L28:
        if (r15 == false) goto L38;
        Set r17 = r0.keySet();
        ?? r18 = new ArrayList();
        Iterator<Map.Entry<String, a<T>>> r6 = this.e.entrySet().iterator();
    L31:
        if (r6.hasNext() == false) goto L39;
        Map.Entry<String, a<T>> r7 = r6.next();
        String r8 = r7.getKey();
        a<T> r9 = r7.getValue();
        if (r17.contains(r8) == true) goto L31;
        r6.remove();
        long r10 = RangesKt.coerceAtLeast(r5 - r9.b, 0);
        if (r10 <= this.c) goto L31;
        r18.add(new c(r9.a, r10));
    L39:
        Iterator r110 = r0.entrySet().iterator();
    L41:
        if (r110.hasNext() == false) goto L45;
        Map.Entry r11 = (Map.Entry) r110.next();
        String r12 = (String) r11.getKey();
        Object r20 = r11.getValue();
        LinkedHashMap<String, a<T>> r21 = this.e;
        if (r21.get(r12) != null) goto L41;
        r21.put(r12, new a(r20, r5));
        goto L41
    L45:
        if (r14 == true) goto L47;
    L62:
        List r111 = CollectionsKt.emptyList();
    L64:
        return new d(r111, r18);
    L47:
        if (this.g == false) goto L62;
        Set r112 = r0.keySet();
        if ((r112 instanceof Collection) == true) goto L51;
    L53:
        Iterator<T> r113 = r112.iterator();
    L55:
        if (r113.hasNext() == false) goto L59;
        if ((!this.d.containsKey((String) r113.next())) == false) goto L55;
    L60:
        if (r1 == false) goto L62;
        this.g = false;
        r111 = CollectionsKt.toList(this.d.values());
    L59:
        r1 = false;
        goto L60
    L51:
        if (r112.isEmpty() == false) goto L53;
    L38:
        r18 = CollectionsKt.emptyList();
        goto L39
    L22:
        if (this.f == true) goto L25;
        return new d(r2);
    L5:
        return new d(r2);
    }
}
