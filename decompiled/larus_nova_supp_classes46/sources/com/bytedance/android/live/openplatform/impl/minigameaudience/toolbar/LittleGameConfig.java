package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import am2.n;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AudienceMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameaudience.api.MiniGameAudienceApi;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w;
import com.bytedance.android.livesdk.config.j90;
import com.bytedance.android.livesdk.config.y80;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LittleGameConfig extends a0 {
    public static final /* synthetic */ int j = 0;
    public final String f;
    public final Context g;
    public final DataCenter h;
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a i;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar.LittleGameConfig$1, reason: invalid class name */
    public static final class AnonymousClass1 implements ToolbarComponentCheckInterface {
        public final /* synthetic */ LittleGameConfig a;
        public final /* synthetic */ long b;

        public AnonymousClass1(LittleGameConfig r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r11, final Function0<Unit> r12, Function1<? super String, Unit> r13) {
            Intrinsics.checkNotNullParameter(r11, "model");
            Intrinsics.checkNotNullParameter(r12, "loadButton");
            Intrinsics.checkNotNullParameter(r13, "stopLoadCallback");
            int r0 = qo0.a.a;
            qo0.a.c(this.a.f, "checkThenLoad, pre=" + r11.isPreloadScene() + ", this=" + this.a);
            String r1 = r11.getComponentExtra();
            Object r2 = null;
            if (r11.isPreloadScene() == false) goto L21;
            final LittleGameConfig r4 = this.a;
            final long r7 = this.b;
            r4.getClass();
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L7
            Object r15 = Result.constructor-impl((fr0.b.a) GsonHelper.get().fromJson(r1, fr0.b.a.class));     // Catch: Throwable -> L7
        L10:
            if (Result.isFailure-impl(r15) == true) goto L13;
            r2 = r15;
        L13:
            fr0.b.a r3 = (fr0.b.a) r2;
            if (r3 != null) goto L17;
            r4.s(new LittleGameConfig$preloadButton$1(r4, r12, r7), r13, true);
        L20:
            return true;
        L17:
            if (r3.c() != true) goto L19;
            r13.invoke("preload candy disable entrance is true.");
            goto L20
        L19:
            r12.invoke();
            r4.r(true, true, r7, true);
        L7:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L10
        L21:
            int r6 = r11.getSource();
            if (r6 == 0) goto L28;
            if (r6 == 1) goto L26;
        L46:
            return true;
        L26:
            if (r11.getComponentId() != 9) goto L46;
            qo0.a.c(this.a.f, "candy toolbar message from IM message, extras: " + r1);
            this.a.s(r12, r13, false);
            goto L46
        L28:
            qo0.a.c(this.a.f, "candy toolbar message from enter room, extras: " + r1);
            if (((Boolean) j90.a.getValue()).booleanValue() == true) goto L47;
            this.a.s(new LittleGameConfig$1$checkThenLoad$2(this, r12), r13, false);
            goto L46
        L47:
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L32
            Object r17 = Result.constructor-impl((fr0.b.a) GsonHelper.get().fromJson(r1, fr0.b.a.class));     // Catch: Throwable -> L32
        L35:
            if (Result.isFailure-impl(r17) == true) goto L38;
            r2 = r17;
        L38:
            fr0.b.a r8 = (fr0.b.a) r2;
            if (r8 != null) goto L42;
            this.a.s(new LittleGameConfig$1$checkThenLoad$1(this, r12), r13, false);
            goto L46
        L42:
            if (r8.c() == false) goto L44;
            r13.invoke("candy disable entrance is true.");
            goto L46
        L44:
            LittleGameConfig.q(this.a, r8, r12, true);
            this.a.r(true, true, this.b, false);
        L32:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            r17 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L35
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LittleGameConfig a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Function0 d;

        public a(LittleGameConfig r1, Function1 r2, boolean r3, Function0 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            List<fr0.b.a> r5 = ((fr0.b) ((Response) r4).data).a();
            if (r5 != null) goto L5;
        L15:
            this.b.invoke("candy entrance error: entrance info list is null or empty.");
            return;
        L5:
            if ((!r5.isEmpty()) != true) goto L15;
            if (((fr0.b.a) ListProtector.get(r5, 0)).c() == false) goto L10;
            this.b.invoke("candy disable entrance is true.");
            return;
        L10:
            if (((Boolean) y80.a.getValue()).booleanValue() == true) goto L12;
        L14:
            LittleGameConfig.q(this.a, (fr0.b.a) ListProtector.get(r5, 0), this.d, false);
            return;
        L12:
            if (this.c == false) goto L14;
            this.d.invoke();
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LittleGameConfig a;
        public final /* synthetic */ Function1 b;

        public b(LittleGameConfig r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            int r0 = qo0.a.a;
            qo0.a.b(this.a.f, "request candy entrance_info failed", r4);
            Function1 r1 = this.b;
            String r5 = r4.getMessage();
            if (r5 != null) goto L5;
            r5 = "candy entrance error: request candy entrance_info failed.";
        L5:
            r1.invoke(r5);
        }
    }

    public final w j() {
        ToolbarButton r1 = ToolbarButton.LITTLE_GAME;
        return new w(r1, null, r1, null);
    }

    public final boolean m() {
        if (((Boolean) y80.a.getValue()).booleanValue() == false) goto L6;
        return false;
    L6:
        return super.m();
    }

    public final void p() {
        if (((Boolean) y80.a.getValue()).booleanValue() == false) goto L6;
        Lazy r0 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.g(this.h, NewToolbarButtonConstants.LittleGame.INSTANCE);
        return;
    }

    public final Context getContext() {
        return this.g;
    }

    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.LittleGame.INSTANCE;
    }

    public final void a(ToolbarButton r2) {
        if (ToolbarButton.LITTLE_GAME == r2) goto L5;
        return;
    L5:
        if (gb2.a.a(this.h, false) == true) goto L13;
        AudienceMiniGameDataContext.Companion.getClass();
        AudienceMiniGameDataContext r3 = AudienceMiniGameDataContext.a.a();
        if (r3 == null) goto L14;
        m<Boolean> r4 = r3.isCandyToolbarShow();
        if (r4 == null) goto L15;
        r4.setValue(Boolean.TRUE);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void b(ToolbarButton r2) {
        if (ToolbarButton.LITTLE_GAME == r2) goto L5;
        return;
    L5:
        if (gb2.a.a(this.h, false) == true) goto L13;
        AudienceMiniGameDataContext.Companion.getClass();
        AudienceMiniGameDataContext r3 = AudienceMiniGameDataContext.a.a();
        if (r3 == null) goto L14;
        m<Boolean> r4 = r3.isCandyToolbarShow();
        if (r4 == null) goto L15;
        r4.setValue(Boolean.FALSE);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final c0.b e(s r3) {
        Intrinsics.checkNotNullParameter(r3, "button");
        if (tb1.c.g == true) goto L5;
        return null;
    L5:
        return new ToolbarOpenPlatformMiniGameBehavior(this.g, true);
    }

    public final c0.b f(s r3) {
        Intrinsics.checkNotNullParameter(r3, "button");
        if (tb1.c.a == true) goto L10;
        if (tb1.c.c == true) goto L10;
        return null;
    L10:
        return new ToolbarOpenPlatformMiniGameBehavior(this.g, false);
    }

    public LittleGameConfig(Context r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        super(null, null, 7);
        this.i = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.g = r5;
        this.h = r6;
        this.f = "LittleGameConfig";
        if (((Boolean) y80.a.getValue()).booleanValue() == false) goto L14;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
        if (r0 == null) goto L11;
        m r1 = r0.getEnterRoomTimeStamp();
        if (r1 == null) goto L11;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L11;
        long r3 = r2.longValue();
    L12:
        int r4 = qo0.a.a;
        qo0.a.c("LittleGameConfig", "initCandyToolbar, this=" + this);
        Lazy r7 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r6, NewToolbarButtonConstants.LittleGame.INSTANCE, new AnonymousClass1(this, r3));
        return;
    L11:
        r3 = com.ss.ugc.live.sdk.msg.utils.f.a();
        goto L12
    }

    public final void s(Function0<Unit> r5, Function1<? super String, Unit> r6, boolean r7) {
        String r0 = "";
        String r1 = new JSONObject(n.f().d()).optString("micro_app_scheme");     // Catch: JSONException -> L5
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L14;
    L9:
        Lazy r2 = LiveOpenPlatformMgClient.c;
        Disposable r8 = ((MiniGameAudienceApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAudienceApi.class)).getEntranceInfo(gb2.a.e(this.h).getRoomId(), r0).compose(RxUtil.rxSchedulerHelper()).retry(3).subscribe(new a(this, r6, r7, r5), new b(this, r6));
        Intrinsics.checkNotNullParameter(r8, "$this$autoDispose");
        this.i.a(r8);
        return;
    L14:
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L11
        r3.put("ad_schema", r1);     // Catch: JSONException -> L11
        r0 = r3.toString();     // Catch: JSONException -> L11
    L5:
        r1 = "";
        goto L7
    }

    public static final void q(LittleGameConfig r2, fr0.b.a r3, Function0 r4, boolean r5) {
        r2.getClass();
        int r0 = qo0.a.a;
        qo0.a.c(r2.f, "showCandyButton");
        CandyToolbarContextService r1 = (CandyToolbarContextService) r2.h.get("CandyToolbarContextService");
        if (r1 == null) goto L5;
        r1.j(r3, r4, r5);
        return;
    L5:
        r2.h.put("LittleGameConfig_entranceInfo", r3);
        r2.h.put("LittleGameConfig_loadButton", r4);
        r2.h.put("LittleGameConfig_dataFromEnter", Boolean.valueOf(r5));
    }

    public final void r(boolean r8, boolean r9, long r10, boolean r12) {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L25
        String r3 = "1";
        if (r8 == false) goto L7;
        Object r11 = "1";
    L8:
        r1.put("opt_group", r11);     // Catch: Exception -> L25
        if (r9 == false) goto L11;
        Object r13 = "1";
    L12:
        r1.put("validity", r13);     // Catch: Exception -> L25
        if (r10 <= 0) goto L15;
        Object r2 = "1";
    L16:
        r1.put("has_start_timestamp", r2);     // Catch: Exception -> L25
        if (r12 == true) goto L20;
        r3 = "0";
    L20:
        r1.put("preload", r3);     // Catch: Exception -> L25
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L25
        if (r10 <= 0) goto L23;
        r14.put("duration", System.currentTimeMillis() - r10);     // Catch: Exception -> L25
    L23:
        int r15 = qo0.a.a;     // Catch: Exception -> L25
        qo0.a.c(this.f, "reportToolbarPerformance, category: " + r1 + ", metric: " + r14);     // Catch: Exception -> L25
        LiveTracingMonitor.f("ttlive_minigame_entrance_info", LiveTracingMonitor.EventModule.OPEN_PLATFORM, r1, r14, new JSONObject());     // Catch: Exception -> L25
        return;
    L15:
        r2 = "0";
        goto L16
    L11:
        r13 = "0";
        goto L12
    L7:
        r11 = "0";
    }
}
