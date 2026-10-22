package com.bytedance.android.live.livepkaudience.base;

import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.config.h9;
import com.bytedance.android.livesdk.config.u7;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.CircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.Disposable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/base/BasePkInteractAnchorWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lgy/d;", "", "<init>", "()V", "a", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BasePkInteractAnchorWidget extends LiveWidget implements gy.d, g {
    public Room a;
    public p b;
    public gy.f c;
    public int d;
    public long e;
    public int f;
    public final ArrayList<User> g;
    public final HashMap<String, Long> h;
    public final HashMap<String, Long> i;
    public String j;
    public String k;

    public interface a {
    }

    public final void A(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    public final void C1(vc0.a r1, vc0.a[] r2) {
    }

    public void J(String[] r1, boolean[] r2, int[] r3) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void L2(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
    }

    public void S(String r1, int r2, int r3) {
    }

    public final void S3(String r1, ByteBuffer r2) {
    }

    public void V4(String r1, uf2.z.a r2) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void V6(String r2, LinkInviteResult r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    public final void X0(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void c7(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
    }

    public final void f1(long r1, long r3) {
    }

    public final void g(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    public abstract i getLinkUserCenter();

    public void j0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void k5(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void l(String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "uid");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void nm(xe r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    public final void o0(long r1) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void onPermitSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
    }

    public final void onUserJoined(String r2) {
        Intrinsics.checkNotNullParameter(r2, "interactId");
    }

    public final void p1(int r1, int r2) {
    }

    public final void s(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
    }

    public final void u1(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    public abstract int xq();

    public void y0(String r1, SurfaceView r2, int r3, int r4) {
    }

    public void o() {
        Iterator<User> r0 = this.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        User r1 = r0.next();
        p r2 = this.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L8:
        r2.e(r1.getIdString(), r1.getCastSecUid());
        goto L4
    L9:
        this.g.clear();
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void u0() {
        if (TextUtils.equals(this.k, "stop_normally") == false) goto L5;
    L6:
        hd0.c.f().k(0);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L9;
        r0.put("cmd_interact_state_change", new a1(8));
    L9:
        xs2.b.a().post(new com.bytedance.android.live.liveinteract.d(1));
        xs2.b.a().post(new a1(15));
        int r1 = al0.b.a;
        DataCenter r2 = ((Widget) this).dataCenter;
        long r3 = this.e;
        int r4 = this.f;
        Room r5 = this.a;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L12:
        ICircleInfo r6 = r5.getCircleInfo();
        if ((r6 instanceof CircleInfo) == true) goto L15;
        r6 = null;
    L15:
        al0.b.e(r2, r3, r4, (CircleInfo) r6, 48);
        this.k = "";
        return;
    L5:
        if (TextUtils.equals(this.k, "pre_apply") == true) goto L6;
    }

    public BasePkInteractAnchorWidget() {
        this.g = new ArrayList();
        this.h = new HashMap();
        this.i = new HashMap();
        this.j = "";
        this.k = "";
    }

    public void onCreate() {
        super.onCreate();
        this.a = (Room) ((Widget) this).dataCenter.get("data_room", new Room());
        p r0 = new p(((Widget) this).dataCenter);
        this.b = r0;
        vlc.d r1 = r0.a;
        if (r1 == null) goto L5;
        r1.addMessageListener(MessageType.LINK_MIC.getIntType(), r0);
    L5:
        gy.c.c2.getClass();
        gy.c r2 = gy.c.a.a();
        if (r2 == null) goto L8;
        gy.f r3 = r2.getRtcManager();
    L9:
        this.c = r3;
        this.d = xq();
        getLinkUserCenter().e();
        p r4 = this.b;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L12:
        r4.a(this);
        return;
    L8:
        r3 = null;
        goto L9
    }

    public void onDestroy() {
        super.onDestroy();
        getLinkUserCenter().g();
        p r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L5:
        r0.f(this);
        p r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L8:
        r1.b();
        this.k = "";
        tc0.c.h().j(Boolean.FALSE);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public void Em(xe r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        if (r3.getReplyType() != 1) goto L8;
        gy.f r4 = this.c;
        if (r4 == null) goto L12;
        r4.m(this);
        return;
    L12:
        return;
    L8:
        if (TextUtils.isEmpty(r3.getReplyPrompts()) == true) goto L10;
        f2.c(r3.getReplyPrompts(), 0);
        return;
    L10:
        f2.b(2131919242, 0);
    }

    public final void L(String r10) {
        User r11 = getLinkUserCenter().t(r10);
        if (r11 == null) goto L31;
        String r12 = r11.getIdStr();
        if (r12 == null) goto L32;
        long r0 = System.currentTimeMillis();
        Long r2 = this.i.get(r12);
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.longValue() <= 0) goto L29;
        long r1 = r0 - r2.longValue();
        String r3 = this.j;
        dl0.m r4 = dl0.m.a;
        if (((Boolean) u7.a.getValue()).booleanValue() == false) goto L13;
        int r5 = 111;
    L14:
        if (r3 == null) goto L25;
        int r6 = 1;
        if (r3.length() <= 0) goto L18;
        boolean r7 = true;
    L19:
        if (r7 != true) goto L25;
        if (Intrinsics.areEqual(r3, "apply") == true) goto L24;
        r6 = 2;
    L24:
        r5 = r5 + (r6 * 1000);
        goto L25
    L18:
        r7 = false;
    L25:
        JSONObject r8 = new JSONObject();
        if (r3 != null) goto L28;
        r3 = "";
    L28:
        BaseMonitor.add(r8, "join_channel_type", r3);
        BaseMonitor.add(r8, "stats", r5);
        BaseMonitor.add(r8, "duration", r1);
        dl0.m.a.getClass();
        dl0.m.A("interaction_mode_anchor_connection_success", r8);
        goto L29
    L13:
        r5 = 11;
    L29:
        this.i.remove(r12);
        this.j = "";
        return;
    L32:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.g
    public final void l0(Throwable r2) {
        ExceptionUtils.handleException(((Widget) this).context, r2);
    }

    public final void yq(String r9) {
        User r10 = getLinkUserCenter().t(r9);
        if (r10 == null) goto L14;
        String r11 = r10.getIdStr();
        if (r11 == null) goto L15;
        long r0 = System.currentTimeMillis();
        Long r2 = this.h.get(r11);
        if (r2 != null) goto L9;
    L12:
        Long r12 = (Long) tc0.c.h().t.remove(r11);
        return;
    L9:
        if (r2.longValue() <= 0) goto L11;
        com.bytedance.android.live.liveinteract.plantform.utils.x.B(1, r0 - r2.longValue());
    L11:
        Long r1 = this.h.remove(r11);
        goto L12
    L15:
        return;
    }

    public void R(long r1, Exception r3) {
        ALogger.e("ttlive_link", "", r3);
        this.g.clear();
        p r2 = this.b;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L5:
        r2.f.clear();
        r2.g.clear();
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L9;
        r4.put("cmd_interact_state_change", new a1(8));
        return;
    }

    public void e1(String r5, long r6) {
        LinkPlayerInfo r0 = getLinkUserCenter().k("0", r5);
        if (r6 == 1) goto L5;
    L20:
        getLinkUserCenter().E(r5);
        return;
    L5:
        if (((Boolean) h9.a.getValue()).booleanValue() == false) goto L20;
        if (r0 == null) goto L13;
        IBaseUser r7 = r0.getUser();
        if (r7 == null) goto L13;
        p r8 = this.b;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L12:
        String r1 = r7.getIdString();
        Intrinsics.checkNotNullParameter(r7, "$this$secUidExt");
        r8.d(r1, r7.getCastSecUid(), "rtc_user_lost");
    L13:
        if (r0 == null) goto L18;
        IBaseUser r9 = r0.getUser();
        if (r9 == null) goto L18;
        String r10 = r9.getIdString();
        if (r10 == null) goto L18;
    L19:
        com.bytedance.android.live.liveinteract.plantform.utils.x.w(r10);
    L18:
        r10 = "";
        goto L19
    }

    public void f0(long r1, Exception r3) {
        wq(this.d, "stop_on_rtc_error");
    }

    public final void wq(int r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "requestFrom");
        this.k = r8;
        p r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "requestFrom");
        if (r1.h == true) goto L9;
        r1.h = true;
        long r2 = System.currentTimeMillis();
        Disposable r9 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).finishV1(r1.c.id, r7, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(r1, r2, r8), new l(r1, r2, r8));
        r1.b.add(r9);
    L9:
        this.g.clear();
    }

    public void L0(String r1, TextureView r2, int r3, int r4) {
        yq(r1);
    }

    public final void b4(String r1, uf2.z.a r2, int r3, int r4) {
        yq(r1);
    }

    public void h1(String r1, SurfaceView r2, int r3, int r4) {
        yq(r1);
    }
}
