package com.bytedance.android.live.liveinteract.floatwindow.applywindow;

import am2.x;
import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.o0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.link.model.bridge.f1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.ILinkmicProfitMessage;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.utils.IMessageManagerProviderService;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLeaveContentBridge;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.floatview.FloatWindowConfig;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowManager;
import com.bytedance.android.livesdkapi.floatview.IInnerFloatWindowSceneInterceptor;
import com.bytedance.android.livesdkapi.floatview.InnerFloatViewTAG;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LinkmicApplyFloatWindowManager implements vlc.l, ye0.c, IInnerFloatWindowManager, IInnerFloatWindowSceneInterceptor {
    public static final d y = null;
    public static final Lazy z = null;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public long e;
    public boolean f;
    public String g;
    public String h;
    public boolean i;
    public HashMap<String, String> j;
    public DataCenter k;
    public IRoom l;
    public final List<ILinkPlayerInfoBridge> m;
    public int n;
    public int o;
    public String p;
    public boolean q;
    public vlc.d r;
    public we0.b s;
    public CompositeDisposable t;
    public Disposable u;
    public Disposable v;
    public Disposable w;
    public final String x;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ILinkPlayerInfoBridge) r1).getUserPosition()), Integer.valueOf(((ILinkPlayerInfoBridge) r2).getUserPosition()));
        }
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ILinkPlayerInfoBridge) r1).getUserPosition()), Integer.valueOf(((ILinkPlayerInfoBridge) r2).getUserPosition()));
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ILinkPlayerInfoBridge) r1).getUserPosition()), Integer.valueOf(((ILinkPlayerInfoBridge) r2).getUserPosition()));
        }
    }

    public static final class d extends com.bytedance.android.live.liveinteract.floatwindow.applywindow.d {
        public d() {
        }
    }

    public static final class e {
        public static LinkmicApplyFloatWindowManager a() {
            return (LinkmicApplyFloatWindowManager) LinkmicApplyFloatWindowManager.z.getValue();
        }
    }

    public static final class f implements DialogInterface.OnClickListener {
        public final /* synthetic */ LinkmicApplyFloatWindowManager a;

        public f(LinkmicApplyFloatWindowManager r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r8, int r9) {
            IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 6, null);
            r8.dismiss();
        }
    }

    public static final class g implements DialogInterface.OnClickListener {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ LinkmicApplyFloatWindowManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public h(LinkmicApplyFloatWindowManager r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            rx1.g r0 = this.a.g();
            View r1 = null;
            if (r0 == null) goto L7;
            rx1.f r2 = r0.a;
            if (r2 == null) goto L7;
            View r3 = r2.c;
        L9:
            if ((r3 instanceof com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) == false) goto L12;
            r1 = r3;
        L12:
            com.bytedance.android.live.liveinteract.floatwindow.applywindow.a r4 = (com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) r1;
            if (r4 == null) goto L16;
            r4.a((int) (((long) 5) - r10.longValue()), this.b, this.c);
        L16:
            if (((int) r10.longValue()) != 5) goto L19;
            IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 6, null);
            return;
        L19:
            return;
        L7:
            r3 = null;
            goto L9
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ LinkmicApplyFloatWindowManager a;

        public i(LinkmicApplyFloatWindowManager r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            rx1.g r0 = this.a.g();
            View r1 = null;
            if (r0 == null) goto L7;
            rx1.f r2 = r0.a;
            if (r2 == null) goto L7;
            View r3 = r2.c;
        L9:
            if ((r3 instanceof com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) == false) goto L12;
            r1 = r3;
        L12:
            com.bytedance.android.live.liveinteract.floatwindow.applywindow.a r4 = (com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) r1;
            if (r4 == null) goto L16;
            r4.a((int) (((long) 5) - r10.longValue()), s1.B(2131918008), 12);
        L16:
            if (((int) r10.longValue()) != 5) goto L19;
            IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 6, null);
            return;
        L19:
            return;
        L7:
            r3 = null;
            goto L9
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ IRoom a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Function1 d;

        public j(IRoom r1, Function1 r2, long r3, Function1 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r5) {
            com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
            this.b.invoke(r6);
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.c;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r6, "response");
            JSONObject r2 = new JSONObject();
            TalkRoomBusinessFullLinkMonitor.Z(LinkMonitorData.GetUserWaitingOffsetData, TalkRoomBusinessFullLinkMonitor.h(r1), r6.logId, r2);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ IRoom a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Function1 d;

        public k(IRoom r1, Function1 r2, long r3, Function1 r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.d.invoke(r6);
            String r0 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r6);
            if (r0 != null) goto L5;
        L10:
            TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
            long r2 = this.c;
            r1.getClass();
            JSONObject r3 = new JSONObject();
            TalkRoomBusinessFullLinkMonitor.Y(LinkMonitorData.GetUserWaitingOffsetData, TalkRoomBusinessFullLinkMonitor.h(r2), r6, r3);
            return;
        L5:
            if (r0.length() <= 0) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == false) goto L10;
            f2.c(r0, 0);
            goto L10
        L7:
            r4 = false;
            goto L8
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

        public l(String r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            InteractLinkFullLinkMonitor.x(this.a, System.currentTimeMillis() - this.b, ((com.bytedance.android.live.network.response.e) r6).logId);
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;

        public m(String r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            String r0 = this.a;
            long r1 = System.currentTimeMillis() - this.b;
            InteractLinkFullLinkMonitor.w(r0, r1, (Throwable) r6);
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ LinkmicApplyFloatWindowManager a;
        public final /* synthetic */ tlc.d b;

        public n(LinkmicApplyFloatWindowManager r1, tlc.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            rx1.g r0 = this.a.g();
            View r1 = null;
            if (r0 == null) goto L7;
            rx1.f r2 = r0.a;
            if (r2 == null) goto L7;
            View r3 = r2.c;
        L9:
            if ((r3 instanceof com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) == false) goto L12;
            r1 = r3;
        L12:
            com.bytedance.android.live.liveinteract.floatwindow.applywindow.a r4 = (com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) r1;
            if (r4 == null) goto L26;
            int r5 = (int) (((long) 3) - r10.longValue());
            if (r5 != 3) goto L22;
            ViewGroup r6 = r4.g;
            if (r6 == null) goto L19;
            r6.setVisibility(8);
        L19:
            ViewGroup r7 = r4.i;
            if (r7 == null) goto L22;
            r7.setVisibility(0);
        L22:
            TextView r8 = r4.j;
            if (r8 == null) goto L26;
            r8.setText(s1.C(2131917611, new Object[]{Integer.valueOf(r5)}));
        L26:
            if (((int) r10.longValue()) != 3) goto L29;
            this.a.e(true);
            this.a.c = false;
            return;
        L29:
            return;
        L7:
            r3 = null;
            goto L9
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ LinkmicApplyFloatWindowManager a;
        public final /* synthetic */ tlc.d b;

        public o(LinkmicApplyFloatWindowManager r1, tlc.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Long r10 = (Long) r9;
            rx1.g r0 = this.a.g();
            View r1 = null;
            if (r0 == null) goto L7;
            rx1.f r2 = r0.a;
            if (r2 == null) goto L7;
            View r3 = r2.c;
        L9:
            if ((r3 instanceof com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) == false) goto L12;
            r1 = r3;
        L12:
            com.bytedance.android.live.liveinteract.floatwindow.applywindow.a r4 = (com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) r1;
            if (r4 == null) goto L16;
            r4.a((int) (((long) 5) - r10.longValue()), s1.B(2131918007), 15);
        L16:
            if (((int) r10.longValue()) != 5) goto L19;
            IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this.a, 0, null, false, 6, null);
            return;
        L19:
            return;
        L7:
            r3 = null;
            goto L9
        }
    }

    public final void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r1) {
    }

    public final void d() {
        this.a = true;
        this.w = Observable.interval(0, 1, TimeUnit.SECONDS).take(((long) 5) + 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this));
    }

    public final boolean dismissWindowWhenToDesktop() {
        return true;
    }

    public final void hideFloatWindow() {
    }

    public final void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r1) {
    }

    public final void reset() {
        this.a = false;
        this.b = false;
        this.d = false;
        this.i = false;
        this.e = 0;
        this.j = null;
        this.g = "popup";
        this.h = "auto";
    }

    public final void showFloatWindow() {
    }

    static {
        y = new d();
        z = LazyKt.lazy(LinkmicApplyFloatWindowManager$Companion$instance$2.INSTANCE);
    }

    @Override // ye0.c
    public final void b() {
        HashMap r0 = new HashMap();
        String r2 = "1";
        r0.put("is_apply_reserve", "1");
        r0.put("is_auto_play", m2.b(this.q));
        boolean r1 = xe0.k.a;
        int r3 = this.n;
        int r4 = this.o;
        String r5 = this.p;
        Intrinsics.checkNotNullParameter(r5, "functionType");
        HashMap r6 = new HashMap();
        if (xe0.k.a == true) goto L6;
        r2 = "0";
    L6:
        r6.put("is_song_order", r2);
        r6.put("trigger_scene", "connection");
        r6.put("windows_type", "in");
        r6.put("initial_page", "content");
        if (vm2.d.v0() == false) goto L9;
        r6.put("function_type", r5);
        r6.put("function_type2", r5);
    L10:
        r6.putAll(r0);
        j0.l().sendLog("livesdk_mini_window_finish_show", r6, new Object[]{IRoom.class, x.class});
        return;
    L9:
        TalkRoomLogUtils.A0(r6, Integer.valueOf(r3), Integer.valueOf(r4));
        goto L10
    }

    @Override // ye0.c
    public final void close() {
        this.h = "manual";
        if (this.f == false) goto L7;
        Activity r0 = jc1.k.n(IMiddlewareHostApp.class).getCurrentActivity();
        if (r0 == null) goto L9;
        x0.b r1 = new x0.b(r0, 4);
        r1.l(2131917750);
        r1.i(0, 2131917580, new f(this));
        r1.i(1, 2131915442, g.a);
        r1.n();
        return;
    L9:
        return;
    L7:
        IInnerFloatWindowManager.DefaultImpls.dismissFloatWindow$default(this, 0, null, false, 6, null);
    }

    public final rx1.g g() {
        return rx1.l.a(this.x);
    }

    @Override // ye0.c
    public final void onClick() {
        if (this.d == false) goto L6;
        return;
    L6:
        if (this.i == false) goto L10;
        f2.c("被拉黑无法进入直播间", 0);
        return;
    L10:
        if (this.c == false) goto L15;
        this.c = false;
        Disposable r0 = this.v;
        if (r0 == null) goto L14;
        r0.dispose();
    L14:
        e(true);
        return;
    L15:
        e(false);
    }

    public LinkmicApplyFloatWindowManager() {
        this.g = "popup";
        this.h = "auto";
        this.m = new ArrayList();
        this.p = "live";
        this.x = InnerFloatViewTAG.TAG_LINKMIC_APPLY_FLOAT.getTag();
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
        if (xe0.j.a() == false) goto L15;
        Integer r2 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r2 == null) goto L15;
        if (r2.intValue() != 1) goto L15;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean floatWindowEntityExists() {
        if (g() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean floatWindowIsShowing() {
        rx1.g r0 = g();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.l != true) goto L7;
        return true;
    }

    public final boolean hideWindowWhenToDesktop() {
        return IInnerFloatWindowManager.DefaultImpls.hideWindowWhenToDesktop(this);
    }

    public final String tag() {
        return this.x;
    }

    public final void e(boolean r9) {
        Activity r0 = jc1.k.n(IMiddlewareHostApp.class).getCurrentActivity();
        if (r0 == null) goto L27;
        IRoom r1 = this.l;
        if (r1 == null) goto L27;
        String r2 = r1.getRequestId();
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        String r4 = r1.getLog_pb();
        if (r4 == null) goto L13;
        r3 = r4;
    L13:
        JSONObject r5 = new JSONObject();
        r5.put("trigger_scene", "connection");
        r5.put("initial_page", "content");
        r5.put("return_windows_type", "in");
        r5.put("is_mini_auto_play", m2.b(this.q));
        String r6 = r5.toString();
        StringBuilder r7 = new StringBuilder("sslocal://webcast_room?room_id=");
        r7.append(r1.getRoomId());
        r7.append("&user_id=");
        r7.append(r1.getOwnerUserIdString());
        r7.append("&request_id=");
        r7.append(r2);
        r7.append("&log_pb=");
        r7.append(r3);
        r7.append("&enter_from_merge=");
        HashMap<String, String> r8 = this.j;
        String r10 = null;
        if (r8 == null) goto L16;
        String r11 = r8.get("enter_from_merge");
    L17:
        r7.append(r11);
        r7.append("&enter_method=");
        HashMap<String, String> r12 = this.j;
        if (r12 == null) goto L20;
        String r13 = r12.get("enter_method");
    L21:
        r7.append(r13);
        r7.append("&action_type=");
        HashMap<String, String> r14 = this.j;
        if (r14 == null) goto L24;
        r10 = r14.get("action_type");
    L24:
        r7.append(r10);
        r7.append("&is_mini_window=1&extra_params=");
        r7.append(r6);
        String r15 = r7.toString();
        IMiddlewareLiveService r16 = TTLiveServiceMiddleware.getLiveService();
        if (r16 == null) goto L27;
        r16.handleSchema(r0, UriProtector.parse(r15));
        goto L27
    L20:
        r13 = null;
        goto L21
    L16:
        r11 = null;
    L27:
        if (r9 == false) goto L29;
        String r17 = "auto";
    L30:
        HashMap r18 = new HashMap();
        r18.put("is_apply_reserve", "1");
        r18.put("is_auto_play", m2.b(this.q));
        boolean r19 = xe0.k.a;
        xe0.k.f(this.n, this.o, this.p, r17, r18);
        return;
    L29:
        r17 = "click";
        goto L30
    }

    public final we0.b i(long r4) {
        IRoom r0 = this.l;
        if (r0 != null) goto L5;
    L6:
        this.s = null;
    L8:
        return this.s;
    L5:
        if (r4 == r0.getRoomId()) goto L8;
        goto L6
    }

    public final void k(String r6) {
        long r0 = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.v(r6);
        LinkApi r2 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r3 = this.l;
        if (r3 == null) goto L5;
        long r4 = r3.getId();
    L6:
        this.u = r2.leave(r4, r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(r6, r0), new m(r6, r0));
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public final void l(boolean r4) {
        HashMap r0 = new HashMap();
        String r2 = "1";
        r0.put("is_apply_reserve", "1");
        if (r4 == true) goto L6;
        r2 = "0";
    L6:
        r0.put("is_auto_close", r2);
        r0.put("is_auto_play", m2.b(this.q));
        boolean r5 = xe0.k.a;
        xe0.k.b(this.n, this.o, this.p, r0);
    }

    public final void onMessage(final tlc.d r15) {
        if (this.d == false) goto L5;
        return;
    L5:
        if (r15 == null) goto L141;
        boolean r8 = true;
        View r9 = null;
        if ((r15 instanceof z0) == false) goto L32;
        z0 r0 = (z0) r15;
        int r11 = (int) r0.getType2();
        if (r11 != 2) goto L11;
        we0.b r1 = this.s;
        if (r1 == null) goto L28;
        r1.B = r0;
    L28:
        if (r1 == null) goto L30;
        r1.C = Long.valueOf(System.currentTimeMillis());
    L30:
        this.c = true;
        this.v = Observable.interval(0, 1, TimeUnit.SECONDS).take(((long) 3) + 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this, r15));
        TalkRoomBusinessFullLinkMonitor r16 = TalkRoomBusinessFullLinkMonitor.a;
        com.bytedance.android.live.liveinteract.multianchor.model.b r2 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r0.castToOrNull(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
        r16.getClass();
        TalkRoomBusinessFullLinkMonitor.n0(r2);
        return;
    L11:
        if (r11 != 17) goto L162;
        int r17 = this.n;
        int r3 = (int) r0.getScene();
        if (r17 != 5) goto L16;
        if (r3 != 9) goto L16;
    L20:
        if (r8 == false) goto L22;
        this.f = false;
        this.s = null;
        d();
    L22:
        this.n = (int) r0.getScene();
        this.o = r0.getUiLayout();
        String r18 = r0.getFunctionType2();
        if (r18 == null) goto L142;
        this.p = r18;
        return;
    L142:
        return;
    L16:
        if (r17 != 9) goto L19;
        if (r3 == 5) goto L20;
    L19:
        r8 = false;
        goto L20
    L162:
        return;
    L32:
        if ((r15 instanceof h1) == false) goto L121;
        h1 r4 = (h1) r15;
        int r5 = r4.getMType();
        if (r5 == 2) goto L115;
        if (r5 != 11) goto L37;
        ILinkerLinkedListChangeContent r19 = r4.getMLinkedListChange();
        if (r19 == null) goto L97;
        List r110 = r19.getLinkUsers();
        if (r110 == null) goto L97;
        Collection r111 = CollectionsKt.toList(je0.d.f0(r110, false));
        if (r111 == null) goto L97;
    L98:
        ArrayList r6 = (ArrayList) this.m;
        r6.clear();
        r6.addAll(r111);
        if (r6.size() <= 1) goto L101;
        CollectionsKt.sortWith(r6, new a());
    L101:
        rx1.g r112 = g();
        if (r112 == null) goto L106;
        rx1.f r113 = r112.a;
        if (r113 == null) goto L106;
        View r114 = r113.c;
    L108:
        if ((r114 instanceof com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) == false) goto L111;
        r9 = r114;
    L111:
        com.bytedance.android.live.liveinteract.floatwindow.applywindow.a r10 = (com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) r9;
        if (r10 == null) goto L151;
        r10.b(this.m);
        return;
    L151:
        return;
    L106:
        r114 = null;
    L97:
        r111 = new ArrayList();
        goto L98
    L37:
        if (r5 != 52) goto L39;
        IRoom r7 = this.l;
        if (r7 == null) goto L149;
        j(r7, this.n, new LinkmicApplyFloatWindowManager$onMessage$$inlined$let$lambda$2(this, r15), LinkmicApplyFloatWindowManager$onMessage$1$6$2.INSTANCE);
        return;
    L149:
        return;
    L39:
        if (r5 == 6) goto L65;
        if (r5 != 7) goto L163;
        ILinkerLeaveContentBridge r115 = r4.getLeave();
        if (r115 == null) goto L48;
        List r116 = r115.getLinkUsers();
        if (r116 == null) goto L48;
        Collection r117 = CollectionsKt.toList(je0.d.f0(r116, false));
        if (r117 == null) goto L48;
    L49:
        ArrayList r12 = (ArrayList) this.m;
        r12.clear();
        r12.addAll(r117);
        if (r12.size() <= 1) goto L52;
        CollectionsKt.sortWith(r12, new c());
    L52:
        rx1.g r118 = g();
        if (r118 == null) goto L57;
        rx1.f r119 = r118.a;
        if (r119 == null) goto L57;
        View r120 = r119.c;
    L59:
        if ((r120 instanceof com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) == false) goto L62;
        r9 = r120;
    L62:
        com.bytedance.android.live.liveinteract.floatwindow.applywindow.a r13 = (com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) r9;
        if (r13 == null) goto L145;
        r13.b(this.m);
        return;
    L145:
        return;
    L57:
        r120 = null;
    L48:
        r117 = new ArrayList();
        goto L49
    L163:
        return;
    L65:
        f1 r121 = r4.getEnter();
        if (r121 == null) goto L71;
        List r122 = r121.getLinkUsers();
        if (r122 == null) goto L71;
        Collection r123 = CollectionsKt.toList(je0.d.f0(r122, false));
        if (r123 == null) goto L71;
    L72:
        ArrayList r14 = (ArrayList) this.m;
        r14.clear();
        r14.addAll(r123);
        if (r14.size() <= 1) goto L75;
        CollectionsKt.sortWith(r14, new b());
    L75:
        rx1.g r124 = g();
        if (r124 == null) goto L80;
        rx1.f r125 = r124.a;
        if (r125 == null) goto L80;
        View r126 = r125.c;
    L82:
        if ((r126 instanceof com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) == false) goto L85;
        r9 = r126;
    L85:
        com.bytedance.android.live.liveinteract.floatwindow.applywindow.a r20 = (com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) r9;
        if (r20 == null) goto L147;
        r20.b(this.m);
        return;
    L147:
        return;
    L80:
        r126 = null;
    L71:
        r123 = new ArrayList();
        goto L72
    L115:
        if (this.b == true) goto L118;
        this.b = true;
        c(s1.B(2131918008), 13);
        return;
    L118:
        if (this.a == true) goto L154;
        c(s1.B(2131918007), 15);
        return;
    L154:
        return;
    L121:
        if ((r15 instanceof ILinkmicProfitMessage) == false) goto L129;
        int r127 = ((ILinkmicProfitMessage) r15).getMsgType();
        if (r127 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_NormalPaidLinkmicOpen.getValue()) goto L126;
        this.f = false;
        this.s = null;
        d();
        k("paid_change");
        return;
    L126:
        if (r127 != ILinkmicProfitMessage.LinkmicProfitMessageType.TypeProfit_NormalPaidLinkmicClose.getValue()) goto L157;
        this.f = false;
        this.s = null;
        d();
        k("paid_change");
        return;
    L157:
        return;
    L129:
        if ((r15 instanceof o0) == false) goto L134;
        if (((o0) r15).getAction() != 3) goto L159;
        c(s1.B(2131918007), 15);
        return;
    L159:
        return;
    L134:
        if ((r15 instanceof va) == false) goto L161;
        int r21 = (int) ((va) r15).getAction();
        if (r21 == 7) goto L139;
        if (r21 == 11) goto L139;
        return;
    L139:
        this.i = true;
        this.s = null;
        this.w = Observable.interval(0, 1, TimeUnit.SECONDS).take(((long) 5) + 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this, r15));
        return;
    L161:
        return;
    }

    public final void c(String r6, int r7) {
        this.n = 0;
        this.d = true;
        this.f = false;
        this.s = null;
        this.a = true;
        this.w = Observable.interval(0, 1, TimeUnit.SECONDS).take(((long) 5) + 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this, r6, r7));
    }

    public final void showFloat(IRoom r2, FloatWindowConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "floatWindowConfig");
        HashMap r4 = r3.getLogExtras();
        if (r4 == null) goto L7;
        String r5 = (String) r4.get("open_source");
        if (r5 == null) goto L7;
        this.g = r5;
    L7:
        DataCenter r6 = this.k;
        if (r6 == null) goto L10;
        r6.put("data_close_room_from_small_window_play", Boolean.TRUE);
    L10:
        xs2.b.a().post(new zg1.h1(6));
    }

    public final void dismissFloatWindow(long r11, String r13, boolean r14) {
        if (g() == null) goto L52;
        IRoom r15 = this.l;
        long r1 = 0;
        if (r15 == null) goto L14;
        if (r11 != r15.getRoomId()) goto L14;
        if (this.c == false) goto L25;
        this.c = false;
        Disposable r16 = this.v;
        if (r16 == null) goto L25;
        r16.dispose();
    L25:
        if (TextUtils.equals(this.h, "auto") == false) goto L27;
        l(true);
    L28:
        if (r13 != null) goto L30;
    L32:
        rx1.g r17 = g();
        if (r17 == null) goto L35;
        r17.a();
    L35:
        HashMap r8 = new HashMap();
        r8.put("is_link_reserve", "0");
        r8.put("is_auto_play", m2.b(this.q));
        boolean r18 = xe0.k.a;
        xe0.k.c(this.n, this.o, this.p, System.currentTimeMillis() - this.e, r8);
        TalkRoomBusinessFullLinkMonitor r19 = TalkRoomBusinessFullLinkMonitor.a;
        IRoom r110 = this.l;
        if (r110 == null) goto L38;
        r1 = r110.getRoomId();
    L38:
        r19.getClass();
        JSONObject r5 = new JSONObject();
        r5.put("status", "close");
        r5.put("source_room_id", r1);
        r5.put("target_room_id", r11);
        nd0.c.o(nd0.c.a, LinkMonitorData.LinkmicApplyFloatWindowData, r5, 0, null, false, 28);
        CompositeDisposable r12 = this.t;
        if (r12 == null) goto L41;
        r12.dispose();
    L41:
        Disposable r111 = this.v;
        if (r111 == null) goto L44;
        r111.dispose();
    L44:
        Disposable r112 = this.w;
        if (r112 == null) goto L47;
        r112.dispose();
    L47:
        vlc.d r113 = this.r;
        if (r113 == null) goto L50;
        r113.release();
    L50:
        reset();
        return;
    L30:
        if (r13.equals("VideoRecordNewActivity") != true) goto L32;
        f2.b(2131917743, 0);
        goto L32
    L27:
        l(false);
    L14:
        if (r11 == 0) goto L17;
        f2.b(2131917743, 0);
    L17:
        if (this.c == false) goto L21;
        this.c = false;
        Disposable r114 = this.v;
        if (r114 == null) goto L21;
        r114.dispose();
    L21:
        this.s = null;
        if (this.f == false) goto L25;
        k("small_window_close");
        goto L25
    }

    public final void j(IRoom r18, int r19, Function1<? super com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.chatroom.model.interact.x>, Unit> r20, Function1<? super Throwable, Unit> r21) {
        long r6 = System.currentTimeMillis();
        CompositeDisposable r9 = this.t;
        if (r9 == null) goto L6;
        RxUtilKt.c(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).getUserWaitingRankPosition(r18.getRoomId(), r18.getRoomId(), r19, 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(r18, r20, r6, r21), new k(r18, r20, r6, r21)), r9);
        return;
    }

    public final void m(IRoom r20, List r21, int r22, int r23, String r24, we0.b r25, HashMap r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r20, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r21, "onlineUserList");
        Intrinsics.checkNotNullParameter(r24, "functionType");
        Intrinsics.checkNotNullParameter(r25, "linkmicParams");
        Intrinsics.checkNotNullParameter(r26, "enterParams");
        if (y.a == false) goto L6;
        k("show_float_window_when_app_in_bg");
        return;
    L6:
        com.bytedance.android.live.liveinteract.floatwindow.applywindow.a r8 = new com.bytedance.android.live.liveinteract.floatwindow.applywindow.a(jc1.a.b(), this);
        Application r9 = jc1.a.b();
        Map r10 = rx1.l.a;
        rx1.l.a r11 = new rx1.l.a(r9);
        r11.b = r8;
        float r12 = 100;
        r11.c = s1.f(r12);
        r11.d = s1.f(r12);
        r11.q = this.x;
        r11.e = 3;
        float r13 = 8;
        int r14 = s1.f(r13);
        float r15 = 12;
        int r16 = s1.f(r15);
        int r17 = s1.f(r13);
        int r18 = s1.f(r15);
        r11.f = r14;
        r11.h = r16;
        r11.g = r17;
        r11.i = r18;
        AccelerateDecelerateInterpolator r19 = new AccelerateDecelerateInterpolator();
        r11.o = 300;
        r11.p = r19;
        r11.r = true;
        r11.t = true;
        r11.a();
        this.l = r20;
        ArrayList r110 = (ArrayList) this.m;
        r110.clear();
        r110.addAll(r21);
        if (r110.size() <= 1) goto L9;
        CollectionsKt.sortWith(r110, new com.bytedance.android.live.liveinteract.floatwindow.applywindow.e());
    L9:
        this.n = r22;
        this.o = r23;
        this.p = r24;
        this.s = r25;
        this.j = r26;
        this.q = r27;
        IMessageManagerProviderService r111 = jc1.k.n(IMessageManagerProviderService.class);
        Application r112 = jc1.a.b();
        long r113 = r20.getRoomId();
        LinkedHashMap r114 = new LinkedHashMap();
        t r2 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r2 == null) goto L14;
        com.bytedance.live.datacontext.j r3 = r2.w1();
        if (r3 == null) goto L14;
        ylc.e r115 = (ylc.e) r3.getValue();
    L15:
        vlc.d r4 = r111.configFloatWindow(r112, r113, r114, r115);
        this.r = r4;
        if (r4 == null) goto L18;
        r4.startMessage();
    L18:
        vlc.d r5 = this.r;
        if (r5 == null) goto L21;
        r5.addMessageListener(MessageType.CONTROL.getKey(), this);
    L21:
        vlc.d r6 = this.r;
        if (r6 == null) goto L24;
        r6.addMessageListener(MessageType.LINK_MIC.getKey(), this);
    L24:
        vlc.d r7 = this.r;
        if (r7 == null) goto L27;
        r7.addMessageListener(MessageType.LINKER.getKey(), this);
    L27:
        vlc.d r28 = this.r;
        if (r28 == null) goto L30;
        r28.addMessageListener(MessageType.LINK_MIC_PROFIT.getKey(), this);
    L30:
        vlc.d r29 = this.r;
        if (r29 == null) goto L33;
        r29.addMessageListener(MessageType.MEMBER.getKey(), this);
    L33:
        this.t = new CompositeDisposable();
        final rx1.g r30 = g();
        if (r30 == null) goto L38;
        rx1.f r31 = r30.a;
        if (r31 == null) goto L38;
        View r32 = r31.c;
    L40:
        if ((r32 instanceof com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) == true) goto L42;
        r32 = null;
    L42:
        com.bytedance.android.live.liveinteract.floatwindow.applywindow.a r33 = (com.bytedance.android.live.liveinteract.floatwindow.applywindow.a) r32;
        if (r33 == null) goto L64;
        List<ILinkPlayerInfoBridge> r34 = this.m;
        Intrinsics.checkNotNullParameter(r20, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r34, "newOnlineUserList");
        r33.k = r20;
        ArrayList r35 = (ArrayList) r33.l;
        r35.clear();
        r35.addAll(r34);
        RecyclerView r36 = r33.c;
        if (r36 == null) goto L47;
        r36.setVisibility(0);
    L47:
        ViewGroup r37 = r33.g;
        if (r37 == null) goto L50;
        r37.setVisibility(0);
    L50:
        ViewGroup r38 = r33.i;
        if (r38 == null) goto L53;
        r38.setVisibility(8);
    L53:
        ViewGroup r39 = r33.d;
        if (r39 == null) goto L56;
        r39.setVisibility(8);
    L56:
        float r40 = s1.y() / s1.w();
        IRoom r41 = r33.k;
        if (r41 == null) goto L61;
        py.k r42 = r41.getCover();
        if (r42 == null) goto L61;
        ImageLoader.bindImage(r33.a, r42, new l3(5, r40, null));
    L61:
        LinkmicApplyFloatViewAvatarAdapter r43 = r33.n;
        if (r43 == null) goto L64;
        r43.notifyDataSetChanged();
    L64:
        if (r30 == null) goto L66;
        r30.e();
    L66:
        if (r30 == null) goto L70;
        rx1.f r44 = r30.a;
        if (r44 == null) goto L70;
        r44.a(s1.y() - s1.f(108), s1.f((s1.A() + 44) + 12));
    L70:
        this.f = true;
        this.e = System.currentTimeMillis();
        HashMap r45 = new HashMap();
        r45.put("is_apply_reserve", "1");
        r45.put("open_source", this.g);
        r45.put("is_auto_play", m2.b(this.q));
        boolean r46 = xe0.k.a;
        xe0.k.d(this.n, this.o, this.p, r45);
        TalkRoomBusinessFullLinkMonitor r47 = TalkRoomBusinessFullLinkMonitor.a;
        IRoom r48 = this.l;
        if (r48 == null) goto L73;
        long r49 = r48.getRoomId();
    L74:
        r47.getClass();
        TalkRoomBusinessFullLinkMonitor.x0(r49);
        j(r20, r22, new AnonymousClass2(r30), AnonymousClass3.INSTANCE);
        return;
    L73:
        r49 = 0;
    L38:
        r32 = null;
    L14:
        r115 = null;
        goto L15
    }
}
