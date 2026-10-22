package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.text.TextUtils;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveHasFirstFrame;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveHasFirstFrame extends DynamicFactor<Integer> implements Observer<KVData> {
    public int b;
    public final DataCenter c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_has_first_frame";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        int r0 = !((Boolean) this.c.get("interaction_on_first_frame", Boolean.TRUE)).booleanValue() ? 1 : 0;
        this.b = r0;
        return Integer.valueOf(r0);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.c.observe("interaction_on_first_frame", this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        this.c.removeObserver("interaction_on_first_frame", this);
    }

    public LiveHasFirstFrame(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r2;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5.getKey()) == true) goto L25;
        String r0 = r5.getKey();
        if (r0.hashCode() == 1922181771) goto L11;
        return;
    L11:
        if (r0.equals("interaction_on_first_frame") == false) goto L23;
        Integer r6 = Integer.valueOf(Intrinsics.areEqual((Boolean) r5.getData(), Boolean.TRUE) ? 1 : 0);
        if (r6.intValue() == this.b) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == true) goto L19;
        r6 = null;
    L19:
        if (r6 == null) goto L24;
        int r7 = r6.intValue();
        this.b = r7;
        update(Integer.valueOf(r7));
        return;
    L24:
        return;
    L15:
        r1 = false;
        goto L16
    L23:
        return;
    }
}
