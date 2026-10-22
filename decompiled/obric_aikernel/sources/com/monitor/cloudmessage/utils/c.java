package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static boolean a(Context r10, String r11) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return false;
    L8:
        if (r10.checkPermission(r11, Process.myPid(), Process.myUid()) != 0) goto L12;
        return true;
    L12:
        return false;
    }
}
