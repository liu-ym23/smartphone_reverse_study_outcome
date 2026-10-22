package com.bytedance.retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ParameterHandler$2 extends ParameterHandler<Object> {
    final /* synthetic */ ParameterHandler this$0;

    public ParameterHandler$2(ParameterHandler r1) {
        this.this$0 = r1;
    }

    public void apply(RequestBuilder r5, @Nullable Object r6) throws IOException {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = Array.getLength(r6);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        this.this$0.apply(r5, Array.get(r6, r1));
        r1 = r1 + 1;
        goto L5
    }
}
