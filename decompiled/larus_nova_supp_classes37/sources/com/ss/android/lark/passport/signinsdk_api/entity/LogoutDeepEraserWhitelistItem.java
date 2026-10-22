package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0006H\u0016R2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR.\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0005j\b\u0012\u0004\u0012\u00020\u0010`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR.\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0005j\b\u0012\u0004\u0012\u00020\u0010`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/entity/LogoutDeepEraserWhitelistItem;", "Ljava/io/Serializable;", "<init>", "()V", "pathList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getPathList", "()Ljava/util/ArrayList;", "setPathList", "(Ljava/util/ArrayList;)V", "blockList", "getBlockList", "setBlockList", "mmkvConfig", "Lcom/ss/android/lark/passport/signinsdk_api/entity/LogoutDeepEraserKVConfig;", "getMmkvConfig", "setMmkvConfig", "spConfig", "getSpConfig", "setSpConfig", "toString", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class LogoutDeepEraserWhitelistItem implements Serializable {

    @SerializedName("block_path_list")
    private ArrayList<String> blockList;

    @SerializedName("mmkv")
    private ArrayList<LogoutDeepEraserKVConfig> mmkvConfig;

    @SerializedName(AppbrandHostConstants.Schema_RESERVED_FIELD.PATH)
    private ArrayList<String> pathList;

    @SerializedName("shared_preference")
    private ArrayList<LogoutDeepEraserKVConfig> spConfig;

    public String toString() {
        return "LogoutDeepEraserWhitelistItem(pathList=" + this.pathList + ", mmkvConfig=" + this.mmkvConfig + ", spConfig=" + this.spConfig + ')';
    }

    public LogoutDeepEraserWhitelistItem() {
        this.mmkvConfig = new ArrayList();
        this.spConfig = new ArrayList();
    }

    public final ArrayList<String> getBlockList() {
        return this.blockList;
    }

    public final ArrayList<LogoutDeepEraserKVConfig> getMmkvConfig() {
        return this.mmkvConfig;
    }

    public final ArrayList<String> getPathList() {
        return this.pathList;
    }

    public final ArrayList<LogoutDeepEraserKVConfig> getSpConfig() {
        return this.spConfig;
    }

    public final void setBlockList(ArrayList<String> r1) {
        this.blockList = r1;
    }

    public final void setMmkvConfig(ArrayList<LogoutDeepEraserKVConfig> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mmkvConfig = r2;
    }

    public final void setPathList(ArrayList<String> r1) {
        this.pathList = r1;
    }

    public final void setSpConfig(ArrayList<LogoutDeepEraserKVConfig> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.spConfig = r2;
    }
}
