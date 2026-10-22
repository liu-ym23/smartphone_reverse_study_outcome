package com.bytedance.librarian;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Context f2803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile String f2804b;
    static c c;
    private static final Object d = null;

    static {
        d = new Object();
    }

    public static void a(String r2, Context r3) {
        a(r2, false, true, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    private static void a(String r2, boolean r3, boolean r4, Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r4 == true) goto L5;
    L7:
        b r7 = b.f2814a;
        if (r7 == null) goto L10;
        r7.a(r2, r3);
        return;
    L10:
        c r8 = c;
        if (r8 == null) goto L13;
        r8.c(r2);
        return;
    L13:
        System.loadLibrary(r2);
        return;
    L5:
        if (f2803a != null) goto L7;
        f2803a = r6;
        goto L7
    }
}
