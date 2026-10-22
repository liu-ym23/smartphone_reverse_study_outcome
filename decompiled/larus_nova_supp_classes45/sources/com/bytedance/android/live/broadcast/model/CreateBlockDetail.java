package com.bytedance.android.live.broadcast.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR,\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/broadcast/model/CreateBlockDetail;", "", "()V", "blockType", "", "getBlockType", "()I", "setBlockType", "(I)V", "dialogInfo", "", "getDialogInfo", "()Ljava/lang/String;", "setDialogInfo", "(Ljava/lang/String;)V", "extra", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "schemaInfo", "Lcom/bytedance/android/live/broadcast/model/SchemaInfo;", "getSchemaInfo", "()Lcom/bytedance/android/live/broadcast/model/SchemaInfo;", "setSchemaInfo", "(Lcom/bytedance/android/live/broadcast/model/SchemaInfo;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CreateBlockDetail {

    @SerializedName("block_type")
    private int blockType;

    @SerializedName("dialog_info")
    private String dialogInfo;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("schema_info")
    private SchemaInfo schemaInfo;

    public CreateBlockDetail() {
        this.dialogInfo = "";
    }

    public final int getBlockType() {
        return this.blockType;
    }

    public final String getDialogInfo() {
        return this.dialogInfo;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final SchemaInfo getSchemaInfo() {
        return this.schemaInfo;
    }

    public final void setBlockType(int r1) {
        this.blockType = r1;
    }

    public final void setDialogInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dialogInfo = r2;
    }

    public final void setExtra(Map<String, String> r1) {
        this.extra = r1;
    }

    public final void setSchemaInfo(SchemaInfo r1) {
        this.schemaInfo = r1;
    }
}
