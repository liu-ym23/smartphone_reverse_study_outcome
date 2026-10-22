package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.config.du0;
import com.bytedance.android.livesdk.config.it0;
import com.bytedance.android.livesdk.config.kd1;
import com.bytedance.android.livesdk.config.qf0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.model.CropSeiData;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d8 {
    public DataCenter a;
    public boolean b;
    public ds0.d c;
    public Configuration d;
    public JSONObject e;
    public AbsLivePlayerView f;
    public long g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final float m;
    public final float n;
    public final float o;
    public final float p;
    public final float q;
    public final float r;
    public final float s;
    public final Float t;
    public final String u;
    public final String v;
    public cy0.a w;
    public final a x;

    public interface a {
        void e9();
    }

    public final void b() {
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L5;
    L179:
        JSONObject r1 = this.e;
        if (r1 != null) goto L182;
        return;
    L182:
        if (r1.has("app_data") != true) goto L197;
        ALogger.e(this.v, "adjustPlayerPosition do nothing " + StatusBarUtil.STATUS_BAR_ADAPT_ENABLE + ' ' + StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY + ' ' + StatusBarUtil.isStatusBarTransparent());
        return;
    L197:
        return;
    L5:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L179;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L179;
        if (PadConfigUtils.c() == true) goto L179;
        if (it0.a.getValue().booleanValue() == false) goto L179;
        AbsLivePlayerView r2 = this.f;
        if (r2 == null) goto L17;
        IRenderView r3 = r2.getRenderView();
        if (r3 == null) goto L17;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
    L19:
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L21;
        r4 = null;
    L21:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        boolean r6 = g(this.e);
        boolean r7 = f(this.e);
        if (r6 == true) goto L24;
    L152:
        if (r7 == true) goto L154;
    L158:
        if (this.j == false) goto L170;
        DataCenter r8 = this.a;
        if (r8 == null) goto L165;
        if (r5 == null) goto L163;
        int r9 = r5.topMargin;
    L164:
        r8.put("data_pk_moved_margin_top", Integer.valueOf(r9));
        goto L165
    L163:
        r9 = -1;
    L165:
        boolean r10 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.j r11 = com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class);
        cy0.a r12 = this.w;
        if (r5 == null) goto L168;
        int r13 = r5.topMargin;
    L169:
        r11.updatePkMovedMarginTop(r12, r13);
        goto L170
    L168:
        r13 = -1;
    L170:
        String r14 = this.v;
        StringBuilder r15 = new StringBuilder("adjustPlayerPosition topMargin=");
        if (r5 == null) goto L173;
        Integer r16 = Integer.valueOf(r5.topMargin);
    L174:
        r15.append(r16);
        r15.append(", mHasMoved=");
        r15.append(this.j);
        r15.append(", isPkMode=");
        r15.append(r6);
        ALogger.e(r14, r15.toString());
        AbsLivePlayerView r17 = this.f;
        if (r17 == null) goto L193;
        IRenderView r18 = r17.getRenderView();
        if (r18 == null) goto L194;
        r18.setLayoutParams(r5);
        return;
    L194:
        return;
    L193:
        return;
    L173:
        r16 = null;
        goto L174
    L154:
        if (this.j == false) goto L158;
        if (r5 == null) goto L158;
        r5.topMargin = this.h;
        goto L158
    L24:
        if (this.j == true) goto L152;
        JSONObject r19 = this.e;     // Catch: JSONException -> L129
        if (r19 == null) goto L130;
        if (r19.has("app_data") == false) goto L130;
        SeiAppData r20 = com.bytedance.android.live.liveinteract.api.utils.j.a(new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r19, "app_data"), "")), "");     // Catch: JSONException -> L129
        CropSeiData r21 = CropSeiData.parseCropSei(r19);     // Catch: JSONException -> L129
        if (r20.getGrids() != null) goto L33;
    L126:
        ALogger.e(this.v, "sei grids invalid " + r19);     // Catch: JSONException -> L185
        goto L130
    L33:
        if (r20.getGrids().size() == 0) goto L126;
        SeiRegion r22 = (SeiRegion) ListProtector.get(r20.getGrids(), 0);     // Catch: JSONException -> L129
        if (r21 != null) goto L190;
    L40:
        boolean r23 = false;
    L41:
        int r24 = e();     // Catch: JSONException -> L129
        if (r23 == false) goto L46;
        SeiCanvas r25 = r20.getCanvas();     // Catch: JSONException -> L186
        float r26 = (r24 * 1.0f) / r25.getWidth();     // Catch: JSONException -> L186
        float r27 = (Math.max(com.bytedance.android.live.core.utils.s1.w(), com.bytedance.android.live.core.utils.s1.y()) * this.t.floatValue()) - 0;     // Catch: JSONException -> L186
        this.i = (int) (((((double) r25.getHeight()) * r22.getY()) * ((double) r26)) + ((double) r27));     // Catch: JSONException -> L186
        ALogger.e(this.v, "cropStream videoMarginTop=" + this.i + ", cropStreamMarginTop=" + r27 + " marginTopOffset=0 canvas=" + r25);     // Catch: JSONException -> L186
        goto L130
    L46:
        DataCenter r28 = this.a;     // Catch: JSONException -> L129
        if (r28 == null) goto L52;
        Integer r29 = (Integer) r28.get("interaction_layer_margin_top", 0);     // Catch: JSONException -> L186
        if (r29 == null) goto L52;
        int r30 = r29.intValue();     // Catch: JSONException -> L186
    L55:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L102;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L102;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L102;
        if (r20.getGrids().size() <= 1) goto L65;
        SeiCanvas r31 = r20.getCanvas();     // Catch: JSONException -> L186
        float r32 = (r24 * 1.0f) / r31.getWidth();     // Catch: JSONException -> L186
        this.i = (int) Math.ceil((((double) r31.getHeight()) * r22.getY()) * ((double) r32));     // Catch: JSONException -> L186
        ALogger.e(this.v, "statusBarAdapt grids>1 videoMarginTop=" + this.i + ", canvas=" + r31 + " streamScale=" + r32);     // Catch: JSONException -> L186
        goto L130
    L65:
        DataCenter r33 = this.a;     // Catch: JSONException -> L98
        if (r33 == null) goto L69;
        Pair r34 = (Pair) r33.get("data_video_size", new Pair(0, 0));     // Catch: JSONException -> L186
        if (r34 == null) goto L69;
    L70:
        int r35 = ((Number) r34.getFirst()).intValue();     // Catch: JSONException -> L98
        if (r35 != 0) goto L74;
        r35 = RangesKt.coerceAtLeast(com.bytedance.android.live.core.utils.s1.w(), com.bytedance.android.live.core.utils.s1.y());     // Catch: JSONException -> L186
    L74:
        if (FoldScreenUtils.f() == true) goto L76;
    L79:
        double r110 = r35;
        this.i = ((int) (r22.getY() * r110)) + ((Number) r34.getSecond()).intValue();     // Catch: JSONException -> L98
        DataCenter r36 = this.a;     // Catch: JSONException -> L98
        if (r36 == null) goto L86;
        Integer r37 = (Integer) r36.get("data_pk_moved_margin_top", -1);     // Catch: JSONException -> L186
        if (r37 == null) goto L86;
        int r38 = r37.intValue();     // Catch: JSONException -> L186
    L87:
        if (r38 < 0) goto L94;
        if (((Number) r34.getSecond()).intValue() <= 0) goto L94;
        if (r38 <= 0) goto L92;
        this.i -= r38;     // Catch: JSONException -> L186
        goto L94
    L92:
        this.i -= ((Number) r34.getSecond()).intValue();     // Catch: JSONException -> L186
    L94:
        if (this.i > 0) goto L96;
        this.i = (int) (r110 * r22.getY());     // Catch: JSONException -> L186
    L96:
        ALogger.e(this.v, "statusBarAdapt videoMarginTop=" + this.i + ", playerViewMovedDistance=" + r38 + " pair=" + r34 + " screenHeight=" + r35);     // Catch: JSONException -> L186
    L86:
        r38 = -1;
        goto L87
    L76:
        if (Intrinsics.areEqual(FoldScreenUtils.d(), this.u) == false) goto L79;
        r35 = RangesKt.coerceAtLeast(com.bytedance.android.live.core.utils.s1.w(), com.bytedance.android.live.core.utils.s1.y()) + com.bytedance.android.live.core.utils.s1.A();
    L69:
        r34 = new Pair(0, 0);     // Catch: JSONException -> L98
    L102:
        if (r30 == 0) goto L104;
    L125:
        SeiCanvas r39 = r20.getCanvas();     // Catch: JSONException -> L185
        float r40 = (r24 * 1.0f) / r39.getWidth();     // Catch: JSONException -> L185
        this.i = (int) ((((double) r39.getHeight()) * r22.getY()) * ((double) r40));     // Catch: JSONException -> L185
        ALogger.e(this.v, "noStatusBarAdapt grids>1 videoMarginTop=" + this.i + ", streamScale=" + r40 + " canvas=" + r39 + " region.y=" + Double.valueOf(r22.getY()));     // Catch: JSONException -> L185
        goto L130
    L104:
        if (r20.getGrids().size() > 1) goto L125;
        DataCenter r41 = this.a;     // Catch: JSONException -> L129
        if (r41 == null) goto L111;
        Pair r42 = (Pair) r41.get("data_video_size", new Pair(0, 0));     // Catch: JSONException -> L186
        if (r42 == null) goto L111;
    L114:
        int r43 = ((Number) r42.getFirst()).intValue();     // Catch: JSONException -> L185
        if (r43 != 0) goto L117;
    L120:
        r43 = RangesKt.coerceAtLeast(com.bytedance.android.live.core.utils.s1.w(), com.bytedance.android.live.core.utils.s1.y());     // Catch: JSONException -> L185
    L121:
        double r111 = r43;
        int r44 = ((int) (r22.getY() * r111)) + ((Number) r42.getSecond()).intValue();     // Catch: JSONException -> L185
        this.i = r44;     // Catch: JSONException -> L185
        if (r44 > 0) goto L124;
        this.i = (int) (r22.getY() * r111);     // Catch: JSONException -> L185
    L124:
        ALogger.e(this.v, "noStatusBarAdapt videoMarginTop=" + this.i + ", screenHeight=" + r43 + " pair=" + r42 + " region.y=" + Double.valueOf(r22.getY()));     // Catch: JSONException -> L185
        goto L130
    L117:
        if (FoldScreenUtils.f() == false) goto L121;
        if (Intrinsics.areEqual(FoldScreenUtils.d(), this.u) == false) goto L121;
    L111:
        r42 = new Pair(0, 0);     // Catch: JSONException -> L185
    L52:
        r30 = 0;
        goto L55
    L190:
        if (r21.isLegalCropSei() == false) goto L40;
        r23 = true;
    L130:
        int r45 = this.i;
        if (du0.a.getValue().booleanValue() == true) goto L134;
        int r46 = com.bytedance.android.live.core.utils.s1.f(this.s);
    L137:
        if (r45 > r46) goto L149;
        if (r5 == null) goto L140;
        int r47 = r5.topMargin;
    L141:
        this.h = r47;
        if (r5 == null) goto L144;
        r5.topMargin = StatusBarUtil.getStatusBarHeight(com.bytedance.android.live.core.utils.s1.getContext());
    L144:
        String r48 = this.v;
        StringBuilder r49 = new StringBuilder("StatusBarTransparent adjustPlayerPosition topMargin = ");
        if (r5 == null) goto L147;
        Integer r50 = Integer.valueOf(r5.topMargin);
    L148:
        r49.append(r50);
        r49.append(", mVideoMarginTop = ");
        r49.append(this.i);
        r49.append(", defaultTop = ");
        r49.append(com.bytedance.android.live.core.utils.s1.f(this.s));
        ALogger.w(r48, r49.toString());
    L151:
        this.j = true;
        goto L158
    L147:
        r50 = null;
        goto L148
    L140:
        r47 = 0;
        goto L141
    L149:
        if (r5 == null) goto L151;
        r5.topMargin = this.h;
        goto L151
    L134:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L136;
        r46 = com.bytedance.android.live.core.utils.s1.f(this.s) + StatusBarUtil.getStatusBarHeight(com.bytedance.android.live.core.utils.s1.getContext());
        goto L137
    L136:
        r46 = com.bytedance.android.live.core.utils.s1.f(this.s);
    L17:
        r4 = null;
        goto L19
    }

    public final void h() {
        AbsLivePlayerView r0 = this.f;
        if (r0 == null) goto L18;
        ViewGroup.LayoutParams r1 = r0.getRenderView().getLayoutParams();
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L7;
        r1 = null;
    L7:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 == null) goto L13;
        r2.topMargin = 0;
        r2.gravity = 17;
        if (PadConfigUtils.c() == false) goto L12;
        r2.width = -1;
        r2.height = -1;
        r0.getRenderView().setScaleType(2);
    L12:
        this.h = r2.topMargin;
        r0.getRenderView().setLayoutParams(r2);
    L13:
        ILivePlayerClient r3 = r0.getClient();
        if (r3 == null) goto L16;
        r3.clipRenderViewVertical(0, 0);
    L16:
        this.x.e9();
        return;
    }

    public final int e() {
        int r0 = RangesKt.coerceAtMost(com.bytedance.android.live.core.utils.s1.y(), com.bytedance.android.live.core.utils.s1.w());
        int r2 = 0;
        if (FoldScreenUtils.f() == false) goto L10;
        Context r1 = com.bytedance.android.live.core.utils.s1.getContext();
        Configuration r3 = this.d;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("latestConfig");
    L8:
        if (FoldScreenUtils.b(r1, r3) != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L21;
        DataCenter r5 = this.a;
        if (r5 == null) goto L17;
        Integer r6 = (Integer) r5.get("data_pk_renderview_width", 0);
        if (r6 == null) goto L17;
        r2 = r6.intValue();
    L17:
        if (r2 > 0) goto L20;
        return (int) (com.bytedance.android.live.core.utils.s1.w() * 0.5625f);
    L20:
        return r2;
    L21:
        return r0;
    L10:
        r4 = false;
        goto L11
    }

    public d8(a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.x = r2;
        this.m = 52.0f;
        this.n = 134.0f;
        this.o = 366.0f;
        this.p = 244.0f;
        this.q = 114.0f;
        this.r = 280.0f;
        this.s = 155.0f;
        this.t = qf0.a.getValue();
        this.u = "SAMSUNG";
        this.v = "ttlive_pk_player";
    }

    public static JSONObject d(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L24;
        LiveSeiUtil.i.getClass();     // Catch: JSONException -> L16
        JSONObject r4 = LiveSeiUtil.c(r3);     // Catch: JSONException -> L16
        if (r4.has("info") == true) goto L7;
        return r4;
    L7:
        if (r4.has("source") == true) goto L9;
        return r4;
    L9:
        if (TextUtils.equals(r4.optString("source"), "zego") == false) goto L22;
        Object r5 = r4.get("info");     // Catch: JSONException -> L16
        if (r5 == null) goto L14;
        return (JSONObject) r5;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: JSONException -> L16
    L22:
        return r4;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L24:
        return null;
    }

    public static boolean f(JSONObject r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (TextUtils.equals(r3.optString("source"), "TTLiveSDK_Android") == false) goto L6;
        return true;
    L6:
        if (TextUtils.equals(r3.optString("source"), "TTLiveSDK_IOS") == true) goto L15;
        LiveSeiUtil r1 = LiveSeiUtil.i;
        String r2 = r3.optString("source");
        r1.getClass();
        if (LiveSeiUtil.d(r2) == false) goto L10;
        return true;
    L10:
        if (TextUtils.equals(r3.optString("source"), "TTLiveSDK_Windows") == false) goto L18;
        return true;
    L18:
        return false;
    L15:
        return true;
    }

    public final boolean c(CropSeiData r5) {
        if (kd1.a.getValue().booleanValue() == true) goto L7;
        float r0 = r5.cropY / r5.strideH;
        StringCompanionObject r6 = StringCompanionObject.INSTANCE;
        return true ^ Intrinsics.areEqual(String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r0)}, 1)), String.valueOf(this.t.floatValue()));
    L7:
        return true;
    }

    public final boolean g(JSONObject r7) {
        if (r7 == null) goto L37;
        if (r7.has("app_data") == false) goto L38;
        String r8 = JSONObjectProtectorUtils.getString(r7, "app_data");     // Catch: JSONException -> L34
        JSONObject r3 = new JSONObject(new Regex("\\\\").replace(r8, ""));     // Catch: JSONException -> L34
        if (r3.has("grids") == false) goto L16;
        JSONArray r9 = JSONObjectProtectorUtils.getJSONArray(r3, "grids");     // Catch: JSONException -> L34
        if (r9 == null) goto L11;
        int r2 = r9.length();     // Catch: JSONException -> L34
    L12:
        if (r2 <= 1) goto L14;
        boolean r4 = true;
    L15:
        this.k = r4;     // Catch: JSONException -> L34
    L18:
        if (r3.has("game_type") == false) goto L25;
        if (r3.optInt("game_type") == 0) goto L22;
        boolean r1 = true;
    L23:
        this.l = r1;     // Catch: JSONException -> L34
        goto L25
    L22:
        r1 = false;
    L25:
        if (r3.has("ver") == true) goto L28;
        return false;
    L28:
        if (r3.optInt("ver") != 2) goto L40;
        if (r9 == null) goto L41;
        if (r9.length() <= 0) goto L42;
        return true;
    L42:
        return false;
    L41:
        return false;
    L40:
        return false;
    L14:
        r4 = false;
        goto L15
    L11:
        r2 = 0;
        goto L12
    L16:
        r9 = null;
        goto L18
    L38:
        return false;
    L43:
        return false;
    L37:
        return false;
    }

    public final void a(String r20, AbsLivePlayerView r21, ds0.d r22, Configuration r23) {
        Intrinsics.checkNotNullParameter(r20, "sei");
        Intrinsics.checkNotNullParameter(r21, "livePlayerView");
        Intrinsics.checkNotNullParameter(r22, "roomSession");
        if (StringsKt.contains$default(r20, "TTLiveSDK_Android", false, 2, null) == false) goto L5;
    L14:
        boolean r8 = true;
    L16:
        if (r8 == false) goto L53;
        JSONObject r9 = d(r20);
        this.e = r9;
        if (r9 != null) goto L145;
    L41:
        boolean r5 = false;
    L43:
        if (r5 == false) goto L48;
        DataCenter r6 = this.a;
        if (r6 == null) goto L52;
        r6.put("data_anchor_gift_in_multi_anchor", Boolean.TRUE);
    L52:
        boolean r7 = true;
        boolean r10 = false;
        int r11 = 2;
        Object r12 = null;
    L55:
        if (StringsKt.contains$default(r20, "TTLiveSDK_Android", r10, r11, r12) == false) goto L57;
    L66:
        boolean r17 = true;
    L68:
        if (r17 == false) goto L70;
        if (r7 == true) goto L93;
        this.e = d(r20);
    L93:
        if (g(this.e) == false) goto L98;
        DataCenter r0 = this.a;
        if (r0 == null) goto L102;
        r0.put("data_anchor_gift_in_pk", Boolean.TRUE);
    L102:
        JSONObject r1 = this.e;
        if (r1 != null) goto L147;
    L113:
        boolean r2 = false;
    L114:
        if (r2 == false) goto L116;
        return;
    L116:
        this.f = r21;
        this.c = r22;
        if (r23 != null) goto L119;
        Configuration r3 = com.bytedance.android.live.core.utils.s1.getResources().getConfiguration();
    L120:
        this.d = r3;
        b();
        if (g(this.e) == false) goto L124;
        boolean r4 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).markAddPkBackground(this.w, true);
        this.b = true;
        h();
        return;
    L124:
        if (f(this.e) == true) goto L126;
        return;
    L126:
        if (this.b == false) goto L153;
        this.b = false;
        ds0.d r13 = this.c;
        if (r13 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L131:
        if (r13.getLiveRequest() == null) goto L140;
        ds0.d r14 = this.c;
        if (r14 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L135:
        LiveRequest r15 = r14.getLiveRequest();
        if (r15 == null) goto L140;
        MutableLiveData r16 = r15.getInAnchorInteractMode();
        if (r16 == null) goto L140;
        r16.setValue(Boolean.FALSE);
    L140:
        ds0.d r18 = this.c;
        if (r18 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L143:
        r18.setInPkMode(false);
        this.j = false;
        h();
        return;
    L153:
        return;
    L119:
        r3 = r23;
        goto L120
    L147:
    L111:
        e = move-exception;
        e.printStackTrace();
        goto L113
    L105:
        if (r1.has("app_data") == false) goto L113;
        long r19 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r1, "app_data"), "")).optLong("timestamp");     // Catch: JSONException -> L111
        if (r19 != this.g) goto L109;
        r2 = true;
        goto L114
    L109:
        this.g = r19;     // Catch: JSONException -> L111
        goto L113
    L98:
        if (f(this.e) == false) goto L102;
        this.k = false;
        this.l = false;
        DataCenter r24 = this.a;
        if (r24 == null) goto L102;
        r24.put("data_anchor_gift_in_pk", Boolean.FALSE);
        goto L102
    L70:
        if (StringsKt.contains$default(r20, "TTLiveSDK_Android", r10, r11, r12) == false) goto L72;
    L81:
        boolean r110 = true;
    L82:
        if (r110 == true) goto L84;
        return;
    L84:
        if (this.b == false) goto L150;
        this.b = false;
        ds0.d r25 = this.c;
        if (r25 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("session");
    L88:
        r25.setInPkMode(false);
        this.j = false;
        return;
    L150:
        return;
    L72:
        if (StringsKt.contains$default(r20, "TTLiveSDK_IOS", r10, r11, r12) == true) goto L81;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.d(r20) == true) goto L81;
        if (StringsKt.contains$default(r20, "TTLiveSDK_Windows", r10, r11, r12) == true) goto L81;
        if (StringsKt.contains$default(r20, "\\\"ver\\\":15", r10, r11, r12) == true) goto L81;
        r110 = false;
        goto L82
    L57:
        if (StringsKt.contains$default(r20, "TTLiveSDK_IOS", r10, r11, r12) == true) goto L66;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.d(r20) == true) goto L66;
        if (StringsKt.contains$default(r20, "TTLiveSDK_Windows", r10, r11, r12) == true) goto L66;
        if (StringsKt.contains$default(r20, "\\\"ver\\\":2", r10, r11, r12) == true) goto L66;
        r17 = false;
        goto L68
    L48:
        if (f(this.e) == false) goto L52;
        DataCenter r26 = this.a;
        if (r26 == null) goto L52;
        r26.put("data_anchor_gift_in_multi_anchor", Boolean.FALSE);
        goto L52
    L145:
        if (r9.has("app_data") == false) goto L41;
        JSONObject r27 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r9, "app_data"), ""));     // Catch: JSONException -> L40
        if (r27.has("grids") == false) goto L24;
        JSONArray r28 = JSONObjectProtectorUtils.getJSONArray(r27, "grids");     // Catch: JSONException -> L40
    L26:
        if (r27.has("ver") == false) goto L41;
        if (r27.optInt("ver") != 6) goto L35;
        if (r28 == null) goto L35;
        DataCenter r111 = this.a;     // Catch: JSONException -> L40
        if (r111 == null) goto L35;
        r111.put("data_anchor_num_from_stream", Integer.valueOf(r28.length()));     // Catch: JSONException -> L40
    L35:
        if (r27.optInt("ver") != 6) goto L41;
        if (r28 == null) goto L41;
        if (r28.length() <= 0) goto L41;
        r5 = true;
        goto L43
    L24:
        r28 = null;
        goto L26
    L53:
        r12 = null;
        r7 = false;
        r10 = false;
        r11 = 2;
        goto L55
    L5:
        if (StringsKt.contains$default(r20, "TTLiveSDK_IOS", false, 2, null) == true) goto L14;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.d(r20) == true) goto L14;
        if (StringsKt.contains$default(r20, "TTLiveSDK_Windows", false, 2, null) == true) goto L14;
        if (StringsKt.contains$default(r20, "\\\"ver\\\":6", false, 2, null) == true) goto L14;
        r8 = false;
        goto L16
    }
}
