package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.discovery.presenter.SoundCardModeManager;
import com.bytedance.android.live.room.discovery.stable.AnchorStableModeConfig;
import com.bytedance.android.live.room.utils.UsbDeviceUtils;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.HostAppMonitorService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.aq0;
import com.bytedance.android.livesdk.config.bi;
import com.bytedance.android.livesdk.config.ci;
import com.bytedance.android.livesdk.config.dh;
import com.bytedance.android.livesdk.config.iq0;
import com.bytedance.android.livesdk.config.k21;
import com.bytedance.android.livesdk.config.lq0;
import com.bytedance.android.livesdk.config.p9;
import com.bytedance.android.livesdk.config.rh;
import com.bytedance.android.livesdk.config.ta;
import com.bytedance.android.livesdk.config.tm;
import com.bytedance.android.livesdk.config.vh;
import com.bytedance.android.livesdk.config.wh;
import com.bytedance.android.livesdk.config.y71;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.gamecp.AnchorFloatWindowPerfData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.live.ILiveExternalCameraServiceForOther;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mobsec.metasec.ml.MSManager;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.effectmanager.DownloadableModelSupport;
import com.ss.android.ugc.effectmanager.IFetchModelListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import zg1.b1;
import zg1.c1;
import zg1.d1;
import zg1.e1;
import zg1.h1;
import zg1.o1;
import zg1.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/room/discovery/AnchorPerfMonitorWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lo70/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorPerfMonitorWidget extends LiveRecyclableWidget implements o70.a, Observer<KVData> {
    public static final /* synthetic */ int b1 = 0;
    public final AtomicInteger A;
    public final AtomicInteger B;
    public final AtomicInteger C;
    public final AtomicInteger D;
    public final AtomicInteger E;
    public final AtomicInteger F;
    public final AtomicInteger G;
    public final AtomicInteger H;
    public final AnchorPerfMonitorWidget$usbReceiver$1 H0;
    public final Map<Integer, Bitmap> I;
    public long J;
    public long K;
    public boolean L;
    public final d L0;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public final boolean P0;
    public Disposable Q;
    public boolean R;
    public final b S;
    public final com.bytedance.android.livesdk.performance.r T;
    public final com.bytedance.android.livesdk.performance.r U;
    public final com.bytedance.android.livesdk.performance.r V;
    public boolean V0;
    public final Lazy W;
    public CompletableJob X;
    public g Y;
    public final c Z;
    public Room a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public View e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public final l k0;
    public boolean l;
    public final CompositeDisposable m;
    public Disposable n;
    public Disposable o;
    public final List<String> p;
    public boolean p0;
    public final List<CharSequence> q;
    public IAnchorPerMonitorDialog r;
    public final SimpleDateFormat s;
    public final com.bytedance.android.livesdk.chatroom.model.a t;
    public final ms1.g u;
    public final int v;
    public final boolean w;
    public final AtomicInteger x;
    public final AtomicInteger y;
    public final AtomicInteger z;

    public static final class a {
    }

    public static final class b extends IHostAppMonitorListener.Stub {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        public b(AnchorPerfMonitorWidget r1) {
            this.a = r1;
        }

        public final void appEnterBackground(boolean r3, boolean r4) {
            AnchorPerfMonitorWidget r5 = this.a;
            r5.R = r3;
            if (r3 == true) goto L8;
            g r6 = r5.Y;
            if (r6 == null) goto L9;
            r6.sendEmptyMessageDelayed(4, 5000);
            return;
        L9:
            return;
        }
    }

    public static final class c extends Handler {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        @Override // android.os.Handler
        public final void handleMessage(Message r9) {
            Intrinsics.checkNotNullParameter(r9, Constants.OperatorKey.MSG);
            super.handleMessage(r9);
            int r0 = r9.what;
            if (r0 != 1) goto L5;
            IAnchorPerMonitorDialog r1 = this.a.r;
            if (r1 == null) goto L31;
            r1.Q0();
        L31:
            RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r2 == null) goto L37;
            com.bytedance.live.datacontext.n r3 = r2.getPerfData();
            if (r3 == null) goto L38;
            int r4 = r9.what;
            AnchorPerfMonitorWidget r10 = this.a;
            r3.setValue(new AnchorFloatWindowPerfData(r4, r10.f, r10.g, r10.i, r10.j));
            return;
        L38:
            return;
        L37:
            return;
        L5:
            if (r0 == 2) goto L25;
            if (r0 != 3) goto L8;
            AnchorPerfMonitorWidget r5 = this.a;
            IAnchorPerMonitorDialog r6 = r5.r;
            if (r6 == null) goto L31;
            r6.N0(r5.g);
            goto L31
        L8:
            if (r0 != 4) goto L10;
            AnchorPerfMonitorWidget r7 = this.a;
            if (r7.O == true) goto L18;
        L19:
            IAnchorPerMonitorDialog r8 = r7.r;
            if (r8 == null) goto L31;
            r8.M0(r7.i, r7.V0);
            goto L31
        L18:
            if (r7.M == true) goto L31;
        L10:
            if (r0 != 5) goto L31;
            AnchorPerfMonitorWidget r12 = this.a;
            IAnchorPerMonitorDialog r13 = r12.r;
            if (r13 == null) goto L31;
            r13.O0(r12.j);
            goto L31
        L25:
            AnchorPerfMonitorWidget r14 = this.a;
            IAnchorPerMonitorDialog r15 = r14.r;
            if (r15 == null) goto L31;
            r15.P0(r14.f);
            goto L31
        }

        public c(AnchorPerfMonitorWidget r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class d implements r81.a {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        @Override // r81.a
        public final void onLowMemory() {
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, ((Widget) this.a).dataCenter, 0, 2);
            if (r0 == null) goto L10;
            com.bytedance.live.datacontext.i r1 = r0.isLiveEnd();
            if (r1 != null) goto L7;
            return;
        L7:
            if (((Boolean) r1.getValue()).booleanValue() == true) goto L12;
            ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).handleLowMemory();
            return;
        L12:
            return;
        }

        public d(AnchorPerfMonitorWidget r1) {
            this.a = r1;
        }
    }

    public static final class e<T> implements androidx.lifecycle.Observer {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        public e(AnchorPerfMonitorWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            if (((Boolean) r4).booleanValue() == false) goto L6;
            AnchorPerfMonitorWidget r5 = this.a;
            int r0 = AnchorPerfMonitorWidget.b1;
            r5.k0.sendEmptyMessage(6);
            r5.k0.sendEmptyMessageDelayed(7, 5000);
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        public f(AnchorPerfMonitorWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (this.a.r == null) goto L5;
        L11:
            IAnchorPerMonitorDialog r6 = this.a.r;
            if (r6 != null) goto L14;
        L18:
            AnchorPerfMonitorWidget r7 = this.a;
            if (r7.O == false) goto L21;
            AnchorPerfMonitorWidget.xq(r7);
        L21:
            LinkedHashMap r8 = new LinkedHashMap();
            r8.put("voice_status_mute", String.valueOf(this.a.D.get()));
            r8.put("voice_status_voice_unusual", String.valueOf(this.a.B.get()));
            r8.put("network_status_normal", String.valueOf(this.a.x.get()));
            r8.put("network_status_wave", String.valueOf(this.a.y.get()));
            r8.put("network_status_bad", String.valueOf(this.a.z.get()));
            r8.put("network_status_no_network", String.valueOf(this.a.A.get()));
            r8.put("temperature_status_normal", String.valueOf(this.a.E.get()));
            r8.put("temperature_status_device_heat", String.valueOf(this.a.F.get()));
            r8.put("temperature_status_device_over_heat", String.valueOf(this.a.G.get()));
            Room r0 = this.a.a;
            if (r0 == null) goto L24;
            r8.put("room_id", String.valueOf(r0.id));
            r8.put("anchor_id", r0.getOwnerUserIdString());
        L24:
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_quality_unit_click", r8, new Object[0]);
            return;
        L14:
            if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L27;
            DialogLancet.handleBlockedDialogShow(r6);
            goto L18
        L27:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
        L17:
            DialogLancet.beforeDialogShow(r6);
            r6.show();
            DialogLancet.afterDialogShow(r6);
            goto L18
        L5:
            if (((Boolean) ci.a.getValue()).booleanValue() == true) goto L10;
            AnchorPerfMonitorWidget r9 = this.a;
            if (r9.O == true) goto L10;
            AnchorPerfMonitorDialog r1 = new AnchorPerfMonitorDialog(((Widget) this.a).context);
            AnchorPerfMonitorWidget r2 = this.a;
            r1.c = r2.h;
            r1.b = r2.g;
            r1.a = r2.f;
            DataCenter r3 = ((Widget) r2).dataCenter;
            List<String> r4 = r2.p;
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r1.d = r4;
            List<CharSequence> r10 = this.a.q;
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            r1.e = r10;
            AnchorPerfMonitorWidget r12 = this.a;
            r1.f = r12.a;
            r1.g = r12.w;
            Unit r13 = Unit.INSTANCE;
            r9.r = r1;
        L10:
            AnchorPerfMonitorWidget r14 = this.a;
            AnchorPerfMonitorDialogNew r15 = new AnchorPerfMonitorDialogNew(((Widget) this.a).context);
            AnchorPerfMonitorWidget r16 = this.a;
            r15.c = r16.h;
            r15.j = r16.V0;
            r15.b = r16.g;
            r15.a = r16.f;
            r15.e = ((Widget) r16).dataCenter;
            List<String> r17 = r16.p;
            Intrinsics.checkNotNullParameter(r17, "<set-?>");
            r15.f = r17;
            List<CharSequence> r18 = this.a.q;
            Intrinsics.checkNotNullParameter(r18, "<set-?>");
            r15.g = r18;
            AnchorPerfMonitorWidget r19 = this.a;
            r15.h = r19.a;
            r15.i = r19.w;
            r15.d = r19.j;
            Unit r20 = Unit.INSTANCE;
            r14.r = r15;
            goto L11
        }
    }

    public static final class g extends Handler {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        @Override // android.os.Handler
        public final void handleMessage(Message r18) {
            Intrinsics.checkNotNullParameter(r18, Constants.OperatorKey.MSG);
            super.handleMessage(r18);
            int r1 = r18.what;
            if (r1 == 1) goto L55;
            if (r1 == 2) goto L54;
            if (r1 == 3) goto L27;
            if (r1 != 4) goto L99;
            AnchorPerfMonitorWidget r2 = this.a;
            int r3 = AnchorPerfMonitorWidget.b1;
            r2.getClass();
            IPerformanceManager r4 = jc1.k.f(IPerformanceManager.class);
            if (r4 == null) goto L24;
            int r5 = r4.getNetQuality();
            if (r5 < r2.t.b()) goto L15;
            r2.V.a = 1;
        L23:
            r2.Fq(r2.V.a);
            goto L24
        L15:
            if (r5 < r2.t.c()) goto L18;
            r2.V.a = 2;
            goto L23
        L18:
            if (r5 < r2.t.d()) goto L20;
            r2.V.a = 3;
            goto L23
        L20:
            if (r5 < (-1)) goto L22;
            r2.V.a = 2;
            goto L23
        L22:
            r2.V.a = 4;
        L24:
            AnchorPerfMonitorWidget r6 = this.a;
            if (r6.R == true) goto L95;
            sendEmptyMessageDelayed(4, ((long) r6.t.j()) * 1000);
            return;
        L95:
            return;
        L99:
            return;
        L27:
            AnchorPerfMonitorWidget r7 = this.a;
            int r8 = AnchorPerfMonitorWidget.b1;
            r7.getClass();
            IPerformanceManager r9 = jc1.k.f(IPerformanceManager.class);
            if (r9 == null) goto L53;
            float r10 = r9.getTemperature();
            if (r10 > r7.t.h()) goto L33;
            r7.J = -1;
        L37:
            if (r10 > r7.t.i()) goto L39;
            r7.K = -1;
        L42:
            r7.U.b = String.valueOf(r10) + "";
            r7.U.a = 1;
            if (r7.K <= 0) goto L48;
            if ((System.currentTimeMillis() - r7.K) < (r7.t.g() * WebcastRedirectException.UNKNOWN)) goto L48;
            r7.U.a = 3;
        L52:
            r7.Gq(r7.U);
        L48:
            if (r7.J <= 0) goto L52;
            if ((System.currentTimeMillis() - r7.J) < (r7.t.g() * WebcastRedirectException.UNKNOWN)) goto L52;
            r7.U.a = 2;
            goto L52
        L39:
            if (r7.K > 0) goto L42;
            r7.K = System.currentTimeMillis();
            goto L42
        L33:
            if (r7.J > 0) goto L37;
            r7.J = System.currentTimeMillis();
        L53:
            sendEmptyMessageDelayed(3, ((long) this.a.t.j()) * 1000);
            return;
        L54:
            AnchorPerfMonitorWidget r12 = this.a;
            r12.Eq(r12.T);
            return;
        L55:
            AnchorPerfMonitorWidget r13 = this.a;
            int r14 = AnchorPerfMonitorWidget.b1;
            r13.getClass();
            IPerformanceManager r15 = jc1.k.f(IPerformanceManager.class);
            if (r15 == null) goto L93;
            float r16 = r15.getTemperature();
            if (r16 > r13.t.h()) goto L61;
            r13.J = -1;
        L65:
            if (r16 > r13.t.i()) goto L67;
            r13.K = -1;
        L70:
            r13.U.b = String.valueOf(r16) + "";
            r13.U.a = 1;
            if (r13.K <= 0) goto L76;
            if ((System.currentTimeMillis() - r13.K) < (r13.t.g() * WebcastRedirectException.UNKNOWN)) goto L76;
            r13.U.a = 3;
        L80:
            r13.Gq(r13.U);
            int r17 = r15.getNetQuality();
            if (r17 < r13.t.b()) goto L84;
            r13.V.a = 1;
        L92:
            r13.Fq(r13.V.a);
            goto L93
        L84:
            if (r17 < r13.t.c()) goto L87;
            r13.V.a = 2;
            goto L92
        L87:
            if (r17 < r13.t.d()) goto L89;
            r13.V.a = 3;
            goto L92
        L89:
            if (r17 < (-1)) goto L91;
            r13.V.a = 2;
            goto L92
        L91:
            r13.V.a = 4;
        L76:
            if (r13.J <= 0) goto L80;
            if ((System.currentTimeMillis() - r13.J) < (r13.t.g() * WebcastRedirectException.UNKNOWN)) goto L80;
            r13.U.a = 2;
            goto L80
        L67:
            if (r13.K > 0) goto L70;
            r13.K = System.currentTimeMillis();
            goto L70
        L61:
            if (r13.J > 0) goto L65;
            r13.J = System.currentTimeMillis();
        L93:
            sendEmptyMessageDelayed(1, ((long) this.a.t.j()) * 1000);
        }

        public g(AnchorPerfMonitorWidget r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        public h(AnchorPerfMonitorWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnchorPerfMonitorWidget.zq(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        public i(AnchorPerfMonitorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            h1 r5 = (h1) r4;
            Intrinsics.checkNotNullParameter(r5, "liveEvent");
            if (r5.a != 31) goto L8;
            g r6 = this.a.Y;
            if (r6 == null) goto L9;
            r6.postDelayed(new t(this), 5000);
            return;
        L9:
            return;
        }
    }

    public static final class j implements IFetchModelListener {
        public j() {
        }

        public final void onFailed(Exception r1) {
            if (r1 == null) goto L5;
            r1.printStackTrace();
            return;
        }

        public final void onSuccess(String[] r1) {
            if (r1 == null) goto L5;
            r1.toString();
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        public k(AnchorPerfMonitorWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            View r0 = this.a.e;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r3.booleanValue() == false) goto L7;
            int r4 = 2131252913;
        L8:
            r0.setBackground(s1.m(r4));
            return;
        L7:
            r4 = 2131252911;
            goto L8
        }
    }

    public static final class l extends Handler {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, Constants.OperatorKey.MSG);
            super.handleMessage(r2);
            int r3 = r2.what;
            if (r3 != 2) goto L5;
            nz.f r4 = (nz.f) this.a.W.getValue();
            if (r4 == null) goto L37;
            int r0 = this.a.f;
            r4.e();
            return;
        L37:
            return;
        L5:
            if (r3 != 3) goto L7;
            nz.f r5 = (nz.f) this.a.W.getValue();
            if (r5 == null) goto L35;
            int r1 = this.a.g;
            r5.c();
            return;
        L35:
            return;
        L7:
            if (r3 != 4) goto L9;
            nz.f r6 = (nz.f) this.a.W.getValue();
            if (r6 == null) goto L33;
            int r7 = this.a.i;
            r6.d();
            return;
        L33:
            return;
        L9:
            if (r3 != 6) goto L11;
            nz.f r8 = (nz.f) this.a.W.getValue();
            if (r8 == null) goto L31;
            r8.b();
            return;
        L31:
            return;
        L11:
            if (r3 != 7) goto L38;
            nz.f r9 = (nz.f) this.a.W.getValue();
            if (r9 == null) goto L29;
            r9.b();
            return;
        L29:
            return;
        }

        public l(AnchorPerfMonitorWidget r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class m implements Action {
        public final /* synthetic */ AnchorPerfMonitorWidget a;

        public m(AnchorPerfMonitorWidget r1) {
            this.a = r1;
        }

        public final void run() {
            if (this.a.H.compareAndSet(0, 1) == false) goto L6;
            jc1.k.n(IHostAction.class).showInnerPush(1);
            return;
        }
    }

    static {
    }

    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(new Class[]{zg1.m0.class, zg1.e.class, zg1.c.class});
    }

    public final int getLayoutId() {
        return 2131568002;
    }

    public final String getSpm() {
        return "a100.a100.a233";
    }

    public final int supportClearScene() {
        return DefaultConfig.MAX_CACHE_ENTRIES;
    }

    public final void Cq() {
        k21 r0 = s81.a.a;
        if (this.T.a != 5) goto L5;
        boolean r1 = true;
    L7:
        if (t81.a.b(((Widget) this).context) == false) goto L9;
        Boolean r2 = Boolean.FALSE;
    L10:
        boolean r3 = r2.booleanValue();
        String r4 = this.T.b;
        long r5 = System.currentTimeMillis() / ((long) WebcastRedirectException.UNKNOWN);
        StringBuilder r6 = new StringBuilder("can record = ");
        r6.append(s81.a.f);
        r6.append(", audioDb = ");
        r6.append(r4);
        r6.append(", volumeList = ");
        s81.a.C0315a r7 = s81.a.e;
        if (r7 == null) goto L13;
        List<String> r8 = r7.c;
    L14:
        r6.append(r8);
        ALogger.i("DataCollector", r6.toString());
        if (s81.a.f == false) goto L26;
        s81.a.C0315a r9 = s81.a.e;
        if (r9 == null) goto L21;
        List r10 = r9.c;
        if (r10 == null) goto L21;
    L22:
        if (r4 == null) goto L24;
        r10.add(r4);
    L24:
        s81.a.e = new s81.a.C0315a(Boolean.valueOf(r1), Boolean.valueOf(r3), r10, Long.valueOf(r5));
        return;
    L21:
        r10 = new ArrayList();
        goto L22
    L26:
        return;
    L13:
        r8 = null;
        goto L14
    L9:
        r2 = Boolean.valueOf(t81.a.a.isMusicActive());
        goto L10
    L5:
        r1 = false;
        goto L7
    }

    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r1 = RoomContext.a.c(r0, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.i r2 = r1.getLiveMode();
        if (r2 == null) goto L7;
        LiveMode r3 = (LiveMode) r2.getValue();
    L9:
        if (r3 != LiveMode.SCREEN_RECORD) goto L15;
        RoomContext r4 = RoomContext.a.c(r0, null, 0, 3);
        if (r4 == null) goto L21;
        com.bytedance.live.datacontext.n r5 = r4.getLiveStreamGame();
        if (r5 != null) goto L23;
        return null;
    L23:
        return (com.bytedance.android.live.pushstream.d) r5.getValue();
    L21:
        return null;
    L15:
        RoomContext r6 = RoomContext.a.c(r0, null, 0, 3);
        if (r6 == null) goto L24;
        com.bytedance.live.datacontext.j r7 = r6.getLiveStream();
        if (r7 != null) goto L20;
        return null;
    L20:
        return (com.bytedance.android.live.pushstream.d) r7.getValue();
    L24:
        return null;
    L7:
        r3 = null;
        goto L9
    }

    public final void onDestroy() {
        if (this.u.a() == false) goto L17;
        Context r0 = ((Widget) this).context;
        AnchorPerfMonitorWidget$usbReceiver$1 r2 = this.H0;
        Intrinsics.checkNotNullParameter(r2, "usbReceiver");
        if (r0 == null) goto L17;
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L81;
        r0.unregisterReceiver(r2);
        goto L17
    L81:
    L12:
        e = move-exception;
        if (r2 == null) goto L15;
        Npth.addTag("unregisterReceiver", r2.toString());
    L15:
        e.printStackTrace();
        goto L17
    L9:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r0) == false) goto L17;
        r0.unregisterReceiver(r2);     // Catch: Exception -> L12
    L17:
        super.onDestroy();
        CompletableJob r1 = this.X;
        LiveMode r3 = null;
        if (r1 == null) goto L20;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L20:
        g r4 = this.Y;
        if (r4 == null) goto L23;
        r4.removeCallbacksAndMessages(null);
    L23:
        this.Z.removeCallbacksAndMessages(null);
        this.k0.removeCallbacksAndMessages(null);
        this.m.dispose();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("voice_status_mute", String.valueOf(this.D.get()));
        r5.put("voice_status_voice_unusual", String.valueOf(this.B.get()));
        r5.put("network_status_normal", String.valueOf(this.x.get()));
        r5.put("network_status_wave", String.valueOf(this.y.get()));
        r5.put("network_status_bad", String.valueOf(this.z.get()));
        r5.put("network_status_no_network", String.valueOf(this.A.get()));
        r5.put("temperature_status_normal", String.valueOf(this.E.get()));
        r5.put("temperature_status_device_heat", String.valueOf(this.F.get()));
        r5.put("temperature_status_device_over_heat", String.valueOf(this.G.get()));
        View r6 = ((Widget) this).contentView;
        if (r6 != null) goto L26;
    L28:
        String r7 = DataType.FALSE;
    L29:
        r5.put("is_hard_acc_enabled", r7);
        Room r8 = this.a;
        if (r8 == null) goto L32;
        r5.put("room_id", String.valueOf(r8.id));
        r5.put("anchor_id", r8.getOwnerUserIdString());
    L32:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_quality_unit_show", r5, new Object[0]);
        CommonBottomDialog r9 = this.r;
        if (r9 == null) goto L51;
        Handler r10 = DialogLancet.resolveDialogHandler(r9);
        if (r10 != null) goto L37;
    L39:
        DialogLancet.beforeDialogDismiss(r9);
        r9.dismiss();     // Catch: Throwable -> L42 Exception -> L44
    L48:
        DialogLancet.afterDialogDismiss(r9);
        goto L51
    L42:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r9);
        throw th;
    L44:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L42
        Throwable r12 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L42
        if (r12 == null) goto L48;
        com.bytedance.crash.d.d(r12, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L42
        goto L48
    L37:
        if (Looper.myLooper() == r10.getLooper()) goto L39;
        r10.post(DialogLancet.createDismissRunnable(r9));
    L51:
        Disposable r13 = this.Q;
        if (r13 != null) goto L54;
    L58:
        s81.a.a();
        s81.a.b(false);
        s81.a.e = null;
        s81.a.c = null;
        CompositeDisposable r14 = s81.a.d;
        if (r14 == null) goto L67;
        if (r14.isDisposed() != true) goto L67;
        CompositeDisposable r15 = s81.a.d;
        if (r15 == null) goto L65;
        r15.dispose();
    L65:
        s81.a.d = null;
    L67:
        if (this.S == null) goto L84;
        RoomContext r16 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r16 == null) goto L74;
        com.bytedance.live.datacontext.i r17 = r16.getLiveMode();
        if (r17 == null) goto L74;
        r3 = (LiveMode) r17.getValue();
    L74:
        if (r3 == LiveMode.SCREEN_RECORD) goto L76;
        return;
    L76:
        if (((Boolean) aq0.a.getValue()).booleanValue() == false) goto L86;
        Lazy r18 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().b(this.S);
        return;
    L86:
        return;
    L84:
        return;
    L54:
        if (r13.isDisposed() == true) goto L58;
        Disposable r19 = this.Q;
        if (r19 == null) goto L58;
        r19.dispose();
        goto L58
    L26:
        if (r6.isHardwareAccelerated() != true) goto L28;
        r7 = DataType.TRUE;
        goto L29
    }

    public final void onUnload() {
        r81.b r0 = r81.b.b;
        jc1.a.b().unregisterComponentCallbacks(r0);
        r81.b.a = null;
    }

    /* JADX WARN: Type inference failed for: r1v30, types: [com.bytedance.android.live.room.discovery.AnchorPerfMonitorWidget$usbReceiver$1] */
    public AnchorPerfMonitorWidget() {
        this.f = 1;
        this.g = 1;
        this.m = new CompositeDisposable();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.s = new SimpleDateFormat("MM.dd HH:mm:ss", Locale.CHINA);
        com.bytedance.android.livesdk.chatroom.model.a r1 = (com.bytedance.android.livesdk.chatroom.model.a) ta.a.getValue();
        this.t = r1;
        this.u = (ms1.g) bi.a.getValue();
        this.v = r1.e();
        if (r1.a() <= 0) goto L5;
        boolean r2 = true;
    L6:
        this.w = r2;
        this.x = new AtomicInteger(0);
        this.y = new AtomicInteger(0);
        this.z = new AtomicInteger(0);
        this.A = new AtomicInteger(0);
        this.B = new AtomicInteger(0);
        this.C = new AtomicInteger(0);
        this.D = new AtomicInteger(0);
        this.E = new AtomicInteger(0);
        this.F = new AtomicInteger(0);
        this.G = new AtomicInteger(0);
        this.H = new AtomicInteger(0);
        this.I = new LinkedHashMap();
        this.J = -1;
        this.K = -1;
        this.S = new b(this);
        this.T = new com.bytedance.android.livesdk.performance.r(0);
        this.U = new com.bytedance.android.livesdk.performance.r(1);
        this.V = new com.bytedance.android.livesdk.performance.r(2);
        this.W = LazyKt.lazy(new AnchorPerfMonitorWidget$iAnchorPerfMonitor$2(this));
        this.Z = new c(this, Looper.getMainLooper());
        this.k0 = new l(this, Looper.getMainLooper());
        this.H0 = new AnchorPerfMonitorWidget$usbReceiver$1(this);
        this.L0 = new d(this);
        this.P0 = ((Boolean) p9.a.getValue()).booleanValue();
        this.V0 = true;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public static final void xq(AnchorPerfMonitorWidget r12) {
        r12.getClass();
        ALogger.d("AnchorVolumnOptiTAG", "isAccessibilityOn:" + r12.N + ", isAudioFocusEverLose:" + r12.L + ", isCurLevelMicOccupied:" + r12.M);
        kjc.c r0 = new kjc.c();
        if (7 != kjc.a.a()) goto L20;
        kjc.b r2 = r0.a;
        if (r12.P == false) goto L11;
        ALogger.d("AnchorVolumnOptiTAG", "refreshOptiMicStatus-occupied");
        IAnchorPerMonitorDialog r3 = r12.r;
        if (r3 == null) goto L9;
        r3.M0(9, r12.V0);
    L9:
        r12.M = true;
    L18:
        r2.a = Unit.INSTANCE;
        r0.b = true;
        goto L20
    L11:
        if (r12.M == false) goto L15;
        ALogger.d("AnchorVolumnOptiTAG", "refreshOptiMicStatus-occupied-to-normal");
        r12.M = false;
        IAnchorPerMonitorDialog r4 = r12.r;
        if (r4 == null) goto L18;
        r4.M0(r12.h, r12.V0);
        goto L18
    L15:
        ALogger.d("AnchorVolumnOptiTAG", "refreshOptiMicStatus-normal");
        IAnchorPerMonitorDialog r5 = r12.r;
        if (r5 == null) goto L18;
        r5.M0(r12.h, r12.V0);
    L20:
        if (r0.b == true) goto L41;
        kjc.b r6 = r0.a;
        if (r12.L == false) goto L30;
        if (r12.N == true) goto L30;
        ALogger.d("AnchorVolumnOptiTAG", "refreshOptiMicStatus-occupied");
        IAnchorPerMonitorDialog r1 = r12.r;
        if (r1 == null) goto L28;
        r1.M0(9, r12.V0);
    L28:
        r12.M = true;
    L40:
        r6.a = Unit.INSTANCE;
    L30:
        if (r12.M == true) goto L32;
        ALogger.d("AnchorVolumnOptiTAG", "refreshOptiMicStatus-normal");
        IAnchorPerMonitorDialog r7 = r12.r;
        if (r7 == null) goto L40;
        r7.M0(r12.h, r12.V0);
        goto L40
    L32:
        if (r12.N == false) goto L36;
        ALogger.d("AnchorVolumnOptiTAG", "refreshOptiMicStatus-occupied-to-normal");
        r12.M = false;
        IAnchorPerMonitorDialog r8 = r12.r;
        if (r8 == null) goto L40;
        r8.M0(r12.h, r12.V0);
        goto L40
    L36:
        ALogger.d("AnchorVolumnOptiTAG", "refreshOptiMicStatus-occupied-on");
    L41:
        Object r13 = r0.a.a;
    }

    public static final void zq(AnchorPerfMonitorWidget r4) {
        if (r4.w == false) goto L32;
        com.bytedance.android.live.pushstream.d r0 = r4.getLiveStream();
        if (r0 == null) goto L9;
        r0.n1(r4.t.a());
    L9:
        if (((Boolean) dh.a.getValue()).booleanValue() == false) goto L24;
        com.bytedance.android.live.pushstream.d r1 = r4.getLiveStream();
        if (r1 != null) goto L13;
    L17:
        ILiveExternalCameraServiceForOther r2 = jc1.k.f(ILiveExternalCameraServiceForOther.class);
        if (r2 == null) goto L24;
        if (r2.isConnected() != true) goto L24;
        r4.T.getClass();
        r4.T.a = 5;
        g r3 = r4.Y;
        if (r3 == null) goto L24;
        r3.sendEmptyMessage(2);
        goto L24
    L13:
        if (r1.t0() != true) goto L17;
        r4.T.getClass();
        r4.T.a = 5;
        g r5 = r4.Y;
        if (r5 == null) goto L17;
        r5.sendEmptyMessage(2);
    L24:
        com.bytedance.android.live.pushstream.d r6 = r4.getLiveStream();
        if (r6 == null) goto L30;
        uf2.d0 r7 = r6.A();
        if (r7 == null) goto L31;
        r7.j0();
        return;
    L31:
        return;
    L30:
        return;
    }

    public final void Aq(String r8) {
        String r0 = this.s.format(new Date());
        ListProtector.add(this.p, 0, r0 + ' ' + r8);
        if (((ArrayList) this.p).size() <= this.v) goto L5;
        List<String> r1 = this.p;
        ListProtector.remove(r1, ((ArrayList) r1).size() - 1);
    L5:
        SpannableStringBuilder r2 = new SpannableStringBuilder(r0);
        r2.setSpan(new ForegroundColorSpan(s1.h(2131107021)), 0, r0.length(), 33);
        r2.append(" " + r8);
        r2.setSpan(new ForegroundColorSpan(s1.h(2131107027)), r0.length(), r2.length(), 33);
        r2.setSpan(new AbsoluteSizeSpan(14, true), 0, r2.length(), 33);
        ListProtector.add(this.q, 0, r2);
        if (((ArrayList) this.q).size() <= this.v) goto L8;
        List<CharSequence> r9 = this.q;
        ListProtector.remove(r9, ((ArrayList) r9).size() - 1);
    L8:
        this.Z.sendEmptyMessage(1);
        this.k0.sendEmptyMessage(1);
    }

    public final void Eq(com.bytedance.android.livesdk.performance.r r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.h != r10.a) goto L5;
        return;
    L5:
        ILiveExternalCameraServiceForOther r0 = jc1.k.f(ILiveExternalCameraServiceForOther.class);
        boolean r1 = true;
        if (r0 == null) goto L11;
        if (r0.isConnected() != true) goto L11;
        this.T.getClass();
        this.T.a = 5;
    L11:
        switch(r10.a) {
            case 0: goto L86;
            case 1: goto L83;
            case 2: goto L80;
            case 3: goto L77;
            case 4: goto L74;
            case 5: goto L52;
            case 6: goto L49;
            case 7: goto L16;
            case 8: goto L13;
            default: goto L90;
        };
    L13:
        ImageView r2 = this.b;
        if (r2 == null) goto L90;
        UtilityKotlinExtentionsKt.t(r2);
        goto L90
    L16:
        ImageView r3 = this.b;
        if (r3 == null) goto L19;
        Bq(r3, 2131251225);
    L19:
        Aq("无声音输出");
        if (((Boolean) rh.a.getValue()).booleanValue() == false) goto L42;
        if (this.V0 == true) goto L42;
        if (this.C.incrementAndGet() != 1) goto L42;
        RoomContext.a r4 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r4, ((Widget) this).dataCenter, 0, 2);
        LiveMode r7 = null;
        if (r5 == null) goto L30;
        com.bytedance.live.datacontext.i r6 = r5.getLiveMode();
        if (r6 == null) goto L30;
        LiveMode r8 = (LiveMode) r6.getValue();
    L32:
        if (r8 == LiveMode.VIDEO) goto L40;
        RoomContext r9 = RoomContext.a.c(r4, ((Widget) this).dataCenter, 0, 2);
        if (r9 == null) goto L39;
        com.bytedance.live.datacontext.i r12 = r9.getLiveMode();
        if (r12 == null) goto L39;
        r7 = (LiveMode) r12.getValue();
    L39:
        if (r7 != LiveMode.AUDIO) goto L42;
    L40:
        jc1.k.n(IHostAction.class).showInnerPush(8);
    L30:
        r8 = null;
    L42:
        if (this.B.incrementAndGet() != 1) goto L90;
        if (this.O == false) goto L48;
        jc1.k.n(IHostAction.class).showInnerPush(11);
        if (com.bytedance.android.livesdk.utils.s.a(((Widget) this).context) == true) goto L90;
        xs2.b.a().post(new e1());
        goto L90
    L48:
        jc1.k.n(IHostAction.class).showInnerPush(0);
        goto L90
    L49:
        ImageView r13 = this.b;
        if (r13 == null) goto L90;
        Bq(r13, 2131251224);
        goto L90
    L52:
        ILinkServiceExternal r14 = jc1.k.f(ILinkServiceExternal.class);
        if (r14 == null) goto L57;
        lc0.d r15 = r14.getPkService();
        if (r15 == null) goto L57;
        long r16 = r15.A();
    L59:
        if (r16 > 0) goto L62;
        r1 = false;
    L62:
        ImageView r17 = this.b;
        if (r17 == null) goto L68;
        if (r1 == false) goto L66;
        int r18 = 2131251231;
    L67:
        Bq(r17, r18);
        goto L68
    L66:
        r18 = 2131251229;
    L68:
        if (r1 == false) goto L70;
        int r19 = 2131911542;
    L71:
        Aq(s1.B(r19));
        this.D.incrementAndGet();
        ImageView r20 = this.b;
        if (r20 == null) goto L90;
        UtilityKotlinExtentionsKt.w(r20);
        goto L90
    L70:
        r19 = 2131911541;
    L57:
        r16 = 0;
        goto L59
    L74:
        ImageView r22 = this.b;
        if (r22 == null) goto L90;
        Bq(r22, 2131251223);
        goto L90
    L77:
        ImageView r23 = this.b;
        if (r23 == null) goto L90;
        Bq(r23, 2131251222);
        goto L90
    L80:
        ImageView r24 = this.b;
        if (r24 == null) goto L90;
        Bq(r24, 2131251221);
        goto L90
    L83:
        ImageView r25 = this.b;
        if (r25 == null) goto L90;
        Bq(r25, 2131251220);
        goto L90
    L86:
        ImageView r26 = this.b;
        if (r26 == null) goto L90;
        Bq(r26, 2131251219);
    L90:
        if (this.h <= 4) goto L92;
    L93:
        this.i = r10.a;
        this.Z.sendEmptyMessage(4);
        this.k0.sendEmptyMessage(4);
    L94:
        int r110 = r10.a;
        this.h = r110;
        DataCenter r27 = ((Widget) this).dataCenter;
        if (r27 == null) goto L98;
        r27.put("data_cmd_mic_status", Integer.valueOf(r110));
        return;
    L98:
        return;
    L92:
        if (r10.a <= 4) goto L94;
        goto L93
    }

    public final void Fq(int r6) {
        if (this.g != r6) goto L6;
        return;
    L6:
        if (r6 != 1) goto L8;
        ImageView r0 = this.d;
        if (r0 == null) goto L30;
        Bq(r0, 2131251267);
    L30:
        this.x.incrementAndGet();
    L31:
        this.g = r6;
        this.Z.sendEmptyMessage(3);
        this.k0.sendEmptyMessage(3);
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L35;
        r7.put("data_cmd_net_status", Integer.valueOf(this.g));
        return;
    L35:
        return;
    L8:
        if (r6 == 2) goto L23;
        if (r6 != 3) goto L11;
        ImageView r1 = this.d;
        if (r1 == null) goto L22;
        Bq(r1, 2131251271);
    L22:
        Aq("Wi-Fi/移动网络不佳");
        this.z.incrementAndGet();
        goto L31
    L11:
        if (r6 != 4) goto L31;
        ImageView r3 = this.d;
        if (r3 == null) goto L16;
        Bq(r3, 2131251265);
    L16:
        Aq("当前未连接网络");
        if (this.A.incrementAndGet() != 1) goto L31;
        jc1.k.n(IHostAction.class).showInnerPush(2);
        goto L31
    L23:
        ImageView r2 = this.d;
        if (r2 == null) goto L26;
        Bq(r2, 2131251269);
    L26:
        Aq("Wi-Fi/移动网络波动");
        this.y.incrementAndGet();
        goto L31
    }

    public final void Gq(com.bytedance.android.livesdk.performance.r r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.f != r6.a) goto L5;
        return;
    L5:
        Disposable r0 = this.n;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        int r1 = r6.a;
        if (r1 != 1) goto L11;
        ImageView r2 = this.c;
        if (r2 == null) goto L28;
        Bq(r2, 2131251545);
    L28:
        this.E.incrementAndGet();
    L29:
        this.f = r6.a;
        this.Z.sendEmptyMessage(2);
        this.k0.sendEmptyMessage(2);
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L33;
        r7.put("data_cmd_temp_status", Integer.valueOf(this.f));
        return;
    L33:
        return;
    L11:
        if (r1 != 2) goto L13;
        ImageView r3 = this.c;
        if (r3 == null) goto L24;
        Bq(r3, 2131251546);
    L24:
        Aq("设备发热明显，温度" + r6.b + "°C");
        this.F.incrementAndGet();
        goto L29
    L13:
        if (r1 != 3) goto L29;
        ImageView r4 = this.c;
        if (r4 == null) goto L18;
        Bq(r4, 2131251544);
    L18:
        Aq("设备发热严重，温度" + r6.b + "°C");
        this.G.incrementAndGet();
        if (this.H.get() != 0) goto L29;
        long r5 = ((long) this.t.f()) * 1000;
        Disposable r8 = RxUtilKt.d(r5, r5).ignoreElements().subscribe(new m(this));
        this.m.add(r8);
        Unit r9 = Unit.INSTANCE;
        this.n = r8;
        goto L29
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L42;
        String r0 = r7.getKey();
        int r1 = r0.hashCode();
        int r2 = 0;
        if (r1 == (-738124344)) goto L23;
        if (r1 == 1060055221) goto L10;
        return;
    L10:
        if (r0.equals("data_keyboard_status") == false) goto L43;
        Boolean r3 = Boolean.TRUE;
        Boolean r8 = (Boolean) r7.getData(r3);
        if (r8 == null) goto L15;
        r3 = r8;
    L15:
        boolean r9 = r3.booleanValue();
        this.k = r9;
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L44;
        if (r9 == false) goto L19;
    L20:
        r2 = 8;
    L21:
        r4.setVisibility(r2);
        return;
    L19:
        if (this.l == false) goto L21;
    L44:
        return;
    L43:
        return;
    L23:
        if (r0.equals("cmd_official_inspector") == false) goto L46;
        com.bytedance.android.live.room.discovery.inspector.a r10 = (com.bytedance.android.live.room.discovery.inspector.a) r7.getData();
        if (r10 == null) goto L51;
        int r12 = r10.getType();
        if (r12 != 0) goto L30;
        this.l = true;
        View r13 = ((Widget) this).contentView;
        if (r13 == null) goto L49;
        r13.setVisibility(8);
        return;
    L49:
        return;
    L30:
        if (r12 != 2) goto L52;
        this.l = false;
        View r14 = ((Widget) this).contentView;
        if (r14 != null) goto L35;
        return;
    L35:
        if (this.k == false) goto L37;
        r2 = 8;
    L37:
        r14.setVisibility(r2);
        return;
    L52:
        return;
    L51:
        return;
    L46:
        return;
    }

    public final void onEnterClear(int r2) {
        if (r2 != 256) goto L6;
        UtilityKotlinExtentionsKt.t(((Widget) this).contentView);
        return;
    }

    public void onEvent(o70.b r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if ((r4 instanceof zg1.m0) == false) goto L9;
        boolean r5 = ((zg1.m0) r4).a;
        View r0 = ((Widget) this).contentView;
        if (r5 == false) goto L7;
        float r6 = 0.0f;
    L8:
        r0.setAlpha(r6);
        return;
    L7:
        r6 = 1.0f;
        goto L8
    L9:
        int r1 = 8;
        if ((r4 instanceof zg1.e) == false) goto L19;
        if (this.w == false) goto L15;
        return;
    L15:
        if (((zg1.e) r4).a == false) goto L17;
        r1 = 5;
    L17:
        Eq(new com.bytedance.android.livesdk.performance.r(r1));
        return;
    L19:
        if ((r4 instanceof zg1.c) == true) goto L21;
        return;
    L21:
        if (((zg1.c) r4).a == false) goto L23;
        r1 = 5;
    L23:
        Eq(new com.bytedance.android.livesdk.performance.r(r1));
    }

    public final void onExitClear(int r2) {
        if (r2 != 256) goto L6;
        UtilityKotlinExtentionsKt.w(((Widget) this).contentView);
        return;
    }

    public final void onInit(Object[] r12) {
        ALogger.d("AnchorVolumnOptiTAG", "onInit");
        this.b = (ImageView) findViewById(2131380044);
        this.c = (ImageView) findViewById(2131388305);
        this.d = (ImageView) findViewById(2131380666);
        this.e = findViewById(2131384840);
        ImageView r0 = this.b;
        if (r0 != null) goto L5;
    L9:
        ImageView r1 = this.b;
        if (r1 == null) goto L12;
        Bq(r1, 2131251219);
    L12:
        ImageView r2 = this.c;
        if (r2 == null) goto L15;
        Bq(r2, 2131251545);
    L15:
        ImageView r3 = this.d;
        if (r3 == null) goto L18;
        Bq(r3, 2131251267);
    L18:
        r3.c(((Widget) this).contentView, "性能状态", true);
        LiveMode r4 = null;
        if (this.u.a() == false) goto L28;
        SoundCardModeManager r5 = SoundCardModeManager.c;
        Context r6 = ((Widget) this).context;
        AnchorPerfMonitorWidget$usbReceiver$1 r7 = this.H0;
        Intrinsics.checkNotNullParameter(r7, "usbReceiver");
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        r8.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        if (r6 != null) goto L130;
    L26:
        SoundCardModeManager.c();
        ((NextLiveData) SoundCardModeManager.b.getValue()).observe(this, new e(this));
        this.X = JobKt.Job$default(null, 1, null);
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        CompletableJob r10 = this.X;
        Intrinsics.checkNotNull(r10);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r9.plus(r10)), null, null, new AnchorPerfMonitorWidget$onInit$$inlined$apply$lambda$2(r5, null, this), 3, null);
        goto L28
    L130:
        wq(r6, r7, r8);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ALogger.e("AnchorPerfMonitorWidget", "register usb Receiver fail " + e);
    L28:
        if (((Boolean) lq0.a.getValue()).booleanValue() == false) goto L48;
        StringBuilder r13 = new StringBuilder("RoomContext.getShared(dataCenter)?.liveMode?.value:");
        RoomContext.a r14 = RoomContext.Companion;
        RoomContext r15 = RoomContext.a.c(r14, ((Widget) this).dataCenter, 0, 2);
        if (r15 == null) goto L36;
        com.bytedance.live.datacontext.i r16 = r15.getLiveMode();
        if (r16 == null) goto L36;
        LiveMode r17 = (LiveMode) r16.getValue();
        if (r17 == null) goto L36;
        String r18 = r17.getSceneName();
    L37:
        r13.append(r18);
        ALogger.d("AnchorVolumnOptiTAG", r13.toString());
        RoomContext r19 = RoomContext.a.c(r14, ((Widget) this).dataCenter, 0, 2);
        if (r19 == null) goto L42;
        com.bytedance.live.datacontext.i r110 = r19.getLiveMode();
        if (r110 == null) goto L42;
        LiveMode r111 = (LiveMode) r110.getValue();
    L44:
        if (r111 != LiveMode.SCREEN_RECORD) goto L46;
        boolean r112 = true;
    L47:
        this.O = r112;
        goto L48
    L46:
        r112 = false;
    L42:
        r111 = null;
    L36:
        r18 = null;
    L48:
        View r113 = ((Widget) this).contentView;
        if (r113 == null) goto L51;
        r113.setOnClickListener(new f(this));
    L51:
        Ref.ObjectRef r114 = new Ref.ObjectRef();
        r114.element = Looper.getMainLooper();
        this.Y = new g(this, (Looper) r114.element);
        RoomContext.a r115 = RoomContext.Companion;
        RoomContext r20 = RoomContext.a.c(r115, ((Widget) this).dataCenter, 0, 2);
        if (r20 == null) goto L56;
        com.bytedance.live.datacontext.i r22 = r20.getLiveMode();
        if (r22 == null) goto L56;
        LiveMode r23 = (LiveMode) r22.getValue();
    L57:
        LiveMode r24 = LiveMode.SCREEN_RECORD;
        if (r23 == r24) goto L60;
    L67:
        g r25 = this.Y;
        if (r25 == null) goto L70;
        r25.sendEmptyMessageDelayed(1, 5000);
    L70:
        g r26 = this.Y;
        if (r26 == null) goto L73;
        r26.postDelayed(new h(this), 5000);
    L73:
        RoomContext r116 = RoomContext.a.c(r115, ((Widget) this).dataCenter, 0, 2);
        if (r116 == null) goto L78;
        com.bytedance.live.datacontext.i r117 = r116.getLiveMode();
        if (r117 == null) goto L78;
        r4 = (LiveMode) r117.getValue();
    L78:
        if (r4 != r24) goto L81;
        this.m.add(xs2.b.a().b(h1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this)));
    L81:
        if (com.bytedance.android.livesdk.utils.p.a() == true) goto L84;
        this.m.add(xs2.b.a().b(q3.class).subscribe(new o(this)));
    L84:
        if (this.O == false) goto L86;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.m.add(xs2.b.a().b(c1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new p(this)));
        this.m.add(xs2.b.a().b(b1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this)));
        this.m.add(xs2.b.a().b(d1.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this)));
    L86:
        this.m.add(xs2.b.a().b(b61.a.class).subscribe(new s(this)));
        this.m.add(xs2.b.a().b(o1.class).subscribe(n.a));
        this.p0 = false;
        if (((Boolean) ci.a.getValue()).booleanValue() == false) goto L89;
    L132:
    L94:
        e = move-exception;
        e.printStackTrace();
    L97:
        if (com.bytedance.android.livesdk.config.setting.b.a() == true) goto L105;
        RoomContext r118 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r118 == null) goto L105;
        com.bytedance.live.datacontext.m r119 = r118.isAnchorStableMode();
        if (r119 == null) goto L105;
        Observable r120 = r119.a();
        if (r120 == null) goto L105;
        r120.subscribe(new k(this));
    L105:
        Disposable r121 = this.Q;
        if (r121 != null) goto L108;
    L112:
        k21 r122 = s81.a.a;
        Context r123 = ((Widget) this).context;
        k21 r27 = (k21) tm.a.getValue();
        s81.a.a = r27;
        if (r27.a() == true) goto L115;
        ALogger.i("DataCollector", "data collector is disabled");
    L127:
        if (s81.a.a.a() == false) goto L136;
        Cq();
        this.Q = Observable.timer(s81.a.a.e(), TimeUnit.SECONDS).repeat().observeOn(AndroidSchedulers.mainThread()).subscribe(new w(this));
        return;
    L136:
        return;
    L115:
        s81.a.d = new CompositeDisposable();
        s81.a.c = new WeakReference(r123);
        s81.a.b = MSManagerUtils.get(String.valueOf(jc1.k.n(IHostContext.class).appId()));
        JSONObject r124 = new JSONObject();
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L118
        r124.put("rep_interval", s81.a.a.b() * WebcastRedirectException.UNKNOWN);     // Catch: Throwable -> L118
        r124.put("tes_interval", s81.a.a.d() * WebcastRedirectException.UNKNOWN);     // Catch: Throwable -> L118
        r124.put("tes_duration", s81.a.a.c() * WebcastRedirectException.UNKNOWN);     // Catch: Throwable -> L118
        Result.constructor-impl(r124);     // Catch: Throwable -> L118
    L120:
        HashMap r29 = new HashMap();
        r29.put("live_conf", r124.toString());
        MSManager r125 = s81.a.b;
        if (r125 == null) goto L123;
        r125.setCustomInfo(r29, true);
    L123:
        s81.a.b(true);
        s81.a.f = true;
        Disposable r126 = Observable.timer(s81.a.a.b(), TimeUnit.SECONDS).repeat().observeOn(AndroidSchedulers.mainThread()).subscribe(s81.b.a, s81.c.a);
        CompositeDisposable r30 = s81.a.d;
        if (r30 == null) goto L127;
        r30.add(r126);
    L118:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L120
    L108:
        if (r121.isDisposed() == true) goto L112;
        Disposable r127 = this.Q;
        if (r127 == null) goto L112;
        r127.dispose();
        goto L112
    L91:
        if (DownloadableModelSupport.isInitialized() == false) goto L97;
        DownloadableModelSupport.getInstance().fetchResourcesNeededByRequirements(new String[]{"liveBaseModels"}, new j());     // Catch: Exception -> L94
        goto L97
    L89:
        if (this.O == false) goto L105;
    L60:
        if (((Boolean) aq0.a.getValue()).booleanValue() == false) goto L67;
        if (this.S == null) goto L64;
        Lazy r33 = HostAppMonitorService.c;
        HostAppMonitorService.a.a().a(this.S);
    L64:
        g r34 = this.Y;
        if (r34 == null) goto L70;
        r34.sendEmptyMessageDelayed(3, 5000);
    L56:
        r23 = null;
        goto L57
    L5:
        if (this.w == false) goto L7;
        int r35 = 0;
    L8:
        r0.setVisibility(r35);
        goto L9
    L7:
        r35 = 8;
        goto L8
    }

    public final void onLoad(Object[] r12) {
        ALogger.d("AnchorVolumnOptiTAG", "onLoad");
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L5;
        r13.observe("data_keyboard_status", this);
    L5:
        DataCenter r14 = ((Widget) this).dataCenter;
        if (r14 == null) goto L8;
        r14.observe("cmd_official_inspector", this);
    L8:
        DataCenter r15 = ((Widget) this).dataCenter;
        LiveMode r0 = null;
        if (r15 == null) goto L11;
        Room r16 = (Room) r15.get("data_room", null);
    L12:
        this.a = r16;
        ci r17 = ci.a;
        if (((Boolean) r17.getValue()).booleanValue() == true) goto L67;
        if (this.O == true) goto L67;
        boolean r6 = false;
        if (((Boolean) wh.a.getValue()).booleanValue() == true) goto L19;
    L43:
        boolean r1 = false;
    L44:
        iq0 r7 = iq0.a;
        if (((y71) r7.getValue()).b() == true) goto L47;
    L63:
        if (r1 == true) goto L65;
        if (r6 == false) goto L67;
    L65:
        r81.b r2 = r81.b.b;
        d r8 = this.L0;
        Intrinsics.checkNotNullParameter(r8, "callback");
        jc1.a.b().registerComponentCallbacks(r2);
        r81.b.a = new WeakReference(r8);
        goto L67
    L47:
        if (((y71) r7.getValue()).a() == false) goto L63;
        RoomContext.a r9 = RoomContext.Companion;
        RoomContext r10 = RoomContext.a.c(r9, ((Widget) this).dataCenter, 0, 2);
        if (r10 == null) goto L53;
        com.bytedance.live.datacontext.i r18 = r10.getLiveMode();
        if (r18 == null) goto L53;
        LiveMode r19 = (LiveMode) r18.getValue();
    L55:
        if (r19 != LiveMode.SCREEN_RECORD) goto L63;
        RoomContext r20 = RoomContext.a.c(r9, ((Widget) this).dataCenter, 0, 2);
        if (r20 == null) goto L63;
        com.bytedance.live.datacontext.i r22 = r20.isAnchor();
        if (r22 == null) goto L63;
        if (((Boolean) r22.getValue()).booleanValue() != true) goto L63;
        r6 = true;
    L53:
        r19 = null;
        goto L55
    L19:
        if (((Boolean) vh.a.getValue()).booleanValue() == false) goto L43;
        RoomContext.a r3 = RoomContext.Companion;
        RoomContext r23 = RoomContext.a.c(r3, ((Widget) this).dataCenter, 0, 2);
        if (r23 == null) goto L25;
        com.bytedance.live.datacontext.i r24 = r23.getLiveMode();
        if (r24 == null) goto L25;
        LiveMode r25 = (LiveMode) r24.getValue();
    L27:
        if (r25 == LiveMode.VIDEO) goto L36;
        RoomContext r26 = RoomContext.a.c(r3, ((Widget) this).dataCenter, 0, 2);
        if (r26 == null) goto L33;
        com.bytedance.live.datacontext.i r27 = r26.getLiveMode();
        if (r27 == null) goto L33;
        LiveMode r28 = (LiveMode) r27.getValue();
    L35:
        if (r28 != LiveMode.MEDIA) goto L43;
    L33:
        r28 = null;
    L36:
        RoomContext r4 = RoomContext.a.c(r3, ((Widget) this).dataCenter, 0, 2);
        if (r4 == null) goto L43;
        com.bytedance.live.datacontext.i r5 = r4.isAnchor();
        if (r5 == null) goto L43;
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L43;
        r1 = true;
    L25:
        r25 = null;
    L67:
        if (((Boolean) r17.getValue()).booleanValue() == false) goto L69;
    L70:
        RoomContext r110 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r110 == null) goto L78;
        com.bytedance.live.datacontext.j r111 = r110.getAnchorStableViewModel();
        if (r111 == null) goto L78;
        nz.n r112 = (nz.n) r111.getValue();
        if (r112 == null) goto L78;
        int r29 = AnchorStableModeConfig.a;
        AnchorStableModeConfig.a(((Widget) this).dataCenter, new AnchorPerfMonitorWidget$onLoad$$inlined$let$lambda$1(this));
        r112.c();
    L78:
        if (((Boolean) rh.a.getValue()).booleanValue() == false) goto L111;
        RoomContext.a r113 = RoomContext.Companion;
        RoomContext r30 = RoomContext.a.c(r113, ((Widget) this).dataCenter, 0, 2);
        if (r30 == null) goto L84;
        com.bytedance.live.datacontext.i r32 = r30.getLiveMode();
        if (r32 == null) goto L84;
        LiveMode r33 = (LiveMode) r32.getValue();
    L86:
        if (r33 == LiveMode.VIDEO) goto L95;
        RoomContext r34 = RoomContext.a.c(r113, ((Widget) this).dataCenter, 0, 2);
        if (r34 == null) goto L93;
        com.bytedance.live.datacontext.i r35 = r34.getLiveMode();
        if (r35 == null) goto L93;
        r0 = (LiveMode) r35.getValue();
    L93:
        if (r0 == LiveMode.MEDIA) goto L95;
        return;
    L95:
        if (this.P0 == true) goto L97;
        return;
    L97:
        if (Build.VERSION.SDK_INT <= 28) goto L114;
        this.V0 = true;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r36 = ILiveWrappedLivePusher.a.b();
        if (r36 == null) goto L101;
        r36.newAudioDeviceModuleAudioFocusChangedCallBack(new v());
    L101:
        RoomContext r114 = RoomContext.a.c(r113, ((Widget) this).dataCenter, 0, 2);
        if (r114 == null) goto L115;
        com.bytedance.live.datacontext.j r115 = r114.getLiveStream();
        if (r115 == null) goto L116;
        com.bytedance.android.live.pushstream.d r116 = (com.bytedance.android.live.pushstream.d) r115.getValue();
        if (r116 == null) goto L117;
        uf2.d0 r117 = r116.A();
        if (r117 == null) goto L118;
        r117.h();
        return;
    L118:
        return;
    L117:
        return;
    L116:
        return;
    L115:
        return;
    L114:
        return;
    L84:
        r33 = null;
        goto L86
    L111:
        return;
    L69:
        if (this.O == false) goto L78;
    L11:
        r16 = null;
        goto L12
    }

    public static final void yq(AnchorPerfMonitorWidget r2, String r3) {
        if (((Widget) r2).context == null) goto L20;
        Disposable r0 = r2.o;
        if (r0 != null) goto L8;
    L12:
        SharedPreferences r4 = SoundCardModeManager.a;
        SoundCardModeManager.c();
        UsbManager r5 = UsbDeviceUtils.a;
        if (UsbDeviceUtils.a() == false) goto L18;
        IHostAction r6 = jc1.k.f(IHostAction.class);
        if (r6 == null) goto L19;
        com.bytedance.android.live.base.model.push.b r1 = new com.bytedance.android.live.base.model.push.b();
        r1.setTitle(s1.B(2131911566));
        r1.setButtonText(s1.B(2131911567));
        Unit r7 = Unit.INSTANCE;
        r6.showInnerPush(12, r1, new u(r3));
        return;
    L19:
        return;
    L18:
        return;
    L8:
        if (r0.isDisposed() == true) goto L12;
        Disposable r8 = r2.o;
        if (r8 == null) goto L12;
        r8.dispose();
        goto L12
    }

    public final void Bq(ImageView r4, int r5) {
    L7:
        th = move-exception;
        if (this.p0 == true) goto L14;
        SafetyGuard.a(null, th, "anchor apm load image error");
        this.p0 = true;
        return;
    L14:
        return;
    L3:
        if (this.I.containsKey(Integer.valueOf(r5)) == true) goto L5;
        this.I.put(Integer.valueOf(r5), BitmapFactory.decodeResource(r4.getResources(), r5));     // Catch: Throwable -> L7
    L5:
        Map<Integer, Bitmap> r0 = this.I;     // Catch: Throwable -> L7
        LinkedHashMap r1 = (LinkedHashMap) r0;     // Catch: Throwable -> L7
        r4.setImageBitmap((Bitmap) r1.get(Integer.valueOf(r5)));     // Catch: Throwable -> L7
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void wq(Context r8, AnchorPerfMonitorWidget$usbReceiver$1 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
