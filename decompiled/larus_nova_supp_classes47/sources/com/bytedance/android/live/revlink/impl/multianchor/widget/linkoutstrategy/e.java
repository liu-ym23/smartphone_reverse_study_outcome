package com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenuelink.connect.n;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectManager;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectModel;
import com.bytedance.android.live.revlink.impl.multianchor.connect.UnexpectedFrameMonitor;
import com.bytedance.android.live.revlink.impl.multianchor.utils.t;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.impl.multianchor.utils.v;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.j;
import com.bytedance.android.live.revlink.impl.utils.r;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.live.revlink.link.biz.service.k;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import z41.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements k, c, f {
    public final d a;
    public final com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.f b;
    public final com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.b c;
    public final Map<String, i6> d;
    public final Set<String> e;
    public final ld.a f;
    public final com.bytedance.android.live.revlink.impl.global.c g;
    public final c h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExtraResponse<bf2.a, Extra> r3 = (ExtraResponse) r2;
            i.H(this.a).q(r3);
            int r0 = r.a;
            int r1 = w11.a.a;
            r.a(r3);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            v r0 = i.H(this.a);
            r0.getClass();
            r0.G("get_ban_record_failed", (Throwable) r5, new JSONObject(), null);
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void finishMultiAnchor(int r8, Function0<Unit> r9, boolean r10, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "reqSrc");
        this.h.finishMultiAnchor(r8, r9, r10, r12, r13);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revenuelink.connect.f getAnchorConnectService() {
        return this.h.getAnchorConnectService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final i11.b getAnchorLinkUserCenter() {
        return this.h.getAnchorLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final t getConnectMonitor() {
        return this.h.getConnectMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final f21.a getConnectionContext() {
        return this.h.getConnectionContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final MultiLinkAnchorControlContext getControlContext() {
        return this.h.getControlContext();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final f41.a getJsbInvitePkCallback() {
        return this.h.getJsbInvitePkCallback();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final u getLaunchParameters() {
        return this.h.getLaunchParameters();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final u.a getLaunchRecord() {
        return this.h.getLaunchRecord();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final com.bytedance.android.live.revlink.impl.multianchor.scope.c getLinkDialogService() {
        return this.h.getLinkDialogService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final ld.a getLinkInternalDataSet() {
        return this.h.getLinkInternalDataSet();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final n getLinkOutManager() {
        return this.h.getLinkOutManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final i11.b getMLinkUserCenter() {
        return this.h.getMLinkUserCenter();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final IRoom getMRoom() {
        return this.h.getMRoom();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final MutableLiveData<q11.c> getPkLinkState() {
        return this.h.getPkLinkState();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final x11.a getRevInternalLinkService() {
        return this.h.getRevInternalLinkService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final wq2.f getRoomDataCenterService() {
        return this.h.getRoomDataCenterService();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final AnchorRtcConnectManager getRtcConnectManager() {
        return this.h.getRtcConnectManager();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final AnchorRtcConnectModel getRtcConnectModel() {
        return this.h.getRtcConnectModel();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final Function0<v51.b> getStreamInteractScopeFn() {
        return this.h.getStreamInteractScopeFn();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final UnexpectedFrameMonitor getUnexpectedFrameMonitor() {
        return this.h.getUnexpectedFrameMonitor();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final boolean isLinkWithAudience() {
        return this.h.isLinkWithAudience();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setConnectionContext(f21.a r2) {
        this.h.setConnectionContext(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setJsbInvitePkCallback(f41.a r2) {
        this.h.setJsbInvitePkCallback(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setLaunchParameters(u r2) {
        this.h.setLaunchParameters(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void setRtcConnectModel(AnchorRtcConnectModel r2) {
        this.h.setRtcConnectModel(r2);
    }

    public final void a() {
        Intrinsics.checkNotNullParameter(this, "$this$linkNetwork");
        Observable<ExtraResponse<bf2.a, Extra>> r0 = i.getContext(this).getLinkNetwork().getLatestBanRecord(14);
        int r1 = p.a;
        r0.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), new b(this));
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f
    public final d Hd() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return this.g;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.f
    public final com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.b qp() {
        return this.c;
    }

    public final void b(i6 r6) {
        Intrinsics.checkNotNullParameter(r6, "_linkerMessage");
        i6 r7 = (i6) r6.castTo(i6.class);
        g r0 = g.o;
        r0.getClass();
        if (((Boolean) g.l.getValue(r0, g.a[10])).booleanValue() == false) goto L14;
        k6 r1 = r7.getReply();
        if (r1 == null) goto L14;
        String r2 = r1.getToUid();
        if (r2 == null) goto L14;
        if (this.e.contains(r2) == false) goto L14;
        this.d.put(r2, r7);
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        return;
    L17:
        t r4 = getConnectMonitor();
        if (r4 == null) goto L20;
        com.bytedance.android.live.revlink.impl.multianchor.utils.g r5 = r4.h(r7);
    L21:
        j r8 = new j(r7, r5);
        k6 r9 = r7.getReply();
        if (r9 != null) goto L24;
    L26:
        Function1 r10 = new RevLinkOutStrategy$handleReceiveReply$dispatch$2(this.b.c);
    L27:
        r10.invoke(r8);
        return;
    L24:
        if (((int) r9.getReplyStatus()) != 1) goto L26;
        r10 = new RevLinkOutStrategy$handleReceiveReply$dispatch$1(this.b.b);
        goto L27
    L20:
        r5 = null;
    L14:
        r3 = false;
        goto L15
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.c
    public final void reset(String r2) {
        Intrinsics.checkNotNullParameter(r2, "src");
        this.a.reset(r2);
    }

    public e(ld.a r2, com.bytedance.android.live.revlink.impl.global.c r3, c r4) {
        Intrinsics.checkNotNullParameter(r3, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r4, "layoutOutStrategyContext");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new d(r3, r4);
        this.b = new com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.f(this, r3);
        this.c = new com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.b(this, r3);
        this.d = new LinkedHashMap();
        this.e = new LinkedHashSet();
    }

    public final void c(d11.g r2, q5 r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "_replyResult");
        com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.r r0 = new com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.consumechain.r(r2, r3.castTo(q5.class), r4);
        if (r2.e != 1) goto L5;
        Function1 r5 = new RevLinkOutStrategy$handleReplySuccess$dispatch$1(this.b.d);
    L6:
        r5.invoke(r0);
        return;
    L5:
        r5 = new RevLinkOutStrategy$handleReplySuccess$dispatch$2(this.b.e);
        goto L6
    }
}
