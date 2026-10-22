package com.ss.android.lark.officewebview.util;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m {
    public final ConcurrentHashMap<String, Long> a;

    public m() {
        this.a = new ConcurrentHashMap();
    }

    public final void a(String r2, long r3) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.a.put(r2, Long.valueOf(r3));
        return;
    }
}
