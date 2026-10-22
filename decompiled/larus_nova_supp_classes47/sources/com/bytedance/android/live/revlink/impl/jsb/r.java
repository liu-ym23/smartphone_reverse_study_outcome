package com.bytedance.android.live.revlink.impl.jsb;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revlink.impl.pk.service.TopBannerDetailsDataContext;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.ITeamTask;
import com.bytedance.android.livesdk.link.model.d4;
import com.bytedance.android.livesdk.link.model.h9;
import com.bytedance.android.livesdk.link.model.i9;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.lang.reflect.Type;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;
import w20.b4;
import w20.xb;
import w20.yb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r extends wy0.b<xb, yb> {
    public static d4 e;
    public final Type a;
    public final com.bytedance.android.live.revlink.impl.global.c b;
    public final ld.a c;
    public final wq2.f d;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.android.live.revlink.impl.pk.utils.q m() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkUtils();
    }

    @Override // wy0.b
    public final Type k() {
        return this.a;
    }

    public static Pair n(xb r3) {
        JSONObject r0 = b4.a(r3);
        if (r0 == null) goto L5;
        long r1 = JSONObjectProtectorUtils.getLong(r0, "designated_gift_id");
    L6:
        JSONObject r4 = b4.a(r3);
        if (r4 == null) goto L10;
        String r5 = JSONObjectProtectorUtils.getString(r4, "designated_gift_name");
        if (r5 == null) goto L10;
    L12:
        return TuplesKt.to(Long.valueOf(r1), r5);
    L10:
        r5 = "";
        goto L12
    L5:
        r1 = 0;
        goto L6
    }

    @Override // wy0.b
    public final void l(vh7.j r13, CallContext r14) {
        xb r15 = (xb) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "callContext");
        jy0.b.d("NotifyPKEventMethod", "param: " + r15);
        int r1 = 0;
        boolean r2 = false;
        boolean r3 = false;
        int r4 = 0;
        int r5 = 0;
        boolean r6 = false;
        int r7 = 0;
        if (r15.getEventName() != 1) goto L33;
        com.bytedance.android.live.revlink.impl.pk.utils.q r16 = m();
        if (r16 == null) goto L21;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r17 = r16.g();
        if (r17 == null) goto L21;
        com.bytedance.android.live.revlink.impl.pk.vm.pk.e r18 = r17.getTeamTaskService();
        if (r18 == null) goto L21;
        JSONObject r8 = b4.a(r15);
        if (r8 == null) goto L19;
        long r9 = JSONObjectProtectorUtils.getLong(r8, "role");
        long r10 = JSONObjectProtectorUtils.getLong(r8, "ratio");
        if (r9 != ITeamTask.Role.RoleAttacker.ordinal()) goto L17;
        float r12 = (r10 * 1.0f) / (r10 + ((long) 100));
    L20:
        r18.setTeamTaskRatio(r12);
        goto L21
    L17:
        if (r9 != ITeamTask.Role.RoleDefender.ordinal()) goto L19;
        r12 = 1 - ((r10 * 1.0f) / (r10 + ((long) 100)));
    L19:
        r12 = 0.0f;
    L21:
        com.bytedance.android.live.revlink.impl.pk.utils.q r19 = m();
        if (r19 == null) goto L252;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r110 = r19.g();
        if (r110 == null) goto L253;
        MutableLiveData<Boolean> r111 = r110.getPkProgressBarSecKillLine();
        if (r111 == null) goto L254;
        JSONObject r112 = b4.a(r15);
        if (r112 == null) goto L31;
        r2 = JSONObjectProtectorUtils.getBoolean(r112, "show");
    L31:
        r111.postValue(Boolean.valueOf(r2));
        return;
    L254:
        return;
    L253:
        return;
    L252:
        return;
    L33:
        if (r15.getEventName() != 2) goto L46;
        com.bytedance.android.live.revlink.impl.pk.utils.q r113 = m();
        if (r113 == null) goto L256;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r114 = r113.g();
        if (r114 == null) goto L257;
        MutableLiveData<Boolean> r115 = r114.getPkProgressBarAdditionAnim();
        if (r115 == null) goto L258;
        JSONObject r116 = b4.a(r15);
        if (r116 == null) goto L44;
        r3 = JSONObjectProtectorUtils.getBoolean(r116, "show");
    L44:
        r115.postValue(Boolean.valueOf(r3));
        return;
    L258:
        return;
    L257:
        return;
    L256:
        return;
    L46:
        if (r15.getEventName() == 3) goto L260;
        com.bytedance.android.live.revlink.impl.precisefind.a r20 = null;
        TopBannerDetailsDataContext r22 = null;
        com.bytedance.android.live.revlink.impl.multianchor.service.c r23 = null;
        Object r24 = null;
        com.bytedance.android.live.revlink.impl.pk.service.h r25 = null;
        com.bytedance.android.live.revlink.impl.pk.service.h r26 = null;
        gt1.b r27 = null;
        r27 = null;
        com.bytedance.android.live.revlink.impl.control.d r28 = null;
        if (r15.getEventName() != 8) goto L59;
        Pair r117 = n(r15);
        com.bytedance.android.live.revlink.impl.global.c r118 = this.b;
        if (r118 == null) goto L52;
        r22 = r118.e7();
    L52:
        if (r22 == null) goto L261;
        com.bytedance.live.datacontext.n<TopBannerDetailsDataContext.b> r119 = r22.getUpdateGiftInfoService();
        if (r119 == null) goto L262;
        TopBannerDetailsDataContext.b r120 = (TopBannerDetailsDataContext.b) r119.getValue();
        if (r120 == null) goto L263;
        ((Number) r117.getFirst()).longValue();
        String r121 = (String) r117.getSecond();
        r120.a();
        return;
    L263:
        return;
    L262:
        return;
    L261:
        return;
    L59:
        if (r15.getEventName() != 7) goto L78;
        JSONObject r122 = b4.a(r15);
        if (r122 == null) goto L63;
        int r123 = JSONObjectProtectorUtils.getInt(r122, "operation_type");
    L64:
        if (r123 != 1) goto L265;
        Pair r124 = n(r15);
        IBattleConfigSetting r125 = vh7.f.c(IBattleConfigSetting.class);
        h9 r0 = vh7.f.c(h9.class);
        r0.setGiftIds(com.bytedance.revenue.platform.api.core.c.a(new Long[]{(Long) r124.getFirst()}));
        Object r29 = r124.getFirst();
        i9 r30 = vh7.f.c(i9.class);
        r30.setGiftName((String) r124.getSecond());
        Unit r126 = Unit.INSTANCE;
        r0.setGiftMap(com.bytedance.revenue.platform.api.core.d.a(new Pair[]{TuplesKt.to(r29, r30)}));
        com.bytedance.android.live.revlink.impl.global.c r127 = this.b;
        if (r127 == null) goto L68;
        com.bytedance.android.live.revlink.impl.utils.s r128 = r127.getRevLinkCommonUtil();
    L69:
        if (r128 == null) goto L71;
        String r129 = r128.e();
    L72:
        r0.setSetUid(r129);
        r125.setSpecifyGiftConfig(r0);
        com.bytedance.android.live.revlink.impl.global.c r130 = this.b;
        if (r130 == null) goto L75;
        r23 = r130.O4();
    L75:
        if (r23 == null) goto L266;
        r23.eb(r125, com.bytedance.android.live.revlink.impl.pk.utils.l.f.c);
        return;
    L266:
        return;
    L71:
        r129 = null;
        goto L72
    L68:
        r128 = null;
        goto L69
    L265:
        return;
    L63:
        r123 = 0;
        goto L64
    L78:
        if (r15.getEventName() != 10) goto L105;
        d51.c r131 = d51.c.A0;
        r131.getClass();
        if (((Boolean) d51.c.K.getValue(r131, d51.c.a[35])).booleanValue() == false) goto L297;
        JSONObject r32 = b4.a(r15);
        if (r32 == null) goto L85;
        int r33 = JSONObjectProtectorUtils.getInt(r32, "operation_type");
    L86:
        JSONObject r34 = b4.a(r15);
        if (r34 == null) goto L89;
        int r35 = JSONObjectProtectorUtils.getInt(r34, "self_reward");
    L90:
        JSONObject r36 = b4.a(r15);
        if (r36 == null) goto L93;
        int r37 = JSONObjectProtectorUtils.getInt(r36, "oppo_reward");
    L94:
        JSONObject r132 = b4.a(r15);
        if (r132 == null) goto L97;
        r4 = JSONObjectProtectorUtils.getInt(r132, "anchor_type");
    L97:
        h0 r133 = new h0(r33, r4, r35, r37);
        com.bytedance.android.live.revlink.impl.pk.utils.q r134 = m();
        if (r134 == null) goto L268;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r135 = r134.g();
        if (r135 == null) goto L269;
        MutableLiveData<h0> r136 = r135.getTeamTaskOptAddition();
        if (r136 == null) goto L270;
        r136.postValue(r133);
        return;
    L270:
        return;
    L269:
        return;
    L268:
        return;
    L93:
        r37 = 0;
        goto L94
    L89:
        r35 = 0;
        goto L90
    L85:
        r33 = 0;
        goto L86
    L297:
        return;
    L105:
        if (r15.getEventName() != 11) goto L108;
        r15.getEventName();
        return;
    L108:
        if (r15.getEventName() != 12) goto L120;
        JSONObject r137 = b4.a(r15);
        if (r137 == null) goto L112;
        r5 = JSONObjectProtectorUtils.getInt(r137, "operation_type");
    L112:
        com.bytedance.android.live.revlink.impl.pk.utils.q r138 = m();
        if (r138 == null) goto L273;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r139 = r138.g();
        if (r139 == null) goto L274;
        MutableLiveData<Integer> r140 = r139.getContributionListAlphaEvent();
        if (r140 == null) goto L275;
        r140.postValue(Integer.valueOf(r5));
        return;
    L275:
        return;
    L274:
        return;
    L273:
        return;
    L120:
        if (r15.getEventName() != 13) goto L139;
        JSONObject r141 = b4.a(r15);
        if (r141 == null) goto L298;
        JSONObjectProtectorUtils.getInt(r141, "operation_type");
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L131
        String r143 = JSONObjectProtectorUtils.getString(r141, "custom_config");     // Catch: Throwable -> L131
        if (r143 == null) goto L128;
        d4 r144 = (d4) l97.a.a.fromJson(r143, TypesJVMKt.getJavaType(Reflection.typeOf(d4.class)));     // Catch: Throwable -> L131
    L129:
        Object r145 = Result.constructor-impl(r144);     // Catch: Throwable -> L131
    L134:
        if (Result.isFailure-impl(r145) == true) goto L137;
        r24 = r145;
    L137:
        e = (d4) r24;
        return;
    L128:
        r144 = null;
    L131:
        th = move-exception;
        Result.Companion r146 = Result.Companion;
        r145 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L134
    L298:
        return;
    L139:
        if (r15.getEventName() != 14) goto L148;
        JSONObject r147 = b4.a(r15);
        if (r147 == null) goto L299;
        int r148 = JSONObjectProtectorUtils.getInt(r147, "operation_type");
        int r149 = JSONObjectProtectorUtils.getInt(r147, "gift_tray_bottom_margin");
        cy0.e.a.getClass();
        cy0.j r38 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r39 = com.bytedance.android.scope.m.b(r38).b(com.bytedance.android.livesdk.revenue.service.gift.a.class);
        Intrinsics.checkNotNull(r39);
        com.bytedance.android.livesdk.revenue.service.gift.a r40 = (com.bytedance.live.kmp.core.c) r39;
        int r150 = com.bytedance.android.live.revenue.common.i.b(r149);
        if (r148 != 1) goto L146;
        r6 = true;
    L146:
        r40.updateGiftTrayPosition(new zg1.f0(r150, r6));
        return;
    L299:
        return;
    L148:
        if (r15.getEventName() != 15) goto L155;
        com.bytedance.android.live.revlink.impl.global.c r151 = this.b;
        if (r151 == null) goto L152;
        r25 = r151.V0();
    L152:
        if (r25 == null) goto L279;
        r25.onLynxMicInteractionEvent(1);
        return;
    L279:
        return;
    L155:
        if (r15.getEventName() != 16) goto L161;
        com.bytedance.android.live.revlink.impl.global.c r152 = this.b;
        if (r152 == null) goto L159;
        r26 = r152.V0();
    L159:
        if (r26 == null) goto L281;
        r26.onLynxMicInteractionEvent(2);
        return;
    L281:
        return;
    L161:
        String r42 = "";
        if (r15.getEventName() != 30) goto L175;
        JSONObject r153 = b4.a(r15);
        if (r153 == null) goto L169;
        String r154 = JSONObjectProtectorUtils.getString(r153, "source");
        if (r154 == null) goto L169;
        r42 = r154;
    L169:
        com.bytedance.android.live.revlink.impl.global.c r155 = this.b;
        if (r155 == null) goto L283;
        com.bytedance.android.live.revlink.impl.service.internal.a r156 = r155.Do();
        if (r156 == null) goto L284;
        r156.Ak(r42);
        return;
    L284:
        return;
    L283:
        return;
    L175:
        if (r15.getEventName() != 19) goto L192;
        if (b4.a(r15) == null) goto L300;
        JSONObject r157 = b4.a(r15);
        if (r157 == null) goto L182;
        int r158 = r157.optInt("width");
    L183:
        JSONObject r159 = b4.a(r15);
        if (r159 == null) goto L186;
        r7 = r159.optInt("width_ratio");
    L186:
        b03.a r160 = b03.a.a;
        s1.y();
        if (r7 > 0) goto L301;
        if (r158 <= 0) goto L286;
        com.bytedance.android.live.revenue.common.i.b(r158);
        return;
    L286:
        return;
    L301:
        return;
    L182:
        r158 = 0;
        goto L183
    L300:
        return;
    L192:
        if (r15.getEventName() != 42) goto L211;
        if (b4.a(r15) == null) goto L302;
        ld.a r161 = this.c;
        if (r161 == null) goto L201;
        NextLiveData r162 = r161.ho();
        if (r162 == null) goto L201;
        r27 = (gt1.b) r162.getValue();
    L201:
        if (r27 != null) goto L203;
        return;
    L203:
        if (r27.getBottom() == 0) goto L303;
        JSONObject r163 = b4.a(r15);
        if (r163 == null) goto L208;
        int r164 = r163.optInt("lynx_view_height");
    L209:
        final qr2.d r165 = new qr2.d();
        r165.f = 1;
        r165.b = r27.d();
        r165.c = r27.e();
        r165.d = r27.b();
        r165.e = r27.a();
        r165.g = r27.getTop();
        r165.h = r27.getBottom();
        r165.i = r27.getLeft();
        r165.j = r27.getRight();
        r165.p = o51.f.j.e.c;
        r165.q = 0;
        r165.a = com.bytedance.android.live.revenue.common.i.b(r164);
        p0.a(0, false, true, new NotifyPKEventMethod$invokeActual$1(this, r165), 3);
        return;
    L208:
        r164 = 0;
        goto L209
    L303:
        return;
    L302:
        return;
    L211:
        if (r15.getEventName() != 20) goto L224;
        if (b4.a(r15) == null) goto L304;
        JSONObject r166 = b4.a(r15);
        if (r166 == null) goto L218;
        r1 = r166.optInt("accept");
    L218:
        com.bytedance.android.live.revlink.impl.global.c r167 = this.b;
        if (r167 == null) goto L290;
        com.bytedance.android.live.revlink.impl.service.internal.a r168 = r167.Do();
        if (r168 == null) goto L291;
        r168.onPrecisionMatchEvent(r1);
        return;
    L291:
        return;
    L290:
        return;
    L304:
        return;
    L224:
        if (r15.getEventName() != 21) goto L240;
        if (b4.a(r15) == null) goto L305;
        JSONObject r169 = b4.a(r15);
        if (r169 == null) goto L234;
        String r170 = JSONObjectProtectorUtils.getString(r169, "request_id");
        if (r170 == null) goto L234;
        r42 = r170;
    L234:
        com.bytedance.android.live.revlink.impl.global.c r171 = this.b;
        if (r171 == null) goto L237;
        r28 = r171.Rc();
    L237:
        if (r28 == null) goto L293;
        r28.setRequestId(r42);
        return;
    L293:
        return;
    L305:
        return;
    L240:
        if (r15.getEventName() == 22) goto L242;
        return;
    L242:
        if (b4.a(r15) == null) goto L306;
        com.bytedance.android.live.revlink.impl.global.c r172 = this.b;
        if (r172 == null) goto L247;
        r20 = r172.Wd();
    L247:
        if (r20 == null) goto L296;
        r20.ro(b4.a(r15));
        return;
    L296:
        return;
    L306:
        return;
    }

    public r(com.bytedance.android.live.revlink.impl.global.c r1, ld.a r2, wq2.f r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = TypesJVMKt.getJavaType(Reflection.typeOf(xb.class));
    }
}
