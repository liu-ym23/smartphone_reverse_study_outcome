package com.obric.memorydata.database.entity;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001*BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003Jc\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006+"}, d2 = {"Lcom/obric/memorydata/database/entity/SpeakerEmbeddingPendingEntity;", "", "embeddingId", "", ObricMemoryConstants.KEY_SESSION_ID, "localSpeakerId", "modelVersion", "vector", "rawObservationIds", "phaseState", "createdAt", "", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getEmbeddingId", "()Ljava/lang/String;", "getSessionId", "getLocalSpeakerId", "getModelVersion", "getVector", "getRawObservationIds", "getPhaseState", "getCreatedAt", "()J", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SpeakerEmbeddingPendingEntity {
    public static final a Companion = null;
    public static final String STATE_COMMITTED = "COMMITTED";
    public static final String STATE_PREPARED = "PREPARED";
    private final long createdAt;
    private final String embeddingId;
    private final String localSpeakerId;
    private final String modelVersion;
    private final String phaseState;
    private final String rawObservationIds;
    private final String sessionId;
    private final long updatedAt;
    private final String vector;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/entity/SpeakerEmbeddingPendingEntity$Companion;", "", "<init>", "()V", "STATE_PREPARED", "", "STATE_COMMITTED", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public SpeakerEmbeddingPendingEntity(String r2, String r3, String r4, String r5, String r6, String r7, String r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r2, "embeddingId");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r4, "localSpeakerId");
        Intrinsics.checkNotNullParameter(r5, "modelVersion");
        Intrinsics.checkNotNullParameter(r6, "vector");
        Intrinsics.checkNotNullParameter(r7, "rawObservationIds");
        Intrinsics.checkNotNullParameter(r8, "phaseState");
        this.embeddingId = r2;
        this.sessionId = r3;
        this.localSpeakerId = r4;
        this.modelVersion = r5;
        this.vector = r6;
        this.rawObservationIds = r7;
        this.phaseState = r8;
        this.createdAt = r9;
        this.updatedAt = r11;
    }

    public /* synthetic */ SpeakerEmbeddingPendingEntity(String r15, String r16, String r17, String r18, String r19, String r20, String r21, long r22, long r24, int r26, DefaultConstructorMarker r27) {
        if ((r26 & 64) == 0) goto L5;
        String r9 = STATE_PREPARED;
    L7:
        if ((r26 & 128) == 0) goto L9;
        long r10 = 0;
    L11:
        if ((r26 & 256) == 0) goto L13;
        long r12 = 0;
    L14:
        this(r15, r16, r17, r18, r19, r20, r9, r10, r12);
        return;
    L13:
        r12 = r24;
        goto L14
    L9:
        r10 = r22;
        goto L11
    L5:
        r9 = r21;
        goto L7
    }

    public static /* synthetic */ SpeakerEmbeddingPendingEntity copy$default(SpeakerEmbeddingPendingEntity r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, long r21, long r23, int r25, Object r26) {
        if ((r25 & 1) == 0) goto L5;
        String r2 = r13.embeddingId;
    L7:
        if ((r25 & 2) == 0) goto L9;
        String r3 = r13.sessionId;
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r4 = r13.localSpeakerId;
    L15:
        if ((r25 & 8) == 0) goto L17;
        String r5 = r13.modelVersion;
    L19:
        if ((r25 & 16) == 0) goto L21;
        String r6 = r13.vector;
    L23:
        if ((r25 & 32) == 0) goto L25;
        String r7 = r13.rawObservationIds;
    L27:
        if ((r25 & 64) == 0) goto L29;
        String r8 = r13.phaseState;
    L31:
        if ((r25 & 128) == 0) goto L33;
        long r9 = r13.createdAt;
    L35:
        if ((r25 & 256) == 0) goto L37;
        long r11 = r13.updatedAt;
    L39:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r11);
    L37:
        r11 = r23;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final String component1() {
        return this.embeddingId;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component3() {
        return this.localSpeakerId;
    }

    public final String component4() {
        return this.modelVersion;
    }

    public final String component5() {
        return this.vector;
    }

    public final String component6() {
        return this.rawObservationIds;
    }

    public final String component7() {
        return this.phaseState;
    }

    public final long component8() {
        return this.createdAt;
    }

    public final long component9() {
        return this.updatedAt;
    }

    public final SpeakerEmbeddingPendingEntity copy(String r14, String r15, String r16, String r17, String r18, String r19, String r20, long r21, long r23) {
        Intrinsics.checkNotNullParameter(r14, "embeddingId");
        Intrinsics.checkNotNullParameter(r15, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r16, "localSpeakerId");
        Intrinsics.checkNotNullParameter(r17, "modelVersion");
        Intrinsics.checkNotNullParameter(r18, "vector");
        Intrinsics.checkNotNullParameter(r19, "rawObservationIds");
        Intrinsics.checkNotNullParameter(r20, "phaseState");
        return new SpeakerEmbeddingPendingEntity(r14, r15, r16, r17, r18, r19, r20, r21, r23);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SpeakerEmbeddingPendingEntity.class) == true) goto L8;
        return false;
    L8:
        SpeakerEmbeddingPendingEntity r10 = (SpeakerEmbeddingPendingEntity) ZeusTransformUtils.preCheckCast(r9, SpeakerEmbeddingPendingEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.embeddingId, r10.embeddingId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sessionId, r10.sessionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localSpeakerId, r10.localSpeakerId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.modelVersion, r10.modelVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.vector, r10.vector) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.rawObservationIds, r10.rawObservationIds) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.phaseState, r10.phaseState) == true) goto L30;
        return false;
    L30:
        if (this.createdAt == r10.createdAt) goto L33;
        return false;
    L33:
        if (this.updatedAt == r10.updatedAt) goto L35;
        return false;
    L35:
        return true;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getEmbeddingId() {
        return this.embeddingId;
    }

    public final String getLocalSpeakerId() {
        return this.localSpeakerId;
    }

    public final String getModelVersion() {
        return this.modelVersion;
    }

    public final String getPhaseState() {
        return this.phaseState;
    }

    public final String getRawObservationIds() {
        return this.rawObservationIds;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getVector() {
        return this.vector;
    }

    public int hashCode() {
        return (((((((((((((((this.embeddingId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.localSpeakerId.hashCode()) * 31) + this.modelVersion.hashCode()) * 31) + this.vector.hashCode()) * 31) + this.rawObservationIds.hashCode()) * 31) + this.phaseState.hashCode()) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "SpeakerEmbeddingPendingEntity(embeddingId=" + this.embeddingId + ", sessionId=" + this.sessionId + ", localSpeakerId=" + this.localSpeakerId + ", modelVersion=" + this.modelVersion + ", vector=" + this.vector + ", rawObservationIds=" + this.rawObservationIds + ", phaseState=" + this.phaseState + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ')';
    }
}
