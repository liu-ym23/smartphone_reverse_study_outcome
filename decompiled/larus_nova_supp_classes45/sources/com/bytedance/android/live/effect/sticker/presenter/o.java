package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface o {

    public static final class a {
        public static /* synthetic */ int d(o r1, String r2) {
            return r1.j(r2, "");
        }

        public static /* synthetic */ void b(o r8, String r9, String r11, com.bytedance.android.live.effect.api.k.e r12) {
            r8.e(r9, r11, 0, 0, "0", null, r12);
        }

        public static /* synthetic */ void a(o r7, String r8, com.bytedance.android.live.effect.api.k.i r9, boolean r11, boolean r12, boolean r13, int r14) {
            if ((r14 & 2) == 0) goto L5;
            r9 = null;
        L5:
            com.bytedance.android.live.effect.api.k.i r2 = r9;
            if ((r14 & 4) == 0) goto L8;
            boolean r3 = true;
        L10:
            if ((r14 & 8) == 0) goto L12;
            boolean r4 = true;
        L14:
            if ((r14 & 32) == 0) goto L16;
            boolean r6 = false;
        L17:
            r7.a(r8, r2, r3, r4, false, r6);
            return;
        L16:
            r6 = r13;
            goto L17
        L12:
            r4 = r12;
            goto L14
        L8:
            r3 = r11;
            goto L10
        }

        public static /* synthetic */ void c(o r9, String r11, String r12, int r13, boolean r14, com.bytedance.android.live.effect.api.k.d r15, boolean r16, int r17) {
            if ((r17 & 4) == 0) goto L5;
            String r3 = "";
        L7:
            if ((r17 & 32) == 0) goto L9;
            boolean r6 = false;
        L11:
            if ((r17 & 64) == 0) goto L13;
            com.bytedance.android.live.effect.api.k.d r7 = null;
        L15:
            if ((r17 & 128) == 0) goto L17;
            boolean r8 = false;
        L18:
            r9.n(r11, false, r3, r13, 0, r6, r7, r8);
            return;
        L17:
            r8 = r16;
            goto L18
        L13:
            r7 = r15;
            goto L15
        L9:
            r6 = r14;
            goto L11
        L5:
            r3 = r12;
            goto L7
        }
    }

    public interface b {
        void a(boolean r1);
    }

    public interface c {
        void a(Sticker r1);

        void b();

        void onDownloadStart();
    }

    public interface d {
        void a(PanelInfoModel r1);
    }

    void a(String r1, com.bytedance.android.live.effect.api.k.i r2, boolean r3, boolean r4, boolean r5, boolean r6);

    boolean b(String r1);

    List<Effect> c(String r1);

    void d(String r1, String r2, Sticker r3);

    void e(String r1, String r2, int r3, int r4, String r5, Map r6, com.bytedance.android.live.effect.api.k.e r7);

    void f(String r1, com.bytedance.android.live.effect.api.k.d r2);

    void g(Sticker r1, boolean r2, b r3);

    void h(String r1, Sticker r2, com.bytedance.android.live.effect.sticker.chain.b.C0190b r3);

    EffectCategoryModel i(String r1, PanelInfoModel r2);

    int j(String r1, String r2);

    void k(String r1, String r2, int r3, com.bytedance.android.live.effect.api.k.a r4);

    void l(String r1, List<? extends Effect> r2);

    int m(String r1);

    void n(String r1, boolean r2, String r3, int r4, int r5, boolean r6, com.bytedance.android.live.effect.api.k.d r7, boolean r8);

    void o(String r1, String r2, com.bytedance.android.live.effect.api.k.b r3);

    void p(String r1, String r2, List<Integer> r3, boolean r4, com.bytedance.android.live.effect.api.k.c r5);
}
