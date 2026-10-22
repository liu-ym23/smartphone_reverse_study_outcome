package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.commerce.DouPlusEntry;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.share.ShareListApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.IReportService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.live.room.api.userinfo.event.ReportConstant;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallbackWithExtra;
import com.bytedance.android.livehostapi.business.depend.share.IShareDialogListener;
import com.bytedance.android.livehostapi.business.depend.share.IShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.model.ShopGuideApi;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.config.h21;
import com.bytedance.android.livesdk.config.jv;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.config.oc;
import com.bytedance.android.livesdk.config.vc;
import com.bytedance.android.livesdk.config.vr0;
import com.bytedance.android.livesdk.config.wc;
import com.bytedance.android.livesdk.config.xl;
import com.bytedance.android.livesdk.config.y9;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.pluggableinterface.IShareGuideService;
import com.bytedance.android.livesdk.vipim.VipIMManager;
import com.bytedance.android.livesdk.vipim.VipIMWidget;
import com.bytedance.android.livesdk.widget.VSShareReverseView;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomGameData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomGameDataChannelConfig;
import com.bytedance.android.livesdkapi.depend.model.live.ToolbarComponentData;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class e5 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public boolean A;
    public String B;
    public long C;
    public Room a;
    public final Context b;
    public final FragmentActivity c;
    public User d;
    public final com.bytedance.android.livesdk.user.f e;
    public RoomContext f;
    public Boolean g;
    public View h;
    public DataCenter i;
    public Dialog j;
    public Disposable k;
    public yo2.e l;
    public boolean m;
    public String n;
    public String o;
    public VipIMWidget p;
    public w5 q;
    public final CompositeDisposable r;
    public SharedPrefHelper s;
    public boolean t;
    public View u;
    public boolean v;
    public VSShareReverseView w;
    public boolean x;
    public final b y;
    public final c z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LiveMode.values().length];
            a = r0;
            r0[LiveMode.AUDIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[LiveMode.THIRD_PARTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class b implements Observer<KVData> {
        public final /* synthetic */ e5 a;

        public b(e5 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            KVData r11 = (KVData) r10;
            if (this.a.h == null) goto L20;
            if (r11 != null) goto L6;
            return;
        L6:
            if ((r11.getData() instanceof com.bytedance.android.livesdk.message.model.r4) == false) goto L22;
            final e5 r0 = this.a;
            final View r2 = r0.h;
            com.bytedance.android.livesdk.message.model.r4 r12 = (com.bytedance.android.livesdk.message.model.r4) r11.getData();
            DataCenter r1 = r0.i;
            Boolean r3 = Boolean.FALSE;
            if (((Boolean) r1.get("data_is_anchor", r3)).booleanValue() == false) goto L10;
            return;
        L10:
            if (((Boolean) r0.i.get("data_is_portrait", r3)).booleanValue() == false) goto L24;
            Context r4 = r0.b;
            if (r4 == null) goto L25;
            yo2.e r5 = r0.l;
            if (r5 == null) goto L18;
            r5.d();
        L18:
            final String r13 = r12.getContent();
            yo2.e r7 = new yo2.e(r4);
            ((yo2.d) r7).d = null;
            ((yo2.d) r7).e = 2131567687;
            ((yo2.d) r7).m = 3;
            ((yo2.d) r7).n = true;
            ((yo2.d) r7).l = true;
            r7.x = new c5(r0, r13, r2);
            r7.a();
            r7.i(r2, 1, 0, 0, 0);
            r0.l = r7;
            com.bytedance.android.livesdk.log.u.l().d("livesdk_fraternity_guide_popup_show", new Object[]{Room.class, am2.x.class});
            return;
        L25:
            return;
        L24:
            return;
        L22:
            return;
        }
    }

    public class c implements Observer<KVData> {
        public final /* synthetic */ e5 a;

        public c(e5 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            this.a.i();
            this.a.j = null;
            k00.e.e.getClass();
            Map r5 = k00.e.c;
            if (r5 == null) goto L5;
            ((LinkedHashMap) r5).clear();
        L5:
            com.bytedance.android.livesdk.share.h r6 = jc1.k.n(IMiddlewareRoomService.class).share();
            if (r6 == null) goto L10;
            ArrayList r0 = new ArrayList();
            r0.add(1);
            r0.add(2);
            IHostShare r7 = r6.a;
            if (r7 == null) goto L10;
            r7.removeExternalDataSource(r0);
        L10:
            k00.e.d = false;
            e5 r8 = this.a;
            DataCenter r1 = r8.i;
            if (r1 == null) goto L14;
            r1.removeObserver("live_room_exit", r8.z);
            return;
        }
    }

    public class d implements SingleObserver<Response<com.bytedance.android.livesdk.chatroom.model.k3>> {
        public final /* synthetic */ ShareParams.Builder a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;
        public final /* synthetic */ HashMap d;
        public final /* synthetic */ e5 e;

        public final void onSubscribe(Disposable r1) {
        }

        public final void onError(Throwable r5) {
            e5 r6 = this.e;
            r6.m = false;
            r6.n = "";
            this.e.g(this.a, this.b, this.c, this.d);
            ALogger.e("ToolbarShareBehavior", "ShopGuideID Error: 获取导购信息失败! ");
        }

        public final void onSuccess(Object r6) {
            Response r7 = (Response) r6;
            if (((BaseResponse) r7).statusCode != 0) goto L28;
            Object r0 = ((BaseResponse) r7).data;
            if (r0 != null) goto L8;
            ALogger.e("ToolbarShareBehavior", "ShopGuideID Error: response.data == null，获取导购信息失败! ");
            e5 r8 = this.e;
            r8.m = false;
            r8.n = "";
            this.e.g(this.a, this.b, this.c, this.d);
            return;
        L8:
            if (((com.bytedance.android.livesdk.chatroom.model.k3) r0).b() == null) goto L13;
            if (xl.a.getValue().booleanValue() == false) goto L13;
            this.d.putAll(((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r7).data).b());
        L13:
            if (((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r7).data).a() != null) goto L15;
        L21:
            ALogger.e("ToolbarShareBehavior", "ShopGuideID Error: 导购信息 == null! ");
            e5 r9 = this.e;
            r9.m = false;
            r9.n = "";
        L22:
            m50 r10 = m50.a;
            if (r10.getValue().p() == false) goto L25;
        L26:
            this.a.setEnableLandscapeOpt(true);
        L27:
            this.e.g(this.a, this.b, this.c, this.d);
            return;
        L25:
            if (r10.getValue().o() == false) goto L27;
        L15:
            if (((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r7).data).a().booleanValue() != true) goto L21;
            if (StringUtils.isEmpty(((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r7).data).c()) == true) goto L21;
            if (StringUtils.isEmpty(((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r7).data).d()) == true) goto L21;
            this.a.setUrl(((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r7).data).c());
            this.a.getExtras().putString("shop_guide_id", ((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r7).data).d());
            e5 r1 = this.e;
            r1.m = true;
            r1.n = ((com.bytedance.android.livesdk.chatroom.model.k3) ((BaseResponse) r7).data).d();
            goto L22
        L28:
            ALogger.e("ToolbarShareBehavior", "ShopGuideID Error: response.statusCode != 0! ");
            this.e.g(this.a, this.b, this.c, this.d);
        }

        public d(e5 r1, ShareParams.Builder r2, String r3, Map r4, HashMap r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public class e implements IShareCallbackWithExtra {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ ShareParams.Builder c;
        public final /* synthetic */ e5 d;

        public final void onFail(Throwable r1) {
        }

        public final /* synthetic */ void onShareUiDismiss() {
            IShareCallback.-CC.$default$onShareUiDismiss(this);
        }

        public final /* synthetic */ void onShareUiShow() {
            IShareCallback.-CC.$default$onShareUiShow(this);
        }

        public final boolean interceptReportAction(IShareParams r5) {
            if (tb1.c.a == true) goto L5;
            return false;
        L5:
            if (TextUtils.isEmpty(oc.a.getValue()) == true) goto L10;
            zg1.r2 r6 = new zg1.r2(this.d.a.getBaseOwner().getCastSecUid(), this.d.a.getId(), jc1.k.f(IUserService.class).user().b().getCastSecUid());
            jc1.k.f(IReportService.class).reportWithReportAnchorEvent(ReportConstant.BusinessSource.MorePanelShareButton, r6, this.d.a);
            return true;
        L10:
            return false;
        }

        public final void onSuccess(String r2, String r3) {
            onSuccessWithExtra(r2, r3, null);
        }

        public final void onSuccessWithExtra(String r18, String r19, Map<String, List<String>> r20) {
            if (tb1.c.a == false) goto L10;
            if (TextUtils.equals(r18, this.d.B) == false) goto L10;
            if (TextUtils.equals(r19, "command") == false) goto L10;
            return;
        L10:
            this.d.B = r18;
            long r3 = System.currentTimeMillis();
            e5 r0 = this.d;
            int r10 = 0;
            if ((r3 - r0.C) < 2000) goto L29;
            r0.C = System.currentTimeMillis();
            if (TextUtils.equals(r18, "share_to_story") == true) goto L15;
        L16:
            final e5 r1 = this.d;
            long r4 = r1.a.getId();
            String r5 = this.d.a.getLabels();
            HashMap r6 = new HashMap();
            com.bytedance.android.livesdk.share.e.a.getClass();
            String r11 = String.valueOf(com.bytedance.android.livesdk.share.e.a.b(r18));
            if (TextUtils.isEmpty(r11) == true) goto L19;
            r6.put("target_id", r11);
        L19:
            String r12 = String.valueOf(1);
            if (TextUtils.isEmpty(r12) == true) goto L22;
            r6.put("share_type", r12);
        L22:
            String r7 = String.valueOf(r5);
            if (TextUtils.isEmpty(r7) == true) goto L25;
            r6.put("common_label_list", r7);
        L25:
            com.bytedance.android.livesdk.service.l.d().getClass();
            ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).sendShare(r4, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new y4(r1), RxUtil.getNoOpThrowable());
            if (com.bytedance.android.live.core.utils.z.e(r1.i, false) == false) goto L29;
            ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).justReportRoomEvent(9, 0, 16, "");
            goto L29
        L15:
            if (com.bytedance.android.livesdk.config.setting.p.a() == false) goto L16;
        L29:
            if (com.bytedance.android.livesdk.utils.c1.b(this.d.i) == false) goto L45;
            if (this.d.a.author() == null) goto L45;
            JSONObject r13 = new JSONObject();
            r13.put("anchor_id", this.d.a.author().getIdString());     // Catch: JSONException -> L35
            r13.put("room_id", String.valueOf(this.d.a.getId()));     // Catch: JSONException -> L35
        L37:
            com.bytedance.android.livesdk.chatroom.utils.k1.f(r13);
            ILiveDouPlusService r2 = jc1.k.f(ILiveDouPlusService.class);
            HashMap r14 = new HashMap();
            r14.put("ad_extra_data", r13.toString());
            Map r15 = com.bytedance.android.livesdk.utils.c1.e(this.d.i);
            if (r15 != null) goto L40;
        L43:
            r2.logEvent(true, "live_ad", "live_share", r14);
            goto L45
        L40:
            if (r15.isEmpty() == true) goto L43;
            r14.putAll(r15);
        L35:
            e = move-exception;
            e.printStackTrace();
        L45:
            if (com.bytedance.android.livesdk.utils.c1.c(this.d.i) == true) goto L47;
        L58:
            DataCenter r8 = this.d.i;
            int r9 = com.bytedance.android.livesdk.utils.x1.a;
            if (TextUtils.equals("vip_im", r18) == false) goto L62;
            Lazy r16 = VipIMManager.f;
            VipIMManager.a.a().a(false);
            HashMap r17 = new HashMap();
            r17.put("inquiry_form", "share");
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_VIPinquiry_click", r17, new Object[]{am2.x.class, Room.class});
        L62:
            if (r20 == null) goto L79;
            List<String> r110 = r20.get("to_user_ids");
            List<String> r111 = r20.get("conversation_ids");
            HashMap r112 = new HashMap();
            if (CollectionUtils.isEmpty(r110) == true) goto L70;
            int r113 = 0;
        L67:
            if (r113 >= r110.size()) goto L70;
            r112.clear();
            r112.put("to_user_id", ListProtector.get(r110, r113));
            r112.putAll(com.bytedance.android.livesdk.locallife.g.a(this.d.a, (String) ListProtector.get(r110, r113)));
            e5.a(this.d, r18, r19, r112, this.a, this.b);
            r113 = r113 + 1;
        L70:
            if (CollectionUtils.isEmpty(r111) == true) goto L75;
        L72:
            if (r10 >= r111.size()) goto L75;
            r112.clear();
            r112.put("conversation_id", ListProtector.get(r111, r10));
            r112.putAll(com.bytedance.android.livesdk.locallife.g.a(this.d.a, null));
            e5.a(this.d, r18, r19, r112, this.a, this.b);
            r10 = r10 + 1;
        L75:
            if (CollectionUtils.isEmpty(r110) == true) goto L77;
            return;
        L77:
            if (CollectionUtils.isEmpty(r111) == false) goto L94;
            e5 r21 = this.d;
            e5.a(r21, r18, r19, com.bytedance.android.livesdk.locallife.g.a(r21.a, null), this.a, this.b);
            return;
        L94:
            return;
        L79:
            HashMap r22 = new HashMap();
            r22.putAll(com.bytedance.android.livesdk.locallife.g.a(this.d.a, null));
            if (this.c.isFromMoreMixShare() == false) goto L84;
            r22.put("enter_from", "share_panel");
            if (TextUtils.equals(r18, "link") == false) goto L84;
            String r23 = "copy";
        L85:
            e5.a(this.d, r23, r19, r22, this.a, this.b);
            return;
        L84:
            r23 = r18;
            goto L85
        L47:
            if (this.d.a.author() == null) goto L58;
            JSONObject r114 = new JSONObject();
            r114.put("anchor_id", this.d.a.author().getIdString());     // Catch: JSONException -> L51
            r114.put("room_id", String.valueOf(this.d.a.getId()));     // Catch: JSONException -> L51
        L53:
            com.bytedance.android.livesdk.chatroom.utils.k1.f(r114);
            ILiveDouPlusService r24 = jc1.k.f(ILiveDouPlusService.class);
            HashMap r25 = new HashMap();
            r25.put("ad_extra_data", r114.toString());
            Map r26 = com.bytedance.android.livesdk.utils.c1.f(this.d.i);
            if (r26.isEmpty() == true) goto L57;
            r25.putAll(r26);
        L57:
            r24.logEvent(true, "live_ad", "live_share", r25);
        L51:
            e = move-exception;
            e.printStackTrace();
            goto L53
        }

        public e(e5 r1, boolean r2, Map r3, ShareParams.Builder r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static class f implements IShareDialogListener {
        public final WeakReference<e5> a;

        public final void onShareDialogDismiss() {
            if (this.a.get() == null) goto L8;
            DataCenter r0 = this.a.get().i;
            if (r0 == null) goto L9;
            r0.put("data_share_dialog_showing", Boolean.FALSE);
            return;
        L9:
            return;
        }

        public final void onShareDialogShow() {
            if (this.a.get() == null) goto L8;
            DataCenter r0 = this.a.get().i;
            if (r0 == null) goto L9;
            r0.put("data_share_dialog_showing", Boolean.TRUE);
            return;
        L9:
            return;
        }

        public f(e5 r2) {
            this.a = new WeakReference(r2);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public static boolean b() {
        int r0 = com.bytedance.android.livesdk.chatroom.utils.y3.a;
        if (y9.a.getValue().booleanValue() == false) goto L9;
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L9;
        if (tb1.c.g == false) goto L9;
    L10:
        return true;
    L9:
        if (xl.a.getValue().booleanValue() == true) goto L10;
        return false;
    }

    public static List c() {
        if (tb1.c.a == true) goto L5;
        return null;
    L5:
        if (com.bytedance.android.livesdk.service.l.d().b() != null) goto L7;
        return null;
    L7:
        if (com.bytedance.android.livesdk.service.l.d().b().a(IShareGuideService.class) != null) goto L9;
        return null;
    L9:
        return ((IShareGuideService) com.bytedance.android.livesdk.service.l.d().b().a(IShareGuideService.class)).returnSortedFansGroup();
    }

    public final void i() {
        Dialog r0 = this.j;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L31;
        FragmentActivity r1 = this.c;
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isFinishing() == true) goto L33;
        Dialog r2 = this.j;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r2);
        return;
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r4 == null) goto L24;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r3.getLooper()) goto L15;
        r3.post(DialogLancet.createDismissRunnable(r2));
        return;
    L33:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.u;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3) {
        if (((Boolean) h21.a.getValue()).booleanValue() == false) goto L7;
        if (r3 == null) goto L8;
        d(r3.c, null, r3);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3) {
        if (((Boolean) h21.a.getValue()).booleanValue() == false) goto L6;
        if (r3 == null) goto L6;
        d(r3.c, null, r3);
    L6:
        if (r3 == null) goto L9;
        TextUtils.isEmpty(r3.d);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r3) {
        if ((r3 instanceof pp1.m) == false) goto L10;
        if (this.h == null) goto L10;
        if (((Boolean) h21.a.getValue()).booleanValue() == true) goto L22;
        UIUtils.setViewVisibility(this.h, ((pp1.m) r3).a);
        return;
    L22:
        return;
    L10:
        if ((r3 instanceof pp1.h) == false) goto L24;
        View r0 = this.h;
        if (r0 == null) goto L14;
        View r1 = r0.findViewById(2131392581);
    L16:
        if (((pp1.h) r3).a == false) goto L18;
        int r4 = 0;
    L19:
        if (r1 == null) goto L25;
        r1.setVisibility(r4);
        return;
    L25:
        return;
    L18:
        r4 = 8;
        goto L19
    L14:
        r1 = null;
        goto L16
    }

    public final void h(ShareParams.Builder r15) {
        if (this.i != null) goto L6;
        return;
    L6:
        if (this.a != null) goto L11;
        RoomContext r0 = this.f;
        if (r0 == null) goto L11;
        this.a = (Room) r0.getRoom().getValue();
    L11:
        if (this.a != null) goto L13;
        return;
    L13:
        String r1 = (String) this.i.get("log_action_type", "");
        HashMap r11 = new HashMap();
        r11.put("position", "detail_bottom_bar");
        com.bytedance.android.livesdk.log.filter.o r2 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        if (r2 == null) goto L16;
        r11.putAll(r2.getMap());
    L16:
        com.bytedance.android.livesdk.log.filter.o r3 = com.bytedance.android.livesdk.log.u.l().c(Room.class);
        if (r3 == null) goto L20;
        r11.putAll(r3.getMap());
    L20:
        if (this.c != null) goto L22;
        return;
    L22:
        HashMap<String, String> r12 = new HashMap();
        if (r15.getMoreShareType() == (-1)) goto L29;
        if (r15.isFromMoreMixShare() == true) goto L29;
        g(r15, r1, r11, r12);
        return;
    L29:
        if (vr0.a.getValue().booleanValue() == false) goto L34;
        FragmentActivity r4 = this.c;
        if (r4 == null) goto L34;
        com.bytedance.android.livesdk.widget.e1 r5 = new com.bytedance.android.livesdk.widget.e1(r4);
        this.j = r5;
        r5.setCancelable(false);
        this.j.setCanceledOnTouchOutside(false);
    L34:
        Single r6 = null;
        if (xl.a.getValue().booleanValue() == false) goto L37;
        String r7 = jc1.k.f(IHostBusiness.class).getBcmChainInfo();
    L39:
        if (b() == true) goto L41;
        g(r15, r1, r11, r12);
        return;
    L41:
        if (this.c == null) goto L64;
        DataCenter r8 = this.i;
        int r9 = com.bytedance.android.livesdk.chatroom.ssposter.util.g.a;
        if (tb1.c.a == false) goto L64;
        if (r8 != null) goto L46;
    L49:
        boolean r10 = true;
    L50:
        if (r10 == false) goto L64;
        Dialog r13 = this.j;
        if (r13 == null) goto L57;
        if (r13.isShowing() == true) goto L64;
    L57:
        if (this.j != null) goto L59;
        com.bytedance.android.livesdk.widget.e1 r14 = new com.bytedance.android.livesdk.widget.e1(this.c);
        this.j = r14;
        r14.setCancelable(false);
        this.j.setCanceledOnTouchOutside(false);
    L59:
        Dialog r16 = this.j;
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L71;
        DialogLancet.handleBlockedDialogShow(r16);
        goto L64
    L71:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L70
    L63:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        goto L64
    L46:
        if (((Boolean) r8.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L49;
        r10 = false;
    L64:
        String r17 = com.bytedance.android.livesdk.utils.g4.e();
        String r18 = com.bytedance.android.livesdk.utils.g4.d();
        long r19 = com.bytedance.android.live.core.utils.z.o(this.i).getId();
        String r20 = com.bytedance.android.live.core.utils.z.o(this.i).getOwnerUserIdString();
        String r110 = this.a.lifeShareId;
        Intrinsics.checkNotNullParameter(r20, "userId");
        com.bytedance.android.livesdk.service.l.d().getClass();
        ShopGuideApi r21 = (ShopGuideApi) com.bytedance.android.live.network.c.b().e(ShopGuideApi.class);
        if (r21 == null) goto L67;
        r6 = r21.queryShopGuideId(r19, r20, r7, r110, "livebroadcasting", r17, r18, r1);
    L67:
        r6.observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r15, r1, r11, r12));
        return;
    L37:
        r7 = null;
        goto L39
    }

    public final void j(ShareParams.Builder r7) {
        DataCenter r0 = this.i;
        Boolean r1 = Boolean.FALSE;
        if (((Boolean) r0.get("data_is_fans_group_share", r1)).booleanValue() == true) goto L6;
        r7.setIsFastShareInPk(false);
        return;
    L6:
        this.i.put("data_is_fans_group_share", r1);
        Room r2 = this.a;
        String r3 = "";
        if (r2 != null) goto L9;
        String r4 = "";
    L10:
        Room r5 = jc1.k.f(ILinkServiceExternal.class).getPkServiceExternal().b();
        if (r5 == null) goto L14;
        r3 = r5.getCoverUrl();
    L14:
        if (r5 == null) goto L16;
        long r6 = r5.getRoomId();
    L17:
        lc0.c r8 = jc1.k.f(ILinkServiceExternal.class).getMultiDataHolderExternal();
        ShareParams.Builder r9 = r7.setIsFastShareInPk(true).setCoverTop(r4).setCoverBottom(r3);
        jv r10 = jv.a;
        r9.setCoverMask(r10.getValue().d()).setCoverMaskForMsg(r10.getValue().b()).setPkTopTitle(r10.getValue().e()).setPkDefaultInputText(r10.getValue().c()).setPkId(r8.getPkId()).setChannelId(r8.getChannelId()).setToRoomId(r6);
        return;
    L16:
        r6 = 0;
        goto L17
    L9:
        r4 = r2.getCoverUrl();
        goto L10
    }

    public final void k(ShareParams.Builder r4) {
        if (((Boolean) this.i.get("data_is_anchor", Boolean.TRUE)).booleanValue() == false) goto L5;
        r4.setDescription(this.a.getAnchorShareText()).setAnchor(true);
        return;
    L5:
        r4.setDescription(this.a.getUserShareText()).setAnchor(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        if (this.f != null) goto L5;
        this.f = RoomContext.getShared(this.i);
    L5:
        RoomContext r9 = this.f;
        if (r9 == null) goto L9;
        this.a = (Room) r9.getRoom().getValue();
        this.d = (User) this.f.getUser().getValue();
    L9:
        if (this.a != null) goto L11;
        return;
    L11:
        if (this.d != null) goto L14;
        return;
    L14:
        if (com.bytedance.android.live.core.utils.n1.a() == true) goto L17;
        return;
    L17:
        if (com.bytedance.android.live.core.utils.z.k(this.i) == false) goto L19;
    L24:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_share_click", com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.f4.a(this.i, null), new Object[]{Room.class});
    L25:
        final ShareParams.Builder r10 = ShareParams.buildUponRoom(this.a);
        if (pm1.f.l() != null) goto L28;
    L30:
        r10.setMultiCamera(com.bytedance.android.live.core.utils.q2.b(this.a)).setStartShareTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.o) == true) goto L33;
        r10.setClickFrom(this.o);
    L33:
        RoomContext r3 = this.f;
        if (r3 == null) goto L39;
        if (((Boolean) r3.isAnchor().getValue()).booleanValue() == false) goto L39;
        r10.setImHalfChatFragmentEnable(false);
    L39:
        if (this.v == false) goto L45;
        this.v = false;
        View r4 = this.h.findViewById(2131374718);
        if (r4 == null) goto L43;
        r4.setVisibility(0);
    L43:
        ((ViewGroup) this.h).removeView(this.u);
        this.h.setBackground(null);
    L45:
        if (this.t == false) goto L48;
        this.t = false;
        SharedPrefHelper r2 = this.s;
        r2.l("key_live_vs_share_icon_reverse_data" + this.a.getRoomId(), Long.valueOf(System.currentTimeMillis()));
        r2.a();
    L48:
        if (this.a.getVisibilityRange() != 11) goto L62;
        RoomContext r5 = this.f;
        if (r5 == null) goto L62;
        if (((Boolean) r5.isAnchor().getValue()).booleanValue() == false) goto L62;
        if (this.g.booleanValue() == false) goto L62;
        this.g = Boolean.FALSE;
        final HashMap r6 = new HashMap();
        r6.put("action_type", "show");
        Context r7 = this.b;
        c9.b r11 = new c9.b();
        r11.a = r7;
        r11.b = 1;
        r11.e = com.bytedance.android.live.core.utils.s1.B(2131922969);
        r11.f = com.bytedance.android.live.core.utils.s1.B(2131922968);
        r11.g = 17;
        r11.q = true;
        String r12 = com.bytedance.android.live.core.utils.s1.B(2131922967);
        DialogInterface.OnClickListener r13 = new w4(this, r6, r10);
        r11.h = r12;
        r11.i = r13;
        c9 r14 = new c9(r11.a, r11);
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L65;
        DialogLancet.handleBlockedDialogShow(r14);
    L60:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_mock_live_share_popup", r6, new Object[]{am2.x.class, Room.class});
        return;
    L65:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L64
    L59:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
    L62:
        h(r10);
        return;
    L28:
        if (com.bytedance.android.live.core.utils.q2.b(this.a) == false) goto L30;
        r10.setCurrentCameraInfo(pm1.f.l().d(this.a, ((Long) this.f.getCameraId().getValue()).longValue())).setSubCamera(pm1.f.l().a(this.i));
        goto L30
    L19:
        if (com.bytedance.android.live.core.utils.z.g(this.i) == true) goto L24;
        if (com.bytedance.android.live.core.utils.z.i(this.i) == true) goto L24;
        if (com.bytedance.android.live.core.utils.z.h(this.i) == false) goto L25;
        goto L24
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        r3.removeObserver("data_hs_fraternity_bubble", this.y);
        yo2.e r4 = this.l;
        if (r4 == null) goto L5;
        r4.d();
        this.l = null;
    L5:
        Disposable r5 = this.k;
        if (r5 == null) goto L9;
        r5.dispose();
        return;
    }

    public final ShareParams.Builder e(ShareParams.Builder r10, HashMap<String, String> r11) {
        if (pm1.f.l() != null) goto L5;
    L7:
        r10.setMultiCamera(com.bytedance.android.live.core.utils.q2.b(this.a)).setStartShareTime(System.currentTimeMillis());
        if (TextUtils.isEmpty(this.o) == true) goto L10;
        r10.setClickFrom(this.o);
    L10:
        RoomContext r0 = this.f;
        boolean r1 = false;
        if (r0 != null) goto L13;
    L15:
        m50 r2 = m50.a;
        boolean r3 = true;
        if (r2.getValue().p() == false) goto L18;
    L19:
        r10.setEnableLandscapeOpt(true);
    L20:
        String r4 = "";
        String r5 = (String) this.i.get("data_member_count_str", "");
        if (TextUtils.isEmpty(r5) == true) goto L23;
        r10.setRoomMemberCountStr(r5);
    L23:
        r10.setUserId(this.e.n());
        r10.setEnterFrom("live_room");
        if (r10.getRequestId() != null) goto L35;
        if (com.bytedance.android.livesdk.log.u.l().c(Room.class) == null) goto L35;
        if (com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap() == null) goto L35;
        if (com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap().get("request_id") == null) goto L35;
        if ((com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap().get("request_id") instanceof String) == false) goto L35;
        r10.setRequestId((String) com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap().get("request_id"));
    L35:
        if (xl.a.getValue().booleanValue() == false) goto L37;
        r10.setLiveCommonShareParams(r11);
    L37:
        com.bytedance.android.livesdk.chatroom.d.a.booleanValue();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.p.a(r10, LiveShareType.SHARE_DIRECT, this.a, this.i);
        int r12 = com.bytedance.android.livesdk.utils.i1.a;
        com.bytedance.android.livesdk.utils.i1.b(r10, "click", this.a);
        k(r10);
        j(r10);
        DouPlusEntry r13 = com.bytedance.android.livesdk.utils.c1.a(this.i);
        if (com.bytedance.android.live.core.utils.z.m(this.i, true) == true) goto L40;
        r13.enableShareEntry = false;
    L40:
        Room r6 = this.a;
        if (r6 != null) goto L43;
    L45:
        boolean r7 = true;
    L46:
        ShareParams.Builder r14 = r10.setEnablePromotion(r7).setDouPlusEntry(r13).setFansGroups(c());
        Room r15 = this.a;
        if (r15 != null) goto L49;
    L53:
        r3 = false;
    L54:
        ShareParams.Builder r16 = r14.setEnablePoster(r3);
        VipIMWidget r17 = this.p;
        if (r17 == null) goto L57;
        r1 = r17.c;
    L60:
        ShareParams.Builder r18 = r16.setShowVipIM(r1);
        Lazy r19 = VipIMManager.f;
        ShareParams.Builder r110 = r18.setShowVipIMRedDot(VipIMManager.a.a().a);
        VipIMWidget r111 = this.p;
        if (r111 == null) goto L63;
        r4 = r111.getSchema();
    L67:
        return r110.setVipIMUri(r4);
    L63:
        w5 r112 = this.q;
        if (r112 == null) goto L67;
        r4 = r112.getSchema();
        goto L67
    L57:
        w5 r113 = this.q;
        if (r113 == null) goto L60;
        r1 = r113.a();
        goto L60
    L49:
        if (r15.getMRoomAuthStatus() == null) goto L53;
        if (this.a.getMRoomAuthStatus().getPoster() != 1) goto L53;
    L43:
        if (r6.getStreamType() != LiveMode.MEDIA) goto L45;
        r7 = com.bytedance.android.livesdk.config.q3.a.getValue().booleanValue();
        goto L46
    L18:
        if (r2.getValue().o() == false) goto L20;
    L13:
        if (((Boolean) r0.isAnchor().getValue()).booleanValue() == false) goto L15;
        r10.setImHalfChatFragmentEnable(false);
        goto L15
    L5:
        if (com.bytedance.android.live.core.utils.q2.b(this.a) == false) goto L7;
        r10.setCurrentCameraInfo(pm1.f.l().d(this.a, ((Long) this.f.getCameraId().getValue()).longValue())).setSubCamera(pm1.f.l().a(this.i));
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public void p4(View r7, DataCenter r8) {
        RoomContext r0 = this.f;
        if (r0 == null) goto L5;
        this.a = (Room) r0.getRoom().getValue();
        this.d = (User) this.f.getUser().getValue();
    L5:
        this.h = r7;
        Room r9 = this.a;
        boolean r1 = false;
        if (r9 != null) goto L8;
    L15:
        int r10 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.b(Boolean.valueOf(com.bytedance.android.live.core.utils.z.e(r8, false))) == false) goto L29;
        if (this.h == null) goto L29;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.i).n(ToolbarButton.SHARE) == false) goto L29;
        View r11 = this.h.findViewById(2131374718);
        if (r11 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2.a(r11);
        if (this.a == null) goto L29;
        r11.setBackgroundResource(2131253002);
        if (((Boolean) j40.h4.a.getValue()).booleanValue() == false) goto L29;
        r11.setBackgroundResource(2131253003);
    L29:
        if (com.bytedance.android.livesdk.config.setting.s.a() == false) goto L74;
        if (((Boolean) h21.a.getValue()).booleanValue() == false) goto L74;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.a r12 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.r.f;
        Room r4 = this.a;
        boolean r13 = com.bytedance.android.live.core.utils.z.m(r8, true);
        r12.getClass();
        if (r13 == false) goto L52;
        if (r4 == null) goto L70;
        LiveToolbarData r14 = r4.getToolbarData();
        if (r14 == null) goto L70;
        List r15 = r14.getToolbarDataList();
        if (r15 == null) goto L70;
        Iterator r16 = r15.iterator();
    L41:
        if (r16.hasNext() == false) goto L48;
        Object r17 = r16.next();
        if (((IToolbarComponentData) r17).getId() != 20) goto L45;
        boolean r5 = true;
    L46:
        if (r5 == false) goto L41;
    L49:
        IToolbarComponentData r18 = (IToolbarComponentData) r17;
        if (r18 == null) goto L70;
        py.k r19 = r18.getIcon();
    L71:
        if (r19 == null) goto L74;
        d(r19, null, null);
        goto L74
    L45:
        r5 = false;
        goto L46
    L48:
        r17 = null;
    L70:
        r19 = null;
        goto L71
    L52:
        if (r4 == null) goto L70;
        LiveToolbarData r20 = r4.getToolbarData();
        if (r20 == null) goto L70;
        List r21 = r20.getLandScapeTop();
        if (r21 == null) goto L70;
        Iterator r22 = r21.iterator();
    L59:
        if (r22.hasNext() == false) goto L66;
        Object r23 = r22.next();
        if (((ToolbarComponentData) r23).getId() != 20) goto L63;
        boolean r6 = true;
    L64:
        if (r6 == false) goto L59;
    L67:
        ToolbarComponentData r24 = (ToolbarComponentData) r23;
        if (r24 == null) goto L70;
        r19 = r24.getIcon();
        goto L71
    L63:
        r6 = false;
        goto L64
    L66:
        r23 = null;
    L74:
        if (com.bytedance.android.livesdk.config.setting.s.a() == false) goto L116;
        Room r25 = this.a;
        int r26 = com.bytedance.android.livesdk.chatroom.ssposter.util.g.a;
        if (r25 == null) goto L94;
        LiveToolbarData r27 = r25.getToolbarData();
        if (r27 == null) goto L94;
        List r28 = r27.getToolbarDataList();
        if (r28 == null) goto L94;
        Iterator r29 = r28.iterator();
    L83:
        if (r29.hasNext() == false) goto L90;
        Object r30 = r29.next();
        if (((IToolbarComponentData) r30).getId() != 20) goto L87;
        boolean r31 = true;
    L88:
        if (r31 == false) goto L83;
    L91:
        IToolbarComponentData r32 = (IToolbarComponentData) r30;
        if (r32 == null) goto L94;
        String r33 = r32.getExtraData();
    L96:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r33) == true) goto L116;
        if (r25 == null) goto L116;
        LiveToolbarData r34 = r25.getToolbarData();
        if (r34 == null) goto L116;
        List r35 = r34.getMorePanelDataList();
        if (r35 == null) goto L116;
        Iterator r36 = r35.iterator();
    L105:
        if (r36.hasNext() == false) goto L112;
        Object r37 = r36.next();
        if (((ToolbarComponentData) r37).getId() != 20) goto L109;
        boolean r38 = true;
    L110:
        if (r38 == false) goto L105;
    L113:
        ToolbarComponentData r39 = (ToolbarComponentData) r37;
        if (r39 == null) goto L116;
        r39.getExtraData();
        goto L116
    L109:
        r38 = false;
        goto L110
    L112:
        r37 = null;
        goto L113
    L87:
        r31 = false;
        goto L88
    L90:
        r30 = null;
    L94:
        r33 = null;
    L116:
        DataCenter r40 = this.i;
        if (r40 == null) goto L120;
        r40.observe("live_room_exit", this.z);
    L120:
        if (com.bytedance.android.live.core.utils.z.e(this.i, false) == true) goto L122;
    L124:
        this.x = r1;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.i).n(ToolbarButton.SHARE) == true) goto L139;
        if (this.a.isMergeVSRoom() == false) goto L139;
        if (this.v == true) goto L139;
        this.t = true;
        SharedPrefHelper r41 = SharedPrefHelper.b(this.b);
        this.s = r41;
        long r42 = r41.i("key_live_vs_share_icon_reverse_data" + this.a.getRoomId(), 0);
        if (r42 > 0) goto L135;
    L137:
        View r43 = LayoutInflater.from(this.b).inflate(2131567838, null);
        this.u = r43;
        this.w = r43.findViewById(2131378468);
        TTLiveSDK.hostService().user().loadSharePanelUserList(1, new k5(this));
        goto L139
    L135:
        if ((r42 + 259200000) <= System.currentTimeMillis()) goto L137;
    L139:
        if (vc.a.getValue().booleanValue() == false) goto L168;
        k00.e r44 = k00.e.e;
        String r45 = this.e.n();
        FragmentActivity r2 = this.c;
        r44.getClass();
        Intrinsics.checkNotNullParameter(r45, "anchorId");
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        if (k00.e.d == false) goto L144;
        return;
    L144:
        if (Intrinsics.areEqual((String) k00.e.b.getValue(), r45) == false) goto L146;
        ((ObservableSubscribeProxy) Observable.create(k00.a.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r2))).subscribe(k00.b.a);
    L146:
        ((ObservableSubscribeProxy) ((ShareListApi) com.bytedance.android.live.network.c.b().e(ShareListApi.class)).getAnchorShareList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r2))).subscribe(new k00.c(r45), k00.d.a);
        return;
    L168:
        return;
    L122:
        if (wc.a.getValue().booleanValue() == false) goto L124;
        r1 = true;
        goto L124
    L8:
        if (r9.getBaseOwner() == null) goto L15;
        if (this.a.getBaseOwner().getSecret() != 1) goto L15;
        HashMap r46 = new HashMap();
        r46.put("room_id", Long.valueOf(this.a.getId()));
        r46.put("anchor_id", this.a.getOwnerUserIdString());
        User r3 = this.d;
        if (r3 == null) goto L14;
        r46.put("user_id", r3.getIdStr());
    L14:
        LiveSlardarMonitor.monitorStatus("ttlive_privateAccount_share_show", 0, r46);
        goto L15
    }

    public final void d(py.k r4, VSShareReverseView r5, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r6) {
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.i).n(ToolbarButton.SHARE) == true) goto L5;
        return;
    L5:
        DataCenter r0 = this.i;
        if (r0 != null) goto L8;
    L10:
        if (r5 != null) goto L12;
        this.A = true;
    L12:
        SkinLoader.c.getClass();
        if (SkinLoader.a.b() == false) goto L19;
        if (r6 == null) goto L19;
        SkinLoader r7 = SkinLoader.a.e(r6);
        ResKeyEnum r1 = ResKeyEnum.STATIC_ICON;
        if (r7.b(com.bytedance.android.livesdk.chatroom.utils.y2.b(r1)) == null) goto L19;
        r7.c(com.bytedance.android.livesdk.chatroom.utils.y2.a(r1, 2131253002), this.h.findViewById(2131374718), new f5(this));
        return;
    L19:
        if (r4 != null) goto L21;
        return;
    L21:
        this.k = com.bytedance.android.livesdk.chatroom.utils.a1.l(r4, com.bytedance.android.live.core.utils.s1.f(36.0f), com.bytedance.android.live.core.utils.s1.f(36.0f), false, null).compose(RxUtil.rxSchedulerHelper()).subscribe(new g5(this, r5), new h5());
        return;
    L8:
        if (((Boolean) r0.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L10;
    }

    public final void g(ShareParams.Builder r20, String r21, Map<String, String> r22, HashMap<String, String> r23) {
        if (r20.isFromMoreMixShare() == false) goto L5;
        i();
    L5:
        String r3 = "";
        this.B = "";
        String r4 = (String) this.i.get("data_member_count_str", "");
        if (TextUtils.isEmpty(r4) == true) goto L8;
        r20.setRoomMemberCountStr(r4);
    L8:
        r20.setUserId(this.e.n());
        r20.setEnterFrom("live_room");
        if (r20.getRequestId() == null) goto L11;
    L19:
        HashMap r5 = new HashMap(r23);
        if (xl.a.getValue().booleanValue() == false) goto L22;
        r20.setLiveCommonShareParams(r23);
    L22:
        LiveShareType r2 = LiveShareType.SHARE_DIALOG;
        int r6 = r20.getMoreShareType();
        int r7 = bp1.d.i;
        if (r6 != 1) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L28;
        LiveShareType r9 = LiveShareType.SHARE_DIRECT;
    L29:
        String r10 = "1";
        if (r9 != r2) goto L77;
        HashMap r11 = new HashMap();
        Room r12 = this.a;
        if (r12 != null) goto L34;
    L37:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_click_more_button", r11, new Object[]{new am2.x(), Room.class});
        IUser r13 = jc1.k.f(IUserService.class).user().b();
        Room r14 = this.a;
        if (r14 != null) goto L40;
    L62:
        HashMap r15 = new HashMap();
        Room r16 = this.a;
        if (r16 == null) goto L69;
        if (r16.getBaseOwner() == null) goto L67;
        r15.put("anchor_id", this.a.getBaseOwner().getIdString());
    L67:
        r15.put("room_id", String.valueOf(this.a.getId()));
    L69:
        if (com.bytedance.android.live.core.utils.z.e(this.i, false) == false) goto L71;
        String r17 = SourceType.ANCHOR;
    L72:
        r15.put("user_type", r17);
        r15.put("event_page", "live_take_detail");
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.i).isPaidLive() == false) goto L75;
        Object r18 = "1";
    L76:
        r15.put("is_paidlive", r18);
        r15.put("watch_paidlive_status", com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.i).J0().q(this.i));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_share_icon_click", r15, new Object[]{new am2.x(), Room.class});
        goto L77
    L75:
        r18 = "0";
        goto L76
    L71:
        r17 = SourceType.DEFAULT;
        goto L72
    L40:
        if (r14.getBaseOwner() == null) goto L62;
        if (r13 == null) goto L62;
        HashMap r19 = new HashMap();
        r19.put("report_type", "report_anchor");
        r19.put("show_type", "data_card_anchor");
        r19.put("to_user_id", this.a.getBaseOwner().getCastSecUid());
        if (r13.isVcdContentAuthorized() == false) goto L46;
        Object r24 = "1";
    L47:
        r19.put("is_reporting_user_authorized", r24);
        if (this.a.getBaseOwner().isVcdContentAuthorized() == false) goto L50;
        Object r25 = "1";
    L51:
        r19.put("is_reported_user_authorized", r25);
        if (this.a.getRoomLayout() != 1) goto L54;
        String r26 = "media";
    L55:
        r19.put("room_layout", r26);
        int r27 = a.a[this.a.getStreamType().ordinal()];
        if (r27 == 1) goto L60;
        if (r27 == 2) goto L59;
        String r28 = "video_live";
    L61:
        r19.put("live_type", r28);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_report_icon_show", r19, new Object[]{Room.class, new am2.x()});
        goto L62
    L59:
        r28 = "third_party";
        goto L61
    L60:
        r28 = "voice_live";
        goto L61
    L54:
        r26 = "normal";
        goto L55
    L50:
        r25 = "0";
        goto L51
    L46:
        r24 = "0";
        goto L47
    L34:
        if (r12.getBaseOwner() == null) goto L36;
        r11.put("anchor_id", this.a.getBaseOwner().getIdString());
    L36:
        r11.put("room_id", String.valueOf(this.a.getId()));
    L77:
        com.bytedance.android.livesdk.chatroom.d.a.booleanValue();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.p.a(r20, r9, this.a, this.i);
        int r29 = com.bytedance.android.livesdk.utils.i1.a;
        com.bytedance.android.livesdk.utils.i1.a(r20, "click", this.a);
        k(r20);
        j(r20);
        m50 r30 = m50.a;
        if (r30.getValue().p() == false) goto L80;
    L83:
        boolean r31 = true;
    L84:
        if (r31 == false) goto L86;
        r20.setEnableLandscapeOpt(true);
    L86:
        if (r31 == false) goto L95;
        Bundle r32 = new Bundle();
        r32.putString("themeId", "fifa");
        r32.putString("loginDesc", "上抖音看世界杯");
        r20.setLoginBundle(r32);
        r20.setLoginEnterFrom("fifa_live");
        if (jc1.k.f(IVSPlayerService.class) == null) goto L93;
        if (((IVSPlayerService) jc1.k.f(IVSPlayerService.class)).provideVSPlayerViewControlService(this.i) == null) goto L93;
        ((IVSPlayerService) jc1.k.f(IVSPlayerService.class)).provideVSPlayerViewControlService(this.i).setVisibilityStatus(false);
    L93:
        if (com.bytedance.android.live.core.utils.z.m(this.i, true) == true) goto L95;
        r20.setEnableMatchRoomDialogAnim(true);
    L95:
        DouPlusEntry r33 = com.bytedance.android.livesdk.utils.c1.a(this.i);
        Room r34 = this.a;
        if (r34 == null) goto L133;
        RoomGameData r110 = r34.getGameData();
        if (r110 == null) goto L133;
        RoomGameDataChannelConfig r111 = r110.getRoomGameDataChannelConfig();
        if (r111 == null) goto L133;
        String r112 = r111.getGameId();
        String r113 = r111.getFusionTagId();
        if (r112 == null) goto L133;
        if (r112.isEmpty() == true) goto L133;
        if (r113 == null) goto L133;
        if (r113.isEmpty() == true) goto L133;
        HashMap r114 = new HashMap();
        r114.put("game_id", r112);
        r114.put("action_type", "share");
        String r115 = am2.n.f().c();
        if (r115 != null) goto L115;
    L117:
        r10 = "0";
    L118:
        r114.put("is_ads", r10);
        User r116 = r34.getBaseOwner();
        if (r116 == null) goto L124;
        if (r116.getIdString() == null) goto L124;
        r114.put("host_id", r116.getIdString());
    L124:
        if (r34.getIdStr() == null) goto L126;
        r114.put("content_id", r34.getIdStr());
    L126:
        r114.put("scene", "0");
        if (r34.getRequestId() == null) goto L129;
        r114.put("req_id", r34.getRequestId());
    L129:
        IHostGameCP r35 = jc1.k.f(IHostGameCP.class);
        if (r35 == null) goto L133;
        r35.dataChannelLinkEvent("douyin_game_content_consume_click_monitor", r114);
        goto L133
    L115:
        if (r115.isEmpty() == true) goto L117;
    L133:
        if (com.bytedance.android.live.core.utils.z.m(this.i, true) == true) goto L135;
        r33.enableShareEntry = false;
    L135:
        f r36 = new f(this);
        RoomContext.a r37 = RoomContext.Companion;
        DataCenter r117 = this.i;
        r37.getClass();
        com.bytedance.android.livesdk.chatroom.o0.a(RoomContext.a.a(r117, 0), r20);
        i81.a.a r38 = new i81.a.a();
        k00.e.e.getClass();
        r20.setIMUserExtra(k00.e.c);
        ILiveShareService r118 = jc1.k.f(ILiveShareService.class);
        ShareParams.Builder r39 = r20.setShareDialogListener(r36);
        Room r119 = this.a;
        if (r119 != null) goto L138;
    L140:
        boolean r120 = true;
    L141:
        ShareParams.Builder r40 = r39.setEnablePromotion(r120).setLogV3Params(r22).setDouPlusEntry(r33).setAnchor(com.bytedance.android.live.core.utils.z.e(this.i, false)).setLogV3ActionType(r21).setFansGroups(c());
        Room r41 = this.a;
        if (r41 != null) goto L144;
    L148:
        boolean r42 = false;
    L149:
        ShareParams.Builder r43 = r40.setEnablePoster(r42);
        VipIMWidget r44 = this.p;
        if (r44 == null) goto L152;
        boolean r45 = r44.c;
    L156:
        ShareParams.Builder r46 = r43.setShowVipIM(r45);
        Lazy r47 = VipIMManager.f;
        ShareParams.Builder r48 = r46.setShowVipIMRedDot(VipIMManager.a.a().a);
        VipIMWidget r49 = this.p;
        if (r49 == null) goto L159;
        r3 = r49.getSchema();
    L162:
        r38.d = r48.setVipIMUri(r3).build();
        r38.b = this.c;
        r38.l = true;
        r38.m = this.j;
        r38.p = r20.getShareDirectTypeCallback();
        r38.q = r20.isGetPosterWhenDirectType();
        r118.share(r38.a(), "ToolbarShareBehavior", r9, new e(this, r8, r5, r20));
        return;
    L159:
        w5 r50 = this.q;
        if (r50 == null) goto L162;
        r3 = r50.getSchema();
        goto L162
    L152:
        w5 r51 = this.q;
        if (r51 == null) goto L155;
        r45 = r51.a();
        goto L156
    L155:
        r45 = false;
        goto L156
    L144:
        if (r41.getMRoomAuthStatus() == null) goto L148;
        if (this.a.getMRoomAuthStatus().getPoster() != 1) goto L148;
        r42 = true;
        goto L149
    L138:
        if (r119.getStreamType() != LiveMode.MEDIA) goto L140;
        r120 = com.bytedance.android.livesdk.config.q3.a.getValue().booleanValue();
        goto L141
    L80:
        if (r30.getValue().o() == true) goto L83;
        r31 = false;
        goto L84
    L28:
        r9 = r2;
        goto L29
    L25:
        r8 = false;
        goto L26
    L11:
        if (com.bytedance.android.livesdk.log.u.l().c(Room.class) == null) goto L19;
        if (com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap() == null) goto L19;
        if (com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap().get("request_id") == null) goto L19;
        if ((com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap().get("request_id") instanceof String) == false) goto L19;
        r20.setRequestId((String) com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap().get("request_id"));
        goto L19
    }

    public e5(Context r3, FragmentActivity r4, com.bytedance.android.livesdk.user.f r5, RoomContext r6, DataCenter r7) {
        this.g = Boolean.TRUE;
        this.m = false;
        this.n = "";
        this.o = "";
        this.v = false;
        this.x = false;
        this.y = new b(this);
        this.z = new c(this);
        this.A = false;
        this.C = 0;
        this.b = r3;
        this.c = r4;
        this.e = r5;
        CompositeDisposable r8 = new CompositeDisposable();
        this.r = r8;
        this.f = r6;
        this.i = r7;
        Consumer r9 = new x4(this);
        r8.add(RxBusAbility.INSTANCE.getRxBus(r7).b(zg1.z2.class).observeOn(AndroidSchedulers.mainThread()).subscribe(r9));
    }

    public final void f(bp1.d r5, boolean r6, v2 r7, boolean r8, boolean r9) {
        RoomContext r0 = this.f;
        if (r0 == null) goto L5;
        this.a = (Room) r0.getRoom().getValue();
        this.d = (User) this.f.getUser().getValue();
    L5:
        ShareParams.Builder r1 = ShareParams.buildUponRoom(this.a);
        r1.setMoreShareType(r5.f);
        r1.setPlatform(r5.getType());
        if (r5.getType().equals("chat_merge") == false) goto L8;
        r1.setIsHalfScreen(true);
    L8:
        bp1.i r10 = r5.h;
        if (r10 != null) goto L11;
    L17:
        if (r6 == false) goto L19;
        r1.setFromMoreMixShare(r6);
    L19:
        if (r7 == null) goto L21;
        r1.setShareDirectTypeCallback(r7);
    L21:
        if (r8 == false) goto L23;
        r1.setGetPosterWhenDirectType(true);
    L23:
        if (r9 == false) goto L25;
        r1.setBanCopyLinkToastWhenDirectType(true);
    L25:
        h(r1);
        return;
    L11:
        if (r10.c != true) goto L17;
        if (StringUtils.isEmpty(r10.a) == true) goto L17;
        if (StringUtils.isEmpty(r10.b) == true) goto L17;
        this.m = r10.c;
        this.n = r10.b;
        r1.setUrl(r10.a);
        r1.getExtras().putString("shop_guide_id", this.n);
        goto L17
    }

    public static void a(e5 r2, String r3, String r4, Map r5, boolean r6, Map r7) {
        r2.getClass();
        HashMap r0 = new HashMap();
        r0.putAll(r5);
        r0.put("share_platform", r3);
        if (TextUtils.equals(r3, "share_to_story") == false) goto L5;
        r0.put("share_platform", "share_to_diary");
    L5:
        String r8 = "0";
        r0.put("is_pyramid_sale", "0");
        r0.put("type", r4);
        r0.put("share_type", r4);
        r0.put("request_page", "live_room");
        if (r6 == false) goto L9;
        r0.put("is_outer_head", "1");
    L9:
        if (((Boolean) r2.i.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L11;
        Object r9 = "1";
    L13:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r2.i).isPaidLive() == false) goto L15;
        Object r10 = "1";
    L16:
        r0.put("is_paidlive", r10);
        r0.put("watch_paidlive_status", com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r2.i).J0().q(r2.i));
        if (r2.m == false) goto L19;
        r8 = "1";
    L19:
        r0.put("is_from_shopping_guide", r8);
        r0.put("shopping_guide_id", r2.n);
        r0.put("is_vr_machine", VrUtils.o(r2.i));
        r0.put("room_orientation", r9);
        r0.put("enter_from", "share_panel");
        if (r7 != null) goto L22;
    L35:
        com.bytedance.android.livesdk.log.u.l().sendLog("share", r0, new Object[]{new am2.x(), Room.class, am2.n.f()});
        return;
    L22:
        if (r7.containsKey("locallife_live_params") == false) goto L35;
        String r11 = (String) r7.get("locallife_live_params");
        Room r12 = r2.a;
        HashMap r13 = new HashMap();
        if (TextUtils.isEmpty(r11) == true) goto L34;
        if (r12 != null) goto L38;
    L27:
        String r14 = new JSONObject(r11).optString("share_info");     // Catch: Exception -> L37
        if (TextUtils.isEmpty(r14) == true) goto L34;
        Map r15 = jc1.k.f(ILiveShareService.class).getLocalLifeShareParams(r14);     // Catch: Exception -> L37
        if (r15.isEmpty() == true) goto L33;
        r13.putAll(r15);     // Catch: Exception -> L37
    L33:
        com.bytedance.android.livesdk.chatroom.c1 r16 = (com.bytedance.android.livesdk.chatroom.c1) GsonHelper.get().fromJson(r14, com.bytedance.android.livesdk.chatroom.c1.class);     // Catch: Exception -> L37
        goto L34
    L38:
        r13.put("life_share_id", r12.lifeShareId);     // Catch: Exception -> L37
    L34:
        r0.putAll(r13);
        goto L35
    L15:
        r10 = "0";
        goto L16
    L11:
        r9 = "0";
        goto L13
    }
}
