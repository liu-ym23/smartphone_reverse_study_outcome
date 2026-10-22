package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickDefaultView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickFanClubView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopEmptyState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RenewFansClub;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIEmptyTopViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopEmptyState, GiftAction> implements l<GiftTopEmptyState, GiftAction> {
    public final CompositeDisposable u;
    public final DataCenter v;
    public final OpenDialogService w;
    public final u1 x;
    public final GiftInRoomService y;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.u.clear();
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopEmptyState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIEmptyTopViewModel$bindToParent$1 r0 = GiftMVIEmptyTopViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void y0(l0 r5, MVIState r6, p r7) {
        GiftAction r8 = (GiftAction) r7;
        Intrinsics.checkNotNullParameter(r5, "$this$reduce");
        Intrinsics.checkNotNullParameter((GiftTopEmptyState) r6, "state");
        Intrinsics.checkNotNullParameter(r8, "action");
        if ((r8 instanceof ClickDefaultView) == false) goto L5;
        this.y.a(1001);
        return;
    L5:
        int r0 = 0;
        String r2 = "0";
        if ((r8 instanceof ClickFanClubView) == false) goto L24;
        u1 r9 = this.x;
        IBaseUser r10 = (IBaseUser) this.v.get("data_user_in_room", null);
        if (r10 == null) goto L11;
        String r11 = r10.getIdString();
        if (r11 == null) goto L11;
    L12:
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L19;
        m<Boolean> r3 = r1.isVS();
        if (r3 == null) goto L19;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L19;
        r2 = "1";
    L19:
        o r4 = yt0.c.c();
        if (r4 == null) goto L22;
        r0 = r4.R2();
    L22:
        r9.X(r11, r2, r0);
        OpenDialogService.d(this.w, 0, null, 3);
        return;
    L11:
        r11 = "0";
        goto L12
    L24:
        if ((r8 instanceof RenewFansClub) == false) goto L38;
        u1 r13 = this.x;
        IBaseUser r14 = (IBaseUser) this.v.get("data_user_in_room", null);
        if (r14 == null) goto L31;
        String r15 = r14.getIdString();
        if (r15 == null) goto L31;
        r2 = r15;
    L31:
        o r16 = yt0.c.c();
        if (r16 == null) goto L34;
        r0 = r16.R2();
    L34:
        r13.Y(r2, r0);
        return;
    }

    public GiftMVIEmptyTopViewModel(DataCenter r2, OpenDialogService r3, u1 r4, GiftInRoomService r5) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "openDialogService");
        Intrinsics.checkNotNullParameter(r4, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r5, "giftInRoomService");
        this.v = r2;
        this.w = r3;
        this.x = r4;
        this.y = r5;
        this.u = new CompositeDisposable();
    }
}
