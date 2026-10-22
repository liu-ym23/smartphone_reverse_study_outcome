package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/f;", "", "", "Lcom/bytedance/android/live/recharge/platform/model/e;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "signList", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "renderData", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "payType", "I", "a", "()I", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.nopassword.SignInfo")
public final class f {

    @SerializedName("pay_type")
    private final int payType;

    @SerializedName("render_data_info")
    private final String renderData;

    @SerializedName("sign_info")
    private final List<e> signList;

    public f() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L12;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.signList, r4.signList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.renderData, r4.renderData) == true) goto L10;
        return false;
    L10:
        if (this.payType == r4.payType) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<e> r0 = this.signList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.renderData;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.payType;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "NoPasswordSignInfo(signList=" + this.signList + ", renderData=" + this.renderData + ", payType=" + this.payType + ")";
    }

    public final boolean d() {
        if (this.payType != NoPasswordPayType.USE_DY_OR_ZFB_PAY.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e() {
        if (this.payType != NoPasswordPayType.USE_ONE_STEP_PAY.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean f() {
        if (this.payType != NoPasswordPayType.USE_RECHARGE_PANEL.getValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean g() {
        if (this.payType != NoPasswordPayType.NOT_USE_NO_PASSWORD.getValue()) goto L5;
    L7:
        return false;
    L5:
        if (this.payType == NoPasswordPayType.USE_RECHARGE_PANEL.getValue()) goto L7;
        return true;
    }

    public final int a() {
        return this.payType;
    }

    public final String b() {
        return this.renderData;
    }

    public final List<e> c() {
        return this.signList;
    }

    public /* synthetic */ f(int r3) {
        this(CollectionsKt.emptyList(), "", NoPasswordPayType.NOT_USE_NO_PASSWORD.getValue());
    }

    public f(List<e> r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "signList");
        Intrinsics.checkNotNullParameter(r3, "renderData");
        this.signList = r2;
        this.renderData = r3;
        this.payType = r4;
    }
}
