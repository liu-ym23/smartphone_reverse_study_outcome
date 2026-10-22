package com.bytedance.android.livesdk.feed.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.Appointment;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.ui.pullrefresh.DoubleBallSwipeRefreshLayout;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.feed.drawerfeed.BaseDrawerFeedFragment;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.bytedance.android.livesdk.feed.tab.repository.p;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kw1.c;
import xs2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feed/adapter/AppointmentListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "AppointmentDateViewHolder", "AppointmentItemViewHolder", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppointmentListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feed/adapter/AppointmentListAdapter$AppointmentDateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AppointmentDateViewHolder extends RecyclerView.ViewHolder {
        public AppointmentDateViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            TextView r3 = (TextView) r2.findViewById(2131383282);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/feed/adapter/AppointmentListAdapter$AppointmentItemViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "Landroid/view/View$OnClickListener;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AppointmentItemViewHolder extends BaseViewHolder<FeedItem> implements View.OnClickListener {
        public final HSImageView a;
        public final TextView b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public final LottieAnimationView f;
        public Appointment g;
        public final CompositeDisposable h;
        public String i;
        public String j;
        public final AppointmentService k;
        public Integer l;
        public DoubleBallSwipeRefreshLayout m;
        public List<Integer> n;
        public final Context o;
        public final Integer p;
        public final BaseDrawerFeedFragment q;

        public final void onViewAttachedToWindow() {
            super.onViewAttachedToWindow();
            DoubleBallSwipeRefreshLayout r0 = this.m;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.c == true) goto L31;
            List<Integer> r1 = this.n;
            if (r1 != null) goto L9;
        L10:
            AppointmentService r2 = this.k;
            String r3 = this.i;
            String r4 = this.j;
            Appointment r5 = this.g;
            Long r6 = null;
            if (r5 == null) goto L13;
            Long r7 = Long.valueOf(r5.appointmentId);
        L14:
            r2.logAppointmentShow(null, r3, r4, r7);
            Integer r8 = this.l;
            if (r8 == null) goto L19;
            int r9 = r8.intValue();
            List<Integer> r10 = this.n;
            if (r10 == null) goto L19;
            r10.add(Integer.valueOf(r9));
        L19:
            Appointment r11 = this.g;
            if (r11 == null) goto L22;
            Boolean r12 = r11.isLiving;
        L24:
            if (Intrinsics.areEqual(r12, Boolean.TRUE) == false) goto L33;
            HashMap r13 = new HashMap();
            r13.put("enter_method", "live_program_list");
            r13.put("enter_from_merge", "drawer_chosen");
            Appointment r14 = this.g;
            if (r14 == null) goto L28;
            r6 = Long.valueOf(r14.appointmentId);
        L28:
            r13.put("program_id", String.valueOf(r6));
            c.d("livesdk_live_show", r13);
            return;
        L33:
            return;
        L22:
            r12 = null;
            goto L24
        L13:
            r7 = null;
            goto L14
        L9:
            if (CollectionsKt.contains(r1, this.l) != true) goto L10;
            return;
        }

        public final void onViewDetachedFromWindow() {
            super.onViewDetachedFromWindow();
            this.h.clear();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r15) {
            Appointment r0 = this.g;
            Map r1 = null;
            Long r2 = null;
            Boolean r3 = null;
            Long r4 = null;
            Long r5 = null;
            if (r0 == null) goto L5;
            Boolean r6 = r0.isLiving;
        L6:
            String r7 = "";
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L28;
            List<e> r16 = p.f().c();
            if (TTLiveService.getLiveService() == null) goto L17;
            ILiveService r8 = TTLiveService.getLiveService();
            if (r8 == null) goto L15;
            ILiveOntologyInfoManager r9 = r8.getLiveOntologyRecord();
            if (r9 == null) goto L15;
            r7 = r9.getInnerUrl();
        L15:
            r7 = null;
        L17:
            if (TextUtils.isEmpty(r7) == false) goto L24;
            Iterator<e> r17 = r16.iterator();
        L20:
            if (r17.hasNext() == false) goto L24;
            e r10 = r17.next();
            if (r10.getType() != 5) goto L20;
            r7 = r10.h();
        L24:
            String r11 = r7;
            AppointmentService r12 = this.k;
            Appointment r18 = this.g;
            if (r18 == null) goto L27;
            r2 = Long.valueOf(r18.roomId);
        L27:
            r12.openLive(r2, r11, this.p, null, this.g, this.o, this.i);
            return;
        L28:
            Appointment r13 = this.g;
            if (r13 == null) goto L31;
            Map r14 = r13.liveExtractsMap;
        L32:
            boolean r19 = false;
            if (r14 != null) goto L35;
        L38:
            boolean r20 = true;
        L39:
            if (r20 == false) goto L69;
            if (r15 != null) goto L42;
        L47:
            Appointment r110 = this.g;
            if (r110 == null) goto L56;
            String r21 = r110.programJumpUrl;
            if (r21 == null) goto L56;
            k.n(IBrowserService.class).buildFullScreenWebPage(s1.getContext(), r21).b();
            AppointmentService r22 = this.k;
            String r23 = this.i;
            Appointment r111 = this.g;
            if (r111 == null) goto L54;
            r4 = Long.valueOf(r111.appointmentId);
        L54:
            r22.logClickReserve("others", null, r23, r4, "H5");
            return;
        L56:
            if (r110 == null) goto L90;
            String r112 = r110.getAnchorIdStr();
            if (r112 == null) goto L91;
            HashMap r24 = new HashMap(1);
            Appointment r25 = this.g;
            if (r25 == null) goto L65;
            String r26 = r25.secAnchorId;
            if (r26 == null) goto L65;
            r7 = r26;
        L65:
            r24.put("sec_user_id", r7);
            k.n(IRoomService.class).actionHandler().showUserProfile(r112, null, r24);
            AppointmentService r27 = this.k;
            String r28 = this.i;
            Appointment r113 = this.g;
            if (r113 == null) goto L68;
            r5 = Long.valueOf(r113.appointmentId);
        L68:
            r27.logClickReserve("others", null, r28, r5, "personal_page");
            return;
        L91:
            return;
        L90:
            return;
        L42:
            if (r15.getId() != 2131383280) goto L47;
            AppointmentService r29 = this.k;
            Appointment r114 = this.g;
            if (r114 == null) goto L46;
            r3 = r114.isReserved;
        L46:
            r29.reserve(r3, this.o, this.p, this.e, null, r114, this.i, this.h);
            return;
        L69:
            Appointment r115 = this.g;
            if (r115 == null) goto L72;
            r1 = r115.liveExtractsMap;
        L72:
            if (r1 != null) goto L74;
        L75:
            r19 = true;
        L76:
            if (r19 == true) goto L93;
            Appointment r30 = this.g;
            if (r30 == null) goto L94;
            Map<Long, ? extends Appointment.LiveFragments> r31 = r30.liveExtractsMap;
            if (r31 == null) goto L95;
            this.k.openVideo(r31, this.o, null, this.i, r30);
            return;
        L95:
            return;
        L94:
            return;
        L93:
            return;
        L74:
            if (r1.isEmpty() == false) goto L76;
        L35:
            if (r14.isEmpty() == true) goto L38;
            r20 = false;
            goto L39
        L31:
            r14 = null;
            goto L32
        L5:
            r6 = null;
            goto L6
        }

        public final void T3(FeedItem r11, int r12) {
            this.l = Integer.valueOf(r12);
            BaseDrawerFeedFragment r13 = this.q;
            Drawable r0 = null;
            if (r13 == null) goto L5;
            DoubleBallSwipeRefreshLayout r14 = r13.aa0();
        L6:
            this.m = r14;
            BaseDrawerFeedFragment r15 = this.q;
            if (r15 == null) goto L9;
            List<Integer> r16 = r15.Z90();
        L10:
            this.n = r16;
            if (r11 == null) goto L13;
            Appointment r17 = r11.appointment;
        L14:
            Integer r18 = this.p;
            boolean r2 = true;
            if (r18 != null) goto L18;
        L20:
            if (r18 != null) goto L23;
        L25:
            if (r18 == null) goto L28;
            r18.intValue();
        L28:
            Integer r19 = this.p;
            if (r19 != null) goto L32;
        L34:
            if (r19 != null) goto L37;
        L39:
            if (r19 != null) goto L42;
        L44:
            String r110 = "";
        L45:
            this.i = r110;
            this.g = r17;
            this.f.pauseAnimation();
            this.f.setVisibility(8);
            Drawable r111 = this.e.getBackground();
            if ((r111 instanceof GradientDrawable) == true) goto L48;
            r111 = null;
        L48:
            GradientDrawable r112 = (GradientDrawable) r111;
            if (r112 == null) goto L51;
            r112.setColor(s1.h(2131107943));
        L51:
            this.d.setTextColor(s1.h(2131108578));
            this.d.getPaint().setShader(null);
            this.d.setTypeface(Typeface.DEFAULT);
            this.d.setVisibility(0);
            HSImageView r113 = this.a;
            Appointment r3 = this.g;
            if (r3 == null) goto L54;
            String r4 = r3.coverImgUrl;
        L55:
            ImageLoader.bindImage(r113, r4);
            Appointment r114 = this.g;
            if (r114 == null) goto L58;
            String r115 = r114.subTitle;
        L60:
            if (TextUtils.isEmpty(r115) == true) goto L66;
            TextView r116 = this.c;
            Appointment r5 = this.g;
            if (r5 == null) goto L64;
            String r6 = r5.subTitle;
        L65:
            r116.setText(r6);
            this.c.setVisibility(0);
        L67:
            TextView r117 = this.b;
            Appointment r7 = this.g;
            if (r7 == null) goto L70;
            String r8 = r7.title;
        L71:
            r117.setText(r8);
            Appointment r118 = this.g;
            if (r118 == null) goto L74;
            String r119 = r118.dueStartTime;
        L76:
            if (TextUtils.isEmpty(r119) == true) goto L84;
            String r120 = s1.B(2131922653);
            TextView r9 = this.d;
            StringCompanionObject r10 = StringCompanionObject.INSTANCE;
            Object[] r20 = new Object[1];
            SimpleDateFormat r21 = new SimpleDateFormat("HH:mm");
            Appointment r22 = this.g;
            if (r22 == null) goto L82;
            String r23 = r22.dueStartTime;
            if (r23 == null) goto L82;
            Long r24 = Long.valueOf(CastLongProtector.parseLong(r23) * ((long) BubbleId.PadCast));
        L83:
            r20[0] = r21.format(r24);
            r9.setText(String.format(r120, Arrays.copyOf(r20, 1)));
        L82:
            r24 = null;
        L84:
            Appointment r121 = this.g;
            if (r121 == null) goto L87;
            Boolean r122 = r121.isLiving;
        L88:
            Boolean r25 = Boolean.TRUE;
            if (Intrinsics.areEqual(r122, r25) == false) goto L91;
            this.j = "play";
            this.e.setText(s1.B(2131920866));
            this.f.playAnimation();
            this.f.setVisibility(0);
            this.d.setText(s1.B(2131920115));
            this.d.setTextColor(ColorProtector.parseColor("#E6ED3495"));
            this.d.setTypeface(Typeface.DEFAULT_BOLD);
        L123:
            this.e.setOnClickListener(this);
            ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(this);
            this.a.setOnClickListener(this);
            ((ObservableSubscribeProxy) b.a().b(qm1.a.class).as(AutoDispose.bind(this.q))).subscribe(new a(this));
            return;
        L91:
            Appointment r123 = this.g;
            if (r123 == null) goto L94;
            Map r124 = r123.liveExtractsMap;
        L95:
            if (r124 == null) goto L101;
            if (r124.isEmpty() == true) goto L101;
            r2 = false;
        L101:
            if (r2 == true) goto L109;
            this.j = "finish";
            this.d.setVisibility(8);
            this.e.setText(s1.B(2131920839));
            Drawable r125 = this.e.getBackground();
            if ((r125 instanceof GradientDrawable) == false) goto L106;
            r0 = r125;
        L106:
            GradientDrawable r1 = (GradientDrawable) r0;
            if (r1 == null) goto L123;
            r1.setColor(s1.h(2131108318));
            goto L123
        L109:
            Appointment r126 = this.g;
            if (r126 == null) goto L112;
            Boolean r127 = r126.isReserved;
        L114:
            if (Intrinsics.areEqual(r127, r25) == false) goto L122;
            this.j = "cancel_reserve";
            this.e.setText(s1.B(2131917327));
            Drawable r128 = this.e.getBackground();
            if ((r128 instanceof GradientDrawable) == false) goto L119;
            r0 = r128;
        L119:
            GradientDrawable r26 = (GradientDrawable) r0;
            if (r26 == null) goto L123;
            r26.setColor(s1.h(2131108318));
            goto L123
        L122:
            this.j = "reserve";
            this.e.setText(s1.B(2131922190));
            goto L123
        L112:
            r127 = null;
            goto L114
        L94:
            r124 = null;
            goto L95
        L87:
            r122 = null;
            goto L88
        L74:
            r119 = null;
            goto L76
        L70:
            r8 = null;
            goto L71
        L64:
            r6 = null;
            goto L65
        L66:
            this.c.setVisibility(8);
            goto L67
        L58:
            r115 = null;
            goto L60
        L54:
            r4 = null;
            goto L55
        L42:
            if (r19.intValue() != 3) goto L44;
            r110 = "research_activity_page";
            goto L45
        L37:
            if (r19.intValue() != 2) goto L39;
            r110 = "drawer_chosen_tab";
            goto L45
        L32:
            if (r19.intValue() != 1) goto L34;
            r110 = "live_end_page";
            goto L45
        L23:
            if (r18.intValue() != 2) goto L25;
        L18:
            if (r18.intValue() != 1) goto L20;
        L13:
            r17 = null;
            goto L14
        L9:
            r16 = null;
            goto L10
        L5:
            r14 = null;
            goto L6
        }

        public final /* bridge */ /* synthetic */ void bind(Object r1, int r2) {
            T3((FeedItem) r1, r2);
        }

        public AppointmentItemViewHolder(View r2, Context r3, Integer r4, BaseDrawerFeedFragment r5) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.o = r3;
            this.p = r4;
            this.q = r5;
            this.a = r2.findViewById(2131383281);
            this.b = (TextView) r2.findViewById(2131383285);
            this.c = (TextView) r2.findViewById(2131383283);
            this.d = (TextView) r2.findViewById(2131383284);
            this.e = (TextView) r2.findViewById(2131383280);
            this.f = r2.findViewById(2131378408);
            this.h = new CompositeDisposable();
            this.i = "";
            this.j = "";
            this.k = new AppointmentService();
        }
    }

    public final int getItemCount() {
        return 0;
    }

    public final int getItemViewType(int r1) {
        return -1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        if ((r3 instanceof AppointmentItemViewHolder) == true) goto L5;
        r3 = null;
    L5:
        AppointmentItemViewHolder r5 = (AppointmentItemViewHolder) r3;
        if (r5 == null) goto L9;
        r5.T3(null, r4);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != 11) goto L6;
        return new AppointmentDateViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565159, r3, false));
    L6:
        return new AppointmentItemViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565160, r3, false), null, null, null);
    }
}
