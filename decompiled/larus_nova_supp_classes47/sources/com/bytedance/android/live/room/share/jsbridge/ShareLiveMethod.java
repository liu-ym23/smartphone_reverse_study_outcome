package com.bytedance.android.live.room.share.jsbridge;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.jsbridge.base.ShareLiveResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.screenrotation.api.IMiddlewareScreenRotateService;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.depend.share.IShareDialogListener;
import com.bytedance.android.livehostapi.business.depend.share.LiveAnnouncementShareConfig;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareScene;
import com.bytedance.android.livehostapi.business.depend.share.ShareSubScene;
import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.config.q3;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import j40.a1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.k6;
import w20.se;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ShareLiveMethod extends k6<se, ShareLiveResultModel> {
    public static final /* synthetic */ int i = 0;
    public Disposable a;
    public CallContext b;
    public Room c;
    public String d;
    public boolean e;
    public LiveAnnouncementShareConfig f;
    public HashMap<String, String> g;
    public final Lazy h;

    public static final class a {
    }

    public static final class b extends SimpleShareCallback {
        public final /* synthetic */ ShareLiveMethod a;

        public final void onChannelShare(String r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            this.a.l().onChannelShare(r2);
        }

        public final void onFail(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            this.a.l().onFail(r2);
            ALogger.e("ShareLiveMethod", r2);
        }

        public b(ShareLiveMethod r1, ShareParams.Builder r2) {
            this.a = r1;
        }

        public final void onSuccess(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "platform");
            Intrinsics.checkNotNullParameter(r3, "shareType");
            onSuccessWithExtra(r2, r3, null);
        }

        public final void onSuccessWithExtra(String r9, String r10, Map<String, ? extends List<String>> r12) {
            Intrinsics.checkNotNullParameter(r9, "platform");
            Intrinsics.checkNotNullParameter(r10, "shareType");
            this.a.l().onSuccessWithExtra(r9, r10, r12);
            if (com.bytedance.android.live.room.share.util.d.a(r9, r12) == false) goto L5;
            return;
        L5:
            ShareLiveMethod r1 = this.a;
            Room r2 = r1.c;
            List<String> r3 = null;
            if (r2 == null) goto L8;
            Long r4 = Long.valueOf(r2.getRoomId());
        L9:
            Room r6 = this.a.c;
            if (r6 != null) goto L12;
            String r7 = "";
        L15:
            ShareLiveMethod.k(r1, r4, r9, 1, r7);
            ShareLiveMethod r5 = this.a;
            if (r5.e == true) goto L18;
            ShareLiveMethod.j(r5, r5.c, r9, r10, r5.d);
            return;
        L18:
            if (r5.f == null) goto L47;
            HashMap r13 = new HashMap();
            HashMap<String, String> r8 = r5.g;
            if (r8 == null) goto L23;
            r13.putAll(r8);
        L23:
            r13.put("platform", r9);
            if (r12 == null) goto L33;
            List<String> r14 = r12.get("to_user_ids");
            if (r14 == null) goto L33;
            if ((!r14.isEmpty()) == true) goto L31;
            r14 = null;
        L31:
            if (r14 == null) goto L33;
            r13.put("to_user_id", r14.toString());
            r13.put("to_user_cnt", String.valueOf(r14.size()));
            r13.put("platform", "single_chat");
            j0.l().sendLog("livesdk_prelive_share_success", r13, new Object[0]);
        L33:
            if (r12 == null) goto L43;
            List<String> r15 = r12.get("conversation_ids");
            if (r15 != null) goto L37;
            return;
        L37:
            if ((true ^ r15.isEmpty()) == false) goto L39;
            r3 = r15;
        L39:
            if (r3 == null) goto L45;
            r13.remove("to_user_id");
            r13.remove("to_user_cnt");
            r13.put("chat_group_id", r3.toString());
            r13.put("platform", "group_chat");
            j0.l().sendLog("livesdk_prelive_share_success", r13, new Object[0]);
            return;
        L45:
            return;
        L43:
            return;
        L47:
            return;
        L12:
            if (r6 == null) goto L14;
            r7 = r6.getLabels();
            goto L15
        L14:
            r7 = null;
            goto L15
        L8:
            r4 = null;
            goto L9
        }
    }

    public static final class c implements IShareDialogListener {
        public final /* synthetic */ ShareLiveMethod a;

        public final void onShareDialogShow() {
        }

        public final void onShareDialogDismiss() {
            this.a.l().onDialogDismiss();
        }

        public c(ShareLiveMethod r1) {
            this.a = r1;
        }
    }

    public static final class d extends LiveWebShareCallback {
        public final /* synthetic */ ShareLiveMethod a;
        public final /* synthetic */ LiveWebShareParams b;

        public final void onRefresh() {
        }

        public final void onDialogDismiss() {
            this.a.l().onDialogDismiss();
        }

        public final void onPreShare() {
            UseReturnDataCallbackHandler r0 = this.a.l();
            r0.getClass();
            r0.a = UseReturnDataCallbackHandler.SelectType.IM_USER_ING;
        }

        public final void onChannelShare(String r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            this.a.l().onChannelShare(r2);
        }

        public final void onContactSelect(boolean r2) {
            this.a.l().onContactSelect(r2);
        }

        public final void onFail(Throwable r2) {
            this.a.l().onFail(r2);
            ALogger.e("ShareLiveMethod", r2);
        }

        public d(ShareLiveMethod r1, LiveWebShareParams r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onSuccess(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, "platform");
            Intrinsics.checkNotNullParameter(r8, "shareType");
            this.a.l().onSuccess(r7, r8);
            if ((!Intrinsics.areEqual(r7, "chat_merge")) == false) goto L19;
            ShareLiveMethod r0 = this.a;
            String r3 = null;
            if (this.b.isLiveShare() == false) goto L10;
            Room r2 = this.a.c;
            if (r2 == null) goto L9;
            long r4 = r2.getRoomId();
        L11:
            Long r5 = Long.valueOf(r4);
        L12:
            Room r6 = this.a.c;
            if (r6 != null) goto L15;
            r3 = "";
        L17:
            ShareLiveMethod.k(r0, r5, r7, 1, r3);
            ShareLiveMethod r1 = this.a;
            ShareLiveMethod.j(r1, r1.c, r7, r8, r1.d);
            return;
        L15:
            if (r6 == null) goto L17;
            r3 = r6.getLabels();
            goto L17
        L9:
            r5 = null;
            goto L12
        L10:
            r4 = 0;
            goto L11
        }

        public final void onSuccessWithExtra(String r5, String r6, Map<String, ? extends List<String>> r7) {
            Intrinsics.checkNotNullParameter(r5, "platform");
            Intrinsics.checkNotNullParameter(r6, "shareType");
            this.a.l().onSuccessWithExtra(r5, r6, r7);
            if (com.bytedance.android.live.room.share.util.d.a(r5, r7) == false) goto L5;
            return;
        L5:
            ShareLiveMethod r8 = this.a;
            String r1 = null;
            if (this.b.isLiveShare() == false) goto L11;
            Room r0 = this.a.c;
            if (r0 == null) goto L10;
            long r2 = r0.getRoomId();
        L12:
            Long r3 = Long.valueOf(r2);
        L13:
            Room r4 = this.a.c;
            if (r4 != null) goto L16;
            r1 = "";
        L18:
            ShareLiveMethod.k(r8, r3, r5, 1, r1);
            ShareLiveMethod r9 = this.a;
            ShareLiveMethod.j(r9, r9.c, r5, r6, r9.d);
            return;
        L16:
            if (r4 == null) goto L18;
            r1 = r4.getLabels();
            goto L18
        L10:
            r3 = null;
            goto L13
        L11:
            r2 = 0;
            goto L12
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ShareLiveMethod a;
        public final /* synthetic */ LiveWebShareParams b;
        public final /* synthetic */ ShareParams.Builder c;

        public e(ShareLiveMethod r1, LiveWebShareParams r2, ShareParams.Builder r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            IBaseUser r4 = (IBaseUser) r3;
            this.a.m(this.b.getNeedPoster(), this.c);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ShareLiveMethod a;
        public final /* synthetic */ LiveWebShareParams b;
        public final /* synthetic */ ShareParams.Builder c;

        public f(ShareLiveMethod r1, LiveWebShareParams r2, ShareParams.Builder r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            IBaseUser r4 = (IBaseUser) r3;
            this.a.m(this.b.getNeedPoster(), this.c);
        }
    }

    static {
    }

    public final UseReturnDataCallbackHandler l() {
        return (UseReturnDataCallbackHandler) this.h.getValue();
    }

    public final void onTerminate() {
        Disposable r0 = this.a;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.dispose();
        return;
    L8:
        return;
    }

    public ShareLiveMethod() {
        this.b = getCallContext();
        this.d = "";
        this.h = LazyKt.lazy(new ShareLiveMethod$useReturnDataCallbackHandler$2(this));
    }

    public final void invoke(Object r32, CallContext r33) {
        se r2 = (se) r32;
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r33, "context");
        this.b = r33;
        LiveWebShareParams r4 = (LiveWebShareParams) JsonUtil.parse(String.valueOf(r2.a()), LiveWebShareParams.class);
        Integer r7 = null;
        if (r4 != null) goto L5;
    L11:
        if (r4 == null) goto L13;
        boolean r3 = r4.isPreLive();
    L14:
        this.e = r3;
        if (r4 == null) goto L17;
        r4.setUseReturnData(true);
    L17:
        if (r4 == null) goto L19;
        r4.setHybridView(r33.d);
    L19:
        Room r0 = o3.f().getCurrentRoom();
        if ((r0 instanceof Room) == true) goto L22;
        r0 = null;
    L22:
        this.c = r0;
        ShareParams.Builder r5 = ShareParams.builder();
        if (r4 == null) goto L32;
        String r1 = r4.getUrlExtra();
        if (r1 == null) goto L32;
        if (r2.a(r1) == true) goto L30;
        r1 = null;
    L30:
        if (r1 == null) goto L32;
        Map r6 = JsonUtil.jsonObjectToMap(new JSONObject(r1));
    L33:
        long r8 = 0;
        if (r4 != null) goto L36;
    L76:
        if (r4 != null) goto L78;
    L101:
        this.d = "URL";
        if (r4 == null) goto L104;
        String r9 = r4.getUrl();
    L105:
        Uri.Builder r10 = UriProtector.parse(String.valueOf(r9)).buildUpon();
        if (r4 == null) goto L108;
        String r12 = r4.getUrl();
    L109:
        p(r10, r12, r6);
        ShareParams.Builder r13 = ShareParams.builder();
        if (r4 == null) goto L112;
        String r14 = r4.getTitle();
    L113:
        ShareParams.Builder r15 = r13.setTitle(String.valueOf(r14));
        if (r4 == null) goto L116;
        String r16 = r4.getDesc();
    L117:
        ShareParams.Builder r17 = r15.setDescription(String.valueOf(r16));
        if (r4 == null) goto L120;
        String r18 = r4.getImage();
    L121:
        ShareParams.Builder r19 = r17.setImageUrl(String.valueOf(r18));
        if (r10 == null) goto L124;
        String r20 = r10.toString();
    L125:
        ShareParams.Builder r22 = r19.setUrl(r20);
        if (r4 != null) goto L128;
    L130:
        boolean r23 = false;
    L131:
        ShareParams.Builder r24 = r22.setIsHalfScreen(r23);
        if (r4 != null) goto L134;
    L136:
        boolean r25 = false;
    L137:
        r5 = r24.setHideDim(r25);
    L138:
        a1 r26 = a1.a;
        if (((d51) r26.getValue()).p() == false) goto L141;
    L144:
        boolean r27 = true;
    L145:
        if (r27 == false) goto L147;
        r5.setEnableLandscapeOpt(true);
    L147:
        Room r28 = this.c;
        if (r28 != null) goto L150;
    L152:
        if (r27 == false) goto L159;
        Context r29 = this.b.getContext();
        if ((r29 instanceof Activity) == true) goto L157;
        r29 = null;
    L157:
        if (e5.g((Activity) r29) == false) goto L159;
        r5.setEnableMatchRoomDialogAnim(true);
    L159:
        if (r4 == null) goto L161;
        r7 = r4.getLiveShareType();
    L161:
        int r30 = ShareLiveMethodType.SHARE_DIALOG.getValue();
        if (r7 != null) goto L165;
    L167:
        int r34 = ShareLiveMethodType.CHAT_DIALOG.getValue();
        if (r7 != null) goto L171;
    L183:
        int r35 = ShareLiveMethodType.THIRD_DIALOG.getValue();
        if (r7 != null) goto L187;
    L202:
        if (r4 == null) goto L213;
        o(r4, r5);
        return;
    L213:
        return;
    L187:
        if (r7.intValue() != r35) goto L202;
        if (TextUtils.isEmpty(r4.getPlatform()) == false) goto L191;
        l().onFail(new Throwable("platform is null"));
        return;
    L191:
        ILiveMiddlewareShareService r36 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        ShareParams.Builder r37 = r5.setPlatform(r4.getPlatform()).setIsHalfScreen(r4.isHalfScreen());
        if (r4.getRoomId() != 0) goto L196;
        Room r38 = this.c;
        if (r38 == null) goto L197;
        r8 = r38.getRoomId();
    L197:
        ShareParams r110 = r37.setRoomIdWithChain(r8).build();
        Context r39 = this.b.getContext();
        if (r39 == null) goto L201;
        r36.share(new i81.a(null, (Activity) r39, null, r110, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ShareLiveMethod", LiveShareType.SHARE_DIRECT, new h(this, r4));
        return;
    L201:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L196:
        r8 = r4.getRoomId();
        goto L197
    L171:
        if (r7.intValue() != r34) goto L183;
        ILiveMiddlewareShareService r40 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        ShareParams.Builder r42 = r5.setPlatform("chat_merge").setIsHalfScreen(r4.isHalfScreen());
        if (r4.getRoomId() != 0) goto L177;
        Room r43 = this.c;
        if (r43 == null) goto L178;
        r8 = r43.getRoomId();
    L178:
        ShareParams r111 = r42.setRoomIdWithChain(r8).build();
        Context r44 = this.b.getContext();
        if (r44 == null) goto L182;
        r40.share(new i81.a(null, (Activity) r44, null, r111, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ShareLiveMethod", LiveShareType.SHARE_DIRECT, new g(this, r4));
        return;
    L182:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L177:
        r8 = r4.getRoomId();
        goto L178
    L165:
        if (r7.intValue() != r30) goto L167;
        o(r4, r5);
        return;
    L150:
        if (r28.isReplay != true) goto L152;
        r5.setEnableLandscapePlayerOpt(true);
        goto L152
    L141:
        if (((d51) r26.getValue()).o() == true) goto L144;
        r27 = false;
        goto L145
    L134:
        if (r4.getHideDim() != true) goto L136;
        r25 = true;
        goto L137
    L128:
        if (r4.isHalfScreen() != true) goto L130;
        r23 = true;
        goto L131
    L124:
        r20 = null;
        goto L125
    L120:
        r18 = null;
        goto L121
    L116:
        r16 = null;
        goto L117
    L112:
        r14 = null;
        goto L113
    L108:
        r12 = null;
        goto L109
    L104:
        r9 = null;
        goto L105
    L78:
        if (r4.isLiveShare() != true) goto L101;
        this.d = "live";
        HashMap r45 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r46 = j0.l().c(x.class);
        if (r46 == null) goto L82;
        r45.putAll(r46.getMap());
    L82:
        com.bytedance.android.livesdk.log.filter.o r112 = j0.l().c(Room.class);
        if (r46 == null) goto L85;
        r45.putAll(r112.getMap());
    L85:
        Room r47 = this.c;
        if (r47 == null) goto L88;
        String r48 = r47.getShareUrl();
    L89:
        Uri.Builder r49 = UriProtector.parse(String.valueOf(r48)).buildUpon();
        Room r113 = this.c;
        if (r113 == null) goto L92;
        String r114 = r113.getShareUrl();
    L93:
        p(r49, r114, r6);
        Room r50 = this.c;
        if (r50 != null) goto L96;
        l().onFail(new Throwable("room is null"));
        return;
    L96:
        ShareParams.Builder r52 = ShareParams.buildUponRoom(r50).setLogV3Params(r45);
        if (r49 == null) goto L99;
        String r53 = r49.toString();
    L100:
        r5 = r52.setUrl(r53);
        goto L138
    L99:
        r53 = null;
        goto L100
    L92:
        r114 = null;
        goto L93
    L88:
        r48 = null;
        goto L89
    L36:
        if (r4.isPreLive() != true) goto L76;
        HashMap r54 = r4.getShareExtraParams();
        if (r54 == null) goto L42;
        Object r55 = r54.get("announcement");
        if (r55 == null) goto L42;
        String r115 = r55.toString();
    L43:
        HashMap r56 = r4.getShareExtraParams();
        if (r56 == null) goto L51;
        Object r57 = r56.get("im_info");
        if (r57 == null) goto L51;
        String r58 = r57.toString();
        if (r58 == null) goto L51;
        String r116 = r58;
    L52:
        this.g = r4.getTrackParams();
        ALogger.d("announce_im_info", r116);
        if (r115 != null) goto L55;
    L72:
        ShareParams.Builder r59 = null;
    L73:
        if (r59 == null) goto L75;
        r5 = r59;
        goto L138
    L75:
        finishWithFailure();
        goto L138
    L55:
        if ((!StringsKt.isBlank(r115)) == false) goto L57;
        String r60 = r115;
    L58:
        if (r60 == null) goto L72;
        LiveAnnouncementShareConfig r62 = (LiveAnnouncementShareConfig) JsonUtil.parseObject(r60, LiveAnnouncementShareConfig.class);     // Catch: JsonParseException -> L61
    L63:
        if (r62 == null) goto L72;
        this.f = r62;
        ImageModel r117 = new ImageModel("", CollectionsKt.listOf(r62.getAvatarUrl()));
        User r63 = new User();
        r63.setIdStr(r62.anchorIdStr());
        r63.setIdString(String.valueOf(r62.getAnchorId()));
        r63.setAvatarThumbKt(r117);
        r63._avatarMedium = r117;
        r63._avatarLarge = r117;
        ShareParams.Builder r64 = ShareParams.buildUponUser(r63).setShareSubScene(ShareSubScene.LiveAnnouncement);
        HashMap r65 = new HashMap();
        r65.put("announcement", r115);
        r65.put("bitmap_compress_format", String.valueOf(Bitmap.CompressFormat.PNG.ordinal()));
        if ((!StringsKt.isBlank(r116)) == false) goto L67;
        r65.put("im_info", r116);
    L67:
        Unit r118 = Unit.INSTANCE;
        r59 = r64.setExtraParams(r65).setLogExtraParams(this.g);
        if (r59 == null) goto L70;
        r59.setShareScene(ShareScene.PRE_LIVE);
    L70:
        if (r59 == null) goto L73;
        r59.setRoomId(0);
    L61:
        e = move-exception;
        finishWithFailure(e);
        r62 = null;
        goto L63
    L57:
        r60 = null;
    L51:
        r116 = "";
    L42:
        r115 = null;
    L32:
        r6 = null;
        goto L33
    L13:
        r3 = false;
        goto L14
    L5:
        if (r4.getUgShare() != true) goto L11;
        Context r119 = r33.getContext();
        ILiveMiddlewareShareService r66 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        Intrinsics.checkNotNullParameter(r119, "context");
        com.bytedance.android.live.room.share.jsbridge.e r67 = new com.bytedance.android.live.room.share.jsbridge.e(this);
        JsonObject r68 = r2.a();
        if (r68 == null) goto L9;
        JSONObject r210 = tv5.a.c(r68);
    L10:
        r66.share(new i81.a(r119, null, null, null, null, null, null, null, null, null, null, Boolean.FALSE, null, r210, r67, null, false), "ShareLiveMethod", LiveShareType.SHARE_JSB, null);
        return;
    L9:
        r210 = new JSONObject(String.valueOf(r2.a()));
        goto L10
    }

    public final void m(boolean r25, ShareParams.Builder r26) {
        Room r2 = this.c;
        Context r3 = null;
        if (r2 == null) goto L5;
        LiveMode r4 = r2.getStreamType();
    L7:
        if (r4 != LiveMode.MEDIA) goto L9;
        Boolean r5 = (Boolean) q3.a.getValue();
    L10:
        ShareParams.Builder r6 = r26.setEnablePromotion(r5.booleanValue()).setShareDialogListener(new c(this));
        Room r7 = this.c;
        if (r7 == null) goto L15;
        ALogger.d("ShareLiveMethod", "room not null,start build upon visibility param");
        MiddlewareRoomContext.a r8 = MiddlewareRoomContext.Companion;
        long r9 = Long.valueOf(r7.getRoomId()).longValue();
        r8.getClass();
        MiddlewareRoomContext r10 = MiddlewareRoomContext.a.a(null, r9);
        if (r10 == null) goto L15;
        o0.a(r10, r6);
    L15:
        ILiveMiddlewareShareService r12 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        ShareParams r13 = r6.build();
        Context r14 = this.b.getContext();
        if ((r14 instanceof Activity) == false) goto L19;
        r3 = r14;
    L19:
        r12.share(new i81.a(null, (Activity) r3, null, r13, null, null, null, null, null, null, null, Boolean.valueOf(r25), null, null, null, null, false), "ShareLiveMethod", LiveShareType.SHARE_DIALOG, new b(this, r26));
        return;
    L9:
        r5 = Boolean.TRUE;
        goto L10
    L5:
        r4 = null;
        goto L7
    }

    public final void n(LiveWebShareParams r23, ShareParams.Builder r24) {
        ILiveMiddlewareShareService r2 = (ILiveMiddlewareShareService) jc1.k.n(ILiveMiddlewareShareService.class);
        LiveMode r3 = null;
        if (r23 == null) goto L5;
        String r5 = r23.getTitle();
    L6:
        ShareParams.Builder r6 = r24.setTitle(String.valueOf(r5));
        if (r23 == null) goto L9;
        String r7 = r23.getDesc();
    L10:
        ShareParams.Builder r8 = r6.setDescription(String.valueOf(r7));
        if (r23 == null) goto L13;
        String r9 = r23.getImage();
    L14:
        ShareParams.Builder r10 = r8.setImageUrl(String.valueOf(r9));
        Room r12 = this.c;
        if (r12 == null) goto L18;
        r3 = r12.getStreamType();
    L18:
        if (r3 != LiveMode.MEDIA) goto L20;
        Boolean r4 = (Boolean) q3.a.getValue();
    L21:
        ShareParams.Builder r13 = r10.setEnablePromotion(r4.booleanValue()).setRoomIdWithChain(r23.getRoomId());
        r23.setTitle(String.valueOf(r23.getTitle()));
        r23.setDesc(String.valueOf(r23.getDesc()));
        r23.setImage(String.valueOf(r23.getImage()));
        Unit r14 = Unit.INSTANCE;
        ShareParams r15 = r13.setLiveWebShareParams(r23).build();
        Context r16 = this.b.getContext();
        if (r16 == null) goto L26;
        r2.share(new i81.a(null, (Activity) r16, null, r15, null, null, null, null, null, null, null, Boolean.valueOf(r23.getNeedPoster()), null, null, null, null, false), "ShareLiveMethod", LiveShareType.SHARE_DIALOG, new d(this, r23));
        return;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L20:
        r4 = Boolean.TRUE;
        goto L21
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void o(LiveWebShareParams r5, ShareParams.Builder r6) {
        if (r5.isPreLive() == false) goto L12;
        if (r5.getNeedLogin() == true) goto L7;
    L9:
        m(r5.getNeedPoster(), r6);
        return;
    L7:
        if (jc1.k.n(IMiddlewareUserService.class).user().isLogin() == true) goto L9;
        jc1.k.n(IMiddlewareUserService.class).user().login(this.b.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).subscribe(new e(this, r5, r6));
        return;
    L12:
        if (r5.isLiveShare() == true) goto L25;
        if (TextUtils.isEmpty(r5.getUrl()) == true) goto L25;
        IMiddlewareScreenRotateService r0 = (IMiddlewareScreenRotateService) jc1.k.f(IMiddlewareScreenRotateService.class);
        if (r0 == null) goto L23;
        Context r1 = this.b.getContext();
        if ((r1 instanceof Activity) == true) goto L21;
        r1 = null;
    L21:
        if (e5.g((Activity) r1) == false) goto L23;
        r0.rotation().b(com.bytedance.android.live.room.api.screenrotation.rotate.f.b.a, new ShareLiveMethod$shareDialog$2(this, r5, r6));
        return;
    L23:
        n(r5, r6);
        return;
    L25:
        if (this.c != null) goto L27;
        finishWithFailure();
        return;
    L27:
        if (r5.getNeedLogin() == true) goto L29;
    L31:
        m(r5.getNeedPoster(), r6);
        return;
    L29:
        if (jc1.k.n(IMiddlewareUserService.class).user().isLogin() == true) goto L31;
        jc1.k.n(IMiddlewareUserService.class).user().login(this.b.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).subscribe(new f(this, r5, r6));
    }

    public static void p(Uri.Builder r2, String r3, Map r4) {
        if (r2 == null) goto L10;
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L8;
        String r5 = r1.n();
    L9:
        r2.appendQueryParameter("share_ht_uid", r5);
    L8:
        r5 = null;
    L10:
        if (r3 == null) goto L18;
        if (r4 == null) goto L24;
        Iterator r6 = r4.entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L25;
        Map.Entry r7 = (Map.Entry) r6.next();
        if (r2 == null) goto L14;
        r2.appendQueryParameter((String) r7.getKey(), (String) r7.getValue());
        goto L14
    L25:
        return;
    L24:
        return;
    }

    public static final void j(ShareLiveMethod r1, Room r2, String r3, String r4, String r5) {
        r1.getClass();
        HashMap r6 = new HashMap();
        r6.put("share_platform", r3);
        r6.put("is_pyramid_sale", DataType.FALSE);
        r6.put("share_type", r4);
        if (r2 == null) goto L5;
        r6.put("log_pb", r2.getLog_pb());
    L5:
        r6.put("share_content", r5);
        j0 r7 = j0.l();
        x r8 = new x();
        r8.f = "click";
        r8.b = "H5";
        r7.sendLog("share", r6, new Object[]{r8, Room.class});
    }

    public static final void k(ShareLiveMethod r7, Long r8, String r9, Integer r10, String r12) {
        r7.getClass();
        int r4 = com.bytedance.android.live.room.share.util.d.b(r9);
        IService r13 = jc1.k.f(IMiddlewareRoomService.class);
        Intrinsics.checkNotNull(r13);
        com.bytedance.android.livesdk.module.d r14 = ((IMiddlewareRoomService) r13).roomInteractService();
        com.bytedance.android.live.room.share.jsbridge.f r1 = com.bytedance.android.live.room.share.jsbridge.f.a;
        Intrinsics.checkNotNull(r8);
        long r2 = r8.longValue();
        Intrinsics.checkNotNull(r10);
        com.bytedance.android.livesdk.module.d r0 = r14;
        r7.a = r0.a(r1, r2, r4, r10.intValue(), r12);
    }
}
