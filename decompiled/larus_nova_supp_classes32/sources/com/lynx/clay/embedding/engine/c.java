package com.lynx.clay.embedding.engine;

import android.content.Context;
import com.lynx.clay.embedding.engine.loader.FlutterLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final Map<String, c> b = null;
    public final List<FlutterEngine> a;

    static {
        b = new HashMap();
    }

    public c(Context r4, String[] r5) {
        this.a = new ArrayList();
        FlutterLoader r0 = c5a.b.a().a;
        if (r0.a == true) goto L6;
        r0.e(r4.getApplicationContext(), new FlutterLoader.c());
        r0.a(r4, r5);
        return;
    }
}
