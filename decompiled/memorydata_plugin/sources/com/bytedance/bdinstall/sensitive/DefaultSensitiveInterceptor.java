package com.bytedance.bdinstall.sensitive;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class DefaultSensitiveInterceptor extends AbsSensitiveInterceptor {
    private InstallOptions options;

    public DefaultSensitiveInterceptor() {
    }

    private String doGetMediaId() {
        if (TextUtils.isEmpty(LocalConstants.getCommonSp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.options.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.options).getString("device_id", "")) == false) goto L6;
        DrLog.d("sdk not start. media id return null. ");
        return "";
    L6:
        Future r6 = ExecutorUtil.submitToFirstIOExecutor(new AnonymousClass1(this));
        return (String) ZeusTransformUtils.preCheckCast(r6.get(100, TimeUnit.MILLISECONDS), String.class, "com.obric.memorydata.plugin");
    L9:
        e = move-exception;
        DrLog.e("media id get error", e);
        return "";
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public List<SubscriptionInfo> getActiveSubscriptionInfoList() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return null;
    L5:
        return SubscriptionManager.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.options.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getActiveSubscriptionInfoList();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public WifiInfo getConnectionInfo() {
        return ((WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.options.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin")).getConnectionInfo();
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
    public byte[] getHardwareAddress(NetworkInterface r1) {
        if (r1 == null) goto L8;
        return r1.getHardwareAddress();
    L5:
        e = move-exception;
        e.printStackTrace();
    L8:
        return new byte[0];
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getIccId(SubscriptionInfo r2) {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return "";
    L5:
        return r2.getIccId();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getImeiByIndex(int r1) {
        return this.options.getTelephonyManager().getImei(r1);
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getMacAddress(WifiInfo r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        return r1.getMacAddress();
    }

    public String getMediaId() {
        return doGetMediaId();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getMeidByIndex(int r1) {
        return this.options.getTelephonyManager().getMeid(r1);
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
    public String getSSID(WifiInfo r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        return r1.getSSID();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSerial() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return "";
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.options.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion >= 26) goto L7;
        return "";
    L7:
        return Build.getSerial();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSimCountryIso() {
        return this.options.getTelephonyManager().getSimCountryIso();
    }

    @Override // com.bytedance.bdinstall.sensitive.AbsSensitiveInterceptor
    public String getSimSerialNumber() {
        return this.options.getTelephonyManager().getSimSerialNumber();
    L4:
        DrLog.d("getSSN , no permission, ignore");
        return "";
    }

    public void setOptions(InstallOptions r1) {
        this.options = r1;
    }
}
