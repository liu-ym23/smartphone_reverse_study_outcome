package com.ss.android.lark.optrace.extension.clientRequest;

import com.ss.android.lark.optrace.extension.TracingExtension;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class TrancingClientRequestExtension implements TracingExtension {
    public TrancingClientRequestExtension() {
    }

    public abstract String getRequestId();

    @Override // com.ss.android.lark.optrace.extension.TracingExtension
    public abstract /* synthetic */ TracingExtension mergeExtension(TracingExtension r1);

    public abstract void setRequestId(String r1);
}
