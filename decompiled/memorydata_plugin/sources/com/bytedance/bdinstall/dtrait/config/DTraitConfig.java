package com.bytedance.bdinstall.dtrait.config;

import com.bytedance.bdinstall.dtrait.interfaces.IDTraitInitConfig;
import com.bytedance.bdinstall.dtrait.interfaces.IDtraitNetworkConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DTraitConfig {
    private static int dTraitCiphertextSamplingPercentage = 10;
    private static List<String> dtraitEventWhiteList = null;
    private static long dtraitExipreTime = 1800000;
    private static IDTraitInitConfig dtraitInterface = null;
    private static IDtraitNetworkConfig dtraitNetworkConfig = null;
    private static boolean enableDTrait = true;
    private static boolean enableLoader = true;

    static {
    }

    public DTraitConfig() {
    }

    public static int getDTraitCiphertextSamplingPercentage() {
        return dTraitCiphertextSamplingPercentage;
    }

    public static List<String> getDtraitEventWhiteList() {
        return dtraitEventWhiteList;
    }

    public static long getDtraitExipreTime() {
        return dtraitExipreTime;
    }

    public static IDTraitInitConfig getDtraitInterface() {
        return dtraitInterface;
    }

    public static IDtraitNetworkConfig getDtraitNetworkConfig() {
        return dtraitNetworkConfig;
    }

    public static boolean isEnableDTrait() {
        return enableDTrait;
    }

    public static boolean isEnableLoader() {
        return enableLoader;
    }

    public static void setDTraitCiphertextSamplingPercentage(int r0) {
        dTraitCiphertextSamplingPercentage = r0;
    }

    public static void setDtraitEventWhiteList(List<String> r2) {
        dtraitEventWhiteList = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    public static void setDtraitExipreTime(long r0) {
        dtraitExipreTime = r0;
    }

    public static void setDtraitInitConfig(IDTraitInitConfig r2) {
        dtraitInterface = (IDTraitInitConfig) ZeusTransformUtils.wrapperContextForParams(r2, IDTraitInitConfig.class, "com.obric.memorydata.plugin");
    }

    public static void setDtraitNetworkConfig(IDtraitNetworkConfig r2) {
        dtraitNetworkConfig = (IDtraitNetworkConfig) ZeusTransformUtils.wrapperContextForParams(r2, IDtraitNetworkConfig.class, "com.obric.memorydata.plugin");
    }

    public static void setEnableDTrait(boolean r0) {
        enableDTrait = r0;
    }

    public static void setEnableLoader(boolean r0) {
        enableLoader = r0;
    }
}
