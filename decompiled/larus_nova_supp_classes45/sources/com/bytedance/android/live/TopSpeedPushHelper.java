package com.bytedance.android.live;

import am2.x;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.bytedance.android.live.base.model.push.LivePushInfo;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.playopt.base.LivePlayOptUtils;
import com.bytedance.android.live.room.api.playopt.topspeed.log.TopSpeedTrace;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.z0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class TopSpeedPushHelper {
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> a = null;
    public static final Function1<LivePushInfo.f, Unit> b = null;

    public TopSpeedPushHelper() {
    }

    static {
        a = new com.bytedance.android.livesdk.sharedpref.e("is_show_topSpeed_guide", Boolean.FALSE);
        b = TopSpeedPushHelper$reportAction$1.INSTANCE;
    }

    public static final void a() {
        SimpleAlogArgsBuilder r0 = new SimpleAlogArgsBuilder();
        r0.d("LiveTopSpeedLog");
        r0.c("展示自动切换push");
        TopSpeedTrace.c(r0.b());
        SpannableString r1 = new SpannableString("可在 播放优化 中修改设置");
        ForegroundColorSpan r7 = new ForegroundColorSpan(ColorProtector.parseColor("#FE2C55"));
        int r2 = StringsKt.indexOf$default(r1, "播放优化", 0, false, 6, null);
        r1.setSpan(r7, r2, r2 + 4, 33);
        IHostAction r3 = k.f(IHostAction.class);
        if (r3 == null) goto L6;
        int r4 = LivePushInfo.e;
        com.bytedance.android.live.base.model.push.b r5 = new com.bytedance.android.live.base.model.push.b();
        r5.setScene("topspeed_mode");
        r5.setTitle("切换成功！");
        r5.setDuration(LivePlayOptUtils.a());
        Intrinsics.checkNotNullParameter(s1.m(2131251378), "drawable");
        r5.a = r1;
        Unit r6 = Unit.INSTANCE;
        LivePushInfo.a r8 = LivePushInfo.c.a(r5);
        r8.b(TopSpeedPushHelper$showOptSuccessPush$3.INSTANCE);
        r8.c(b);
        r8.a(new Pair[]{TuplesKt.to("push_reason", "experienceOpt_change"), TuplesKt.to("content", r1.toString()), TuplesKt.to("button_type", "switch_success"), TuplesKt.to("degrade_level", GamePromoteDataContext.GAME_TYPE_MINI)});
        r3.showLiveCommonInnerPush(new LivePushInfo(r8));
        return;
    }

    public static void c() {
        boolean r0 = LiveExpPushHelper.a();
        if (r0 == false) goto L6;
        SimpleAlogArgsBuilder r1 = new SimpleAlogArgsBuilder();
        r1.d("LiveTopSpeedLog");
        r1.c("极速性能模式push被频控了, inInterval：" + r0);
        TopSpeedTrace.c(r1.b());
        return;
    L6:
        IHostAction r2 = k.f(IHostAction.class);
        if (r2 == null) goto L9;
        int r3 = LivePushInfo.e;
        com.bytedance.android.live.base.model.push.b r4 = new com.bytedance.android.live.base.model.push.b();
        r4.setTitle("即将开启极速性能模式");
        r4.setContent("检测到轻微卡顿，开启后流畅看播");
        r4.setButtonText("不开启");
        r4.setScene("topspeed_mode");
        r4.setDuration(LivePlayOptUtils.a());
        Unit r5 = Unit.INSTANCE;
        LivePushInfo.a r6 = LivePushInfo.c.a(r4);
        r6.b(TopSpeedPushHelper$showPushAtPrefPoor$3.INSTANCE);
        r6.c(b);
        r6.a(new Pair[]{TuplesKt.to("push_reason", "poor"), TuplesKt.to("btn_text", "not_open")});
        r2.showLiveCommonInnerPush(new LivePushInfo(r6));
    L9:
        TopSpeedTrace.b.a("triggered PrefPoor push");
        LiveExpPushHelper.b();
    }

    public static void d() {
        boolean r0 = LiveExpPushHelper.a();
        if (r0 == false) goto L6;
        SimpleAlogArgsBuilder r1 = new SimpleAlogArgsBuilder();
        r1.d("LiveTopSpeedLog");
        r1.c("极速性能模式push被频控了, inInterval：" + r0);
        TopSpeedTrace.c(r1.b());
        return;
    L6:
        IHostAction r2 = k.f(IHostAction.class);
        if (r2 == null) goto L9;
        int r3 = LivePushInfo.e;
        com.bytedance.android.live.base.model.push.b r4 = new com.bytedance.android.live.base.model.push.b();
        r4.setTitle("即将开启极速性能模式");
        r4.setContent("检测到轻微卡顿，开启后流畅看播");
        r4.setButtonText("不开启");
        r4.setScene("topspeed_mode");
        r4.setDuration(LivePlayOptUtils.a());
        Unit r5 = Unit.INSTANCE;
        LivePushInfo.a r6 = LivePushInfo.c.a(r4);
        r6.b(TopSpeedPushHelper$showPushAtPrefRatherPoor$3.INSTANCE);
        r6.c(b);
        r6.a(new Pair[]{TuplesKt.to("push_reason", "not_good"), TuplesKt.to("btn_text", "not_open")});
        r2.showLiveCommonInnerPush(new LivePushInfo(r6));
    L9:
        TopSpeedTrace.b.a("triggered PrefRatherPoor push");
        LiveExpPushHelper.b();
    }

    public static void e() {
        boolean r0 = LiveExpPushHelper.a();
        if (r0 == false) goto L6;
        SimpleAlogArgsBuilder r1 = new SimpleAlogArgsBuilder();
        r1.d("LiveTopSpeedLog");
        r1.c("极速性能模式push被频控了, inInterval：" + r0);
        TopSpeedTrace.c(r1.b());
        return;
    L6:
        IHostAction r2 = k.f(IHostAction.class);
        if (r2 == null) goto L9;
        int r3 = LivePushInfo.e;
        com.bytedance.android.live.base.model.push.b r4 = new com.bytedance.android.live.base.model.push.b();
        r4.setTitle("建议提前开启极速性能模式");
        r4.setContent("发热卡顿耗电风险大，可能影响观看");
        r4.setButtonText("去开启");
        r4.setScene("topspeed_mode");
        r4.setDuration(LivePlayOptUtils.a());
        Unit r5 = Unit.INSTANCE;
        LivePushInfo.a r6 = LivePushInfo.c.a(r4);
        r6.b(TopSpeedPushHelper$showPushAtPrefRisk$3.INSTANCE);
        r6.c(b);
        r6.a(new Pair[]{TuplesKt.to("push_reason", "risk"), TuplesKt.to("btn_text", "go_and_open")});
        r2.showLiveCommonInnerPush(new LivePushInfo(r6));
    L9:
        TopSpeedTrace.b.a("triggered PrefRisk push");
        LiveExpPushHelper.b();
    }

    public static void b(com.bytedance.android.live.base.model.push.b r3, String r4, Map r5) {
        Intrinsics.checkNotNullParameter(r3, "pushMessage");
        Intrinsics.checkNotNullParameter(r4, "actType");
        Intrinsics.checkNotNullParameter(r5, "logExtra");
        HashMap r0 = new HashMap();
        String r1 = r3.getScene();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put("business_scene", r1);
        r0.put("action_type", r4);
        int r6 = z0.a();
        Integer r2 = z0.d;
        if (r2 != null) goto L9;
    L11:
        String r7 = "non_low_level";
    L12:
        r0.put("machine_level", r7);
        r0.put("content", String.valueOf(r3.getContent()));
        r0.putAll(r5);
        u.l().sendLog("livesdk_live_common_inner_push", r0, new Object[]{x.class, Room.class});
        return;
    L9:
        if (r6 != r2.intValue()) goto L11;
        r7 = "low_level";
        goto L12
    }
}
