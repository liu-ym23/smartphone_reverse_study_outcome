package com.ss.android.lark.integrator.ccm.dependency.di;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.integrator.ccm.spacekit.SpacekitSdkWrapper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class DocsPreloadAgentImpl<Boolean> implements IGetDataCallback<Boolean> {
    public DocsPreloadAgentImpl() {
    }

    public void onError(ErrorResult r1) {
    }

    public /* bridge */ /* synthetic */ void onError(Object r1) {
        onError((ErrorResult) r1);
    }

    public void onSuccess(Boolean r2) {
        Iterator r3 = ((CopyOnWriteArrayList) SpacekitSdkWrapper.b.a.c).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((gmb.a) r3.next()).getClass();
        goto L4
    }
}
