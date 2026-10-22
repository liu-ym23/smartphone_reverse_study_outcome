package com.ss.android.lark.inline.ai.creationai.editor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import io.reactivex.functions.Function;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g<T, R> implements Function {
    public final /* synthetic */ CreationAIEditorWebview a;

    public g(CreationAIEditorWebview r1) {
        this.a = r1;
    }

    public final Object apply(Object r25) {
        Intrinsics.checkNotNullParameter((Boolean) r25, "it");
        int r0 = c.a;
        Context r2 = this.a.getContext();
        Intrinsics.checkNotNullParameter(r2, "context");
        Log.i("CreationAIEditorResLoader", "getRichtextRes  1");
        long r5 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r2, "context");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(c.c(new BufferedReader(new InputStreamReader(r2.getAssets().open("inlineai/creation_ai_revision")))));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r3);
        if (r7 == null) goto L10;
        Log.i("CreationAIEditorResLoader", "getAssetVersion onFailure : " + r7);
    L10:
        m r8 = new m();
        if (Result.isFailure-impl(r3) == false) goto L13;
        r3 = r8;
    L13:
        String r13 = ((m) r3).b;
        if (r13 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == true) goto L71;
        VFSPath r12 = c.b();
        Intrinsics.checkNotNullParameter(r2, "context");
    L26:
        th = move-exception;
        Log.e("CreationAIEditorResLoader", "getResLocalVersion error", th);
    L28:
        m r6 = new m();
    L29:
        String r9 = r6.b;
        if (r9 != null) goto L32;
        r9 = "";
    L32:
        List r10 = StringsKt.split$default(r13, new char[]{'.'}, false, 0, 6, null);
        List r11 = StringsKt.split$default(r9, new char[]{'.'}, false, 0, 6, null);
        int r14 = Math.min(r10.size(), r11.size());
        int r15 = 0;
        int r16 = 0;
    L33:
        if (r15 >= r14) goto L40;
        r16 = ((String) ListProtector.get(r10, r15)).length() - ((String) ListProtector.get(r11, r15)).length();
        if (r16 != 0) goto L37;
        r16 = ((String) ListProtector.get(r10, r15)).compareTo((String) ListProtector.get(r11, r15));
    L37:
        if (r16 != 0) goto L40;
        r15 = r15 + 1;
    L40:
        if (r16 != 0) goto L42;
        r16 = r10.size() - r11.size();
    L42:
        Log.i("CreationAIEditorResLoader", "getRichtextRes   cost1 : " + (System.currentTimeMillis() - r5) + ",  localVersion: " + r9 + ",  assetVersion: " + r13 + ",  versionCompare: " + r16 + ",  resLocalDir: " + r12.getAbsolutePath());
        if (r16 <= 0) goto L45;
    L51:
        Log.i("CreationAIEditorResLoader", "replaceLocal");
        Intrinsics.checkNotNullParameter(r2, "context");
        VFSPath r17 = c.b();
        VFSFiles.b.getClass();
        FileUtils.f(VFSFiles.b(true).i(r17.getAbsolutePath()));
        Intrinsics.checkNotNullParameter(r2, "context");
        VFSPath r18 = r12;
        Intrinsics.checkNotNullParameter(r18, "dest");
        VFSPath r19 = c.b().subPath("creation_ai_preview.7z");
        com.suite.lark.component.storage.ext.b.delete(r19);
        c.a(r2, "inlineai/creation_ai_preview.7z", r19);
        String r20 = r19.getRealPath();
        String r21 = r18.getRealPath();
        Intrinsics.checkNotNullParameter(r21, "destFold1");
        if (TextUtils.isEmpty(r20) == false) goto L54;
    L63:
        int r22 = -1;
    L64:
        com.suite.lark.component.storage.ext.b.delete(r19);
        if (r22 != 0) goto L69;
    L66:
        Log.i("CreationAIEditorResLoader", "getRichtextRes   cost2 : " + (System.currentTimeMillis() - r5));
        return r18.subPath("creation_ai_preview").subPath("index.html").getAbsolutePath();
    L69:
        throw new IllegalAccessException("extract7z failed " + r22);
    L54:
        if (TextUtils.isEmpty(r21) == true) goto L63;
    L61:
        e = move-exception;
        Log.e("CreationAIEditorResLoader", "extractAll fails : " + e + "  message:" + e.getMessage());
        goto L63
    L57:
        if (StringsKt.endsWith$default(r21, "/", false, 2, null) == true) goto L59;
        r21 = r21 + File.separator;     // Catch: IOException -> L61
    L59:
        r22 = Archive.extractAll(r20, r21, null, 0);     // Catch: IOException -> L61
        goto L64
    L45:
        if (r9.length() != 0) goto L47;
        boolean r23 = true;
    L48:
        if (r23 == true) goto L51;
        r18 = r12;
        goto L66
    L47:
        r23 = false;
        goto L48
    L23:
        if (com.suite.lark.component.storage.ext.b.b(c.b().subPath("creation_ai_preview").subPath("creation_ai_revision")) == false) goto L28;
        VFSFiles.b.getClass();     // Catch: Throwable -> L26
        r6 = c.c(new BufferedReader(new PolarisFileReaderWrapper(VFSFiles.b(true).r(c.b().subPath("creation_ai_preview").subPath("creation_ai_revision"), false))));     // Catch: Throwable -> L26
        goto L29
    L71:
        throw new IllegalArgumentException("assetVersion is null");
    L16:
        if (r13.length() == 0) goto L19;
        r4 = false;
    L5:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
