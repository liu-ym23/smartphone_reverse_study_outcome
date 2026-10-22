package com.larksuite.framework.utils;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k implements FilenameFilter {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public k(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r4, String r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (new PolarisFileWrapper(r5).isDirectory() == false) goto L8;
        return false;
    L8:
        String r0 = this.a;
        String r1 = this.b;
        String r2 = FileUtils.m(r5);
        String r6 = FileUtils.n(r5);
        if (TextUtils.equals(r2, r1) == true) goto L12;
        return false;
    L12:
        if (r6.startsWith(r0) == false) goto L21;
        String r7 = r6.substring(r0.length());
        if (TextUtils.isEmpty(r7) == false) goto L19;
        return true;
    L19:
        return PatternProtector.compile("^_\\d+?$").matcher(r7).find();
    L21:
        return false;
    }
}
