package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.im.v1.MGetMessagesResponse;
import com.ss.android.lark.parser.internal.ModelParserMessage;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t<T, R> implements Function {
    public final /* synthetic */ List<String> a;

    public t(List<String> r1) {
        this.a = r1;
    }

    public final Object apply(Object r5) {
        com.bytedance.lark.rustclient.api.x r6 = (com.bytedance.lark.rustclient.api.x) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        Map r7 = ModelParserMessage.j((MGetMessagesResponse) r6.c);
        Intrinsics.checkNotNull(r7);
        List<String> r0 = this.a;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r8 = ((HashMap) r7).entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) r8.next();
        if (r0.contains(r2.getKey()) == false) goto L4;
        r1.put(r2.getKey(), r2.getValue());
        goto L4
    L9:
        return MapsKt.toMutableMap(r1);
    }
}
