package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ RevLinkDynamicDataContext$transformAIAnchorList$$inlined$also$lambda$1 a;

    public x(RevLinkDynamicDataContext$transformAIAnchorList$$inlined$also$lambda$1 r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        MediatorLiveData r0 = this.a.a;
        r0.postValue((JSONArray) r2);
    }
}
