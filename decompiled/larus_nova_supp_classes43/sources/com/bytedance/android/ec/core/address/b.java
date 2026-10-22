package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.address.api.AddressItemVO;
import com.bytedance.android.ec.core.address.api.RecommendAddressConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public AddressItemVO a;
    public long b;
    public volatile JSONObject c;

    public final void a() {
        this.a = null;
        this.c = null;
    }

    public b() {
        this.b = z.j() + ((long) 1800);
        this.c = null;
    }

    public final void update(AddressItemVO r10) {
        if (r10 == null) goto L4;
        JSONObject r0 = r10.getAddressVO();
    L5:
        this.c = r0;
        if (r10 == null) goto L10;
        RecommendAddressConfig r1 = r10.getConfig();
        if (r1 == null) goto L10;
        this.b = r1.getInvalidTime();
    L10:
        this.a = r10;
        return;
    L4:
        r0 = null;
        goto L5
    }

    public final void update(b r10) {
        Intrinsics.checkNotNullParameter(r10, "item");
        this.c = r10.c;
        this.b = r10.b;
        this.a = r10.a;
    }
}
