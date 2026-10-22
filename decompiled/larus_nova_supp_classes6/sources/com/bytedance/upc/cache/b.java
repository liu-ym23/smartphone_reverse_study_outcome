package com.bytedance.upc.cache;

import android.content.ContentValues;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class b {
    public static String a;
    public static String b;
    public static final b c = null;

    public b() {
    }

    static {
        c = new b();
    }

    public final String a() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return "";
    L5:
        Context r0 = getContext();
        if (r0 != null) goto L8;
        return "";
    L8:
        if (ContextCompat.checkSelfPermission(r0, "android.permission.READ_PHONE_STATE") == 0) goto L10;
        return "";
    L10:
        return null;
    }

    private final Context getContext() {
        return ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getContext();
    L4:
        return null;
    }

    public final String b(String r5) {
        if (Intrinsics.areEqual(r5, "upc_cache_imei") == false) goto L9;
        if (TextUtils.isEmpty(a) == true) goto L9;
        return a;
    L9:
        if (Intrinsics.areEqual(r5, "upc_cache_deviceid") == false) goto L32;
        if (TextUtils.isEmpty(b) == false) goto L32;
        return b;
    L32:
        Context r1 = getContext();     // Catch: Throwable -> L26
        String r2 = ApiMultiProcessSharedProvider.e;     // Catch: Throwable -> L26
        monitor-enter(ApiMultiProcessSharedProvider.class);     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L18:
        if (ApiMultiProcessSharedProvider.h != null) goto L20;
        ApiMultiProcessSharedProvider.h = new ApiMultiProcessSharedProvider.b(r1);     // Catch: Throwable -> L23
    L20:
        ApiMultiProcessSharedProvider.b r3 = ApiMultiProcessSharedProvider.h;     // Catch: Throwable -> L23
        monitor-exit(ApiMultiProcessSharedProvider.class);     // Catch: Throwable -> L26
    L27:
        if (r3 != null) goto L29;
        return null;
    L29:
        return r3.c(r5);
    L26:
        r3 = null;
        goto L27
    }

    public final void c(String r6, String r7) {
        if (Intrinsics.areEqual(r6, "upc_cache_imei") == false) goto L8;
        if (TextUtils.isEmpty(r7) == true) goto L8;
        a = r7;
    L37:
        Context r0 = getContext();     // Catch: Throwable -> L23
        String r1 = ApiMultiProcessSharedProvider.e;     // Catch: Throwable -> L23
        monitor-enter(ApiMultiProcessSharedProvider.class);     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L15:
        if (ApiMultiProcessSharedProvider.h != null) goto L17;
        ApiMultiProcessSharedProvider.h = new ApiMultiProcessSharedProvider.b(r0);     // Catch: Throwable -> L20
    L17:
        ApiMultiProcessSharedProvider.b r2 = ApiMultiProcessSharedProvider.h;     // Catch: Throwable -> L20
        monitor-exit(ApiMultiProcessSharedProvider.class);     // Catch: Throwable -> L23
    L24:
        if (r2 == null) goto L31;
        Context r3 = r2.a;
        ContentValues r4 = new ContentValues();
        Context r5 = r3.getApplicationContext();
        r5.getApplicationContext().getSharedPreferences("upc_sdk_multi_process_sp", 4);
        r4.put(r6, r7);
        String r8 = ApiMultiProcessSharedProvider.e;     // Catch: Throwable -> L29
        ApiMultiProcessSharedProvider.a.b(r5.getContentResolver(), ApiMultiProcessSharedProvider.b(r5, "key", "type"), r4);     // Catch: Throwable -> L32
        return;
    L41:
        return;
    L29:
        th = move-exception;
        throw th;
    L31:
        return;
    L23:
        r2 = null;
    L8:
        if (Intrinsics.areEqual(r6, "upc_cache_deviceid") == false) goto L37;
        if (TextUtils.isEmpty(r7) == true) goto L37;
        b = r7;
        goto L37
    }
}
