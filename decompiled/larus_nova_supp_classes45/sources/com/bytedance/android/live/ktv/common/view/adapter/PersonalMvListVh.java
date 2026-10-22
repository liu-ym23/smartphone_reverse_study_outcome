package com.bytedance.android.live.ktv.common.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/PersonalMvListVh;", "Lcom/bytedance/android/live/ktv/common/view/adapter/SoloMvListVh;", "a", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PersonalMvListVh extends SoloMvListVh {
    public static final int j = 0;
    public static final int k = 0;

    public static final class a {
    }

    static {
        j = s1.f(82.0f);
        k = s1.f(110.0f);
    }

    public PersonalMvListVh(View r3, b r4) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "adapterClickCb");
        super(r3, r4);
        ((ViewGroup) r3).addView(this.d, new ViewGroup.LayoutParams(-1, -1));
    }
}
