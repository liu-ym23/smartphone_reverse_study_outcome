package com.obric.memorydata.personalcontext.vectordb;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 )2\u00020\u0001:\u0002()B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J]\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0013¢\u0006\u0002\u0010\u0014Jb\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\t2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0013H\u0080@¢\u0006\u0004\b\u0016\u0010\u0017JY\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0013H\u0002¢\u0006\u0002\u0010\u001cJ'\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u000eH\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190#H\u0002J&\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190#2\u0006\u0010'\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/VectorTopKByKeysSearcher;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "parallelism", "", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "search", "", "Lkotlin/Pair;", "", "", "queryVector", "", "keys", "limit", "minScore", "vectorReader", "Lkotlin/Function1;", "([FLjava/util/List;ILjava/lang/Float;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "searchAsync", "searchAsync$personal_context_obricRelease", "([FLjava/util/List;ILjava/lang/Float;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "topKForPartition", "Lcom/obric/memorydata/personalcontext/vectordb/VectorTopKByKeysSearcher$ScoredKey;", "queryNorm", "", "([FDLjava/util/List;ILjava/lang/Float;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "cosineSimilarity", "candidateVector", "([FD[F)Ljava/lang/Float;", "vectorNorm", "vector", "newTopKQueue", "Ljava/util/PriorityQueue;", "offer", "", "queue", "candidate", "ScoredKey", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f12415a = null;
    private static final ah d = null;
    private static final Comparator<b> e = null;
    private static final Comparator<b> f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f12416b;
    private final int c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/VectorTopKByKeysSearcher$Companion;", "", "<init>", "()V", "SEARCH_PARALLELISM", "", "SEARCH_DISPATCHER", "Lkotlinx/coroutines/CoroutineDispatcher;", "getSEARCH_DISPATCHER", "()Lkotlinx/coroutines/CoroutineDispatcher;", "WORST_FIRST_COMPARATOR", "Ljava/util/Comparator;", "Lcom/obric/memorydata/personalcontext/vectordb/VectorTopKByKeysSearcher$ScoredKey;", "Lkotlin/Comparator;", "getWORST_FIRST_COMPARATOR", "()Ljava/util/Comparator;", "BEST_FIRST_COMPARATOR", "getBEST_FIRST_COMPARATOR", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/vectordb/VectorTopKByKeysSearcher$ScoredKey;", "", "key", "", "score", "", "<init>", "(JF)V", "getKey", "()J", "getScore", "()F", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f12417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f12418b;

        public b(long r1, float r3) {
            this.f12417a = r1;
            this.f12418b = r3;
        }

        public final long a() {
            return this.f12417a;
        }

        public final float b() {
            return this.f12418b;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (this.f12417a == r10.f12417a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f12418b, r10.f12418b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f12417a) * 31) + Float.hashCode(this.f12418b);
        }

        public String toString() {
            return "ScoredKey(key=" + this.f12417a + ", score=" + this.f12418b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Float.valueOf(((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin")).b()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f12419a;

        public e(Comparator r3) {
            this.f12419a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f12419a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class f<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f12420a;

        public f(Comparator r3) {
            this.f12420a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f12420a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin")).a()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f12415a = new a(null);
        d = ba.c();
        e = (Comparator) ZeusTransformUtils.preCheckCast(new f((Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin");
        f = (Comparator) ZeusTransformUtils.preCheckCast(new e((Comparator) ZeusTransformUtils.preCheckCast(new d(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public h(ah r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dispatcher");
        this.f12416b = r2;
        this.c = r3;
    }

    public /* synthetic */ h(ah r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = d;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 2;
    L8:
        this(r1, r2);
    }

    private final double a(float[] r6) {
        int r5 = r6.length;
        double r0 = 0.0d;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L6;
        double r3 = r6[r2];
        r0 = r0 + (r3 * r3);
        r2 = r2 + 1;
        goto L3
    L6:
        return Math.sqrt(r0);
    }

    private final Float a(float[] r17, double r18, float[] r20) {
        if (r20.length == r17.length) goto L5;
        return null;
    L5:
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.getIndices(r17), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        double r8 = 0.0d;
        double r10 = 0.0d;
    L7:
        if (r2.hasNext() == false) goto L10;
        int r3 = ((IntIterator) ZeusTransformUtils.preCheckCast(r2, IntIterator.class, "com.obric.memorydata.plugin")).nextInt();
        double r12 = r20[r3];
        r10 = r10 + (((double) r17[r3]) * r12);
        r8 = r8 + (r12 * r12);
        goto L7
    L10:
        if (r8 > 0.0d) goto L12;
        return null;
    L12:
        Float r0 = Float.valueOf((float) (r10 / (Math.sqrt(r8) * r18)));
        float r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).floatValue();
        if (Float.isInfinite(r1) == false) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == true) goto L20;
        return null;
    L20:
        return r0;
    L15:
        if (Float.isNaN(r1) == true) goto L17;
        r4 = true;
        goto L18
    }

    public static final /* synthetic */ List a(h r10, float[] r11, double r12, List r14, int r15, Float r16, Function1 r17) {
        return r10.a(r11, r12, (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin"), r15, r16, (Function1) ZeusTransformUtils.wrapperContextForParams(r17, Function1.class, "com.obric.memorydata.plugin"));
    }

    private final List<b> a(float[] r7, double r8, List<Long> r10, int r11, Float r12, Function1<? super Long, float[]> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r13, Function1.class, "com.obric.memorydata.plugin");
        PriorityQueue<b> r0 = a();
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r16.hasNext() == false) goto L17;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r16.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        float[] r4 = (float[]) ZeusTransformUtils.preCheckCast(r15.invoke(Long.valueOf(r2)), float[].class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L4;
        Float r5 = a(r7, r8, r4);
        if (r5 == null) goto L4;
        float r6 = r5.floatValue();
        if (r12 == null) goto L15;
        if (r6 < r12.floatValue()) goto L4;
    L15:
        a(r0, new b(r2, r6), r11);
        goto L4
    L17:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final PriorityQueue<b> a() {
        return new PriorityQueue(e);
    }

    public static final /* synthetic */ ah a(h r0) {
        return r0.f12416b;
    }

    private final void a(PriorityQueue<b> r2, b r3, int r4) {
        if (r2.size() >= r4) goto L6;
        r2.offer(r3);
        return;
    L6:
        b r1 = (b) ZeusTransformUtils.preCheckCast(r2.peek(), b.class, "com.obric.memorydata.plugin");
        if (e.compare(r3, r1) <= 0) goto L10;
        r2.poll();
        r2.offer(r3);
        return;
    }

    public final Object a(float[] r19, List<Long> r20, int r21, Float r22, Function1<? super Long, float[]> r23, Continuation<? super List<Pair<Long, Float>>> r24) {
        h r10 = this;
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r23, Function1.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r24, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, VectorTopKByKeysSearcher$searchAsync$1.class) == false) goto L7;
        VectorTopKByKeysSearcher$searchAsync$1 r3 = (VectorTopKByKeysSearcher$searchAsync$1) ZeusTransformUtils.preCheckCast(r2, VectorTopKByKeysSearcher$searchAsync$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        VectorTopKByKeysSearcher$searchAsync$1 r12 = r3;
        Object r4 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r12.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r0 = r12.I$0;
        h r6 = (h) ZeusTransformUtils.preCheckCast(r12.L$0, h.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r10 = r6;
    L42:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        PriorityQueue<b> r9 = r10.a();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L44:
        if (r11.hasNext() == false) goto L49;
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11.next(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L47:
        if (r14.hasNext() == false) goto L44;
        r10.a(r9, (b) ZeusTransformUtils.preCheckCast(r14.next(), b.class, "com.obric.memorydata.plugin"), r0);
        goto L47
    L49:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), f), Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L51:
        if (r17.hasNext() == false) goto L54;
        b r18 = (b) ZeusTransformUtils.preCheckCast(r17.next(), b.class, "com.obric.memorydata.plugin");
        r16.add(TuplesKt.to(Boxing.boxLong(r18.a()), Boxing.boxFloat(r18.b())));
        goto L51
    L54:
        return (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        if (r21 <= 0) goto L56;
        if (r1.isEmpty() == true) goto L56;
        if (r19.length != 0) goto L21;
        boolean r25 = true;
    L22:
        if (r25 == true) goto L56;
        double r26 = a(r19);
        if (r26 <= 0.0d) goto L27;
        List r27 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"));
        int r110 = Math.min(r21, r27.size());
        int r28 = Math.min(RangesKt.coerceAtLeast(r10.c, 1), r27.size());
        ArrayList r29 = new ArrayList(r28);
        int r30 = 0;
    L29:
        if (r30 >= r28) goto L31;
        r29.add((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        r30 = r30 + 1;
        goto L29
    L31:
        List r31 = (List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.memorydata.plugin");
        Iterator r32 = ((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r33 = 0;
    L33:
        if (r32.hasNext() == false) goto L38;
        Object r34 = r32.next();
        int r35 = r33 + 1;
        if (r33 >= 0) goto L37;
        CollectionsKt.throwIndexOverflow();
    L37:
        ((List) ZeusTransformUtils.preCheckCast(r31.get(r33 % r28), List.class, "com.obric.memorydata.plugin")).add(Boxing.boxLong(((Number) ZeusTransformUtils.preCheckCast(r34, Number.class, "com.obric.memorydata.plugin")).longValue()));
        r33 = r35;
        goto L33
    L38:
        Function2 r36 = (Function2) ZeusTransformUtils.preCheckCast(new VectorTopKByKeysSearcher$searchAsync$localResults$1(r31, this, r19, r26, r110, r22, r8, null), Function2.class, "com.obric.memorydata.plugin");
        r12.L$0 = r10;
        r12.I$0 = r110;
        r12.label = 1;
        r4 = am.a(r36, r12);
        if (r4 != r13) goto L41;
        return r13;
    L41:
        r0 = r110;
        goto L42
    L27:
        return CollectionsKt.emptyList();
    L21:
        r25 = false;
    L56:
        return CollectionsKt.emptyList();
    L7:
        r3 = new VectorTopKByKeysSearcher$searchAsync$1(r10, r2);
        goto L8
    }

    public final List<Pair<Long, Float>> a(float[] r11, List<Long> r12, int r13, Float r14, Function1<? super Long, float[]> r15) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "queryVector");
        Intrinsics.checkNotNullParameter(r5, "keys");
        Intrinsics.checkNotNullParameter(r8, "vectorReader");
        return (List) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new VectorTopKByKeysSearcher$search$1(this, r11, r5, r13, r14, r8, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin");
    }
}
