package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.link.model.n0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.service.datacenter.UserProfileClickPos;
import com.bytedance.android.livesdk.revenue.service.datacenter.UserProfileReportType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/PKRecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRecordViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {
    public static final /* synthetic */ int u = 0;
    public final com.bytedance.android.live.revlink.impl.pk.service.b a;
    public final x31.o b;
    public int c;
    public final com.bytedance.android.livesdk.revenue.room.a d;
    public x31.u e;
    public CompositeDisposable f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final Lazy n;
    public TextView o;
    public int p;
    public String q;
    public f2 r;
    public final HashMap<String, String> s;
    public final x31.p t;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PKRecordViewHolder a;
        public final /* synthetic */ String b;

        public b(PKRecordViewHolder r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            IFollowPair r5 = (IFollowPair) r4;
            String r0 = null;
            if (r5 == null) goto L5;
            String r1 = r5.getUserIdString();
        L7:
            if (TextUtils.isEmpty(r1) == true) goto L16;
            if (r5 == null) goto L10;
            String r2 = r5.getUserIdString();
        L12:
            if (TextUtils.equals(r2, DataType.FALSE) == true) goto L16;
            if (r5 == null) goto L16;
            r0 = r5.getUserIdString();
            goto L16
        L10:
            r2 = null;
        L16:
            if ((!Intrinsics.areEqual(r0, this.b)) == true) goto L25;
            if (r5 == null) goto L23;
            int r6 = r5.getFollowStatus();
            PKRecordViewHolder r3 = this.a;
            r3.V3(r3.o, r3.T3(r6));
            x31.u r7 = this.a.e;
            if (r7 == null) goto L24;
            r7.a = r6;
            return;
        L24:
            return;
        L23:
            return;
        L25:
            return;
        L5:
            r1 = null;
            goto L7
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PKRecordViewHolder a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ f2 d;
        public final /* synthetic */ int e;

        public c(PKRecordViewHolder r1, String r2, int r3, f2 r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            PKRecordViewHolder r8 = this.a;
            String r0 = this.b;
            int r1 = PKRecordViewHolder.u;
            r8.getClass();
            com.bytedance.android.live.revenuelink.connect.g r2 = com.bytedance.android.live.revlink.impl.global.b.b();
            if (r2 == null) goto L22;
            boolean r3 = true;
            if (r2.v1() != true) goto L22;
            com.bytedance.android.live.revlink.impl.pk.service.b r9 = r8.a;
            Object r4 = null;
            if (r9 == null) goto L20;
            i11.b r10 = r9.getLinkUserCenter();
            if (r10 == null) goto L20;
            List<IBaseUser> r12 = r10.getInviteeList();
            if (r12 == null) goto L20;
            Iterator<T> r13 = r12.iterator();
        L15:
            if (r13.hasNext() == false) goto L19;
            Object r5 = r13.next();
            if (Intrinsics.areEqual(iz.a.a((IBaseUser) r5), r0) == false) goto L15;
            r4 = r5;
        L19:
            r4 = (IBaseUser) r4;
        L20:
            if (r4 == null) goto L22;
        L23:
            if (r3 == false) goto L25;
            ToastUtil.a(2131921456, 0);
        L28:
            HashMap r14 = new HashMap();
            r14.put("oncemore_click_from", "pk_history");
            mz0.n r6 = new mz0.n();
            Map<String, String> r15 = r6.a;
            Intrinsics.checkNotNullParameter(r15, "map");
            Intrinsics.checkNotNullParameter(r14, "map");
            r15.putAll(r14);
            mz0.m r16 = new mz0.m();
            r16.b(LogCommon.ROOM);
            List<Object> r17 = r6.b;
            ArrayList r18 = (ArrayList) r17;
            r18.addAll(r16.a);
            cy0.e.a.getClass();
            cy0.j r19 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r20);
            ((mz0.i) ((f80.a) r20)).w3("livesdk_pk_oncemore_click", r6.a, r6.b);
            return;
        L25:
            x31.o r22 = this.a.b;
            if (r22 == null) goto L28;
            r22.a50(this.c, this.d, this.e);
        L22:
            r3 = false;
            goto L23
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ PKRecordViewHolder a;
        public final /* synthetic */ f2 b;

        public d(PKRecordViewHolder r1, f2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            x31.o r5 = this.a.b;
            if (r5 == null) goto L5;
            r5.op(this.b);
        L5:
            mz0.n r6 = new mz0.n();
            mz0.m r0 = new mz0.m();
            r0.b(LogCommon.ROOM);
            r0.b(LogCommon.PAGE_SOURCE_LOG);
            List<Object> r1 = r6.b;
            ArrayList r2 = (ArrayList) r1;
            r2.addAll(r0.a);
            cy0.e.a.getClass();
            cy0.j r3 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r7 = com.bytedance.android.scope.m.b(r3).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r7);
            ((mz0.i) ((f80.a) r7)).w3("livesdk_pk_start_feedback_icon_click", r6.a, r6.b);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ PKRecordViewHolder a;
        public final /* synthetic */ f2 b;

        public e(PKRecordViewHolder r1, f2 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            PKRecordViewHolder r10 = this.a;
            IBattleUserInfo r0 = this.b.getBattleUserInfo();
            if (r0 == null) goto L7;
            k0 r1 = r0.getUserInfo();
            if (r1 == null) goto L7;
            String r2 = r1.getUserId();
        L8:
            String r3 = r2;
            r10.getClass();
            wq2.f r4 = ma1.a.a();
            if (r4 == null) goto L12;
            wq2.f.a.a(r4, r3, UserProfileClickPos.POSITION_PK_HISTORY_RECORD, "pk", UserProfileReportType.DATA_TYPE_CARD_PK_ANCHOR, 1, 64);
            return;
        L12:
            return;
        L7:
            r2 = null;
            goto L8
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        f2 r0 = this.r;
        String r1 = "";
        if (r0 == null) goto L6;
        String r2 = String.valueOf(r0.getBattleStartTime());
        if (r2 == null) goto L6;
    L7:
        f2 r3 = this.r;
        if (r3 == null) goto L18;
        IBattleUserInfo r4 = r3.getBattleUserInfo();
        if (r4 == null) goto L18;
        k0 r5 = r4.getUserInfo();
        if (r5 == null) goto L18;
        String r6 = r5.getUserId();
        if (r6 == null) goto L18;
        r1 = r6;
    L18:
        return r1 + ':' + r2;
    L6:
        r2 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r4) {
        Intrinsics.checkNotNullParameter(r4, "panelType");
        String r0 = this.q;
        if (r0 != null) goto L5;
        r0 = "pk_banner";
    L5:
        this.s.put("enter_from", r4);
        this.s.put("source", r0);
        this.s.put("invitee_list", "history");
        HashMap<String, String> r5 = this.s;
        d31.d r1 = com.bytedance.android.live.revlink.impl.global.b.c0();
        String r2 = "";
        if (r1 == null) goto L8;
        String r3 = r1.f();
    L9:
        r5.put("invite_mode", r3);
        HashMap<String, String> r6 = this.s;
        d31.d r7 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r7 == null) goto L12;
        String r8 = r7.d();
    L13:
        r6.put("battle_mode", r8);
        HashMap<String, String> r9 = this.s;
        d31.d r10 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r10 == null) goto L16;
        String r12 = r10.s();
    L17:
        r9.put("room_status", r12);
        HashMap<String, String> r13 = this.s;
        d31.d r14 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r14 == null) goto L20;
        r2 = r14.b();
    L20:
        r13.put("connection_sub_type", r2);
        mz0.n r15 = new mz0.n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        HashMap<String, String> r17 = this.s;
        Intrinsics.checkNotNullParameter(r17, "map");
        r16.putAll(r17);
        mz0.m r18 = new mz0.m();
        r18.b(LogCommon.ROOM);
        List<Object> r19 = r15.b;
        ArrayList r20 = (ArrayList) r19;
        r20.addAll(r18.a);
        cy0.e.a.getClass();
        cy0.j r22 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r22).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r23);
        ((mz0.i) ((f80.a) r23)).w3("livesdk_connectioninvite_anchoricon_show", r15.a, r15.b);
        return;
    L16:
        r12 = "";
        goto L17
    L12:
        r8 = "";
        goto L13
    L8:
        r3 = "";
        goto L9
    }

    public final Triple<String, Integer, Integer> T3(int r4) {
        if (r4 == 1) goto L8;
        if (r4 == 2) goto L10;
        return new Triple("", Integer.valueOf(this.k), Integer.valueOf(this.j * 2));
    L10:
        return new Triple("好友", Integer.valueOf(this.l), Integer.valueOf(this.j * 3));
    L8:
        return new Triple("已关注", Integer.valueOf(this.k), Integer.valueOf(this.j * 2));
    }

    public final void V3(TextView r3, Triple<String, Integer, Integer> r4) {
        if (r3 == null) goto L14;
        CharSequence r0 = (CharSequence) r4.getFirst();
        int r1 = 0;
        if (r0 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        r1 = 4;
    L12:
        r3.setVisibility(r1);
        r3.setText((CharSequence) r4.getFirst());
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        r5.width = ((Number) r4.getSecond()).intValue();
        Unit r6 = Unit.INSTANCE;
        r3.setLayoutParams(r5);
        return;
    L6:
        if (r0.length() == 0) goto L9;
        r2 = false;
        goto L10
    }

    public PKRecordViewHolder(View r2, x31.o r3, x31.p r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "listener");
        super(r2);
        this.t = r4;
        this.a = com.bytedance.android.live.revlink.impl.global.b.N();
        this.b = r3;
        this.c = 8;
        com.bytedance.android.livesdk.revenue.service.room.c r5 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r5 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r6 = r5.getRoomContext();
    L6:
        this.d = r6;
        this.g = LazyKt.lazy(PKRecordViewHolder$nonFixWidth$2.INSTANCE);
        this.h = LazyKt.lazy(PKRecordViewHolder$minNickWidth$2.INSTANCE);
        this.i = LazyKt.lazy(PKRecordViewHolder$btnWidth$2.INSTANCE);
        this.j = s1.f(4.0f);
        this.k = s1.f(39.0f);
        this.l = s1.f(32.0f);
        this.m = s1.f(16.0f);
        this.n = LazyKt.lazy(new PKRecordViewHolder$sexWidth$2(this));
        this.s = new HashMap();
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void U3(int r20, String r22, int r23, f2 r24, int r25, Integer r26, String r27, boolean r28, boolean r29) {
        Intrinsics.checkNotNullParameter(r27, "activityName");
        if (r24 != null) goto L5;
        return;
    L5:
        this.e = null;
        CompositeDisposable r1 = this.f;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.f = null;
        this.p = r20;
        this.q = r22;
        this.r = r24;
        IBattleUserInfo r2 = r24.getBattleUserInfo();
        if (r2 == null) goto L13;
        k0 r3 = r2.getUserInfo();
        if (r3 == null) goto L13;
        String r4 = r3.getUserId();
    L14:
        if (r4 == null) goto L27;
        x31.p r5 = this.t;
        if (r5 == null) goto L18;
        x31.u r6 = r5.f(r4);
    L19:
        this.e = r6;
        if (r6 == null) goto L22;
        int r7 = r6.a;
    L23:
        this.f = new CompositeDisposable();
        Disposable r8 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).u0(r4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r4));
        CompositeDisposable r10 = this.f;
        if (r10 == null) goto L26;
        r10.add(r8);
    L26:
        int r12 = r7;
    L28:
        this.c = r23;
        UtilityKotlinExtentionsKt.A(((RecyclerView.ViewHolder) this).itemView.findViewById(2131369197), !r28);
        ImageView r9 = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267);
        IBattleUserInfo r13 = r24.getBattleUserInfo();
        if (r13 == null) goto L33;
        k0 r14 = r13.getUserInfo();
        if (r14 == null) goto L33;
        py.k r15 = r14.getAvatarThumb();
    L34:
        a1.x(r9, r15, ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267).getWidth(), ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267).getHeight(), 2131250965);
        TextView r16 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390993);
        IBattleUserInfo r17 = r24.getBattleUserInfo();
        if (r17 == null) goto L39;
        k0 r18 = r17.getUserInfo();
        if (r18 == null) goto L39;
        String r19 = r18.getNickName();
    L40:
        r16.setText(r19);
        int r110 = r12;
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391117)).setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(r24.getBattleStartTime() * ((long) WebcastRedirectException.UNKNOWN))));
        com.bytedance.android.live.core.utils.a1.n(((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598), s1.f(8.0f));
        if (r27.length() <= 0) goto L43;
        boolean r30 = true;
    L44:
        if (r30 == true) goto L46;
    L53:
        boolean r32 = false;
    L54:
        IBattleUserInfo r33 = r24.getBattleUserInfo();
        if (r33 == null) goto L59;
        k0 r34 = r33.getUserInfo();
        if (r34 == null) goto L59;
        Integer r35 = Integer.valueOf(r34.getGender());
    L61:
        if (r35 != null) goto L64;
    L66:
        if (r35 != null) goto L69;
    L71:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setVisibility(8);
    L73:
        if (r24.getRivalLivingRoomId() == 0) goto L133;
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131365723)).setVisibility(0);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378545).setVisibility(0);
        if (r32 == false) goto L90;
        IBattleUserInfo r111 = r24.getBattleUserInfo();
        if (r111 == null) goto L83;
        n0 r112 = r111.getActivityUser();
        if (r112 == null) goto L83;
        if (r112.isValid() != true) goto L83;
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598)).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390808)).setVisibility(8);
    L91:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378545).setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_item_rank_top_on_going_hd.webp").setAutoPlayAnimations(true).build());
        d51.c r36 = d51.c.A0;
        Map<Long, r41.d> r37 = r36.p();
        if (r37 != null) goto L94;
    L97:
        boolean r38 = true;
    L98:
        if (r38 == true) goto L149;
        long r113 = r25;
        r41.d r39 = r36.p().get(Long.valueOf(r113));
        if (r39 == null) goto L102;
        String r40 = r39.f();
    L103:
        if (r40 != null) goto L105;
    L108:
        boolean r42 = true;
    L109:
        if (r42 == true) goto L115;
        HSImageView r43 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376327);
        r41.d r114 = r36.p().get(Long.valueOf(r113));
        if (r114 == null) goto L113;
        String r115 = r114.f();
    L114:
        ImageLoader.bindImage(r43, r115);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376327).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setBackgroundColor(0);
        goto L115
    L113:
        r115 = null;
    L115:
        r41.d r44 = r36.p().get(Long.valueOf(r113));
        if (r44 == null) goto L118;
        String r45 = r44.g();
    L119:
        if (r45 != null) goto L121;
    L124:
        boolean r46 = true;
    L125:
        if (r46 == true) goto L149;
        TextView r47 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811);     // Catch: Exception -> L132
        r41.d r48 = r36.p().get(Long.valueOf(r113));     // Catch: Exception -> L132
        if (r48 == null) goto L129;
        String r49 = r48.g();     // Catch: Exception -> L132
    L130:
        r47.setTextColor(Color.parseColor(r49));     // Catch: Exception -> L132
        goto L149
    L129:
        r49 = null;
        goto L130
    L121:
        if (r45.length() == 0) goto L124;
        r46 = false;
        goto L125
    L118:
        r45 = null;
        goto L119
    L105:
        if (r40.length() == 0) goto L108;
        r42 = false;
        goto L109
    L102:
        r40 = null;
    L149:
        if (r24.getBattleResultType() != 1) goto L176;
        d51.c r50 = d51.c.A0;
        Map<Long, r41.d> r116 = r50.p();
        if (r116 != null) goto L153;
    L156:
        boolean r117 = true;
    L157:
        if (r117 == true) goto L174;
        long r118 = r25;
        r41.d r119 = r50.p().get(Long.valueOf(r118));
        if (r119 == null) goto L161;
        String r120 = r119.j();
    L162:
        if (r120 != null) goto L164;
    L167:
        boolean r121 = true;
    L168:
        if (r121 == true) goto L174;
        HSImageView r52 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458);
        r41.d r53 = r50.p().get(Long.valueOf(r118));
        if (r53 == null) goto L172;
        String r54 = r53.j();
    L173:
        ImageLoader.bindImage(r52, r54);
    L227:
        if (r26 == null) goto L295;
        int r55 = r26.intValue();
        if (r55 > 0) goto L231;
        int r122 = 0;
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131367694)).setVisibility(8);
    L294:
        Unit r0 = Unit.INSTANCE;
    L296:
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setOnClickListener(new c(this, r4, r23, r24, r20));
        ((LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390608)).setOnClickListener(new d(this, r24));
        ViewUtilsKt.g(((RecyclerView.ViewHolder) this).itemView.findViewById(2131390608), r29);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267).setOnClickListener(new e(this, r24));
        final Triple<String, Integer, Integer> r56 = T3(r110);
        TextView r57 = this.o;
        if (r57 != null) goto L308;
        TextView r58 = new TextView(((RecyclerView.ViewHolder) this).itemView.getContext());
        r58.setSingleLine(true);
        r58.setGravity(17);
        LinearLayout.LayoutParams r59 = new LinearLayout.LayoutParams(((Number) r56.getSecond()).intValue(), this.m);
        r59.gravity = 16;
        Unit r60 = Unit.INSTANCE;
        r58.setLayoutParams(r59);
        r58.setMaxLines(1);
        r58.setTextColor(ColorProtector.parseColor("#80161823"));
        r58.setTextSize(1, 10.0f);
        r58.setBackground(ContextCompat.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131249724));
        CharSequence r62 = (CharSequence) r56.getFirst();
        if (r62 != null) goto L301;
    L304:
        boolean r63 = true;
    L305:
        if (r63 == false) goto L307;
        r122 = 4;
    L307:
        r58.setVisibility(r122);
        r58.setText((CharSequence) r56.getFirst());
        this.o = r58;
        List r64 = CollectionsKt.listOf(r58);
    L309:
        ((PkTagsContainerView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131388160)).setOldTag(r32);
        PkTagsContainerView r65 = (PkTagsContainerView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131388160);
        if (r32 == false) goto L316;
        IBattleUserInfo r66 = r24.getBattleUserInfo();
        if (r66 == null) goto L316;
        n0 r67 = r66.getActivityUser();
        if (r67 == null) goto L316;
        List r68 = r67.getLabelList();
    L317:
        com.bytedance.android.livesdk.revenue.room.a r69 = this.d;
        if (r69 == null) goto L322;
        com.bytedance.live.datacontext.m r70 = r69.getRoom();
        if (r70 == null) goto L322;
        IRoom r72 = (IRoom) r70.getValue();
    L323:
        r65.g(r68, r64, r72, new PKRecordViewHolder$onBindViewHolder$7(this, r56));
        IRoom r73 = r24.getRivalLivingRoom();
        HashMap r74 = new HashMap();
        f2 r75 = this.r;
        String r76 = "";
        if (r75 == null) goto L331;
        IBattleUserInfo r77 = r75.getBattleUserInfo();
        if (r77 == null) goto L331;
        k0 r78 = r77.getUserInfo();
        if (r78 == null) goto L331;
        String r79 = r78.getUserId();
        if (r79 == null) goto L331;
    L332:
        r74.put("right_user_id", r79);
        f2 r80 = this.r;
        if (r80 != null) goto L335;
    L336:
        f2 r82 = this.r;
        if (r82 == null) goto L340;
        String r83 = String.valueOf(r82.getRivalLivingRoomId());
        if (r83 == null) goto L340;
    L341:
        r74.put("right_room_id", r83);
    L343:
        if (r73 == null) goto L349;
        Map r84 = r73.getLinkMap();
        if (r84 == null) goto L349;
        if (r84.containsKey(String.valueOf(8)) != true) goto L349;
        r74.put("right_user_status", DataType.TRUE);
    L350:
        if (r73 == null) goto L364;
        this.s.put("watch_uv", String.valueOf(r73.getUserCount()));
        IBaseUser r85 = r73.getOwner();
        if (r85 == null) goto L354;
        py.j r86 = r85.getFollowInfo();
    L355:
        if (r86 == null) goto L364;
        HashMap<String, String> r87 = this.s;
        IBaseUser r88 = r73.getOwner();
        if (r88 == null) goto L362;
        py.j r89 = r88.getFollowInfo();
        if (r89 == null) goto L362;
        String r90 = String.valueOf(r89.getFollowerCount());
        if (r90 == null) goto L362;
    L363:
        r87.put("recommend_anchor_fans", r90);
    L362:
        r90 = "";
        goto L363
    L354:
        r86 = null;
    L364:
        r74.put("connection_type", "manual_link");
        int r92 = UserListInviteType.a;
        r74.put("list_type", UserListInviteType.a(this.c, null));
        r74.put("invitee_list", UserListInviteType.a(this.c, null));
        r74.put("list_num", String.valueOf(this.p + 1));
        d31.d r93 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r93 == null) goto L370;
        String r94 = r93.a();
        if (r94 == null) goto L370;
        r76 = r94;
    L370:
        r74.put("anchor_connect_status", r76);
        this.s.putAll(r74);
        return;
    L349:
        r74.put("right_user_status", "2");
    L340:
        r83 = "";
        goto L341
    L335:
        if (r80.getRivalLivingRoomId() == 0) goto L343;
    L331:
        r79 = "";
    L322:
        r72 = null;
    L316:
        r68 = null;
        goto L317
    L301:
        if (r62.length() == 0) goto L304;
        r63 = false;
        goto L305
    L308:
        Intrinsics.checkNotNull(r57);
        V3(r57, r56);
        r64 = CollectionsKt.listOf(r57);
        goto L309
    L231:
        if (r55 <= 99) goto L233;
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390387)).setText(s1.B(2131917827));
    L234:
        d51.c r95 = d51.c.A0;
        Map<Long, r41.d> r123 = r95.p();
        if (r123 != null) goto L237;
    L240:
        boolean r124 = true;
    L241:
        if (r124 == true) goto L292;
        long r125 = r25;
        r41.d r96 = r95.p().get(Long.valueOf(r125));
        if (r96 == null) goto L245;
        String r97 = r96.c();
    L246:
        if (r97 != null) goto L248;
    L251:
        boolean r98 = true;
    L252:
        if (r98 == true) goto L258;
        HSImageView r99 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376138);
        r41.d r100 = r95.p().get(Long.valueOf(r125));
        if (r100 == null) goto L256;
        String r101 = r100.c();
    L257:
        ImageLoader.bindImage(r99, r101);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376138).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390387)).setBackgroundColor(0);
        goto L258
    L256:
        r101 = null;
    L258:
        r41.d r102 = r95.p().get(Long.valueOf(r125));
        if (r102 == null) goto L261;
        String r103 = r102.e();
    L262:
        if (r103 != null) goto L264;
    L267:
        boolean r104 = true;
    L268:
        if (r104 == false) goto L372;
    L276:
        d51.c r105 = d51.c.A0;
        r41.d r106 = r105.p().get(Long.valueOf(r125));
        if (r106 == null) goto L279;
        String r107 = r106.d();
    L280:
        if (r107 != null) goto L282;
    L285:
        boolean r108 = true;
    L286:
        if (r108 == true) goto L292;
        TextView r109 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390387);
        r41.d r126 = r105.p().get(Long.valueOf(r125));
        if (r126 == null) goto L290;
        String r127 = r126.d();
    L291:
        r109.setText(r127);
        goto L292
    L290:
        r127 = null;
        goto L291
    L282:
        if (r107.length() == 0) goto L285;
        r108 = false;
        goto L286
    L279:
        r107 = null;
        goto L280
    L372:
        TextView r128 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390387);     // Catch: Exception -> L275
        r41.d r129 = r95.p().get(Long.valueOf(r125));     // Catch: Exception -> L275
        if (r129 == null) goto L272;
        String r130 = r129.e();     // Catch: Exception -> L275
    L273:
        r128.setTextColor(Color.parseColor(r130));     // Catch: Exception -> L275
        goto L276
    L272:
        r130 = null;
        goto L273
    L264:
        if (r103.length() == 0) goto L267;
        r104 = false;
        goto L268
    L261:
        r103 = null;
        goto L262
    L248:
        if (r97.length() == 0) goto L251;
        r98 = false;
        goto L252
    L245:
        r97 = null;
    L292:
        r122 = 0;
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131367694)).setVisibility(0);
        goto L294
    L237:
        if (r123.isEmpty() == true) goto L240;
        r124 = false;
        goto L241
    L233:
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390387)).setText(s1.C(2131917829, new Object[]{r26}));
        goto L234
    L295:
        r122 = 0;
        goto L296
    L172:
        r54 = null;
        goto L173
    L164:
        if (r120.length() == 0) goto L167;
        r121 = false;
        goto L168
    L161:
        r120 = null;
    L174:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458).setImageResource(2131251328);
        goto L227
    L153:
        if (r116.isEmpty() == true) goto L156;
        r117 = false;
        goto L157
    L176:
        if (r24.getBattleResultType() != 2) goto L202;
        d51.c r131 = d51.c.A0;
        Map<Long, r41.d> r132 = r131.p();
        if (r132 != null) goto L180;
    L183:
        boolean r133 = true;
    L184:
        if (r133 == true) goto L201;
        long r134 = r25;
        r41.d r135 = r131.p().get(Long.valueOf(r134));
        if (r135 == null) goto L188;
        String r136 = r135.i();
    L189:
        if (r136 != null) goto L191;
    L194:
        boolean r137 = true;
    L195:
        if (r137 == true) goto L201;
        HSImageView r138 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458);
        r41.d r139 = r131.p().get(Long.valueOf(r134));
        if (r139 == null) goto L199;
        String r140 = r139.i();
    L200:
        ImageLoader.bindImage(r138, r140);
        goto L227
    L199:
        r140 = null;
        goto L200
    L191:
        if (r136.length() == 0) goto L194;
        r137 = false;
        goto L195
    L188:
        r136 = null;
    L201:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458).setImageResource(2131251327);
        goto L227
    L180:
        if (r132.isEmpty() == true) goto L183;
        r133 = false;
        goto L184
    L202:
        d51.c r141 = d51.c.A0;
        Map<Long, r41.d> r142 = r141.p();
        if (r142 != null) goto L205;
    L208:
        boolean r143 = true;
    L209:
        if (r143 == true) goto L226;
        long r144 = r25;
        r41.d r145 = r141.p().get(Long.valueOf(r144));
        if (r145 == null) goto L213;
        String r146 = r145.h();
    L214:
        if (r146 != null) goto L216;
    L219:
        boolean r147 = true;
    L220:
        if (r147 == true) goto L226;
        HSImageView r148 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458);
        r41.d r149 = r141.p().get(Long.valueOf(r144));
        if (r149 == null) goto L224;
        String r150 = r149.h();
    L225:
        ImageLoader.bindImage(r148, r150);
        goto L227
    L224:
        r150 = null;
        goto L225
    L216:
        if (r146.length() == 0) goto L219;
        r147 = false;
        goto L220
    L213:
        r146 = null;
    L226:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458).setImageResource(2131251326);
        goto L227
    L205:
        if (r142.isEmpty() == true) goto L208;
        r143 = false;
        goto L209
    L94:
        if (r37.isEmpty() == true) goto L97;
        r38 = false;
    L83:
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598)).setVisibility(8);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setVisibility(8);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390808)).setVisibility(0);
        TextView r151 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390808);
        IBattleUserInfo r152 = r24.getBattleUserInfo();
        if (r152 == null) goto L88;
        n0 r153 = r152.getActivityUser();
        if (r153 == null) goto L88;
        String r154 = r153.getReasonMessage();
    L89:
        r151.setText(r154);
    L88:
        r154 = null;
        goto L89
    L90:
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598)).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390808)).setVisibility(8);
        goto L91
    L133:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376327).setVisibility(8);
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598)).setVisibility(8);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setVisibility(8);
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131365723)).setVisibility(8);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378545).setVisibility(8);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390808)).setVisibility(8);
        if (r32 == false) goto L149;
        IBattleUserInfo r155 = r24.getBattleUserInfo();
        if (r155 == null) goto L141;
        n0 r156 = r155.getActivityUser();
        if (r156 == null) goto L141;
        if (r156.isValid() == true) goto L149;
    L141:
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390808)).setVisibility(0);
        TextView r157 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390808);
        IBattleUserInfo r158 = r24.getBattleUserInfo();
        if (r158 == null) goto L146;
        n0 r159 = r158.getActivityUser();
        if (r159 == null) goto L146;
        String r160 = r159.getReasonMessage();
    L147:
        r157.setText(r160);
    L146:
        r160 = null;
        goto L147
    L69:
        if (r35.intValue() != 2) goto L71;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setImageResource(2131250687);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setVisibility(0);
        goto L73
    L64:
        if (r35.intValue() != 1) goto L66;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setImageResource(2131250688);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setVisibility(0);
    L59:
        r35 = null;
        goto L61
    L46:
        if (r24.getBattleUserInfo() == null) goto L53;
        IBattleUserInfo r161 = r24.getBattleUserInfo();
        if (r161 == null) goto L50;
        n0 r162 = r161.getActivityUser();
    L51:
        if (r162 == null) goto L53;
        r32 = true;
        goto L54
    L50:
        r162 = null;
        goto L51
    L43:
        r30 = false;
    L39:
        r19 = null;
    L33:
        r15 = null;
        goto L34
    L22:
        r7 = r24.getFollowType();
        goto L23
    L18:
        r6 = null;
        goto L19
    L27:
        r12 = 0;
    L13:
        r4 = null;
        goto L14
    }
}
