package v72;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.g4;
import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.base.model.message.o6;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.l61;
import com.bytedance.android.livesdk.config.o20;
import com.bytedance.android.livesdk.config.p4;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.HighlevelNoMessageMonitorEnum;
import com.bytedance.android.livesdk.interactivity.api.settings.config.h;
import com.bytedance.android.livesdk.interactivity.enteranim.EnterAnimWidget;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.OpenAssetVideoPlayer;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.o;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.EnterAnimAppLogger;
import com.bytedance.android.livesdk.interactivity.enteranim.utils.j;
import com.bytedance.android.livesdk.interactivity.enteranim.view.EnterAnimationView;
import com.bytedance.android.livesdk.log.k0;
import com.bytedance.android.livesdk.message.model.pg;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import ec2.x;
import ec2.y;
import gd0.v;
import j40.q1;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r52.l0;
import r72.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements u72.a, View.OnClickListener {
    public final HandlerC0288c A;
    public DataCenter a;
    public InteractivityPlatformContext b;
    public final Context c;
    public final EnterAnimationView d;
    public f e;
    public l f;
    public k32.a g;
    public int h;
    public Animator i;
    public h32.a j;
    public f32.b k;
    public f32.c l;
    public long m;
    public int n;
    public boolean o;
    public int p;
    public x72.a q;
    public x72.c r;
    public final com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c s;
    public final RevenueUtils t;
    public com.bytedance.android.livesdk.interactivity.d u;
    public final v72.a v;
    public final v72.b w;
    public final a x;
    public final b y;
    public long z;

    public class a implements com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a {
        public final /* synthetic */ c a;

        public final void a() {
            c r0 = this.a;
            if (r0.m > 0) goto L5;
        L37:
            this.a.z = System.currentTimeMillis();
            RevenueUtils.i.getClass();
            IPerformanceManager r1 = k.f(IPerformanceManager.class);
            if (r1 == null) goto L40;
            r1.onModuleStop("user_enter");
        L40:
            c r2 = this.a;
            r2.n--;
            DataCenter r3 = r2.a;
            if (r3 == null) goto L43;
            r3.put("data_enter_anim_showing", Boolean.FALSE);
        L43:
            c r4 = this.a;
            if (r4.n >= 0) goto L46;
            r4.n = 0;
        L46:
            r4.d();
            return;
        L5:
            if (r0.g == null) goto L37;
            int r5 = g.a;
            long r6 = SystemClock.uptimeMillis();
            c r7 = this.a;
            long r8 = r6 - r7.m;
            k32.a r9 = r7.g;
            String r10 = r9.a;
            Intrinsics.checkNotNullParameter(r10, "userId");
            Intrinsics.checkNotNullParameter(r9, "curMsg");
        L35:
            e = move-exception;
            SafetyGuard.a(null, e, null);
            goto L37
        L8:
            if (LocalTestManager.c(new Class[]{wy.a.class}) == false) goto L11;
            ALogger.i("enter monitor", "time cost: " + r8);     // Catch: Exception -> L35
        L11:
            if ((r9 instanceof k32.c) == true) goto L13;
        L15:
            va.a r11 = r9.k;     // Catch: Exception -> L35
            if (r11 == null) goto L23;
            if (EnterAnimAppLogger.d(r11, r9) == false) goto L23;
            if (r8 < 30000) goto L37;
        L23:
            if (r8 <= 10000) goto L26;
            int r13 = 1;
        L29:
            if (r13 == 0) goto L37;
            JSONObject r14 = new JSONObject();     // Catch: Exception -> L35
            r14.put("anim_exception", r13);     // Catch: Exception -> L35
            if (r8 <= 30000) goto L33;
            r14.put("anim_blocked", 1);     // Catch: Exception -> L35
        L33:
            JSONObject r15 = new JSONObject();     // Catch: Exception -> L35
            r15.put("anim_time_consume", r8);     // Catch: Exception -> L35
            JSONObject r16 = new JSONObject();     // Catch: Exception -> L35
            r16.put("msgId", r10);     // Catch: Exception -> L35
            LiveTracingMonitor.f("ttlive_high_level_msg_monitor", LiveTracingMonitor.EventModule.INTERACTIVITY, r14, r15, r16);     // Catch: Exception -> L35
            goto L37
        L26:
            if (r8 >= IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW) goto L28;
            r13 = 2;
            goto L29
        L28:
            r13 = 0;
            goto L29
        L13:
            if (r8 >= 30000) goto L15;
            goto L15
        }

        public final void b() {
            DataCenter r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.put("data_enter_anim_showing", Boolean.TRUE);
            return;
        }

        public a(c r1) {
            this.a = r1;
        }
    }

    public class b {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: v72.c$c, reason: collision with other inner class name */
    public class HandlerC0288c extends Handler {
        public final /* synthetic */ c a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            if (r2.what != 12345) goto L6;
            this.a.e();
            return;
        }

        public HandlerC0288c(c r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public final void d() {
        int r0 = h.a;
        if (((h) l0.a.getValue()).a() == true) goto L9;
        if (((p4) o20.a.getValue()).b() == true) goto L9;
        e();
        return;
    L9:
        if (this.n < 1) goto L11;
        return;
    L11:
        long r1 = this.l.a;
        long r2 = System.currentTimeMillis() - this.z;
        if (r2 < 0) goto L19;
        if (r2 >= r1) goto L19;
        if (this.A.hasMessages(12345) == true) goto L23;
        this.A.sendEmptyMessageDelayed(12345, r1 - r2);
        return;
    L23:
        return;
    L19:
        if (this.A.hasMessages(12345) == true) goto L25;
        this.A.sendEmptyMessage(12345);
        return;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View, com.bytedance.android.livesdk.interactivity.enteranim.view.EnterAnimationView] */
    public final void e() {
        if (((Boolean) j40.b.a.getValue()).booleanValue() == false) goto L17;
        DataCenter r0 = this.a;
        if (r0 == null) goto L7;
        int r1 = ((Integer) r0.get("data_link_state", 0)).intValue();
    L9:
        if (this.o == false) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
        ALogger.i("DefaultEntryController", "intercept play animation in pk mode");
    L21:
        boolean r3 = false;
    L23:
        if (r3 == true) goto L25;
        return;
    L25:
        f r4 = this.e;
        if (r4 != null) goto L29;
        return;
    L29:
        if (r4.c.a.isEmpty() == false) goto L31;
        return;
    L31:
        int r5 = this.n;
        if (r5 < 1) goto L34;
        return;
    L34:
        this.n = r5 + 1;
        f r6 = this.e;
        b r7 = this.y;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "pollInterceptor");
        long r8 = 0;
        if (r6.c.a.isEmpty() == false) goto L37;
    L143:
        k32.a r13 = null;
    L144:
        this.g = r13;
        if (r13 == null) goto L429;
        int r9 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a;
        Intrinsics.checkNotNullParameter(r13, "message");
        if ((r13 instanceof k32.b) == false) goto L149;
    L160:
        boolean r15 = true;
    L161:
        if (r15 == true) goto L163;
    L165:
        boolean r16 = false;
    L166:
        Intrinsics.checkNotNullParameter(r13, "message");
        boolean r10 = r13 instanceof y72.a;
        boolean r11 = r13 instanceof k32.d;
        String r14 = BuildConfig.FLAVOR;
        if (r11 == false) goto L178;
        g4.e0.getClass();
        List r17 = g4.a.b;
        h3 r18 = ((k32.d) r13).t;
        if (r18 == null) goto L174;
        pg.c r19 = r18.M();
        if (r19 == null) goto L174;
        String r20 = r19.getScene();
        if (r20 == null) goto L174;
    L176:
        if (r17.contains(r20) == false) goto L178;
        boolean r21 = true;
    L179:
        if (r11 == false) goto L189;
        h3 r23 = ((k32.d) r13).t;
        if (r23 == null) goto L185;
        pg.c r24 = r23.M();
        if (r24 == null) goto L185;
        String r25 = r24.getScene();
    L187:
        if (Intrinsics.areEqual(r25, "game_download") == false) goto L189;
        boolean r26 = true;
    L190:
        if (r10 == true) goto L195;
        if (r21 == true) goto L195;
        if (r26 == true) goto L195;
        boolean r27 = false;
    L196:
        if (r27 == true) goto L198;
    L200:
        boolean r28 = false;
    L201:
        Intrinsics.checkNotNullParameter(r13, "message");
        if (r13.k == null) goto L204;
        boolean r29 = true;
    L205:
        if (r29 == true) goto L207;
    L209:
        boolean r30 = false;
    L210:
        Intrinsics.checkNotNullParameter(r13, "message");
        if (r11 == false) goto L229;
        g4.e0.getClass();
        List r31 = g4.a.b;
        k32.d r33 = (k32.d) r13;
        h3 r34 = r33.t;
        if (r34 == null) goto L217;
        pg.c r35 = r34.M();
        if (r35 == null) goto L217;
        String r36 = r35.getScene();
    L219:
        if (CollectionsKt.contains(r31, r36) == true) goto L228;
        List r37 = g4.a.c;
        h3 r38 = r33.t;
        if (r38 == null) goto L225;
        pg.c r39 = r38.M();
        if (r39 == null) goto L225;
        String r40 = r39.getScene();
    L227:
        if (CollectionsKt.contains(r37, r40) == false) goto L229;
    L225:
        r40 = null;
    L228:
        boolean r41 = true;
    L230:
        if (r41 == true) goto L232;
    L234:
        boolean r43 = false;
    L235:
        if (r16 == true) goto L241;
        if (r30 == true) goto L241;
        if (r43 == true) goto L241;
        if (r28 == true) goto L241;
        boolean r44 = false;
    L242:
        if (r44 == true) goto L244;
    L250:
        if (r44 == false) goto L252;
        ALogger.i("DefaultEntryController", "drop due to degrade, ecom: " + r16 + ", game:" + r28 + ", highLevel: " + r30);
    L252:
        if (r44 == true) goto L429;
        long r45 = SystemClock.uptimeMillis();
        MeasureOptFrameLayout r46 = this.d;
        if (r46 != null) goto L257;
    L425:
        int r47 = this.n;
        if (r47 != 1) goto L453;
        this.n = r47 - 1;
        return;
    L453:
        return;
    L257:
        if (r46.getContext() == null) goto L425;
        if (this.c == null) goto L425;
        com.bytedance.android.livesdk.interactivity.d r48 = this.u;
        if (r48 == null) goto L266;
        EnterAnimWidget r49 = ((EnterAnimWidget.a) r48).a;
        if (r49.l == false) goto L266;
        r49.l = false;
        r49.h.a(((Widget) r49).containerView, 8, false);
    L266:
        this.m = SystemClock.uptimeMillis();
        boolean r50 = this.g instanceof k32.d;
        if (r50 == true) goto L269;
        c r51 = this;
    L270:
        if (r50 == false) goto L272;
        z32.b.a(HighlevelNoMessageMonitorEnum.NotifyShowCount);
    L273:
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c r53 = this.s;
        final k32.a r110 = this.g;
        final Context r54 = this.c;
        final AnimPlayer.a r111 = new AnimPlayer.a(this.h, r45, r51);
        final ?? r55 = this.d;
        final a r112 = this.x;
        r53.getClass();
        AnimPlayer.PlayerType r56 = com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c.a(r110);
        if (r56 != AnimPlayer.PlayerType.DouyinDefault) goto L277;
        r112.a();
    L298:
        if (k.f(IMiddlewareUserService.class) != null) goto L300;
    L308:
        k32.a r57 = this.g;
        if (r57 != null) goto L311;
        int r58 = EnterAnimAppLogger.a;
    L348:
        k32.a r59 = this.g;
        if (r59 == null) goto L449;
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c r60 = this.s;
        r60.getClass();
        if ((r60.a.get(com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c.a(r59)) instanceof OpenAssetVideoPlayer) == true) goto L450;
        EnterAnimAppLogger.g(1, this.g, this.p);
        k32.a r61 = this.g;
        if (r61 != null) goto L356;
        return;
    L356:
        if ((!Intrinsics.areEqual(r61.a, k.n(IMiddlewareUserService.class).user().n())) == true) goto L452;
        LinkedHashMap r63 = new LinkedHashMap();
        va.a r64 = r61.k;
        if (r64 == null) goto L367;
        String r65 = r64.getDressId();
        if (r65 == null) goto L367;
        com.bytedance.android.live.profit.dress.l r66 = yt0.c.a().getDressData(r65, 2, "reportEnterEffectProfitCheck");
        r63.put("enter_dress_id", r65);
        if (r66 == null) goto L367;
        String r67 = r66.o;
        if (r67 == null) goto L367;
        r63.put("avatar_border_dress_id", r67);
    L367:
        va.a r68 = r61.k;
        if (r68 == null) goto L376;
        a5 r69 = r68.getText();
        if (r69 == null) goto L376;
        String r70 = r69.getDefaultPattern();
        if (r70 == null) goto L375;
        r14 = r70;
    L375:
        r63.put("script", sb2.a.h(r69, r14, false).toString());
    L376:
        va.a r71 = r61.k;
        if (r71 == null) goto L387;
        Long r73 = Long.valueOf(r71.getAnimAssetId());
        if (r73.longValue() == 0) goto L381;
        boolean r113 = true;
    L382:
        if (r113 == true) goto L385;
        r73 = null;
    L385:
        if (r73 == null) goto L387;
        r63.put("enter_asset_id", Long.valueOf(r73.longValue()));
        goto L387
    L381:
        r113 = false;
    L387:
        va.a r74 = r61.k;
        if (r74 == null) goto L398;
        Long r75 = Long.valueOf(r74.getCenterAnimAssetId());
        if (r75.longValue() == 0) goto L392;
        boolean r114 = true;
    L393:
        if (r114 == true) goto L396;
        r75 = null;
    L396:
        if (r75 == null) goto L398;
        r63.put("enter_asset_id", Long.valueOf(r75.longValue()));
        goto L398
    L392:
        r114 = false;
    L398:
        va.a r76 = r61.k;
        if (r76 == null) goto L409;
        Long r77 = Long.valueOf(r76.a());
        if (r77.longValue() == 0) goto L403;
        boolean r115 = true;
    L404:
        if (r115 == true) goto L407;
        r77 = null;
    L407:
        if (r77 == null) goto L409;
        r63.put("enter_asset_id", Long.valueOf(r77.longValue()));
        goto L409
    L403:
        r115 = false;
    L409:
        py.k r78 = r61.d;
        if (r78 == null) goto L416;
        List r79 = r78.getUrls();
        if (r79 == null) goto L416;
        String r80 = (String) CollectionsKt.getOrNull(r79, 0);
        if (r80 == null) goto L416;
        r63.put("user_avatar_url", r80);
    L416:
        va.a r81 = r61.k;
        if (r81 == null) goto L423;
        py.k r83 = r81.getAnimatedBadge();
        if (r83 == null) goto L423;
        String r84 = r83.getUri();
        if (r84 == null) goto L423;
        r63.put("badge_uri", r84);
    L423:
        boolean r85 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class).B1(ProfitCheckType.ENTER_ROOM_EFFECT, r63, null);
        return;
    L452:
        return;
    L450:
        return;
    L449:
        return;
    L311:
        HashMap<String, String> r86 = EnterAnimAppLogger.c(r57);
        r86.put("show_time", String.valueOf(p6.b()));
        if ((r57 instanceof k32.d) == false) goto L347;
        k32.d r87 = (k32.d) r57;
        h3 r88 = r87.t;
        if (r88 == null) goto L318;
        Map<? extends String, ? extends String> r89 = r88.getBuriedPoint();
        if (r89 == null) goto L318;
        r86.putAll(r89);
    L318:
        h3 r90 = r87.t;
        int r91 = com.bytedance.android.livesdk.interactivity.enteranim.utils.f.a;
        if (r90 == null) goto L344;
        com.bytedance.android.live.base.model.message.d r93 = r90.I0();
        if (r93 == null) goto L344;
        List r94 = r93.b();
        if (r94 == null) goto L344;
        Iterator r95 = r94.iterator();
    L326:
        if (r95.hasNext() == false) goto L330;
        Object r96 = r95.next();
        if (((com.bytedance.android.live.base.model.message.f) r96).a() == false) goto L326;
    L331:
        com.bytedance.android.live.base.model.message.f r97 = (com.bytedance.android.live.base.model.message.f) r96;
        if (r97 == null) goto L344;
        o6 r98 = r97.g();
        if (r98 == null) goto L344;
        a5 r99 = r98.a();
        if (r99 == null) goto L344;
        List r100 = r99.getPieces();
        if (r100 == null) goto L344;
        c5 r101 = (c5) CollectionsKt.firstOrNull(r100);
        if (r101 == null) goto L344;
        String r102 = r101.getStringValue();
        if (r102 == null) goto L344;
        Long r103 = StringsKt.toLongOrNull(r102);
    L345:
        if (r103 == null) goto L347;
        String r104 = r86.put("show_num_cnt", String.valueOf(r103.longValue()));
        goto L347
    L330:
        r96 = null;
    L344:
        r103 = null;
    L347:
        EnterAnimAppLogger.i("livesdk_high_level_common_message_show", r86, null);
        goto L348
    L300:
        if (k.f(IMiddlewareUserService.class).user() == null) goto L308;
        k32.a r105 = this.g;
        if (r105 == null) goto L308;
        if (TextUtils.isEmpty(r105.a) == true) goto L308;
        if (TextUtils.equals(this.g.a, k.f(IMiddlewareUserService.class).user().n()) == true) goto L308;
        this.p++;
        goto L308
    L277:
        if (r56 != AnimPlayer.PlayerType.UnKnownEffect) goto L279;
        r112.a.n--;
        goto L298
    L279:
        final AnimPlayer<?> r106 = r53.a.get(r56);
        if (r106 != null) goto L433;
        int r107 = g.a;
        String r108 = "cant find proper player for type  " + r56 + " " + r110;
        Intrinsics.checkNotNullParameter(r108, "msg");
        ALogger.e("TTLIVE_ENTER_ANIM", r108);
        r112.a();
        goto L298
    L433:
        Runnable r109 = new com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.b(r106, r110, r54, r111, r55, r112);     // Catch: Exception -> L292
        Boolean r116 = com.bytedance.android.livesdk.interactivity.enteranim.utils.g.a;     // Catch: Exception -> L292
        Intrinsics.checkNotNullParameter(r109, "action");     // Catch: Exception -> L292
        if (com.bytedance.android.livesdk.interactivity.enteranim.utils.g.a.booleanValue() == true) goto L287;
        r109.run();     // Catch: Exception -> L292
    L288:
        va.a r117 = r110.k;     // Catch: Exception -> L292
        if (r117 == null) goto L298;
        RevenueUtils.a(String.valueOf(r117.getType()), r55, r110, r45);     // Catch: Exception -> L292
        RevenueUtils.e(r55, r110);     // Catch: Exception -> L292
        goto L298
    L287:
        long r118 = System.nanoTime();     // Catch: Exception -> L292
        r109.run();     // Catch: Exception -> L292
        com.bytedance.android.livesdk.interactivity.enteranim.utils.g.d += System.nanoTime() - r118;     // Catch: Exception -> L292
        com.bytedance.android.livesdk.interactivity.enteranim.utils.g.e++;     // Catch: Exception -> L292
    L292:
        e = e;
    L296:
        int r119 = g.a;
        Intrinsics.checkNotNullParameter("play Anim Error", "msg");
        ALogger.e("TTLIVE_ENTER_ANIM", "play Anim Error", e);
        SafetyGuard.a(null, e, null);
    L294:
        e = e;
        goto L296
    L272:
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberShowCount);
        goto L273
    L269:
        r51 = null;
        goto L270
    L244:
        if (this.k.d == false) goto L250;
        com.bytedance.android.livesdk.user.e r120 = k.f(IMiddlewareUserService.class).user();
        if (r120 == null) goto L248;
        String r121 = r120.n();
    L249:
        r44 = !TextUtils.equals(r121, r13.a);
        goto L250
    L248:
        r121 = BuildConfig.FLAVOR;
    L241:
        r44 = true;
        goto L242
    L232:
        if (this.k.c == false) goto L234;
        r43 = true;
    L217:
        r36 = null;
    L229:
        r41 = false;
        goto L230
    L207:
        if (this.k.b == false) goto L209;
        r30 = true;
        goto L210
    L204:
        r29 = false;
        goto L205
    L198:
        if (this.k.e == false) goto L200;
        r28 = true;
    L195:
        r27 = true;
    L185:
        r25 = null;
    L189:
        r26 = false;
    L174:
        r20 = BuildConfig.FLAVOR;
    L178:
        r21 = false;
        goto L179
    L163:
        if (this.k.a == false) goto L165;
        r16 = true;
        goto L166
    L149:
        if ((r13 instanceof k32.d) == false) goto L159;
        h3 r122 = ((k32.d) r13).t;
        if (r122 == null) goto L155;
        pg.c r123 = r122.M();
        if (r123 == null) goto L155;
        String r124 = r123.getScene();
    L157:
        if (Intrinsics.areEqual(r124, "ecom_barrage_buy") == false) goto L159;
    L155:
        r124 = null;
    L159:
        r15 = false;
    L429:
        int r125 = this.n;
        if (r125 != 1) goto L454;
        this.n = r125 - 1;
        return;
    L454:
        return;
    L37:
        if (r6.e == true) goto L143;
        Iterator<Map.Entry<Long, Deque<k32.a>>> r126 = r6.c.a.entrySet().iterator();
    L41:
        if (r126.hasNext() == false) goto L143;
        Deque<k32.a> r127 = r126.next().getValue();
        Iterator<k32.a> r128 = r127.iterator();
    L44:
        if (r128.hasNext() == false) goto L140;
        r13 = r128.next();
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c r129 = r7.a.s;
        if (r129.b == false) goto L54;
        if (r13 != null) goto L49;
        AnimPlayer<?> r130 = null;
    L50:
        if (r130 == null) goto L54;
        if ((r13 instanceof k32.d) == false) goto L54;
        boolean r131 = r130.a((k32.d) r13);
    L55:
        if (r131 == false) goto L44;
        r128.remove();
        String r132 = f.a(r13);
        if (r132 == null) goto L63;
        k32.a r133 = r6.b.get(r132);
        if (r133 == null) goto L63;
        r6.b.remove(r132);
        r13 = r133;
    L70:
        if (r13.o != r8) goto L73;
    L74:
        boolean r134 = true;
    L77:
        if ((r13 instanceof k32.d) == false) goto L131;
        e r135 = r6.d;
        k32.d r136 = (k32.d) r13;
        if (r135.f == null) goto L130;
        h3 r137 = r136.t;
        if (r137 == null) goto L130;
        pg.c r138 = r137.M();
        if (r138 == null) goto L130;
        String r139 = r138.getScene();
        if (r139 == null) goto L130;
        pg.c r140 = r137.M();
        if (r140 == null) goto L130;
        String r141 = r140.e();
        if (r141 == null) goto L130;
        Long r142 = r135.f.b.get(r141);
        long r143 = r137.getMessageId();
        if (r142 == null) goto L104;
        if (r143 <= 0) goto L104;
        Long r144 = (Long) ((HashMap) r135.a).get(Long.valueOf(r137.getMessageId()));
        if (r144 == null) goto L104;
        r144.longValue();
        ((HashMap) r135.a).remove(Long.valueOf(r137.getMessageId()));
        if (r142.longValue() >= (System.currentTimeMillis() - r144.longValue())) goto L104;
    L128:
        r134 = false;
    L104:
        if (e.b(r141, r135.d, r135.f.e) == false) goto L128;
        o r145 = r135.f.f.get(r141);
        if (r145 == null) goto L117;
        if (r145.b() == null) goto L117;
        if (r145.a() == null) goto L117;
        d r146 = e.a(r145, (d) ((HashMap) r135.e).get(r141));
        if (r146 == null) goto L128;
        ((HashMap) r135.e).put(r141, r146);
    L117:
        if (e.b(r139, r135.b, r135.f.c) == false) goto L128;
        if (r145 != null) goto L130;
        o r147 = r135.f.d.get(r139);
        if (r147 == null) goto L130;
        if (r147.b() == null) goto L130;
        if (r147.a() == null) goto L130;
        d r148 = e.a(r147, (d) ((HashMap) r135.c).get(r139));
        if (r148 == null) goto L128;
        ((HashMap) r135.c).put(r139, r148);
    L130:
        r134 = true;
    L131:
        if (r134 == true) goto L133;
        r8 = 0;
        goto L44
    L133:
        if (r127.isEmpty() == false) goto L135;
        r126.remove();
    L135:
        f.b r149 = r6.f;
        if (r149 == null) goto L144;
        r149.b(r149.b);
        goto L144
    L73:
        if ((SystemClock.elapsedRealtime() - r13.n) <= (r13.o * ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW))) goto L74;
        r134 = false;
    L63:
        if ((r13 instanceof k32.d) == false) goto L70;
        int r150 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a;
        Long r151 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a((k32.d) r13);
        if (r151 == null) goto L70;
        LinkedList<k32.d> r152 = r6.a.get(Long.valueOf(r151.longValue()));
        if (r152 == null) goto L70;
        k32.d r153 = r152.removeFirst();
        goto L70
    L49:
        r130 = r129.a.get(com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c.a(r13));
    L54:
        r131 = true;
        goto L55
    L140:
        if (r127.isEmpty() == false) goto L142;
        r126.remove();
    L142:
        r8 = 0;
        goto L41
    L11:
        if (v.a(r1, 4) == false) goto L14;
        r2 = false;
        goto L15
    L7:
        r1 = 0;
    L17:
        DataCenter r154 = this.a;
        if (r154 != null) goto L20;
    L22:
        r3 = true;
        goto L23
    L20:
        if (((Boolean) r154.get("cmd_vr_in_immersed_mode", Boolean.FALSE)).booleanValue() == false) goto L22;
        goto L21
    }

    public final void a(@Nullable k32.a r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        f r0 = this.e;
        if (r0 == null) goto L165;
        Intrinsics.checkNotNullParameter(r13, "userInfo");
        if (r0.e == true) goto L165;
        j<k32.a> r1 = r0.c;
        long r2 = r13.p;
        Deque<k32.a> r4 = r1.a.get(Long.valueOf(r2));
        if (r4 != null) goto L12;
        r4 = new LinkedList();
        r1.a.put(Long.valueOf(r2), r4);
    L12:
        r13.n = SystemClock.elapsedRealtime();
        String r3 = f.a(r13);
        boolean r5 = true;
        int r6 = 0;
        if (r3 == null) goto L121;
        k32.a r7 = r0.b.get(r3);
        if (r7 != null) goto L18;
        r0.b.put(r3, r13);
    L128:
        r5 = false;
    L129:
        if (r5 == false) goto L131;
    L162:
        f.b r14 = r0.f;
        if (r14 == null) goto L165;
        r14.b(r14.a);
        goto L165
    L131:
        if ((r13 instanceof k32.d) == false) goto L138;
        e r8 = r0.d;
        k32.d r9 = (k32.d) r13;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "windScreenCommonMessage");
        h3 r10 = r9.t;
        if (r10 == null) goto L138;
        long r11 = r10.getMessageId();
        if (r11 == 0) goto L138;
        ((HashMap) r8.a).put(Long.valueOf(r11), Long.valueOf(System.currentTimeMillis()));
    L138:
        r4.offerLast(r13);
        int r15 = r0.b();
        if ((r13 instanceof k32.c) == false) goto L141;
        Iterable r16 = r0.c.a(f.h);
        String r17 = "OpenAssetEnter";
    L145:
        Iterator r18 = r16.iterator();
    L147:
        if (r18.hasNext() == false) goto L162;
        k32.a r19 = (k32.a) r18.next();
        String r20 = f.a(r19);
        if (r20 == null) goto L154;
        if (r0.b.get(r20) == null) goto L154;
        r0.b.remove(r20);
    L158:
        f.b r21 = r0.f;
        if (r21 == null) goto L161;
        f.b.a(r21, r19, r17);
    L161:
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberDropCount);
    L154:
        if ((r19 instanceof k32.d) == false) goto L158;
        int r23 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a;
        Long r24 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a((k32.d) r19);
        if (r24 == null) goto L158;
        LinkedList<k32.d> r25 = r0.a.remove(Long.valueOf(r24.longValue()));
        goto L158
    L141:
        int r110 = f.g;
        if (r15 < r110) goto L144;
        r16 = r0.c.a(r15 - r110);
        r17 = "Full";
        goto L145
    L144:
        r16 = new LinkedList();
        r17 = BuildConfig.FLAVOR;
        goto L145
    L18:
        if ((r7 instanceof k32.b) == false) goto L21;
        k32.b r26 = (k32.b) r13;
        k32.b r27 = (k32.b) r7;
        r27.b = r26.b;
        r27.t += r26.t;
        goto L129
    L21:
        if ((r7 instanceof y72.a) == false) goto L24;
        y72.a r28 = (y72.a) r13;
        y72.a r29 = (y72.a) r7;
        r29.t = r28.t;
        r29.w = r28.w;
        r29.u += r28.u;
        r29.x = r28.x;
        r29.v = r28.v;
        goto L129
    L24:
        if ((r7 instanceof k32.d) == false) goto L121;
        k32.d r30 = (k32.d) r13;
        k32.d r31 = (k32.d) r7;
        Long r33 = null;
        if (r30.a() == true) goto L28;
        h3 r34 = r31.t;
        if (r34 == null) goto L118;
        pg.c r35 = r34.M();
        if (r35 == null) goto L118;
        Long r36 = r35.a();
        if (r36 == null) goto L118;
        long r37 = r36.longValue();
        h3 r38 = r30.t;
        if (r38 == null) goto L118;
        pg.c r39 = r38.M();
        if (r39 == null) goto L118;
        h3 r40 = r30.t;
        if (r40 == null) goto L117;
        pg.c r41 = r40.M();
        if (r41 == null) goto L117;
        Long r43 = r41.a();
        if (r43 == null) goto L117;
        r33 = Long.valueOf(r43.longValue() + r37);
    L117:
        r39.g(r33);
    L118:
        r30.u = true;
    L119:
        r0.b.put(r3, r13);
        goto L129
    L28:
        if (((Boolean) x.a.getValue()).booleanValue() == false) goto L119;
        h3 r44 = r30.t;
        if (r44 == null) goto L119;
        com.bytedance.android.live.base.model.message.d r45 = r44.I0();
        if (r45 == null) goto L119;
        List r46 = r45.b();
        if (r46 == null) goto L119;
        Iterator r47 = r46.iterator();
    L37:
        if (r47.hasNext() == false) goto L42;
        if (((com.bytedance.android.live.base.model.message.f) r47.next()).a() == true) goto L43;
        r6 = r6 + 1;
    L43:
        if (r6 == (-1)) goto L119;
        h3 r48 = r31.t;
        if (r48 == null) goto L51;
        com.bytedance.android.live.base.model.message.d r49 = r48.I0();
        if (r49 == null) goto L51;
        List r50 = r49.b();
        if (r50 == null) goto L51;
        com.bytedance.android.live.base.model.message.f r51 = (com.bytedance.android.live.base.model.message.f) CollectionsKt.getOrNull(r50, r6);
    L52:
        h3 r53 = r30.t;
        if (r53 == null) goto L59;
        com.bytedance.android.live.base.model.message.d r54 = r53.I0();
        if (r54 == null) goto L59;
        List r55 = r54.b();
        if (r55 == null) goto L59;
        com.bytedance.android.live.base.model.message.f r56 = (com.bytedance.android.live.base.model.message.f) CollectionsKt.getOrNull(r55, r6);
    L60:
        if (r51 == null) goto L119;
        if (r56 == null) goto L119;
        if (r51.k() == false) goto L119;
        if (r56.k() == false) goto L119;
        o6 r57 = r51.g();
        if (r57 == null) goto L77;
        a5 r58 = r57.a();
        if (r58 == null) goto L77;
        List r59 = r58.getPieces();
        if (r59 == null) goto L77;
        c5 r60 = (c5) CollectionsKt.firstOrNull(r59);
        if (r60 == null) goto L77;
        String r61 = r60.getStringValue();
        if (r61 == null) goto L77;
        Long r63 = StringsKt.toLongOrNull(r61);
    L78:
        o6 r64 = r56.g();
        if (r64 == null) goto L89;
        a5 r65 = r64.a();
        if (r65 == null) goto L89;
        List r66 = r65.getPieces();
        if (r66 == null) goto L89;
        c5 r67 = (c5) CollectionsKt.firstOrNull(r66);
        if (r67 == null) goto L89;
        String r68 = r67.getStringValue();
        if (r68 == null) goto L89;
        r33 = StringsKt.toLongOrNull(r68);
    L89:
        if (r63 == null) goto L119;
        if (r33 == null) goto L119;
        o6 r69 = r56.g();
        if (r69 == null) goto L119;
        a5 r70 = r69.a();
        if (r70 == null) goto L119;
        List r71 = r70.getPieces();
        if (r71 == null) goto L119;
        c5 r73 = (c5) CollectionsKt.firstOrNull(r71);
        if (r73 == null) goto L119;
        r73.setStringValue(String.valueOf(r63.longValue() + r33.longValue()));
    L77:
        r63 = null;
    L59:
        r56 = null;
    L51:
        r51 = null;
        goto L52
    L42:
        r6 = -1;
    L121:
        if ((r13 instanceof k32.d) == false) goto L128;
        int r74 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a;
        k32.d r75 = (k32.d) r13;
        Long r76 = com.bytedance.android.livesdk.interactivity.common.enterAnim.f.a(r75);
        if (r76 == null) goto L128;
        long r77 = r76.longValue();
        LinkedList<k32.d> r78 = r0.a.get(Long.valueOf(r77));
        if (r78 == null) goto L127;
        r78.add(r75);
        goto L129
    L127:
        LinkedList<k32.d> r79 = new LinkedList();
        r79.add(r75);
        r0.a.put(Long.valueOf(r77), r79);
    L165:
        d();
    }

    public final void b(k32.a r3) {
        if (r3 == null) goto L24;
        va.a r0 = r3.k;
        if (r0 == null) goto L19;
        int r1 = r0.getType();
        if (r1 == 5) goto L16;
        if (r1 == 7) goto L16;
        if (r1 == 8) goto L16;
        if (r1 != 9) goto L19;
    L16:
        if (this.t.d(r3, new com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.g(this)) == true) goto L24;
    L19:
        if ((r3 instanceof k32.c) == true) goto L21;
    L25:
        if (r3 != null) goto L27;
        return;
    L27:
        c(r3);
        return;
    L21:
        if (((Boolean) q1.a.getValue()).booleanValue() == false) goto L25;
        if (this.t.d(r3, new com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.g(this)) == false) goto L25;
    L24:
        r3 = null;
        goto L25
    }

    public final void c(k32.a r3) {
        if (this.q.a(r3) == false) goto L9;
        ALogger.d("DefaultEntryController", "start intercept enter message.");
        if ((r3 instanceof k32.d) == false) goto L7;
        z32.b.a(HighlevelNoMessageMonitorEnum.NotifyFilterCount);
        return;
    L7:
        z32.b.a(HighlevelNoMessageMonitorEnum.MemberFilterCount);
        return;
    L9:
        a(r3);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        k32.a r5 = this.g;
        if (r5 == null) goto L21;
        l r0 = this.f;
        if (r0 == null) goto L22;
        EnterAnimWidget r1 = (EnterAnimWidget) r0;
        r1.getClass();
        String r2 = r5.a;
        if (TextUtils.isEmpty(r2) == false) goto L9;
    L16:
        k32.a r6 = this.g;
        r6.getClass();
        if ((r6 instanceof k32.c) == true) goto L19;
        EnterAnimAppLogger.g(2, this.g, this.p);
    L19:
        EnterAnimAppLogger.j(this.g);
        return;
    L9:
        if (TextUtils.equals("0", r2) == true) goto L16;
        if ((r5 instanceof k32.c) == true) goto L16;
        UserProfileEvent r7 = new UserProfileEvent(r2);
        r7.setClickUserPosition("enter_effect");
        DataCenter r3 = ((Widget) r1).dataCenter;
        if (r3 == null) goto L16;
        r3.put("cmd_show_user_profile", r7);
        goto L16
    L22:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [v72.a] */
    /* JADX WARN: Type inference failed for: r3v3, types: [v72.b] */
    public c(Context r6, EnterAnimationView r7) {
        this.k = new f32.b();
        this.l = new f32.c();
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.p = 0;
        this.s = new com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.c();
        this.t = new RevenueUtils();
        this.v = new v72.a(this);
        this.w = new v72.b(this);
        this.x = new a(this);
        this.y = new b(this);
        this.z = 0;
        this.A = new HandlerC0288c(this, Looper.getMainLooper());
        this.c = r6;
        this.d = r7;
        if (((l61) LiveInfraSettingKeys.LIVE_ON_MEASURE_OPT_CONFIG.getValue()).b() == false) goto L6;
        r7.setHasFixSize(true);
        k0.o().getClass();
        com.bytedance.android.live.core.log.g.i("ttlive_msg", "enteranim measure opt enabled");
    L6:
        if (w72.a.a == true) goto L41;
        String r8 = (String) y.a.getValue();
        if (r8 != null) goto L43;
    L40:
        w72.a.a = true;
        goto L41
    L43:
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.d r9 = (com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.d) GsonHelper.get().fromJson(r8, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.d.class);     // Catch: Exception -> L38
        if (r9 == null) goto L40;
        if (r9.a() == null) goto L40;
        Iterator<com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.c> r10 = r9.a().iterator();     // Catch: Exception -> L38
    L16:
        if (r10.hasNext() == false) goto L40;
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.c r11 = r10.next();     // Catch: Exception -> L38
        if (r11.b() == null) goto L16;
        Integer r1 = r11.a();     // Catch: Exception -> L38
        boolean r3 = w72.a.a;
        if (r1 == null) goto L27;
        if (r1.intValue() != 3) goto L27;
        w72.a.a(r11.b(), w72.a.b);     // Catch: Exception -> L38
        w72.a.a(r11.b(), w72.a.c);     // Catch: Exception -> L38
    L27:
        if (r1 == null) goto L32;
        if (r1.intValue() != 1) goto L32;
        w72.a.a(r11.b(), w72.a.b);     // Catch: Exception -> L38
    L32:
        if (r1 == null) goto L16;
        if (r1.intValue() != 2) goto L16;
        w72.a.a(r11.b(), w72.a.c);     // Catch: Exception -> L38
    L38:
        e = move-exception;
        SafetyGuard.a(null, e, "EnterOptExpHolder init configs");
    L41:
        ArrayList r13 = new ArrayList();
        r13.add(new x72.h());
        x72.c r14 = new x72.c(this);
        this.r = r14;
        r13.add(r14);
        this.q = new x72.a(0, r13, this);
    }
}
