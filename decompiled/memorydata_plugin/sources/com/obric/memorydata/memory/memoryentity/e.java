package com.obric.memorydata.memory.memoryentity;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\"\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010)\u001a\u00020\u000eHÆ\u0003Jr\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0007HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "", "uri", "", "hash", AILabCheckPermissionTask.KEY_SOURCE, "imageType", "", "mimeType", "size", "", "width", "height", "decodedCompressed", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "getUri", "()Ljava/lang/String;", "getHash", "getSource", "getImageType", "()I", "getMimeType", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getDecodedCompressed", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/obric/memorydata/memory/memoryentity/MemorySourceImageInfo;", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10322b;
    private final String c;
    private final int d;
    private final String e;
    private final Long f;
    private final Integer g;
    private final Integer h;
    private final boolean i;

    public e(String r2, String r3, String r4, int r5, String r6, Long r7, Integer r8, Integer r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "hash");
        this.f10321a = r2;
        this.f10322b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }

    public /* synthetic */ e(String r11, String r12, String r13, int r14, String r15, Long r16, Integer r17, Integer r18, boolean r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 2) == 0) goto L5;
        String r1 = "";
    L6:
        Integer r3 = null;
        if ((r20 & 4) == 0) goto L9;
        String r2 = null;
    L10:
        boolean r5 = false;
        if ((r20 & 8) == 0) goto L13;
        int r4 = 0;
    L15:
        if ((r20 & 16) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r20 & 32) == 0) goto L21;
        Long r7 = null;
    L23:
        if ((r20 & 64) == 0) goto L25;
        Integer r8 = null;
    L27:
        if ((r20 & 128) != 0) goto L31;
        r3 = r18;
    L31:
        if ((r20 & 256) != 0) goto L34;
        r5 = r19;
    L34:
        this(r11, r1, r2, r4, r6, r7, r8, r3, r5);
        return;
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L10
    L5:
        r1 = r12;
        goto L6
    }

    public static /* synthetic */ e a(e r10, String r11, String r12, String r13, int r14, String r15, Long r16, Integer r17, Integer r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r2 = r10.f10321a;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.f10322b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.c;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r5 = r10.d;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.e;
    L23:
        if ((r20 & 32) == 0) goto L25;
        Long r7 = r10.f;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Integer r8 = r10.g;
    L31:
        if ((r20 & 128) == 0) goto L33;
        Integer r9 = r10.h;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r1 = r10.i;
    L39:
        return r10.a(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final e a(String r12, String r13, String r14, int r15, String r16, Long r17, Integer r18, Integer r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r12, "uri");
        Intrinsics.checkNotNullParameter(r13, "hash");
        return new e(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public final String a() {
        return this.f10321a;
    }

    public final String b() {
        return this.f10322b;
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10321a, r6.f10321a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10322b, r6.f10322b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L35;
        return false;
    L35:
        return true;
    }

    public final Long f() {
        return this.f;
    }

    public final Integer g() {
        return this.g;
    }

    public final Integer h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((this.f10321a.hashCode() * 31) + this.f10322b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Integer.hashCode(this.d)) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.f;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.g;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.h;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return ((r13 + r2) * 31) + Boolean.hashCode(this.i);
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final boolean i() {
        return this.i;
    }

    public String toString() {
        return "MemorySourceImageInfo(uri=" + this.f10321a + ", hash=" + this.f10322b + ", source=" + this.c + ", imageType=" + this.d + ", mimeType=" + this.e + ", size=" + this.f + ", width=" + this.g + ", height=" + this.h + ", decodedCompressed=" + this.i + ')';
    }
}
