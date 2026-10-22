package bc;

import com.bytedance.android.scope.m;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.bytedance.tools.kcp.ultrasettings.runtime.c;
import e33.l;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import oj0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void call(String r10) {
        Intrinsics.checkNotNullParameter(r10, "group");
        int r0 = r10.hashCode();
        if (r0 == (-1734888178)) goto L16;
        if (r0 == (-1068799377)) goto L13;
        if (r0 == 1434631203) goto L10;
        return;
    L10:
        if (r10.equals("settings") == false) goto L19;
        int r11 = ym3.a.a;
        en3.a.a();
        int r12 = gn3.a.a;
        int r13 = pn3.a.a;
        ConcurrentHashMap r14 = UltraSettingsManager.a;
        UltraSettingsManager.b("live_local_default_audio_theme", new c("live_local_default_audio_theme", Reflection.getOrCreateKotlinClass(b.class), "语音直播默认背景资源", "wuzhixin.jensen"));
        int r15 = qn3.a.a;
        UltraSettingsManager.b("live_aigc_rtc_stream_config", new c("live_aigc_rtc_stream_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.liveinteract.plantform.utils.a.class), "AI嘉宾低延迟配置", "null"));
        int r16 = rn3.a.a;
        int r17 = sn3.a.a;
        int r18 = ao3.a.a;
        int r19 = bo3.a.a;
        int r20 = co3.a.a;
        int r21 = do3.a.a;
        eo3.a.a();
        int r22 = fo3.a.a;
        UltraSettingsManager.b("live_ai_guest_entrance_url", new c("live_ai_guest_entrance_url", Reflection.getOrCreateKotlinClass(String.class), "ai嘉宾邀请入口icon配置", "null"));
        int r23 = go3.a.a;
        int r24 = ho3.a.a;
        int r25 = io3.a.a;
        int r26 = jo3.a.a;
        int r27 = ko3.a.a;
        int r28 = lo3.a.a;
        int r29 = mo3.a.a;
        int r30 = no3.a.a;
        UltraSettingsManager.b("live_ignore_auto_switch_bg_play_mode", new c("live_ignore_auto_switch_bg_play_mode", oo3.a.a, "忽略自动切换背景的玩法列表", "null"));
        int r31 = po3.a.a;
        int r32 = qo3.a.a;
        return;
    L19:
        return;
    L13:
        if (r10.equals("modelx") == false) goto L21;
        ux2.a.g.b();
        vx2.a.g.b();
        wx2.a.g.b();
        dy2.b.g.b();
        ey2.b.g.b();
        fy2.a.g.b();
        return;
    L21:
        return;
    L16:
        if (r10.equals("scope-modules") == false) goto L23;
        l[] r33 = e03.a.a;
        m r34 = m.e;
        e03.a r1 = e03.a.b;
        r34.getClass();
        m.e(r1);
        n03.a r35 = n03.a.a;
        r34.getClass();
        m.e(r35);
        s03.a r36 = s03.a.a;
        r34.getClass();
        m.e(r36);
        u03.a r37 = u03.a.a;
        r34.getClass();
        m.e(r37);
        i13.a r38 = i13.a.b;
        r34.getClass();
        m.e(r38);
        m.e(k13.a.a);
        m.e(l13.a.b);
        m.e(y13.a.a);
        m.e(z13.a.b);
        m.e(a23.a.a);
        m.e(b23.a.b);
        c23.a r39 = c23.a.a;
        r34.getClass();
        m.e(r39);
        m.e(d23.a.a);
        m.e(e23.a.a);
        m.e(f23.a.a);
        m.e(g23.a.b);
        m.e(i23.a.a);
        j23.a r40 = j23.a.a;
        r34.getClass();
        m.e(r40);
        m.e(k23.a.a);
        m.e(l23.a.a);
        m.e(m23.a.a);
        m.e(n23.a.a);
        m.e(o23.a.a);
        return;
    }
}
