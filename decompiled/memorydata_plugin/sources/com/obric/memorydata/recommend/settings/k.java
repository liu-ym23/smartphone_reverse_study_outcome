package com.obric.memorydata.recommend.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u0010%\u001a\u00020\u0011HÆ\u0003Jk\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\nHÖ\u0001J\t\u0010*\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/obric/memorydata/recommend/settings/RecommendSettingsState;", "", "isProactiveMemoryEnabled", "", "isExperienceProgramEnabled", "isRecommendCellularEnabled", "appSettings", "", "Lcom/obric/memorydata/recommend/settings/AppSettingItem;", "newMemorySetting", "", "categoryItems", "Lcom/obric/memorydata/recommend/settings/CategoryItem;", "enableCategories", "", "", "version", "", "<init>", "(ZZZLjava/util/List;ILjava/util/List;Ljava/util/Set;J)V", "()Z", "getAppSettings", "()Ljava/util/List;", "getNewMemorySetting", "()I", "getCategoryItems", "getEnableCategories", "()Ljava/util/Set;", "getVersion", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12611b;
    private final boolean c;
    private final List<c> d;
    private final int e;
    private final List<i> f;
    private final Set<String> g;
    private final long h;

    public k() {
        this(false, false, false, null, 0, null, null, 0, 255, null);
    }

    public k(boolean r3, boolean r4, boolean r5, List<c> r6, int r7, List<i> r8, Set<String> r9, long r10) {
        List<c> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<i> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "appSettings");
        Intrinsics.checkNotNullParameter(r12, "categoryItems");
        Intrinsics.checkNotNullParameter(r13, "enableCategories");
        this.f12610a = r3;
        this.f12611b = r4;
        this.c = r5;
        this.d = r11;
        this.e = r7;
        this.f = r12;
        this.g = r13;
        this.h = r10;
    }

    public /* synthetic */ k(boolean r11, boolean r12, boolean r13, List r14, int r15, List r16, Set r17, long r18, int r20, DefaultConstructorMarker r21) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Set<String> r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r17, Set.class, "com.obric.memorydata.plugin");
        boolean r5 = false;
        if ((r20 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r20 & 2) == 0) goto L9;
        boolean r6 = false;
    L11:
        if ((r20 & 4) != 0) goto L15;
        r5 = r13;
    L15:
        if ((r20 & 8) == 0) goto L18;
        r1 = CollectionsKt.emptyList();
    L18:
        if ((r20 & 16) == 0) goto L20;
        int r7 = t.f12630a.i();
    L22:
        if ((r20 & 32) == 0) goto L25;
        r3 = CollectionsKt.emptyList();
    L25:
        if ((r20 & 64) == 0) goto L28;
        r2 = t.f12630a.j();
    L28:
        if ((r20 & 128) == 0) goto L30;
        long r8 = 0;
    L31:
        this(r4, r6, r5, r1, r7, r3, r2, r8);
        return;
    L30:
        r8 = r18;
        goto L31
    L20:
        r7 = r15;
        goto L22
    L9:
        r6 = r12;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }

    public static /* synthetic */ k a(k r11, boolean r12, boolean r13, boolean r14, List r15, int r16, List r17, Set r18, long r19, int r21, Object r22) {
        List<c> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        List<i> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Set<String> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r18, Set.class, "com.obric.memorydata.plugin");
        if ((r21 & 1) == 0) goto L5;
        boolean r5 = r11.f12610a;
    L7:
        if ((r21 & 2) == 0) goto L9;
        boolean r6 = r11.f12611b;
    L11:
        if ((r21 & 4) == 0) goto L13;
        boolean r7 = r11.c;
    L15:
        if ((r21 & 8) == 0) goto L18;
        r2 = r11.d;
    L18:
        if ((r21 & 16) == 0) goto L20;
        int r8 = r11.e;
    L22:
        if ((r21 & 32) == 0) goto L25;
        r4 = r11.f;
    L25:
        if ((r21 & 64) == 0) goto L28;
        r3 = r11.g;
    L28:
        if ((r21 & 128) == 0) goto L30;
        long r9 = r11.h;
    L32:
        return r11.a(r5, r6, r7, r2, r8, r4, r3, r9);
    L30:
        r9 = r19;
        goto L32
    L20:
        r8 = r16;
        goto L22
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    public final k a(boolean r13, boolean r14, boolean r15, List<c> r16, int r17, List<i> r18, Set<String> r19, long r20) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r19, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "appSettings");
        Intrinsics.checkNotNullParameter(r8, "categoryItems");
        Intrinsics.checkNotNullParameter(r9, "enableCategories");
        return new k(r13, r14, r15, r6, r17, r8, r9, r20);
    }

    public final boolean a() {
        return this.f12610a;
    }

    public final List<c> b() {
        return this.d;
    }

    public final int c() {
        return this.e;
    }

    public final List<i> d() {
        return this.f;
    }

    public final long e() {
        return this.h;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, k.class) == true) goto L8;
        return false;
    L8:
        k r8 = (k) ZeusTransformUtils.preCheckCast(r7, k.class, "com.obric.memorydata.plugin");
        if (this.f12610a == r8.f12610a) goto L12;
        return false;
    L12:
        if (this.f12611b == r8.f12611b) goto L15;
        return false;
    L15:
        if (this.c == r8.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r8.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r8.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r8.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r8.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r8.h) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        return (((((((((((((Boolean.hashCode(this.f12610a) * 31) + Boolean.hashCode(this.f12611b)) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Long.hashCode(this.h);
    }

    public String toString() {
        return "RecommendSettingsState(isProactiveMemoryEnabled=" + this.f12610a + ", isExperienceProgramEnabled=" + this.f12611b + ", isRecommendCellularEnabled=" + this.c + ", appSettings=" + this.d + ", newMemorySetting=" + this.e + ", categoryItems=" + this.f + ", enableCategories=" + this.g + ", version=" + this.h + ')';
    }
}
