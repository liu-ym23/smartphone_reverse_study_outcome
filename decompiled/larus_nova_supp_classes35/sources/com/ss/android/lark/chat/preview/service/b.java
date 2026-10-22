package com.ss.android.lark.chat.preview.service;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.url.v1.PushPreviewsRequest;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.sdk.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements g.b {
    public final /* synthetic */ d a;

    public b(d r1) {
        this.a = r1;
    }

    public final void a(byte[] r5) {
        Map r6 = ((PushPreviewsRequest) PushPreviewsRequest.ADAPTER.decode(r5)).preview_entities;
        HashMap r0 = new HashMap();
        Intrinsics.checkNotNull(r6);
        Iterator r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r7.next();
        UrlCardPreviewEntity r2 = j6b.d.d((UrlPreviewEntity) r1.getValue(), false);
        r0.put(r1.getKey(), r2);
        goto L4
    L6:
        UICallbackExecutor.post(new a(this.a, r0));
    }
}
