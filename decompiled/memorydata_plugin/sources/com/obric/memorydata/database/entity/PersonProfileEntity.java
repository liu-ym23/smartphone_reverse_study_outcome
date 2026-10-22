package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J]\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006'"}, d2 = {"Lcom/obric/memorydata/database/entity/PersonProfileEntity;", "", "profileId", "", "alias", "aliasConfidence", "summary", "summaryConfidence", "l1RefIds", "createdAt", "", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getProfileId", "()Ljava/lang/String;", "getAlias", "getAliasConfidence", "getSummary", "getSummaryConfidence", "getL1RefIds", "getCreatedAt", "()J", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonProfileEntity {
    private final String alias;
    private final String aliasConfidence;
    private final long createdAt;
    private final String l1RefIds;
    private final String profileId;
    private final String summary;
    private final String summaryConfidence;
    private final long updatedAt;

    public PersonProfileEntity(String r2, String r3, String r4, String r5, String r6, String r7, long r8, long r10) {
        Intrinsics.checkNotNullParameter(r2, "profileId");
        Intrinsics.checkNotNullParameter(r3, "alias");
        Intrinsics.checkNotNullParameter(r5, "summary");
        Intrinsics.checkNotNullParameter(r7, "l1RefIds");
        this.profileId = r2;
        this.alias = r3;
        this.aliasConfidence = r4;
        this.summary = r5;
        this.summaryConfidence = r6;
        this.l1RefIds = r7;
        this.createdAt = r8;
        this.updatedAt = r10;
    }

    public /* synthetic */ PersonProfileEntity(String r12, String r13, String r14, String r15, String r16, String r17, long r18, long r20, int r22, DefaultConstructorMarker r23) {
        String r2 = "";
        if ((r22 & 2) == 0) goto L5;
        String r1 = "";
    L6:
        String r4 = null;
        if ((r22 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r22 & 8) != 0) goto L15;
        r2 = r15;
    L15:
        if ((r22 & 16) != 0) goto L19;
        r4 = r16;
    L19:
        if ((r22 & 32) == 0) goto L21;
        String r5 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L22:
        long r7 = 0;
        if ((r22 & 64) == 0) goto L25;
        long r9 = 0;
    L27:
        if ((r22 & 128) != 0) goto L30;
        r7 = r20;
    L30:
        this(r12, r1, r3, r2, r4, r5, r9, r7);
        return;
    L25:
        r9 = r18;
        goto L27
    L21:
        r5 = r17;
        goto L22
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L6
    }

    public static /* synthetic */ PersonProfileEntity copy$default(PersonProfileEntity r12, String r13, String r14, String r15, String r16, String r17, String r18, long r19, long r21, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        String r2 = r12.profileId;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r3 = r12.alias;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r4 = r12.aliasConfidence;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r5 = r12.summary;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r6 = r12.summaryConfidence;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r7 = r12.l1RefIds;
    L27:
        if ((r23 & 64) == 0) goto L29;
        long r8 = r12.createdAt;
    L31:
        if ((r23 & 128) == 0) goto L33;
        long r10 = r12.updatedAt;
    L35:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r10);
    L33:
        r10 = r21;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.profileId;
    }

    public final String component2() {
        return this.alias;
    }

    public final String component3() {
        return this.aliasConfidence;
    }

    public final String component4() {
        return this.summary;
    }

    public final String component5() {
        return this.summaryConfidence;
    }

    public final String component6() {
        return this.l1RefIds;
    }

    public final long component7() {
        return this.createdAt;
    }

    public final long component8() {
        return this.updatedAt;
    }

    public final PersonProfileEntity copy(String r13, String r14, String r15, String r16, String r17, String r18, long r19, long r21) {
        Intrinsics.checkNotNullParameter(r13, "profileId");
        Intrinsics.checkNotNullParameter(r14, "alias");
        Intrinsics.checkNotNullParameter(r16, "summary");
        Intrinsics.checkNotNullParameter(r18, "l1RefIds");
        return new PersonProfileEntity(r13, r14, r15, r16, r17, r18, r19, r21);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, PersonProfileEntity.class) == true) goto L8;
        return false;
    L8:
        PersonProfileEntity r10 = (PersonProfileEntity) ZeusTransformUtils.preCheckCast(r9, PersonProfileEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.profileId, r10.profileId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.alias, r10.alias) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.aliasConfidence, r10.aliasConfidence) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.summary, r10.summary) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.summaryConfidence, r10.summaryConfidence) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.l1RefIds, r10.l1RefIds) == true) goto L27;
        return false;
    L27:
        if (this.createdAt == r10.createdAt) goto L30;
        return false;
    L30:
        if (this.updatedAt == r10.updatedAt) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getAliasConfidence() {
        return this.aliasConfidence;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getL1RefIds() {
        return this.l1RefIds;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getSummaryConfidence() {
        return this.summaryConfidence;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int r0 = ((this.profileId.hashCode() * 31) + this.alias.hashCode()) * 31;
        String r1 = this.aliasConfidence;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.summary.hashCode()) * 31;
        String r5 = this.summaryConfidence;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((((r4 + r2) * 31) + this.l1RefIds.hashCode()) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "PersonProfileEntity(profileId=" + this.profileId + ", alias=" + this.alias + ", aliasConfidence=" + this.aliasConfidence + ", summary=" + this.summary + ", summaryConfidence=" + this.summaryConfidence + ", l1RefIds=" + this.l1RefIds + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ')';
    }
}
