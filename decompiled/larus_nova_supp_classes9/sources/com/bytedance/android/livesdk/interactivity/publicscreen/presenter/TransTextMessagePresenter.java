package com.bytedance.android.livesdk.interactivity.publicscreen.presenter;

import aa2.a0;
import aa2.m;
import aa2.p;
import aa2.r;
import aa2.s;
import aa2.u;
import aa2.w;
import aa2.y;
import aa2.z;
import am2.x;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.g1;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.l0;
import com.bytedance.android.live.base.model.message.l4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.base.model.message.q0;
import com.bytedance.android.live.base.model.message.r0;
import com.bytedance.android.live.base.model.message.r1;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.message.t5;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.message.v0;
import com.bytedance.android.live.base.model.message.w0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.PublicAreaBadgeInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.n0;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.utils.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.l;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.TextMessageTracer;
import com.bytedance.android.livesdk.interactivity.api.settings.config.k0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u0;
import com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin.ChatRoomAuthPlugin;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.IPSMessageRepoManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.batch.PsFirstFetchMsgBatchHelper;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.PSFirstMessageType;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.PublicScreenStateHelper;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.e;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.k;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.MessageHeatUtil;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.f0;
import com.bytedance.android.livesdk.interactivity.textmessage.model.b0;
import com.bytedance.android.livesdk.interactivity.textmessage.model.c0;
import com.bytedance.android.livesdk.interactivity.textmessage.model.i0;
import com.bytedance.android.livesdk.interactivity.textmessage.model.v;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.h7;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.message.model.qa;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenAttachments;
import com.bytedance.android.livesdkapi.depend.model.live.RoomPublicScreenInfo;
import com.bytedance.android.livesdkapi.message.BottomPinInfo;
import com.bytedance.android.livesdkapi.message.HoverInfo;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PersonalizedDisplayInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ec2.g;
import ec2.p1;
import fa2.c;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import r42.h;
import r52.a4;
import r52.b4;
import vlc.d;
import vlc.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class TransTextMessagePresenter extends n<ITextMessageView> implements aa2.a, j, v92.b, Observer<KVData>, l {
    public static final int Y = 0;
    public final o A;
    public final com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.a B;
    public final ja2.b C;
    public final IPSMessageRepoManager D;
    public final u E;
    public final PublicScreenStateHelper F;
    public final boolean G;
    public final Set<String> H;
    public final e I;
    public com.bytedance.android.livesdk.interactivity.publicscreen.utils.l J;
    public final k0 K;
    public c L;
    public boolean M;
    public long N;
    public long O;
    public boolean P;
    public PsFirstFetchMsgBatchHelper Q;
    public Disposable R;
    public Disposable S;
    public final boolean T;
    public final b U;
    public a V;
    public aa2.n W;
    public boolean X;
    public IRoom e;
    public final List<f<?>> f;
    public final ua2.a g;
    public PublicAreaBadgeInfo h;
    public final boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final List<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j> m;
    public t92.a n;
    public int o;
    public int p;
    public boolean q;
    public PublishSubject r;
    public boolean s;
    public boolean t;
    public final Handler u;
    public final lc2.b v;
    public v92.c w;
    public h x;
    public boolean y;
    public final q92.a z;

    public class a implements ja2.b.a {
        @Override // ja2.b.a
        public final void b() {
        }

        public a() {
        }

        @Override // ja2.b.a
        public final void c(f<?> r2) {
            com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.r(r2);
        }

        @Override // ja2.b.a
        public final void a(f<?> r2, int r3) {
            if (r3 != 1) goto L5;
            com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.e(r2);
            return;
        L5:
            if (r3 != 2) goto L7;
            com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.q(r2);
            return;
        L7:
            if (r3 != 3) goto L15;
            com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.h(r2);
            return;
        }
    }

    public class b {
        public final /* synthetic */ TransTextMessagePresenter a;

        public b(TransTextMessagePresenter r1) {
            this.a = r1;
        }
    }

    public void A0() {
    }

    public void B0(int r1) {
    }

    public void C0(Boolean r1, PublicScreenHeatState r2, com.bytedance.android.livesdk.interactivity.api.publicscreen.model.f r3, PSMessageHeatState r4) {
    }

    public boolean E0(f<?> r1) {
        return false;
    }

    public boolean F0(f<?> r1) {
        return false;
    }

    public boolean G0(f<?> r1) {
        return false;
    }

    @Override // aa2.a
    public final f Z() {
        int r0 = 0;
    L4:
        if (r0 >= ((ArrayList) this.f).size()) goto L14;
        if (8 == ((f) ListProtector.get(this.f, r0)).getType()) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        f r1 = (f) ListProtector.remove(this.f, r0);
        ITextMessageView r2 = ((q46.b) this).a;
        if (r2 != null) goto L11;
    L13:
        return r1;
    L11:
        if (r2.d() == false) goto L13;
        ((q46.b) this).a.V50(r0, true);
        goto L13
    L14:
        return null;
    }

    @Override // aa2.a
    public final int d() {
        int r0 = 0;
    L4:
        if (r0 >= ((ArrayList) this.f).size()) goto L9;
        if (8 == ((f) ListProtector.get(this.f, r0)).getType()) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public void i0(t r1) {
    }

    public void q0(f<?> r1) {
    }

    public void r0(f<?> r1, ShowArea r2) {
    }

    public void u0() {
    }

    public boolean v0(f<?> r1) {
        return false;
    }

    public void w0(f<?> r1) {
    }

    public void x0(int r1, long r2) {
    }

    public boolean z0(t r1, long r2) {
        return false;
    }

    static {
        Y = ((Integer) g.a.getValue()).intValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final boolean E() {
        return this.I.a(PSFirstMessageType.REALTIME);
    }

    @Override // aa2.a
    public final w G() {
        return new w(this);
    }

    public final void I0() {
        if (this.x == null) goto L6;
        return;
    L6:
        if (i.a(null, ((n) this).c) != null) goto L9;
        ALogger.e("HISTORY_COMMENT_TAG", "getInteractivityContext failed in Presenter");
        return;
    L9:
        h r0 = (h) i.a(null, ((n) this).c).getHistoryDataManager().getValue();
        this.x = r0;
        if (r0 != null) goto L13;
        ALogger.e("HISTORY_COMMENT_TAG", "historyChatDataManager in InteractivityContext is null");
        return;
    }

    @Override // aa2.a
    public final void N() {
        Iterator r0 = ((ArrayList) this.f).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        f r1 = (f) r0.next();
        if (r1 == null) goto L4;
        r1.F = null;
        goto L4
    }

    @Override // aa2.a
    public final boolean a() {
        h r0 = this.x;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.b.a() == true) goto L9;
        return false;
    L9:
        if (this.y == false) goto L12;
        return false;
    L12:
        if (this.X == false) goto L14;
        return true;
    L14:
        this.X = true;
        h r1 = this.x;
        d r2 = ((n) this).d;
        aa2.e r3 = new aa2.e(this);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "messageManager");
        Intrinsics.checkNotNullParameter(r3, "onHistoryCallBack");
        if (r42.g.b() == false) goto L18;
        r1.b.b(r2, r3);
    L18:
        return true;
    }

    public final q46.a b0() {
        return ((q46.b) this).a;
    }

    @Override // aa2.a
    public final boolean canLoadMore() {
        if (this.I.a(PSFirstMessageType.HISTORY) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return false;
    L11:
        if (r42.g.b() == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (this.I.a(PSFirstMessageType.REALTIME) == true) goto L8;
        r0 = false;
        goto L9
    }

    public void e() {
        int r0 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.w.a;
        Intrinsics.checkNotNullParameter(this, "presenter");
        boolean r1 = TextMessageTracer.a;
        TextMessageTracer.A("TransTextMessagePresenter unload model, this is " + hashCode() + ')');
        DataCenter r2 = ((n) this).c;
        if (r2 == null) goto L5;
        r2.removeObserver(this);
    L5:
        d r3 = ((n) this).d;
        if (r3 == null) goto L8;
        r3.v(this);
    L8:
        PublishSubject r4 = this.r;
        if (r4 == null) goto L11;
        r4.onComplete();
    L11:
        this.D.unbind(this.E);
        ((ArrayList) this.m).clear();
        ja2.b r5 = this.C;
        if (r5 == null) goto L16;
        a r6 = this.V;
        if (r6 == null) goto L16;
        Intrinsics.checkNotNullParameter(r6, "listener");
        ((ArrayList) ((com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a) r5).a).remove(r6);
        this.V = null;
    L16:
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.a r7 = this.B;
        if (r7 == null) goto L25;
        aa2.n r8 = this.W;
        if (r8 == null) goto L21;
        Intrinsics.checkNotNullParameter(r8, "listener");
        ((ArrayList) r7.a).remove(r8);
    L21:
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.a r9 = this.B;
        if ((r9 instanceof com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c) == false) goto L24;
        ((com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c) r9).d = null;
    L24:
        this.W = null;
    L25:
        this.B.i();
        this.C.onUnload();
        this.F.d.removeCallbacksAndMessages(null);
        this.l = false;
        Disposable r10 = this.R;
        if (r10 != null) goto L28;
    L30:
        this.R = null;
        if (i.a(null, ((n) this).c) == null) goto L34;
        i.a(null, ((n) this).c).getHasLoadModel().setValue(Boolean.FALSE);
        return;
    L34:
        return;
    L28:
        if (r10.isDisposed() == true) goto L30;
        this.R.dispose();
        goto L30
    }

    @Override // s42.d
    public final PublishSubject i() {
        if (this.z.i == false) goto L5;
    L8:
        PublishSubject r0 = this.r;
        if (r0 == null) goto L11;
        r0.onComplete();
    L11:
        PublishSubject r1 = PublishSubject.create();
        this.r = r1;
        return r1;
    L5:
        if (this.l == true) goto L8;
        return null;
    }

    public final void j0() {
        Disposable r0 = this.S;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.k = false;
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.a r1 = this.B;
        if ((r1 instanceof com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c) == true) goto L8;
        r1 = null;
    L8:
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c r2 = (com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c) r1;
        if (r2 == null) goto L12;
        r2.m = 0;
        return;
    }

    public final n42.a l0() {
        DataCenter r0 = ((n) this).c;
        if (r0 == null) goto L11;
        if (((Boolean) r0.get("data_is_portrait", Boolean.TRUE)).booleanValue() == true) goto L11;
        q92.a r1 = this.z;
        if (r1.j == false) goto L11;
        return r1.l;
    L11:
        return this.z.k;
    }

    public final boolean m0() {
        o r0 = this.A;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (Boolean.TRUE.equals(r0.isAnchor()) == false) goto L7;
        return true;
    }

    public void t0() {
        this.I.b(PSFirstMessageType.REALTIME);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final void x() {
        ((ArrayList) this.f).clear();
        this.s = true;
        this.j = false;
        j0();
        ITextMessageView r0 = ((q46.b) this).a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d() == false) goto L9;
        ((q46.b) this).a.Ev();
        return;
    }

    @Override // aa2.a
    public final void detachView() {
        super.detachView();
        ALogger.i("PublicScreenFirstMessageProcessorV2", "detachView");
        int r0 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.w.a;
        Intrinsics.checkNotNullParameter(this, "presenter");
        boolean r1 = TextMessageTracer.a;
        TextMessageTracer.A("TransTextMessagePresenter detach, this is " + hashCode() + ')');
        e();
    }

    @Override // aa2.a
    public final boolean T() {
        return this.k;
    }

    @Override // s42.d
    public final List<f<?>> getMessageList() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final boolean q() {
        return this.s;
    }

    @Override // aa2.a
    public final int r() {
        return this.p;
    }

    public static void D0(va2.a r5) {
        Iterator<Map.Entry<String, Integer>> r0 = r5.a.entrySet().iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r2 = r2 + r0.next().getValue().intValue();
        goto L4
    L6:
        if (r2 <= 0) goto L15;
        HashMap r1 = new HashMap();
        r1.put("comment_send_num", String.valueOf(r2));
        JSONObject r3 = new JSONObject();
        Iterator<Map.Entry<String, Integer>> r6 = r5.a.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        Map.Entry<String, Integer> r4 = r6.next();
        r3.put(r4.getKey(), String.valueOf(r4.getValue().intValue()));
        goto L9
    L11:
        r1.put("history_comment_type", r3.toString());
        j0.l().sendLog("livesdk_history_comment_auto_show", r1, new Object[]{new x(), IRoom.class});
        return;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [aa2.m, java.lang.Object] */
    @Override // aa2.a
    public final void A(ITextMessageView r4) {
        super.c0(r4);
        ALogger.i("PublicScreenFirstMessageProcessorV2", "attachView");
        int r5 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.w.a;
        Intrinsics.checkNotNullParameter(this, "presenter");
        boolean r6 = TextMessageTracer.a;
        TextMessageTracer.A("TransTextMessagePresenter attach, this is " + hashCode() + ')');
        DataCenter r7 = ((n) this).c;
        if (r7 == null) goto L6;
        W(r7);
    L6:
        if (m0() == false) goto L15;
        b4 r8 = b4.a;
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.u) r8.getValue()).f() == true) goto L10;
        return;
    L10:
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.u) r8.getValue()).g() == false) goto L17;
        MiddlewareRoomContext r9 = MiddlewareRoomContext.getShared(((n) this).c);
        if (r9 == null) goto L18;
        ?? r0 = new m(this);
        Intrinsics.checkNotNullParameter(r9, "$this$observeRtcRoomMessageManagerRelease");
        Intrinsics.checkNotNullParameter(r0, "releaseFunc");
        this.R = r9.getRtcRoomMessageManager().a().subscribe(new n0(r9, r0));
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final void C(Function1<? super f<?>, Boolean> r3) {
        if (this.k == true) goto L5;
        return;
    L5:
        if (((ArrayList) this.f).isEmpty() == true) goto L11;
        List<f<?>> r0 = this.f;
        if (((Boolean) r3.invoke(ListProtector.get(r0, ((ArrayList) r0).size() - 1))).booleanValue() == false) goto L12;
        j0();
        return;
    L12:
        return;
    }

    @Override // fa2.d
    public final void H(c r1) {
        this.L = r1;
    }

    public final void H0(List<? extends f<? extends t>> r21) {
        if (r21 != null) goto L5;
        return;
    L5:
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator<? extends f<? extends t>> r4 = r21.iterator();
    L6:
        long r6 = 0;
        if (r4.hasNext() == false) goto L11;
        f<? extends t> r5 = r4.next();
        if (r5.q.longValue() <= 0) goto L6;
        z32.e.a(PSRealtimeIndicatorNode.AsyncRendConsume, System.currentTimeMillis() - r5.q.longValue());
        goto L6
    L11:
        Iterator<? extends f<? extends t>> r7 = r21.iterator();
    L12:
        final int r9 = 0;
        if (r7.hasNext() == false) goto L71;
        final f<? extends t> r8 = r7.next();
        if (r8 == null) goto L49;
        boolean r13 = TextMessageTracer.a;
        TextMessageTracer.z(new aa2.g(r8));
        DataCenter r14 = ((n) this).c;
        if (r14 == null) goto L49;
        boolean r15 = ((Boolean) r14.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        List<String> r16 = wa2.a.a;
        Intrinsics.checkNotNullParameter(r8, "absTextMessage");
        if ((r8 instanceof v) == false) goto L49;
        va r17 = ((v) r8).b;
        if ((r17 instanceof va) == false) goto L49;
        if (r15 == false) goto L25;
        long r18 = r17.z1();
    L27:
        if (r18 != 6) goto L33;
        HashMap r19 = new HashMap();
        r19.put("message_type", "share");
        if (r15 == false) goto L31;
        Object r110 = "1";
    L32:
        r19.put("is_anchor", r110);
        j0.l().sendLog("livesdk_special_enter_room_message_show", r19, new Object[]{IRoom.class, x.class});
        goto L49
    L31:
        r110 = "0";
        goto L32
    L33:
        Long r111 = Long.valueOf(r18);
        long r112 = r111.longValue();
        if (r112 > r6) goto L36;
    L38:
        boolean r10 = false;
    L39:
        if (r10 == true) goto L42;
        r111 = null;
    L42:
        if (r111 == null) goto L49;
        long r11 = r111.longValue();
        HashMap r113 = new HashMap();
        r113.put("info_type", ListProtector.get(wa2.a.a, (int) r11));
        if (r15 == false) goto L46;
        Object r20 = "1";
    L47:
        r113.put("is_anchor", r20);
        j0.l().sendLog("livesdk_enter_room_relation_show", r113, new Object[]{IRoom.class, x.class});
        goto L49
    L46:
        r20 = "0";
        goto L47
    L36:
        if (r112 >= wa2.a.a.size()) goto L38;
        r10 = true;
        goto L39
    L25:
        r18 = r17.Z0();
    L49:
        if (r8 != null) goto L52;
    L64:
        if (r9 != 1) goto L66;
        r1.add(r8);
    L70:
        boolean r23 = TextMessageTracer.a;
        TextMessageTracer.z(new aa2.t(r9, r8));
        r6 = 0;
        goto L12
    L66:
        if (r9 != 2) goto L68;
        r2.add(r8);
        goto L70
    L68:
        if (r9 != 3) goto L70;
        r3.add(r8);
        goto L70
    L52:
        if (k.a(r8) == false) goto L55;
        r9 = 3;
        goto L64
    L55:
        if (n0(r8) == false) goto L61;
        if (F0(r8) == true) goto L64;
        r9 = 2;
        goto L64
    L61:
        if (G0(r8) == true) goto L64;
        r9 = 1;
        goto L64
    L71:
        b r24 = this.U;
        if (r24 == null) goto L226;
        long r25 = System.currentTimeMillis();
        if (r2.size() <= 0) goto L122;
        t92.a r26 = r24.a.n;
        if (r26.c.a() == true) goto L80;
    L87:
        boolean r27 = false;
    L89:
        if (r27 == true) goto L94;
        int r28 = 0;
    L92:
        if (r28 >= r2.size()) goto L122;
        TransTextMessagePresenter r29 = r24.a;
        final f<?> r114 = (f) ListProtector.get(r2, r28);
        r29.getClass();
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.f(r114);
        boolean r30 = TextMessageTracer.a;
        TextMessageTracer.z(new aa2.j(r114));
        r28 = r28 + 1;
        goto L92
    L94:
        final f<?> r31 = (f) ListProtector.get(r2, 0);
        t92.a r33 = r24.a.n;
        T r34 = r31.b;
        s92.b r35 = r33.c;
        if (r34 != 0) goto L97;
        r35.getClass();
    L98:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n.b(new a0(r31));
        TransTextMessagePresenter r36 = r24.a;
        if (r36.j == true) goto L101;
    L108:
        int r37 = ((ArrayList) r24.a.f).size();
        ListProtector.add(r24.a.f, r37, r31);
        ITextMessageView r38 = ((q46.b) r24.a).a;
        if (r38 != null) goto L111;
    L113:
        r24.a.n.getClass();
        r24.a.j = true;
    L114:
        r24.a.getClass();
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.o(r31);
        com.bytedance.android.livesdk.interactivity.api.h r39 = i.a(null, ((n) r24.a).c);
        if (r39 == null) goto L117;
        l22.d r40 = r39.getBaseUserActionCollector();
    L118:
        if (r40 == null) goto L120;
        r40.b(r31);
    L120:
        r24.a.r0(r31, ShowArea.Fold);
        goto L122
    L117:
        r40 = null;
        goto L118
    L111:
        if (r38.d() == false) goto L113;
        ((q46.b) r24.a).a.DD(r37, 1, r25);
        goto L113
    L101:
        if (((ArrayList) r36.f).size() <= 0) goto L108;
        int r41 = ((ArrayList) r24.a.f).size() - 1;
        ListProtector.remove(r24.a.f, r41);
        ListProtector.add(r24.a.f, r41, r31);
        ITextMessageView r43 = ((q46.b) r24.a).a;
        if (r43 != null) goto L105;
    L107:
        r24.a.n.getClass();
        goto L114
    L105:
        if (r43.d() == false) goto L107;
        ((q46.b) r24.a).a.XD(r41, r25);
        goto L107
    L97:
        r35.a = r34;
        r35.b = System.currentTimeMillis();
        goto L98
    L80:
        if (r26.i != (-1)) goto L82;
    L88:
        r26.i = System.currentTimeMillis();
        r27 = true;
        goto L89
    L82:
        if ((System.currentTimeMillis() - r26.i) < r26.h.intValue()) goto L84;
        boolean r44 = true;
    L85:
        if (r44 == false) goto L87;
    L84:
        r44 = false;
    L122:
        if (r1.size() > 0) goto L124;
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.a r45 = null;
    L175:
        if (r3.size() <= 0) goto L209;
        final f r46 = (f) ListProtector.get(r3, 0);
        TransTextMessagePresenter r47 = r24.a;
        if (r47.j == true) goto L180;
    L187:
        int r48 = ((ArrayList) r24.a.f).size();
        ListProtector.add(r24.a.f, r48, r46);
        ITextMessageView r49 = ((q46.b) r24.a).a;
        if (r49 != null) goto L190;
    L192:
        r24.a.n.getClass();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n.b(new z(r46));
    L193:
        final TransTextMessagePresenter r50 = r24.a;
        r50.j0();
        r50.k = true;
        int r51 = k.a;
        Intrinsics.checkNotNullParameter(r46, "message");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.i r53 = r46.s();
        if (r53 == null) goto L200;
        IPublicAreaCommon r54 = r53.c();
        if (r54 == null) goto L200;
        BottomPinInfo r55 = r54.getBottomPinInfo();
        if (r55 == null) goto L200;
        long r56 = r55.getDuration();
    L201:
        long r57 = r56 * 1000;
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.a r58 = r50.B;
        long r115 = System.currentTimeMillis() + r57;
        if ((r58 instanceof com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c) == false) goto L205;
        r45 = r58;
    L205:
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c r59 = (com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c) r45;
        if (r59 == null) goto L208;
        r59.m = r115;
    L208:
        r50.S = Observable.timer(r57, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new aa2.h(r50), new aa2.i());
        r24.a.j = false;
    L200:
        r56 = 0;
        goto L201
    L190:
        if (r49.d() == false) goto L192;
        ((q46.b) r24.a).a.DD(r48, 1, r25);
        goto L192
    L180:
        if (((ArrayList) r47.f).isEmpty() == true) goto L187;
        int r60 = ((ArrayList) r24.a.f).size() - 1;
        ListProtector.remove(r24.a.f, r60);
        ListProtector.add(r24.a.f, r60, r46);
        ITextMessageView r61 = ((q46.b) r24.a).a;
        if (r61 != null) goto L184;
    L186:
        r24.a.n.getClass();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n.b(new y(r46));
        goto L193
    L184:
        if (r61.d() == false) goto L186;
        ((q46.b) r24.a).a.XD(r60, r25);
    L209:
        B0(((ArrayList) this.f).size());
        return;
    L124:
        TransTextMessagePresenter r63 = r24.a;
        if (r63.j == false) goto L142;
        t92.a r64 = r63.n;
        r64.getClass();
        if ((System.currentTimeMillis() - r64.i) < r64.h.intValue()) goto L129;
        boolean r65 = true;
    L130:
        if (r65 == true) goto L132;
    L134:
        boolean r66 = false;
    L135:
        if (r66 == false) goto L142;
        if (((ArrayList) r24.a.f).size() <= 0) goto L142;
        int r67 = ((ArrayList) r24.a.f).size() - 1;
        ListProtector.remove(r24.a.f, r67);
        ITextMessageView r68 = ((q46.b) r24.a).a;
        if (r68 == null) goto L141;
        r68.V50(r67, false);
    L141:
        TransTextMessagePresenter r69 = r24.a;
        r69.n.i = -1;
        r69.j = false;
        goto L142
    L132:
        if (r64.c.a() == false) goto L134;
        r66 = true;
        goto L135
    L129:
        r65 = false;
    L142:
        r45 = null;
        com.bytedance.android.livesdk.interactivity.api.h r70 = i.a(null, ((n) r24.a).c);
        if (r70 == null) goto L145;
        l22.d r71 = r70.getBaseUserActionCollector();
    L146:
        TransTextMessagePresenter r73 = r24.a;
        if (r73.j == true) goto L151;
        if (r73.k == true) goto L151;
    L153:
        int r74 = ((ArrayList) r24.a.f).size();
    L154:
        int r116 = 0;
    L156:
        if (r116 >= r1.size()) goto L165;
        ListProtector.add(r24.a.f, r74 + r116, (f) ListProtector.get(r1, r116));
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L160;
    L162:
        if (r71 == null) goto L164;
        r71.b((f) ListProtector.get(r1, r116));
    L164:
        r24.a.r0((f) ListProtector.get(r1, r116), ShowArea.Scroll);
        r116 = r116 + 1;
        goto L156
    L160:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n.a == false) goto L162;
        f r117 = (f) ListProtector.get(r1, r116);
        goto L162
    L165:
        ITextMessageView r75 = ((q46.b) r24.a).a;
        if (r75 != null) goto L168;
    L170:
        int r76 = 0;
    L172:
        if (r76 >= r1.size()) goto L175;
        TransTextMessagePresenter r77 = r24.a;
        f<?> r118 = (f) ListProtector.get(r1, r76);
        r77.getClass();
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.n(r118);
        r76 = r76 + 1;
        goto L172
    L168:
        if (r75.d() == false) goto L170;
        ((q46.b) r24.a).a.DD(r74, r1.size(), r25);
        ((q46.b) r24.a).a.sU(r1.size());
    L151:
        if (((ArrayList) r73.f).isEmpty() == true) goto L153;
        r74 = ((ArrayList) r24.a.f).size() - 1;
        goto L154
    L145:
        r71 = null;
        goto L146
    }

    public final void I(tlc.d r3) {
        if ((r3 instanceof t) == false) goto L8;
        f<?> r4 = i0.e((t) r3, l0().m, this.e);
        if (r4 == null) goto L9;
        J0(r4);
        return;
    L9:
        return;
    }

    public final void J0(f<?> r4) {
        String r0 = jc1.k.f(IMiddlewareUserService.class).user().n();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        if ("0".equals(r0) == false) goto L7;
        return;
    L7:
        if (TextUtils.equals(r0, r4.y()) == false) goto L34;
        T r1 = r4.b;
        if ((r1 instanceof t) == true) goto L12;
    L24:
        IBaseUser r5 = r4.x();
        if (r5 != null) goto L27;
        return;
    L27:
        if (r5.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.d.class) == null) goto L33;
        this.h = ((com.bytedance.android.livesdk.interactivity.service.model.d) r5.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.d.class)).getPublicAreaBadgeInfo();
        return;
    L33:
        return;
    L12:
        if (TextUtils.equals(r1.getMessageMethod(), "WebcastChatMessage") == true) goto L24;
        if (TextUtils.equals(r1.getMessageMethod(), "WebcastGiftMessage") == true) goto L24;
        if (TextUtils.equals(r1.getMessageMethod(), "WebcastDoodleGiftMessage") == true) goto L24;
        if (TextUtils.equals(r1.getMessageMethod(), "GiftGroupMessage") == true) goto L24;
        if (TextUtils.equals(r1.getMessageMethod(), "WebcastMemberMessage") == true) goto L24;
        if (TextUtils.equals(r1.getMessageMethod(), "WebcastScreenChatMessage") == true) goto L24;
        return;
    }

    @Override // aa2.a
    public final void Q(t r3) {
        int r0 = 0;
    L4:
        if (r0 >= ((ArrayList) this.f).size()) goto L18;
        if (r3 == ((f) ListProtector.get(this.f, r0)).b) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        ListProtector.remove(this.f, r0);
        ITextMessageView r4 = ((q46.b) this).a;
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.d() == false) goto L17;
        ((q46.b) this).a.V50(r0, true);
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final void V(Function1<? super f<?>, Boolean> r2) {
        this.C.j(r2);
    }

    /* JADX WARN: Type inference failed for: r10v40, types: [aa2.n, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.o] */
    /* JADX WARN: Type inference failed for: r6v0, types: [aa2.r] */
    public void W(DataCenter r10) {
        int r0 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.w.a;
        Intrinsics.checkNotNullParameter(this, "presenter");
        boolean r1 = TextMessageTracer.a;
        TextMessageTracer.A("TransTextMessagePresenter load model, this is " + hashCode() + ')');
        ((n) this).c = r10;
        this.e = (IRoom) r10.get("data_room", null);
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.o.a(((n) this).c) == false) goto L5;
        this.Q = new PsFirstFetchMsgBatchHelper();
    L5:
        IRoom r11 = this.e;
        w r2 = new w(this);
        q92.a r3 = this.z;
        this.n = new t92.a(r11, r2, r3.g, r3.h);
        this.D.bind(this.E);
        boolean r4 = true;
        if (PublicScreenABHelper.P == false) goto L8;
    L16:
        A0();
        ((ArrayList) this.m).add(new jc2.b(this.e, m0(), new r(this)));
        ((ArrayList) this.m).add(new u92.d());
        ((ArrayList) this.m).add(new jc2.c(((n) this).c));
        ((ArrayList) this.m).add(new u92.a());
        ((ArrayList) this.m).add(new u92.e());
        ((ArrayList) this.m).add(new u92.c());
        if (this.z.e == false) goto L35;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j> r13 = this.m;
        if (this.e.getGiftMessageStyle() != 3) goto L21;
        boolean r5 = true;
    L23:
        if (this.e.getFansMessageStyle() != 3) goto L25;
        boolean r6 = true;
    L27:
        if (this.e.getShareMessageStyle() != 3) goto L29;
        boolean r7 = true;
    L31:
        if (this.e.getFollowMessageStyle() == 3) goto L34;
        r4 = false;
    L34:
        ((ArrayList) r13).add(new u92.b(r5, r6, r7, r4));
        goto L35
    L29:
        r7 = false;
        goto L31
    L25:
        r6 = false;
        goto L27
    L21:
        r5 = false;
    L35:
        ((ArrayList) this.m).add(new u92.h(this.e));
        if (this.z.f == false) goto L38;
        ((ArrayList) this.m).add(new u92.g());
    L38:
        ((ArrayList) this.m).add(new u92.i(this));
        if (this.z.c == false) goto L42;
        ((ArrayList) this.m).add(new jc2.a());
    L42:
        if (m0() == false) goto L44;
        boolean r14 = ((Boolean) PublicScreenABHelper.z.getValue()).booleanValue();
    L45:
        if (r14 == true) goto L47;
        ((ArrayList) this.m).add(new u92.f());
    L47:
        d r15 = ((n) this).d;
        if (r15 == null) goto L51;
        r15.k(this);
    L51:
        if (this.K.publicScreenHeatEnable == false) goto L57;
        IRoom r16 = this.e;
        if (r16 != null) goto L55;
        int r17 = 0;
    L56:
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.l r8 = new com.bytedance.android.livesdk.interactivity.publicscreen.utils.l(r17, this.K);
        this.J = r8;
        C0(null, null, null, r8.a);
        goto L57
    L55:
        r17 = (int) r16.getUserCount();
    L57:
        a r18 = new a();
        this.V = r18;
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a r9 = (com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a) this.C;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r18, "listener");
        ((ArrayList) r9.a).add(r18);
        ?? r19 = new aa2.n(this);
        this.W = r19;
        this.B.b(r19);
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.a r110 = this.B;
        if ((r110 instanceof com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c) == false) goto L60;
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.d r20 = new aa2.o(this);
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c r111 = (com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c) r110;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r20, "listener");
        r111.d = r20;
    L60:
        this.B.g();
        this.C.onLoad();
        PublicScreenStateHelper r112 = this.F;
        r112.d.sendEmptyMessageDelayed(PublicScreenStateHelper.Companion.HandlerMessage.UPDATE_MESSAGE_HEAT_STATE.ordinal(), r112.a.a);
        r112.d.sendEmptyMessageDelayed(PublicScreenStateHelper.Companion.HandlerMessage.UPDATE_COMMENT_MESSAGE_STATE.ordinal(), r112.b.a);
        r112.d.sendEmptyMessageDelayed(PublicScreenStateHelper.Companion.HandlerMessage.UPDATE_INDIVIDUAL_PRIORITY_STATE.ordinal(), r112.c.a);
        if (r112.k.publicScreenHeatEnable == false) goto L66;
        Handler r21 = r112.d;
        int r23 = PublicScreenStateHelper.Companion.HandlerMessage.UPDATE_CHAT_MESSAGE_COUNT.ordinal();
        int r113 = r112.k.heatStatusCalculateInterval;
        if (r113 > 0) goto L65;
        r113 = 5;
    L65:
        r21.sendEmptyMessageDelayed(r23, r113 * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    L66:
        this.j = false;
        j0();
        ((n) this).c.observe("data_room_comment_status", this);
        ((n) this).c.observe("data_push_to_public_screen_open_platfrom_message", this);
        ((n) this).c.observe("data_is_in_float_mode", this);
        if (i.a(null, ((n) this).c) == null) goto L70;
        i.a(null, ((n) this).c).getHasLoadModel().setValue(Boolean.TRUE);
        return;
    L70:
        return;
    L44:
        r14 = ((Boolean) PublicScreenABHelper.A.getValue()).booleanValue();
        goto L45
    L8:
        if (this.I.a <= 0) goto L10;
        boolean r114 = true;
    L11:
        if (r114 == false) goto L13;
        s0 r115 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.k(-10023, "已经收到其他消息-1", null);
        goto L16
    L13:
        com.bytedance.android.livesdk.interactivity.api.h r116 = i.a(null, ((n) this).c);
        if (r116 == null) goto L16;
        r116.getPsTopMessage().c(new aa2.x(this));
        goto L16
    L10:
        r114 = false;
        goto L11
    }

    @Override // aa2.a
    public final void X(f0 r1) {
        this.w = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final void Y(ChatRoomAuthPlugin.a r2) {
        ((ArrayList) this.m).add(r2);
    }

    @Override // aa2.a, v42.b
    public final void b(t r2) {
        this.D.insertLocalMessage(r2);
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        A((ITextMessageView) r1);
    }

    @Override // fa2.d
    public final f<?> f(t r3) {
        return i0.e(r3, l0().m, this.e);
    }

    public final void h0(f r10) {
        q0(r10);
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.b(r10) == false) goto L6;
        return;
    L6:
        if (this.G == false) goto L8;
    L10:
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.p(r10);
        if (this.o != 0) goto L13;
        this.u.postDelayed(new p(this), 1000);
    L13:
        this.o++;
        T r0 = r10.b;
        if (r0 == 0) goto L16;
        r0.setTooMuchMsg(this.q);
    L16:
        DataCenter r1 = ((n) this).c;
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L25;
        r10.e = ((Boolean) r1.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        com.bytedance.live.datacontext.m r3 = jc1.k.f(IRoomContextService.class).getRoomDataContext(((n) this).c, 0).getRoom();
        if (r3 != null) goto L21;
    L23:
        String r4 = BuildConfig.FLAVOR;
    L24:
        r10.f = r4;
        goto L25
    L21:
        if (r3.getValue() == null) goto L23;
        r4 = ((IRoom) r3.getValue()).getOwnerUserIdString();
    L25:
        boolean r5 = false;
        if (this.i == true) goto L28;
    L40:
        Iterator r6 = ((ArrayList) this.m).iterator();
    L42:
        if (r6.hasNext() == false) goto L46;
        if (((com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j) r6.next()).a(r10) == false) goto L42;
        boolean r7 = true;
    L47:
        if (r7 == false) goto L49;
    L194:
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.d(r10);
        return;
    L49:
        if (E0(r10) == true) goto L194;
        String r8 = null;
        if (this.s == false) goto L68;
        this.s = false;
        ITextMessageView r9 = ((q46.b) this).a;
        if (r9 == null) goto L56;
        r9.ZE();
    L56:
        u0();
        k0(r10, true, true);
        if (this.L == null) goto L62;
        if (SelectedMsgABHelper.d(r10) == false) goto L62;
        this.L.y(r10);
    L62:
        if (i.a(null, ((n) this).c) == null) goto L64;
        i.a(null, ((n) this).c).isFirstMessageConsumed().setValue(Boolean.TRUE);
    L64:
        DataCenter r11 = ((n) this).c;
        if (r11 == null) goto L119;
        r11.put("cmd_specific_view_loaded", "cmd_first_chat_view_loaded");
    L119:
        if (this.z.i == false) goto L121;
    L123:
        ua2.a r13 = this.g;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r10, "absTextMessage");
        T r14 = r10.b;
        if (r14 == 0) goto L130;
        String r15 = r14.getMessageMethod();
        if (r15 == null) goto L130;
        r2 = r15;
    L130:
        if (r13.d.contains(r2) == false) goto L154;
        o7 r16 = r10.b;
        if (Intrinsics.areEqual(r2, "WebcastGiftMessage") == true) goto L135;
    L151:
        ArrayDeque<f<?>> r17 = r13.a;
        if (r17.size() >= 100) goto L154;
        r17.add(r10);
        goto L154
    L135:
        if ((r16 instanceof o7) == false) goto L151;
        o7 r18 = r16;
        if (r18.getClientGiftSource() != 1) goto L139;
    L144:
        h1 r19 = r18.getGift();
    L145:
        if (r19 == null) goto L151;
        if (r19.isRepeat() == false) goto L151;
        if (r18.isLocal() == false) goto L151;
    L139:
        if (r18.getClientGiftSource() == 0) goto L141;
    L143:
        r19 = null;
        goto L145
    L141:
        if (r18.getGift() == null) goto L143;
    L154:
        PublicScreenStateHelper r20 = this.F;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r10, "message");
        r20.f++;
        r20.h++;
        Lazy r21 = MessageHeatUtil.a;
        Intrinsics.checkNotNullParameter(r10, "message");
        boolean r23 = r10 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.z;
        if (r23 == false) goto L163;
        PublicScreenConfig$MessageModelType r24 = ((com.bytedance.android.livesdk.interactivity.textmessage.model.z) r10).H.getType();
        if (r24 != PublicScreenConfig$MessageModelType.EMOJI_CHAT) goto L159;
    L181:
        r5 = true;
    L182:
        if (r5 == false) goto L199;
        int r25 = r20.g + 1;
        r20.g = r25;
        boolean r26 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        Intrinsics.checkNotNullParameter(r10, "message");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a == false) goto L200;
        StringBuilder r27 = new StringBuilder("收到一条评论消息，消息类型为：");
        if (r23 == false) goto L189;
        r8 = ((com.bytedance.android.livesdk.interactivity.textmessage.model.z) r10).H.getType().name();
    L192:
        r27.append(r8);
        r27.append("，评论消息总数为");
        r27.append(r25);
        ALogger.e("PS_CHAT_COUNT", r27.toString());
        return;
    L189:
        T r110 = r10.b;
        if (r110 == 0) goto L192;
        r8 = r110.getMessageMethod();
        goto L192
    L200:
        return;
    L199:
        return;
    L159:
        if (r24 == PublicScreenConfig$MessageModelType.INTERACTIVITY_SHARE) goto L181;
        if (r24 != PublicScreenConfig$MessageModelType.VIDEO_SHARE) goto L182;
    L163:
        T r28 = r10.b;
        if (r28 == 0) goto L182;
        if (r28.isFromFirstRequest() == true) goto L182;
        if ((r28 instanceof com.bytedance.android.live.base.model.message.k0) == true) goto L181;
        if ((r28 instanceof com.bytedance.android.live.base.model.message.r) == true) goto L181;
        if ((r28 instanceof v0) == true) goto L181;
        if ((r28 instanceof t5) == true) goto L181;
        if ((r28 instanceof h4) == true) goto L181;
        if ((r28 instanceof s3) == true) goto L181;
        if ((r28 instanceof m1) == false) goto L182;
    L121:
        if (this.l == true) goto L123;
    L68:
        if (TextUtils.equals(r10.y(), jc1.k.f(IMiddlewareUserService.class).user().n()) == false) goto L81;
        com.bytedance.android.live.base.model.message.k0 r29 = r10.b;
        boolean r30 = r29 instanceof com.bytedance.android.live.base.model.message.k0;
        if (r30 == true) goto L72;
    L74:
        if (r30 == false) goto L81;
        k0(r10, true, true);
        if (this.L == null) goto L119;
        if (SelectedMsgABHelper.d(r10) == false) goto L119;
        this.L.y(r10);
        goto L119
    L72:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.o.b(((n) this).c) == false) goto L74;
        r30 = !r29.getOrInitPublicAreaCommon().isFirstAggregateHistoryMessage();
    L81:
        if (r10.z() == false) goto L83;
    L113:
        k0(r10, false, true);
        if (this.L == null) goto L119;
        if (SelectedMsgABHelper.d(r10) == false) goto L119;
        this.L.K(r10);
        goto L119
    L83:
        if (this.P == false) goto L88;
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.c(r10.b) == true) goto L113;
    L88:
        if (n0(r10) == false) goto L90;
    L98:
        u3 r31 = r10.b;
        if ((r31 instanceof u3) == false) goto L103;
        u3 r33 = r31;
        if (r33.getOrInitPublicAreaCommon() == null) goto L103;
        boolean r34 = r33.getOrInitPublicAreaCommon().isFirstFetchBatchMsg();
    L104:
        if (r34 == true) goto L106;
    L108:
        this.C.h(r10, n0(r10), o0(r10));
        if (this.L == null) goto L119;
        if (SelectedMsgABHelper.d(r10) == false) goto L119;
        this.L.B(r10);
        goto L119
    L106:
        if (m0() == true) goto L108;
        k0(r10, true, true);
    L103:
        r34 = false;
        goto L104
    L90:
        if ((System.currentTimeMillis() - this.N) <= this.O) goto L98;
        if (m0() == false) goto L98;
        k0(r10, false, true);
        if (this.L == null) goto L119;
        if (SelectedMsgABHelper.d(r10) == false) goto L119;
        this.L.K(r10);
        goto L119
    L46:
        r7 = false;
        goto L47
    L28:
        if (r10.d() == false) goto L30;
        r10.l = this.h;
        goto L40
    L30:
        T r35 = r10.b;
        if (r35 != 0) goto L33;
    L37:
        boolean r36 = false;
    L38:
        if (r36 == true) goto L40;
        J0(r10);
        goto L40
    L33:
        if (r35.isInsert() == false) goto L37;
        if (r10.A() == false) goto L37;
        r36 = true;
        goto L38
    L8:
        if (r10.B().booleanValue() == true) goto L10;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final f<?> m(Function1<? super f<?>, Boolean> r2) {
        return this.C.b(r2);
    }

    public boolean n0(f r21) {
        if (r21.r != null) goto L296;
        t92.a r2 = this.n;
        q0 r3 = r21.b;
        r2.getClass();
        IMiddlewareUserService r4 = jc1.k.f(IMiddlewareUserService.class);
        if (r4 == null) goto L7;
        com.bytedance.android.livesdk.user.e r5 = r4.user();
    L9:
        if (r5 != null) goto L11;
    L13:
        String r6 = BuildConfig.FLAVOR;
    L14:
        boolean r10 = false;
        if ((r3 instanceof q0) == false) goto L44;
        q0 r7 = r3;
        if (r7.H0(jc1.k.n(IMiddlewareUserService.class).user().b()) == true) goto L262;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r8 = r2.e;
        if (r2.a() == false) goto L231;
        w r9 = (w) r8;
        if (r9.a() == false) goto L31;
        IRoomAuthStatus r11 = r2.d.getRoomAuthStatus();
        if (r11 == null) goto L31;
        if (r11.isAnchorColdMessageTiled() != true) goto L31;
        m0 r13 = r7.getBaseMessage();
        if (r13 == null) goto L31;
        if (r13.getAnchorFoldTypeV2() != 3) goto L31;
        boolean r14 = false;
    L33:
        if (r9.b() == false) goto L263;
        m0 r15 = r7.getBaseMessage();
        if (r15 != null) goto L37;
    L38:
        m0 r16 = r7.getBaseMessage();
        if (r16 == null) goto L263;
        if (r16.getAnchorFoldTypeV2() != 2) goto L263;
    L37:
        if (r15.getAnchorFoldTypeV2() == 1) goto L231;
    L263:
        r21.r = Boolean.valueOf(r14);
        if (this.T == false) goto L296;
        boolean r17 = m0();
        IRoom r18 = this.e;
        if (this.F.e != PublicScreenHeatState.COLD) goto L268;
        boolean r19 = true;
    L269:
        int r20 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.f.a;
        Intrinsics.checkNotNullParameter(r21, "textMessage");
        PersonalizedDisplayInfo r23 = r21.t();
        if (r23 != null) goto L272;
    L281:
        if (r17 == false) goto L296;
        if (r18 == null) goto L296;
        IRoomAuthStatus r24 = r18.getRoomAuthStatus();
        if (r24 == null) goto L296;
        if (r24.isAnchorColdMessageTiled() != true) goto L296;
        if (r19 == false) goto L296;
        T r25 = r21.b;
        if (r25 == 0) goto L296;
        m0 r26 = r25.getBaseMessage();
        if (r26 == null) goto L296;
        if (r26.getAnchorFoldTypeV2() != 3) goto L296;
        r21.r = Boolean.FALSE;
        goto L296
    L272:
        if (Intrinsics.areEqual(r23.isPersonalized(), Boolean.TRUE) == false) goto L281;
        Long r27 = r23.getFoldType();
        if (r27 == null) goto L276;
        long r110 = r27.longValue();
        long r28 = 0;
    L278:
        if (r110 != r28) goto L280;
        r10 = true;
    L280:
        r21.r = Boolean.valueOf(r10);
        goto L281
    L276:
        r28 = 0;
        r110 = 0;
        goto L278
    L268:
        r19 = false;
    L31:
        r14 = true;
    L231:
        r14 = true;
    L262:
        r14 = false;
        goto L263
    L44:
        if ((r3 instanceof c4) == true) goto L46;
        int r29 = 3;
        if ((r3 instanceof va) == false) goto L149;
        va r30 = (va) r3;
        if (r30.getAction() != 1) goto L138;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r31 = r2.e;
        if (r2.a() == false) goto L105;
        if (r30.getBaseMessage() == null) goto L116;
        m0 r111 = r30.getBaseMessage();
        if (r111 != null) goto L98;
    L99:
        m0 r112 = r30.getBaseMessage();
        if (r112 == null) goto L116;
        if (r112.getAnchorFoldTypeV2() != 2) goto L116;
    L115:
        boolean r113 = false;
    L117:
        if (r113 == true) goto L129;
        if ((System.currentTimeMillis() - r2.a) <= 1000) goto L122;
        r2.b = 0;
        r2.a = System.currentTimeMillis();
    L122:
        if (r30.isTooMuchMsg() == false) goto L124;
        r29 = 0;
    L124:
        int r33 = r2.b;
        if (r33 >= r29) goto L127;
        r2.b = r33 + 1;
        r113 = false;
        goto L129
    L127:
        r113 = true;
    L129:
        if (r2.a() == false) goto L137;
        m0 r34 = r30.getBaseMessage();
        if (r34 == null) goto L137;
        if (r34.getAnchorFoldTypeV2() != 3) goto L137;
        if (((w) r31).a() == true) goto L138;
    L137:
        r14 = r113;
    L140:
        if (r30.getUser() == null) goto L263;
        IBaseUser r35 = r30.getUser();
        if (r35 == null) goto L144;
        String r36 = r35.getIdString();
    L146:
        if (Intrinsics.areEqual(r36, r6) == false) goto L263;
    L144:
        r36 = null;
        goto L146
    L98:
        if (r111.getAnchorFoldTypeV2() == 0) goto L115;
    L116:
        r113 = true;
        goto L117
    L105:
        if (r2.g != 1) goto L107;
        boolean r114 = true;
    L108:
        if (r114 == false) goto L116;
        if (r30.getBaseMessage() == null) goto L116;
        m0 r115 = r30.getBaseMessage();
        if (r115 == null) goto L116;
        if (r115.getFoldType() != 0) goto L116;
    L107:
        r114 = false;
    L138:
        r14 = false;
        goto L140
    L149:
        if ((r3 instanceof o7) == false) goto L163;
        o7 r37 = (o7) r3;
        if (r37.getFromUser() == null) goto L262;
        IBaseUser r38 = r37.getFromUser();
        if (r38 == null) goto L155;
        String r39 = r38.getIdString();
    L157:
        if ((!Intrinsics.areEqual(r39, r6)) == false) goto L262;
        int r40 = r2.d.getGiftMessageStyle();
        if (r2.f == false) goto L262;
        if (r40 != 2) goto L262;
    L155:
        r39 = null;
        goto L157
    L163:
        if ((r3 instanceof kc2.b) == false) goto L173;
        IBaseUser r41 = ((kc2.b) r3).a;
        if (r41 == null) goto L262;
        if ((!Intrinsics.areEqual(r41.getIdString(), r6)) == false) goto L262;
        int r43 = r2.d.getGiftMessageStyle();
        if (r2.f == false) goto L262;
        if (r43 != 2) goto L262;
    L173:
        if ((r3 instanceof r0) == false) goto L187;
        r0 r44 = (r0) r3;
        if (r44.q() == null) goto L262;
        User r45 = r44.q();
        if (r45 == null) goto L179;
        String r46 = r45.getIdString();
    L181:
        if ((!Intrinsics.areEqual(r46, r6)) == false) goto L262;
        int r47 = r2.d.getGiftMessageStyle();
        if (r2.f == false) goto L262;
        if (r47 != 2) goto L262;
    L179:
        r46 = null;
        goto L181
    L187:
        if ((r3 instanceof h7) == false) goto L206;
        h7 r48 = (h7) r3;
        if (r48.getUser() == null) goto L198;
        IBaseUser r49 = r48.getUser();
        if (r49 == null) goto L193;
        String r50 = r49.getIdString();
    L195:
        if (Intrinsics.areEqual(r50, r6) == false) goto L198;
    L193:
        r50 = null;
    L198:
        if (r48.getAction() != 1) goto L200;
    L201:
        int r51 = r2.d.getFansMessageStyle();
        if (r2.f == false) goto L262;
        if (r51 != 2) goto L262;
    L200:
        if (r48.getAction() != 2) goto L262;
    L206:
        if ((r3 instanceof l4) == false) goto L230;
        l4 r53 = (l4) r3;
        if (r53.getUser() == null) goto L217;
        IBaseUser r54 = r53.getUser();
        if (r54 == null) goto L212;
        String r55 = r54.getIdString();
    L214:
        if (Intrinsics.areEqual(r55, r6) == false) goto L217;
    L212:
        r55 = null;
    L217:
        if (r53.getAction() != 1) goto L219;
    L228:
        r14 = r2.b(r53, r2.e, r2.d.getFollowMessageStyle());
        goto L263
    L219:
        if (r53.getAction() == 2) goto L228;
        if (r53.getAction() == 4) goto L228;
        if (r53.getAction() == 5) goto L228;
        if (r53.getAction() != 3) goto L262;
        r14 = r2.b(r53, r2.e, r2.d.getShareMessageStyle());
        goto L263
    L230:
        if ((r3 instanceof w0) == true) goto L231;
        if ((r3 instanceof l0) == false) goto L262;
        l0 r56 = (l0) r3;
        Intrinsics.checkNotNullParameter(r56, "message");
        IBaseUser r57 = r56.getUser();
        if (r57 == null) goto L237;
        String r58 = r57.getIdString();
    L238:
        IMiddlewareUserService r59 = jc1.k.f(IMiddlewareUserService.class);
        if (r59 == null) goto L243;
        com.bytedance.android.livesdk.user.e r60 = r59.user();
        if (r60 == null) goto L243;
        String r61 = r60.n();
    L244:
        boolean r63 = !Intrinsics.areEqual(r58, r61);
        if (r2.a() == false) goto L252;
        m0 r64 = r56.getBaseMessage();
        if (r64 == null) goto L252;
        if (r64.getAnchorFoldType() == 0) goto L262;
    L252:
        if (r2.g != 1) goto L254;
        boolean r65 = true;
    L255:
        if (r65 == false) goto L261;
        m0 r66 = r56.getBaseMessage();
        if (r66 == null) goto L261;
        if (r66.getFoldType() == 0) goto L262;
    L261:
        r14 = r63;
        goto L263
    L254:
        r65 = false;
    L243:
        r61 = null;
        goto L244
    L237:
        r58 = null;
        goto L238
    L46:
        if (r2.a() == false) goto L59;
        m0 r67 = ((c4) r3).getBaseMessage();
        if (r67 == null) goto L59;
        if (r67.getAnchorFoldTypeV2() != 3) goto L59;
        if (((w) r2.e).a() == false) goto L231;
        IRoomAuthStatus r68 = r2.d.getRoomAuthStatus();
        if (r68 == null) goto L231;
        if (r68.isAnchorColdMessageTiled() == true) goto L262;
    L59:
        if (r2.g != 1) goto L61;
        boolean r69 = true;
    L62:
        if (r69 == false) goto L75;
        c4 r70 = (c4) r3;
        m0 r71 = r70.getBaseMessage();
        if (r71 != null) goto L66;
    L67:
        m0 r73 = r70.getBaseMessage();
        if (r73 == null) goto L262;
        if (r73.getFoldType() != 2) goto L262;
        if (((w) r2.e).b() == false) goto L262;
    L66:
        if (r71.getFoldType() == 1) goto L231;
    L75:
        if (r2.a() == false) goto L262;
        c4 r74 = (c4) r3;
        m0 r75 = r74.getBaseMessage();
        if (r75 != null) goto L79;
    L80:
        m0 r76 = r74.getBaseMessage();
        if (r76 == null) goto L262;
        if (r76.getAnchorFoldType() != 2) goto L262;
        if (((w) r2.e).b() == false) goto L262;
    L79:
        if (r75.getAnchorFoldType() == 1) goto L231;
    L61:
        r69 = false;
        goto L62
    L11:
        if ((!Intrinsics.areEqual(r5.n(), "0")) == false) goto L13;
        r6 = r5.n();
        goto L14
    L7:
        r5 = null;
    L296:
        return r21.r.booleanValue();
    }

    public boolean o0(f r3) {
        if (TextUtils.equals(r3.y(), jc1.k.f(IMiddlewareUserService.class).user().n()) == true) goto L11;
        com.bytedance.android.live.base.model.message.k0 r0 = r3.b;
        if (r0 != null) goto L8;
    L12:
        boolean r1 = false;
    L13:
        r3.y = r1;
        return r1;
    L8:
        if ((r0 instanceof com.bytedance.android.live.base.model.message.k0) == false) goto L12;
        if (r0.getPriorityLevel() != 2) goto L12;
    L11:
        r1 = true;
        goto L13
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        long r0 = System.currentTimeMillis();
        if (r7 == null) goto L28;
        String r2 = r7.getKey();
        r2.getClass();
        byte r4 = -1;
        switch(r2.hashCode()) {
            case -1274518299: goto L16;
            case 630915744: goto L12;
            case 1114022349: goto L8;
            default: goto L19;
        };
    L19:
        switch(r4) {
            case 0: goto L25;
            case 1: goto L22;
            case 2: goto L25;
            default: goto L32;
        };
    L32:
        return;
    L22:
        if ((r7.getData() instanceof Boolean) == false) goto L29;
        this.l = ((Boolean) r7.getData()).booleanValue();
        return;
    L29:
        return;
    L25:
        if ((r7.getData() instanceof t) == false) goto L31;
        g0((t) r7.getData(), r0);
        return;
    L31:
        return;
    L8:
        if (r2.equals("data_push_2_public_screen_message") == false) goto L19;
        r4 = 2;
        goto L19
    L12:
        if (r2.equals("data_is_in_float_mode") == false) goto L19;
        r4 = 1;
        goto L19
    L16:
        if (r2.equals("data_push_to_public_screen_open_platfrom_message") == false) goto L19;
        r4 = 0;
        goto L19
    }

    public final void p0(boolean r6) {
        IRoom r7 = this.e;
        if (r7 == null) goto L5;
        long r0 = r7.getRoomId();
    L6:
        int r8 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.a;
        DataCenter r9 = ((n) this).c;
        if (r9 == null) goto L9;
        boolean r10 = ((Boolean) r9.get("data_is_anchor", Boolean.FALSE)).booleanValue();
    L10:
        t r11 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.a(r0, false, r10, this.e);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r.d(r11, PSMessageAction.SYSTEM);
        this.D.insertLocalMessage(r11);
        return;
    L9:
        r10 = false;
        goto L10
    L5:
        r0 = 0;
        goto L6
    }

    public final void s0(int r4) {
        ITextMessageView r0 = ((q46.b) this).a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.XD(r4, 0);
    }

    @Override // aa2.a
    public final void updateRoom(IRoom r8) {
        this.e = r8;
        boolean r1 = false;
        if (this.M == true) goto L27;
        Lazy r0 = PublicScreenABHelper.a;
        if (r8 == null) goto L25;
        RoomPublicScreenInfo r2 = gb2.b.b(r8);
        if (r2 == null) goto L12;
        RoomPublicScreenAttachments r3 = r2.attachments;
        if (r3 == null) goto L12;
        Integer r4 = Integer.valueOf(r3.anchorColdMsgShowOpt);
    L14:
        if (((com.bytedance.android.livesdk.interactivity.service.model.e) PublicScreenABHelper.H.getValue()).anchorColdMsgShowOpt == false) goto L21;
        if (r4 == null) goto L21;
        if (r4.intValue() != 1) goto L25;
    L24:
        boolean r9 = true;
    L26:
        this.M = r9;
    L21:
        if (r8.isMergeVSRoom() == true) goto L25;
        if (r8.isMediaRoom() == true) goto L25;
    L12:
        r4 = null;
    L25:
        r9 = false;
    L27:
        IRoom r10 = this.e;
        if (r10 == null) goto L54;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.l r5 = this.J;
        if (r5 == null) goto L55;
        int r11 = (int) r10.getUserCount();
        if (((ArrayDeque) r5.g).size() < r5.f) goto L34;
        boolean r6 = true;
    L36:
        if (r6 == false) goto L38;
    L50:
        ALogger.i("PS_MESSAGE_HEAT", "slide window has full, no need to use acu");
    L51:
        if (r1 == false) goto L56;
        C0(null, null, null, this.J.a);
        return;
    L56:
        return;
    L38:
        if (r5.h == true) goto L50;
        k0 r7 = r5.i;
        if (r11 < r7.acuHotThreshold) goto L44;
        PSMessageHeatState r13 = PSMessageHeatState.HOT;
    L48:
        if (r13 == r5.a) goto L51;
        r5.a = r13;
        ALogger.i("PS_MESSAGE_HEAT", "real acu is " + r11 + ", related heat state is " + r5.a.name());
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.c(r5.a, r11);
        r1 = true;
        goto L51
    L44:
        if (r11 >= r7.acuColdThreshold) goto L46;
        r13 = PSMessageHeatState.COLD;
        goto L48
    L46:
        r13 = PSMessageHeatState.NORMAL;
        goto L48
    L34:
        r6 = false;
        goto L36
    L55:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final void v(ChatRoomAuthPlugin.a r2) {
        ((ArrayList) this.m).remove(r2);
    }

    @Override // aa2.a
    public final void w(com.bytedance.android.livesdk.interactivity.publicscreen.pin.d r3) {
        int r0 = 0;
    L4:
        if (r0 >= ((ArrayList) this.f).size()) goto L18;
        if (r3.a((f) ListProtector.get(this.f, r0)) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        ListProtector.remove(this.f, r0);
        ITextMessageView r4 = ((q46.b) this).a;
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.d() == false) goto L17;
        ((q46.b) this).a.V50(r0, true);
        return;
    L17:
        return;
    }

    @Override // aa2.a
    public final void D(int r4, f r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4 > ((ArrayList) this.f).size()) goto L13;
        if (r4 < 0) goto L13;
        ListProtector.add(this.f, r4, r5);
        ITextMessageView r6 = ((q46.b) this).a;
        if (r6 == null) goto L15;
        r6.DD(r4, 1, 0);
        return;
    L15:
        return;
    L13:
        boolean r7 = TextMessageTracer.a;
        TextMessageTracer.A("insert message to show list error, index is " + r4 + ", size is " + ((ArrayList) this.f).size());
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final void c(Function1<? super f<?>, Boolean> r4, Function2<? super f<?>, ? super Integer, Unit> r5) {
        int r0 = 0;
    L4:
        if (r0 >= ((ArrayList) this.f).size()) goto L9;
        if (((Boolean) r4.invoke(ListProtector.get(this.f, r0))).booleanValue() == false) goto L8;
        r5.invoke(ListProtector.get(this.f, r0), Integer.valueOf(r0));
        s0(r0);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public final void g0(t r11, long r13) {
        f r0 = i0.e(r11, l0().m, this.e);
        DataCenter r1 = ((n) this).c;
        if (r0 != null) goto L5;
        int r2 = com.bytedance.android.livesdk.interactivity.publicscreen.pin.b.a;
    L72:
        if (r0 == null) goto L74;
        r0.B = r13;
        h0(r0);
        i0(r11);
        return;
    L74:
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.k(r11);
        return;
    L5:
        int r3 = com.bytedance.android.livesdk.interactivity.publicscreen.pin.b.a;
        if ((r0 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.z) == false) goto L8;
        u42.b r4 = ((com.bytedance.android.livesdk.interactivity.textmessage.model.z) r0).H.d;
    L9:
        if (r4 != null) goto L72;
        if ((r0 instanceof b0) == false) goto L70;
        b0 r5 = (b0) r0;
        com.bytedance.android.live.base.model.message.b4 r6 = r5.b;
        IRoomContextService r7 = jc1.k.f(IRoomContextService.class);
        HoverInfo r8 = null;
        if (r7 == null) goto L18;
        o r9 = IRoomContextService.a.a(r7, null, 0, 3);
        if (r9 == null) goto L18;
        Boolean r10 = r9.isAnchor();
    L19:
        boolean r14 = Intrinsics.areEqual(r10, Boolean.TRUE);
        boolean r15 = false;
        if (((u0) a4.a.getValue()).b() == false) goto L28;
        if (r6 == null) goto L61;
        IPublicAreaCommon r16 = r6.getOrInitPublicAreaCommon();
        if (r16 == null) goto L61;
        HoverInfo r17 = r16.getHoverInfo();
        if (r17 == null) goto L61;
        r15 = r17.isHover;
    L61:
        if (r15 == true) goto L63;
    L68:
        r5.C = r8;
        goto L72
    L63:
        if (r6 == null) goto L67;
        IPublicAreaCommon r18 = r6.getOrInitPublicAreaCommon();
        if (r18 == null) goto L67;
        r8 = r18.getHoverInfo();
    L67:
        r8 = new x92.a(r0, r1, r8);
        goto L68
    L28:
        if (r14 == true) goto L57;
        if (r6.getStyle() == 1) goto L60;
        o72.d.a.getClass();
        p1 r19 = p1.a;
        if (((o72.d) r19.getValue()).d() == true) goto L34;
    L36:
        boolean r20 = false;
    L37:
        if (r20 == true) goto L60;
        int r21 = p52.a.a;
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r6, "message");
        List r23 = r6.G1();
        if (r23 == null) goto L51;
        Iterator r24 = r23.iterator();
    L42:
        if (r24.hasNext() == false) goto L49;
        Object r25 = r24.next();
        if (((py.r) r25).getType() != 1) goto L46;
        boolean r26 = true;
    L47:
        if (r26 == false) goto L42;
    L50:
        py.r r27 = (py.r) r25;
    L52:
        if (r27 == null) goto L54;
        boolean r28 = true;
    L55:
        if (r28 == true) goto L60;
    L54:
        r28 = false;
        goto L55
    L46:
        r26 = false;
        goto L47
    L49:
        r25 = null;
        goto L50
    L51:
        r27 = null;
        goto L52
    L34:
        if (((o72.d) r19.getValue()).a() == false) goto L36;
        r20 = true;
    L60:
        r15 = true;
    L57:
        if (p52.a.c(r6, 6) == true) goto L60;
        if (p52.a.c(r6, 7) == false) goto L61;
    L18:
        r10 = null;
        goto L19
    L70:
        if ((r0 instanceof c0) == false) goto L72;
        c0 r29 = (c0) r0;
        r29.C = new y92.a(RangesKt.coerceAtLeast(r29.b.i(), 30000), r0);
        goto L72
    L8:
        r4 = r0.C;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final void l(Function1<? super f<?>, Boolean> r3, Function1<? super f<?>, Unit> r4) {
        int r0 = ((ArrayList) this.f).size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L12;
        if (((Boolean) r3.invoke(ListProtector.get(this.f, r0))).booleanValue() == false) goto L3;
        r4.invoke(ListProtector.get(this.f, r0));
        s0(r0);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final f<?> t(Function1<? super f<?>, Boolean> r1, IntRange r2) {
        int r3 = z(r1, r2);
        if (r3 >= 0) goto L6;
        return null;
    L6:
        return (f) ListProtector.get(this.f, r3);
    }

    public final void y0(tlc.d r9, boolean r10) {
        long r0 = System.currentTimeMillis();
        if (r10 == false) goto L5;
    L7:
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.l(r9);
        if ((r9 instanceof t) == false) goto L122;
        g1 r11 = (t) r9;
        if (z0(r11, r0) == false) goto L12;
        return;
    L12:
        boolean r3 = true;
        if ((r11 instanceof kc2.b) == false) goto L18;
        if (((kc2.b) r11).j == false) goto L18;
    L101:
        if (r3 == false) goto L104;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.u.b.t(r9);
        return;
    L104:
        g0(r11, r0);
        return;
    L18:
        if ((r11 instanceof g1) == false) goto L38;
        List r2 = r11.b1();
        if (r2 == null) goto L101;
        final HashSet r5 = new HashSet(r2);
        int r4 = ((ArrayList) this.f).size();
    L23:
        r4 = r4 - 1;
        if (r4 < 0) goto L36;
        f r6 = (f) ListProtector.get(this.f, r4);
        if (r6 == null) goto L23;
        T r7 = r6.b;
        if (r7 == 0) goto L23;
        if (r5.contains(Long.valueOf(r7.getMessageId())) == false) goto L23;
        ListProtector.remove(this.f, r4);
        ITextMessageView r8 = ((q46.b) this).a;
        if (r8 == null) goto L23;
        if (r8.d() == false) goto L23;
        ((q46.b) this).a.V50(r4, false);
        goto L23
    L36:
        this.C.j(new s(r5));
        goto L101
    L38:
        if ((r11 instanceof r1) == false) goto L67;
        r1 r13 = (r1) r11;
        if (this.e.getRoomAuthStatus() != null) goto L42;
    L44:
        boolean r14 = false;
    L45:
        if (r14 == false) goto L101;
        if (r13.W() != null) goto L50;
    L52:
        boolean r15 = r13.H0(jc1.k.f(IMiddlewareUserService.class).user().b());
        if (r13.getScene() != null) goto L55;
    L60:
        if (r15 == true) goto L62;
    L64:
        if (r15 == false) goto L67;
        this.t = true;
        goto L67
    L62:
        if (this.t == false) goto L64;
    L55:
        if (r13.getScene().equals("linkmic_guest_like") == false) goto L60;
        String r16 = r13.M0();
        if (((HashSet) this.H).contains(r16) == true) goto L101;
        ((HashSet) this.H).add(r16);
    L100:
        r3 = false;
        goto L101
    L50:
        if (r13.W().showText == true) goto L52;
    L42:
        if (this.e.getRoomAuthStatus().getEnableDigg() == false) goto L44;
        r14 = true;
    L67:
        if ((r11 instanceof qa) == false) goto L72;
        if (q.a() == false) goto L101;
    L72:
        if ((r11 instanceof kc2.a) == false) goto L86;
        final kc2.a r17 = (kc2.a) r11;
        if (TextUtils.isEmpty(r17.updatePath) == true) goto L101;
        f<?> r18 = this.C.b(new aa2.f(r17));
        if (r18 == null) goto L79;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.d.b(r17, r18);
        goto L101
    L79:
        int r19 = ((ArrayList) this.f).size();
    L80:
        r19 = r19 - 1;
        if (r19 < 0) goto L101;
        f r20 = (f) ListProtector.get(this.f, r19);
        if (com.bytedance.android.livesdk.interactivity.textmessage.utils.d.a(r17, r20) == false) goto L80;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.d.b(r17, r20);
        s0(r19);
        goto L101
    L86:
        if ((r11 instanceof com.bytedance.android.live.base.model.message.r) == false) goto L93;
        com.bytedance.android.live.base.model.message.r r21 = (com.bytedance.android.live.base.model.message.r) r11;
        if (TextUtils.equals(r21.getUserInfo().getIdString(), jc1.k.f(IMiddlewareUserService.class).user().n()) == false) goto L93;
        if (r21.getSendStatus() == 0) goto L101;
    L93:
        if ((r11 instanceof h4) == false) goto L98;
        if (((h4) r11).notShowInPublicScreen() == true) goto L101;
    L98:
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_COMMENT_AREA.getValue()).booleanValue() == false) goto L100;
    L122:
        return;
    L5:
        if (r9.isFromFirstRequest() == false) goto L7;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.l
    public final int z(Function1<? super f<?>, Boolean> r5, IntRange r6) {
        if (r6.getFirst() != (-1)) goto L5;
        int r0 = 0;
    L7:
        if (r6.getLast() != (-1)) goto L9;
        int r7 = ((ArrayList) this.f).size();
    L10:
        if (r0 >= r7) goto L15;
        if (((Boolean) r5.invoke(ListProtector.get(this.f, r0))).booleanValue() == true) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        return r0;
    L15:
        return -1;
    L9:
        r7 = Math.max(Math.min(r6.getLast(), ((ArrayList) this.f).size()), 0);
        goto L10
    L5:
        r0 = Math.max(Math.min(r6.getFirst(), ((ArrayList) this.f).size()), 0);
        goto L7
    }

    public final void k0(final f r4, boolean r5, boolean r6) {
        if (((ArrayList) this.f).size() < 200) goto L18;
        ((ArrayList) this.f).subList(0, 70).clear();
        ITextMessageView r0 = ((q46.b) this).a;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.h.a;
        com.bytedance.android.livesdk.interactivity.api.h r2 = i.b(null, 3);
        if (r2 == null) goto L16;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l> r3 = r2.getAudienceOperateManager();
        if (r3 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l r7 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l) r3.getValue();
        if (r7 == null) goto L16;
        r7.a();
    L16:
        this.y = true;
        goto L18
    L7:
        if (r0.d() == false) goto L9;
        ((q46.b) this).a.pa(70);
    L18:
        if (n0(r4) == true) goto L20;
        this.N = System.currentTimeMillis();
    L20:
        w0(r4);
        if (r5 == true) goto L26;
        this.v.a(r4);
        if (r6 == false) goto L25;
        this.v.b();
    L25:
        boolean r8 = TextMessageTracer.a;
        TextMessageTracer.z(new aa2.d(r4));
        return;
    L26:
        if (r4 == null) goto L29;
        ArrayList r9 = new ArrayList();
        r9.add(r4);
        H0(r9);
    L29:
        boolean r10 = TextMessageTracer.a;
        TextMessageTracer.z(new aa2.l());
    }

    public TransTextMessagePresenter(IPSMessageRepoManager r13, com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c r14, com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a r15, q92.a r16) {
        this.f = new ArrayList(200);
        this.g = new ua2.a();
        this.h = null;
        this.i = ((Boolean) com.bytedance.android.livesdk.interactivity.service.settings.d.a.getValue()).booleanValue();
        int r5 = 0;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = new ArrayList();
        this.o = 0;
        this.p = 0;
        this.q = false;
        this.s = true;
        this.t = false;
        Handler r7 = new Handler(Looper.getMainLooper());
        this.u = r7;
        this.y = false;
        this.A = jc1.k.f(IRoomContextService.class).getRoomDataContext(null, 0);
        this.G = true;
        this.H = new HashSet();
        this.I = new e();
        com.bytedance.android.livesdk.interactivity.api.settings.config.m r8 = PublicScreenABHelper.g(m0());
        if (m0() == false) goto L5;
        k0 r11 = (k0) PublicScreenABHelper.t.getValue();
    L6:
        this.K = r11;
        this.M = false;
        this.N = 0;
        this.O = 0;
        this.P = false;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = PublicScreenABHelper.g(m0()).enablePersonalizedChannel;
        this.U = new b(this);
        this.X = false;
        int r4 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.w.a;
        Intrinsics.checkNotNullParameter(this, "presenter");
        boolean r6 = TextMessageTracer.a;
        StringBuilder r9 = new StringBuilder("TransTextMessagePresenter create, this is ");
        r9.append(hashCode());
        r9.append(", repo is ");
        r9.append(r13.hashCode());
        r9.append(", updater is ");
        if (r14 == null) goto L9;
        int r10 = r14.hashCode();
    L10:
        r9.append(r10);
        r9.append(", buffer is ");
        if (r15 == null) goto L13;
        r5 = r15.hashCode();
    L13:
        r9.append(r5);
        r9.append(", config is ");
        r9.append(r16.hashCode());
        TextMessageTracer.A(r9.toString());
        this.z = r16;
        List<lc2.d> r17 = lc2.c.a;
        lc2.b r18 = new lc2.b(r16, r7, new aa2.q(this));
        this.v = r18;
        r18.b = true;
        this.B = r14;
        this.C = r15;
        this.D = r13;
        this.E = new u(this);
        this.F = new PublicScreenStateHelper(r15, new aa2.v(this), (o72.b) ec2.a.a.getValue(), ((Integer) g.a.getValue()).intValue(), r8, r11);
        return;
    L9:
        r10 = 0;
        goto L10
    L5:
        r11 = (k0) PublicScreenABHelper.s.getValue();
        goto L6
    }
}
