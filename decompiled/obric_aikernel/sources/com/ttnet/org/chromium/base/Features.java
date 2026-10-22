package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
@MainDex
public abstract class Features {
    private final String mName;

    interface Natives {
        boolean getFieldTrialParamByFeatureAsBoolean(long r10, String r11, boolean r12);

        boolean isEnabled(long r10);
    }

    protected Features(String r10) {
        this.mName = r10;
    }

    protected abstract long getFeaturePointer();

    public boolean getFieldTrialParamByFeatureAsBoolean(String r10, boolean r11) {
        return FeaturesJni.get().getFieldTrialParamByFeatureAsBoolean(getFeaturePointer(), r10, r11);
    }

    public String getName() {
        return this.mName;
    }

    public boolean isEnabled() {
        Boolean r10 = FeatureList.getTestValueForFeature(getName());
        if (r10 == null) goto L7;
        return r10.booleanValue();
    L7:
        return FeaturesJni.get().isEnabled(getFeaturePointer());
    }
}
