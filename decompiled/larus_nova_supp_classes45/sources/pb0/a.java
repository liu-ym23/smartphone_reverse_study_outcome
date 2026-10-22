package pb0;

import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.core.utils.statusbar.RomUtils;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {

    /* JADX INFO: renamed from: pb0.a$a, reason: collision with other inner class name */
    public static final class C0261a {
        public static /* synthetic */ void b(a r8, String r9, String r11, String r12, String r13, String r14, int r15) {
            if ((r15 & 2) == 0) goto L5;
            String r4 = "";
        L7:
            if ((r15 & 4) == 0) goto L9;
            String r5 = "";
        L11:
            if ((r15 & 8) == 0) goto L13;
            r13 = null;
        L13:
            String r6 = r13;
            if ((r15 & 16) == 0) goto L16;
            r14 = "0";
        L16:
            r8.j(r9, r4, r5, r6, r14);
            return;
        L9:
            r5 = r12;
            goto L11
        L5:
            r4 = r11;
            goto L7
        }

        public static /* synthetic */ void a(a r23, String r24, String r25, String r26, String r27, String r28, String r29, long r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, Boolean r39, Boolean r41, MusicPanel r42, int r43) {
            if ((r43 & 8) == 0) goto L5;
            String r7 = "";
        L7:
            if ((r43 & 16) == 0) goto L9;
            String r8 = "";
        L11:
            if ((r43 & 32) == 0) goto L13;
            String r9 = "";
        L15:
            if ((r43 & 64) == 0) goto L17;
            long r11 = 0;
        L19:
            if ((r43 & 128) == 0) goto L21;
            String r12 = "";
        L23:
            if ((r43 & 256) == 0) goto L25;
            String r13 = "";
        L27:
            if ((r43 & 512) == 0) goto L29;
            String r14 = "";
        L31:
            if ((r43 & RomUtils.SZ) == 0) goto L33;
            String r15 = "";
        L35:
            if ((r43 & 4096) == 0) goto L37;
            String r17 = null;
        L39:
            if ((r43 & IESStatusBarUtil.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) == 0) goto L41;
            String r18 = null;
        L43:
            if ((r43 & 16384) == 0) goto L45;
            String r19 = null;
        L47:
            if ((32768 & r43) == 0) goto L49;
            Boolean r21 = null;
        L51:
            if ((r43 & 65536) == 0) goto L53;
            Boolean r22 = null;
        L54:
            r23.o(r24, r25, r26, r7, r8, r9, r11, r12, r13, r14, r15, null, r17, r18, r19, r21, r22, r42);
            return;
        L53:
            r22 = r41;
            goto L54
        L49:
            r21 = r39;
            goto L51
        L45:
            r19 = r38;
            goto L47
        L41:
            r18 = r37;
            goto L43
        L37:
            r17 = r36;
            goto L39
        L33:
            r15 = r35;
            goto L35
        L29:
            r14 = r34;
            goto L31
        L25:
            r13 = r33;
            goto L27
        L21:
            r12 = r32;
            goto L23
        L17:
            r11 = r31;
            goto L19
        L13:
            r9 = r29;
            goto L15
        L9:
            r8 = r28;
            goto L11
        L5:
            r7 = r27;
            goto L7
        }
    }

    void a();

    void b(String r1, String r2, boolean r3, String r4, String r5, String r6, String r7, String r8, String r9);

    void c(String r1, String r2);

    void d(String r1, long r2, String r4, String r5, String r6, long r7, boolean r9, String r11, int r12, int r13, String r14, Boolean r15);

    void e(String r1, String r2, Boolean r3, Boolean r4, String r5, String r6, String r7, Boolean r8);

    void f(MusicPanel r1, String r2, String r3, String r4, long r5, String r7, boolean r8, String r9, String r11, HashMap<String, String> r12, String r13, String r14, Integer r15, String r16, String r17, Boolean r18);

    void g(String r1, Throwable r2);

    void h(String r1, String r2, boolean r3);

    void i(String r1, String r2, String r3, boolean r4, boolean r5);

    void j(String r1, String r2, String r3, String r4, String r5);

    void k(String r1, String r2);

    void l(String r1, String r2, String r3, String r4);

    void m(int r1, s r2);

    void n(String r1, String r2);

    void o(String r1, String r2, String r3, String r4, String r5, String r6, long r7, String r9, String r11, String r12, String r13, HashMap<String, String> r14, String r15, String r16, String r17, Boolean r18, Boolean r19, MusicPanel r110);

    void p(String r1, String r2, String r3, String r4);

    void q(String r1, String r2, String r3, String r4, String r5, String r6, String r7);

    void r(String r1, String r2, String r3, String r4);

    void s(int r1, s r2);

    void t(MusicPanel r1, String r2, String r3, HashMap<String, String> r4, String r5);

    void u(String r1);

    void v(String r1, String r2, String r3, long r4, String r6, String r7, Integer r8, String r9, String r11);

    void w(boolean r1);
}
