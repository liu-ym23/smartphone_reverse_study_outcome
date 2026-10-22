package com.larus.bmhome.view.actionbar.custom;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface w2 {

    public static final class a {
        public static /* synthetic */ String a(w2 r10, String r11, com.larus.bmhome.actionbar.model.r r12, List r13, com.larus.bmhome.actionbar.model.p1 r14, fq8.e r15, int r16, com.larus.bmhome.instruction.f2 r17, int r18) {
            if ((r18 & 8) == 0) goto L5;
            com.larus.bmhome.actionbar.model.p1 r6 = null;
        L7:
            if ((r18 & 16) == 0) goto L9;
            fq8.e r7 = null;
        L11:
            if ((r18 & 32) == 0) goto L13;
            int r8 = -1;
        L15:
            if ((r18 & 64) == 0) goto L17;
            com.larus.bmhome.instruction.f2 r9 = null;
        L19:
            return r10.b(r11, r12, r13, r6, r7, r8, r9);
        L17:
            r9 = r17;
            goto L19
        L13:
            r8 = r16;
            goto L15
        L9:
            r7 = r15;
            goto L11
        L5:
            r6 = r14;
            goto L7
        }
    }

    String a(String r1);

    String b(String r1, com.larus.bmhome.actionbar.model.r r2, List<com.larus.bmhome.actionbar.model.u> r3, com.larus.bmhome.actionbar.model.p1 r4, fq8.e r5, int r6, com.larus.bmhome.instruction.f2 r7);

    String c();
}
