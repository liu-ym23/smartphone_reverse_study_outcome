package rc0;

import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.revlink.api.ILinkService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l {

    public static final class a implements ca0.h {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // ca0.h
        public final void onResult(int r1) {
        }
    }

    public static final class b implements ca0.f {
        public b() {
        }
    }

    public static final void a(boolean r11, boolean r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "scene");
        if (r11 == false) goto L11;
        if (r12 == false) goto L11;
        ca0.b r0 = ((IGiftService) com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class)).getGiftAnimationEngine(GiftType.STICKER_GIFT);
        if (r0 == null) goto L8;
        r0.g();
    L8:
        fr2.p r1 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLiveCore();
        if (r1 == null) goto L11;
        ((IGiftService) com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class)).getGiftRenderFilterWrapper().e(new vc0.a(r1));
    L11:
        b r5 = new b();
        a r6 = a.a;
        ca0.i r2 = ((IGiftService) com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class)).getGiftRenderFilterWrapper();
        if (r2 == null) goto L14;
        r2.l(r12, r5, r6, r11, r13, r14);
    L14:
        if (r12 == true) goto L20;
        if (r2 != null) goto L17;
        return;
    L17:
        if (r2.i(r11) != true) goto L22;
        r2.m(false, r11, r13, r14);
        return;
    L22:
        return;
    }
}
