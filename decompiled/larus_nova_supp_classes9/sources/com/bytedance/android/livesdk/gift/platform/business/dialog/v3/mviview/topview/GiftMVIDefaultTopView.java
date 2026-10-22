package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickDefaultView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopEmptyState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIDefaultTopView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopEmptyState, GiftAction> {
    public TextView m;
    public final DataCenter n;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ GiftMVIDefaultTopView a;

        public a(GiftMVIDefaultTopView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.o(new ClickDefaultView());
        }
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567534;
    }

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final void q() {
        TextView r0 = (TextView) r().findViewById(2131368765);
        this.m = r0;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new a(this));
    L5:
        boolean r1 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin();
        com.bytedance.android.livesdk.gift.platform.business.config.m r2 = (com.bytedance.android.livesdk.gift.platform.business.config.m) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.m.class);
        Room r4 = null;
        Room r3 = (IRoom) this.n.get("data_room", null);
        if ((r3 instanceof Room) == false) goto L10;
        r4 = r3;
    L10:
        if (r2.j(r1) == false) goto L15;
        TextView r5 = this.m;
        if (r5 == null) goto L16;
        r5.setText(((Number) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_DIALOG_DEFAULT_TOP_TEXT, 2131917181)).intValue());
        return;
    L16:
        return;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIDefaultTopView$bindToParent$1 r0 = GiftMVIDefaultTopView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void b(com.bytedance.android.anya.k r2, MVIState r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$handleDiff");
        Intrinsics.checkNotNullParameter((GiftTopEmptyState) r3, "state");
    }

    public GiftMVIDefaultTopView(Context r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        super(r2, r3);
        this.n = r4;
    }
}
