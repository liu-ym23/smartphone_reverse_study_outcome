package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoRepositoryState;", "", "pendingItems", "", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "pendingTotal", "", "loaded", "", "migrationReady", "errorCode", "", "<init>", "(Ljava/util/List;IZZLjava/lang/String;)V", "getPendingItems", "()Ljava/util/List;", "getPendingTotal", "()I", "getLoaded", "()Z", "getMigrationReady", "getErrorCode", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ar> f11216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11217b;
    private final boolean c;
    private final boolean d;
    private final String e;

    public ay() {
        this(null, 0, false, false, null, 31, null);
    }

    public ay(List<ar> r3, int r4, boolean r5, boolean r6, String r7) {
        List<ar> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "pendingItems");
        this.f11216a = r8;
        this.f11217b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
    }

    public /* synthetic */ ay(List r4, int r5, boolean r6, boolean r7, String r8, int r9, DefaultConstructorMarker r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r9 & 1) == 0) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        boolean r0 = false;
        if ((r9 & 2) == 0) goto L8;
        int r12 = 0;
    L10:
        if ((r9 & 4) == 0) goto L12;
        boolean r1 = false;
    L14:
        if ((r9 & 8) != 0) goto L18;
        r0 = r7;
    L18:
        if ((r9 & 16) == 0) goto L20;
        r8 = null;
    L20:
        this(r11, r12, r1, r0, r8);
        return;
    L12:
        r1 = r6;
        goto L14
    L8:
        r12 = r5;
        goto L10
    }

    public static /* synthetic */ ay a(ay r3, List r4, int r5, boolean r6, boolean r7, String r8, int r9, Object r10) {
        List<ar> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if ((r9 & 1) == 0) goto L6;
        r11 = r3.f11216a;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.f11217b;
    L8:
        int r12 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.c;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.d;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.e;
    L17:
        List<ar> r13 = r11;
        return r3.a(r13, r12, r0, r1, r8);
    }

    public final ay a(List<ar> r7, int r8, boolean r9, boolean r10, String r11) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "pendingItems");
        return new ay(r1, r8, r9, r10, r11);
    }

    public final List<ar> a() {
        return this.f11216a;
    }

    public final int b() {
        return this.f11217b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ay.class) == true) goto L8;
        return false;
    L8:
        ay r6 = (ay) ZeusTransformUtils.preCheckCast(r5, ay.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11216a, r6.f11216a) == true) goto L12;
        return false;
    L12:
        if (this.f11217b == r6.f11217b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f11216a.hashCode() * 31) + Integer.hashCode(this.f11217b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31;
        String r2 = this.e;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "PendingPersonalInfoRepositoryState(pendingItems=" + this.f11216a + ", pendingTotal=" + this.f11217b + ", loaded=" + this.c + ", migrationReady=" + this.d + ", errorCode=" + this.e + ')';
    }
}
