package com.bytedance.android.live.broadcastgame.api.model;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static String a(int r2, String r3, r r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "title");
            if (r2 != InteractID.OpenGame.getValue()) goto L5;
        L38:
            StringBuilder r6 = new StringBuilder();
            r6.append(r2);
            r6.append('_');
            r6.append(r3);
            r6.append('_');
            if (r4 == null) goto L41;
            Long r7 = Long.valueOf(r4.p());
        L42:
            r6.append(r7);
            return r6.toString();
        L41:
            r7 = null;
            goto L42
        L5:
            if (r2 == InteractID.SonicMiniGame.getValue()) goto L38;
            if (r2 == InteractID.EffectGame.getValue()) goto L38;
            if (r2 == InteractID.Zhufen.getValue()) goto L38;
            if (r2 != InteractID.OpenMicroApp.getValue()) goto L18;
            if (r4 == null) goto L37;
            String r8 = r4.b();
            if (r8 == null) goto L37;
            return r8;
        L37:
            return "";
        L18:
            if (r2 != InteractID.InteractGamePlus.getValue()) goto L20;
        L33:
            JSONObject r9 = ln1.a.a.b(r5);
            if (r9 == null) goto L37;
            String r11 = JSONObjectProtectorUtils.getString(r9, OpenPlatformBaseDebugger.APP_ID);
            if (r11 == null) goto L37;
            return r11;
        L20:
            if (r2 == InteractID.InteractLoki.getValue()) goto L33;
            if (r2 == InteractID.InteractMiniApp.getValue()) goto L33;
            if (r2 != InteractID.OpenMicroGame.getValue()) goto L46;
            if (r4 == null) goto L37;
            c0 r12 = r4.x();
            if (r12 == null) goto L37;
            String r13 = r12.gameId;
            if (r13 == null) goto L37;
            return r13;
        L46:
            return r2 + '_' + r3;
        }
    }

    static {
    }
}
