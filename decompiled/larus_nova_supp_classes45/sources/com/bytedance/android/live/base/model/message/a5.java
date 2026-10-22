package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface a5 extends vh7.c<a5> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    b5 getDefaultFormat();

    String getDefaultPattern();

    String getKey();

    List<c5> getPieces();

    Map<String, m6> getSchemaInfos();

    void setDefaultFormat(b5 r1);

    void setDefaultPattern(String r1);

    /* synthetic */ void setKey(String r1);

    void setPieces(List<? extends c5> r1);
}
