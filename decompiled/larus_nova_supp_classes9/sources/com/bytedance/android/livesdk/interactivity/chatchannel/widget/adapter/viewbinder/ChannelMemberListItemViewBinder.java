package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.fifa.core.IChannelLinkService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.f1;
import com.bytedance.android.livesdk.config.zj;
import com.bytedance.android.livesdk.interactivity.chatchannel.model.ChannelLinkUserInfo;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelRingView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;
import o62.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChannelMemberListItemViewBinder extends b<ChannelLinkUserInfo, ItemViewHolder> {
    public final s22.a b;
    public final a c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/adapter/viewbinder/ChannelMemberListItemViewBinder$ItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemViewHolder extends RecyclerView.ViewHolder {
        public ChannelLinkUserInfo a;
        public ValueAnimator b;
        public final View c;
        public final HSImageView d;
        public final ChannelRingView e;
        public final ChannelRingView f;
        public final TextView g;
        public final TextView h;
        public final View i;
        public final HSImageView j;
        public final View k;
        public final HSImageView l;
        public final HSImageView m;
        public final View n;
        public final View o;
        public final View p;
        public final HSImageView q;
        public final s22.a r;
        public final a s;

        public static final class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ ItemViewHolder a;

            public a(ItemViewHolder r1) {
                this.a = r1;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r9) {
                Intrinsics.checkNotNullParameter(r9, "it");
                Object r10 = r9.getAnimatedValue();
                if (r10 == null) goto L11;
                float r11 = ((Float) r10).floatValue();
                if (r11 < 0.5f) goto L7;
                double r4 = 0.8f;
                double r6 = r11;
            L8:
                float r1 = (float) (r4 + (r6 * 0.2d));
                this.a.d.setScaleX(r1);
                this.a.d.setScaleY(r1);
                ChannelRingView r2 = this.a.e;
                r2.c = r11;
                r2.d.setStrokeWidth(r2.a * r11);
                r2.invalidate();
                float r0 = (float) ((((double) (1.0f - r11)) * 0.3d) + 0.9d);
                this.a.e.setScaleX(r0);
                this.a.e.setScaleY(r0);
                this.a.e.setAlpha((float) (((double) r11) * 0.5d));
                return;
            L7:
                r4 = 0.8f;
                r6 = 1.0f - r11;
                goto L8
            L11:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }

        public static final class b extends AnimatorListenerAdapter {
            public final /* synthetic */ ItemViewHolder a;

            public b(ItemViewHolder r1) {
                this.a = r1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r2) {
                Intrinsics.checkNotNullParameter(r2, "animation");
                UtilityKotlinExtentionsKt.t(this.a.e);
            }
        }

        public final void U3() {
            UtilityKotlinExtentionsKt.w(this.e);
            ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            r0.setDuration(1400);
            r0.addUpdateListener(new a(this));
            r0.addListener(new b(this));
            Unit r1 = Unit.INSTANCE;
            this.b = r0;
            r0.setRepeatCount(-1);
            ValueAnimator r2 = this.b;
            if (r2 == null) goto L6;
            r2.start();
            return;
        }

        public static boolean T3(ChannelLinkUserInfo r1) {
            return Intrinsics.areEqual(r1.a.getCastSecUid(), o.a(k.n(IUserService.class).user().b()));
        }

        public final void W3(final ChannelLinkUserInfo r8) {
            if (((Boolean) this.r.v().a).booleanValue() == false) goto L32;
            ChannelLinkUserInfo.ChannelUserRole r0 = r8.b.a;
            int r1 = com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.viewbinder.a.a[r0.ordinal()];
            if (r1 != 1) goto L7;
            UtilityKotlinExtentionsKt.w(this.f);
            UtilityKotlinExtentionsKt.w(this.k);
            UtilityKotlinExtentionsKt.t(this.p);
            UtilityKotlinExtentionsKt.t(this.j);
            ChannelLinkUserInfo.LinkUserInfo r2 = r8.c;
            if (r2 == null) goto L25;
            final int r3 = r2.getSilenceStatus();
        L26:
            ChannelLinkUserInfo.LinkUserInfo r4 = r8.c;
            if (r4 == null) goto L30;
            IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r5 = r4.getVolumeLevel();
            if (r5 == null) goto L30;
        L31:
            int r6 = c.a(r3, r5);
            r3.a(this.n, c.b(r3, r5));
            ImageLoader.bindDrawableResource(this.l, r6);
            this.n.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateOthersAudienceOperateButton$1(this, r3, r8)));
            r3.c(this.o, s1.B(2131915729), true);
            ImageLoader.bindDrawableResource(this.m, 2131252886);
            this.o.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateOthersAudienceOperateButton$2(this, r8)));
            return;
        L30:
            r5 = IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.SILENT;
            goto L31
        L25:
            r3 = 0;
            goto L26
        L7:
            if (r1 == 2) goto L19;
            if (r1 != 3) goto L11;
            UtilityKotlinExtentionsKt.w(this.k);
            UtilityKotlinExtentionsKt.t(this.p);
            UtilityKotlinExtentionsKt.t(this.j);
            UtilityKotlinExtentionsKt.w(this.h);
            this.h.setText(2131922260);
            U3();
            r3.a(this.n, s1.B(2131915718));
            ImageLoader.bindDrawableResource(this.l, 2131252885);
            this.n.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateOthersLinkApplingOperateButton$1(this, r8)));
            r3.a(this.o, s1.B(2131915724));
            ImageLoader.bindDrawableResource(this.m, 2131252887);
            this.o.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateOthersLinkApplingOperateButton$2(this, r8)));
            return;
        L11:
            if (r1 != 4) goto L13;
            UtilityKotlinExtentionsKt.t(this.k);
            UtilityKotlinExtentionsKt.t(this.j);
            UtilityKotlinExtentionsKt.w(this.p);
            UtilityKotlinExtentionsKt.w(this.h);
            this.h.setText(2131922262);
            U3();
            r3.a(this.p, s1.B(2131915724));
            ImageLoader.bindDrawableResource(this.q, 2131252887);
            this.p.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateOthersLinkInviteeOperateButton$1(this, r8)));
            return;
        L13:
            if (r1 != 5) goto L52;
            UtilityKotlinExtentionsKt.w(this.f);
            UtilityKotlinExtentionsKt.w(this.k);
            UtilityKotlinExtentionsKt.t(this.p);
            UtilityKotlinExtentionsKt.t(this.j);
            UtilityKotlinExtentionsKt.w(this.h);
            this.h.setText(2131922254);
            r3.c(this.n, s1.B(2131915718), true);
            ImageLoader.bindDrawableResource(this.l, 2131252885);
            this.n.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateOthersGuestApplingOperateButton$1(this, r8)));
            r3.c(this.o, s1.B(2131915724), true);
            ImageLoader.bindDrawableResource(this.m, 2131252887);
            this.o.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateOthersGuestApplingOperateButton$2(this, r8)));
            return;
        L52:
            return;
        L19:
            if (r8.b.b == false) goto L21;
            UtilityKotlinExtentionsKt.w(this.f);
            UtilityKotlinExtentionsKt.w(this.k);
            UtilityKotlinExtentionsKt.t(this.p);
            UtilityKotlinExtentionsKt.t(this.j);
            r3.c(this.n, s1.B(2131915720), true);
            ImageLoader.bindDrawableResource(this.l, 2131252872);
            this.n.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateOthersGuestOperateButton$1(this, r8)));
            r3.c(this.o, s1.B(2131915729), true);
            ImageLoader.bindDrawableResource(this.m, 2131252886);
            this.o.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateOthersGuestOperateButton$2(this, r8)));
            return;
        L21:
            UtilityKotlinExtentionsKt.w(this.f);
            UtilityKotlinExtentionsKt.t(this.k);
            UtilityKotlinExtentionsKt.w(this.p);
            UtilityKotlinExtentionsKt.t(this.j);
            r3.c(this.p, s1.B(2131915729), true);
            ImageLoader.bindDrawableResource(this.q, 2131252886);
            this.p.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateOthersGuestOperateButton$3(this, r8)));
            return;
        L32:
            UtilityKotlinExtentionsKt.w(this.f);
            UtilityKotlinExtentionsKt.t(this.k);
            UtilityKotlinExtentionsKt.t(this.p);
            UtilityKotlinExtentionsKt.t(this.j);
            ChannelLinkUserInfo.LinkUserInfo r9 = r8.c;
            if (r9 == null) goto L44;
            UtilityKotlinExtentionsKt.w(this.j);
            int r7 = c.a;
            r9.getSilenceStatus();
            IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r10 = r9.getVolumeLevel();
            Intrinsics.checkNotNullParameter(r10, "volumeLevel");
            switch(o62.b.b[r10.ordinal()]) {
                case 1: goto L42;
                case 2: goto L41;
                case 3: goto L40;
                case 4: goto L39;
                case 5: goto L39;
                case 6: goto L38;
                default: goto L37;
            };
        L38:
            int r11 = 2131252883;
        L43:
            ImageLoader.bindDrawableResource(this.j, r11);
            r3.a(this.j, s1.B(2131915727));
            goto L44
        L39:
            r11 = 2131252882;
            goto L43
        L40:
            r11 = 2131252881;
            goto L43
        L41:
            r11 = 2131252880;
            goto L43
        L42:
            r11 = 2131252879;
            goto L43
        L37:
            throw new NoWhenBranchMatchedException();
        L44:
            this.n.setOnClickListener(null);
            this.o.setOnClickListener(null);
        }

        public final void X3(final ChannelLinkUserInfo r6) {
            UtilityKotlinExtentionsKt.t(this.k);
            UtilityKotlinExtentionsKt.t(this.p);
            UtilityKotlinExtentionsKt.t(this.j);
            UtilityKotlinExtentionsKt.t(this.f);
            if (r6.b.b == false) goto L42;
            ChannelLinkUserInfo.LinkUserInfo r0 = r6.c;
            if (r0 != null) goto L8;
        L19:
            ChannelLinkUserInfo.LinkUserInfo r1 = r6.c;
            if (r1 != null) goto L22;
        L29:
            ChannelLinkUserInfo.LinkUserInfo r2 = r6.c;
            if (r2 != null) goto L32;
        L36:
            UtilityKotlinExtentionsKt.w(this.f);
            UtilityKotlinExtentionsKt.w(this.p);
            r3.a(this.p, s1.B(2131915720) + s1.B(2131915719));
            ImageLoader.bindDrawableResource(this.q, 2131252872);
            this.p.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateSelfOperateButton$6(this, r6)));
            return;
        L32:
            if (r2.getLinkStatus() != 1) goto L36;
            if (r6.b.a != ChannelLinkUserInfo.ChannelUserRole.LinkInvitee) goto L36;
            UtilityKotlinExtentionsKt.w(this.k);
            UtilityKotlinExtentionsKt.w(this.f);
            UtilityKotlinExtentionsKt.w(this.h);
            this.h.setText(2131922261);
            r3.c(this.n, s1.B(2131915718), true);
            ImageLoader.bindDrawableResource(this.l, 2131252885);
            this.n.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateSelfOperateButton$4(this)));
            r3.c(this.o, s1.B(2131915724), true);
            ImageLoader.bindDrawableResource(this.m, 2131252887);
            this.o.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateSelfOperateButton$5(this)));
            return;
        L22:
            if (r1.getLinkStatus() != 1) goto L29;
            if (r6.b.a != ChannelLinkUserInfo.ChannelUserRole.LinkApplicant) goto L29;
            if (((Boolean) this.r.v().a).booleanValue() == false) goto L28;
            UtilityKotlinExtentionsKt.w(this.p);
            this.q.setController(Fresco.newDraweeControllerBuilder().setUri(((f1) zj.a.getValue()).a()).setAutoPlayAnimations(true).build());
            this.p.setOnClickListener(null);
            return;
        L28:
            UtilityKotlinExtentionsKt.w(this.p);
            UtilityKotlinExtentionsKt.w(this.h);
            this.h.setText(2131922260);
            U3();
            r3.c(this.p, s1.B(2131915724), true);
            ImageLoader.bindDrawableResource(this.q, 2131252887);
            this.p.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateSelfOperateButton$3(this, r6)));
            return;
        L8:
            if (r0.getLinkStatus() != 2) goto L19;
            UtilityKotlinExtentionsKt.w(this.f);
            UtilityKotlinExtentionsKt.w(this.k);
            ChannelLinkUserInfo.LinkUserInfo r3 = r6.c;
            if (r3 == null) goto L12;
            final int r4 = r3.getSilenceStatus();
        L13:
            ChannelLinkUserInfo.LinkUserInfo r5 = r6.c;
            if (r5 == null) goto L17;
            IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel r7 = r5.getVolumeLevel();
            if (r7 == null) goto L17;
        L18:
            int r8 = c.a(r4, r7);
            r3.a(this.n, c.b(r4, r7));
            ImageLoader.bindDrawableResource(this.l, r8);
            this.n.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateSelfOperateButton$1(this, r4, r6)));
            r3.c(this.o, s1.B(2131915729), true);
            ImageLoader.bindDrawableResource(this.m, 2131252886);
            this.o.setOnClickListener(x0.a(new ChannelMemberListItemViewBinder$ItemViewHolder$updateSelfOperateButton$2(this, r6)));
            return;
        L17:
            r7 = IChannelLinkService.IOnlineUserLinkerStatus.VolumeLevel.SILENT;
            goto L18
        L12:
            r4 = -1;
            goto L13
        }

        public static void V3(ChannelLinkUserInfo r10, ChannelLinkUserInfo r11) {
            if (r11 != null) goto L5;
        L44:
            boolean r2 = false;
            long r7 = -1;
            if (r11 == null) goto L50;
            ChannelLinkUserInfo.LinkUserInfo r9 = r11.c;
            if (r9 == null) goto L50;
            if (r9.getLinkStatus() != 2) goto L50;
        L67:
            ChannelLinkUserInfo.LinkUserInfo r13 = r10.c;
            if (r13 != null) goto L70;
        L71:
            if (r11 == null) goto L103;
            ChannelLinkUserInfo.LinkUserInfo r14 = r11.c;
            if (r14 == null) goto L103;
            if (r14.getLinkStatus() != 2) goto L103;
            ChannelLinkUserInfo.LinkUserInfo r15 = r10.c;
            if (r15 == null) goto L103;
            if (r15.getLinkStatus() != 2) goto L103;
            ChannelLinkUserInfo.LinkUserInfo r16 = r11.c;
            if (r16 == null) goto L83;
            Integer r17 = Integer.valueOf(r16.getSilenceStatus());
        L84:
            ChannelLinkUserInfo.LinkUserInfo r1 = r10.c;
            if (r1 == null) goto L87;
            Integer r3 = Integer.valueOf(r1.getSilenceStatus());
        L89:
            if ((!Intrinsics.areEqual(r17, r3)) == false) goto L103;
            RoomContext r18 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r18 == null) goto L97;
            n r19 = r18.getCurTabId();
            if (r19 == null) goto L97;
            Long r110 = (Long) r19.getValue();
            if (r110 == null) goto L97;
            r7 = r110.longValue();
        L97:
            ChannelLinkUserInfo.LinkUserInfo r111 = r10.c;
            if (r111 != null) goto L100;
        L102:
            o62.a.b(r7, r2);
            return;
        L100:
            if (r111.getSilenceStatus() != 0) goto L102;
            r2 = true;
            goto L102
        L87:
            r3 = null;
            goto L89
        L83:
            r17 = null;
        L103:
            int r112 = o62.a.a;
            o62.a.a("livesdk_match_chat_member_voice_show", new HashMap());
            return;
        L70:
            if (r13.getLinkStatus() != 1) goto L71;
            return;
        L50:
            ChannelLinkUserInfo.LinkUserInfo r20 = r10.c;
            if (r20 == null) goto L67;
            if (r20.getLinkStatus() != 2) goto L67;
            RoomContext r113 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r113 == null) goto L61;
            n r114 = r113.getCurTabId();
            if (r114 == null) goto L61;
            Long r115 = (Long) r114.getValue();
            if (r115 == null) goto L61;
            r7 = r115.longValue();
        L61:
            ChannelLinkUserInfo.LinkUserInfo r116 = r10.c;
            if (r116 != null) goto L64;
        L66:
            o62.a.b(r7, r2);
            return;
        L64:
            if (r116.getSilenceStatus() != 0) goto L66;
            r2 = true;
            goto L66
        L5:
            if (Intrinsics.areEqual(r10.a.getCastSecUid(), r11.a.getCastSecUid()) == false) goto L44;
            ChannelLinkUserInfo.LinkUserInfo r4 = r10.c;
            if (r4 != null) goto L9;
        L25:
            ChannelLinkUserInfo.LinkUserInfo r5 = r10.c;
            if (r5 != null) goto L28;
        L29:
            ChannelLinkUserInfo.LinkUserInfo r6 = r11.c;
            if (r6 != null) goto L32;
        L33:
            ChannelLinkUserInfo.LinkUserInfo r8 = r10.c;
            if (r8 == null) goto L36;
            Integer r21 = Integer.valueOf(r8.getLinkStatus());
        L37:
            ChannelLinkUserInfo.LinkUserInfo r23 = r11.c;
            if (r23 == null) goto L40;
            Integer r24 = Integer.valueOf(r23.getLinkStatus());
        L42:
            if (Intrinsics.areEqual(r21, r24) == false) goto L44;
            return;
        L40:
            r24 = null;
            goto L42
        L36:
            r21 = null;
            goto L37
        L32:
            if (r6.getLinkStatus() == 2) goto L44;
        L28:
            if (r5.getLinkStatus() == 2) goto L44;
        L9:
            if (r4.getLinkStatus() != 2) goto L25;
            ChannelLinkUserInfo.LinkUserInfo r25 = r11.c;
            if (r25 == null) goto L25;
            if (r25.getLinkStatus() != 2) goto L25;
            ChannelLinkUserInfo.LinkUserInfo r26 = r10.c;
            if (r26 == null) goto L17;
            Integer r27 = Integer.valueOf(r26.getSilenceStatus());
        L18:
            ChannelLinkUserInfo.LinkUserInfo r28 = r11.c;
            if (r28 == null) goto L21;
            Integer r29 = Integer.valueOf(r28.getSilenceStatus());
        L23:
            if (Intrinsics.areEqual(r27, r29) == false) goto L25;
            return;
        L21:
            r29 = null;
            goto L23
        L17:
            r27 = null;
            goto L18
        }

        public ItemViewHolder(View r2, s22.a r3, a r4) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            Intrinsics.checkNotNullParameter(r3, "chatChannel");
            Intrinsics.checkNotNullParameter(r4, "itemClickListener");
            super(r2);
            this.r = r3;
            this.s = r4;
            View r5 = r2.findViewById(2131392014);
            this.c = r5;
            this.d = r2.findViewById(2131392002);
            this.e = (ChannelRingView) r2.findViewById(2131391994);
            this.f = (ChannelRingView) r2.findViewById(2131391997);
            this.g = (TextView) r2.findViewById(2131392058);
            this.h = (TextView) r2.findViewById(2131392065);
            this.i = r2.findViewById(2131379523);
            this.j = r2.findViewById(2131375323);
            this.k = r2.findViewById(2131381541);
            this.l = r2.findViewById(2131377733);
            this.m = r2.findViewById(2131384554);
            this.n = r2.findViewById(2131377734);
            this.o = r2.findViewById(2131384555);
            this.p = r2.findViewById(2131386677);
            this.q = r2.findViewById(2131386678);
            r5.setOnClickListener(x0.a(new AnonymousClass1(this)));
        }
    }

    public interface a {
        void a(ChannelLinkUserInfo r1);

        void b(ChannelLinkUserInfo r1);

        void c(ChannelLinkUserInfo r1);

        void d(ChannelLinkUserInfo r1);

        void e(ChannelLinkUserInfo r1);

        void f(ChannelLinkUserInfo r1);

        void g();

        void h(ChannelLinkUserInfo r1, boolean r2);

        void i(ChannelLinkUserInfo r1);

        void j(HSImageView r1, ChannelLinkUserInfo r2);
    }

    public final void e(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter((ItemViewHolder) r2, "holder");
    }

    public final void f(RecyclerView.ViewHolder r2) {
        ItemViewHolder r3 = (ItemViewHolder) r2;
        Intrinsics.checkNotNullParameter(r3, "holder");
        ValueAnimator r4 = r3.b;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.isRunning() == false) goto L9;
        r4.cancel();
        return;
    }

    public ChannelMemberListItemViewBinder(s22.a r2, ChannelMemberManagerDialog.b r3) {
        Intrinsics.checkNotNullParameter(r2, "chatChannel");
        Intrinsics.checkNotNullParameter(r3, "itemClickListener");
        this.b = r2;
        this.c = r3;
    }

    public static void h(ItemViewHolder r3, ChannelLinkUserInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "item");
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "userInfo");
        User r0 = r4.a;
        ImageUtil.loadRoundImage(r3.d, r0.getAvatarThumb());
        r3.g.setText(r0.getNickName());
        if (r4.b.a != ChannelLinkUserInfo.ChannelUserRole.Manager) goto L5;
        UtilityKotlinExtentionsKt.w(r3.i);
    L6:
        UtilityKotlinExtentionsKt.t(r3.h);
        if (ItemViewHolder.T3(r4) == false) goto L9;
        r3.X3(r4);
        ItemViewHolder.V3(r4, r3.a);
    L10:
        View r1 = r3.c;
        int r2 = c.a;
        r3.a(r1, c.c(r4, r3.r));
        r3.a = r4;
        return;
    L9:
        r3.W3(r4);
        goto L10
    L5:
        UtilityKotlinExtentionsKt.t(r3.i);
        goto L6
    }

    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r1, Object r2) {
        h((ItemViewHolder) r1, (ChannelLinkUserInfo) r2);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ItemViewHolder(r3.inflate(2131566390, r4, false), this.b, this.c);
    }

    public final void c(RecyclerView.ViewHolder r4, Object r5, List r6) {
        ItemViewHolder r7 = (ItemViewHolder) r4;
        ChannelLinkUserInfo r8 = (ChannelLinkUserInfo) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r6, "payloads");
        if (r6.size() != 0) goto L5;
        h(r7, r8);
        return;
    L5:
        Object r9 = ListProtector.get(r6, r6.size() - 1);
        if (r9 == null) goto L29;
        Iterator<String> r10 = ((Bundle) r9).keySet().iterator();
    L9:
        if (r10.hasNext() == false) goto L39;
        String r0 = r10.next();
        if (r0 == null) goto L9;
        if (r0.hashCode() != (-838773859)) goto L9;
        if (r0.equals("payload_key_channel_user_item_user_info") == false) goto L9;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "userInfo");
        if (r8.b.a != ChannelLinkUserInfo.ChannelUserRole.Manager) goto L21;
        UtilityKotlinExtentionsKt.w(r7.i);
    L22:
        UtilityKotlinExtentionsKt.t(r7.h);
        if (ItemViewHolder.T3(r8) == false) goto L25;
        r7.X3(r8);
        ItemViewHolder.V3(r8, r7.a);
    L26:
        View r1 = r7.c;
        int r2 = c.a;
        r3.a(r1, c.c(r8, r7.r));
        r7.a = r8;
        goto L9
    L25:
        r7.W3(r8);
        goto L26
    L21:
        UtilityKotlinExtentionsKt.t(r7.i);
        goto L22
    L39:
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
    }
}
