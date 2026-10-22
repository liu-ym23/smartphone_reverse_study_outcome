package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.interact.model.c0;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomChangeSyncData;
import com.bytedance.android.livesdk.interactivity.api.comment.data.IntercomSyncDataModel;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.ae;
import com.bytedance.android.livesdk.message.model.be;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.p;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001KB\u000f\u0012\u0006\u0010C\u001a\u00020\u000b¢\u0006\u0004\bI\u0010HJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0005R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R!\u00102\u001a\b\u0012\u0004\u0012\u00020.0-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u00101R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\r0%8\u0006¢\u0006\f\n\u0004\b3\u0010'\u001a\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010$R\u0016\u0010>\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010$R\u0016\u0010?\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010$R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010C\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006L"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/MediaInteractCommentDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lvlc/l;", "Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/a;", "action", BuildConfig.FLAVOR, "sendAction", "Ltlc/d;", "message", "onMessage", "invite", BuildConfig.FLAVOR, "replyStatus", BuildConfig.FLAVOR, "banInvite", "reply", "close", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/RoomContext;", "Lio/reactivex/disposables/Disposable;", "mInviteTimeOutDisposable", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "isAnchor", "Z", "Landroidx/lifecycle/MutableLiveData;", "_interComState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "interComState", "Landroidx/lifecycle/LiveData;", "getInterComState", "()Landroidx/lifecycle/LiveData;", "Lcom/bytedance/live/datacontext/k;", BuildConfig.FLAVOR, "onIconClickEvent$delegate", "getOnIconClickEvent", "()Lcom/bytedance/live/datacontext/k;", "onIconClickEvent", "showInterCommentIcon", "getShowInterCommentIcon", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/d;", "mInterComLogger", "Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/d;", "getMInterComLogger", "()Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/d;", "setMInterComLogger", "(Lcom/bytedance/android/livesdk/interactivity/medialink/intercomment/d;)V", "isStarter", "mIsInviting", "isFinisher", BuildConfig.FLAVOR, "mStartTimeInterval", "J", "scene", "I", "getScene", "()I", "setScene", "(I)V", "<init>", "Companion", "c", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaInteractCommentDataContext extends DataContext implements vlc.l {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final c Companion = null;
    public static final long INVITE_TIME_OUT = 20;
    public static final int REPLY_AGREE = 1;
    public static final int REPLY_REFUSE = 2;
    public static final int REPLY_REFUSE_BY_TIME_OUT = 3;
    public static final String TAG = "MediaInteractCommentDataContext";
    private final MutableLiveData<Integer> _interComState;
    private final CompositeDisposable cd;
    private final LiveData<Integer> interComState;
    private boolean isAnchor;
    private boolean isFinisher;
    private boolean isStarter;
    private com.bytedance.android.livesdk.interactivity.medialink.intercomment.d mInterComLogger;
    private Disposable mInviteTimeOutDisposable;
    private boolean mIsInviting;
    private long mStartTimeInterval;
    private final p onIconClickEvent$delegate;
    private final RoomContext roomContext;
    private int scene;
    private final p service$delegate;
    private final MutableLiveData<Boolean> showInterCommentIcon;

    public static final class a implements Action {
        public final /* synthetic */ MediaInteractCommentDataContext a;

        public a(MediaInteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            RoomContext r0 = this.a.getRoomContext();
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
            if (r1 == null) goto L9;
            vlc.d r2 = (vlc.d) r1.getValue();
            if (r2 == null) goto L9;
            r2.removeMessageListener(this.a);
        L9:
            MediaInteractCommentDataContext.access$getCd$p(this.a).dispose();
            Disposable r3 = MediaInteractCommentDataContext.access$getMInviteTimeOutDisposable$p(this.a);
            if (r3 == null) goto L13;
            r3.dispose();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MediaInteractCommentDataContext a;

        public b(MediaInteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            dc2.c.b r14 = (dc2.c.b) r13;
            if (((IntercomChangeSyncData) r14.b).isInIntercom() == false) goto L6;
            MediaInteractCommentDataContext.access$setMStartTimeInterval$p(this.a, System.currentTimeMillis());
            MediaInteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.g());
        L29:
            MediaInteractCommentDataContext.access$setFinisher$p(this.a, false);
            return;
        L6:
            if (((IntercomChangeSyncData) r14.b).closeReason != 3) goto L11;
            if (MediaInteractCommentDataContext.access$isAnchor$p(this.a) == false) goto L11;
            f2.b(2131920270, 0);
        L11:
            if (MediaInteractCommentDataContext.access$isAnchor$p(this.a) == false) goto L28;
            com.bytedance.android.livesdk.interactivity.medialink.intercomment.d r0 = this.a.getMInterComLogger();
            boolean r2 = MediaInteractCommentDataContext.access$isStarter$p(this.a);
            boolean r3 = MediaInteractCommentDataContext.access$isFinisher$p(this.a);
            long r6 = MediaInteractCommentDataContext.access$getMStartTimeInterval$p(this.a);
            long r8 = ((IntercomChangeSyncData) r14.b).closeReason;
            r0.getClass();
            HashMap r15 = new HashMap();
            r15.put("connection_scene", "connection");
            r15.put("channel_id", String.valueOf(e92.m.b()));
            com.bytedance.android.livesdk.interactivity.medialink.intercomment.d.a(r15);
            r15.put("interflow_time", String.valueOf((System.currentTimeMillis() - r6) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
            if (r8 != 2) goto L15;
        L23:
            String r1 = "other_close_type";
        L24:
            r15.put("close_type", r1);
            com.bytedance.android.livesdk.interactivity.api.base.b.a r4 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
            q r5 = q.a;
            r4.getClass();
            com.bytedance.android.livesdk.interactivity.api.base.b r7 = com.bytedance.android.livesdk.interactivity.api.base.b.a.a();
            if (r7 == null) goto L27;
            r15.put("comment_show_cnt", String.valueOf(r7.i));
            r15.put("other_comment_show_cnt", String.valueOf(r7.j));
        L27:
            u.l().sendLog("livesdk_comment_interflow_end", r15, new Object[]{Room.class});
            goto L28
        L15:
            if (r8 == 3) goto L23;
            if (r2 == false) goto L20;
            if (r3 == true) goto L22;
        L21:
            r1 = "guest";
        L22:
            r1 = "host";
            goto L24
        L20:
            if (r3 == false) goto L22;
        L28:
            com.bytedance.android.livesdk.interactivity.api.base.b.a r16 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
            q r9 = q.a;
            r16.getClass();
            com.bytedance.android.livesdk.interactivity.api.base.b.a.d();
            MediaInteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
            goto L29
        }
    }

    public static final class c {
        public c() {
        }

        public final MediaInteractCommentDataContext getContext() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(MediaInteractCommentDataContext.TAG);
            if ((r0 instanceof MediaInteractCommentDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (MediaInteractCommentDataContext) r0;
        }

        public final com.bytedance.android.livesdk.interactivity.medialink.intercomment.b a() {
            MediaInteractCommentDataContext r0 = getContext();
            if (r0 == null) goto L7;
            com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.medialink.intercomment.b> r1 = r0.getService();
            if (r1 == null) goto L7;
            return (com.bytedance.android.livesdk.interactivity.medialink.intercomment.b) r1.getValue();
        L7:
            return null;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MediaInteractCommentDataContext a;

        public d(MediaInteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            MediaInteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
            c0 r4 = (c0) ((BaseResponse) ((Response) r3)).data;
            if (r4 == null) goto L8;
            String r5 = r4.toast;
            if (r5 == null) goto L9;
            f2.c(r5, 0);
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            Context r0 = s1.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r2);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ MediaInteractCommentDataContext a;

        public f(MediaInteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Response r7 = (Response) r6;
            MediaInteractCommentDataContext.access$setMIsInviting$p(this.a, false);
            MediaInteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.f(true));
            Disposable r0 = MediaInteractCommentDataContext.access$getMInviteTimeOutDisposable$p(this.a);
            if (r0 == null) goto L5;
            r0.dispose();
        L5:
            MediaInteractCommentDataContext.access$setMInviteTimeOutDisposable$p(this.a, Observable.timer(20, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.i(this)));
            c0 r8 = (c0) ((BaseResponse) r7).data;
            if (r8 == null) goto L11;
            String r9 = r8.toast;
            if (r9 == null) goto L12;
            f2.c(r9, 0);
            return;
        L12:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ MediaInteractCommentDataContext a;

        public g(MediaInteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            MediaInteractCommentDataContext.access$setMIsInviting$p(this.a, false);
            Context r0 = s1.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r3);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ MediaInteractCommentDataContext a;
        public final /* synthetic */ int b;

        public h(MediaInteractCommentDataContext r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Response r4 = (Response) r3;
            if (this.b != 1) goto L5;
            MediaInteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.g());
        L6:
            c0 r5 = (c0) ((BaseResponse) r4).data;
            if (r5 == null) goto L12;
            String r6 = r5.toast;
            if (r6 == null) goto L13;
            f2.c(r6, 0);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            MediaInteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
            goto L6
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ MediaInteractCommentDataContext a;

        public i(MediaInteractCommentDataContext r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Context r0 = s1.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r2);
            MediaInteractCommentDataContext.access$sendAction(this.a, new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MediaInteractCommentDataContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MediaInteractCommentDataContext.class, "onIconClickEvent", "getOnIconClickEvent()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
        Companion = new c();
    }

    public final void close() {
        this.isFinisher = true;
        LinkInteractCommentApi r0 = (LinkInteractCommentApi) com.bytedance.android.live.network.c.b().e(LinkInteractCommentApi.class);
        RoomContext r1 = this.roomContext;
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L9;
        long r4 = r3.getRoomId();
    L10:
        Disposable r5 = r0.intercomClose(r4, e92.m.b()).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), e.a);
        this.cd.add(r5);
        return;
    L9:
        r4 = 0;
        goto L10
    }

    public final com.bytedance.live.datacontext.k<Object> getOnIconClickEvent() {
        return (com.bytedance.live.datacontext.k) this.onIconClickEvent$delegate.a(this, $$delegatedProperties[1]);
    }

    public final com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.medialink.intercomment.b> getService() {
        return (com.bytedance.live.datacontext.j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public final void invite() {
        this.isStarter = true;
        if (this.mIsInviting == false) goto L5;
        return;
    L5:
        this.mIsInviting = true;
        LinkInteractCommentApi r0 = (LinkInteractCommentApi) com.bytedance.android.live.network.c.b().e(LinkInteractCommentApi.class);
        RoomContext r1 = this.roomContext;
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L12;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L12;
        long r4 = r3.getRoomId();
    L13:
        Disposable r5 = r0.intercomInvite(r4, e92.m.b()).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this), new g(this));
        this.cd.add(r5);
        return;
    L12:
        r4 = 0;
        goto L13
    }

    public final LiveData<Integer> getInterComState() {
        return this.interComState;
    }

    public final com.bytedance.android.livesdk.interactivity.medialink.intercomment.d getMInterComLogger() {
        return this.mInterComLogger;
    }

    public final RoomContext getRoomContext() {
        return this.roomContext;
    }

    public final int getScene() {
        return this.scene;
    }

    public final MutableLiveData<Boolean> getShowInterCommentIcon() {
        return this.showInterCommentIcon;
    }

    public MediaInteractCommentDataContext(int r4) {
        this.scene = r4;
        this.service$delegate = ConstantKt.c(this);
        DataContext r5 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        if ((r5 instanceof RoomContext) == true) goto L5;
        r5 = null;
    L5:
        RoomContext r6 = (RoomContext) r5;
        this.roomContext = r6;
        CompositeDisposable r0 = new CompositeDisposable();
        this.cd = r0;
        if (r6 == null) goto L12;
        com.bytedance.live.datacontext.i r1 = r6.isAnchor();
        if (r1 == null) goto L12;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L12;
        boolean r3 = r2.booleanValue();
    L13:
        this.isAnchor = r3;
        MutableLiveData<Integer> r7 = new MutableLiveData();
        this._interComState = r7;
        this.interComState = r7;
        this.onIconClickEvent$delegate = com.bytedance.live.datacontext.e.b(this);
        this.showInterCommentIcon = new MutableLiveData();
        this.mInterComLogger = new com.bytedance.android.livesdk.interactivity.medialink.intercomment.d();
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r0);
        if (r6 == null) goto L20;
        com.bytedance.live.datacontext.j r8 = r6.getMessageManager();
        if (r8 == null) goto L20;
        vlc.d r9 = (vlc.d) r8.getValue();
        if (r9 == null) goto L20;
        r9.addMessageListener(MessageType.INTER_COM_INVITE.getIntType(), this);
        r9.addMessageListener(MessageType.INTER_COM_REPLY.getIntType(), this);
    L20:
        IntercomSyncDataModel r10 = q.h();
        if (r10 == null) goto L30;
        dc2.c<IntercomChangeSyncData> r11 = r10.getIntercomStatus();
        if (r11 == null) goto L30;
        IntercomChangeSyncData r13 = r11.c();
        if (r13 == null) goto L30;
        if (r13.isInIntercom() == false) goto L29;
        sendAction(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.g());
        goto L30
    L29:
        sendAction(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
    L30:
        IntercomSyncDataModel r14 = q.h();
        if (r14 == null) goto L40;
        dc2.c<IntercomChangeSyncData> r15 = r14.getIntercomStatus();
        if (r15 == null) goto L41;
        Observable<dc2.c.b<IntercomChangeSyncData>> r16 = r15.b();
        if (r16 == null) goto L42;
        Disposable r17 = r16.subscribe(new b(this));
        if (r17 == null) goto L43;
        r0.add(r17);
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L12:
        r3 = false;
        goto L13
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(MediaInteractCommentDataContext r0) {
        return r0.cd;
    }

    public static final /* synthetic */ Disposable access$getMInviteTimeOutDisposable$p(MediaInteractCommentDataContext r0) {
        return r0.mInviteTimeOutDisposable;
    }

    public static final /* synthetic */ boolean access$getMIsInviting$p(MediaInteractCommentDataContext r0) {
        return r0.mIsInviting;
    }

    public static final /* synthetic */ long access$getMStartTimeInterval$p(MediaInteractCommentDataContext r2) {
        return r2.mStartTimeInterval;
    }

    public static final /* synthetic */ boolean access$isAnchor$p(MediaInteractCommentDataContext r0) {
        return r0.isAnchor;
    }

    public static final /* synthetic */ boolean access$isFinisher$p(MediaInteractCommentDataContext r0) {
        return r0.isFinisher;
    }

    public static final /* synthetic */ boolean access$isStarter$p(MediaInteractCommentDataContext r0) {
        return r0.isStarter;
    }

    private final void sendAction(com.bytedance.android.livesdk.interactivity.medialink.intercomment.a r7) {
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
        if ((r7 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.e) == false) goto L33;
    L24:
        if ((r7 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.h) == false) goto L28;
        ((com.bytedance.android.livesdk.interactivity.medialink.intercomment.h) r7).getClass();
    L26:
        r2 = 4;
        goto L34
    L28:
        if ((r7 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.g) == true) goto L26;
        if ((r7 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.e) == false) goto L33;
    L8:
        if ((r7 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.f) == false) goto L14;
        if (((com.bytedance.android.livesdk.interactivity.medialink.intercomment.f) r7).a == false) goto L12;
        r2 = 1;
        goto L34
    L12:
        r2 = 2;
        goto L34
    L14:
        if ((r7 instanceof com.bytedance.android.livesdk.interactivity.medialink.intercomment.g) == false) goto L33;
        goto L33
    }

    public void onMessage(tlc.d r6) {
        if ((r6 instanceof ae) == false) goto L6;
        this.isStarter = false;
        sendAction(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.f(false));
        return;
    L6:
        if ((r6 instanceof be) == false) goto L28;
        be r7 = (be) r6;
        String r0 = r7.getMToast();
        if (r0 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L16;
        f2.c(r7.getMToast(), 0);
    L16:
        Disposable r2 = this.mInviteTimeOutDisposable;
        if (r2 == null) goto L20;
        r2.dispose();
    L20:
        if (r7.getMReplyStatus() != 1) goto L23;
        sendAction(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.g());
        return;
    L23:
        if (this.isAnchor == false) goto L25;
        this.mInterComLogger.getClass();
        HashMap r8 = new HashMap();
        r8.put("connection_scene", "connection");
        r8.put("channel_id", String.valueOf(e92.m.b()));
        com.bytedance.android.livesdk.interactivity.medialink.intercomment.d.a(r8);
        u.l().sendLog("livesdk_refuse_feedback", r8, new Object[]{Room.class});
    L25:
        sendAction(new com.bytedance.android.livesdk.interactivity.medialink.intercomment.e());
        return;
    L10:
        if (r0.length() == 0) goto L13;
        r1 = false;
        goto L14
    }

    public final void setMInterComLogger(com.bytedance.android.livesdk.interactivity.medialink.intercomment.d r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mInterComLogger = r2;
    }

    public final void setScene(int r1) {
        this.scene = r1;
    }

    public static final /* synthetic */ void access$sendAction(MediaInteractCommentDataContext r0, com.bytedance.android.livesdk.interactivity.medialink.intercomment.a r1) {
        r0.sendAction(r1);
    }

    public static final /* synthetic */ void access$setAnchor$p(MediaInteractCommentDataContext r0, boolean r1) {
        r0.isAnchor = r1;
    }

    public static final /* synthetic */ void access$setFinisher$p(MediaInteractCommentDataContext r0, boolean r1) {
        r0.isFinisher = r1;
    }

    public static final /* synthetic */ void access$setMInviteTimeOutDisposable$p(MediaInteractCommentDataContext r0, Disposable r1) {
        r0.mInviteTimeOutDisposable = r1;
    }

    public static final /* synthetic */ void access$setMIsInviting$p(MediaInteractCommentDataContext r0, boolean r1) {
        r0.mIsInviting = r1;
    }

    public static final /* synthetic */ void access$setMStartTimeInterval$p(MediaInteractCommentDataContext r0, long r1) {
        r0.mStartTimeInterval = r1;
    }

    public static final /* synthetic */ void access$setStarter$p(MediaInteractCommentDataContext r0, boolean r1) {
        r0.isStarter = r1;
    }

    public final void reply(int r9, boolean r10) {
        if (r9 != 1) goto L5;
        int r6 = 1;
    L6:
        LinkInteractCommentApi r1 = (LinkInteractCommentApi) com.bytedance.android.live.network.c.b().e(LinkInteractCommentApi.class);
        RoomContext r0 = this.roomContext;
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.m r2 = r0.getRoom();
        if (r2 == null) goto L13;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L13;
        long r4 = r3.getRoomId();
    L14:
        Disposable r11 = r1.intercomReply(r4, e92.m.b(), r6, r10).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r9), new i(this));
        this.cd.add(r11);
        return;
    L13:
        r4 = 0;
        goto L14
    L5:
        r6 = 2;
        goto L6
    }
}
