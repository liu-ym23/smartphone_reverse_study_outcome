package org.apache.xmlbeans.impl.xb.xsdownload.impl;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.xb.xsdownload.impl.-$$Lambda$-UgC8mlAW9S3Bajw7TUqn3j7x0E, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$UgC8mlAW9S3Bajw7TUqn3j7x0E implements Supplier {
    public final /* synthetic */ DownloadedSchemaEntryImpl f$0;

    public /* synthetic */ $$Lambda$UgC8mlAW9S3Bajw7TUqn3j7x0E(DownloadedSchemaEntryImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.f$0.sizeOfSchemaLocationArray());
    }
}
