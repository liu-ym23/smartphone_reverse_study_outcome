package com.larus.bmhome.collection;

import by7.e;
import com.larus.im.bean.message.Message;
import com.larus.network.http.a;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.SaveCollectionResponse;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001JQ\u0010\f\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0001J[\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/collection/CollectionReportDelegate;", "Lcom/larus/bmhome/collection/ICollectionReport;", "<init>", "()V", "clickButton", "", "collectionId", "", "buttonName", "followingOtherAction", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "messageCollect", "collectResult", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/SaveCollectionResponse;", "messages", "", "Lcom/larus/im/bean/message/Message;", "clickFrom", "currentPage", "traceInfo", "Lorg/json/JSONObject;", "messageCollectCancel", "collectCancelResult", "Lcom/larus/platform/model/CancelCollectionResponse;", "botId", "conversationId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollectionReportDelegate implements ICollectionReport {
    public static final CollectionReportDelegate b = null;
    public final /* synthetic */ ICollectionReport a;

    static {
        b = new CollectionReportDelegate();
    }

    @Override // com.larus.bmhome.collection.ICollectionReport
    public final void a(String r2, String r3, String r4, e r5) {
        Intrinsics.checkNotNullParameter(r3, "buttonName");
        Intrinsics.checkNotNullParameter(r4, "followingOtherAction");
        this.a.a(r2, r3, r4, r5);
    }

    @Override // com.larus.bmhome.collection.ICollectionReport
    public final void b(a<CancelCollectionResponse> r10, List<Message> r11, String r12, String r13, String r14, String r15, e r16) {
        Intrinsics.checkNotNullParameter(r12, "clickFrom");
        this.a.b(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.larus.bmhome.collection.ICollectionReport
    public final void c(a<SaveCollectionResponse> r9, List<Message> r10, String r11, String r12, String r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r11, "clickFrom");
        this.a.c(r9, r10, r11, r12, r13, r14);
    }

    private CollectionReportDelegate() {
        ICollectionReport r0 = (ICollectionReport) ServiceManager.get().getService(ICollectionReport.class);
        if (r0 != null) goto L5;
        r0 = new CollectionReportNoop();
    L5:
        this.a = r0;
    }
}
