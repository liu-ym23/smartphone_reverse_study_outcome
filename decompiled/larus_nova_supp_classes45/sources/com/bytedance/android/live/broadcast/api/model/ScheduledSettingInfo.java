package com.bytedance.android.live.broadcast.api.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u001e\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00013BQ\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\t\u0010\n\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003JS\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R$\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)¨\u00064"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/ScheduledSettingInfo;", "Ljava/io/Serializable;", "", "component1", "component2", "", "component3", "", "component4", "component5", "component6", "component7", "masterSwitch", "profileSwitch", "pushSwitch", "anchorScheduledTime", "anchorScheduledDays", "noticeSwitchDisplay", "scheduledTimeWords", "copy", "toString", "hashCode", "", "other", "equals", "Z", "getMasterSwitch", "()Z", "setMasterSwitch", "(Z)V", "getProfileSwitch", "setProfileSwitch", "I", "getPushSwitch", "()I", "setPushSwitch", "(I)V", "Ljava/lang/String;", "getAnchorScheduledTime", "()Ljava/lang/String;", "setAnchorScheduledTime", "(Ljava/lang/String;)V", "getAnchorScheduledDays", "setAnchorScheduledDays", "getNoticeSwitchDisplay", "setNoticeSwitchDisplay", "getScheduledTimeWords", "setScheduledTimeWords", "<init>", "(ZZILjava/lang/String;IILjava/lang/String;)V", "Companion", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScheduledSettingInfo implements Serializable {
    public static final a Companion = null;

    @SerializedName("scheduled_days")
    private int anchorScheduledDays;

    @SerializedName("scheduled_time")
    private String anchorScheduledTime;

    @SerializedName("scheduled_master_switch")
    private boolean masterSwitch;

    @SerializedName("scheduled_notice_switch_display")
    private int noticeSwitchDisplay;

    @SerializedName("scheduled_profile_switch")
    private boolean profileSwitch;

    @SerializedName("scheduled_notice_switch")
    private int pushSwitch;

    @SerializedName("scheduled_time_text")
    private String scheduledTimeWords;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ScheduledSettingInfo() {
        this(false, false, 0, null, 0, 0, null, 127, null);
    }

    public static /* synthetic */ ScheduledSettingInfo copy$default(ScheduledSettingInfo r5, boolean r6, boolean r7, int r8, String r9, int r11, int r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r6 = r5.masterSwitch;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r7 = r5.profileSwitch;
    L8:
        boolean r16 = r7;
        if ((r14 & 4) == 0) goto L11;
        r8 = r5.pushSwitch;
    L11:
        int r0 = r8;
        if ((r14 & 8) == 0) goto L14;
        r9 = r5.anchorScheduledTime;
    L14:
        String r1 = r9;
        if ((r14 & 16) == 0) goto L17;
        r11 = r5.anchorScheduledDays;
    L17:
        int r2 = r11;
        if ((r14 & 32) == 0) goto L20;
        r12 = r5.noticeSwitchDisplay;
    L20:
        int r3 = r12;
        if ((r14 & 64) == 0) goto L23;
        r13 = r5.scheduledTimeWords;
    L23:
        boolean r17 = r6;
        return r5.copy(r17, r16, r0, r1, r2, r3, r13);
    }

    public final boolean component1() {
        return this.masterSwitch;
    }

    public final boolean component2() {
        return this.profileSwitch;
    }

    public final int component3() {
        return this.pushSwitch;
    }

    public final String component4() {
        return this.anchorScheduledTime;
    }

    public final int component5() {
        return this.anchorScheduledDays;
    }

    public final int component6() {
        return this.noticeSwitchDisplay;
    }

    public final String component7() {
        return this.scheduledTimeWords;
    }

    public final ScheduledSettingInfo copy(boolean r11, boolean r12, int r13, String r14, int r15, int r16, String r17) {
        return new ScheduledSettingInfo(r11, r12, r13, r14, r15, r16, r17);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ScheduledSettingInfo) == false) goto L20;
        ScheduledSettingInfo r4 = (ScheduledSettingInfo) r3;
        if (this.masterSwitch == r4.masterSwitch) goto L8;
        return false;
    L8:
        if (this.profileSwitch == r4.profileSwitch) goto L10;
        return false;
    L10:
        if (this.pushSwitch == r4.pushSwitch) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.anchorScheduledTime, r4.anchorScheduledTime) == true) goto L14;
        return false;
    L14:
        if (this.anchorScheduledDays == r4.anchorScheduledDays) goto L16;
        return false;
    L16:
        if (this.noticeSwitchDisplay == r4.noticeSwitchDisplay) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scheduledTimeWords, r4.scheduledTimeWords) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    public int hashCode() {
        boolean r0 = this.masterSwitch;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.profileSwitch;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (((r3 + r1) * 31) + this.pushSwitch) * 31;
        String r6 = this.anchorScheduledTime;
        int r7 = 0;
        if (r6 == null) goto L12;
        int r8 = r6.hashCode();
    L13:
        int r9 = (((((r5 + r8) * 31) + this.anchorScheduledDays) * 31) + this.noticeSwitchDisplay) * 31;
        String r11 = this.scheduledTimeWords;
        if (r11 == null) goto L17;
        r7 = r11.hashCode();
    L17:
        return r9 + r7;
    L12:
        r8 = 0;
        goto L13
    }

    public String toString() {
        return "ScheduledSettingInfo(masterSwitch=" + this.masterSwitch + ", profileSwitch=" + this.profileSwitch + ", pushSwitch=" + this.pushSwitch + ", anchorScheduledTime=" + this.anchorScheduledTime + ", anchorScheduledDays=" + this.anchorScheduledDays + ", noticeSwitchDisplay=" + this.noticeSwitchDisplay + ", scheduledTimeWords=" + this.scheduledTimeWords + ")";
    }

    public final int getAnchorScheduledDays() {
        return this.anchorScheduledDays;
    }

    public final String getAnchorScheduledTime() {
        return this.anchorScheduledTime;
    }

    public final boolean getMasterSwitch() {
        return this.masterSwitch;
    }

    public final int getNoticeSwitchDisplay() {
        return this.noticeSwitchDisplay;
    }

    public final boolean getProfileSwitch() {
        return this.profileSwitch;
    }

    public final int getPushSwitch() {
        return this.pushSwitch;
    }

    public final String getScheduledTimeWords() {
        return this.scheduledTimeWords;
    }

    @JvmStatic
    public static final ScheduledSettingInfo from(ScheduledSettingInfo r11) {
        Companion.getClass();
        ScheduledSettingInfo r0 = new ScheduledSettingInfo(false, false, 0, null, 0, 0, null, 127, null);
        if (r11 == null) goto L5;
        r0.setMasterSwitch(r11.getMasterSwitch());
        r0.setProfileSwitch(r11.getProfileSwitch());
        r0.setPushSwitch(r11.getPushSwitch());
        r0.setAnchorScheduledTime(r11.getAnchorScheduledTime());
        r0.setAnchorScheduledDays(r11.getAnchorScheduledDays());
        r0.setScheduledTimeWords(r11.getScheduledTimeWords());
        r0.setNoticeSwitchDisplay(r11.getNoticeSwitchDisplay());
    L5:
        return r0;
    }

    public final void setAnchorScheduledDays(int r1) {
        this.anchorScheduledDays = r1;
    }

    public final void setAnchorScheduledTime(String r1) {
        this.anchorScheduledTime = r1;
    }

    public final void setMasterSwitch(boolean r1) {
        this.masterSwitch = r1;
    }

    public final void setNoticeSwitchDisplay(int r1) {
        this.noticeSwitchDisplay = r1;
    }

    public final void setProfileSwitch(boolean r1) {
        this.profileSwitch = r1;
    }

    public final void setPushSwitch(int r1) {
        this.pushSwitch = r1;
    }

    public final void setScheduledTimeWords(String r1) {
        this.scheduledTimeWords = r1;
    }

    public ScheduledSettingInfo(boolean r1, boolean r2, int r3, String r4, int r5, int r6, String r7) {
        this.masterSwitch = r1;
        this.profileSwitch = r2;
        this.pushSwitch = r3;
        this.anchorScheduledTime = r4;
        this.anchorScheduledDays = r5;
        this.noticeSwitchDisplay = r6;
        this.scheduledTimeWords = r7;
    }

    public /* synthetic */ ScheduledSettingInfo(boolean r6, boolean r7, int r8, String r9, int r11, int r12, String r13, int r14, DefaultConstructorMarker r15) {
        int r0 = 0;
        if ((r14 & 1) == 0) goto L5;
        boolean r16 = false;
    L7:
        if ((r14 & 2) == 0) goto L9;
        boolean r1 = false;
    L11:
        if ((r14 & 4) == 0) goto L13;
        int r2 = 0;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r3 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        int r4 = 0;
    L23:
        if ((r14 & 32) != 0) goto L27;
        r0 = r12;
    L27:
        if ((r14 & 64) == 0) goto L29;
        String r17 = null;
    L30:
        this(r16, r1, r2, r3, r4, r0, r17);
        return;
    L29:
        r17 = r13;
        goto L30
    L21:
        r4 = r11;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r16 = r6;
        goto L7
    }
}
