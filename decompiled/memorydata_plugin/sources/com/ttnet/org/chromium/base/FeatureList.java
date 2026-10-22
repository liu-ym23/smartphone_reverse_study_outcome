package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.library_loader.LibraryLoader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base::android")
@MainDex
public class FeatureList {
    private static boolean sTestCanUseDefaults;
    private static TestValues sTestFeatures;

    public interface Natives {
        boolean isInitialized();
    }

    public static class TestValues {
        private Map<String, Boolean> mFeatureFlags;
        private Map<String, String> mFieldTrialParams;

        public TestValues() {
            this.mFeatureFlags = new HashMap();
            this.mFieldTrialParams = new HashMap();
        }

        static /* synthetic */ Map access$000(TestValues r0) {
            return r0.mFeatureFlags;
        }

        private static String makeKey(String r1, String r2) {
            return r1 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r2;
        }

        public void addFeatureFlagOverride(String r1, boolean r2) {
            this.mFeatureFlags.put(r1, Boolean.valueOf(r2));
        }

        public void addFieldTrialParamOverride(String r1, String r2, String r3) {
            this.mFieldTrialParams.put(makeKey(r1, r2), r3);
        }

        Boolean getFeatureFlagOverride(String r2) {
            return (Boolean) ZeusTransformUtils.preCheckCast(this.mFeatureFlags.get(r2), Boolean.class, "com.obric.memorydata.plugin");
        }

        String getFieldTrialParamOverride(String r1, String r2) {
            return (String) ZeusTransformUtils.preCheckCast(this.mFieldTrialParams.get(makeKey(r1, r2)), String.class, "com.obric.memorydata.plugin");
        }

        public void setFeatureFlagsOverride(Map<String, Boolean> r3) {
            this.mFeatureFlags = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        }
    }

    private FeatureList() {
    }

    public static Boolean getTestValueForFeature(String r3) {
        if (hasTestFeatures() == false) goto L12;
        Boolean r0 = sTestFeatures.getFeatureFlagOverride(r3);
        if (r0 == null) goto L8;
        return r0;
    L8:
        if (sTestCanUseDefaults == false) goto L11;
        return null;
    L11:
        throw new IllegalArgumentException("No test value configured for " + r3 + " and native is not available to provide a default value. Use @EnableFeatures or @DisableFeatures to provide test values for the flag.");
    L12:
        return null;
    }

    public static String getTestValueForFieldTrialParam(String r1, String r2) {
        if (hasTestFeatures() == false) goto L7;
        String r3 = sTestFeatures.getFieldTrialParamOverride(r1, r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        return null;
    L7:
        return null;
    }

    public static boolean hasTestFeature(String r1) {
        if (hasTestFeatures() == true) goto L5;
    L7:
        return false;
    L5:
        if (TestValues.access$000(sTestFeatures).containsKey(r1) == false) goto L7;
        return true;
    }

    public static boolean hasTestFeatures() {
        if (sTestFeatures == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isInitialized() {
        if (hasTestFeatures() == false) goto L5;
    L8:
        return true;
    L5:
        if (isNativeInitialized() == true) goto L8;
        return false;
    }

    public static boolean isNativeInitialized() {
        if (LibraryLoader.getInstance().isInitialized() == true) goto L7;
        return false;
    L7:
        return FeatureListJni.get().isInitialized();
    }

    public static void resetTestCanUseDefaultsForTesting() {
        sTestCanUseDefaults = false;
    }

    public static void setTestCanUseDefaultsForTesting() {
        sTestCanUseDefaults = true;
    }

    public static void setTestFeatures(Map<String, Boolean> r2) {
        Map<String, Boolean> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        setTestValues(null);
        return;
    L5:
        TestValues r0 = new TestValues();
        r0.setFeatureFlagsOverride(r3);
        setTestValues(r0);
    }

    public static void setTestValues(TestValues r0) {
        sTestFeatures = r0;
    }
}
