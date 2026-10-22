package com.bytedance.android.livesdk.feed.squarefeed.viewholder;

import am2.n;
import am2.x;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerSmallLiveViewHolder;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder;
import com.bytedance.android.livesdk.feed.openui.view.DouyinSmallLiveCardView;
import com.bytedance.android.livesdk.g;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import ww1.c;
import ww1.d;
import ww1.h;
import ww1.i;
import ww1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DouyinSmallLiveViewHolder extends CommonLiveViewHolder {
    public static final /* synthetic */ int K = 0;
    public final View D;
    public final DouyinSmallLiveCardView E;
    public final ViewGroup F;
    public final ImageView G;
    public final TextView H;
    public boolean I;
    public Disposable J;

    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ DouyinSmallLiveViewHolder a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public a(DouyinSmallLiveViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Disposable r3 = this.a.J;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.isDisposed() == true) goto L9;
            this.a.J.dispose();
            this.a.J = null;
            return;
        }
    }

    public class b implements Observer<FollowPair> {
        public final /* synthetic */ Room a;
        public final /* synthetic */ DouyinSmallLiveViewHolder b;

        public final void onComplete() {
        }

        public final void onError(Throwable r2) {
            f2.b(2131916613, 0);
        }

        public final void onNext(Object r6) {
            FollowPair r7 = (FollowPair) r6;
            DouyinSmallLiveViewHolder r8 = this.b;
            int r0 = DouyinSmallLiveViewHolder.K;
            r8.b.e(r8.c, String.valueOf(this.a.getId()));
            DouyinSmallLiveViewHolder r9 = this.b;
            if (r9.n == null) goto L7;
            o r1 = u.l().c(x.class);
            String r2 = r9.V3();
            String r3 = r9.h4();
            HashMap r4 = new HashMap();
            r4.put("enter_from_merge", r2);
            r4.put("enter_method", r3);
            r4.put("action_type", "click");
            r4.put("request_page", "long_press");
            r4.put("to_user_id", r9.n.getAnchorId());
            r4.put("event_page", "live_cover");
            r4.put("from_room_id", l0.a("from_room_id", r1));
            u.l().sendLog("livesdk_unfollow", r4, new Object[]{Room.class, n.f()});
            return;
        }

        public final void onSubscribe(Disposable r2) {
            if (r2 == null) goto L5;
            this.b.register(r2);
            return;
        }

        public b(DouyinSmallLiveViewHolder r1, Room r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final String V3() {
        return this.m.Sy();
    }

    public final String h4() {
        String r0 = this.m.getEnterMethod();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return "live_double_window";
    L6:
        return r0;
    }

    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void c4(FeedItem r7) {
        Bundle r0 = new Bundle();
        Bundle r1 = new Bundle();
        r1.putString("live_source", "live_small_picture");
        FeedDataKey r2 = this.c;
        if (r2 == null) goto L5;
        String r3 = r2.b;
    L7:
        if (r3.contains("live") == false) goto L13;
        e r4 = this.h;
        if (r4 == null) goto L13;
        r3 = r4.e();
        if (TextUtils.isEmpty(r3) == false) goto L13;
        r3 = "live_merge_null";
    L13:
        r1.putString("subtab", r3);
        r0.putString("source", r3);
        r0.putBundle("live.intent.extra.ENTER_LIVE_EXTRA_V1", r1);
        r0.putString("log_pb", r7.logPb);
        r0.putString("request_id", r7.resId);
        e r5 = this.h;
        if (r5 == null) goto L16;
        r0.putLong("live.intent.extra.USER_FROM", r5.l());
    L16:
        r0.putString("enter_from", "live");
        r0.putString("enter_from_merge", r3);
        if (r7.isRecommendCard == false) goto L20;
        r0.putString("enter_from_merge_recommend", "pop_card");
    L20:
        if (TextUtils.isEmpty(r7.liveReason) == true) goto L22;
        r0.putString("live_reason", r7.liveReason);
    L22:
        r0.putString("enter_method", h4());
        Y3(r7, true, "small_picture", r0);
        return;
    L5:
        r3 = "";
        goto L7
    }

    public final void f4(boolean r8) {
        if (r8 == true) goto L5;
        UIUtils.setViewVisibility(this.F, 8);
        this.I = false;
        xs2.b.a().post(new yv1.b(false, this.n.getId()));
        return;
    L5:
        if (this.n == null) goto L12;
        o r9 = u.l().c(x.class);
        String r2 = V3();
        String r3 = h4();
        if (r9.getMap().containsKey("action_type") == false) goto L10;
        String r10 = (String) r9.getMap().get("action_type");
    L11:
        HashMap r4 = new HashMap();
        r4.put("enter_from_merge", r2);
        r4.put("enter_method", r3);
        r4.put("action_type", r10);
        r4.put("event_page", "live_cover");
        u.l().sendLog("livesdk_click_trans_layer", r4, new Object[]{Room.class});
        goto L12
    L10:
        r10 = "";
    L12:
        this.I = true;
        UIUtils.setViewVisibility(this.F, 0);
        xs2.b.a().post(new yv1.b(true, this.n.getId()));
    }

    public final void g4(final Room r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        register(this.a.a(r8.getId(), r8.getAnchorId(), r8.getRequestId(), V3(), h4()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this, r8), new j(this)));
    }

    public final void i4(Room r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getOwner() == null) goto L9;
        r5.getOwner().getFollowInfo().getFollowStatus();
        f r0 = k.f(IUserService.class).user();
        com.bytedance.android.livesdk.user.n.b r1 = new com.bytedance.android.livesdk.user.n.b();
        DrawerSmallLiveViewHolder.l4(((RecyclerView.ViewHolder) this).itemView);
        com.bytedance.android.livesdk.user.n.b r2 = r1.f(r5.getId()).c(r5.getAnchorId());
        r2.getClass();
        r0.G(new com.bytedance.android.livesdk.user.n(r2)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r5));
        return;
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void U3(FeedItem r9, final Room r10, int r11) {
        super.U3(r9, r10, r11);
        UIUtils.setViewVisibility(this.t, 8);
        UIUtils.setViewVisibility(this.D, 8);
        UIUtils.setViewVisibility(this.s, 8);
        boolean r0 = false;
        this.E.setVisibility(0);
        g r12 = g.a;
        if (((Boolean) r12.getValue()).booleanValue() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L21;
        this.F.setVisibility(8);
        k.f(IRoomService.class).getLiveOntologyRecord().getReqFrom();
        this.F.setOnClickListener(new ww1.b(this));
        if (this.m.getFeedType() != FeedType.FOLLOW_FEED) goto L13;
        boolean r13 = true;
    L14:
        if (r13 == false) goto L16;
        this.G.setImageResource(2131252307);
        this.H.setText(2131916631);
        this.G.setOnClickListener(new c(this, r10));
        this.H.setOnClickListener(new d(this, r10));
    L17:
        Disposable r14 = xs2.b.a().b(yv1.a.class).subscribe(new ww1.g(this, r10), new h());
        this.J = r14;
        if (r14 == null) goto L21;
        register(r14);
        goto L21
    L16:
        this.G.setImageResource(2131250342);
        this.H.setText(2131916575);
        this.G.setOnClickListener(new ww1.e(this, r10));
        this.H.setOnClickListener(new ww1.f(this, r10));
        goto L17
    L13:
        r13 = false;
    L21:
        if (((Boolean) r12.getValue()).booleanValue() == true) goto L23;
    L25:
        boolean r15 = false;
    L26:
        String r16 = null;
        if (r15 == false) goto L29;
        View.OnLongClickListener r17 = new ww1.a(this, r10);
    L30:
        DouyinSmallLiveCardView r2 = this.E;
        String r3 = this.m.d40();
        String r4 = V3();
        String r5 = h4();
        LiveCoverConfig r6 = this.m.kG();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r10, "room");
        Intrinsics.checkNotNullParameter(r3, "feedUrl");
        if (r5 != null) goto L33;
    L39:
        r2.b = r3;
        r2.bindRoom(r10, r4, r6);
        if (r17 == null) goto L42;
        r2.setOnLongClickListener(r17);
    L42:
        ((RecyclerView.ViewHolder) this).itemView.addOnAttachStateChangeListener(new a(this));
        return;
    L33:
        if (r5.length() <= 0) goto L35;
        r0 = true;
    L35:
        if (r0 == false) goto L37;
        r16 = r5;
    L37:
        if (r16 == null) goto L39;
        r2.e = r16;
        goto L39
    L29:
        r17 = null;
        goto L30
    L23:
        if (this.b == null) goto L25;
        r15 = true;
        goto L26
    L5:
        if (this.b == null) goto L7;
        r1 = true;
        goto L8
    }

    public DouyinSmallLiveViewHolder(View r13, tv1.c r14, com.bytedance.android.livesdk.feed.f r15, FeedDataKey r16, com.bytedance.android.livesdk.feed.j r17, ILiveRoomListDataSource r18, PublishSubject r19, com.bytedance.android.livesdk.feed.h r20) {
        super(r13, r14, r15, r16, r17, r18, null, r19, r20);
        this.I = false;
        this.F = (ViewGroup) r13.findViewById(2131369147);
        this.G = (ImageView) r13.findViewById(2131376181);
        this.H = (TextView) r13.findViewById(2131390514);
        this.D = r13.findViewById(2131367812);
        this.E = (DouyinSmallLiveCardView) r13.findViewById(2131378252);
    }
}
