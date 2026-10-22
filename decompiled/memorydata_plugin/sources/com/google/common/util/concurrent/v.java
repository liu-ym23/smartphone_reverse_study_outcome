package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class v {
    static void a(Throwable r1) {
        com.google.common.base.n.a(r1);
        if (ZeusTransformUtils.instanceOf(r1, InterruptedException.class) == false) goto L6;
        Thread.currentThread().interrupt();
        return;
    }
}
