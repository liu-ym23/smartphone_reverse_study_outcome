package com.bytedance.android.livesdk.drawer.history;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.core.utils.d1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.utils.landscape.LandscapeLiveMonitor;
import com.bytedance.android.livesdk.utils.landscape.LandscapeScene;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import java.util.HashMap;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ HistoryViewHolder a;
    public final /* synthetic */ ScheduledLiveItem b;

    public d(HistoryViewHolder r1, ScheduledLiveItem r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r14) {
        if (this.b.getRoom() == null) goto L41;
        Room r15 = this.b.getRoom();
        if (r15 == null) goto L49;
        Bundle r1 = new Bundle();
        this.a.getClass();
        r1.putString("enter_from_merge", "drawer_hot");
        this.a.getClass();
        r1.putString("enter_method", "live_history");
        r1.putString("log_pb", r15.getLog_pb());
        r1.putString("request_id", r15.getRequestId());
        Bundle r6 = new Bundle();
        String r9 = new UrlBuilder("/webcast/feed/").addParam("need_map", 1).addParam("source_key", "drawer_hot_drawer_cover").addParam("inner_from_drawer", 1).build();
        ILiveService r10 = TTLiveService.getLiveService();
        if (r10 == null) goto L26;
        ILiveOntologyInfoManager r11 = r10.getLiveOntologyRecord();
        if (r11 == null) goto L26;
        if (r11.isEnableReplaceRecommend() != true) goto L26;
        ILiveService r12 = TTLiveService.getLiveService();
        if (r12 == null) goto L17;
        ILiveOntologyInfoManager r13 = r12.getLiveOntologyRecord();
        if (r13 == null) goto L17;
        String r16 = r13.getInnerUrl();
    L19:
        if (TextUtils.isEmpty(r16) == true) goto L26;
        ILiveService r17 = TTLiveService.getLiveService();
        if (r17 == null) goto L25;
        ILiveOntologyInfoManager r18 = r17.getLiveOntologyRecord();
        if (r18 == null) goto L25;
        r9 = r18.getInnerUrl();
    L25:
        r9 = null;
    L17:
        r16 = null;
    L26:
        r6.putBoolean("live.intent.extra.FROM_NEW_STYLE", true);
        r6.putString("enter_from_live_source", "live_square");
        r6.putString("live.intent.extra.FEED_URL", r9);
        this.a.getClass();
        r6.putString("enter_from_merge", "drawer_hot");
        this.a.getClass();
        r6.putString("enter_method", "live_history");
        ArgumentsBuilder.buildCustomizeAudioRoomArgs(r15, r6);
        r6.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", r1);
        r6.putString("log_pb", r15.getLog_pb());
        r6.putString("request_id", r15.getRequestId());
        r6.putString("live.intent.extra.PULL_STREAM_URL", r15.buildPullUrl());
        StreamUrl r2 = r15.getStreamUrl();
        if (r2 == null) goto L29;
        yt2.a.f(r6, r2);
    L29:
        r6.putString("live.intent.extra.PULL_SDK_PARAMS", r15.getSdkParams());
        if (r15.getMultiStreamData() == null) goto L32;
        yt2.a.g(r6, "live.intent.extra.PULL_STREAM_DATA", r15.getMultiStreamData());
    L32:
        r6.putString("live.intent.extra.PULL_DEFAULT_RESOLUTION", r15.getMultiStreamDefaultQualitySdkKey());
        this.a.getClass();
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L35;
    L38:
        TTLiveSDK.hostService().action().startLive(this.a.getContext(), r15.getId(), r6);
        e r19 = this.a.j;
        if (r19 == null) goto L50;
        r19.c();
        return;
    L50:
        return;
    L35:
        if (com.bytedance.android.livesdk.utils.landscape.b.a() == false) goto L38;
        LandscapeLiveMonitor.a r3 = LandscapeLiveMonitor.Companion;
        Pair r4 = TuplesKt.to(Long.valueOf(r15.id), LandscapeScene.JUMP);
        r3.getClass();
        LandscapeLiveMonitor.a.d(r4);
        r6.putBoolean("live.intent.extra.is_game_live", d1.a(r15));
        r6.putInt("live.intent.extra.SCREEN_ORIENTATION", ((Boolean) r0.isPortraitInteraction().getValue()).booleanValue() ? 1 : 0);
        goto L38
    L49:
        return;
    L41:
        String r110 = this.b.getSecUid();
        if (TextUtils.isEmpty(r110) == false) goto L44;
        r110 = this.b.getUidStr();
    L44:
        HashMap r5 = new HashMap();
        if (TextUtils.isEmpty(r110) == true) goto L47;
        r5.put("sec_user_id", r110);
    L47:
        k.n(IRoomService.class).actionHandler().showUserProfile(this.b.getUidStr(), null, r5);
    }
}
