package com.larus.bmhome.collection;

import by7.e;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.SaveCollectionResponse;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&JT\u0010\n\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&Jb\u0010\u0015\u001a\u00020\u00032\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/collection/ICollectionReport;", "", "clickButton", "", "collectionId", "", "buttonName", "followingOtherAction", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "messageCollect", "collectResult", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/SaveCollectionResponse;", "messages", "", "Lcom/larus/im/bean/message/Message;", "clickFrom", "currentPage", "traceInfo", "Lorg/json/JSONObject;", "messageCollectCancel", "collectCancelResult", "Lcom/larus/platform/model/CancelCollectionResponse;", "botId", "conversationId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICollectionReport {

    public static final class a {
        public static /* synthetic */ void a(CollectionReportDelegate r9, com.larus.network.http.a r10, List r11, String r12, String r13, String r14, JSONObject r15, int r16) {
            if ((r16 & 16) == 0) goto L5;
            String r7 = null;
        L7:
            if ((r16 & 32) == 0) goto L9;
            JSONObject r8 = null;
        L10:
            r9.c(r10, r11, r12, r13, r7, r8);
            return;
        L9:
            r8 = r15;
            goto L10
        L5:
            r7 = r14;
            goto L7
        }

        public static /* synthetic */ void b(CollectionReportDelegate r10, com.larus.network.http.a r11, List r12, String r13, String r14, String r15, String r16, int r17) {
            if ((r17 & 8) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r17 & 16) == 0) goto L9;
            String r7 = null;
        L11:
            if ((r17 & 32) == 0) goto L13;
            String r8 = null;
        L14:
            r10.b(r11, r12, r13, r6, r7, r8, null);
            return;
        L13:
            r8 = r16;
            goto L14
        L9:
            r7 = r15;
            goto L11
        L5:
            r6 = r14;
            goto L7
        }
    }

    void a(String r1, String r2, String r3, e r4);

    void b(com.larus.network.http.a<CancelCollectionResponse> r1, List<Message> r2, String r3, String r4, String r5, String r6, e r7);

    void c(com.larus.network.http.a<SaveCollectionResponse> r1, List<Message> r2, String r3, String r4, String r5, JSONObject r6);
}
