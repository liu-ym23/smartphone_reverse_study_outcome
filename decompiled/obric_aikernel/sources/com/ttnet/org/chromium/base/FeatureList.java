package com.ttnet.org.chromium.base;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.library_loader.LibraryLoader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public class FeatureList {
    private static boolean sTestCanUseDefaults;

    @Nullable
    private static TestValues sTestFeatures;

    @VisibleForTesting(otherwise = 3)
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

        static /* synthetic */ Map access$000(TestValues r10) {
            return r10.mFeatureFlags;
        }

        private static String makeKey(String r10, String r11) {
            return r10 + ":" + r11;
        }

        public void addFeatureFlagOverride(String r10, boolean r11) {
            this.mFeatureFlags.put(r10, Boolean.valueOf(r11));
        }

        public void addFieldTrialParamOverride(String r10, String r11, String r12) {
            this.mFieldTrialParams.put(makeKey(r10, r11), r12);
        }

        Boolean getFeatureFlagOverride(String r10) {
            return this.mFeatureFlags.get(r10);
        }

        String getFieldTrialParamOverride(String r10, String r11) {
            return this.mFieldTrialParams.get(makeKey(r10, r11));
        }

        public void setFeatureFlagsOverride(Map<String, Boolean> r10) {
            this.mFeatureFlags = r10;
        }
    }

    private FeatureList() {
    }

    public static Boolean getTestValueForFeature(String r10) {
        if (hasTestFeatures() == false) goto L12;
        Boolean r11 = sTestFeatures.getFeatureFlagOverride(r10);
        if (r11 == null) goto L8;
        return r11;
    L8:
        if (sTestCanUseDefaults == false) goto L11;
        return null;
    L11:
        throw new IllegalArgumentException("No test value configured for " + r10 + " and native is not available to provide a default value. Use @EnableFeatures or @DisableFeatures to provide test values for the flag.");
    L12:
        return null;
    }

    public static String getTestValueForFieldTrialParam(String r10, String r11) {
        if (hasTestFeatures() == false) goto L7;
        String r12 = sTestFeatures.getFieldTrialParamOverride(r10, r11);
        if (r12 == null) goto L9;
        return r12;
    L9:
        return null;
    L7:
        return null;
    }

    public static boolean hasTestFeature(String r10) {
        if (hasTestFeatures() == true) goto L5;
    L7:
        return false;
    L5:
        if (TestValues.access$000(sTestFeatures).containsKey(r10) == false) goto L7;
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

    @VisibleForTesting
    public static void resetTestCanUseDefaultsForTesting() {
        sTestCanUseDefaults = false;
    }

    @VisibleForTesting
    public static void setTestCanUseDefaultsForTesting() {
        sTestCanUseDefaults = true;
    }

    @VisibleForTesting
    public static void setTestFeatures(Map<String, Boolean> r10) {
        if (r10 != null) goto L4;
        setTestValues(null);
        return;
    L4:
        TestValues r11 = new TestValues();
        r11.setFeatureFlagsOverride(r10);
        setTestValues(r11);
    }

    @VisibleForTesting
    public static void setTestValues(TestValues r10) {
        sTestFeatures = r10;
    }
}
