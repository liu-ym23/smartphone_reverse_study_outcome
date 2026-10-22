package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.live.datacontext.DataContext;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class f {
    static {
        PublishSubject<g> r0 = g.m0;
    }

    public static g a() {
        DataContext r0 = com.bytedance.live.datacontext.d.d("ILinkMultiInternalService");
        if ((r0 instanceof LinkInternalServiceContext) == true) goto L5;
        return null;
    L5:
        return (g) ((LinkInternalServiceContext) r0).getMultiService().getValue();
    }
}
