package com.larus.platform.api;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface d0 {

    public static final class a {
        public static /* synthetic */ void a(Context r8, String r9, by7.e r10, String r11, String r12, String r13, int r14) {
            com.larus.platform.service.u r0 = com.larus.platform.service.u.a;
            if ((r14 & 8) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r14 & 16) == 0) goto L9;
            String r5 = null;
        L11:
            if ((r14 & 32) == 0) goto L13;
            String r6 = null;
        L14:
            r0.b(r8, r9, r10, r4, r5, r6, null);
            return;
        L13:
            r6 = r13;
            goto L14
        L9:
            r5 = r12;
            goto L11
        L5:
            r4 = r11;
            goto L7
        }
    }

    void b(Context r1, String r2, by7.e r3, String r4, String r5, String r6, String r7);

    void c(Fragment r1, View r2, String r3, by7.e r4);

    void d();
}
