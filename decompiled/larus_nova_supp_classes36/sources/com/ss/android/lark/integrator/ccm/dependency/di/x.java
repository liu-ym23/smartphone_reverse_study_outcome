package com.ss.android.lark.integrator.ccm.dependency.di;

import android.app.assist.AssistContent;
import com.ss.android.lark.intent.export.entity.donate.ScreenDonateEntity;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class x implements com.bytedance.ee.bear.lark.dependency.p {
    public x() {
    }

    public final void a(AssistContent r2, List<? extends ScreenDonateEntity> r3) {
        Intrinsics.checkNotNullParameter(r2, "assistContent");
        Intrinsics.checkNotNullParameter(r3, LocationHitPoint$ResultType.LIST);
        ((com.bytedance.ee.bear.lark.dependency.g) LarkContext.spiByDwarf(com.bytedance.ee.bear.lark.dependency.g.class)).V0();
    }
}
