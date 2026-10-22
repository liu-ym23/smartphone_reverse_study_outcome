package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/config/r91;", "", "", "schema", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "url", "b", "setUrl", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class r91 {

    @SerializedName("schema")
    private String schema;

    @SerializedName("url")
    private String url;

    public r91() {
        this(null, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r91) == false) goto L10;
        r91 r4 = (r91) r3;
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.schema;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.url;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LynxConfigItem(schema=" + this.schema + ", url=" + this.url + ")";
    }

    public final String a() {
        return this.schema;
    }

    public final String b() {
        return this.url;
    }

    public r91(String r1, String r2) {
        this.schema = r1;
        this.url = r2;
    }
}
