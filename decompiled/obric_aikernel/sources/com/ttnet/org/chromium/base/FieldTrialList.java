package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes2.dex */
@MainDex
public class FieldTrialList {

    interface Natives {
        boolean createFieldTrial(String r10, String r11);

        String findFullName(String r10);

        String getVariationParameter(String r10, String r11);

        void logActiveTrials();

        boolean trialExists(String r10);
    }

    private FieldTrialList() {
    }

    public static boolean createFieldTrial(String r10, String r11) {
        return FieldTrialListJni.get().createFieldTrial(r10, r11);
    }

    public static String findFullName(String r10) {
        return FieldTrialListJni.get().findFullName(r10);
    }

    public static String getVariationParameter(String r10, String r11) {
        return FieldTrialListJni.get().getVariationParameter(r10, r11);
    }

    public static void logActiveTrials() {
        FieldTrialListJni.get().logActiveTrials();
    }

    public static boolean trialExists(String r10) {
        return FieldTrialListJni.get().trialExists(r10);
    }
}
