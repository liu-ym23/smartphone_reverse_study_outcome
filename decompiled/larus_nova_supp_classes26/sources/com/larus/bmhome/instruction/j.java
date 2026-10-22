package com.larus.bmhome.instruction;

import android.content.Context;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface j {

    public static final class a {
        public static /* synthetic */ com.larus.bmhome.actionbar.model.r a(Integer r6, String r7, com.larus.bmhome.view.actionbar.edit.b r8, com.larus.bmhome.actionbar.model.r r9) {
            return c2.a.e(r6, r7, r8, r9, 0);
        }

        public static /* synthetic */ com.larus.bmhome.actionbar.model.r b(Integer r6, String r7, List r8, com.larus.bmhome.actionbar.model.r r9) {
            return c2.a.a(r6, r7, r8, r9, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Map c(j r7, String r8, String r9, String r10, boolean r11, Map r12, Long r13, int r14) {
            if ((r14 & 8) == 0) goto L5;
            boolean r4 = false;
        L7:
            if ((r14 & 16) == 0) goto L9;
            Map r5 = null;
        L11:
            if ((r14 & 32) == 0) goto L13;
            Long r6 = null;
        L15:
            return r7.b(r8, r9, r10, r4, r5, r6);
        L13:
            r6 = r13;
            goto L15
        L9:
            r5 = r12;
            goto L11
        L5:
            r4 = r11;
            goto L7
        }
    }

    com.larus.bmhome.actionbar.model.r a(Integer r1, String r2, List<com.larus.bmhome.actionbar.model.u> r3, com.larus.bmhome.actionbar.model.r r4, int r5);

    Map<String, String> b(String r1, String r2, String r3, boolean r4, Map<String, String> r5, Long r6);

    com.larus.bmhome.actionbar.model.r c(String r1, com.larus.bmhome.actionbar.model.r r2, com.larus.bmhome.view.actionbar.edit.c r3, com.larus.bmhome.view.actionbar.edit.b r4, com.larus.bmhome.actionbar.model.p1 r5, fq8.e r6);

    boolean d(Context r1, String r2, boolean r3, com.larus.bmhome.view.actionbar.edit.c r4, Integer r5);

    com.larus.bmhome.actionbar.model.r e(Integer r1, String r2, com.larus.bmhome.view.actionbar.edit.b r3, com.larus.bmhome.actionbar.model.r r4, int r5);

    String f(String r1, com.larus.bmhome.view.actionbar.edit.c r2, com.larus.bmhome.view.actionbar.edit.b r3, com.larus.bmhome.actionbar.model.p1 r4, fq8.e r5, f2 r6);
}
