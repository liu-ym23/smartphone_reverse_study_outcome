package com.larus.platform.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface b3 {

    public static final class a {
        public static /* synthetic */ void a(View r6, int r7, String r8, String r9, String r10, int r11) {
            com.larus.platform.service.z1 r0 = com.larus.platform.service.z1.a;
            if ((r11 & 4) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r11 & 8) == 0) goto L9;
            String r4 = null;
        L11:
            if ((r11 & 16) == 0) goto L13;
            String r5 = null;
        L14:
            r0.g(r6, r7, r3, r4, r5);
            return;
        L13:
            r5 = r10;
            goto L14
        L9:
            r4 = r9;
            goto L11
        L5:
            r3 = r8;
            goto L7
        }

        public static /* synthetic */ void b(Fragment r10, String r11, String r12, String r13, String r14, String r15, boolean r16, String r17, int r18) {
            com.larus.platform.service.z1 r1 = com.larus.platform.service.z1.a;
            if ((r18 & 4) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r18 & 8) == 0) goto L9;
            String r5 = null;
        L11:
            if ((r18 & 16) == 0) goto L13;
            String r6 = null;
        L15:
            if ((r18 & 32) == 0) goto L17;
            String r7 = null;
        L19:
            if ((r18 & 64) == 0) goto L21;
            boolean r8 = false;
        L23:
            if ((r18 & 128) == 0) goto L25;
            String r9 = null;
        L26:
            r1.h(r10, r11, r4, r5, r6, r7, r8, r9);
            return;
        L25:
            r9 = r17;
            goto L26
        L21:
            r8 = r16;
            goto L23
        L17:
            r7 = r15;
            goto L19
        L13:
            r6 = r14;
            goto L15
        L9:
            r5 = r13;
            goto L11
        L5:
            r4 = r12;
            goto L7
        }
    }

    boolean a(Bundle r1, Bundle r2, int r3);

    void b(Fragment r1, String r2);

    void c(Activity r1);

    boolean d();

    boolean e(Fragment r1, boolean r2);

    boolean f(Context r1, Bundle r2);

    void g(View r1, int r2, String r3, String r4, String r5);

    void h(Fragment r1, String r2, String r3, String r4, String r5, String r6, boolean r7, String r8);
}
