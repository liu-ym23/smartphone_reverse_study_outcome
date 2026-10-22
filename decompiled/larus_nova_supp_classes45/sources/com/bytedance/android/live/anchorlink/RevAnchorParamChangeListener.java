package com.bytedance.android.live.anchorlink;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gy.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/anchorlink/RevAnchorParamChangeListener;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "liveanchorlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevAnchorParamChangeListener implements Observer<KVData> {
    public final f a;

    public RevAnchorParamChangeListener(f r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L5;
        String r0 = r4.getKey();
    L7:
        if (Intrinsics.areEqual(r0, "data_interact_anchor_param_change") == false) goto L15;
        if (r4 == null) goto L16;
        String r5 = (String) r4.getData();
        if (r5 == null) goto L17;
        f r1 = this.a;
        if (r1 == null) goto L18;
        r1.J(r5);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r0 = null;
        goto L7
    }
}
