package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ String b;
    public final /* synthetic */ FormatType c;

    public d(MediatorLiveData r1, String r2, FormatType r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r4) {
        JSONObject r0 = new JSONObject();
        r0.put("type", this.b);
        if (this.c != FormatType.NEW) goto L8;
        if (r4 == null) goto L6;
        String r1 = this.b;
        Intrinsics.checkNotNullParameter(r4, "$this$toNewFormatString");
        Intrinsics.checkNotNullParameter(r1, "tag");
        JSONObject r2 = new JSONObject();
        r2.put(r1, r4);
        r4 = r2.toString();
    L13:
        r0.put(Constants.Keys.DATA, r4);
        this.a.setValue(new Pair(this.b, r0));
        return;
    L6:
        r4 = null;
        goto L13
    L8:
        if ((r4 instanceof String) == true) goto L13;
        if ((r4 instanceof JSONObject) == true) goto L13;
        r4 = GsonProtectorUtils.toJson(l97.a.a, r4);
        goto L13
    }
}
