package com.bytedance.ai.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final boolean a(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return false;
    L6:
        return new PolarisFileWrapper(r1).exists();
    }

    public static final boolean c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (TextUtils.isEmpty(r10) == true) goto L10;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r10);
        if (r0.exists() == true) goto L8;
        return false;
    L8:
        return FilesKt.deleteRecursively(r0);
    L10:
        return false;
    }

    public static final boolean d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (TextUtils.isEmpty(r10) == true) goto L10;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r10);
        if (r0.exists() == true) goto L8;
        return false;
    L8:
        return r0.delete();
    L10:
        return false;
    }

    public static final boolean delete(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (TextUtils.isEmpty(r10) == true) goto L14;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r10);
        if (r0.exists() == true) goto L8;
        return false;
    L8:
        if (r0.isDirectory() == false) goto L11;
        return FilesKt.deleteRecursively(r0);
    L11:
        return r0.delete();
    L14:
        return false;
    }

    public static final long f(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        long r1 = 0;
        if (r10.exists() == false) goto L13;
        File[] r11 = r10.listFiles();
        if (r11 == null) goto L13;
        int r0 = r11.length;
        int r12 = 0;
    L7:
        if (r12 >= r0) goto L13;
        File r13 = r11[r12];
        if (r13.isDirectory() == false) goto L11;
        Intrinsics.checkNotNull(r13);
        long r14 = f(r13);
    L12:
        r1 = r1 + r14;
        r12 = r12 + 1;
        goto L7
    L11:
        r14 = r13.length();
    L13:
        return r1;
    }

    public static final boolean g(String r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.length() <= 0) goto L6;
        return true;
    }

    public static final void h(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        PolarisFileWrapper r0 = new PolarisFileWrapper(r1);
        if (r0.exists() == true) goto L6;
        r0.mkdirs();
        return;
    }

    public static final void j(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        g.a.d("applet_performance", r10);
    }

    public static final String k(InputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        StringBuilder r0 = new StringBuilder();
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r10));
        String r11 = r1.readLine();     // Catch: Throwable -> L9
    L4:
        if (r11 == null) goto L6;
        r0.append(r11);     // Catch: Throwable -> L9
        r0.append("\n");     // Catch: Throwable -> L9
        r11 = r1.readLine();     // Catch: Throwable -> L9
        goto L4
    L6:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r1, null);
        return r0.toString();
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    public static final void b(InputStream r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "inputStream");
        Intrinsics.checkNotNullParameter(r11, "destFile");
        PolarisFileOutputStreamWrapper r0 = new PolarisFileOutputStreamWrapper(r11);
        byte[] r12 = new byte[1024];     // Catch: Throwable -> L10
    L4:
        int r1 = r10.read(r12);     // Catch: Throwable -> L10
        if (r1 <= 0) goto L7;
        r0.write(r12, 0, r1);     // Catch: Throwable -> L10
        goto L4
    L7:
        r0.flush();     // Catch: Throwable -> L10
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r0, null);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    public static final boolean i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        if (TextUtils.isEmpty(r10) == true) goto L11;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r10);
        if (r0.exists() == true) goto L10;
        g.a.e("ExtentionFunc", r0 + " is invalid");
        return false;
    L10:
        return r0.renameTo(new PolarisFileWrapper(r11));
    L11:
        return false;
    }

    public static final boolean l(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "dstFile");
        Intrinsics.checkNotNullParameter(r11, "assetsFolderName");
        Context r12 = f2.k.a();     // Catch: Exception -> L17
        String r13 = new PolarisFileWrapper(r10).getName();     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L17
        InputStream r14 = e(r12, r11, r13);     // Catch: Exception -> L17
        if (r14 != null) goto L20;
        g.a.d("ExtentionFunc", "Resource " + r13 + " does not exist in the assets directory");     // Catch: Exception -> L17
        return false;
    L20:
        g.a.i("ExtentionFunc", "The assets directory contains resource " + r13);     // Catch: Throwable -> L10
        b(r14, r10);     // Catch: Throwable -> L10
    L7:
        CloseableKt.closeFinally(r14, null);     // Catch: Exception -> L17
        return true;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);     // Catch: Exception -> L17
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        g r15 = g.a;
        StringBuilder r1 = new StringBuilder("check assets exist error : ");
        e.printStackTrace();
        r1.append(Unit.INSTANCE);
        r15.e("ExtentionFunc", r1.toString());
        return false;
    }

    public static final InputStream e(Context r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "folderName");
        Intrinsics.checkNotNullParameter(r12, "fileName");
        AssetManager r13 = r10.getAssets();
        String[] r0 = r13.list(r11);
        if (r0 != null) goto L5;
        return null;
    L5:
        int r14 = r0.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L12;
        String r16 = r0[r15];
        if (Intrinsics.areEqual(r16, r12) == true) goto L10;
        r15 = r15 + 1;
        goto L6
    L10:
        return r13.open(r11 + '/' + r16);
    L12:
        return null;
    }
}
