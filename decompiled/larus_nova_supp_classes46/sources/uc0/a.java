package uc0;

import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.i;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class a extends i {
    public a() {
    }

    public k getAvatarForRoomIntroMessage(b4 r7) {
        Intrinsics.checkNotNullParameter(r7, "roomIntroMessage");
        m0 r8 = r7.getBaseMessage();
        if (r8 == null) goto L15;
        long r1 = r8.getRoomId();
        ILiveRoomService r9 = jc1.k.f(ILiveRoomService.class);
        if (r9 == null) goto L7;
        Room r10 = r9.getCurrentRoomFromRoomContext();
    L8:
        if (r10 != null) goto L10;
        return null;
    L10:
        if (r1 != r10.getRoomId()) goto L17;
        User r2 = r10.getOwner();
        RoomAuthStatus r11 = r10.getMRoomAuthStatus();
        if (r2 != null) goto L14;
        return null;
    L14:
        return r2.getAvatarThumbByRoomAuth(r11);
    L17:
        return null;
    L7:
        r10 = null;
        goto L8
    L15:
        return null;
    }

    public String getCommentTip(DataCenter r4) {
        if (r4 == null) goto L5;
        Boolean r5 = (Boolean) r4.get("enter_from_effect_ad", Boolean.FALSE);
    L7:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == true) goto L9;
        return null;
    L9:
        return s1.B(2131919969);
    L5:
        r5 = null;
        goto L7
    }
}
