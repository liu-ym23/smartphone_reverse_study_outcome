package com.bytedance.android.live.revenue.platform.log.impl.filterimpl;

import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.y;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import mz0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class a implements e<Object> {
    public final o<Object> a;

    @Override // mz0.e
    public final Map<String, String> getMap() {
        return this.a.getMap();
    }

    public final void n() {
        Intrinsics.checkNotNullParameter("lottery_id", "key");
        this.a.remove("lottery_id");
    }

    public a(o<Object> r2) {
        Intrinsics.checkNotNullParameter(r2, FileUtils.FILTER);
        this.a = r2;
    }

    @Override // mz0.e
    public final void c(y r2) {
        Intrinsics.checkNotNullParameter(r2, Constants.Keys.DATA);
        this.a.setData(r2);
    }

    public final void h(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.a.a(r2);
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.c(r2, r3);
    }
}
