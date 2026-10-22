package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class LeanModeInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<LeanModeInfo> CREATOR = null;

    @JSONField(name = "all_devices_in_lean_mode")
    public boolean allDevicesInLeanMode;

    @JSONField(name = "can_use_lean_mode")
    public boolean canUseLeanMode;

    @JSONField(name = "device_have_authority")
    public boolean deviceHaveAuthority;

    @JSONField(name = "is_lock_screen_enabled")
    public boolean isLockScreenEnabled;

    @JSONField(name = "lean_mode_cfg_update_time")
    public long leanModeCfgUpdateTime;

    @JSONField(name = "lock_screen_cfg_update_time")
    public long lockScreenCfgUpdateTime;

    @JSONField(name = "lock_screen_pwd")
    public String lockScreenPwd;

    public class a implements Parcelable.Creator<LeanModeInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LeanModeInfo createFromParcel(Parcel r2) {
            return new LeanModeInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final LeanModeInfo[] newArray(int r1) {
            return new LeanModeInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "LeanModeInfo{deviceHaveAuthority=" + this.deviceHaveAuthority + ", isLockScreenEnabled=" + this.isLockScreenEnabled + ", allDevicesInLeanMode=" + this.allDevicesInLeanMode + ", canUseLeanMode=" + this.canUseLeanMode + ", lockScreenCfgUpdateTime=" + this.lockScreenCfgUpdateTime + ", leanModeCfgUpdateTime=" + this.leanModeCfgUpdateTime + '}';
    }

    public LeanModeInfo() {
    }

    public LeanModeInfo(Parcel r4) {
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.deviceHaveAuthority = r0;
        if (r4.readByte() == 0) goto L9;
        boolean r2 = true;
    L10:
        this.isLockScreenEnabled = r2;
        this.lockScreenPwd = r4.readString();
        if (r4.readByte() == 0) goto L13;
        boolean r3 = true;
    L14:
        this.allDevicesInLeanMode = r3;
        if (r4.readByte() != 0) goto L18;
        r1 = false;
    L18:
        this.canUseLeanMode = r1;
        this.lockScreenCfgUpdateTime = r4.readLong();
        this.leanModeCfgUpdateTime = r4.readLong();
        return;
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeByte(this.deviceHaveAuthority ? 1 : 0);
        r3.writeByte(this.isLockScreenEnabled ? 1 : 0);
        r3.writeString(this.lockScreenPwd);
        r3.writeByte(this.allDevicesInLeanMode ? 1 : 0);
        r3.writeByte(this.canUseLeanMode ? 1 : 0);
        r3.writeLong(this.lockScreenCfgUpdateTime);
        r3.writeLong(this.leanModeCfgUpdateTime);
    }
}
