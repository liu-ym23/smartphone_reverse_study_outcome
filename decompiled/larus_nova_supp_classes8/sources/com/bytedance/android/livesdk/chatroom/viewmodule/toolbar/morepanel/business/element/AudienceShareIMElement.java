package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMContact;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMShareContactType;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.model.ShopGuideApi;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.a5;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.i5;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.z4;
import com.bytedance.android.livesdk.config.xl;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.g4;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class AudienceShareIMElement extends BaseElement<ip1.d> {
    public final ElementType c;
    public boolean d;
    public ViewGroup e;
    public ViewGroup f;
    public View g;
    public View h;
    public View i;
    public ViewGroup j;
    public ViewGroup k;
    public final CompositeDisposable l;
    public Map<String, String> m;
    public long n;
    public final Lazy o;
    public final jp1.b p;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final void f() {
        this.d = true;
    }

    @Override // kp1.b
    public final void i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final Integer k() {
        return null;
    }

    @Override // kp1.b
    public final void release() {
        this.d = false;
        this.m = null;
        this.n = 0;
        this.l.clear();
    }

    public final DataCenter p() {
        return this.p.getDataCenter();
    }

    public final Room q() {
        RoomContext r0 = this.p.a();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        return (Room) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.c;
    }

    public AudienceShareIMElement(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
        this.p = r2;
        this.c = ElementType.ShareIM;
        this.l = new CompositeDisposable();
        this.o = LazyKt.lazy(AudienceShareIMElement$disableIMTitle$2.INSTANCE);
    }

    public static final void o(AudienceShareIMElement r6) {
        r6.getClass();
        if ((System.currentTimeMillis() - r6.n) < 2000) goto L21;
        r6.n = System.currentTimeMillis();
        Room r0 = r6.q();
        if (r0 == null) goto L22;
        long r1 = r0.id;
        Room r2 = r6.q();
        if (r2 == null) goto L9;
        String r3 = r2.getLabels();
    L10:
        HashMap r4 = new HashMap();
        com.bytedance.android.livesdk.share.e.a.getClass();
        String r5 = String.valueOf(com.bytedance.android.livesdk.share.e.a.b("chat_merge"));
        if (TextUtils.isEmpty(r5) == true) goto L13;
        r4.put("target_id", r5);
    L13:
        String r7 = String.valueOf(1);
        if (TextUtils.isEmpty(r7) == true) goto L16;
        r4.put("share_type", r7);
    L16:
        String r8 = String.valueOf(r3);
        if (TextUtils.isEmpty(r8) == true) goto L19;
        r4.put("common_label_list", r8);
    L19:
        com.bytedance.android.livesdk.service.l.d().getClass();
        ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).sendShare(r1, r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(r6.p.a(), r6.p()));
        return;
    L9:
        r3 = null;
        goto L10
    L22:
        return;
    }

    @Override // kp1.b
    public final void h(lp1.b r19) {
        ip1.d r1 = (ip1.d) r19;
        Intrinsics.checkNotNullParameter(r1, "model");
        if (this.d == true) goto L69;
        ViewGroup r2 = this.e;
        if (r2 == null) goto L70;
        ViewGroup r3 = this.f;
        if (r3 == null) goto L71;
        r2.removeAllViews();
        r3.removeAllViews();
        Activity r4 = ContextUtil.contextToActivity(r2.getContext());
        if (r4 == null) goto L72;
        int r6 = (int) ToolbarButton.IM_LIST_VIRTUAL.getId();
        if (r6 == (-1)) goto L65;
        ArrayList<T> r5 = r1.a;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r8 = r5.iterator();
    L18:
        if (r8.hasNext() == false) goto L21;
        r7.add(Integer.valueOf(((lp1.a) r8.next()).getButton().g));
        goto L18
    L21:
        if (r7.contains(Integer.valueOf(r6)) == false) goto L66;
        c0.b r9 = y3.f(p()).t(ToolbarButton.SHARE);
        if ((r9 instanceof e5) == true) goto L25;
        r9 = null;
    L25:
        final e5 r10 = (e5) r9;
        if (r10 != null) goto L38;
        c0 r11 = y3.m(p());
        if ((r11 instanceof x3) == true) goto L30;
        r11 = null;
    L30:
        x3 r12 = (x3) r11;
        if (r12 == null) goto L33;
        c0.b r13 = r12.t(ToolbarButton.SHARE);
    L35:
        if ((r13 instanceof e5) == true) goto L37;
        r13 = null;
    L37:
        r10 = (e5) r13;
        goto L38
    L33:
        r13 = null;
    L38:
        if (r10 != null) goto L40;
        ALogger.e("MoreMixSharePanel", "IM toolbarShareBehavior is null");
        Single r14 = null;
    L59:
        if (r14 == null) goto L67;
        Disposable r15 = r14.subscribe(new m(this, r4, r2, r3), n.a);
        if (r15 == null) goto L68;
        RxUtilKt.c(r15, this.l);
        return;
    L68:
        return;
    L67:
        return;
    L40:
        RoomContext r16 = r10.f;
        if (r16 == null) goto L43;
        r10.a = (Room) r16.getRoom().getValue();
        r10.d = (User) r10.f.getUser().getValue();
    L43:
        Room r17 = r10.a;
        if (r17 != null) goto L47;
        Single r18 = Single.error(new Exception("room is null"));
    L46:
        r14 = r18;
        goto L59
    L47:
        final ShareParams.Builder r20 = ShareParams.buildUponRoom(r17);
        if (xl.a.getValue().booleanValue() == false) goto L50;
        String r110 = jc1.k.f(IHostBusiness.class).getBcmChainInfo();
    L51:
        String r111 = (String) r10.i.get("log_action_type", "");
        final HashMap<String, String> r21 = new HashMap();
        if (e5.b() == false) goto L58;
        String r112 = g4.e();
        String r113 = g4.d();
        long r22 = z.o(r10.i).getId();
        String r114 = z.o(r10.i).getOwnerUserIdString();
        String r115 = r10.a.lifeShareId;
        Intrinsics.checkNotNullParameter(r114, "userId");
        com.bytedance.android.livesdk.service.l.d().getClass();
        ShopGuideApi r23 = (ShopGuideApi) com.bytedance.android.live.network.c.b().e(ShopGuideApi.class);
        if (r23 == null) goto L56;
        Single r24 = r23.queryShopGuideId(r22, r114, r110, r115, "livebroadcasting", r112, r113, r111);
    L57:
        r18 = r24.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorReturn(new z4()).doOnSuccess(new i5(r21, r20)).map(new a5(r10, r20, r21));
        goto L46
    L56:
        r24 = null;
        goto L57
    L58:
        r18 = Single.just(r10.e(r20, r21).build());
        goto L46
    L50:
        r110 = null;
        goto L51
    L66:
        return;
    L65:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final View j(ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r9, "parent");
        LayoutInflater r0 = LayoutInflater.from(r9.getContext());
        if (((Boolean) this.o.getValue()).booleanValue() == false) goto L5;
        int r1 = 2131566996;
    L6:
        int r2 = 0;
        View r10 = r0.inflate(r1, r9, false);
        if (r10 == null) goto L9;
        ViewGroup r3 = (ViewGroup) r10.findViewById(2131386082);
    L10:
        this.j = r3;
        if (r10 == null) goto L17;
        LinearLayout r4 = (LinearLayout) r10.findViewById(2131382404);
        if (r4 == null) goto L17;
        this.k = r4;
        int r5 = s1.y() - UtilityKotlinExtentionsKt.i(10);
        int r6 = UtilityKotlinExtentionsKt.i(68);
        int r7 = UtilityKotlinExtentionsKt.i(12);
        int r8 = (int) ((((double) (r5 + r7)) / ((double) (r6 + r7))) + 1.0d);
    L15:
        if (r2 >= r8) goto L17;
        r0.inflate(2131566997, r4, true);
        r2 = r2 + 1;
    L17:
        return r10;
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = 2131566995;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final void l(View r2) {
        Intrinsics.checkNotNullParameter(r2, "elementView");
        if (this.e != null) goto L6;
        this.e = (ViewGroup) r2.findViewById(2131386077);
    L6:
        if (this.f != null) goto L9;
        this.f = (ViewGroup) this.p.findView(2131374925);
    L9:
        if (this.g != null) goto L12;
        this.g = this.p.findView(2131374927);
    L12:
        if (this.h != null) goto L15;
        this.h = this.p.findView(2131374926);
    L15:
        if (this.i != null) goto L18;
        this.i = this.p.findView(2131380317);
        return;
    }

    public static final void n(AudienceShareIMElement r10, List r11) {
        r10.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        Long r2 = null;
        if (r11.isEmpty() == false) goto L5;
        r10.r(com.bytedance.android.livesdk.locallife.g.a(r10.q(), null), r10.m);
    L24:
        if (c1.b(r10.p()) == false) goto L50;
        JSONObject r12 = new JSONObject();
        Room r7 = r10.q();     // Catch: JSONException -> L38
        if (r7 == null) goto L31;
        IUser r8 = r7.author();     // Catch: JSONException -> L38
        if (r8 == null) goto L31;
        String r9 = r8.getIdString();     // Catch: JSONException -> L38
    L32:
        r12.put("anchor_id", r9);     // Catch: JSONException -> L38
        Room r13 = r10.q();     // Catch: JSONException -> L38
        if (r13 == null) goto L35;
        Long r14 = Long.valueOf(r13.id);     // Catch: JSONException -> L38
    L36:
        r12.put("room_id", String.valueOf(r14));     // Catch: JSONException -> L38
    L40:
        k1.f(r12);
        ILiveDouPlusService r15 = jc1.k.f(ILiveDouPlusService.class);
        if (r15 == null) goto L50;
        HashMap r16 = new HashMap();
        r16.put("ad_extra_data", r12.toString());
        Map r17 = c1.e(r10.p());
        if (r17 != null) goto L45;
    L48:
        r15.logEvent(true, "live_ad", "live_share", r16);
        goto L50
    L45:
        if (r17.isEmpty() == true) goto L48;
        r16.putAll(r17);
        goto L48
    L35:
        r14 = null;
    L31:
        r9 = null;
    L38:
        e = move-exception;
        e.printStackTrace();
    L50:
        if (c1.c(r10.p()) == false) goto L81;
        JSONObject r18 = new JSONObject();
        Room r19 = r10.q();     // Catch: JSONException -> L63
        if (r19 == null) goto L57;
        IUser r20 = r19.author();     // Catch: JSONException -> L63
        if (r20 == null) goto L57;
        String r21 = r20.getIdString();     // Catch: JSONException -> L63
    L58:
        r18.put("anchor_id", r21);     // Catch: JSONException -> L63
        Room r6 = r10.q();     // Catch: JSONException -> L63
        if (r6 == null) goto L61;
        r2 = Long.valueOf(r6.id);     // Catch: JSONException -> L63
    L61:
        r18.put("room_id", String.valueOf(r2));     // Catch: JSONException -> L63
    L65:
        k1.f(r18);
        ILiveDouPlusService r1 = jc1.k.f(ILiveDouPlusService.class);
        if (r1 == null) goto L82;
        HashMap r3 = new HashMap();
        r3.put("ad_extra_data", r18.toString());
        Map r110 = c1.f(r10.p());
        if (r110.isEmpty() == true) goto L71;
        r3.putAll(r110);
    L71:
        r1.logEvent(true, "live_ad", "live_share", r3);
        return;
    L82:
        return;
    L57:
        r21 = null;
    L63:
        e = move-exception;
        e.printStackTrace();
        goto L65
    L81:
        return;
    L5:
        Iterator r111 = r11.iterator();
    L7:
        if (r111.hasNext() == false) goto L24;
        LiveIMContact.LiveIMUser r4 = (LiveIMContact) r111.next();
        r0.clear();
        String r5 = "";
        if ((r4 instanceof LiveIMContact.LiveIMUser) == false) goto L16;
        LiveIMContact.LiveIMUser r22 = r4;
        String r23 = r22.getId();
        if (r23 == null) goto L14;
        r5 = r23;
    L14:
        r0.put("to_user_id", r5);
        r0.putAll(com.bytedance.android.livesdk.locallife.g.a(r10.q(), r22.getId()));
    L22:
        r10.r(r0, r10.m);
        goto L7
    L16:
        if ((r4 instanceof LiveIMContact.LiveConversation) == false) goto L22;
        String r24 = ((LiveIMContact.LiveConversation) r4).getConversationId();
        if (r24 == null) goto L21;
        r5 = r24;
    L21:
        r0.put("conversation_id", r5);
        r0.putAll(com.bytedance.android.livesdk.locallife.g.a(r10.q(), null));
        goto L22
    }

    public final void r(Map r7, Map r8) {
        HashMap r0 = new HashMap();
        r0.putAll(r7);
        r0.put("share_platform", "chat_merge");
        if (TextUtils.equals("chat_merge", "share_to_story") == false) goto L5;
        r0.put("share_platform", "share_to_diary");
    L5:
        r0.put("is_pyramid_sale", "0");
        r0.put("type", "link");
        r0.put("share_type", "link");
        r0.put("request_page", "live_room");
        DataCenter r9 = this.p.getDataCenter();
        Map r2 = null;
        if (r9 == null) goto L8;
        Boolean r10 = (Boolean) r9.get("data_is_portrait", Boolean.TRUE);
    L9:
        String r3 = "1";
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L12;
        Object r11 = "1";
    L14:
        if (com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(p()).isPaidLive() == true) goto L17;
        r3 = "0";
    L17:
        r0.put("is_paidlive", r3);
        r0.put("watch_paidlive_status", com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(p()).J0().q(p()));
        r0.put("is_from_shopping_guide", "0");
        r0.put("shopping_guide_id", "");
        r0.put("is_vr_machine", VrUtils.o(p()));
        r0.put("room_orientation", r11);
        if (r8 != null) goto L20;
    L47:
        r0.put("enter_from", "share_panel");
        com.bytedance.android.livesdk.log.u.l().sendLog("share", r0, new Object[]{new am2.x(), Room.class, am2.n.f()});
        return;
    L20:
        if (r8.containsKey("locallife_live_params") == false) goto L47;
        String r12 = (String) r8.get("locallife_live_params");
        Room r4 = q();
        HashMap r5 = new HashMap();
        if (r12 != null) goto L24;
    L27:
        boolean r6 = true;
    L28:
        if (r6 == true) goto L46;
        if (r4 != null) goto L50;
    L31:
        String r13 = new JSONObject(r12).optString("share_info");     // Catch: Exception -> L49
        if (TextUtils.isEmpty(r13) == true) goto L46;
        ILiveShareService r14 = jc1.k.f(ILiveShareService.class);     // Catch: Exception -> L49
        if (r14 == null) goto L37;
        r2 = r14.getLocalLifeShareParams(r13);     // Catch: Exception -> L49
    L37:
        if (r2 != null) goto L39;
    L42:
        boolean r15 = true;
    L43:
        if (r15 == true) goto L45;
        r5.putAll(r2);     // Catch: Exception -> L49
    L45:
        com.bytedance.android.livesdk.chatroom.c1 r16 = (com.bytedance.android.livesdk.chatroom.c1) GsonHelper.get().fromJson(r13, com.bytedance.android.livesdk.chatroom.c1.class);     // Catch: Exception -> L49
        goto L46
    L39:
        if (r2.isEmpty() == true) goto L42;
        r15 = false;
        goto L43
    L50:
        r5.put("life_share_id", r4.lifeShareId);     // Catch: Exception -> L49
    L46:
        r0.putAll(r5);
        goto L47
    L24:
        if (r12.length() == 0) goto L27;
        r6 = false;
        goto L28
    L12:
        r11 = "0";
        goto L14
    L8:
        r10 = null;
        goto L9
    }

    public static final void m(AudienceShareIMElement r2, LiveIMShareContactType r3, LiveIMContact r4, boolean r5) {
        r2.getClass();
        int r6 = e.a[r3.ordinal()];
        if (r6 == 1) goto L12;
        if (r6 != 2) goto L7;
        s(null, null, null, true, false);
        return;
    L7:
        if (r6 != 3) goto L22;
        s(null, null, null, false, true);
        return;
    L22:
        return;
    L12:
        if ((r4 instanceof LiveIMContact.LiveIMUser) == false) goto L15;
        s(Boolean.valueOf(r5), ((LiveIMContact.LiveIMUser) r4).getId(), null, false, false);
        return;
    L15:
        if ((r4 instanceof LiveIMContact.LiveConversation) == false) goto L21;
        s(Boolean.valueOf(r5), null, ((LiveIMContact.LiveConversation) r4).getConversationId(), false, false);
        return;
    }

    public static void s(Boolean r2, String r3, String r4, boolean r5, boolean r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r3 == null) goto L5;
        r0.put("to_user_id", r3);
    L5:
        if (r4 == null) goto L7;
        r0.put("conversation_id", r4);
    L7:
        if (r2 == null) goto L13;
        r2.booleanValue();
        if (r2.booleanValue() == false) goto L11;
        String r7 = "select";
    L12:
        r0.put("after_status", r7);
        goto L13
    L11:
        r7 = "cancel";
    L13:
        String r8 = "1";
        if (r5 == false) goto L16;
        Object r9 = "1";
    L17:
        r0.put("is_more_click", r9);
        if (r6 == true) goto L21;
        r8 = "0";
    L21:
        r0.put("is_recent_click", r8);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_share_panel_head_click", r0, new Object[]{Room.class, am2.x.class});
        return;
    L16:
        r9 = "0";
        goto L17
    }
}
