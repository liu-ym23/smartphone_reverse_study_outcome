package com.bytedance.crash.util;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class FdCollector {
    public FdCollector() {
    }

    public static List<String> collect() {
        return NativeTools.get().getFdListForAPM();
    }
}
