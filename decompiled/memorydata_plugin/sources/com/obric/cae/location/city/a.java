package com.obric.cae.location.city;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f7044a = null;

    static {
        f7044a = Uri.parse("content://com.obric.memorydata.memory.ailabprovider/ai_proactive_agent");
    }

    public static void a(Context r3, ContentObserver r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L13;
        if (r4 == null) goto L14;
        ZeusProviderTransform.registerContentObserver(r5.getContentResolver(), f7044a, false, r4, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.obric.cae.log.a.g("StarLocation-Lab", "registerProactiveAgentObserver failed: " + e.getMessage());
        return;
    L14:
        return;
    }

    public static boolean a(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L36;
        return false;
    L36:
        Cursor r12 = ZeusProviderTransform.query(r11.getContentResolver(), f7044a, null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L31
        if (r12 != null) goto L37;
        if (r12 == null) goto L9;
        r12.close();     // Catch: Exception -> L31
    L9:
        return false;
    L37:
    L25:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Exception -> L31
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L31
        goto L30
    L11:
        if (r12.moveToFirst() == true) goto L14;
        r12.close();     // Catch: Exception -> L31
        return false;
    L14:
        int r3 = r12.getColumnIndex("status");     // Catch: Throwable -> L25
        if (r3 >= 0) goto L18;
        r12.close();     // Catch: Exception -> L31
        return false;
    L18:
        boolean r4 = true;
        if (r12.getInt(r3) == 1) goto L22;
        r4 = false;
    L22:
        com.obric.cae.log.a.e("StarLocation-Lab", "isProactiveAgentEnabled: " + r4);     // Catch: Throwable -> L25
        r12.close();     // Catch: Exception -> L31
        return r4;
    L31:
        e = move-exception;
        com.obric.cae.log.a.g("StarLocation-Lab", "isProactiveAgentEnabled failed: " + e.getMessage());
        return false;
    }

    public static void b(Context r2, ContentObserver r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        if (r3 == null) goto L12;
        ZeusProviderTransform.unregisterContentObserver(r4.getContentResolver(), r3, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        return;
    L13:
        return;
    L12:
        return;
    }
}
