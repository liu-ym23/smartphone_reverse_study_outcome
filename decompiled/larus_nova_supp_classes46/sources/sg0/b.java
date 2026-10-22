package sg0;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.view.PaidLinkCountDownView;
import com.bytedance.android.live.liveinteract.view.PositionNameCountDownController;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import com.bytedance.android.live.liveinteract.view.SeatPosTagLabelTextView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import je0.d;
import kotlin.jvm.internal.Intrinsics;
import pg0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends e {
    public PaidLinkCountDownView k;
    public PositionNameCountDownController l;
    public View m;
    public final m n;

    @Override // jg0.c
    public final int o() {
        MicSeatScene r0 = this.b;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return 2131566586;
    L5:
        if (r1 != 2) goto L7;
        return 2131566587;
    L7:
        if (r1 != 3) goto L9;
        return 2131566585;
    L9:
        if (r1 != 4) goto L18;
        return 2131566575;
    L18:
        return 2131566585;
    }

    @Override // jg0.c, jg0.f
    public final void onDetach() {
        PositionNameCountDownController r0 = this.l;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("positionNameCountDownController");
    L5:
        x00.a r1 = null;
        r0.c = null;
        if ((r0.k instanceof AppCompatActivity) == false) goto L16;
        Boolean r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r2 == null) goto L10;
        boolean r3 = r2.booleanValue();
    L11:
        IInteractService r4 = (IInteractService) k.f(IInteractService.class);
        if (r4 == null) goto L14;
        r1 = r4.getThemeManager(r3, r0.l);
    L14:
        if (r1 == null) goto L16;
        r1.f(r0.d, 2);
        goto L16
    L10:
        r3 = false;
    L16:
        r0.a.removeCallbacks(r0.e);
        r0.a.removeCallbacks(r0.f);
        r0.a.removeCallbacks(r0.g);
    }

    @Override // jg0.c
    public final String p() {
        MicSeatScene r0 = this.b;
        int r1 = a.b[r0.ordinal()];
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L14;
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonGuestStatusLayer.name();
    L14:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonGuestStatusLayer.name();
    L15:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonCPositionGuestMicSeatStatusLayer.name();
    L12:
        return VerticalNitaInflate.Tag.MultiLinkAudioCommonLargeGuestMicSeatStatusLayer.name();
    }

    @Override // pg0.e, jg0.c, jg0.f
    public final void a(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super.a(r7);
        this.k = (PaidLinkCountDownView) q().findViewById(2131389700);
        this.m = q().findViewById(2131363497);
        PositionNameTv r1 = this.f;
        Intrinsics.checkNotNull(r1);
        PaidLinkCountDownView r2 = this.k;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("paidLinkCountDownView");
    L5:
        SeatPosTagLabelTextView r3 = this.g;
        Context r4 = q().getContext();
        xg0.a r0 = this.c;
        if (r0 == null) goto L8;
        DataCenter r5 = r0.getDataCenter();
    L9:
        this.l = new PositionNameCountDownController(r1, r2, r3, r4, r5);
        PositionNameTv r8 = this.f;
        if (r8 == null) goto L13;
        r8.F("#80000000");
        return;
    L13:
        return;
    L8:
        r5 = null;
        goto L9
    }

    @Override // jg0.c, jg0.f
    public final void j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // pg0.e, jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        t((MultiLinkGuestViewBinder.a) r1, r2);
    }

    @Override // pg0.e
    public final void t(MultiLinkGuestViewBinder.a r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "itemData");
        super.t(r5, r6);
        PositionNameCountDownController r7 = this.l;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("positionNameCountDownController");
    L5:
        ch0.e r1 = r5.k;
        if (r1 == null) goto L8;
        ILinkPlayerInfoBridge r2 = r1.a;
    L9:
        r7.a(r2, d.r(), r5.d, this.n.getUiLayout());
        PositionNameCountDownController r8 = this.l;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("positionNameCountDownController");
    L12:
        r8.f();
        if (this.n.getUiLayout() != 24) goto L27;
        AppCompatTextView r9 = this.f;
        if (r9 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r9);
    L17:
        AppCompatTextView r10 = this.f;
        if (r10 == null) goto L20;
        Handler r3 = UtilityKotlinExtentionsKt.a;
        Intrinsics.checkNotNullParameter(r10, "$this$setVisibilityInVisibleAlpha");
        r10.setAlpha(0.0f);
    L20:
        AppCompatTextView r11 = this.g;
        if (r11 == null) goto L23;
        UtilityKotlinExtentionsKt.t(r11);
    L23:
        AppCompatTextView r12 = this.g;
        if (r12 == null) goto L28;
        Handler r4 = UtilityKotlinExtentionsKt.a;
        Intrinsics.checkNotNullParameter(r12, "$this$setVisibilityInVisibleAlpha");
        r12.setAlpha(0.0f);
        return;
    L28:
        return;
    L27:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public b(MicSeatScene r2, m r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r2, r4);
        this.n = r3;
    }

    @Override // pg0.e, jg0.f
    public final /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        u((MultiLinkGuestViewBinder.a) r1, r2, r3);
    }

    @Override // pg0.e
    public final void u(MultiLinkGuestViewBinder.a r4, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        Intrinsics.checkNotNullParameter(r6, "payload");
        super.u(r4, r5, r6);
        PositionNameCountDownController r7 = this.l;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("positionNameCountDownController");
    L5:
        ch0.e r8 = r4.k;
        if (r8 == null) goto L8;
        ILinkPlayerInfoBridge r9 = r8.a;
    L9:
        r7.a(r9, d.r(), n(), this.n.getUiLayout());
        PositionNameCountDownController r10 = this.l;
        if (r10 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("positionNameCountDownController");
    L12:
        r10.f();
        return;
    L8:
        r9 = null;
        goto L9
    }
}
