package com.ss.android.lark.chat.base.model.dispatch;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r4) {
        if (r4 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r4.hashCode() + '_' + StringsKt.substringAfterLast$default(r4, ".", null, 2, null);
    }
}
