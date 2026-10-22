package com.qualcomm.qti.qesdk.Dcf;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public interface IDcfCBs {

    public interface IBleAdvertiseStatusCallback {
        void onValues(long r8, long r10, DcfEnums.BleAdvertiseStatus r11);
    }

    public interface IBleScanStatusCallback {
        void onValues(long r8, long r10, DcfEnums.BleScanStatus r11);
    }

    public interface IClientRegistrationCallback {
        void onValues(long r8, DcfEnums.ClientRegistrationStatus r10, long r11);
    }

    public interface ICustomEventCallback {
        void onValues(long r8, long r10, byte[] r11);
    }

    public interface ICustomRequestStatusCallback {
        void onValues(long r8, long r10, DcfEnums.CustomRequestStatus r11);
    }

    public interface IDataReadyCallback {
        void onValues(long r8, ArrayList<Integer> r10, DcfUDT.BleScanData r11, DcfUDT.Properties r12);
    }

    public interface IDuplicateDetectionStatusCallback {
        void onValues(long r8, int r10, int r11, DcfEnums.DuplicateDetectionStatus r12);
    }

    public interface IPlatformStatusCallback {
        void onValues(long r8, DcfEnums.PlatformStatus r10);
    }

    public interface ITriggerStatusCallback {
        void onValues(long r8, int r10, DcfEnums.TriggerRequestType r11, DcfEnums.TriggerStatus r12);
    }
}
