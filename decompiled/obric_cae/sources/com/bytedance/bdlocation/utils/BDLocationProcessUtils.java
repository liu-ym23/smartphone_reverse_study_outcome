package com.bytedance.bdlocation.utils;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationProcessUtils {
    private static volatile String sCurrentProcessName;

    public BDLocationProcessUtils() {
    }

    public static String getCurrentProcessName(Context r8) {
        return Application.getProcessName();
    }
}
