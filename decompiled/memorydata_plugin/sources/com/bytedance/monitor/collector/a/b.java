package com.bytedance.monitor.collector.a;

import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Set<Integer> f2832a;

    static {
        HashSet r0 = new HashSet();
        f2832a = r0;
        r0.add(114);
        f2832a.add(115);
        f2832a.add(116);
        f2832a.add(121);
        f2832a.add(122);
        f2832a.add(123);
    }

    public static boolean a(Message r1) {
        return f2832a.contains(Integer.valueOf(r1.what));
    }
}
