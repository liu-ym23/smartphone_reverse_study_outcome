package com.bytedance.lego.init.util;

import com.bytedance.lego.init.config.ProcessMatchMode;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6772a = null;

    static {
        int[] r5 = new int[ProcessMatchMode.values().length];
        f6772a = r5;
        r5[ProcessMatchMode.ENDWITH.ordinal()] = 1;
        r5[ProcessMatchMode.CONTAIN.ordinal()] = 2;
    }
}
