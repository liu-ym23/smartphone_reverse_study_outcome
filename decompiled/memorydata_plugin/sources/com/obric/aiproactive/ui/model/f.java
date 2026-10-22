package com.obric.aiproactive.ui.model;

import com.obric.aiproactive.api.ProactiveDayHeaderDto;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u0010\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u001b\u0010)\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u0010HÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u0010HÆ\u0003J\u0089\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u00102\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u0010HÆ\u0001J\u0013\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR#\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!¨\u00061"}, d2 = {"Lcom/obric/aiproactive/ui/model/AllPageUiState;", "", "batchId", "", "loading", "", "items", "", "Lcom/obric/aiproactive/ui/model/ProactiveListItem;", "showTip", "dayHeaders", "Lcom/obric/aiproactive/api/ProactiveDayHeaderDto;", "expandedDays", "", "", "dayItems", "", "Lcom/obric/aiproactive/api/ProactiveRecommendationDto;", "dayPaging", "Lcom/obric/aiproactive/ui/model/AllDayPagingState;", "<init>", "(JZLjava/util/List;ZLjava/util/List;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)V", "getBatchId", "()J", "getLoading", "()Z", "getItems", "()Ljava/util/List;", "getShowTip", "getDayHeaders", "getExpandedDays", "()Ljava/util/Set;", "getDayItems", "()Ljava/util/Map;", "getDayPaging", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6724b;
    private final List<j> c;
    private final boolean d;
    private final List<ProactiveDayHeaderDto> e;
    private final Set<String> f;
    private final Map<String, List<ProactiveRecommendationDto>> g;
    private final Map<String, c> h;

    public f() {
        this(0, false, null, false, null, null, null, null, 255, null);
    }

    public f(long r3, boolean r5, List<? extends j> r6, boolean r7, List<ProactiveDayHeaderDto> r8, Set<String> r9, Map<String, ? extends List<ProactiveRecommendationDto>> r10, Map<String, c> r11) {
        List<j> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<ProactiveDayHeaderDto> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Set<String> r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        Map<String, List<ProactiveRecommendationDto>> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Map<String, c> r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "items");
        Intrinsics.checkNotNullParameter(r13, "dayHeaders");
        Intrinsics.checkNotNullParameter(r14, "expandedDays");
        Intrinsics.checkNotNullParameter(r15, "dayItems");
        Intrinsics.checkNotNullParameter(r16, "dayPaging");
        this.f6723a = r3;
        this.f6724b = r5;
        this.c = r12;
        this.d = r7;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.h = r16;
    }

    public /* synthetic */ f(long r12, boolean r14, List r15, boolean r16, List r17, Set r18, Map r19, Map r20, int r21, DefaultConstructorMarker r22) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r18, Set.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        if ((r21 & 1) == 0) goto L5;
        long r6 = 0;
    L6:
        boolean r9 = false;
        if ((r21 & 2) == 0) goto L9;
        boolean r8 = false;
    L11:
        if ((r21 & 4) == 0) goto L14;
        r1 = CollectionsKt.emptyList();
    L14:
        if ((r21 & 8) != 0) goto L18;
        r9 = r16;
    L18:
        if ((r21 & 16) == 0) goto L21;
        r3 = CollectionsKt.emptyList();
    L21:
        if ((r21 & 32) == 0) goto L24;
        r4 = SetsKt.emptySet();
    L24:
        if ((r21 & 64) == 0) goto L27;
        r5 = MapsKt.emptyMap();
    L27:
        if ((r21 & 128) == 0) goto L29;
        r2 = MapsKt.emptyMap();
    L29:
        this(r6, r8, r1, r9, r3, r4, r5, r2);
        return;
    L9:
        r8 = r14;
        goto L11
    L5:
        r6 = r12;
        goto L6
    }

    public static /* synthetic */ f a(f r12, long r13, boolean r15, List r16, boolean r17, List r18, Set r19, Map r20, Map r21, int r22, Object r23) {
        List<j> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        List<ProactiveDayHeaderDto> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r19, Set.class, "com.obric.memorydata.plugin");
        Map<String, List<ProactiveRecommendationDto>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Map<String, c> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        if ((r22 & 1) == 0) goto L5;
        long r7 = r12.f6723a;
    L7:
        if ((r22 & 2) == 0) goto L9;
        boolean r9 = r12.f6724b;
    L11:
        if ((r22 & 4) == 0) goto L14;
        r2 = r12.c;
    L14:
        if ((r22 & 8) == 0) goto L16;
        boolean r10 = r12.d;
    L18:
        if ((r22 & 16) == 0) goto L21;
        r4 = r12.e;
    L21:
        if ((r22 & 32) == 0) goto L24;
        r5 = r12.f;
    L24:
        if ((r22 & 64) == 0) goto L27;
        r6 = r12.g;
    L27:
        if ((r22 & 128) == 0) goto L29;
        Map<String, c> r1 = r12.h;
    L31:
        return r12.a(r7, r9, r2, r10, r4, r5, r6, r1);
    L29:
        r1 = r3;
        goto L31
    L16:
        r10 = r17;
        goto L18
    L9:
        r9 = r15;
        goto L11
    L5:
        r7 = r13;
        goto L7
    }

    public final long a() {
        return this.f6723a;
    }

    public final f a(long r13, boolean r15, List<? extends j> r16, boolean r17, List<ProactiveDayHeaderDto> r18, Set<String> r19, Map<String, ? extends List<ProactiveRecommendationDto>> r20, Map<String, c> r21) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r19, Set.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "items");
        Intrinsics.checkNotNullParameter(r8, "dayHeaders");
        Intrinsics.checkNotNullParameter(r9, "expandedDays");
        Intrinsics.checkNotNullParameter(r10, "dayItems");
        Intrinsics.checkNotNullParameter(r11, "dayPaging");
        return new f(r13, r15, r6, r17, r8, r9, r10, r11);
    }

    public final boolean b() {
        return this.f6724b;
    }

    public final List<j> c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final List<ProactiveDayHeaderDto> e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        if (this.f6723a == r10.f6723a) goto L12;
        return false;
    L12:
        if (this.f6724b == r10.f6724b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final Set<String> f() {
        return this.f;
    }

    public final Map<String, List<ProactiveRecommendationDto>> g() {
        return this.g;
    }

    public final Map<String, c> h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.f6723a) * 31) + Boolean.hashCode(this.f6724b)) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "AllPageUiState(batchId=" + this.f6723a + ", loading=" + this.f6724b + ", items=" + this.c + ", showTip=" + this.d + ", dayHeaders=" + this.e + ", expandedDays=" + this.f + ", dayItems=" + this.g + ", dayPaging=" + this.h + ')';
    }
}
