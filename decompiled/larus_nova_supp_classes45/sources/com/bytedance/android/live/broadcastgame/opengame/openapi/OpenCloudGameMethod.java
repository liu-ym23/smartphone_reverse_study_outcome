package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.os.Build;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.opengame.cloudgame.model.LiveCloudGameSceneType;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.LiveCloudGameCloseStatus;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.LiveGameOrientation;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Queue;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OpenCloudGameMethod extends BaseOpenMethod<JSONObject> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "openCloudGame";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r28, CallContext r29) {
        Intrinsics.checkNotNullParameter(r28, "params");
        Intrinsics.checkNotNullParameter(r29, "context");
        int r4 = m10.a.a;
        m10.a.a("OpenCloudGameMethod", "Params: " + r28);
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = LiveGameOrientation.LANDSCAPE;
        final Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = "";
        final Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = "";
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = "";
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = "";
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = "";
        final ArrayList r8 = new ArrayList();
        final LinkedHashMap r14 = new LinkedHashMap();
        boolean r16 = true;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L30
        JSONObject r0 = r28.optJSONObject("info");     // Catch: Throwable -> L30
        if (r0 == null) goto L78;
    L9:
        r9.element = LiveGameOrientation.values()[r0.optInt("orientation")];     // Catch: Throwable -> L30
        Object r12 = this.d.m.k.get("OPEN_APP_ICON_URL");     // Catch: Throwable -> L30
        if ((r12 instanceof String) == true) goto L12;
        r12 = null;
    L12:
        String r15 = (String) r12;     // Catch: Throwable -> L30
        if (r15 != null) goto L15;
        r15 = "";
    L15:
        r5.element = r15;     // Catch: Throwable -> L30
        r6.element = r0.optString("gameName");     // Catch: Throwable -> L30
        r13.element = r0.optString("id");     // Catch: Throwable -> L30
        r11.element = r0.optString("roundId");     // Catch: Throwable -> L30
        Ref.ObjectRef r210 = r11;
        String r18 = "OpenCloudGameMethod";
        r7.element = StringsKt.substringAfter$default((String) r13.element, "###", null, 2, null);     // Catch: Throwable -> L28
        JSONObject r19 = r0.optJSONObject("cpExtra");     // Catch: Throwable -> L28
        boolean r1 = r0.optBoolean("prefer");     // Catch: Throwable -> L28
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L20;
    L22:
        r8.add(new Pair("cpExtra", r19));     // Catch: Throwable -> L28
        LiveCloudGameSceneType.Companion.getClass();     // Catch: Throwable -> L28
        r8.add(new Pair("prefer", LiveCloudGameSceneType.a.a(this, r1).getExtra2Game()));     // Catch: Throwable -> L28
        r8.add(new Pair("enter_from", "live_miniplay"));     // Catch: Throwable -> L28
        boolean r2 = !LiveCloudGameSceneType.a.a(this, r1).isUnLimited();
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L34:
        IGameCPCloudGameService r21 = jc1.k.n(IHostGameCP.class).getCloudGameService();
        if (r21 == null) goto L50;
        long r22 = this.d.m.a;
        String r110 = (String) r13.element;
        Pair[] r111 = new Pair[10];
        r111[0] = TuplesKt.to("user_id", jc1.k.n(IUserService.class).user().n());
        r111[1] = TuplesKt.to("room_id", String.valueOf(this.d.m.a));
        r111[2] = TuplesKt.to("game_id", (String) r13.element);
        r111[3] = TuplesKt.to("game_name", (String) r6.element);
        Room r23 = this.d.n();
        if (r23 == null) goto L39;
        LiveMode r24 = r23.getStreamType();
    L40:
        r111[4] = TuplesKt.to("live_type", String.valueOf(r24));
        r111[5] = TuplesKt.to(OpenPlatformBaseDebugger.APP_ID, this.d.m.i);
        PluginContext r25 = this.d;
        r111[6] = TuplesKt.to("app_name", r25.m.b(r25.o));
        r111[7] = TuplesKt.to("orientation", String.valueOf(((LiveGameOrientation) r9.element).getType()));
        if (r2 == false) goto L43;
        String r26 = GamePromoteDataContext.GAME_TYPE_MINI;
    L44:
        r111[8] = TuplesKt.to("scene", r26);
        if (this.d.o == false) goto L47;
        String r27 = "anchor";
    L48:
        r111[9] = TuplesKt.to("launch_from", r27);
        r21.initMonitor(r22, r110, MapsKt.mapOf(r111));
        goto L50
    L47:
        r27 = "audience";
        goto L48
    L43:
        r26 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        goto L44
    L39:
        r24 = null;
    L50:
        IGameCPCloudGameService r211 = jc1.k.n(IHostGameCP.class).getCloudGameService();
        if (r211 == null) goto L54;
        r211.monitorEvent(this.d.m.a, (String) r13.element, "ttlive_cg_launch_start", MapsKt.emptyMap());
    L54:
        if (Result.exceptionOrNull-impl(r3) == null) goto L56;
    L73:
        IGameCPCloudGameService r31 = jc1.k.n(IHostGameCP.class).getCloudGameService();
        if (r31 == null) goto L76;
        r31.monitorEvent(this.d.m.a, (String) r13.element, "ttlive_cg_launch_fail", MapsKt.mapOf(new Pair[]{TuplesKt.to(LiveSlardarConstants.EXTRA_KEY_ERROR_CODE, String.valueOf(LiveCloudGameCloseStatus.FAIL.getStatus())), TuplesKt.to(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, "params_error " + Result.exceptionOrNull-impl(r3))}));
    L76:
        OpenApiErrorInfo r32 = OpenApiErrorInfo.INCORRECT_PARAMS;
        JSONObject r33 = new JSONObject();
        r33.put("code", r32.getErrorCode());
        r33.put("errNo", r32.getErrorCode());
        r33.put("errMsg", "openCloudGame:fail " + r32.getErrorMsg());
        Unit r34 = Unit.INSTANCE;
        BaseOpenMethod.q(this, r33, r32);
        return;
    L56:
        if (StringsKt.isBlank((String) r13.element) == true) goto L73;
        if (StringsKt.isBlank((String) r7.element) == true) goto L73;
        final Ref.ObjectRef r112 = r210;
        Function0<Unit> r35 = new OpenCloudGameMethod$call$openGame$1(this, r6, r5, r13, r7, r8, r14, r9, r112);
        String r36 = Build.MANUFACTURER;
        if (r36 != null) goto L63;
    L65:
        r16 = false;
    L66:
        if (r16 == true) goto L68;
    L70:
        this.d.k.a();
        r35.invoke();
    L71:
        JSONObject r37 = new JSONObject();
        r37.put("code", 0);
        r37.put("errCode", 0);
        r37.put("errMsg", "openCloudGame:ok");
        Unit r38 = Unit.INSTANCE;
        r(r37);
        int r39 = m10.a.a;
        m10.a.a(r18, "Cloud game " + ((String) r13.element) + " launch success.");
        return;
    L68:
        if (((Boolean) com.bytedance.android.livesdk.config.c1.a.getValue()).booleanValue() == false) goto L70;
        r35.invoke();
        this.d.k.a();
        goto L71
    L63:
        if (r36.contains("HUAWEI") == false) goto L65;
    L26:
        th = th;
    L33:
        Result.Companion r41 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L20:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.u3.getValue()).booleanValue() == false) goto L22;
        r1 = true;
    L28:
        th = th;
    L32:
        r2 = true;
        goto L33
    L78:
        r0 = new JSONObject();     // Catch: Throwable -> L7
    L7:
        th = th;
        r210 = r11;
        r18 = "OpenCloudGameMethod";
        r2 = true;
    L30:
        th = th;
        r210 = r11;
        r18 = "OpenCloudGameMethod";
        goto L32
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public OpenCloudGameMethod(PluginContext r2, g0 r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "openApi");
        super(r2, r4);
    }
}
