package com.bytedance.android.livesdk.interactivity.like;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.identity.CardTypeAndPriority;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.panel.PanelCoverListener;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.c2;
import com.bytedance.android.livesdk.config.ce1;
import com.bytedance.android.livesdk.config.d2;
import com.bytedance.android.livesdk.config.f2;
import com.bytedance.android.livesdk.config.jn;
import com.bytedance.android.livesdk.config.l20;
import com.bytedance.android.livesdk.config.lj1;
import com.bytedance.android.livesdk.config.nj0;
import com.bytedance.android.livesdk.config.on;
import com.bytedance.android.livesdk.config.qn;
import com.bytedance.android.livesdk.config.qq;
import com.bytedance.android.livesdk.config.rn;
import com.bytedance.android.livesdk.config.uk;
import com.bytedance.android.livesdk.config.xm;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.api.like.utils.DiggABHelper;
import com.bytedance.android.livesdk.interactivity.api.like.utils.UserInfoDiggBridge;
import com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.like.controller.DiggCountFlipperLayoutControllerImpl;
import com.bytedance.android.livesdk.interactivity.like.controller.State;
import com.bytedance.android.livesdk.interactivity.like.view.BottomSelfDiggOptimizeView;
import com.bytedance.android.livesdk.interactivity.like.view.DiggCountFlipperLayout;
import com.bytedance.android.livesdk.interactivity.like.view.DiggTabCountView;
import com.bytedance.android.livesdk.interactivity.like.view.DiggTapOptimizeView;
import com.bytedance.android.livesdk.message.model.ek;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdk.message.model.yd;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.opt.MeasureOptFrameLayout;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameDataChannelConfig;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.feed.digg.ILivePreviewDiggView;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ec2.v1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import org.json.JSONObject;
import r52.b4;
import zg1.n3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u0007:\u0004\u000e\u000f\u0010\u0011B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/DiggWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lu32/k;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/common/i;", "Lcom/bytedance/android/live/room/api/visibilitycontrol/b;", "Lzg1/n3;", "event", BuildConfig.FLAVOR, "onEvent", "<init>", "()V", "a", "b", "c", "d", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DiggWidget extends RoomRecyclableWidget implements u32.k, vlc.l, Observer<KVData>, com.bytedance.android.livesdk.common.i, com.bytedance.android.live.room.api.visibilitycontrol.b {
    public static final int M1 = 0;
    public static final int P1 = 0;
    public boolean A;
    public boolean B;
    public Disposable C;
    public vlc.d D;
    public final PublishSubject<Integer> E;
    public Disposable F;
    public boolean G;
    public final s G1;
    public Boolean H;
    public final Map<Long, List<py.k>> H0;
    public int H1;
    public Boolean I;
    public boolean J;
    public PublishSubject<Unit> K;
    public u32.i L;
    public final ts1.a L0;
    public long L1;
    public h32.a M;
    public boolean N;
    public final Lazy O;
    public yd P;
    public f32.i P0;
    public Disposable Q;
    public boolean R;
    public final j S;
    public final i T;
    public boolean U;
    public int V;
    public f32.d V0;
    public final Lazy W;
    public long X;
    public final PublishSubject Y;
    public final Observable<Long> Z;
    public final s82.a a;
    public Boolean b;
    public final x b1;
    public View c;
    public BottomSelfDiggOptimizeView d;
    public SimpleDraweeView e;
    public DiggTabCountView f;
    public com.bytedance.android.livesdk.interactivity.like.l g;
    public final h g1;
    public final d h;
    public boolean h1;
    public final c i;
    public com.bytedance.android.livesdk.interactivity.like.controller.d j;
    public Disposable k;
    public boolean k0;
    public final g k1;
    public UserInfoDiggBridge l;
    public CompositeDisposable m;
    public final ArrayList<Integer> n;
    public final SparseArray<Bitmap> o;
    public final ArrayList<Integer> p;
    public final e p0;
    public final int p1;
    public final SparseArray<Bitmap> q;
    public final ArrayList<py.k> r;
    public final Set<Bitmap> s;
    public long t;
    public Disposable u;
    public boolean v;
    public boolean v1;
    public long w;
    public int x;
    public final long x1;
    public long y;
    public final f y1;
    public Room z;

    public static final class a {
        public static Bitmap a(Bitmap r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "bitmap");
            Bitmap r0 = Bitmap.createBitmap(r8, r8, Bitmap.Config.ARGB_4444);
            Canvas r1 = new Canvas(r0);
            Paint r2 = new Paint();
            r2.setAntiAlias(true);
            Rect r3 = new Rect(0, 0, r8, r8);
            RectF r5 = new RectF(r3);
            float r9 = r8 / 2;
            r1.drawARGB(0, 0, 0, 0);
            r2.setColor(-12434878);
            r1.drawRoundRect(r5, r9, r9, r2);
            r2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            r1.drawBitmap(r7, null, r3, r2);
            r2.setColor(ColorProtector.parseColor("#ffffff"));
            r2.setStyle(Paint.Style.STROKE);
            r2.setStrokeWidth(s1.f(1.3f));
            r1.drawCircle(r5.centerX(), r5.centerY(), r5.width() / 2, r2);
            return r0;
        }
    }

    public static abstract class b {
        public b() {
        }
    }

    public final class c extends b {
        public Bitmap a;
        public boolean b;
        public Disposable c;
        public Disposable d;
        public int e;
        public int f;
        public final /* synthetic */ DiggWidget g;

        public final BottomSelfDiggOptimizeView a() {
            BottomSelfDiggOptimizeView r0 = this.g.d;
            if ((r0 instanceof com.bytedance.android.livesdk.interactivity.like.view.z) == true) goto L6;
            return null;
        L6:
            return r0;
        }

        public final boolean b() {
            if (((ys1.a) v1.a.getValue()).a() == false) goto L9;
            DataCenter r0 = ((Widget) this.g).dataCenter;
            if (r0 == null) goto L9;
            Boolean r1 = (Boolean) r0.get("cmd_notify_web_dialog_status", Boolean.FALSE);
            if (r1 == null) goto L9;
            boolean r2 = r1.booleanValue();
        L11:
            if (((Boolean) this.g.W.getValue()).booleanValue() == false) goto L16;
            if (com.bytedance.android.livesdk.utils.b.a().b == false) goto L16;
            r2 = true;
        L16:
            if (this.g.L.c() == true) goto L18;
            return false;
        L18:
            if (this.g.L.a() == true) goto L20;
            return false;
        L20:
            if (this.g.V0.a == true) goto L26;
            if (r2 == true) goto L27;
            return true;
        L27:
            return false;
        L26:
            return false;
        L9:
            r2 = false;
            goto L11
        }

        public c(DiggWidget r1) {
            this.g = r1;
            new ArrayList();
        }

        public final void c(boolean r2, int r3) {
            this.b = r2;
            if (r2 == true) goto L5;
            Disposable r4 = this.c;
            if (r4 == null) goto L24;
            r4.dispose();
        L24:
            Disposable r5 = this.d;
            if (r5 == null) goto L29;
            r5.dispose();
            return;
        L29:
            return;
        L5:
            if (b() == false) goto L15;
            if (((Boolean) PerformanceTestSettings.TEST_DISABLE_DIGG.getValue()).booleanValue() == true) goto L15;
            Disposable r6 = this.c;
            if (r6 == null) goto L13;
            r6.dispose();
        L13:
            int r7 = com.bytedance.android.livesdk.interactivity.like.utils.j.a;
            this.c = Disposables.fromAction(new com.bytedance.android.livesdk.interactivity.like.u(this, Observable.create(com.bytedance.android.livesdk.interactivity.like.utils.e.a).subscribeOn(Schedulers.io()).onErrorReturn(com.bytedance.android.livesdk.interactivity.like.v.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.interactivity.like.x(this))));
        L15:
            if (b() == false) goto L30;
            Disposable r8 = this.d;
            if (r8 == null) goto L20;
            r8.dispose();
        L20:
            this.e = r3;
            this.d = Observable.interval(300, TimeUnit.MILLISECONDS).filter(new y(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new z(this));
            return;
        }

        public final void e(Bitmap r8, Bitmap r9) {
            Intrinsics.checkNotNullParameter(r8, "avatarBitmap");
            Intrinsics.checkNotNullParameter(r9, "normalBitmap");
            if (b() == true) goto L6;
            return;
        L6:
            if (((Boolean) PerformanceTestSettings.TEST_DISABLE_DIGG.getValue()).booleanValue() == false) goto L9;
            return;
        L9:
            if (this.g.V0.b == false) goto L11;
            return;
        L11:
            float r0 = s1.f(34.0f) + (Random.Default.nextInt(-32, 32) / 2);
            PointF r4 = new PointF(r0, s1.f(192.0f));
            PointF r5 = new PointF(r0, s1.f(112.0f));
            BottomSelfDiggOptimizeView r1 = a();
            if (r1 == null) goto L15;
            r1.c(r8, r9, r4, r5, 3);
            return;
        }

        public final void f(Bitmap r13, Bitmap r14) {
            Intrinsics.checkNotNullParameter(r13, "avatarBitmap");
            Intrinsics.checkNotNullParameter(r14, "normalBitmap");
            if (b() == true) goto L6;
            return;
        L6:
            if (((Boolean) PerformanceTestSettings.TEST_DISABLE_DIGG.getValue()).booleanValue() == false) goto L8;
            return;
        L8:
            boolean r1 = true;
            if (this.b == false) goto L12;
            this.e++;
            return;
        L12:
            Random.Default r0 = Random.Default;
            if (r0.nextInt(1, 100) >= (((Number) InteractivityOpt.c(jn.a)).floatValue() * 100)) goto L15;
            return;
        L15:
            float r4 = InteractivityOpt.a(34.0f) + (r0.nextInt(-32, 32) / 2);
            if (this.g.isRunOnLivePreview() == true) goto L18;
            PointF r5 = new PointF(r4, InteractivityOpt.a(192.0f));
        L20:
            if (this.g.isRunOnLivePreview() == true) goto L22;
            PointF r7 = new PointF(r4, InteractivityOpt.a(112.0f));
        L23:
            boolean r8 = false;
            if (this.g.isRunOnLivePreview() == true) goto L40;
            DiggWidget r6 = this.g;
            if (r6.V0.b == true) goto L40;
            if (this.b == true) goto L40;
            if (r6.x != 1) goto L36;
            this.f = r0.nextInt(2, 5);
        L36:
            if (Math.abs(this.g.x - this.f) >= 2) goto L38;
            this.f += r0.nextInt(2, 5);
        L39:
            r8 = r1;
            goto L40
        L38:
            r1 = false;
        L40:
            if (r8 == false) goto L44;
            BottomSelfDiggOptimizeView r2 = a();
            if (r2 == null) goto L48;
            r2.c(r13, r14, r5, r7, 1);
            return;
        L48:
            return;
        L44:
            BottomSelfDiggOptimizeView r3 = a();
            if (r3 == null) goto L50;
            r3.d(r14, r5, r7, 2, 0);
            return;
        L50:
            return;
        L22:
            r7 = new PointF(r4, InteractivityOpt.a(98.0f) - (com.bytedance.android.livesdk.interactivity.like.view.g.a(2).b * 0.5f));
            goto L23
        L18:
            r5 = new PointF(r4, InteractivityOpt.a(218.0f) - (com.bytedance.android.livesdk.interactivity.like.view.g.a(2).b * 0.5f));
            goto L20
        }

        public final void d(Bitmap r9, int r10, long r11) {
            Intrinsics.checkNotNullParameter(r9, "bitmap");
            if (((Boolean) PerformanceTestSettings.TEST_DISABLE_DIGG.getValue()).booleanValue() == false) goto L5;
            return;
        L5:
            float r0 = s1.f(34.0f) + (Random.Default.nextInt(-32, 32) / 2);
            PointF r3 = new PointF(r0, s1.f(192.0f));
            PointF r4 = new PointF(r0 + r10, s1.f(112.0f));
            if (this.g.k0 == false) goto L8;
            int r5 = 5;
        L9:
            BottomSelfDiggOptimizeView r1 = a();
            if (r1 == null) goto L13;
            r1.d(r9, r3, r4, r5, r11);
            return;
        L13:
            return;
        L8:
            r5 = 4;
            goto L9
        }
    }

    public final class d extends b {
        public boolean a;
        public final /* synthetic */ DiggWidget b;

        public static final class a implements Runnable {
            public final /* synthetic */ com.bytedance.android.livesdk.interactivity.like.view.z a;
            public final /* synthetic */ PointF b;
            public final /* synthetic */ d c;
            public final /* synthetic */ Bitmap d;
            public final /* synthetic */ PointF e;

            public a(com.bytedance.android.livesdk.interactivity.like.view.z r1, PointF r2, boolean r3, d r4, Bitmap r5, PointF r6) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
                this.d = r5;
                this.e = r6;
            }

            public final void a() {
                int r0 = com.bytedance.android.livesdk.interactivity.like.utils.j.a;
                Bitmap r1 = this.d;
                PointF r8 = this.e;
                Intrinsics.checkNotNullParameter(r1, "bitmap");
                Intrinsics.checkNotNullParameter(r8, "position");
                if (r1.isRecycled() == false) goto L5;
                Pair r2 = null;
            L6:
                if (r2 != null) goto L8;
                return;
            L8:
                this.a.a((Bitmap) r2.component1(), (PointF) r2.component2(), this.b, -1, 25.0f, this.c.b.P0);
                return;
            L5:
                Matrix r6 = new Matrix();
                r6.postScale(0.8f, 0.8f);
                r2 = new Pair(Bitmap.createBitmap(r1, 0, 0, r1.getWidth(), r1.getHeight(), r6, true), new PointF(r8.x + (r1.getWidth() * 1.5f), r8.y + (((-r1.getHeight()) * 0.1f) - 20.0f)));
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

        public static final class b implements Runnable {
            public final /* synthetic */ d a;

            public b(d r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                View r0 = this.a.b.c;     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.performHapticFeedback(1, 2);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public d(DiggWidget r1) {
            this.b = r1;
        }

        public final void a(Bitmap r18, MotionEvent r19, PointF r20) {
            Intrinsics.checkNotNullParameter(r18, "bitmap");
            DiggWidget r1 = this.b;
            if (r1.h1 == true) goto L5;
            int r0 = 2;
            int r11 = 1;
        L96:
            if (this.b.B == false) goto L98;
            boolean r7 = false;
        L99:
            if (r7 == false) goto L116;
        L107:
            e = move-exception;
            ALogger.e("DiggWidget", "performHapticFeedback npe: " + e);
            return;
        L101:
            if (InteractivityOpt.a == false) goto L103;
            Schedulers.io().scheduleDirect(new b(this));     // Catch: NullPointerException -> L107
        L110:
            return;
        L103:
            View r2 = this.b.c;     // Catch: NullPointerException -> L107
            if (r2 == null) goto L110;
            r2.performHapticFeedback(r11, r0);     // Catch: NullPointerException -> L107
            goto L110
        L116:
            return;
        L98:
            r7 = ((Boolean) com.bytedance.android.livesdk.sharedpref.b.Y2.getValue()).booleanValue();
            goto L99
        L5:
            if (r1.P0.a <= 0) goto L7;
            r1.h1 = false;
            Handler r3 = com.bytedance.android.live.core.utils.i0.c();
            DiggWidget r4 = this.b;
            r3.postDelayed(r4.k1, r4.P0.a);
        L7:
            int[] r5 = new int[2];
            View r6 = this.b.c;
            if (r6 == null) goto L10;
            r6.getLocationOnScreen(r5);
        L10:
            Object r8 = null;
            if (r20 == null) goto L13;
            float r9 = r20.x;
        L15:
            Float r10 = Float.valueOf(r9);
        L17:
            if (r10 == null) goto L93;
            float r13 = r10.floatValue();
            if (r20 == null) goto L21;
            float r14 = r20.y;
        L23:
            Float r15 = Float.valueOf(r14);
        L25:
            if (r15 == null) goto L114;
            PointF r16 = new PointF(r13 - r5[0], r15.floatValue() - r5[1]);
            DiggWidget r17 = this.b;
            View r21 = r17.c;
            if ((r21 instanceof com.bytedance.android.livesdk.interactivity.like.view.z) == false) goto L30;
            r8 = r21;
        L30:
            com.bytedance.android.livesdk.interactivity.like.view.z r23 = (com.bytedance.android.livesdk.interactivity.like.view.z) r8;
            if (r23 == null) goto L49;
            com.bytedance.android.livesdk.interactivity.like.controller.a r24 = r17.Eq();
            if (r24 == null) goto L35;
            PointF r25 = r24.a;
            PointF r26 = new PointF(r25.x + (0 / 2), r25.y);
        L36:
            DataCenter r27 = ((Widget) this.b).dataCenter;
            if (r27 == null) goto L39;
            boolean r28 = com.bytedance.android.live.core.utils.z.e(r27, false);
        L41:
            if (this.a == false) goto L43;
            float r110 = 0.0f;
        L44:
            PointF r111 = r16;
            com.bytedance.android.livesdk.interactivity.like.view.z.a.a(r23, r18, r16, r26, r28, r110, this.b.P0, 16);
            if (this.a == false) goto L50;
            View r29 = this.b.c;
            if (r29 == null) goto L50;
            r11 = 1;
            boolean r30 = r28;
            r0 = 2;
            r29.postDelayed(new a(r23, r26, r30, this, r18, r111), 150);
        L51:
            Room r31 = this.b.z;
            if (r31 == null) goto L56;
            if (r31.isMergeVSRoom() != r11) goto L56;
        L57:
            Room r33 = this.b.z;
            if (r33 == null) goto L96;
            if (r33.isMergeVSRoom() != r11) goto L96;
            DiggContext.a r34 = DiggContext.Companion;
            DataCenter r35 = ((Widget) this.b).dataCenter;
            r34.getClass();
            DiggContext r36 = DiggContext.a.a(r35);
            if (r36 == null) goto L96;
            com.bytedance.live.datacontext.m<Boolean> r37 = r36.getVsLiveRoomDiggCountAnim();
            if (r37 == null) goto L96;
            if (((Boolean) r37.getValue()).booleanValue() != r11) goto L96;
        L67:
            DiggWidget r38 = this.b;
            DiggTabCountView r39 = r38.f;
            if (r39 == null) goto L96;
            int r40 = r38.x;
            boolean r41 = this.a;
            PointF r43 = r111;
            Intrinsics.checkNotNullParameter(r43, "position");
            if (r40 < 10) goto L96;
            if ((r40 % 10) != 0) goto L78;
            int r44 = r40 + 10;
            r39.h.clear();
            int r45 = r40;
        L75:
            if (r45 >= r44) goto L78;
            r39.h.add(Integer.valueOf(r45));
            r45 = r45 + Random.Default.nextInt(r0, 4);
        L78:
            if (r39.h.contains(Integer.valueOf(r40)) == false) goto L96;
            r39.j.a();
            r39.e = new PointF(r43.x, r43.y);
            r39.b.setText(String.valueOf(r40));
            if (10 > r40) goto L86;
            if (49 < r40) goto L86;
            int r46 = -1;
        L92:
            r39.b.setTextColor(r46);
            r39.c.setTextColor(r46);
            UtilityKotlinExtentionsKt.v(r39.d, r41);
            r39.b.post(new com.bytedance.android.livesdk.interactivity.like.view.s(r39));
        L86:
            if (50 <= r40) goto L89;
        L91:
            r46 = ColorProtector.parseColor("#FFA9A9");
            goto L92
        L89:
            if (99 < r40) goto L91;
            r46 = ColorProtector.parseColor("#FFEBB6");
        L56:
            if (this.b.P0.b == false) goto L67;
        L50:
            r0 = 2;
            r11 = 1;
            goto L51
        L43:
            r110 = -25.0f;
            goto L44
        L39:
            r28 = true;
            goto L41
        L35:
            r26 = new PointF();
            goto L36
        L49:
            r111 = r16;
            goto L50
        L114:
            return;
        L21:
            if (r19 == null) goto L24;
            r14 = r19.getRawY();
            goto L23
        L24:
            r15 = null;
            goto L25
        L93:
            return;
        L13:
            if (r19 == null) goto L16;
            r9 = r19.getRawX();
            goto L15
        L16:
            r10 = null;
            goto L17
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ DiggWidget a;

        public e(DiggWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.k0 = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ DiggWidget a;

        public f(DiggWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.v1 = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ DiggWidget a;

        public g(DiggWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h1 = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements h32.d<f32.d> {
        public final /* synthetic */ DiggWidget a;

        public h(DiggWidget r1) {
            this.a = r1;
        }

        @Override // h32.d
        public final void a(f32.f r5) {
            f32.d r6 = (f32.d) r5;
            Intrinsics.checkNotNullParameter(r6, "newConfig");
            DiggWidget r0 = this.a;
            r0.V0 = r6;
            if (r0.j == null) goto L6;
            Math.max(200, r6.c);
            return;
        }
    }

    public static final class i extends cc2.p<cc2.i> {
        public final Set<cc2.i> f;
        public final Set<cc2.i> g;

        @Override // cc2.p
        public final Set<cc2.i> b() {
            return this.f;
        }

        @Override // cc2.p
        public final Set<cc2.i> c() {
            return this.g;
        }

        public i(c0 r4) {
            super(true, r4);
            this.f = SetsKt.setOf(new cc2.i[]{cc2.i.c.c, cc2.i.a.c, cc2.i.b.c});
            this.g = SetsKt.emptySet();
        }
    }

    public static final class j extends cc2.p<cc2.g> {
        public final Set<cc2.g> f;
        public final Set<cc2.g> g;

        @Override // cc2.p
        public final Set<cc2.g> b() {
            return this.f;
        }

        @Override // cc2.p
        public final Set<cc2.g> c() {
            return this.g;
        }

        public j(d0 r4) {
            super(true, r4);
            this.f = SetsKt.setOf(new cc2.g[]{cc2.g.a.c, cc2.g.d.c, cc2.g.c.c, cc2.g.e.c, cc2.g.b.c});
            this.g = SetsKt.emptySet();
        }
    }

    public static final class k<T> implements Predicate {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final boolean test(Object r2) {
            Bitmap r3 = (Bitmap) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return !r3.isRecycled();
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ DiggWidget a;

        public l(DiggWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Set<Bitmap> r0 = this.a.s;
            r0.add((Bitmap) r2);
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ DiggWidget a;

        public m(DiggWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            int r0 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
            this.a.getClass();
            com.bytedance.android.livesdk.interactivity.like.utils.b.b("a100.a100.a175", "Fetch Icon Failed, Error: " + ((Throwable) r3).getMessage());
        }
    }

    public static final class n implements Action {
        public final /* synthetic */ DiggWidget a;

        public n(DiggWidget r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.v = true;
        }
    }

    public static final class o implements u32.m.a {
        public final a a;
        public final /* synthetic */ DiggWidget b;

        public static final class a {
            public final /* synthetic */ o a;

            public final void a() {
                if (((Boolean) DiggABHelper.d.getValue()).booleanValue() == true) goto L7;
                DiggWidget r0 = this.a.b;
                int r1 = r0.V + 1;
                r0.V = r1;
                if ((r1 % r0.p1) != 0) goto L7;
                jc1.k.n(IPerformanceManager.class).monitorPerformance("show_digg");
                this.a.b.V = 0;
            L7:
                DiggWidget r2 = this.a.b;
                int r3 = DiggWidget.M1;
                Bitmap r4 = r2.Qq();
                if (r4 == null) goto L29;
                c r5 = this.a.b.i;
                r5.getClass();
                Intrinsics.checkNotNullParameter(r4, "normalBitmap");
                if (r5.b() == true) goto L13;
                return;
            L13:
                if (r5.g.N == true) goto L16;
                return;
            L16:
                if (((Boolean) PerformanceTestSettings.TEST_DISABLE_DIGG.getValue()).booleanValue() == false) goto L19;
                return;
            L19:
                if (r5.b == false) goto L22;
                r5.e++;
                return;
            L22:
                if (r4.isRecycled() == true) goto L34;
                long r8 = System.nanoTime();
                float r6 = InteractivityOpt.a(34.0f) + (Random.Default.nextInt(-32, 32) / 2);
                PointF r7 = new PointF(r6, InteractivityOpt.a(192.0f));
                PointF r9 = new PointF(r6, InteractivityOpt.a(112.0f));
                BottomSelfDiggOptimizeView r10 = r5.a();
                if (r10 == null) goto L27;
                r10.b(r4, r7, r9, 0);
            L27:
                Boolean r11 = com.bytedance.android.livesdk.interactivity.like.utils.k.a;
                com.bytedance.android.livesdk.interactivity.like.utils.k.b += System.nanoTime() - r8;
                com.bytedance.android.livesdk.interactivity.like.utils.k.c++;
                return;
            L34:
                return;
            }

            public a(o r1) {
                this.a = r1;
            }
        }

        @Override // u32.m.a
        public final a a() {
            return this.a;
        }

        public o(DiggWidget r1) {
            this.b = r1;
            this.a = new a(this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.DiggWidget$onLoad$5, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        final /* synthetic */ DiggWidget this$0;

        public AnonymousClass5(DiggWidget r1) {
            this.this$0 = r1;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final Unit m693invoke() {
            DiggWidget r0 = this.this$0;
            int r1 = DiggWidget.M1;
            RoomContext r2 = r0.getDataContext();
            if (r2 == null) goto L7;
            com.bytedance.live.datacontext.j r3 = r2.getWidgetLoadTaskScheduler();
            if (r3 == null) goto L7;
            r3.c(new AnonymousClass1(this));
            return Unit.INSTANCE;
        L7:
            return null;
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return m693invoke();
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ DiggWidget a;

        public p(DiggWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (this.a.isScreenPortrait() == false) goto L11;
            DiggWidget r0 = this.a;
            if (r3.booleanValue() == false) goto L8;
            int r4 = 8;
        L9:
            r0.A9(r4);
            return;
        L8:
            r4 = 0;
            goto L9
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ DiggWidget a;

        public q(DiggWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            DiggWidget.zq(this.a);
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ DiggWidget a;

        public r(DiggWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            DiggWidget.zq(this.a);
        }
    }

    public static final class s extends PanelCoverListener {
        public final /* synthetic */ DiggWidget c;

        public final boolean e(com.bytedance.android.live.room.api.panel.e r2) {
            Intrinsics.checkNotNullParameter(r2, "panelInfo");
            return true;
        }

        public final String getName() {
            return "DiggWidget";
        }

        public final View d() {
            return ((Widget) this.c).contentView;
        }

        public final void f() {
            ALogger.i("PanelCoverListener", "hide, listener = DiggWidget");
            this.c.T.e(cc2.i.b.c, true);
            this.c.Sq(false);
        }

        public final void g() {
            ALogger.i("PanelCoverListener", "show, listener = DiggWidget");
            this.c.T.e(cc2.i.b.c, false);
            this.c.Sq(true);
        }

        public s(DiggWidget r1) {
            this.c = r1;
        }
    }

    public static final class t<T> implements Predicate {
        public static final t a = null;

        static {
            a = new t();
        }

        public t() {
        }

        public final boolean test(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            if (r3.size() <= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class u<T, R> implements Function {
        public final /* synthetic */ DiggWidget a;

        public u(DiggWidget r1) {
            this.a = r1;
        }

        public final Object apply(Object r26) {
            List r2 = (List) r26;
            Intrinsics.checkNotNullParameter(r2, "it");
            HashMap r0 = new HashMap();
            if (this.a.isRunOnLivePreview() == false) goto L5;
            String r3 = "preview_stream";
        L6:
            r0.put("action_stream_type", r3);
            r0.put("like_amount", String.valueOf(r2.size()));
            DiggWidget r4 = this.a;
            int r5 = DiggWidget.M1;
            r4.getClass();
            List r6 = r2;
            ArrayList r7 = new ArrayList();
            Iterator<T> r8 = r6.iterator();
        L7:
            boolean r9 = false;
            if (r8.hasNext() == false) goto L17;
            T r10 = r8.next();
            Integer r11 = (Integer) r10;
            if (r11 != null) goto L13;
        L15:
            if (r9 == false) goto L7;
            r7.add(r10);
            goto L7
        L13:
            if (r11.intValue() != 2) goto L15;
            r9 = true;
            goto L15
        L17:
            int r13 = r7.size();
            ArrayList r14 = new ArrayList();
            Iterator<T> r15 = r6.iterator();
        L19:
            if (r15.hasNext() == false) goto L29;
            T r16 = r15.next();
            Integer r17 = (Integer) r16;
            if (r17 != null) goto L24;
        L26:
            boolean r18 = false;
        L27:
            if (r18 == false) goto L19;
            r14.add(r16);
            goto L19
        L24:
            if (r17.intValue() != 1) goto L26;
            r18 = true;
            goto L27
        L29:
            r0.put("gesture_amount", "icon:" + r13 + "|combo:" + r14.size());
            Room r19 = this.a.z;
            if (r19 == null) goto L32;
            LiveMode r20 = r19.getStreamType();
        L33:
            int r21 = h1.a;
            r0.put("live_type", i1.a(r20));
            RoomContext r23 = RoomContext.a.c(RoomContext.Companion, ((Widget) this.a).dataCenter, 0, 2);
            if (r23 != null) goto L36;
        L46:
            Room r24 = this.a.z;
            String r25 = BuildConfig.FLAVOR;
            if (r24 == null) goto L50;
            String r27 = r24.getOwnerUserIdString();
            if (r27 == null) goto L50;
        L51:
            r0.put("to_user_id", r27);
            r0.put("to_user_type", "room");
            r0.put("request_page", "double_click");
            r0.put("is_vr_machine", VrUtils.o(((Widget) this.a).dataCenter));
            IUserService r28 = jc1.k.f(IUserService.class);
            if (r28 == null) goto L56;
            com.bytedance.android.livesdk.user.f r29 = r28.user();
            if (r29 == null) goto L56;
            String r30 = r29.n();
        L57:
            r0.put("user_id", String.valueOf(r30));
            Boolean r31 = (Boolean) ((Widget) this.a).dataCenter.get("data_hide_screen", Boolean.FALSE);
            if (r31 == null) goto L60;
            boolean r33 = r31.booleanValue();
        L61:
            String r34 = "1";
            if (r33 == false) goto L64;
            Object r35 = "1";
        L65:
            r0.put("is_clean_screen", r35);
            r0.putAll(h1.a(this.a.z));
            com.bytedance.android.live.liveinteract.utils.w.b(r0);
            DiggWidget r36 = this.a;
            if (r36.isRunOnLivePreview() == false) goto L100;
            Room r110 = r36.z;
            if (r110 == null) goto L72;
            String r111 = String.valueOf(r110.id);
            if (r111 == null) goto L72;
        L73:
            r0.put("room_id", r111);
            Room r112 = r36.z;
            if (r112 == null) goto L77;
            String r113 = r112.getOwnerUserIdString();
            if (r113 == null) goto L77;
        L78:
            r0.put("anchor_id", r113);
            DataCenter r114 = ((Widget) r36).dataCenter;
            if (r114 == null) goto L100;
            Bundle r115 = (Bundle) r114.get("data_preview_outer_merge_data", new Bundle());
            if (r115 == null) goto L100;
            String r116 = r115.getString("request_id");
            if (r116 != null) goto L88;
            Room r37 = r36.z;
            if (r37 == null) goto L87;
            r116 = r37.getRequestId();
            goto L88
        L87:
            r116 = null;
        L88:
            if (r116 != null) goto L90;
            r116 = BuildConfig.FLAVOR;
        L90:
            r0.put("request_id", r116);
            String r117 = r115.getString("enter_method");
            if (r117 != null) goto L93;
            r117 = BuildConfig.FLAVOR;
        L93:
            r0.put("enter_method", r117);
            String r118 = r115.getString("enter_from_merge");
            if (r118 != null) goto L96;
            r118 = BuildConfig.FLAVOR;
        L96:
            r0.put("enter_from_merge", r118);
            String r38 = r115.getString("action_type");
            if (r38 != null) goto L99;
            r38 = BuildConfig.FLAVOR;
        L99:
            r0.put("action_type", r38);
        L77:
            r113 = BuildConfig.FLAVOR;
        L72:
            r111 = BuildConfig.FLAVOR;
        L100:
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_like", r0, new Object[]{new am2.x(), am2.u.class, Room.class, am2.n.f()});
            DiggWidget r1 = this.a;
            Room r39 = r1.z;
            if (r39 == null) goto L164;
            IRoomGameData r40 = r39.roomGameData;
            if (r40 == null) goto L164;
            IRoomGameDataChannelConfig r41 = r40.getRoomGameDataChannelConfig();
            if (r41 == null) goto L164;
            String r119 = r41.getGameId();
            if (r119 != null) goto L110;
        L113:
            boolean r120 = true;
        L114:
            if (r120 == true) goto L164;
            String r121 = r41.getFusionTagId();
            if (r121 != null) goto L118;
        L121:
            boolean r122 = true;
        L122:
            if (r122 == true) goto L164;
            HashMap r123 = new HashMap();
            String r43 = r41.getGameId();
            if (r43 != null) goto L127;
            r43 = BuildConfig.FLAVOR;
        L127:
            r123.put("game_id", r43);
            r123.put("action_type", "like");
            String r44 = am2.n.f().c();
            if (r44 != null) goto L130;
        L142:
            r34 = "0";
        L143:
            r123.put("is_ads", r34);
            Room r45 = r1.z;
            if (r45 == null) goto L149;
            IUser r46 = r45.author();
            if (r46 == null) goto L149;
            String r47 = r46.getIdString();
            if (r47 == null) goto L149;
        L150:
            r123.put("host_id", r47);
            Room r48 = r1.z;
            if (r48 == null) goto L153;
            Long r49 = Long.valueOf(r48.id);
        L154:
            r123.put("content_id", String.valueOf(r49));
            r123.put("scene", "0");
            Room r50 = r1.z;
            if (r50 == null) goto L160;
            String r51 = r50.getRequestId();
            if (r51 == null) goto L160;
            r25 = r51;
        L160:
            r123.put("req_id", r25);
            IHostGameCP r53 = jc1.k.f(IHostGameCP.class);
            if (r53 == null) goto L164;
            r53.dataChannelLinkEvent("douyin_game_content_consume_click_monitor", r123);
            goto L164
        L153:
            r49 = null;
        L149:
            r47 = "0";
            goto L150
        L130:
            if (r44.length() <= 0) goto L132;
            boolean r124 = true;
        L133:
            if (r124 == true) goto L136;
            r44 = null;
        L136:
            if (r44 == null) goto L142;
            if (r44.length() <= 0) goto L140;
            r9 = true;
        L140:
            if (r9 == false) goto L142;
        L132:
            r124 = false;
            goto L133
        L118:
            if (r121.length() == 0) goto L121;
            r122 = false;
            goto L122
        L110:
            if (r119.length() == 0) goto L113;
            r120 = false;
        L164:
            if (com.bytedance.android.livesdk.utils.c1.b(((Widget) this.a).dataCenter) == false) goto L193;
            Room r54 = this.a.z;
            if (r54 == null) goto L168;
            IUser r55 = r54.author();
        L169:
            if (r55 == null) goto L193;
            JSONObject r56 = new JSONObject();
            Room r57 = this.a.z;     // Catch: Exception -> L183
            if (r57 == null) goto L176;
            IUser r58 = r57.author();     // Catch: Exception -> L183
            if (r58 == null) goto L176;
            String r59 = r58.getIdString();     // Catch: Exception -> L183
        L177:
            r56.put("anchor_id", r59);     // Catch: Exception -> L183
            Room r60 = this.a.z;     // Catch: Exception -> L183
            if (r60 == null) goto L180;
            Long r61 = Long.valueOf(r60.getId());     // Catch: Exception -> L183
        L181:
            r56.put("room_id", String.valueOf(r61));     // Catch: Exception -> L183
        L185:
            k1.f(r56);
            ILiveDouPlusService r63 = jc1.k.n(ILiveDouPlusService.class);
            HashMap r125 = new HashMap();
            r125.put("ad_extra_data", r56.toString());
            Map r64 = com.bytedance.android.livesdk.utils.c1.e(((Widget) this.a).dataCenter);
            if (r64 != null) goto L188;
        L191:
            r63.logEvent(true, "live_ad", "like", r125);
            goto L193
        L188:
            if (r64.isEmpty() == true) goto L191;
            r125.putAll(r64);
            goto L191
        L180:
            r61 = null;
        L176:
            r59 = null;
        L183:
            e = move-exception;
            ALogger.e("DiggWidget_AdLog", e);
            goto L185
        L168:
            r55 = null;
        L193:
            if (com.bytedance.android.livesdk.utils.c1.c(((Widget) this.a).dataCenter) == false) goto L219;
            Room r65 = this.a.z;
            if (r65 == null) goto L197;
            IUser r66 = r65.author();
        L198:
            if (r66 == null) goto L219;
            JSONObject r67 = new JSONObject();
            Room r68 = this.a.z;     // Catch: Exception -> L212
            if (r68 == null) goto L205;
            IUser r69 = r68.author();     // Catch: Exception -> L212
            if (r69 == null) goto L205;
            String r70 = r69.getIdString();     // Catch: Exception -> L212
        L206:
            r67.put("anchor_id", r70);     // Catch: Exception -> L212
            Room r71 = this.a.z;     // Catch: Exception -> L212
            if (r71 == null) goto L209;
            Long r73 = Long.valueOf(r71.getId());     // Catch: Exception -> L212
        L210:
            r67.put("room_id", String.valueOf(r73));     // Catch: Exception -> L212
        L214:
            k1.f(r67);
            ILiveDouPlusService r74 = jc1.k.n(ILiveDouPlusService.class);
            HashMap r75 = new HashMap();
            r75.put("ad_extra_data", r67.toString());
            Map r76 = com.bytedance.android.livesdk.utils.c1.f(((Widget) this.a).dataCenter);
            if (r76.isEmpty() == true) goto L218;
            r75.putAll(r76);
        L218:
            r74.logEvent(true, "live_ad", "like", r75);
            goto L219
        L209:
            r73 = null;
        L205:
            r70 = null;
        L212:
            e = move-exception;
            ALogger.e("DiggWidget_AdLog", e);
            goto L214
        L197:
            r66 = null;
        L219:
            Observable r77 = Observable.just(Integer.valueOf(r2.size()));
            DiggApi r126 = (DiggApi) com.bytedance.android.live.network.c.b().e(DiggApi.class);
            long r78 = this.a.y;
            int r127 = r2.size();
            nm1.m r79 = pm1.f.l();
            if (r79 == null) goto L228;
            DiggWidget r80 = this.a;
            Room r81 = r80.z;
            RoomContext r83 = RoomContext.a.c(RoomContext.Companion, ((Widget) r80).dataCenter, 0, 2);
            if (r83 == null) goto L226;
            com.bytedance.live.datacontext.m r84 = r83.getCameraId();
            if (r84 == null) goto L226;
            Long r85 = (Long) r84.getValue();
        L227:
            long r128 = r79.k(r81, r85);
        L229:
            long r210 = r128;
            DataCenter r86 = ((Widget) this.a).dataCenter;
            if (r86 != null) goto L232;
        L234:
            String r211 = null;
        L236:
            return Observable.zip(r77, DiggApi.a.a(r126, r78, r127, r210, r211, null, 48), t0.a);
        L232:
            if (com.bytedance.android.live.core.utils.a0.c(r86) != true) goto L234;
            r211 = "preview_feed_v2";
        L226:
            r85 = null;
            goto L227
        L228:
            r128 = 0;
            goto L229
        L64:
            r35 = "0";
            goto L65
        L60:
            r33 = false;
        L56:
            r30 = null;
        L50:
            r27 = BuildConfig.FLAVOR;
            goto L51
        L36:
            if (((Boolean) r23.isAnchor().getValue()).booleanValue() == false) goto L38;
            String r87 = "anchor";
        L45:
            r0.put("user_type", r87);
            goto L46
        L38:
            Integer r88 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r88 != null) goto L42;
        L43:
            r87 = "guest";
            goto L45
        L42:
            if (r88.intValue() != 0) goto L43;
            r87 = "audience";
            goto L45
        L32:
            r20 = null;
            goto L33
        L5:
            r3 = "in_stream";
            goto L6
        }
    }

    public static final class v<T, R> implements Function {
        public final /* synthetic */ DiggWidget a;

        public v(DiggWidget r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            ExceptionUtils.handleException(((Widget) this.a).context, r4);
            return new Pair(0, new Response());
        }
    }

    public static final class w<T> implements Consumer {
        public final /* synthetic */ DiggWidget a;

        public w(DiggWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Pair r7 = (Pair) r6;
            com.bytedance.android.livesdk.interactivity.api.base.b.a r0 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
            com.bytedance.android.livesdk.interactivity.api.q r1 = com.bytedance.android.livesdk.interactivity.api.q.a;
            DiggWidget r2 = this.a;
            int r3 = DiggWidget.M1;
            RoomContext r4 = r2.getDataContext();
            DataCenter r5 = ((Widget) this.a).dataCenter;
            int r8 = ((Number) r7.getFirst()).intValue();
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "$this$onDigg");
            com.bytedance.android.livesdk.interactivity.api.h r9 = com.bytedance.android.livesdk.interactivity.api.i.a(r4, r5);
            if (r9 == null) goto L9;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.base.b> r10 = r9.getInteractivityStat();
            if (r10 == null) goto L9;
            com.bytedance.android.livesdk.interactivity.api.base.b r11 = (com.bytedance.android.livesdk.interactivity.api.base.b) r10.getValue();
            if (r11 == null) goto L9;
            r11.f += r8;
        L9:
            DataCenter r13 = ((Widget) this.a).dataCenter;
            if (r13 == null) goto L12;
            r13.put("data_self_digg_count", r7.getFirst());
        L12:
            u32.l r14 = this.a.Iq();
            if (r14 == null) goto L23;
            int r15 = ((Number) r7.getFirst()).intValue();
            com.bytedance.android.livesdk.interactivity.like.api.c r16 = (com.bytedance.android.livesdk.interactivity.like.api.c) ((BaseResponse) ((Response) r7.getSecond())).data;
            boolean r17 = false;
            if (r16 == null) goto L17;
            boolean r18 = r16.a();
        L18:
            com.bytedance.android.livesdk.interactivity.like.api.c r19 = (com.bytedance.android.livesdk.interactivity.like.api.c) ((BaseResponse) ((Response) r7.getSecond())).data;
            if (r19 == null) goto L21;
            r17 = r19.b();
        L21:
            r14.onLocalLikeResult(r15, r18, r17);
            return;
        L17:
            r18 = false;
            goto L18
        }
    }

    public static final class x implements h32.d<f32.i> {
        public final /* synthetic */ DiggWidget a;

        public x(DiggWidget r1) {
            this.a = r1;
        }

        @Override // h32.d
        public final void a(f32.f r2) {
            f32.i r3 = (f32.i) r2;
            Intrinsics.checkNotNullParameter(r3, "newConfig");
            this.a.P0 = r3;
        }
    }

    public final /* synthetic */ String Lg() {
        return com.bytedance.android.livesdk.common.h.b(this);
    }

    public final /* synthetic */ String cg() {
        return com.bytedance.android.livesdk.common.h.c(this);
    }

    public final int getLayoutId() {
        return 2131566721;
    }

    public final String getSpm() {
        return "a100.a100.a175";
    }

    public final String nc() {
        return "DiggWidget";
    }

    public final /* synthetic */ boolean nq() {
        return com.bytedance.android.livesdk.common.h.a();
    }

    public final int supportClearScene() {
        return 311;
    }

    @Override // u32.k
    public final void xo() {
        this.v1 = true;
    }

    static {
        s1.f(85.0f);
        M1 = s1.f(32.0f);
        P1 = s1.f(28.0f);
        s1.f(32.0f);
    }

    public DiggWidget() {
        this.a = new s82.a();
        this.b = Boolean.FALSE;
        this.h = new d(this);
        this.i = new c(this);
        this.n = new ArrayList();
        this.o = new SparseArray();
        this.p = new ArrayList();
        this.q = new SparseArray();
        this.r = new ArrayList();
        this.s = Collections.newSetFromMap(new ConcurrentHashMap());
        this.t = -10086;
        this.E = PublishSubject.create();
        this.L = u32.c.b;
        this.N = true;
        this.O = LazyKt.lazy(DiggWidget$optDiggGameRoom$2.INSTANCE);
        this.S = new j(new d0(this));
        this.T = new i(new c0(this));
        this.W = LazyKt.lazy(DiggWidget$shouldEnableHostAbiDegrade$2.INSTANCE);
        PublishSubject r2 = PublishSubject.create();
        this.Y = r2;
        this.Z = r2.observeOn(AndroidSchedulers.mainThread());
        this.p0 = new e(this);
        this.H0 = new HashMap();
        this.L0 = (ts1.a) l20.a.getValue();
        this.P0 = new f32.i(0, false, false, false, false, 63);
        this.V0 = new f32.d(false, false, 0, false, 15);
        this.b1 = new x(this);
        this.g1 = new h(this);
        this.h1 = true;
        this.k1 = new g(this);
        this.p1 = Math.max(1, DiggABHelper.a().c());
        this.x1 = ((long) DiggABHelper.a().a()) * 1000;
        this.y1 = new f(this);
        this.G1 = new s(this);
    }

    @Override // u32.k
    public final boolean Eg() {
        if (this.x == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final com.bytedance.android.livesdk.interactivity.like.controller.a Eq() {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        u32.a r3 = null;
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.n<u32.a> r4 = r2.getAvatarAnimationController();
        if (r4 == null) goto L7;
        u32.a r5 = (u32.a) r4.getValue();
    L9:
        if ((r5 instanceof com.bytedance.android.livesdk.interactivity.like.controller.a) == false) goto L13;
        r3 = r5;
    L13:
        return (com.bytedance.android.livesdk.interactivity.like.controller.a) r3;
    L7:
        r5 = null;
        goto L9
    }

    public final boolean Fq() {
        ILinkServiceExternal r0 = jc1.k.f(ILinkServiceExternal.class);
        if (r0 == null) goto L8;
        lc0.b r1 = r0.getMultiAnchorServiceExternal();
        if (r1 == null) goto L8;
        if (r1.blockDigg() != true) goto L8;
    L13:
        if (this.B == true) goto L17;
    L15:
        return false;
    L17:
        return true;
    L8:
        IMediaLinkOutService r2 = (IMediaLinkOutService) jc1.k.f(IMediaLinkOutService.class);
        if (r2 == null) goto L15;
        if (r2.blockDigg() != true) goto L15;
        goto L15
    }

    public final DiggCountFlipperLayoutControllerImpl Gq() {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        u32.d r3 = null;
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.n<u32.d> r4 = r2.getDiggCountFlipperLayoutController();
        if (r4 == null) goto L7;
        u32.d r5 = (u32.d) r4.getValue();
    L9:
        if ((r5 instanceof DiggCountFlipperLayoutControllerImpl) == false) goto L13;
        r3 = r5;
    L13:
        return (DiggCountFlipperLayoutControllerImpl) r3;
    L7:
        r5 = null;
        goto L9
    }

    public final u32.l Iq() {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.j<u32.l> r3 = r2.getDoubleLikeManager();
        if (r3 == null) goto L7;
        return (u32.l) r3.getValue();
    L7:
        return null;
    }

    public final com.bytedance.android.livesdk.interactivity.like.controller.c Jq() {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        u32.h r3 = null;
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.n<u32.h> r4 = r2.getHeartAnimationController();
        if (r4 == null) goto L7;
        u32.h r5 = (u32.h) r4.getValue();
    L9:
        if ((r5 instanceof com.bytedance.android.livesdk.interactivity.like.controller.c) == false) goto L13;
        r3 = r5;
    L13:
        return (com.bytedance.android.livesdk.interactivity.like.controller.c) r3;
    L7:
        r5 = null;
        goto L9
    }

    public final boolean Lq() {
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L7;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.G0.getValue()).booleanValue() == true) goto L7;
    L11:
        return false;
    L7:
        if (isScreenPortrait() == true) goto L11;
        if (this.B == true) goto L11;
        return true;
    }

    public final com.bytedance.android.livesdk.interactivity.like.controller.e Mq() {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        u32.o r3 = null;
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.n<u32.o> r4 = r2.getThankAnimationController();
        if (r4 == null) goto L7;
        u32.o r5 = (u32.o) r4.getValue();
    L9:
        if ((r5 instanceof com.bytedance.android.livesdk.interactivity.like.controller.e) == false) goto L13;
        r3 = r5;
    L13:
        return (com.bytedance.android.livesdk.interactivity.like.controller.e) r3;
    L7:
        r5 = null;
        goto L9
    }

    public final void Pq() {
        if (jc1.k.n(IUserService.class).user().isLogin() == false) goto L19;
        Room r0 = this.z;
        if (r0 == null) goto L11;
        RoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L11;
        if (r1.getEnableDigg() == false) goto L19;
    L11:
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L15;
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.G0.getValue()).booleanValue() == true) goto L15;
    L18:
        boolean r2 = true;
    L20:
        Boolean r3 = this.I;
        if (r3 == null) goto L26;
        r3.booleanValue();
        if ((true ^ Intrinsics.areEqual(Boolean.valueOf(r2), this.I)) == false) goto L28;
        this.I = Boolean.valueOf(r2);
        int r4 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
        com.bytedance.android.livesdk.interactivity.like.utils.b.a("Self Digg Status Changed", this.B, isScreenPortrait(), this.G, this.z);
        return;
    L28:
        return;
    L26:
        this.I = Boolean.valueOf(r2);
        int r5 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
        com.bytedance.android.livesdk.interactivity.like.utils.b.a("First Set Self Digg Status", this.B, isScreenPortrait(), this.G, this.z);
        return;
    L15:
        if (isScreenPortrait() == true) goto L18;
        if (this.B == true) goto L18;
    L19:
        r2 = false;
        goto L20
    }

    public final Bitmap Qq() {
        if ((!this.s.isEmpty()) == true) goto L5;
    L7:
        Resources r2 = null;
        if (((Widget) this).context == null) goto L29;
        Room r0 = this.z;
        if (r0 != null) goto L13;
    L20:
        int r1 = ((Number) CollectionsKt.random(this.n, Random.Default)).intValue();
        Bitmap r3 = this.o.get(r1);
        if (r3 != null) goto L27;
        Context r4 = ((Widget) this).context;
        if (r4 == null) goto L25;
        r2 = r4.getResources();
    L25:
        BitmapFactory.Options r5 = new BitmapFactory.Options();
        r5.inPreferredConfig = Bitmap.Config.ARGB_4444;
        Unit r6 = Unit.INSTANCE;
        r3 = BitmapFactory.decodeResource(r2, r1, r5);
        this.o.put(r1, r3);
    L27:
        return r3;
    L13:
        if (r0.isMediaRoom() != true) goto L20;
        int r7 = ((Number) CollectionsKt.random(this.p, Random.Default)).intValue();
        r3 = this.q.get(r7);
        if (r3 != null) goto L27;
        Context r8 = ((Widget) this).context;
        if (r8 == null) goto L19;
        r2 = r8.getResources();
    L19:
        BitmapFactory.Options r9 = new BitmapFactory.Options();
        r9.inPreferredConfig = Bitmap.Config.ARGB_4444;
        Unit r10 = Unit.INSTANCE;
        r3 = BitmapFactory.decodeResource(r2, r7, r9);
        this.q.put(r7, r3);
        goto L27
    L29:
        return null;
    L5:
        if (this.v == false) goto L7;
        return (Bitmap) CollectionsKt.random(this.s, Random.Default);
    }

    public final void Rq() {
        if (this.J == true) goto L23;
        int r0 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
        Room r1 = this.z;
        boolean r2 = isScreenPortrait();
        boolean r3 = this.B;
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L7;
        int r4 = 1;
    L21:
        InteractivityMonitor.c(InteractivityMonitor.Event.DiggDisable, r1, Integer.valueOf(r4), null, 24);
        this.J = true;
        return;
    L7:
        if (r1 == null) goto L14;
        RoomAuthStatus r5 = r1.getRoomAuthStatus();
        if (r5 == null) goto L14;
        if (r5.getEnableDigg() == true) goto L14;
        r4 = 2;
    L14:
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L16;
    L17:
        if (r2 == true) goto L20;
        if (r3 == true) goto L20;
        r4 = 4;
    L20:
        r4 = 0;
        goto L21
    L16:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.G0.getValue()).booleanValue() == false) goto L20;
    }

    public final void Tq() {
        this.F = ((ObservableSubscribeProxy) ((du2.a) this.E.as(new du2.b())).a(2, TimeUnit.SECONDS).filter(t.a).observeOn(Schedulers.io()).flatMap(new u(this)).observeOn(AndroidSchedulers.mainThread()).onErrorReturn(new v(this)).as(autoDispose())).subscribe(new w(this));
    }

    public final void Wq() {
        Iterator r0 = ((HashMap) this.H0).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        long r2 = ((Number) r1).longValue();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r4 = y3.m(((Widget) this).dataCenter);
        SparseArray r5 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0.e;
        if (r4.n(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0.a.a((int) r2, this.B, false)) == false) goto L4;
    L9:
        Long r3 = (Long) r1;
        if (r3 == null) goto L12;
        long r6 = r3.longValue();
    L13:
        Zq(r6);
        return;
    L12:
        r6 = -10086;
        goto L13
    L8:
        r1 = null;
        goto L9
    }

    public final boolean canControlByClearScreenService() {
        return !((Boolean) uk.a.getValue()).booleanValue();
    }

    @Override // u32.k
    public final boolean needPerformHapticFeedback() {
        if (this.h.b.B == false) goto L6;
        return false;
    L6:
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.Y2.getValue()).booleanValue();
    }

    public final void onClear() {
        this.h.getClass();
        this.i.getClass();
        this.L.clear();
        if (((Boolean) on.a.getValue()).booleanValue() == true) goto L10;
        int r0 = this.o.size();
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L7;
        this.o.valueAt(r2).recycle();
        r2 = r2 + 1;
        goto L5
    L7:
        int r3 = this.q.size();
    L8:
        if (r1 >= r3) goto L14;
        this.q.valueAt(r1).recycle();
        r1 = r1 + 1;
        goto L8
    L14:
        return;
    L10:
        this.o.clear();
        this.q.clear();
    }

    public final void onUnload() {
        ALogger.i("preview_digg", "DiggWidget, onUnLoad");
        CompositeDisposable r0 = this.m;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.v = false;
        this.J = false;
        this.k0 = false;
        this.H = null;
        this.I = null;
        this.b = Boolean.FALSE;
        this.U = false;
        KeyEvent.Callback r2 = this.h.b.c;
        if ((r2 instanceof com.bytedance.android.livesdk.interactivity.like.view.z) == true) goto L8;
        r2 = null;
    L8:
        com.bytedance.android.livesdk.interactivity.like.view.z r3 = (com.bytedance.android.livesdk.interactivity.like.view.z) r2;
        if (r3 == null) goto L11;
        r3.clear();
    L11:
        c r4 = this.i;
        r4.c(false, 0);
        BottomSelfDiggOptimizeView r5 = r4.g.d;
        if ((r5 instanceof com.bytedance.android.livesdk.interactivity.like.view.z) == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L16;
        r5.clear();
    L16:
        com.bytedance.android.livesdk.interactivity.like.controller.d r6 = this.j;
        if (r6 == null) goto L19;
        r6.e();
    L19:
        Boolean r7 = com.bytedance.android.livesdk.interactivity.like.utils.k.a;
        RoomContext r8 = getDataContext();
        if (r8 == null) goto L26;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L26;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L26;
        Long r11 = Long.valueOf(r10.getRoomId());
    L27:
        RoomContext r13 = getDataContext();
        if (r13 == null) goto L34;
        com.bytedance.live.datacontext.m r14 = r13.getUser();
        if (r14 == null) goto L34;
        User r15 = (User) r14.getValue();
        if (r15 == null) goto L34;
        String r16 = r15.getIdStr();
    L36:
        if (r11 == null) goto L39;
        String r17 = String.valueOf(r11.longValue());
        if (r17 == null) goto L39;
    L40:
        if (r16 != null) goto L43;
        r16 = "0";
    L43:
        if (com.bytedance.android.livesdk.interactivity.like.utils.k.a.booleanValue() == false) goto L52;
        LinkedHashMap r18 = new LinkedHashMap();
        if (com.bytedance.android.livesdk.interactivity.like.utils.k.c <= 0) goto L49;
        r18.put("other_like_time_ms", String.valueOf(com.bytedance.android.livesdk.interactivity.like.utils.k.b));
        r18.put("other_like_cnt", String.valueOf(com.bytedance.android.livesdk.interactivity.like.utils.k.c));
    L49:
        if (com.bytedance.android.livesdk.interactivity.like.utils.k.e <= 0) goto L51;
        r18.put("others_like_anim_create_time", String.valueOf(com.bytedance.android.livesdk.interactivity.like.utils.k.d));
        r18.put("others_like_anim_create_cnt", String.valueOf(com.bytedance.android.livesdk.interactivity.like.utils.k.e));
    L51:
        r18.put("room_id", r17);
        r18.put("user_id", r16);
        com.bytedance.android.livesdk.log.u.l().sendLog("ttlive_like_performance", r18, new Object[0]);
    L52:
        com.bytedance.android.livesdk.interactivity.like.utils.k.c = 0;
        com.bytedance.android.livesdk.interactivity.like.utils.k.b = 0;
        com.bytedance.android.livesdk.interactivity.like.utils.k.e = 0;
        com.bytedance.android.livesdk.interactivity.like.utils.k.d = 0;
        DiggContext.a r19 = DiggContext.Companion;
        DataCenter r20 = ((Widget) this).dataCenter;
        r19.getClass();
        DiggContext r21 = DiggContext.a.a(r20);
        if (r21 == null) goto L55;
        r21.getDiggWidget().setValue(null);
    L55:
        runOnLivePreview(AnonymousClass2.INSTANCE);
        this.H1 = 0;
        this.V = 0;
        vlc.d r23 = this.D;
        if (r23 == null) goto L58;
        r23.removeMessageListener(this);
    L58:
        com.bytedance.android.live.core.utils.i0.c().removeCallbacks(this.p0);
        com.bytedance.android.live.core.utils.i0.k(c50.b.b(((Widget) this).dataCenter), this.y1);
        this.v1 = false;
        Disposable r24 = this.F;
        if (r24 == null) goto L61;
        r24.dispose();
    L61:
        Disposable r25 = this.C;
        if (r25 == null) goto L64;
        r25.dispose();
    L64:
        this.C = null;
        this.L.clear();
        this.t = -10086;
        ((HashMap) this.H0).clear();
        this.u = null;
        IPerformanceStrategyManager r26 = jc1.k.f(IPerformanceStrategyManager.class);
        if (r26 == null) goto L67;
        r26.unregisterPerformanceStrategyTask(220);
    L67:
        h32.a r27 = this.M;
        if (r27 == null) goto L70;
        r27.e().a(this.b1);
        r27.b().a(this.g1);
    L70:
        this.M = null;
        Disposable r28 = this.Q;
        if (r28 != null) goto L73;
    L77:
        this.Q = null;
        this.P = null;
        this.R = false;
        int r1 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r29 = com.bytedance.android.live.room.api.panel.d.b(((Widget) this).dataCenter, this.y);
        if (r29 == null) goto L81;
        r29.unregisterPanelListener(this.G1);
        return;
    L81:
        return;
    L73:
        if (r28.isDisposed() == true) goto L77;
        Disposable r30 = this.Q;
        if (r30 == null) goto L77;
        r30.dispose();
    L39:
        r17 = "0";
    L34:
        r16 = null;
    L26:
        r11 = null;
        goto L27
    }

    public final long Kq() {
        RoomContext r0 = getDataContext();
        if (r0 == null) goto L8;
        if (r0.isVSRoom() != true) goto L8;
        return ((Number) InteractivityOpt.c(lj1.a)).longValue();
    L8:
        if (isRunOnLivePreview() == false) goto L10;
        Long r1 = (Long) InteractivityOpt.c(nj0.a);
    L12:
        return r1.longValue();
    L10:
        r1 = (Long) InteractivityOpt.c(f2.a);
        goto L12
    }

    public final void onStart() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
        this.h.getClass();
        com.bytedance.android.livesdk.interactivity.like.controller.d r0 = this.i.g.j;
        if (r0 == null) goto L6;
        r0.d = true;
        ALogger.d("PauseAnim", "OthersDiggAnimationControllerImpl resume");
        return;
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
        this.h.getClass();
        com.bytedance.android.livesdk.interactivity.like.controller.d r0 = this.i.g.j;
        if (r0 == null) goto L6;
        r0.d = false;
        r0.e();
        ALogger.d("PauseAnim", "OthersDiggAnimationControllerImpl pause");
        return;
    }

    @Override // u32.k
    public final Observable<Long> Lo() {
        return this.Z;
    }

    public final View getContentView() {
        return ((Widget) this).contentView;
    }

    @Override // u32.k
    public final long getDiggCount() {
        return this.X;
    }

    public final Boolean uk() {
        return this.b;
    }

    public static final void Aq(final DiggWidget r13) {
        r13.h.getClass();
        c r0 = r13.i;
        r0.getClass();
        ((ObservableSubscribeProxy) jc1.k.n(IUserService.class).user().p().observeOn(Schedulers.io()).flatMap(com.bytedance.android.livesdk.interactivity.like.q.a).map(com.bytedance.android.livesdk.interactivity.like.r.a).observeOn(AndroidSchedulers.mainThread()).as(r0.g.autoDispose())).subscribe(new com.bytedance.android.livesdk.interactivity.like.s(r0), com.bytedance.android.livesdk.interactivity.like.t.a);
        r13.Tq();
        PublishSubject<Unit> r1 = PublishSubject.create();
        r13.K = r1;
        if (r1 == null) goto L5;
        r13.Bq(r1.buffer(r1.debounce(300, TimeUnit.MILLISECONDS)).filter(l0.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new j0(r13)));
    L5:
        o0 r2 = new o0(r13);
        u32.l r3 = r13.Iq();
        if (r3 == null) goto L8;
        r3.addListener(r2, true);
    L8:
        r13.Bq(Disposables.fromAction(new m0(r13, r2)));
        State r4 = null;
        if (((Widget) r13).dataCenter == null) goto L11;
        UserInfoDiggBridge r5 = new UserInfoDiggBridge(((Widget) r13).dataCenter);
    L12:
        r13.l = r5;
        if (r5 == null) goto L17;
        u32.l r6 = r5.a();
        if (r6 == null) goto L17;
        r6.addListener(r5, true);
    L17:
        r13.S.d();
        r13.T.d();
        r13.Bq(Disposables.fromAction(new n0(r13)));
        com.bytedance.android.livesdk.interactivity.api.h r7 = com.bytedance.android.livesdk.interactivity.api.i.a(r13.getDataContext(), ((Widget) r13).dataCenter);
        if (r7 == null) goto L24;
        List<py.k> r8 = ((com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r) r7.getLikeIconInfo().getValue()).iconList;
        if (r8 == null) goto L22;
        r13.Nq(r8);
    L22:
        r13.Bq(r7.getLikeIconInfo().a().subscribe(new k0(r13)));
        r13.ar((com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r) r7.getLikeIconInfo().getValue());
    L24:
        if (PadConfigUtils.c() == false) goto L27;
        UIUtils.updateLayoutMargin(r13.d, -3, -3, s1.f(8.0f), s1.f(42.0f));
        s82.a r9 = r13.a;
        s1.f(8.0f);
        r9.getClass();
        s82.a r10 = r13.a;
        s1.f(42.0f);
        r10.getClass();
        r13.runOnLivePreview(new DiggWidget$prepareViewOnLoad$5(r13));
    L30:
        int r11 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
        com.bytedance.android.livesdk.interactivity.like.utils.b.a("prepareViewOnLoad", r13.B, r13.isScreenPortrait(), r13.G, r13.z);
        com.bytedance.android.live.core.utils.i0.c().removeCallbacks(r13.p0);
        DataCenter r14 = ((Widget) r13).dataCenter;
        if (r14 == null) goto L33;
        Boolean r15 = (Boolean) r14.get("pre_entry_like_event", Boolean.FALSE);
    L35:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L154;
        com.bytedance.android.livesdk.interactivity.like.controller.d r16 = r13.j;
        if (r16 == null) goto L39;
        r16.d(20, r13.V0.c);
    L39:
        r13.Pq();
        RoomContext r17 = r13.getDataContext();
        if (r17 != null) goto L42;
    L44:
        Long r18 = (Long) InteractivityOpt.c(f2.a);
    L45:
        RoomContext r19 = r13.getDataContext();
        if (r19 == null) goto L57;
        if (r19.isVSRoom() != true) goto L57;
        IVSPlayerService r20 = jc1.k.f(IVSPlayerService.class);
        if (r20 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r21 = r20.provideVSPlayerViewControlService(((Widget) r13).dataCenter);
        if (r21 == null) goto L57;
        if (r21.getLockStatus() != true) goto L57;
    L149:
        DataCenter r110 = ((Widget) r13).dataCenter;
        if (r110 == null) goto L155;
        r110.put("pre_entry_like_event", Boolean.FALSE);
        return;
    L155:
        return;
    L57:
        if (r13.L.c() == true) goto L59;
    L148:
        r13.Fq();
        r13.Rq();
        goto L149
    L59:
        if (r13.Lq() == true) goto L148;
        if (r13.Fq() == true) goto L148;
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L68;
        r13.Rq();
        PublishSubject<Unit> r23 = r13.K;
        if (r23 == null) goto L149;
        r23.onNext(Unit.INSTANCE);
        goto L149
    L68:
        Disposable r24 = r13.F;
        if (r24 != null) goto L71;
    L72:
        r13.Tq();
    L73:
        long r25 = SystemClock.elapsedRealtime();
        r13.w = r25;
    L145:
        th = move-exception;
        r13.w = r25;
        throw th;
    L75:
        if ((r25 - r25) > r18.longValue()) goto L143;
        com.bytedance.android.livesdk.interactivity.like.controller.d r26 = r13.j;     // Catch: Throwable -> L145
        if (r26 == null) goto L79;
        r26.d = false;     // Catch: Throwable -> L145
        r26.e();     // Catch: Throwable -> L145
        ALogger.d("PauseAnim", "OthersDiggAnimationControllerImpl pause");     // Catch: Throwable -> L145
    L79:
        Disposable r27 = r13.C;     // Catch: Throwable -> L145
        if (r27 == null) goto L82;
        r27.dispose();     // Catch: Throwable -> L145
    L82:
        boolean r28 = InteractivityOpt.a;     // Catch: Throwable -> L145
        if (r28 == true) goto L85;
        Disposable r29 = ((ObservableSubscribeProxy) Observable.timer(r18.longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).as(r13.autoDispose())).subscribe(new g0(r13));     // Catch: Throwable -> L145
    L86:
        r13.C = r29;     // Catch: Throwable -> L145
        r13.x++;     // Catch: Throwable -> L145
        if (r13.B == false) goto L130;
        com.bytedance.android.livesdk.interactivity.like.controller.e r30 = r13.Mq();     // Catch: Throwable -> L145
        if (r30 == null) goto L91;
        r30.getClass();     // Catch: Throwable -> L145
    L91:
        c2 r31 = c2.a;     // Catch: Throwable -> L145
        int r33 = ((Number) InteractivityOpt.c(r31)).intValue();     // Catch: Throwable -> L145
        int r34 = r13.x;     // Catch: Throwable -> L145
        if (r34 < 0) goto L101;
        if (r33 <= r34) goto L101;
        com.bytedance.android.livesdk.interactivity.like.controller.c r35 = r13.Jq();     // Catch: Throwable -> L145
        if (r35 == null) goto L99;
        r4 = r35.a;     // Catch: Throwable -> L145
    L99:
        if (r4 != State.CLEAR) goto L130;
        r13.Eq();     // Catch: Throwable -> L145
    L101:
        int r36 = ((Number) InteractivityOpt.c(r31)).intValue();     // Catch: Throwable -> L145
        int r37 = ((Number) InteractivityOpt.c(d2.a)).intValue();     // Catch: Throwable -> L145
        int r38 = r13.x;     // Catch: Throwable -> L145
        if (r36 > r38) goto L106;
        if (r37 <= r38) goto L106;
    L119:
        com.bytedance.android.livesdk.interactivity.like.controller.c r39 = r13.Jq();     // Catch: Throwable -> L145
        if (r39 == null) goto L122;
        State r40 = r39.a;     // Catch: Throwable -> L145
    L124:
        if (r40 != State.CLEAR) goto L130;
        if (r13.Eq() == null) goto L130;
        int r41 = com.bytedance.android.livesdk.interactivity.like.controller.a.b;     // Catch: Throwable -> L145
        Intrinsics.throwUninitializedPropertyAccessException("avatarScaleView");     // Catch: Throwable -> L145
        throw null;     // Catch: Throwable -> L145
    L122:
        r40 = null;
    L106:
        if (r13.A == false) goto L119;
        Room r43 = r13.z;     // Catch: Throwable -> L145
        if (r43 == null) goto L113;
        if (r43.isMediaRoom() == true) goto L119;
    L113:
        if (r13.Eq() != null) goto L117;
        com.bytedance.android.livesdk.interactivity.like.controller.c r44 = r13.Jq();     // Catch: Throwable -> L145
        if (r44 == null) goto L130;
        r44.d(r13.x);     // Catch: Throwable -> L145
        goto L130
    L117:
        Intrinsics.throwUninitializedPropertyAccessException("avatarScaleView");     // Catch: Throwable -> L145
        throw null;     // Catch: Throwable -> L145
    L130:
        r13.E.onNext(1);     // Catch: Throwable -> L145
        u32.l r45 = r13.Iq();     // Catch: Throwable -> L145
        if (r45 == null) goto L133;
        r45.onLocalLike(1);     // Catch: Throwable -> L145
    L133:
        DiggContext.a r46 = DiggContext.Companion;     // Catch: Throwable -> L145
        DataCenter r47 = ((Widget) r13).dataCenter;     // Catch: Throwable -> L145
        r46.getClass();     // Catch: Throwable -> L145
        DiggContext r48 = DiggContext.a.a(r47);     // Catch: Throwable -> L145
        if (r48 == null) goto L138;
        com.bytedance.live.datacontext.m<Long> r49 = r48.getDiggTime();     // Catch: Throwable -> L145
        if (r49 == null) goto L138;
        r49.setValue(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L145
    L138:
        if (r28 == false) goto L140;
        Schedulers.io().scheduleDirect(new i0(r13));     // Catch: Throwable -> L145
    L144:
        r13.w = r25;
        goto L149
    L140:
        View r50 = r13.c;     // Catch: Throwable -> L145
        if (r50 == null) goto L144;
        r50.performHapticFeedback(1, 2);     // Catch: Throwable -> L145
        goto L144
    L85:
        r29 = Observable.timer(r18.longValue(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new h0(r13));     // Catch: Throwable -> L145
        goto L86
    L143:
        r13.x = 0;     // Catch: Throwable -> L145
        goto L144
    L71:
        if (r24.isDisposed() == false) goto L73;
    L42:
        if (r17.isVSRoom() != true) goto L44;
        r18 = (Long) InteractivityOpt.c(lj1.a);
        goto L45
    L154:
        return;
    L33:
        r15 = null;
        goto L35
    L27:
        if (r13.B == true) goto L29;
        r13.isScreenPortrait();
    L29:
        int r51 = P1;
        int r53 = com.bytedance.android.livesdk.interactivity.like.utils.j.k;
        UIUtils.updateLayoutMargin(r13.d, -3, -3, -3, r51);
        r13.a.getClass();
        r13.runOnLivePreview(new DiggWidget$updateFlowAreaOnLoad$1(r13));
        UIUtils.updateLayoutMargin(r13.e, -3, -3, -3, r53);
        goto L30
    L11:
        r5 = null;
        goto L12
    }

    public static final void yq(DiggWidget r3) {
        Room r0 = r3.z;
        if (r0 == null) goto L5;
        long r1 = r0.getDiggCount();
    L6:
        r3.X = r1;
        if (((Boolean) xm.a.getValue()).booleanValue() == true) goto L11;
        DiggCountFlipperLayoutControllerImpl r2 = r3.Gq();
        if (r2 == null) goto L11;
        r2.g(r1);
    L11:
        r3.Y.onNext(Long.valueOf(r1));
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public static final void zq(DiggWidget r3) {
        Disposable r0 = r3.C;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        r3.C = null;
        if (r3.x < ((Integer) d2.a.getValue()).intValue()) goto L8;
        com.bytedance.android.livesdk.interactivity.like.controller.c r1 = r3.Jq();
        if (r1 == null) goto L21;
        State r2 = r1.a;
        if (r2 == State.ENDING) goto L21;
        if (r2 == State.CLEAR) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("bubbleLottieView");
        throw null;
    L21:
        r3.x = 0;
        if (r3.U == true) goto L27;
        com.bytedance.android.livesdk.interactivity.like.controller.d r4 = r3.j;
        if (r4 == null) goto L28;
        r4.d = true;
        ALogger.d("PauseAnim", "OthersDiggAnimationControllerImpl resume");
        return;
    L28:
        return;
    L27:
        return;
    L8:
        if (r3.Eq() == null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("avatarScaleView");
        throw null;
    }

    @Override // u32.k
    public final void A9(int r4) {
        if (r4 != 0) goto L5;
        this.T.e(cc2.i.a.c, false);
        this.G = false;
        Sq(true);
        return;
    L5:
        if (r4 != 4) goto L7;
    L9:
        this.T.e(cc2.i.a.c, true);
        this.G = true;
        Sq(false);
        return;
    L7:
        if (r4 == 8) goto L9;
    }

    public final void Bq(Disposable r2) {
        CompositeDisposable r0 = this.m;
        if (r0 == null) goto L6;
        r0.add(r2);
        return;
    }

    @Override // u32.k
    public final boolean D8(MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        return u32.k.a.a(this, r11, Kq(), null, false, false, false, 60);
    }

    public final void Nq(List<? extends py.k> r6) {
        List r7 = CollectionsKt.filterNotNull(r6);
        Disposable r0 = this.u;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        List r8 = r7;
        List r1 = CollectionsKt.plus(r8, this.r);
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        String r5 = ((py.k) r4).getUri();
        Object r9 = r2.get(r5);
        if (r9 != null) goto L11;
        r9 = new ArrayList();
        r2.put(r5, r9);
    L11:
        ((List) r9).add(r4);
        goto L7
    L12:
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r11 = r2.entrySet().iterator();
    L13:
        boolean r13 = true;
        if (r11.hasNext() == false) goto L22;
        Map.Entry r14 = (Map.Entry) r11.next();
        if (((List) r14.getValue()).size() == 1) goto L19;
        r13 = false;
    L19:
        if (r13 == false) goto L13;
        r10.put(r14.getKey(), r14.getValue());
        goto L13
    L22:
        if ((!r10.isEmpty()) == false) goto L28;
        this.s.clear();
        ArrayList<py.k> r15 = this.r;
        r15.clear();
        r15.addAll(r8);
        ArrayList<py.k> r16 = this.r;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<py.k> r18 = r16.iterator();
    L25:
        if (r18.hasNext() == false) goto L27;
        r17.add(com.bytedance.android.livesdk.chatroom.utils.a1.k(r18.next()));
        goto L25
    L27:
        Observable r19 = Observable.merge(r17);
    L29:
        if (r19 != null) goto L31;
        this.s.clear();
        this.r.clear();
        r19 = Observable.empty();
    L31:
        this.u = ((ObservableSubscribeProxy) r19.filter(k.a).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new l(this), new m(this), new n(this));
        return;
    L28:
        r19 = Observable.empty();
        goto L29
    }

    public final void Sq(boolean r3) {
        if (((Boolean) this.O.getValue()).booleanValue() == false) goto L16;
        Room r0 = this.z;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isGameRoom() == 1) goto L9;
        return;
    L9:
        if (PadConfigUtils.c() == true) goto L19;
        Room r1 = this.z;
        if (r1 != null) goto L13;
        return;
    L13:
        if (r1.isMergeVSRoom() == true) goto L21;
        this.N = r3;
        return;
    L21:
        return;
    L19:
        return;
    }

    public final void Yq(ArrayList r6) {
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r0 = r7.next();
        if (((HashMap) this.H0).containsKey(Long.valueOf(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) r0).a)) == false) goto L4;
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s) r0;
        if (r1 == null) goto L12;
        long r2 = r1.a;
    L13:
        Zq(r2);
        return;
    L12:
        r2 = -10086;
        goto L13
    L8:
        r0 = null;
        goto L9
    }

    public final boolean Zq(long r4) {
        if (this.t == r4) goto L8;
        Map<Long, List<py.k>> r0 = this.H0;
        HashMap r1 = (HashMap) r0;
        List<? extends py.k> r2 = (List) r1.get(Long.valueOf(r4));
        if (r2 == null) goto L10;
        Nq(r2);
        this.t = r4;
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public final void ar(com.bytedance.android.livesdk.interactivity.api.publicscreen.api.r r5) {
        if (DiggABHelper.a == true) goto L5;
        return;
    L5:
        ((HashMap) this.H0).clear();
        List<py.k> r0 = r5.iconList;
        if (r0 == null) goto L8;
        ((HashMap) this.H0).put(-10086L, r0);
    L8:
        Map<Long, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.s> r6 = r5.a();
        if (r6 == null) goto L30;
        Iterator<Map.Entry<Long, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.s>> r7 = r6.entrySet().iterator();
    L12:
        if (r7.hasNext() == false) goto L19;
        Map.Entry<Long, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.s> r1 = r7.next();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.s r2 = r1.getValue();
        if (r2 == null) goto L12;
        List<py.k> r3 = r2.a();
        if (r3 == null) goto L12;
        Map<Long, List<py.k>> r4 = this.H0;
        HashMap r8 = (HashMap) r4;
        r8.put(r1.getKey(), r3);
        goto L12
    L19:
        if (isScreenPortrait() == false) goto L21;
        Wq();
        return;
    L21:
        Yq((ArrayList) ((Widget) this).dataCenter.get("landscape_toolbar_button_change", new ArrayList()));
        return;
    }

    public final void br(long r4) {
        if (r4 <= DiggABHelper.e) goto L5;
        boolean r5 = true;
    L6:
        BottomSelfDiggOptimizeView r6 = this.d;
        if (r6 == null) goto L14;
        r6.f = r5;
        if (r5 == false) goto L11;
        int r7 = 39;
    L12:
        r6.g = r7;
        return;
    L11:
        r7 = 75;
        goto L12
    L14:
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5.getKey()) == true) goto L93;
        String r0 = r5.getKey();
        switch(r0.hashCode()) {
            case -1989436139: goto L59;
            case -1506136963: goto L56;
            case -1143525893: goto L46;
            case -1122045708: goto L34;
            case -887333561: goto L26;
            case -435307162: goto L14;
            case 1995521258: goto L11;
            default: goto L94;
        };
    L94:
        return;
    L11:
        if (r0.equals("cmd_specific_behavior_loaded") == true) goto L16;
        return;
    L16:
        if (DiggABHelper.a == true) goto L18;
        return;
    L18:
        if (isScreenLandscape() == true) goto L95;
        ToolbarBehaviorData r6 = (ToolbarBehaviorData) r5.getData(null);
        if (r6 != null) goto L23;
        return;
    L23:
        if (((HashMap) this.H0).containsKey(Long.valueOf(r6.getId())) == false) goto L74;
        Wq();
        return;
    L74:
        return;
    L95:
        return;
    L14:
        if (r0.equals("cmd_specific_behavior_un_loaded") == true) goto L16;
        return;
    L26:
        if (r0.equals("match_is_public_interact_tab") == true) goto L28;
        return;
    L28:
        if (((Boolean) r5.getData()) == null) goto L77;
        Boolean r7 = (Boolean) r5.getData();
        if (r7 != null) goto L32;
        r7 = Boolean.FALSE;
    L32:
        this.S.e(cc2.g.c.c, !r7.booleanValue());
        return;
    L77:
        return;
    L34:
        if (r0.equals("data_hide_screen") == false) goto L79;
        Boolean r8 = (Boolean) r5.getData();
        if (r8 != null) goto L39;
        r8 = Boolean.FALSE;
    L39:
        if (r8.booleanValue() == true) goto L41;
        return;
    L41:
        if (((Boolean) uk.a.getValue()).booleanValue() == false) goto L81;
        MeasureOptFrameLayout r9 = this.d;
        if (r9 == null) goto L82;
        UtilityKotlinExtentionsKt.t(r9);
        return;
    L82:
        return;
    L81:
        return;
    L79:
        return;
    L46:
        if (r0.equals("data_is_portrait") == true) goto L48;
        return;
    L48:
        if (((Boolean) r5.getData(Boolean.TRUE)) == null) goto L85;
        Boolean r10 = (Boolean) r5.getData();
        if (r10 != null) goto L53;
        r10 = Boolean.valueOf(isScreenPortrait());
    L53:
        if (r10.booleanValue() == false) goto L86;
        UIUtils.updateLayoutMargin(((Widget) this).contentView, 0, -3, 0, -3);
        UIUtils.updateLayoutMargin(this.d, -3, -3, 0, -3);
        UIUtils.updateLayoutMargin(this.e, -3, -3, 0, -3);
        return;
    L86:
        return;
    L85:
        return;
    L56:
        if (r0.equals("cmd_all_widget_loaded") == false) goto L88;
        com.bytedance.android.live.core.utils.i0.j(c50.b.b(((Widget) this).dataCenter), this.y1, this.x1);
        return;
    L88:
        return;
    L59:
        if (r0.equals("landscape_toolbar_button_change") == true) goto L61;
        return;
    L61:
        if (DiggABHelper.a == true) goto L63;
        return;
    L63:
        if (isScreenPortrait() == true) goto L96;
        ArrayList r11 = (ArrayList) r5.getData(new ArrayList());
        if (r11 == null) goto L92;
        Yq(r11);
        return;
    L92:
        return;
    L96:
        return;
    }

    public final void onEnterClear(int r7) {
        if (r7 != 1) goto L7;
        if (((Boolean) uk.a.getValue()).booleanValue() == true) goto L7;
    L12:
        this.S.e(cc2.g.e.c, true);
    L14:
        if (r7 != 2) goto L35;
        ce1 r1 = com.bytedance.android.livesdk.performance.x.a;
        if (r1.enable == true) goto L18;
    L20:
        boolean r2 = false;
    L21:
        if (r2 == false) goto L35;
        if (isViewValid() == false) goto L35;
        ALogger.d("PauseAnim", "DiggWidget pauseFlowAnimation");
        com.bytedance.android.livesdk.interactivity.like.controller.d r3 = this.i.g.j;
        if (r3 == null) goto L27;
        r3.d = false;
        r3.e();
        ALogger.d("PauseAnim", "OthersDiggAnimationControllerImpl pause");
    L27:
        BottomSelfDiggOptimizeView r4 = this.i.a();
        if (r4 == null) goto L33;
        ALogger.d("PauseAnim", "pauseFlowAnimation size=" + ((LinkedList) r4.a).size());
        Iterator<w0> r5 = r4.a.iterator();
    L31:
        if (r5.hasNext() == false) goto L33;
        r5.next().pause();
    L33:
        this.U = true;
        goto L35
    L18:
        if (r1.diggWidgetEnable == false) goto L20;
        r2 = true;
    L35:
        if (r7 != 256) goto L52;
        View r8 = ((Widget) this).contentView;
        if (r8 == null) goto L39;
        UtilityKotlinExtentionsKt.t(r8);
    L39:
        this.L.b(false);
        DiggCountFlipperLayoutControllerImpl r9 = Gq();
        if (r9 == null) goto L53;
        DiggCountFlipperLayout r0 = r9.c;
        if (r0 == null) goto L44;
        r0.setCanFlip(false);
    L44:
        DiggCountFlipperLayout r6 = r9.e;
        if (r6 == null) goto L47;
        r6.setCanFlip(false);
    L47:
        DiggCountFlipperLayout r10 = r9.g;
        if (r10 == null) goto L54;
        r10.setCanFlip(false);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L7:
        if (r7 == 4) goto L12;
        if (r7 == 16) goto L12;
        if (r7 != 32) goto L14;
        goto L12
    }

    public final void onEvent(zg1.x0 r6) {
        if (com.bytedance.android.live.core.utils.z.b(((Widget) this).dataCenter).b == false) goto L5;
        return;
    L5:
        if (((Widget) this).isViewValid == false) goto L10;
        UIUtils.updateLayoutMargin(((Widget) this).contentView, -r6.c, -3, -r6.d, -3);
        UIUtils.updateLayoutMargin(this.d, -3, -3, r6.d - s1.f(10.0f), -3);
        UIUtils.updateLayoutMargin(this.e, -3, -3, r6.d - s1.f(10.0f), -3);
        return;
    }

    public final void onExitClear(int r7) {
        if (r7 != 1) goto L5;
    L10:
        this.S.e(cc2.g.e.c, false);
    L12:
        if (r7 != 2) goto L36;
        ce1 r2 = com.bytedance.android.livesdk.performance.x.a;
        if (r2.enable == true) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L36;
        if (isViewValid() == false) goto L36;
        ALogger.d("PauseAnim", "DiggWidget resumeFlowAnimation");
        com.bytedance.android.livesdk.interactivity.like.controller.d r4 = this.i.g.j;
        if (r4 == null) goto L25;
        r4.d = true;
        ALogger.d("PauseAnim", "OthersDiggAnimationControllerImpl resume");
    L25:
        BottomSelfDiggOptimizeView r5 = this.i.a();
        if (r5 == null) goto L34;
        ALogger.d("PauseAnim", "resumeFlowAnimation size=" + ((LinkedList) r5.a).size());
        if (r5.a.isEmpty() == true) goto L34;
        Iterator<w0> r6 = r5.a.iterator();
    L32:
        if (r6.hasNext() == false) goto L34;
        r6.next().resume();
    L34:
        this.U = false;
        goto L36
    L16:
        if (r2.diggWidgetEnable == false) goto L18;
        r3 = true;
    L36:
        if (r7 != 256) goto L53;
        View r8 = ((Widget) this).contentView;
        if (r8 == null) goto L40;
        UtilityKotlinExtentionsKt.w(r8);
    L40:
        this.L.b(true);
        DiggCountFlipperLayoutControllerImpl r9 = Gq();
        if (r9 == null) goto L54;
        DiggCountFlipperLayout r0 = r9.c;
        if (r0 == null) goto L45;
        r0.setCanFlip(true);
    L45:
        DiggCountFlipperLayout r1 = r9.e;
        if (r1 == null) goto L48;
        r1.setCanFlip(true);
    L48:
        DiggCountFlipperLayout r10 = r9.g;
        if (r10 == null) goto L55;
        r10.setCanFlip(true);
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L5:
        if (r7 == 4) goto L10;
        if (r7 == 16) goto L10;
        if (r7 != 32) goto L12;
        goto L10
    }

    public final void onInit(Object[] r9) {
        ALogger.i("preview_digg", "DiggWidget, onInit");
        LiveViewStub r0 = ((Widget) this).contentView.findViewById(2131385872);
        if ((r0 instanceof LiveViewStub) == false) goto L8;
        ALogger.i("preview_digg", "selfViewStub is LiveViewStub");
        BottomSelfDiggOptimizeView r1 = new BottomSelfDiggOptimizeView(((Widget) this).context);
        this.d = r1;
        r1.setHasFixSize(true);
        MeasureOptFrameLayout r2 = this.d;
        if (r2 == null) goto L13;
        r0.a(r2);
    L13:
        this.e = ((Widget) this).contentView.findViewById(2131369094);
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L16;
        this.B = com.bytedance.android.live.core.utils.z.b(r3).c;
    L16:
        LiveViewStub r4 = ((Widget) this).contentView.findViewById(2131388187);
        if ((r4 instanceof LiveViewStub) == false) goto L20;
        ALogger.i("preview_digg", "tapViewStub is LiveViewStub");
        DiggTapOptimizeView r5 = new DiggTapOptimizeView(((Widget) this).context);
        this.c = r5;
        r4.a(r5);
    L25:
        MeasureOptFrameLayout r6 = this.d;
        if (r6 == null) goto L28;
        r6.setVisibility(0);
    L28:
        SimpleDraweeView r7 = this.e;
        if (r7 == null) goto L31;
        r7.setVisibility(0);
    L31:
        View r8 = this.c;
        if (r8 == null) goto L34;
        r8.setVisibility(0);
    L34:
        this.f = (DiggTabCountView) ((Widget) this).contentView.findViewById(2131369098);
        if (isRunOnLivePreview() == true) goto L37;
    L50:
        ALogger.i("digg_widget_obtainTypedArray", "get origin");
        TypedArray r10 = ((Widget) this).context.getResources().obtainTypedArray(2130903116);
        int r11 = r10.length();
        int r13 = 0;
    L51:
        if (r13 >= r11) goto L53;
        this.n.add(Integer.valueOf(r10.getResourceId(r13, 0)));
        r13 = r13 + 1;
        goto L51
    L53:
        r10.recycle();
        TypedArray r14 = ((Widget) this).context.getResources().obtainTypedArray(2130903120);
        int r15 = r14.length();
        int r16 = 0;
    L54:
        if (r16 >= r15) goto L56;
        this.p.add(Integer.valueOf(r14.getResourceId(r16, 0)));
        r16 = r16 + 1;
        goto L54
    L56:
        r14.recycle();
    L57:
        this.h.getClass();
        c r17 = this.i;
        UIUtils.updateLayout(r17.g.d, (int) UtilityKotlinExtentionsKt.h(68.0f), (int) UtilityKotlinExtentionsKt.h(220.0f));
        s82.a r18 = r17.g.a;
        UtilityKotlinExtentionsKt.h(68.0f);
        r18.getClass();
        s82.a r19 = r17.g.a;
        UtilityKotlinExtentionsKt.h(200.0f);
        r19.getClass();
        py.k r20 = jc1.k.n(IUserService.class).user().b().getAvatarThumb();
        if (r20 == null) goto L60;
        ((ObservableSubscribeProxy) Observable.just(r20).observeOn(Schedulers.io()).flatMap(new com.bytedance.android.livesdk.interactivity.like.n(r20)).map(com.bytedance.android.livesdk.interactivity.like.o.a).observeOn(AndroidSchedulers.mainThread()).as(r17.g.autoDispose())).subscribe(new com.bytedance.android.livesdk.interactivity.like.m(r17), com.bytedance.android.livesdk.interactivity.like.p.a);
    L60:
        this.j = new com.bytedance.android.livesdk.interactivity.like.controller.d(new o(this));
        ALogger.i("preview_digg", "DiggWidget, success");
        return;
    L37:
        if (((Boolean) rn.a.getValue()).booleanValue() == false) goto L50;
        ALogger.i("digg_widget_obtainTypedArray", "get new in preview");
        if (this.n.isEmpty() == false) goto L45;
        ALogger.i("digg_widget_obtainTypedArray", "drawableIds is empty");
        TypedArray r21 = ((Widget) this).context.getResources().obtainTypedArray(2130903116);
        int r23 = r21.length();
        int r24 = 0;
    L41:
        if (r24 >= r23) goto L43;
        this.n.add(Integer.valueOf(r21.getResourceId(r24, 0)));
        r24 = r24 + 1;
        goto L41
    L43:
        r21.recycle();
    L45:
        if (this.p.isEmpty() == false) goto L57;
        ALogger.i("digg_widget_obtainTypedArray", "mediaDrawableIds is empty");
        TypedArray r25 = ((Widget) this).context.getResources().obtainTypedArray(2130903120);
        int r26 = r25.length();
        int r27 = 0;
    L47:
        if (r27 >= r26) goto L49;
        this.p.add(Integer.valueOf(r25.getResourceId(r27, 0)));
        r27 = r27 + 1;
        goto L47
    L49:
        r25.recycle();
        goto L57
    L20:
        if ((r4 instanceof DiggTapOptimizeView) == false) goto L22;
        ALogger.i("preview_digg", "tapViewStub is DiggTapOptimizeView");
        this.c = r4;
        goto L25
    L22:
        ALogger.i("preview_digg", "tapViewStub type error");
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L63;
        this.c = new DiggTapOptimizeView(((Widget) this).context);
        goto L25
    L63:
        throw new Exception("tapViewStub type error: ".concat(r4.getClass().getName()));
    L8:
        if ((r0 instanceof BottomSelfDiggOptimizeView) == false) goto L10;
        ALogger.i("preview_digg", "selfViewStub is BottomSelfDiggOptimizeView");
        this.d = (BottomSelfDiggOptimizeView) r0;
        goto L13
    L10:
        ALogger.i("preview_digg", "selfViewStub type error");
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L65;
        this.d = new BottomSelfDiggOptimizeView(((Widget) this).context);
        goto L13
    L65:
        throw new Exception("selfViewStub type error: ".concat(r0.getClass().getName()));
    }

    public final void onLoad(Object[] r20) {
        ALogger.i("preview_digg", "DiggWidget, onLoad");
        this.m = new CompositeDisposable();
        boolean r2 = false;
        this.x = 0;
        com.bytedance.android.live.core.utils.y r0 = com.bytedance.android.live.core.utils.z.b(((Widget) this).dataCenter);
        IRoom r3 = r0.a;
        Object r5 = null;
        if ((r3 instanceof Room) == true) goto L5;
        r3 = null;
    L5:
        Room r4 = (Room) r3;
        this.z = r4;
        this.A = r0.b;
        this.B = r0.c;
        if (r4 == null) goto L8;
        br(Long.valueOf(r4.getUserCount()).longValue());
    L8:
        Room r1 = this.z;
        if (r1 == null) goto L11;
        long r6 = r1.id;
    L12:
        this.y = r6;
        int r7 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
        com.bytedance.android.livesdk.interactivity.like.utils.b.a("onLoad", this.B, isScreenPortrait(), this.G, this.z);
        RoomContext r8 = getRoomContext();
        if (r8 == null) goto L19;
        com.bytedance.android.livesdk.interactivity.api.h r9 = com.bytedance.android.livesdk.interactivity.api.i.c(r8);
        if (r9 == null) goto L19;
        com.bytedance.live.datacontext.j<h32.a> r10 = r9.getDegradeManager();
        if (r10 == null) goto L19;
        h32.a r11 = (h32.a) r10.getValue();
    L20:
        this.M = r11;
        vlc.d r13 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r13 == null) goto L23;
        r13.addMessageListener(MessageType.LIKE_MESSAGE.getIntType(), this);
        r13.addMessageListener(MessageType.DOUBLE_LIKE_HEART_MESSAGE.getIntType(), this);
        r13.addMessageListener(MessageType.ROOM_STATS.getWsMethod(), this);
        Unit r14 = Unit.INSTANCE;
    L24:
        this.D = r13;
        ((Widget) this).dataCenter.observe("match_is_public_interact_tab", this).observe("data_is_portrait", this).observe("cmd_specific_behavior_loaded", this).observe("cmd_specific_behavior_un_loaded", this).observe("landscape_toolbar_button_change", this).observe("cmd_all_widget_loaded", this).observe("data_hide_screen", this);
        RoomContext r15 = getDataContext();
        if (r15 == null) goto L29;
        com.bytedance.live.datacontext.m r16 = r15.getLandscapeRootChange();
        if (r16 == null) goto L29;
        onEvent((zg1.x0) r16.getValue());
        ((ObservableSubscribeProxy) r16.a().observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new s0(new DiggWidget$initEvents$2$1(this)));
    L29:
        ((ObservableSubscribeProxy) xs2.b.a().b(zg1.e0.class).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new e0(this));
        if (VrUtils.t(((Widget) this).dataCenter, false) == false) goto L32;
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).b(n3.class).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new f0(this));
    L32:
        h32.a r17 = this.M;
        if (r17 == null) goto L36;
        r17.e().b(this.b1);
        r17.b().b(this.g1);
    L36:
        if (this.L0.useStrategyPlatform == false) goto L46;
        IStrategyService r18 = jc1.k.f(IStrategyService.class);
        if (r18 == null) goto L42;
        LiveData r19 = IStrategyService.a.a(r18, "flow_like_degrade_level", 0, false, 12);
        if (r19 == null) goto L42;
        r19.observe(this, new q0(this));
    L42:
        if (r18 == null) goto L46;
        LiveData r21 = IStrategyService.a.a(r18, "tap_like_degrade_level", 0, false, 12);
        if (r21 == null) goto L46;
        r21.observe(this, new r0(this));
    L46:
        DiggTabCountView r23 = this.f;
        if (r23 != null) goto L49;
    L59:
        DiggContext.a r24 = DiggContext.Companion;
        DataCenter r25 = ((Widget) this).dataCenter;
        r24.getClass();
        DiggContext r26 = DiggContext.a.a(r25);
        if (r26 == null) goto L62;
        r26.getDiggWidget().setValue(this);
    L62:
        runOnLivePreview(new AnonymousClass4(this));
        boolean r27 = DiggABHelper.a;
        com.bytedance.android.livesdk.interactivity.api.like.utils.a.a(this.B);
        runOnLiveInner(new AnonymousClass5(this));
        runOnLivePreview(new AnonymousClass6(this));
        if (this.L0.useStrategyPlatform == true) goto L87;
        boolean r28 = this.B;
        if (r28 == false) goto L69;
        if (r28 == false) goto L87;
        if (((Boolean) qq.a.getValue()).booleanValue() == false) goto L87;
    L69:
        com.bytedance.android.livesdk.interactivity.like.l r29 = new com.bytedance.android.livesdk.interactivity.like.l(this.M, getRoomContext());
        this.g = r29;
        IPerformanceStrategyManager r30 = jc1.k.f(IPerformanceStrategyManager.class);
        if (r30 == null) goto L72;
        r30.registerPerformanceStrategyTask(220, r29);
    L72:
        IPerformanceStrategyManager r31 = jc1.k.f(IPerformanceStrategyManager.class);
        if (r31 == null) goto L75;
        int r33 = r31.getCurrentPerformanceLevel();
    L76:
        com.bytedance.android.livesdk.interactivity.like.l r34 = this.g;
        if (r34 == null) goto L87;
        Intrinsics.checkNotNullParameter(r34, "$this$syncDegrade");
        com.bytedance.android.livesdk.interactivity.like.c r110 = new com.bytedance.android.livesdk.interactivity.like.c();
        if (r33 == 1) goto L86;
        if (r33 != 2) goto L82;
        r34.onTriggerDegrade(r33, new HashMap(), r110);
        goto L87
    L82:
        if (r33 != 11) goto L87;
        r34.onTriggerDegrade(r33, new HashMap(), r110);
        goto L87
    L86:
        r34.onTriggerDegrade(r33, new HashMap(), r110);
        goto L87
    L75:
        r33 = 0;
    L87:
        KeyEvent.Callback r35 = this.c;
        if ((r35 instanceof com.bytedance.android.livesdk.interactivity.like.view.z) == true) goto L90;
        r35 = null;
    L90:
        com.bytedance.android.livesdk.interactivity.like.view.z r36 = (com.bytedance.android.livesdk.interactivity.like.view.z) r35;
        if (r36 == null) goto L93;
        r36.load();
    L93:
        boolean r37 = this.d instanceof com.bytedance.android.livesdk.interactivity.like.view.z;
        Lazy r38 = DiggABHelper.c;
        if (((ss1.b) r38.getValue()).enable == true) goto L96;
    L107:
        this.k0 = false;
        this.L = new u32.e(this.z, this.D, Iq(), ((Widget) this).dataCenter);
        if (com.bytedance.android.live.core.utils.z.m(((Widget) this).dataCenter, true) == false) goto L110;
    L118:
        j r39 = this.S;
        cc2.g.c r40 = cc2.g.c.c;
        DataCenter r111 = ((Widget) this).dataCenter;
        Boolean r112 = Boolean.TRUE;
        if (r111 == null) goto L129;
        Object r41 = r111.get("match_is_public_interact_tab", null);
        if ((r41 instanceof Boolean) == false) goto L125;
        r5 = r41;
    L125:
        Boolean r43 = (Boolean) r5;
        if (r43 == null) goto L129;
        r112 = r43;
    L129:
        r39.e(r40, !r112.booleanValue());
        j r44 = this.S;
        cc2.g.d r45 = cc2.g.d.c;
        if (VrUtils.t(((Widget) this).dataCenter, false) == false) goto L138;
        RoomContext r46 = getRoomContext();
        if (r46 == null) goto L138;
        com.bytedance.live.datacontext.m r47 = r46.getVrInImmersedMode();
        if (r47 == null) goto L138;
        if (((Boolean) r47.getValue()).booleanValue() != true) goto L138;
        boolean r48 = true;
    L139:
        r44.e(r45, r48);
        if (VrUtils.d(((Widget) this).dataCenter) == true) goto L142;
    L152:
        this.N = true;
        if (isScreenPortrait() == false) goto L158;
        int r49 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r50 = com.bytedance.android.live.room.api.panel.d.b(((Widget) this).dataCenter, this.y);
        if (r50 == null) goto L158;
        r50.registerPanelListener(this.G1, true);
    L158:
        if (this.B == true) goto L160;
        return;
    L160:
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.u) b4.a.getValue()).a() == true) goto L162;
        return;
    L162:
        if (((Boolean) xm.a.getValue()).booleanValue() == true) goto L180;
        MiddlewareRoomContext r51 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r51 == null) goto L181;
        com.bytedance.live.datacontext.n r53 = r51.getRtcRoomInfo();
        if (r53 == null) goto L182;
        dh1.a r54 = (dh1.a) r53.getValue();
        if (r54 == null) goto L170;
        long r55 = r54.a;
    L172:
        if (r55 <= 0) goto L174;
        r2 = true;
    L174:
        this.R = r2;
        this.Q = r53.a().subscribe(new p0(r53, this));
        return;
    L170:
        r55 = 0;
        goto L172
    L182:
        return;
    L181:
        return;
    L180:
        return;
    L142:
        if (isScreenPortrait() == false) goto L152;
        RoomContext r56 = getRoomContext();
        if (r56 == null) goto L152;
        com.bytedance.live.datacontext.m r57 = r56.getVrInImmersedMode();
        if (r57 == null) goto L152;
        if (((Boolean) r57.getValue()).booleanValue() == false) goto L150;
        int r58 = 8;
    L151:
        A9(r58);
        Bq(r57.a().subscribe(new p(this)));
        goto L152
    L150:
        r58 = 0;
    L138:
        r48 = false;
        goto L139
    L110:
        if (com.bytedance.android.live.core.utils.z.o(((Widget) this).dataCenter).isMergeVSRoom() == false) goto L118;
        MeasureOptFrameLayout r113 = this.d;
        if (r113 == null) goto L118;
        IVSPlayerService r59 = jc1.k.f(IVSPlayerService.class);
        if (r59 == null) goto L118;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r60 = r59.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r60 == null) goto L118;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c.a.a(r60, PlayerViewControl.KEY.DiggSelf, PlayerViewControl.Type.ALPHA, PlayerViewControl.Style.HIDE, r113, 0.0f, false, false, null, 400);
        goto L118
    L96:
        if (((ss1.b) r38.getValue()).hideWhenIntroduceCardShow == false) goto L107;
        if (isScreenPortrait() == false) goto L107;
        if (jc1.k.n(IMsgWindowService.class).cardRecorder().a(((Widget) this).dataCenter, CardTypeAndPriority.AssembledIntroduceCard.getType(), MsgWindowPosition.BOTTOM_RIGHT) == false) goto L104;
        this.T.e(cc2.i.c.c, true);
        ALogger.i("DiggHide", "onLoad digg view gone");
    L104:
        Disposable r61 = jc1.k.n(IMsgWindowService.class).cardStateDispatcher(((Widget) this).dataCenter).a().a().subscribe(new u0(this));
        if (r61 == null) goto L107;
        Bq(r61);
        goto L107
    L49:
        if (r23.i == true) goto L59;
        if (((Boolean) qn.a.getValue()).booleanValue() == false) goto L59;
        r23.i = true;
        ALogger.i("DiggTabCountView", "set typeface in trySetTypeface");
        Typeface r63 = Typeface.createFromAsset(r23.getContext().getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L57
        r23.b.setTypeface(r63);     // Catch: Exception -> L57
        r23.c.setTypeface(r63);     // Catch: Exception -> L57
        ((TextView) r23.d.findViewById(2131390527)).setTypeface(r63);     // Catch: Exception -> L57
        ((TextView) r23.d.findViewById(2131390526)).setTypeface(r63);     // Catch: Exception -> L57
    L57:
        e = move-exception;
        ALogger.e("DiggTabCountView", "load font asset exception: " + e.getMessage());
        goto L59
    L23:
        r13 = null;
    L19:
        r11 = null;
        goto L20
    L11:
        r6 = 0;
        goto L12
    }

    public final void onMessage(tlc.d r7) {
        if ((r7 instanceof yd) == false) goto L79;
        if (((LiveWidget) this).isAppBackground == false) goto L7;
        return;
    L7:
        yd r8 = (yd) r7;
        if (((Widget) this).isViewValid == false) goto L16;
        Room r0 = this.z;
        if (r0 == null) goto L16;
        RoomAuthStatus r1 = r0.getMRoomAuthStatus();
        if (r1 == null) goto L16;
        if (r1.getEnableDigg() != true) goto L16;
        boolean r2 = true;
    L17:
        Boolean r3 = this.H;
        if (r3 == null) goto L22;
        r3.booleanValue();
        if ((!Intrinsics.areEqual(Boolean.valueOf(r2), this.H)) == false) goto L24;
        this.H = Boolean.valueOf(r2);
        int r4 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
        com.bytedance.android.livesdk.interactivity.like.utils.b.a("Show Other Digg Status Changed", this.B, isScreenPortrait(), this.G, this.z);
    L24:
        if (((Widget) this).isViewValid == false) goto L82;
        Room r5 = this.z;
        if (r5 == null) goto L83;
        RoomAuthStatus r6 = r5.getMRoomAuthStatus();
        if (r6 != null) goto L30;
        return;
    L30:
        if (r6.getEnableDigg() == true) goto L33;
        return;
    L33:
        if (this.R == false) goto L35;
        this.P = r8;
        return;
    L35:
        this.X = r8.getTotal();
        if (isRunOnLivePreview() == true) goto L41;
        Room r9 = this.z;
        if (r9 == null) goto L41;
        r9.setDiggCount(r8.getTotal());
    L41:
        if (this.L.c() == true) goto L44;
        return;
    L44:
        if (((Boolean) xm.a.getValue()).booleanValue() == true) goto L48;
        DiggCountFlipperLayoutControllerImpl r10 = Gq();
        if (r10 == null) goto L48;
        r10.g(r8.getTotal());
    L48:
        this.Y.onNext(Long.valueOf(r8.getTotal()));
        User r11 = r8.getUser();
        if (r11 == null) goto L51;
        String r13 = r11.getIdStr();
    L53:
        if ((!Intrinsics.areEqual(r13, jc1.k.n(IUserService.class).user().n())) == true) goto L55;
    L67:
        com.bytedance.android.livesdk.interactivity.like.controller.d r14 = this.j;
        if (r14 == null) goto L71;
        r14.e();
    L71:
        if (this.B == false) goto L92;
        com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.b.J1;
        if (((Boolean) r15.a()).booleanValue() == true) goto L86;
        r15.b(Boolean.TRUE);
        ek r16 = ag1.c.c(this.y, s1.B(2131916208));
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.d(r16, PSMessageAction.SYSTEM);
        vlc.d r17 = this.D;
        if (r17 == null) goto L87;
        r17.B(r16);
        return;
    L87:
        return;
    L86:
        return;
    L92:
        return;
    L55:
        if (this.V0.d == true) goto L67;
        if (isRunOnLivePreview() == true) goto L67;
        com.bytedance.android.live.base.model.data.e r18 = r8.W();
        if (r18 == null) goto L63;
        if (r18.showIcons == false) goto L71;
    L63:
        if (this.v1 == true) goto L71;
        com.bytedance.android.livesdk.interactivity.like.controller.d r19 = this.j;
        if (r19 == null) goto L71;
        r19.d(r8.getCount(), this.V0.c);
        goto L71
    L51:
        r13 = null;
        goto L53
    L83:
        return;
    L82:
        return;
    L22:
        this.H = Boolean.valueOf(r2);
        int r20 = com.bytedance.android.livesdk.interactivity.like.utils.b.a;
        com.bytedance.android.livesdk.interactivity.like.utils.b.a("First Set Show Other Digg Status", this.B, isScreenPortrait(), this.G, this.z);
    L16:
        r2 = false;
        goto L17
    L79:
        if ((r7 instanceof mk) == false) goto L89;
        br(((mk) r7).getTotal());
        return;
    }

    public final void qo(Boolean r1) {
        this.b = r1;
    }

    public final void onEvent(n3 r5) {
        boolean r1 = false;
        if (VrUtils.t(((Widget) this).dataCenter, false) == true) goto L5;
        return;
    L5:
        j r0 = this.S;
        cc2.g.d r2 = cc2.g.d.c;
        if (r5 != null) goto L8;
    L10:
        r0.e(r2, r1);
        return;
    L8:
        if (r5.a != true) goto L10;
        r1 = true;
        goto L10
    }

    public static final void wq(DiggWidget r3, View r4) {
        r3.getClass();
        if (r4 == null) goto L9;
        ViewPropertyAnimator r0 = r4.animate();
        if (r0 == null) goto L10;
        r0.cancel();
        r0.alpha(0.0f).setDuration(200).setListener(new a0(r3, r4)).start();
        return;
    L10:
        return;
    }

    public static final void xq(DiggWidget r3, View r4) {
        r3.getClass();
        if (r4 == null) goto L9;
        ViewPropertyAnimator r0 = r4.animate();
        if (r0 == null) goto L10;
        r0.cancel();
        r4.setAlpha(0.0f);
        r0.alpha(1.0f).setDuration(200).setListener(new b0(r3, r4)).start();
        return;
    L10:
        return;
    }

    public final void Cq(ILivePreviewDiggView r5, int[] r6) {
        MeasureOptFrameLayout r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r6 != null) goto L7;
        r6 = r5.getLocationOnScreen();
    L7:
        int r1 = 0;
        if (1 > ArraysKt.getLastIndex(r6)) goto L10;
        int r7 = r6[1];
    L11:
        int[] r8 = new int[2];
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L14;
        r3.getLocationOnScreen(r8);
    L14:
        int r9 = r8[1];
        View r2 = ((Widget) this).contentView;
        if (r2 == null) goto L17;
        r1 = r2.getHeight();
    L17:
        int r10 = (r9 + r1) - r7;
        if (r10 != com.bytedance.android.live.core.utils.a1.e(r0)) goto L20;
        return;
    L20:
        ALogger.i("preview_digg", "set new margin bottom: " + r10);
        this.H1 = r10;
        UIUtils.updateLayoutMargin(r0, -3, -3, -3, r10);
        this.a.getClass();
        return;
    L10:
        r7 = 0;
        goto L11
    }

    @Override // u32.k
    public final boolean Km(MotionEvent r9, long r10, PointF r13, boolean r14, boolean r15, boolean r16) {
        Pq();
        RoomContext r0 = getDataContext();
        if (r0 == null) goto L15;
        if (r0.isVSRoom() != true) goto L15;
        IVSPlayerService r1 = jc1.k.f(IVSPlayerService.class);
        if (r1 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r2 = r1.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r2 == null) goto L15;
        if (r2.getLockStatus() != true) goto L15;
        ALogger.i("preview_digg", "onScreenTap, return false for vs");
        return false;
    L15:
        if (this.L.c() == true) goto L19;
        if (isRunOnLivePreview() == true) goto L19;
    L135:
        Fq();
        Rq();
        ALogger.i("preview_digg", "onScreenTap, return false for can digg");
        return false;
    L19:
        if (Lq() == true) goto L135;
        if (Fq() == true) goto L135;
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L38;
        Rq();
        PublishSubject<Unit> r11 = this.K;
        if (r11 == null) goto L28;
        r11.onNext(Unit.INSTANCE);
    L28:
        long r17 = SystemClock.elapsedRealtime();
        if (isRunOnLivePreview() == true) goto L33;
        ALogger.i("preview_digg", "onScreenTap, return false for inner not login");
        return false;
    L33:
        if ((r17 - this.L1) > r10) goto L36;
        this.L1 = SystemClock.elapsedRealtime();
        ALogger.i("preview_digg", "onScreenTap, return true for live preview not login");
        return true;
    L36:
        this.L1 = SystemClock.elapsedRealtime();
        ALogger.i("preview_digg", "onScreenTap, return false for live preview not login");
        return false;
    L38:
        Disposable r3 = this.F;
        if (r3 != null) goto L41;
    L42:
        Tq();
    L43:
        long r4 = SystemClock.elapsedRealtime();
    L132:
        th = move-exception;
        this.w = r4;
        throw th;
    L45:
        if ((r4 - this.w) <= r10) goto L51;
        if (r14 == true) goto L51;
        this.x = 0;     // Catch: Throwable -> L132
        ALogger.i("preview_digg", "onScreenTap, return false can't digg");     // Catch: Throwable -> L132
        this.w = r4;
        return false;
    L51:
        com.bytedance.android.livesdk.interactivity.like.controller.d r18 = this.j;     // Catch: Throwable -> L132
        if (r18 == null) goto L54;
        r18.d = false;     // Catch: Throwable -> L132
        r18.e();     // Catch: Throwable -> L132
        ALogger.d("PauseAnim", "OthersDiggAnimationControllerImpl pause");     // Catch: Throwable -> L132
    L54:
        Disposable r19 = this.C;     // Catch: Throwable -> L132
        if (r19 == null) goto L58;
        r19.dispose();     // Catch: Throwable -> L132
    L58:
        if (InteractivityOpt.a == true) goto L60;
        Disposable r110 = ((ObservableSubscribeProxy) Observable.timer(r10, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new q(this));     // Catch: Throwable -> L132
    L61:
        this.C = r110;     // Catch: Throwable -> L132
        this.x++;     // Catch: Throwable -> L132
        if (this.B == false) goto L105;
        com.bytedance.android.livesdk.interactivity.like.controller.e r111 = Mq();     // Catch: Throwable -> L132
        if (r111 == null) goto L66;
        r111.getClass();     // Catch: Throwable -> L132
    L66:
        c2 r112 = c2.a;     // Catch: Throwable -> L132
        int r113 = ((Number) InteractivityOpt.c(r112)).intValue();     // Catch: Throwable -> L132
        int r114 = this.x;     // Catch: Throwable -> L132
        State r5 = null;
        if (r114 < 0) goto L76;
        if (r113 <= r114) goto L76;
        com.bytedance.android.livesdk.interactivity.like.controller.c r115 = Jq();     // Catch: Throwable -> L132
        if (r115 == null) goto L74;
        r5 = r115.a;     // Catch: Throwable -> L132
    L74:
        if (r5 != State.CLEAR) goto L105;
        Eq();     // Catch: Throwable -> L132
    L76:
        int r116 = ((Number) InteractivityOpt.c(r112)).intValue();     // Catch: Throwable -> L132
        int r117 = ((Number) InteractivityOpt.c(d2.a)).intValue();     // Catch: Throwable -> L132
        int r118 = this.x;     // Catch: Throwable -> L132
        if (r116 > r118) goto L81;
        if (r117 <= r118) goto L81;
    L94:
        com.bytedance.android.livesdk.interactivity.like.controller.c r119 = Jq();     // Catch: Throwable -> L132
        if (r119 == null) goto L97;
        State r120 = r119.a;     // Catch: Throwable -> L132
    L99:
        if (r120 != State.CLEAR) goto L105;
        if (Eq() == null) goto L105;
        int r20 = com.bytedance.android.livesdk.interactivity.like.controller.a.b;     // Catch: Throwable -> L132
        Intrinsics.throwUninitializedPropertyAccessException("avatarScaleView");     // Catch: Throwable -> L132
        throw null;     // Catch: Throwable -> L132
    L97:
        r120 = null;
    L81:
        if (this.A == false) goto L94;
        Room r121 = this.z;     // Catch: Throwable -> L132
        if (r121 == null) goto L88;
        if (r121.isMediaRoom() == true) goto L94;
    L88:
        if (Eq() != null) goto L92;
        com.bytedance.android.livesdk.interactivity.like.controller.c r122 = Jq();     // Catch: Throwable -> L132
        if (r122 == null) goto L105;
        r122.d(this.x);     // Catch: Throwable -> L132
        goto L105
    L92:
        Intrinsics.throwUninitializedPropertyAccessException("avatarScaleView");     // Catch: Throwable -> L132
        throw null;     // Catch: Throwable -> L132
    L105:
        Bitmap r123 = Qq();     // Catch: Throwable -> L132
        if (r123 != null) goto L108;
    L110:
        Bitmap r21 = this.i.a;     // Catch: Throwable -> L132
        if (r123 == null) goto L117;
        if (r21 == null) goto L117;
        if (this.L.a() == false) goto L117;
        if (r16 == true) goto L117;
        this.i.f(r21, r123);     // Catch: Throwable -> L132
    L117:
        PublishSubject<Integer> r23 = this.E;     // Catch: Throwable -> L132
        if (r15 == false) goto L120;
        int r124 = 2;
    L121:
        r23.onNext(Integer.valueOf(r124));     // Catch: Throwable -> L132
        u32.l r24 = Iq();     // Catch: Throwable -> L132
        if (r24 == null) goto L124;
        r24.onLocalLike(1);     // Catch: Throwable -> L132
    L124:
        DiggContext.a r25 = DiggContext.Companion;     // Catch: Throwable -> L132
        DataCenter r125 = ((Widget) this).dataCenter;     // Catch: Throwable -> L132
        r25.getClass();     // Catch: Throwable -> L132
        DiggContext r26 = DiggContext.a.a(r125);     // Catch: Throwable -> L132
        if (r26 == null) goto L129;
        com.bytedance.live.datacontext.m<Long> r27 = r26.getDiggTime();     // Catch: Throwable -> L132
        if (r27 == null) goto L129;
        r27.setValue(Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L132
    L129:
        ALogger.i("preview_digg", "onScreenTap, return true can digg");     // Catch: Throwable -> L132
        this.w = r4;
        return true;
    L120:
        r124 = 1;
        goto L121
    L108:
        if (this.L.d() == false) goto L110;
        this.h.a(r123, r9, r13);     // Catch: Throwable -> L132
        goto L110
    L60:
        r110 = Observable.timer(r10, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this));     // Catch: Throwable -> L132
        goto L61
    L41:
        if (r3.isDisposed() == false) goto L43;
        goto L42
    }
}
