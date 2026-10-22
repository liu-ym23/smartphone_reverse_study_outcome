package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveShortTouchFactor;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveShortTouchFactor extends DynamicFactor<Integer> implements Observer<KVData> {
    public final DataCenter b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public String c() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public void e() {
    }

    public Integer f() {
        return 0;
    }

    public void g(KVData r1) {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public /* bridge */ /* synthetic */ Integer b() {
        return f();
    }

    public LiveShortTouchFactor(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        g((KVData) r1);
    }

    public final void h(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        DataCenter r0 = this.b;
        if (r0 == null) goto L12;
        IRoom r1 = (IRoom) r0.get("data_room");
        if (r1 == null) goto L13;
        List r2 = r1.getStrategyFeatWhitelist();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.contains(r3) != true) goto L15;
        update(Integer.valueOf(r4));
        return;
    L15:
        return;
    L13:
        return;
    }
}
