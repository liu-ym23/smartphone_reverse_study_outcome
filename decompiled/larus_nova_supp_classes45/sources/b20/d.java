package b20;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.revenue.core.util.h;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends e {
    @Override // b20.e
    public final boolean a(long r3, Map<String, ? extends Object> r5) {
        if (r3 != 6) goto L5;
        return true;
    L5:
        return false;
    }

    public d() {
    }

    @Override // b20.e
    public final boolean b(List r6, ViewPager r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "data");
        List<String> r9 = LiveEffectContext.h;
        boolean r11 = !LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(d0.d).isEmpty();
        boolean r1 = h.a;
        fa0.c r2 = (fa0.c) h.e(fa0.c.class);
        if (r2 == null) goto L14;
        fa0.a r3 = r2.o0();
        if (r3 == null) goto L14;
        if (r3.a == false) goto L14;
        Integer r4 = r3.getType();
        if (r4 == null) goto L14;
        if (r4.intValue() != 7) goto L14;
        boolean r5 = true;
    L15:
        IBroadcastService r12 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r12 == null) goto L22;
        List<String> r13 = r12.getRunningInteractPluginIds();
        if (r13 == null) goto L22;
        if ((!r13.isEmpty()) == false) goto L22;
        r5 = true;
    L22:
        if (r11 == true) goto L26;
        if (r5 == true) goto L26;
        return false;
    L26:
        if (r7 != null) goto L28;
    L30:
        if (r7 == null) goto L32;
        r7.post(new c(r7, r8));
    L32:
        return true;
    L28:
        if (r7.getCurrentItem() != r8) goto L30;
        return true;
    L14:
        r5 = false;
        goto L15
    }
}
