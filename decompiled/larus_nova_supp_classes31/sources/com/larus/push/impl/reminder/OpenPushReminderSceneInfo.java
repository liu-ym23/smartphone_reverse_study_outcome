package com.larus.push.impl.reminder;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003JV\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0004\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/larus/push/impl/reminder/OpenPushReminderSceneInfo;", "", "sceneId", "", "isOpen", "", "eventTimes", "", "title", "subTitle", "bubbleInfo", "Lcom/larus/push/impl/reminder/BubbleInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/push/impl/reminder/BubbleInfo;)V", "getSceneId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEventTimes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getSubTitle", "getBubbleInfo", "()Lcom/larus/push/impl/reminder/BubbleInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/larus/push/impl/reminder/BubbleInfo;)Lcom/larus/push/impl/reminder/OpenPushReminderSceneInfo;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class OpenPushReminderSceneInfo {

    @SerializedName("bubble_info")
    private final BubbleInfo bubbleInfo;

    @SerializedName("event_times")
    private final Integer eventTimes;

    @SerializedName("is_open")
    private final Boolean isOpen;

    @SerializedName("scene_id")
    private final String sceneId;

    @SerializedName("sub_title")
    private final String subTitle;

    @SerializedName("title")
    private final String title;

    public OpenPushReminderSceneInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ OpenPushReminderSceneInfo copy$default(OpenPushReminderSceneInfo r4, String r5, Boolean r6, Integer r7, String r8, String r9, BubbleInfo r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.sceneId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.isOpen;
    L8:
        Boolean r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.eventTimes;
    L11:
        Integer r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.title;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.subTitle;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.bubbleInfo;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.sceneId;
    }

    public final Boolean component2() {
        return this.isOpen;
    }

    public final Integer component3() {
        return this.eventTimes;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.subTitle;
    }

    public final BubbleInfo component6() {
        return this.bubbleInfo;
    }

    public final OpenPushReminderSceneInfo copy(String r9, Boolean r10, Integer r11, String r12, String r13, BubbleInfo r14) {
        return new OpenPushReminderSceneInfo(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OpenPushReminderSceneInfo) == true) goto L8;
        return false;
    L8:
        OpenPushReminderSceneInfo r6 = (OpenPushReminderSceneInfo) r5;
        if (Intrinsics.areEqual(this.sceneId, r6.sceneId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isOpen, r6.isOpen) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.eventTimes, r6.eventTimes) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subTitle, r6.subTitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bubbleInfo, r6.bubbleInfo) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.sceneId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isOpen;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.eventTimes;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.title;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.subTitle;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        BubbleInfo r16 = this.bubbleInfo;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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
        return "OpenPushReminderSceneInfo(sceneId=" + this.sceneId + ", isOpen=" + this.isOpen + ", eventTimes=" + this.eventTimes + ", title=" + this.title + ", subTitle=" + this.subTitle + ", bubbleInfo=" + this.bubbleInfo + ')';
    }

    public final BubbleInfo getBubbleInfo() {
        return this.bubbleInfo;
    }

    public final Integer getEventTimes() {
        return this.eventTimes;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Boolean isOpen() {
        return this.isOpen;
    }

    public OpenPushReminderSceneInfo(String r1, Boolean r2, Integer r3, String r4, String r5, BubbleInfo r6) {
        this.sceneId = r1;
        this.isOpen = r2;
        this.eventTimes = r3;
        this.title = r4;
        this.subTitle = r5;
        this.bubbleInfo = r6;
    }

    public /* synthetic */ OpenPushReminderSceneInfo(String r6, Boolean r7, Integer r8, String r9, String r10, BubbleInfo r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        r7 = Boolean.FALSE;
    L9:
        Boolean r1 = r7;
        if ((r12 & 4) == 0) goto L12;
        r8 = 1;
    L12:
        Integer r2 = r8;
        if ((r12 & 8) == 0) goto L15;
        String r3 = null;
    L17:
        if ((r12 & 16) == 0) goto L19;
        String r4 = null;
    L21:
        if ((r12 & 32) == 0) goto L23;
        BubbleInfo r15 = null;
    L24:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L23:
        r15 = r11;
        goto L24
    L19:
        r4 = r10;
        goto L21
    L15:
        r3 = r9;
        goto L17
    L5:
        r14 = r6;
        goto L7
    }
}
