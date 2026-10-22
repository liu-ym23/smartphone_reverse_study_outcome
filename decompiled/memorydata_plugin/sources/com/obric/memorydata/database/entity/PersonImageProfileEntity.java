package com.obric.memorydata.database.entity;

import androidx.core.app.FrameMetricsAggregator;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jg\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006+"}, d2 = {"Lcom/obric/memorydata/database/entity/PersonImageProfileEntity;", "", OaidModel.KEY_ID, "", "profileId", "", "embedding", "dim", "", "resourceId", "modelVersion", "confidence", "profileImageType", "createdAt", "<init>", "(JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()J", "getProfileId", "()Ljava/lang/String;", "getEmbedding", "getDim", "()I", "getResourceId", "getModelVersion", "getConfidence", "getProfileImageType", "getCreatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonImageProfileEntity {
    private final String confidence;
    private final long createdAt;
    private final int dim;
    private final String embedding;
    private final long id;
    private final String modelVersion;
    private final String profileId;
    private final String profileImageType;
    private final String resourceId;

    public PersonImageProfileEntity() {
        this(0, null, null, 0, null, null, null, null, 0, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public PersonImageProfileEntity(long r2, String r4, String r5, int r6, String r7, String r8, String r9, String r10, long r11) {
        Intrinsics.checkNotNullParameter(r4, "profileId");
        Intrinsics.checkNotNullParameter(r5, "embedding");
        Intrinsics.checkNotNullParameter(r8, "modelVersion");
        Intrinsics.checkNotNullParameter(r10, "profileImageType");
        this.id = r2;
        this.profileId = r4;
        this.embedding = r5;
        this.dim = r6;
        this.resourceId = r7;
        this.modelVersion = r8;
        this.confidence = r9;
        this.profileImageType = r10;
        this.createdAt = r11;
    }

    public /* synthetic */ PersonImageProfileEntity(long r13, String r15, String r16, int r17, String r18, String r19, String r20, String r21, long r22, int r24, DefaultConstructorMarker r25) {
        long r2 = 0;
        if ((r24 & 1) == 0) goto L5;
        long r4 = 0;
    L6:
        String r6 = "";
        if ((r24 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r7 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L15:
        if ((r24 & 8) == 0) goto L17;
        int r8 = 0;
    L18:
        String r10 = null;
        if ((r24 & 16) == 0) goto L21;
        String r9 = null;
    L23:
        if ((r24 & 32) != 0) goto L27;
        r6 = r19;
    L27:
        if ((r24 & 64) != 0) goto L31;
        r10 = r20;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r11 = "face";
    L35:
        if ((r24 & 256) != 0) goto L38;
        r2 = r22;
    L38:
        this(r4, r1, r7, r8, r9, r6, r10, r11, r2);
        return;
    L33:
        r11 = r21;
        goto L35
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L18
    L13:
        r7 = r16;
        goto L15
    L9:
        r1 = r15;
        goto L11
    L5:
        r4 = r13;
        goto L6
    }

    public static /* synthetic */ PersonImageProfileEntity copy$default(PersonImageProfileEntity r13, long r14, String r16, String r17, int r18, String r19, String r20, String r21, String r22, long r23, int r25, Object r26) {
        if ((r25 & 1) == 0) goto L5;
        long r2 = r13.id;
    L7:
        if ((r25 & 2) == 0) goto L9;
        String r4 = r13.profileId;
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r5 = r13.embedding;
    L15:
        if ((r25 & 8) == 0) goto L17;
        int r6 = r13.dim;
    L19:
        if ((r25 & 16) == 0) goto L21;
        String r7 = r13.resourceId;
    L23:
        if ((r25 & 32) == 0) goto L25;
        String r8 = r13.modelVersion;
    L27:
        if ((r25 & 64) == 0) goto L29;
        String r9 = r13.confidence;
    L31:
        if ((r25 & 128) == 0) goto L33;
        String r10 = r13.profileImageType;
    L35:
        if ((r25 & 256) == 0) goto L37;
        long r11 = r13.createdAt;
    L39:
        return r13.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11);
    L37:
        r11 = r23;
        goto L39
    L33:
        r10 = r22;
        goto L35
    L29:
        r9 = r21;
        goto L31
    L25:
        r8 = r20;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.profileId;
    }

    public final String component3() {
        return this.embedding;
    }

    public final int component4() {
        return this.dim;
    }

    public final String component5() {
        return this.resourceId;
    }

    public final String component6() {
        return this.modelVersion;
    }

    public final String component7() {
        return this.confidence;
    }

    public final String component8() {
        return this.profileImageType;
    }

    public final long component9() {
        return this.createdAt;
    }

    public final PersonImageProfileEntity copy(long r14, String r16, String r17, int r18, String r19, String r20, String r21, String r22, long r23) {
        Intrinsics.checkNotNullParameter(r16, "profileId");
        Intrinsics.checkNotNullParameter(r17, "embedding");
        Intrinsics.checkNotNullParameter(r20, "modelVersion");
        Intrinsics.checkNotNullParameter(r22, "profileImageType");
        return new PersonImageProfileEntity(r14, r16, r17, r18, r19, r20, r21, r22, r23);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, PersonImageProfileEntity.class) == true) goto L8;
        return false;
    L8:
        PersonImageProfileEntity r10 = (PersonImageProfileEntity) ZeusTransformUtils.preCheckCast(r9, PersonImageProfileEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.profileId, r10.profileId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.embedding, r10.embedding) == true) goto L18;
        return false;
    L18:
        if (this.dim == r10.dim) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceId, r10.resourceId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.modelVersion, r10.modelVersion) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.confidence, r10.confidence) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.profileImageType, r10.profileImageType) == true) goto L33;
        return false;
    L33:
        if (this.createdAt == r10.createdAt) goto L35;
        return false;
    L35:
        return true;
    }

    public final String getConfidence() {
        return this.confidence;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final int getDim() {
        return this.dim;
    }

    public final String getEmbedding() {
        return this.embedding;
    }

    public final long getId() {
        return this.id;
    }

    public final String getModelVersion() {
        return this.modelVersion;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final String getProfileImageType() {
        return this.profileImageType;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public int hashCode() {
        int r0 = ((((((Long.hashCode(this.id) * 31) + this.profileId.hashCode()) * 31) + this.embedding.hashCode()) * 31) + Integer.hashCode(this.dim)) * 31;
        String r1 = this.resourceId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.modelVersion.hashCode()) * 31;
        String r5 = this.confidence;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((r4 + r2) * 31) + this.profileImageType.hashCode()) * 31) + Long.hashCode(this.createdAt);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "PersonImageProfileEntity(id=" + this.id + ", profileId=" + this.profileId + ", embedding=" + this.embedding + ", dim=" + this.dim + ", resourceId=" + this.resourceId + ", modelVersion=" + this.modelVersion + ", confidence=" + this.confidence + ", profileImageType=" + this.profileImageType + ", createdAt=" + this.createdAt + ')';
    }
}
