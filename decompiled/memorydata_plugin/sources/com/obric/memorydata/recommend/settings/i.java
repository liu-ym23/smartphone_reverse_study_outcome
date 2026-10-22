package com.obric.memorydata.recommend.settings;

import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/recommend/settings/CategoryItem;", "", "apps", "", "Lcom/obric/memorydata/recommend/settings/AppSettingItem;", "categoryName", "", "categoryCode", "", "desc", "<init>", "(Ljava/util/List;Ljava/lang/String;ILjava/lang/String;)V", "getApps", "()Ljava/util/List;", "getCategoryName", "()Ljava/lang/String;", "getCategoryCode", "()I", "getDesc", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c> f12606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12607b;
    private final int c;
    private final String d;

    public i() {
        this(null, null, 0, null, 15, null);
    }

    public i(List<c> r3, String r4, int r5, String r6) {
        List<c> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "apps");
        Intrinsics.checkNotNullParameter(r4, "categoryName");
        Intrinsics.checkNotNullParameter(r6, "desc");
        this.f12606a = r7;
        this.f12607b = r4;
        this.c = r5;
        this.d = r6;
    }

    public /* synthetic */ i(List r2, String r3, int r4, String r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = CollectionsKt.emptyList();
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = IRecommendSettings.ProfileTag.OTHER;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = a.f12594a.a(r4);
    L14:
        this(r8, r3, r4, r5);
    }

    public static /* synthetic */ i a(i r1, List r2, String r3, int r4, String r5, int r6, Object r7) {
        List<c> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = r1.f12606a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.f12607b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.c;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.d;
    L15:
        return r1.a(r8, r3, r4, r5);
    }

    public final i a(List<c> r2, String r3, int r4, String r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "apps");
        Intrinsics.checkNotNullParameter(r3, "categoryName");
        Intrinsics.checkNotNullParameter(r5, "desc");
        return new i(r1, r3, r4, r5);
    }

    public final List<c> a() {
        return this.f12606a;
    }

    public final String b() {
        return this.f12607b;
    }

    public final int c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, i.class) == true) goto L8;
        return false;
    L8:
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12606a, r6.f12606a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f12607b, r6.f12607b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f12606a.hashCode() * 31) + this.f12607b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "CategoryItem(apps=" + this.f12606a + ", categoryName=" + this.f12607b + ", categoryCode=" + this.c + ", desc=" + this.d + ')';
    }
}
