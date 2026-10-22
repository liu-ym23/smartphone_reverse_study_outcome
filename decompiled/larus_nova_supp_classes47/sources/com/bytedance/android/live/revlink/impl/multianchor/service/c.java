package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void b(c r1, boolean r2, IBattleConfigSetting r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            r1.S6(r2, r3, null);
        }

        public static /* synthetic */ void a(c r0, int r1, int r2, String r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r1 = 0;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r2 = -1;
        L8:
            r0.Wm(r1, r2);
        }
    }

    void Bp();

    void Da();

    void Hb();

    void Md(JsonObject r1);

    void Ob();

    void S6(boolean r1, IBattleConfigSetting r2, p21.e r3);

    void U5(IBattleConfigSetting r1, p21.e r2);

    void Ul(int r1);

    void Wm(int r1, int r2);

    void eb(IBattleConfigSetting r1, com.bytedance.android.live.revlink.impl.pk.utils.l r2);

    void r6();

    void t8();
}
