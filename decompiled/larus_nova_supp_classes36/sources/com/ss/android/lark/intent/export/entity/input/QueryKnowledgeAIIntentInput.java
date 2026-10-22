package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import knb.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/QueryKnowledgeAIIntentInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", "query", "", "topicId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "getTopicId", "toString", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class QueryKnowledgeAIIntentInput extends IntentInput implements Serializable {
    private final String query;
    private final String topicId;

    public String toString() {
        StringBuilder r0 = new StringBuilder("QueryKnowledgeAIIntentInput(query=");
        String r1 = this.query;
        String r2 = "null";
        if (r1 == null) goto L6;
        String r3 = a.a(r1);
        if (r3 == null) goto L6;
    L7:
        r0.append(r3);
        r0.append(", topicId=");
        String r4 = this.topicId;
        if (r4 == null) goto L11;
        r2 = r4;
    L11:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L6:
        r3 = "null";
        goto L7
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public QueryKnowledgeAIIntentInput(String r2, String r3) {
        super(IntentInput.IntentType.QUERY_KNOWLEDGE_AI);
        this.query = r2;
        this.topicId = r3;
    }
}
