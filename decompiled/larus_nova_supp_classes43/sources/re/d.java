package re;

import com.bytedance.android.ec.adapter.impl.converter.j;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.coupon.ShortTouchLynxCoupon;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.ShoppingCart;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.constraint.StartLivePreviewButton;
import kotlin.jvm.internal.Intrinsics;
import wd.f;
import xd.g;
import xd.i;
import xd.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements td.d {
    public final ILiveRoomViewHandler a;

    @Override // td.d
    public final f F() {
        g r0 = g.a;
        Intrinsics.checkNotNullParameter(r0, "id");
        ILiveRoomViewHandler r1 = this.a;
        Intrinsics.checkNotNullParameter(r0, "$this$live");
        IExternalViewGroup r10 = r1.findViewGroupById(StartLivePreviewButton.INSTANCE);
        Intrinsics.checkNotNullParameter(r10, "$this$convert2EC");
        return j.b.a(r10);
    }

    public d(ILiveRoomViewHandler r10) {
        Intrinsics.checkNotNullParameter(r10, "realHandler");
        this.a = r10;
    }

    @Override // td.d
    public final void C(ShoppingCart r10) {
        i r0 = i.a;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_CLICK_AREA_BUTTON);
        Intrinsics.checkNotNullParameter(r0, "constraint");
        this.a.removeToolbarButton(com.bytedance.android.ec.adapter.impl.converter.b.a(r10), com.bytedance.android.ec.adapter.impl.utils.c.a(r0));
    }

    @Override // td.d
    public final void D(EntryController.k r10) {
        Intrinsics.checkNotNullParameter(r10, "loadFilter");
        ILiveRoomViewHandler r0 = this.a;
        NewToolbarButtonConstants.CommerceCart r1 = NewToolbarButtonConstants.CommerceCart.INSTANCE;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2Live");
        r0.registerToolbarLoadFilter(r1, com.bytedance.android.ec.adapter.impl.converter.c.j.b.a(r10));
    }

    @Override // td.d
    public final void E(ShoppingCart r10) {
        i r0 = i.a;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_CLICK_AREA_BUTTON);
        Intrinsics.checkNotNullParameter(r0, "constraint");
        this.a.provideToolbarButton(com.bytedance.android.ec.adapter.impl.converter.b.a(r10), com.bytedance.android.ec.adapter.impl.utils.c.a(r0));
    }

    @Override // td.d
    public final void G(EntryController.j r10) {
        Intrinsics.checkNotNullParameter(r10, "viewProvider");
        this.a.registerToolbarButtonView(com.bytedance.android.ec.adapter.impl.converter.b.a(r10));
    }

    @Override // td.d
    public final void H(ShortTouchLynxCoupon r10) {
        Intrinsics.checkNotNullParameter(r10, "iconModel");
        ILiveRoomViewHandler r0 = this.a;
        Intrinsics.checkNotNullParameter(r10, "$this$convert2Live");
        r0.loadIconModel(new com.bytedance.android.ec.adapter.impl.converter.c.e().a(r10));
    }

    @Override // td.d
    public final void a(wd.g r10) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        this.a.requestShow(com.bytedance.android.ec.adapter.impl.converter.b.b(r10));
        ECLiveEntranceMonitor.trace$default("requestShow: ".concat(r10.getClass().getName()), "LiveRoomViewHandlerAdapter", false, 4, null);
    }

    @Override // td.d
    public final void c(wd.g r10) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        this.a.requestDismiss(com.bytedance.android.ec.adapter.impl.converter.b.b(r10));
    }

    @Override // td.d
    public final void b(wd.g r10, k r11) {
        Intrinsics.checkNotNullParameter(r10, "widget");
        Intrinsics.checkNotNullParameter(r11, "constraint");
        this.a.provideWidget(com.bytedance.android.ec.adapter.impl.converter.b.b(r10), com.bytedance.android.ec.adapter.impl.utils.c.a(r11));
        ECLiveEntranceMonitor.trace$default("provideWidget: ".concat(r10.getClass().getName()), "LiveRoomViewHandlerAdapter", false, 4, null);
    }
}
