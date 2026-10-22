package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b%\u0010&J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0000H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R$\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/RecommendSearchWordsResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "", "getResponseMessage", "getResponseData", "", "getStatusCode", "", "checkValue", "Lcom/ss/ugc/effectplatform/model/net/RecommendSearchWordsModel;", "component1", "component2", "component3", "data", "status_code", INotificationHitPoint.NoticeType.MESSAGE, "copy", "toString", "hashCode", "", INotificationHitPoint.NoticeType.OTHER, "equals", "Lcom/ss/ugc/effectplatform/model/net/RecommendSearchWordsModel;", "getData", "()Lcom/ss/ugc/effectplatform/model/net/RecommendSearchWordsModel;", "setData", "(Lcom/ss/ugc/effectplatform/model/net/RecommendSearchWordsModel;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/net/RecommendSearchWordsModel;ILjava/lang/String;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class RecommendSearchWordsResponse extends e<RecommendSearchWordsResponse> {
    private RecommendSearchWordsModel data;
    private String message;
    private int status_code;

    public RecommendSearchWordsResponse() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ RecommendSearchWordsResponse copy$default(RecommendSearchWordsResponse r0, RecommendSearchWordsModel r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.status_code;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.message;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final RecommendSearchWordsModel component1() {
        return this.data;
    }

    public final int component2() {
        return this.status_code;
    }

    public final String component3() {
        return this.message;
    }

    public final RecommendSearchWordsResponse copy(RecommendSearchWordsModel r2, int r3, String r4) {
        return new RecommendSearchWordsResponse(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof RecommendSearchWordsResponse) == false) goto L12;
        RecommendSearchWordsResponse r4 = (RecommendSearchWordsResponse) r3;
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L8;
        return false;
    L8:
        if (this.status_code == r4.status_code) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.message, r4.message) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public RecommendSearchWordsResponse getResponseData() {
        return this;
    }

    public int hashCode() {
        RecommendSearchWordsModel r0 = this.data;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.status_code) * 31;
        String r4 = this.message;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "RecommendSearchWordsResponse(data=" + this.data + ", status_code=" + this.status_code + ", message=" + this.message + ")";
    }

    public boolean checkValue() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1558getResponseData() {
        return getResponseData();
    }

    public final RecommendSearchWordsModel getData() {
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

    public final void setData(RecommendSearchWordsModel r1) {
        this.data = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public RecommendSearchWordsResponse(RecommendSearchWordsModel r1, int r2, String r3) {
        this.data = r1;
        this.status_code = r2;
        this.message = r3;
    }

    public /* synthetic */ RecommendSearchWordsResponse(RecommendSearchWordsModel r2, int r3, String r4, int r5, DefaultConstructorMarker r6) {
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
