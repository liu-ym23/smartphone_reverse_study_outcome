package com.bytedance.android.livesdk.chatroom.widget.landscape;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.ui.f9;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.h1;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.config.hr0;
import com.bytedance.android.livesdk.config.o01;
import com.bytedance.android.livesdk.landscapeslide.LiveLandSlideContext;
import com.bytedance.android.livesdk.widgetdescriptor.data.LandscapeInteractionModel;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import j40.a1;
import j40.d1;
import j40.w0;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.ranges.RangesKt;
import zg1.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeGestureWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lp70/d;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeGestureWidget extends RoomRecyclableWidget implements Observer<KVData>, p70.d {
    public static final int M = 0;
    public static final int N = 0;
    public com.bytedance.android.livesdk.widget.gesture.c A;
    public com.bytedance.android.livesdk.widget.gesture.a B;
    public com.bytedance.android.livesdk.widget.gesture.c C;
    public HSImageView D;
    public HSImageView E;
    public LandscapeInteractionModel F;
    public final Lazy G;
    public final Boolean H;
    public boolean I;
    public final Lazy J;
    public final b K;
    public final c L;
    public Room a;
    public long b;
    public int c;
    public com.bytedance.android.livesdk.chatroom.vsplayer.api.c d;
    public VelocityTracker e;
    public float f;
    public boolean g;
    public boolean h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public WeakReference<View> p;
    public WeakReference<com.bytedance.android.live.platformplayer.layout.c> q;
    public float r;
    public float s;
    public boolean t;
    public float u;
    public float v;
    public boolean w;
    public ko1.b x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements p70.c<ah1.e> {
        public final /* synthetic */ LandscapeGestureWidget a;

        public final Class<? extends p70.a<ah1.e>> b() {
            return ah1.b.class;
        }

        public b(LandscapeGestureWidget r1) {
            this.a = r1;
        }

        public final boolean a(Object r18) {
            ah1.e r1 = (ah1.e) r18;
            Intrinsics.checkNotNullParameter(r1, "param");
            LandscapeGestureWidget r2 = this.a;
            if (r2.y == true) goto L6;
            return false;
        L6:
            if (VrUtils.u(((Widget) r2).dataCenter, true) == true) goto L243;
            LandscapeGestureWidget r3 = this.a;
            View r5 = r1.a;
            MotionEvent r4 = r1.b;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r5, "view");
            Intrinsics.checkNotNullParameter(r4, "event");
            int r6 = r4.getAction();
            long r7 = 0;
            if (r6 != 0) goto L11;
            LandscapeInteractionModel r8 = r3.F;
            if (r8 != null) goto L149;
            Intrinsics.throwUninitializedPropertyAccessException("interactionModel");
        L149:
            if (Intrinsics.areEqual((Boolean) r8.isInZoomState().getValue(), Boolean.TRUE) == false) goto L153;
            ViewParent r9 = r5.getParent();
            if (r9 == null) goto L153;
            r9.requestDisallowInterceptTouchEvent(true);
        L153:
            r3.c = 0;
            r3.i = r4.getRawX();
            float r10 = r4.getRawY();
            r3.j = r10;
            int r11 = LandscapeGestureWidget.N;
            if (r10 > r11) goto L156;
        L163:
            boolean r12 = true;
        L164:
            if (r12 == false) goto L166;
            r3.z = false;
            return false;
        L166:
            r3.m = 0.0f;
            r3.n = r4.getRawX();
            float r13 = r3.i;
            int r14 = ((Widget) r3).contentView.getWidth();
            float r15 = r14;
            float r16 = r15 / 2.0f;
            LiveLandSlideContext.Companion.getClass();
            if (LiveLandSlideContext.a.b() == false) goto L178;
            float r17 = r15 / 5.0f;
            float r19 = (r14 * 4) / 5.0f;
            if (r3.H.booleanValue() == true) goto L177;
            String r20 = i2.a;
            HSImageView r21 = r3.D;
            if (r21 != null) goto L173;
            Intrinsics.throwUninitializedPropertyAccessException("brightHotArea");
        L173:
            i2.h(r21, "/slide/ttlive_bg_hot_brightness_one_fifth.png");
            HSImageView r22 = r3.E;
            if (r22 != null) goto L176;
            Intrinsics.throwUninitializedPropertyAccessException("volumeHotArea");
        L176:
            i2.h(r22, "/slide/ttlive_bg_hot_volume_one_fifth.png");
        L177:
            float r23 = r19;
            r16 = r17;
        L180:
            if (r13 >= r16) goto L182;
            boolean r110 = true;
        L183:
            r3.h = r110;
            if (r110 == false) goto L193;
            com.bytedance.android.livesdk.widget.gesture.a r111 = r3.B;
            if (r111 != null) goto L188;
            Intrinsics.throwUninitializedPropertyAccessException("mBrightnessView");
        L188:
            r3.A = r111;
            com.bytedance.android.livesdk.widget.gesture.c r112 = r3.C;
            if (r112 != null) goto L191;
            Intrinsics.throwUninitializedPropertyAccessException("mVolumeView");
        L191:
            r112.hide();
        L193:
            if (r13 <= r23) goto L195;
            boolean r24 = true;
        L196:
            r3.g = r24;
            if (r24 == false) goto L206;
            com.bytedance.android.livesdk.widget.gesture.c r25 = r3.C;
            if (r25 != null) goto L201;
            Intrinsics.throwUninitializedPropertyAccessException("mVolumeView");
        L201:
            r3.A = r25;
            com.bytedance.android.livesdk.widget.gesture.a r26 = r3.B;
            if (r26 != null) goto L204;
            Intrinsics.throwUninitializedPropertyAccessException("mBrightnessView");
        L204:
            r26.hide();
        L206:
            if (r3.g == true) goto L210;
            if (r3.h == true) goto L210;
        L214:
            IPlayerProgressService r27 = (IPlayerProgressService) r3.G.getValue();
            if (r27 == null) goto L219;
            Long r28 = r27.getCurrentDisplayTimeInContext();
            if (r28 == null) goto L219;
            r7 = r28.longValue();
        L219:
            r3.b = r7;
            IPlayerProgressService r29 = (IPlayerProgressService) r3.G.getValue();
            if (r29 == null) goto L222;
            r29.onProgressGestureStartTouch();
        L222:
            ko1.b r30 = r3.x;
            if (r30 == null) goto L241;
            r30.c(r4);
            return false;
        L241:
            return false;
        L210:
            if (LiveLandSlideContext.a.b() == false) goto L214;
            ViewParent r31 = r5.getParent();
            if (r31 == null) goto L214;
            r31.requestDisallowInterceptTouchEvent(true);
            goto L214
        L195:
            r24 = false;
            goto L196
        L182:
            r110 = false;
            goto L183
        L178:
            r23 = r16;
            goto L180
        L156:
            if (r3.zq().booleanValue() == false) goto L158;
            int r113 = ((Widget) r3).contentView.getHeight();
        L160:
            if (r10 >= (r113 - r11)) goto L163;
            r12 = false;
            goto L164
        L158:
            r113 = s1.w();
            goto L160
        L11:
            if (r6 != 1) goto L13;
        L121:
            IPlayerProgressService r32 = (IPlayerProgressService) r3.G.getValue();
            if (r32 == null) goto L124;
            r32.onProgressGestureEndTouch();
        L124:
            r3.z = true;
            int r33 = r3.c;
            if (r33 == 1) goto L144;
            if (r33 == 2) goto L136;
            ko1.b r34 = r3.x;
            if (r34 == null) goto L130;
            r34.c(r4);
        L130:
            LandscapeInteractionModel r35 = r3.F;
            if (r35 != null) goto L134;
            Intrinsics.throwUninitializedPropertyAccessException("interactionModel");
        L134:
            if (Intrinsics.areEqual((Boolean) r35.isInZoomState().getValue(), Boolean.TRUE) == true) goto L144;
            return false;
        L136:
            r3.wq(false);
            com.bytedance.android.livesdk.widget.gesture.c r36 = r3.A;
            if (r36 == null) goto L140;
            r36.e();
        L140:
            if (r3.g == false) goto L142;
            String r37 = "livesdk_fullscreen_gesture_voice";
        L143:
            com.bytedance.android.livesdk.log.u.l().d(r37, new Object[]{x.class, Room.class});
            goto L144
        L142:
            r37 = "livesdk_fullscreen_gesture_brightness";
        L144:
            return true;
        L13:
            if (r6 == 2) goto L17;
            if (r6 == 3) goto L121;
            return false;
        L17:
            if (r4.getPointerCount() != 1) goto L117;
            LandscapeInteractionModel r38 = r3.F;
            if (r38 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("interactionModel");
        L22:
            if (Intrinsics.areEqual((Boolean) r38.isInZoomState().getValue(), Boolean.FALSE) == true) goto L24;
            ko1.b r39 = r3.x;
            if (r39 == null) goto L233;
            r39.c(r4);
            return false;
        L233:
            return false;
        L24:
            if (r3.z == false) goto L245;
            r3.k = r4.getRawX() - r3.i;
            r3.l = r4.getRawY() - r3.j;
            r3.o = r4.getRawX() - r3.n;
            r3.n = r4.getRawX();
            if (r3.zq().booleanValue() == true) goto L32;
            if (r3.xq(r3.c) == false) goto L32;
            return false;
        L32:
            if (r3.c == 0) goto L34;
        L70:
            int r40 = r3.c;
            if (r40 == 1) goto L95;
            if (r40 == 2) goto L75;
            return false;
        L75:
            if (r3.zq().booleanValue() == false) goto L84;
            com.bytedance.android.livesdk.widget.gesture.c r41 = r3.A;
            if (r41 == null) goto L226;
            float r42 = -r3.l;
            if (r3.zq().booleanValue() == false) goto L81;
            int r43 = ((Widget) r3).contentView.getHeight();
        L82:
            r41.b(r42 / r43);
            return false;
        L81:
            r43 = s1.w();
            goto L82
        L226:
            return false;
        L84:
            if (Math.abs(r3.l - r3.m) > LandscapeGestureWidget.M) goto L86;
            return false;
        L86:
            if ((r3.l - r3.m) >= 0) goto L90;
            com.bytedance.android.livesdk.widget.gesture.c r44 = r3.A;
            if (r44 == null) goto L93;
            r44.a();
        L93:
            r3.m = r3.l;
            return false;
        L90:
            com.bytedance.android.livesdk.widget.gesture.c r45 = r3.A;
            if (r45 == null) goto L93;
            r45.f();
            goto L93
        L95:
            if (r3.e != null) goto L97;
            r3.e = VelocityTracker.obtain();
        L97:
            VelocityTracker r46 = r3.e;
            if (r46 == null) goto L230;
            r46.computeCurrentVelocity(BubbleId.PadCast);
            r46.addMovement(r4);
            if (r46.getXVelocity() <= BubbleId.PadCast) goto L103;
            float r47 = 1000.0f;
        L106:
            float r48 = r3.o;
            float r49 = s1.e(1.0f);
            int r50 = (int) (r3.yq() / ((long) 60));
            float r51 = r3.f + (r48 / r49);
            r3.f = r51 % 0.1f;
            int r52 = RangesKt.coerceAtMost((int) (((Math.pow(((int) (((double) r51) / 0.1d)) * (r47 / r49), 2.0d) / ((double) 2000000)) + ((double) 3)) * ((double) 20)), r50);
            long r53 = r3.b;
            if (r3.o > 0) goto L110;
            r52 = -r52;
        L110:
            long r114 = r53 + ((long) r52);
            r3.b = r114;
            r3.b = RangesKt.coerceIn(r114, 0, RangesKt.coerceAtLeast(r3.yq(), 0));
            IPlayerProgressService r54 = (IPlayerProgressService) r3.G.getValue();
            if (r54 == null) goto L231;
            r54.onProgressGestureTracking(r3.b, r3.yq());
            return false;
        L231:
            return false;
        L103:
            if (r46.getXVelocity() >= (-1000)) goto L105;
            r47 = -1000.0f;
            goto L106
        L105:
            r47 = r46.getXVelocity();
            goto L106
        L230:
            return false;
        L34:
            if (Math.abs(r3.k) <= Math.abs(r3.l)) goto L46;
            h1.a r55 = h1.b;
            DataCenter r56 = ((Widget) r3).dataCenter;
            r55.getClass();
            LiveVisibilityControlContext r57 = h1.a.f(r56);
            if (r57 == null) goto L40;
            if (r57.enablePlayBackAbility() != true) goto L40;
        L41:
            boolean r58 = true;
        L43:
            if (r58 == false) goto L46;
            int r59 = 1;
        L56:
            if (r3.zq().booleanValue() == true) goto L58;
        L60:
            r3.c = r59;
            if (r59 != 1) goto L66;
            DataCenter r60 = ((Widget) r3).dataCenter;
            if (r60 == null) goto L70;
            r60.put("cmd_change_landscape_visibility", Boolean.TRUE);
            goto L70
        L66:
            if (r3.zq().booleanValue() == false) goto L70;
            if (r3.c != 2) goto L70;
            r3.wq(true);
            goto L70
        L58:
            if (r3.xq(r59) == false) goto L60;
            return false;
        L40:
            if (hr0.a.getValue().booleanValue() == false) goto L41;
            r58 = false;
        L46:
            if (r3.h == true) goto L52;
            if (r3.g == true) goto L52;
            r59 = 0;
        L52:
            if (r3.zq().booleanValue() == true) goto L54;
            r3.wq(true);
        L54:
            r59 = 2;
            goto L56
        L245:
            return false;
        L117:
            if (r4.getPointerCount() != 2) goto L235;
            ko1.b r61 = r3.x;
            if (r61 == null) goto L236;
            r61.c(r4);
            return false;
        L236:
            return false;
        L235:
            return false;
        L243:
            return false;
        }
    }

    public static final class c implements p70.c<ah1.d> {
        public final /* synthetic */ LandscapeGestureWidget a;

        public final Class<? extends p70.a<ah1.d>> b() {
            return ah1.c.class;
        }

        public c(LandscapeGestureWidget r1) {
            this.a = r1;
        }

        public final boolean a(Object r6) {
            ah1.d r7 = (ah1.d) r6;
            Intrinsics.checkNotNullParameter(r7, "param");
            if (this.a.y == false) goto L16;
            int r0 = r7.b;
            if (r0 != 25) goto L8;
        L11:
            boolean r2 = true;
        L12:
            if (r2 == false) goto L15;
            xs2.b.a().post(new com.bytedance.android.livesdk.event.a(0, r0, r7.c));
            return true;
        L15:
            return false;
        L8:
            if (r0 == 24) goto L11;
            r2 = false;
            goto L12
        L16:
            return false;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LandscapeGestureWidget a;

        public d(LandscapeGestureWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.event.a r5 = (com.bytedance.android.livesdk.event.a) r4;
            LandscapeGestureWidget r0 = this.a;
            int r1 = LandscapeGestureWidget.M;
            r0.getClass();
            if (r5.a != 0) goto L26;
            int r6 = r5.b;
            if (r6 != 24) goto L8;
            com.bytedance.android.livesdk.widget.gesture.c r7 = r0.C;
            if (r7 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("mVolumeView");
        L20:
            r7.a();
            com.bytedance.android.livesdk.widget.gesture.c r8 = r0.C;
            if (r8 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("mVolumeView");
        L23:
            r8.e();
            return;
        L8:
            if (r6 != 25) goto L27;
            com.bytedance.android.livesdk.widget.gesture.c r9 = r0.C;
            if (r9 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mVolumeView");
        L13:
            r9.f();
            com.bytedance.android.livesdk.widget.gesture.c r10 = r0.C;
            if (r10 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mVolumeView");
        L16:
            r10.e();
            return;
        L27:
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ LandscapeGestureWidget a;

        public e(LandscapeGestureWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 == null) goto L6;
            this.a.y = !r3.booleanValue();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LandscapeGestureWidget a;

        public f(LandscapeGestureWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            LandscapeGestureWidget r0 = this.a;
            int r1 = LandscapeGestureWidget.M;
            r0.Aq((do1.a) r3);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LandscapeGestureWidget a;

        public g(LandscapeGestureWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            LandscapeGestureWidget r0 = this.a;
            int r1 = LandscapeGestureWidget.M;
            r0.getClass();
            if (((zt2.a) r5).a == false) goto L5;
        L8:
            r0.Aq(new do1.a(x6.a, 0, 5, 0));
            return;
        L5:
            if (r0.I == true) goto L7;
            return;
        L7:
            if (((o01) d1.a.getValue()).a() == true) goto L8;
        }
    }

    public final class h implements Consumer {
        public final /* synthetic */ Function1 a;

        public h(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.widget.landscape.LandscapeGestureWidget$onLoad$4, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass4 extends MutablePropertyReference0Impl {
        public AnonymousClass4(LandscapeGestureWidget r7) {
            super(r7, LandscapeGestureWidget.class, "mRoom", "getMRoom()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", 0);
        }

        public Object get() {
            Room r0 = ((LandscapeGestureWidget) ((CallableReference) this).receiver).a;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mRoom");
        L5:
            return r0;
        }

        public void set(Object r2) {
            Room r3 = (Room) r2;
            ((LandscapeGestureWidget) ((CallableReference) this).receiver).a = r3;
        }
    }

    public final int getLayoutId() {
        return 2131566550;
    }

    public final String getSpm() {
        return "a100.a100.a270";
    }

    public final void onInit(Object[] r1) {
    }

    public final Set<p70.c<?>> ud() {
        return SetsKt.setOf(new p70.c[]{this.K, this.L});
    }

    public final Boolean zq() {
        return (Boolean) this.J.getValue();
    }

    static {
        M = UtilityKotlinExtentionsKt.i(15);
        N = UtilityKotlinExtentionsKt.i(21);
    }

    public final void Bq() {
        Float r0 = Float.valueOf(1.0f);
        Float r1 = Float.valueOf(0.0f);
        Cq(r0, r0, r1, r1);
        float r2 = this.u;
        float r3 = this.v;
        if (this.w == false) goto L14;
        WeakReference<View> r4 = this.p;
        if (r4 == null) goto L9;
        View r5 = r4.get();
        if (r5 == null) goto L9;
        r5.setX(r2);
    L9:
        WeakReference<View> r6 = this.p;
        if (r6 == null) goto L14;
        View r7 = r6.get();
        if (r7 == null) goto L14;
        r7.setY(r3);
    L14:
        float r8 = this.r;
        float r9 = this.s;
        if (this.t == false) goto L26;
        WeakReference<View> r10 = this.p;
        if (r10 == null) goto L21;
        View r11 = r10.get();
        if (r11 == null) goto L21;
        r11.setPivotX(r8);
    L21:
        WeakReference<View> r12 = this.p;
        if (r12 == null) goto L26;
        View r13 = r12.get();
        if (r13 == null) goto L26;
        r13.setPivotY(r9);
    L26:
        ko1.b r14 = this.x;
        if (r14 == null) goto L29;
        r14.e();
    L29:
        LandscapeInteractionModel r15 = this.F;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("interactionModel");
    L32:
        r15.isInZoomState().setValue(Boolean.FALSE);
        x6.e = false;
        if (x6.f == null) goto L36;
        ALogger.d("SandwichBorderInfo", "resetPlayerViewOnUnload");
        Eq(this, null, null, r1, 7);
        return;
    }

    public final long yq() {
        IPlayerProgressService r0 = (IPlayerProgressService) this.G.getValue();
        if (r0 == null) goto L7;
        Long r1 = r0.getTotalTimeInContext();
        if (r1 == null) goto L7;
        return r1.longValue();
    L7:
        return 0;
    }

    public LandscapeGestureWidget() {
        this.z = true;
        this.G = InfraKotlinExtsKt.mainThreadLazy(new LandscapeGestureWidget$mProgressService$2(this));
        this.H = (Boolean) w0.a.getValue();
        this.J = LazyKt.lazy(LandscapeGestureWidget$optIndicator$2.INSTANCE);
        this.K = new b(this);
        this.L = new c(this);
    }

    public final void onUnload() {
        if (x6.c() == true) goto L5;
    L9:
        com.bytedance.android.livesdk.widget.gesture.c r0 = this.A;
        if (r0 == null) goto L12;
        r0.hide();
    L12:
        com.bytedance.android.livesdk.widget.gesture.a r1 = this.B;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mBrightnessView");
    L15:
        r1.c();
        this.y = false;
        return;
    L5:
        if (x6.e == false) goto L7;
    L8:
        boolean r2 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.e.cancel();
        MatchRoomLandScapeAnimUtil.u(0);
        MatchRoomLandScapeAnimUtil.A = 1.0f;
        MatchRoomLandScapeAnimUtil.B = 0.0f;
        MatchRoomLandScapeAnimUtil.C = 0.0f;
        MatchRoomLandScapeAnimUtil.r();
        Bq();
        this.r = 0.0f;
        this.s = 0.0f;
        this.u = 0.0f;
        this.v = 0.0f;
        this.p = null;
        this.q = null;
        goto L9
    L7:
        if (x6.c == true) goto L9;
        goto L8
    }

    public final void Aq(do1.a r20) {
        float r2 = x1.i(jc1.k.n(IHostApp.class).getTopActivity()).widthPixels;
        Activity r3 = jc1.k.n(IHostApp.class).getTopActivity();
        if (r3 != null) goto L5;
        int r4 = 0;
    L6:
        float r5 = r4;
        RoomContext r6 = getDataContext();
        if (r6 == null) goto L13;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L13;
        Room r8 = (Room) r7.getValue();
        if (r8 == null) goto L13;
        long r9 = r8.id;
    L15:
        if (r9 != 0) goto L18;
        return;
    L18:
        if (x6.f() == true) goto L20;
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r10 == null) goto L88;
        com.bytedance.live.datacontext.m r11 = r10.isSandwichAdapter();
        if (r11 == null) goto L88;
        r11.setValue(Boolean.FALSE);
    L88:
        as0.a r12 = LivePlatformPlayerManager.e(r9, false);
        if (r12 == null) goto L95;
        LivePlayerView r13 = r12.getLivePlayerView();
        if (r13 == null) goto L95;
        IRenderView r14 = r13.getRenderView();
        if (r14 == null) goto L95;
        int r15 = r14.getWidth();
    L96:
        as0.a r16 = LivePlatformPlayerManager.e(r9, false);
        if (r16 == null) goto L103;
        LivePlayerView r17 = r16.getLivePlayerView();
        if (r17 == null) goto L103;
        IRenderView r18 = r17.getRenderView();
        if (r18 == null) goto L103;
        int r19 = r18.getHeight();
    L104:
        if (r15 == 0) goto L124;
        if (r19 == 0) goto L125;
        float r21 = r2 / r15;
        float r22 = r5 / r19;
        ALogger.i("SandwichBorderInfo", "LandscapeWidgetGestureWidget handlePicTypeChange pic type " + r20.b);
        int r1 = r20.b;
        if (r1 != 0) goto L110;
        Bq();
        MatchRoomLandScapeAnimUtil.v = 1.0f;
        MatchRoomLandScapeAnimUtil.w = 1.0f;
    L121:
        float r110 = 1.0f;
    L122:
        ALogger.d("SandwichBorderInfo", "LandscapePicTypeSettingManager setInitScaleValue " + r110);
        x6.d = r110;
        return;
    L110:
        if (r1 != 1) goto L112;
        Bq();
        if (r21 <= r22) goto L118;
        Eq(this, Float.valueOf(r21), null, null, 14);
        x6.b = true;
        MatchRoomLandScapeAnimUtil.v = r21;
        MatchRoomLandScapeAnimUtil.w = 1.0f;
    L119:
        r110 = Math.max(r21, r22);
        goto L122
    L118:
        Eq(this, null, Float.valueOf(r22), null, 13);
        x6.b = false;
        MatchRoomLandScapeAnimUtil.v = 1.0f;
        MatchRoomLandScapeAnimUtil.w = r22;
        goto L119
    L112:
        if (r1 != 2) goto L121;
        Bq();
        r110 = Math.max(r21, r22);
        Eq(this, Float.valueOf(r110), Float.valueOf(r110), null, 12);
        MatchRoomLandScapeAnimUtil.v = r110;
        MatchRoomLandScapeAnimUtil.w = r110;
        goto L122
    L125:
        return;
    L124:
        return;
    L103:
        r19 = 0;
    L95:
        r15 = 0;
        goto L96
    L20:
        if (x6.f() == true) goto L27;
        RoomContext r23 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r23 == null) goto L26;
        com.bytedance.live.datacontext.m r24 = r23.isSandwichAdapter();
        if (r24 == null) goto L26;
        r24.setValue(Boolean.FALSE);
    L26:
        ALogger.d("SandwichBorderInfo", "autoAdapterSandwichLayout roomId:" + r9 + " false , is not sandwich");
    L79:
        boolean r25 = false;
    L80:
        ALogger.d("SandwichBorderInfo", "LandscapeWidgetGestureWidget handlePicTypeChange autoAdapterSandwichLayout " + r25);
        if (r25 == false) goto L88;
        return;
    L27:
        f9 r26 = x6.f;
        if (r26 == null) goto L73;
        as0.a r111 = LivePlatformPlayerManager.e(r9, false);
        if (r111 == null) goto L79;
        LivePlayerView r112 = r111.getLivePlayerView();
        if (r112 == null) goto L79;
        ILivePlayerClient r113 = r111.player();
        if (r113 != null) goto L38;
    L42:
        boolean r114 = false;
    L43:
        if (r114 == false) goto L45;
        Pair r115 = TuplesKt.to(r112, null);
    L52:
        View r27 = (View) r115.component1();
        com.bytedance.android.live.platformplayer.layout.c r28 = (com.bytedance.android.live.platformplayer.layout.c) r115.component2();
        Activity r29 = jc1.k.n(IHostApp.class).getTopActivity();
        if (r29 != null) goto L55;
        int r30 = 0;
    L56:
        float r31 = r30;
        float r116 = r26.b;
        float r117 = r26.a;
        if (r116 > r117) goto L59;
        float r118 = 1.0f;
    L60:
        float r119 = (((1.0f - r116) - (r117 - 0.0f)) * 0.5f) * r31;
        r27.setScaleX(r118);
        r27.setScaleY(r118);
        r27.setTranslationY(r119);
        if (r28 == null) goto L63;
        r28.setScaleX(r118);
    L63:
        if (r28 == null) goto L65;
        r28.setScaleY(r118);
    L65:
        if (r28 == null) goto L67;
        r28.setTranslationY(r119);
    L67:
        RoomContext r32 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r32 == null) goto L72;
        com.bytedance.live.datacontext.m r33 = r32.isSandwichAdapter();
        if (r33 == null) goto L72;
        r33.setValue(Boolean.TRUE);
    L72:
        ALogger.i("SandwichBorderInfo", "autoAdapterSandwichLayout roomId:" + r9 + " info:" + r26 + " ,scale:" + r118 + "  translateY:" + r119);
        r25 = true;
        goto L80
    L59:
        r118 = 1.0f / (r116 - r117);
        goto L60
    L55:
        r30 = x1.i(r29).heightPixels;
        goto L56
    L45:
        IRenderView r120 = r112.getRenderView();
        if ((r120 instanceof View) == true) goto L48;
        r120 = null;
    L48:
        View r121 = (View) r120;
        if (r121 == null) goto L79;
        r115 = TuplesKt.to(r121, (com.bytedance.android.live.platformplayer.layout.c) LivePlatformPlayerManager.b.get(Long.valueOf(r9)));
        goto L52
    L38:
        if (r113.gameExtraRenderController().isEnable() == false) goto L40;
    L41:
        r114 = true;
        goto L43
    L40:
        if (r113.extraRenderController().isGameRoom() == false) goto L42;
    L73:
        RoomContext r34 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r34 == null) goto L78;
        com.bytedance.live.datacontext.m r35 = r34.isSandwichAdapter();
        if (r35 == null) goto L78;
        r35.setValue(Boolean.FALSE);
    L78:
        ALogger.d("SandwichBorderInfo", "autoAdapterSandwichLayout roomId:" + r9 + " false , info == null");
    L13:
        r9 = 0;
        goto L15
    L5:
        r4 = x1.i(r3).heightPixels;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        KVData r2 = (KVData) r1;
    }

    public final void onLoad(Object[] r14) {
        DataCenter r15 = ((Widget) this).dataCenter;
        ViewParent r0 = null;
        if (r15 == null) goto L5;
        Boolean r16 = (Boolean) r15.get("data_longer_video_within_live_type", Boolean.FALSE);
    L6:
        this.y = !Intrinsics.areEqual(r16, Boolean.TRUE);
        this.F = getViewModel(LandscapeInteractionModel.class);
        this.B = findViewById(2131364569);
        this.C = findViewById(2131392785);
        if ((getContext() instanceof Activity) == false) goto L16;
        com.bytedance.android.livesdk.widget.gesture.a r17 = this.B;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mBrightnessView");
    L11:
        Context r3 = getContext();
        if (r3 == null) goto L15;
        r17.h(((Activity) r3).getWindow());
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L16:
        this.D = findViewById(2131364568);
        this.E = findViewById(2131392781);
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L112;
        Room r19 = (Room) r18.get("data_room");
        if (r19 == null) goto L115;
        this.a = r19;
        com.bytedance.android.livesdk.widget.gesture.a r110 = this.B;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mBrightnessView");
    L24:
        Room r4 = this.a;
        if (r4 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L27:
        r110.d(r4);
        com.bytedance.android.livesdk.widget.gesture.a r111 = this.B;
        if (r111 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mBrightnessView");
    L30:
        r111.g(((Widget) this).dataCenter);
        L7(com.bytedance.android.livesdk.event.a.class, new d(this));
        com.bytedance.android.livesdk.provideservices.b.a().bindDataCenter(((Widget) this).dataCenter);
        IVSPlayerService r112 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r112 == null) goto L33;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r113 = r112.provideVSPlayerViewControlService(((Widget) this).dataCenter);
    L34:
        this.d = r113;
        LandscapeInteractionModel r114 = this.F;
        if (r114 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("interactionModel");
    L37:
        r114.isLocked().observe(this, new e(this));
        RoomContext r115 = getDataContext();
        if (r115 == null) goto L71;
        com.bytedance.live.datacontext.m r116 = r115.getRoom();
        if (r116 == null) goto L71;
        Room r117 = (Room) r116.getValue();
        if (r117 == null) goto L71;
        long r5 = r117.getRoomId();
        as0.a r118 = LivePlatformPlayerManager.e(r5, false);
        if (r118 == null) goto L71;
        LivePlayerView r10 = r118.getLivePlayerView();
        if (r10 == null) goto L71;
        ILivePlayerClient r119 = r118.player();
        if (r119 != null) goto L52;
    L56:
        boolean r120 = false;
    L57:
        this.I = r120;
        if (r120 == false) goto L60;
        Pair r121 = TuplesKt.to(r10, null);
    L67:
        View r9 = (View) r121.component1();
        com.bytedance.android.live.platformplayer.layout.c r12 = (com.bytedance.android.live.platformplayer.layout.c) r121.component2();
        this.r = r9.getPivotX();
        this.s = r9.getPivotY();
        this.u = r9.getX();
        this.v = r9.getY();
        this.p = new WeakReference(r9);
        this.q = new WeakReference(r12);
        Context r8 = ((Widget) this).context;
        LandscapeInteractionModel r11 = this.F;
        if (r11 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("interactionModel");
    L70:
        ko1.b r122 = new ko1.b(r8, r9, r10, r11, r12);
        this.x = r122;
        r122.a();
        Aq(new do1.a(x6.a, 0, 5, 0));
        goto L71
    L60:
        IRenderView r123 = r10.getRenderView();
        if ((r123 instanceof View) == true) goto L63;
        r123 = null;
    L63:
        View r124 = (View) r123;
        if (r124 == null) goto L71;
        r121 = TuplesKt.to(r124, (com.bytedance.android.live.platformplayer.layout.c) LivePlatformPlayerManager.b.get(Long.valueOf(r5)));
        goto L67
    L52:
        if (r119.gameExtraRenderController().isEnable() == false) goto L54;
    L55:
        r120 = true;
        goto L57
    L54:
        if (r119.extraRenderController().isGameRoom() == false) goto L56;
    L71:
        L7(do1.a.class, new f(this));
        if (((d51) a1.a.getValue()).g() == false) goto L77;
        Room r125 = this.a;
        if (r125 == null) goto L77;
        if (r125.isMediaRoom() != true) goto L77;
    L79:
        if (VrUtils.t(((Widget) this).dataCenter, true) == false) goto L106;
        Room r126 = this.a;
        if (r126 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mRoom");
    L84:
        if (r126.isMediaRoom() == true) goto L106;
        WeakReference<View> r127 = this.p;
        if (r127 == null) goto L106;
        View r128 = r127.get();
        if (r128 == null) goto L106;
        if (this.u == 0.0f) goto L93;
    L94:
        Logger.d("LandscapeGestureWidget", "onLoad(), initX and initY are set to zero in vr landscape immersed mode.");
        r128.setLeft(0);
        r128.setTop(0);
        r128.setTranslationX(0.0f);
        r128.setTranslationY(0.0f);
        this.u = 0.0f;
        this.v = 0.0f;
        this.w = true;
    L95:
        ViewParent r2 = r128.getParent();
        if ((r2 instanceof FrameLayout) == false) goto L99;
        r0 = r2;
    L99:
        FrameLayout r1 = (FrameLayout) r0;
        if (r1 == null) goto L106;
        float r6 = r1.getWidth();
        float r7 = r1.getHeight();
        Logger.d("LandscapeGestureWidget", "onLoad(), parentWidth is " + r6 + ", parentHeight is " + r7 + '.');
        float r13 = (float) 2;
        float r20 = r6 / r13;
        if (Math.abs(this.r - r20) <= 1.0f) goto L104;
    L105:
        Logger.d("LandscapeGestureWidget", "onLoad(), initPivotX and initPivotY are set to half of parent size in vr landscape immersed mode.");
        r128.setPivotX(r20);
        r128.setPivotY(r7 / r13);
        this.r = r128.getPivotX();
        this.s = r128.getPivotY();
        this.t = true;
        goto L106
    L104:
        if (Math.abs(this.s - (r7 / r13)) <= 1.0f) goto L106;
    L93:
        if (this.v == 0.0f) goto L95;
    L106:
        RoomContext r129 = getDataContext();
        if (r129 == null) goto L113;
        com.bytedance.live.datacontext.m r130 = r129.getLandscapeRootChange();
        if (r130 == null) goto L114;
        x0 r21 = (x0) r130.getValue();
        UIUtils.updateLayoutMargin(((Widget) this).contentView, -r21.c, -3, -r21.d, -3);
        ((ObservableSubscribeProxy) r130.a().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new h(new LandscapeGestureWidget$onLoad$6$1(this)));
        return;
    L114:
        return;
    L113:
        return;
    L77:
        L7(zt2.a.class, new g(this));
        goto L79
    L33:
        r113 = null;
        goto L34
    L115:
        return;
    L112:
        return;
    L5:
        r16 = null;
        goto L6
    }

    public final void wq(boolean r3) {
        LiveLandSlideContext.Companion.getClass();
        if (LiveLandSlideContext.a.b() == true) goto L5;
        return;
    L5:
        if (this.h == false) goto L20;
        HSImageView r0 = this.D;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("brightHotArea");
    L9:
        UtilityKotlinExtentionsKt.z(r0, r3);
        if (this.H.booleanValue() == false) goto L36;
        HSImageView r4 = this.D;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("brightHotArea");
    L15:
        if ((r4.getDrawable() instanceof BitmapDrawable) == true) goto L37;
        String r5 = i2.a;
        HSImageView r6 = this.D;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("brightHotArea");
    L19:
        i2.h(r6, "/slide/ttlive_bg_hot_brightness_one_fifth.png");
        return;
    L37:
        return;
    L36:
        return;
    L20:
        HSImageView r1 = this.E;
        if (r1 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("volumeHotArea");
    L23:
        UtilityKotlinExtentionsKt.z(r1, r3);
        if (this.H.booleanValue() == false) goto L39;
        HSImageView r7 = this.E;
        if (r7 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("volumeHotArea");
    L29:
        if ((r7.getDrawable() instanceof BitmapDrawable) == true) goto L40;
        String r8 = i2.a;
        HSImageView r9 = this.E;
        if (r9 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("volumeHotArea");
    L33:
        i2.h(r9, "/slide/ttlive_bg_hot_volume_one_fifth.png");
        return;
    L40:
        return;
    }

    public final boolean xq(int r3) {
        if (r3 == 0) goto L8;
        float r4 = Math.abs(this.l);
        int r0 = M;
        if (r4 >= r0) goto L8;
        if (Math.abs(this.k) >= r0) goto L8;
        return true;
    L8:
        return false;
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    public final void Cq(Float r4, Float r5, Float r6, Float r7) {
        StringBuilder r0 = new StringBuilder("setScale ref render view :");
        WeakReference<View> r1 = this.p;
        com.bytedance.android.live.platformplayer.layout.c r2 = null;
        if (r1 == null) goto L5;
        View r3 = r1.get();
    L6:
        r0.append(r3);
        r0.append(", layout position :");
        WeakReference<com.bytedance.android.live.platformplayer.layout.c> r8 = this.q;
        if (r8 == null) goto L9;
        r2 = r8.get();
    L9:
        r0.append(r2);
        r0.append(" scaleX:");
        r0.append(r4);
        r0.append(",scaleY:");
        r0.append(r5);
        ALogger.i("LandscapeGestureWidget", r0.toString());
        WeakReference<View> r9 = this.p;
        if (r9 == null) goto L21;
        View r10 = r9.get();
        if (r10 == null) goto L21;
        if (r4 == null) goto L15;
        r10.setScaleX(r4.floatValue());
    L15:
        if (r5 == null) goto L17;
        r10.setScaleY(r5.floatValue());
    L17:
        if (r6 == null) goto L19;
        r10.setTranslationX(r6.floatValue());
    L19:
        if (r7 == null) goto L21;
        r10.setTranslationY(r7.floatValue());
    L21:
        WeakReference<com.bytedance.android.live.platformplayer.layout.c> r11 = this.q;
        if (r11 == null) goto L34;
        com.bytedance.android.live.platformplayer.layout.c r12 = r11.get();
        if (r12 == null) goto L35;
        if (r4 == null) goto L27;
        r12.setScaleX(r4.floatValue());
    L27:
        if (r5 == null) goto L29;
        r12.setScaleY(r5.floatValue());
    L29:
        if (r6 == null) goto L31;
        r12.setTranslationX(r6.floatValue());
    L31:
        if (r7 == null) goto L36;
        r12.setTranslationY(r7.floatValue());
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static /* synthetic */ void Eq(LandscapeGestureWidget r2, Float r3, Float r4, Float r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        r2.Cq(r3, r4, null, r5);
    }
}
