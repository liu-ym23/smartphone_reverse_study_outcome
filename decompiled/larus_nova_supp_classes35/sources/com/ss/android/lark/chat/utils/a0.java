package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a0 {
    static {
    }

    @JvmStatic
    public static final String b(HashMap<String, String> r9) {
        if (r9 != null) goto L5;
        return BuildConfig.FLAVOR;
    L5:
        Locale r0 = ChatCoreModule.a().getLanguageDependency().getCacheLanguageSetting();
        String r1 = StringsKt.replace$default(new Locale(r0.getLanguage(), r0.getCountry()).toLanguageTag(), "-", "_", false, 4, null).toLowerCase(Locale.getDefault());
        if (TextUtils.isEmpty(a(r9, r1)) == true) goto L9;
        return a(r9, r1);
    L9:
        return a(r9, "en_us");
    }

    public static String a(HashMap r3, String r4) {
        Iterator r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) r5.next();
        if (Intrinsics.areEqual(((String) r0.getKey()).toLowerCase(Locale.getDefault()), r4) == false) goto L4;
        return (String) r0.getValue();
    L9:
        return BuildConfig.FLAVOR;
    }
}
