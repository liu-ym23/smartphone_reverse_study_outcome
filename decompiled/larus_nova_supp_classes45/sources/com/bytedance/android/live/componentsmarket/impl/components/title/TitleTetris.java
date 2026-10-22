package com.bytedance.android.live.componentsmarket.impl.components.title;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris;
import com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.config.a6;
import com.bytedance.android.livesdk.config.lj;
import com.bytedance.android.livesdk.config.qu0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPlatformComponentsData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomTitle;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/title/TitleTetris;", "Lcom/bytedance/android/live/componentsmarket/impl/components/BaseComponentsTetris;", "Lcom/bytedance/android/live/componentsmarket/impl/components/titledetail/a$a;", "Lo70/a;", "Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/a;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TitleTetris extends BaseComponentsTetris implements com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.InterfaceC0136a, o70.a, com.bytedance.android.livesdk.chatroom.vsplayer.model.a {
    public com.bytedance.android.livesdk.common.j A;
    public Disposable B;
    public HSImageView C;
    public Disposable D;
    public ObjectAnimator E;
    public boolean F;
    public final TitleTetris$timerListener$1 G;
    public TextView s;
    public ConstraintLayout t;
    public TextView u;
    public View v;
    public View w;
    public TextView x;
    public View y;
    public View z;

    public static final class a implements View.OnLongClickListener {
        public final /* synthetic */ ILiveSdkProjectModeService a;
        public final /* synthetic */ TitleTetris b;

        public a(ILiveSdkProjectModeService r1, TitleTetris r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r2) {
            FragmentActivity r3 = ((d90.a) this.b.K()).getContext();
            if (r3 == null) goto L7;
            ILiveSdkProjectModeService r0 = this.a;
            r0.initAndShowPerfTools(r3);
            return true;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TitleTetris a;

        public b(TitleTetris r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            TitleTetris.i0(this.a);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ TitleTetris a;

        public c(TitleTetris r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            TitleTetris.i0(this.a);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ TitleTetris a;

        public static final class a implements com.bytedance.android.livesdk.common.j.a {
            public final /* synthetic */ d a;

            public final void onEnd() {
                com.bytedance.android.livesdk.common.j r0 = this.a.a.A;
                if (r0 == null) goto L5;
                r0.cancelAnimation();
            L5:
                TitleTetris r1 = this.a.a;
                com.bytedance.android.livesdk.common.j r2 = r1.A;
                if (r2 == null) goto L9;
                r2.setTextWithFadingMode(r1.j0());
                return;
            }

            public final void onStart() {
                com.bytedance.android.livesdk.common.j r0 = this.a.a.A;
                if (r0 == null) goto L6;
                r0.textNeedLeftEdge(true);
                return;
            }

            public a(d r1) {
                this.a = r1;
            }
        }

        public d(TitleTetris r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.common.j r0 = this.a.A;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.startMarqueeIfNeed(new a(this));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ TitleTetris a;

        public e(TitleTetris r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.n0(true);
        }
    }

    public static final class f extends AnimatorListenerAdapter {
        public final /* synthetic */ TitleTetris a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            Intrinsics.checkNotNullParameter(r5, "animation");
            super.onAnimationEnd(r5);
            if (this.b == true) goto L7;
            ConstraintLayout r6 = this.a.t;
            if (r6 == null) goto L7;
            r6.setVisibility(8);
        L7:
            TitleTetris r7 = this.a;
            boolean r0 = this.b;
            ViewGroup r8 = r7.t;
            if (r8 == null) goto L27;
            float r1 = r8.getAlpha();
            float r2 = 1.0f;
            if (r0 == false) goto L15;
            if (r1 != 1.0f) goto L16;
        L17:
            boolean r3 = false;
        L18:
            if (r3 == true) goto L21;
            r8 = null;
        L21:
            if (r8 == null) goto L28;
            if (r0 == true) goto L25;
            r2 = 0.0f;
        L25:
            r8.setAlpha(r2);
            return;
        L28:
            return;
        L16:
            r3 = true;
            goto L18
        L15:
            if (r1 == 0.0f) goto L17;
        }

        public f(TitleTetris r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(new Class[]{bh1.a.class, bh1.b.class});
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, android.view.View.OnClickListener
    public final void onClick(View r1) {
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void V() {
        ILiveSdkProjectModeService r0 = jc1.k.f(ILiveSdkProjectModeService.class);
        if (r0 != null) goto L5;
    L9:
        View r1 = this.y;
        if (r1 == null) goto L12;
        r1.setOnClickListener(new b(this));
    L12:
        View r2 = this.v;
        if (r2 == null) goto L15;
        r2.setOnClickListener(new c(this));
    L15:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r3 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        ArrayList<com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.InterfaceC0136a> r4 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b;
        if (r4.contains(this) == true) goto L18;
        r4.add(this);
    L18:
        super.V();
        return;
    L5:
        if (r0.isPerfToolsDebug() == false) goto L9;
        View r5 = this.y;
        if (r5 == null) goto L9;
        r5.setOnLongClickListener(new a(r0, this));
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void W() {
        if ((this.p instanceof BaseTitleViewModel) == false) goto L211;
        d90.a r0 = (d90.a) K();
        Disposable r1 = null;
        if (r0 == null) goto L9;
        DataCenter r2 = r0.h;
        if (r2 == null) goto L9;
        Room r3 = z.o(r2);
    L10:
        this.q = r3;
        if (r3 == null) goto L15;
        RoomPlatformComponentsData r4 = r3.roomPlatformComponentsData;
        if (r4 == null) goto L15;
        RoomTitle r5 = r4.getRoomTitle();
    L16:
        if (r5 == null) goto L19;
        this.F = r5.isGameUIStyle();
    L19:
        if (this.F == true) goto L21;
    L117:
        ConstraintLayout r6 = this.t;
        if (r6 == null) goto L121;
        r6.setVisibility(0);
    L121:
        if (d90.c.i((d90.a) K()) == false) goto L132;
        if (this.F == false) goto L132;
        MiddlewareRoomContext r7 = d90.e.l((d90.d) K());
        if (r7 == null) goto L132;
        m r8 = r7.isShowTitleUIByClickScreen();
        if (r8 == null) goto L132;
        Observable r9 = r8.a();
        if (r9 == null) goto L132;
        r9.subscribe(new com.bytedance.android.live.componentsmarket.impl.components.title.a(this));
    L132:
        if (this.F == true) goto L134;
    L138:
        View r11 = this.w;
        if (r11 == null) goto L142;
        UtilityKotlinExtentionsKt.t(r11);
    L142:
        if (this.F == true) goto L144;
        TextView r12 = this.x;
        if (r12 == null) goto L166;
        r12.setTextSize(1, 16.0f);
    L166:
        com.bytedance.android.livesdk.common.j r13 = this.A;
        if (r13 == null) goto L169;
        r13.setTextSize(1, 16.0f);
    L169:
        Room r14 = this.q;
        if (r14 == null) goto L176;
        ViewModel r15 = this.p;
        if (r15 == null) goto L175;
        Intrinsics.checkNotNull(r14);
        ((BaseTitleViewModel) r15).setRoomInfo(r14);
        goto L176
    L175:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L176:
        ViewModel r16 = this.p;
        if (r16 == null) goto L210;
        LiveData<Boolean> r17 = ((BaseTitleViewModel) r16).isTvStatusShow();
        if (r17 == null) goto L181;
        r17.observe(this, new com.bytedance.android.live.componentsmarket.impl.components.title.b(this));
    L181:
        ViewModel r18 = this.p;
        if (r18 == null) goto L208;
        LiveData<String> r19 = ((BaseTitleViewModel) r18).getTitleText();
        if (r19 == null) goto L186;
        r19.observe(this, new com.bytedance.android.live.componentsmarket.impl.components.title.c(this));
    L186:
        ViewModel r21 = this.p;
        if (r21 == null) goto L206;
        LiveData<String> r22 = ((BaseTitleViewModel) r21).getDesText();
        if (r22 == null) goto L191;
        r22.observe(this, new com.bytedance.android.live.componentsmarket.impl.components.title.d(this));
    L191:
        ViewModel r23 = this.p;
        if (r23 == null) goto L204;
        LiveData<Boolean> r24 = ((BaseTitleViewModel) r23).isTitleIconShow();
        if (r24 == null) goto L196;
        r24.observe(this, new com.bytedance.android.live.componentsmarket.impl.components.title.e(this));
    L196:
        ViewModel r25 = this.p;
        if (r25 == null) goto L202;
        LiveData<Boolean> r26 = ((BaseTitleViewModel) r25).isPrefixImgShow();
        if (r26 == null) goto L211;
        r26.observe(this, new com.bytedance.android.live.componentsmarket.impl.components.title.f(this));
        goto L211
    L202:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L204:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L206:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L208:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L210:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L144:
        if (isScreenPortrait() == false) goto L157;
        ConstraintLayout r27 = this.t;
        if (r27 == null) goto L148;
        a1.k(r27, (int) t6.a(((d90.a) K()).getContext(), 36.0f));
    L148:
        TextView r28 = this.x;
        if (r28 == null) goto L151;
        r28.setTextSize(1, 13.0f);
    L151:
        TextView r29 = this.x;
        if (r29 == null) goto L154;
        r29.setPadding(0, 0, UtilityKotlinExtentionsKt.i(58), 0);
    L154:
        com.bytedance.android.livesdk.common.j r31 = this.A;
        if (r31 == null) goto L169;
        r31.setTextSize(1, 13.0f);
        goto L169
    L157:
        TextView r32 = this.x;
        if (r32 == null) goto L160;
        r32.setTextSize(1, 15.0f);
    L160:
        com.bytedance.android.livesdk.common.j r33 = this.A;
        if (r33 == null) goto L169;
        r33.setTextSize(1, 15.0f);
        goto L169
    L134:
        if (isScreenPortrait() == false) goto L138;
        View r34 = this.w;
        if (r34 == null) goto L142;
        UtilityKotlinExtentionsKt.w(r34);
        goto L142
    L21:
        if (d90.c.i((d90.a) K()) == false) goto L117;
        d90.a r35 = (d90.a) K();
        if (r35 == null) goto L27;
        DataCenter r36 = r35.h;
        if (r36 == null) goto L27;
        Integer r37 = (Integer) r36.get("data_screen_change_status", 0);
    L28:
        if (r37 != null) goto L30;
    L32:
        boolean r38 = false;
    L33:
        int r39 = o40.b.a;
        o r41 = j0.l().c(x.class);
        if (r41 != null) goto L37;
    L73:
        boolean r42 = false;
    L74:
        if (r42 == false) goto L79;
        if (r38 == true) goto L79;
        ConstraintLayout r43 = this.t;
        if (r43 == null) goto L121;
        r43.setVisibility(8);
    L79:
        MiddlewareRoomContext r44 = d90.e.l((d90.d) K());
        if (r44 == null) goto L121;
        r44.isShowTitleUIByClickScreen().setValue(Boolean.TRUE);
        ConstraintLayout r45 = this.t;
        if (r45 == null) goto L84;
        r45.setVisibility(0);
    L84:
        RoomContext r46 = d90.e.l((d90.d) K());
        Disposable r47 = this.D;
        if (r47 != null) goto L87;
    L91:
        LiveVisibilityControlContext.Companion.getClass();
        if (LiveVisibilityControlContext.a.a() == false) goto L111;
        DataCenter r48 = o3.f().getDataCenter();
        if (r48 == null) goto L99;
        IVisibilityControlBrickService r49 = jc1.k.f(IVisibilityControlBrickService.class);
        if (r49 == null) goto L99;
        IVisibilityControlService r51 = r49.provideVisibilityControlService(r48);
    L100:
        if (r51 == null) goto L111;
        DataCenter r52 = o3.f().getDataCenter();
        if (r52 == null) goto L107;
        IVisibilityControlBrickService r53 = jc1.k.f(IVisibilityControlBrickService.class);
        if (r53 == null) goto L107;
        IVisibilityControlService r54 = r53.provideVisibilityControlService(r52);
    L108:
        if (r54 == null) goto L110;
        Observable r55 = r54.startVisibilityTimer();
    L112:
        if (r55 == null) goto L116;
        Observable r56 = r55.observeOn(AndroidSchedulers.mainThread());
        if (r56 == null) goto L116;
        r1 = r56.subscribe(new k(r46));
    L116:
        this.D = r1;
        goto L121
    L110:
        r55 = null;
    L107:
        r54 = null;
    L99:
        r51 = null;
    L111:
        r55 = Observable.timer(((a6) lj.a.getValue()).a(), TimeUnit.SECONDS).map(j.a);
        goto L112
    L87:
        if (r47.isDisposed() == true) goto L91;
        Disposable r57 = this.D;
        if (r57 == null) goto L91;
        r57.dispose();
        goto L91
    L37:
        if (r41.getMap() == null) goto L73;
        String r58 = "";
        if (r41.getMap().containsKey("enter_from_merge") == false) goto L44;
        String r59 = (String) r41.getMap().get("enter_from_merge");
        if (r59 != null) goto L46;
        r59 = "";
    L46:
        if (r41.getMap().containsKey("enter_method") == false) goto L50;
        String r61 = (String) r41.getMap().get("enter_method");
        if (r61 != null) goto L52;
        r61 = "";
    L52:
        if (r41.getMap().containsKey("action_type") == false) goto L57;
        String r62 = (String) r41.getMap().get("action_type");
        if (r62 == null) goto L59;
        r58 = r62;
    L59:
        if ("homepage_hot".equals(r59) == true) goto L69;
        if ("homepage_follow".equals(r59) == true) goto L69;
        if ("homepage_tablive".equals(r59) == true) goto L69;
        if ("general_search".equals(r59) == true) goto L69;
        if ("search_result".equals(r59) == false) goto L73;
    L69:
        if ("live_cell".equals(r61) == false) goto L73;
        if ("click".equals(r58) == false) goto L73;
        r42 = true;
        goto L74
    L57:
        r58 = null;
        goto L59
    L50:
        r61 = null;
        goto L52
    L44:
        r59 = null;
        goto L46
    L30:
        if (r37.intValue() <= 0) goto L32;
        r38 = true;
    L27:
        r37 = null;
    L15:
        r5 = null;
    L9:
        r3 = null;
    L211:
        super.W();
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final o40.a c0() {
        return new s40.a();
    }

    public final String j0() {
        ViewModel r0 = this.p;
        if (r0 != null) goto L5;
    L14:
        return "";
    L5:
        if ((r0 instanceof BaseTitleViewModel) == false) goto L14;
        if (r0 == null) goto L13;
        String r1 = (String) ((BaseTitleViewModel) r0).getTitleText().getValue();
        if (r1 != null) goto L11;
        return "";
    L11:
        return r1;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    }

    public final boolean k0() {
        if (this.F == true) goto L5;
    L8:
        return true;
    L5:
        if (isScreenPortrait() == false) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        com.bytedance.android.livesdk.common.j r0 = this.A;
        if (r0 == null) goto L5;
        r0.cancelAnimation();
    L5:
        Disposable r1 = this.D;
        if (r1 != null) goto L8;
    L12:
        RoomContext r2 = ((d90.a) K()).b();
        if (r2 == null) goto L19;
        com.bytedance.live.datacontext.j r3 = r2.getRoomTitleAndAnchorNameTimer();
        if (r3 == null) goto L19;
        d9 r4 = (d9) r3.getValue();
        if (r4 == null) goto L19;
        r4.c(this.G);
    L19:
        Disposable r5 = this.B;
        if (r5 == null) goto L22;
        r5.dispose();
    L22:
        super.onDestroy();
        return;
    L8:
        if (r1.isDisposed() == true) goto L12;
        Disposable r6 = this.D;
        if (r6 == null) goto L12;
        r6.dispose();
        goto L12
    }

    public TitleTetris() {
        this.G = new TitleTetris$timerListener$1(this);
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        super.O();
        Disposable r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        m r1 = r0.getCurrentMatchId();
        if (r1 == null) goto L9;
        Observable r2 = r1.a();
        if (r2 == null) goto L9;
        r4 = r2.subscribe(new e(this));
    L9:
        this.B = r4;
        ConstraintLayout r3 = this.t;
        if (r3 == null) goto L13;
        r3.setPadding(0, 0, 0, 0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void d0() {
        DataCenter r0 = ((d90.a) K()).h;
        if (r0 == null) goto L6;
        r0.observe("data_is_hiding_landscape_buttons", this);
    L6:
        if (((Boolean) qu0.a.getValue()).booleanValue() == false) goto L14;
        DataCenter r1 = ((d90.a) K()).h;
        if (r1 == null) goto L10;
        r1.observe("data_room_title", this);
    L10:
        DataCenter r2 = ((d90.a) K()).h;
        if (r2 == null) goto L15;
        r2.observe("data_room_short_title", this);
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void f0() {
        this.w = Z().findViewById(2131388835);
        this.s = (TextView) Z().findViewById(2131391507);
        this.t = Z().findViewById(2131388896);
        this.x = (TextView) Z().findViewById(2131391606);
        this.u = (TextView) Z().findViewById(2131390479);
        this.v = Z().findViewById(2131388873);
        this.y = Z().findViewById(2131388843);
        this.z = Z().findViewById(2131388844);
        this.A = Z().findViewById(2131379652);
        this.C = (HSImageView) Z().findViewById(2131376497);
        super.f0();
        IVSPlayerService r0 = jc1.k.f(IVSPlayerService.class);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r1 = r0.provideVSPlayerViewControlService(((d90.a) K()).h);
    L6:
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r2 = r1;
        if (r2 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r2, PlayerViewControl.KEY.LandscapeRoomTitle, PlayerViewControl.Type.TOP, PlayerViewControl.Style.HIDE, Z(), 0.0f, true, false, this, 272);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.InterfaceC0136a
    public final void onHide() {
        if (isScreenPortrait() == false) goto L9;
        d90.a r0 = (d90.a) K();
        if (r0 == null) goto L9;
        DataCenter r1 = r0.h;
        if (r1 == null) goto L9;
        r1.put("data_media_introduction_showing", Boolean.FALSE);
    L9:
        View r2 = this.v;
        if (r2 == null) goto L18;
        ViewPropertyAnimator r3 = r2.animate();
        if (r3 == null) goto L18;
        ViewPropertyAnimator r4 = r3.rotation(0.0f);
        if (r4 == null) goto L18;
        ViewPropertyAnimator r5 = r4.setDuration(200);
        if (r5 == null) goto L18;
        ViewPropertyAnimator r6 = r5.setInterpolator(new DecelerateInterpolator());
    L19:
        if (r6 == null) goto L22;
        r6.start();
    L22:
        if (r3.l(((d90.a) K()).getContext()) == false) goto L24;
        r3.q(((d90.a) K()).getContext(), "已收起");
    L24:
        o0(null);
        return;
    L18:
        r6 = null;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.InterfaceC0136a
    public final void onShow() {
        if (isScreenPortrait() == false) goto L9;
        d90.a r0 = (d90.a) K();
        if (r0 == null) goto L9;
        DataCenter r1 = r0.h;
        if (r1 == null) goto L9;
        r1.put("data_media_introduction_showing", Boolean.TRUE);
    L9:
        View r2 = this.v;
        if (r2 == null) goto L18;
        ViewPropertyAnimator r3 = r2.animate();
        if (r3 == null) goto L18;
        ViewPropertyAnimator r4 = r3.rotation(180.0f);
        if (r4 == null) goto L18;
        ViewPropertyAnimator r5 = r4.setDuration(200);
        if (r5 == null) goto L18;
        ViewPropertyAnimator r6 = r5.setInterpolator(new DecelerateInterpolator());
    L19:
        if (r6 == null) goto L22;
        r6.start();
    L22:
        if (r3.l(((d90.a) K()).getContext()) == false) goto L24;
        r3.q(((d90.a) K()).getContext(), "已展开");
    L24:
        o0(null);
        return;
    L18:
        r6 = null;
        goto L19
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onStop() {
        super.onStop();
    }

    public static final void i0(TitleTetris r2) {
        Room r0 = r2.q;
        if (r0 == null) goto L134;
        RoomPlatformComponentsData r1 = r0.roomPlatformComponentsData;
        if (r1 == null) goto L136;
        RoomTitle r3 = r1.getRoomTitle();
        if (r3 == null) goto L137;
        String r4 = r3.getIntroduction();
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.length() != 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        return;
    L16:
        if (r2.isScreenPortrait() == false) goto L144;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r6 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        ConstraintLayout r7 = r2.t;
        Intrinsics.checkNotNull(r7);
        int r8 = r7.getWidth();
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.c = r7;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.d = r8;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r9 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r9 != null) goto L21;
    L23:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r11 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r11 != null) goto L26;
        return;
    L26:
        if (com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.c != null) goto L28;
        return;
    L28:
        if (com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.h != null) goto L30;
        return;
    L30:
        if (com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.l != null) goto L33;
        return;
    L33:
        if (r11.isShowing() == true) goto L146;
        View r12 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.h;
        ViewGroup.LayoutParams r13 = null;
        if (r12 == null) goto L61;
        ViewParent r14 = r12.getParent();
        if ((r14 instanceof ViewGroup) == true) goto L40;
        r14 = null;
    L40:
        ViewGroup r15 = (ViewGroup) r14;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.j = r15;
        if (r15 == null) goto L43;
        Integer r16 = Integer.valueOf(r15.indexOfChild(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.h));
    L44:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.i = r16;
        View r17 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.h;
        if (r17 == null) goto L47;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
    L48:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.k = r18;
        ViewGroup r19 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.j;
        if (r19 == null) goto L51;
        r19.removeView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.h);
    L51:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r21 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r21 == null) goto L56;
        ViewGroup r22 = r21.r3();
        if (r22 == null) goto L56;
        r22.removeAllViews();
    L56:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r23 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r23 == null) goto L61;
        ViewGroup r24 = r23.r3();
        if (r24 == null) goto L61;
        r24.addView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.h);
        goto L61
    L47:
        r18 = null;
        goto L48
    L43:
        r16 = null;
    L61:
        View r25 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.l;
        if (r25 == null) goto L92;
        ViewParent r26 = r25.getParent();
        if ((r26 instanceof ViewGroup) == true) goto L66;
        r26 = null;
    L66:
        ViewGroup r27 = (ViewGroup) r26;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.n = r27;
        if (r27 == null) goto L69;
        Integer r28 = Integer.valueOf(r27.indexOfChild(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.l));
    L70:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.m = r28;
        View r29 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.l;
        if (r29 == null) goto L73;
        ViewGroup.LayoutParams r31 = r29.getLayoutParams();
    L74:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.o = r31;
        ViewGroup r32 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.n;
        if (r32 == null) goto L77;
        r32.removeView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.l);
    L77:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r33 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r33 == null) goto L82;
        ViewGroup r34 = r33.B2();
        if (r34 == null) goto L82;
        r34.removeAllViews();
    L82:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r35 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r35 == null) goto L87;
        ViewGroup r36 = r35.B2();
        if (r36 == null) goto L87;
        r36.addView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.l);
    L87:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r37 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r37 == null) goto L92;
        ViewGroup r38 = r37.B2();
        if (r38 == null) goto L92;
        UtilityKotlinExtentionsKt.w(r38);
        goto L92
    L73:
        r31 = null;
        goto L74
    L69:
        r28 = null;
    L92:
        View r39 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.c;
        if (r39 == null) goto L127;
        ViewParent r41 = r39.getParent();
        if ((r41 instanceof ViewGroup) == true) goto L97;
        r41 = null;
    L97:
        ViewGroup r42 = (ViewGroup) r41;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f = r42;
        if (r42 == null) goto L100;
        Integer r43 = Integer.valueOf(r42.indexOfChild(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.c));
    L101:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.e = r43;
        View r44 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.c;
        if (r44 == null) goto L104;
        r13 = r44.getLayoutParams();
    L104:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.g = r13;
        ViewGroup r45 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.f;
        if (r45 == null) goto L107;
        r45.removeView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.c);
    L107:
        ViewGroup.LayoutParams r46 = new ConstraintLayout.LayoutParams(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.d, s1.f(52.0f));
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r47 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r47 == null) goto L112;
        ViewGroup r48 = r47.J4();
        if (r48 == null) goto L112;
        a1.j(r48, 16);
    L112:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r49 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r49 == null) goto L117;
        ViewGroup r51 = r49.J4();
        if (r51 == null) goto L117;
        r51.setLayoutParams(r46);
    L117:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r52 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r52 == null) goto L122;
        ViewGroup r53 = r52.J4();
        if (r53 == null) goto L122;
        r53.removeAllViews();
    L122:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r54 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r54 == null) goto L127;
        ViewGroup r55 = r54.J4();
        if (r55 == null) goto L127;
        r55.addView(com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.c);
        goto L127
    L100:
        r43 = null;
    L127:
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b r56 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a;
        if (r56 == null) goto L130;
        r56.y2();
    L130:
        Iterator<com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.InterfaceC0136a> r57 = com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.b.iterator();
    L132:
        if (r57.hasNext() == false) goto L147;
        r57.next().onShow();
        goto L132
    L147:
        return;
    L146:
        return;
    L21:
        if (r9.isShowing() != true) goto L23;
        com.bytedance.android.live.componentsmarket.impl.components.titledetail.a.a();
        return;
    L144:
        return;
    L13:
        r5 = false;
        goto L14
    L137:
        return;
    L136:
        return;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(t70.k r2) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return super.G(r2);
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final ViewModel a0(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "cxt");
        BaseTitleViewModel.a r0 = BaseTitleViewModel.Companion;
        BaseTitleViewModel.ComponentsType r1 = BaseTitleViewModel.ComponentsType.IS_VS;
        r0.getClass();
        return BaseTitleViewModel.a.a(r1, r3);
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final ConstraintLayout b0(t70.k r2) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (isScreenPortrait() == false) goto L5;
        int r0 = 2131567517;
    L6:
        ConstraintLayout r3 = r2.b(r0);
        if (r3 == null) goto L11;
        return r3;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L5:
        r0 = 2131567515;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canControlByPlayer(PlayerViewControl.KEY r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return d90.c.f((d90.a) K());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void g0(KVData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r5.getKey()) == true) goto L126;
        String r0 = r5.getKey();
        int r1 = r0.hashCode();
        Object r3 = null;
        if (r1 == 956730793) goto L51;
        if (r1 == 1511434086) goto L34;
        if (r1 == 1883240861) goto L14;
        return;
    L14:
        if (r0.equals("data_is_hiding_landscape_buttons") == false) goto L109;
        Object r6 = r5.getData();
        if ((r6 instanceof Boolean) == false) goto L19;
        r3 = r6;
    L19:
        Boolean r4 = (Boolean) r3;
        if (r4 == null) goto L110;
        boolean r7 = r4.booleanValue();
        if (this.F == true) goto L24;
        return;
    L24:
        if (isScreenPortrait() == true) goto L112;
        com.bytedance.android.livesdk.common.j r2 = this.A;
        if (r2 == null) goto L28;
        r2.cancelAnimation();
    L28:
        com.bytedance.android.livesdk.common.j r8 = this.A;
        if (r8 == null) goto L31;
        r8.scrollToOrigin();
    L31:
        if (r7 == true) goto L113;
        Z().postDelayed(new d(this), 800);
        return;
    L113:
        return;
    L112:
        return;
    L110:
        return;
    L109:
        return;
    L34:
        if (r0.equals("data_room_short_title") == true) goto L36;
        return;
    L36:
        if (k0() == false) goto L44;
        com.bytedance.android.livesdk.common.j r9 = this.A;
        if ((r9 instanceof FrameLayout) == false) goto L41;
        r3 = r9;
    L41:
        FrameLayout r11 = (FrameLayout) r3;
        if (r11 == null) goto L47;
        a1.m(r11, s1.f(0.0f));
    L47:
        o40.a r12 = this.r;
        if (r12 == null) goto L116;
        r12.c();
        return;
    L116:
        return;
    L44:
        TextView r13 = this.x;
        if (r13 == null) goto L47;
        a1.m(r13, s1.f(8.0f));
        goto L47
    L51:
        if (r0.equals("data_room_title") == false) goto L118;
        Object r14 = r5.getData();
        if ((r14 instanceof String) == false) goto L56;
        r3 = r14;
    L56:
        String r15 = (String) r3;
        if (r15 != null) goto L59;
        return;
    L59:
        if ((!Intrinsics.areEqual(r15, "")) == true) goto L61;
        return;
    L61:
        if (((Boolean) qu0.a.getValue()).booleanValue() == false) goto L77;
        DataCenter r16 = ((d90.a) K()).h;
        if (r16 == null) goto L71;
        Room r17 = z.o(r16);
        if (r17 == null) goto L71;
        RoomPlatformComponentsData r18 = r17.roomPlatformComponentsData;
        if (r18 == null) goto L71;
        RoomTitle r19 = r18.getRoomTitle();
        if (r19 == null) goto L71;
        r19.setTitle(r15);
    L71:
        ViewModel r21 = this.p;
        if (r21 == null) goto L75;
        ((BaseTitleViewModel) r21).titleText(r15);
        goto L77
    L75:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.componentsmarket.impl.components.title.model.BaseTitleViewModel");
    L77:
        if (k0() == false) goto L92;
        DataCenter r22 = ((d90.a) K()).h;
        if (r22 == null) goto L85;
        Room r23 = z.o(r22);
        if (r23 == null) goto L85;
        EpisodeExtraInfo r24 = r23.getEpisodeExtra2();
        if (r24 == null) goto L85;
        r24.setTitle(r15);
    L85:
        nm1.m r25 = pm1.f.l();
        if (r25 != null) goto L88;
    L90:
        n0(false);
        goto L92
    L88:
        if (r25.y(((d90.a) K()).h) != true) goto L90;
        return;
    L92:
        if (k0() == true) goto L94;
        TextView r26 = this.x;
        if (r26 == null) goto L104;
        r26.setEllipsize(TextUtils.TruncateAt.END);
    L104:
        TextView r27 = this.x;
        if (r27 == null) goto L125;
        r27.setText(r15);
        return;
    L125:
        return;
    L94:
        if (this.F == false) goto L98;
        com.bytedance.android.livesdk.common.j r28 = this.A;
        if (r28 == null) goto L121;
        r28.setTextWithFadingMode(r15);
        return;
    L121:
        return;
    L98:
        com.bytedance.android.livesdk.common.j r29 = this.A;
        if (r29 == null) goto L123;
        r29.setTextWithEllipsis(r15);
        return;
    L123:
        return;
    L118:
        return;
    }

    public final void l0(boolean r5) {
        ObjectAnimator r0 = this.E;
        if (r0 != null) goto L5;
    L9:
        ObjectAnimator r2 = null;
        if (r5 == false) goto L14;
        ConstraintLayout r3 = this.t;
        if (r3 == null) goto L17;
        r3.setVisibility(0);
        r2 = ObjectAnimator.ofFloat(this.t, LiveDegradeFpsAnimator.ALPHA, new float[]{0.0f, 1.0f});
    L17:
        this.E = r2;
        if (r2 == null) goto L20;
        r2.setDuration(200);
    L20:
        ObjectAnimator r1 = this.E;
        if (r1 == null) goto L23;
        r1.removeAllListeners();
    L23:
        ObjectAnimator r4 = this.E;
        if (r4 == null) goto L26;
        r4.start();
    L26:
        ObjectAnimator r6 = this.E;
        if (r6 == null) goto L30;
        r6.addListener(new f(this, r5));
        return;
    L30:
        return;
    L14:
        ConstraintLayout r7 = this.t;
        if (r7 == null) goto L17;
        r2 = ObjectAnimator.ofFloat(r7, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f});
        goto L17
    L5:
        if (r0.isRunning() != true) goto L9;
        ObjectAnimator r8 = this.E;
        if (r8 == null) goto L9;
        r8.cancel();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n0(boolean r6) {
        if (r6 == false) goto L41;
        String r1 = "";
        if (((d90.a) K()).h == null) goto L29;
        nm1.m r7 = pm1.f.l();
        if (r7 == null) goto L18;
        VSCameraInfo r8 = r7.K(((d90.a) K()).h);
        if (r8 == null) goto L18;
        if (r8.cameraType != VSCameraType.CAMERA_TYPE_MATCH.getValue()) goto L18;
        nm1.m r9 = pm1.f.l();
        if (r9 == null) goto L17;
        VSCameraInfo r11 = r9.K(((d90.a) K()).h);
        if (r11 == null) goto L17;
        final String r12 = r11.title;
        if (r12 == null) goto L17;
    L42:
        com.bytedance.android.livesdk.common.j r0 = this.A;
        FrameLayout r2 = null;
        if (r0 == null) goto L45;
        String r3 = r0.getOriginText();
    L47:
        if (r12.equals(r3) != true) goto L49;
        return;
    L49:
        com.bytedance.android.livesdk.common.j r4 = this.A;
        if (r4 == null) goto L53;
        r4.cancelAnimation();
    L53:
        if (k0() == false) goto L68;
        com.bytedance.android.livesdk.common.j r5 = this.A;
        if ((r5 instanceof FrameLayout) == true) goto L57;
        r5 = null;
    L57:
        FrameLayout r13 = (FrameLayout) r5;
        if (r13 == null) goto L60;
        r13.setAlpha(1.0f);
    L60:
        FrameLayout r14 = this.A;
        if ((r14 instanceof FrameLayout) == false) goto L64;
        r2 = r14;
    L64:
        FrameLayout r15 = r2;
        if (r15 == null) goto L67;
        UtilityKotlinExtentionsKt.w(r15);
    L67:
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.A, LiveDegradeFpsAnimator.ALPHA, new float[]{1.0f, 0.0f}).setDuration(200);
        Function1<Animator, Unit> r17 = new TitleTetris$updateTitle$1(this, r12);
        Intrinsics.checkNotNullParameter(r16, "$this$doOnComplete");
        Intrinsics.checkNotNullParameter(r17, "callback");
        r16.addListener(new com.bytedance.android.live.core.utils.e(r17));
        r16.start();
    L74:
        o0(r12);
        return;
    L68:
        TextView r18 = this.x;
        if (r18 == null) goto L71;
        r18.setEllipsize(TextUtils.TruncateAt.END);
    L71:
        TextView r19 = this.x;
        if (r19 == null) goto L74;
        r19.setText(r12);
        goto L74
    L45:
        r3 = null;
    L17:
        r12 = j0();
        ALogger.d("VSMediaMergeTitle", "currentVsTitle is " + r12 + " current cameratype is CAMERA_TYPE_MATCH");
    L18:
        Room r21 = this.q;
        if (r21 == null) goto L28;
        RoomPlatformComponentsData r22 = r21.roomPlatformComponentsData;
        if (r22 == null) goto L28;
        RoomTitle r23 = r22.getRoomTitle();
        if (r23 == null) goto L28;
        String r24 = r23.getTitle();
        if (r24 == null) goto L28;
        r1 = r24;
    L28:
        ALogger.d("VSMediaMergeTitle", "currentVsTitle is " + r1 + " current cameratype is not CAMERA_TYPE_MATCH");
    L40:
        r12 = r1;
        goto L42
    L29:
        Room r25 = this.q;
        if (r25 == null) goto L39;
        RoomPlatformComponentsData r26 = r25.roomPlatformComponentsData;
        if (r26 == null) goto L39;
        RoomTitle r27 = r26.getRoomTitle();
        if (r27 == null) goto L39;
        String r28 = r27.getTitle();
        if (r28 == null) goto L39;
        r1 = r28;
    L39:
        ALogger.d("VSMediaMergeTitle", "currentVsTitle is " + r1 + " current cameratype is not CAMERA_TYPE_MATCH");
        goto L40
    L41:
        r12 = j0();
        goto L42
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o0(String r11) {
        if (isScreenPortrait() == false) goto L50;
        d90.a r0 = (d90.a) K();
        String r1 = null;
        if (r0 == null) goto L9;
        DataCenter r2 = r0.h;
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.get("data_media_introduction_showing", Boolean.FALSE);
    L10:
        boolean r4 = Intrinsics.areEqual(r3, Boolean.TRUE);
        String r5 = "收起";
        if (((Boolean) m40.a.a.getValue()).booleanValue() == false) goto L27;
        View r6 = this.y;
        StringBuilder r7 = new StringBuilder();
        TextView r8 = this.x;
        if (r8 == null) goto L17;
        CharSequence r9 = r8.getText();
        if (r9 == null) goto L17;
        r1 = r9.toString();
    L17:
        r7.append(m0(r11, r1));
        r7.append(' ');
        if (r4 == true) goto L21;
        r5 = "展开";
    L21:
        r7.append(r5);
        r7.append(", 按钮");
        r3.a(r6, r7.toString());
        View r12 = this.z;
        if (r12 == null) goto L24;
        r12.setImportantForAccessibility(4);
    L24:
        View r13 = this.v;
        if (r13 == null) goto L51;
        r13.setImportantForAccessibility(2);
        return;
    L51:
        return;
    L27:
        TextView r14 = this.x;
        StringBuilder r15 = new StringBuilder();
        TextView r16 = this.x;
        if (r16 == null) goto L32;
        CharSequence r17 = r16.getText();
        if (r17 == null) goto L32;
        String r18 = r17.toString();
    L33:
        r15.append(m0(r11, r18));
        r15.append(' ');
        if (r4 == false) goto L36;
        String r19 = "收起";
    L37:
        r15.append(r19);
        r15.append(", 按钮");
        r3.a(r14, r15.toString());
        com.bytedance.android.livesdk.common.j r21 = this.A;
        if (r21 == null) goto L40;
        View r22 = r21.getA11yDescView();
    L41:
        StringBuilder r23 = new StringBuilder();
        com.bytedance.android.livesdk.common.j r24 = this.A;
        if (r24 == null) goto L44;
        r1 = r24.getContent();
    L44:
        r23.append(m0(r11, r1));
        r23.append(' ');
        if (r4 == true) goto L48;
        r5 = "展开";
    L48:
        r23.append(r5);
        r23.append(", 按钮");
        r3.a(r22, r23.toString());
        return;
    L40:
        r22 = null;
        goto L41
    L36:
        r19 = "展开";
    L32:
        r18 = null;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        g0((KVData) r1);
    }

    @Override // o70.a
    public void onEvent(o70.b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof bh1.b) == false) goto L11;
        int r4 = ((bh1.b) r3).a;
        View r0 = this.y;
        if (r0 == null) goto L7;
        r0.setTranslationY(r4);
    L7:
        View r1 = this.v;
        if (r1 == null) goto L23;
        r1.setTranslationY(r4);
        return;
    L23:
        return;
    L11:
        if ((r3 instanceof bh1.a) == false) goto L25;
        bh1.a r5 = (bh1.a) r3;
        boolean r2 = r5.a;
        boolean r6 = r5.b;
        if (r2 == false) goto L15;
        int r7 = 4;
    L16:
        View r8 = this.y;
        if (r8 == null) goto L19;
        r8.setVisibility(r7);
    L19:
        View r9 = this.v;
        if (r9 == null) goto L26;
        r9.setVisibility(r7);
        return;
    L26:
        return;
    L15:
        r7 = 0;
        goto L16
    }

    public static String m0(String r1, String r2) {
        if (ln1.a.a.a(r1) == true) goto L6;
        r1 = null;
    L6:
        if (r1 != null) goto L11;
        if (r2 != null) goto L10;
        r2 = "";
    L10:
        return r2;
    L11:
        return r1;
    }
}
