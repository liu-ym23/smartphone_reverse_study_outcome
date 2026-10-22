package com.bytedance.bdinstall.oaid;

import android.content.Context;
import com.bytedance.bdinstall.DrLog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class XiaomiOppoImpl implements OaidApi {
    private static Class<?> sClass;
    private static Method sGetOAID;
    private static Object sIdProviderImpl;

    static {
        Class<?> r10 = Class.forName("com.android.id.impl.IdProviderImpl");     // Catch: Exception -> L4
        sClass = r10;     // Catch: Exception -> L4
        sIdProviderImpl = r10.newInstance();     // Catch: Exception -> L4
        sGetOAID = sClass.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        DrLog.e("Oaid#static reflect exception! " + e.getMessage());
    }

    XiaomiOppoImpl() {
    }

    private static String invokeMethod(Context r10, Method r11) {
        Object r12 = sIdProviderImpl;
        if (r12 == null) goto L10;
        if (r11 != null) goto L13;
        return null;
    L13:
        Object r13 = r11.invoke(r12, new Object[]{r10});     // Catch: Exception -> L12
        if (r13 == null) goto L16;
        return (String) r13;
    L16:
        return null;
    L17:
        return null;
    L10:
        return null;
    }

    static boolean isSupport() {
        if (sClass != null) goto L5;
    L9:
        return false;
    L5:
        if (sIdProviderImpl == null) goto L9;
        if (sGetOAID == null) goto L9;
        return true;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Xiaomi";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r10) {
        OaidApi.Result r11 = new OaidApi.Result();     // Catch: Exception -> L4
        r11.oaid = invokeMethod(r10, sGetOAID);     // Catch: Exception -> L4
        return r11;
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r10) {
        return isSupport();
    }
}
