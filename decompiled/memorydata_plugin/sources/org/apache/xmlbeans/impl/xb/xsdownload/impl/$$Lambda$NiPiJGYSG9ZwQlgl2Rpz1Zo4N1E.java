package org.apache.xmlbeans.impl.xb.xsdownload.impl;

import java.util.function.Consumer;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.xb.xsdownload.impl.-$$Lambda$NiPiJGYSG9ZwQlgl2Rpz1Zo4N1E, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class $$Lambda$NiPiJGYSG9ZwQlgl2Rpz1Zo4N1E implements Consumer {
    public final /* synthetic */ DownloadedSchemaEntryImpl f$0;

    public /* synthetic */ $$Lambda$NiPiJGYSG9ZwQlgl2Rpz1Zo4N1E(DownloadedSchemaEntryImpl r1) {
        this.f$0 = r1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object r1) {
        this.f$0.removeSchemaLocation(((Integer) r1).intValue());
    }
}
