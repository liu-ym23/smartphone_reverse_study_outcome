package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.n50;
import com.bytedance.android.livesdk.config.og0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerContext;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x6 {
    public static int a;
    public static boolean b;
    public static boolean c;
    public static float d;
    public static boolean e;
    public static f9 f;

    static {
        b = true;
        c = true;
        d = 1.0f;
    }

    public static float a() {
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager getInitScaleValue " + d);
        return d;
    }

    public static boolean c() {
        Room r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        r4 = (Room) r1.getValue();
    L7:
        as0.a r2 = LivePlatformPlayerManager.b();
        if (r2 == null) goto L16;
        ILivePlayerClient r3 = r2.player();
        if (r3 == null) goto L16;
        ILivePlayerExtraRenderController r5 = r3.extraRenderController();
        if (r5 == null) goto L16;
        if (r5.isUgcRoom() != true) goto L16;
        boolean r6 = true;
    L18:
        if (n50.a.getValue().booleanValue() == false) goto L27;
        if (r4 != null) goto L21;
        return false;
    L21:
        if (r4.isMediaRoom() == false) goto L23;
        return false;
    L23:
        if (r4.isMergeVSRoom() == true) goto L30;
        if (r6 == true) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L27:
        return false;
    L16:
        r6 = false;
        goto L18
    }

    public static boolean d() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L15;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L15;
        if (r2.isMergeVSRoom() == true) goto L15;
        if (r2.isMediaRoom() == true) goto L15;
        if (r2.isCompoundScene() == true) goto L15;
        boolean r3 = true;
    L17:
        if (og0.a.getValue().booleanValue() == false) goto L21;
        if (r3 == false) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L15:
        r3 = false;
        goto L17
    }

    @JvmStatic
    public static final boolean f() {
        BottomContainerSize r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.isRestoreSandwich();
        if (r1 == null) goto L10;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L10;
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager isSandwich false isRestoreSandwich true");
        return false;
    L10:
        IGameStickerContext r2 = com.bytedance.android.livesdk.chatroom.gamestickerv2.f.a.getDataContext(GameStickerScene.ENTER);
        if (r2 == null) goto L13;
        r4 = r2.getInputSize();
    L13:
        if (r4 == null) goto L16;
        ALogger.d("SandwichBorderInfo", "in game sticker layout return false");
        return false;
    L16:
        ILivePlayerClient r3 = LivePlatformPlayerManager.f();
        if (r3 == null) goto L24;
        ILivePlayerMultiRenderController r5 = r3.multiRenderController();
        if (r5 == null) goto L24;
        if (r5.isEnable() != true) goto L24;
        return false;
    L24:
        if (a == 0) goto L26;
    L29:
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager isSandwich false cur pic " + a + " info:" + f);
        return false;
    L26:
        if (f == null) goto L29;
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager isSandwich true");
        return true;
    }

    public static boolean e() {
        if (PadConfigUtils.c() == false) goto L5;
        return false;
    L5:
        nm1.e r0 = pm1.f.c();
        Room r2 = null;
        if (r0 != null) goto L8;
    L20:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L25;
        com.bytedance.live.datacontext.m r3 = r1.getRoom();
        if (r3 == null) goto L25;
        r2 = (Room) r3.getValue();
    L25:
        if (r2 != null) goto L27;
    L34:
        return false;
    L27:
        if (r2.isVsLive() != true) goto L34;
        RoomAuthStatus r4 = r2.getRoomAuthStatus();
        if (r4 == null) goto L34;
        if (r4.getVideoAmplificationType() != 1) goto L34;
        return true;
    L8:
        if (r0.f(null) != true) goto L20;
        lm1.b r5 = pm1.f.d(null);
        if (r5 == null) goto L20;
        com.bytedance.live.datacontext.n r6 = r5.getEpisode();
        if (r6 == null) goto L20;
        Episode r7 = (Episode) r6.getValue();
        if (r7 == null) goto L20;
        IRoomAuthStatus r8 = r7.getRoomAuthStatus();
        if (r8 == null) goto L20;
        if (r8.getVideoAmplificationType() != 1) goto L20;
        return true;
    }

    public static String b(Integer r1) {
        if (r1 == null) goto L4;
        int r2 = r1.intValue();
    L5:
        if (r2 != 0) goto L7;
        return "auto";
    L7:
        if (r2 != 1) goto L9;
        return "draw";
    L9:
        if (r2 != 2) goto L11;
        return "big";
    L11:
        if (r2 == 3) goto L13;
        return "";
    L13:
        return "cut";
    L4:
        r2 = a;
        goto L5
    }

    @JvmStatic
    public static final void g(f9 r2) {
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager setSandwichInfo:" + r2);
        f = r2;
    }
}
