package com.bytedance.bdinstall;

import android.content.Context;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public interface ISstInfoProvider {
    String getDefaultImeiOrMeid(Context r1, InstallOptions r2);

    JSONArray getIPV6Address(Context r1);

    String getImei(Context r1, int r2, InstallOptions r3);

    String getMac(Context r1, InstallOptions r2);

    String getMeid(Context r1, int r2, InstallOptions r3);

    String getSerial(Context r1, InstallOptions r2);

    String[] getSimSerialNumbers(Context r1, InstallOptions r2);

    String reflectGetDeviceIdWithSlotIndex(Context r1, int r2);
}
