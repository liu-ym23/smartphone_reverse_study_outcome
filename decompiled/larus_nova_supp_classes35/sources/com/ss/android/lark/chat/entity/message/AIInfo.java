package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AIInfo;", "Ljava/io/Serializable;", "roundId", BuildConfig.FLAVOR, "buttonConfig", "Lcom/ss/android/lark/chat/entity/message/AIButtonConfig;", "rootRoundId", "enterpriseQAGeneralInfo", "Lcom/ss/android/lark/chat/entity/message/EnterpriseQAGeneralInfo;", "<init>", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/AIButtonConfig;Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/EnterpriseQAGeneralInfo;)V", "getRoundId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getButtonConfig", "()Lcom/ss/android/lark/chat/entity/message/AIButtonConfig;", "getRootRoundId", "getEnterpriseQAGeneralInfo", "()Lcom/ss/android/lark/chat/entity/message/EnterpriseQAGeneralInfo;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/AIButtonConfig;Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/EnterpriseQAGeneralInfo;)Lcom/ss/android/lark/chat/entity/message/AIInfo;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIInfo implements Serializable {
    private final AIButtonConfig buttonConfig;
    private final EnterpriseQAGeneralInfo enterpriseQAGeneralInfo;
    private final Long rootRoundId;
    private final Long roundId;

    public static /* synthetic */ AIInfo copy$default(AIInfo r0, Long r1, AIButtonConfig r2, Long r3, EnterpriseQAGeneralInfo r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.roundId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.buttonConfig;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.rootRoundId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.enterpriseQAGeneralInfo;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Long component1() {
        return this.roundId;
    }

    public final AIButtonConfig component2() {
        return this.buttonConfig;
    }

    public final Long component3() {
        return this.rootRoundId;
    }

    public final EnterpriseQAGeneralInfo component4() {
        return this.enterpriseQAGeneralInfo;
    }

    public final AIInfo copy(Long r2, AIButtonConfig r3, Long r4, EnterpriseQAGeneralInfo r5) {
        return new AIInfo(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIInfo) == true) goto L8;
        return false;
    L8:
        AIInfo r6 = (AIInfo) r5;
        if (Intrinsics.areEqual(this.roundId, r6.roundId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buttonConfig, r6.buttonConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rootRoundId, r6.rootRoundId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enterpriseQAGeneralInfo, r6.enterpriseQAGeneralInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Long r0 = this.roundId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        AIButtonConfig r4 = this.buttonConfig;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.rootRoundId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        EnterpriseQAGeneralInfo r10 = this.enterpriseQAGeneralInfo;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AIInfo(roundId=" + this.roundId + ", buttonConfig=" + this.buttonConfig + ", rootRoundId=" + this.rootRoundId + ", enterpriseQAGeneralInfo=" + this.enterpriseQAGeneralInfo + ')';
    }

    public final AIButtonConfig getButtonConfig() {
        return this.buttonConfig;
    }

    public final EnterpriseQAGeneralInfo getEnterpriseQAGeneralInfo() {
        return this.enterpriseQAGeneralInfo;
    }

    public final Long getRootRoundId() {
        return this.rootRoundId;
    }

    public final Long getRoundId() {
        return this.roundId;
    }

    public AIInfo(Long r1, AIButtonConfig r2, Long r3, EnterpriseQAGeneralInfo r4) {
        this.roundId = r1;
        this.buttonConfig = r2;
        this.rootRoundId = r3;
        this.enterpriseQAGeneralInfo = r4;
    }
}
