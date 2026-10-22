package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ*\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/entity/ClearDataModel;", "", "appType", "", "", "dataType", "", "<init>", "([Ljava/lang/String;Ljava/lang/Integer;)V", "getAppType", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getDataType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "equals", "", "other", "hashCode", "component1", "component2", "copy", "([Ljava/lang/String;Ljava/lang/Integer;)Lcom/ss/android/lark/passport/signinsdk_api/entity/ClearDataModel;", "toString", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ClearDataModel {

    @SerializedName("app_type")
    private final String[] appType;

    @SerializedName("data_type")
    private final Integer dataType;

    /* JADX WARN: Multi-variable type inference failed */
    public ClearDataModel() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ClearDataModel copy$default(ClearDataModel r0, String[] r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.appType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.dataType;
    L9:
        return r0.copy(r1, r2);
    }

    public final String[] component1() {
        return this.appType;
    }

    public final Integer component2() {
        return this.dataType;
    }

    public final ClearDataModel copy(String[] r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "appType");
        return new ClearDataModel(r2, r3);
    }

    public String toString() {
        return "ClearDataModel(appType=" + Arrays.toString(this.appType) + ", dataType=" + this.dataType + ')';
    }

    public int hashCode() {
        int r0 = Arrays.hashCode(this.appType) * 31;
        Integer r1 = this.dataType;
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String[] getAppType() {
        return this.appType;
    }

    public final Integer getDataType() {
        return this.dataType;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(ClearDataModel.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.passport.signinsdk_api.entity.ClearDataModel");
        ClearDataModel r6 = (ClearDataModel) r5;
        if (Arrays.equals(this.appType, r6.appType) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.dataType, r6.dataType) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public ClearDataModel(String[] r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "appType");
        this.appType = r2;
        this.dataType = r3;
    }

    public /* synthetic */ ClearDataModel(String[] r1, Integer r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = new String[0];
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
