package com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view.a$a, reason: collision with other inner class name */
    public static final class C0006a {
        public static /* synthetic */ void a(a r8, String r9, String r10, String r11, String r12, int r13, int r14) {
            if ((r14 & 2) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r14 & 4) == 0) goto L9;
            String r5 = null;
        L11:
            if ((r14 & 8) == 0) goto L13;
            String r6 = null;
        L15:
            if ((r14 & 16) == 0) goto L17;
            int r7 = -1;
        L18:
            r8.b(r9, r4, r5, r6, r7);
            return;
        L17:
            r7 = r13;
            goto L18
        L13:
            r6 = r12;
            goto L15
        L9:
            r5 = r11;
            goto L11
        L5:
            r4 = r10;
            goto L7
        }
    }

    void a();

    void b(String r1, String r2, String r3, String r4, int r5);

    void c(String r1, String r2, String r3, String r4, int r5, Boolean r6, Long r7);
}
