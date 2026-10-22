package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.text.TextUtils;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveScreenOrientation;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveScreenOrientation extends DynamicFactor<Integer> implements Observer<KVData> {
    public int b;
    public final DataCenter c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_screen_orientation";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        int r0 = !((Boolean) this.c.get("data_is_portrait", Boolean.TRUE)).booleanValue() ? 1 : 0;
        this.b = r0;
        return Integer.valueOf(r0);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.c.observe("data_is_portrait", this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        this.c.removeObserver("data_is_portrait", this);
    }

    public LiveScreenOrientation(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r2;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4.getKey()) == false) goto L8;
        return;
    L8:
        if (TextUtils.equals(r4.getKey(), "data_is_portrait") == false) goto L14;
        Boolean r0 = Boolean.TRUE;
        int r5 = !Intrinsics.areEqual((Boolean) r4.getData(r0), r0) ? 1 : 0;
        if (r5 == this.b) goto L15;
        this.b = r5;
        update(Integer.valueOf(r5));
        return;
    L15:
        return;
    }
}
