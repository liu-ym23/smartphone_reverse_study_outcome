package com.bytedance.android.annie.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Pair b(Context r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "path");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L20
        PolarisFileWrapper r13 = new PolarisFileWrapper(r11);     // Catch: Throwable -> L20
        if (r12 == false) goto L6;
        Uri r14 = d.c(r10, r13.getName());     // Catch: Throwable -> L20
    L7:
        if (r14 != null) goto L9;
        return null;
    L9:
        OutputStream r15 = ContentResolverWrapper.openOutputStream(r10.getContentResolver(), r14);     // Catch: Throwable -> L20
        d.b(new PolarisFileInputStreamWrapper(r11), r15);     // Catch: Throwable -> L20
        d.g(r11);     // Catch: Throwable -> L20
        boolean r16 = false;
        AssetFileDescriptor r17 = ContentResolverWrapper.openAssetFileDescriptor(r10.getContentResolver(), r14, "r");     // Catch: FileNotFoundException -> L34 Throwable -> L20
        if (r17 == null) goto L16;
        r17.close();     // Catch: IOException -> L33 Throwable -> L20
    L15:
        r16 = true;
    L16:
        if (r16 == false) goto L18;
        r10.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r14));     // Catch: Throwable -> L20
    L18:
        Object r18 = Result.constructor-impl(new Pair(r14, null));     // Catch: Throwable -> L20
    L23:
        if (Result.isSuccess-impl(r18) == false) goto L27;
        return (Pair) r18;
    L27:
        if (Result.exceptionOrNull-impl(r18) != null) goto L37;
    L32:
        return null;
    L37:
        Result.constructor-impl(Boolean.valueOf(d.g(r11)));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L6:
        r14 = d.d(r10, r13.getName());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public static Pair a(Context r10, String r11, boolean r12, com.bytedance.android.annie.container.fragment.q r13, com.bytedance.android.annie.bridge.method.permission.b r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "path");
        if (ContextCompat.checkSelfPermission(r10, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L54;
        if (r14 == null) goto L48;
        if (r13 == null) goto L14;
        r13.registerOnRequestPermissionsCallBack(r14);
        r13.requestPermissionsProxy(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 800);
    L14:
        return new Pair(null, -1);
    L48:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L7
        Object r16 = Result.constructor-impl(Boolean.valueOf(d.g(r11)));     // Catch: Throwable -> L7
    L9:
        Result.exceptionOrNull-impl(r16);
        return null;
    L7:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L54:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L33
        PolarisFileWrapper r19 = new PolarisFileWrapper(r11);     // Catch: Throwable -> L33
        if (r12 == false) goto L18;
        Uri r20 = d.c(r10, r19.getName());     // Catch: Throwable -> L33
    L19:
        if (r20 != null) goto L21;
        r20 = null;
    L21:
        ContentResolver r21 = r10.getContentResolver();     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L33
        d.b(new PolarisFileInputStreamWrapper(r11), ContentResolverWrapper.openOutputStream(r21, r20));     // Catch: Throwable -> L33
        d.g(r11);     // Catch: Throwable -> L33
        boolean r22 = false;
        if (r20 != null) goto L50;
    L29:
        if (r22 == false) goto L31;
        r10.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r20));     // Catch: Throwable -> L33
    L31:
        Object r23 = Result.constructor-impl(new Pair(r20, null));     // Catch: Throwable -> L33
    L36:
        if (Result.isSuccess-impl(r23) == false) goto L40;
        return (Pair) r23;
    L40:
        if (Result.exceptionOrNull-impl(r23) != null) goto L56;
    L45:
        return null;
    L56:
        Result.constructor-impl(Boolean.valueOf(d.g(r11)));     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L50:
        AssetFileDescriptor r25 = ContentResolverWrapper.openAssetFileDescriptor(r10.getContentResolver(), r20, "r");     // Catch: FileNotFoundException -> L47 Throwable -> L33
        if (r25 == null) goto L29;
        r25.close();     // Catch: IOException -> L46 Throwable -> L33
    L28:
        r22 = true;
        goto L29
    L18:
        r20 = d.d(r10, r19.getName());     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L36
    }
}
