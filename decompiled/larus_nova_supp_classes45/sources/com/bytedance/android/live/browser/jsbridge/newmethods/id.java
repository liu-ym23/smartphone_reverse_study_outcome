package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLivePanelEffectResultModel;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.et0;
import com.bytedance.android.livesdk.config.f30;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.mf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "updateLivePanelEffect")
public final class id extends w20.b7<mf, UpdateLivePanelEffectResultModel> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public id() {
    }

    public final void invoke(Object r18, CallContext r19) {
        mf r4 = (mf) r18;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r19, "context");
        String r1 = r4.c();
        if (r1 != null) goto L5;
        String r5 = "";
    L6:
        String r2 = r4.a();
        if (r2 == null) goto L11;
        Long r3 = StringsKt.toLongOrNull(r2);
        if (r3 == null) goto L11;
        long r9 = r3.longValue();
    L12:
        boolean r11 = Intrinsics.areEqual(r4.d(), Boolean.TRUE);
        Bundle r12 = new Bundle();
        String r6 = r4.b();
        boolean r13 = true;
        if (r6 == null) goto L25;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L23
        JSONObject r7 = LiveSeiUtil.c(r6);     // Catch: Exception -> L23
        r7.optString("event_page");     // Catch: Exception -> L23
        if (((Boolean) f30.a.getValue()).booleanValue() == true) goto L17;
    L21:
        r12.putBoolean("force_replace_other", r7.optBoolean("force_replace_other"));     // Catch: Exception -> L23
        r12.putString("replace_dialog_content", r7.optString("effect_replace_tip"));     // Catch: Exception -> L23
        r12.putString("challenge_id", r7.optString("upload_score_id"));     // Catch: Exception -> L23
        Unit r0 = Unit.INSTANCE;     // Catch: Exception -> L23
        goto L25
    L17:
        if (r7.optInt("interact_tool_version_type") != 1) goto L19;
        boolean r8 = true;
    L20:
        r12.putBoolean("extra_key_enable_debug_mode", r8);     // Catch: Exception -> L23
        r12.putString("extra_key_debug_schema_url", r7.optString("interact_tool_debug_schema"));     // Catch: Exception -> L23
        goto L21
    L19:
        r8 = false;
    L25:
        if (((Boolean) et0.a.getValue()).booleanValue() == false) goto L27;
    L39:
        RoomContext.a r14 = RoomContext.Companion;
        RoomContext r15 = RoomContext.a.c(r14, null, 0, 3);
        if (r15 == null) goto L55;
        com.bytedance.live.datacontext.i r16 = r15.isAnchor();
        if (r16 == null) goto L55;
        if (((Boolean) r16.getValue()).booleanValue() != true) goto L55;
        RoomContext r17 = RoomContext.a.c(r14, null, 0, 3);
        if (r17 == null) goto L50;
        com.bytedance.live.datacontext.i r21 = r17.getLiveMode();
        if (r21 == null) goto L50;
        LiveMode r22 = (LiveMode) r21.getValue();
    L52:
        if (r22 == LiveMode.VIDEO) goto L55;
        com.bytedance.android.live.core.utils.f2.b(2131922658, 0);
        finishWithFailure();
        return;
    L50:
        r22 = null;
    L55:
        if (r5.length() == 0) goto L59;
        r13 = false;
    L59:
        if (r13 == true) goto L82;
        if (r9 == 0) goto L82;
        if (Intrinsics.areEqual(r5, "zongyiyouxi") == false) goto L66;
        xs2.b.a().post(new zg1.p(r5, String.valueOf(r9), r11, new ld(this)));
        return;
    L66:
        String r23 = com.bytedance.android.live.effect.api.d0.d;
        if (Intrinsics.areEqual(r5, r23) == false) goto L72;
        if (RoomContext.a.c(r14, null, 0, 3) != null) goto L72;
        xs2.b.a().post(new zg1.l2());
        finishWithFailure();
        return;
    L72:
        if (((k81) ft0.a.getValue()).b() == true) goto L74;
    L80:
        List<String> r24 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffect(String.valueOf(r9), new nd(this, r5, r11, r4, r9, r12));
        return;
    L74:
        if (Intrinsics.areEqual(r5, r23) == false) goto L80;
        RoomContext r25 = RoomContext.a.c(r14, null, 0, 3);
        if (r25 == null) goto L80;
        com.bytedance.live.datacontext.n r26 = r25.getDownLoadingInteractEffectId();
        if (r26 == null) goto L80;
        r26.setValue(String.valueOf(r9));
    L82:
        if (Intrinsics.areEqual(r5, "zongyiyouxi") == false) goto L85;
        if (r11 == true) goto L85;
        xs2.b.a().post(new zg1.p(r5, "", false, new kd(this)));
    L85:
        finishWithFailure();
        return;
    L27:
        if (((k81) ft0.a.getValue()).b() == false) goto L39;
        if (Intrinsics.areEqual(r5, com.bytedance.android.live.effect.api.d0.c) == false) goto L39;
        List<String> r27 = LiveEffectContext.h;
        if ((!LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(com.bytedance.android.live.effect.api.d0.d).isEmpty()) == false) goto L39;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_interactive_extension_conflict_popup", MapsKt.mapOf(TuplesKt.to("action_type", "show")), new Object[]{IRoom.class});
        View r28 = LayoutInflater.from(r19.getContext()).inflate(2131567649, null);
        TextView r29 = (TextView) r28.findViewById(2131388772);
        TextView r31 = (TextView) r28.findViewById(2131387553);
        r29.setText("请先退出当前互动工具");
        r31.setText("最多可同时使用一种特效/互动工具");
        com.bytedance.android.livesdk.widget.z0 r32 = com.bytedance.android.livesdk.widget.z0.a();
        Context r33 = r19.getContext();
        r32.getClass();
        com.bytedance.android.livesdk.widget.x0.d r34 = new com.bytedance.android.livesdk.widget.x0.d();
        r34.b = r33;
        r34.a = 4;
        r34.l = false;
        r34.f = r28;
        jd r35 = jd.a;
        com.bytedance.android.livesdk.widget.x0.c[] r36 = r34.g;
        com.bytedance.android.livesdk.widget.x0.c r37 = r36[0];
        if (r37 != null) goto L35;
        r37 = new com.bytedance.android.livesdk.widget.x0.c();
        r36[0] = r37;
    L35:
        r37.a = "我知道了";
        r37.b = r35;
        com.bytedance.android.livesdk.widget.x0.c[] r38 = r34.g;
        com.bytedance.android.livesdk.widget.x0.c r39 = r38[0];
        if (r39 != null) goto L38;
        r39 = new com.bytedance.android.livesdk.widget.x0.c();
        r38[0] = r39;
    L38:
        r39.c = true;
        com.bytedance.android.livesdk.widget.x0.b.g(new com.bytedance.android.livesdk.widget.x0(r34.b, r34));
        finishWithFailure();
        return;
    L11:
        r9 = 0;
        goto L12
    L5:
        r5 = r1;
        goto L6
    }
}
