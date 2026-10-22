package com.ss.android.account.share.data.write;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class SecShareDataWriteManager {
    public static final /* synthetic */ KProperty[] a = null;
    public static d b;
    public static boolean c;
    public static Context d;
    public static final Lazy e = null;
    public static final SecShareDataWriteManager f = null;

    static {
        a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SecShareDataWriteManager.class), "gson", "getGson()Lcom/google/gson/Gson;"))};
        f = new SecShareDataWriteManager();
        b = new d();
        e = LazyKt.lazy(SecShareDataWriteManager$gson$2.INSTANCE);
    }

    public SecShareDataWriteManager() {
    }

    public static boolean a(String r8) {
        if (c == true) goto L5;
        dra.b r0 = new dra.b();
        r0.b("share_sdk_no_init");
        r0.c();
        boolean r1 = false;
    L6:
        if (r1 == true) goto L8;
        return false;
    L8:
        String r3 = "";
        if (TextUtils.isEmpty(r8) == false) goto L11;
    L36:
        dra.b r2 = new dra.b();
        r2.b("share_sdk_check_pkg_sign_failed");
        r2.a("pkg_name", r8);
        r2.a("pkg_sign", r3);
        r2.c();
        return false;
    L11:
        if (c == false) goto L36;
        if (CollectionsKt.contains(b.a.keySet(), r8) == false) goto L36;
        int r4 = c.a;
        Context r5 = d;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mContext");
    L17:
        if (r8 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        String r6 = null;
        String r7 = c.a(r5.getPackageManager().getPackageInfo(r8, 64).signatures[0]);     // Catch: Exception -> L22
    L24:
        if (r7 == null) goto L27;
        r3 = r7;
    L27:
        if (TextUtils.isEmpty(r3) == true) goto L36;
        if (TextUtils.isEmpty(b.a.get(r8)) == true) goto L36;
        String r9 = r3.toLowerCase();
        String r10 = b.a.get(r8);
        if (r10 == null) goto L34;
        r6 = r10.toLowerCase();
    L34:
        if (Intrinsics.areEqual(r9, r6) == false) goto L36;
        return true;
    L22:
        e = move-exception;
        e.printStackTrace();
        dra.b r11 = new dra.b();
        r11.b("share_sdk_get_pkg_sign_failed");
        r11.a("err_msg", e.getMessage());
        r11.a("err_msg_stack", Log.getStackTraceString(e));
        r11.c();
        r7 = null;
        goto L24
    L5:
        r1 = true;
        goto L6
    }
}
