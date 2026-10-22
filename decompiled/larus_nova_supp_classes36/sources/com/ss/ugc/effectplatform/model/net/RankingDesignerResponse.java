package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.model.RankingDesignerInfoConvertModel;
import com.ss.ugc.effectplatform.model.RankingDesignerInfoModel;
import com.ss.ugc.effectplatform.model.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b*\u0010+J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J;\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003R*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010#\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'¨\u0006,"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/RankingDesignerResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/RankingDesignerInfoConvertModel;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "", "Lcom/ss/ugc/effectplatform/model/RankingDesignerInfoModel;", "component1", "component2", "component3", "component4", "data", INotificationHitPoint.NoticeType.MESSAGE, "status_code", TrafficMetrics.FROM_TOTAL, "copy", "toString", "hashCode", "", INotificationHitPoint.NoticeType.OTHER, "", "equals", "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "getTotal", "setTotal", "<init>", "(Ljava/util/List;Ljava/lang/String;II)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class RankingDesignerResponse extends e<RankingDesignerInfoConvertModel> {
    private List<? extends RankingDesignerInfoModel> data;
    private String message;
    private int status_code;
    private int total;

    public RankingDesignerResponse() {
        this(null, null, 0, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RankingDesignerResponse copy$default(RankingDesignerResponse r0, List r1, String r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.data;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.status_code;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.total;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final List<RankingDesignerInfoModel> component1() {
        return this.data;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.status_code;
    }

    public final int component4() {
        return this.total;
    }

    public final RankingDesignerResponse copy(List<? extends RankingDesignerInfoModel> r2, String r3, int r4, int r5) {
        return new RankingDesignerResponse(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof RankingDesignerResponse) == false) goto L14;
        RankingDesignerResponse r4 = (RankingDesignerResponse) r3;
        if (Intrinsics.areEqual(this.data, r4.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r4.message) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r4.status_code) goto L12;
        return false;
    L12:
        if (this.total == r4.total) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<? extends RankingDesignerInfoModel> r0 = this.data;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.message;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((((r3 + r1) * 31) + this.status_code) * 31) + this.total;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "RankingDesignerResponse(data=" + this.data + ", message=" + this.message + ", status_code=" + this.status_code + ", total=" + this.total + ")";
    }

    public RankingDesignerInfoConvertModel getResponseData() {
        return new RankingDesignerInfoConvertModel(this.data, this.total);
    }

    public final List<RankingDesignerInfoModel> getData() {
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

    public final int getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1556getResponseData() {
        return getResponseData();
    }

    public final void setData(List<? extends RankingDesignerInfoModel> r1) {
        this.data = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public final void setTotal(int r1) {
        this.total = r1;
    }

    public RankingDesignerResponse(List<? extends RankingDesignerInfoModel> r1, String r2, int r3, int r4) {
        this.data = r1;
        this.message = r2;
        this.status_code = r3;
        this.total = r4;
    }

    public /* synthetic */ RankingDesignerResponse(List r2, String r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }
}
