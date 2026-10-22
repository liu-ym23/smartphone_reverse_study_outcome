package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/l;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "bizType", "I", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/m;", "dataList", "Ljava/util/List;", "curLeftGiftCount", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class l implements vh7.h {

    @SerializedName("biz_type")
    public int bizType;

    @SerializedName("cur_left_gift_count")
    public int curLeftGiftCount;

    @SerializedName("data_list")
    public List<m> dataList;

    public l() {
        this.dataList = new ArrayList();
    }

    public l(am3.g r5) {
        this.dataList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        if (r2 != 1) goto L8;
        this.bizType = (int) r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.dataList.add(new m(r5));
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this.curLeftGiftCount = (int) r5.j();
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r0);
        if (this.dataList.isEmpty() == false) goto L31;
        this.dataList = new ArrayList();
        return;
    }
}
