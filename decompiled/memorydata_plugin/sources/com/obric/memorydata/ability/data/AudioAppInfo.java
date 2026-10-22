package com.obric.memorydata.ability.data;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0018JL\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\bHÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/obric/memorydata/ability/data/AudioAppInfo;", "", "active", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "audioType", "outputType", "", "beginTime", "", "endTime", "<init>", "(ZLjava/lang/String;Ljava/lang/String;IJLjava/lang/Long;)V", "getActive", "()Z", "getPackageName", "()Ljava/lang/String;", "getAudioType", "getOutputType", "()I", "getBeginTime", "()J", "getEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/String;Ljava/lang/String;IJLjava/lang/Long;)Lcom/obric/memorydata/ability/data/AudioAppInfo;", "equals", "other", "hashCode", "toString", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AudioAppInfo {
    private final boolean active;
    private final String audioType;
    private final long beginTime;
    private final Long endTime;
    private final int outputType;
    private final String packageName;

    public AudioAppInfo(boolean r2, String r3, String r4, int r5, long r6, Long r8) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r4, "audioType");
        this.active = r2;
        this.packageName = r3;
        this.audioType = r4;
        this.outputType = r5;
        this.beginTime = r6;
        this.endTime = r8;
    }

    public /* synthetic */ AudioAppInfo(boolean r10, String r11, String r12, int r13, long r14, Long r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 32) == 0) goto L5;
        Long r8 = null;
    L6:
        this(r10, r11, r12, r13, r14, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public static /* synthetic */ AudioAppInfo copy$default(AudioAppInfo r5, boolean r6, String r7, String r8, int r9, long r10, Long r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.active;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.packageName;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.audioType;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.outputType;
    L14:
        int r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.beginTime;
    L17:
        long r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r12 = r5.endTime;
    L20:
        boolean r11 = r6;
        return r5.copy(r11, r15, r0, r1, r2, r12);
    }

    public final boolean component1() {
        return this.active;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.audioType;
    }

    public final int component4() {
        return this.outputType;
    }

    public final long component5() {
        return this.beginTime;
    }

    public final Long component6() {
        return this.endTime;
    }

    public final AudioAppInfo copy(boolean r9, String r10, String r11, int r12, long r13, Long r15) {
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r11, "audioType");
        return new AudioAppInfo(r9, r10, r11, r12, r13, r15);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AudioAppInfo.class) == true) goto L8;
        return false;
    L8:
        AudioAppInfo r10 = (AudioAppInfo) ZeusTransformUtils.preCheckCast(r9, AudioAppInfo.class, "com.obric.memorydata.plugin");
        if (this.active == r10.active) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.audioType, r10.audioType) == true) goto L18;
        return false;
    L18:
        if (this.outputType == r10.outputType) goto L21;
        return false;
    L21:
        if (this.beginTime == r10.beginTime) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.endTime, r10.endTime) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final boolean getActive() {
        return this.active;
    }

    public final String getAudioType() {
        return this.audioType;
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final int getOutputType() {
        return this.outputType;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        int r0 = ((((((((Boolean.hashCode(this.active) * 31) + this.packageName.hashCode()) * 31) + this.audioType.hashCode()) * 31) + Integer.hashCode(this.outputType)) * 31) + Long.hashCode(this.beginTime)) * 31;
        Long r3 = this.endTime;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "AudioAppInfo(active=" + this.active + ", packageName=" + this.packageName + ", audioType=" + this.audioType + ", outputType=" + this.outputType + ", beginTime=" + this.beginTime + ", endTime=" + this.endTime + ')';
    }
}
