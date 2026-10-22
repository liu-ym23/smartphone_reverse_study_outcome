package com.obric.memorydata.recommend.ui.list;

import androidx.core.app.NotificationCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003J_\u0010&\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010'\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\u000fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/TodoState;", "", "data", "", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "isLoading", "", "currentPage", "", "nextId", "possibilityType", "", "hasMore", "code", NotificationCompat.CATEGORY_MESSAGE, "", "<init>", "(Ljava/util/List;ZJJIZILjava/lang/String;)V", "getData", "()Ljava/util/List;", "()Z", "getCurrentPage", "()J", "getNextId", "getPossibilityType", "()I", "getHasMore", "getCode", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<f> f12713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12714b;
    private final long c;
    private final long d;
    private final int e;
    private final boolean f;
    private final int g;
    private final String h;

    public m(List<? extends f> r3, boolean r4, long r5, long r7, int r9, boolean r10, int r11, String r12) {
        List<f> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "data");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
        this.f12713a = r6;
        this.f12714b = r4;
        this.c = r5;
        this.d = r7;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.h = r12;
    }

    public static /* synthetic */ m a(m r11, List r12, boolean r13, long r14, long r16, int r18, boolean r19, int r20, String r21, int r22, Object r23) {
        List<f> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if ((r22 & 1) == 0) goto L6;
        r2 = r11.f12713a;
    L6:
        if ((r22 & 2) == 0) goto L8;
        boolean r3 = r11.f12714b;
    L10:
        if ((r22 & 4) == 0) goto L12;
        long r4 = r11.c;
    L14:
        if ((r22 & 8) == 0) goto L16;
        long r6 = r11.d;
    L18:
        if ((r22 & 16) == 0) goto L20;
        int r8 = r11.e;
    L22:
        if ((r22 & 32) == 0) goto L24;
        boolean r9 = r11.f;
    L26:
        if ((r22 & 64) == 0) goto L28;
        int r10 = r11.g;
    L30:
        if ((r22 & 128) == 0) goto L32;
        String r1 = r11.h;
    L34:
        return r11.a(r2, r3, r4, r6, r8, r9, r10, r1);
    L32:
        r1 = r21;
        goto L34
    L28:
        r10 = r20;
        goto L30
    L24:
        r9 = r19;
        goto L26
    L20:
        r8 = r18;
        goto L22
    L16:
        r6 = r16;
        goto L18
    L12:
        r4 = r14;
        goto L14
    L8:
        r3 = r13;
        goto L10
    }

    public final m a(List<? extends f> r13, boolean r14, long r15, long r17, int r19, boolean r20, int r21, String r22) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r22, NotificationCompat.CATEGORY_MESSAGE);
        return new m(r2, r14, r15, r17, r19, r20, r21, r22);
    }

    public final List<f> a() {
        return this.f12713a;
    }

    public final boolean b() {
        return this.f12714b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, m.class) == true) goto L8;
        return false;
    L8:
        m r10 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12713a, r10.f12713a) == true) goto L12;
        return false;
    L12:
        if (this.f12714b == r10.f12714b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final boolean f() {
        return this.f;
    }

    public int hashCode() {
        return (((((((((((((this.f12713a.hashCode() * 31) + Boolean.hashCode(this.f12714b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "TodoState(data=" + this.f12713a + ", isLoading=" + this.f12714b + ", currentPage=" + this.c + ", nextId=" + this.d + ", possibilityType=" + this.e + ", hasMore=" + this.f + ", code=" + this.g + ", msg=" + this.h + ')';
    }
}
