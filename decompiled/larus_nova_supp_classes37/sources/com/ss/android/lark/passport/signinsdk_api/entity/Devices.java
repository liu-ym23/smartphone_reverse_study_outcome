package com.ss.android.lark.passport.signinsdk_api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class Devices implements Serializable {

    @JSONField(name = "device")
    private List<Device> sessions;

    public static final class DeleteDevice implements Serializable {
        private boolean success;

        public DeleteDevice() {
        }

        public boolean isSuccess() {
            return this.success;
        }

        public void setSuccess(boolean r1) {
            this.success = r1;
        }
    }

    public static final class Device implements Serializable {

        @JSONField(name = "device_id")
        private String deviceId;

        @JSONField(name = "device_model")
        private String deviceModel;

        @JSONField(name = "device_name")
        private String deviceName;

        @JSONField(name = "device_os")
        private String deviceOs;

        @JSONField(name = "is_abnormal")
        private boolean isAbnormal;

        @JSONField(name = "is_current")
        private boolean isCurrentDevice;

        @JSONField(name = "is_online")
        private boolean isOnline;

        @JSONField(name = "login_time")
        private long loginTime;

        @JSONField(name = "tenant_name")
        public String tenantName;

        @JSONField(name = "terminal_type")
        private int terminalType;

        public Device() {
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public String getDeviceModel() {
            return this.deviceModel;
        }

        public String getDeviceName() {
            return this.deviceName;
        }

        public String getDeviceOs() {
            return this.deviceOs;
        }

        public boolean getIsAbnormal() {
            return this.isAbnormal;
        }

        public boolean getIsCurrentDevice() {
            return this.isCurrentDevice;
        }

        public boolean getIsOnline() {
            return this.isOnline;
        }

        public long getLoginTime() {
            return this.loginTime;
        }

        public int getTerminalType() {
            return this.terminalType;
        }

        public void setDeviceId(String r1) {
            this.deviceId = r1;
        }

        public void setDeviceModel(String r1) {
            this.deviceModel = r1;
        }

        public void setDeviceName(String r1) {
            this.deviceName = r1;
        }

        public void setDeviceOs(String r1) {
            this.deviceOs = r1;
        }

        public void setIsAbnormal(boolean r1) {
            this.isAbnormal = r1;
        }

        public void setIsCurrentDevice(boolean r1) {
            this.isCurrentDevice = r1;
        }

        public void setIsOnline(boolean r1) {
            this.isOnline = r1;
        }

        public void setLoginTime(long r1) {
            this.loginTime = r1;
        }

        public void setTerminalType(int r1) {
            this.terminalType = r1;
        }
    }

    public Devices() {
    }

    public List<Device> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<Device> r1) {
        this.sessions = r1;
    }
}
