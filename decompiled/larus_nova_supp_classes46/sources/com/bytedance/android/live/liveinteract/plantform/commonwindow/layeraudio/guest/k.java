package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.bytedance.android.livesdk.config.qb1;
import com.bytedance.android.livesdk.config.sa1;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k extends MultiLinkAudioCommonGuestMicSeatBasicLayer {
    public ConstraintLayout A;
    public FrameLayout B;
    public View C;
    public Drawable D;
    public final CompositeDisposable E;
    public boolean F;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.m G;
    public int z;

    public static final class a implements Runnable {
        public final /* synthetic */ k a;

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.k$a$a, reason: collision with other inner class name */
        public static final class C0050a extends q0 {
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
                k r1 = this.b.a;
                r1.D = new BitmapDrawable(s1.getResources(), r6);
                return;
            L15:
                return;
            }

            public C0050a(py.k r1, a r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public a(k r1) {
            this.a = r1;
        }

        public final void a() {
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r0 = this.a.G;
            if (r0.c == false) goto L5;
            int r1 = 0;
        L6:
            InteractiveSongContext.a r2 = InteractiveSongContext.Companion;
            MultiLinkGuestViewBinder.a r3 = this.a.e;
            ConstraintLayout.LayoutParams r4 = null;
            if (r3 == null) goto L9;
            ch0.e r5 = r3.k;
        L11:
            if (InteractiveSongContext.a.d(r2, r5, r1, false, 4) == false) goto L26;
            k r6 = this.a;
            MultiLinkGuestViewBinder.a r7 = r6.e;
            if (r7 == null) goto L19;
            ch0.e r8 = r7.k;
            if (r8 == null) goto L19;
            ch0.h r9 = r8.b;
            if (r9 == null) goto L19;
            r4 = r9.b;
        L19:
            r6.Q(true, r4);
            HSImageView r10 = this.a.i;
            if (r10 == null) goto L22;
            r10.setVisibility(8);
        L22:
            View r11 = this.a.C;
            if (r11 == null) goto L101;
            r11.setVisibility(8);
            return;
        L101:
            return;
        L26:
            if (this.a.I() == false) goto L69;
            this.a.Q(false, null);
            HSImageView r12 = this.a.i;
            if (r12 == null) goto L30;
            r12.setVisibility(8);
        L30:
            ILinkPlayerInfoBridge r13 = this.a.J();
            if (r13 == null) goto L103;
            Linkmic2DAvatar r14 = r13.getLinkmic2DAvatar();
            if (r14 == null) goto L104;
            py.k r15 = r14.getImage();
            if (r15 == null) goto L105;
            View r16 = this.a.t;
            if (r16 == null) goto L39;
            ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        L41:
            if ((r17 instanceof ConstraintLayout.LayoutParams) == true) goto L43;
            r17 = null;
        L43:
            ViewGroup.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
            if (r18 == null) goto L48;
            ((ConstraintLayout.LayoutParams) r18).startToEnd = -1;
            ((ConstraintLayout.LayoutParams) r18).endToStart = -1;
            ((ConstraintLayout.LayoutParams) r18).bottomToBottom = 0;
            ((ConstraintLayout.LayoutParams) r18).endToEnd = 0;
            ((ConstraintLayout.LayoutParams) r18).startToStart = 0;
            ((ConstraintLayout.LayoutParams) r18).topToTop = 0;
            View r19 = this.a.t;
            if (r19 == null) goto L48;
            r19.setLayoutParams(r18);
        L48:
            HSImageView r20 = this.a.h;
            if (r20 == null) goto L51;
            ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        L53:
            if ((r21 instanceof ConstraintLayout.LayoutParams) == true) goto L55;
            r21 = null;
        L55:
            ViewGroup.LayoutParams r22 = (ConstraintLayout.LayoutParams) r21;
            if (r22 == null) goto L60;
            ((ConstraintLayout.LayoutParams) r22).bottomToBottom = 0;
            ((ConstraintLayout.LayoutParams) r22).endToEnd = 0;
            ((ConstraintLayout.LayoutParams) r22).startToStart = 0;
            ((ConstraintLayout.LayoutParams) r22).topToTop = 0;
            HSImageView r23 = this.a.h;
            if (r23 == null) goto L60;
            r23.setLayoutParams(r22);
        L60:
            View r24 = this.a.C;
            if (r24 == null) goto L63;
            r24.setVisibility(8);
        L63:
            HSImageView r25 = this.a.h;
            if (r25 == null) goto L66;
            r25.setBackground(null);
        L66:
            k r26 = this.a;
            HSImageView r27 = r26.h;
            if (r27 == null) goto L106;
            com.bytedance.android.live.ui.k.d(r27, r15, r26.D, ImageView.ScaleType.FIT_XY, s1.f(8.0f), new C0050a(r15, this));
            return;
        L106:
            return;
        L51:
            r21 = null;
            goto L53
        L39:
            r17 = null;
            goto L41
        L105:
            return;
        L104:
            return;
        L103:
            return;
        L69:
            this.a.Q(false, null);
            HSImageView r28 = this.a.i;
            if (r28 == null) goto L72;
            r28.setVisibility(0);
        L72:
            View r29 = this.a.t;
            if (r29 == null) goto L75;
            ViewGroup.LayoutParams r30 = r29.getLayoutParams();
        L77:
            if ((r30 instanceof ConstraintLayout.LayoutParams) == true) goto L79;
            r30 = null;
        L79:
            ViewGroup.LayoutParams r31 = (ConstraintLayout.LayoutParams) r30;
            if (r31 == null) goto L84;
            ((ConstraintLayout.LayoutParams) r31).endToEnd = -1;
            ((ConstraintLayout.LayoutParams) r31).startToStart = -1;
            ((ConstraintLayout.LayoutParams) r31).topToTop = -1;
            ((ConstraintLayout.LayoutParams) r31).startToEnd = 2131374152;
            ((ConstraintLayout.LayoutParams) r31).endToStart = 2131374155;
            ((ConstraintLayout.LayoutParams) r31).bottomToBottom = 0;
            View r32 = this.a.t;
            if (r32 == null) goto L84;
            r32.setLayoutParams(r31);
        L84:
            HSImageView r33 = this.a.h;
            if (r33 == null) goto L87;
            ConstraintLayout.LayoutParams r34 = r33.getLayoutParams();
        L89:
            if ((r34 instanceof ConstraintLayout.LayoutParams) == false) goto L92;
            r4 = r34;
        L92:
            ConstraintLayout.LayoutParams r35 = r4;
            if (r35 == null) goto L97;
            r35.bottomToBottom = 2131374117;
            r35.endToEnd = 2131374117;
            r35.startToStart = 2131374117;
            r35.topToTop = 2131374117;
            HSImageView r36 = this.a.h;
            if (r36 == null) goto L97;
            r36.setLayoutParams(r35);
        L97:
            View r37 = this.a.C;
            if (r37 == null) goto L108;
            r37.setVisibility(0);
            return;
        L108:
            return;
        L87:
            r34 = null;
            goto L89
        L75:
            r30 = null;
            goto L77
        L9:
            r5 = null;
            goto L11
        L5:
            r1 = r0.getUiLayout();
            goto L6
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
        public final /* synthetic */ k a;

        public b(k r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            com.bytedance.android.livesdk.event.f r2 = (com.bytedance.android.livesdk.event.f) r1;
            this.a.R();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ k a;

        public c(k r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            k r5 = this.a;
            MultiLinkGuestViewBinder.a r0 = r5.e;
            if (r0 == null) goto L6;
            r5.A(r0, r5.z);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ k a;

        public d(k r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            k r5 = this.a;
            MultiLinkGuestViewBinder.a r0 = r5.e;
            if (r0 == null) goto L6;
            r5.A(r0, r5.z);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ k a;

        public e(k r1) {
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
            com.bytedance.android.live.liveinteract.plantform.commonwindow.m r15 = this.a.G;
            if (r15.c == false) goto L39;
            int r16 = 0;
        L41:
            if (InteractiveSongContext.a.d(InteractiveSongContext.Companion, r13, r16, false, 4) == false) goto L48;
            k r17 = this.a;
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
        return 2131566576;
    }

    public final void R() {
        pn0.f r0 = this.G.d;
        if (r0 == null) goto L20;
        List<pn0.f.c> r1 = r0.d;
        if (r1 == null) goto L21;
        pn0.f.c r2 = (pn0.f.c) CollectionsKt.firstOrNull(r1);
        if (r2 == null) goto L22;
        int r3 = r2.f;
        ConstraintLayout r4 = this.A;
        if (r4 == null) goto L11;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
    L12:
        if (r5 != null) goto L14;
        return;
    L14:
        if (r5.height == r3) goto L24;
        r5.height = r3;
        ConstraintLayout r6 = this.A;
        if (r6 == null) goto L18;
        r6.setLayoutParams(r5);
    L18:
        q().invalidate();
        return;
    L24:
        return;
    L11:
        r5 = null;
        goto L12
    L22:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonFirstUserEnlargeStageMicSeatBasicLayer.name();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, jg0.c, jg0.f
    public final void onDetach() {
        super.onDetach();
        this.E.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void r() {
        super.r();
        q().post(new a(this));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer
    public final void K(IBaseUser r5) {
        Intrinsics.checkNotNullParameter(r5, "curUser");
        if (I() == false) goto L5;
        return;
    L5:
        if (this.G.getUiLayout() != 24) goto L7;
        ImageUtil.loadRoundImageAntiFlink(this.h, je0.d.n(r5, AvatarType.AVATAR_MEDIUM.getValue()), 0);
        return;
    L7:
        ImageUtil.loadRoundImageAntiFlink(this.h, je0.d.n(r5, AvatarType.AVATAR_LARGE.getValue()), 0);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.c, jg0.f
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.a(r3);
        this.A = q().findViewById(2131389565);
        this.B = (FrameLayout) q().findViewById(2131389568);
        this.C = q().findViewById(2131374158);
        Disposable r4 = xs2.b.a().b(com.bytedance.android.livesdk.event.f.class).subscribe(new b(this));
        if (r4 == null) goto L5;
        RxUtilKt.c(r4, this.E);
    L5:
        InteractiveSongContext.a r5 = InteractiveSongContext.Companion;
        InteractiveSongContext r0 = r5.getContext();
        if (r0 == null) goto L14;
        com.bytedance.live.datacontext.m<String> r1 = r0.getSingingGuestId();
        if (r1 == null) goto L14;
        Observable r2 = r1.a();
        if (r2 == null) goto L14;
        Disposable r6 = r2.subscribe(new c(this));
        if (r6 == null) goto L14;
        RxUtilKt.c(r6, this.E);
    L14:
        InteractiveSongContext r7 = r5.getContext();
        if (r7 == null) goto L23;
        com.bytedance.live.datacontext.m<Boolean> r8 = r7.isShowPlayer();
        if (r8 == null) goto L23;
        Observable r9 = r8.a();
        if (r9 == null) goto L23;
        Disposable r10 = r9.subscribe(new d(this));
        if (r10 == null) goto L23;
        RxUtilKt.c(r10, this.E);
    L23:
        LinkUserDataMergeContext.a r11 = LinkUserDataMergeContext.Companion;
        xg0.a r12 = this.c;
        if (r12 == null) goto L26;
        DataCenter r13 = r12.getDataCenter();
    L27:
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r14 = LinkUserDataMergeContext.a.b(r11, r13);
        if (r14 == null) goto L37;
        BehaviorSubject<List<ch0.e>> r15 = r14.f();
        if (r15 == null) goto L38;
        Observable r16 = RxUtilKt.h(r15);
        if (r16 == null) goto L39;
        Disposable r17 = r16.subscribe(new e(this));
        if (r17 == null) goto L40;
        RxUtilKt.c(r17, this.E);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L26:
        r13 = null;
        goto L27
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void A(MultiLinkGuestViewBinder.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        this.z = r3;
        super.A(r2, r3);
        R();
    }

    public final void Q(boolean r3, View r4) {
        if (r3 == true) goto L4;
    L34:
        if (r3 == false) goto L36;
        return;
    L36:
        if (this.F == false) goto L62;
        this.F = false;
        FrameLayout r5 = this.B;
        if (r5 == null) goto L40;
        r5.removeAllViews();
    L40:
        FrameLayout r6 = this.B;
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
        if (((qb1) sa1.a.getValue()).f() == false) goto L63;
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
        if (this.F == true) goto L34;
        this.F = true;
        if (r4 == null) goto L8;
        ViewGroup r0 = UtilityKotlinExtentionsKt.p(r4);
    L10:
        if ((true ^ Intrinsics.areEqual(r0, this.B)) == false) goto L21;
        if (r4 == null) goto L21;
        ViewGroup r11 = UtilityKotlinExtentionsKt.p(r4);
        if (r11 == null) goto L15;
        r11.removeView(r4);
    L15:
        FrameLayout r12 = this.B;
        if (r12 == null) goto L18;
        r12.addView(r4);
    L18:
        FrameLayout r13 = this.B;
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
        if (((qb1) sa1.a.getValue()).f() == false) goto L57;
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

    public k(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r3, r4);
        this.G = r3;
        this.E = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g
    public final void B(MultiLinkGuestViewBinder.a r2, int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "itemData");
        Intrinsics.checkNotNullParameter(r4, "payload");
        super.B(r2, r3, r4);
        R();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g, jg0.f
    public final /* bridge */ /* synthetic */ void k(MultiLinkGuestViewBinder.a r1, int r2, Bundle r3) {
        B(r1, r2, r3);
    }
}
