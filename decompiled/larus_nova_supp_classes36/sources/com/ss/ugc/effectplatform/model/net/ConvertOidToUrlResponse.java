package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/ConvertOidToUrlResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "", "Lcom/ss/ugc/effectplatform/model/net/ResourceUrl;", "url_list", "Ljava/util/List;", "getUrl_list", "()Ljava/util/List;", "setUrl_list", "(Ljava/util/List;)V", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "status_msg", "Ljava/lang/String;", "getStatus_msg", "()Ljava/lang/String;", "setStatus_msg", "(Ljava/lang/String;)V", "<init>", "(Ljava/util/List;ILjava/lang/String;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class ConvertOidToUrlResponse extends e<ConvertOidToUrlResponse> {
    private int status_code;
    private String status_msg;
    private List<? extends ResourceUrl> url_list;

    public ConvertOidToUrlResponse() {
        this(null, 0, null, 7, null);
    }

    public ConvertOidToUrlResponse getResponseData() {
        return this;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1531getResponseData() {
        return getResponseData();
    }

    public String getResponseMessage() {
        return getStatus_msg();
    }

    public int getStatusCode() {
        return getStatus_code();
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public String getStatus_msg() {
        return this.status_msg;
    }

    public List<ResourceUrl> getUrl_list() {
        return this.url_list;
    }

    public void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public void setStatus_msg(String r1) {
        this.status_msg = r1;
    }

    public void setUrl_list(List<? extends ResourceUrl> r1) {
        this.url_list = r1;
    }

    public ConvertOidToUrlResponse(List<? extends ResourceUrl> r1, int r2, String r3) {
        this.url_list = r1;
        this.status_code = r2;
        this.status_msg = r3;
    }

    public /* synthetic */ ConvertOidToUrlResponse(List r2, int r3, String r4, int r5, DefaultConstructorMarker r6) {
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
