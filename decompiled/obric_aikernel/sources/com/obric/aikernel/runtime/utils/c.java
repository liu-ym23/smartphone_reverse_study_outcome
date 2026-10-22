package com.obric.aikernel.runtime.utils;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void a(c r10, String r11, String r12, int r13, int r14, Object r15) {
            if (r15 != null) goto L9;
            if ((r14 & 4) == 0) goto L6;
            r13 = 3;
        L6:
            r10.a(r11, r12, r13);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
    }

    void a(String r10, String r11, int r12);

    void aeeLog(int r10, String r11, String r12);

    void b(String r10, JSONObject r11);
}
