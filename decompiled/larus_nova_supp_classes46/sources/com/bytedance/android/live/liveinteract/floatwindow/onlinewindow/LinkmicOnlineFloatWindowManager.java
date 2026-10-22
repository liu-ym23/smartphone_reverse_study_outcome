package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.anchormodelink.model.LinkerUserState;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.message.b1;
import com.bytedance.android.live.base.model.message.o0;
import com.bytedance.android.live.base.model.message.p2;
import com.bytedance.android.live.base.model.message.s2;
import com.bytedance.android.live.base.model.message.x2;
import com.bytedance.android.live.base.model.message.x5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.core.u;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSVideoWidget;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSVoiceWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.chatroom.model.g1;
import com.bytedance.android.livesdk.chatroom.model.interact.OrderSingItemAction;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.f1;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomStateChangeReason;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.LinkmicOrderSingMessageType;
import com.bytedance.android.livesdk.message.model.da;
import com.bytedance.android.livesdk.message.model.de;
import com.bytedance.android.livesdk.message.model.t8;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerKickOutContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.floatview.FloatWindowConfig;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowManager;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import com.bytedance.android.livesdkapi.floatview.InnerFloatViewTAG;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfigKt;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.multilink.api.LinkSecurityApi;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.revenue.platform.api.core.rx.p;
import com.larus.apm.impl.protector.RunnableProtector;
import gd0.x;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.z;
import zf2.s0;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkmicOnlineFloatWindowManager implements vlc.l, ye0.c, IInnerFloatWindowManager, IInnerFloatWindowSceneInterceptor, xe0.h.a, u, com.bytedance.android.live.liveinteract.plantform.core.k, ii6.a, xe0.a.InterfaceC0292a, com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b {
    public static final String Y = null;
    public static final b Z = null;
    public static final Lazy k0 = null;
    public final ConcurrentHashMap<String, yb6.j> A;
    public RTSVideoWidget B;
    public RTSVoiceWidget C;
    public final List<ch0.h> D;
    public ch0.g E;
    public x5 F;
    public com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.a G;
    public final List<IVideoFloatManager.VideoFloatManagerListener> H;
    public long I;
    public int J;
    public int K;
    public String L;
    public String M;
    public String N;
    public HashMap<String, String> O;
    public Disposable P;
    public Disposable Q;
    public Disposable R;
    public Disposable S;
    public CompositeDisposable T;
    public boolean U;
    public final long V;
    public long W;
    public final CompositeDisposable X;
    public vlc.d a;
    public xe0.h b;
    public xe0.a c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final HashMap<String, Boolean> k;
    public DataCenter l;
    public IRoom m;
    public tc0.c n;
    public final List<ILinkPlayerInfoBridge> o;
    public ILinkPlayerInfoBridge p;
    public v0 q;
    public x r;
    public hg6.g s;
    public dn0.c t;
    public we0.b u;
    public final Handler v;
    public jg6.a w;
    public hg6.g x;
    public m00.h y;
    public com.bytedance.android.live.pushstream.d z;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ILinkPlayerInfoBridge) r1).getUserPosition()), Integer.valueOf(((ILinkPlayerInfoBridge) r2).getUserPosition()));
        }
    }

    public static final class b extends com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.e {
        public b() {
        }
    }

    public static final class c {
        public static LinkmicOnlineFloatWindowManager a() {
            return (LinkmicOnlineFloatWindowManager) LinkmicOnlineFloatWindowManager.k0.getValue();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LinkmicOnlineFloatWindowManager a;
        public final /* synthetic */ String b;

        public d(LinkmicOnlineFloatWindowManager r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            this.a.getClass();
            rx1.g r0 = LinkmicOnlineFloatWindowManager.m();
            View r1 = null;
            if (r0 == null) goto L7;
            rx1.f r2 = r0.a;
            if (r2 == null) goto L7;
            View r3 = r2.c;
        L9:
            if ((r3 instanceof com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) == false) goto L12;
            r1 = r3;
        L12:
            com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b r4 = (com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) r1;
            if (r4 == null) goto L29;
            int r5 = (int) (((long) 5) - r10.longValue());
            String r6 = this.b;
            Intrinsics.checkNotNullParameter(r6, "hint");
            if (r5 != 5) goto L22;
            TextView r7 = r4.l;
            if (r7 == null) goto L19;
            r7.setVisibility(8);
        L19:
            ViewGroup r8 = r4.h;
            if (r8 == null) goto L22;
            r8.setVisibility(0);
        L22:
            TextView r11 = r4.i;
            if (r11 == null) goto L25;
            r11.setText(r6);
        L25:
            TextView r12 = r4.j;
            if (r12 == null) goto L29;
            r12.setText(s1.C(2131917611, new Object[]{Integer.valueOf(r5)}));
        L29:
            if (((int) r10.longValue()) != 5) goto L32;
            IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 2, null);
            this.a.l();
            return;
        L32:
            return;
        L7:
            r3 = null;
            goto L9
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public final /* synthetic */ LinkmicOnlineFloatWindowManager a;

        public e(LinkmicOnlineFloatWindowManager r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r9, int r10) {
            LinkmicOnlineFloatWindowManager r11 = this.a;
            r11.N = "manual";
            r11.u();
            this.a.n("small_window_close");
            IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 6, null);
            r9.dismiss();
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LinkmicOnlineFloatWindowManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public g(LinkmicOnlineFloatWindowManager r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            this.a.getClass();
            rx1.g r0 = LinkmicOnlineFloatWindowManager.m();
            View r1 = null;
            if (r0 == null) goto L7;
            rx1.f r2 = r0.a;
            if (r2 == null) goto L7;
            View r3 = r2.c;
        L9:
            if ((r3 instanceof com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) == false) goto L12;
            r1 = r3;
        L12:
            com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b r4 = (com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) r1;
            if (r4 == null) goto L38;
            int r5 = (int) (((long) 5) - r10.longValue());
            String r6 = this.b;
            int r7 = this.c;
            Intrinsics.checkNotNullParameter(r6, "tips");
            if (r5 != 5) goto L28;
            r4.p.b();
            ViewGroup r8 = r4.d;
            if (r8 == null) goto L19;
            r8.setVisibility(0);
        L19:
            RecyclerView r11 = r4.c;
            if (r11 == null) goto L22;
            r11.setVisibility(8);
        L22:
            TextView r12 = r4.l;
            if (r12 == null) goto L25;
            r12.setVisibility(8);
        L25:
            ViewGroup r13 = r4.g;
            if (r13 == null) goto L28;
            r13.setVisibility(8);
        L28:
            TextView r14 = r4.e;
            if (r14 == null) goto L31;
            r14.setText(r6);
        L31:
            TextView r15 = r4.e;
            if (r15 == null) goto L34;
            r15.setTextSize(r7);
        L34:
            TextView r16 = r4.f;
            if (r16 == null) goto L38;
            r16.setText(s1.C(2131917597, new Object[]{Integer.valueOf(r5)}));
        L38:
            if (((int) r10.longValue()) != 5) goto L41;
            this.a.n("small_window_close");
            this.a.u();
            IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 6, null);
            return;
        L41:
            return;
        L7:
            r3 = null;
            goto L9
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ LinkmicOnlineFloatWindowManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public h(LinkmicOnlineFloatWindowManager r1, long r2) {
            this.a = r1;
            this.b = "small_window_close";
            this.c = r2;
        }

        public final void accept(Object r6) {
            com.bytedance.android.live.network.response.e r7 = (com.bytedance.android.live.network.response.e) r6;
            InteractLinkFullLinkMonitor.x(this.b, System.currentTimeMillis() - this.c, r7.logId);
            IRoom r0 = this.a.m;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isLiveTypeAudio() == false) goto L7;
            return;
        L7:
            if (je0.d.A() == false) goto L12;
            we0.b r1 = this.a.u;
            r1.I = (g1) r7.data;
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

        public i(long r2) {
            this.a = "small_window_close";
            this.b = r2;
        }

        public final void accept(Object r6) {
            String r0 = this.a;
            long r1 = System.currentTimeMillis() - this.b;
            InteractLinkFullLinkMonitor.w(r0, r1, (Throwable) r6);
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ LinkmicOnlineFloatWindowManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Exception d;

        public j(LinkmicOnlineFloatWindowManager r1, int r2, long r3, Exception r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.b != (-3)) goto L9;
            this.a.f0(this.c, this.d);     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ LinkmicOnlineFloatWindowManager a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object[] c;

        public k(LinkmicOnlineFloatWindowManager r1, int r2, Object[] r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            int r0 = this.b;
            if (r0 != 9) goto L5;
            Object r1 = this.c[0];
            if (r1 == null) goto L76;
            Object[] r2 = (Object[]) r1;
            LinkmicOnlineFloatWindowManager r3 = this.a;
            Object r4 = r2[0];
            Object r5 = null;
            if ((r4 instanceof String[]) == true) goto L66;
            r4 = null;
        L66:
            String[] r6 = (String[]) r4;
            Object r7 = r2[1];
            if ((r7 instanceof boolean[]) == true) goto L69;
            r7 = null;
        L69:
            boolean[] r8 = (boolean[]) r7;
            Object r9 = r2[2];
            if ((r9 instanceof int[]) == false) goto L73;
            r5 = r9;
        L73:
            r3.J(r6, r8, (int[]) r5);
            return;
        L76:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        L5:
            if (r0 != 202) goto L7;
            Object r10 = this.c[0];
            if (r10 == null) goto L60;
            Object[] r11 = (Object[]) r10;
            RTSVideoWidget r12 = this.a.B;
            if (r12 == null) goto L48;
            Object r13 = r11[0];
            if (r13 == null) goto L47;
            String r14 = (String) r13;
            Object r15 = r11[1];
            if (r15 == null) goto L45;
            String r16 = (String) r15;
            Intrinsics.checkNotNullParameter(r14, "from");
            Intrinsics.checkNotNullParameter(r16, MultiLinkOpenSource.MESSAGE);
            ((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) r12.a.getValue()).a(r14, r16);
            goto L48
        L45:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L47:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L48:
            RTSVoiceWidget r17 = this.a.C;
            if (r17 == null) goto L79;
            Object r18 = r11[0];
            if (r18 == null) goto L58;
            String r19 = (String) r18;
            Object r20 = r11[1];
            if (r20 == null) goto L56;
            String r21 = (String) r20;
            Intrinsics.checkNotNullParameter(r19, "from");
            Intrinsics.checkNotNullParameter(r21, MultiLinkOpenSource.MESSAGE);
            ((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) r17.a.getValue()).a(r19, r21);
            return;
        L56:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L58:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L79:
            return;
        L60:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
        L7:
            if (r0 != 204) goto L81;
            Object r22 = this.c[0];
            if (r22 == null) goto L34;
            Object[] r23 = (Object[]) r22;
            RTSVideoWidget r24 = this.a.B;
            if (r24 == null) goto L22;
            Object r25 = r23[0];
            if (r25 == null) goto L21;
            String r26 = (String) r25;
            Object r27 = r23[1];
            if (r27 == null) goto L19;
            String r28 = (String) r27;
            Intrinsics.checkNotNullParameter(r26, "from");
            Intrinsics.checkNotNullParameter(r28, MultiLinkOpenSource.MESSAGE);
            ((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) r24.a.getValue()).J3(r26, r28);
            goto L22
        L19:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L21:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L22:
            RTSVoiceWidget r29 = this.a.C;
            if (r29 == null) goto L77;
            Object r30 = r23[0];
            if (r30 == null) goto L32;
            String r31 = (String) r30;
            Object r32 = r23[1];
            if (r32 == null) goto L30;
            String r33 = (String) r32;
            Intrinsics.checkNotNullParameter(r31, "from");
            Intrinsics.checkNotNullParameter(r33, MultiLinkOpenSource.MESSAGE);
            ((com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a) r29.a.getValue()).J3(r31, r33);
            return;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L32:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L77:
            return;
        L34:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any>");
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

    public static final class l<T> implements Consumer {
        public final /* synthetic */ LinkmicOnlineFloatWindowManager a;

        public l(LinkmicOnlineFloatWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.w();
        }
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void D1(String r1, ByteBuffer r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void L0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void Lb() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void M1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.u
    public final void Qc() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void R(long r1, Exception r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S(String r1, int r2, int r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void T6(String r1, s0 r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void V4(String r1, z.a r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Xi(int r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void al(String r1, int r2) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void b4(String r1, z.a r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void ci() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f1(long r1, long r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f4() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h6(int r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void ip(Object r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void j0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void k1() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.u
    public final void l8() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o() {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void o0(long r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.t
    public final void p2(fi6.a r1) {
    }

    public final void reset() {
        this.d = false;
        this.f = false;
        this.g = false;
        this.h = false;
        if (Z.a == true) goto L5;
        this.i = false;
    L5:
        this.I = 0;
        this.M = "popup";
        this.N = "auto";
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wf(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wk(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void z7() {
    }

    static {
        Y = InnerFloatViewTAG.TAG_LINKMIC_ONLINE_FLOAT.getTag();
        Z = new b();
        k0 = LazyKt.lazy(LinkmicOnlineFloatWindowManager$Companion$instance$2.INSTANCE);
    }

    public static rx1.g m() {
        return rx1.l.a(Y);
    }

    @Override // xe0.a.InterfaceC0292a
    public final void Y2() {
        jg6.a r0 = this.w;
        if (r0 == null) goto L8;
        kg6.e r1 = r0.b();
        if (r1 == null) goto L9;
        r1.t(new kg6.b(false, true, "live end", 8));
        return;
    L9:
        return;
    }

    @Override // ye0.c
    public final void b() {
        ILinkPlayerInfoBridge r0 = this.p;
        boolean r1 = false;
        if (r0 == null) goto L5;
        int r2 = r0.getSilenceStatus();
    L6:
        if (r2 <= 0) goto L8;
        r1 = true;
    L8:
        HashMap r3 = new HashMap();
        r3.put("is_link_reserve", "1");
        if (r1 == false) goto L11;
        String r4 = "off";
    L12:
        r3.put("mic_status", r4);
        r3.put("is_auto_play", m2.b(this.j));
        boolean r5 = xe0.k.a;
        xe0.k.b(this.J, this.K, this.L, r3);
        StringBuilder r6 = new StringBuilder("call logOnFinishShow, roomId = ");
        IRoom r7 = this.m;
        if (r7 == null) goto L15;
        Long r8 = Long.valueOf(r7.getRoomId());
    L16:
        r6.append(r8);
        t(r6.toString());
        return;
    L15:
        r8 = null;
        goto L16
    L11:
        r4 = "on";
        goto L12
    L5:
        r2 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.a.b
    public final void c() {
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        boolean r1 = vm2.j.a();
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.S(1, "kick_out_self_by_rts", r1, null);
        t("call onKickOutSelfByRTS");
        if (vm2.j.a() == false) goto L6;
        k(this, null, null, 3);
        return;
    }

    @Override // ye0.c
    public final void close() {
        Activity r0 = jc1.k.n(IMiddlewareHostApp.class).getCurrentActivity();
        if (r0 == null) goto L6;
        x0.b r1 = new x0.b(r0, 4);
        r1.l(2131917761);
        r1.i(0, 2131917580, new e(this));
        r1.i(1, 2131915442, f.a);
        r1.n();
        return;
    }

    public final void i() {
        this.v.removeCallbacksAndMessages(null);
        this.s = null;
        this.t = null;
        this.q = null;
        this.r = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.w = null;
    }

    public final void l() {
        if (Z.a == false) goto L5;
        return;
    L5:
        Activity r0 = jc1.k.n(IMiddlewareHostApp.class).getTopActivity();
        if (r0 == null) goto L34;
        IRoom r3 = this.m;
        if (r3 == null) goto L34;
        String r4 = r3.getRequestId();
        String r5 = "";
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        String r6 = r3.getLog_pb();
        if (r6 == null) goto L16;
        r5 = r6;
    L16:
        JSONObject r7 = new JSONObject();
        r7.put("is_link_reserve", "1");
        r7.put("trigger_scene", "connection");
        r7.put("initial_page", "content");
        r7.put("return_windows_type", "in");
        r7.put("is_mini_auto_play", m2.b(this.j));
        String r8 = r7.toString();
        StringBuilder r9 = new StringBuilder("sslocal://webcast_room?room_id=");
        r9.append(r3.getRoomId());
        r9.append("&user_id=");
        r9.append(r3.getOwnerUserIdString());
        r9.append("&request_id=");
        r9.append(r4);
        r9.append("&log_pb=");
        r9.append(r5);
        r9.append("&enter_from_merge=");
        HashMap<String, String> r10 = this.O;
        String r11 = null;
        if (r10 == null) goto L19;
        String r12 = r10.get("enter_from_merge");
    L20:
        r9.append(r12);
        r9.append("&enter_method=");
        HashMap<String, String> r13 = this.O;
        if (r13 == null) goto L23;
        String r14 = r13.get("enter_method");
    L24:
        r9.append(r14);
        r9.append("&action_type=");
        HashMap<String, String> r15 = this.O;
        if (r15 == null) goto L27;
        r11 = r15.get("action_type");
    L27:
        r9.append(r11);
        r9.append("&link_mic_float_hint=");
        if (this.d == false) goto L30;
        String r16 = "1";
    L31:
        r9.append(r16);
        r9.append("&is_mini_window=1&extra_params=");
        r9.append(r8);
        String r17 = r9.toString();
        IMiddlewareLiveService r18 = TTLiveServiceMiddleware.getLiveService();
        if (r18 == null) goto L34;
        r18.handleSchema(r0, UriProtector.parse(r17));
        goto L34
    L30:
        r16 = "0";
        goto L31
    L23:
        r14 = null;
        goto L24
    L19:
        r12 = null;
    L34:
        HashMap r1 = new HashMap();
        r1.put("is_link_reserve", "1");
        r1.put("is_auto_play", m2.b(this.j));
        boolean r2 = xe0.k.a;
        xe0.k.f(this.J, this.K, this.L, "click", r1);
    }

    @Override // ye0.c
    public final void onClick() {
        if (this.f == false) goto L5;
        return;
    L5:
        this.i = true;
        if (((Boolean) vm2.d.j7.getValue(null, vm2.d.a[422(0x1a6, float:5.91E-43)])).booleanValue() == false) goto L27;
        IRoom r1 = this.m;
        if (r1 == null) goto L27;
        long r2 = r1.getId();
        com.bytedance.android.livesdk.sharedpref.e r3 = b6.h0;
        if (Intrinsics.areEqual((Boolean) r3.getValue(), Boolean.FALSE) == false) goto L27;
        com.bytedance.android.livesdk.sharedpref.e r4 = b6.f0;
        Long r5 = (Long) r4.getValue();
        if (r5 != null) goto L16;
    L26:
        com.bytedance.android.livesdk.sharedpref.e r6 = b6.g0;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, 1);
        com.bytedance.android.livesdk.sharedpref.f.d(r4, Long.valueOf(r2));
        goto L27
    L16:
        if (r5.longValue() != r2) goto L26;
        com.bytedance.android.livesdk.sharedpref.e r7 = b6.g0;
        Integer r8 = (Integer) r7.getValue();
        if (r8 == null) goto L24;
        if (r8.intValue() != 1) goto L24;
        this.d = true;
        com.bytedance.android.livesdk.sharedpref.f.d(r3, Boolean.TRUE);
    L24:
        if (((Number) r7.getValue()).intValue() >= 2) goto L27;
        com.bytedance.android.livesdk.sharedpref.f.d(r7, Integer.valueOf(((Integer) r7.getValue()).intValue() + 1));
    L27:
        l();
    }

    public final void u() {
        DataCenter r0 = this.l;
        if (r0 == null) goto L5;
        r0.put("cmd_interact_state_change", new a1(4));
    L5:
        hg6.g r1 = this.s;
        if (r1 == null) goto L8;
        r1.n();
    L8:
        hg6.g r2 = this.s;
        if (r2 == null) goto L11;
        r2.onDestroy();
    L11:
        v0 r3 = this.q;
        if (r3 == null) goto L14;
        r3.release();
    L14:
        hg6.g r4 = this.x;
        if (r4 == null) goto L17;
        r4.n();
    L17:
        hg6.g r5 = this.x;
        if (r5 == null) goto L20;
        r5.onDestroy();
    L20:
        com.bytedance.android.live.pushstream.d r6 = this.z;
        if (r6 == null) goto L23;
        r6.release();
    L23:
        this.A.clear();
        m00.h r7 = this.y;
        if (r7 == null) goto L26;
        r7.c();
    L26:
        i();
        tc0.c.h().k();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L31;
        DataCenter r8 = this.l;
        if (r8 == null) goto L31;
        tc0.c.i((String) r8.get("data_room_unique_id", "")).k();
    L31:
        hd0.c.f().l();
        hd0.g r9 = hd0.g.d;
        r9.getClass();
        ((ge1.a) r9).b = Integer.valueOf(LinkerUserState.None.ordinal());
    }

    public final void w() {
        if (ILiveLinkCameraBackUpConfigKt.supportAudienceCheckLinker(vm2.g.c()) == true) goto L5;
        return;
    L5:
        int r1 = LinkSecurityApi.a;
        if (v.a() == true) goto L8;
    L10:
        IRoom r2 = this.m;
        if (r2 == null) goto L13;
        boolean r3 = r2.isLiveTypeAudio();
    L14:
        IRoom r4 = this.m;
        if (r4 == null) goto L17;
        long r5 = r4.getRoomId();
    L18:
        ILinkPlayerInfoBridge r6 = this.p;
        if (r6 == null) goto L21;
        int r7 = r6.getLinkType();
    L22:
        ILinkPlayerInfoBridge r8 = this.p;
        if (r8 == null) goto L25;
        int r9 = r8.getSilenceStatus();
    L26:
        LinkSecurityApi.VideoCaptureType r10 = LinkSecurityApi.VideoCaptureType.VIDEO_CAPTURE_DEVICE_NONE;
        jg6.a r11 = this.w;
        if (r11 == null) goto L34;
        kg6.e r12 = r11.b();
        if (r12 != null) goto L31;
    L33:
        LinkSecurityApi.AudioCaptureType r13 = LinkSecurityApi.AudioCaptureType.AUDIO_CAPTURE_DEVICE_ING;
    L35:
        LinkSecurityApi.FilterReasonID r14 = LinkSecurityApi.FilterReasonID.FilterNone;
        if (r3 == false) goto L46;
        hg6.g r15 = this.x;
        if (r15 == null) goto L54;
        ei6.a r16 = r15.V0();
        if (r16 == null) goto L54;
        fi6.a r17 = r16.g();
        if (r17 == null) goto L54;
        String r18 = r17.v;
        if (r18 == null) goto L54;
    L55:
        String r19 = r18;
        TalkRoomBusinessFullLinkMonitor r20 = TalkRoomBusinessFullLinkMonitor.a;
        int r110 = r10.ordinal();
        int r111 = r13.ordinal();
        int r112 = r14.ordinal();
        r20.getClass();
        Intrinsics.checkNotNullParameter(r19, "rtcExtInfo");
        Intrinsics.checkNotNullParameter("small_window", "requestSource");
        JSONObject r21 = new JSONObject();
        r21.put("room_id_params", r5);
        r21.put("link_type_params", r7);
        r21.put("silence_status_params", r9);
        r21.put("video_capture_type_params", r110);
        r21.put("audio_capture_type_params", r111);
        r21.put("filter_reason_id_params", r112);
        r21.put("rtc_ext_info_params", r19);
        r21.put("request_source_params", "small_window");
        nd0.c.o(nd0.c.a, LinkMonitorData.LinkOnlineFloatWindowStartCheckAudienceLinkers, r21, 0, null, false, 28);
        long r113 = System.currentTimeMillis();
        long r22 = r5;
        int r23 = r7;
        int r24 = r9;
        Observable r25 = LinkSecurityApi.b(r22, r23, r24, r10.ordinal(), r13.ordinal(), r14.ordinal(), r19, "small_window");
        int r26 = p.a;
        Disposable r27 = r25.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.l(this, r113), new m(r113));
        this.X.add(r27);
    L56:
        Disposable r28 = Observable.timer(Math.max(this.W, this.V), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this));
        this.X.add(r28);
        return;
    L54:
        r18 = "";
        goto L55
    L46:
        hg6.g r29 = this.s;
        if (r29 == null) goto L54;
        ei6.a r30 = r29.V0();
        if (r30 == null) goto L54;
        fi6.a r31 = r30.g();
        if (r31 == null) goto L54;
        r18 = r31.v;
        if (r18 != null) goto L55;
    L31:
        if (r12.p() != true) goto L33;
        r13 = LinkSecurityApi.AudioCaptureType.AUDIO_CAPTURE_DEVICE_NONE;
        goto L35
    L34:
        r13 = LinkSecurityApi.AudioCaptureType.AUDIO_CAPTURE_DEVICE_UNKNOWN;
        goto L35
    L25:
        r9 = -1;
        goto L26
    L21:
        r7 = 0;
        goto L22
    L17:
        r5 = 0;
        goto L18
    L13:
        r3 = false;
        goto L14
    L8:
        if (vm2.c.h().a() == false) goto L10;
        goto L10
    }

    public LinkmicOnlineFloatWindowManager() {
        this.k = new HashMap(9);
        this.o = new ArrayList();
        this.u = new we0.b.a().a();
        this.v = new Handler(Looper.getMainLooper());
        this.A = new ConcurrentHashMap();
        this.D = new ArrayList();
        this.H = new ArrayList();
        this.L = "live";
        this.M = "popup";
        this.N = "auto";
        this.V = 5;
        this.W = 20;
        this.X = new CompositeDisposable();
    }

    public static void d() {
        rx1.g r0 = m();
        if (r0 == null) goto L8;
        rx1.f r1 = r0.a;
        if (r1 == null) goto L9;
        r1.a(s1.z() - s1.f(108), s1.f((s1.A() + 44) + 12));
        return;
    L9:
        return;
    }

    public final boolean canShow() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L6:
        if (r1 != null) goto L8;
    L15:
        return false;
    L8:
        if (xe0.j.c() == false) goto L15;
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 == null) goto L15;
        if (r2.intValue() != 2) goto L15;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean dismissWindowWhenToDesktop() {
        return IInnerFloatWindowManager.DefaultImpls.dismissWindowWhenToDesktop(this);
    }

    public final boolean floatWindowEntityExists() {
        if (m() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean floatWindowIsShowing() {
        rx1.g r0 = m();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.l != true) goto L7;
        return true;
    }

    public final void hideFloatWindow() {
        rx1.g r0 = m();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.l != true) goto L11;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.T("hideFloatWindow", 3);
        t("call hideFloatWindow");
        rx1.g r1 = m();
        if (r1 == null) goto L12;
        r1.c();
        return;
    L12:
        return;
    }

    public final boolean hideWindowWhenToDesktop() {
        return IInnerFloatWindowManager.DefaultImpls.hideWindowWhenToDesktop(this);
    }

    public final void showFloatWindow() {
        rx1.g r0 = m();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.l == true) goto L12;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.T("showFloatWindow", 2);
        t("call showFloatWindow");
        rx1.g r1 = m();
        if (r1 == null) goto L9;
        r1.e();
    L9:
        this.u = new we0.b.a().a();
        return;
    }

    public final String tag() {
        return Y;
    }

    public static void t(String r2) {
        ALogger.e("ttlive_link", "link_online_float_window, content = " + r2);
    }

    public final void B(int r4) {
        Iterator<T> r0 = this.o.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (je0.d.C((ILinkPlayerInfoBridge) r1) == false) goto L4;
    L9:
        ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r1;
        if (r2 == null) goto L12;
        r2.setSilenceStatus(r4);
    L12:
        ILinkPlayerInfoBridge r3 = this.p;
        if (r3 == null) goto L19;
        r3.setSilenceStatus(r4);
        return;
    L19:
        return;
    L8:
        r1 = null;
        goto L9
    }

    @Override // xe0.h.a
    public final void B0(long r10) {
        ILinkPlayerInfoBridge r0 = this.p;
        if (r0 == null) goto L30;
        rx1.g r1 = m();
        View r2 = null;
        if (r1 == null) goto L9;
        rx1.f r3 = r1.a;
        if (r3 == null) goto L9;
        View r4 = r3.c;
    L11:
        if ((r4 instanceof com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) == false) goto L14;
        r2 = r4;
    L14:
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b r5 = (com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) r2;
        if (r5 == null) goto L31;
        Intrinsics.checkNotNullParameter(r0, "selfLinkPlayerInfo");
        long r6 = r0.getExpectLeaveTime();
        long r7 = r0.getJoinChannelTime();
        if (r6 != 0) goto L21;
        View r11 = r5.k;
        if (r11 == null) goto L32;
        r11.setVisibility(8);
        return;
    L32:
        return;
    L21:
        long r8 = (r6 - r7) * ((long) 1000);
        if (r10 > 0) goto L26;
        View r12 = r5.k;
        if (r12 == null) goto L34;
        r12.setVisibility(8);
        return;
    L34:
        return;
    L26:
        UIUtils.updateLayout(r5.k, (int) ((((long) r5.getRootView().getWidth()) * r10) / r8), -3);
        View r13 = r5.k;
        if (r13 == null) goto L36;
        r13.setVisibility(0);
        return;
    L36:
        return;
    L31:
        return;
    L9:
        r4 = null;
        goto L11
    }

    public final void C(boolean r15) {
        if (vm2.d.e0() == true) goto L6;
        return;
    L6:
        if (this.e == true) goto L8;
        return;
    L8:
        ILinkPlayerInfoBridge r0 = this.p;
        if (r0 == null) goto L11;
        int r1 = r0.getSilenceStatus();
    L12:
        boolean r2 = tb1.d.a;
        if (NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled() == false) goto L18;
        if (r15 == false) goto L17;
        if (r1 != 0) goto L42;
        updateMultiLinkNotificationStatus(true);
        return;
    L42:
        return;
    L17:
        updateMultiLinkNotificationStatus(false);
        return;
    L18:
        long r4 = 0;
        if (r1 != 0) goto L30;
        if (r15 == false) goto L30;
        y(false, "linkFloatWindow onEnterBackground");
        B(3);
        xe0.a r16 = this.c;
        if (r16 == null) goto L45;
        String r3 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        if (r16.d == true) goto L50;
        r16.d = true;
        long r5 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.V(r3);
        CompositeDisposable r6 = r16.f;
        LinkApi r7 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r8 = r16.c;
        if (r8 == null) goto L29;
        r4 = r8.getId();
    L29:
        r6.add(r7.silence(r4, r3, r3, 1).subscribeOn(Schedulers.io()).flatMap(xe0.b.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new xe0.c(r16, r3, r5), new xe0.d(r16, r3, r5)));
        return;
    L50:
        return;
    L45:
        return;
    L30:
        if (r1 != 3) goto L47;
        if (r15 == true) goto L48;
        y(true, "linkFloatWindow onEnterForeground");
        B(0);
        xe0.a r17 = this.c;
        if (r17 == null) goto L49;
        String r9 = jc1.k.n(IMiddlewareUserService.class).user().n();
        Intrinsics.checkNotNullParameter(r9, "toUserId");
        if (r17.e == true) goto L51;
        r17.e = true;
        long r12 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.n0(r9);
        CompositeDisposable r10 = r17.f;
        LinkApi r11 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r13 = r17.c;
        if (r13 == null) goto L40;
        r4 = r13.getId();
    L40:
        r10.add(r11.unSilence(r4, r9, r9).subscribeOn(Schedulers.io()).flatMap(xe0.e.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new xe0.f(r17, r9, r12, null), new xe0.g(r17, r9, r12, null)));
        return;
    L51:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L11:
        r1 = -1;
        goto L12
    }

    @Override // xe0.a.InterfaceC0292a
    public final void D(String r2) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        if (Intrinsics.areEqual(r2, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L6;
        y(false, "silence success");
        return;
    }

    @Override // xe0.a.InterfaceC0292a
    public final void G(String r2) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        if (Intrinsics.areEqual(r2, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L6;
        y(true, "unSilence success");
        return;
    }

    public final void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.H).contains(r2) == true) goto L8;
        ((ArrayList) this.H).add(r2);
        return;
    }

    public final void e(String r6) {
        Intrinsics.checkNotNullParameter(r6, "displayContent");
        this.i = true;
        this.Q = Observable.interval(0, 1, TimeUnit.SECONDS).take(((long) 5) + 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r6));
    }

    public final void n(String r6) {
        Intrinsics.checkNotNullParameter("small_window_close", "requestSource");
        long r1 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.v("small_window_close");
        LinkApi r7 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r3 = this.m;
        if (r3 == null) goto L5;
        long r4 = r3.getId();
    L6:
        this.S = r7.leave(r4, "small_window_close").compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r1), new i(r1));
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public final void onMessage(tlc.d r12) {
        if (this.f == false) goto L5;
        return;
    L5:
        if (r12 == null) goto L243;
        t("call onMessage: msgId = " + r12.getMessageId() + ", methodType = " + r12.getIntType() + "，message = " + r12);
        Object r4 = null;
        if ((r12 instanceof z0) == false) goto L28;
        z0 r13 = (z0) r12;
        int r0 = (int) r13.getType2();
        if (r0 != 3) goto L11;
        k(this, Integer.valueOf(r13.getKickOutSource()), null, 2);
        return;
    L11:
        if (r0 != 17) goto L290;
        tc0.c r1 = tc0.c.h();
        if (r1 == null) goto L17;
        r1.r = r13.getMultiLiveCoreInfo();
        r1.m = r13.getLiveCoreExtInfo();
        r1.n = r13.getMultiRtcInfo();
        r1.k = r13.getRtcExtInfo();
    L17:
        if (this.J != r13.getValidScene()) goto L22;
        if (this.K != r13.getUiLayout()) goto L22;
        return;
    L22:
        if (r13.getValidScene() != 16) goto L24;
        e(s1.B(2131917756));
    L24:
        this.J = (int) r13.getScene();
        this.K = r13.getUiLayout();
        String r14 = r13.getFunctionType2();
        if (r14 == null) goto L244;
        this.L = r14;
        return;
    L244:
        return;
    L290:
        return;
    L28:
        boolean r5 = true;
        if ((r12 instanceof h1) == false) goto L161;
        h1 r15 = (h1) r12;
        int r2 = r15.getMType();
        if (r2 == 2) goto L155;
        if (r2 != 41) goto L35;
        com.bytedance.android.live.base.model.data.i r16 = r15.getLinkerCrossRoomUpdateContentExt();
        if (r16 == null) goto L267;
        Map r3 = r16.getLinkerContentMap();
        if (r3 == null) goto L123;
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator r7 = r3.entrySet().iterator();
    L113:
        if (r7.hasNext() == false) goto L120;
        Map.Entry r8 = (Map.Entry) r7.next();
        if (((Number) r8.getKey()).longValue() != r16.getToRoomId()) goto L117;
        boolean r9 = true;
    L118:
        if (r9 == false) goto L113;
        r6.put(r8.getKey(), r8.getValue());
        goto L113
    L117:
        r9 = false;
        goto L118
    L120:
        Map.Entry r10 = com.bytedance.android.live.core.utils.z0.a(r6);
        if (r10 == null) goto L123;
        g2 r11 = (g2) r10.getValue();
    L124:
        if (r11 == null) goto L126;
        Integer r17 = Integer.valueOf(r11.getRoomLinkSilenceStatus());
    L127:
        if (r17 != null) goto L130;
    L132:
        f2.b(2131917732, 0);
    L133:
        if (r17 != null) goto L136;
    L138:
        r5 = false;
    L139:
        if (r11 == null) goto L141;
        r4 = r11.getLinkedUsers();
    L141:
        tc0.c.h().l(r16.getLinkerContentMap());
        if (r4 == null) goto L268;
        Iterator r18 = ((Iterable) r4).iterator();
    L145:
        if (r18.hasNext() == false) goto L294;
        ILinkPlayerInfoBridge r19 = je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r18.next(), false);
        jg6.a r20 = this.w;
        if (r20 == null) goto L145;
        kg6.e r21 = r20.b();
        if (r21 == null) goto L145;
        String r22 = r19.getInteractId();
        if (r22 != null) goto L153;
        r22 = "";
    L153:
        r21.h(r22, r5, "room battle cross silence float window");
        goto L145
    L294:
        return;
    L268:
        return;
    L136:
        if (r17.intValue() != 1) goto L138;
    L130:
        if (r17.intValue() != 1) goto L132;
        f2.b(2131917729, 0);
        goto L133
    L126:
        r17 = null;
    L123:
        r11 = null;
        goto L124
    L267:
        return;
    L35:
        if (r2 != 101) goto L37;
        IRoom r23 = this.m;
        if (r23 != null) goto L103;
        return;
    L103:
        if (r23.isLiveTypeAudio() == false) goto L105;
        return;
    L105:
        if (je0.d.A() == false) goto L265;
        this.u.H = r15.getMLinkerSysKickOutContent();
        return;
    L265:
        return;
    L37:
        if (r2 == 6) goto L89;
        if (r2 == 7) goto L77;
        switch(r2) {
            case 11: goto L65;
            case 12: goto L53;
            case 13: goto L41;
            default: goto L292;
        };
    L41:
        ILinkerKickOutContent r24 = r15.getMKickOut();
        if (r24 == null) goto L44;
        Integer r25 = Integer.valueOf(r24.getKickOutSource());
    L45:
        k(this, r25, null, 2);
        IRoom r26 = this.m;
        if (r26 != null) goto L48;
        return;
    L48:
        if (r26.isLiveTypeAudio() == false) goto L50;
        return;
    L50:
        if (je0.d.A() == false) goto L249;
        this.u.G = r15.getMKickOut();
        return;
    L249:
        return;
    L44:
        r25 = null;
        goto L45
    L292:
        return;
    L53:
        if (this.f == false) goto L55;
        return;
    L55:
        if (this.g == true) goto L252;
        ILinkerUpdateUserContent r110 = r15.getMUpdateUser();
        if (r110 == null) goto L62;
        List r111 = r110.getMLinkUsers();
        if (r111 == null) goto L62;
        List<? extends ILinkPlayerInfoBridge> r112 = CollectionsKt.toList(je0.d.f0(r111, false));
        if (r112 == null) goto L62;
    L63:
        s(r112);
        return;
    L62:
        r112 = new ArrayList();
        goto L63
    L252:
        return;
    L65:
        if (this.f == false) goto L67;
        return;
    L67:
        if (this.g == true) goto L255;
        ILinkerLinkedListChangeContent r113 = r15.getMLinkedListChange();
        if (r113 == null) goto L74;
        List r114 = r113.getLinkUsers();
        if (r114 == null) goto L74;
        List<? extends ILinkPlayerInfoBridge> r115 = CollectionsKt.toList(je0.d.f0(r114, false));
        if (r115 == null) goto L74;
    L75:
        s(r115);
        return;
    L74:
        r115 = new ArrayList();
        goto L75
    L255:
        return;
    L77:
        if (this.f == false) goto L79;
        return;
    L79:
        if (this.g == true) goto L258;
        ILinkerLeaveContentBridge r116 = r15.getLeave();
        if (r116 == null) goto L86;
        List r117 = r116.getLinkUsers();
        if (r117 == null) goto L86;
        List<? extends ILinkPlayerInfoBridge> r118 = CollectionsKt.toList(je0.d.f0(r117, false));
        if (r118 == null) goto L86;
    L87:
        s(r118);
        return;
    L86:
        r118 = new ArrayList();
        goto L87
    L258:
        return;
    L89:
        if (this.f == false) goto L91;
        return;
    L91:
        if (this.g == true) goto L261;
        f1 r119 = r15.getEnter();
        if (r119 == null) goto L98;
        List r120 = r119.getLinkUsers();
        if (r120 == null) goto L98;
        List<? extends ILinkPlayerInfoBridge> r121 = CollectionsKt.toList(je0.d.f0(r120, false));
        if (r121 == null) goto L98;
    L99:
        s(r121);
        return;
    L98:
        r121 = new ArrayList();
        goto L99
    L261:
        return;
    L155:
        if (this.h == true) goto L158;
        this.h = true;
        j(s1.B(2131918008), 13);
        return;
    L158:
        if (this.f == true) goto L270;
        j(s1.B(2131918007), 15);
        return;
    L270:
        return;
    L161:
        if ((r12 instanceof o0) == false) goto L168;
        if (((o0) r12).getAction() == 3) goto L165;
        return;
    L165:
        if (this.h == true) goto L273;
        this.h = true;
        j(s1.B(2131918007), 15);
        return;
    L273:
        return;
    L168:
        if ((r12 instanceof va) == false) goto L176;
        int r122 = (int) ((va) r12).getAction();
        if (r122 != 7) goto L172;
    L174:
        this.h = true;
        j(s1.B(2131918007), 15);
        return;
    L172:
        if (r122 == 11) goto L174;
        return;
    L176:
        if ((r12 instanceof t8) == false) goto L192;
        t8 r123 = (t8) r12;
        int r27 = r123.getMessageIntType();
        t8.Companion.getClass();
        if (r27 != 3) goto L276;
        List r124 = r123.getMusicInfoList();
        if (r124 == null) goto L188;
        de.a r125 = (de.a) CollectionsKt.getOrNull(r124, 0);
        if (r125 == null) goto L188;
        KtvMusic r126 = r125.a();
        if (r126 == null) goto L188;
        if (r126.isOrderedBy(je0.d.b0()) != true) goto L188;
    L189:
        if (r5 == false) goto L277;
        e(s1.B(2131917758));
        return;
    L277:
        return;
    L188:
        r5 = false;
        goto L189
    L276:
        return;
    L192:
        if ((r12 instanceof x2) == false) goto L214;
        x2 r127 = (x2) r12;
        if (r127.getMessageType() != LinkmicOrderSingMessageType.TYPE_MESSAGE_SING_ACTION.getValue()) goto L279;
        s2 r28 = r127.getOrderSingActionContent();
        if (r28 == null) goto L200;
        IBaseUser r29 = r28.getOrderUser();
        if (r29 == null) goto L200;
        String r30 = r29.getIdString();
    L201:
        IMiddlewareUserService r31 = jc1.k.f(IMiddlewareUserService.class);
        if (r31 == null) goto L207;
        com.bytedance.android.livesdk.user.e r32 = r31.user();
        if (r32 == null) goto L207;
        r4 = r32.n();
    L207:
        if (Intrinsics.areEqual(r30, r4) == false) goto L280;
        s2 r128 = r127.getOrderSingActionContent();
        if (r128 != null) goto L211;
        return;
    L211:
        if (r128.getOrderSingItemAction() != OrderSingItemAction.ORDER_SING_START_ITEM.getValue()) goto L282;
        e(s1.B(2131917758));
        return;
    L282:
        return;
    L280:
        return;
    L200:
        r30 = null;
        goto L201
    L279:
        return;
    L214:
        if ((r12 instanceof p2) == false) goto L219;
        if (((p2) r12).getMsgType() != 1) goto L284;
        e(s1.B(2131917756));
        return;
    L284:
        return;
    L219:
        if ((r12 instanceof b1) == false) goto L224;
        if (((b1) r12).getMsgType() != 1) goto L286;
        e(s1.B(2131917756));
        return;
    L286:
        return;
    L224:
        if ((r12 instanceof da) == false) goto L288;
        da r129 = (da) r12;
        if (r129.getMsgType() != 1) goto L228;
    L229:
        e(s1.B(2131917756));
        return;
    L228:
        if (r129.getMsgType() == 4) goto L229;
        return;
    L288:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void onUserJoined(String r9) {
        Intrinsics.checkNotNullParameter(r9, "linkId");
        Intrinsics.checkNotNullParameter(r9, "s");
        List<ch0.h> r0 = this.D;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new ch0.h(r9, false, false, 1, 32));
    }

    public final void p(boolean r5) {
        if (this.i == false) goto L5;
        return;
    L5:
        ILinkPlayerInfoBridge r0 = this.p;
        boolean r1 = false;
        if (r0 == null) goto L8;
        int r2 = r0.getSilenceStatus();
    L9:
        if (r2 <= 0) goto L11;
        r1 = true;
    L11:
        HashMap r3 = new HashMap();
        String r4 = "1";
        r3.put("is_link_reserve", "1");
        if (r5 == true) goto L15;
        r4 = "0";
    L15:
        r3.put("is_auto_close", r4);
        r3.put("is_auto_play", m2.b(this.j));
        if (r1 == false) goto L18;
        String r6 = "off";
    L19:
        r3.put("mic_status", r6);
        boolean r7 = xe0.k.a;
        xe0.k.b(this.J, this.K, this.L, r3);
        StringBuilder r8 = new StringBuilder("call logOnClose, roomId = ");
        IRoom r9 = this.m;
        if (r9 == null) goto L22;
        Long r10 = Long.valueOf(r9.getRoomId());
    L23:
        r8.append(r10);
        t(r8.toString());
        return;
    L22:
        r10 = null;
        goto L23
    L18:
        r6 = "on";
        goto L19
    L8:
        r2 = 0;
        goto L9
    }

    @Override // xe0.a.InterfaceC0292a
    public final void q(int r7) {
        View r2 = null;
        if (r7 == 0) goto L24;
        if (r7 != 1) goto L6;
    L10:
        rx1.g r4 = m();
        if (r4 == null) goto L15;
        rx1.f r5 = r4.a;
        if (r5 == null) goto L15;
        View r6 = r5.c;
    L17:
        if ((r6 instanceof com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) == false) goto L20;
        r2 = r6;
    L20:
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b r3 = (com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) r2;
        if (r3 == null) goto L23;
        r3.a(true);
    L23:
        y(false, "silence message " + r7);
        f2.b(2131919412, 0);
        updateMultiLinkNotificationStatus(false);
        return;
    L15:
        r6 = null;
        goto L17
    L6:
        if (r7 == 2) goto L10;
        if (r7 == 4) goto L10;
        return;
    L24:
        rx1.g r8 = m();
        if (r8 == null) goto L29;
        rx1.f r9 = r8.a;
        if (r9 == null) goto L29;
        View r10 = r9.c;
    L31:
        if ((r10 instanceof com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) == false) goto L34;
        r2 = r10;
    L34:
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b r11 = (com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) r2;
        if (r11 == null) goto L37;
        r11.a(false);
    L37:
        y(true, "silence message " + r7);
        f2.b(2131919449, 0);
        return;
    L29:
        r10 = null;
        goto L31
    }

    public final void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((ArrayList) this.H).contains(r2) == false) goto L8;
        ((ArrayList) this.H).remove(r2);
        return;
    }

    public final void s(List<? extends ILinkPlayerInfoBridge> r9) {
        Intrinsics.checkNotNullParameter(r9, "newList");
        z(r9);
        ArrayList r0 = (ArrayList) this.o;
        r0.clear();
        r0.addAll(r9);
        if (r0.size() <= 1) goto L5;
        CollectionsKt.sortWith(r0, new a());
    L5:
        List<ILinkPlayerInfoBridge> r10 = this.o;
        rx1.g r1 = m();
        View r2 = null;
        if (r1 == null) goto L10;
        rx1.f r3 = r1.a;
        if (r3 == null) goto L10;
        View r4 = r3.c;
    L12:
        if ((r4 instanceof com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) == false) goto L15;
        r2 = r4;
    L15:
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b r5 = (com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) r2;
        if (r5 == null) goto L18;
        r5.setGuestListWithDiffUpdate(r10);
    L18:
        xe0.h r11 = this.b;
        if (r11 == null) goto L36;
        ILinkPlayerInfoBridge r6 = this.p;
        if (r6 == null) goto L36;
        if (je0.d.C(r6) == false) goto L36;
        long r7 = r6.getExpectLeaveTime();
        r11.a = r7;
        if (r7 == 0) goto L36;
        long r8 = 1000;
        long r12 = p6.b() / r8;
        long r13 = (r7 - r12) * r8;
        r11.b = r13;
        if (r13 > 0) goto L31;
        r11.b = 0;
    L31:
        Iterator<xe0.h.a> r14 = r11.d.iterator();
    L33:
        if (r14.hasNext() == false) goto L35;
        r14.next().B0(r11.b);
        goto L33
    L35:
        r11.a(false, Long.valueOf(r12));
    L36:
        RTSVideoWidget r15 = this.B;
        if (r15 == null) goto L39;
        r15.xq(this.o);
    L39:
        RTSVoiceWidget r16 = this.C;
        if (r16 == null) goto L44;
        r16.xq(this.o);
        return;
    L44:
        return;
    L10:
        r4 = null;
        goto L12
    }

    public final void updateMultiLinkNotificationStatus(boolean r2) {
        if (vm2.d.e0() == true) goto L5;
        return;
    L5:
        boolean r0 = tb1.d.a;
        if (NotificationManagerCompat.from(jc1.a.b()).areNotificationsEnabled() == false) goto L9;
        jc1.k.n(IMiddlewareRoomService.class).updateMultiLinkNotificationStatus(r2);
        return;
    }

    public final void v(x r3) {
        this.r = r3;
        if (r3 == null) goto L25;
        r3.f = this.q;
        hg6.g r0 = this.s;
        if (r0 == null) goto L7;
        r0.a0(pg6.a.a(r3), null);
    L7:
        hg6.g r4 = this.s;
        if (r4 == null) goto L10;
        r4.W(this);
    L10:
        jg6.a r5 = this.w;
        if (r5 == null) goto L15;
        lh6.b r6 = r5.a();
        if (r6 == null) goto L15;
        ng6.c.a.a(r6, true);
    L15:
        hg6.g r7 = this.s;
        if (r7 == null) goto L18;
        r7.i(false);
    L18:
        hg6.g r8 = this.s;
        if (r8 == null) goto L21;
        r8.X(2, "LinkMicOnlineFloatWindow, setRtcData");
    L21:
        hg6.g r9 = this.x;
        if (r9 == null) goto L26;
        r9.X(2, "LinkMicOnlineFloatWindow, setRtcData");
        return;
    L26:
        return;
    }

    public final void z(List<? extends ILinkPlayerInfoBridge> r3) {
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (je0.d.C((ILinkPlayerInfoBridge) r0) == false) goto L4;
    L9:
        ILinkPlayerInfoBridge r1 = (ILinkPlayerInfoBridge) r0;
        if (r1 == null) goto L16;
        this.p = r1;
        return;
    L16:
        return;
    L8:
        r0 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void A(String r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "interactId");
        Intrinsics.checkNotNullParameter(r5, "interactId");
        Iterator r0 = ((ArrayList) this.D).iterator();
    L3:
        Object r2 = null;
        String r3 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        ch0.h r4 = (ch0.h) r1;
        if (r4 == null) goto L9;
        r3 = r4.a;
    L9:
        if (TextUtils.equals(r3, r5) == false) goto L3;
        r2 = r1;
    L11:
        ch0.h r7 = (ch0.h) r2;
        if (r7 == null) goto L19;
        if (r6 == null) goto L20;
        r7.c = r6.booleanValue();
        return;
    L20:
        return;
    }

    @Override // xe0.a.InterfaceC0292a
    public final void F(String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        rx1.g r5 = m();
        Context r0 = null;
        if (r5 == null) goto L7;
        rx1.f r6 = r5.a;
        if (r6 == null) goto L7;
        View r7 = r6.c;
    L9:
        if ((r7 instanceof com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) == true) goto L11;
        r7 = null;
    L11:
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b r8 = (com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) r7;
        if (r8 == null) goto L14;
        r0 = r8.getContext();
    L14:
        ExceptionUtils.handleException(r0, r4, 2131919335);
        return;
    L7:
        r7 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J3(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        com.bytedance.android.live.liveinteract.plantform.core.g.a(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void S1(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.c(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Z4(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void d5(dg2.e r2, dg2.e[] r3) {
        Intrinsics.checkNotNullParameter(r2, "localQuality");
        Intrinsics.checkNotNullParameter(r3, "remoteQualities");
        com.bytedance.android.live.liveinteract.plantform.core.g.d(r2, r3);
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void e1(String r1, long r2) {
        Iterator r3 = ((ArrayList) this.D).iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        ch0.h r4 = (ch0.h) r3.next();
        if (r4 == null) goto L8;
        String r5 = r4.a;
    L10:
        if (TextUtils.equals(r5, r1) == false) goto L4;
        r3.remove();
        goto L4
    L8:
        r5 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f0(long r4, Exception r6) {
        if (r4 != LiveWrappedRoomStateChangeReason.KICKED_OUT.value()) goto L8;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        boolean r2 = vm2.j.a();
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.S((int) r4, "kick_out_by_open_api", r2, r6);
        ALogger.e("ttlive_link", "link_online_float_window, handleRTCOpenApiKickOutEvent, code = " + r4 + ", exception = " + r6);
        if (vm2.j.a() == false) goto L9;
        dismissFloatWindow(0, "kick_out_by_open_api", true);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void g(String r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "interactId");
        Intrinsics.checkNotNullParameter(r5, "interactId");
        Iterator r0 = ((ArrayList) this.D).iterator();
    L3:
        Object r2 = null;
        String r3 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        ch0.h r4 = (ch0.h) r1;
        if (r4 == null) goto L9;
        r3 = r4.a;
    L9:
        if (TextUtils.equals(r3, r5) == false) goto L3;
        r2 = r1;
    L11:
        ch0.h r7 = (ch0.h) r2;
        if (r7 == null) goto L19;
        if (r6 == null) goto L20;
        r7.d = r6.booleanValue();
        return;
    L20:
        return;
    }

    public final void j(String r6, int r7) {
        this.J = 0;
        this.f = true;
        this.P = Observable.interval(0, 1, TimeUnit.SECONDS).take(((long) 5) + 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r6, r7));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void n2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r3, "interactId");
        com.bytedance.android.live.liveinteract.plantform.core.g.b(r2, r3);
    }

    @Override // xe0.a.InterfaceC0292a
    public final void r(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        if ((r3 instanceof ApiServerException) == false) goto L6;
        f2.c(((ApiServerException) r3).getPrompt(), 0);
        return;
    }

    public final void showFloat(IRoom r2, FloatWindowConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "floatWindowConfig");
        HashMap r4 = r3.getLogExtras();
        if (r4 == null) goto L7;
        String r5 = (String) r4.get("open_source");
        if (r5 == null) goto L7;
        this.M = r5;
    L7:
        DataCenter r6 = this.l;
        if (r6 == null) goto L10;
        r6.put("data_close_room_from_small_window_play", Boolean.TRUE);
    L10:
        xs2.b.a().post(new zg1.h1(6));
    }

    public final void y(boolean r7, String r8) {
        t("switchRtcAudio: enable = " + r7 + ", extra = " + r8);
        boolean r1 = false;
        if (this.s == null) goto L17;
        boolean r0 = jc1.k.n(IKtvService.class).isCurrentUserIsSinger();
        if (r7 == false) goto L11;
        jg6.a r2 = this.w;
        if (r2 == null) goto L17;
        kg6.e r3 = r2.b();
        if (r3 == null) goto L17;
        r3.z(new kg6.d(false, true, r8, 8));
        goto L17
    L11:
        jg6.a r4 = this.w;
        if (r4 == null) goto L17;
        kg6.e r5 = r4.b();
        if (r5 == null) goto L17;
        r5.t(new kg6.b(false, !r0, r8, 8));
    L17:
        if (this.x == null) goto L34;
        if (r7 == false) goto L24;
        jg6.a r6 = this.w;
        if (r6 == null) goto L34;
        kg6.e r9 = r6.b();
        if (r9 == null) goto L34;
        r9.z(new kg6.d(true, true, r8, 8));
        goto L34
    L24:
        jg6.a r10 = this.w;
        if (r10 == null) goto L34;
        kg6.e r11 = r10.b();
        if (r11 == null) goto L34;
        if (je0.d.G() == false) goto L31;
    L33:
        r11.t(new kg6.b(true, r1, r8, 8));
        goto L34
    L31:
        if (je0.d.p() == true) goto L33;
        r1 = true;
    L34:
        DataCenter r12 = this.l;
        if (r12 == null) goto L38;
        r12.put("data_self_is_silenced", Boolean.valueOf(!r7));
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Hf(int r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "deviceId");
        Intrinsics.checkNotNullParameter(r2, "deviceId");
    }

    /* JADX WARN: Type inference failed for: r6v6, types: [boolean] */
    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void J(String[] r6, boolean[] r7, int[] r8) {
        if (r6 == null) goto L62;
        if (r7 == null) goto L69;
        int r9 = r6.length;
        boolean r0 = false;
        int r1 = 0;
    L6:
        if (r1 >= r9) goto L8;
        Boolean r2 = this.k.put(r6[r1], Boolean.valueOf(Boolean.valueOf(r7[r1]).booleanValue()));
        r1 = r1 + 1;
        goto L6
    L8:
        ILinkPlayerInfoBridge r10 = this.p;
        if (r10 == null) goto L63;
        ?? r11 = Intrinsics.areEqual(this.k.get(String.valueOf(r10.getInteractId())), Boolean.TRUE);
        Iterator r12 = ((ArrayList) this.o).iterator();
    L11:
        RecyclerView.ViewHolder r3 = null;
        if (r12.hasNext() == false) goto L16;
        Object r13 = r12.next();
        if (je0.d.C((ILinkPlayerInfoBridge) r13) == false) goto L11;
    L17:
        ILinkPlayerInfoBridge r14 = (ILinkPlayerInfoBridge) r13;
        if (r14 != null) goto L20;
        return;
    L20:
        if (r14.getTalkState() == r11) goto L65;
        r14.setTalkState(r11 == true ? 1 : 0);
        rx1.g r15 = m();
        if (r15 == null) goto L26;
        rx1.f r16 = r15.a;
        if (r16 == null) goto L26;
        View r17 = r16.c;
    L28:
        if ((r17 instanceof com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) == true) goto L30;
        r17 = null;
    L30:
        com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b r18 = (com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.b) r17;
        if (r18 == null) goto L66;
        if (r11 <= 0) goto L34;
        r0 = true;
    L34:
        Iterator<T> r19 = r18.n.iterator();
    L36:
        if (r19.hasNext() == false) goto L40;
        Object r20 = r19.next();
        if (je0.d.C((ILinkPlayerInfoBridge) r20) == false) goto L36;
    L42:
        if (((ILinkPlayerInfoBridge) r20) != null) goto L44;
        return;
    L44:
        if (r18.n.size() < 4) goto L48;
        RecyclerView r21 = r18.c;
        if (r21 == null) goto L52;
        r3 = r21.findViewHolderForAdapterPosition(3);
    L52:
        if ((r3 instanceof LinkmicOnlineFloatViewAvatarViewHolder) == false) goto L68;
        ((LinkmicOnlineFloatViewAvatarViewHolder) r3).U3(r0);
        return;
    L68:
        return;
    L48:
        RecyclerView r22 = r18.c;
        if (r22 == null) goto L52;
        r3 = r22.findViewHolderForAdapterPosition(r18.n.size() - 1);
        goto L52
    L40:
        r20 = null;
        goto L42
    L66:
        return;
    L26:
        r17 = null;
        goto L28
    L65:
        return;
    L16:
        r13 = null;
        goto L17
    L63:
        return;
    L69:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void Rj(int r1, int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    public final void dismissFloatWindow(long r9, String r11, boolean r12) {
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.T("dismissFloatWindow, reason: " + r11 + ", needResetLinkerState: " + r12, 4);
        t("call dismissFloatWindow, reason: " + r11 + ", needResetLinkerState: " + r12);
        if (vm2.d.e0() == false) goto L6;
        jc1.k.n(IMiddlewareRoomService.class).stopMultiLinkNotification();
    L6:
        this.X.clear();
        if (TextUtils.equals(r11, "call") == false) goto L9;
    L23:
        n("small_window_close");
        u();
    L25:
        if (TextUtils.equals(r11, "enter room") == false) goto L27;
        this.i = true;
    L27:
        IMiddlewareHostBusiness r10 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r10 == null) goto L30;
        r10.setLinkMicFloatWindowState(false);
    L30:
        this.e = false;
        if (TextUtils.equals(this.N, "auto") == false) goto L33;
        p(true);
    L34:
        com.bytedance.android.livesdk.sharedpref.e r13 = b6.e0;
        Boolean r14 = Boolean.FALSE;
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, r14);
        HashMap r7 = new HashMap();
        r7.put("is_link_reserve", "1");
        r7.put("is_auto_play", m2.b(this.j));
        boolean r15 = xe0.k.a;
        xe0.k.c(this.J, this.K, this.L, System.currentTimeMillis() - this.I, r7);
        StringBuilder r16 = new StringBuilder("call logLiveDuration, roomId = ");
        IRoom r17 = this.m;
        if (r17 == null) goto L37;
        Long r18 = Long.valueOf(r17.getRoomId());
    L38:
        r16.append(r18);
        t(r16.toString());
        rx1.g r19 = m();
        if (r19 == null) goto L41;
        r19.a();
    L41:
        hg6.g r20 = this.s;
        if (r20 == null) goto L44;
        r20.X(3, "LinkMicOnlineFloatWindow, afterFloatWindowClose");
    L44:
        hg6.g r21 = this.x;
        if (r21 == null) goto L47;
        r21.X(3, "LinkMicOnlineFloatWindow, afterFloatWindowClose");
    L47:
        RTSVideoWidget r22 = this.B;
        if (r22 == null) goto L50;
        r22.onDestroy();
    L50:
        this.B = null;
        RTSVoiceWidget r23 = this.C;
        if (r23 == null) goto L53;
        r23.onDestroy();
    L53:
        this.C = null;
        this.v.removeCallbacksAndMessages(null);
        vlc.d r24 = this.a;
        if (r24 == null) goto L56;
        r24.release();
    L56:
        xe0.a r25 = this.c;
        if (r25 == null) goto L59;
        r25.f.clear();
    L59:
        xe0.h r26 = this.b;
        if (r26 == null) goto L62;
        Intrinsics.checkNotNullParameter(this, "listener");
        r26.d.remove(this);
    L62:
        xe0.h r27 = this.b;
        if (r27 == null) goto L68;
        Disposable r110 = r27.c;
        if (r110 == null) goto L67;
        r110.dispose();
    L67:
        r27.d.clear();
    L68:
        CompositeDisposable r28 = this.T;
        if (r28 == null) goto L71;
        r28.dispose();
    L71:
        Disposable r29 = this.Q;
        if (r29 == null) goto L74;
        r29.dispose();
    L74:
        Disposable r30 = this.P;
        if (r30 == null) goto L77;
        r30.dispose();
    L77:
        Disposable r31 = this.R;
        if (r31 == null) goto L80;
        r31.dispose();
    L80:
        reset();
        return;
    L37:
        r18 = null;
        goto L38
    L33:
        p(false);
        goto L34
    L9:
        if (TextUtils.equals(r11, "teen mode on") == true) goto L23;
        if (TextUtils.equals(r11, "user logout or switch account") == true) goto L23;
        if (v.a() == false) goto L18;
        if (vm2.c.h().c() == false) goto L18;
    L21:
        boolean r32 = false;
    L22:
        if (r32 == false) goto L25;
    L18:
        if (((Boolean) vm2.d.D7.getValue(null, vm2.d.a[442(0x1ba, float:6.2E-43)])).booleanValue() == false) goto L21;
        if (r12 == false) goto L21;
        r32 = true;
        goto L22
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void x1(LiveWrappedNetworkDetectionLinkType r1, int r2, double r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r1, "type");
    }

    public static void k(LinkmicOnlineFloatWindowManager r4, Integer r5, Boolean r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r7 & 2) == 0) goto L8;
        r6 = Boolean.FALSE;
    L8:
        r4.getClass();
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L12;
        r4.n("small_window_close");
    L12:
        if (r4.g == true) goto L16;
        r4.g = true;
        r4.u();
        r4.R = Observable.interval(0, 1, TimeUnit.SECONDS).take(((long) 5) + 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.liveinteract.floatwindow.onlinewindow.g(r4, r5));
        return;
    }

    public final void H(ei6.a r8, int r9, long r10, Exception r12) {
        this.v.post(new j(this, r9, r10, r12));
    }

    public final void M(ei6.a r1, int r2, long r3, Object... r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        this.v.post(new k(this, r2, r5));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void h1(String r3, SurfaceView r4, int r5, int r6) {
        Iterator<T> r7 = this.D.iterator();
    L3:
        Object r0 = null;
        String r1 = null;
        if (r7.hasNext() == false) goto L11;
        Object r8 = r7.next();
        ch0.h r2 = (ch0.h) r8;
        if (r2 == null) goto L9;
        r1 = r2.a;
    L9:
        if (TextUtils.equals(r1, r3) == false) goto L3;
        r0 = r8;
    L11:
        ch0.h r9 = (ch0.h) r0;
        if (r9 == null) goto L19;
        if (r4 == null) goto L20;
        r9.b = r4;
        return;
    L20:
        return;
    }
}
