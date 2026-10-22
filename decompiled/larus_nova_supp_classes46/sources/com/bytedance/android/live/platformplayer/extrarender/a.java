package com.bytedance.android.live.platformplayer.extrarender;

import android.graphics.Rect;
import com.bytedance.android.livesdkapi.depend.model.live.CommentaryRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IClip;
import com.bytedance.android.livesdkapi.depend.model.live.IExtension;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderInfo;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderSeiInfo;
import com.bytedance.android.livesdkapi.model.PlayerGameExtraRenderInfo;
import com.bytedance.android.livesdkapi.model.PlayerGameExtraRenderSeiInfo;
import com.bytedance.android.livesdkapi.model.RenderAreaInfo;
import com.bytedance.android.livesdkapi.model.RenderDescInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final RoomBaseSession a;

    public final boolean b() {
        StreamUrl r0 = this.a.getStreamUrl();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getCompoundSceneType() != 1) goto L7;
        return true;
    }

    public a(RoomBaseSession r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.a = r2;
    }

    public static RenderAreaInfo a(IClip r4) {
        return new RenderAreaInfo(r4.getX(), r4.getY(), r4.getW(), r4.getH());
    }

    public static void d(IRoom r16, StreamUrl r17, ILivePlayerClient r18) {
        RenderAreaInfo r0 = null;
        if (r16 == null) goto L6;
        IExtension r1 = r16.getExtension();
        if (r1 == null) goto L6;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        String r2 = r1.getMultiViewData();
        if (r2 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L20;
        return;
    L20:
        IClip r4 = r1.getGameClip();
        if (r4 != null) goto L23;
        return;
    L23:
        IClip r5 = r1.getCameraClipCustom();
        if (r5 != null) goto L26;
        return;
    L26:
        RenderAreaInfo r7 = a(r4);
        RenderAreaInfo r8 = a(r5);
        ILiveCoreSDKData.ICameraHorizontalPosition r6 = r1.getCameraHorizontalPosition();
        if (r6 == null) goto L29;
        r0 = new RenderAreaInfo(r6.getX(), r6.getY(), r6.getW(), r6.getH());
    L29:
        RenderAreaInfo r9 = r0;
        int r10 = r1.getCameraHorizontalType();
        if (r1.getCameraHidden() != 1) goto L32;
        boolean r11 = true;
    L33:
        r18.gameExtraRenderController().enable(new PlayerGameExtraRenderInfo(new PlayerGameExtraRenderSeiInfo(r7, r8, r9, r10, r11), null, null, null, false, null, false, 126, null));
        return;
    L32:
        r11 = false;
        goto L33
    L14:
        if (r2.length() == 0) goto L17;
        r3 = false;
    L6:
        if (r17 == null) goto L8;
        r1 = r17.getExtension();
        goto L9
    L8:
        r1 = null;
        goto L9
    }

    public static void c(a r9, IRoom r10, StreamUrl r11, ILivePlayerClient r12) {
        Rect r0 = new Rect(0, 0, 0, 0);
        ILivePlayerExtraRenderController r13 = r12.extraRenderController();
        RenderAreaInfo r2 = null;
        if (r10 == null) goto L7;
        IExtension r3 = r10.getExtension();
        if (r3 == null) goto L7;
    L11:
        if (r3 == null) goto L13;
        IClip r14 = r3.getGameClip();
    L14:
        if (r3 == null) goto L16;
        IClip r15 = r3.getCameraClip();
    L17:
        if (r3 == null) goto L20;
        IClip r4 = r3.getCameraClipCustom();
        if (r4 == null) goto L20;
    L21:
        if (r14 == null) goto L66;
        if (r15 == null) goto L67;
        if (r4 == null) goto L68;
        PlayerExtraRenderSeiInfo r5 = new PlayerExtraRenderSeiInfo();
        RenderAreaInfo r16 = a(r14);
        boolean r6 = true;
        r16.setGame(true);
        Unit r7 = Unit.INSTANCE;
        r5.setGameAreaInfo(r16);
        r5.setCameraAreaInfo(a(r15));
        r5.setDisplayMode(r3.getDisplayMode());
        if (r3.getCameraHidden() != 1) goto L27;
        boolean r17 = true;
    L28:
        r5.setCameraHidden(r17);
        if (r3.getGameHidden() != 1) goto L31;
        boolean r18 = true;
    L32:
        r5.setGameHidden(r18);
        String r19 = r3.getGameRoomIdStr();
        String r110 = "";
        if (r19 != null) goto L35;
        r19 = "";
    L35:
        r5.setGameRoomId(r19);
        r5.setCameraCustomAreaInfo(a(r4));
        r5.setCameraVerticalType(r3.getCameraVerticalType());
        r5.setCameraHorizontalType(r3.getCameraHorizontalType());
        ILiveCoreSDKData.ICameraHorizontalPosition r20 = r3.getCameraHorizontalPosition();
        if (r20 == null) goto L38;
        r2 = new RenderAreaInfo(r20.getX(), r20.getY(), r20.getW(), r20.getH());
    L38:
        r5.setCameraHorizontalPosition(r2);
        if (r3.getCameraHorizontalHidden() == 1) goto L42;
        r6 = false;
    L42:
        r5.setCameraHorizontalHidden(r6);
        RenderDescInfo r21 = new RenderDescInfo();
        if (r10 == null) goto L64;
        CommentaryRoomInfo r111 = r10.getCommentaryRoomInfo();
        if (r111 == null) goto L64;
        String r8 = r111.getUserIdStr();
        if (r8 != null) goto L49;
        r8 = "";
    L49:
        r21.setUserId(r8);
        k r22 = r111.getAvatar();
        if (r22 == null) goto L55;
        List r23 = r22.getUrls();
        if (r23 == null) goto L55;
        String r1 = (String) CollectionsKt.getOrNull(r23, 0);
        if (r1 == null) goto L55;
    L56:
        r21.setAvatar(r1);
        String r24 = r111.getNickName();
        if (r24 != null) goto L59;
        r24 = "";
    L59:
        r21.setNickName(r24);
        r21.setRoomId(String.valueOf(r111.getRoomId()));
        String r112 = r111.getTitle();
        if (r112 == null) goto L63;
        r110 = r112;
    L63:
        r21.setTitle(r110);
    L55:
        r1 = "";
    L64:
        PlayerExtraRenderInfo r113 = new PlayerExtraRenderInfo(r3.getLayout());
        r113.setInitSeiInfo(r5);
        r113.setDescInfo(r21);
        r113.getExtraViewInfo().setMargin(r0);
        r13.enable(r113);
        return;
    L31:
        r18 = false;
        goto L32
    L27:
        r17 = false;
        goto L28
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L20:
        r4 = r15;
        goto L21
    L16:
        r15 = null;
        goto L17
    L13:
        r14 = null;
    L7:
        if (r9.b() == false) goto L10;
        if (r11 == null) goto L10;
        r3 = r11.getExtension();
    L10:
        r3 = null;
        goto L11
    }
}
