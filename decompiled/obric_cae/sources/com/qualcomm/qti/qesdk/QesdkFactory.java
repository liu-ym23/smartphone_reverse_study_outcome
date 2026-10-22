package com.qualcomm.qti.qesdk;

import android.content.Context;
import com.qualcomm.qti.qesdkIntf.IQesdk;

/* JADX INFO: loaded from: classes2.dex */
public final class QesdkFactory {
    private QesdkFactory() {
    }

    public static IQesdk getInstance(Context r8) {
        return QesdkBase.getInstance(r8);
    }
}
