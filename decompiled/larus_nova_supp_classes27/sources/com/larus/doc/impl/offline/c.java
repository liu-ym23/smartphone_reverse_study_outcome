package com.larus.doc.impl.offline;

import com.larus.doc.sdk.api.SyncedDocInfoSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface c extends m1a.a {
    boolean BK();

    void FN();

    void QN(f r1);

    void b10(boolean r1);

    void g60();

    String getCreateDocResp();

    void offlineCreateFail();

    void onSyncedDocInfo(SyncedDocInfoSource r1);

    boolean wL();
}
