package n39;

import com.larus.doc.sdk.api.SyncedDocInfoSource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface d extends com.larus.office.base.service.a<d> {
    String getCreateDocResp();

    void notifyDocLoadSuccess();

    void notifyInterruptConversation();

    void notifyOfflineCreateState(int r1);

    void offlineCreateFail();

    void onSyncedDocInfo(SyncedDocInfoSource r1);
}
