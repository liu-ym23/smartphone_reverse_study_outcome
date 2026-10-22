package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.livesdk.config.ac0;
import com.bytedance.android.livesdk.config.zj0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(int r1) {
        if (r1 != 0) goto L6;
        return ((Boolean) ac0.a.getValue()).booleanValue();
    L6:
        if (r1 != 5) goto L8;
    L12:
        return false;
    L8:
        if (((Boolean) zj0.a.getValue()).booleanValue() == false) goto L12;
        if (((Boolean) ac0.a.getValue()).booleanValue() == false) goto L12;
        return true;
    }
}
