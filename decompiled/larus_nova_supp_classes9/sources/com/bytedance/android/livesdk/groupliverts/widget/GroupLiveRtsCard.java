package com.bytedance.android.livesdk.groupliverts.widget;

import android.view.View;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.salamander.anniex.q4;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v61.a;
import x61.c;
import x61.f;
import x61.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GroupLiveRtsCard extends a {
    public final q4<Map<String, Object>> m;

    public final h<?, ?> content() {
        h.a r0 = h.a;
        Function1<c.a, View> r1 = new AnonymousClass1(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "inflate");
        return new f(r1);
    }

    public GroupLiveRtsCard(q4 r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "contentView");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "cardType");
        super(r4, BuildConfig.FLAVOR, 1);
        this.m = r3;
    }
}
