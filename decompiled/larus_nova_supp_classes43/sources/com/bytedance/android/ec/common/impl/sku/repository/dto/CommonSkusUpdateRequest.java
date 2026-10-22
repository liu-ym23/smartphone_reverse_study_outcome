package com.bytedance.android.ec.common.impl.sku.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/repository/dto/CommonSkusUpdateRequest;", "Ljava/io/Serializable;", "selectedNum", "", "param", "", "(JLjava/lang/String;)V", "getParam", "()Ljava/lang/String;", "getSelectedNum", "()J", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonSkusUpdateRequest implements Serializable {

    @SerializedName("param")
    private final String param;

    @SerializedName("selected_num")
    private final long selectedNum;

    public CommonSkusUpdateRequest() {
        this(0, null, 3, null);
    }

    public final String getParam() {
        return this.param;
    }

    public final long getSelectedNum() {
        return this.selectedNum;
    }

    public CommonSkusUpdateRequest(long r1, String r10) {
        this.selectedNum = r1;
        this.param = r10;
    }

    public /* synthetic */ CommonSkusUpdateRequest(long r1, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = null;
    L8:
        this(r1, r10);
    }
}
