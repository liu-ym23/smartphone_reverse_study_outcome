package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.multianchor.utils.e0;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.utils.t;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.c7;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.n9;
import com.bytedance.android.livesdk.link.model.o6;
import com.bytedance.android.livesdk.link.model.p6;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkBackendService;", "Lcom/bytedance/live/datacontext/DataContext;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "Ld11/o;", "params", "switchChannelInvite", "Ld11/p;", "switchChannelReply", "Ld11/n;", "switchChannelCancel", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lyz0/l;", "messageService", "Lyz0/l;", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkBackendService$b;", "apiListener", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkBackendService$b;", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkDataContext;", "dataContext", "Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkDataContext;", "<init>", "(Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkBackendService$b;Lcom/bytedance/android/live/revlink/impl/multianchor/connect/RelinkDataContext;)V", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RelinkBackendService extends DataContext {
    private final b apiListener;
    private final CompositeDisposable cd;
    private final RelinkDataContext dataContext;
    private final yz0.l messageService;

    public static final class a implements Action {
        public final /* synthetic */ RelinkBackendService a;

        public a(RelinkBackendService r1) {
            this.a = r1;
        }

        public final void run() {
            RelinkBackendService.access$getCd$p(this.a).clear();
        }
    }

    public interface b {
        void a(d11.p r1);

        void c(d11.o r1, n9 r2);

        void d(d11.n r1);

        void f(d11.n r1, Throwable r2);

        void g(d11.o r1, Throwable r2);

        void h(d11.p r1, Throwable r2);
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ RelinkBackendService a;
        public final /* synthetic */ d11.n b;
        public final /* synthetic */ long c;

        public d(RelinkBackendService r1, d11.n r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r20) {
            ExtraResponse r1 = (ExtraResponse) r20;
            e0 r2 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r2 == null) goto L5;
            d11.n r3 = this.b;
            long r4 = t.a(this.c);
            Intrinsics.checkNotNullParameter(r3, "params");
            JSONObject r6 = new JSONObject();
            int r7 = y50.b.a;
            y50.b.a.d(r6, "params", r3.toString());
            r2.c(r6);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r2).E("switch_channel_cancel_success", r4, r6);
            com.bytedance.android.live.revlink.link.biz.service.i.b0(r2).e("/webcast/linkmic/switch_channel_cancel/", new d31.a(0, 0, 0, 0, r3.f, 0, 0, null, null, null, null, 4079), r4);
        L5:
            RelinkBackendService.access$getApiListener$p(this.a).d(this.b);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ RelinkBackendService a;
        public final /* synthetic */ d11.n b;
        public final /* synthetic */ long c;

        public e(RelinkBackendService r1, d11.n r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r22) {
            Throwable r7 = (Throwable) r22;
            e0 r1 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r1 == null) goto L5;
            d11.n r2 = this.b;
            long r5 = t.a(this.c);
            Intrinsics.checkNotNullParameter(r2, "params");
            JSONObject r4 = new JSONObject();
            int r8 = y50.b.a;
            y50.b.a.d(r4, "params", r2.toString());
            r1.c(r4);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r1).G("switch_channel_cancel_failed", r7, r4, Long.valueOf(r5));
            com.bytedance.android.live.revlink.link.biz.service.i.b0(r1).c("/webcast/linkmic/switch_channel_cancel/", new d31.a(0, 0, 0, 0, r2.f, 0, 0, null, null, null, null, 4079), r7, r5);
        L5:
            RelinkBackendService.access$getApiListener$p(this.a).f(this.b, r7);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ RelinkBackendService a;
        public final /* synthetic */ d11.o b;
        public final /* synthetic */ long c;

        public f(RelinkBackendService r1, d11.o r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r22) {
            ExtraResponse r1 = (ExtraResponse) r22;
            if (r1 == null) goto L15;
            n9 r2 = (n9) r1.data;
            if (r2 == null) goto L15;
            if (r2.isFailure() == true) goto L15;
            e0 r3 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r3 == null) goto L18;
            d11.o r4 = this.b;
            n9 r5 = (n9) r1.data;
            long r6 = t.a(this.c);
            Intrinsics.checkNotNullParameter(r4, "params");
            JSONObject r7 = new JSONObject();
            int r8 = y50.b.a;
            y50.b.a.d(r7, "invite_params", r4.toString());
            if (r5 == null) goto L13;
            Long r9 = Long.valueOf(r5.getWaitSec());
        L14:
            y50.b.a.d(r7, "wait_sec", String.valueOf(r9));
            r3.c(r7);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r3).E("switch_channel_invite_success", r6, r7);
            com.bytedance.android.live.revlink.link.biz.service.i.b0(r3).e("/webcast/linkmic/switch_channel_invite/", new d31.a(r4.b, 0, 0, 0, null, 0, 0, null, null, null, null, 4094), r6);
            goto L18
        L13:
            r9 = null;
        L18:
            RelinkBackendService.access$getDataContext$p(this.a).getRelinkInviteSuccess().post(r1.data);
            RelinkBackendService.access$getApiListener$p(this.a).c(this.b, (n9) r1.data);
            return;
        L15:
            e0 r10 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r10 == null) goto L18;
            r10.m(this.b, (n9) r1.data, new Exception("inviter not support"), t.a(this.c));
            goto L18
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ RelinkBackendService a;
        public final /* synthetic */ d11.o b;
        public final /* synthetic */ long c;

        public g(RelinkBackendService r1, d11.o r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            e0 r0 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r0 == null) goto L5;
            r0.m(this.b, null, r8, t.a(this.c));
        L5:
            RelinkBackendService.access$getApiListener$p(this.a).g(this.b, r8);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ RelinkBackendService a;
        public final /* synthetic */ d11.p b;
        public final /* synthetic */ long c;

        public h(RelinkBackendService r1, d11.p r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r20) {
            ExtraResponse r1 = (ExtraResponse) r20;
            e0 r2 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r2 == null) goto L5;
            d11.p r3 = this.b;
            long r4 = t.a(this.c);
            Intrinsics.checkNotNullParameter(r3, "params");
            JSONObject r5 = new JSONObject();
            int r6 = y50.b.a;
            y50.b.a.d(r5, "reply_params", r3.toString());
            r2.c(r5);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r2).E("switch_channel_reply_success", r4, r5);
            com.bytedance.android.live.revlink.link.biz.service.i.b0(r2).e("/webcast/linkmic/switch_channel_reply/", new d31.a(r3.g, 0, 0, 0, null, r3.a, 0, null, null, null, null, 4062), r4);
        L5:
            RelinkBackendService.access$getApiListener$p(this.a).a(this.b);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ RelinkBackendService a;
        public final /* synthetic */ d11.p b;
        public final /* synthetic */ long c;

        public i(RelinkBackendService r1, d11.p r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r22) {
            Throwable r7 = (Throwable) r22;
            e0 r1 = com.bytedance.android.live.revlink.impl.global.b.Z();
            if (r1 == null) goto L5;
            d11.p r2 = this.b;
            long r5 = t.a(this.c);
            Intrinsics.checkNotNullParameter(r2, "params");
            JSONObject r3 = new JSONObject();
            int r4 = y50.b.a;
            y50.b.a.d(r3, "reply_params", r2.toString());
            r1.c(r3);
            com.bytedance.android.live.revlink.link.biz.service.i.H(r1).G("switch_channel_reply_failed", r7, r3, Long.valueOf(r5));
            com.bytedance.android.live.revlink.link.biz.service.i.b0(r1).c("/webcast/linkmic/switch_channel_reply/", new d31.a(r2.g, 0, 0, 0, null, r2.a, 0, null, null, null, null, 4062), r7, r5);
        L5:
            RelinkBackendService.access$getApiListener$p(this.a).h(this.b, r7);
        }
    }

    public static final /* synthetic */ b access$getApiListener$p(RelinkBackendService r0) {
        return r0.apiListener;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(RelinkBackendService r0) {
        return r0.cd;
    }

    public static final /* synthetic */ RelinkDataContext access$getDataContext$p(RelinkBackendService r0) {
        return r0.dataContext;
    }

    private final void onMessage(yh6.c r10) {
        if ((r10 instanceof h1) == false) goto L42;
        i6 r12 = ((h1) r10).castTo(i6.class);
        switch(((int) r12.getType2())) {
            case 60: goto L31;
            case 61: goto L11;
            case 62: goto L7;
            default: goto L45;
        };
    L7:
        e0 r0 = com.bytedance.android.live.revlink.impl.global.b.Z();
        if (r0 == null) goto L10;
        Intrinsics.checkNotNullParameter(r12, Constants.OperatorKey.MSG);
        JSONObject r1 = new JSONObject();
        com.bytedance.android.live.revlink.link.biz.service.i.H(r0).getClass();
        v.m(r12, r1);
        com.bytedance.android.live.revlink.link.biz.service.i.H(r0).I("receive_switch_channel_cancel_msg", r1, false);
    L10:
        this.dataContext.getReceiveSwitchChannelCancel().post(r12);
        return;
    L11:
        e0 r2 = com.bytedance.android.live.revlink.impl.global.b.Z();
        if (r2 == null) goto L30;
        Intrinsics.checkNotNullParameter(r12, Constants.OperatorKey.MSG);
        JSONObject r3 = new JSONObject();
        p6 r4 = r12.getSwitchChannelReplyContent();
        if (r4 == null) goto L29;
        k6 r5 = r4.getReplyContent();
        if (r5 == null) goto L29;
        int r6 = y50.b.a;
        y50.b.a.d(r3, "reply_status", String.valueOf(r5.getReplyStatus()));
        String r7 = r5.getFromUid();
        String r8 = "";
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        y50.b.a.d(r3, "from_user", r7);
        y50.b.a.c(r3, "from_room", r5.getFromRoomId());
        y50.b.a.d(r3, "match_type", String.valueOf(r5.getMatchType()));
        String r9 = r5.getToUid();
        if (r9 == null) goto L24;
        r8 = r9;
    L24:
        y50.b.a.d(r3, "to_user", r8);
        b7 r13 = r5.getMultiChannelInfo();
        if (r13 == null) goto L27;
        String r14 = c7.a(r13);
    L28:
        y50.b.a.d(r3, "multi_channel_info", r14);
        y50.b.a.d(r3, "multi_channel_version", String.valueOf(r5.getVersion()));
        goto L29
    L27:
        r14 = null;
    L29:
        com.bytedance.android.live.revlink.link.biz.service.i.H(r2).getClass();
        v.m(r12, r3);
        r2.c(r3);
        com.bytedance.android.live.revlink.link.biz.service.i.H(r2).I("receive_switch_channel_reply_msg", r3, false);
    L30:
        this.dataContext.getReceiveSwitchChannelReply().post(r12);
        return;
    L31:
        e0 r15 = com.bytedance.android.live.revlink.impl.global.b.Z();
        if (r15 == null) goto L40;
        Intrinsics.checkNotNullParameter(r12, Constants.OperatorKey.MSG);
        JSONObject r16 = new JSONObject();
        o6 r17 = r12.getSwitchChannelInviteContent();
        if (r17 == null) goto L36;
        r17.getInviteContent();
    L36:
        IBattleLinkerInviteMessageExtra r18 = j6.a(r12);
        if (r18 == null) goto L39;
        int r19 = y50.b.a;
        y50.b.a.d(r16, "match_type", String.valueOf(r18.getMatchType()));
        y50.b.a.d(r16, "invite_type", String.valueOf(r18.getInviteType()));
    L39:
        com.bytedance.android.live.revlink.link.biz.service.i.H(r15).getClass();
        v.m(r12, r16);
        r15.c(r16);
        com.bytedance.android.live.revlink.link.biz.service.i.H(r15).I("receive_switch_channel_invite_msg", r16, false);
    L40:
        this.dataContext.getReceiveSwitchChannelInvite().post(r12);
        return;
    L45:
        return;
    }

    public final void switchChannelCancel(d11.n r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        jy0.b.d("ttlive_anchor_link_relink", "switchChannelCancel " + r12);
        long r0 = System.currentTimeMillis();
        Observable<ExtraResponse<Object, Extra>> r2 = r31.b.a(r31.a.a).d(r12.a, r12.b, r12.c, r12.d, r12.e);
        if (r2 == null) goto L10;
        Observable r3 = r2.compose(RxUtil.rxSchedulerHelper());
        if (r3 == null) goto L11;
        Disposable r13 = r3.subscribe(new d(this, r12, r0), new e(this, r12, r0));
        if (r13 == null) goto L12;
        this.cd.add(r13);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void switchChannelInvite(d11.o r13) {
        Intrinsics.checkNotNullParameter(r13, "params");
        jy0.b.d("ttlive_anchor_link_relink", "switchChannelInvite " + r13);
        long r0 = System.currentTimeMillis();
        Observable<ExtraResponse<n9, Extra>> r2 = r31.b.a(r31.a.a).E(r13.a, r13.b, r13.c, r13.d, r13.e, r13.f);
        if (r2 == null) goto L10;
        Observable r3 = r2.compose(RxUtil.rxSchedulerHelper());
        if (r3 == null) goto L11;
        Disposable r14 = r3.subscribe(new f(this, r13, r0), new g(this, r13, r0));
        if (r14 == null) goto L12;
        this.cd.add(r14);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void switchChannelReply(d11.p r19) {
        Intrinsics.checkNotNullParameter(r19, "params");
        jy0.b.d("ttlive_anchor_link_relink", "switchChannelReply " + r19);
        long r2 = System.currentTimeMillis();
        Observable<ExtraResponse<Object, Extra>> r0 = r31.b.a(r31.a.a).L(r19.a, r19.b, r19.c, r19.d, r19.e, r19.f, r19.g, r19.h);
        if (r0 == null) goto L10;
        Observable r1 = r0.compose(RxUtil.rxSchedulerHelper());
        if (r1 == null) goto L10;
        Disposable r3 = r1.subscribe(new h(this, r19, r2), new i(this, r19, r2));
        if (r3 == null) goto L11;
        this.cd.add(r3);
        return;
    L11:
        return;
    }

    public RelinkBackendService(b r4, RelinkDataContext r5) {
        Intrinsics.checkNotNullParameter(r4, "apiListener");
        Intrinsics.checkNotNullParameter(r5, "dataContext");
        this.apiListener = r4;
        this.dataContext = r5;
        CompositeDisposable r6 = new CompositeDisposable();
        this.cd = r6;
        yz0.l r7 = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        this.messageService = r7;
        if (r7 == null) goto L7;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r8 = yz0.h.a.a(r7, com.bytedance.android.live.revenue.common.message.b.b, false, 6);
        final RelinkBackendService$1$1 r0 = new RelinkBackendService$1$1(this);
        Disposable r9 = r8.subscribe(new c(r0));
        if (r9 == null) goto L7;
        RxUtilKt.c(r9, r6);
    L7:
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r6);
    }

    public static final /* synthetic */ void access$onMessage(RelinkBackendService r0, yh6.c r1) {
        r0.onMessage(r1);
    }
}
