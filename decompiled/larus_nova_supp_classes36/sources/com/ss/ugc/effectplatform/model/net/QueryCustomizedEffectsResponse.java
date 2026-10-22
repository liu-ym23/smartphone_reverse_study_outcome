package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\"\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/QueryCustomizedEffectsResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/net/QueryCustomizedEffectsData;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "", "verifySign", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", INotificationHitPoint.NoticeType.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "data", "Lcom/ss/ugc/effectplatform/model/net/QueryCustomizedEffectsData;", "getData", "()Lcom/ss/ugc/effectplatform/model/net/QueryCustomizedEffectsData;", "setData", "(Lcom/ss/ugc/effectplatform/model/net/QueryCustomizedEffectsData;)V", "<init>", "(ILjava/lang/String;Lcom/ss/ugc/effectplatform/model/net/QueryCustomizedEffectsData;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class QueryCustomizedEffectsResponse extends e<QueryCustomizedEffectsData> {
    private QueryCustomizedEffectsData data;
    private String message;
    private int status_code;

    public QueryCustomizedEffectsResponse() {
        this(0, null, null, 7, null);
    }

    public boolean verifySign() {
        return true;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1551getResponseData() {
        return getResponseData();
    }

    public final QueryCustomizedEffectsData getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public String getResponseMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    public QueryCustomizedEffectsData getResponseData() {
        return this.data;
    }

    public final void setData(QueryCustomizedEffectsData r1) {
        this.data = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public QueryCustomizedEffectsResponse(int r1, String r2, QueryCustomizedEffectsData r3) {
        this.status_code = r1;
        this.message = r2;
        this.data = r3;
    }

    public /* synthetic */ QueryCustomizedEffectsResponse(int r2, String r3, QueryCustomizedEffectsData r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
