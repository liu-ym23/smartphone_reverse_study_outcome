package com.obric.memorydata.memory.ui.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BU\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003JW\u0010(\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\u0013\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\bHÖ\u0001J\t\u0010,\u001a\u00020\fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0012¨\u0006."}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoUiState;", "", "pendingItems", "", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "loaded", "", "pendingTotal", "", "displayRevision", "", "errorCode", "", "isSheetOpen", "showBadge", "<init>", "(Ljava/util/List;ZIJLjava/lang/String;ZZ)V", "getPendingItems", "()Ljava/util/List;", "getLoaded", "()Z", "getPendingTotal", "()I", "getDisplayRevision", "()J", "getErrorCode", "()Ljava/lang/String;", "getShowBadge", "previewItem", "getPreviewItem", "()Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", "sheetItems", "getSheetItems", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11218a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<ar> f11219b;
    private final boolean c;
    private final int d;
    private final long e;
    private final String f;
    private final boolean g;
    private final boolean h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoUiState$Companion;", "", "<init>", "()V", "MAX_PENDING_SHEET_ITEMS", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11218a = new a(null);
    }

    public az() {
        this(null, false, 0, 0, null, false, false, 127, null);
    }

    public az(List<ar> r3, boolean r4, int r5, long r6, String r8, boolean r9, boolean r10) {
        List<ar> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "pendingItems");
        this.f11219b = r7;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }

    public /* synthetic */ az(List r10, boolean r11, int r12, long r13, String r15, boolean r16, boolean r17, int r18, DefaultConstructorMarker r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r18 & 1) == 0) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        boolean r2 = false;
        if ((r18 & 2) == 0) goto L8;
        boolean r1 = false;
    L10:
        if ((r18 & 4) == 0) goto L12;
        int r3 = 0;
    L14:
        if ((r18 & 8) == 0) goto L16;
        long r4 = 0;
    L18:
        if ((r18 & 16) == 0) goto L20;
        String r6 = null;
    L22:
        if ((r18 & 32) == 0) goto L24;
        boolean r7 = false;
    L26:
        if ((r18 & 64) != 0) goto L29;
        r2 = r17;
    L29:
        this(r0, r1, r3, r4, r6, r7, r2);
        return;
    L24:
        r7 = r16;
        goto L26
    L20:
        r6 = r15;
        goto L22
    L16:
        r4 = r13;
        goto L18
    L12:
        r3 = r12;
        goto L14
    L8:
        r1 = r11;
        goto L10
    }

    public static /* synthetic */ az a(az r9, List r10, boolean r11, int r12, long r13, String r15, boolean r16, boolean r17, int r18, Object r19) {
        List<ar> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if ((r18 & 1) == 0) goto L6;
        r1 = r9.f11219b;
    L6:
        if ((r18 & 2) == 0) goto L8;
        boolean r2 = r9.c;
    L10:
        if ((r18 & 4) == 0) goto L12;
        int r3 = r9.d;
    L14:
        if ((r18 & 8) == 0) goto L16;
        long r4 = r9.e;
    L18:
        if ((r18 & 16) == 0) goto L20;
        String r6 = r9.f;
    L22:
        if ((r18 & 32) == 0) goto L24;
        boolean r7 = r9.g;
    L26:
        if ((r18 & 64) == 0) goto L28;
        boolean r8 = r9.h;
    L30:
        return r9.a(r1, r2, r3, r4, r6, r7, r8);
    L28:
        r8 = r17;
        goto L30
    L24:
        r7 = r16;
        goto L26
    L20:
        r6 = r15;
        goto L22
    L16:
        r4 = r13;
        goto L18
    L12:
        r3 = r12;
        goto L14
    L8:
        r2 = r11;
        goto L10
    }

    public final az a(List<ar> r11, boolean r12, int r13, long r14, String r16, boolean r17, boolean r18) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "pendingItems");
        return new az(r2, r12, r13, r14, r16, r17, r18);
    }

    public final List<ar> a() {
        return this.f11219b;
    }

    public final boolean b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, az.class) == true) goto L8;
        return false;
    L8:
        az r10 = (az) ZeusTransformUtils.preCheckCast(r9, az.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f11219b, r10.f11219b) == true) goto L12;
        return false;
    L12:
        if (this.c == r10.c) goto L15;
        return false;
    L15:
        if (this.d == r10.d) goto L18;
        return false;
    L18:
        if (this.e == r10.e) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L24;
        return false;
    L24:
        if (this.g == r10.g) goto L27;
        return false;
    L27:
        if (this.h == r10.h) goto L29;
        return false;
    L29:
        return true;
    }

    public final boolean f() {
        return this.g;
    }

    public final boolean g() {
        return this.h;
    }

    public final ar h() {
        return (ar) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(this.f11219b), ar.class, "com.obric.memorydata.plugin");
    }

    public int hashCode() {
        int r0 = ((((((this.f11219b.hashCode() * 31) + Boolean.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31;
        String r1 = this.f;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + Boolean.hashCode(this.g)) * 31) + Boolean.hashCode(this.h);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final List<ar> i() {
        return CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(this.f11219b, Iterable.class, "com.obric.memorydata.plugin"), 20);
    }

    public String toString() {
        return "PendingPersonalInfoUiState(pendingItems=" + this.f11219b + ", loaded=" + this.c + ", pendingTotal=" + this.d + ", displayRevision=" + this.e + ", errorCode=" + this.f + ", isSheetOpen=" + this.g + ", showBadge=" + this.h + ')';
    }
}
