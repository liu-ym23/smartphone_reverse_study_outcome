package com.ss.android.lark.filedetail.impl.folder.manage.service;

import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExtractConfig {
    public static FileConfigValue a;

    static {
        a = new FileConfigValue(null, 1, null);
        SettingManager.getInstance().get(FileConfigValue.class, new AnonymousClass1());
    }

    public static boolean a(long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "fileName");
        if (r4 <= a.getExtractConfig().getMaxExtractSize()) goto L5;
        return false;
    L5:
        String r5 = FileUtils.m(r6);
        if (r5 != null) goto L8;
    L11:
        return false;
    L8:
        if (r5.length() <= 1) goto L11;
        String r7 = r5.substring(1);
        return a.getExtractConfig().getSupportedFormat().contains(r7);
    }
}
