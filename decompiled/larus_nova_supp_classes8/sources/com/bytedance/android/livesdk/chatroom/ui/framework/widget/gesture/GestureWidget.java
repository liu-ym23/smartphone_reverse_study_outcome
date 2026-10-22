package com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.live.room.api.visibilitycontrol.LiveVisibilityControlContext;
import com.bytedance.android.live.room.enterprocess.IEnterProcessorService;
import com.bytedance.android.live.room.enterprocess.IInteractionBizInterceptor;
import com.bytedance.android.live.room.t;
import com.bytedance.android.live.room.y;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenConst;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.model.z3;
import com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.LiveVrContext;
import com.bytedance.android.livesdk.chatroom.ui.InteractionContext;
import com.bytedance.android.livesdk.chatroom.ui.d7;
import com.bytedance.android.livesdk.chatroom.ui.e7;
import com.bytedance.android.livesdk.chatroom.ui.f7;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.clearscreen.gesture.ClickPS2ClearScreenGestureBehavior;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.config.b41;
import com.bytedance.android.livesdk.config.c41;
import com.bytedance.android.livesdk.config.k2;
import com.bytedance.android.livesdk.config.m1;
import com.bytedance.android.livesdk.config.qy;
import com.bytedance.android.livesdk.config.tk;
import com.bytedance.android.livesdk.config.uk;
import com.bytedance.android.livesdk.feedback.room.RoomFeedbackContext;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.i1;
import com.bytedance.android.livesdk.utils.t1;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdk.widgetdescriptor.e0;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrlExtra;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nm1.r;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0004\t\n\u000b\fB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0004¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/gesture/GestureWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/gesture/q;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/app/Activity;", "getActivity", "<init>", "()V", "a", "b", "c", "d", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class GestureWidget extends MiddlewareRoomWidget implements q, Observer<KVData> {
    public static final /* synthetic */ int y = 0;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a c;
    public GestureDetectLayout d;
    public boolean e;
    public d f;
    public GestureDetector g;
    public c h;
    public ko1.d i;
    public com.bytedance.android.livesdk.clearscreen.gesture.b j;
    public com.bytedance.android.livesdk.chatroom.record.i k;
    public boolean l;
    public com.bytedance.android.livesdk.clearscreen.gesture.a m;
    public ClickPS2ClearScreenGestureBehavior n;
    public final lo1.a o;
    public View.OnTouchListener p;
    public h q;
    public Disposable r;
    public Disposable s;
    public Disposable t;
    public final CompositeDisposable u;
    public Disposable v;
    public Disposable w;
    public boolean x;

    public final class a implements DialogInterface.OnKeyListener {
        public boolean a;
        public final /* synthetic */ GestureWidget b;

        public a(GestureWidget r1) {
            this.b = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r4, int r5, KeyEvent r6) {
            Intrinsics.checkNotNullParameter(r4, "dialog");
            Intrinsics.checkNotNullParameter(r6, "event");
            int r0 = GestureWidget.y;
            Logger.d("GestureWidget", "onKey called " + r5 + " event " + r6);
            com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.b.a;
            p70.a r2 = null;
            if (r1 == null) goto L5;
            List<DialogInterface.OnKeyListener> r3 = r1.S5();
        L6:
            if (r3 == null) goto L11;
            Iterator<DialogInterface.OnKeyListener> r7 = r3.iterator();
        L9:
            if (r7.hasNext() == false) goto L11;
            r7.next().onKey(r4, r5, r6);
        L11:
            com.bytedance.android.livesdk.chatroom.ui.framework.a r8 = this.b.c;
            if (r8 == null) goto L17;
            Intrinsics.checkNotNullParameter(r8, "$this$getKeyEventProcessorChain");
            p70.a r9 = r8.E9();
            if ((r9 instanceof p70.a) == false) goto L17;
            r2 = r9;
        L17:
            if (r2 == null) goto L20;
            r2.a(new ah1.d(r4, r5, r6));
        L20:
            if (r5 != 25) goto L22;
        L25:
            boolean r10 = true;
        L27:
            if (tb1.c.a == false) goto L42;
            if (r10 == false) goto L42;
            this.b.getClass();
            IInteractGameService r11 = jc1.k.f(IInteractGameService.class);
            Intrinsics.checkNotNull(r11);
            if (r11.isPlayingGame(InteractID.EffectGame) == true) goto L37;
            IKtvService r12 = jc1.k.f(IKtvService.class);
            Intrinsics.checkNotNull(r12);
            if (r12.isInKtvState(1) == true) goto L34;
        L36:
            boolean r13 = false;
        L38:
            if (r13 == true) goto L42;
            xs2.b.a().post(new com.bytedance.android.livesdk.event.a(0, r5, r6));
            return false;
        L34:
            if (k2.a.getValue().booleanValue() == false) goto L36;
        L37:
            r13 = true;
        L42:
            if (r6.getAction() != 0) goto L46;
            this.a = true;
            return false;
        L46:
            if (4 == r5) goto L48;
        L51:
            return false;
        L48:
            if (this.a == false) goto L51;
            this.b.onBackPressed();
            this.a = false;
            return true;
        L22:
            if (r5 == 24) goto L25;
            r10 = false;
            goto L27
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class b {
    }

    public final class c extends GestureDetector.SimpleOnGestureListener {
        public int a;
        public final /* synthetic */ GestureWidget b;

        public c(GestureWidget r1) {
            this.b = r1;
            this.a = -1;
        }

        public final boolean a(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "e");
            if (this.b.pX() == true) goto L5;
        L14:
            Room r0 = this.b.getRoom();
            if (r0 == null) goto L17;
            RoomAuthStatus r2 = r0.getRoomAuthStatus();
        L18:
            if (r2 != null) goto L20;
        L23:
            boolean r1 = this.b.D8(r6);
            if (r1 == true) goto L29;
            GestureWidget r3 = this.b;
            Disposable r4 = r3.t;
            if (r4 == null) goto L28;
            r4.dispose();
        L28:
            r3.t = Observable.timer(((Number) ClearScreenHelper.d.getValue()).longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(r3, r6));
            this.a = r6.getActionIndex();
        L33:
            return r1;
        L29:
            Disposable r7 = this.b.t;
            if (r7 == null) goto L32;
            r7.dispose();
        L32:
            this.a = -1;
            goto L33
        L20:
            if (r0.getRoomAuthStatus().getEnableDigg() == true) goto L23;
            GestureWidget.xq(this.b, r6);
            return false;
        L17:
            r2 = null;
            goto L18
        L5:
            if (this.b.x == true) goto L7;
        L9:
            boolean r5 = false;
        L10:
            if (r5 == true) goto L14;
            GestureWidget.xq(this.b, r6);
            return false;
        L7:
            if (uk.a.getValue().booleanValue() == false) goto L9;
            r5 = true;
            goto L10
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r6) {
            Intrinsics.checkNotNullParameter(r6, "e");
            Disposable r0 = this.b.t;
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            ko1.d r1 = this.b.i;
            if (r1 == null) goto L14;
            r1.a = true;
            ko1.d.a r2 = r1.d;
            if (r2 == null) goto L10;
            r2.removeCallbacks(r1.e);
        L10:
            ko1.d.a r3 = r1.d;
            if (r3 == null) goto L14;
            r3.postDelayed(r1.e, r1.b.c());
        L14:
            if (this.b.pX() == true) goto L23;
            boolean r7 = this.b.D8(r6);
            if (r7 == true) goto L26;
        L22:
            return r7;
        L26:
            IEnterProcessorService r4 = jc1.k.f(IEnterProcessorService.class);     // Catch: Exception -> L25
            if (r4 == null) goto L22;
            IInteractionBizInterceptor r5 = r4.interactionBizInterceptor();     // Catch: Exception -> L25
            if (r5 == null) goto L22;
            r5.doDiggActionWithToken(this.b.getContext());     // Catch: Exception -> L25
            goto L22
        L23:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            GestureWidget r4 = this.b;
            int r0 = GestureWidget.y;
            if (r4.isViewValid() == false) goto L27;
            Activity r1 = r4.getActivity();
            if (r1 == null) goto L28;
            View r5 = r4.Gq();
            if (r5 == null) goto L22;
            IBinder r6 = r5.getWindowToken();
            if (r6 == null) goto L29;
            Object r2 = r1.getSystemService("input_method");
            if (r2 == null) goto L21;
            ((InputMethodManager) r2).hideSoftInputFromWindow(r6, 0);     // Catch: Exception -> L18
            return true;
        L18:
            e = move-exception;
            e.printStackTrace();
            return true;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        L29:
            return true;
        L22:
            return true;
        L28:
            return true;
        L27:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            super.onLongPress(r4);
            Room r5 = this.b.getRoom();
            if (r5 != null) goto L5;
            return;
        L5:
            xs2.b.a().post(new h1(26, r5));
            i1.a(null, "press", r5);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            GestureWidget r0 = this.b;
            if (r4.getActionIndex() != this.a) goto L5;
            boolean r1 = true;
        L7:
            return r0.br(r4, r1);
        L5:
            r1 = false;
            goto L7
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            this.b.cr();
            return a(r2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
            Intrinsics.checkNotNullParameter(r3, "e2");
            return this.b.Zq(r2, r3, r4, r5);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r5, MotionEvent r6, float r7, float r8) {
            Intrinsics.checkNotNullParameter(r6, "e2");
            if (r5 != null) goto L5;
            return false;
        L5:
            int r1 = GestureWidget.y;
            StringCompanionObject r2 = StringCompanionObject.INSTANCE;
            Logger.d("GestureWidget", String.format("onScroll, Event1={%f, %f}, Event2={%f, %f}, distanceX=%f, distanceY=%f", Arrays.copyOf(new Object[]{Float.valueOf(r5.getX()), Float.valueOf(r5.getY()), Float.valueOf(r6.getX()), Float.valueOf(r6.getY()), Float.valueOf(r7), Float.valueOf(r8)}, 6)));
            return this.b.ar(r5, r6, r7, r8);
        }
    }

    public final class d implements View.OnTouchListener {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public final /* synthetic */ GestureWidget f;

        public d(GestureWidget r1) {
            this.f = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r9, MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r9, "v");
            Intrinsics.checkNotNullParameter(r10, "event");
            if (this.a == 0.0f) goto L5;
            this.f.Wq(r10.getX(), r10.getY(), this.a, this.d, this.e);
        L6:
            this.a = r10.getX();
            r10.getY();
            if (r10.getAction() != 1) goto L9;
        L10:
            ut1.j.d(this.f.getActivity());
            this.a = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
        L11:
            int r0 = r10.getAction();
            if (r0 == 0) goto L18;
            if (r0 != 1) goto L20;
            this.a = 0.0f;
            if (Math.abs(this.b - r10.getX()) > 30) goto L20;
            Math.abs(this.c - r10.getY());
        L20:
            if (this.f.isAnchor() == true) goto L22;
        L24:
            GestureWidget r1 = this.f;
            if (r10.getAction() == 0) goto L27;
            boolean r2 = true;
        L28:
            boolean r3 = r1.Rq(r2);
            ah1.b r4 = null;
            if (r3 == false) goto L31;
        L53:
            com.bytedance.android.livesdk.chatroom.record.i r5 = this.f.k;
            if (r5 == null) goto L56;
            r5.a(r10);
        L56:
            View.OnTouchListener r6 = this.f.Fq();
            if (r6 == null) goto L59;
            r6.onTouch(r9, r10);
        L59:
            com.bytedance.android.livesdk.chatroom.ui.framework.c r7 = this.f.a;
            if (r7 == null) goto L62;
            List<View.OnTouchListener> r8 = r7.u6();
        L63:
            if (r8 == null) goto L68;
            Iterator<View.OnTouchListener> r11 = r8.iterator();
        L66:
            if (r11.hasNext() == false) goto L68;
            r11.next().onTouch(r9, r10);
        L68:
            com.bytedance.android.livesdk.chatroom.ui.framework.a r12 = this.f.c;
            if (r12 == null) goto L71;
            r4 = r12.xb();
        L71:
            if (r4 != null) goto L73;
        L75:
            RoomContext r13 = this.f.Iq();
            if (r13 == null) goto L85;
            com.bytedance.live.datacontext.m r14 = r13.getLiveTouchListenerList();
            if (r14 == null) goto L85;
            List r15 = (List) r14.getValue();
            if (r15 == null) goto L85;
            Iterator r16 = r15.iterator();
            if (r16.hasNext() == false) goto L85;
            return ((View.OnTouchListener) r16.next()).onTouch(r9, r10);
        L85:
            return false;
        L73:
            if (r4.a(new ah1.e(r9, r10)) != true) goto L75;
            return false;
        L62:
            r8 = null;
            goto L63
        L31:
            if (this.f.Nq(r10) == true) goto L53;
            GestureWidget r17 = this.f;
            if (r17.g == null) goto L53;
            h70.b r18 = r17.getComponentContext();
            if (r18 == null) goto L39;
            IAbilityCenter r19 = r18.a();
            if (r19 == null) goto L39;
            jo1.c r20 = (jo1.c) r19.getAbility(jo1.c.class);
        L40:
            if (r20 != null) goto L42;
        L44:
            GestureDetector r21 = this.f.g;
            if (r21 == null) goto L49;
            if (r21.onTouchEvent(r10) == true) goto L53;
        L49:
            if (r10.getAction() != 1) goto L51;
        L52:
            this.f.Yq();
            goto L53
        L51:
            if (r10.getAction() != 3) goto L53;
        L42:
            if (r20.onTouchEvent(r10) != true) goto L44;
            int r22 = GestureWidget.y;
            ALogger.i("GestureWidget", "mScaleGestureDetector intercept event");
            r10.setAction(3);
        L39:
            r20 = null;
            goto L40
        L27:
            r2 = false;
            goto L28
        L22:
            if (com.bytedance.android.livesdk.utils.p.a() == false) goto L24;
            this.f.Jq(r10);
            goto L24
        L18:
            this.b = r10.getX();
            this.c = r10.getY();
            goto L20
        L9:
            if (r10.getAction() != 3) goto L11;
        L5:
            this.e = r10.getY();
            this.d = r10.getX();
            goto L6
        }
    }

    static {
    }

    public abstract void Cq(float r1, float r2);

    public void I4(boolean r1, boolean r2) {
    }

    public void Jq(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public boolean Mq() {
        return this instanceof AudiencePortraitGestureWidget;
    }

    public boolean Nq(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return false;
    }

    public void Wq(float r1, float r2, float r3, float r4, float r5) {
    }

    public void Yq() {
    }

    public boolean Zq(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        return false;
    }

    public boolean ar(MotionEvent r1, MotionEvent r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r1, "e1");
        Intrinsics.checkNotNullParameter(r2, "e2");
        return true;
    }

    public boolean br(MotionEvent r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "e");
        return false;
    }

    public void cr() {
    }

    public void dr(String r1) {
    }

    public void er() {
        this.p = null;
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q
    public final boolean onBackPressed() {
        if (Rq(true) == false) goto L5;
        return true;
    L5:
        IEnterGuideService r1 = jc1.k.f(IEnterGuideService.class);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a;
        if (r2 == null) goto L8;
        Fragment r3 = r2.getFragment();
    L9:
        if (r1 == null) goto L15;
        if (r3 == null) goto L15;
        if (r1.isBottomGuideShowing(r3) == false) goto L15;
        r1.closeBottomGuide(r3);
        return true;
    L15:
        RoomContext r4 = Iq();
        if (r4 != null) goto L18;
    L21:
        h1 r5 = new h1(8);
        Bundle r6 = new Bundle();
        r6.putLong("time", System.currentTimeMillis());
        r6.putString("action_type", "draw");
        r5.d = r6;
        xs2.b.a().post(r5);
        dr("back_press_to_finish_live");
        f7.b = true;
        d7.b = true;
        e7.b = true;
        return true;
    L18:
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.b) r4.getCommonPopupModel().getValue()).a == false) goto L21;
        xs2.b.a().post(new com.bytedance.android.livesdk.commonpop.a());
        return true;
    L8:
        r3 = null;
        goto L9
    }

    public final View Gq() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Wa();
    }

    public final void Lq() {
        if (this.e == true) goto L60;
        this.h = new c(this);
        Context r1 = getContext();
        c r2 = this.h;
        Intrinsics.checkNotNull(r2);
        this.g = new GestureDetector(r1, r2);
        b41 r0 = c41.a;
        View r3 = null;
        if (r0.b() == false) goto L22;
        GestureDetector r4 = this.g;     // Catch: Throwable -> L19
        if (r4 == null) goto L9;
        Field r5 = r4.getClass().getDeclaredField("mMinimumFlingVelocity");     // Catch: Throwable -> L19
    L10:
        if (r5 == null) goto L12;
        r5.setAccessible(true);     // Catch: Throwable -> L19
    L12:
        if (r5 == null) goto L22;
        GestureDetector r6 = this.g;     // Catch: Throwable -> L19
        if (r0.b() == false) goto L16;
        int r7 = r0.e();     // Catch: Throwable -> L19
    L17:
        r5.setInt(r6, r7);     // Catch: Throwable -> L19
        goto L22
    L16:
        r7 = 150;
        goto L17
    L9:
        r5 = null;
    L19:
        th = move-exception;
        th.printStackTrace();
    L22:
        if (this.g == null) goto L27;
        if (qy.a.getValue().b() == false) goto L27;
        GestureDetector r8 = this.g;
        Intrinsics.checkNotNull(r8);
        this.i = new ko1.d(r8);
    L27:
        if (g1() == true) goto L29;
    L53:
        this.k = new com.bytedance.android.livesdk.chatroom.record.i(getContext(), ((Widget) this).dataCenter);
        d r9 = new d(this);
        this.f = r9;
        GestureDetectLayout r10 = this.d;
        if (r10 == null) goto L56;
        Intrinsics.checkNotNull(r9);
        r10.b(r9);
    L56:
        this.e = true;
        return;
    L29:
        if (ClearScreenHelper.d(((Widget) this).dataCenter) == false) goto L53;
        if (isAnchor() == true) goto L53;
        if (this.j != null) goto L41;
        int r11 = com.bytedance.android.livesdk.clearscreen.gesture.b.t;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r12 = this.b;
        if (r12 == null) goto L38;
        View r13 = r12.getRootView();
    L39:
        Intrinsics.checkNotNull(r13);
        Context r14 = getContext();
        DataCenter r15 = getDataCenter();
        Intrinsics.checkNotNullParameter(r13, "rootView");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "dataCenter");
        com.bytedance.android.livesdk.clearscreen.gesture.b r16 = new com.bytedance.android.livesdk.clearscreen.gesture.b(r13, r14);
        int r17 = gh1.a.c;
        gh1.a.a.a(r15, r16);
        this.j = r16;
        this.r = Disposables.fromAction(new m(this, r16));
        goto L41
    L38:
        r13 = null;
    L41:
        if (this.n != null) goto L53;
        if (ClearScreenHelper.l(getDataCenter()) == true) goto L45;
    L47:
        boolean r18 = false;
    L48:
        if (r18 == false) goto L53;
        int r19 = ClickPS2ClearScreenGestureBehavior.q;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r20 = this.b;
        if (r20 == null) goto L52;
        r3 = r20.getRootView();
    L52:
        Intrinsics.checkNotNull(r3);
        Context r21 = getContext();
        DataCenter r22 = getDataCenter();
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "dataCenter");
        ClickPS2ClearScreenGestureBehavior r23 = new ClickPS2ClearScreenGestureBehavior(r3, r21, r22);
        int r24 = gh1.a.c;
        gh1.a.a.a(r22, r23);
        this.n = r23;
        r23.b = new n(this);
        this.w = Disposables.fromAction(new o(this, r23));
        goto L53
    L45:
        if (ClearScreenHelper.j().j() == false) goto L47;
        r18 = true;
        goto L48
    }

    public final boolean Pq() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        IUserService r2 = jc1.k.f(IUserService.class);
        User r3 = null;
        if (r2 == null) goto L8;
        com.bytedance.android.livesdk.user.f r4 = r2.user();
    L9:
        if (r4 == null) goto L15;
        IUserService r5 = jc1.k.f(IUserService.class);
        Intrinsics.checkNotNull(r5);
        User r6 = r5.user().b();
        if (r6 == null) goto L14;
        r3 = r6;
        goto L15
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.User");
    L15:
        if (r3 != null) goto L17;
        return false;
    L17:
        boolean r7 = isAnchor();
        if (r0.getVideoTalkService() == null) goto L20;
        boolean r8 = r0.getVideoTalkService().C(r7, r3.getIdString());
    L22:
        if (r0.getAudioTalkService() == null) goto L24;
        boolean r9 = r0.getAudioTalkService().q(r7, r3.getIdString());
    L26:
        if (r0.getInteractAudienceService() == null) goto L28;
        boolean r10 = r0.getInteractAudienceService().S(r7, r3);
    L29:
        iy.g r1 = r0.getDynamicCenterService(((Widget) this).dataCenter);
        if (r1 == null) goto L32;
        boolean r11 = r1.Rp();
    L33:
        if (r8 == true) goto L37;
        if (r9 == true) goto L37;
        if (r10 == true) goto L37;
        if (r11 == true) goto L37;
        return false;
    L37:
        return true;
    L32:
        r11 = false;
        goto L33
    L28:
        r10 = false;
        goto L29
    L24:
        r9 = false;
        goto L26
    L20:
        r8 = false;
        goto L22
    L8:
        r4 = null;
        goto L9
    }

    public final boolean Qq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L25;
        Room r1 = z.o(r0);
        if (r1 == null) goto L31;
        RoomContext r2 = Iq();
        if (r2 != null) goto L11;
        return false;
    L11:
        if (com.bytedance.android.livesdk.chatroom.game.e.a(r1, r2) == true) goto L13;
        return false;
    L13:
        if (isAnchor() == false) goto L15;
        return false;
    L15:
        if (t1.a(r1) == true) goto L17;
        return false;
    L17:
        if (Sq() == true) goto L29;
        RoomContext r3 = Iq();
        if (r3 == null) goto L21;
        boolean r4 = r3.isMediaRoom();
    L22:
        if (r4 == true) goto L30;
        return true;
    L30:
        return false;
    L21:
        r4 = false;
        goto L22
    L29:
        return false;
    L31:
        return false;
    L25:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q
    public final void R5() {
        Disposable r0 = this.s;
        if (r0 != null) goto L5;
    L9:
        LiveVisibilityControlContext.Companion.getClass();
        if (LiveVisibilityControlContext.a.a() == false) goto L14;
        com.bytedance.android.livesdk.chatroom.utils.h1.a r1 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r2 = ((Widget) this).dataCenter;
        r1.getClass();
        IVisibilityControlService r3 = com.bytedance.android.livesdk.chatroom.utils.h1.a.g(r2);
        if (r3 == null) goto L22;
        r3.stopVisibilityTimer();
        return;
    L22:
        return;
    L14:
        RoomContext r4 = Iq();
        if (r4 == null) goto L24;
        com.bytedance.live.datacontext.m r5 = r4.getCastScreenEntryDismissTimer();
        if (r5 == null) goto L25;
        ig1.b r6 = (ig1.b) r5.getValue();
        if (r6 == null) goto L26;
        r6.release();
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L5:
        if (r0.isDisposed() == true) goto L9;
        Disposable r7 = this.s;
        if (r7 == null) goto L9;
        r7.dispose();
        goto L9
    }

    public final boolean fr() {
        LiveVrContext.Companion.getClass();
        com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel.a r0 = LiveVrContext.c.a();
        if (r0 == null) goto L8;
        if (r0.isInVrMode() == false) goto L8;
        return true;
    L8:
        if (ClearScreenHelper.a() == false) goto L10;
        return false;
    L10:
        RoomFeedbackContext.Companion.getClass();
        RoomFeedbackContext r1 = RoomFeedbackContext.a.a();
        if (r1 != null) goto L13;
    L15:
        RoomContext r2 = Iq();
        if (r2 == null) goto L22;
        com.bytedance.live.datacontext.m r3 = r2.isInZoom();
        if (r3 == null) goto L22;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L22;
        return true;
    L22:
        return false;
    L13:
        if (((Boolean) r1.isHideViewsOnClearScreen().getValue()).booleanValue() == false) goto L15;
        return true;
    }

    public final boolean g1() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
    L6:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r1 = this.a;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.V9() != true) goto L11;
        return true;
    L5:
        if (r0.dg() != true) goto L6;
        return true;
    }

    public final Activity getActivity() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.p0();
    }

    public final Room getRoom() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L7;
        return null;
    L7:
        return z.o(r0);
    }

    public final Observable<Unit> hr() {
        LiveVisibilityControlContext.Companion.getClass();
        if (LiveVisibilityControlContext.a.a() == false) goto L7;
        ALogger.d("timerTag", "AbsInteractionFragment.java # startTimer # get common timer");
        com.bytedance.android.livesdk.chatroom.utils.h1.a r0 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        IVisibilityControlService r2 = com.bytedance.android.livesdk.chatroom.utils.h1.a.g(r1);
        if (r2 != null) goto L16;
    L14:
        return null;
    L16:
        return r2.startVisibilityTimer();
    L7:
        ALogger.d("timerTag", "AbsInteractionFragment.java # startTimer # get dataContext timer");
        RoomContext r3 = Iq();
        if (r3 == null) goto L14;
        com.bytedance.live.datacontext.m r4 = r3.getCastScreenEntryDismissTimer();
        if (r4 == null) goto L14;
        ig1.b r5 = (ig1.b) r4.getValue();
        if (r5 == null) goto L14;
        return r5.a();
    }

    public final boolean isAnchor() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.dg();
    }

    public void onWidgetLoaded() {
        if (tk.a.getValue().booleanValue() == false) goto L18;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L8;
        Bundle r2 = r0.Wl();
    L9:
        if (r2 == null) goto L11;
        Bundle r3 = m0.a(r2);
    L13:
        if (r3 == null) goto L16;
        r1 = r3.getString("clean_room_after_enter");
    L16:
        if (Intrinsics.areEqual(r1, "1") == false) goto L18;
        r3.remove("clean_room_after_enter");
        ClearScreenHelper.m(true);
        goto L18
    L11:
        r3 = null;
        goto L13
    L8:
        r2 = null;
    L18:
        Lq();
    }

    public final boolean pX() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) r0.get("DATA_IS_HIDE_INTERACTION", Boolean.FALSE)).booleanValue() == false) goto L7;
        return true;
    }

    public final boolean yq() {
        Integer r0 = (Integer) ((Widget) this).dataCenter.get("data_screen_orientation", 1);
        if (r0 != null) goto L6;
    L10:
        return false;
    L6:
        if (r0.intValue() != 1) goto L10;
        if (this.dataContext == null) goto L10;
        return true;
    }

    public final boolean zq() {
        com.bytedance.android.livesdk.chatroom.utils.h1.a r0 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        LiveVisibilityControlContext r2 = com.bytedance.android.livesdk.chatroom.utils.h1.a.f(r1);
        if (r2 != null) goto L5;
    L29:
        return false;
    L5:
        if (r2.enablePlayBackAbility() == false) goto L29;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 != null) goto L10;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L29;
        if (PadConfigUtils.a() == false) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == true) goto L29;
        if (com.bytedance.android.livesdk.chatroom.utils.h1.a.a() == false) goto L29;
        return true;
    L21:
        if (FoldScreenUtils.e() == true) goto L24;
        r5 = false;
        goto L25
    L10:
        if (com.bytedance.android.livesdk.chatroom.utils.h1.a.c() == false) goto L16;
        if (z.m(r3, true) == false) goto L16;
        if (z.e(r3, false) == true) goto L16;
        r4 = true;
        goto L17
    }

    public GestureWidget() {
        this.o = new lo1.a(new WeakReference(new a(this)));
        this.u = new CompositeDisposable();
    }

    public final boolean Aq() {
        RoomContext r0 = Iq();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (ClearScreenHelper.g() == false) goto L8;
    L13:
        return true;
    L8:
        if (ClearScreenHelper.d(((Widget) this).dataCenter) == true) goto L10;
        return false;
    L10:
        if (((Boolean) r0.isCleanMode().getValue()).booleanValue() == true) goto L13;
        if (((Number) r0.getCleanMode().getValue()).intValue() == ClearScreenConst.InteractType.INTERACT_SHOW.getId()) goto L13;
        return false;
    }

    public final jo1.e Eq() {
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        return (jo1.e) r1.getAbility(jo1.e.class);
    L7:
        return null;
    }

    public final RoomContext Iq() {
        MiddlewareRoomContext r0 = getMiddlewareRoomContext();
        if ((r0 instanceof RoomContext) == true) goto L6;
        r0 = null;
    L6:
        return (RoomContext) r0;
    }

    public final boolean Kq() {
        if (zq() == false) goto L6;
        return true;
    L6:
        if (yq() == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean Sq() {
        RoomContext r0 = Iq();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isVSRoom();
    }

    public final boolean Tq() {
        RoomContext r0 = Iq();
        if (r0 == null) goto L15;
        com.bytedance.live.datacontext.n r1 = r0.getWidgetLoadedProperty();
        if (r1 == null) goto L15;
        z3 r2 = (z3) r1.getValue();
        if (r2 == null) goto L15;
        z3.a r3 = r2.d;
        if (r3 == null) goto L15;
        PropertyOwner r4 = r3.b;
        if (r4 == null) goto L15;
        if (((Boolean) r4.a).booleanValue() != true) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean isRecording() {
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L9;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L9;
        IRoomRecordService r2 = r1.getAbility(IRoomRecordService.class);
        if (r2 == null) goto L9;
        return r2.isRecording();
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r0 = getComponentContext();
        InteractionContext r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = ho1.a.d(r0);
    L6:
        this.a = r2;
        h70.b r3 = getComponentContext();
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r4 = ho1.a.i(r3);
    L10:
        this.b = r4;
        h70.b r5 = getComponentContext();
        if (r5 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r6 = ho1.a.c(r5);
    L14:
        this.c = r6;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r7 = this.b;
        if (r7 == null) goto L17;
        GestureDetectLayout r8 = r7.oh();
    L19:
        if ((r8 instanceof GestureDetectLayout) == true) goto L21;
        r8 = null;
    L21:
        this.d = r8;
        if (r8 == null) goto L24;
        r8.setEnableSlide(Mq());
    L24:
        GestureDetectLayout r9 = this.d;
        if (r9 == null) goto L27;
        r9.setSlideAction(new g(this));
    L27:
        ((Widget) this).dataCenter.put("data_text_message_widget_slide", Boolean.valueOf(Mq()));
        RoomContext r10 = Iq();
        if (r10 == null) goto L34;
        r r11 = pm1.f.o();
        if (r11 == null) goto L34;
        r11.a();
        if (MultiTabManagerImpl.e.i(((Widget) this).dataCenter) != true) goto L34;
        r10.getInteractionFragmentDoubleTap().setValue(new i(this));
        r10.getInteractionFragmentSwipeListener().setValue(new j(this));
    L34:
        this.q = new h(this);
        h70.b r12 = getComponentContext();
        if ((r12 instanceof e0) == true) goto L37;
        r12 = null;
    L37:
        e0 r13 = (e0) r12;
        if (r13 == null) goto L40;
        r1 = r13.k;
    L40:
        if (r1 == null) goto L44;
        com.bytedance.live.datacontext.n<View.OnTouchListener> r14 = r1.getInterceptViewTouchListener();
        if (r14 == null) goto L44;
        r14.setValue(this.q);
    L44:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r15 = this.c;
        if (r15 == null) goto L52;
        PropertyOwner r16 = r15.getLoadState();
        if (r16 == null) goto L52;
        Disposable r17 = com.bytedance.android.livesdk.chatroom.ui.framework.b.a(r16, new AnonymousClass1(this));
        if (r17 == null) goto L52;
        RxUtilKt.c(r17, this.u);
    L52:
        if (Sq() == true) goto L54;
    L64:
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L67;
        r18.observeForever("cmd_widget_loaded", this);
    L67:
        int r19 = y.a;
        y.a(((Widget) this).dataCenter, this.u, "GestureWidget#initKeyListener", new AnonymousClass3(this));
        h70.b r20 = getComponentContext();
        if (r20 == null) goto L73;
        IAbilityCenter r21 = r20.a();
        if (r21 == null) goto L73;
        r21.registerAbility(q.class, this);
    L73:
        if (uk.a.getValue().booleanValue() == false) goto L78;
        DataCenter r22 = ((Widget) this).dataCenter;
        if (r22 == null) goto L79;
        r22.observe("data_hide_screen", this);
        return;
    L79:
        return;
    L78:
        return;
    L54:
        if (com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.e == false) goto L64;
        if (g1() == false) goto L64;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r23 = this.c;
        if (r23 == null) goto L64;
        PropertyOwner r24 = r23.getLoadState();
        if (r24 == null) goto L64;
        Disposable r25 = com.bytedance.android.livesdk.chatroom.ui.framework.b.a(r24, new AnonymousClass2(this));
        if (r25 == null) goto L64;
        RxUtilKt.c(r25, this.u);
        goto L64
    L17:
        r8 = null;
        goto L19
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        r1.unregisterAbility(q.class);
    L7:
        this.u.dispose();
        R5();
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L10;
        r2.removeObserver(this);
    L10:
        this.a = null;
        this.b = null;
        this.c = null;
        GestureDetectLayout r3 = this.d;
        if (r3 == null) goto L13;
        r3.setSlideAction(null);
    L13:
        Disposable r4 = this.t;
        if (r4 == null) goto L16;
        r4.dispose();
        this.t = null;
    L16:
        Disposable r5 = this.r;
        if (r5 == null) goto L19;
        r5.dispose();
        this.r = null;
    L19:
        Disposable r6 = this.w;
        if (r6 == null) goto L22;
        r6.dispose();
        this.w = null;
    L22:
        Disposable r7 = this.v;
        if (r7 == null) goto L25;
        r7.dispose();
        this.v = null;
    L25:
        er();
        h70.b r8 = getComponentContext();
        if ((r8 instanceof e0) == true) goto L28;
        r8 = null;
    L28:
        e0 r9 = (e0) r8;
        if (r9 == null) goto L31;
        InteractionContext r10 = r9.k;
    L32:
        if (r10 == null) goto L36;
        com.bytedance.live.datacontext.n<View.OnTouchListener> r11 = r10.getInterceptViewTouchListener();
        if (r11 == null) goto L36;
        r11.setValue(null);
    L36:
        this.q = null;
        this.l = false;
        return;
    L31:
        r10 = null;
        goto L32
    }

    public View.OnTouchListener Fq() {
        return this.p;
    }

    public static final /* synthetic */ DataContext wq(GestureWidget r0) {
        return r0.dataContext;
    }

    public boolean D8(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        if (r2 != null) goto L5;
    L9:
        return false;
    L5:
        if (r2.getDiggWidget().getValue() == null) goto L9;
        u32.k r4 = (u32.k) r2.getDiggWidget().getValue();
        if (r4 == null) goto L9;
        return r4.D8(r3);
    }

    public final boolean Rq(boolean r3) {
        t r0 = (t) com.bytedance.android.livesdk.service.l.d().b().a(t.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowStickerView() == false) goto L13;
        if (r3 == false) goto L12;
        r0.hideStickerView();
        return true;
    L12:
        return true;
    L13:
        return false;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hq() != true) goto L35;
        if (r5 == null) goto L9;
        String r1 = r5.getKey();
    L10:
        if (r1 == null) goto L36;
        int r2 = r1.hashCode();
        if (r2 == (-1836833765)) goto L25;
        if (r2 == (-1122045708)) goto L18;
        return;
    L18:
        if (r1.equals("data_hide_screen") == false) goto L31;
        Boolean r6 = (Boolean) r5.getData();
        if (r6 == null) goto L22;
        boolean r7 = r6.booleanValue();
    L23:
        this.x = r7;
        return;
    L22:
        r7 = false;
        goto L23
    L31:
        return;
    L25:
        if (r1.equals("cmd_widget_loaded") == true) goto L27;
        return;
    L27:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.d.a(r5) == false) goto L34;
        onWidgetLoaded();
        return;
    L34:
        return;
    L36:
        return;
    L9:
        r1 = null;
        goto L10
    }

    public static final void xq(GestureWidget r7, MotionEvent r8) {
        Room r0 = r7.getRoom();
        if (r0 == null) goto L91;
        boolean r1 = r7.pX();
        View r4 = null;
        Pair r2 = (Pair) ((Widget) r7).dataCenter.get("data_video_size_pair", null);
        if (r2 == null) goto L8;
        Integer r3 = (Integer) r2.getFirst();
    L9:
        boolean r5 = false;
        if (r3 == null) goto L17;
        if (r2.getSecond() == null) goto L17;
        Object r6 = r2.getFirst();
        Intrinsics.checkNotNull(r6);
        int r9 = ((Number) r6).intValue();
        Object r10 = r2.getSecond();
        Intrinsics.checkNotNull(r10);
        if (r9 > ((Number) r10).intValue()) goto L20;
    L21:
        boolean r11 = false;
    L22:
        if (r11 == true) goto L24;
        DataCenter r12 = ((Widget) r7).dataCenter;
        Lazy r13 = ClearScreenHelper.a;
        if (m1.a.getValue().booleanValue() == false) goto L79;
        if (r12 == null) goto L79;
        if (z.l(r12) != true) goto L79;
        r5 = true;
    L79:
        if (r5 == true) goto L90;
        r7.gr(!r1, r8);
        return;
    L90:
        return;
    L24:
        if (r7.Aq() == false) goto L64;
        if (r7.Kq() == false) goto L64;
        Rect r14 = new Rect();
        RoomContext r15 = r7.Iq();
        if (r15 == null) goto L40;
        com.bytedance.live.datacontext.m r16 = r15.getRoom();
        if (r16 == null) goto L40;
        Room r17 = (Room) r16.getValue();
        if (r17 == null) goto L40;
        ILivePlayerClient r18 = LivePlatformPlayerManager.a(r17.getRoomId(), false);
        if (r18 == null) goto L38;
        IRenderView r19 = r18.getRenderView();
        if (r19 == null) goto L38;
        r4 = r19.getSelfView();
    L38:
        if (r4 == null) goto L40;
        IRenderView r20 = r18.getRenderView();
        Intrinsics.checkNotNull(r20);
        r20.getSelfView().getGlobalVisibleRect(r14);
        r5 = true;
    L40:
        if (r5 == true) goto L42;
        r7.Bq(!r1, r8);
        return;
    L42:
        if (r8.getRawX() >= r14.left) goto L44;
    L61:
        r7.gr(!r1, r8);
        return;
    L44:
        if (r8.getRawX() > r14.right) goto L61;
        if (r8.getRawY() < r14.top) goto L61;
        if (r8.getRawY() > r14.bottom) goto L61;
        if (((Boolean) ClearScreenHelper.e.getValue()).booleanValue() == false) goto L60;
        RoomContext r21 = r7.Iq();
        if (r21 == null) goto L60;
        com.bytedance.live.datacontext.m r22 = r21.isCleanMode();
        if (r22 == null) goto L60;
        if (((Boolean) r22.getValue()).booleanValue() != true) goto L60;
        if (r7.isAnchor() == true) goto L60;
        r7.gr(!r1, r8);
        return;
    L60:
        r7.Bq(!r1, r8);
        return;
    L64:
        if (r7.Kq() == true) goto L69;
        if (r7.Aq() == false) goto L69;
        r7.gr(!r1, r8);
        return;
    L69:
        if (r7.Kq() == true) goto L71;
        return;
    L71:
        if (r7.Aq() == true) goto L88;
        r7.Bq(!r1, r8);
        return;
    L88:
        return;
    L20:
        r11 = true;
    L17:
        if (r0.getStreamUrlExtra() == null) goto L21;
        StreamUrlExtra r23 = r0.getStreamUrlExtra();
        Intrinsics.checkNotNull(r23);
        int r24 = r23.getWidth();
        StreamUrlExtra r25 = r0.getStreamUrlExtra();
        Intrinsics.checkNotNull(r25);
        if (r24 <= r25.getHeight()) goto L21;
    L8:
        r3 = null;
        goto L9
    }

    public final void Bq(boolean r6, MotionEvent r7) {
        if (ClearScreenHelper.f(RoomContext.a.c(RoomContext.Companion, getDataCenter(), 0, 2), getDataCenter()) == false) goto L20;
        gr(r6, r7);
        if (yq() == false) goto L73;
        if (r6 == true) goto L74;
        RoomContext r8 = Iq();
        if (r8 == null) goto L75;
        com.bytedance.live.datacontext.m r9 = r8.isShowCastScreenUIByClickScreen();
        if (r9 != null) goto L12;
        return;
    L12:
        if (((Boolean) r9.getValue()).booleanValue() == true) goto L77;
        RoomContext r10 = Iq();
        if (r10 == null) goto L78;
        com.bytedance.live.datacontext.m r11 = r10.isShowCastScreenUIByClickScreen();
        if (r11 == null) goto L79;
        r11.setValue(Boolean.TRUE);
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L75:
        return;
    L74:
        return;
    L73:
        return;
    L20:
        if (zq() == false) goto L24;
        ALogger.d("visibilityControlTag", "AbsInteractionFragment #onSingleTapConfirmed, clickInteraction");
        com.bytedance.android.livesdk.chatroom.utils.h1.a r12 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r13 = ((Widget) this).dataCenter;
        r12.getClass();
        IVisibilityControlService r14 = com.bytedance.android.livesdk.chatroom.utils.h1.a.g(r13);
        if (r14 == null) goto L24;
        r14.changeTetrisVisible();
        boolean r15 = true;
    L26:
        if (yq() == false) goto L80;
        String r16 = "已隐藏播放控制栏";
        if (r15 == false) goto L51;
        com.bytedance.android.livesdk.chatroom.utils.h1.a r17 = com.bytedance.android.livesdk.chatroom.utils.h1.b;
        DataCenter r1 = ((Widget) this).dataCenter;
        r17.getClass();
        IVisibilityControlService r18 = com.bytedance.android.livesdk.chatroom.utils.h1.a.g(r1);
        if (r18 == null) goto L81;
        boolean r19 = r18.provideContext().getPlaybackVisibleValue();
        if (r3.l(getContext()) == false) goto L37;
        Context r2 = getContext();
        if (r19 == false) goto L36;
        r16 = "已显示播放控制栏";
    L36:
        r3.q(r2, r16);
    L37:
        RoomContext r20 = Iq();
        if (r20 == null) goto L87;
        if (r19 == true) goto L46;
        com.bytedance.live.datacontext.m r21 = r20.isShowCastScreenUIByClickScreen();
        Boolean r0 = Boolean.FALSE;
        r21.setValue(r0);
        if (Qq() == false) goto L44;
        r20.isShowTitleUIByClickScreen().setValue(r0);
    L44:
        R5();
        return;
    L46:
        if (Qq() == false) goto L48;
        r20.isShowTitleUIByClickScreen().setValue(Boolean.TRUE);
    L48:
        r20.isShowCastScreenUIByClickScreen().setValue(Boolean.TRUE);
        R5();
        Observable<Unit> r22 = hr();
        if (r22 == null) goto L83;
        this.s = r22.observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r20));
        return;
    L83:
        return;
    L87:
        return;
    L81:
        return;
    L51:
        RoomContext r23 = Iq();
        if (r23 == null) goto L88;
        boolean r3 = ((Boolean) r23.isShowCastScreenUIByClickScreen().getValue()).booleanValue();
        if (r3.l(getContext()) == false) goto L61;
        Context r4 = getContext();
        if (r3 == true) goto L60;
        r16 = "已显示播放控制栏";
    L60:
        r3.q(r4, r16);
    L61:
        if (r3 == false) goto L67;
        com.bytedance.live.datacontext.m r24 = r23.isShowCastScreenUIByClickScreen();
        Boolean r5 = Boolean.FALSE;
        r24.setValue(r5);
        if (Qq() == false) goto L65;
        r23.isShowTitleUIByClickScreen().setValue(r5);
    L65:
        R5();
        return;
    L67:
        if (Qq() == false) goto L69;
        r23.isShowTitleUIByClickScreen().setValue(Boolean.TRUE);
    L69:
        r23.isShowCastScreenUIByClickScreen().setValue(Boolean.TRUE);
        R5();
        Observable<Unit> r25 = hr();
        if (r25 == null) goto L86;
        this.s = r25.observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, r23));
        return;
    L86:
        return;
    L88:
        return;
    L80:
        return;
    L24:
        r15 = false;
        goto L26
    }

    public final void gr(boolean r5, MotionEvent r6) {
        RoomContext r0 = Iq();
        if (r0 != null) goto L6;
        return;
    L6:
        if (ClearScreenHelper.d(getDataCenter()) == false) goto L11;
        if (isAnchor() == false) goto L11;
        return;
    L11:
        if (ClearScreenHelper.g() == true) goto L19;
        if (ClearScreenHelper.d(((Widget) this).dataCenter) == true) goto L15;
        return;
    L15:
        if (((Boolean) r0.isCleanMode().getValue()).booleanValue() == true) goto L19;
        if (((Number) r0.getCleanMode().getValue()).intValue() == ClearScreenConst.InteractType.INTERACT_SHOW.getId()) goto L19;
        return;
    L19:
        if (Pq() == false) goto L25;
        if (wt2.a.d(Boolean.valueOf(isAnchor())) == false) goto L25;
        f2.b(2131917260, 0);
        ALogger.e("GestureWidget", "rejected screen clean for pure clean mode");
        return;
    L25:
        if (isRecording() == false) goto L27;
        return;
    L27:
        int r1 = com.bytedance.android.livesdk.clearscreen.o.j0;
        com.bytedance.android.livesdk.clearscreen.o r2 = com.bytedance.android.livesdk.clearscreen.o.a.a(this.d);
        if (r2 == null) goto L36;
        boolean r7 = r2.C(r6);
        MotionEvent r3 = r2.i0;
        if (r3 == null) goto L32;
        r3.recycle();
    L32:
        r2.i0 = null;
        if (r7 == false) goto L36;
        ALogger.e("GestureWidget", "刚退出pinch放大模式，这里不消费了");
        return;
    L36:
        ALogger.d("clearscreen_tag", "time is " + System.currentTimeMillis());
        xs2.b.a().post(new ToolbarClearScreenEvent(r5, true));
        if (r5 == false) goto L39;
        ClearScreenLogUtils.Companion r8 = ClearScreenLogUtils.a;
        DataCenter r4 = ((Widget) this).dataCenter;
        r8.getClass();
        ClearScreenLogUtils.Companion.d(r4, "click_button", null);
        return;
    L39:
        ClearScreenLogUtils.Companion r9 = ClearScreenLogUtils.a;
        DataCenter r10 = ((Widget) this).dataCenter;
        r9.getClass();
        ClearScreenLogUtils.Companion.f(r10, "click_button", null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q
    public final void N9(boolean r2, Integer r3, Integer r4, Boolean r5) {
        GestureDetectLayout r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setIsInMultiAnchorLink(r2);
        if (r3 == null) goto L8;
        r0.setMultiAnchorTopY(r3.intValue());
    L8:
        if (r4 == null) goto L10;
        r0.setMultiAnchorBottomY(r4.intValue());
    L10:
        if (r5 == null) goto L13;
        r0.setIsAnchor(Boolean.valueOf(r5.booleanValue()));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.gesture.q
    public final void jp(boolean r2, Integer r3, Integer r4, Boolean r5) {
        GestureDetectLayout r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setIsInPk(r2);
        if (r3 == null) goto L8;
        r0.setPkTopY(r3.intValue());
    L8:
        if (r4 == null) goto L10;
        r0.setPkBottomY(r4.intValue());
    L10:
        if (r5 == null) goto L13;
        r0.setIsAnchor(Boolean.valueOf(r5.booleanValue()));
        return;
    }
}
