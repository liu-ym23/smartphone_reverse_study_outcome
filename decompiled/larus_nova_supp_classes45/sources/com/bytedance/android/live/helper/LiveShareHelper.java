package com.bytedance.android.live.helper;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.api.MatchShareApi;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.m;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.share.ShareOutsideDialogParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SharePublishParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.android.livehostapi.business.depend.share.ShareSubScene;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.ShareResource;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomImInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionResponseDataSingle;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import py.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveShareHelper {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ MatchShareParam b;
        public final /* synthetic */ HashMap c;

        public a(FragmentActivity r1, MatchShareParam r2, HashMap r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Response r5 = (Response) r4;
            int r0 = LiveShareHelper.a;
            FragmentActivity r1 = this.a;
            MatchShareParam r2 = this.b;
            if (r5 == null) goto L8;
            CollectionResponseDataSingle r6 = (CollectionResponseDataSingle) ((BaseResponse) r5).data;
            if (r6 == null) goto L8;
            CollectionItem r7 = r6.getCollectionItem();
            if (r7 == null) goto L8;
        L9:
            LiveShareHelper.a(r1, r2, r7, this.c);
            return;
        L8:
            r7 = new CollectionItem();
            goto L9
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ MatchShareParam b;
        public final /* synthetic */ CollectionItem c;
        public final /* synthetic */ HashMap d;

        public b(FragmentActivity r1, MatchShareParam r2, CollectionItem r3, HashMap r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            int r6 = LiveShareHelper.a;
            LiveShareHelper.a(this.a, this.b, this.c, this.d);
        }
    }

    static {
    }

    public static void a(FragmentActivity r21, final MatchShareParam r22, CollectionItem r23, HashMap r24) {
        Intrinsics.checkNotNullParameter(r21, "activity");
        Intrinsics.checkNotNullParameter(r22, "param");
        Intrinsics.checkNotNullParameter(r24, "extraParams");
        ShareParams.Builder r2 = ShareParams.builder();
        ShareSubScene r3 = ShareSubScene.Unknown;
        if (TextUtils.isEmpty(r22.b) == true) goto L6;
        r3 = ShareSubScene.LiveMatchMoment;
    L43:
        if (r2 == null) goto L45;
        SharePublishParam r4 = r2.getSharePublishParam();
    L46:
        if (r4 == null) goto L48;
        r4.setShareFromKey(r22.l.a);
    L48:
        if (r4 == null) goto L50;
        r4.setShareFromType(r22.l.b);
    L50:
        if (r4 == null) goto L52;
        r4.setOnPublishLaunch(new LiveShareHelper$onShowShareDialog$1(r22));
    L52:
        HashMap r6 = r22.n;
        if (TextUtils.isEmpty(r22.m) == true) goto L55;
        r6.put("content_type", r22.m);
        r24.put("content_type", r22.m);
        r6.put("sjb_content_type", r22.m);
        r24.put("sjb_content_type", r22.m);
    L55:
        IRoom r7 = r22.f;
        if ((r7 instanceof Room) == true) goto L58;
        r7 = null;
    L58:
        Room r8 = (Room) r7;
        boolean r9 = true;
        String r11 = "0";
        String r12 = "";
        if (r8 == null) goto L118;
        r6.put("room_type", GamePromoteDataContext.LIVE);
        if (r4 == null) goto L71;
        List r5 = r8.publishMusicIds;
        if (r5 == null) goto L69;
        List r13 = r5;
        if ((!r13.isEmpty()) == false) goto L67;
        String r14 = (String) CollectionsKt.random(r13, Random.Default);
    L68:
        if (r14 == null) goto L69;
    L70:
        r4.setMusicId(r14);
        goto L71
    L67:
        r14 = "";
    L69:
        r14 = "";
    L71:
        ShareParams.Builder r15 = ShareParams.buildUponRoom(r8);
        IUserService r16 = k.f(IUserService.class);
        if (r16 == null) goto L77;
        f r17 = r16.user();
        if (r17 == null) goto L77;
        String r18 = r17.n();
        if (r18 == null) goto L77;
    L78:
        r2 = r15.setUserId(r18).setDescription(r8.getUserShareText()).setAnchor(true).setSharePublishParam(r4);
        if (r2 == null) goto L113;
        ShareOutsideDialogParam r19 = new ShareOutsideDialogParam();
        EpisodeExtraInfo r110 = r8.getEpisodeExtra2();
        if (r110 == null) goto L89;
        IMatchRoomInfo r111 = r110.getMatchRoomInfo();
        if (r111 == null) goto L89;
        IMatchRoomImInfo r112 = r111.getImInfo();
        if (r112 == null) goto L89;
        py.k r113 = r112.getIcon();
        if (r113 == null) goto L89;
        ImageModel r114 = (ImageModel) m.b(r113, ImageModel.class);
    L90:
        r19.setShareCardIcon(r114);
        EpisodeExtraInfo r115 = r8.getEpisodeExtra2();
        if (r115 == null) goto L97;
        IMatchRoomInfo r116 = r115.getMatchRoomInfo();
        if (r116 == null) goto L97;
        IMatchRoomImInfo r117 = r116.getImInfo();
        if (r117 == null) goto L97;
        String r118 = r117.getTitle();
    L98:
        r19.setShareCardTitle(r118);
        EpisodeExtraInfo r119 = r8.getEpisodeExtra2();
        if (r119 == null) goto L107;
        IMatchRoomInfo r120 = r119.getMatchRoomInfo();
        if (r120 == null) goto L107;
        List r121 = r120.backgroundImageUrlList();
        if (r121 == null) goto L107;
        py.k r122 = (py.k) CollectionsKt.firstOrNull(r121);
        if (r122 == null) goto L107;
        ImageModel r123 = (ImageModel) m.b(r122, ImageModel.class);
    L108:
        r19.setPosterShareBackground(r123);
        ShareResource r25 = r8.shareResource;
        if (r25 == null) goto L111;
        ImageModel r26 = r25.getToastBackground();
    L112:
        r19.setToastBackground(r26);
        Unit r27 = Unit.INSTANCE;
        r2.setCustomCommandDialogParam(r19);
        goto L113
    L111:
        r26 = null;
    L107:
        r123 = null;
    L97:
        r118 = null;
    L89:
        r114 = null;
    L113:
        if (r2 == null) goto L118;
        String r28 = r22.a;
        if (r28 != null) goto L117;
        r28 = "";
    L117:
        r2.setEnterFrom(r28);
    L77:
        r18 = "0";
    L118:
        Episode r29 = r22.g;
        if (r29 == null) goto L146;
        r6.put("room_type", "replay");
        ShareParams.Builder r31 = ShareParams.buildUponReplay(r29);
        IUserService r124 = k.f(IUserService.class);
        if (r124 == null) goto L128;
        f r125 = r124.user();
        if (r125 == null) goto L128;
        String r126 = r125.n();
        if (r126 == null) goto L128;
        r11 = r126;
    L128:
        r2 = r31.setUserId(r11).setAnchor(true).setDescription(r29.share.userShareText).setSharePublishParam(r4);
        if (TextUtils.isEmpty(r22.a) == false) goto L132;
        if (r2 == null) goto L132;
        r2.setEnterFrom("match_episode_room");
    L132:
        if (r2 == null) goto L140;
        ShareOutsideDialogParam r32 = new ShareOutsideDialogParam();
        EpisodeBasicInfo r33 = r29.episodeBasicInfo;
        if (r33 == null) goto L138;
        s r34 = r33.getShareResource();
        if (r34 == null) goto L138;
        py.k r35 = r34.getToastBackground();
    L139:
        r32.setToastBackground(r35);
        Unit r36 = Unit.INSTANCE;
        r2.setCustomCommandDialogParam(r32);
    L138:
        r35 = null;
    L140:
        r24.put("replay_id", String.valueOf(r29.getIdExt()));
        if (r2 == null) goto L146;
        String r37 = r22.a;
        if (r37 != null) goto L145;
        r37 = "";
    L145:
        r2.setEnterFrom(r37);
    L146:
        if (r2 == null) goto L278;
        Bundle r38 = r2.getExtras();
        if (r38 == null) goto L248;
        if (r23 == null) goto L151;
        String r39 = r23.getLocalImagePath();
    L152:
        r38.putString("quickShotPath", r39);
        if (r23 == null) goto L155;
        String r41 = r23.getLocalVideoPath();
    L156:
        r38.putString("quickRecordPath", r41);
        VideoViewParams r42 = r22.e;
        if (r42 == null) goto L159;
        int r43 = r42.b;
    L160:
        r38.putInt("key_share_live_video_height", r43);
        VideoViewParams r44 = r22.e;
        if (r44 == null) goto L163;
        int r45 = r44.a;
    L164:
        r38.putInt("key_share_live_video_width", r45);
        r38.putInt("key_share_live_screen_height", s1.r());
        r38.putInt("key_share_live_screen_width", s1.t());
        if (r23 == null) goto L167;
        String r46 = r23.getShareInfo();
    L168:
        r38.putString("MatchPublishData", r46);
        if (r23 == null) goto L171;
        String r47 = String.valueOf(r23.getCollectionType());
    L173:
        if (Intrinsics.areEqual(r47, GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L183;
        py.k r127 = r23.getCoverImage();
        if (r127 == null) goto L180;
        List<String> r128 = r127.getUrls();
        if (r128 == null) goto L180;
        String r129 = (String) CollectionsKt.firstOrNull(r128);
        if (r129 == null) goto L180;
    L181:
        r38.putString("MatchMomentPublishDataUrl", r129);
    L188:
        r38.putString("MatchMomentPublishDataType", r47);
        IRoom r48 = r22.f;
        if ((r48 instanceof Room) == true) goto L191;
        r48 = null;
    L191:
        Room r49 = (Room) r48;
        if (r49 == null) goto L199;
        EpisodeExtraInfo r51 = r49.getEpisodeExtra2();
        if (r51 == null) goto L199;
        IMatchRoomInfo r52 = r51.getMatchRoomInfo();
        if (r52 == null) goto L199;
        String r53 = r52.getMatchHashTag();
        if (r53 == null) goto L199;
    L200:
        r38.putString("MatchPublishHashTag", r53);
        IRoom r54 = r22.f;
        if ((r54 instanceof Room) == true) goto L203;
        r54 = null;
    L203:
        Room r55 = (Room) r54;
        if (r55 == null) goto L214;
        EpisodeExtraInfo r56 = r55.getEpisodeExtra2();
        if (r56 == null) goto L214;
        IMatchRoomInfo r57 = r56.getMatchRoomInfo();
        if (r57 == null) goto L214;
        IMatchRoomImInfo r58 = r57.getImInfo();
        if (r58 == null) goto L214;
        py.k r59 = r58.getIcon();
        if (r59 == null) goto L214;
        ImageModel r61 = (ImageModel) m.b(r59, ImageModel.class);
    L215:
        r38.putParcelable("key_share_live_bottom_card_icon", r61);
        IRoom r62 = r22.f;
        if ((r62 instanceof Room) == true) goto L218;
        r62 = null;
    L218:
        Room r63 = (Room) r62;
        if (r63 == null) goto L228;
        EpisodeExtraInfo r64 = r63.getEpisodeExtra2();
        if (r64 == null) goto L228;
        IMatchRoomInfo r65 = r64.getMatchRoomInfo();
        if (r65 == null) goto L228;
        IMatchRoomImInfo r66 = r65.getImInfo();
        if (r66 == null) goto L228;
        String r67 = r66.getTitle();
        if (r67 == null) goto L228;
    L229:
        r38.putString("key_share_live_bottom_card_title", r67);
        r38.putLong("key_share_live_video_width", r22.h);
        if (s1.F() == true) goto L232;
    L234:
        boolean r68 = false;
    L235:
        r38.putBoolean("is_use_dark_mode_force", r68);
        if (r23 == null) goto L238;
        String r69 = r23.getUgShareInfo();
    L239:
        r38.putString("downgrade_share_info", r69);
        if (r3 != ShareSubScene.LiveQuickShot) goto L248;
        r38.putBoolean("key_no_read_external_storage", true);
        if (r23 == null) goto L247;
        String r130 = r23.getLocalImagePath();
        if (r130 == null) goto L247;
        r12 = r130;
    L247:
        r38.putParcelable("quickShotUri", Uri.fromFile(new PolarisFileWrapper(r12)));
        goto L248
    L238:
        r69 = null;
        goto L239
    L232:
        if (r3 != ShareSubScene.LiveMatchMoment) goto L234;
        r68 = true;
    L228:
        r67 = "";
    L214:
        r61 = null;
    L199:
        r53 = "";
    L180:
        r129 = "";
        goto L181
    L183:
        if (Intrinsics.areEqual(r47, GamePromoteDataContext.GAME_TYPE_MINI) == false) goto L188;
        String r131 = r23.getOriginalVidUrl();
        if (r131 != null) goto L187;
        r131 = "";
    L187:
        r38.putString("MatchMomentPublishDataUrl", r131);
        goto L188
    L171:
        r47 = null;
        goto L173
    L167:
        r46 = null;
        goto L168
    L163:
        r45 = 0;
        goto L164
    L159:
        r43 = 0;
        goto L160
    L155:
        r41 = null;
        goto L156
    L151:
        r39 = null;
    L248:
        if (r23 == null) goto L250;
        py.k r71 = r23.getCoverImage();
    L251:
        if (r71 == null) goto L253;
        r2.setCover(r23.getCoverImage());
    L253:
        HashMap r72 = new HashMap();
        r72.putAll(r24);
        r72.putAll(r6);
        Unit r73 = Unit.INSTANCE;
        r2.setActivityInfo(r72);
        r2.setShareSubScene(r3);
        r2.setExtraParams(r24);
        r2.setLogExtraParams(r6);
        if (r22.f == null) goto L256;
        ShareScene r1 = ShareScene.LIVE;
    L257:
        r2.setShareScene(r1);
        IRoom r74 = r22.f;
        if (r74 == null) goto L264;
        IRoomAuthStatus r0 = r74.getRoomAuthStatus();
        if (r0 != null) goto L262;
    L271:
        r9 = false;
    L272:
        r2.setEnablePoster(r9);
        ShareParams r75 = r2.build();
        if (r75 == null) goto L279;
        ILiveShareService r76 = k.f(ILiveShareService.class);
        if (r76 == null) goto L280;
        r76.share(new i81.a(null, r21, null, r75, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "LandscapeShareFragment", LiveShareType.SHARE_DIALOG, null);
        return;
    L280:
        return;
    L279:
        return;
    L262:
        if (r0.getPoster() != 1) goto L271;
    L264:
        Episode r77 = r22.g;
        if (r77 == null) goto L271;
        IRoomAuthStatus r78 = r77.getRoomAuthStatus();
        if (r78 == null) goto L271;
        if (r78.getPoster() != 1) goto L271;
    L256:
        r1 = ShareScene.REPLAY;
        goto L257
    L250:
        r71 = null;
        goto L251
    L278:
        return;
    L45:
        r4 = null;
        goto L46
    L6:
        if (CollectionUtils.isEmpty(r22.d) == true) goto L26;
        List r79 = r22.d;
        if (r79 == null) goto L12;
        CollectionItem r81 = (CollectionItem) CollectionsKt.firstOrNull(r79);
        if (r81 == null) goto L12;
        String r82 = r81.getLocalImagePath();
    L14:
        if (TextUtils.isEmpty(r82) == true) goto L16;
        r3 = ShareSubScene.LiveQuickShot;
        goto L43
    L16:
        List r83 = r22.d;
        if (r83 == null) goto L21;
        CollectionItem r84 = (CollectionItem) CollectionsKt.firstOrNull(r83);
        if (r84 == null) goto L21;
        String r85 = r84.getLocalVideoPath();
    L23:
        if (TextUtils.isEmpty(r85) == true) goto L43;
        r3 = ShareSubScene.LiveQuickRecord;
    L21:
        r85 = null;
    L12:
        r82 = null;
        goto L14
    L26:
        if (CollectionUtils.isEmpty(r22.d) == true) goto L43;
        List r86 = r22.d;
        if (r86 == null) goto L32;
        CollectionItem r87 = (CollectionItem) CollectionsKt.first(r86);
        if (r87 == null) goto L32;
        String r88 = r87.getOriginalVidUrl();
    L34:
        if (TextUtils.isEmpty(r88) == false) goto L42;
        List r89 = r22.d;
        if (r89 == null) goto L40;
        CollectionItem r91 = (CollectionItem) CollectionsKt.first(r89);
        if (r91 == null) goto L40;
        py.k r92 = r91.getCoverImage();
    L41:
        if (r92 == null) goto L43;
    L40:
        r92 = null;
    L42:
        r3 = ShareSubScene.LiveMatchMoment;
    L32:
        r88 = null;
        goto L34
    }

    @JvmStatic
    public static final void b(FragmentActivity r4, MatchShareParam r5, CollectionItem r6, HashMap<String, String> r7) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "param");
        Intrinsics.checkNotNullParameter(r7, "extraParams");
        String r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getCollectionId();
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L32;
        if (r6 == null) goto L10;
        String r2 = r6.getTemplateVid();
    L12:
        if (TextUtils.isEmpty(r2) == true) goto L17;
        if (r6 == null) goto L16;
        r0 = r6.getShareInfo();
    L16:
        if (TextUtils.isEmpty(r0) == false) goto L32;
    L17:
        MatchShareApi r3 = (MatchShareApi) c.b().e(MatchShareApi.class);
        String r8 = "";
        if (r6 == null) goto L21;
        String r9 = r6.getCollectionId();
        if (r9 == null) goto L21;
    L22:
        if (r6 == null) goto L27;
        String r11 = r6.getEpisodeId();
        if (r11 == null) goto L27;
        r8 = r11;
    L27:
        Observable<Response<CollectionResponseDataSingle>> r12 = r3.getCollectionDataByCollectionId(r9, r8);
        if (r12 == null) goto L34;
        Observable r13 = r12.observeOn(AndroidSchedulers.mainThread());
        if (r13 == null) goto L35;
        r13.subscribe(new a(r4, r5, r7), new b(r4, r5, r6, r7));
        return;
    L35:
        return;
    L34:
        return;
    L21:
        r9 = "";
        goto L22
    L10:
        r2 = null;
    L32:
        a(r4, r5, r6, r7);
        return;
    L5:
        r1 = null;
        goto L7
    }
}
