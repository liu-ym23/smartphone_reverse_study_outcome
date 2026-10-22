package o21;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.link.player.MultiPlayerScene;
import com.bytedance.android.live.revenuelink.f;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.transfer.monitor.PlayerStatus;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import k31.j;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;
import rc0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements d {
    public final c a;
    public boolean b;
    public long c;
    public j d;
    public C0281b e;
    public o21.a f;

    public static final class a {
    }

    /* JADX INFO: renamed from: o21.b$b, reason: collision with other inner class name */
    public static final class C0281b {
        public boolean a;
        public long b;

        public C0281b(long r1) {
            this.b = r1;
            this.a = true;
        }
    }

    static {
    }

    public final void a() {
        this.b = true;
        this.d = null;
        this.f = null;
        this.e = new C0281b(System.currentTimeMillis());
    }

    public final void c() {
        this.b = false;
        this.d = null;
        this.f = null;
        this.e = null;
    }

    public b() {
        this.a = new c();
    }

    public final void b(hs0.b r26) {
        b r0 = this;
        Intrinsics.checkNotNullParameter(r26, "param");
        String r3 = r26.c;
        MultiPlayerScene r4 = r26.a;
        View r1 = r26.b;
        j.e.getClass();
        Intrinsics.checkNotNullParameter(r3, "sei");
        n0 r6 = com.bytedance.android.live.revenue.common.player.utils.a.a(r3, false);
        JSONArray r5 = com.bytedance.android.live.revenue.common.player.utils.a.b(r3);
        if (r5 == null) goto L13;
        if (r6 != null) goto L7;
        j r7 = new j(com.bytedance.android.live.revenue.common.player.utils.a.g(r5), com.bytedance.android.live.revenue.common.player.utils.a.h(r5), com.bytedance.android.live.revenue.common.player.utils.a.e(r5), com.bytedance.android.live.revenue.common.player.utils.a.f(r5));
    L14:
        if (r7 != null) goto L16;
        return;
    L16:
        k31.d r8 = new k31.d(r4, r1, r7);
        if (r0.b == false) goto L172;
        j r2 = r0.d;
        if (r2 != null) goto L22;
    L163:
        C0281b r9 = r0.e;
        if (r9 == null) goto L166;
        r9.b = System.currentTimeMillis();
    L166:
        r0.d = r8.c;
        return;
    L22:
        if (r2.equals(r8.c) != true) goto L163;
        long r10 = System.currentTimeMillis();
        if (r10 >= r0.c) goto L27;
        r0.c = 0;
        boolean r12 = false;
    L28:
        if (r12 == false) goto L168;
        C0281b r13 = r0.e;
        if (r13 != null) goto L33;
        return;
    L33:
        if (System.currentTimeMillis() >= r13.b) goto L35;
        boolean r14 = true;
    L36:
        if (r14 == false) goto L39;
        r13.b = System.currentTimeMillis();
        return;
    L39:
        if (System.currentTimeMillis() < (r13.b + 1000)) goto L41;
        boolean r15 = true;
    L42:
        if (r15 == false) goto L170;
        r0.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "param");
        MultiPlayerScene r16 = r8.a;
        AbsLivePlayerView r17 = r8.b;
        if ((r17 instanceof AbsLivePlayerView) == true) goto L46;
        AbsLivePlayerView r18 = null;
    L47:
        AbsLivePlayerView r19 = r18;
        if (r19 == null) goto L125;
        IRenderView r20 = r19.getRenderView();
        if (r20 == null) goto L125;
        View r22 = r20.getSelfView();
        if (r22 == null) goto L125;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L125;
        ViewGroup.LayoutParams r24 = r17.getLayoutParams();
        if (r24 == null) goto L125;
        View r110 = r17.findViewById(2131389668);
        View r111 = r17.findViewById(2131389666);
        if (r110 == null) goto L63;
        ViewGroup.LayoutParams r112 = r110.getLayoutParams();
    L64:
        if (r111 == null) goto L66;
        ViewGroup.LayoutParams r113 = r111.getLayoutParams();
    L68:
        if ((r23 instanceof FrameLayout.LayoutParams) == false) goto L124;
        if (r112 != null) goto L71;
    L72:
        if (r113 != null) goto L74;
    L76:
        ViewGroup r25 = (ViewGroup) r17;
        j r27 = r8.c;
        FrameLayout.LayoutParams r28 = (FrameLayout.LayoutParams) r23;
        if ((r112 instanceof FrameLayout.LayoutParams) == true) goto L79;
        r112 = null;
    L79:
        FrameLayout.LayoutParams r114 = (FrameLayout.LayoutParams) r112;
        if ((r113 instanceof FrameLayout.LayoutParams) == true) goto L82;
        r113 = null;
    L82:
        FrameLayout.LayoutParams r115 = (FrameLayout.LayoutParams) r113;
        Intrinsics.checkNotNullParameter(r16, "playerScene");
        Intrinsics.checkNotNullParameter(r25, "playerView");
        Intrinsics.checkNotNullParameter(r27, "seiLayouts");
        Intrinsics.checkNotNullParameter(r22, "renderView");
        Intrinsics.checkNotNullParameter(r28, "renderLayouts");
        Intrinsics.checkNotNullParameter(r24, "playerLayouts");
        if (r110 != null) goto L85;
    L90:
        if (r111 != null) goto L92;
    L97:
        o21.a r29 = null;
    L98:
        if (r29 != null) goto L114;
        int r30 = r28.width;
        int r32 = r28.height;
        int r116 = r28.topMargin;
        if (r114 == null) goto L103;
        int r117 = RangesKt.coerceAtLeast((r114.topMargin + r114.height) - r116, 0);
    L104:
        int r118 = RangesKt.coerceAtLeast(r117, r116 * (-1));
        int r119 = r28.height;
        int r120 = r28.topMargin;
        int r121 = r24.height;
        if (r115 == null) goto L107;
        r119 = RangesKt.coerceAtMost(r115.topMargin - r120, r119);
    L107:
        if (r121 <= 0) goto L109;
        r119 = RangesKt.coerceAtMost(r119, r121 - r120);
    L109:
        int r122 = RangesKt.coerceAtLeast(r28.leftMargin * (-1), 0);
        int r123 = r28.width;
        int r33 = r28.leftMargin;
        int r34 = r24.width;
        if (r34 <= 0) goto L112;
        r123 = RangesKt.coerceAtMost(r34 - r33, r123);
    L112:
        if (r119 > r118) goto L115;
        r29 = new o21.a(r16, PlayerStatus.ERROR_CODE_LAYOUT_PARAM_INVISIBLE);
        goto L114
    L115:
        double r35 = r30;
        double r36 = r32;
        boolean r37 = ((c.a(r27.a, ((double) r122) / r35) & c.a(r27.b, ((double) r118) / r36)) & c.a(r27.c, ((double) r123) / r35)) & c.a(r27.d, ((double) r119) / r36);
        if (r37 == false) goto L118;
        PlayerStatus r38 = PlayerStatus.ERROR_CODE_NO_ERROR;
    L119:
        float r39 = r30;
        Float r40 = Float.valueOf(r122 / r39);
        float r42 = r32;
        Float r124 = Float.valueOf(r118 / r42);
        Float r125 = Float.valueOf(r123 / r39);
        Float r126 = Float.valueOf(r119 / r42);
        if (r37 == true) goto L122;
        String r127 = r27.toString();
    L123:
        r29 = new o21.a(r16, r38, r40, r124, r125, r126, r127);
    L126:
        r0 = this;
    L127:
        o21.a r43 = r0.f;
        if (r43 != null) goto L130;
    L132:
        c r44 = r0.a;
        C0281b r45 = r0.e;
        if (r45 == null) goto L135;
        Boolean r46 = Boolean.valueOf(r45.a);
    L136:
        r44.getClass();
        u41.d r47 = u41.d.n;
        r47.getClass();
        if (((Boolean) u41.d.h.getValue(r47, u41.d.a[6])).booleanValue() == false) goto L159;
        if (r29 == null) goto L159;
        HashMap r128 = new HashMap();
        r128.put("android_event_key", r29.b.toString());
        JSONObject r129 = new JSONObject();
        r129.put("player_scene", r29.a);
        r129.put("is_first_frame", Intrinsics.areEqual(r46, Boolean.TRUE));
        Float r48 = r29.c;
        if (r48 == null) goto L144;
        r129.put("canvas_ratio_left", Float.valueOf(r48.floatValue()));
    L144:
        Float r49 = r29.d;
        if (r49 == null) goto L147;
        r129.put("canvas_ratio_top", Float.valueOf(r49.floatValue()));
    L147:
        Float r50 = r29.e;
        if (r50 == null) goto L150;
        r129.put("canvas_ratio_right", Float.valueOf(r50.floatValue()));
    L150:
        Float r52 = r29.f;
        if (r52 == null) goto L153;
        r129.put("canvas_ratio_bottom", Float.valueOf(r52.floatValue()));
    L153:
        String r53 = r29.g;
        if (r53 == null) goto L156;
        r129.put("detail_message", r53);
    L156:
        LocalTestManager.a(new Class[]{wy.a.class});
        f r54 = com.bytedance.android.live.revlink.impl.global.b.g0();
        if (r54 == null) goto L159;
        r54.c0("ttlive_multi_player_layout_monitor", LiveTracingMonitorKt.EventModule.MULTI_LINKER, r29.b.getCode(), null, r128, r129);
    L159:
        r0.f = r29;
        C0281b r55 = r0.e;
        if (r55 == null) goto L162;
        r55.a = false;
    L162:
        r13.b = System.currentTimeMillis();
        return;
    L135:
        r46 = null;
        goto L136
    L130:
        if (r43.equals(r29) != true) goto L132;
    L122:
        r127 = null;
        goto L123
    L118:
        r38 = PlayerStatus.ERROR_CODE_RENDER_SEI_DIFF;
        goto L119
    L103:
        r117 = 0;
    L114:
        r13 = r13;
        goto L127
    L92:
        if ((!Intrinsics.areEqual(r111.getParent(), r25)) == false) goto L95;
        r29 = new o21.a(r16, PlayerStatus.ERROR_CODE_BOTTOM_BG_ROOT_DIFF);
        goto L98
    L95:
        if (r25.indexOfChild(r111) >= r25.indexOfChild(r22)) goto L97;
        r29 = new o21.a(r16, PlayerStatus.ERROR_CODE_BOTTOM_BG_BELOW_RENDER);
        goto L98
    L85:
        if ((!Intrinsics.areEqual(r110.getParent(), r25)) == false) goto L88;
        r29 = new o21.a(r16, PlayerStatus.ERROR_CODE_TOP_BG_ROOT_DIFF);
        goto L98
    L88:
        if (r25.indexOfChild(r110) >= r25.indexOfChild(r22)) goto L90;
        r29 = new o21.a(r16, PlayerStatus.ERROR_CODE_TOP_BG_BELOW_RENDER);
        goto L98
    L74:
        if ((r113 instanceof FrameLayout.LayoutParams) == true) goto L76;
    L71:
        if ((r112 instanceof FrameLayout.LayoutParams) == true) goto L72;
    L124:
        r29 = new o21.a(r16, PlayerStatus.ERROR_CODE_LAYOUT_PARAM_MISMATCH);
        goto L126
    L66:
        r113 = null;
        goto L68
    L63:
        r112 = null;
    L125:
        r29 = null;
        goto L126
    L46:
        r18 = r17;
        goto L47
    L170:
        return;
    L41:
        r15 = false;
        goto L42
    L35:
        r14 = false;
        goto L36
    L168:
        return;
    L27:
        r0.c = r10;
        r12 = true;
        goto L28
    L172:
        return;
    L7:
        double r56 = com.bytedance.android.live.revenue.common.player.utils.a.i(r5);
        double r130 = com.bytedance.android.live.revenue.common.player.utils.a.d(r5);
        if (r56 <= 0.0d) goto L13;
        if (r130 <= 0.0d) goto L13;
        double r57 = ((double) r6.b()) / ((double) r6.f());
        double r131 = ((double) r6.a()) / ((double) r6.e());
        double r132 = ((double) r6.c()) / ((double) r6.f());
        double r133 = ((double) r6.d()) / ((double) r6.e());
        r7 = new j(r132 + (com.bytedance.android.live.revenue.common.player.utils.a.g(r5) * r57), (com.bytedance.android.live.revenue.common.player.utils.a.h(r5) * r131) + r133, r132 + (r57 * com.bytedance.android.live.revenue.common.player.utils.a.e(r5)), r133 + (r131 * com.bytedance.android.live.revenue.common.player.utils.a.f(r5)));
    L13:
        r7 = null;
        goto L14
    }
}
