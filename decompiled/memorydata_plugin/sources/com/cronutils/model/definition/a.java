package com.cronutils.model.definition;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static CronConstraint a() {
        final String r1 = "Both, a day-of-week AND a day-of-month parameter, are not supported.";
        return new CronConstraintsFactory$2(r1);
    }
}
