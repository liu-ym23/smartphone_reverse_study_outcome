package n38;

import com.larus.account.base.model.LoginPlatform;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface h {

    public static final class a {
        public static /* synthetic */ void b(h r1, LoginPlatform r2, String r3) {
            r1.b(r2, r3, Boolean.FALSE);
        }

        public static /* synthetic */ void a(h r12, LoginPlatform r13, int r14, String r15, String r16, String r17, Integer r19, String r110, Map r20, int r21) {
            if ((r21 & 32) == 0) goto L5;
            String r8 = null;
        L7:
            if ((r21 & 64) == 0) goto L9;
            Integer r9 = null;
        L11:
            if ((r21 & 128) == 0) goto L13;
            String r10 = null;
        L15:
            if ((r21 & 256) == 0) goto L17;
            Map r11 = null;
        L18:
            r12.a(r13, r14, r15, r16, r8, r9, r10, r11);
            return;
        L17:
            r11 = r20;
            goto L18
        L13:
            r10 = r110;
            goto L15
        L9:
            r9 = r19;
            goto L11
        L5:
            r8 = r17;
            goto L7
        }
    }

    void a(LoginPlatform r1, int r2, String r3, String r4, String r5, Integer r6, String r7, Map r8);

    void b(LoginPlatform r1, String r2, Boolean r3);
}
