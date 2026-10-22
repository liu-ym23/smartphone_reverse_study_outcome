package com.ss.android.lark.forsetiutils.leak;

import androidx.fragment.app.Fragment;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final Map<String, WeakReference<Fragment>> a = null;
    public static final Map<String, Long> b = null;

    static {
        a = new LinkedHashMap();
        new ReferenceQueue();
        b = new LinkedHashMap();
    }
}
