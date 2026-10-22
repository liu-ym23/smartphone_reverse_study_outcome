package com.bytedance.android.live.revlink.impl.service.internal;

import com.bytedance.android.live.revlink.impl.control.launchcontext.RevLinkSwitchExtraContext;
import com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r1, int r2, boolean r3, int r4) {
            if ((r4 & 2) == 0) goto L5;
            r3 = false;
        L5:
            r1.ui(r2, r3, false);
        }
    }

    void Ak(String r1);

    void Gp(int r1, RevLinkSwitchExtraContext r2);

    void Pg();

    void Rg(String r1);

    void Sa();

    int Wp();

    boolean dc();

    int getCurrentMode();

    JSONObject hn(List<String> r1);

    boolean k0(int r1);

    void m();

    void onMultiAnchorStateChange(int r1);

    void onPrecisionMatchEvent(int r1);

    void startSwitchPk(g r1);

    void tn(Function0<Unit> r1, String r2, boolean r3);

    void ui(int r1, boolean r2, boolean r3);
}
