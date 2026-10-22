package com.larus.bmhome.collection;

import by7.e;
import com.larus.im.bean.message.Message;
import com.larus.network.http.a;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.SaveCollectionResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JP\u0010\f\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016JZ\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/collection/CollectionReportNoop;", "Lcom/larus/bmhome/collection/ICollectionReport;", "<init>", "()V", "clickButton", "", "collectionId", "", "buttonName", "followingOtherAction", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "messageCollect", "collectResult", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/SaveCollectionResponse;", "messages", "", "Lcom/larus/im/bean/message/Message;", "clickFrom", "currentPage", "traceInfo", "Lorg/json/JSONObject;", "messageCollectCancel", "collectCancelResult", "Lcom/larus/platform/model/CancelCollectionResponse;", "botId", "conversationId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectionReportNoop implements ICollectionReport {
    public CollectionReportNoop() {
    }

    @Override // com.larus.bmhome.collection.ICollectionReport
    public final void a(String r1, String r2, String r3, e r4) {
        Intrinsics.checkNotNullParameter(r2, "buttonName");
        Intrinsics.checkNotNullParameter(r3, "followingOtherAction");
    }

    @Override // com.larus.bmhome.collection.ICollectionReport
    public final void b(a<CancelCollectionResponse> r1, List<Message> r2, String r3, String r4, String r5, String r6, e r7) {
        Intrinsics.checkNotNullParameter(r3, "clickFrom");
    }

    @Override // com.larus.bmhome.collection.ICollectionReport
    public final void c(a<SaveCollectionResponse> r1, List<Message> r2, String r3, String r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r3, "clickFrom");
    }
}
