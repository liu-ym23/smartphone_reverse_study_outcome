package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.batch;

import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.o;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.a;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o42.e;
import r42.g;
import tlc.d;
import xs2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PsFirstFetchMsgBatchHelper {
    public DataCenter a;

    public PsFirstFetchMsgBatchHelper() {
    }

    public static void b(final a r6, ka2.a r7) {
        Intrinsics.checkNotNullParameter(r6, "updater");
        Intrinsics.checkNotNullParameter(r7, "updateInfo");
        if (r7.a == true) goto L6;
        r7 = null;
    L6:
        if (r7 == null) goto L9;
        UtilityKotlinExtentionsKt.s(0, false, true, new PsFirstFetchMsgBatchHelper$onConsumeMsg$$inlined$also$lambda$1(r6), 3);
        return;
    }

    public final void a(a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "updater");
        if (o.a(this.a) == true) goto L5;
        return;
    L5:
        if ((r2 instanceof c) == true) goto L7;
        r2 = null;
    L7:
        c r4 = (c) r2;
        if (r4 == null) goto L14;
        if (r3 != 0) goto L11;
        b.a().post(new e());
        r4.f();
        return;
    L11:
        r4.t = r3;
        r4.j();
        return;
    }

    public final void c(List<? extends d> r11, DataCenter r13) {
        Intrinsics.checkNotNullParameter(r11, "messages");
        if (o.a(r13) == true) goto L5;
        return;
    L5:
        this.a = r13;
        List<? extends d> r14 = r11;
        ALogger.d("PsAggregateBatchHelper", CollectionsKt.joinToString$default(r14, "\n", null, null, 0, null, new PsFirstFetchMsgBatchHelper$onReceiveFirstMessage$1(this), 30, null));
        Iterator<T> r15 = r14.iterator();
        int r0 = 0;
    L7:
        if (r15.hasNext() == false) goto L22;
        Object r1 = r15.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        u3 r3 = (d) r1;
        if ((r3 instanceof u3) == false) goto L21;
        u3 r4 = r3;
        if (r4.getOrInitPublicAreaCommon().isFirstAggregateHistoryMessage() == false) goto L19;
        if (g.a(null, null) == false) goto L21;
    L19:
        if (o.a(r13) == false) goto L21;
        r4.getOrInitPublicAreaCommon().setFirstFetchBatchMsg(true);
    L21:
        r0 = r2;
        goto L7
    }
}
