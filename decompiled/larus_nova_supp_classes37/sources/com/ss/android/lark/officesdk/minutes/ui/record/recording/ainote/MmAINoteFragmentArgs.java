package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001c¨\u0006+"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/ainote/MmAINoteFragmentArgs;", "Ljava/io/Serializable;", "ownerKey", "", "meetingId", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "minHeight", "", "initialDuration", "", "meetingStartTime", "expandImmediately", "", "isWavePlaying", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;IJJZZ)V", "getOwnerKey", "()Ljava/lang/String;", "getMeetingId", "getUiLaunchMode", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "getMinHeight", "()I", "getInitialDuration", "()J", "getMeetingStartTime", "getExpandImmediately", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmAINoteFragmentArgs implements Serializable {
    private final boolean expandImmediately;
    private final long initialDuration;
    private final boolean isWavePlaying;
    private final String meetingId;
    private final long meetingStartTime;
    private final int minHeight;
    private final String ownerKey;
    private final MmRecordingUILaunchMode uiLaunchMode;

    public static /* synthetic */ MmAINoteFragmentArgs copy$default(MmAINoteFragmentArgs r11, String r12, String r13, MmRecordingUILaunchMode r14, int r15, long r16, long r18, boolean r20, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.ownerKey;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.meetingId;
    L11:
        if ((r22 & 4) == 0) goto L13;
        MmRecordingUILaunchMode r4 = r11.uiLaunchMode;
    L15:
        if ((r22 & 8) == 0) goto L17;
        int r5 = r11.minHeight;
    L19:
        if ((r22 & 16) == 0) goto L21;
        long r6 = r11.initialDuration;
    L23:
        if ((r22 & 32) == 0) goto L25;
        long r8 = r11.meetingStartTime;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r10 = r11.expandImmediately;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r1 = r11.isWavePlaying;
    L35:
        return r11.copy(r2, r3, r4, r5, r6, r8, r10, r1);
    L33:
        r1 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.ownerKey;
    }

    public final String component2() {
        return this.meetingId;
    }

    public final MmRecordingUILaunchMode component3() {
        return this.uiLaunchMode;
    }

    public final int component4() {
        return this.minHeight;
    }

    public final long component5() {
        return this.initialDuration;
    }

    public final long component6() {
        return this.meetingStartTime;
    }

    public final boolean component7() {
        return this.expandImmediately;
    }

    public final boolean component8() {
        return this.isWavePlaying;
    }

    public final MmAINoteFragmentArgs copy(String r13, String r14, MmRecordingUILaunchMode r15, int r16, long r17, long r19, boolean r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r13, "ownerKey");
        Intrinsics.checkNotNullParameter(r14, "meetingId");
        Intrinsics.checkNotNullParameter(r15, "uiLaunchMode");
        return new MmAINoteFragmentArgs(r13, r14, r15, r16, r17, r19, r21, r22);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MmAINoteFragmentArgs) == true) goto L8;
        return false;
    L8:
        MmAINoteFragmentArgs r9 = (MmAINoteFragmentArgs) r8;
        if (Intrinsics.areEqual(this.ownerKey, r9.ownerKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.meetingId, r9.meetingId) == true) goto L15;
        return false;
    L15:
        if (this.uiLaunchMode == r9.uiLaunchMode) goto L18;
        return false;
    L18:
        if (this.minHeight == r9.minHeight) goto L21;
        return false;
    L21:
        if (this.initialDuration == r9.initialDuration) goto L24;
        return false;
    L24:
        if (this.meetingStartTime == r9.meetingStartTime) goto L27;
        return false;
    L27:
        if (this.expandImmediately == r9.expandImmediately) goto L30;
        return false;
    L30:
        if (this.isWavePlaying == r9.isWavePlaying) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.ownerKey.hashCode() * 31) + this.meetingId.hashCode()) * 31) + this.uiLaunchMode.hashCode()) * 31) + this.minHeight) * 31;
        long r1 = this.initialDuration;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.meetingStartTime;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        int r5 = 1231;
        if (this.expandImmediately == false) goto L5;
        int r6 = 1231;
    L6:
        int r7 = (r4 + r6) * 31;
        if (this.isWavePlaying == true) goto L11;
        r5 = 1237;
    L11:
        return r7 + r5;
    L5:
        r6 = 1237;
        goto L6
    }

    public String toString() {
        return "MmAINoteFragmentArgs(ownerKey=" + this.ownerKey + ", meetingId=" + this.meetingId + ", uiLaunchMode=" + this.uiLaunchMode + ", minHeight=" + this.minHeight + ", initialDuration=" + this.initialDuration + ", meetingStartTime=" + this.meetingStartTime + ", expandImmediately=" + this.expandImmediately + ", isWavePlaying=" + this.isWavePlaying + ')';
    }

    public final boolean getExpandImmediately() {
        return this.expandImmediately;
    }

    public final long getInitialDuration() {
        return this.initialDuration;
    }

    public final String getMeetingId() {
        return this.meetingId;
    }

    public final long getMeetingStartTime() {
        return this.meetingStartTime;
    }

    public final int getMinHeight() {
        return this.minHeight;
    }

    public final String getOwnerKey() {
        return this.ownerKey;
    }

    public final MmRecordingUILaunchMode getUiLaunchMode() {
        return this.uiLaunchMode;
    }

    public final boolean isWavePlaying() {
        return this.isWavePlaying;
    }

    public MmAINoteFragmentArgs(String r2, String r3, MmRecordingUILaunchMode r4, int r5, long r6, long r8, boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "ownerKey");
        Intrinsics.checkNotNullParameter(r3, "meetingId");
        Intrinsics.checkNotNullParameter(r4, "uiLaunchMode");
        this.ownerKey = r2;
        this.meetingId = r3;
        this.uiLaunchMode = r4;
        this.minHeight = r5;
        this.initialDuration = r6;
        this.meetingStartTime = r8;
        this.expandImmediately = r10;
        this.isWavePlaying = r11;
    }

    public /* synthetic */ MmAINoteFragmentArgs(String r14, String r15, MmRecordingUILaunchMode r16, int r17, long r18, long r20, boolean r22, boolean r23, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 64) == 0) goto L5;
        boolean r11 = false;
    L7:
        if ((r24 & 128) == 0) goto L9;
        boolean r12 = true;
    L10:
        this(r14, r15, r16, r17, r18, r20, r11, r12);
        return;
    L9:
        r12 = r23;
        goto L10
    L5:
        r11 = r22;
        goto L7
    }
}
