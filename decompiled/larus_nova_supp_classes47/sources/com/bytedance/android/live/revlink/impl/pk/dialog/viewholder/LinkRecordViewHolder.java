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
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.o5;
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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/LinkRecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRecordViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {
    public static final /* synthetic */ int u = 0;
    public final com.bytedance.android.live.revlink.impl.pk.service.b a;
    public final x31.b b;
    public int c;
    public final com.bytedance.android.livesdk.revenue.room.a d;
    public x31.t e;
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
    public o5 r;
    public final HashMap<String, String> s;
    public final x31.c t;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LinkRecordViewHolder a;
        public final /* synthetic */ String b;

        public b(LinkRecordViewHolder r1, String r2) {
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
            LinkRecordViewHolder r3 = this.a;
            r3.V3(r3.o, r3.T3(r6));
            x31.t r7 = this.a.e;
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
        public final /* synthetic */ LinkRecordViewHolder a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ o5 d;

        public c(LinkRecordViewHolder r1, String r2, int r3, o5 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            LinkRecordViewHolder r8 = this.a;
            String r0 = this.b;
            int r1 = LinkRecordViewHolder.u;
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
            x31.b r22 = this.a.b;
            if (r22 == null) goto L28;
            r22.mF(this.c, this.d);
        L22:
            r3 = false;
            goto L23
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ LinkRecordViewHolder a;
        public final /* synthetic */ o5 b;

        public d(LinkRecordViewHolder r1, o5 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            LinkRecordViewHolder r10 = this.a;
            IBaseUser r0 = this.b.getUser();
            if (r0 == null) goto L5;
            String r1 = r0.getIdString();
        L6:
            String r2 = r1;
            r10.getClass();
            wq2.f r3 = ma1.a.a();
            if (r3 == null) goto L10;
            wq2.f.a.a(r3, r2, UserProfileClickPos.POSITION_PK_HISTORY_RECORD, "pk", UserProfileReportType.DATA_TYPE_CARD_PK_ANCHOR, 1, 64);
            return;
        L10:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final String G() {
        o5 r0 = this.r;
        String r1 = "";
        if (r0 == null) goto L8;
        Long r2 = r0.getStartTime();
        if (r2 == null) goto L8;
        String r3 = String.valueOf(r2.longValue());
        if (r3 == null) goto L8;
    L9:
        o5 r4 = this.r;
        if (r4 == null) goto L15;
        Long r5 = r4.getEndTime();
        if (r5 == null) goto L15;
        String r6 = String.valueOf(r5.longValue());
        if (r6 == null) goto L15;
    L16:
        o5 r7 = this.r;
        if (r7 == null) goto L25;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L25;
        String r9 = r8.getIdString();
        if (r9 == null) goto L25;
        r1 = r9;
    L25:
        return r1 + ':' + r3 + '-' + r6;
    L15:
        r6 = "";
    L8:
        r3 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.ui.j
    public final void N(String r4) {
        Intrinsics.checkNotNullParameter(r4, "panelType");
        String r0 = this.q;
        if (r0 != null) goto L5;
        r0 = "link_banner";
    L5:
        this.s.put("enter_from", r4);
        this.s.put("source", r0);
        this.s.put("invitee_list", "link_history");
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

    public LinkRecordViewHolder(View r2, x31.b r3, x31.c r4) {
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
        this.g = LazyKt.lazy(LinkRecordViewHolder$nonFixWidth$2.INSTANCE);
        this.h = LazyKt.lazy(LinkRecordViewHolder$minNickWidth$2.INSTANCE);
        this.i = LazyKt.lazy(LinkRecordViewHolder$btnWidth$2.INSTANCE);
        this.j = s1.f(4.0f);
        this.k = s1.f(39.0f);
        this.l = s1.f(32.0f);
        this.m = s1.f(16.0f);
        this.n = LazyKt.lazy(new LinkRecordViewHolder$sexWidth$2(this));
        this.s = new HashMap();
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void U3(int r22, String r23, int r24, o5 r25, int r26, boolean r27) {
        if (r25 != null) goto L5;
        return;
    L5:
        this.e = null;
        CompositeDisposable r4 = this.f;
        if (r4 == null) goto L8;
        r4.dispose();
    L8:
        this.f = null;
        this.p = r22;
        this.q = r23;
        this.r = r25;
        IBaseUser r5 = r25.getUser();
        if (r5 == null) goto L11;
        String r6 = r5.getIdString();
    L13:
        if (r6 == null) goto L33;
        x31.c r7 = this.t;
        if (r7 == null) goto L17;
        x31.t r8 = r7.f(r6);
    L18:
        this.e = r8;
        if (r8 == null) goto L21;
        Integer r9 = Integer.valueOf(r8.a);
    L27:
        if (r9 == null) goto L29;
        int r10 = r9.intValue();
    L30:
        this.f = new CompositeDisposable();
        Disposable r12 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).u0(r6).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r6));
        CompositeDisposable r13 = this.f;
        if (r13 == null) goto L34;
        r13.add(r12);
    L34:
        this.c = r24;
        UtilityKotlinExtentionsKt.A(((RecyclerView.ViewHolder) this).itemView.findViewById(2131369197), !r27);
        ImageView r14 = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267);
        IBaseUser r15 = r25.getUser();
        if (r15 == null) goto L37;
        py.k r16 = r15.getAvatarThumbKt();
    L38:
        a1.x(r14, r16, ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267).getWidth(), ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267).getHeight(), 2131250965);
        TextView r17 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390993);
        IBaseUser r18 = r25.getUser();
        if (r18 == null) goto L41;
        String r19 = r18.getNickName();
    L42:
        r17.setText(r19);
        Long r20 = r25.getStartTime();
        if (r20 == null) goto L45;
        long r110 = r20.longValue();
    L46:
        long r111 = WebcastRedirectException.UNKNOWN;
        long r112 = r110 * r111;
        Long r113 = r25.getEndTime();
        if (r113 == null) goto L49;
        long r114 = r113.longValue();
    L50:
        Long r115 = r25.getStartTime();
        if (r115 == null) goto L53;
        long r116 = r115.longValue();
    L54:
        long r117 = r111 * (r114 - r116);
        if (r112 <= 0) goto L57;
        String r3 = new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(r112));
    L59:
        if (r117 <= 0) goto L64;
        int r28 = ((int) r117) / WebcastRedirectException.UNKNOWN;
        if (r28 >= 60) goto L63;
        String r29 = s1.C(2131917708, new Object[]{Integer.valueOf(r28)});
    L65:
        StringBuilder r30 = new StringBuilder();
        if (by0.b.a(r3) == false) goto L69;
        r30.append(r3);
    L69:
        if (by0.b.a(r29) == false) goto L78;
        if (r30.length() <= 0) goto L73;
        boolean r32 = true;
    L74:
        if (r32 == false) goto L76;
        r30.append(" ");
    L76:
        r30.append(r29);
        goto L78
    L73:
        r32 = false;
    L78:
        if (r30.length() <= 0) goto L80;
        boolean r33 = true;
    L82:
        if (r33 == false) goto L84;
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391117)).setText(r30);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391117)).setVisibility(0);
    L85:
        IBaseUser r34 = r25.getUser();
        if (r34 == null) goto L88;
        Integer r35 = Integer.valueOf(r34.getGender());
    L90:
        if (r35 != null) goto L93;
    L95:
        if (r35 != null) goto L98;
    L100:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setVisibility(8);
    L101:
        IBaseUser r36 = r25.getUser();
        if (r36 != null) goto L104;
    L107:
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131365723)).setVisibility(0);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378545).setVisibility(0);
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598)).setVisibility(8);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setVisibility(0);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378545).setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_item_rank_top_on_going_hd.webp").setAutoPlayAnimations(true).build());
        d51.c r37 = d51.c.A0;
        Map<Long, r41.d> r38 = r37.p();
        if (r38 != null) goto L110;
    L113:
        boolean r39 = true;
    L114:
        if (r39 == true) goto L149;
        long r118 = r26;
        r41.d r40 = r37.p().get(Long.valueOf(r118));
        if (r40 == null) goto L118;
        String r42 = r40.f();
    L119:
        if (r42 != null) goto L121;
    L124:
        boolean r43 = true;
    L125:
        if (r43 == true) goto L131;
        HSImageView r44 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376327);
        r41.d r45 = r37.p().get(Long.valueOf(r118));
        if (r45 == null) goto L129;
        String r46 = r45.f();
    L130:
        ImageLoader.bindImage(r44, r46);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376327).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setBackgroundColor(0);
        goto L131
    L129:
        r46 = null;
    L131:
        r41.d r47 = r37.p().get(Long.valueOf(r118));
        if (r47 == null) goto L134;
        String r48 = r47.g();
    L135:
        if (r48 != null) goto L137;
    L140:
        boolean r49 = true;
    L141:
        if (r49 == true) goto L149;
        TextView r50 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811);     // Catch: Exception -> L148
        r41.d r52 = r37.p().get(Long.valueOf(r118));     // Catch: Exception -> L148
        if (r52 == null) goto L145;
        String r53 = r52.g();     // Catch: Exception -> L148
    L146:
        r50.setTextColor(Color.parseColor(r53));     // Catch: Exception -> L148
        goto L149
    L145:
        r53 = null;
        goto L146
    L137:
        if (r48.length() == 0) goto L140;
        r49 = false;
        goto L141
    L134:
        r48 = null;
        goto L135
    L121:
        if (r42.length() == 0) goto L124;
        r43 = false;
        goto L125
    L118:
        r42 = null;
    L149:
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setOnClickListener(new c(this, r6, r24, r25));
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267).setOnClickListener(new d(this, r25));
        final Triple<String, Integer, Integer> r1 = T3(r10);
        TextView r2 = this.o;
        if (r2 != null) goto L162;
        TextView r54 = new TextView(((RecyclerView.ViewHolder) this).itemView.getContext());
        r54.setSingleLine(true);
        r54.setGravity(17);
        LinearLayout.LayoutParams r55 = new LinearLayout.LayoutParams(((Number) r1.getSecond()).intValue(), this.m);
        r55.gravity = 16;
        Unit r56 = Unit.INSTANCE;
        r54.setLayoutParams(r55);
        r54.setMaxLines(1);
        r54.setTextColor(ColorProtector.parseColor("#80161823"));
        r54.setTextSize(1, 10.0f);
        r54.setBackground(ContextCompat.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131249724));
        CharSequence r57 = (CharSequence) r1.getFirst();
        if (r57 != null) goto L154;
    L157:
        boolean r58 = true;
    L158:
        if (r58 == false) goto L160;
        int r59 = 4;
    L161:
        r54.setVisibility(r59);
        r54.setText((CharSequence) r1.getFirst());
        this.o = r54;
        List r60 = CollectionsKt.listOf(r54);
    L163:
        ((PkTagsContainerView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131388160)).setOldTag(false);
        PkTagsContainerView r62 = (PkTagsContainerView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131388160);
        com.bytedance.android.livesdk.revenue.room.a r63 = this.d;
        if (r63 == null) goto L168;
        com.bytedance.live.datacontext.m r64 = r63.getRoom();
        if (r64 == null) goto L168;
        IRoom r65 = (IRoom) r64.getValue();
    L169:
        r62.g(null, r60, r65, new LinkRecordViewHolder$onBindViewHolder$5(this, r1));
        HashMap r66 = new HashMap();
        o5 r67 = this.r;
        String r68 = "";
        if (r67 == null) goto L175;
        IBaseUser r69 = r67.getUser();
        if (r69 == null) goto L175;
        String r70 = r69.getIdString();
        if (r70 == null) goto L175;
    L176:
        r66.put("right_user_id", r70);
        o5 r72 = this.r;
        if (r72 == null) goto L182;
        IBaseUser r73 = r72.getUser();
        if (r73 == null) goto L182;
        if (r73.getLiveRoomId() != 0) goto L182;
    L190:
        r66.put("connection_type", "manual_link");
        int r74 = UserListInviteType.a;
        r66.put("list_type", UserListInviteType.a(this.c, null));
        r66.put("invitee_list", UserListInviteType.a(this.c, null));
        r66.put("list_num", String.valueOf(this.p + 1));
        d31.d r75 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r75 == null) goto L196;
        String r76 = r75.a();
        if (r76 == null) goto L196;
        r68 = r76;
    L196:
        r66.put("anchor_connect_status", r68);
        this.s.putAll(r66);
        return;
    L182:
        o5 r77 = this.r;
        if (r77 == null) goto L188;
        IBaseUser r78 = r77.getUser();
        if (r78 == null) goto L188;
        String r79 = String.valueOf(r78.getLiveRoomId());
        if (r79 == null) goto L188;
    L189:
        r66.put("right_room_id", r79);
    L188:
        r79 = "";
    L175:
        r70 = "";
    L168:
        r65 = null;
        goto L169
    L160:
        r59 = 0;
        goto L161
    L154:
        if (r57.length() == 0) goto L157;
        r58 = false;
        goto L158
    L162:
        Intrinsics.checkNotNull(r2);
        V3(r2, r1);
        r60 = CollectionsKt.listOf(r2);
        goto L163
    L110:
        if (r38.isEmpty() == true) goto L113;
        r39 = false;
        goto L114
    L104:
        if (r36.getLiveRoomId() != 0) goto L107;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376327).setVisibility(8);
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598)).setVisibility(8);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setVisibility(8);
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131365723)).setVisibility(8);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378545).setVisibility(8);
        goto L149
    L98:
        if (r35.intValue() != 2) goto L100;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setImageResource(2131250687);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setVisibility(0);
        goto L101
    L93:
        if (r35.intValue() != 1) goto L95;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setImageResource(2131250688);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setVisibility(0);
        goto L101
    L88:
        r35 = null;
        goto L90
    L84:
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391117)).setText(null);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391117)).setVisibility(8);
        goto L85
    L80:
        r33 = false;
        goto L82
    L63:
        r29 = s1.C(2131917707, new Object[]{Integer.valueOf(r28 / 60)});
        goto L65
    L64:
        r29 = null;
        goto L65
    L57:
        r3 = null;
        goto L59
    L53:
        r116 = 0;
        goto L54
    L49:
        r114 = 0;
        goto L50
    L45:
        r110 = 0;
        goto L46
    L41:
        r19 = null;
        goto L42
    L37:
        r16 = null;
        goto L38
    L29:
        r10 = 0;
        goto L30
    L21:
        IBaseUser r80 = r25.getUser();
        if (r80 == null) goto L26;
        py.j r82 = r80.getFollowInfo();
        if (r82 == null) goto L26;
        r9 = Integer.valueOf((int) r82.getFollowStatus());
    L26:
        r9 = null;
        goto L27
    L17:
        r8 = null;
        goto L18
    L33:
        r10 = 0;
        goto L34
    L11:
        r6 = null;
        goto L13
    }
}
