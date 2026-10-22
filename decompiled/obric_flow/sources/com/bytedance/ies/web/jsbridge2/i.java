package com.bytedance.ies.web.jsbridge2;

import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public interface i {
    void a(int r5, String r10);

    default void b(int r5, String r10) {
        a(r5, r10);
    }

    void c(String r5, z r10);

    default void d(String r5, String r10, int r11, String r12, z r13) {
        b(r11, r10);
    }
}
