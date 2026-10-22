package com.bytedance.android.live.anchorlink;

import android.view.SurfaceView;
import android.view.TextureView;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.liveinteract.plantform.base.h;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.model.AnchorJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkLeaveResult;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import ey.i;
import gy.c;
import gy.d;
import gy.f;
import gy.g;
import hy.e;
import java.nio.ByteBuffer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc0.b;
import uf2.z;
import vc0.a;
import zg1.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/anchorlink/BaseEqualLinkWidget;", "Lcom/bytedance/android/live/liveinteract/plantform/base/h;", "T", "Lcom/bytedance/android/live/anchorlink/BaseRevLinkWidget;", "Lgy/d;", "Ley/h;", "Lgy/g;", "<init>", "()V", "liveanchorlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseEqualLinkWidget<T extends h> extends BaseRevLinkWidget implements d, ey.h, g {
    public Room a;
    public i b;
    public f c;
    public boolean d;
    public boolean e;
    public RevAnchorParamChangeListener f;
    public final b g;

    @Override // gy.d
    public final void A(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // gy.d
    public final void C1(a r1, a[] r2) {
    }

    @Override // gy.d
    public final void J(String[] r1, boolean[] r2, int[] r3) {
    }

    @Override // gy.d
    public final void L(String r1) {
    }

    @Override // gy.d
    public void L0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // gy.d
    public void S(String r1, int r2, int r3) {
    }

    @Override // gy.d
    public final void S3(String r1, ByteBuffer r2) {
    }

    @Override // gy.d
    public void V4(String r1, z.a r2) {
    }

    @Override // gy.d
    public final void X0(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // ey.h
    public void Z2(fy.d r2) {
        Intrinsics.checkNotNullParameter(r2, "finishParams");
    }

    @Override // gy.d
    public void b4(String r1, z.a r2, int r3, int r4) {
    }

    @Override // gy.d
    public void e1(String r1, long r2) {
    }

    @Override // gy.d
    public final void f1(long r1, long r3) {
    }

    @Override // gy.d
    public final void g(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    @Override // gy.d
    public void h1(String r1, SurfaceView r2, int r3, int r4) {
    }

    @Override // ey.h
    public final void i3(fy.d r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "finishParams");
    }

    @Override // gy.d
    public void j0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // ey.h
    public void m2(fy.h r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "leaveParams");
    }

    @Override // gy.d
    public void o() {
    }

    @Override // gy.d
    public final void o0(long r1) {
    }

    @Override // gy.d
    public final void p1(int r1, int r2) {
    }

    @Override // gy.d
    public final void s(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "from");
        Intrinsics.checkNotNullParameter(r3, "message");
    }

    @Override // gy.d
    public final void u1(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public abstract e wq();

    @Override // gy.d
    public void y0(String r1, SurfaceView r2, int r3, int r4) {
    }

    public abstract void zq(String r1, dy.a r2);

    public BaseEqualLinkWidget() {
        ey.g.a.getClass();
        this.g = ey.g.a.a();
    }

    @Override // com.bytedance.android.live.anchorlink.BaseRevLinkWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public void onCreate() {
        super.onCreate();
        this.a = (Room) ((Widget) this).dataCenter.get("data_room", new Room());
        boolean r0 = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.d = r0;
        if (r0 == false) goto L30;
        b r1 = this.g;
        if (r1 == null) goto L7;
        this.b = new nc0.h(r1.d.linkInManager());
    L7:
        c.c2.getClass();
        c r2 = c.a.a();
        if (r2 == null) goto L10;
        f r3 = r2.getRtcManager();
    L11:
        this.c = r3;
        b r4 = this.g;
        if (r4 == null) goto L14;
        int r5 = getScene();
        Intrinsics.checkNotNullParameter(this, "listener");
        nc0.g r6 = new nc0.g(this);
        r4.d.addLinkInListener(r5, r6);
        ((HashMap) r4.c).put(this, r6);
    L14:
        RevAnchorParamChangeListener r7 = new RevAnchorParamChangeListener(this.c);
        this.f = r7;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L17;
        r8.observeForever("data_interact_anchor_param_change", r7);
    L17:
        f r9 = this.c;
        if (r9 == null) goto L30;
        if (r9.isEngineOn() == true) goto L30;
        i r11 = this.b;
        if (r11 == null) goto L30;
        LiveData r12 = ey.a.a();
        if (r12 == null) goto L28;
        ey.f r13 = (ey.f) r12.getValue();
        if (r13 == null) goto L28;
        long r14 = r13.a;
    L29:
        r11.c(new fy.f(r14, getScene(), 0, 24));
    L28:
        r14 = 0;
        goto L29
    L10:
        r3 = null;
    L30:
        e r15 = wq();
        if (r15 == null) goto L34;
        r15.attach();
        return;
    }

    @Override // com.bytedance.android.live.anchorlink.BaseRevLinkWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public void onDestroy() {
        super.onDestroy();
        f r0 = this.c;
        if (r0 == null) goto L5;
        r0.e(this);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L9;
        r1.removeObserver(this.f);
    L9:
        if (this.d == false) goto L16;
        b r2 = this.g;
        if (r2 == null) goto L17;
        int r3 = getScene();
        Intrinsics.checkNotNullParameter(this, "listener");
        com.bytedance.android.live.revenuelink.connect.i r4 = (com.bytedance.android.live.revenuelink.connect.i) ((HashMap) r2.c).remove(this);
        if (r4 == null) goto L18;
        r2.d.removeLinkInListener(r3, r4);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget
    public void onResume() {
        super.onResume();
        if (this.d == false) goto L13;
        f r0 = this.c;
        if (r0 != null) goto L7;
    L9:
        e r1 = wq();
        if (r1 == null) goto L14;
        r1.r0();
        return;
    L14:
        return;
    L7:
        if (r0.isEngineOn() == false) goto L9;
        r0.onResume();
        goto L9
    }

    public void yq(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reqSrc");
        zq("rtcEndSuccess", new dy.a.b(r2));
    }

    @Override // ey.h
    public void Pi(fy.h r2, Response<LinkLeaveResult> r3) {
        Intrinsics.checkNotNullParameter(r2, "leaveParams");
        if (this.d == false) goto L14;
        f r4 = this.c;
        if (r4 != null) goto L7;
    L12:
        yq(r2.c);
        return;
    L7:
        if (r4.isEngineOn() != true) goto L12;
        f r5 = this.c;
        if (r5 == null) goto L11;
        r5.j("leaveSuccess");
    L11:
        yq(r2.c);
        return;
    }

    @Override // gy.d
    public final void R(long r1, Exception r3) {
        xq(this, "rtc_start_error", false, 6);
    }

    @Override // gy.d
    public final void f0(long r1, Exception r3) {
        xq(this, "rtc_error", false, 6);
    }

    @Override // ey.h
    public void h3(fy.f r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r1, "joinChannelParams");
        zq("onJoinFailed", dy.a.C0225a.b);
    }

    @Override // ey.h
    public void pl(fy.f r2, Response<AnchorJoinChannelResult> r3) {
        Intrinsics.checkNotNullParameter(r2, "joinChannelParams");
        Intrinsics.checkNotNullParameter(r3, "response");
        ((Widget) this).dataCenter.put("cmd_interact_state_change", new a1(7));
        f r4 = this.c;
        if (r4 == null) goto L6;
        r4.m(this);
        return;
    }

    public static void xq(BaseEqualLinkWidget r9, String r11, boolean r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r13 & 4) == 0) goto L9;
        String r14 = "0";
    L10:
        String r6 = r14;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r11, "reqSrc");
        Intrinsics.checkNotNullParameter(r6, "isManager");
        r9.e = true;
        ey.g.a.getClass();
        b r15 = ey.g.a.a();
        if (r15 == null) goto L17;
        LiveData<ey.f> r16 = r15.c();
        if (r16 == null) goto L17;
        ey.f r17 = (ey.f) r16.getValue();
        if (r17 == null) goto L17;
        long r18 = r17.a;
    L18:
        long r1 = r18;
        i r19 = r9.b;
        if (r19 == null) goto L22;
        r19.a(new fy.h(r1, r9.getScene(), r11, r5, r6, ey.b.a(r11), 192));
        return;
    L22:
        return;
    L17:
        r18 = 0;
        goto L18
    L9:
        r14 = null;
        goto L10
    L5:
        r5 = r12;
        goto L7
    }
}
