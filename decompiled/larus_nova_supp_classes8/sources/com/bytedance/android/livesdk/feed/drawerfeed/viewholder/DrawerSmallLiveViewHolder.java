package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.FollowInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.config.bp;
import com.bytedance.android.livesdk.config.jr;
import com.bytedance.android.livesdk.feed.drawerfeed.widget.FixedRatioRelativeLayout;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.widget.DrawLiveCoverOptView;
import com.bytedance.android.livesdk.widget.LiveCoverOptView;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAppearance;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import j40.b4;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DrawerSmallLiveViewHolder extends DrawerCommonLiveViewHolder {
    public static int V = -1;
    public static int W = -1;
    public static int X = -1;
    public static final List<String> Y = null;
    public final ViewGroup J;
    public final ViewGroup K;
    public final ViewGroup L;
    public final ImageView M;
    public final TextView N;
    public final ViewGroup O;
    public boolean P;
    public Disposable Q;
    public final HSImageView R;
    public final View S;
    public j0 T;
    public final DrawLiveCoverOptView U;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ DrawerSmallLiveViewHolder a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public a(DrawerSmallLiveViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Disposable r3 = this.a.Q;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.isDisposed() == true) goto L9;
            this.a.Q.dispose();
            this.a.Q = null;
            return;
        }
    }

    public class b implements Observer<FollowPair> {
        public final /* synthetic */ Room a;
        public final /* synthetic */ DrawerSmallLiveViewHolder b;

        public final void onComplete() {
        }

        public final void onError(Throwable r2) {
            f2.b(2131916613, 0);
        }

        public final void onNext(Object r5) {
            FollowPair r6 = (FollowPair) r5;
            DrawerSmallLiveViewHolder r7 = this.b;
            int r0 = DrawerSmallLiveViewHolder.V;
            r7.b.e(r7.c, String.valueOf(this.a.getId()));
            DrawerSmallLiveViewHolder r8 = this.b;
            if (r8.n == null) goto L7;
            com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
            String r1 = r8.V3();
            String r2 = r8.i4();
            HashMap r3 = new HashMap();
            r3.put("enter_from_merge", r1);
            r3.put("enter_method", r2);
            r3.put("action_type", "click");
            r3.put("request_page", "long_press");
            r3.put("to_user_id", String.valueOf(r8.n.getOwnerUserIdString()));
            r3.put("event_page", "live_cover");
            r3.putAll(r8.j4());
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_unfollow", r3, new Object[]{Room.class, am2.n.f()});
            return;
        }

        public final void onSubscribe(Disposable r2) {
            if (r2 == null) goto L5;
            this.b.register(r2);
            return;
        }

        public b(DrawerSmallLiveViewHolder r1, Room r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public String k4() {
        return "";
    }

    static {
        Y = Arrays.asList(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public String V3() {
        com.bytedance.android.livesdk.feed.h r0 = this.m;
        if (r0 == null) goto L13;
        if (r0.wg() == null) goto L13;
        String r1 = this.m.wg().j();
        String r2 = this.m.wg().e();
        if (TextUtils.isEmpty(r1) == true) goto L10;
        return r1;
    L10:
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return r2;
    L13:
        if (Y.contains(super.V3()) == false) goto L17;
        return "drawer_follow";
    L17:
        if (TextUtils.equals(super.V3(), "homepage_fresh") == false) goto L20;
        return "drawer_city";
    L20:
        return "drawer_hot";
    }

    public String i4() {
        if (this.G == false) goto L6;
        return "drawer_cell";
    L6:
        return "drawer_cover";
    }

    public HashMap<String, String> j4() {
        HashMap<String, String> r0 = new HashMap();
        if (TTLiveService.getLiveService() == null) goto L5;
        String r1 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
    L6:
        r0.put("drawer_page", r1);
        Room r2 = this.n;
        if (r2 != null) goto L9;
    L20:
        return r0;
    L9:
        if (r2.isMergeVSRoom() == false) goto L20;
        LiveVSLog.r.getClass();
        r0.putAll(LiveVSLog.b.a(r2).a());
        Activity r3 = bz2.b.a(((RecyclerView.ViewHolder) this).itemView.getContext());
        if (r3 == null) goto L20;
        if (r3.getRequestedOrientation() != 0) goto L15;
    L18:
        String r4 = "landscape";
    L19:
        r0.put("vs_screen_type", r4);
        goto L20
    L15:
        if (r3.getRequestedOrientation() == 6) goto L18;
        r4 = "portrait";
        goto L19
    L5:
        r1 = "";
        goto L6
    }

    public boolean r4() {
        if (jr.a.getValue().booleanValue() == true) goto L6;
        return false;
    L6:
        if (TTLiveService.getLiveService() != null) goto L8;
    L11:
        return false;
    L8:
        if (TTLiveService.getLiveService().getLiveOntologyRecord() == null) goto L11;
        String r0 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
        TTLiveService.getLiveService().getLiveOntologyRecord().getEnterMethod();
        return bx1.a.a(r0);
    }

    public static Boolean n4() {
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L7;
        return Boolean.FALSE;
    L7:
        return Boolean.valueOf(e5.n());
    }

    public boolean m4() {
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getLiveOntologyRecord() == null) goto L10;
        String r1 = TTLiveService.getLiveService().getLiveOntologyRecord().getReqFrom();
        return Y.contains(r1);
    L10:
        return false;
    }

    public final void unbind() {
        super.unbind();
        j0 r0 = this.T;
        if (r0 == null) goto L7;
        ViewGroup r1 = this.J;
        if (r1 == null) goto L7;
        r1.removeOnLayoutChangeListener(r0);
    L7:
        this.T = null;
    }

    public static Activity l4(View r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Context r3 = r2.getContext();
        if (r3 != null) goto L9;
        return null;
    L9:
        if ((r3 instanceof ContextWrapper) == false) goto L15;
        if ((r3 instanceof Activity) == true) goto L13;
        r3 = ((ContextWrapper) r3).getBaseContext();
        goto L9
    L13:
        return (Activity) r3;
    L15:
        return null;
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void c4(FeedItem r7) {
        if (r7 != null) goto L4;
    L11:
        Bundle r0 = new Bundle();
        r0.putLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", System.currentTimeMillis());
        String r1 = this.c.b;
        if (r1.contains("live") == false) goto L16;
        com.bytedance.android.livesdk.feed.feed.e r3 = this.h;
        if (r3 == null) goto L16;
        r1 = r3.e();
    L16:
        r0.putString("source", r1);
        Bundle r4 = new Bundle();
        r4.putString("live_source", "live_small_picture");
        r4.putString("subtab", r1);
        Map<String, String> r2 = this.k;
        String r5 = "";
        if (r2 != null) goto L19;
    L22:
        String r6 = "";
    L23:
        r4.putString("pull_type", r6);
        if (TextUtils.isEmpty(this.k.get("cover_content_category")) == true) goto L26;
        r4.putString("cover_content_category", this.k.get("cover_content_category"));
    L26:
        r0.putBundle("live.intent.extra.ENTER_LIVE_EXTRA_V1", r4);
        r0.putString("log_pb", r7.logPb);
        r0.putString("request_id", r7.resId);
        r0.putInt(VSConstants.EXTRA_ITEM_TYPE, r7.type);
        r0.putString("enter_from", "live");
        com.bytedance.android.livesdk.feed.feed.e r8 = this.h;
        if (r8 == null) goto L29;
        r0.putLong("live.intent.extra.USER_FROM", r8.l());
    L29:
        r0.putString("enter_from_merge", V3());
        r0.putString("enter_method", i4());
        r0.putInt("live.intent.extra.ENTER_LIVE_ORDER", this.o);
        if (r7.isRecommendCard == false) goto L33;
        r0.putString("enter_from_merge_recommend", "pop_card");
    L33:
        if (TextUtils.isEmpty(r7.liveReason) == true) goto L36;
        r0.putString("live_reason", r7.liveReason);
    L36:
        if (r7.getRoom() == null) goto L41;
        if (TextUtils.isEmpty(r7.getRoom().getItemExplicitInfo()) == true) goto L41;
        r0.putString("live_recommend_info", r7.getRoom().getItemExplicitInfo());
    L41:
        if (TTLiveService.getLiveService() == null) goto L43;
        r5 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();
    L43:
        r0.putString("drawer_page", r5);
        r0.putString("drawer_inner_req_from", k4());
        if (r7.getRoom() != null) goto L46;
    L48:
        Y3(r7, false, "small_picture", r0);
        return;
    L46:
        if (r7.getRoom().getContentLabel() == null) goto L48;
        r0.putString("drawer_room_icon_type", String.valueOf(r7.getRoom().getContentLabel().getImageType()));
        goto L48
    L19:
        if (TextUtils.isEmpty(r2.get("pull_type")) == true) goto L22;
        r6 = this.k.get("pull_type");
        goto L23
    L4:
        if (r7.getRoom() == null) goto L11;
        HashMap<String, String> r9 = j4();
        com.bytedance.android.livesdk.log.filter.o r10 = com.bytedance.android.livesdk.log.u.l().c(am2.o.class);
        if (r10 == null) goto L11;
        if (r10.getMap() == null) goto L11;
        r10.getMap().putAll(r9);
        am2.o r11 = new am2.o();
        r11.a = r7.getRoom().getId();
        r10.setData(r11);
        goto L11
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void d4(ImageModel r2) {
        if (r2 != null) goto L4;
        q4(0, 0);
        return;
    L4:
        q4(r2.width, r2.height);
    }

    public final void g4(boolean r9) {
        if (r9 == true) goto L5;
        UIUtils.setViewVisibility(this.K, 8);
        this.P = false;
        UIUtils.setViewVisibility(this.U, 0);
        return;
    L5:
        if (this.n == null) goto L12;
        com.bytedance.android.livesdk.log.filter.o r10 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r3 = V3();
        String r4 = i4();
        if (r10.getMap().containsKey("action_type") == false) goto L10;
        String r11 = (String) r10.getMap().get("action_type");
    L11:
        HashMap r5 = new HashMap();
        r5.put("enter_from_merge", r3);
        r5.put("enter_method", r4);
        r5.put("action_type", r11);
        r5.put("event_page", "live_cover");
        r5.putAll(j4());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_click_trans_layer", r5, new Object[]{Room.class});
        goto L12
    L10:
        r11 = "";
    L12:
        this.P = true;
        UIUtils.setViewVisibility(this.K, 0);
        UIUtils.setViewVisibility(this.O, 8);
        UIUtils.setViewVisibility(this.U, 8);
    }

    public final void h4(final Room r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        register(this.a.a(r8.getId(), r8.getOwnerUserIdString(), r8.getRequestId(), V3(), i4()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g0(this, r8), new h0(this)));
    }

    public final void s4(Room r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getBaseOwner() == null) goto L12;
        FollowInfo r0 = r5.getBaseOwner().getFollowInfo();
        if (r0 == null) goto L9;
        r0.getFollowStatus();
    L9:
        com.bytedance.android.livesdk.user.f r1 = jc1.k.f(IUserService.class).user();
        com.bytedance.android.livesdk.user.n.b r2 = new com.bytedance.android.livesdk.user.n.b();
        l4(((RecyclerView.ViewHolder) this).itemView);
        com.bytedance.android.livesdk.user.n.b r3 = r2.f(r5.getId()).c(r5.getOwnerUserIdString()).e(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.LIVE_DRAWER));
        r3.getClass();
        r1.G(new com.bytedance.android.livesdk.user.n(r3)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r5));
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void X3(Room r11, Map<String, String> r12) {
        ((HashMap) r12).putAll(j4());
        String r0 = jc1.k.f(IHostBusiness.class).createBtmId(jc1.k.f(IHostBusiness.class).getBtmIdByWidget("livesdk_live_drawer_widget"), this.O);
        if (r0.isEmpty() == true) goto L5;
        ((HashMap) r12).put("btm_id", r0);
    L5:
        super.X3(r11, r12);
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.getBaseOwner() != null) goto L11;
        String r13 = "0";
    L12:
        HashMap r1 = new HashMap();
        r1.put("enter_from_merge", V3());
        r1.put("enter_method", i4());
        r1.put("anchor_id", r13);
        r1.put("request_id", r11.getRequestId());
        r1.put("room_id", String.valueOf(r11.getId()));
        r1.put("action_type", "click");
        JSONObject r14 = new JSONObject();
        String r5 = "";
        if (this.U.getStyle() != 0) goto L33;
    L30:
        e = move-exception;
        e.printStackTrace();
    L92:
        r1.put("basic_info", r14.toString());
        r1.putAll(j4());
        com.bytedance.android.livesdk.log.u.l().sendLog("live_cover_info", r1, new Object[0]);
        return;
    L15:
        if (r11.getBaseOwner() != null) goto L17;
        String r2 = "";
    L18:
        r14.put("location", r2);     // Catch: Exception -> L30
        if (b4() == true) goto L22;
        r5 = r11.getLiveHashTagJson();     // Catch: Exception -> L30
    L22:
        r14.put("challenge_info", r5);     // Catch: Exception -> L30
        if (r11.isMediaRoom() == true) goto L25;
    L27:
        long r3 = r11.getUserCount();     // Catch: Exception -> L30
    L28:
        r14.put("user_count", r3);     // Catch: Exception -> L30
        goto L92
    L25:
        if (r11.getStats() == null) goto L27;
        r3 = r11.getStats().getTotalUser();     // Catch: Exception -> L30
        goto L28
    L17:
        r2 = r11.getBaseOwner().getCity();     // Catch: Exception -> L30
        goto L18
    L33:
        if (this.U.getStyle() != 1) goto L61;
    L52:
        e = move-exception;
        e.printStackTrace();
    L55:
        if (r11.getContentLabel() == null) goto L58;
        r1.put("main_info", String.valueOf(r11.getContentLabel().getImageType()));
    L58:
        if (r11.getOperationLabel() == null) goto L92;
        r1.put("sub_info", String.valueOf(r11.getOperationLabel().getImageType()));
        goto L92
    L35:
        if (b4() == false) goto L37;
        String r4 = "";
    L38:
        r14.put("challenge_info", r4);     // Catch: Exception -> L52
        if (b4() == true) goto L41;
    L43:
        r5 = r11.getContentTag();     // Catch: Exception -> L52
    L44:
        r14.put("content_tag", r5);     // Catch: Exception -> L52
        if (r11.isMediaRoom() == true) goto L47;
    L49:
        long r6 = r11.getUserCount();     // Catch: Exception -> L52
    L50:
        r14.put("user_count", r6);     // Catch: Exception -> L52
        goto L55
    L47:
        if (r11.getStats() == null) goto L49;
        r6 = r11.getStats().getTotalUser();     // Catch: Exception -> L52
        goto L50
    L41:
        if (r11.getLiveHashTagInfo() == null) goto L43;
    L37:
        r4 = r11.getLiveHashTagJson();     // Catch: Exception -> L52
        goto L38
    L61:
        if (this.U.getStyle() != 2) goto L92;
    L84:
        e = move-exception;
        e.printStackTrace();
    L87:
        if (r11.getContentLabel() == null) goto L90;
        r1.put("main_info", String.valueOf(r11.getContentLabel().getImageType()));
    L90:
        if (r11.getOperationLabel() == null) goto L92;
        r1.put("sub_info", String.valueOf(r11.getOperationLabel().getImageType()));
        goto L92
    L63:
        if (r11.getBaseOwner() != null) goto L65;
        String r7 = "";
    L66:
        r14.put("location", r7);     // Catch: Exception -> L84
        if (b4() == false) goto L69;
        String r8 = "";
    L70:
        r14.put("challenge_info", r8);     // Catch: Exception -> L84
        if (b4() == true) goto L73;
    L75:
        r5 = r11.getContentTag();     // Catch: Exception -> L84
    L76:
        r14.put("content_tag", r5);     // Catch: Exception -> L84
        if (r11.isMediaRoom() == true) goto L79;
    L81:
        long r9 = r11.getUserCount();     // Catch: Exception -> L84
    L82:
        r14.put("user_count", r9);     // Catch: Exception -> L84
        goto L87
    L79:
        if (r11.getStats() == null) goto L81;
        r9 = r11.getStats().getTotalUser();     // Catch: Exception -> L84
        goto L82
    L73:
        if (r11.getLiveHashTagInfo() == null) goto L75;
    L69:
        r8 = r11.getLiveHashTagJson();     // Catch: Exception -> L84
        goto L70
    L65:
        r7 = r11.getBaseOwner().getCity();     // Catch: Exception -> L84
        goto L66
    L11:
        r13 = r11.getBaseOwner().getIdString();
        goto L12
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void a4(ImageModel r3, Room r4) {
        if (b4.a() == false) goto L7;
        j0 r0 = new j0(this, r3);
        this.T = r0;
        ViewGroup r1 = this.J;
        if (r1 == null) goto L7;
        r1.addOnLayoutChangeListener(r0);
    L7:
        q4(r3.getWidth(), r3.getHeight());
        super.a4(r3, r4);
    }

    public final void q4(int r3, int r4) {
        if (n4().booleanValue() == false) goto L5;
        int r0 = W;
    L6:
        V = r0;
        V = (this.J.getMeasuredWidth() - 3) / 2;
        if (n4().booleanValue() == false) goto L9;
        W = V;
    L10:
        if (r3 <= 0) goto L14;
        if (r4 <= 0) goto L14;
        int r5 = (int) (V / 0.7619048f);
    L15:
        ViewGroup.LayoutParams r6 = this.s.getLayoutParams();
        int r1 = r6.width;
        int r2 = V;
        if (r1 == r2) goto L18;
    L20:
        r6.width = r2;
        r6.height = r5;
        this.s.setLayoutParams(r6);
        return;
    L18:
        if (r6.height != r5) goto L20;
        return;
    L14:
        r5 = V;
        goto L15
    L9:
        X = V;
        goto L10
    L5:
        r0 = X;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerCommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public void U3(FeedItem r9, final Room r10, int r11) {
        super.U3(r9, r10, r11);
        e4(this.w, 8);
        if (r10.isMediaRoom() == false) goto L9;
        e4(this.x, 8);
        User r12 = r10.getBaseOwner();
        if (r12 == null) goto L9;
        if (TextUtils.isEmpty(r12.getRealNickName()) == true) goto L9;
        e4(this.r, 0);
        this.r.setText(r12.getRealNickName());
    L9:
        ((RecyclerView.ViewHolder) this).itemView.setOnLongClickListener(new y(this, r10));
        this.K.setVisibility(8);
        TTLiveService.getLiveService().getLiveOntologyRecord().getReqFrom();
        this.K.setOnClickListener(new z(this));
        if (m4() == false) goto L12;
        this.M.setImageResource(2131252307);
        this.N.setText(2131916631);
        this.M.setOnClickListener(new a0(this, r10));
        this.N.setOnClickListener(new b0(this, r10));
    L13:
        this.N.setImportantForAccessibility(4);
        this.M.setImportantForAccessibility(4);
        this.L.setContentDescription(this.N.getText() + ((RecyclerView.ViewHolder) this).itemView.getContext().getString(2131916301));
        Disposable r13 = this.Q;
        if (r13 != null) goto L16;
    L18:
        Disposable r14 = xs2.b.a().b(yv1.a.class).subscribe(new e0(this, r10), new f0());
        this.Q = r14;
        if (r14 == null) goto L21;
        register(r14);
    L21:
        UIUtils.setViewVisibility(this.t, 8);
        UIUtils.setViewVisibility(this.O, 8);
        this.U.setVisibility(0);
        this.U.c(r10);
        ((RecyclerView.ViewHolder) this).itemView.addOnAttachStateChangeListener(new a(this));
        if (r4() == false) goto L30;
        if (TextUtils.isEmpty(r10.getDistanceKm()) == true) goto L30;
        DrawLiveCoverOptView r15 = this.U;
        r15.getClass();
        String r3 = r10.getDistanceKm();
        if (TextUtils.isEmpty(r3) == true) goto L28;
        ((LiveCoverOptView) r15).l.setText(r3);
        ((LiveCoverOptView) r15).l.setVisibility(0);
        ((LiveCoverOptView) r15).d.setMaxEms(4);
    L28:
        ((LiveCoverOptView) r15).m.setVisibility(8);
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ((LiveCoverOptView) r15).g.getLayoutParams();
        r4.bottomMargin = s1.f(6.0f);
        ((LiveCoverOptView) r15).g.setLayoutParams(r4);
    L30:
        if (f4() == false) goto L47;
        DrawLiveCoverOptView r16 = this.U;
        r16.getClass();
        String r5 = r10.getDistanceKm();
        int r6 = bp.a.getValue().intValue();
        ((LiveCoverOptView) r16).l.setTypeface(Typeface.defaultFromStyle(1));
        if (r6 != 3) goto L35;
        ((LiveCoverOptView) r16).l.setVisibility(8);
        ((LiveCoverOptView) r16).m.setVisibility(0);
        ((LiveCoverOptView) r16).d.setMaxEms(8);
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ((LiveCoverOptView) r16).g.getLayoutParams();
        r1.bottomMargin = 0;
        ((LiveCoverOptView) r16).g.setLayoutParams(r1);
    L46:
        this.U.e(r10, false);
    L48:
        View r17 = this.S;
        if (r17 == null) goto L51;
        r17.setVisibility(0);
    L51:
        DrawLiveCoverOptView r18 = this.U;
        if (r18 == null) goto L57;
        ViewGroup r19 = ((LiveCoverOptView) r18).n;
        if (r19 == null) goto L57;
        r19.setBackgroundResource(2131249018);
    L57:
        if (this.R == null) goto L77;
        RoomAppearance r20 = r10.appearance;
        if (r20 != null) goto L62;
    L72:
        this.R.setVisibility(8);
        return;
    L62:
        if (r20.getCoverDynamicMask() == null) goto L72;
        this.R.setVisibility(0);
        ImageLoader.d r21 = ImageLoader.load(r10.appearance.getCoverDynamicMask());
        r21.e = new i0(this);
        r21.f = true;
        r21.a(this.R);
        View r22 = this.S;
        if (r22 == null) goto L67;
        r22.setVisibility(8);
    L67:
        DrawLiveCoverOptView r23 = this.U;
        if (r23 == null) goto L74;
        ViewGroup r24 = ((LiveCoverOptView) r23).n;
        if (r24 == null) goto L75;
        r24.setBackground(null);
        return;
    L75:
        return;
    L74:
        return;
    L77:
        return;
    L35:
        if (r6 != 2) goto L42;
        if (TextUtils.isEmpty(r5) == true) goto L39;
        ((LiveCoverOptView) r16).l.setText(r5);
        ((LiveCoverOptView) r16).l.setVisibility(0);
        ((LiveCoverOptView) r16).d.setMaxEms(4);
    L40:
        ((LiveCoverOptView) r16).m.setVisibility(8);
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ((LiveCoverOptView) r16).g.getLayoutParams();
        r2.bottomMargin = s1.f(6.0f);
        ((LiveCoverOptView) r16).g.setLayoutParams(r2);
        goto L46
    L39:
        ((LiveCoverOptView) r16).l.setVisibility(8);
        ((LiveCoverOptView) r16).d.setMaxEms(8);
        goto L40
    L42:
        if (TextUtils.isEmpty(r5) == true) goto L44;
        ((LiveCoverOptView) r16).i.setText(r5);
    L45:
        ((LiveCoverOptView) r16).d.setMaxEms(8);
        ((LiveCoverOptView) r16).l.setVisibility(8);
        ((LiveCoverOptView) r16).m.setVisibility(0);
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) ((LiveCoverOptView) r16).g.getLayoutParams();
        r7.bottomMargin = 0;
        ((LiveCoverOptView) r16).g.setLayoutParams(r7);
        goto L46
    L44:
        ((LiveCoverOptView) r16).i.setVisibility(8);
        goto L45
    L47:
        this.U.e(r10, true);
        goto L48
    L16:
        if (r13.isDisposed() == true) goto L18;
        this.Q.dispose();
        goto L18
    L12:
        this.M.setImageResource(2131250342);
        this.N.setText(2131916575);
        this.M.setOnClickListener(new c0(this, r10));
        this.N.setOnClickListener(new d0(this, r10));
        goto L13
    }

    public DrawerSmallLiveViewHolder(View r13, tv1.c r14, com.bytedance.android.livesdk.feed.f r15, FeedDataKey r16, com.bytedance.android.livesdk.feed.j r17, ILiveRoomListDataSource r18, PublishSubject r19, PublishSubject r20, ViewGroup r21, Map r22, com.bytedance.android.livesdk.feed.h r23) {
        super(r13, r14, r15, r16, r17, r18, r19, r20, r23);
        this.P = false;
        this.J = r21;
        this.K = (ViewGroup) r13.findViewById(2131369147);
        this.M = (ImageView) r13.findViewById(2131376181);
        this.N = (TextView) r13.findViewById(2131390514);
        this.L = (ViewGroup) r13.findViewById(2131369145);
        this.O = (ViewGroup) r13.findViewById(2131367812);
        DrawLiveCoverOptView r0 = r13.findViewById(2131378272);
        this.U = r0;
        FixedRatioRelativeLayout r1 = (FixedRatioRelativeLayout) r13.findViewById(2131370245);
        this.R = r13.findViewById(2131378267);
        this.S = r13.findViewById(2131378297);
        this.k = r22;
        r1.setRatio(0.7619048f);
        if (n4().booleanValue() == false) goto L6;
        r0.a();
        return;
    }
}
