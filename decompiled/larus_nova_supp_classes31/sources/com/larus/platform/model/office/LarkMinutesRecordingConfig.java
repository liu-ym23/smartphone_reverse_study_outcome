package com.larus.platform.model.office;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/office/LarkMinutesRecordingConfig;", "", "startRecordingTimeoutInSec", "", "moaStartRecordingTimeoutInSec", "enableOfficeSdkLoginOpt", "", "<init>", "(JJZ)V", "getStartRecordingTimeoutInSec", "()J", "getMoaStartRecordingTimeoutInSec", "getEnableOfficeSdkLoginOpt", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LarkMinutesRecordingConfig {

    @SerializedName("enable_office_sdk_login_opt")
    private final boolean enableOfficeSdkLoginOpt;

    @SerializedName("moa_start_recording_timeout_in_sec")
    private final long moaStartRecordingTimeoutInSec;

    @SerializedName("start_recording_timeout_in_sec")
    private final long startRecordingTimeoutInSec;

    public LarkMinutesRecordingConfig() {
        this(0, 0, false, 7, null);
    }

    public static /* synthetic */ LarkMinutesRecordingConfig copy$default(LarkMinutesRecordingConfig r6, long r7, long r9, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.startRecordingTimeoutInSec;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.moaStartRecordingTimeoutInSec;
    L8:
        long r3 = r9;
        if ((r12 & 4) == 0) goto L12;
        r11 = r6.enableOfficeSdkLoginOpt;
    L12:
        return r6.copy(r1, r3, r11);
    }

    public final long component1() {
        return this.startRecordingTimeoutInSec;
    }

    public final long component2() {
        return this.moaStartRecordingTimeoutInSec;
    }

    public final boolean component3() {
        return this.enableOfficeSdkLoginOpt;
    }

    public final LarkMinutesRecordingConfig copy(long r8, long r10, boolean r12) {
        return new LarkMinutesRecordingConfig(r8, r10, r12);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LarkMinutesRecordingConfig) == true) goto L8;
        return false;
    L8:
        LarkMinutesRecordingConfig r9 = (LarkMinutesRecordingConfig) r8;
        if (this.startRecordingTimeoutInSec == r9.startRecordingTimeoutInSec) goto L12;
        return false;
    L12:
        if (this.moaStartRecordingTimeoutInSec == r9.moaStartRecordingTimeoutInSec) goto L15;
        return false;
    L15:
        if (this.enableOfficeSdkLoginOpt == r9.enableOfficeSdkLoginOpt) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r0 = this.startRecordingTimeoutInSec;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.moaStartRecordingTimeoutInSec;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.enableOfficeSdkLoginOpt == false) goto L5;
        int r4 = 1231;
    L7:
        return r2 + r4;
    L5:
        r4 = 1237;
        goto L7
    }

    public String toString() {
        return "LarkMinutesRecordingConfig(startRecordingTimeoutInSec=" + this.startRecordingTimeoutInSec + ", moaStartRecordingTimeoutInSec=" + this.moaStartRecordingTimeoutInSec + ", enableOfficeSdkLoginOpt=" + this.enableOfficeSdkLoginOpt + ')';
    }

    public final boolean getEnableOfficeSdkLoginOpt() {
        return this.enableOfficeSdkLoginOpt;
    }

    public final long getMoaStartRecordingTimeoutInSec() {
        return this.moaStartRecordingTimeoutInSec;
    }

    public final long getStartRecordingTimeoutInSec() {
        return this.startRecordingTimeoutInSec;
    }

    public LarkMinutesRecordingConfig(long r1, long r3, boolean r5) {
        this.startRecordingTimeoutInSec = r1;
        this.moaStartRecordingTimeoutInSec = r3;
        this.enableOfficeSdkLoginOpt = r5;
    }

    public /* synthetic */ LarkMinutesRecordingConfig(long r7, long r9, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = 30;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = 180;
    L8:
        long r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        boolean r5 = true;
    L12:
        this(r1, r3, r5);
        return;
    L11:
        r5 = r11;
        goto L12
    }
}
