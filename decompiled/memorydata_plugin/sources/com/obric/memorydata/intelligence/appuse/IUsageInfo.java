package com.obric.memorydata.intelligence.appuse;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/memorydata/intelligence/appuse/IUsageInfo;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "appCategory", "duration", "", "startUsageTime", "endUsageTime", "connectionType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJJI)V", "getPackageName", "()Ljava/lang/String;", "getAppCategory", "getDuration", "()J", "getStartUsageTime", "getEndUsageTime", "getConnectionType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IUsageInfo {
    private final String appCategory;
    private final int connectionType;
    private final long duration;
    private final long endUsageTime;
    private final String packageName;
    private final long startUsageTime;

    public IUsageInfo(String r2, String r3, long r4, long r6, long r8, int r10) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "appCategory");
        this.packageName = r2;
        this.appCategory = r3;
        this.duration = r4;
        this.startUsageTime = r6;
        this.endUsageTime = r8;
        this.connectionType = r10;
    }

    public static /* synthetic */ IUsageInfo copy$default(IUsageInfo r10, String r11, String r12, long r13, long r15, long r17, int r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r1 = r10.packageName;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r2 = r10.appCategory;
    L11:
        if ((r20 & 4) == 0) goto L13;
        long r3 = r10.duration;
    L15:
        if ((r20 & 8) == 0) goto L17;
        long r5 = r10.startUsageTime;
    L19:
        if ((r20 & 16) == 0) goto L21;
        long r7 = r10.endUsageTime;
    L23:
        if ((r20 & 32) == 0) goto L25;
        int r9 = r10.connectionType;
    L27:
        return r10.copy(r1, r2, r3, r5, r7, r9);
    L25:
        r9 = r19;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.appCategory;
    }

    public final long component3() {
        return this.duration;
    }

    public final long component4() {
        return this.startUsageTime;
    }

    public final long component5() {
        return this.endUsageTime;
    }

    public final int component6() {
        return this.connectionType;
    }

    public final IUsageInfo copy(String r12, String r13, long r14, long r16, long r18, int r20) {
        Intrinsics.checkNotNullParameter(r12, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r13, "appCategory");
        return new IUsageInfo(r12, r13, r14, r16, r18, r20);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, IUsageInfo.class) == true) goto L8;
        return false;
    L8:
        IUsageInfo r10 = (IUsageInfo) ZeusTransformUtils.preCheckCast(r9, IUsageInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appCategory, r10.appCategory) == true) goto L15;
        return false;
    L15:
        if (this.duration == r10.duration) goto L18;
        return false;
    L18:
        if (this.startUsageTime == r10.startUsageTime) goto L21;
        return false;
    L21:
        if (this.endUsageTime == r10.endUsageTime) goto L24;
        return false;
    L24:
        if (this.connectionType == r10.connectionType) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getAppCategory() {
        return this.appCategory;
    }

    public final int getConnectionType() {
        return this.connectionType;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getEndUsageTime() {
        return this.endUsageTime;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final long getStartUsageTime() {
        return this.startUsageTime;
    }

    public int hashCode() {
        return (((((((((this.packageName.hashCode() * 31) + this.appCategory.hashCode()) * 31) + Long.hashCode(this.duration)) * 31) + Long.hashCode(this.startUsageTime)) * 31) + Long.hashCode(this.endUsageTime)) * 31) + Integer.hashCode(this.connectionType);
    }

    public String toString() {
        return "IUsageInfo(packageName=" + this.packageName + ", appCategory=" + this.appCategory + ", duration=" + this.duration + ", startUsageTime=" + this.startUsageTime + ", endUsageTime=" + this.endUsageTime + ", connectionType=" + this.connectionType + ')';
    }
}
