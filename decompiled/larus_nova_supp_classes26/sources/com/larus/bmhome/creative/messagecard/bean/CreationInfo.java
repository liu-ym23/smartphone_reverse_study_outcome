package com.larus.bmhome.creative.messagecard.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001b\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016JZ\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/creative/messagecard/bean/CreationInfo;", "Ljava/io/Serializable;", "layoutType", "", "taskGroupId", "", "taskInfo", "", "Lcom/larus/bmhome/creative/messagecard/bean/CreationTask;", "supportVersion", "needRefreshCreationContent", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;)V", "Ljava/lang/Integer;", "Ljava/lang/Boolean;", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "()Ljava/lang/Boolean;", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/creative/messagecard/bean/CreationInfo;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationInfo implements Serializable {

    @SerializedName("layout_type")
    public final Integer layoutType;

    @SerializedName("need_refresh_creation_content")
    public final Boolean needRefreshCreationContent;

    @SerializedName("support_version")
    public final String supportVersion;

    @SerializedName("task_group_id")
    public final String taskGroupId;

    @SerializedName("task_info")
    public final Map<String, CreationTask> taskInfo;

    public CreationInfo() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CreationInfo copy$default(CreationInfo r3, Integer r4, String r5, Map r6, String r7, Boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.layoutType;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.taskGroupId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.taskInfo;
    L11:
        Map r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.supportVersion;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.needRefreshCreationContent;
    L17:
        Integer r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final Integer component1() {
        return this.layoutType;
    }

    public final String component2() {
        return this.taskGroupId;
    }

    public final Map<String, CreationTask> component3() {
        return this.taskInfo;
    }

    public final String component4() {
        return this.supportVersion;
    }

    public final Boolean component5() {
        return this.needRefreshCreationContent;
    }

    public final CreationInfo copy(@CreationMsgLayoutType Integer r8, String r9, Map<String, CreationTask> r10, String r11, Boolean r12) {
        return new CreationInfo(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationInfo) == true) goto L8;
        return false;
    L8:
        CreationInfo r6 = (CreationInfo) r5;
        if (Intrinsics.areEqual(this.layoutType, r6.layoutType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskGroupId, r6.taskGroupId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskInfo, r6.taskInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.supportVersion, r6.supportVersion) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.needRefreshCreationContent, r6.needRefreshCreationContent) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.layoutType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.taskGroupId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, CreationTask> r7 = this.taskInfo;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.supportVersion;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.needRefreshCreationContent;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "CreationInfo(layoutType=" + this.layoutType + ", taskGroupId=" + this.taskGroupId + ", taskInfo=" + this.taskInfo + ", supportVersion=" + this.supportVersion + ", needRefreshCreationContent=" + this.needRefreshCreationContent + ')';
    }

    public CreationInfo(@CreationMsgLayoutType Integer r1, String r2, Map<String, CreationTask> r3, String r4, Boolean r5) {
        this.layoutType = r1;
        this.taskGroupId = r2;
        this.taskInfo = r3;
        this.supportVersion = r4;
        this.needRefreshCreationContent = r5;
    }

    public /* synthetic */ CreationInfo(Integer r4, String r5, Map r6, String r7, Boolean r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L5;
        r4 = -1;
    L5:
        Boolean r0 = null;
        if ((r9 & 2) == 0) goto L8;
        String r11 = null;
    L10:
        if ((r9 & 4) == 0) goto L12;
        Map r1 = null;
    L14:
        if ((r9 & 8) == 0) goto L16;
        String r2 = null;
    L18:
        if ((r9 & 16) != 0) goto L21;
        r0 = r8;
    L21:
        this(r4, r11, r1, r2, r0);
        return;
    L16:
        r2 = r7;
        goto L18
    L12:
        r1 = r6;
        goto L14
    L8:
        r11 = r5;
        goto L10
    }
}
