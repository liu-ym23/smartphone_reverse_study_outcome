package com.ss.android.lark.passport.signinsdk_api.entity;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class DevicesStatus implements Serializable {
    private List<DeviceStatus> devices;

    public static class DeviceStatus implements Serializable {
        private String deviceId;
        private OnLineStatus onlineStatus;
        private TerminalType terminalType;

        public static final enum OnLineStatus extends Enum<OnLineStatus> {
            public static final OnLineStatus OFFLINE = null;
            public static final OnLineStatus ONLINE = null;
            public static final OnLineStatus UNKNOWN_ONLINE_STATUS = null;
            public static final /* synthetic */ OnLineStatus[] a = null;
            int value;

            static {
                OnLineStatus r0 = new OnLineStatus("UNKNOWN_ONLINE_STATUS", 0, 0);
                UNKNOWN_ONLINE_STATUS = r0;
                OnLineStatus r1 = new OnLineStatus("ONLINE", 1, 1);
                ONLINE = r1;
                OnLineStatus r3 = new OnLineStatus("OFFLINE", 2, 2);
                OFFLINE = r3;
                a = new OnLineStatus[]{r0, r1, r3};
            }

            public static OnLineStatus[] values() {
                return (OnLineStatus[]) a.clone();
            }

            public int getValue() {
                return this.value;
            }

            public static OnLineStatus valueOf(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return UNKNOWN_ONLINE_STATUS;
            L10:
                return OFFLINE;
            L12:
                return ONLINE;
            L14:
                return UNKNOWN_ONLINE_STATUS;
            }

            public void setValue(int r1) {
                this.value = r1;
            }

            public static OnLineStatus valueOf(String r1) {
                return (OnLineStatus) a.a(OnLineStatus.class, r1);
            }

            public OnLineStatus(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final enum TerminalType extends Enum<TerminalType> {
            public static final TerminalType ANDROID = null;
            public static final TerminalType IOS = null;
            public static final TerminalType PC = null;
            public static final TerminalType UNKNOWN_TERMINAL_TYPE = null;
            public static final TerminalType WEB = null;
            public static final /* synthetic */ TerminalType[] a = null;
            int value;

            static {
                TerminalType r0 = new TerminalType("UNKNOWN_TERMINAL_TYPE", 0, 0);
                UNKNOWN_TERMINAL_TYPE = r0;
                TerminalType r1 = new TerminalType("PC", 1, 1);
                PC = r1;
                TerminalType r3 = new TerminalType("WEB", 2, 2);
                WEB = r3;
                TerminalType r5 = new TerminalType("ANDROID", 3, 3);
                ANDROID = r5;
                TerminalType r7 = new TerminalType("IOS", 4, 4);
                IOS = r7;
                a = new TerminalType[]{r0, r1, r3, r5, r7};
            }

            public static TerminalType[] values() {
                return (TerminalType[]) a.clone();
            }

            public int getValue() {
                return this.value;
            }

            public static TerminalType valueOf(int r1) {
                if (r1 == 0) goto L22;
                if (r1 == 1) goto L20;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L16;
                if (r1 == 4) goto L14;
                return UNKNOWN_TERMINAL_TYPE;
            L14:
                return IOS;
            L16:
                return ANDROID;
            L18:
                return WEB;
            L20:
                return PC;
            L22:
                return UNKNOWN_TERMINAL_TYPE;
            }

            public void setValue(int r1) {
                this.value = r1;
            }

            public static TerminalType valueOf(String r1) {
                return (TerminalType) a.a(TerminalType.class, r1);
            }

            public TerminalType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public DeviceStatus() {
        }

        public String getDeviceId() {
            return this.deviceId;
        }

        public OnLineStatus getOnlineStatus() {
            return this.onlineStatus;
        }

        public TerminalType getTerminalType() {
            return this.terminalType;
        }

        public void setDeviceId(String r1) {
            this.deviceId = r1;
        }

        public void setOnlineStatus(OnLineStatus r1) {
            this.onlineStatus = r1;
        }

        public void setTerminalType(TerminalType r1) {
            this.terminalType = r1;
        }
    }

    public DevicesStatus() {
    }

    public int getDeviceCount() {
        List<DeviceStatus> r0 = this.devices;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public List<DeviceStatus> getDevices() {
        return this.devices;
    }

    public void add(DeviceStatus r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2.getDeviceId()) == false) goto L7;
        return;
    L7:
        if (this.devices != null) goto L9;
        this.devices = new ArrayList();
    L9:
        this.devices.add(r2);
    }

    public boolean contains(DeviceStatus r4) {
        if (r4 == null) goto L16;
        List<DeviceStatus> r0 = this.devices;
        if (r0 == null) goto L24;
        Iterator<DeviceStatus> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L25;
        DeviceStatus r2 = r1.next();
        if (r2 == null) goto L8;
        if (a(r2.getDeviceId(), r4.getDeviceId()) == false) goto L8;
        return true;
    L25:
        return false;
    L24:
        return false;
    L16:
        return false;
    }

    public void remove(DeviceStatus r5) {
        if (r5 == null) goto L22;
        List<DeviceStatus> r0 = this.devices;
        if (r0 == null) goto L23;
        Iterator<DeviceStatus> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L24;
        DeviceStatus r2 = r1.next();
        if (r2 == null) goto L8;
        if (a(r2.getDeviceId(), r5.getDeviceId()) == false) goto L8;
        this.devices.remove(r2);
        return;
    L24:
        return;
    L23:
        return;
    }

    public void setDevices(List<DeviceStatus> r1) {
        this.devices = r1;
    }

    public void update(DeviceStatus r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        List<DeviceStatus> r0 = this.devices;
        if (r0 != null) goto L8;
        ArrayList r1 = new ArrayList();
        this.devices = r1;
        r1.add(r5);
        return;
    L8:
        Iterator<DeviceStatus> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L18;
        DeviceStatus r3 = r2.next();
        if (r3 == null) goto L10;
        if (a(r3.getDeviceId(), r5.getDeviceId()) == false) goto L10;
        r3.setOnlineStatus(r5.getOnlineStatus());
        return;
    L18:
        this.devices.add(r5);
    }

    public static boolean a(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        return r1.equals(r2);
    }
}
