package com.bytedance.lego.init.util;

import com.bytedance.lego.init.config.ProcessMatchMode;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2120a = null;

    static {
        int[] r10 = new int[ProcessMatchMode.values().length];
        f2120a = r10;
        r10[ProcessMatchMode.ENDWITH.ordinal()] = 1;
        r10[ProcessMatchMode.CONTAIN.ordinal()] = 2;
    }
}
