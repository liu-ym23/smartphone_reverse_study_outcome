package com.bytedance.ies.xelement.overlay;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f6490a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f6491b;

    static {
        f6490a = new ArrayList();
    }

    public static String a(String r5, a r10) {
        Intrinsics.checkNotNullParameter(r10, "dialog");
        if (r5 != null) goto L5;
        StringBuilder r11 = new StringBuilder("default_overlay_id_");
        int r12 = f6491b;
        f6491b = r12 + 1;
        r11.append(r12);
        r5 = r11.toString();
    L5:
        f6490a.add(0, new b(r5, r10));
        return r5;
    }
}
