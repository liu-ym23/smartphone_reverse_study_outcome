package com.bytedance.bdinstall.sensitive;

import android.annotation.SuppressLint;
import android.media.MediaDrm;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import androidx.annotation.RequiresApi;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingPermission", "HardwareIds"})
public class DefaultSensitiveInterceptor extends AbsSensitiveInterceptor {
    private InstallOptions options;

    public DefaultSensitiveInterceptor() {
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    @SuppressLint({"MissingPermission"})
    public List<SubscriptionInfo> getActiveSubscriptionInfoList() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return null;
    L5:
        return SubscriptionManager.from(this.options.getContext()).getActiveSubscriptionInfoList();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public WifiInfo getConnectionInfo() {
        return ((WifiManager) this.options.getContext().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getCountry() {
        return Locale.getDefault().getCountry();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getDeviceId() {
        return this.options.getTelephonyManager().getDeviceId();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public byte[] getHardwareAddress(NetworkInterface r10) {
        if (r10 == null) goto L8;
        return r10.getHardwareAddress();
    L5:
        e = move-exception;
        e.printStackTrace();
    L8:
        return new byte[0];
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getIccId(SubscriptionInfo r10) {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return "";
    L5:
        return r10.getIccId();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    @RequiresApi(api = 26)
    public String getImeiByIndex(int r10) {
        return this.options.getTelephonyManager().getImei(r10);
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    @SuppressLint({"HardwareIds"})
    public String getMacAddress(WifiInfo r10) {
        if (r10 != null) goto L4;
        return "";
    L4:
        return r10.getMacAddress();
    }

    public String getMediaId() {
        int r10 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L17 Exception -> L19
        if (r10 < 18) goto L60;
        MediaDrm r11 = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));     // Catch: Throwable -> L17 Exception -> L19
        String r12 = Utils.bytesToHex(r11.getPropertyByteArray("deviceUniqueId"));     // Catch: Exception -> L15 Throwable -> L34
        if (r10 < 28) goto L12;
        r11.close();     // Catch: Exception -> L10
    L49:
    L14:
        return r12;
    L12:
        if (r10 < 18) goto L14;
        r11.release();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L15:
        Exception e10 = e;
    L21:
        e10.printStackTrace();     // Catch: Throwable -> L34
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 28) goto L29;
        if (r11 == null) goto L61;
        r11.close();     // Catch: Exception -> L27
    L46:
        return "";
    L61:
        return "";
    L29:
        if (r13 < 18) goto L63;
        if (r11 == null) goto L64;
        r11.release();     // Catch: Exception -> L27
        goto L46
    L64:
        return "";
    L63:
        return "";
    L27:
        e = move-exception;
        e.printStackTrace();
        return "";
    L34:
        Throwable th = th;
    L35:
        int r14 = Build.VERSION.SDK_INT;
        if (r14 < 28) goto L42;
        if (r11 == null) goto L45;
        r11.close();     // Catch: Exception -> L40
    L52:
    L45:
        throw th;
    L42:
        if (r14 < 18) goto L45;
        if (r11 == null) goto L45;
        r11.release();     // Catch: Exception -> L40
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L45
    L60:
        return "";
    L19:
        e = move-exception;
        r11 = null;
        e10 = e;
    L17:
        th = move-exception;
        r11 = null;
        th = th;
        goto L35
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    @RequiresApi(api = 26)
    public String getMeidByIndex(int r10) {
        return this.options.getTelephonyManager().getMeid(r10);
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public Enumeration<NetworkInterface> getNetworkInterfaces() {
        return NetworkInterface.getNetworkInterfaces();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getNetworkOperator() {
        return this.options.getTelephonyManager().getNetworkOperator();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getNetworkOperatorName() {
        return this.options.getTelephonyManager().getNetworkOperatorName();
    }

    public InstallOptions getOptions() {
        return this.options;
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSSID(WifiInfo r10) {
        if (r10 != null) goto L4;
        return "";
    L4:
        return r10.getSSID();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    @SuppressLint({"MissingPermission"})
    public String getSerial() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return "";
    L5:
        if (this.options.getContext().getApplicationInfo().targetSdkVersion >= 26) goto L7;
        return "";
    L7:
        return Build.getSerial();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSimCountryIso() {
        return this.options.getTelephonyManager().getSimCountryIso();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    @SuppressLint({"MissingPermission", "HardwareIds"})
    public String getSimSerialNumber() {
        return this.options.getTelephonyManager().getSimSerialNumber();
    L4:
        DrLog.d("getSSN , no permission, ignore");
        return "";
    }

    public void setOptions(InstallOptions r10) {
        this.options = r10;
    }
}
