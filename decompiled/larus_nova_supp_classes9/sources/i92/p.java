package i92;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.livesdk.interactivity.notifications.LiveRoomNotifyWidget;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherWrapperEvent;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p implements Consumer<JumpToOtherWrapperEvent> {
    public final /* synthetic */ LiveRoomNotifyWidget a;

    public p(LiveRoomNotifyWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r13) throws Exception {
        JumpToOtherWrapperEvent r14 = (JumpToOtherWrapperEvent) r13;
        if (r14 == null) goto L78;
        JumpToOtherRoomEvent r15 = r14.event;
        if (r15 != null) goto L7;
        return;
    L7:
        if (r15.enterExtra != null) goto L9;
        r15.enterExtra = new Bundle();
    L9:
        r15.enterExtra.putInt("back_source", 1);
        Activity r0 = ContextUtil.contextToActivity(this.a.getContext());
        DataCenter r3 = ((Widget) this.a).dataCenter;
        Bundle r4 = r15.enterExtra;
        boolean r5 = false;
        int r1 = r4.getInt("back_source", 0);
        if (r1 != 1) goto L12;
    L24:
        r5 = true;
    L25:
        if (r5 == false) goto L76;
        if (r3 == null) goto L76;
        Room r2 = (Room) r3.get("data_room");
        if (r2 == null) goto L76;
        Bundle r6 = (Bundle) r3.get("data_room_back_extra");
        if (Logger.debug() == false) goto L37;
        StringBuilder r7 = new StringBuilder("next:");
        if (r6 == null) goto L35;
        String r8 = r6.toString();
    L36:
        r7.append(r8);
        Logger.d("BackToRoomDataUtils", r7.toString());
        goto L37
    L35:
        r8 = "null";
    L37:
        IMicRoomService r9 = jc1.k.f(IMicRoomService.class);
        if (r9 != null) goto L40;
    L51:
        Bundle r10 = ArgumentsBuilder.buildRoomArgs(r2);
        if (r10 != null) goto L54;
    L53:
        Bundle r11 = null;
    L59:
        int r16 = r2.getOrientation();
        if (r11 == null) goto L76;
        r11.putInt("orientation", r16);
        if (r6 == null) goto L65;
        r11.putBundle("log_extra", r6);
    L65:
        if (r4.containsKey("enter_from_merge") == true) goto L67;
    L69:
        r4.putBundle("live.intent.extra.BACK_PRE_ROOM_EXTRA", r11);
        if (TTLiveService.getLiveService() == null) goto L76;
        ILiveOntologyInfoManager r17 = TTLiveService.getLiveService().getLiveOntologyRecord();
        long r18 = r11.getLong("live.intent.extra.ROOM_ID");
        if (r0 == null) goto L74;
        int r19 = r0.hashCode();
    L75:
        r17.recordBackRoomInfo(r18, r19);
        goto L76
    L74:
        r19 = -1;
        goto L75
    L67:
        if (r4.containsKey("challenge_page") == false) goto L69;
        r11.putString("live.intent.extra.CREATE_PRE_ROOM_BUNDLE_SCENE", r4.getString("enter_from_merge", BuildConfig.FLAVOR) + "_" + r4.getString("challenge_page"));
        r11.putLong("live.intent.extra.PRE_ROOM_ID", ((Long) r3.get("data_room_id", 0L)).longValue());
        goto L69
    L54:
        User r110 = r2.getBaseOwner();
        if (r110 == null) goto L57;
        r10.putString("anchor_id", r110.getIdStr());
        r10.putParcelable("pre_room_user_avatar", r110.getAvatarThumb());
    L57:
        r10.putBoolean("can_go_back", true);
    L58:
        r11 = r10;
        goto L59
    L40:
        if (r9.isMicRoom(r2) == false) goto L51;
        r10 = ArgumentsBuilder.buildRoomArgs(r2);
        if (r10 == null) goto L53;
        OfficialChannelInfo r111 = r2.officialChannelInfo;
        if (r111 == null) goto L53;
        User r112 = r111.getChannelUser();
        if (r112 == null) goto L50;
        r10.putString("anchor_id", r112.getIdStr());
        r10.putParcelable("pre_room_user_avatar", r112.getAvatarThumb());
    L50:
        r10.putBoolean("from_mic_room", true);
        r10.putBoolean("can_go_back", true);
        r10.putLong("show_time", (r2.officialChannelInfo.getEndTimeStamp() - (com.bytedance.android.livesdk.utils.ntp.e.a() / 1000)) - 60);
    L76:
        JumpToOtherRoomEvent r20 = new JumpToOtherRoomEvent(r15.roomId, "live_detail", r15.enterExtra);
        r20.source = "sourceJumpToOtherLiveRoomNotifyW_" + r15.enterLiveSource;
        xs2.b.a().post(r20);
        return;
    L12:
        if (r1 == 3) goto L24;
        if (r1 == 5) goto L24;
        if (r1 == 6) goto L24;
        if (r1 == 7) goto L24;
        if (r1 != 8) goto L25;
    }
}
