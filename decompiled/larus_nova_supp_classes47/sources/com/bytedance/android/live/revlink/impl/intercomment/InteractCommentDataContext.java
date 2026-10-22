package com.bytedance.android.live.revlink.impl.intercomment;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.link.model.bridge.k0;
import com.bytedance.android.livesdk.link.model.bridge.l0;
import com.bytedance.android.livesdk.link.model.l4;
import com.bytedance.android.livesdk.link.model.u4;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 J2\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010C\u001a\u00020\u000b¢\u0006\u0004\bI\u0010HJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0005R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R!\u00102\u001a\b\u0012\u0004\u0012\u00020.0-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u00101R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\r0%8\u0006¢\u0006\f\n\u0004\b3\u0010'\u001a\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010$R\u0016\u0010>\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010$R\u0016\u0010?\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010$R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010C\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/intercomment/InteractCommentDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "Lcom/bytedance/android/live/revlink/impl/intercomment/a;", "action", "sendAction", "invite", "", "replyStatus", "", "banInvite", "reply", "close", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/revlink/impl/intercomment/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "getRoomContext", "()Lcom/bytedance/android/livesdk/revenue/room/a;", "Lio/reactivex/disposables/Disposable;", "mInviteTimeOutDisposable", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "isAnchor", "Z", "Landroidx/lifecycle/MutableLiveData;", "_interComState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "interComState", "Landroidx/lifecycle/LiveData;", "getInterComState", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/live/datacontext/k;", "", "onIconClickEvent$delegate", "getOnIconClickEvent", "()Lcom/bytedance/live/datacontext/k;", "onIconClickEvent", "showInterCommentIcon", "getShowInterCommentIcon", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/live/revlink/impl/intercomment/e;", "mInterComLogger", "Lcom/bytedance/android/live/revlink/impl/intercomment/e;", "getMInterComLogger", "()Lcom/bytedance/android/live/revlink/impl/intercomment/e;", "setMInterComLogger", "(Lcom/bytedance/android/live/revlink/impl/intercomment/e;)V", "isStarter", "mIsInviting", "isFinisher", "", "mStartTimeInterval", "J", "scene", "I", "getScene", "()I", "setScene", "(I)V", "<init>", "Companion", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractCommentDataContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final b Companion = null;
    public static final long INVITE_TIME_OUT = 20;
    public static final int REPLY_AGREE = 1;
    public static final int REPLY_REFUSE = 2;
    public static final int REPLY_REFUSE_BY_TIME_OUT = 3;
    private static final String TAG = null;
    private final MutableLiveData<Integer> _interComState;
    private final CompositeDisposable cd;
    private final LiveData<Integer> interComState;
    private boolean isAnchor;
    private boolean isFinisher;
    private boolean isStarter;
    private com.bytedance.android.live.revlink.impl.intercomment.e mInterComLogger;
    private Disposable mInviteTimeOutDisposable;
    private boolean mIsInviting;
    private long mStartTimeInterval;
    private final com.bytedance.live.datacontext.p onIconClickEvent$delegate;
    private final com.bytedance.android.livesdk.revenue.room.a roomContext;
    private int scene;
    private final com.bytedance.live.datacontext.p service$delegate;
    private final MutableLiveData<Boolean> showInterCommentIcon;

    public static final class a implements Action {
        public final /* synthetic */ InteractCommentDataContext a;

        public a(InteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            InteractCommentDataContext.access$getCd$p(this.a).dispose();
            Disposable r0 = InteractCommentDataContext.access$getMInviteTimeOutDisposable$p(this.a);
            if (r0 == null) goto L6;
            r0.dispose();
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final InteractCommentDataContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(InteractCommentDataContext.access$getTAG$cp());
            if ((r0 instanceof InteractCommentDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (InteractCommentDataContext) r0;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ InteractCommentDataContext a;

        public c(InteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            InteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.live.revlink.impl.intercomment.f());
            ToastUtil.b(((l4) ((ExtraResponse) r3).data).getToast(), 0);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            Context r0 = s1.getContext();
            com.bytedance.android.live.revenue.common.k.a(r0, (Throwable) r2);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ InteractCommentDataContext a;

        public e(InteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            InteractCommentDataContext.access$setMIsInviting$p(this.a, false);
            InteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.live.revlink.impl.intercomment.g(true));
            Disposable r0 = InteractCommentDataContext.access$getMInviteTimeOutDisposable$p(this.a);
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            InteractCommentDataContext.access$setMInviteTimeOutDisposable$p(this.a, Observable.timer(20, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this)));
            l4 r8 = (l4) r7.data;
            if (r8 == null) goto L11;
            String r9 = r8.getToast();
            if (r9 == null) goto L12;
            ToastUtil.b(r9, 0);
            return;
        L12:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ InteractCommentDataContext a;

        public f(InteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            InteractCommentDataContext.access$setMIsInviting$p(this.a, false);
            Context r0 = s1.getContext();
            com.bytedance.android.live.revenue.common.k.a(r0, (Throwable) r3);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ InteractCommentDataContext a;
        public final /* synthetic */ int b;

        public g(InteractCommentDataContext r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            ExtraResponse r4 = (ExtraResponse) r3;
            if (this.b != 1) goto L5;
            InteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.live.revlink.impl.intercomment.h());
        L6:
            l4 r5 = (l4) r4.data;
            if (r5 == null) goto L12;
            String r6 = r5.getToast();
            if (r6 == null) goto L13;
            ToastUtil.b(r6, 0);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            InteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.live.revlink.impl.intercomment.f());
            goto L6
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ InteractCommentDataContext a;

        public h(InteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Context r0 = s1.getContext();
            com.bytedance.android.live.revenue.common.k.a(r0, (Throwable) r2);
            InteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.live.revlink.impl.intercomment.f());
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(InteractCommentDataContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractCommentDataContext.class, "onIconClickEvent", "getOnIconClickEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new b();
        TAG = "InteractCommentDataContext";
    }

    public final void close() {
        this.isFinisher = true;
        r31.a r0 = r31.b.a(r31.a.a);
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        long r2 = 0;
        if (r1 == null) goto L7;
        IRoom r3 = r1.getRoom();
        if (r3 == null) goto L7;
        long r4 = r3.getRoomId();
    L8:
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r5 == null) goto L11;
        r2 = r5.c();
    L11:
        Observable<ExtraResponse<l4, Extra>> r6 = r0.intercomClose(r4, r2);
        if (r6 == null) goto L19;
        Observable r7 = r6.compose(RxUtil.rxSchedulerHelper());
        if (r7 == null) goto L20;
        Disposable r8 = r7.subscribe(new c(this), d.a);
        if (r8 == null) goto L21;
        this.cd.add(r8);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r4 = 0;
        goto L8
    }

    public final com.bytedance.live.datacontext.k<Object> getOnIconClickEvent() {
        return (com.bytedance.live.datacontext.k) this.onIconClickEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.intercomment.b> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final void invite() {
        this.isStarter = true;
        if (this.mIsInviting == false) goto L5;
        return;
    L5:
        this.mIsInviting = true;
        r31.a r0 = r31.b.a(r31.a.a);
        yz0.k r1 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        long r2 = 0;
        if (r1 == null) goto L10;
        IRoom r3 = r1.getRoom();
        if (r3 == null) goto L10;
        long r4 = r3.getRoomId();
    L11:
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r5 == null) goto L14;
        r2 = r5.c();
    L14:
        Observable<ExtraResponse<l4, Extra>> r6 = r0.intercomInvite(r4, r2);
        if (r6 == null) goto L22;
        Observable r7 = r6.compose(RxUtil.rxSchedulerHelper());
        if (r7 == null) goto L23;
        Disposable r8 = r7.subscribe(new e(this), new f(this));
        if (r8 == null) goto L24;
        this.cd.add(r8);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L10:
        r4 = 0;
        goto L11
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final LiveData<Integer> getInterComState() {
        return this.interComState;
    }

    public final com.bytedance.android.live.revlink.impl.intercomment.e getMInterComLogger() {
        return this.mInterComLogger;
    }

    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        return this.roomContext;
    }

    public final int getScene() {
        return this.scene;
    }

    public final MutableLiveData<Boolean> getShowInterCommentIcon() {
        return this.showInterCommentIcon;
    }

    public InteractCommentDataContext(int r7) {
        this.scene = r7;
        this.service$delegate = ConstantKt.c(this);
        com.bytedance.android.live.revenue.core.util.j.a r8 = com.bytedance.android.live.revenue.core.util.j.C0;
        com.bytedance.android.livesdk.revenue.service.room.c r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r8.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
    L6:
        this.roomContext = r1;
        CompositeDisposable r2 = new CompositeDisposable();
        this.cd = r2;
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.i r3 = r1.isAnchor();
        if (r3 == null) goto L13;
        Boolean r4 = (Boolean) r3.getValue();
        if (r4 == null) goto L13;
        boolean r5 = r4.booleanValue();
    L14:
        this.isAnchor = r5;
        MutableLiveData<Integer> r6 = new MutableLiveData();
        this._interComState = r6;
        this.interComState = r6;
        this.onIconClickEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.showInterCommentIcon = new MutableLiveData();
        this.mInterComLogger = new com.bytedance.android.live.revlink.impl.intercomment.e(this.scene);
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r2);
        yz0.l r9 = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(r8.a(), yz0.l.class);
        if (r9 == null) goto L22;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r10 = yz0.h.a.a(r9, com.bytedance.android.live.revenue.common.message.b.n, false, 6);
        final InteractCommentDataContext$2$1 r12 = new InteractCommentDataContext$2$1(this);
        Disposable r13 = r10.subscribe(new i(r12));
        if (r13 == null) goto L19;
        RxUtilKt.c(r13, r2);
    L19:
        Observable r14 = yz0.h.a.a(r9, com.bytedance.android.live.revenue.common.message.b.o, false, 6);
        final InteractCommentDataContext$2$2 r15 = new InteractCommentDataContext$2$2(this);
        Disposable r16 = r14.subscribe(new i(r15));
        if (r16 == null) goto L22;
        RxUtilKt.c(r16, r2);
    L22:
        Boolean r17 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).a0();
        if (r17 != null) goto L25;
    L28:
        Disposable r18 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).xn(new AnonymousClass4(this));
        if (r18 == null) goto L32;
        RxUtilKt.c(r18, r2);
        return;
    L32:
        return;
    L25:
        if (r17.booleanValue() == false) goto L27;
        sendAction(new com.bytedance.android.live.revlink.impl.intercomment.h());
        goto L28
    L27:
        sendAction(new com.bytedance.android.live.revlink.impl.intercomment.f());
    L13:
        r5 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(InteractCommentDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ Disposable access$getMInviteTimeOutDisposable$p(InteractCommentDataContext r0) {
        return r0.mInviteTimeOutDisposable;
    }

    public static final /* synthetic */ boolean access$getMIsInviting$p(InteractCommentDataContext r0) {
        return r0.mIsInviting;
    }

    public static final /* synthetic */ long access$getMStartTimeInterval$p(InteractCommentDataContext r2) {
        return r2.mStartTimeInterval;
    }

    public static final /* synthetic */ boolean access$isAnchor$p(InteractCommentDataContext r0) {
        return r0.isAnchor;
    }

    public static final /* synthetic */ boolean access$isFinisher$p(InteractCommentDataContext r0) {
        return r0.isFinisher;
    }

    public static final /* synthetic */ boolean access$isStarter$p(InteractCommentDataContext r0) {
        return r0.isStarter;
    }

    private final void onMessage(yh6.c r6) {
        if ((r6 instanceof k0) == false) goto L6;
        this.isStarter = false;
        sendAction(new com.bytedance.android.live.revlink.impl.intercomment.g(false));
        return;
    L6:
        if ((r6 instanceof l0) == false) goto L39;
        u4 r7 = ((vh7.c) r6).castTo(u4.class);
        String r0 = r7.getToast();
        if (r0 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L16;
        int r2 = ToastUtil.a;
        ToastUtil.b(r7.getToast(), 0);
    L16:
        Disposable r3 = this.mInviteTimeOutDisposable;
        if (r3 == null) goto L20;
        r3.dispose();
    L20:
        if (((int) r7.getReplyStatus()) != 1) goto L23;
        sendAction(new com.bytedance.android.live.revlink.impl.intercomment.h());
        return;
    L23:
        if (this.isAnchor == false) goto L36;
        com.bytedance.android.live.revlink.impl.intercomment.e r8 = this.mInterComLogger;
        r8.getClass();
        HashMap r4 = new HashMap();
        if (r8.b != 1) goto L27;
        String r5 = "pk";
    L28:
        r4.put("connection_scene", r5);
        LinkCrossRoomDataHolder r9 = com.bytedance.android.live.revlink.impl.global.b.j();
        Long r10 = null;
        if (r9 == null) goto L31;
        Long r12 = Long.valueOf(r9.c());
    L32:
        r4.put("channel_id", String.valueOf(r12));
        w31.c r13 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r13 == null) goto L35;
        r10 = Long.valueOf(r13.i());
    L35:
        r4.put("pk_id", String.valueOf(r10));
        r8.a(r4);
        mz0.n r14 = new mz0.n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r15.putAll(r4);
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.ROOM);
        ((ArrayList) r14.b).addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_refuse_feedback", r14.a, r14.b);
        goto L36
    L31:
        r12 = null;
        goto L32
    L27:
        r5 = "connection";
    L36:
        sendAction(new com.bytedance.android.live.revlink.impl.intercomment.f());
        return;
    L10:
        if (r0.length() == 0) goto L13;
        r1 = false;
        goto L14
    }

    private final void sendAction(com.bytedance.android.live.revlink.impl.intercomment.a r7) {
        Integer r0 = (Integer) this._interComState.getValue();
        Integer r1 = (Integer) this._interComState.getValue();
        int r2 = 0;
        if (r1 != null) goto L5;
        r1 = 0;
    L5:
        int r3 = r1.intValue();
        Intrinsics.checkNotNullParameter(r7, "action");
        if (r3 == 0) goto L8;
        if (r3 == 1) goto L24;
        if (r3 == 2) goto L24;
        if (r3 == 4) goto L21;
    L33:
        r2 = r3;
    L34:
        if (r0 != null) goto L37;
    L39:
        this._interComState.setValue(Integer.valueOf(r2));
        return;
    L37:
        if (r0.intValue() != r2) goto L39;
        return;
    L21:
        if ((r7 instanceof com.bytedance.android.live.revlink.impl.intercomment.f) == false) goto L33;
    L24:
        if ((r7 instanceof com.bytedance.android.live.revlink.impl.intercomment.i) == false) goto L28;
        ((com.bytedance.android.live.revlink.impl.intercomment.i) r7).getClass();
    L26:
        r2 = 4;
        goto L34
    L28:
        if ((r7 instanceof com.bytedance.android.live.revlink.impl.intercomment.h) == true) goto L26;
        if ((r7 instanceof com.bytedance.android.live.revlink.impl.intercomment.f) == false) goto L33;
    L8:
        if ((r7 instanceof com.bytedance.android.live.revlink.impl.intercomment.g) == false) goto L14;
        if (((com.bytedance.android.live.revlink.impl.intercomment.g) r7).a == false) goto L12;
        r2 = 1;
        goto L34
    L12:
        r2 = 2;
        goto L34
    L14:
        if ((r7 instanceof com.bytedance.android.live.revlink.impl.intercomment.h) == false) goto L33;
        goto L33
    }

    public final void setMInterComLogger(com.bytedance.android.live.revlink.impl.intercomment.e r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mInterComLogger = r2;
    }

    public final void setScene(int r1) {
        this.scene = r1;
    }

    public static final /* synthetic */ void access$onMessage(InteractCommentDataContext r0, yh6.c r1) {
        r0.onMessage(r1);
    }

    public static final /* synthetic */ void access$sendAction(InteractCommentDataContext r0, com.bytedance.android.live.revlink.impl.intercomment.a r1) {
        r0.sendAction(r1);
    }

    public static final /* synthetic */ void access$setAnchor$p(InteractCommentDataContext r0, boolean r1) {
        r0.isAnchor = r1;
    }

    public static final /* synthetic */ void access$setFinisher$p(InteractCommentDataContext r0, boolean r1) {
        r0.isFinisher = r1;
    }

    public static final /* synthetic */ void access$setMInviteTimeOutDisposable$p(InteractCommentDataContext r0, Disposable r1) {
        r0.mInviteTimeOutDisposable = r1;
    }

    public static final /* synthetic */ void access$setMIsInviting$p(InteractCommentDataContext r0, boolean r1) {
        r0.mIsInviting = r1;
    }

    public static final /* synthetic */ void access$setMStartTimeInterval$p(InteractCommentDataContext r0, long r1) {
        r0.mStartTimeInterval = r1;
    }

    public static final /* synthetic */ void access$setStarter$p(InteractCommentDataContext r0, boolean r1) {
        r0.isStarter = r1;
    }

    public final void reply(int r10, boolean r12) {
        if (r10 != 1) goto L5;
        int r6 = 1;
    L6:
        r31.a r1 = r31.b.a(r31.a.a);
        com.bytedance.android.livesdk.revenue.room.a r0 = this.roomContext;
        long r2 = 0;
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.m r3 = r0.getRoom();
        if (r3 == null) goto L13;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L13;
        long r5 = r4.getRoomId();
    L14:
        LinkCrossRoomDataHolder r7 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r7 == null) goto L17;
        r2 = r7.c();
    L17:
        Observable<ExtraResponse<l4, Extra>> r13 = r1.intercomReply(r5, r2, r6, r12);
        if (r13 == null) goto L25;
        Observable r14 = r13.compose(RxUtil.rxSchedulerHelper());
        if (r14 == null) goto L26;
        Disposable r15 = r14.subscribe(new g(this, r10), new h(this));
        if (r15 == null) goto L27;
        this.cd.add(r15);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L13:
        r5 = 0;
        goto L14
    L5:
        r6 = 2;
        goto L6
    }
}
