package com.bytedance.android.live.broadcastgame.opengame;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameLaunchSource;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.runtime.AnchorPluginRuntime;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends LiveBasePluginManager {
    public final com.bytedance.android.live.pushstream.d l;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.a$a, reason: collision with other inner class name */
    public static final class C0057a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.LiveBasePluginManager, com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.broadcastgame.api.xplay.n.b.e("release");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.r
    public final void p(String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        int r0 = q.a;
        q.e("AudiencePluginManager", new Object[]{"start plugin failed ", ", errorCode: ", -1, ", errorMsg: ", r4});
        this.b = null;
        this.a = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void g(String r1, Map<String, String> r2, com.bytedance.android.live.broadcastgame.api.openplatform.f.a r3) {
        d(r1, r2);
    }

    public a(com.bytedance.android.live.pushstream.d r9, Context r11, DataCenter r12, long r13, ViewGroup r14) {
        Intrinsics.checkNotNullParameter(r9, "liveStream");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        Intrinsics.checkNotNullParameter(r14, "containerView");
        super(r11, r12, r13, r14);
        this.l = r9;
        LinkedHashMap r7 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r7, "extraParams");
        Intrinsics.checkNotNullParameter(this, "pluginManager");
        String r15 = null;
        RoomContext r16 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r16 == null) goto L9;
        com.bytedance.live.datacontext.j r17 = r16.getPreviewSourceParam();
        if (r17 == null) goto L9;
        PreviewSourceParam r18 = (PreviewSourceParam) r17.getValue();
        if (r18 == null) goto L9;
        r15 = r18.getOriginalRawString();
    L9:
        int r19 = com.bytedance.android.live.broadcastgame.opengame.debug.d.c;
        PluginType r110 = PluginType.UNKNOWN_TYPE;
        if (r15 != null) goto L12;
    L15:
        boolean r111 = true;
    L16:
        if (r111 == true) goto L31;
        JSONObject r112 = new JSONObject(r15);     // Catch: Exception -> L28
        if (r112.has("timor_schema") == false) goto L31;
        if (r112.has("open_type") == false) goto L31;
        if (r112.has("enter_from") == false) goto L31;
        PluginType.a r113 = PluginType.Companion;     // Catch: Exception -> L28
        String r21 = JSONObjectProtectorUtils.getString(r112, "timor_schema");     // Catch: Exception -> L28
        r113.getClass();     // Catch: Exception -> L28
        PluginType r22 = PluginType.a.a(r21);     // Catch: Exception -> L28
        if (r22 == null) goto L31;
        r110 = r22;
    L28:
        e = move-exception;
        e.printStackTrace();
    L31:
        if (r110 != PluginType.UNKNOWN_TYPE) goto L33;
        PluginType r2 = PluginType.LYNX;
    L35:
        if (r2 == PluginType.MINI_APP) goto L40;
        this.d.c(r2, getContext(), this.h, this.j, this, r7);
        return;
    L40:
        return;
    L33:
        r2 = r110;
        goto L35
    L12:
        if (r15.length() == 0) goto L15;
        r111 = false;
        goto L16
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.LiveBasePluginManager
    public final com.bytedance.android.live.broadcastgame.opengame.runtime.q l(Context r11, long r12, DataCenter r13, f r14, PluginType r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        Intrinsics.checkNotNullParameter(r14, "gameIMManager");
        Intrinsics.checkNotNullParameter(r15, "pluginType");
        com.bytedance.android.live.pushstream.d r6 = this.l;
        com.bytedance.android.live.broadcastgame.opengame.debug.d r0 = this.d;
        OpenPlatformBaseDebugger r1 = null;
        if (r0 == null) goto L8;
        if (r0.a == false) goto L8;
        r1 = r0.b;
    L8:
        return new AnchorPluginRuntime(r11, r13, r12, r6, r14, r1);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.LiveBasePluginManager, com.bytedance.android.live.broadcastgame.api.openplatform.b
    public final void i(long r14, String r16, String r17, Map<String, ? extends Object> r18, boolean r19, boolean r21) {
        Intrinsics.checkNotNullParameter(r16, "appId");
        Intrinsics.checkNotNullParameter(r17, "schema");
        Intrinsics.checkNotNullParameter(r18, "params");
        if (r19 == true) goto L48;
        int r1 = t.q;
        if (t.a.a(r17) == 1) goto L48;
        if (t.a.a(r17) == 2) goto L48;
        int r2 = com.bytedance.android.live.broadcastgame.opengame.utils.e.a;
        com.bytedance.android.live.broadcastgame.opengame.utils.k.i r3 = com.bytedance.android.live.broadcastgame.opengame.utils.k.i.c;
        String r8 = "null";
        Object r9 = null;
        if (r18.containsKey("launch_from") == true) goto L12;
        ALogger.i("CheckOpenParamsUtils", "start params has no launch_from");
    L19:
        Object r4 = null;
    L21:
        if (Intrinsics.areEqual((String) r4, "game_promote") == false) goto L28;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r5 = AnchorGameContext.a.a();
        if (r5 == null) goto L53;
        com.bytedance.live.datacontext.m<GameLaunchSource> r6 = r5.getOpenGameLaunchSource();
        if (r6 == null) goto L53;
        r6.setValue(GameLaunchSource.GamePromote);
    L53:
        super.i(r14, r16, r17, r18, r19, r21);
        return;
    L28:
        if (r18.containsKey("launch_from") == true) goto L30;
        ALogger.i("CheckOpenParamsUtils", "start params has no launch_from");
    L37:
        if (Intrinsics.areEqual((String) r9, "invite") == false) goto L43;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r7 = AnchorGameContext.a.a();
        if (r7 == null) goto L53;
        com.bytedance.live.datacontext.m<GameLaunchSource> r11 = r7.getOpenGameLaunchSource();
        if (r11 == null) goto L53;
        r11.setValue(GameLaunchSource.Invite);
        goto L53
    L43:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r12 = AnchorGameContext.a.a();
        if (r12 == null) goto L53;
        com.bytedance.live.datacontext.m<GameLaunchSource> r13 = r12.getOpenGameLaunchSource();
        if (r13 == null) goto L53;
        r13.setValue(GameLaunchSource.Panel);
        goto L53
    L30:
        Object r15 = r18.get("launch_from");
        if ((r15 instanceof String) == false) goto L33;
        r9 = r15;
        goto L37
    L33:
        if (r15 == null) goto L35;
        r8 = Reflection.getOrCreateKotlinClass(r15.getClass()).toString();
    L35:
        ALogger.i("CheckOpenParamsUtils", "start params launch_from type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r8);
        goto L37
    L12:
        r4 = r18.get("launch_from");
        if ((r4 instanceof String) == true) goto L21;
        if (r4 == null) goto L17;
        String r22 = Reflection.getOrCreateKotlinClass(r4.getClass()).toString();
    L18:
        ALogger.i("CheckOpenParamsUtils", "start params launch_from type error : need" + Reflection.getOrCreateKotlinClass(String.class) + " but is " + r22);
        goto L19
    L17:
        r22 = "null";
    L48:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r23 = AnchorGameContext.a.a();
        if (r23 == null) goto L53;
        com.bytedance.live.datacontext.m<GameLaunchSource> r24 = r23.getOpenGameLaunchSource();
        if (r24 == null) goto L53;
        r24.setValue(GameLaunchSource.Scan);
        goto L53
    }
}
