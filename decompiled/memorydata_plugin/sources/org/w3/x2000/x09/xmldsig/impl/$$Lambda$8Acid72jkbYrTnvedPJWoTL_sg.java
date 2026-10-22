package org.w3.x2000.x09.xmldsig.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: org.w3.x2000.x09.xmldsig.impl.-$$Lambda$8Acid72jkbYr-TnvedPJWoTL_sg, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class $$Lambda$8Acid72jkbYrTnvedPJWoTL_sg implements Consumer {
    public final /* synthetic */ TransformTypeImpl f$0;

    public /* synthetic */ $$Lambda$8Acid72jkbYrTnvedPJWoTL_sg(TransformTypeImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeXPath(((Integer) r1).intValue());
    }
}
