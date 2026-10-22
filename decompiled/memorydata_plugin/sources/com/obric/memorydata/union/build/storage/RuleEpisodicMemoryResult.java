package com.obric.memorydata.union.build.storage;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0003\b\u0083\b\u0018\u0000 '2\u00020\u0001:\u0001'BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003JZ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006("}, d2 = {"Lcom/obric/memorydata/union/build/storage/RuleEpisodicMemoryResult;", "", "code", "", "message", "entityId", "rawId", "", "operation", "dbWriteSuccess", "", "indexScheduled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZZ)V", "getCode", "()Ljava/lang/String;", "getMessage", "getEntityId", "getRawId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOperation", "getDbWriteSuccess", "()Z", "getIndexScheduled", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZZ)Lcom/obric/memorydata/union/build/storage/RuleEpisodicMemoryResult;", "equals", "other", "hashCode", "", "toString", "Companion", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RuleEpisodicMemoryResult {
    public static final a Companion = null;

    @SerializedName("code")
    private final String code;

    @SerializedName("dbWriteSuccess")
    private final boolean dbWriteSuccess;

    @SerializedName("entityId")
    private final String entityId;

    @SerializedName("indexScheduled")
    private final boolean indexScheduled;

    @SerializedName("message")
    private final String message;

    @SerializedName("operation")
    private final String operation;

    @SerializedName("rawId")
    private final Long rawId;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/union/build/storage/RuleEpisodicMemoryResult$Companion;", "", "<init>", "()V", "invalid", "Lcom/obric/memorydata/union/build/storage/RuleEpisodicMemoryResult;", "message", "", "failed", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final RuleEpisodicMemoryResult a(String r11) {
            Intrinsics.checkNotNullParameter(r11, "message");
            return new RuleEpisodicMemoryResult("400", r11, null, null, null, false, false, 124, null);
        }

        public final RuleEpisodicMemoryResult b(String r11) {
            Intrinsics.checkNotNullParameter(r11, "message");
            return new RuleEpisodicMemoryResult("500", r11, null, null, null, false, false, 124, null);
        }
    }

    static {
        Companion = new a(null);
    }

    public RuleEpisodicMemoryResult() {
        this(null, null, null, null, null, false, false, 127, null);
    }

    public RuleEpisodicMemoryResult(String r2, String r3, String r4, Long r5, String r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "code");
        Intrinsics.checkNotNullParameter(r3, "message");
        this.code = r2;
        this.message = r3;
        this.entityId = r4;
        this.rawId = r5;
        this.operation = r6;
        this.dbWriteSuccess = r7;
        this.indexScheduled = r8;
    }

    public /* synthetic */ RuleEpisodicMemoryResult(String r6, String r7, String r8, Long r9, String r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = BDLocationException.SUCCESS;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = "success";
    L8:
        String r15 = r7;
        String r0 = null;
        if ((r13 & 4) == 0) goto L11;
        String r1 = null;
    L13:
        if ((r13 & 8) == 0) goto L15;
        Long r2 = null;
    L17:
        if ((r13 & 16) != 0) goto L21;
        r0 = r10;
    L21:
        if ((r13 & 32) == 0) goto L23;
        boolean r3 = false;
    L25:
        if ((r13 & 64) == 0) goto L27;
        boolean r4 = false;
    L28:
        this(r6, r15, r1, r2, r0, r3, r4);
        return;
    L27:
        r4 = r12;
        goto L28
    L23:
        r3 = r11;
        goto L25
    L15:
        r2 = r9;
        goto L17
    L11:
        r1 = r8;
        goto L13
    }

    public static /* synthetic */ RuleEpisodicMemoryResult copy$default(RuleEpisodicMemoryResult r5, String r6, String r7, String r8, Long r9, String r10, boolean r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.code;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.message;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.entityId;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.rawId;
    L14:
        Long r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.operation;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.dbWriteSuccess;
    L20:
        boolean r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.indexScheduled;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.entityId;
    }

    public final Long component4() {
        return this.rawId;
    }

    public final String component5() {
        return this.operation;
    }

    public final boolean component6() {
        return this.dbWriteSuccess;
    }

    public final boolean component7() {
        return this.indexScheduled;
    }

    public final RuleEpisodicMemoryResult copy(String r9, String r10, String r11, Long r12, String r13, boolean r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r9, "code");
        Intrinsics.checkNotNullParameter(r10, "message");
        return new RuleEpisodicMemoryResult(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RuleEpisodicMemoryResult.class) == true) goto L8;
        return false;
    L8:
        RuleEpisodicMemoryResult r6 = (RuleEpisodicMemoryResult) ZeusTransformUtils.preCheckCast(r5, RuleEpisodicMemoryResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.code, r6.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entityId, r6.entityId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.rawId, r6.rawId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.operation, r6.operation) == true) goto L24;
        return false;
    L24:
        if (this.dbWriteSuccess == r6.dbWriteSuccess) goto L27;
        return false;
    L27:
        if (this.indexScheduled == r6.indexScheduled) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getCode() {
        return this.code;
    }

    public final boolean getDbWriteSuccess() {
        return this.dbWriteSuccess;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final boolean getIndexScheduled() {
        return this.indexScheduled;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final Long getRawId() {
        return this.rawId;
    }

    public int hashCode() {
        int r0 = ((this.code.hashCode() * 31) + this.message.hashCode()) * 31;
        String r1 = this.entityId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.rawId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.operation;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((r7 + r2) * 31) + Boolean.hashCode(this.dbWriteSuccess)) * 31) + Boolean.hashCode(this.indexScheduled);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "RuleEpisodicMemoryResult(code=" + this.code + ", message=" + this.message + ", entityId=" + this.entityId + ", rawId=" + this.rawId + ", operation=" + this.operation + ", dbWriteSuccess=" + this.dbWriteSuccess + ", indexScheduled=" + this.indexScheduled + ')';
    }
}
