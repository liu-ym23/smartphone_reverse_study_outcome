package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface n1 extends vh7.c<n1> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "effect_types")
    List<Long> getEffectTypes();
}
