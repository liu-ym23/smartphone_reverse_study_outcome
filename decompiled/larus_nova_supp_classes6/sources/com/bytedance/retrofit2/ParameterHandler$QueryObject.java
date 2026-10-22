package com.bytedance.retrofit2;

import com.bytedance.retrofit2.http.ext.QueryParamObject;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class ParameterHandler$QueryObject<T> extends ParameterHandler<T> {
    public ParameterHandler$QueryObject() {
    }

    public void apply(RequestBuilder r3, T r4) throws IOException {
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof QueryParamObject) == false) goto L9;
        r3.setQueryObjectParams(((QueryParamObject) r4).toQuery());
        return;
    L9:
        throw new RuntimeException("wrong type:" + r4.getClass() + ",not implement QueryParamObject");
    }
}
