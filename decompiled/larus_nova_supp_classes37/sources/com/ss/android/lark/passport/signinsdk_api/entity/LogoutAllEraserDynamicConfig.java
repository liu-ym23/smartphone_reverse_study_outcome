package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "lark_security_logout_all_eraser_dynamic")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0006H\u0016R2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/entity/LogoutAllEraserDynamicConfig;", "Ljava/io/Serializable;", "<init>", "()V", "pathList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPathList", "()Ljava/util/ArrayList;", "setPathList", "(Ljava/util/ArrayList;)V", "toString", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class LogoutAllEraserDynamicConfig implements Serializable {

    @SerializedName(AppbrandHostConstants.Schema_RESERVED_FIELD.PATH)
    private ArrayList<String> pathList;

    public LogoutAllEraserDynamicConfig() {
    }

    public String toString() {
        return "LogoutAllEraserDynamicConfig(pathList=" + this.pathList + ')';
    }

    public final ArrayList<String> getPathList() {
        return this.pathList;
    }

    public final void setPathList(ArrayList<String> r1) {
        this.pathList = r1;
    }
}
