package com.obric.search.api.a;

import com.bytedance.security.dbcipher.utils.CipherConst;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\r\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0010¨\u0006#"}, d2 = {"Lcom/obric/search/api/config/SQLCipherConfig;", "", "kdfIteration", "", "hmacEnabled", "", "hmacAlgorithm", "kdfAlgorithm", "pageSize", "(IZIII)V", "getHmacAlgorithm", "()I", "getHmacEnabled", "()Z", "getKdfAlgorithm", "setKdfAlgorithm", "(I)V", "getKdfIteration", "getPageSize", "setPageSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toSQLiteCipherSpec", "Lcom/tencent/wcdb/database/SQLiteCipherSpec;", "toSQLiteCipherSpec$sdk_release", "toString", "", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14924a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14925b;
    private final boolean c;
    private final int d;
    private int e;
    private int f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/search/api/config/SQLCipherConfig$Companion;", "", "()V", "HMAC_DEFAULT", "", CipherConst.HMAC_SHA1, CipherConst.HMAC_SHA256, CipherConst.HMAC_SHA512, "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f14924a = new a(null);
    }

    public b() {
        this(0, false, 0, 0, 0, 31, null);
    }

    public b(int r1, boolean r2, int r3, int r4, int r5) {
        this.f14925b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }

    public /* synthetic */ b(int r4, boolean r5, int r6, int r7, int r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = true;
    L8:
        boolean r11 = r5;
        int r0 = -1;
        if ((r9 & 4) == 0) goto L11;
        int r1 = -1;
    L13:
        if ((r9 & 8) != 0) goto L17;
        r0 = r7;
    L17:
        if ((r9 & 16) == 0) goto L19;
        r8 = SQLiteGlobal.f15849a;
    L19:
        this(r4, r11, r1, r0, r8);
        return;
    L11:
        r1 = r6;
        goto L13
    }

    public final SQLiteCipherSpec a() {
        SQLiteCipherSpec r2 = new SQLiteCipherSpec().a(this.f14925b).a(this.c).b(this.d).c(this.e).d(this.f);
        Intrinsics.checkNotNullExpressionValue(r2, "SQLiteCipherSpec()\n     …   .setPageSize(pageSize)");
        return r2;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (this.f14925b == r6.f14925b) goto L12;
        return false;
    L12:
        if (this.c == r6.c) goto L15;
        return false;
    L15:
        if (this.d == r6.d) goto L18;
        return false;
    L18:
        if (this.e == r6.e) goto L21;
        return false;
    L21:
        if (this.f == r6.f) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int r0 = Integer.hashCode(this.f14925b) * 31;
        boolean r1 = this.c;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((((((r0 + r2) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "SQLCipherConfig(kdfIteration=" + this.f14925b + ", hmacEnabled=" + this.c + ", hmacAlgorithm=" + this.d + ", kdfAlgorithm=" + this.e + ", pageSize=" + this.f + ')';
    }
}
