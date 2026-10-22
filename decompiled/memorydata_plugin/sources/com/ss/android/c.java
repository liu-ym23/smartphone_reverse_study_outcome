package com.ss.android;

import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f15020a;

    public interface a {
        void a(String r1, String r2);
    }

    public static void a(String r1, String r2) {
        a r0 = f15020a;
        if (r0 == null) goto L5;
        r0.a(r1, r2);
        return;
    L5:
        Logger.d(r1, r2);
    }
}
