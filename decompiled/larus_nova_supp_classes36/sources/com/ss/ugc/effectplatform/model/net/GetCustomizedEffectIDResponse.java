package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/GetCustomizedEffectIDResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/net/GetCustomizedEffectIDData;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "data", "Lcom/ss/ugc/effectplatform/model/net/GetCustomizedEffectIDData;", "getData", "()Lcom/ss/ugc/effectplatform/model/net/GetCustomizedEffectIDData;", "setData", "(Lcom/ss/ugc/effectplatform/model/net/GetCustomizedEffectIDData;)V", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", INotificationHitPoint.NoticeType.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/net/GetCustomizedEffectIDData;ILjava/lang/String;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class GetCustomizedEffectIDResponse extends e<GetCustomizedEffectIDData> {
    private GetCustomizedEffectIDData data;
    private String message;
    private int status_code;

    public GetCustomizedEffectIDResponse() {
        this(null, 0, null, 7, null);
    }

    public GetCustomizedEffectIDData getResponseData() {
        return getData();
    }

    public String getResponseMessage() {
        return getMessage();
    }

    public int getStatusCode() {
        return getStatus_code();
    }

    public GetCustomizedEffectIDData getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1539getResponseData() {
        return getResponseData();
    }

    public void setData(GetCustomizedEffectIDData r1) {
        this.data = r1;
    }

    public void setMessage(String r1) {
        this.message = r1;
    }

    public void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public GetCustomizedEffectIDResponse(GetCustomizedEffectIDData r1, int r2, String r3) {
        this.data = r1;
        this.status_code = r2;
        this.message = r3;
    }

    public /* synthetic */ GetCustomizedEffectIDResponse(GetCustomizedEffectIDData r2, int r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
