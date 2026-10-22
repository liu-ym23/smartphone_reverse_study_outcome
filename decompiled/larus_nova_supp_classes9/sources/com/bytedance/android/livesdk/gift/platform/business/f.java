package com.bytedance.android.livesdk.gift.platform.business;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ boolean a(f r2, AbsPanel r3) {
            return r2.x(r3, SelectedStatus.CLICK, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean b(f r16, AbsPanel r17, int r18, IBaseUser r19, boolean r20, List r21, n r23, com.bytedance.android.livesdk.gift.platform.core.model.k r24, com.bytedance.android.livesdk.gift.platform.core.model.k r25, l1 r26, com.bytedance.android.livesdk.gift.model.n r27, String r28, com.bytedance.android.livesdk.gift.platform.core.model.a r29, int r210) {
            if ((r210 & 16) == 0) goto L5;
            boolean r5 = false;
        L7:
            if ((r210 & 32) == 0) goto L9;
            List r6 = null;
        L11:
            if ((r210 & 128) == 0) goto L13;
            n r8 = new n(null, null, 7);
        L15:
            if ((r210 & 256) == 0) goto L17;
            com.bytedance.android.livesdk.gift.platform.core.model.k r9 = null;
        L19:
            if ((r210 & 512) == 0) goto L21;
            com.bytedance.android.livesdk.gift.platform.core.model.k r10 = null;
        L23:
            if ((r210 & 1024) == 0) goto L25;
            l1 r11 = null;
        L27:
            if ((r210 & 2048) == 0) goto L29;
            com.bytedance.android.livesdk.gift.model.n r13 = null;
        L31:
            if ((r210 & 16384) == 0) goto L33;
            com.bytedance.android.livesdk.gift.platform.core.model.a r15 = null;
        L35:
            return r16.A(r17, r18, 0, r19, r5, r6, false, r8, r9, r10, r11, r13, null, r28, r15);
        L33:
            r15 = r29;
            goto L35
        L29:
            r13 = r27;
            goto L31
        L25:
            r11 = r26;
            goto L27
        L21:
            r10 = r25;
            goto L23
        L17:
            r9 = r24;
            goto L19
        L13:
            r8 = r23;
            goto L15
        L9:
            r6 = r21;
            goto L11
        L5:
            r5 = r20;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean c(f r19, AbsPanel r20, int r21, int r23, IBaseUser r24, boolean r25, List r26, n r27, l1 r28, com.bytedance.android.livesdk.gift.model.n r29, String r210, int r30, String r31, com.bytedance.android.livesdk.gift.platform.core.model.a r33, int r34) {
            if ((r34 & 16) == 0) goto L5;
            boolean r8 = false;
        L7:
            if ((r34 & 32) == 0) goto L9;
            List r9 = null;
        L11:
            if ((r34 & 64) == 0) goto L13;
            n r10 = new n(null, null, 7);
        L15:
            if ((r34 & 512) == 0) goto L17;
            l1 r13 = null;
        L19:
            if ((r34 & 1024) == 0) goto L21;
            com.bytedance.android.livesdk.gift.model.n r14 = null;
        L23:
            if ((r34 & 2048) == 0) goto L25;
            String r15 = null;
        L27:
            if ((r34 & 4096) == 0) goto L29;
            int r16 = 0;
        L31:
            if ((r34 & 8192) == 0) goto L33;
            String r17 = null;
        L35:
            if ((r34 & 16384) == 0) goto L37;
            com.bytedance.android.livesdk.gift.platform.core.model.a r18 = null;
        L39:
            return r19.o(r20, r21, r23, r24, r8, r9, r10, null, null, r13, r14, r15, r16, r17, r18);
        L37:
            r18 = r33;
            goto L39
        L33:
            r17 = r31;
            goto L35
        L29:
            r16 = r30;
            goto L31
        L25:
            r15 = r210;
            goto L27
        L21:
            r14 = r29;
            goto L23
        L17:
            r13 = r28;
            goto L19
        L13:
            r10 = r27;
            goto L15
        L9:
            r9 = r26;
            goto L11
        L5:
            r8 = r25;
            goto L7
        }
    }

    boolean A(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, boolean r7, n r8, com.bytedance.android.livesdk.gift.platform.core.model.k r9, com.bytedance.android.livesdk.gift.platform.core.model.k r10, l1 r11, com.bytedance.android.livesdk.gift.model.n r13, String r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16);

    void c();

    void d(AbsPanel r1);

    void h();

    void i(h1 r1);

    void j(long r1, Integer r3);

    void n();

    boolean o(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, n r7, com.bytedance.android.livesdk.gift.platform.core.model.k r8, com.bytedance.android.livesdk.gift.platform.core.model.k r9, l1 r10, com.bytedance.android.livesdk.gift.model.n r11, String r13, int r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16);

    void q();

    void s();

    boolean x(AbsPanel<?> r1, SelectedStatus r2, Integer r3);

    void y(p2 r1);
}
