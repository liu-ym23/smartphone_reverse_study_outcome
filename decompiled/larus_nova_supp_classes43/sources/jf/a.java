package jf;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.model.response.StepperActionType;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemButtonModule;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements d {
    public static final a b = null;

    public a() {
    }

    @Override // jf.d
    public final void a(Context r1, g r10, j0 r11, String r12, Integer r13, int r14, int r15, cf.a r16, int r17, com.bytedance.android.btm.api.model.d r18, il2.a r19) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "promotionParams");
        Intrinsics.checkNotNullParameter(r11, "action");
        Intrinsics.checkNotNullParameter("enter_room_api", "clickArea");
    }

    @Override // jf.d
    public final void b(Context r10, g r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter("blank", "clickArea");
        Intrinsics.checkNotNullParameter(r11, "promotionParams");
    }

    @Override // jf.d
    public final void c(Context r1, String r10, com.bytedance.android.btm.api.model.d r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // jf.d
    public final void d(Context r1, LiveRoomParams r10, String r11, com.bytedance.android.btm.api.model.d r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // jf.d
    public final void e(Context r1, g r10, com.bytedance.android.btm.api.model.d r11, LiveActionTracker r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "promotionParams");
    }

    @Override // jf.d
    public final void f(Context r10, g r11, Function1<? super Long, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "promotionParams");
        Intrinsics.checkNotNullParameter(r12, "success");
    }

    @Override // jf.d
    public final void g(g r1, String r10, boolean r11, String r12, BtmItemBuilder r13, View r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r1, "promotionParams");
        Intrinsics.checkNotNullParameter(r10, "clickArea");
    }

    @Override // jf.d
    public final void h(Context r1, String r10, g r11, com.bytedance.android.btm.api.model.d r12, il2.a r13, View r14, Function0<Unit> r15, Pair<Integer, Integer> r16) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "clickArea");
        Intrinsics.checkNotNullParameter(r11, "promotionParams");
    }

    @Override // jf.d
    public final void i(Context r1, g r10, com.bytedance.android.btm.api.model.d r11, il2.a r12) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "promotionParams");
    }

    @Override // jf.d
    public final void j(Context r1, g r10, com.bytedance.android.btm.api.model.d r11, ListItemButtonModule.addCartListener.1 r12, View r13, Pair r14) {
        Intrinsics.checkNotNullParameter(r10, "promotionParams");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_CLICK_AREA_BUTTON, "clickArea");
    }

    @Override // jf.d
    public final void k(Context r1, String r10, g r11, com.bytedance.android.btm.api.model.d r12, LiveActionTracker r13) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "promotionParams");
    }

    @Override // jf.d
    public final void l(Context r1, String r10, Integer r11, g r12, j0 r13, int r14, int r15, cf.a r16, int r17, com.bytedance.android.btm.api.model.d r18, il2.a r19) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "clickArea");
        Intrinsics.checkNotNullParameter(r12, "promotionParams");
        Intrinsics.checkNotNullParameter(r13, "action");
    }

    @Override // jf.d
    public final void m(Context r1, String r10, g r11, com.bytedance.android.btm.api.model.d r12, LiveActionTracker r13) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_CLICK_AREA_BUTTON, "clickArea");
        Intrinsics.checkNotNullParameter(r11, "promotionParams");
    }

    @Override // jf.d
    public final void n(Context r1, String r10, com.bytedance.android.btm.api.model.d r11, g r12, String r13, il2.a r14) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
    }

    @Override // jf.d
    public final void o(Context r1, String r10, LiveRoomParams r11, com.bytedance.android.btm.api.model.d r12) {
        Intrinsics.checkNotNullParameter(r1, "context");
    }

    @Override // jf.d
    public final void p(Context r1, String r10, com.bytedance.android.btm.api.model.d r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "source");
    }

    @Override // jf.d
    public final void q(Context r1, g r10, com.bytedance.android.btm.api.model.d r11, ListItemButtonModule.addCartListener.1 r12, View r13, StepperActionType r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "promotionParams");
        Intrinsics.checkNotNullParameter(r14, "stepperAction");
    }

    @Override // jf.d
    public final void r(Context r1, g r10, String r11, boolean r12, com.bytedance.android.btm.api.model.d r13, il2.a r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "promotionParams");
    }

    static {
        b = new a();
    }
}
