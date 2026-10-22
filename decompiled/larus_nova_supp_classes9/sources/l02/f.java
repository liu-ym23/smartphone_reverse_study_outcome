package l02;

import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements o, h {
    public final List<g> a;

    public final void onStart() {
    }

    public final void onStop() {
        ((ArrayList) this.a).clear();
    }

    public f() {
        this.a = new ArrayList();
    }

    @Override // l02.h
    public final void a(int r13, int r14, boolean r15, String r16, boolean r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r16, "schema");
        k r2 = com.bytedance.android.live.revenue.core.util.f.c(com.bytedance.android.live.revenue.core.util.k.a(), k.class);
        if (r2 == null) goto L9;
        DataCenter r3 = r2.getDataCenter();
        if (r3 == null) goto L9;
        Boolean r4 = (Boolean) r3.get("data_is_portrait", Boolean.TRUE);
        if (r4 == null) goto L9;
        boolean r5 = r4.booleanValue();
    L11:
        if (((ArrayList) this.a).isEmpty() == true) goto L32;
        if (r5 != true) goto L38;
        if (r13 != 1) goto L27;
        Iterator r1 = ((ArrayList) this.a).iterator();
    L17:
        if (r1.hasNext() == false) goto L39;
        g r6 = (g) r1.next();
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == true) goto L21;
    L25:
        float r7 = 128.0f;
    L26:
        r6.b(r14, r15, r7, r16, r17, r18, r19);
        goto L17
    L21:
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L25;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L25;
        r7 = UtilityKotlinExtentionsKt.k(StatusBarUtil.getStatusBarHeight(com.bytedance.live.kmp.util.c.a.getContext())) + 128.0f;
        goto L26
    L39:
        return;
    L27:
        if (r13 != 0) goto L37;
        Iterator r8 = ((ArrayList) this.a).iterator();
    L30:
        if (r8.hasNext() == false) goto L40;
        ((g) r8.next()).a(r14, r18, r19);
        goto L30
    L40:
        return;
    L37:
        return;
    L38:
        return;
    L32:
        return;
    L9:
        r5 = true;
        goto L11
    }
}
