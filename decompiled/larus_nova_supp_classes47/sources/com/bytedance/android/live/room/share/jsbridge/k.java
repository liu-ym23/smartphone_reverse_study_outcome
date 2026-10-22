package com.bytedance.android.live.room.share.jsbridge;

import am2.x;
import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.share.ILiveMiddlewareShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareParams;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.q3;
import com.bytedance.android.livesdk.config.vh1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@XBridgeMethod(biz = "webcast", name = "sharePanel")
public final class k extends com.bytedance.ies.web.jsbridge2.f<LiveWebShareParams, Object> {
    public y6.d a;
    public Disposable b;
    public CallContext c;
    public Map<String, String> d;
    public final a e;

    public class a extends com.bytedance.android.livesdk.user.h<IBaseUser> {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        public final void onNext(Object r2) {
            IBaseUser r3 = (IBaseUser) r2;
            k r4 = this.a;
            r4.m(r4.d);
        }
    }

    public class b extends SimpleShareCallback {
        public final /* synthetic */ Room a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ k c;

        public final void onFail(Throwable r2) {
            ALogger.e("SharePanelMethod", r2);
        }

        public final void onSuccess(String r12, String r13) {
            k.j(this.c, this.a.getId(), r12, this.a.getLabels());
            k.k(this.c, this.a, r12, r13, "live", null);
            k.l(this.c, r12, r13, this.b);
        }

