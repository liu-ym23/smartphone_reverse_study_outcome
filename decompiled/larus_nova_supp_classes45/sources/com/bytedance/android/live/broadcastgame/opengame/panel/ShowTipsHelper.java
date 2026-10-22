package com.bytedance.android.live.broadcastgame.opengame.panel;

import am2.x;
import android.content.SharedPreferences;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.utils.m;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.config.re0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ShowTipsHelper {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public k d;
    public boolean e;
    public boolean f;
    public l g;
    public final PluginContext h;
    public final Function0<Boolean> i;
    public final Function0<Unit> j;

    public final void a() {
        MainThreadPostUtils.d(this.d);
        PluginContext r0 = this.h;
        if (r0 == null) goto L7;
        DataCenter r1 = r0.i;
        if (r1 == null) goto L7;
        r1.removeObserver(this.g);
    L7:
        this.f = false;
    }

    public final void b() {
        int r0 = m.a;
        if (((Boolean) re0.a.getValue()).booleanValue() == false) goto L47;
        PluginContext r1 = this.h;
        if (r1 != null) goto L9;
        return;
    L9:
        if (this.f == false) goto L12;
        return;
    L12:
        if (r1.o == false) goto L14;
        return;
    L14:
        if (r1.m.c == false) goto L17;
        return;
    L17:
        if (v5.b().getBoolean("live.key.AUDIENCE_HAS_COLLECTED_V2", false) == true) goto L51;
        int r2 = v5.b().getInt("live.key.SHOW_START_GAME_TIP_COUNT", 0);
        if (r2 < 10) goto L23;
        return;
    L23:
        if (r1.m.e == false) goto L53;
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = "default";
        this.f = true;
        String r5 = r1.m.i;
        this.d = new k(this, r3, r5, r2);
        this.g = new l(this, r5, r3);
        if (((SharedPreferences) this.a.getValue()).contains(r5) == false) goto L28;
        r3.element = "launch_again";
        long r4 = 3000;
    L41:
        DataCenter r6 = r1.i;
        if (r6 == null) goto L44;
        r6.observe("key_live_game_pay_success", this.g, false);
    L44:
        MainThreadPostUtils.c(this.d, r4);
        ((SharedPreferences) this.a.getValue()).edit().putBoolean(r5, true).apply();
        return;
    L28:
        o r7 = u.l().c(x.class);
        if (r7 == null) goto L37;
        Map r8 = r7.getMap();
        if (r8 == null) goto L37;
        String r9 = (String) r8.get("enter_from_merge");
        if (r9 == null) goto L37;
        if (StringsKt.contains$default(r9, "search", false, 2, null) != true) goto L37;
        boolean r11 = true;
    L38:
        if (r11 == false) goto L40;
        r3.element = "enter_from_search";
        r4 = n5.DEFAULT_SHOW_DURATION;
        goto L41
    L40:
        r3.element = "exceed_avg_duration";
        r4 = 85000;
    L37:
        r11 = false;
        goto L38
    L53:
        return;
    L51:
        return;
    }

    public ShowTipsHelper(PluginContext r2, Function0<Boolean> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "isPanelShow");
        Intrinsics.checkNotNullParameter(r4, "showTipsHandler");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.a = LazyKt.lazy(ShowTipsHelper$gameStartSP$2.INSTANCE);
        this.b = LazyKt.lazy(ShowTipsHelper$gamePaySP$2.INSTANCE);
        this.c = LazyKt.lazy(ShowTipsHelper$gameHasShowSP$2.INSTANCE);
    }
}
