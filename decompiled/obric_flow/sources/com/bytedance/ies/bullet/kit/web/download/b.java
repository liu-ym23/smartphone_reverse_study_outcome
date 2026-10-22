package com.bytedance.ies.bullet.kit.web.download;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.bullet.kit.resourceloader.g;
import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f5496c = null;
    public static final Lazy d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f5497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f5498b;

    static {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        Object r10 = Result.m124constructorimpl(DownloadTask.class.getDeclaredMethod("a", new Class[]{Long.TYPE}));     // Catch: Throwable -> L4
    L7:
        if (Result.m130isFailureimpl(r10) == false) goto L9;
        r10 = null;
    L9:
        f5496c = (Method) r10;
        d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, WebResourceDownloader$Companion$instance$2.f5493a);
        return;
    L4:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public b() {
        Application r5 = g.f5452b;
        this.f5497a = r5;
        if (r5 == null) goto L5;
        File r10 = new File(r5.getCacheDir(), "bullet_web_resource_offline");
        r10.mkdirs();
    L6:
        this.f5498b = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    public static String a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Uri r10 = Uri.parse(r5);
        if (r10.isHierarchical() == true) goto L6;
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "WebResourceDownloader: url=" + r5 + " isn't hierarchical", "XPreload");
        return null;
    L6:
        char[] r12 = i.f5457a;
        if (r5 != null) goto L31;
    L12:
        String r13 = null;
    L14:
        if (r10.isHierarchical() == true) goto L17;
        r10 = null;
    L17:
        if (r10 == null) goto L29;
        String r14 = r10.getEncodedPath();
        if (r14 == null) goto L29;
        String r15 = FilesKt.getExtension(new File(r14));
        if (r15 == null) goto L29;
        if (TextUtils.isEmpty(r15) == false) goto L26;
        r15 = null;
    L26:
        if (r15 == null) goto L29;
        return androidx.constraintlayout.motion.widget.a.m(r13, '.', r15);
    L29:
        return null;
    L31:
        if (r5.length() <= 0) goto L12;
        MessageDigest r16 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L30
        r16.update(r5.getBytes(Charset.forName("UTF-8")));     // Catch: Exception -> L30
        r13 = i.g(r16.digest());     // Catch: Exception -> L30
        goto L14
    }
}
