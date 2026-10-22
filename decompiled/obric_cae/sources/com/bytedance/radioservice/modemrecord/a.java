package com.bytedance.radioservice.modemrecord;

import android.annotation.Nullable;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ServiceManager;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    @Nullable
    public static IModemInfoRecordService a() {
        IBinder r8 = ServiceManager.getService("modem_info_record_service");
        if (r8 != null) goto L6;
        return null;
    L6:
        int r10 = IModemInfoRecordService.Stub.f4038a;
        IInterface r11 = r8.queryLocalInterface("com.bytedance.radioservice.modemrecord.IModemInfoRecordService");
        if (r11 == null) goto L12;
        if ((r11 instanceof IModemInfoRecordService) == false) goto L12;
        return (IModemInfoRecordService) r11;
    L12:
        return new IModemInfoRecordService.Stub.Proxy(r8);
    }
}
