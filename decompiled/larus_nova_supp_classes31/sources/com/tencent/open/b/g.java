package com.tencent.open.b;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class g {
    public static void a(String r0) {
    }

    public static void a(String r0, List<Serializable> r1) {
    }

    public static void a() {
        Context r0 = com.tencent.open.utils.g.a();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.deleteDatabase("sdk_report.db");
    }

    public static List<Serializable> b(String r0) {
        return Collections.synchronizedList(new ArrayList());
    }
}
