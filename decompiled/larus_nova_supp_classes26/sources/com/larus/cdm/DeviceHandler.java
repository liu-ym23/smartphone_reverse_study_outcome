package com.larus.cdm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class DeviceHandler {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/cdm/DeviceHandler$Device;", "", "productId", "", "productName", "", "scanUUID", "connectUUID", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProductId", "()I", "getProductName", "()Ljava/lang/String;", "getScanUUID", "getConnectUUID", "D_OLD", "D", "E", "G", "H_FREE_CLIP", "H_FREE_PRO", "H_FREE_BUDS_PRO", "UNKNOWN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Device extends Enum<Device> {
        public static final Device D = null;
        public static final Device D_OLD = null;
        public static final Device E = null;
        public static final Device G = null;
        public static final Device H_FREE_BUDS_PRO = null;
        public static final Device H_FREE_CLIP = null;
        public static final Device H_FREE_PRO = null;
        public static final Device UNKNOWN = null;
        public static final /* synthetic */ Device[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String connectUUID;
        private final int productId;
        private final String productName;
        private final String scanUUID;

        public static EnumEntries<Device> getEntries() {
            return b;
        }

        static {
            Device r7 = new Device("D_OLD", 0, 0, "Dora", "0000FD7B-0000-1000-8000-00805F9B34FB", "00002499-0000-1000-8000-00805f9b34fb");
            D_OLD = r7;
            Device r0 = new Device("D", 1, 1, "Dora", "0000FD7B-0000-1000-8000-00805F9B34FB", "00002499-0000-1000-8000-00805f9b34fb");
            D = r0;
            Device r1 = new Device("E", 2, 2, "DoraE", "0000FD7B-0000-1000-8000-00805F9B34FB", "00002499-0000-1000-8000-00805f9b34fb");
            E = r1;
            Device r2 = new Device("G", 3, 16, "DoraG", "0000FD7B-0000-1000-8000-00805F9B34FB", "00002499-0000-1000-8000-00805f9b34fb");
            G = r2;
            Device r3 = new Device("H_FREE_CLIP", 4, 1048576, "HUAWEI FreeClip 2", "0000FDEE-0000-1000-8000-00805F9B34FB", "00101020-4C42-0065-636E-614465747942");
            H_FREE_CLIP = r3;
            Device r4 = new Device("H_FREE_PRO", 5, 1048577, "HUAWEI FreeBuds Pro 5", "0000FDEE-0000-1000-8000-00805F9B34FB", "00101020-4C42-0065-636E-614465747942");
            H_FREE_PRO = r4;
            Device r5 = new Device("H_FREE_BUDS_PRO", 6, 1048578, "HUAWEI FreeBuds Pro 5", "0000FDEE-0000-1000-8000-00805F9B34FB", "00101020-4C42-0065-636E-614465747942");
            H_FREE_BUDS_PRO = r5;
            Device r6 = new Device("UNKNOWN", 7, -1, "UNKNOWN", "", "");
            UNKNOWN = r6;
            Device[] r8 = {r7, r0, r1, r2, r3, r4, r5, r6};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
        }

        public static Device[] values() {
            return (Device[]) a.clone();
        }

        public final String getConnectUUID() {
            return this.connectUUID;
        }

        public final int getProductId() {
            return this.productId;
        }

        public final String getProductName() {
            return this.productName;
        }

        public final String getScanUUID() {
            return this.scanUUID;
        }

        public static Device valueOf(String r1) {
            return (Device) a.a(Device.class, r1);
        }

        public Device(String r1, int r2, int r3, String r4, String r5, String r6) {
            super(r1, r2);
            this.productId = r3;
            this.productName = r4;
            this.scanUUID = r5;
            this.connectUUID = r6;
        }
    }

    static {
    }

    public static Device a(int r2) {
        Device r0 = Device.G;
        if (r2 != r0.getProductId()) goto L6;
        return r0;
    L6:
        if (r2 == Device.D_OLD.getProductId()) goto L25;
        Device r1 = Device.D;
        if (r2 == r1.getProductId()) goto L27;
        Device r3 = Device.E;
        if (r2 == r3.getProductId()) goto L28;
        Device r4 = Device.H_FREE_CLIP;
        if (r2 == r4.getProductId()) goto L29;
        Device r5 = Device.H_FREE_PRO;
        if (r2 == r5.getProductId()) goto L30;
        Device r6 = Device.H_FREE_BUDS_PRO;
        if (r2 != r6.getProductId()) goto L24;
        return r6;
    L24:
        return Device.UNKNOWN;
    L30:
        return r5;
    L29:
        return r4;
    L28:
        return r3;
    L27:
        return r1;
    L25:
        return Device.D;
    }
}
