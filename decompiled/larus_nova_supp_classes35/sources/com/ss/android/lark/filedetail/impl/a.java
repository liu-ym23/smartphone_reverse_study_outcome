package com.ss.android.lark.filedetail.impl;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.MediaStoreUtil;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final byte[] a = null;

    static {
        a = new byte[]{5, 69, 69, 83, 0, 0, 0, 0};
    }

    @JvmStatic
    public static final String a(Context r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "fileName");
        StringBuilder r7 = new StringBuilder();
        Set r0 = MediaStoreUtil.a;
        MediaStoreUtil.DirType r1 = MediaStoreUtil.DirType.DOWNLOADS;
        Intrinsics.checkNotNullParameter(r1, "dirType");
        r7.append(new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(r1.getValue()), "Lark").getAbsolutePath());
        r7.append(File.separator);
        String r8 = r7.toString();
        ArrayList r2 = new ArrayList();
        if (TextUtils.isEmpty(r6) == true) goto L9;
        String[] r3 = new PolarisFileWrapper(r8).list(new com.larksuite.framework.utils.k(FileUtils.n(r6), FileUtils.m(r6)));
        if (r3 == null) goto L9;
        r2.addAll(Arrays.asList(r3));
    L9:
        if (r2.size() == 0) goto L27;
        Collections.sort(r2);
        String r4 = FileUtils.n(r6);
        String r9 = FileUtils.m(r6);
        String r10 = FileUtils.n((String) ListProtector.get(r2, r2.size() - 1)).substring(r4.length());
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        int r11 = 0;
    L19:
        int r12 = r11 + 1;
        if (r12 != 0) goto L22;
        String r13 = BuildConfig.FLAVOR;
    L24:
        return r8 + r4 + r13 + r9;
    L22:
        r13 = "_" + r12;
        goto L24
    L13:
        if (TextUtils.isEmpty(r10) == true) goto L18;
        r11 = CastIntegerProtector.parseInt(r10.substring(1, r10.length()));     // Catch: Exception -> L16
        goto L19
    L27:
        return r8 + r6;
    }
}
