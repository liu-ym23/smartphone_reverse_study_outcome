package q38;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jk\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011¨\u0006("}, d2 = {"Lcom/larus/account/base/model/StatusInfo;", "", "canFastCancel", "", "cancelApplyTime", "", "cancelCoolTime", "cancelBufferTime", "isCanceling", "lastOpTime", "unusableMobileLevel", "", "deathState", "isLocked", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IZZ)V", "getCanFastCancel", "()Z", "getCancelApplyTime", "()Ljava/lang/String;", "getCancelCoolTime", "getCancelBufferTime", "getLastOpTime", "getUnusableMobileLevel", "()I", "getDeathState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class n {

    @SerializedName("can_fast_cancel")
    private final boolean canFastCancel;

    @SerializedName("cancel_apply_time")
    private final String cancelApplyTime;

    @SerializedName("cancel_buffer_time")
    private final String cancelBufferTime;

    @SerializedName("cancel_cool_time")
    private final String cancelCoolTime;

    @SerializedName("death_state")
    private final boolean deathState;

    @SerializedName("is_canceling")
    private final boolean isCanceling;

    @SerializedName("is_locked")
    private final boolean isLocked;

    @SerializedName("last_op_time")
    private final String lastOpTime;

    @SerializedName("unusable_mobile_level")
    private final int unusableMobileLevel;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (this.canFastCancel == r6.canFastCancel) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cancelApplyTime, r6.cancelApplyTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cancelCoolTime, r6.cancelCoolTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cancelBufferTime, r6.cancelBufferTime) == true) goto L21;
        return false;
    L21:
        if (this.isCanceling == r6.isCanceling) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.lastOpTime, r6.lastOpTime) == true) goto L27;
        return false;
    L27:
        if (this.unusableMobileLevel == r6.unusableMobileLevel) goto L30;
        return false;
    L30:
        if (this.deathState == r6.deathState) goto L33;
        return false;
    L33:
        if (this.isLocked == r6.isLocked) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.canFastCancel == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        String r3 = this.cancelApplyTime;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.cancelCoolTime;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.cancelBufferTime;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        if (this.isCanceling == false) goto L21;
        int r13 = 1231;
    L22:
        int r14 = (r12 + r13) * 31;
        String r15 = this.lastOpTime;
        if (r15 == null) goto L26;
        r4 = r15.hashCode();
    L26:
        int r16 = (((r14 + r4) * 31) + this.unusableMobileLevel) * 31;
        if (this.deathState == false) goto L29;
        int r17 = 1231;
    L30:
        int r19 = (r16 + r17) * 31;
        if (this.isLocked == true) goto L35;
        r1 = 1237;
    L35:
        return r19 + r1;
    L29:
        r17 = 1237;
        goto L30
    L21:
        r13 = 1237;
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "StatusInfo(canFastCancel=" + this.canFastCancel + ", cancelApplyTime=" + this.cancelApplyTime + ", cancelCoolTime=" + this.cancelCoolTime + ", cancelBufferTime=" + this.cancelBufferTime + ", isCanceling=" + this.isCanceling + ", lastOpTime=" + this.lastOpTime + ", unusableMobileLevel=" + this.unusableMobileLevel + ", deathState=" + this.deathState + ", isLocked=" + this.isLocked + ')';
    }

    public n() {
        this.canFastCancel = false;
        this.cancelApplyTime = null;
        this.cancelCoolTime = null;
        this.cancelBufferTime = null;
        this.isCanceling = false;
        this.lastOpTime = null;
        this.unusableMobileLevel = 0;
        this.deathState = false;
        this.isLocked = false;
    }
}
