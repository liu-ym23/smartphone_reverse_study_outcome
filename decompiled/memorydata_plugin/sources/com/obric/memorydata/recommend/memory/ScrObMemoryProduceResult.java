package com.obric.memorydata.recommend.memory;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/recommend/memory/ScrObMemoryProduceResult;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "memoryList", "", "Lcom/obric/memorydata/recommend/memory/ScrObMemoryEntity;", "batchSize", "", "<init>", "(ILjava/lang/String;Ljava/util/List;J)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getMemoryList", "()Ljava/util/List;", "getBatchSize", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrObMemoryProduceResult {

    @SerializedName("batch_size")
    private final long batchSize;
    private final int code;

    @SerializedName(SlardarSettingsConstants.PERF_KEY_MEMORY)
    private final List<ScrObMemoryEntity> memoryList;
    private final String msg;

    public ScrObMemoryProduceResult(int r3, String r4, List<ScrObMemoryEntity> r5, long r6) {
        List<ScrObMemoryEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        this.code = r3;
        this.msg = r4;
        this.memoryList = r7;
        this.batchSize = r6;
    }

    public /* synthetic */ ScrObMemoryProduceResult(int r7, String r8, List r9, long r10, int r12, DefaultConstructorMarker r13) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        List r3 = r11;
        if ((r12 & 8) == 0) goto L8;
        r10 = 0;
    L8:
        this(r7, r8, r3, r10);
    }

    public static /* synthetic */ ScrObMemoryProduceResult copy$default(ScrObMemoryProduceResult r6, int r7, String r8, List r9, long r10, int r12, Object r13) {
        List<ScrObMemoryEntity> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.code;
    L5:
        int r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.msg;
    L8:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r11 = r6.memoryList;
    L11:
        List<ScrObMemoryEntity> r3 = r11;
        if ((r12 & 8) == 0) goto L15;
        r10 = r6.batchSize;
    L15:
        return r6.copy(r1, r2, r3, r10);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final List<ScrObMemoryEntity> component3() {
        return this.memoryList;
    }

    public final long component4() {
        return this.batchSize;
    }

    public final ScrObMemoryProduceResult copy(int r7, String r8, List<ScrObMemoryEntity> r9, long r10) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
        return new ScrObMemoryProduceResult(r7, r8, r3, r10);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ScrObMemoryProduceResult.class) == true) goto L8;
        return false;
    L8:
        ScrObMemoryProduceResult r8 = (ScrObMemoryProduceResult) ZeusTransformUtils.preCheckCast(r7, ScrObMemoryProduceResult.class, "com.obric.memorydata.plugin");
        if (this.code == r8.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r8.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.memoryList, r8.memoryList) == true) goto L18;
        return false;
    L18:
        if (this.batchSize == r8.batchSize) goto L20;
        return false;
    L20:
        return true;
    }

    public final long getBatchSize() {
        return this.batchSize;
    }

    public final int getCode() {
        return this.code;
    }

    public final List<ScrObMemoryEntity> getMemoryList() {
        return this.memoryList;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.code) * 31) + this.msg.hashCode()) * 31;
        List<ScrObMemoryEntity> r1 = this.memoryList;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Long.hashCode(this.batchSize);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ScrObMemoryProduceResult(code=" + this.code + ", msg=" + this.msg + ", memoryList=" + this.memoryList + ", batchSize=" + this.batchSize + ')';
    }
}
