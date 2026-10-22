package com.bytedance.dataplatform.a;

import com.bytedance.dataplatform.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f2245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Set<String> f2246b;
    private static boolean c;
    private static boolean d;

    static {
        f2246b = new HashSet();
    }

    static /* synthetic */ Set a() {
        return f2246b;
    }

    public static void a(b r2, boolean r3, boolean r4) {
        f2245a = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        d = r4;
        c = r3;
    }

    public static void a(final String r1, final String r2) {
        if (c == true) goto L5;
        return;
    L5:
        l.a(new AnonymousClass1(r1, r2));
    }

    static /* synthetic */ void a(String r0, JSONObject r1) {
        b(r0, r1);
    }

    private static void b(String r1, JSONObject r2) {
        b r0 = f2245a;
        if (r0 == null) goto L6;
        r0.onEventV3(r1, r2);
        return;
    }
}
