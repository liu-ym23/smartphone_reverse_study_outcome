package he0;

import aj6.d;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiCreator;
import com.bytedance.android.live.liveinteract.api.utils.StringEscapeUtils;
import com.bytedance.android.live.liveinteract.api.utils.g;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdk.model.y0;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import ti6.f;
import ti6.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements j {
    public a a;
    public fi6.a b;
    public final Map<String, Integer> c;
    public boolean d;
    public final Map<String, Integer> e;
    public Integer f;
    public j1 g;

    public interface a {
        int C0();

        boolean J8();

        String N4(String r1);

        List<Integer> R4();

        int getUILayout();

        int he();

        int me();

        void o9(List<f> r1);

        int q0(List<f> r1, Map<String, Integer> r2);
    }

    public final boolean b(d r4, aj6.b r5) {
        if (com.bytedance.android.live.liveinteract.spatial.a.e(this.a.C0()) == true) goto L6;
        return false;
    L6:
        SpatialAudioStrategyManager.a r0 = SpatialAudioStrategyManager.c;
        y0 r1 = r0.a().c(this.a.C0());
        r4.a = r1.a();
        r4.b = r1.b();
        r4.c = r1.c();
        aj6.b r6 = r0.a().a(this.a.C0());
        aj6.c r2 = r6.a;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r5.a = r2;
        aj6.c r3 = r6.b;
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r5.b = r3;
        aj6.c r7 = r6.c;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r5.c = r7;
        ALogger.d("SpatialAudio_RadioStreamMixer", "updateMixSpatialAudio SpatialStrategyId : " + this.a.C0() + " listenerPos :" + r1.toString());
        return true;
    }

    public b(a r3, Map<String, Integer> r4, j1 r5) {
        k.f(IMiddlewareUserService.class).user().n();
        this.d = false;
        this.e = new HashMap();
        this.f = 5;
        Lazy r1 = KtvCommonSettingHelper.a;
        KtvCommonSettingHelper.a(null);
        this.a = r3;
        this.c = r4;
        this.g = r5;
        if (r5 == null) goto L8;
        dn0.c r6 = (dn0.c) r5.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r6 == null) goto L9;
        r6.Se("rtc_init", "RadioStreamMixer_constructor", false);
        return;
    L9:
        return;
    }

    public final String a(int r15, int r16, List<f> r17) {
        String r2 = tc0.c.h().f;
        int r7 = this.a.getUILayout();
        if (ArraysKt.contains((Integer[]) vm2.d.X2.getValue(null, vm2.d.a[203(0xcb, float:2.84E-43)]), Integer.valueOf(je0.d.f())) == false) goto L5;
        Map<String, Integer> r3 = new HashMap();
    L6:
        Map<String, Integer> r4 = r3;
        if (r4 == null) goto L9;
        r4.clear();
    L9:
        boolean r5 = je0.d.y();
        je0.d.s();
        String r6 = je0.d.g();
        String r8 = this.a.N4(r6);
        if (r5 == false) goto L13;
        ALogger.i("ttlive_link_rtc", "mixStream singer:" + r6 + " " + r8 + " w=" + r15 + " h=" + r16);
    L13:
        if (SpatialAudioContext.getContext() != null) goto L15;
    L21:
        m r9 = k.f(IKtvService.class).isPushingExternalVideo();
        if (r9 == null) goto L25;
        ((Boolean) r9.getValue()).booleanValue();
    L25:
        if (this.f.intValue() <= 0) goto L27;
        this.f = Integer.valueOf(this.f.intValue() - 1);
    L27:
        this.a.q0(r17, r4);
        this.a.o9(r17);
        j1 r10 = this.g;
        if (r10 == null) goto L32;
        dn0.c r11 = (dn0.c) r10.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r11 == null) goto L32;
        r11.o3(r17);
    L32:
        String r1 = LiveSeiCreator.b(r17, this.c, this.b, r4, tc0.c.h().getChannelId(), r7, this.a.J8(), this.a.me(), this.a.he(), this.a.R4(), -1).toString();
        if (StringEscapeUtils.a(r1).length() >= 950) goto L35;
    L37:
        return r1;
    L35:
        if (this.d == true) goto L37;
        HashMap r12 = new HashMap();
        r12.put("sei", r1);
        g.n("sei_too_long", r12, tc0.c.h(), true);
        this.d = true;
        goto L37
    L15:
        if (SpatialAudioContext.getContext().getCurrentStrategyId() == null) goto L21;
        if (SpatialAudioContext.getContext().getCurrentStrategyId().getValue() == null) goto L21;
        if (((Integer) SpatialAudioContext.getContext().getCurrentStrategyId().getValue()).intValue() == this.a.C0()) goto L21;
        SpatialAudioContext.getContext().getCurrentStrategyId().setValue(Integer.valueOf(this.a.C0()));
        goto L21
    L5:
        r3 = this.e;
        goto L6
    }
}
