package com.obric.memorydata.recommend.settings;

import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/recommend/settings/CategoryInfo;", "", "categoryName", "", "categoryCode", "", "isChecked", "", "<init>", "(Ljava/lang/String;IZ)V", "getCategoryName", "()Ljava/lang/String;", "getCategoryCode", "()I", "()Z", "setChecked", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12605b;
    private boolean c;

    public h() {
        this(null, 0, false, 7, null);
    }

    public h(String r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "categoryName");
        this.f12604a = r2;
        this.f12605b = r3;
        this.c = r4;
    }

    public /* synthetic */ h(String r2, int r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = IRecommendSettings.ProfileTag.OTHER;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }

    public final String a() {
        return this.f12604a;
    }

    public final void a(boolean r1) {
        this.c = r1;
    }

    public final int b() {
        return this.f12605b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12604a, r6.f12604a) == true) goto L12;
        return false;
    L12:
        if (this.f12605b == r6.f12605b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f12604a.hashCode() * 31) + Integer.hashCode(this.f12605b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "CategoryInfo(categoryName=" + this.f12604a + ", categoryCode=" + this.f12605b + ", isChecked=" + this.c + ')';
    }
}
