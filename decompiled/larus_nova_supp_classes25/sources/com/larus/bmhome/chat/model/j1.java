package com.larus.bmhome.chat.model;

import com.larus.im.bean.message.UplinkFileEntity;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface j1 {

    public static final class a {
        public static /* synthetic */ boolean b(j1 r9, List r10, boolean r11, boolean r12, String r13, String r14, Long r15, int r16) {
            if ((r16 & 2) == 0) goto L5;
            boolean r4 = false;
        L7:
            if ((r16 & 4) == 0) goto L9;
            boolean r5 = false;
        L11:
            if ((r16 & 8) == 0) goto L13;
            String r6 = null;
        L15:
            if ((r16 & 16) == 0) goto L17;
            String r7 = null;
        L19:
            if ((r16 & 32) == 0) goto L21;
            Long r8 = null;
        L23:
            return r9.s(r10, r4, r5, r6, r7, r8);
        L21:
            r8 = r15;
            goto L23
        L17:
            r7 = r14;
            goto L19
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

        public static /* synthetic */ boolean c(j1 r7, String r8, String r9, boolean r10, Long r11, String r12, String r13, int r14) {
            if ((r14 & 1) == 0) goto L5;
            r8 = "";
        L5:
            String r1 = r8;
            if ((r14 & 4) == 0) goto L8;
            boolean r3 = false;
        L10:
            if ((r14 & 8) == 0) goto L12;
            Long r4 = null;
        L14:
            if ((r14 & 16) == 0) goto L16;
            String r5 = null;
        L18:
            if ((r14 & 32) == 0) goto L20;
            String r6 = null;
        L22:
            return r7.g(r1, r9, r3, r4, r5, r6);
        L20:
            r6 = r13;
            goto L22
        L16:
            r5 = r12;
            goto L18
        L12:
            r4 = r11;
            goto L14
        L8:
            r3 = r10;
            goto L10
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean a(j1 r13, String r14, UplinkFileEntity r15, List r16, boolean r17, boolean r18, String r19, String r20, Long r21, String r22, int r23) {
            if ((r23 & 2) == 0) goto L5;
            UplinkFileEntity r5 = null;
        L7:
            if ((r23 & 4) == 0) goto L9;
            List r6 = null;
        L11:
            if ((r23 & 8) == 0) goto L13;
            boolean r7 = false;
        L15:
            if ((r23 & 16) == 0) goto L17;
            boolean r8 = false;
        L19:
            if ((r23 & 32) == 0) goto L21;
            String r9 = null;
        L23:
            if ((r23 & 64) == 0) goto L25;
            String r10 = null;
        L27:
            if ((r23 & 128) == 0) goto L29;
            Long r11 = null;
        L31:
            if ((r23 & 256) == 0) goto L33;
            String r12 = null;
        L35:
            return r13.e(r14, r5, r6, r7, r8, r9, r10, r11, r12);
        L33:
            r12 = r22;
            goto L35
        L29:
            r11 = r21;
            goto L31
        L25:
            r10 = r20;
            goto L27
        L21:
            r9 = r19;
            goto L23
        L17:
            r8 = r18;
            goto L19
        L13:
            r7 = r17;
            goto L15
        L9:
            r6 = r16;
            goto L11
        L5:
            r5 = r15;
            goto L7
        }
    }

    int a();

    void b(boolean r1);

    void c(String r1, String r2, Long r3);

    ChatDraftItem d();

    boolean e(String r1, UplinkFileEntity r2, List<UplinkFileEntity> r3, boolean r4, boolean r5, String r6, String r7, Long r8, String r9);

    ChatDraftItem f();

    boolean g(String r1, String r2, boolean r3, Long r4, String r5, String r6);

    void h();

    void i();

    void j(List<String> r1);

    void k(List<String> r1);

    void l(String r1);

    ChatDraftItem m();

    void n();

    List<String> o();

    boolean p();

    void q();

    List<String> r();

    boolean s(List<ChatDraftItem> r1, boolean r2, boolean r3, String r4, String r5, Long r6);

    void t(String r1, String r2);

    boolean u(ChatDraftItem r1);
}
