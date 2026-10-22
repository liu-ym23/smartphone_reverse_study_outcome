package com.bytedance.android.annie.bridge;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/bytedance/android/annie/bridge/u;", "", "", com.bytedance.android.ec.core.event.a.KEY_URL, "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "filePath", "a", "setFilePath", "", "header", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "params", "d", "setParams", "fileType", "getFileType", "setFileType", "", "needCommonParams", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "setNeedCommonParams", "(Ljava/lang/Boolean;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("filePath")
    private String filePath;

    @SerializedName("fileType")
    private String fileType;

    @SerializedName("header")
    private Map<String, ? extends Object> header;

    @SerializedName("needCommonParams")
    private Boolean needCommonParams;

    @SerializedName("params")
    private Map<String, ? extends Object> params;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_URL)
    private String url;

    public u() {
        this.url = "";
        this.filePath = "";
    }

    public final String a() {
        return this.filePath;
    }

    public final Map<String, Object> b() {
        return this.header;
    }

    public final Boolean c() {
        return this.needCommonParams;
    }

    public final Map<String, Object> d() {
        return this.params;
    }

    public final String e() {
        return this.url;
    }
}
