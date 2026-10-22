package com.ss.ugc.effectplatform.model;

import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B!\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingDesignerInfoConvertModel;", "", "data", "", "Lcom/ss/ugc/effectplatform/model/RankingDesignerInfoModel;", TrafficMetrics.FROM_TOTAL, "", "(Ljava/util/List;I)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getTotal", "()I", "setTotal", "(I)V", "toString", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingDesignerInfoConvertModel {
    private List<? extends RankingDesignerInfoModel> data;
    private int total;

    public RankingDesignerInfoConvertModel() {
        List r2 = null;
        this(r2, 0, 3, r2);
    }

    public String toString() {
        return "RankingDesignerInfoConvertModel(data=" + getData() + ", total=" + getTotal() + ')';
    }

    public List<RankingDesignerInfoModel> getData() {
        return this.data;
    }

    public int getTotal() {
        return this.total;
    }

    public void setData(List<? extends RankingDesignerInfoModel> r1) {
        this.data = r1;
    }

    public void setTotal(int r1) {
        this.total = r1;
    }

    public RankingDesignerInfoConvertModel(List<? extends RankingDesignerInfoModel> r1, int r2) {
        this.data = r1;
        this.total = r2;
    }

    public /* synthetic */ RankingDesignerInfoConvertModel(List r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }
}