        public b(k r1, Room r2, Map r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class c implements IShareCallback {
        public final /* synthetic */ Room a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ k c;

        public final boolean interceptReportAction(IShareParams r1) {
            return false;
        }

        public final /* synthetic */ void onShareUiDismiss() {
            IShareCallback.-CC.$default$onShareUiDismiss(this);
        }

        public final /* synthetic */ void onShareUiShow() {
            IShareCallback.-CC.$default$onShareUiShow(this);
        }

        public final void onFail(Throwable r2) {
            ALogger.e("SharePanelMethod", r2);
        }

        public final void onSuccess(String r12, String r13) {
            k.j(this.c, this.a.getId(), r12, this.a.getLabels());
            k.k(this.c, this.a, r12, r13, "live", null);
            k.l(this.c, r12, r13, this.b);
        }

        public c(k r1, Room r2, Map r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public final void onTerminate() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a = null;
    }

    public k(y6.d r2) {
        this.e = new a(this);
        this.a = r2;
    }

    public final void m(Map<String, String> r7) {
        if (r7 != null) goto L5;
        r7 = new HashMap();
    L5:
        Room r0 = o3.f().getCurrentRoom();
        com.bytedance.android.livesdk.log.filter.o r1 = j0.l().c(x.class);
        if (r1 == null) goto L8;
        r7.putAll(r1.getMap());
    L8:
        com.bytedance.android.livesdk.log.filter.o r2 = j0.l().c(Room.class);
        if (r1 == null) goto L11;
        r7.putAll(r2.getMap());
    L11:
        ShareParams.Builder r3 = ShareParams.buildUponRoom(r0).setLogV3Params(r7);
        if (r0 != null) goto L14;
    L16:
        boolean r4 = true;
    L17:
        ShareParams.Builder r5 = r3.setEnablePromotion(r4);
        if (r0 == null) goto L22;
        ALogger.d("SharePanelMethod", "room not null,start build upon visibility param");
        MiddlewareRoomContext.a r6 = MiddlewareRoomContext.Companion;
        long r8 = r0.getRoomId();
        r6.getClass();
        MiddlewareRoomContext r9 = MiddlewareRoomContext.a.a(null, r8);
        if (r9 == null) goto L22;
        o0.a(r9, r5);
    L22:
        i81.a.C0251a r10 = new i81.a.C0251a();
        IShareCallback r12 = new b(this, r0, r7);
        if (((Boolean) vh1.a.getValue()).booleanValue() == false) goto L25;
        r12 = new c(this, r0, r7);
    L25:
        ILiveMiddlewareShareService r13 = (ILiveMiddlewareShareService) jc1.k.f(ILiveMiddlewareShareService.class);
        r10.d = r5.build();
        r10.b = (Activity) this.c.getContext();
        r13.share(r10.a(), "SharePanelMethod", LiveShareType.SHARE_DIALOG, r12);
        finishWithSuccess();
        return;
    L14:
        if (r0.getStreamType() != LiveMode.MEDIA) goto L16;
        r4 = ((Boolean) q3.a.getValue()).booleanValue();
        goto L17
    }

    public final void invoke(Object r12, CallContext r13) throws Exception {
        LiveWebShareParams r14 = (LiveWebShareParams) r12;
        l r0 = new l(this);
        int r1 = UseReturnDataCallbackHandler.c;
        Intrinsics.checkNotNullParameter(r14, "params");
        Intrinsics.checkNotNullParameter(r0, "action");
        if (r14.getUseReturnData() == false) goto L5;
        LiveWebShareCallback r2 = new UseReturnDataCallbackHandler(r0);
    L6:
        this.c = r13;
        Room r3 = o3.f().getCurrentRoom();
        HashMap r5 = new HashMap();
        com.bytedance.android.livesdk.log.filter.o r4 = j0.l().c(x.class);
        if (r4 == null) goto L9;
        r5.putAll(r4.getMap());
    L9:
        com.bytedance.android.livesdk.log.filter.o r6 = j0.l().c(Room.class);
        if (r4 == null) goto L13;
        r5.putAll(r6.getMap());
    L13:
        if (r14.getLogParams() == null) goto L15;
        r5.putAll(r14.getLogParams());
    L15:
        HashMap r7 = new HashMap();
        IMiddlewareUserService r8 = jc1.k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L22;
        com.bytedance.android.livesdk.user.e r9 = r8.user();
        if (r9 == null) goto L22;
        String r10 = r9.n();
        if (TextUtils.isEmpty(r10) == true) goto L22;
        r7.put("from_user_id", r10);
    L22:
        String r15 = (String) r5.get("content_type");
        if (TextUtils.isEmpty(r15) == true) goto L26;
        r7.put("content_type", r15);
    L26:
        if (TextUtils.isEmpty(r14.getUrl()) == true) goto L43;
        this.a.w1();
        String r16 = r14.getTitle();
        String r17 = r14.getDesc();
        String r18 = r14.getImage();
        String r19 = r14.getUrl();
        Intrinsics.checkNotNullParameter(r16, "title");
        Intrinsics.checkNotNullParameter(r17, "desc");
        Intrinsics.checkNotNullParameter(r18, "image");
        Intrinsics.checkNotNullParameter(r19, "url");
        if (TextUtils.isEmpty(r19) == true) goto L58;
        Uri.Builder r20 = UriProtector.parse(r19).buildUpon();
        r20.appendQueryParameter("share_ht_uid", jc1.k.f(IMiddlewareUserService.class).user().n());
        ShareParams.Builder r22 = ShareParams.builder().setTitle(r16).setDescription(r17).setImageUrl(r18).setUrl(r20.toString()).setLogV3Params(r5).setLogExtraParams(r5).setExtraParams(r7);
        if (r3 != null) goto L33;
    L35:
        boolean r23 = true;
    L36:
        ShareParams.Builder r24 = r22.setEnablePromotion(r23).setRoomIdWithChain(r14.getRoomId());
        if (TextUtils.isEmpty(r14.getPlatform()) == true) goto L39;
        LiveWebShareParams r25 = r14;
    L40:
        ShareParams.Builder r26 = r24.setLiveWebShareParams(r25);
        r26.getExtras().putString("key_share_from_method_tag", "SharePanelMethod");
        i81.a.C0251a r27 = new i81.a.C0251a();
        ILiveMiddlewareShareService r28 = (ILiveMiddlewareShareService) jc1.k.f(ILiveMiddlewareShareService.class);
        r27.d = r26.build();
        r27.b = (Activity) r13.getContext();
        r28.share(r27.a(), "SharePanelMethod", LiveShareType.SHARE_DIALOG, new m(this, r2, r3, r14, r5));
        if (r14.getUseReturnData() == true) goto L53;
        finishWithSuccess();
        return;
    L53:
        return;
    L39:
        r25 = null;
        goto L40
    L33:
        if (r3.getStreamType() != LiveMode.MEDIA) goto L35;
        r23 = ((Boolean) q3.a.getValue()).booleanValue();
        goto L36
    L58:
        return;
    L43:
        if (r3 != null) goto L45;
        finishWithFailure();
        return;
    L45:
        if (r14.getNeedLogin() == true) goto L47;
        m(r5);
        return;
    L47:
        if (jc1.k.f(IMiddlewareUserService.class).user().isLogin() == true) goto L49;
        this.d = r5;
        jc1.k.f(IMiddlewareUserService.class).user().login(r13.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).subscribe(this.e);
        return;
    L49:
        m(r5);
        return;
    L5:
        r2 = new LiveWebShareCallback();
        goto L6
    }

    public static void j(k r7, long r8, String r10, String r12) {
        r7.getClass();
        int r4 = com.bytedance.android.live.room.share.util.d.b(r10);
        com.bytedance.android.livesdk.module.d r13 = ((IMiddlewareRoomService) jc1.k.f(IMiddlewareRoomService.class)).roomInteractService();
        com.bytedance.android.livesdk.module.d r0 = r13;
        r7.b = r0.a(new j(), r8, r4, 1, r12);
    }

    public static void l(k r0, String r1, String r2, Map r3) {
        r0.getClass();
        HashMap r4 = new HashMap();
        if (r3 == null) goto L5;
        r4.putAll(r3);
    L5:
        r4.put("share_type", r2);
        r4.put("platform", r1);
        j0.l().sendLog("share_all_theme", r4, new Object[0]);
    }

    public static void k(k r1, Room r2, String r3, String r4, String r5, LiveWebShareParams r6) {
        r1.getClass();
        HashMap r7 = new HashMap();
        r7.put("share_platform", r3);
        r7.put("is_pyramid_sale", DataType.FALSE);
        r7.put("share_type", r4);
        if (r2 == null) goto L5;
        r7.put("log_pb", r2.getLog_pb());
    L5:
        r7.put("share_content", r5);
        if (r6 == null) goto L21;
        String r8 = r6.getCustomParams();
        HashMap r9 = new HashMap();
        if (TextUtils.isEmpty(r8) == true) goto L20;
        if (r2 != null) goto L24;
    L11:
        JSONObject r10 = new JSONObject(r8).optJSONObject("local_life_params");     // Catch: Exception -> L23
        if (r10 == null) goto L20;
        String r12 = r10.optString("share_info");     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r12) == true) goto L20;
        Map<String, String> r13 = ((ILiveMiddlewareShareService) jc1.k.f(ILiveMiddlewareShareService.class)).getLocalLifeShareParams(r12);     // Catch: Exception -> L23
        if (r13.isEmpty() == true) goto L20;
        r9.putAll(r13);     // Catch: Exception -> L23
        goto L20
    L24:
        r9.put("life_share_id", r2.lifeShareId);     // Catch: Exception -> L23
    L20:
        r7.putAll(r9);
    L21:
        j0 r14 = j0.l();
        x r15 = new x();
        r15.f = "click";
        r15.b = "H5";
        r14.sendLog("share", r7, new Object[]{r15, Room.class});
    }
}
