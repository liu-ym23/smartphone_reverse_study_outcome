package com.bytedance.amap.depend;

import android.text.TextUtils;
import com.ss.android.common.applog.TeaAgent;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorDependImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile MonitorDependImpl f3090a;

    public MonitorDependImpl() {
    }

    public final String a() {
        if (TextUtils.isEmpty("") == true) goto L6;
        return "";
    L6:
        return TeaAgent.getServerDeviceId();
    }
}
