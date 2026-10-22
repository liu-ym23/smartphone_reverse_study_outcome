package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Bundle;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.mf;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class nd implements IFetchEffectListener {
    public final /* synthetic */ id a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ mf d;
    public final /* synthetic */ long e;
    public final /* synthetic */ Bundle f;

    public final void onStart(Effect r1) {
    }

    public final void onSuccess(Object r11) {
        Effect r2 = (Effect) r11;
        if (r2 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.b, com.bytedance.android.live.effect.api.d0.d) == false) goto L16;
        id r12 = this.a;
        boolean r0 = this.c;
        mf r1 = this.d;
        long r3 = this.e;
        r12.getClass();
        if (r0 == false) goto L16;
        String r4 = r1.b();
        if (r4 == null) goto L16;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L18
        JSONObject r5 = LiveSeiUtil.c(r4);     // Catch: Exception -> L18
        IBroadcastService r6 = (IBroadcastService) jc1.k.f(IBroadcastService.class);     // Catch: Exception -> L18
        if (r6 == null) goto L16;
        String r7 = String.valueOf(r3);     // Catch: Exception -> L18
        String r8 = r5.optString("interact_tool_name", "");     // Catch: Exception -> L18
        int r9 = InteractID.InteractLoki.getValue();     // Catch: Exception -> L18
        String r13 = r5.optString("event_page");     // Catch: Exception -> L18
        if (r13 != null) goto L15;
        r13 = "interactive_extension_detailpage";
    L15:
        r6.putInteractToolsMobInfo(r7, new a00.a(r8, r9, r13, r5.optString("interact_tool_info", "")));     // Catch: Exception -> L18
        Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L18
    L16:
        xs2.b r15 = xs2.b.a();
        String r16 = this.b;
        boolean r17 = this.c;
        Bundle r18 = this.f;
        r15.post(new zg1.o(r16, r2, r17, new md(this, r2), r18));
    }

    public final void onFail(Effect r4, ExceptionResult r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        if (((k81) ft0.a.getValue()).b() == true) goto L5;
    L11:
        this.a.finishWithFailure();
        return;
    L5:
        if (Intrinsics.areEqual(this.b, com.bytedance.android.live.effect.api.d0.d) == false) goto L11;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r6 == null) goto L11;
        com.bytedance.live.datacontext.n r7 = r6.getDownLoadingInteractEffectId();
        if (r7 == null) goto L11;
        r7.setValue(null);
        goto L11
    }

    public nd(id r1, String r2, boolean r3, mf r4, long r5, Bundle r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
    }
}
