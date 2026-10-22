package com.bytedance.android.live.recharge.utils;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/recharge/utils/c;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "dialogContentEnable", "Z", "getDialogContentEnable", "()Z", "setDialogContentEnable", "(Z)V", "", "dialogContent", "Ljava/lang/String;", "getDialogContent", "()Ljava/lang/String;", "setDialogContent", "(Ljava/lang/String;)V", "dialogTitle", "getDialogTitle", "setDialogTitle", "diamondLimit", "a", "setDiamondLimit", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c {

    @SerializedName("dialog_content")
    private String dialogContent;

    @SerializedName("dialog_enable")
    private boolean dialogContentEnable;

    @SerializedName("dialog_title")
    private String dialogTitle;

    @SerializedName("diamond_limit")
    private int diamondLimit;

    @SerializedName("type")
    private int type;

    public static final class a {
    }

    static {
    }

    public c() {
        this.dialogContent = "";
        this.dialogTitle = "";
        this.diamondLimit = 10;
    }

    public final int a() {
        return this.diamondLimit;
    }

    public final int getType() {
        return this.type;
    }
}
