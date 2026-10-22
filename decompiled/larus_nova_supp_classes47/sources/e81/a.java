package e81;

import android.os.Bundle;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.media.api.IMediaReplayService;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomGravitySensor;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import f81.b;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends com.bytedance.android.live.room.api.screenrotation.entrance.judge.a {
    public final String d;
    public final DataCenter e;
    public final Bundle f;

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final boolean c(IRotateEntrance r2) {
        Intrinsics.checkNotNullParameter(r2, "entrance");
        return true;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final String getTag() {
        return this.d;
    }

    @Override // com.bytedance.android.live.room.api.screenrotation.entrance.judge.a, com.bytedance.android.live.room.api.screenrotation.entrance.a
    public final boolean a(IRotateEntrance r6) {
        Intrinsics.checkNotNullParameter(r6, "entrance");
        DataCenter r7 = this.e;
        boolean r0 = false;
        if (r7 == null) goto L64;
        Room r8 = z.o(r7);
        if (r8 == null) goto L64;
        if (e5.p() != 0) goto L10;
        return false;
    L10:
        Bundle r1 = this.f;
        boolean r2 = true;
        if (r1 != null) goto L13;
    L33:
        boolean r3 = false;
    L34:
        if (r3 == true) goto L36;
    L42:
        if (r3 == false) goto L50;
        RoomPlatformComponentsData r4 = r8.roomPlatformComponentsData;
        if (r4 == null) goto L50;
        RoomGravitySensor r5 = r4.getRoomGravitySensor();
        if (r5 == null) goto L50;
        if (r5.getOpen() != 2) goto L50;
        r3 = false;
    L50:
        boolean r9 = r8.isVrRoom();
        if (r3 == false) goto L56;
        if (r9 == true) goto L56;
        if (b.a(r8) == false) goto L56;
        r0 = true;
    L56:
        if (r9 == false) goto L59;
        r0 = VrUtils.B();
    L59:
        if (r8.isMergeVSRoom() == true) goto L62;
        r2 = r0;
    L62:
        SimpleAlogArgsBuilder r10 = new SimpleAlogArgsBuilder();
        r10.d(this.d);
        r10.c("support sensor rotate:" + r2);
        f81.a.a(r10.b());
        return r2;
    L36:
        if (r8.getRoomAuthStatus() != null) goto L38;
    L41:
        r3 = true;
        goto L42
    L38:
        if (r8.getRoomAuthStatus().isEnableSwitchLandscape() == true) goto L41;
        r3 = false;
        goto L42
    L13:
        if (r1.getBoolean("live.intent.extra.EXTRA_NO_FULL_VIDEO_BTN", false) == true) goto L33;
        if (r8.isStar() == true) goto L19;
        if (r8.isThirdParty() == false) goto L19;
    L28:
        r3 = true;
    L30:
        if (k.f(IMediaReplayService.class) == null) goto L34;
        IMediaReplayService r12 = k.f(IMediaReplayService.class);
        Intrinsics.checkNotNull(r12);
        if (r12.isShowGenerating() == false) goto L34;
    L19:
        if (r8.isScreenshot() == true) goto L28;
        RoomSpecificSceneTypeInfo r13 = r8.getSceneTypeInfo();
        if ((r13 instanceof RoomSpecificSceneTypeInfo) == true) goto L23;
        r13 = null;
    L23:
        if (r13 != null) goto L25;
    L27:
        r3 = false;
        goto L30
    L25:
        if (r13.isLandscapeVertical() != true) goto L27;
    L64:
        return false;
    }

    public a(RoomContext r2, DataCenter r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "rCtx");
        Intrinsics.checkNotNullParameter(r4, "playFragArgs");
        this.e = r3;
        this.f = r4;
        this.d = "SensorJudge";
    }
}
