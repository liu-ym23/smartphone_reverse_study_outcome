package com.obric.memorydata.database.entity;

import androidx.core.app.FrameMetricsAggregator;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006+"}, d2 = {"Lcom/obric/memorydata/database/entity/PersonAudioProfileEntity;", "", OaidModel.KEY_ID, "", "profileId", "", AILabCheckPermissionTask.KEY_SOURCE, "embedding", "dim", "", "resourceId", "modelVersion", "durationMs", "createdAt", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JJ)V", "getId", "()J", "getProfileId", "()Ljava/lang/String;", "getSource", "getEmbedding", "getDim", "()I", "getResourceId", "getModelVersion", "getDurationMs", "getCreatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonAudioProfileEntity {
    private final long createdAt;
    private final int dim;
    private final long durationMs;
    private final String embedding;
    private final long id;
    private final String modelVersion;
    private final String profileId;
    private final String resourceId;
    private final String source;

    public PersonAudioProfileEntity() {
        this(0, null, null, null, 0, null, null, 0, 0, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public PersonAudioProfileEntity(long r2, String r4, String r5, String r6, int r7, String r8, String r9, long r10, long r12) {
        Intrinsics.checkNotNullParameter(r4, "profileId");
        Intrinsics.checkNotNullParameter(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r6, "embedding");
        Intrinsics.checkNotNullParameter(r9, "modelVersion");
        this.id = r2;
        this.profileId = r4;
        this.source = r5;
        this.embedding = r6;
        this.dim = r7;
        this.resourceId = r8;
        this.modelVersion = r9;
        this.durationMs = r10;
        this.createdAt = r12;
    }

    public /* synthetic */ PersonAudioProfileEntity(long r14, String r16, String r17, String r18, int r19, String r20, String r21, long r22, long r24, int r26, DefaultConstructorMarker r27) {
        long r2 = 0;
        if ((r26 & 1) == 0) goto L5;
        long r4 = 0;
    L6:
        String r6 = "";
        if ((r26 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r7 = "glasses";
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r8 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L19:
        if ((r26 & 16) == 0) goto L21;
        int r9 = 0;
    L23:
        if ((r26 & 32) == 0) goto L25;
        String r10 = null;
    L27:
        if ((r26 & 64) != 0) goto L31;
        r6 = r21;
    L31:
        if ((r26 & 128) == 0) goto L33;
        long r11 = 0;
    L35:
        if ((r26 & 256) != 0) goto L38;
        r2 = r24;
    L38:
        this(r4, r1, r7, r8, r9, r10, r6, r11, r2);
        return;
    L33:
        r11 = r22;
        goto L35
    L25:
        r10 = r20;
        goto L27
    L21:
        r9 = r19;
        goto L23
    L17:
        r8 = r18;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r1 = r16;
        goto L11
    L5:
        r4 = r14;
        goto L6
    }

    public static /* synthetic */ PersonAudioProfileEntity copy$default(PersonAudioProfileEntity r14, long r15, String r17, String r18, String r19, int r20, String r21, String r22, long r23, long r25, int r27, Object r28) {
        if ((r27 & 1) == 0) goto L5;
        long r2 = r14.id;
    L7:
        if ((r27 & 2) == 0) goto L9;
        String r4 = r14.profileId;
    L11:
        if ((r27 & 4) == 0) goto L13;
        String r5 = r14.source;
    L15:
        if ((r27 & 8) == 0) goto L17;
        String r6 = r14.embedding;
    L19:
        if ((r27 & 16) == 0) goto L21;
        int r7 = r14.dim;
    L23:
        if ((r27 & 32) == 0) goto L25;
        String r8 = r14.resourceId;
    L27:
        if ((r27 & 64) == 0) goto L29;
        String r9 = r14.modelVersion;
    L31:
        if ((r27 & 128) == 0) goto L33;
        long r10 = r14.durationMs;
    L35:
        if ((r27 & 256) == 0) goto L37;
        long r12 = r14.createdAt;
    L39:
        return r14.copy(r2, r4, r5, r6, r7, r8, r9, r10, r12);
    L37:
        r12 = r25;
        goto L39
    L33:
        r10 = r23;
        goto L35
    L29:
        r9 = r22;
        goto L31
    L25:
        r8 = r21;
        goto L27
    L21:
        r7 = r20;
        goto L23
    L17:
        r6 = r19;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r4 = r17;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.profileId;
    }

    public final String component3() {
        return this.source;
    }

    public final String component4() {
        return this.embedding;
    }

    public final int component5() {
        return this.dim;
    }

    public final String component6() {
        return this.resourceId;
    }

    public final String component7() {
        return this.modelVersion;
    }

    public final long component8() {
        return this.durationMs;
    }

    public final long component9() {
        return this.createdAt;
    }

    public final PersonAudioProfileEntity copy(long r15, String r17, String r18, String r19, int r20, String r21, String r22, long r23, long r25) {
        Intrinsics.checkNotNullParameter(r17, "profileId");
        Intrinsics.checkNotNullParameter(r18, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r19, "embedding");
        Intrinsics.checkNotNullParameter(r22, "modelVersion");
        return new PersonAudioProfileEntity(r15, r17, r18, r19, r20, r21, r22, r23, r25);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, PersonAudioProfileEntity.class) == true) goto L8;
        return false;
    L8:
        PersonAudioProfileEntity r10 = (PersonAudioProfileEntity) ZeusTransformUtils.preCheckCast(r9, PersonAudioProfileEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.profileId, r10.profileId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.source, r10.source) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.embedding, r10.embedding) == true) goto L21;
        return false;
    L21:
        if (this.dim == r10.dim) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resourceId, r10.resourceId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.modelVersion, r10.modelVersion) == true) goto L30;
        return false;
    L30:
        if (this.durationMs == r10.durationMs) goto L33;
        return false;
    L33:
        if (this.createdAt == r10.createdAt) goto L35;
        return false;
    L35:
        return true;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final int getDim() {
        return this.dim;
    }

    public final long getDurationMs() {
        return this.durationMs;
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

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        int r0 = ((((((((Long.hashCode(this.id) * 31) + this.profileId.hashCode()) * 31) + this.source.hashCode()) * 31) + this.embedding.hashCode()) * 31) + Integer.hashCode(this.dim)) * 31;
        String r1 = this.resourceId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + this.modelVersion.hashCode()) * 31) + Long.hashCode(this.durationMs)) * 31) + Long.hashCode(this.createdAt);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "PersonAudioProfileEntity(id=" + this.id + ", profileId=" + this.profileId + ", source=" + this.source + ", embedding=" + this.embedding + ", dim=" + this.dim + ", resourceId=" + this.resourceId + ", modelVersion=" + this.modelVersion + ", durationMs=" + this.durationMs + ", createdAt=" + this.createdAt + ')';
    }
}
