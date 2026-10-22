package com.ss.android.lark.movable.preview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final ConcurrentHashMap<String, String> a = null;
    public static final AtomicInteger b = null;

    static {
        a = new ConcurrentHashMap();
        b = new AtomicInteger(0);
    }

    @JvmStatic
    public static final boolean a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    L3:
        if (r2 == null) goto L15;
        if ((r2 instanceof MovablePreviewActivity) == true) goto L6;
        if ((r2 instanceof ContextWrapper) == false) goto L11;
        ContextWrapper r3 = (ContextWrapper) r2;
    L12:
        if (r3 != null) goto L13;
        r2 = null;
        goto L3
    L13:
        r2 = r3.getBaseContext();
        goto L3
    L11:
        r3 = null;
        goto L12
    L6:
        return true;
    L15:
        return false;
    }

    public static void b(Context r2, int r3, String r4, int r5) {
        Intent r0 = new Intent(r2, MovablePreviewActivity.class);
        if ((r2 instanceof Activity) == true) goto L5;
        r0.addFlags(268435456);
    L5:
        r0.putExtra("key:movable:preview:type", r3);
        String r6 = "movable_md_" + b.incrementAndGet();
        a.put(r6, r4);
        r0.putExtra("key:movable:preview:markdown:key", r6);
        r0.putExtra("key:movable:source:instance:id", r5);
        r2.startActivity(r0);
    }
}
