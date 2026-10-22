package he0;

import aj6.d;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiCreator;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.e;
import com.bytedance.android.live.liveinteract.plantform.spatial.SpatialAudioStrategyManager;
import com.bytedance.android.live.liveinteract.spatial.SpatialAudioContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.model.y0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import ne0.g;
import sh0.h0;
import sh0.j0;
import ti6.f;
import ti6.j;
import yg0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements j {
    public final String a;
    public final long b;
    public j1 c;
    public fi6.a d;
    public final a e;
    public final Map<String, Integer> f;

    public interface a {
        int C0();

        List<Integer> R4();

        int getUILayout();

        int i1();

        int q0(List<f> r1, Map<String, Integer> r2);
    }

    public final void c(String r3) {
        j1 r0 = this.c;
        if (r0 == null) goto L8;
        dn0.c r1 = (dn0.c) r0.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r1 == null) goto L9;
        r1.H4(r3);
        return;
    L9:
        return;
    }

    public c(a r4, j1 r5) {
        this.c = null;
        this.f = new HashMap();
        this.e = r4;
        this.a = tc0.c.h().f;
        this.b = tc0.c.h().getChannelId();
        this.c = r5;
        e.c.getClass();
        e.a.c("video talk mixer init", null, r5);
    }

    public final boolean b(d r4, aj6.b r5) {
        if (com.bytedance.android.live.liveinteract.spatial.a.e(this.e.C0()) == true) goto L6;
        return false;
    L6:
        SpatialAudioStrategyManager.a r0 = SpatialAudioStrategyManager.c;
        y0 r1 = r0.a().c(this.e.C0());
        r4.a = r1.a();
        r4.b = r1.b();
        r4.c = r1.c();
        aj6.b r6 = r0.a().a(this.e.C0());
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
        ALogger.d("SpatialAudio_VideoTalkRoomStreamMixer", "SpatialStrategyId : " + this.e.C0() + " listenerPos :" + r1.toString());
        return true;
    }

    public final String a(int r14, int r15, List<f> r16) {
        String r2 = k.f(IMiddlewareUserService.class).user().n();
        int r8 = 0;
        this.e.getUILayout();
        ((IInteractService) k.f(IInteractService.class)).getCurrentScene();
        if (j0.a(null) != null) goto L5;
    L7:
        int r9 = 1;
    L9:
        if (j0.a(null) == null) goto L14;
        g r4 = j0.a(null).b;
        if (r4 == null) goto L14;
        int r6 = h0.a;
        String r5 = (String) r4.a("visible_guest_uid");
        if (r5 == null) goto L14;
    L15:
        String r10 = r5;
        com.bytedance.android.live.liveinteract.spatial.a.e(this.e.C0());
        if (ArraysKt.contains((Integer[]) vm2.d.W2.getValue(null, vm2.d.a[202(0xca, float:2.83E-43)]), Integer.valueOf(je0.d.f())) == false) goto L18;
        Map<String, Integer> r3 = new HashMap();
    L19:
        if (r3 == null) goto L21;
        r3.clear();
    L21:
        rj0.k.m2.getClass();
        rj0.k r7 = rj0.k.a.a();
        if (r7 != null) goto L24;
    L49:
        Iterator<f> r11 = r16.iterator();
    L51:
        if (r11.hasNext() == false) goto L55;
        f r12 = r11.next();
        if (TextUtils.equals(r12.b, this.a) == false) goto L51;
        r12.f = 1.0d;
        r12.g = 1.0d;
        r12.d = 0.0d;
        r12.e = 0.0d;
        r12.c(r2);
        r12.a = 1;
        r12.i = 0;
        goto L51
    L55:
        j1 r13 = this.c;
        if (r13 == null) goto L61;
        dn0.c r17 = (dn0.c) r13.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r17 == null) goto L61;
        r17.o3(r16);
    L61:
        return LiveSeiCreator.c(r16, this.d, r3, this.b, this.e.i1(), this.e.getUILayout(), 0, r9, r10, this.e.R4()).toString();
    L24:
        if (r7.isEngineOn() == false) goto L49;
        if (SpatialAudioContext.getContext() != null) goto L29;
    L35:
        ln0.a r18 = h.a;
        if (h.j(this.e.i1(), this.e.getUILayout()) == false) goto L38;
        r8 = this.e.q0(r16, r3);
    L38:
        j1 r19 = this.c;
        if (r19 == null) goto L43;
        dn0.c r20 = (dn0.c) r19.getScopeServiceOrNullInMultiLinkRoom(dn0.c.class);
        if (r20 == null) goto L43;
        r20.o3(r16);
    L43:
        StringBuilder r21 = new StringBuilder();
        r21.append("mixStream, ver = " + this.e.i1() + ", uiLayout = " + this.e.getUILayout() + ", micSeatStatus = " + r9);
        Iterator<f> r22 = r16.iterator();
    L45:
        if (r22.hasNext() == false) goto L47;
        f r23 = r22.next();
        r21.append("\n");
        r21.append("interactId:" + r23.b);
        r21.append(", width: " + r23.f);
        r21.append(", height: " + r23.g);
        r21.append(", X: " + r23.d);
        r21.append(", Y: " + r23.e);
        goto L45
    L47:
        boolean r24 = gh0.b.a;
        gh0.b.a("MixStream", r21.toString(), false);
        return LiveSeiCreator.c(r16, this.d, r3, this.b, this.e.i1(), this.e.getUILayout(), r8, r9, r10, this.e.R4()).toString();
    L29:
        if (SpatialAudioContext.getContext().getCurrentStrategyId() == null) goto L35;
        if (SpatialAudioContext.getContext().getCurrentStrategyId().getValue() == null) goto L35;
        if (((Integer) SpatialAudioContext.getContext().getCurrentStrategyId().getValue()).intValue() == this.e.C0()) goto L35;
        SpatialAudioContext.getContext().getCurrentStrategyId().setValue(Integer.valueOf(this.e.C0()));
        goto L35
    L18:
        r3 = this.f;
    L14:
        r5 = "";
        goto L15
    L5:
        if (j0.a(null).h() == false) goto L7;
        r9 = 2;
        goto L9
    }
}
