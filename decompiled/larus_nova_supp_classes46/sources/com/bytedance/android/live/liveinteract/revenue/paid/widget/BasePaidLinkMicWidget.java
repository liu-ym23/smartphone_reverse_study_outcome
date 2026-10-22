package com.bytedance.android.live.liveinteract.revenue.paid.widget;

import cj0.k;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicViewModel;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import je0.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import xh0.f;
import xh0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/paid/widget/BasePaidLinkMicWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class BasePaidLinkMicWidget extends AbsPlayModeWidget {
    public static final /* synthetic */ int g = 0;
    public IRoom a;
    public PaidLinkMicViewModel b;
    public final CompositeDisposable c;
    public boolean d;
    public Integer e;
    public int f;

    public static final class a {
    }

    static {
    }

    @Override // xh0.b
    public final ArrayList<f> getIncompatibleSourceList() {
        IncompatibleTag r3 = IncompatibleTag.PLAY_MODE;
        return CollectionsKt.arrayListOf(new f[]{new f(r3, 5), new f(r3, 7, ""), new f(r3, 16, ""), new f(r3, 17, ""), new f(r3, 6, ""), new f(r3, 29, ""), new f(IncompatibleTag.SCENE, 9, s1.B(2131919598))});
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r1) {
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r1) {
    }

    @Override // xh0.b
    public final h getPlayModeInfo() {
        return new h(11, s1.B(2131921167));
    }

    @Override // xh0.b
    public final boolean isOpen() {
        PaidLinkMicViewModel r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        return r0.isPaidLinkOn();
    }

    public BasePaidLinkMicWidget() {
        this.c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onCreate() {
        super.onCreate();
        this.a = (IRoom) ((Widget) this).dataCenter.get("data_room", vh7.f.c(IRoom.class));
        Boolean r0 = (Boolean) ((Widget) this).dataCenter.get("data_is_anchor");
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.booleanValue();
    L6:
        this.d = r2;
        this.e = d.h();
        this.f = d.f();
        Pair r3 = com.bytedance.live.datacontext.d.a(BasePaidLinkMicWidget$onCreate$pair$1.INSTANCE);
        this.b = new PaidLinkMicViewModel(((Widget) this).dataCenter);
        j<cj0.c> r4 = ((PaidLinkMicContext) r3.getFirst()).m308getWidget();
        PaidLinkMicViewModel r5 = this.b;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        r4.d(r5);
        com.bytedance.live.datacontext.b.a((DataContext) r3.getFirst(), cj0.a.class);
        this.c.add((Disposable) r3.getSecond());
        DataCenter r6 = ((Widget) this).dataCenter;
        Boolean r7 = Boolean.TRUE;
        r6.put("cmd_paid_linkmic_widget_ready", r7);
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == false) goto L54;
        IRoom r8 = this.a;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L14:
        z5 r9 = r8.getLinkerDetail();
        if (r9 == null) goto L42;
        List r10 = r9.getPlayModes();
        if (r10 == null) goto L42;
        if (r10.contains(Long.valueOf(11)) != true) goto L42;
        j r11 = m.e(this).J();
        if (r11 == null) goto L26;
        LivePlayModeLogContext r12 = (LivePlayModeLogContext) r11.getValue();
        if (r12 == null) goto L26;
        r12.addPlayMode(11);
    L26:
        if (this.d == true) goto L34;
        PaidLinkMicViewModel r13 = this.b;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        IRoom r14 = this.a;
        if (r14 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L33:
        r13.fetchUserPaidBenefitInfo(r14.getId());
    L34:
        PaidLinkMicViewModel r15 = this.b;
        if (r15 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        IRoom r16 = this.a;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L40:
        r15.fetchNormalPaidInfo(r16.getId());
    L42:
        if (this.d == false) goto L44;
    L50:
        if (r1 == false) goto L54;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L54;
        r17.put("data_paid_link_profile_show", r7);
        goto L54
    L44:
        if (vm2.d.o0() == false) goto L50;
        cj0.c r18 = PaidLinkMicContext.Companion.a();
        if (r18 == null) goto L50;
        if (r18.isPaidLinkOn() != true) goto L50;
        r1 = true;
    L54:
        PaidLinkMicViewModel r19 = this.b;
        if (r19 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L57:
        r19.getPaidLinkMicPlayModeGuideState().observe(this, new com.bytedance.android.live.liveinteract.revenue.paid.widget.a(this));
        PaidLinkMicViewModel r20 = this.b;
        if (r20 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L60:
        r20.getPaidLinkMicAddPriceState().observe(this, new b(this));
        PaidLinkMicViewModel r21 = this.b;
        if (r21 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        r21.getPaidLinkMicState().observe(this, new c(this));
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public void onDestroy() {
        super.onDestroy();
        cj0.c r0 = PaidLinkMicContext.Companion.a();
        if (r0 != null) goto L5;
    L10:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L14;
        r1.put("data_paid_link_profile_show", Boolean.FALSE);
    L14:
        if (this.c.isDisposed() == true) goto L17;
        this.c.clear();
        return;
    L17:
        return;
    L5:
        if (r0.isPaidLinkOn() != true) goto L10;
        fj0.b r2 = fj0.b.b;
        if (this.d == false) goto L9;
        fj0.b.d(r2);
        goto L10
    L9:
        fj0.b.g(r2);
        goto L10
    }

    public void wq(k r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (r3.a == false) goto L14;
        if (this.d == false) goto L7;
        return;
    L7:
        if (vm2.d.o0() == true) goto L9;
        return;
    L9:
        if (r3.d == false) goto L23;
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L24;
        r4.put("data_paid_link_profile_show", Boolean.TRUE);
        return;
    L24:
        return;
    L23:
        return;
    L14:
        if (this.d == false) goto L16;
        return;
    L16:
        if (vm2.d.o0() == false) goto L27;
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L28;
        r5.put("data_paid_link_profile_show", Boolean.FALSE);
        return;
    L28:
        return;
    }

    public final void xq(int r5, int r6) {
        cj0.c r0 = PaidLinkMicContext.Companion.a();
        if (r0 != null) goto L5;
    L15:
        this.e = Integer.valueOf(r6);
        this.f = r5;
        return;
    L5:
        if (r0.isPaidLinkOn() != true) goto L15;
        Integer r1 = this.e;
        if (r1 == null) goto L12;
        if (r1.intValue() == r6) goto L15;
    L12:
        if (this.d == false) goto L14;
        fj0.b r2 = fj0.b.b;
        fj0.b.c(this.f, this.e);
        fj0.b.h(r2, "function_switch", null, 6);
        goto L15
    L14:
        fj0.a r3 = fj0.b.a;
        fj0.b.f(this.f, this.e);
        fj0.b.e(null);
        goto L15
    }
}
