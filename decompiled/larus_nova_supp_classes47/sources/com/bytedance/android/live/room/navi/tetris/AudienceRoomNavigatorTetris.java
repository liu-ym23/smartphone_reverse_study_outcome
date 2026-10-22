package com.bytedance.android.live.room.navi.tetris;

import am2.x;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.f0;
import com.bytedance.android.live.core.tetris.layer.core.element.widget.WidgetElement;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.view.EllipsizedScrollTextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.live.room.a0;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.ui.d9;
import com.bytedance.android.livesdk.interactivity.api.IBaseDiggService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSTitleIcon;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraType;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/navi/tetris/AudienceRoomNavigatorTetris;", "Lcom/bytedance/android/live/room/navi/tetris/RoomNavigatorTetris;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/room/a0$a;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceRoomNavigatorTetris extends RoomNavigatorTetris implements Observer<KVData>, a0.a {
    public HSImageView A;
    public TextView B;
    public TextView C;
    public View D;
    public View E;
    public com.bytedance.android.livesdk.common.j F;
    public final CompositeDisposable G;
    public final AudienceRoomNavigatorTetris$timerListener$1 H;
    public WidgetElement v;
    public Disposable w;
    public Disposable x;
    public FrameLayout y;
    public EllipsizedScrollTextView z;

    public static final class a implements View.OnLongClickListener {
        public final /* synthetic */ l81.n a;
        public final /* synthetic */ AudienceRoomNavigatorTetris b;

        public a(l81.n r1, AudienceRoomNavigatorTetris r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r2) {
            FragmentActivity r3 = this.b.K().getContext();
            if (r3 == null) goto L7;
            l81.n r0 = this.a;
            r0.a(r3);
            return true;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AudienceRoomNavigatorTetris a;

        public b(AudienceRoomNavigatorTetris r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            o r4 = z51.a.h(this.a.s, 2);
            if (r4 == null) goto L140;
            com.bytedance.live.datacontext.m r5 = r4.getRoom();
            if (r5 == null) goto L142;
            IRoom r6 = (IRoom) r5.getValue();
            if (r6 == null) goto L143;
            String r7 = r6.getIntroduction();
            if (r7 != null) goto L11;
            return;
        L11:
            if (r7.length() != 0) goto L13;
            boolean r8 = true;
        L14:
            if (r8 == true) goto L149;
            a0.b r9 = a0.a;
            AudienceRoomNavigatorTetris r10 = this.a;
            a0.c = r10.t;
            a0.k = r10.p;
            String r12 = r10.W();
            if (r12 == null) goto L19;
            Intrinsics.checkNotNullParameter(r12, "title");
            a0.o = r12;
        L19:
            a0.b r13 = a0.a;
            if (r13 != null) goto L22;
        L24:
            ALogger.e("VSLiveDetailService", "showVSLiveDetail");
            a0.b r14 = a0.a;
            if (r14 != null) goto L27;
            return;
        L27:
            if (a0.c != null) goto L29;
            return;
        L29:
            if (a0.g != null) goto L31;
            return;
        L31:
            if (a0.k != null) goto L34;
            return;
        L34:
            if (r14.isShowing() == true) goto L151;
            View r15 = a0.g;
            ViewGroup.LayoutParams r0 = null;
            if (r15 == null) goto L62;
            ViewParent r16 = r15.getParent();
            if ((r16 instanceof ViewGroup) == true) goto L41;
            r16 = null;
        L41:
            ViewGroup r17 = (ViewGroup) r16;
            a0.i = r17;
            if (r17 == null) goto L44;
            Integer r18 = Integer.valueOf(r17.indexOfChild(a0.g));
        L45:
            a0.h = r18;
            View r19 = a0.g;
            if (r19 == null) goto L48;
            ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        L49:
            a0.j = r20;
            ViewGroup r22 = a0.i;
            if (r22 == null) goto L52;
            r22.removeView(a0.g);
        L52:
            a0.b r23 = a0.a;
            if (r23 == null) goto L57;
            ViewGroup r24 = r23.r3();
            if (r24 == null) goto L57;
            r24.removeAllViews();
        L57:
            a0.b r25 = a0.a;
            if (r25 == null) goto L62;
            ViewGroup r26 = r25.r3();
            if (r26 == null) goto L62;
            r26.addView(a0.g);
            goto L62
        L48:
            r20 = null;
            goto L49
        L44:
            r18 = null;
        L62:
            View r27 = a0.k;
            if (r27 == null) goto L93;
            ViewParent r28 = r27.getParent();
            if ((r28 instanceof ViewGroup) == true) goto L67;
            r28 = null;
        L67:
            ViewGroup r29 = (ViewGroup) r28;
            a0.m = r29;
            if (r29 == null) goto L70;
            Integer r30 = Integer.valueOf(r29.indexOfChild(a0.k));
        L71:
            a0.l = r30;
            View r32 = a0.k;
            if (r32 == null) goto L74;
            ViewGroup.LayoutParams r33 = r32.getLayoutParams();
        L75:
            a0.n = r33;
            ViewGroup r34 = a0.m;
            if (r34 == null) goto L78;
            r34.removeView(a0.k);
        L78:
            a0.b r35 = a0.a;
            if (r35 == null) goto L83;
            ViewGroup r36 = r35.B2();
            if (r36 == null) goto L83;
            r36.removeAllViews();
        L83:
            a0.b r37 = a0.a;
            if (r37 == null) goto L88;
            ViewGroup r38 = r37.B2();
            if (r38 == null) goto L88;
            r38.addView(a0.k);
        L88:
            a0.b r39 = a0.a;
            if (r39 == null) goto L93;
            ViewGroup r40 = r39.B2();
            if (r40 == null) goto L93;
            UtilityKotlinExtentionsKt.w(r40);
            goto L93
        L74:
            r33 = null;
            goto L75
        L70:
            r30 = null;
        L93:
            View r42 = a0.c;
            if (r42 == null) goto L128;
            ViewParent r43 = r42.getParent();
            if ((r43 instanceof ViewGroup) == true) goto L98;
            r43 = null;
        L98:
            ViewGroup r44 = (ViewGroup) r43;
            a0.e = r44;
            if (r44 == null) goto L101;
            Integer r45 = Integer.valueOf(r44.indexOfChild(a0.c));
        L102:
            a0.d = r45;
            View r46 = a0.c;
            if (r46 == null) goto L105;
            r0 = r46.getLayoutParams();
        L105:
            a0.f = r0;
            ViewGroup r47 = a0.e;
            if (r47 == null) goto L108;
            r47.removeView(a0.c);
        L108:
            Rect r48 = new Rect();
            View r1 = a0.c;
            if (r1 == null) goto L111;
            r1.getGlobalVisibleRect(r48);
        L111:
            a0.b r2 = a0.a;
            if (r2 == null) goto L118;
            ViewGroup r49 = r2.J4();
            if (r49 == null) goto L118;
            ViewGroup.LayoutParams r50 = r49.getLayoutParams();
            if (r50 == null) goto L118;
            r50.width = r48.width();
        L118:
            a0.b r52 = a0.a;
            if (r52 == null) goto L123;
            ViewGroup r53 = r52.J4();
            if (r53 == null) goto L123;
            r53.removeAllViews();
        L123:
            a0.b r54 = a0.a;
            if (r54 == null) goto L128;
            ViewGroup r55 = r54.J4();
            if (r55 == null) goto L128;
            r55.addView(a0.c);
            goto L128
        L101:
            r45 = null;
        L128:
            a0.b r56 = a0.a;
            if (r56 == null) goto L133;
            TextView r57 = r56.Jp();
            if (r57 == null) goto L133;
            r57.setText(a0.o);
        L133:
            a0.b r58 = a0.a;
            if (r58 == null) goto L136;
            r58.y2();
        L136:
            Iterator<a0.a> r59 = a0.b.iterator();
        L138:
            if (r59.hasNext() == false) goto L152;
            r59.next().onShow();
            goto L138
        L152:
            return;
        L151:
            return;
        L22:
            if (r13.isShowing() != true) goto L24;
            a0.a();
            return;
        L149:
            return;
        L13:
            r8 = false;
            goto L14
        L143:
            return;
        L142:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AudienceRoomNavigatorTetris a;

        public c(AudienceRoomNavigatorTetris r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            AudienceRoomNavigatorTetris r0 = this.a;
            r0.Z((IRoom) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AudienceRoomNavigatorTetris a;

        public d(AudienceRoomNavigatorTetris r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.updateTitle();
        }
    }

    public final void O() {
        if (d90.e.d(K()) == false) goto L6;
        UIUtils.setViewVisibility(this.r, 8);
        return;
    L6:
        DataCenter r0 = K().h;
        if (r0 != null) goto L9;
    L10:
        LiveMode r1 = LiveMode.VIDEO;
    L11:
        IRoom r8 = d90.e.j(K());
        DataCenter r2 = K().h;
        this.s = r2;
        if (r2 == null) goto L14;
        r2.observeForever("cmd_update_mic_room_due_to_part_show", this);
    L14:
        DataCenter r3 = this.s;
        if (r3 == null) goto L17;
        r3.observeForever("cmd_widget_loaded", this);
    L17:
        DataCenter r4 = this.s;
        if (r4 == null) goto L20;
        r4.observe("data_room_title", this);
    L20:
        MiddlewareRoomContext r5 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.s, 0, 2);
        boolean r13 = false;
        if (r5 == null) goto L29;
        com.bytedance.live.datacontext.n r6 = r5.getExternalConfigJudger();
        if (r6 == null) goto L29;
        IExternalConfigJudger r7 = (IExternalConfigJudger) r6.getValue();
        if (r7 == null) goto L29;
        if (r7.disableUserLeave() != true) goto L29;
        boolean r14 = true;
    L30:
        DataCenter r9 = this.s;
        Disposable r15 = null;
        if (r9 == null) goto L33;
        IRoom r10 = com.bytedance.android.live.core.utils.a0.n(r9);
    L34:
        if (r10 == null) goto L57;
        IEpisodeExtraInfo r12 = r10.getEpisodeExtra();
        if (r12 == null) goto L57;
        IBaseEpisodeMod r16 = r12.getMod();
        if (r16 == null) goto L57;
        if (r16.getEpisodeStage() != EpisodeMod.EpisodeStageType.PREMIERE) goto L57;
        TextView r17 = this.C;
        if (r17 == null) goto L44;
        UtilityKotlinExtentionsKt.w(r17);
    L44:
        HSImageView r18 = this.A;
        if (r18 == null) goto L47;
        UtilityKotlinExtentionsKt.t(r18);
    L47:
        TextView r19 = this.B;
        if (r19 == null) goto L50;
        a1.m(r19, s1.f(4.0f));
    L50:
        TextView r20 = this.B;
        if (r20 == null) goto L134;
        IEpisodeExtraInfo r22 = r10.getEpisodeExtra();
        if (r22 == null) goto L55;
        String r23 = r22.getCurrentPeriod();
    L56:
        r20.setText(r23);
        goto L134
    L55:
        r23 = null;
    L134:
        final long r24 = 1000;
        if (wt2.e.a() == false) goto L137;
    L142:
        EllipsizedScrollTextView r25 = this.z;
        if (r25 == null) goto L145;
        r25.setVisibility(8);
    L145:
        com.bytedance.android.livesdk.common.j r26 = this.F;
        if ((r26 instanceof FrameLayout) == true) goto L148;
        r26 = null;
    L148:
        FrameLayout r27 = (FrameLayout) r26;
        if (r27 == null) goto L151;
        r27.setVisibility(0);
    L151:
        com.bytedance.android.livesdk.common.j r28 = this.F;
        if (r28 == null) goto L154;
        r28.setTextSize(1, 16.0f);
    L154:
        com.bytedance.android.livesdk.common.j r29 = this.F;
        if (r29 == null) goto L157;
        r29.setIncludeFontPadding(true);
    L157:
        com.bytedance.android.livesdk.common.j r30 = this.F;
        if (r30 == null) goto L160;
        r30.setSpeed(UtilityKotlinExtentionsKt.i(38));
    L160:
        r r32 = z51.a.e(K().h);
        if (r32 == null) goto L167;
        com.bytedance.live.datacontext.m r33 = r32.J();
        if (r33 == null) goto L167;
        Boolean r34 = (Boolean) r33.getValue();
        if (r34 == null) goto L167;
        boolean r35 = r34.booleanValue();
    L168:
        if (r35 == false) goto L186;
        com.bytedance.android.livesdk.common.j r36 = this.F;
        if (r36 == null) goto L180;
        Paint r37 = r36.getPaint();
        String r38 = W();
        if (r37 != null) goto L174;
        String r39 = null;
    L179:
        r36.setTextWithEllipsis(r39);
        goto L180
    L174:
        float r40 = r37.measureText(r38);
        StringBuilder r42 = new StringBuilder();
    L176:
        if (r37.measureText(r42.toString()) >= r40) goto L178;
        r42.append(' ');
        goto L176
    L178:
        r39 = r42.toString();
    L180:
        com.bytedance.android.livesdk.common.j r43 = this.F;
        if ((r43 instanceof FrameLayout) == true) goto L183;
        r43 = null;
    L183:
        FrameLayout r44 = (FrameLayout) r43;
        if (r44 == null) goto L197;
        r44.post(new f(this));
    L197:
        r r45 = z51.a.e(K().h);
        if (r45 == null) goto L200;
        com.bytedance.live.datacontext.j r46 = r45.n();
    L201:
        if (r46 != null) goto L203;
    L204:
        if (r46 == null) goto L206;
        final long r47 = 111;
        r46.e(new AudienceRoomNavigatorTetris$startAnimationListener$1(r47, r24));
    L206:
        if (r46 == null) goto L208;
        r46.c(new AudienceRoomNavigatorTetris$startAnimationListener$2(this));
    L208:
        if (r8 == null) goto L226;
        IMiddlewareMicRoomService r48 = (IMiddlewareMicRoomService) jc1.k.f(IMiddlewareMicRoomService.class);
        ViewGroup r49 = this.o;
        if (r49 == null) goto L226;
        boolean r50 = k60.b.a();
        if (r48 != null) goto L215;
    L224:
        WidgetElement r52 = P(((INavigationService) jc1.k.n(INavigationService.class)).getUserInfoWidget(K().h), r49, r50, null, r50);
    L225:
        this.v = r52;
        goto L226
    L215:
        if (r48.isMicRoom(r8) == false) goto L224;
        INavigationProxyService r53 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r53 == null) goto L223;
        l81.o r54 = r53.getMicRoomService();
        if (r54 == null) goto L223;
        Class<? extends LiveRecyclableWidget> r55 = r54.getMicRoomOfficialInfoWidget();
        if (r55 == null) goto L223;
        r52 = P(r55, r49, r50, null, r50);
    L223:
        r52 = null;
    L226:
        Z(r8);
        o r56 = z51.a.h(K().h, 2);
        if (r56 == null) goto L235;
        com.bytedance.live.datacontext.m r57 = r56.getRoom();
        if (r57 == null) goto L235;
        Observable r58 = r57.a();
        if (r58 == null) goto L235;
        Disposable r59 = r58.subscribe(new c(this));
        if (r59 == null) goto L235;
        RxUtilKt.c(r59, this.G);
    L235:
        if (r14 == false) goto L239;
        UIUtils.setViewVisibility(this.r, 8);
        ViewGroup r60 = this.p;
        if (r60 == null) goto L254;
        a1.n(r60, s1.f(12.0f));
    L254:
        V(K());
        boolean r62 = k60.b.a.mEnable;
        FrameLayout r63 = this.y;
        if (r63 == null) goto L261;
        IBaseDiggService r64 = jc1.k.f(IBaseDiggService.class);
        if (r64 == null) goto L261;
        Class r65 = r64.digAccessibilityWidget();
        if (r65 == null) goto L261;
        P(r65, r63, r62, null, r62);
    L261:
        int r66 = ca1.a.a;
        if (com.bytedance.android.livesdk.m.c() == true) goto L264;
    L266:
        if (r13 == false) goto L281;
        IMiddlewareMicRoomService r67 = (IMiddlewareMicRoomService) jc1.k.f(IMiddlewareMicRoomService.class);
        if (r67 == null) goto L281;
        if (r67.isMicRoom(r8) != true) goto L281;
        ViewGroup r68 = this.p;
        if (r68 == null) goto L275;
        ViewGroup.LayoutParams r69 = r68.getLayoutParams();
    L277:
        if ((r69 instanceof ViewGroup.MarginLayoutParams) == false) goto L281;
        ((ViewGroup.MarginLayoutParams) r69).leftMargin = UtilityKotlinExtentionsKt.i(1);
        ViewGroup r70 = this.p;
        if (r70 == null) goto L281;
        r70.setLayoutParams(r69);
        goto L281
    L275:
        r69 = null;
    L281:
        ArrayList<a0.a> r72 = a0.b;
        if (r72.contains(this) == true) goto L284;
        r72.add(this);
    L284:
        View r73 = this.D;
        if (r73 != null) goto L287;
    L292:
        o r74 = z51.a.h(K().h, 2);
        if (r74 == null) goto L299;
        com.bytedance.live.datacontext.m r75 = r74.q2();
        if (r75 == null) goto L299;
        Observable r76 = r75.a();
        if (r76 == null) goto L299;
        r15 = r76.subscribe(new d(this));
    L299:
        this.x = r15;
        return;
    L287:
        if (r73.getVisibility() != 0) goto L292;
        View r77 = this.t;
        if (r77 == null) goto L292;
        r77.postDelayed(new i(this), 1000);
        goto L292
    L264:
        if (((Boolean) com.bytedance.android.live.misc.a.a.getValue()).booleanValue() == false) goto L266;
        r13 = true;
        goto L266
    L239:
        d90.d r78 = K();
        final h r79 = new h(this);
        if (((Boolean) f0.a.getValue()).booleanValue() == false) goto L244;
        ImageView r80 = this.r;
        if (r80 == null) goto L253;
        UtilityKotlinExtentionsKt.w(r80);
    L253:
        r3.c(this.r, s1.B(2131918650), true);
        goto L254
    L244:
        DataCenter r82 = r78.h;
        Room r83 = d90.e.j(r78);
        if (r83 == null) goto L247;
        long r84 = r83.getRoomId();
    L248:
        o r85 = z51.a.f(r82, r84);
        if (r85 == null) goto L253;
        com.bytedance.live.datacontext.j r86 = r85.B2();
        if (r86 == null) goto L253;
        r86.c(new AudienceRoomNavigatorTetris$initCloseLayout$1(this, r79));
        goto L253
    L247:
        r84 = 0;
        goto L248
    L203:
        if (r46.hasValue() == true) goto L206;
    L200:
        r46 = null;
        goto L201
    L186:
        com.bytedance.android.livesdk.common.j r87 = this.F;
        if (r87 == null) goto L190;
        r87.setTextWithFading(W());
    L190:
        if (d90.e.i(K()) == false) goto L197;
        com.bytedance.android.livesdk.common.j r88 = this.F;
        if (r88 == null) goto L194;
        r88.setTextColor(-1);
    L194:
        com.bytedance.android.livesdk.common.j r89 = this.F;
        if (r89 == null) goto L197;
        r89.setTextWithEllipsisImmediately(W());
    L167:
        r35 = false;
        goto L168
    L137:
        if (d90.e.i(K()) == true) goto L142;
        EllipsizedScrollTextView r90 = this.z;
        if (r90 == null) goto L208;
        r90.setText(W());
    L57:
        TextView r92 = this.C;
        if (r92 == null) goto L60;
        UtilityKotlinExtentionsKt.t(r92);
    L60:
        if (r10 == null) goto L64;
        IEpisodeExtraInfo r93 = r10.getEpisodeExtra();
        if (r93 == null) goto L64;
        String r94 = r93.getCurrentPeriod();
    L65:
        String r95 = "  |  ";
        if (TextUtils.isEmpty(r94) == true) goto L75;
        StringBuilder r96 = new StringBuilder("  |  ");
        if (r10 == null) goto L73;
        IEpisodeExtraInfo r97 = r10.getEpisodeExtra();
        if (r97 == null) goto L73;
        String r98 = r97.getCurrentPeriod();
    L74:
        r96.append(r98);
        r96.append("  ");
        r95 = r96.toString();
    L73:
        r98 = null;
    L75:
        DataCenter r99 = this.s;
        if (r99 != null) goto L78;
    L90:
        boolean r100 = false;
    L91:
        if (r100 == false) goto L124;
        HSImageView r101 = this.A;
        if (r101 == null) goto L95;
        UtilityKotlinExtentionsKt.w(r101);
    L95:
        DataCenter r102 = this.s;
        if (r102 == null) goto L102;
        IRoom r103 = com.bytedance.android.live.core.utils.a0.n(r102);
        if (r103 == null) goto L102;
        IEpisodeExtraInfo r104 = r103.getEpisodeExtra();
        if (r104 == null) goto L102;
        IVSTitleIcon r105 = r104.getTitleIcon();
    L104:
        if (r105 == null) goto L111;
        int r106 = r105.getSizeType();
        if (r106 == 1) goto L110;
        if (r106 == 2) goto L109;
        float r107 = UtilityKotlinExtentionsKt.h(82);
    L112:
        int r108 = (int) r107;
        HSImageView r109 = this.A;
        if (r109 == null) goto L119;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if (r110 == null) goto L117;
        r110.width = r108;
        r110.height = UtilityKotlinExtentionsKt.i(42);
        Unit r111 = Unit.INSTANCE;
    L118:
        r109.setLayoutParams(r110);
        goto L119
    L117:
        r110 = null;
    L119:
        if (r105 == null) goto L123;
        py.k r112 = r105.getIcon();
        if (r112 == null) goto L123;
        ImageUtil.loadImage(this.A, r112, 0);
    L123:
        String r113 = "";
    L128:
        TextView r114 = this.B;
        if (r114 == null) goto L131;
        a1.m(r114, s1.f(0.0f));
    L131:
        TextView r115 = this.B;
        if (r115 == null) goto L134;
        r115.setText(r113 + r95);
        goto L134
    L109:
        r107 = UtilityKotlinExtentionsKt.h(102);
        goto L112
    L110:
        r107 = UtilityKotlinExtentionsKt.h(82);
        goto L112
    L111:
        r107 = UtilityKotlinExtentionsKt.h(82);
    L102:
        r105 = null;
        goto L104
    L124:
        HSImageView r116 = this.A;
        if (r116 == null) goto L127;
        UtilityKotlinExtentionsKt.t(r116);
    L127:
        r113 = "直播";
        goto L128
    L78:
        if (com.bytedance.android.live.core.utils.a0.l(r99, true) != true) goto L90;
        DataCenter r117 = this.s;
        if (r117 == null) goto L90;
        IRoom r118 = com.bytedance.android.live.core.utils.a0.n(r117);
        if (r118 == null) goto L90;
        IEpisodeExtraInfo r119 = r118.getEpisodeExtra();
        if (r119 == null) goto L90;
        IVSTitleIcon r120 = r119.getTitleIcon();
        if (r120 == null) goto L90;
        if (r120.isAvailable() != true) goto L90;
        r100 = true;
    L64:
        r94 = null;
        goto L65
    L33:
        r10 = null;
    L29:
        r14 = false;
        goto L30
    L9:
        if (((LiveMode) r0.get("data_live_mode", LiveMode.VIDEO)) != null) goto L11;
        goto L10
    }

    public final String W() {
        DataCenter r0 = this.s;
        String r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = com.bytedance.android.live.core.utils.a0.n(r0);
    L7:
        if (r2 == null) goto L54;
        if (r2.isMergeVSRoom() != true) goto L54;
        if (wt2.e.a() == false) goto L13;
    L18:
        com.bytedance.android.livesdk.common.j r3 = this.F;
        if ((r3 instanceof FrameLayout) == true) goto L21;
        r3 = null;
    L21:
        FrameLayout r4 = (FrameLayout) r3;
        if (r4 == null) goto L24;
        a1.m(r4, s1.f(0.0f));
    L24:
        DataCenter r5 = this.s;
        if (r5 == null) goto L27;
        IRoom r6 = com.bytedance.android.live.core.utils.a0.n(r5);
    L28:
        nm1.m r7 = pm1.f.l();
        if (r7 == null) goto L47;
        VSCameraInfo r8 = r7.K(this.s);
        if (r8 == null) goto L47;
        if (r8.cameraType != VSCameraType.CAMERA_TYPE_MATCH.getValue()) goto L47;
        nm1.m r9 = pm1.f.l();
        if (r9 == null) goto L42;
        VSCameraInfo r10 = r9.K(this.s);
        if (r10 == null) goto L42;
        String r12 = r10.title;
        if (r12 == null) goto L42;
        return r12;
    L42:
        if (r6 == null) goto L46;
        IEpisodeExtraInfo r13 = r6.getEpisodeExtra();
        if (r13 == null) goto L46;
        r1 = r13.getTitle();
    L46:
        String r14 = String.valueOf(r1);
        ALogger.d("VSTitle", "currentVsTitle is " + r14 + " current cameratype is CAMERA_TYPE_MATCH");
    L71:
        return r14;
    L47:
        if (r6 == null) goto L51;
        IEpisodeExtraInfo r15 = r6.getEpisodeExtra();
        if (r15 == null) goto L51;
        r1 = r15.getTitle();
    L51:
        r14 = String.valueOf(r1);
        ALogger.d("VSTitle", "currentVsTitle is " + r14 + " current cameratype is not CAMERA_TYPE_MATCH");
        goto L71
    L27:
        r6 = null;
        goto L28
    L13:
        if (d90.e.i(K()) == true) goto L18;
        EllipsizedScrollTextView r16 = this.z;
        if (r16 == null) goto L24;
        a1.m(r16, s1.f(8.0f));
    L54:
        if (wt2.e.a() == false) goto L56;
    L61:
        com.bytedance.android.livesdk.common.j r17 = this.F;
        if ((r17 instanceof FrameLayout) == true) goto L64;
        r17 = null;
    L64:
        FrameLayout r18 = (FrameLayout) r17;
        if (r18 == null) goto L67;
        a1.m(r18, s1.f(0.0f));
    L67:
        if (r2 != null) goto L69;
        return null;
    L69:
        return r2.getTitle();
    L56:
        if (d90.e.i(K()) == true) goto L61;
        EllipsizedScrollTextView r19 = this.z;
        if (r19 == null) goto L67;
        a1.m(r19, s1.f(0.0f));
        goto L67
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.room.a0.a
    public final void onHide() {
        View r0 = this.D;
        if (r0 == null) goto L11;
        ViewPropertyAnimator r1 = r0.animate();
        if (r1 == null) goto L11;
        ViewPropertyAnimator r2 = r1.rotation(0.0f);
        if (r2 == null) goto L11;
        ViewPropertyAnimator r3 = r2.setDuration(200);
        if (r3 == null) goto L11;
        ViewPropertyAnimator r4 = r3.setInterpolator(new DecelerateInterpolator());
    L12:
        if (r4 == null) goto L15;
        r4.start();
        return;
    L15:
        return;
    L11:
        r4 = null;
        goto L12
    }

    @Override // com.bytedance.android.live.room.a0.a
    public final void onShow() {
        View r0 = this.D;
        if (r0 == null) goto L11;
        ViewPropertyAnimator r1 = r0.animate();
        if (r1 == null) goto L11;
        ViewPropertyAnimator r2 = r1.rotation(180.0f);
        if (r2 == null) goto L11;
        ViewPropertyAnimator r3 = r2.setDuration(200);
        if (r3 == null) goto L11;
        ViewPropertyAnimator r4 = r3.setInterpolator(new DecelerateInterpolator());
    L12:
        if (r4 == null) goto L15;
        r4.start();
        return;
    L15:
        return;
    L11:
        r4 = null;
        goto L12
    }

    public AudienceRoomNavigatorTetris() {
        this.G = new CompositeDisposable();
        this.H = new AudienceRoomNavigatorTetris$timerListener$1(this);
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        this.G.clear();
        DataCenter r0 = this.s;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        com.bytedance.android.livesdk.common.j r1 = this.F;
        if (r1 == null) goto L8;
        r1.cancelAnimation();
    L8:
        r r2 = z51.a.e(K().h);
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.j r3 = r2.n();
        if (r3 == null) goto L15;
        d9 r4 = (d9) r3.getValue();
        if (r4 == null) goto L15;
        r4.c(this.H);
    L15:
        ArrayList<a0.a> r5 = a0.b;
        if (r5.contains(this) == false) goto L18;
        r5.remove(this);
    L18:
        Disposable r6 = this.x;
        if (r6 == null) goto L22;
        r6.dispose();
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onResume();
        View r0 = this.D;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L13;
        View r1 = this.t;
        if (r1 == null) goto L12;
        r1.postDelayed(new i(this), 1000);
        return;
    L12:
        return;
    }

    public final void updateTitle() {
        String r0 = W();
        FrameLayout r1 = null;
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.common.j r2 = this.F;
        if (r2 == null) goto L7;
        String r3 = r2.getOriginText();
    L9:
        if (r0.equals(r3) != true) goto L11;
        return;
    L7:
        r3 = null;
    L11:
        com.bytedance.android.livesdk.common.j r4 = this.F;
        if (r4 == null) goto L15;
        r4.cancelAnimation();
    L15:
        if (wt2.e.a() == false) goto L17;
    L25:
        com.bytedance.android.livesdk.common.j r5 = this.F;
        if ((r5 instanceof FrameLayout) == true) goto L28;
        r5 = null;
    L28:
        FrameLayout r6 = (FrameLayout) r5;
        if (r6 == null) goto L31;
        r6.setAlpha(1.0f);
    L31:
        FrameLayout r7 = this.F;
        if ((r7 instanceof FrameLayout) == false) goto L35;
        r1 = r7;
    L35:
        FrameLayout r8 = r1;
        if (r8 == null) goto L38;
        UtilityKotlinExtentionsKt.w(r8);
    L38:
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.F, "alpha", new float[]{1.0f, 0.0f}).setDuration(200);
        Function1<Animator, Unit> r10 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r9, "$this$doOnComplete");
        Intrinsics.checkNotNullParameter(r10, "callback");
        r9.addListener(new com.bytedance.android.live.core.utils.e(r10));
        r9.start();
        return;
    L17:
        if (d90.e.i(K()) == true) goto L25;
        EllipsizedScrollTextView r12 = this.z;
        if (r12 == null) goto L22;
        r12.setEllipsize(TextUtils.TruncateAt.END);
    L22:
        EllipsizedScrollTextView r13 = this.z;
        if (r13 == null) goto L40;
        r13.setText(W());
        return;
    }

    public final View G(t70.k r4) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        if (d90.e.i(K()) == false) goto L5;
        int r0 = 2131567158;
    L6:
        View r5 = r4.b(r0);
        INavigationProxyService r1 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r1 == null) goto L11;
        l81.e r2 = r1.getDrawCleanScreenViewModel();
        if (r2 == null) goto L11;
        r2.a(this.s, r5, d90.e.j(K()));
    L11:
        this.y = (FrameLayout) r5.findViewById(2131362012);
        this.o = (ViewGroup) r5.findViewById(2131392032);
        this.p = (ViewGroup) r5.findViewById(2131389219);
        this.q = (ViewGroup) r5.findViewById(2131389218);
        this.r = (ImageView) r5.findViewById(2131366999);
        this.z = r5.findViewById(2131391606);
        this.A = r5.findViewById(2131376497);
        this.B = (TextView) r5.findViewById(2131390479);
        this.C = (TextView) r5.findViewById(2131391507);
        this.t = r5.findViewById(2131388843);
        this.D = r5.findViewById(2131388873);
        this.E = r5.findViewById(2131388843);
        View r3 = this.t;
        if (r3 == null) goto L14;
        r3.setOnClickListener(new b(this));
    L14:
        INavigationProxyService r6 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r6 == null) goto L23;
        l81.n r7 = r6.getILiveSdkProjectModeService();
        if (r7 == null) goto L23;
        if (Intrinsics.areEqual(r7.isPerfToolsDebug(), Boolean.TRUE) == false) goto L23;
        View r8 = this.t;
        if (r8 == null) goto L23;
        r8.setOnLongClickListener(new a(r7, this));
    L23:
        EllipsizedScrollTextView r9 = this.z;
        if (r9 == null) goto L27;
        r9.setMarqueeRepeatLimit(1);
    L27:
        if (d90.e.i(K()) == false) goto L29;
        this.F = r5.findViewById(2131379652);
    L31:
        if (PadConfigUtils.c() == false) goto L41;
        ViewGroup r10 = this.o;
        if (r10 == null) goto L35;
        a1.m(r10, s1.f(12.0f));
    L35:
        ImageView r12 = this.r;
        if (r12 == null) goto L38;
        a1.n(r12, s1.f(12.0f));
    L38:
        TextView r13 = this.B;
        if (r13 == null) goto L41;
        a1.m(r13, s1.f(20.0f));
    L41:
        return r5;
    L29:
        this.F = r5.findViewById(2131379652);
        goto L31
    L5:
        r0 = 2131567156;
        goto L6
    }

    public final void Z(IRoom r8) {
        StringBuilder r0 = new StringBuilder("room?.introduction:");
        if (r8 == null) goto L5;
        String r2 = r8.getIntroduction();
    L6:
        r0.append(r2);
        r0.append("、OrientationUtils.displayRotation():");
        r0.append(e5.a());
        ALogger.e("AudienceRoomNavigatorTetris", r0.toString());
        int r3 = 8;
        if (d90.e.i(K()) == false) goto L12;
        View r9 = this.D;
        if (r9 == null) goto L29;
        r9.setVisibility(8);
        return;
    L29:
        return;
    L12:
        View r1 = this.D;
        if (r1 == null) goto L30;
        if (r8 == null) goto L27;
        String r10 = r8.getIntroduction();
        if (r10 == null) goto L27;
        if (r10.length() != 0) goto L20;
        boolean r12 = true;
    L21:
        if (r12 == true) goto L27;
        if (PadConfigUtils.c() == false) goto L25;
    L26:
        j0.l().sendLog("livesdk_live_intro_title_show", null, new Object[]{IRoom.class, x.class});
        r3 = 0;
        goto L27
    L25:
        if (CollectionsKt.listOf(new Integer[]{1, 9}).contains(Integer.valueOf(e5.a())) == false) goto L27;
    L20:
        r12 = false;
    L27:
        r1.setVisibility(r3);
        return;
    L30:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L92;
        String r0 = r5.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-1836833765)) goto L66;
        if (r1 == 956730793) goto L28;
        if (r1 == 1005883595) goto L13;
        return;
    L13:
        if (r0.equals("cmd_update_mic_room_due_to_part_show") == false) goto L76;
        DataCenter r6 = K().h;
        Room r2 = d90.e.j(K());
        if (r2 == null) goto L17;
        long r3 = r2.getRoomId();
    L18:
        o r7 = z51.a.f(r6, r3);
        if (r7 == null) goto L77;
        com.bytedance.live.datacontext.n r8 = r7.getInteractionDataPrepared();
        if (r8 == null) goto L78;
        Observable r9 = r8.a();
        if (r9 == null) goto L79;
        Disposable r10 = r9.subscribe(new g(this));
        if (r10 == null) goto L80;
        this.w = r10;
        return;
    L80:
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L17:
        r3 = 0;
        goto L18
    L76:
        return;
    L28:
        if (r0.equals("data_room_title") == false) goto L82;
        Object r12 = r5.getData();
        if ((r12 instanceof String) == true) goto L32;
        r12 = null;
    L32:
        String r13 = (String) r12;
        if (r13 != null) goto L35;
        return;
    L35:
        if ((!Intrinsics.areEqual(r13, "")) == true) goto L37;
        return;
    L37:
        if (d90.e.i(K()) == false) goto L52;
        DataCenter r14 = this.s;
        if (r14 == null) goto L45;
        IRoom r15 = com.bytedance.android.live.core.utils.a0.n(r14);
        if (r15 == null) goto L45;
        IEpisodeExtraInfo r16 = r15.getEpisodeExtra();
        if (r16 == null) goto L45;
        r16.setTitle(r13);
    L45:
        nm1.m r17 = pm1.f.l();
        if (r17 != null) goto L48;
    L50:
        updateTitle();
        goto L52
    L48:
        if (r17.y(this.s) != true) goto L50;
        return;
    L52:
        if (wt2.e.a() == false) goto L54;
    L62:
        com.bytedance.android.livesdk.common.j r18 = this.F;
        if (r18 == null) goto L87;
        r18.setTextWithEllipsis(r13);
        return;
    L87:
        return;
    L54:
        if (d90.e.i(K()) == true) goto L62;
        EllipsizedScrollTextView r19 = this.z;
        if (r19 == null) goto L59;
        r19.setEllipsize(TextUtils.TruncateAt.END);
    L59:
        EllipsizedScrollTextView r20 = this.z;
        if (r20 == null) goto L85;
        r20.setText(r13);
        return;
    L85:
        return;
    L82:
        return;
    L66:
        if (r0.equals("cmd_widget_loaded") == true) goto L68;
        return;
    L68:
        if (wt2.e.a() == false) goto L70;
        return;
    L70:
        if (d90.e.i(K()) == true) goto L95;
        EllipsizedScrollTextView r22 = this.z;
        if (r22 == null) goto L91;
        r22.y();
        return;
    L91:
        return;
    L95:
        return;
    }
}
