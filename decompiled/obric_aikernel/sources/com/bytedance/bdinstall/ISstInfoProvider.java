package com.bytedance.bdinstall;

import android.content.Context;
import androidx.annotation.RequiresApi;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public interface ISstInfoProvider {
    String getDefaultImeiOrMeid(Context r10, InstallOptions r11);

    JSONArray getIPV6Address(Context r10);

    @RequiresApi(api = 26)
    String getImei(Context r10, int r11, InstallOptions r12);

    String getMac(Context r10, InstallOptions r11);

    @RequiresApi(api = 26)
    String getMeid(Context r10, int r11, InstallOptions r12);

    String getSerial(Context r10, InstallOptions r11);

    String[] getSimSerialNumbers(Context r10, InstallOptions r11);

    String reflectGetDeviceIdWithSlotIndex(Context r10, int r11);
}
