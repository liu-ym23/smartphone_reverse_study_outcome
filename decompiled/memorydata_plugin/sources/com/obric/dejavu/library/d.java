package com.obric.dejavu.library;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003JO\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/obric/dejavu/library/DbOptions;", "", "dbname", "", "dims", "", "createIfMissing", "", "errorIfExists", "compressLevel", "kvEngine", "Lcom/obric/dejavu/library/KvEngineType;", "indexCfg", "Lcom/obric/dejavu/library/DbIndexConfig;", "(Ljava/lang/String;IZZILcom/obric/dejavu/library/KvEngineType;Lcom/obric/dejavu/library/DbIndexConfig;)V", "getCompressLevel", "()I", "getCreateIfMissing", "()Z", "getDbname", "()Ljava/lang/String;", "getDims", "getErrorIfExists", "getIndexCfg", "()Lcom/obric/dejavu/library/DbIndexConfig;", "getKvEngine", "()Lcom/obric/dejavu/library/KvEngineType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7888b;
    private final boolean c;
    private final boolean d;
    private final int e;
    private final KvEngineType f;
    private final a g;

    public d(String r2, int r3, boolean r4, boolean r5, int r6, KvEngineType r7, a r8) {
        Intrinsics.checkNotNullParameter(r2, "dbname");
        Intrinsics.checkNotNullParameter(r7, "kvEngine");
        Intrinsics.checkNotNullParameter(r8, "indexCfg");
        this.f7887a = r2;
        this.f7888b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public /* synthetic */ d(String r23, int r24, boolean r25, boolean r26, int r27, KvEngineType r28, a r29, int r30, DefaultConstructorMarker r31) {
        if ((r30 & 4) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r30 & 8) == 0) goto L9;
        boolean r6 = false;
    L11:
        if ((r30 & 16) == 0) goto L13;
        int r7 = 0;
    L15:
        if ((r30 & 32) == 0) goto L17;
        KvEngineType r8 = KvEngineType.LevelDb;
    L19:
        if ((r30 & 64) == 0) goto L21;
        a r9 = new a(null, null, 0, 0, 0, 0, 0, 0, 0, false, 1023, null);
    L22:
        this(r23, r24, r5, r6, r7, r8, r9);
        return;
    L21:
        r9 = r29;
        goto L22
    L17:
        r8 = r28;
        goto L19
    L13:
        r7 = r27;
        goto L15
    L9:
        r6 = r26;
        goto L11
    L5:
        r5 = r25;
        goto L7
    }

    public final String a() {
        return this.f7887a;
    }

    public final int b() {
        return this.f7888b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f7887a, r6.f7887a) == true) goto L12;
        return false;
    L12:
        if (this.f7888b == r6.f7888b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final KvEngineType f() {
        return this.f;
    }

    public final a g() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = ((this.f7887a.hashCode() * 31) + Integer.hashCode(this.f7888b)) * 31;
        boolean r1 = this.c;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.d;
        if (r5 == true) goto L10;
        r2 = r5;
    L10:
        return ((((((r4 + r2) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "DbOptions(dbname=" + this.f7887a + ", dims=" + this.f7888b + ", createIfMissing=" + this.c + ", errorIfExists=" + this.d + ", compressLevel=" + this.e + ", kvEngine=" + this.f + ", indexCfg=" + this.g + ')';
    }
}
