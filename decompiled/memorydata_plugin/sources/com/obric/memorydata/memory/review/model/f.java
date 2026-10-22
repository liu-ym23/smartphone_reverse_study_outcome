package com.obric.memorydata.memory.review.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 42\u00020\u0001:\u00014Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010-\u001a\u00020\u0011HÆ\u0003Js\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001aR\u0013\u0010$\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001f¨\u00065"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewPage;", "", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "observeFromTimeMillis", "", "windowEndTimeMillis", "pendingRecords", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewRecord;", "completedRecords", "feedbackByRecordId", "", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackInfo;", "nextPageCursor", "hasMore", "", "<init>", "(Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;JJLjava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Z)V", "getModule", "()Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "getObserveFromTimeMillis", "()J", "getWindowEndTimeMillis", "getPendingRecords", "()Ljava/util/List;", "getCompletedRecords", "getFeedbackByRecordId", "()Ljava/util/Map;", "getNextPageCursor", "()Ljava/lang/String;", "getHasMore", "()Z", "records", "getRecords", "nextCursor", "getNextCursor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10389a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MemoryReviewModule f10390b;
    private final long c;
    private final long d;
    private final List<h> e;
    private final List<h> f;
    private final Map<String, d> g;
    private final String h;
    private final boolean i;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tJR\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0015¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/review/model/MemoryReviewPage$Companion;", "", "<init>", "()V", "empty", "Lcom/obric/memorydata/memory/review/model/MemoryReviewPage;", "module", "Lcom/obric/memorydata/memory/review/model/MemoryReviewModule;", "observeFromTimeMillis", "", "windowEndTimeMillis", "fromRecords", "records", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewRecord;", "feedbackByRecordId", "", "", "Lcom/obric/memorydata/memory/review/model/MemoryReviewFeedbackInfo;", "nextPageCursor", "hasMore", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ f a(a r6, MemoryReviewModule r7, long r8, long r10, int r12, Object r13) {
            if ((r12 & 2) == 0) goto L5;
            r8 = 0;
        L5:
            long r2 = r8;
            if ((r12 & 4) == 0) goto L9;
            r10 = System.currentTimeMillis();
        L9:
            return r6.a(r7, r2, r10);
        }

        public final f a(MemoryReviewModule r15, long r16, long r18) {
            Intrinsics.checkNotNullParameter(r15, "module");
            return new f(r15, r16, r18, CollectionsKt.emptyList(), null, null, null, false, 240, null);
        }

        public final f a(MemoryReviewModule r13, long r14, long r16, List<h> r18, Map<String, d> r19, String r20, boolean r21) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
            Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r13, "module");
            Intrinsics.checkNotNullParameter(r0, "records");
            Intrinsics.checkNotNullParameter(r3, "feedbackByRecordId");
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r6 = r4.iterator();
        L3:
            boolean r7 = true;
            if (r6.hasNext() == false) goto L11;
            Object r8 = r6.next();
            if (((h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.memorydata.plugin")).f() == MemoryReviewFeedbackState.SUBMITTED) goto L9;
            r7 = false;
        L9:
            if (r7 == false) goto L3;
            r5.add(r8);
            goto L3
        L11:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
            Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r2 = r1.iterator();
        L13:
            if (r2.hasNext() == false) goto L20;
            Object r11 = r2.next();
            if (((h) ZeusTransformUtils.preCheckCast(r11, h.class, "com.obric.memorydata.plugin")).f() != MemoryReviewFeedbackState.SUBMITTED) goto L17;
            boolean r12 = true;
        L18:
            if (r12 == true) goto L13;
            r10.add(r11);
            goto L13
        L17:
            r12 = false;
            goto L18
        L20:
            List r15 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
            Map r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r3.size())), Map.class, "com.obric.memorydata.plugin");
            Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r3.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L22:
            if (r22.hasNext() == false) goto L25;
            Object r23 = r22.next();
            r17.put(i.f10395a.a(r13, (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r23, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), String.class, "com.obric.memorydata.plugin")), ((Map.Entry) ZeusTransformUtils.preCheckCast(r23, Map.Entry.class, "com.obric.memorydata.plugin")).getValue());
            goto L22
        L25:
            return new f(r13, r14, r16, r15, r9, r17, r20, r21);
        }
    }

    static {
        f10389a = new a(null);
    }

    public f(MemoryReviewModule r3, long r4, long r6, List<h> r8, List<h> r9, Map<String, d> r10, String r11, boolean r12) {
        List<h> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<h> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Map<String, d> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "module");
        Intrinsics.checkNotNullParameter(r13, "pendingRecords");
        Intrinsics.checkNotNullParameter(r14, "completedRecords");
        Intrinsics.checkNotNullParameter(r15, "feedbackByRecordId");
        this.f10390b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r11;
        this.i = r12;
    }

    public /* synthetic */ f(MemoryReviewModule r10, long r11, long r13, List r15, List r16, Map r17, String r18, boolean r19, int r20, DefaultConstructorMarker r21) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin");
        if ((r20 & 2) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r20 & 4) == 0) goto L9;
        long r6 = System.currentTimeMillis();
    L11:
        if ((r20 & 16) == 0) goto L14;
        r3 = CollectionsKt.emptyList();
    L14:
        if ((r20 & 32) == 0) goto L17;
        r2 = MapsKt.emptyMap();
    L17:
        if ((r20 & 64) == 0) goto L19;
        String r8 = null;
    L21:
        if ((r20 & 128) == 0) goto L23;
        boolean r0 = false;
    L24:
        this(r10, r4, r6, r1, r3, r2, r8, r0);
        return;
    L23:
        r0 = r19;
        goto L24
    L19:
        r8 = r18;
        goto L21
    L9:
        r6 = r13;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }

    public final MemoryReviewModule a() {
        return this.f10390b;
    }

    public final long b() {
        return this.c;
    }

    public final long c() {
        return this.d;
    }

    public final List<h> d() {
        return this.e;
    }

    public final List<h> e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        if (this.f10390b == r10.f10390b) goto L12;
        return false;
    L12:
        if (this.c == r10.c) goto L15;
        return false;
    L15:
        if (this.d == r10.d) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L30;
        return false;
    L30:
        if (this.i == r10.i) goto L32;
        return false;
    L32:
        return true;
    }

    public final Map<String, d> f() {
        return this.g;
    }

    public final String g() {
        return this.h;
    }

    public final boolean h() {
        return this.i;
    }

    public int hashCode() {
        int r0 = ((((((((((this.f10390b.hashCode() * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String r1 = this.h;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Boolean.hashCode(this.i);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String i() {
        return this.h;
    }

    public String toString() {
        return "MemoryReviewPage(module=" + this.f10390b + ", observeFromTimeMillis=" + this.c + ", windowEndTimeMillis=" + this.d + ", pendingRecords=" + this.e + ", completedRecords=" + this.f + ", feedbackByRecordId=" + this.g + ", nextPageCursor=" + this.h + ", hasMore=" + this.i + ')';
    }
}
