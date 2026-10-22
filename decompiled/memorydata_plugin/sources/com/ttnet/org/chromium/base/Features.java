package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base::android")
@MainDex
public abstract class Features {
    private final String mName;

    interface Natives {
        boolean getFieldTrialParamByFeatureAsBoolean(long r1, String r3, boolean r4);

        boolean isEnabled(long r1);
    }

    public Features(String r1) {
        this.mName = r1;
    }

    public abstract long getFeaturePointer();

    public boolean getFieldTrialParamByFeatureAsBoolean(String r4, boolean r5) {
        return FeaturesJni.get().getFieldTrialParamByFeatureAsBoolean(getFeaturePointer(), r4, r5);
    }

    public String getName() {
        return this.mName;
    }

    public boolean isEnabled() {
        Boolean r0 = FeatureList.getTestValueForFeature(getName());
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        return FeaturesJni.get().isEnabled(getFeaturePointer());
    }
}
