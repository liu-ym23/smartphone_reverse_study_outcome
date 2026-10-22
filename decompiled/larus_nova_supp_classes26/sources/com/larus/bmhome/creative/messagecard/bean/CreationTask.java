package com.larus.bmhome.creative.messagecard.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.CreationTaskType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B`\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000f\b\u0002\u0010\n\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0017\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u000bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rHÆ\u0003Jg\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\u000f\b\u0002\u0010\n\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\n\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u000b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "Ljava/io/Serializable;", "id", "", "status", "", "loadingInfo", "Lcom/larus/bmhome/creative/messagecard/bean/LoadingInfo;", "index", "taskType", "loadingAssetType", "Lcom/larus/bmhome/creative/messagecard/bean/CreationAssetType;", "asset", "Lcom/larus/bmhome/creative/messagecard/bean/CreationAsset;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/creative/messagecard/bean/LoadingInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/creative/messagecard/bean/CreationAsset;)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/bmhome/creative/messagecard/bean/LoadingInfo;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/larus/bmhome/creative/messagecard/bean/CreationAsset;)Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationTask implements Serializable {

    @SerializedName("asset")
    public final CreationAsset asset;

    @SerializedName("id")
    public final String id;

    @SerializedName("index")
    public final Integer index;

    @SerializedName("asset_type")
    public final Integer loadingAssetType;

    @SerializedName("loading_info")
    public final LoadingInfo loadingInfo;

    @SerializedName("status")
    public final Integer status;

    @SerializedName("task_type")
    public final Integer taskType;

    public CreationTask() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ CreationTask copy$default(CreationTask r5, String r6, Integer r7, LoadingInfo r8, Integer r9, Integer r10, Integer r11, CreationAsset r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.id;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.status;
    L8:
        Integer r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.loadingInfo;
    L11:
        LoadingInfo r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.index;
    L14:
        Integer r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.taskType;
    L17:
        Integer r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.loadingAssetType;
    L20:
        Integer r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.asset;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.id;
    }

    public final Integer component2() {
        return this.status;
    }

    public final LoadingInfo component3() {
        return this.loadingInfo;
    }

    public final Integer component4() {
        return this.index;
    }

    public final Integer component5() {
        return this.taskType;
    }

    public final Integer component6() {
        return this.loadingAssetType;
    }

    public final CreationAsset component7() {
        return this.asset;
    }

    public final CreationTask copy(String r10, @CreationTaskStatus Integer r11, LoadingInfo r12, Integer r13, @CreationTaskType Integer r14, Integer r15, CreationAsset r16) {
        return new CreationTask(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationTask) == true) goto L8;
        return false;
    L8:
        CreationTask r6 = (CreationTask) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.loadingInfo, r6.loadingInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.index, r6.index) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.taskType, r6.taskType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.loadingAssetType, r6.loadingAssetType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.asset, r6.asset) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.status;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        LoadingInfo r7 = this.loadingInfo;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.index;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.taskType;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.loadingAssetType;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        CreationAsset r19 = this.asset;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "CreationTask(id=" + this.id + ", status=" + this.status + ", loadingInfo=" + this.loadingInfo + ", index=" + this.index + ", taskType=" + this.taskType + ", loadingAssetType=" + this.loadingAssetType + ", asset=" + this.asset + ')';
    }

    public CreationTask(String r1, @CreationTaskStatus Integer r2, LoadingInfo r3, Integer r4, @CreationTaskType Integer r5, Integer r6, CreationAsset r7) {
        this.id = r1;
        this.status = r2;
        this.loadingInfo = r3;
        this.index = r4;
        this.taskType = r5;
        this.loadingAssetType = r6;
        this.asset = r7;
    }

    public /* synthetic */ CreationTask(String r7, Integer r8, LoadingInfo r9, Integer r10, Integer r11, Integer r12, CreationAsset r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        String r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        Integer r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        LoadingInfo r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        Integer r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        Integer r4 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        Integer r5 = null;
    L27:
        if ((r14 & 64) == 0) goto L29;
        CreationAsset r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L25:
        r5 = r12;
        goto L27
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r10;
        goto L19
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
