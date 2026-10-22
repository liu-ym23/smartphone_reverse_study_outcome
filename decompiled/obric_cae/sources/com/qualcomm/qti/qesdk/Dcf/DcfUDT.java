package com.qualcomm.qti.qesdk.Dcf;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class DcfUDT {

    public static class AdvertiseData {
        public int includeLocalName;
        public ArrayList<byte[]> manufacturerData;
        public ArrayList<Long> manufacturerIds;
        public byte[] rawAdvertiseData;
        public ArrayList<byte[]> serviceData;
        public ArrayList<byte[]> serviceDataUuids;
        public ArrayList<byte[]> serviceUuids;

        public AdvertiseData() {
        }

        public AdvertiseData(ArrayList<byte[]> r8, ArrayList<byte[]> r10, ArrayList<Long> r11, ArrayList<byte[]> r12, ArrayList<byte[]> r13, byte[] r14, int r15) {
            this.serviceData = r8;
            this.serviceDataUuids = r10;
            this.manufacturerIds = r11;
            this.manufacturerData = r12;
            this.serviceUuids = r13;
            this.rawAdvertiseData = r14;
            this.includeLocalName = r15;
        }
    }

    public static class AdvertisingParameters {
        public int includeTxPower;
        public DcfEnums.AdvertisingInterval interval;
        public int legacy;
        public DcfEnums.TxPowerLevel txPowerLevel;

        public AdvertisingParameters() {
            this.legacy = 0;
        }

        public AdvertisingParameters(DcfEnums.AdvertisingInterval r8, DcfEnums.TxPowerLevel r10, int r11, int r12) {
            this.interval = r8;
            this.txPowerLevel = r10;
            this.includeTxPower = r11;
            this.legacy = r12;
        }
    }

    public static class BleScanData {
        public String deviceName;
        public ArrayList<byte[]> manufacturerData;
        public ArrayList<Long> manufacturerIds;
        public byte[] rawData;
        public ArrayList<byte[]> serviceData;
        public ArrayList<byte[]> serviceDataUuids;
        public ArrayList<byte[]> serviceUuids;

        public BleScanData() {
        }

        public BleScanData(byte[] r8, ArrayList<byte[]> r10, ArrayList<byte[]> r11, ArrayList<Long> r12, ArrayList<byte[]> r13, String r14, ArrayList<byte[]> r15) {
            this.rawData = r8;
            this.serviceDataUuids = r10;
            this.serviceData = r11;
            this.manufacturerIds = r12;
            this.manufacturerData = r13;
            this.deviceName = r14;
            this.serviceUuids = r15;
        }
    }

    public static class DataFilters {
        public ArrayList<byte[]> manufacturerData;
        public ArrayList<byte[]> manufacturerDataMasks;
        public ArrayList<Long> manufacturerIds;
        public ArrayList<byte[]> serviceData;
        public ArrayList<byte[]> serviceDataMasks;
        public ArrayList<byte[]> serviceDataUuids;

        public DataFilters() {
        }

        public DataFilters(ArrayList<byte[]> r8, ArrayList<byte[]> r10, ArrayList<byte[]> r11, ArrayList<Long> r12, ArrayList<byte[]> r13, ArrayList<byte[]> r14) {
            this.serviceDataUuids = r8;
            this.serviceData = r10;
            this.serviceDataMasks = r11;
            this.manufacturerIds = r12;
            this.manufacturerData = r13;
            this.manufacturerDataMasks = r14;
        }
    }

    public static class Properties {
        public ArrayList<DcfEnums.PropertyId> propertyIds;
        public ArrayList<Long> propertyValues;

        public Properties() {
        }

        public Properties(ArrayList<DcfEnums.PropertyId> r8, ArrayList<Long> r10) {
            this.propertyIds = r8;
            this.propertyValues = r10;
        }
    }

    public static class PropertyFilters {
        public ArrayList<DcfEnums.Condition> acceptIf;
        public ArrayList<DcfEnums.PropertyId> propertyIds;
        public ArrayList<Long> propertyValues;

        public PropertyFilters() {
        }

        public PropertyFilters(ArrayList<DcfEnums.PropertyId> r8, ArrayList<Long> r10, ArrayList<DcfEnums.Condition> r11) {
            this.propertyIds = r8;
            this.propertyValues = r10;
            this.acceptIf = r11;
        }
    }

    public static class ScanFilters {
        public ArrayList<String> deviceNames;
        public ArrayList<byte[]> manufacturerData;
        public ArrayList<byte[]> manufacturerDataMasks;
        public ArrayList<Long> manufacturerIds;
        public ArrayList<byte[]> serviceData;
        public ArrayList<byte[]> serviceDataMasks;
        public ArrayList<byte[]> serviceDataUuids;
        public ArrayList<byte[]> serviceUuidMasks;
        public ArrayList<byte[]> serviceUuids;

        public ScanFilters() {
        }

        public ScanFilters(ArrayList<byte[]> r8, ArrayList<byte[]> r10, ArrayList<byte[]> r11, ArrayList<Long> r12, ArrayList<byte[]> r13, ArrayList<byte[]> r14, ArrayList<String> r15, ArrayList<byte[]> r16, ArrayList<byte[]> r17) {
            this.serviceDataUuids = r8;
            this.serviceData = r10;
            this.serviceDataMasks = r11;
            this.manufacturerIds = r12;
            this.manufacturerData = r13;
            this.manufacturerDataMasks = r14;
            this.deviceNames = r15;
            this.serviceUuids = r16;
            this.serviceUuidMasks = r17;
        }
    }

    public static class ScanSettings {
        public int highRssiThreshold;
        public long maxLatency;
        public DcfEnums.ScanMode mode;

        public ScanSettings() {
        }

        public ScanSettings(DcfEnums.ScanMode r8, long r10, int r11) {
            this.mode = r8;
            this.maxLatency = r10;
            this.highRssiThreshold = r11;
        }
    }

    public DcfUDT() {
    }
}
