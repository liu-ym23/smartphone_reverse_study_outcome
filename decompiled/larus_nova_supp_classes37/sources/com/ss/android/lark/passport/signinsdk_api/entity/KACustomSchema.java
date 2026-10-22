package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "passport_idp_custom_callback_schema")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/entity/KACustomSchema;", "Ljava/io/Serializable;", "<init>", "()V", "customSchema", "", "getCustomSchema", "()Ljava/lang/String;", "setCustomSchema", "(Ljava/lang/String;)V", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class KACustomSchema implements Serializable {

    @SerializedName("client_schema")
    private String customSchema;

    public KACustomSchema() {
        this.customSchema = "";
    }

    public final String getCustomSchema() {
        return this.customSchema;
    }

    public final void setCustomSchema(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.customSchema = r2;
    }
}
