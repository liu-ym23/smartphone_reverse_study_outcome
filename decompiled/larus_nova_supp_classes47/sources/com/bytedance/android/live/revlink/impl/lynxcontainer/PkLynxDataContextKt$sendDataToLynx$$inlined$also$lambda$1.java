package com.bytedance.android.live.revlink.impl.lynxcontainer;

import androidx.lifecycle.MediatorLiveData;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/lynxcontainer/PkLynxDataContextKt$sendDataToLynx$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkLynxDataContextKt$sendDataToLynx$$inlined$also$lambda$1 implements Observer<Object> {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ String b;

    public final void onChanged(Object r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        JSONObject r0 = new JSONObject();
        r0.put("type", this.b);
        if ((r4 instanceof String) == false) goto L7;
        r0.put(Constants.Keys.DATA, r4);
    L8:
        this.a.setValue(new Pair(this.b, r0));
        return;
    L7:
        r0.put(Constants.Keys.DATA, GsonProtectorUtils.toJson(l97.a.a, r4));
        goto L8
    }

    public PkLynxDataContextKt$sendDataToLynx$$inlined$also$lambda$1(MediatorLiveData r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
