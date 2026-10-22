package org.w3.x2000.x09.xmldsig.impl;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.w3.x2000.x09.xmldsig.impl.-$$Lambda$M5iYGOKM-e0txfMmdHy9KYPk1wA, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class $$Lambda$M5iYGOKMe0txfMmdHy9KYPk1wA implements Supplier {
    public final /* synthetic */ TransformTypeImpl f$0;

    public /* synthetic */ $$Lambda$M5iYGOKMe0txfMmdHy9KYPk1wA(TransformTypeImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.f$0.sizeOfXPathArray());
    }
}
