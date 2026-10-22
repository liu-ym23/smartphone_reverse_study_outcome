package com.ss.android.deviceregister.c;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Account f15207a;

    public static String a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        String r0 = d(r5);
        if (r0 != null) goto L5;
    L8:
        String r6 = c(r5);
        if (r6 != null) goto L11;
        return "";
    L11:
        if (r6.startsWith("newUserModeUtil:") == true) goto L13;
        return "";
    L13:
        return r6.substring(16);
    L5:
        if (r0.startsWith("newUserModeUtil:") == false) goto L8;
        return r0.substring(16);
    }

    private static Account b(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Account r0 = f15207a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        AccountManager r1 = AccountManager.get(r6);
        String r2 = r6.getPackageName();
        String r7 = r6.getString(r6.getApplicationInfo().labelRes);     // Catch: Throwable -> L8
    L11:
        if (TextUtils.isEmpty(r7) == false) goto L13;
    L26:
        return null;
    L13:
        if (TextUtils.isEmpty(r2) == true) goto L26;
        Account[] r3 = r1.getAccountsByType(r2);
        int r4 = r3.length;
        int r8 = 0;
    L16:
        if (r8 >= r4) goto L25;
        Account r9 = r3[r8];
        if (r9 == null) goto L23;
        if (r7.equals(r9.name) == false) goto L23;
        f15207a = r9;
    L23:
        r8 = r8 + 1;
    L25:
        return f15207a;
    L8:
        th = move-exception;
        com.ss.android.common.b.b.d("getAccount:", th);
        r7 = null;
        goto L11
    }

    private static String c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return AccountManager.get(r3).getUserData(b(r3), "new_user_mode_account");
    L5:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    private static String d(Context r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        final Callable<String> r0 = new AnonymousClass1(r5);
        return (String) ZeusTransformUtils.preCheckCast(r0.call(), String.class, "com.obric.memorydata.plugin");
    L6:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L14;
        final CountDownLatch r6 = new CountDownLatch(1);
        final String[] r1 = new String[1];
        new Handler(Looper.getMainLooper()).post(new AnonymousClass2(r1, r0, r6));
        r6.await();     // Catch: InterruptedException -> L10
    L13:
        return r1[0];
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L14:
        return null;
    }
}
