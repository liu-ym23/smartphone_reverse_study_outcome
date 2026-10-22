package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.jsbridge.base.ShareViewToPanelResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.LiveQrCodeConfig;
import com.bytedance.android.livehostapi.business.depend.share.ShareOutsideDialogParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SharePublishParam;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.android.livehostapi.business.depend.share.ShareSubScene;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.gift.effect.normal.utils.BitmapTranslateUtils;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.ShareResource;
import com.bytedance.android.livesdkapi.depend.model.live.episode.BaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeShare;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomImInfo;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.lynx.tasm.LynxView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import w20.ue;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "shareViewToPanel")
public final class oc extends w20.m6<ue, ShareViewToPanelResultModel> {
    public final y6.c a;

    public static final class a {
    }

    static {
    }

    public oc(y6.c r1) {
        this.a = r1;
    }

    public final void invoke(Object r25, CallContext r26) {
        ue r1 = (ue) r25;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r26, "context");
        boolean r0 = com.bytedance.android.live.core.utils.s1.F();
        Boolean r14 = Boolean.FALSE;
        boolean r3 = true;
        if (r0 == true) goto L5;
        xs2.b.a().post(new HorizontalPlayEvent(1, 0, "source_landscape_vs_msg_board"));
    L5:
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.m r4 = r2.getRoom();
        if (r4 == null) goto L10;
        Room r8 = (Room) r4.getValue();
    L11:
        lm1.b r5 = pm1.f.d(null);
        if (r5 == null) goto L16;
        com.bytedance.live.datacontext.n r6 = r5.getEpisode();
        if (r6 == null) goto L16;
        Episode r9 = (Episode) r6.getValue();
    L17:
        y6.c r7 = this.a;
        if (r7 == null) goto L22;
        IHybridComponent r11 = r7.c();
        if (r11 == null) goto L22;
        View r12 = r11.getHybridView();
    L24:
        if ((r12 instanceof LynxView) == false) goto L37;
        String r13 = r1.l();
        if (r13 != null) goto L28;
    L30:
        View r15 = null;
    L31:
        String r16 = r1.i();
        if (r16 != null) goto L34;
    L36:
        View r17 = null;
    L38:
        ILiveService r18 = TTLiveService.getLiveService();
        if (r18 == null) goto L44;
        String r19 = r1.getType();
        if (r19 != null) goto L43;
        r19 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L43:
        ILiveQrCodeShareHelper r110 = r18.getQrCodeShareHelper(CastIntegerProtector.parseInt(r19));
    L45:
        if (r15 == null) goto L49;
        Bitmap r111 = BitmapTranslateUtils.c(r15);
        if (r110 == null) goto L49;
        r110.setViewCutBitmap(r111);
        Unit r112 = Unit.INSTANCE;
    L49:
        if (r17 == null) goto L53;
        Bitmap r21 = BitmapTranslateUtils.c(r17);
        if (r110 == null) goto L53;
        r110.setSavePicBitmap(r21);
        Unit r22 = Unit.INSTANCE;
    L53:
        String r23 = r1.getType();
        if (r23 == null) goto L56;
        Integer r24 = Integer.valueOf(CastIntegerProtector.parseInt(r23));
    L57:
        int r113 = ShareType.MatchSituation.getType();
        if (r24 != null) goto L61;
    L72:
        LiveQrCodeConfig r27 = new LiveQrCodeConfig();
        r27.setPanelType(4);
        if ((r110 instanceof IQrCodeShareHelper) == true) goto L75;
        r110 = null;
    L75:
        IQrCodeShareHelper r114 = (IQrCodeShareHelper) r110;
        if (r114 == null) goto L78;
        r27.setQrCodeShareHelper(r114);
    L78:
        HashMap r115 = new HashMap();
        Map r116 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        if (r116 == null) goto L81;
        r115.putAll(r116);
        Unit r117 = Unit.INSTANCE;
    L81:
        HashMap r118 = new HashMap();
        if (r8 == null) goto L112;
        Map r28 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        if (r28 == null) goto L86;
        r115.putAll(r28);
        Unit r29 = Unit.INSTANCE;
    L86:
        Map r31 = com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap();
        if (r31 == null) goto L89;
        r115.putAll(r31);
        Unit r32 = Unit.INSTANCE;
    L89:
        int r33 = ju2.f.M;
        r115.putAll(ju2.f.a.a(r8).b());
        Unit r34 = Unit.INSTANCE;
        r115.put("room_type", GamePromoteDataContext.LIVE);
        ShareParams.Builder r35 = ShareParams.buildUponRoom(r8).setEnterFrom(r1.a()).setUserId(jc1.k.n(IUserService.class).user().n()).setDescription(r8.getAnchorShareText()).setAnchor(true);
        if (r35 == null) goto L113;
        ShareOutsideDialogParam r36 = new ShareOutsideDialogParam();
        EpisodeExtraInfo r37 = r8.getEpisodeExtra2();
        if (r37 == null) goto L98;
        IMatchRoomInfo r38 = r37.getMatchRoomInfo();
        if (r38 == null) goto L98;
        IMatchRoomImInfo r39 = r38.getImInfo();
        if (r39 == null) goto L98;
        py.k r41 = r39.getIcon();
    L99:
        r36.setShareCardIcon((py.k) com.bytedance.android.live.base.model.m.b(r41, ImageModel.class));
        EpisodeExtraInfo r42 = r8.getEpisodeExtra2();
        if (r42 == null) goto L106;
        IMatchRoomInfo r43 = r42.getMatchRoomInfo();
        if (r43 == null) goto L106;
        IMatchRoomImInfo r44 = r43.getImInfo();
        if (r44 == null) goto L106;
        String r45 = r44.getTitle();
    L107:
        r36.setShareCardTitle(r45);
        ShareResource r46 = r8.shareResource;
        if (r46 == null) goto L110;
        ImageModel r47 = r46.getToastBackground();
    L111:
        r36.setToastBackground(r47);
        r35.setCustomCommandDialogParam(r36);
        goto L113
    L110:
        r47 = null;
    L106:
        r45 = null;
    L98:
        r41 = null;
    L113:
        if (r9 == null) goto L129;
        int r48 = am2.a0.L;
        r115.putAll(am2.a0.a.a(r9).a());
        Unit r49 = Unit.INSTANCE;
        r115.putAll(new am2.b0().a());
        r115.put("room_type", "replay");
        r118.put("replay_id", String.valueOf(r9.getIdExt()));
        ShareParams.Builder r51 = ShareParams.buildUponReplay(r9).setEnterFrom(r1.a()).setUserId(jc1.k.n(IUserService.class).user().n());
        EpisodeShare r52 = r9.share;
        if (r52 == null) goto L117;
        String r53 = r52.anchorShareText;
    L118:
        r35 = r51.setDescription(r53).setAnchor(true).setExtraParams(r118);
        if (r35 == null) goto L129;
        ShareOutsideDialogParam r54 = new ShareOutsideDialogParam();
        EpisodeBasicInfo r55 = r9.episodeBasicInfo;
        if (r55 == null) goto L127;
        py.s r56 = r55.getShareResource();
        if (r56 == null) goto L127;
        py.k r57 = r56.getToastBackground();
        if (r57 == null) goto L127;
        ImageModel r58 = (ImageModel) com.bytedance.android.live.base.model.m.b(r57, ImageModel.class);
    L128:
        r54.setToastBackground(r58);
        r35.setCustomCommandDialogParam(r54);
    L127:
        r58 = null;
        goto L128
    L117:
        r53 = null;
    L129:
        HashMap r59 = new HashMap();
        int r61 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r1.c()) == true) goto L322;
    L137:
        int r62 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        String r63 = "";
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r1.a()) == false) goto L160;
        String r64 = r1.a();
        if (r64 != null) goto L142;
        r64 = "";
    L142:
        r59.put("content_type", r64);
        String r65 = r1.a();
        if (r65 != null) goto L145;
        r65 = "";
    L145:
        r115.put("content_type", r65);
        String r66 = r1.a();
        if (r66 != null) goto L148;
        r66 = "";
    L148:
        r118.put("content_type", r66);
        r59.put("token_form", "pic");
        r115.put("token_form", "pic");
        r118.put("token_form", "pic");
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r1.d()) == false) goto L160;
        String r67 = r1.d();
        if (r67 != null) goto L153;
        r67 = "";
    L153:
        r59.put("module_type", r67);
        String r68 = r1.d();
        if (r68 != null) goto L156;
        r68 = "";
    L156:
        r115.put("module_type", r68);
        String r69 = r1.d();
        if (r69 != null) goto L159;
        r69 = "";
    L159:
        r118.put("module_type", r69);
    L160:
        if (r35 != null) goto L163;
        r35 = ShareParams.builder();
    L163:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r1.j()) == true) goto L318;
    L172:
        if (r35 == null) goto L316;
        Bundle r71 = r35.getExtras();
        if (r71 == null) goto L184;
        if (r8 == null) goto L182;
        EpisodeExtraInfo r119 = r8.getEpisodeExtra2();
        if (r119 == null) goto L182;
        IMatchRoomInfo r120 = r119.getMatchRoomInfo();
        if (r120 == null) goto L182;
        String r121 = r120.getMatchHashTag();
        if (r121 == null) goto L182;
    L183:
        r71.putString("MatchPublishHashTag", r121);
        r71.putBoolean("is_match_room", true);
    L182:
        r121 = "";
    L184:
        r35.setActivityInfo(r59);
        r35.setLogExtraParams(r115);
        r35.setLiveQrCodeConfig(r27);
        r35.setShareSceneConfigName(r1.h());
        if (TextUtils.isEmpty(r1.g()) == false) goto L227;
        String r72 = r1.getType();
        if (r72 == null) goto L227;
        if (CastIntegerProtector.parseInt(r72) != ShareType.PaidLivePackage.getType()) goto L227;
        nm1.e r73 = pm1.f.c();
        if (r73 == null) goto L195;
        ReplayDataContext r74 = r73.h(null);
        if (r74 == null) goto L195;
        com.bytedance.live.datacontext.j r75 = r74.getVsMsgBoardDataContext();
    L197:
        if ((r75 instanceof com.bytedance.live.datacontext.j) == true) goto L199;
        r75 = null;
    L199:
        if (r75 == null) goto L204;
        com.bytedance.android.livesdk.chatroom.msgboard.a r76 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r75.getValue();
        if (r76 == null) goto L204;
        IShareCallback r122 = null;
    L210:
        if (r76 == null) goto L217;
        IRoom r77 = r76.getRoom();
        if (r77 == null) goto L217;
        IShareCallback r78 = r77.getShareUrl();
        if (r78 == null) goto L217;
        IShareCallback r79 = r78;
    L224:
        if (r79 != null) goto L226;
        r79 = "";
    L226:
        r35.setUrl(r79);
    L228:
        SharePublishParam r81 = new SharePublishParam();
        String r82 = r1.f();
        if (r82 == null) goto L232;
        r63 = r82;
    L232:
        r81.setMusicId(r63);
        Integer r83 = r1.e();
        if (r83 == null) goto L235;
        int r84 = r83.intValue();
    L236:
        r81.setActivityVideoType(r84);
        String r85 = r1.k();
        if (r85 != null) goto L320;
    L243:
        Unit r86 = Unit.INSTANCE;
        r35.setSharePublishParam(r81);
        if (r9 == null) goto L250;
        EpisodeMod r87 = r9.episodeMod;
        if (r87 == null) goto L250;
        if (((BaseEpisodeMod) r87).episodeStage != EpisodeMod.EpisodeStageType.REPLAY) goto L250;
        boolean r88 = true;
    L251:
        String r89 = r1.getType();
        if (r89 != null) goto L254;
    L256:
        if (r88 == false) goto L258;
        ShareScene r91 = ShareScene.REPLAY;
    L259:
        r35.setShareScene(r91);
        String r92 = r1.getType();
        if (r92 == null) goto L262;
        IShareCallback r93 = Integer.valueOf(CastIntegerProtector.parseInt(r92));
    L263:
        int r94 = ShareType.MatchSituation.getType();
        if (r93 != null) goto L267;
    L269:
        int r95 = ShareType.Prediction.getType();
        if (r93 != null) goto L273;
    L275:
        int r96 = ShareType.Champion.getType();
        if (r93 != null) goto L279;
    L281:
        int r97 = ShareType.PaidLivePackage.getType();
        if (r93 != null) goto L285;
    L287:
        int r98 = ShareType.ReceiveShareTicket.getType();
        if (r93 != null) goto L291;
    L293:
        int r99 = ShareType.PaidLiveTicket.getType();
        if (r93 != null) goto L297;
    L299:
        if (r8 == null) goto L305;
        RoomAuthStatus r100 = r8.getMRoomAuthStatus();
        if (r100 == null) goto L305;
        if (r100.getPoster() != 1) goto L305;
    L306:
        r35.setEnablePoster(r3);
        ShareParams r101 = r35.build();
        if (r101 == null) goto L316;
        IShareCallback r102 = r26.getContext();
        if ((r102 instanceof Activity) == true) goto L311;
        r102 = r122;
    L311:
        IShareCallback r103 = (Activity) r102;
        if (r103 == null) goto L314;
        IShareCallback r104 = r103;
    L315:
        jc1.k.n(ILiveShareService.class).share(new i81.a(null, r104, null, r101, null, null, null, null, null, null, null, r14, null, null, null, null, false), "ShareViewToPanelMethod", LiveShareType.SHARE_DIALOG, r122);
        goto L316
    L314:
        r104 = r122;
    L305:
        r3 = false;
        goto L306
    L297:
        if (r93.intValue() != r99) goto L299;
        r35.setShareSubScene(ShareSubScene.LivePaidTicket);
        goto L299
    L291:
        if (r93.intValue() != r98) goto L293;
        r35.setShareSubScene(ShareSubScene.ReceivePaidTicket);
        goto L299
    L285:
        if (r93.intValue() != r97) goto L287;
        r35.setShareSubScene(ShareSubScene.LivePaidPackage);
        goto L299
    L279:
        if (r93.intValue() != r96) goto L281;
        r35.setShareSubScene(ShareSubScene.LiveMatchChampionWho);
        goto L299
    L273:
        if (r93.intValue() != r95) goto L275;
        r35.setShareSubScene(ShareSubScene.LiveMatchPrediction);
        goto L299
    L267:
        if (r93.intValue() != r94) goto L269;
        r35.setShareSubScene(ShareSubScene.LiveTabMatchSituation);
        goto L299
    L262:
        r93 = r122;
        goto L263
    L258:
        r91 = ShareScene.LIVE;
        goto L259
    L254:
        if (CastIntegerProtector.parseInt(r89) != ShareType.ReceiveShareTicket.getType()) goto L256;
        r91 = ShareScene.H5;
    L250:
        r88 = false;
        goto L251
    L320:
        r81.setRelatedReviewContent(new JSONObject(r85).optString("related_review_content"));     // Catch: Exception -> L240
    L242:
        Unit r105 = Unit.INSTANCE;
    L240:
        e = move-exception;
        ALogger.e("ShareViewToPanelMethod", "unmodifiablePublishParams illegal", e);
        goto L242
    L235:
        r84 = 0;
    L217:
        if (r76 == null) goto L223;
        Episode r106 = r76.getEpisode();
        if (r106 == null) goto L223;
        EpisodeShare r107 = r106.share;
        if (r107 == null) goto L223;
        r79 = r107.shareUrl;
    L223:
        r79 = r122;
    L204:
        r122 = null;
        RoomContext r108 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r108 == null) goto L209;
        com.bytedance.live.datacontext.j r109 = r108.getVsMsgBoardDataContext();
        if (r109 == null) goto L209;
        r76 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r109.getValue();
    L209:
        r76 = null;
    L195:
        r75 = null;
    L227:
        r122 = null;
        r35.setUrl(r1.g());
    L316:
        finishWithSuccess();
        return;
    L318:
        Map r123 = (Map) new Gson().fromJson(Uri.decode(r1.j()), new qc().getType());     // Catch: Exception -> L171
        if (r123 == null) goto L168;
        r59.putAll(r123);     // Catch: Exception -> L171
        r115.putAll(r123);     // Catch: Exception -> L171
        r118.putAll(r123);     // Catch: Exception -> L171
        Unit r124 = Unit.INSTANCE;     // Catch: Exception -> L171
    L168:
        if (r35 == null) goto L172;
        r35.setExtraParams(r118);     // Catch: Exception -> L171
        goto L172
    L322:
        Map r125 = (Map) new Gson().fromJson(Uri.decode(r1.c()), new pc().getType());     // Catch: Exception -> L136
        if (r125 == null) goto L137;
        r115.putAll(r125);     // Catch: Exception -> L136
        Unit r126 = Unit.INSTANCE;     // Catch: Exception -> L136
        goto L137
    L112:
        r35 = null;
        goto L113
    L61:
        if (r24.intValue() != r113) goto L72;
        ue.a r127 = r1.b();
        if (r127 == null) goto L72;
        String r128 = r127.b();
        if (r128 == null) goto L68;
        if (r110 == null) goto L68;
        r110.setMatchTiming(r128);
    L68:
        String r129 = r127.a();
        if (r129 == null) goto L72;
        if (r110 == null) goto L72;
        r110.setMatchSchedule(r129);
        goto L72
    L56:
        r24 = null;
        goto L57
    L44:
        r110 = null;
        goto L45
    L34:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r16) != true) goto L36;
        r17 = ((LynxView) r12).findViewByIdSelector(r1.i());
        goto L38
    L28:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r13) != true) goto L30;
        r15 = ((LynxView) r12).findViewByIdSelector(r1.l());
        goto L31
    L37:
        r17 = null;
        r15 = null;
    L22:
        r12 = null;
    L16:
        r9 = null;
    L10:
        r8 = null;
        goto L11
    }
}
