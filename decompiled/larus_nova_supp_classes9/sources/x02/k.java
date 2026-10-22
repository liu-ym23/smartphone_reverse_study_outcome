package x02;

import com.bytedance.android.livesdk.gift.configmodel.y2;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.r0;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends d0 {
    public k() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final void c(com.bytedance.android.livesdk.gift.platform.core.model.t r10, p2 r11, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r13, Function1<? super y, Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "info");
        Intrinsics.checkNotNullParameter(r13, "listener");
        Intrinsics.checkNotNullParameter(r14, "nextPlugin");
        ReadOnlyProperty r0 = com.bytedance.android.livesdk.gift.platform.core.h.B0;
        KProperty[] r1 = com.bytedance.android.livesdk.gift.platform.core.h.a;
        if (((y2) r0.getValue(null, r1[78])).a() == true) goto L5;
        return;
    L5:
        h1 r3 = GiftManagerKt.j(r10.i().b, null);
        if (r3 != null) goto L8;
    L18:
        super.c(r10, r11, r13, r14);
        return;
    L8:
        if (j0.a(r3) == true) goto L18;
        if ((r3.getReqExtraType() & 8) != 8) goto L18;
        i12.e r4 = i12.o.b();
        if (r4 == null) goto L14;
        Object r5 = com.bytedance.android.scope.m.e.d(r4, r0.class);
    L15:
        r0 r6 = (r0) r5;
        if (r6 == null) goto L18;
        r6.c(CollectionsKt.listOf(Long.valueOf(r10.i().b)), ((y2) r0.getValue(null, r1[78])).b());
        goto L18
    L14:
        r5 = null;
        goto L15
    }
}
