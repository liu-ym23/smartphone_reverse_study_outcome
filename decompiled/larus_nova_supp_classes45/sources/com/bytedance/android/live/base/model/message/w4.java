package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface w4 extends vh7.c<w4> {
    @FieldName(name = "accompaniment_volume")
    int accompaniment_volume();

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "chorus_singers_volume")
    int chorus_singers_volume();

    @FieldName(name = "singer_volume")
    int singer_volume();
}
