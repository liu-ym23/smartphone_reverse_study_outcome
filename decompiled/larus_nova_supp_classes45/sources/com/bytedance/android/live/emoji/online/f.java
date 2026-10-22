package com.bytedance.android.live.emoji.online;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiResInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<V> implements Callable {
    public final /* synthetic */ String a;

    public f(String r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public final OnlineSmallEmojiResInfo call() {
        String r0 = c.a;
        String r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "md5");
        PolarisFileWrapper r2 = new PolarisFileWrapper(c.b(r1));
        BufferedReader r4 = null;
        if (r2.exists() == true) goto L5;
    L68:
        ALogger.d("OnlineEmojiFileHelper", " loadCache, cacheDir not exist");
        return null;
    L5:
        if (r2.isDirectory() == false) goto L68;
        File[] r3 = r2.listFiles();
        boolean r5 = true;
        if (r3 != null) goto L10;
    L16:
        if (r5 == false) goto L18;
        ALogger.d("OnlineEmojiFileHelper", " loadCache, cacheDirFileList is empty");
        return null;
    L18:
        File r6 = r3[0];
        PolarisFileWrapper r7 = new PolarisFileWrapper(r6, "info.json");
        if (r7.exists() == true) goto L21;
    L67:
        ALogger.d("OnlineEmojiFileHelper", " loadCache, infoFile not exist");
        return null;
    L21:
        if (r7.isFile() == false) goto L67;
        int r8 = com.bytedance.android.live.emoji.utils.c.a;
        Intrinsics.checkNotNullParameter(r7, "file");
        BufferedReader r9 = new BufferedReader(new PolarisFileReaderWrapper(r7));     // Catch: Throwable -> L37 Exception -> L39
    L82:
        String r11 = r9.readLine();     // Catch: Throwable -> L33 Exception -> L35
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L33 Exception -> L35
    L26:
        if (r11 == null) goto L28;
        r12.append(r11);     // Catch: Throwable -> L33 Exception -> L35
        r11 = r9.readLine();     // Catch: Throwable -> L33 Exception -> L35
        goto L26
    L28:
        String r13 = r12.toString();     // Catch: Throwable -> L33 Exception -> L35
        r9.close();     // Catch: Exception -> L31
    L49:
        if (TextUtils.isEmpty(r13) == false) goto L76;
        ALogger.d("OnlineEmojiFileHelper", " loadCache, infoJsonStr is empty");
        return null;
    L76:
        Gson r14 = com.bytedance.android.live.emoji.utils.d.a;     // Catch: Throwable -> L53
        Intrinsics.checkNotNullParameter(OnlineSmallEmojiResInfo.class, "clazz");     // Catch: Throwable -> L53
        OnlineSmallEmojiResInfo r15 = (OnlineSmallEmojiResInfo) GsonProtectorUtils.fromJson(com.bytedance.android.live.emoji.utils.d.a, r13, OnlineSmallEmojiResInfo.class);     // Catch: Throwable -> L53
    L55:
        if (r15 != null) goto L57;
        ALogger.d("OnlineEmojiFileHelper", " loadCache resultResInfo is null");
        return null;
    L57:
        r15.setMd5(r1);
        r15.setResDirPath(r6.getAbsolutePath());
        r15.setPicFileDirPath(new PolarisFileWrapper(r6, "static/").getAbsolutePath());
        return r15;
    L53:
        th = move-exception;
        ALogger.e("OnlineEmojiFileHelper", th);
        r15 = null;
    L31:
        e = move-exception;
        ALogger.e("FileRWerHelper", e);
        goto L49
    L35:
        e = e;
    L72:
        ALogger.e("FileRWerHelper", e);     // Catch: Throwable -> L58
        if (r9 != null) goto L74;
    L47:
        r13 = "";
        goto L49
    L74:
        r9.close();     // Catch: Exception -> L45
    L45:
        e = move-exception;
        ALogger.e("FileRWerHelper", e);
    L58:
        th = th;
        r4 = r9;
    L60:
        r9 = r4;
    L61:
        if (r9 != null) goto L70;
    L66:
        throw th;
    L70:
        r9.close();     // Catch: Exception -> L64
    L64:
        e = move-exception;
        ALogger.e("FileRWerHelper", e);
    L33:
        th = th;
    L39:
        e = e;
        r9 = null;
    L37:
        th = th;
        goto L60
    L10:
        if (r3.length != 0) goto L12;
        boolean r16 = true;
    L13:
        if (r16 == true) goto L16;
        r5 = false;
        goto L16
    L12:
        r16 = false;
        goto L13
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
