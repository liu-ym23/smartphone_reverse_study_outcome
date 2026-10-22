package com.bytedance.android.live.liveinteract.voicechat.stage;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import ih0.b;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    public static /* synthetic */ boolean d() {
        o r0 = m.i();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
    L9:
        return c(r2);
    L7:
        r2 = null;
        goto L9
    }

    static {
    }

    public static boolean b(IRoom r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return Intrinsics.areEqual(r1.getAnchorAbValue("audio_1v8_stage_enlarge"), "1");
    }

    public static boolean c(IRoom r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return Intrinsics.areEqual(r1.getAnchorAbValue("audio_double_enlarge_enable"), "1");
    }

    public static void f(DataCenter r3) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", Integer.valueOf(AudioChatStageEventType.STAGE_UPDATE_POSITION.ordinal()));
        b r4 = ((IInteractService) k.n(IInteractService.class)).dynamicService(r3);
        if (r4 == null) goto L6;
        r4.Dk("audiochat_stage", "audiochat_stage", r0, false);
        return;
    }

    public static void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "content");
        ALogger.i("AudioChatStage", "[" + r2 + "] " + r3);
    }

    public static boolean a(Integer r2, boolean r3, boolean r4) {
        if (r2 != null) goto L5;
    L6:
        if (r2 != null) goto L9;
    L10:
        if (r2 != null) goto L13;
    L17:
        return false;
    L13:
        if (r2.intValue() != 30) goto L17;
    L14:
        if (r3 == true) goto L17;
        if (r4 == true) goto L17;
        return true;
    L9:
        if (r2.intValue() == 26) goto L14;
    L5:
        if (r2.intValue() == 27) goto L14;
        goto L6
    }
}
