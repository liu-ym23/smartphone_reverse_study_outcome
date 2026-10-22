package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import fd2.v;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends MultiLinkAudioCommonGuestMicSeatBasicLayer {
    public FrameLayout A;
    public HSImageView B;
    public View C;
    public ConstraintLayout D;
    public LinearLayout E;
    public ViewGroup F;
    public Drawable G;
    public ConstraintLayout H;
    public boolean I;
    public final CompositeDisposable J;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.m K;
    public int z;

    public static final class a implements Runnable {
        public final /* synthetic */ l a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.l$a$a, reason: collision with other inner class name */
        public static final class C0051a extends q0 {
            public final /* synthetic */ py.k a;
            public final /* synthetic */ a b;

            public final void d(ImageInfo r4) {
                if ((r4 instanceof CloseableStaticBitmap) == false) goto L13;
                Bitmap r5 = ((CloseableStaticBitmap) r4).getUnderlyingBitmap();
                if (r5 != null) goto L7;
                return;
            L7:
                if (r5.isRecycled() == true) goto L15;
                Bitmap.Config r0 = r5.getConfig();
                if (r0 != null) goto L11;
                r0 = Bitmap.Config.ARGB_8888;
            L11:
                Bitmap r6 = r5.copy(r0, true);
                l r1 = this.b.a;
                r1.G = new BitmapDrawable(s1.getResources(), r6);
                return;
            L15:
                return;
            }

            public C0051a(py.k r1, a r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public a(l r1) {
            this.a = r1;
        }

        public final void a() {
            xg0.a r0 = this.a.c;
            if (r0 == null) goto L7;
            RecyclerView r1 = r0.getMicSeatRecyclerView();
            if (r1 == null) goto L7;
            float r2 = r1.getHeight();
        L8:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.c r3 = this.a.K.d();
            if (r3 == null) goto L11;
            float r4 = r3.b();
        L12:
            Ref.IntRef r5 = new Ref.IntRef();
            r5.element = s1.f(110.0f);
            if (r2 != 0.0f) goto L15;
        L25:
            View r6 = this.a.t;
            int r7 = r5.element;
            UIUtils.updateLayout(r6, r7, r7);
            float r8 = r5.element;
            int r9 = (int) (r8 + (0.165f * r8));
            UIUtils.updateLayout(this.a.C, r9, r9);
            ViewGroup r10 = this.a.F;
            if (r10 == null) goto L28;
            r10.setTranslationX(r5.element / 2.0f);
            r10.setTranslationY((-r5.element) / 2.0f);
        L28:
            ConstraintLayout r11 = this.a.H;
            View r12 = null;
            if (r11 == null) goto L31;
            ViewGroup.LayoutParams r13 = r11.getLayoutParams();
        L33:
            if ((r13 instanceof ConstraintLayout.LayoutParams) == true) goto L35;
            r13 = null;
        L35:
            ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13;
            if (r14 == null) goto L40;
            ((ViewGroup.MarginLayoutParams) r14).leftMargin = r9 - UtilityKotlinExtentionsKt.i(4);
            ConstraintLayout r15 = this.a.H;
            if (r15 == null) goto L40;
            r15.setLayoutParams(r14);
        L40:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r16 = this.a.K;
            if (r16.c == false) goto L43;
            int r17 = 0;
        L44:
            InteractiveSongContext.a r18 = InteractiveSongContext.Companion;
            MultiLinkGuestViewBinder.a r19 = this.a.e;
            if (r19 == null) goto L47;
            ch0.e r20 = r19.k;
        L49:
            if (InteractiveSongContext.a.d(r18, r20, r17, false, 4) == false) goto L81;
            l r21 = this.a;
            MultiLinkGuestViewBinder.a r22 = r21.e;
            if (r22 == null) goto L57;
            ch0.e r23 = r22.k;
            if (r23 == null) goto L57;
            ch0.h r24 = r23.b;
            if (r24 == null) goto L57;
            View r25 = r24.b;
        L58:
            r21.Q(true, r25);
            ViewGroup r26 = this.a.F;
            if (r26 == null) goto L61;
            r26.setVisibility(8);
        L61:
            View r27 = this.a.C;
            if (r27 == null) goto L64;
            r27.setVisibility(8);
        L64:
            HSImageView r28 = this.a.B;
            if (r28 == null) goto L67;
            ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        L69:
            if ((r29 instanceof ConstraintLayout.LayoutParams) == true) goto L71;
            r29 = null;
        L71:
            ConstraintLayout.LayoutParams r30 = (ConstraintLayout.LayoutParams) r29;
            if (r30 == null) goto L76;
            ((ViewGroup.MarginLayoutParams) r30).rightMargin = s1.f(8.0f);
            ((ViewGroup.MarginLayoutParams) r30).bottomMargin = s1.f(8.0f);
            r30.bottomToBottom = 0;
            r30.rightToRight = 0;
            HSImageView r31 = this.a.B;
            if (r31 == null) goto L76;
            r31.setLayoutParams(r30);
        L76:
            l r32 = this.a;
            xg0.a r33 = r32.c;
            if (r33 == null) goto L79;
            r12 = r33.Za(r32.z, 2131384387);
        L79:
            int r34 = r5.element;
            UIUtils.updateLayout(r12, r34, r34);
            return;
        L67:
            r29 = null;
        L57:
            r25 = null;
            goto L58
        L81:
            if (this.a.I() == false) goto L127;
            this.a.Q(false, null);
            ViewGroup r35 = this.a.F;
            if (r35 == null) goto L85;
            r35.setVisibility(8);
        L85:
            ILinkPlayerInfoBridge r36 = this.a.J();
            if (r36 == null) goto L163;
            Linkmic2DAvatar r37 = r36.getLinkmic2DAvatar();
            if (r37 == null) goto L164;
            py.k r38 = r37.getImage();
            if (r38 == null) goto L165;
            HSImageView r39 = this.a.h;
            if (r39 == null) goto L94;
            ViewGroup.LayoutParams r40 = r39.getLayoutParams();
        L96:
            if ((r40 instanceof ConstraintLayout.LayoutParams) == true) goto L98;
            r40 = null;
        L98:
            ViewGroup.LayoutParams r41 = (ConstraintLayout.LayoutParams) r40;
            if (r41 == null) goto L103;
            ((ConstraintLayout.LayoutParams) r41).bottomToBottom = 0;
            ((ConstraintLayout.LayoutParams) r41).endToEnd = 0;
            ((ConstraintLayout.LayoutParams) r41).startToStart = 0;
            ((ConstraintLayout.LayoutParams) r41).topToTop = 0;
            HSImageView r42 = this.a.h;
            if (r42 == null) goto L103;
            r42.setLayoutParams(r41);
        L103:
            HSImageView r43 = this.a.h;
            if (r43 == null) goto L106;
            r43.setBackground(null);
        L106:
            HSImageView r44 = this.a.B;
            if (r44 == null) goto L109;
            ViewGroup.LayoutParams r45 = r44.getLayoutParams();
        L111:
            if ((r45 instanceof ConstraintLayout.LayoutParams) == true) goto L113;
            r45 = null;
        L113:
            ConstraintLayout.LayoutParams r46 = (ConstraintLayout.LayoutParams) r45;
            if (r46 == null) goto L118;
            ((ViewGroup.MarginLayoutParams) r46).rightMargin = s1.f(8.0f);
            ((ViewGroup.MarginLayoutParams) r46).bottomMargin = s1.f(8.0f);
            r46.bottomToBottom = 0;
            r46.rightToRight = 0;
            HSImageView r47 = this.a.B;
            if (r47 == null) goto L118;
            r47.setLayoutParams(r46);
        L118:
            View r48 = this.a.C;
            if (r48 == null) goto L121;
            r48.setVisibility(8);
        L121:
            ConstraintLayout r49 = this.a.D;
            int r50 = r5.element;
            UIUtils.updateLayout(r49, r50, r50);
            l r51 = this.a;
            xg0.a r52 = r51.c;
            if (r52 == null) goto L124;
            r12 = r52.Za(r51.z, 2131384387);
        L124:
            int r53 = r5.element;
            UIUtils.updateLayout(r12, r53, r53);
            l r54 = this.a;
            HSImageView r55 = r54.h;
            if (r55 == null) goto L166;
            com.bytedance.android.live.ui.k.d(r55, r38, r54.G, ImageView.ScaleType.FIT_XY, s1.f(8.0f), new C0051a(r38, this));
            return;
        L166:
            return;
        L109:
            r45 = null;
            goto L111
        L94:
            r40 = null;
            goto L96
        L165:
            return;
        L164:
            return;
        L163:
            return;
        L127:
            this.a.Q(false, null);
            ViewGroup r56 = this.a.F;
            if (r56 == null) goto L130;
            r56.setVisibility(0);
        L130:
            HSImageView r57 = this.a.h;
            if (r57 == null) goto L133;
            ViewGroup.LayoutParams r58 = r57.getLayoutParams();
        L135:
            if ((r58 instanceof ConstraintLayout.LayoutParams) == true) goto L137;
            r58 = null;
        L137:
            ViewGroup.LayoutParams r59 = (ConstraintLayout.LayoutParams) r58;
            if (r59 == null) goto L142;
            ((ConstraintLayout.LayoutParams) r59).bottomToBottom = 2131389566;
            ((ConstraintLayout.LayoutParams) r59).endToEnd = 2131389566;
            ((ConstraintLayout.LayoutParams) r59).startToStart = 2131389566;
            ((ConstraintLayout.LayoutParams) r59).topToTop = 2131389566;
            HSImageView r60 = this.a.h;
            if (r60 == null) goto L142;
            r60.setLayoutParams(r59);
        L142:
            HSImageView r61 = this.a.B;
            if (r61 == null) goto L145;
            ViewGroup.LayoutParams r62 = r61.getLayoutParams();
        L147:
            if ((r62 instanceof ConstraintLayout.LayoutParams) == true) goto L149;
            r62 = null;
        L149:
            ConstraintLayout.LayoutParams r63 = (ConstraintLayout.LayoutParams) r62;
            if (r63 == null) goto L154;
            ((ViewGroup.MarginLayoutParams) r63).rightMargin = s1.f(8.0f);
            ((ViewGroup.MarginLayoutParams) r63).bottomMargin = s1.f(10.0f);
            r63.bottomToBottom = 2131389566;
            r63.rightToRight = 2131389566;
            HSImageView r65 = this.a.B;
            if (r65 == null) goto L154;
            r65.setLayoutParams(r63);
        L154:
            View r66 = this.a.C;
            if (r66 == null) goto L157;
            r66.setVisibility(0);
        L157:
            ConstraintLayout r67 = this.a.D;
            int r68 = r5.element;
            UIUtils.updateLayout(r67, r68, r68);
            l r69 = this.a;
            xg0.a r70 = r69.c;
            if (r70 == null) goto L160;
            r12 = r70.Za(r69.z, 2131384387);
        L160:
            int r71 = r5.element;
            UIUtils.updateLayout(r12, r71, r71);
            return;
        L145:
            r62 = null;
            goto L147
        L133:
            r58 = null;
            goto L135
        L47:
            r20 = null;
            goto L49
        L43:
            r17 = r16.getUiLayout();
            goto L44
        L31:
            r13 = null;
            goto L33
        L15:
            if (r2 == (-1.0f)) goto L25;
            if (r4 == 0.0f) goto L25;
            if (r4 == (-1.0f)) goto L25;
            float r72 = s1.G((int) r2);
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m.c r73 = this.a.K.d();
            if (r73 == null) goto L23;
            Number r74 = Integer.valueOf(r73.b());
        L24:
            r5.element = (int) ((r72 / r74.floatValue()) * s1.f(110.0f));
            goto L25
        L23:
            r74 = Float.valueOf(-1.0f);
            goto L24
        L11:
            r4 = -1.0f;
        L7:
            r2 = -1.0f;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ l a;

        public b(l r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            l r5 = this.a;
            MultiLinkGuestViewBinder.a r0 = r5.e;
            if (r0 == null) goto L6;
            r5.A(r0, r5.z);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ l a;

        public c(l r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            l r5 = this.a;
            MultiLinkGuestViewBinder.a r0 = r5.e;
            if (r0 == null) goto L6;
            r5.A(r0, r5.z);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ l a;

        public d(l r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            List r8 = (List) r7;
            MultiLinkGuestViewBinder.a r0 = this.a.e;
            View r1 = null;
            if (r0 == null) goto L11;
            ch0.e r2 = r0.k;
            if (r2 == null) goto L11;
            ILinkPlayerInfoBridge r3 = r2.a;
            if (r3 == null) goto L11;
            IBaseUser r4 = r3.getUser();
            if (r4 == null) goto L11;
            String r5 = r4.getIdString();
        L12:
            if (r5 != null) goto L14;
            return;
        L14:
            if (r5.length() != 0) goto L16;
            boolean r6 = true;
        L17:
            if (r6 == true) goto L55;
            Iterator<T> r9 = r8.iterator();
        L21:
            if (r9.hasNext() == false) goto L29;
            T r10 = r9.next();
            IBaseUser r11 = ((ch0.e) r10).a.getUser();
            if (r11 == null) goto L25;
            String r12 = r11.getIdString();
        L27:
            if (Intrinsics.areEqual(r12, r5) == false) goto L21;
        L30:
            ch0.e r13 = r10;
            if (r13 != null) goto L36;
            MultiLinkGuestViewBinder.a r14 = this.a.e;
            if (r14 == null) goto L35;
            r13 = r14.k;
            goto L36
        L35:
            r13 = null;
        L36:
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r15 = this.a.K;
            if (r15.c == false) goto L39;
            int r16 = 0;
        L41:
            if (InteractiveSongContext.a.d(InteractiveSongContext.Companion, r13, r16, false, 4) == false) goto L48;
            l r17 = this.a;
            if (r13 == null) goto L47;
            ch0.h r18 = r13.b;
            if (r18 == null) goto L47;
            r1 = r18.b;
        L47:
            r17.Q(true, r1);
            return;
        L48:
            this.a.Q(false, null);
            return;
        L39:
            r16 = r15.getUiLayout();
            goto L41
        L25:
            r12 = null;
            goto L27
        L29:
            r10 = (T) null;
            goto L30
        L55:
            return;
        L16:
            r6 = false;
        L11:
            r5 = null;
            goto L12
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final int o() {
        return 2131566567;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final boolean u() {
        return true;
    }

    public final void R() {
        LinearLayout r0 = this.E;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L10;
        r1 = r2;
    L10:
        ViewGroup.LayoutParams r3 = (ConstraintLayout.LayoutParams) r1;
        if (r3 == null) goto L16;
        ((ConstraintLayout.LayoutParams) r3).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) r3).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r3).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r3).topToTop = 0;
        LinearLayout r4 = this.E;
        if (r4 == null) goto L17;
        r4.setLayoutParams(r3);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkAudioFirstUserVirtualAvatarMicSeatBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer
    public final void M() {
        super.M();
        AnchorPauseTipsView r0 = this.j;
        if (r0 != null) goto L5;
    L9:
        R();
        AnchorPauseTipsView r1 = this.j;
        if (r1 == null) goto L13;
        String r2 = s1.B(2131919276);
        Intrinsics.checkNotNullParameter(r2, "title");
        ((TextView) r1._$_findCachedViewById(2131388920)).setVisibility(0);
        ((TextView) r1._$_findCachedViewById(2131367861)).setVisibility(8);
        ((TextView) r1._$_findCachedViewById(2131388920)).setText(r2);
        return;
    L13:
        return;
    L5:
        if (I() == false) goto L7;
        int r3 = s1.f(8.0f);
    L8:
        r0.c = true;
        r0.d = r3;
        r0.requestLayout();
        goto L9
    L7:
        r3 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c, jg0.f
    public final void onDetach() {
        super.onDetach();
        this.J.clear();
        com.bytedance.live.datacontext.n<v> r1 = null;
        Q(false, null);
        InteractiveSongContext r0 = InteractiveSongContext.Companion.getContext();
        if (r0 == null) goto L5;
        r1 = r0.getLyricsRecognizer();
    L5:
        ConstraintLayout r2 = this.H;
        if (r2 == null) goto L12;
        if (r1 == null) goto L13;
        v r3 = (v) r1.getValue();
        if (r3 == null) goto L14;
        r3.f(r2);
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void r() {
        super.r();
        q().post(new a(this));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void H(int r4) {
        super.H(r4);
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        MultiLinkGuestViewBinder.a r1 = this.e;
        if (r1 == null) goto L5;
        int r2 = r1.a;
    L7:
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.C0094a.d(Integer.valueOf(r2)) == true) goto L15;
        Map.Entry r3 = tc0.c.h().p;
        if (r3 == null) goto L15;
        g2 r5 = (g2) r3.getValue();
        if (r5 == null) goto L15;
        boolean r6 = true;
        if (r5.getRoomLinkSilenceStatus() != 1) goto L15;
    L16:
        if (r6 == false) goto L20;
        a1.m(this.B, 2131251753);
        HSImageView r7 = this.B;
        if (r7 == null) goto L28;
        r7.setVisibility(0);
        return;
    L28:
        return;
    L20:
        if (r4 == 0) goto L24;
        a1.m(this.B, 2131251871);
        HSImageView r8 = this.B;
        if (r8 == null) goto L30;
        r8.setVisibility(0);
        return;
    L30:
        return;
    L24:
        HSImageView r9 = this.B;
        if (r9 == null) goto L32;
        r9.setVisibility(8);
        return;
    L32:
        return;
    L15:
        r6 = false;
        goto L16
    L5:
        r2 = -1;
        goto L7
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer
    public final void K(IBaseUser r5) {
        Intrinsics.checkNotNullParameter(r5, "curUser");
        if (I() == false) goto L5;
        return;
    L5:
        if (this.K.getUiLayout() != 24) goto L7;
        ImageUtil.loadRoundImageAntiFlink(this.h, je0.d.n(r5, AvatarType.AVATAR_MEDIUM.getValue()), 0);
        return;
    L7:
        ImageUtil.loadRoundImageAntiFlink(this.h, je0.d.n(r5, AvatarType.AVATAR_LARGE.getValue()), 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.a(r3);
        ConstraintLayout r4 = q().findViewById(2131389565);
        this.D = q().findViewById(2131389890);
        this.A = (FrameLayout) q().findViewById(2131389568);
        this.B = q().findViewById(2131389675);
        this.C = q().findViewById(2131374158);
        this.F = (ViewGroup) q().findViewById(2131389467);
        this.H = q().findViewById(2131387087);
        InteractiveSongContext.a r5 = InteractiveSongContext.Companion;
        InteractiveSongContext r0 = r5.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<String> r1 = r0.getSingingGuestId();
        if (r1 == null) goto L11;
        Observable r2 = r1.a();
        if (r2 == null) goto L11;
        Disposable r6 = r2.subscribe(new b(this));
        if (r6 == null) goto L11;
        RxUtilKt.c(r6, this.J);
    L11:
        InteractiveSongContext r7 = r5.getContext();
        if (r7 == null) goto L20;
        com.bytedance.live.datacontext.m<Boolean> r8 = r7.isShowPlayer();
        if (r8 == null) goto L20;
        Observable r9 = r8.a();
        if (r9 == null) goto L20;
        Disposable r10 = r9.subscribe(new c(this));
        if (r10 == null) goto L20;
        RxUtilKt.c(r10, this.J);
    L20:
        LinkUserDataMergeContext.a r11 = LinkUserDataMergeContext.Companion;
        xg0.a r12 = this.c;
        if (r12 == null) goto L23;
        DataCenter r13 = r12.getDataCenter();
    L24:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r14 = LinkUserDataMergeContext.a.b(r11, r13);
        if (r14 == null) goto L34;
        BehaviorSubject<List<ch0.e>> r15 = r14.f();
        if (r15 == null) goto L35;
        Observable r16 = RxUtilKt.h(r15);
        if (r16 == null) goto L36;
        Disposable r17 = r16.subscribe(new d(this));
        if (r17 == null) goto L37;
        RxUtilKt.c(r17, this.J);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L23:
        r13 = null;
        goto L24
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void j(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.j(r3);
        AnchorPauseTipsView r4 = this.j;
        if (r4 != null) goto L5;
    L9:
        AnchorPauseTipsView r5 = this.j;
        if (r5 == null) goto L12;
        LinearLayout r6 = (LinearLayout) r5.findViewById(2131362581);
    L13:
        this.E = r6;
        R();
        return;
    L12:
        r6 = null;
        goto L13
    L5:
        if (I() == false) goto L7;
        int r0 = s1.f(8.0f);
    L8:
        r4.c = true;
        r4.d = r0;
        r4.requestLayout();
        goto L9
    L7:
        r0 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void A(MultiLinkGuestViewBinder.a r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        this.z = r5;
        super.A(r4, r5);
        InteractiveSongContext.a r6 = InteractiveSongContext.Companion;
        InteractiveSongContext r7 = r6.getContext();
        if (r7 == null) goto L7;
        com.bytedance.live.datacontext.n<v> r8 = r7.getLyricsRecognizer();
        if (r8 == null) goto L7;
        v r9 = (v) r8.getValue();
    L9:
        if (n() == 0) goto L11;
        boolean r0 = true;
    L12:
        InteractiveSongContext r10 = r6.getContext();
        if (r10 == null) goto L23;
        com.bytedance.live.datacontext.i<Boolean> r11 = r10.isFeed();
        if (r11 != null) goto L17;
        return;
    L17:
        if (r0 != ((Boolean) r11.getValue()).booleanValue()) goto L25;
        ConstraintLayout r12 = this.H;
        if (r12 == null) goto L26;
        if (r9 == null) goto L27;
        r9.o(r12.getContext(), r12, r0, this.K.getUiLayout());
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L23:
        return;
    L11:
        r0 = false;
    L7:
        r9 = null;
        goto L9
    }

    public final void Q(boolean r3, View r4) {
        if (r3 == true) goto L4;
    L34:
        if (r3 == false) goto L36;
        return;
    L36:
        if (this.I == false) goto L62;
        this.I = false;
        FrameLayout r5 = this.A;
        if (r5 == null) goto L40;
        r5.removeAllViews();
    L40:
        FrameLayout r6 = this.A;
        if (r6 == null) goto L43;
        UtilityKotlinExtentionsKt.t(r6);
    L43:
        HSImageView r7 = this.h;
        if (r7 == null) goto L46;
        UtilityKotlinExtentionsKt.w(r7);
    L46:
        xg0.a r8 = this.c;
        if (r8 == null) goto L50;
        r8.S4();
    L50:
        if (vm2.h.h0().f() == false) goto L63;
        com.bytedance.android.live.liveinteract.plantform.base.g r9 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r9 == null) goto L64;
        com.bytedance.android.live.ui.c r10 = r9.y4();
        if (r10 == null) goto L65;
        r10.n();
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    L4:
        if (this.I == true) goto L34;
        this.I = true;
        if (r4 == null) goto L8;
        ViewGroup r0 = UtilityKotlinExtentionsKt.p(r4);
    L10:
        if ((true ^ Intrinsics.areEqual(r0, this.A)) == false) goto L21;
        if (r4 == null) goto L21;
        ViewGroup r11 = UtilityKotlinExtentionsKt.p(r4);
        if (r11 == null) goto L15;
        r11.removeView(r4);
    L15:
        FrameLayout r12 = this.A;
        if (r12 == null) goto L18;
        r12.addView(r4);
    L18:
        FrameLayout r13 = this.A;
        if (r13 == null) goto L21;
        UtilityKotlinExtentionsKt.w(r13);
    L21:
        HSImageView r14 = this.h;
        if (r14 == null) goto L24;
        UtilityKotlinExtentionsKt.t(r14);
    L24:
        xg0.a r15 = this.c;
        if (r15 == null) goto L28;
        r15.S4();
    L28:
        if (vm2.h.h0().f() == false) goto L57;
        com.bytedance.android.live.liveinteract.plantform.base.g r16 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r16 == null) goto L58;
        com.bytedance.android.live.ui.c r17 = r16.y4();
        if (r17 == null) goto L59;
        r17.k();
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L8:
        r0 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void d(MultiLinkGuestViewBinder.a r1, int r2) {
        A(r1, r2);
    }

    public l(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r3, r4);
        this.K = r3;
        this.J = new CompositeDisposable();
    }
}
