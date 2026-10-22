package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.graphics.Color;
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
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.pk.ui.PkTagsContainerView;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.h2;
import com.bytedance.android.livesdk.link.model.h4;
import com.bytedance.android.livesdk.link.model.i4;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.link.model.n0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/viewholder/NewPkRecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/revlink/impl/pk/ui/j;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class NewPkRecordViewHolder extends RecyclerView.ViewHolder implements com.bytedance.android.live.revlink.impl.pk.ui.j {
    public static final /* synthetic */ int z = 0;
    public final com.bytedance.android.live.revlink.impl.pk.service.b a;
    public y31.d.a b;
    public final x31.o c;
    public int d;
    public final com.bytedance.android.livesdk.revenue.room.a e;
    public x31.u f;
    public CompositeDisposable g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final int k;
    public final int l;
    public final int m;
    public final Lazy n;
    public TextView o;
    public int p;
    public String q;
    public f2 r;
    public final HashMap<String, String> s;
    public HSImageView t;
    public View u;
    public View v;
    public TextView w;
    public final b x;
    public final x31.p y;

    public static final class a {
    }

    public static final class b implements Function1<yy0.d, Unit> {
        public final /* synthetic */ NewPkRecordViewHolder a;

        public b(NewPkRecordViewHolder r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2) {
            yy0.d r3 = (yy0.d) r2;
            Intrinsics.checkNotNullParameter(r3, "p1");
            r3.d(new NewPkRecordViewHolder$callBackObject$1$invoke$1(this));
            return Unit.INSTANCE;
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

    public final Triple<String, Integer, Integer> T3(int r5) {
        if (r5 == 1) goto L8;
        if (r5 == 2) goto L10;
        return new Triple("", Integer.valueOf(this.l), Integer.valueOf(this.k * 2));
    L10:
        return new Triple("好友", Integer.valueOf(this.l), Integer.valueOf(this.k * 3));
    L8:
        return new Triple("", Integer.valueOf(this.l), Integer.valueOf(this.k * 2));
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

    public NewPkRecordViewHolder(View r2, x31.o r3, x31.p r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "listener");
        super(r2);
        this.y = r4;
        this.a = com.bytedance.android.live.revlink.impl.global.b.N();
        this.c = r3;
        this.d = 8;
        com.bytedance.android.livesdk.revenue.service.room.c r5 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r5 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r6 = r5.getRoomContext();
    L6:
        this.e = r6;
        this.h = LazyKt.lazy(NewPkRecordViewHolder$nonFixWidth$2.INSTANCE);
        this.i = LazyKt.lazy(NewPkRecordViewHolder$minNickWidth$2.INSTANCE);
        this.j = LazyKt.lazy(NewPkRecordViewHolder$btnWidth$2.INSTANCE);
        this.k = s1.f(4.0f);
        s1.f(39.0f);
        this.l = s1.f(32.0f);
        this.m = s1.f(16.0f);
        this.n = LazyKt.lazy(new NewPkRecordViewHolder$sexWidth$2(this));
        this.s = new HashMap();
        this.x = new b(this);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void U3(int r22, String r23, int r24, f2 r25, int r26, Integer r27, String r28, y31.d.a r29) {
        Intrinsics.checkNotNullParameter(r28, "activityName");
        Intrinsics.checkNotNullParameter(r29, "item");
        if (r25 != null) goto L5;
        return;
    L5:
        this.b = r29;
        this.f = null;
        CompositeDisposable r1 = this.g;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.g = null;
        this.p = r22;
        this.q = r23;
        this.r = r25;
        IBattleUserInfo r2 = r25.getBattleUserInfo();
        if (r2 == null) goto L13;
        k0 r3 = r2.getUserInfo();
        if (r3 == null) goto L13;
        String r4 = r3.getUserId();
    L15:
        if (r4 == null) goto L28;
        x31.p r5 = this.y;
        if (r5 == null) goto L19;
        x31.u r6 = r5.f(r4);
    L20:
        this.f = r6;
        if (r6 == null) goto L23;
        int r7 = r6.a;
    L24:
        this.g = new CompositeDisposable();
        Disposable r8 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).u0(r4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r4));
        CompositeDisposable r12 = this.g;
        if (r12 == null) goto L27;
        r12.add(r8);
    L27:
        int r13 = r7;
    L29:
        this.d = r24;
        UtilityKotlinExtentionsKt.A(((RecyclerView.ViewHolder) this).itemView.findViewById(2131369197), false);
        ImageView r9 = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267);
        IBattleUserInfo r14 = r25.getBattleUserInfo();
        if (r14 == null) goto L34;
        k0 r15 = r14.getUserInfo();
        if (r15 == null) goto L34;
        py.k r16 = r15.getAvatarThumb();
    L35:
        a1.x(r9, r16, ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267).getWidth(), ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267).getHeight(), 2131250965);
        TextView r10 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390993);
        IBattleUserInfo r17 = r25.getBattleUserInfo();
        if (r17 == null) goto L40;
        k0 r18 = r17.getUserInfo();
        if (r18 == null) goto L40;
        String r19 = r18.getNickName();
    L41:
        r10.setText(r19);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131391117)).setText(new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(r25.getBattleStartTime() * ((long) WebcastRedirectException.UNKNOWN))));
        com.bytedance.android.live.core.utils.a1.n(((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598), s1.f(8.0f));
        if (r28.length() <= 0) goto L44;
        boolean r20 = true;
    L45:
        if (r20 == true) goto L47;
    L54:
        boolean r110 = false;
    L55:
        IBattleUserInfo r30 = r25.getBattleUserInfo();
        if (r30 == null) goto L60;
        k0 r32 = r30.getUserInfo();
        if (r32 == null) goto L60;
        Integer r33 = Integer.valueOf(r32.getGender());
    L62:
        if (r33 != null) goto L65;
    L67:
        if (r33 != null) goto L70;
    L72:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setVisibility(8);
    L73:
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598)).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390808)).setVisibility(8);
        if (r25.getRivalLivingRoomId() == 0) goto L76;
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598)).setBackgroundColor(s1.h(2131107349));
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setTextColor(s1.h(2131107958));
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131365723)).setVisibility(0);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378545).setVisibility(0);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598).setBackground(s1.m(2131249722));
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811).setBackground(s1.m(2131249722));
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378545).setController(Fresco.newDraweeControllerBuilder().setUri("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_item_rank_top_on_going_hd.webp").setAutoPlayAnimations(true).build());
    L78:
        if (r25.getBattleResultType() != 1) goto L105;
        d51.c r34 = d51.c.A0;
        Map<Long, r41.d> r111 = r34.p();
        if (r111 != null) goto L82;
    L85:
        boolean r112 = true;
    L86:
        if (r112 == true) goto L103;
        long r35 = r26;
        r41.d r113 = r34.p().get(Long.valueOf(r35));
        if (r113 == null) goto L90;
        String r114 = r113.j();
    L91:
        if (r114 != null) goto L93;
    L96:
        boolean r115 = true;
    L97:
        if (r115 == true) goto L103;
        HSImageView r36 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458);
        r41.d r37 = r34.p().get(Long.valueOf(r35));
        if (r37 == null) goto L101;
        String r38 = r37.j();
    L102:
        ImageLoader.bindImage(r36, r38);
    L156:
        if (r27 == null) goto L225;
        int r39 = r27.intValue();
        if (r39 > 0) goto L160;
        boolean r116 = r110;
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131367694)).setVisibility(8);
    L224:
        Unit r0 = Unit.INSTANCE;
    L226:
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setOnClickListener(new d(this, r4, r25, r24, r22));
        ((LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390608)).setOnClickListener(new e(this, r25));
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374267).setOnClickListener(new f(this, r25));
        h4 r40 = r29.h;
        if (r40 == null) goto L252;
        if (r40.getQuestion() != null) goto L231;
    L250:
        Unit r42 = Unit.INSTANCE;
        goto L252
    L231:
        if (r40.getQuestion().getQuestionText() == null) goto L250;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372277).setVisibility(0);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372211).setVisibility(0);
        Iterator r43 = r40.getQuestion().getOptions().iterator();
        boolean r44 = false;
    L235:
        if (r43.hasNext() == false) goto L247;
        i4 r45 = (i4) r43.next();
        if (r45.isSelect() == false) goto L242;
        if (r45.getTendency() != 0) goto L242;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372219).setVisibility(0);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372219).setBackground(s1.m(2131253059));
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372211)).setText("满意");
    L246:
        r44 = true;
    L242:
        if (r45.isSelect() == false) goto L235;
        if (r45.getTendency() != 1) goto L235;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372219).setVisibility(0);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372219).setBackground(s1.m(2131252605));
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372211)).setText("不满意");
        goto L246
    L247:
        if (r44 == true) goto L249;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372219).setVisibility(8);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372211)).setText("评价");
    L249:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372277).setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.b(this));
    L252:
        if (r29.h != null) goto L254;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131372277).setVisibility(8);
    L254:
        Triple<String, Integer, Integer> r46 = T3(r13);
        TextView r47 = this.o;
        if (r47 != null) goto L267;
        TextView r48 = new TextView(((RecyclerView.ViewHolder) this).itemView.getContext());
        r48.setSingleLine(true);
        r48.setGravity(17);
        LinearLayout.LayoutParams r49 = new LinearLayout.LayoutParams(((Number) r46.getSecond()).intValue(), this.m);
        r49.gravity = 16;
        Unit r50 = Unit.INSTANCE;
        r48.setLayoutParams(r49);
        r48.setMaxLines(1);
        r48.setTextColor(ColorProtector.parseColor("#80161823"));
        r48.setTextSize(1, 10.0f);
        r48.setBackground(ContextCompat.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), 2131249724));
        CharSequence r52 = (CharSequence) r46.getFirst();
        if (r52 != null) goto L259;
    L262:
        boolean r53 = true;
    L263:
        if (r53 == false) goto L265;
        int r54 = 4;
    L266:
        r48.setVisibility(r54);
        r48.setText((CharSequence) r46.getFirst());
        this.o = r48;
        List r55 = CollectionsKt.listOf(r48);
    L268:
        boolean r117 = r116;
        ((PkTagsContainerView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131388160)).setOldTag(r117);
        PkTagsContainerView r56 = (PkTagsContainerView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131388160);
        if (r117 == false) goto L275;
        IBattleUserInfo r57 = r25.getBattleUserInfo();
        if (r57 == null) goto L275;
        n0 r58 = r57.getActivityUser();
        if (r58 == null) goto L275;
        List r59 = r58.getLabelList();
    L276:
        com.bytedance.android.livesdk.revenue.room.a r60 = this.e;
        if (r60 == null) goto L281;
        com.bytedance.live.datacontext.m r62 = r60.getRoom();
        if (r62 == null) goto L281;
        IRoom r63 = (IRoom) r62.getValue();
    L282:
        r56.g(r59, r55, r63, NewPkRecordViewHolder$onBindViewHolder$8.INSTANCE);
        if (r29.l == 5) goto L294;
        HSImageView r64 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385652);
        this.t = r64;
        if (r64 == null) goto L287;
        ViewUtilsKt.g(r64, false);
        Unit r65 = Unit.INSTANCE;
    L287:
        this.w = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385653);
        if (r25.getPlayMode() != ILinkMicBattleSetting.BasePlayMode.BattlePlayMode_Season.getType()) goto L290;
        String r66 = "巅峰赛";
    L291:
        TextView r67 = this.w;
        if (r67 == null) goto L314;
        r67.setText(r66);
    L314:
        this.u = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131368897);
        this.v = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131368832);
        h2 r68 = r25.getSeasonInfo();
        if (r68 == null) goto L317;
        String r69 = r68.getScheme();
    L318:
        if (r69 != null) goto L320;
    L323:
        boolean r70 = true;
    L324:
        if (r70 == true) goto L331;
        View r72 = this.u;
        if (r72 == null) goto L328;
        ViewUtilsKt.g(r72, true);
        Unit r73 = Unit.INSTANCE;
    L328:
        View r74 = this.v;
        if (r74 == null) goto L337;
        r74.setOnClickListener(new g(this, r69));
        Unit r75 = Unit.INSTANCE;
    L337:
        IRoom r76 = r25.getRivalLivingRoom();
        HashMap r77 = new HashMap();
        f2 r78 = this.r;
        String r79 = "";
        if (r78 == null) goto L345;
        IBattleUserInfo r80 = r78.getBattleUserInfo();
        if (r80 == null) goto L345;
        k0 r82 = r80.getUserInfo();
        if (r82 == null) goto L345;
        String r83 = r82.getUserId();
        if (r83 == null) goto L345;
    L346:
        r77.put("right_user_id", r83);
        f2 r84 = this.r;
        if (r84 != null) goto L349;
    L350:
        f2 r85 = this.r;
        if (r85 == null) goto L354;
        String r86 = String.valueOf(r85.getRivalLivingRoomId());
        if (r86 == null) goto L354;
    L355:
        r77.put("right_room_id", r86);
    L357:
        if (r76 == null) goto L363;
        Map r87 = r76.getLinkMap();
        if (r87 == null) goto L363;
        if (r87.containsKey(String.valueOf(8)) != true) goto L363;
        r77.put("right_user_status", DataType.TRUE);
    L364:
        if (r76 == null) goto L378;
        this.s.put("watch_uv", String.valueOf(r76.getUserCount()));
        IBaseUser r88 = r76.getOwner();
        if (r88 == null) goto L368;
        py.j r118 = r88.getFollowInfo();
    L369:
        if (r118 == null) goto L378;
        HashMap<String, String> r89 = this.s;
        IBaseUser r90 = r76.getOwner();
        if (r90 == null) goto L376;
        py.j r92 = r90.getFollowInfo();
        if (r92 == null) goto L376;
        String r93 = String.valueOf(r92.getFollowerCount());
        if (r93 == null) goto L376;
    L377:
        r89.put("recommend_anchor_fans", r93);
    L376:
        r93 = "";
        goto L377
    L368:
        r118 = null;
    L378:
        r77.put("connection_type", "manual_link");
        int r94 = UserListInviteType.a;
        r77.put("list_type", UserListInviteType.a(this.d, null));
        r77.put("invitee_list", UserListInviteType.a(this.d, null));
        r77.put("list_num", String.valueOf(this.p + 1));
        d31.d r95 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r95 == null) goto L384;
        String r96 = r95.a();
        if (r96 == null) goto L384;
        r79 = r96;
    L384:
        r77.put("anchor_connect_status", r79);
        this.s.putAll(r77);
        return;
    L363:
        r77.put("right_user_status", "2");
    L354:
        r86 = "";
        goto L355
    L349:
        if (r84.getRivalLivingRoomId() == 0) goto L357;
    L345:
        r83 = "";
        goto L346
    L331:
        View r97 = this.v;
        if (r97 == null) goto L334;
        r97.setOnClickListener(null);
        Unit r98 = Unit.INSTANCE;
    L334:
        View r99 = this.u;
        if (r99 == null) goto L337;
        ViewUtilsKt.g(r99, false);
        Unit r100 = Unit.INSTANCE;
        goto L337
    L320:
        if (r69.length() == 0) goto L323;
        r70 = false;
        goto L324
    L317:
        r69 = null;
        goto L318
    L290:
        r66 = "常规PK";
        goto L291
    L294:
        this.t = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385652);
        h2 r101 = r25.getSeasonInfo();
        if (r101 == null) goto L297;
        py.k r102 = r101.getRankBadge();
    L299:
        if (UtilityKotlinExtentionsKt.n(r102) == true) goto L304;
        HSImageView r103 = this.t;
        if (r103 == null) goto L303;
        ViewUtilsKt.g(r103, true);
        Unit r104 = Unit.INSTANCE;
    L303:
        ImageLoader.bindImage(this.t, r102);
    L307:
        TextView r105 = this.w;
        if (r105 == null) goto L314;
        h2 r106 = r25.getSeasonInfo();
        if (r106 == null) goto L312;
        String r107 = r106.getRankDetail();
    L313:
        r105.setText(r107);
        goto L314
    L312:
        r107 = null;
        goto L313
    L304:
        HSImageView r108 = this.t;
        if (r108 == null) goto L307;
        ViewUtilsKt.g(r108, false);
        Unit r109 = Unit.INSTANCE;
        goto L307
    L297:
        r102 = null;
    L281:
        r63 = null;
    L275:
        r59 = null;
        goto L276
    L265:
        r54 = 0;
        goto L266
    L259:
        if (r52.length() == 0) goto L262;
        r53 = false;
        goto L263
    L267:
        Intrinsics.checkNotNull(r47);
        V3(r47, r46);
        r55 = CollectionsKt.listOf(r47);
        goto L268
    L160:
        if (r39 <= 99) goto L162;
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390387)).setText(s1.B(2131917827));
    L163:
        d51.c r119 = d51.c.A0;
        Map<Long, r41.d> r120 = r119.p();
        if (r120 != null) goto L166;
    L169:
        boolean r121 = true;
    L170:
        if (r121 == true) goto L221;
        r116 = r110;
        long r122 = r26;
        r41.d r123 = r119.p().get(Long.valueOf(r122));
        if (r123 == null) goto L174;
        String r124 = r123.c();
    L175:
        if (r124 != null) goto L177;
    L180:
        boolean r125 = true;
    L181:
        if (r125 == true) goto L187;
        HSImageView r126 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376138);
        r41.d r127 = r119.p().get(Long.valueOf(r122));
        if (r127 == null) goto L185;
        String r128 = r127.c();
    L186:
        ImageLoader.bindImage(r126, r128);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131376138).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390387)).setBackgroundColor(0);
        goto L187
    L185:
        r128 = null;
    L187:
        r41.d r129 = r119.p().get(Long.valueOf(r122));
        if (r129 == null) goto L190;
        String r130 = r129.e();
    L191:
        if (r130 != null) goto L193;
    L196:
        boolean r131 = true;
    L197:
        if (r131 == false) goto L386;
    L205:
        d51.c r132 = d51.c.A0;
        r41.d r133 = r132.p().get(Long.valueOf(r122));
        if (r133 == null) goto L208;
        String r134 = r133.d();
    L209:
        if (r134 != null) goto L211;
    L214:
        boolean r135 = true;
    L215:
        if (r135 == true) goto L222;
        TextView r136 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390387);
        r41.d r137 = r132.p().get(Long.valueOf(r122));
        if (r137 == null) goto L219;
        String r138 = r137.d();
    L220:
        r136.setText(r138);
        goto L222
    L219:
        r138 = null;
    L222:
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131367694)).setVisibility(0);
        goto L224
    L211:
        if (r134.length() == 0) goto L214;
        r135 = false;
        goto L215
    L208:
        r134 = null;
        goto L209
    L386:
        TextView r139 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390387);     // Catch: Exception -> L204
        r41.d r140 = r119.p().get(Long.valueOf(r122));     // Catch: Exception -> L204
        if (r140 == null) goto L201;
        String r141 = r140.e();     // Catch: Exception -> L204
    L202:
        r139.setTextColor(Color.parseColor(r141));     // Catch: Exception -> L204
        goto L205
    L201:
        r141 = null;
        goto L202
    L193:
        if (r130.length() == 0) goto L196;
        r131 = false;
        goto L197
    L190:
        r130 = null;
        goto L191
    L177:
        if (r124.length() == 0) goto L180;
        r125 = false;
        goto L181
    L174:
        r124 = null;
        goto L175
    L221:
        r116 = r110;
        goto L222
    L166:
        if (r120.isEmpty() == true) goto L169;
        r121 = false;
        goto L170
    L162:
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390387)).setText(s1.C(2131917829, new Object[]{r27}));
        goto L163
    L225:
        r116 = r110;
        goto L226
    L101:
        r38 = null;
        goto L102
    L93:
        if (r114.length() == 0) goto L96;
        r115 = false;
        goto L97
    L90:
        r114 = null;
    L103:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458).setImageResource(2131251328);
        goto L156
    L82:
        if (r111.isEmpty() == true) goto L85;
        r112 = false;
        goto L86
    L105:
        if (r25.getBattleResultType() != 2) goto L131;
        d51.c r142 = d51.c.A0;
        Map<Long, r41.d> r143 = r142.p();
        if (r143 != null) goto L109;
    L112:
        boolean r144 = true;
    L113:
        if (r144 == true) goto L130;
        long r145 = r26;
        r41.d r146 = r142.p().get(Long.valueOf(r145));
        if (r146 == null) goto L117;
        String r147 = r146.i();
    L118:
        if (r147 != null) goto L120;
    L123:
        boolean r148 = true;
    L124:
        if (r148 == true) goto L130;
        HSImageView r149 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458);
        r41.d r150 = r142.p().get(Long.valueOf(r145));
        if (r150 == null) goto L128;
        String r151 = r150.i();
    L129:
        ImageLoader.bindImage(r149, r151);
        goto L156
    L128:
        r151 = null;
        goto L129
    L120:
        if (r147.length() == 0) goto L123;
        r148 = false;
        goto L124
    L117:
        r147 = null;
    L130:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458).setImageResource(2131251327);
        goto L156
    L109:
        if (r143.isEmpty() == true) goto L112;
        r144 = false;
        goto L113
    L131:
        d51.c r152 = d51.c.A0;
        Map<Long, r41.d> r153 = r152.p();
        if (r153 != null) goto L134;
    L137:
        boolean r154 = true;
    L138:
        if (r154 == true) goto L155;
        long r155 = r26;
        r41.d r156 = r152.p().get(Long.valueOf(r155));
        if (r156 == null) goto L142;
        String r157 = r156.h();
    L143:
        if (r157 != null) goto L145;
    L148:
        boolean r158 = true;
    L149:
        if (r158 == true) goto L155;
        HSImageView r159 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458);
        r41.d r160 = r152.p().get(Long.valueOf(r155));
        if (r160 == null) goto L153;
        String r161 = r160.h();
    L154:
        ImageLoader.bindImage(r159, r161);
        goto L156
    L153:
        r161 = null;
        goto L154
    L145:
        if (r157.length() == 0) goto L148;
        r158 = false;
        goto L149
    L142:
        r157 = null;
    L155:
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131384458).setImageResource(2131251326);
        goto L156
    L134:
        if (r153.isEmpty() == true) goto L137;
        r154 = false;
        goto L138
    L76:
        ((ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131365723)).setVisibility(8);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131378545).setVisibility(8);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598).setBackground(null);
        ((FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131375598)).setBackgroundColor(s1.h(2131107349));
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setTextColor(s1.h(2131107328));
        ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811)).setBackground(s1.m(2131249723));
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131390811).setOnClickListener(null);
        goto L78
    L70:
        if (r33.intValue() != 2) goto L72;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setImageResource(2131250687);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setVisibility(0);
        goto L73
    L65:
        if (r33.intValue() != 1) goto L67;
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setImageResource(2131250688);
        ((RecyclerView.ViewHolder) this).itemView.findViewById(2131373623).setVisibility(0);
    L60:
        r33 = null;
        goto L62
    L47:
        if (r25.getBattleUserInfo() == null) goto L54;
        IBattleUserInfo r162 = r25.getBattleUserInfo();
        if (r162 == null) goto L51;
        n0 r163 = r162.getActivityUser();
    L52:
        if (r163 == null) goto L54;
        r110 = true;
        goto L55
    L51:
        r163 = null;
        goto L52
    L44:
        r20 = false;
    L40:
        r19 = null;
    L34:
        r16 = null;
        goto L35
    L23:
        r7 = r25.getFollowType();
        goto L24
    L19:
        r6 = null;
        goto L20
    L28:
        r13 = 0;
    L13:
        r4 = null;
        goto L15
    }
}
