package jf;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
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
public interface d {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        public static boolean a(String r1, ECUIPromotion r10) {
            Intrinsics.checkNotNullParameter(r1, "clickArea");
            Intrinsics.checkNotNullParameter(r10, "promotion");
            if (Intrinsics.areEqual(r1, com.bytedance.android.ec.core.event.a.VALUE_CLICK_AREA_BUTTON) == true) goto L5;
        L11:
            boolean r11 = false;
        L13:
            return !r11;
        L5:
            if (r10.isOnSale() == true) goto L11;
            if (r10.shouldCheckIfNotOnSale() == true) goto L11;
            if (r10.shouldShowFindSimilar() == true) goto L11;
            r11 = true;
            goto L13
        }
    }

    public static final class b {
        public static /* synthetic */ void e(d r10, Context r11, String r12, com.bytedance.android.btm.api.model.d r13) {
            r10.n(r11, r12, r13, null, null, null);
        }

        public static /* synthetic */ void d(d r10, Context r11, g r12, com.bytedance.android.btm.api.model.d r13, LiveActionTracker r14) {
            r10.e(r11, r12, r13, r14, 0);
        }

        public static /* synthetic */ void c(d r10, Context r11, g r12, String r13, boolean r14, com.bytedance.android.btm.api.model.d r15, il2.a r16) {
            r10.r(r11, r12, r13, r14, r15, r16, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(d r11, Context r12, String r13, g r14, com.bytedance.android.btm.api.model.d r15, il2.a r16, View r17, Function0 r18, int r19) {
            if ((r19 & 32) == 0) goto L5;
            View r10 = null;
        L7:
            if ((r19 & 64) == 0) goto L9;
            Function0 r20 = null;
        L10:
            r11.h(r12, r13, r14, r15, r16, r10, r20, null);
            return;
        L9:
            r20 = r18;
            goto L10
        L5:
            r10 = r17;
            goto L7
        }

        public static /* synthetic */ void f(d r10, g r11, String r12, boolean r13, String r14, BtmItemBuilder r15, View r16, boolean r17, int r18) {
            if ((r18 & 4) == 0) goto L5;
            boolean r19 = true;
        L7:
            if ((r18 & 16) == 0) goto L9;
            BtmItemBuilder r20 = null;
        L11:
            if ((r18 & 64) == 0) goto L13;
            boolean r21 = false;
        L14:
            r10.g(r11, r12, r19, r14, r20, r16, r21);
            return;
        L13:
            r21 = r17;
            goto L14
        L9:
            r20 = r15;
            goto L11
        L5:
            r19 = r13;
            goto L7
        }

        public static /* synthetic */ void b(d r15, Context r16, String r17, Integer r18, g r19, j0 r20, int r21, int r22, cf.a r23, com.bytedance.android.btm.api.model.d r24, il2.a r25, int r26) {
            if ((r26 & 32) == 0) goto L5;
            int r10 = 0;
        L7:
            if ((r26 & 64) == 0) goto L9;
            int r11 = 0;
        L11:
            if ((r26 & 128) == 0) goto L13;
            cf.a r12 = null;
        L15:
            if ((r26 & 256) == 0) goto L17;
            int r13 = -1;
        L18:
            r15.l(r16, r17, r18, r19, r20, r10, r11, r12, r13, r24, r25);
            return;
        L17:
            r13 = 0;
            goto L18
        L13:
            r12 = r23;
            goto L15
        L9:
            r11 = r22;
            goto L11
        L5:
            r10 = r21;
            goto L7
        }
    }

    static {
        a = a.a;
    }

    void a(Context r1, g r10, j0 r11, String r12, Integer r13, int r14, int r15, cf.a r16, int r17, com.bytedance.android.btm.api.model.d r18, il2.a r19);

    void b(Context r1, g r10);

    void c(Context r1, String r10, com.bytedance.android.btm.api.model.d r11, boolean r12);

    void d(Context r1, LiveRoomParams r10, String r11, com.bytedance.android.btm.api.model.d r12, boolean r13, String r14);

    void e(Context r1, g r10, com.bytedance.android.btm.api.model.d r11, LiveActionTracker r12, int r13);

    void f(Context r1, g r10, Function1<? super Long, Unit> r11);

    void g(g r1, String r10, boolean r11, String r12, BtmItemBuilder r13, View r14, boolean r15);

    void h(Context r1, String r10, g r11, com.bytedance.android.btm.api.model.d r12, il2.a r13, View r14, Function0<Unit> r15, Pair<Integer, Integer> r16);

    void i(Context r1, g r10, com.bytedance.android.btm.api.model.d r11, il2.a r12);

    void j(Context r1, g r10, com.bytedance.android.btm.api.model.d r11, ListItemButtonModule.addCartListener.1 r12, View r13, Pair r14);

    void k(Context r1, String r10, g r11, com.bytedance.android.btm.api.model.d r12, LiveActionTracker r13);

    void l(Context r1, String r10, Integer r11, g r12, j0 r13, int r14, int r15, cf.a r16, int r17, com.bytedance.android.btm.api.model.d r18, il2.a r19);

    void m(Context r1, String r10, g r11, com.bytedance.android.btm.api.model.d r12, LiveActionTracker r13);

    void n(Context r1, String r10, com.bytedance.android.btm.api.model.d r11, g r12, String r13, il2.a r14);

    void o(Context r1, String r10, LiveRoomParams r11, com.bytedance.android.btm.api.model.d r12);

    void p(Context r1, String r10, com.bytedance.android.btm.api.model.d r11, String r12, boolean r13);

    void q(Context r1, g r10, com.bytedance.android.btm.api.model.d r11, ListItemButtonModule.addCartListener.1 r12, View r13, StepperActionType r14, int r15);

    void r(Context r1, g r10, String r11, boolean r12, com.bytedance.android.btm.api.model.d r13, il2.a r14, int r15);
}
