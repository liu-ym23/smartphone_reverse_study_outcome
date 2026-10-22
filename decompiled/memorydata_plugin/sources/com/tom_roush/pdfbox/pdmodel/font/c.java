package com.tom_roush.pdfbox.pdmodel.font;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, com.tom_roush.fontbox.c.b> f16225a = null;

    static {
        f16225a = new ConcurrentHashMap();
    }

    public static com.tom_roush.fontbox.c.b a(InputStream r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new com.tom_roush.fontbox.c.c(true).a(r2);
    }

    public static com.tom_roush.fontbox.c.b a(String r4) {
        Map<String, com.tom_roush.fontbox.c.b> r0 = f16225a;
        com.tom_roush.fontbox.c.b r1 = (com.tom_roush.fontbox.c.b) ZeusTransformUtils.preCheckCast(r0.get(r4), com.tom_roush.fontbox.c.b.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        com.tom_roush.fontbox.c.b r5 = new com.tom_roush.fontbox.c.c().a(r4);
        r0.put(r5.d(), r5);
        return r5;
    }
}
