package com.ss.android.lark.passport.flow.mfa;

import com.alibaba.fastjson.JSONObject;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n {
    public static final List<String> a = null;

    static {
        a = CollectionsKt.listOf(new String[]{"uri", "auth_url", "url", "web_url", "redirect_url"});
    }

    public static final String a(JSONObject r4) {
        Iterator<T> r0 = a.iterator();
    L3:
        String r2 = null;
        if (r0.hasNext() == false) goto L11;
        String r1 = r4.getString((String) r0.next());
        if (r1 == null) goto L10;
        if ((!StringsKt.isBlank(r1)) == false) goto L10;
        r2 = r1;
    L10:
        if (r2 == null) goto L3;
    L11:
        return r2;
    }
}
