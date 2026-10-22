package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ RevSeiFrame a;

    public d(RevSeiFrame r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((String) r2, "it");
        String r0 = this.a.C;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return new JSONObject(r0);
    }
}
