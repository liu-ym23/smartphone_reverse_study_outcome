package d81;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.api.base.alog.SimpleAlogArgsBuilder;
import com.bytedance.android.live.room.api.screenrotation.entrance.IRotateEntrance;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomFullVideoBtn;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import kotlin.jvm.internal.Intrinsics;
import z70.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends com.bytedance.android.live.room.api.screenrotation.entrance.judge.a {
    public final String d;
    public final RoomContext e;
    public final DataCenter f;

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
    public final boolean a(IRotateEntrance r9) {
        Intrinsics.checkNotNullParameter(r9, "entrance");
        DataCenter r10 = this.f;
        Room r0 = null;
        if (r10 == null) goto L5;
        Room r12 = z.o(r10);
    L6:
        SimpleAlogArgsBuilder r1 = new SimpleAlogArgsBuilder();
        r1.d(this.d);
        StringBuilder r2 = new StringBuilder("isPortrait:");
        DataCenter r3 = this.f;
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        r2.append(r4);
        r2.append("\tisAudience:");
        r2.append(!z.e(this.f, false));
        r2.append("\troomType:");
        if (r12 != null) goto L16;
    L26:
        boolean r5 = false;
    L27:
        r2.append(r5);
        r2.append("\tisVr:");
        r2.append(!VrUtils.y(this.f));
        r2.append("\troomContext?.showFullVideoButton?.value:");
        RoomContext r6 = this.e;
        if (r6 == null) goto L32;
        m r7 = r6.getShowFullVideoButton();
        if (r7 == null) goto L32;
        Boolean r8 = (Boolean) r7.getValue();
    L33:
        r2.append(r8);
        r1.c(r2.toString());
        f81.a.a(r1.b());
        RoomContext r13 = RoomContext.a.c(RoomContext.Companion, this.f, 0, 2);
        if (r13 == null) goto L40;
        n r14 = r13.getTemplateContext();
        if (r14 == null) goto L40;
        b r15 = (b) r14.getValue();
        if (r15 == null) goto L40;
        boolean r16 = r15.j("full_screen");
    L41:
        if (r16 == false) goto L61;
        DataCenter r17 = this.f;
        if (r17 == null) goto L45;
        r0 = (Room) r17.get("data_room", null);
    L45:
        DataCenter r18 = this.f;
        if (r18 == null) goto L50;
        if (z.m(r18, true) == true) goto L50;
    L59:
        return false;
    L50:
        if (z.e(this.f, false) == true) goto L59;
        if (r0 == null) goto L96;
        RoomPlatformComponentsData r19 = r0.roomPlatformComponentsData;
        if (r19 == null) goto L97;
        RoomFullVideoBtn r20 = r19.getFullVideoBtn();
        if (r20 != null) goto L57;
        return true;
    L57:
        if (r20.getShow() == RoomFullVideoBtn.FullVideoBtnShow.is_Close.getType()) goto L59;
        return true;
    L97:
        return true;
    L96:
        return true;
    L61:
        if (r12 != null) goto L63;
    L65:
        DataCenter r22 = this.f;
        if (r22 == null) goto L70;
        if (z.m(r22, true) == true) goto L70;
    L94:
        return false;
    L70:
        if (z.e(this.f, false) == true) goto L94;
        if (r12 == null) goto L94;
        if (r12.isStar() == true) goto L94;
        if (r12.isThirdParty() == false) goto L77;
    L85:
        RoomContext r23 = this.e;
        if (r23 == null) goto L94;
        if (r23.isVSRoom() == true) goto L94;
        if (VSMediaUIConfigHelper.b(this.f) == true) goto L94;
        if (((Boolean) this.e.getShowFullVideoButton().getValue()).booleanValue() == false) goto L94;
        return true;
    L77:
        if (r12.isScreenshot() == true) goto L85;
        Room r24 = r12.getSceneTypeInfo();
        if ((r24 instanceof RoomSpecificSceneTypeInfo) == false) goto L82;
        r0 = r24;
    L82:
        if (r0 == null) goto L94;
        if (r0.isLandscapeVertical() != true) goto L94;
    L63:
        if (r12.isVrRoom() != true) goto L65;
    L40:
        r16 = false;
    L32:
        r8 = null;
        goto L33
    L16:
        if (r12.isStar() == true) goto L26;
        if (r12.isThirdParty() == false) goto L20;
    L21:
        RoomContext r25 = this.e;
        if (r25 == null) goto L26;
        if (r25.isVSRoom() == true) goto L26;
        r5 = true;
        goto L27
    L20:
        if (r12.isScreenshot() == false) goto L26;
    L9:
        if (z.m(r3, true) == true) goto L12;
        r4 = false;
        goto L13
    L5:
        r12 = null;
        goto L6
    }

    public a(RoomContext r1, DataCenter r2) {
        this.e = r1;
        this.f = r2;
        this.d = "LandscapeSupportJudge";
    }
}
