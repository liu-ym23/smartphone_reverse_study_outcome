package org.etsi.uri.x01903.v13.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: org.etsi.uri.x01903.v13.impl.-$$Lambda$6Sg3Aini1QAzMGvi7qdbQzt38lM, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$6Sg3Aini1QAzMGvi7qdbQzt38lM implements Consumer {
    public final /* synthetic */ CommitmentTypeIndicationTypeImpl f$0;

    public /* synthetic */ $$Lambda$6Sg3Aini1QAzMGvi7qdbQzt38lM(CommitmentTypeIndicationTypeImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeObjectReference(((Integer) r1).intValue());
    }
}
