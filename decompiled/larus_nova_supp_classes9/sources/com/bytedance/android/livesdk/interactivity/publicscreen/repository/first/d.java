package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostNetwork;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.g7;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import com.bytedance.android.livesdk.interactivity.api.utils.PSTopMessagePayload;
import com.bytedance.android.livesdk.interactivity.publicscreen.repository.NormalMessageRepoManagerV2;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.TextMessagePresenterUtil;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model.com.bytedance.android.livesdk.model.LiveFirstMessageOptConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r42.p;
import r52.g3;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements vlc.h, l {
    public static final /* synthetic */ int u = 0;
    public final boolean a;
    public final o b;
    public final HashSet<Long> c;
    public final List<tlc.d> d;
    public final List<tlc.d> e;
    public final CompositeDisposable f;
    public final long g;
    public Disposable h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final DataCenter m;
    public final IRoom n;
    public final List<String> o;
    public final vlc.d p;
    public final vlc.h q;
    public final l r;
    public final Function1<p, Unit> s;
    public final Function1<List<? extends tlc.d>, Boolean> t;

    public static final class a {
    }

    static {
    }

    public static final void b(d r6) {
        if (r6.i == false) goto L6;
        r6.c("已处理置顶消息,不再请求backup接口");
        return;
    L6:
        if (r6.k == false) goto L8;
        r6.c("已请求过backup接口,不再重复请求");
        return;
    L8:
        r6.k = true;
        vlc.d r0 = r6.p;
        String r2 = null;
        if ((r0 instanceof vlc.e) == true) goto L11;
        r0 = null;
    L11:
        vlc.e r1 = (vlc.e) r0;
        if (r1 == null) goto L20;
        int r3 = r42.a.a;
        g r4 = new g(r6);
        Intrinsics.checkNotNullParameter(r1, "messageManager");
        Intrinsics.checkNotNullParameter(r4, "listener");
        StringBuilder r5 = new StringBuilder("https://");
        IMiddlewareHostNetwork r7 = k.f(IMiddlewareHostNetwork.class);
        if (r7 == null) goto L16;
        r2 = r7.getHostDomain();
    L16:
        r5.append(r2);
        r5.append(hm2.c.a);
        Single r8 = Single.create(new r42.c(r1, r5.toString()));
        int r9 = r42.g.a;
        RxUtilKt.c(r8.timeout(Math.max(500, ((Long) g3.a.getValue()).longValue()), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new r42.d(r4), new r42.f(r4)), r6.f);
        return;
    }

    public final void c(String r5) {
        if (this.a == true) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append(r5);
        r0.append(" ,roomid:");
        IRoom r6 = this.n;
        String r1 = null;
        if (r6 == null) goto L8;
        Long r7 = Long.valueOf(r6.getRoomId());
    L9:
        r0.append(r7);
        r0.append("，owner:");
        IRoom r8 = this.n;
        if (r8 == null) goto L14;
        IBaseUser r9 = r8.getOwner();
        if (r9 == null) goto L14;
        r1 = r9.getNickName();
    L14:
        r0.append(r1);
        ALogger.d("PublicScreenFirstMessageProcessorV2", r0.toString());
        return;
    L8:
        r7 = null;
        goto L9
    }

    public final void onMessage(tlc.d r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isFromFirstRequest() == false) goto L7;
        return;
    L7:
        if (this.j == false) goto L11;
        ((ArrayList) this.d).add(r2);
        return;
    }

    public static final void a(final d r6, List r7) {
        if (r6.i == true) goto L84;
        r6.c("置顶消息ready，消息数量：" + r7.size());
        r6.i = true;
        Disposable r1 = r6.h;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        ArrayList r3 = new ArrayList();
        r2.element = r3;
        r3.addAll(r7);
        Iterator r8 = ((List) r2.element).iterator();
    L9:
        tlc.d r4 = null;
        if (r8.hasNext() == false) goto L14;
        Object r5 = r8.next();
        if (Intrinsics.areEqual("WebcastRoomIntroMessage", ((tlc.d) r5).getMessageMethod()) == false) goto L9;
    L15:
        tlc.d r9 = (tlc.d) r5;
        if (r9 != null) goto L18;
    L22:
        List r10 = (List) r2.element;
        ArrayList r11 = new ArrayList();
        Iterator r13 = r10.iterator();
    L24:
        if (r13.hasNext() == false) goto L28;
        Object r14 = r13.next();
        if ((r14 instanceof k0) == false) goto L24;
        r11.add(r14);
        goto L24
    L28:
        Iterator r15 = r11.iterator();
    L30:
        if (r15.hasNext() == false) goto L32;
        ((k0) r15.next()).getOrInitPublicAreaCommon().setFirstAggregateHistoryMessage(true);
        goto L30
    L32:
        Iterator r16 = ((List) r2.element).iterator();
    L34:
        if (r16.hasNext() == false) goto L37;
        r6.c.add(Long.valueOf(((tlc.d) r16.next()).getMessageId()));
        goto L34
    L37:
        if (r42.g.a(r6.n, Boolean.FALSE) == true) goto L45;
        List r17 = (List) r2.element;
        ArrayList r18 = new ArrayList();
        Iterator r19 = r17.iterator();
    L40:
        if (r19.hasNext() == false) goto L44;
        Object r20 = r19.next();
        if ((!(((tlc.d) r20) instanceof k0)) == false) goto L40;
        r18.add(r20);
        goto L40
    L44:
        ((List) r2.element).clear();
        ((List) r2.element).addAll(r18);
    L45:
        Iterator r21 = ((List) r2.element).iterator();
        int r23 = 0;
    L47:
        if (r21.hasNext() == false) goto L55;
        Object r24 = r21.next();
        int r25 = r23 + 1;
        if (r23 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        u3 r26 = (tlc.d) r24;
        if ((r26 instanceof u3) == false) goto L54;
        r26.getOrInitPublicAreaCommon().setFirstFetchBatchMsg(true);
    L54:
        r23 = r25;
        goto L47
    L55:
        com.bytedance.android.livesdk.interactivity.api.h r27 = i.b(r6.m, 1);
        if (r27 == null) goto L81;
        m<Boolean> r28 = r27.getHasLoadModel();
        if (r28 == null) goto L82;
        Disposable r29 = i80.a.a(r28, new PublicScreenFirstMessageProcessorV2$onTopMessageReady$7(r6, r2));
        if (r29 == null) goto L83;
        RxUtilKt.c(r29, r6.f);
        return;
    L83:
        return;
    L82:
        return;
    L81:
        return;
    L18:
        if (TextMessagePresenterUtil.a(r9, r6.m) == false) goto L20;
        r4 = r9;
    L20:
        if (r4 == null) goto L22;
        r6.c("置顶消息中发现了RoomIntro，需要异步处理，拎去RoomIntroPlugin");
        TextMessagePresenterUtil.b(r6.m, r6.f, r4);
        ((List) r2.element).remove(r4);
        goto L22
    L14:
        r5 = null;
        goto L15
    }

    public final void onFirstMessage(List<? extends tlc.d> r2, boolean r3) {
        if (this.j == false) goto L9;
        if (r2 == null) goto L11;
        Iterator r4 = CollectionsKt.filterNotNull(r2).iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        tlc.d r5 = (tlc.d) r4.next();
        ((ArrayList) this.e).add(r5);
        goto L7
    L12:
        return;
    L11:
        return;
    }

    public d(DataCenter r2, IRoom r3, List r4, vlc.d r5, vlc.h r6, NormalMessageRepoManagerV2.a r7, Function1 r8, Function1 r9) {
        Intrinsics.checkNotNullParameter(r4, "msgTypes");
        Intrinsics.checkNotNullParameter(r6, "actualOnFirstMessageListener");
        Intrinsics.checkNotNullParameter(r7, "actualOnRealtimeMessageList");
        Intrinsics.checkNotNullParameter(r8, "historyStatusUpdater");
        Intrinsics.checkNotNullParameter(r9, "onTopMessageReady");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.q = r6;
        this.r = r7;
        this.s = r8;
        this.t = r9;
        this.a = ((LiveFirstMessageOptConfig) g7.a.getValue()).getLogEnable();
        IRoomContextService r10 = k.f(IRoomContextService.class);
        if (r10 == null) goto L5;
        o r11 = IRoomContextService.a.a(r10, r2, 0, 2);
    L6:
        this.b = r11;
        this.c = new HashSet(128);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new CompositeDisposable();
        this.g = PublicScreenABHelper.Q;
        this.j = true;
        r42.a.c("public screen first message processor init");
        if (r5 == null) goto L9;
        r5.n(this);
    L9:
        Iterator r13 = r4.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        String r14 = (String) r13.next();
        vlc.d r15 = this.p;
        if (r15 == null) goto L11;
        r15.addMessageListener(r14, this);
        goto L11
    L15:
        o r16 = this.b;
        if (r16 != null) goto L19;
        s0 r17 = PublicScreenTraceMonitor.a;
        PublicScreenTraceMonitor.k(-10012, "v2 roomcontext为空", null);
        return;
    L19:
        if (Intrinsics.areEqual(r16.isVSRoom(), Boolean.TRUE) == false) goto L21;
    L31:
        c("media or vs room, don't  consume top message");
        return;
    L21:
        if (this.b.isMediaRoom() == true) goto L31;
        Disposable r18 = this.h;
        if (r18 == null) goto L26;
        r18.dispose();
    L26:
        Disposable r19 = Observable.timer(this.g, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this), new f(this));
        RxUtilKt.c(r19, this.f);
        this.h = r19;
        com.bytedance.android.livesdk.interactivity.api.h r20 = i.b(this.m, 1);
        if (r20 == null) goto L39;
        j<PSTopMessagePayload> r21 = r20.getPsTopMessage();
        if (r21 == null) goto L40;
        r21.c(new PublicScreenFirstMessageProcessorV2$observeTopMessage$3(this));
        return;
    L40:
        return;
    L39:
        return;
    L5:
        r11 = null;
        goto L6
    }
}
