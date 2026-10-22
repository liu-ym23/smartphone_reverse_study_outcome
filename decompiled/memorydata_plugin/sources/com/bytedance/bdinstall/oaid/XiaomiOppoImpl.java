package com.bytedance.bdinstall.oaid;

import android.content.Context;
import com.bytedance.bdinstall.DrLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class XiaomiOppoImpl implements OaidApi {
    private static Class<?> sClass;
    private static Method sGetOAID;
    private static Object sIdProviderImpl;

    static {
        Class<?> r0 = ZeusTransformUtils.forName("com.android.id.impl.IdProviderImpl", "com.obric.memorydata.plugin");     // Catch: Exception -> L4
        sClass = r0;     // Catch: Exception -> L4
        sIdProviderImpl = r0.newInstance();     // Catch: Exception -> L4
        sGetOAID = sClass.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        DrLog.e("Oaid#static reflect exception! " + e.getMessage());
    }

    XiaomiOppoImpl() {
    }

    private static String invokeMethod(Context r4, Method r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Object r0 = sIdProviderImpl;
        if (r0 == null) goto L10;
        if (r5 != null) goto L13;
        return null;
    L13:
        Object r7 = r5.invoke(r0, new Object[]{r6});     // Catch: Exception -> L12
        if (r7 == null) goto L16;
        return (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
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
    public OaidApi.Result getOaid(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        OaidApi.Result r3 = new OaidApi.Result();     // Catch: Exception -> L5
        r3.oaid = invokeMethod(r1, sGetOAID);     // Catch: Exception -> L5
        return r3;
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return isSupport();
    }
}
