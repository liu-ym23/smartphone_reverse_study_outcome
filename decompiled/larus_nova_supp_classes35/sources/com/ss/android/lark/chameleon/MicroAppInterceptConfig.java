package com.ss.android.lark.chameleon;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0000J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/ss/android/lark/chameleon/MicroAppInterceptConfig;", "Ljava/io/Serializable;", "urlPath", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "urlQuery", "Lcom/ss/android/lark/chameleon/UrlQuery;", "urlSchema", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chameleon/UrlQuery;Ljava/util/ArrayList;)V", "getUrlPath", "()Ljava/lang/String;", "setUrlPath", "(Ljava/lang/String;)V", "getUrlQuery", "()Lcom/ss/android/lark/chameleon/UrlQuery;", "setUrlQuery", "(Lcom/ss/android/lark/chameleon/UrlQuery;)V", "getUrlSchema", "()Ljava/util/ArrayList;", "setUrlSchema", "(Ljava/util/ArrayList;)V", "copy", "toString", "component1", "component2", "component3", "equals", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "other", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "hashCode", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MicroAppInterceptConfig implements Serializable {
    private String urlPath;
    private UrlQuery urlQuery;
    private ArrayList<String> urlSchema;

    public MicroAppInterceptConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MicroAppInterceptConfig copy$default(MicroAppInterceptConfig r0, String r1, UrlQuery r2, ArrayList r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.urlPath;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.urlQuery;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.urlSchema;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.urlPath;
    }

    public final UrlQuery component2() {
        return this.urlQuery;
    }

    public final ArrayList<String> component3() {
        return this.urlSchema;
    }

    public final MicroAppInterceptConfig copy(String r2, UrlQuery r3, ArrayList<String> r4) {
        return new MicroAppInterceptConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MicroAppInterceptConfig) == true) goto L8;
        return false;
    L8:
        MicroAppInterceptConfig r6 = (MicroAppInterceptConfig) r5;
        if (Intrinsics.areEqual(this.urlPath, r6.urlPath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlQuery, r6.urlQuery) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.urlSchema, r6.urlSchema) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.urlPath;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        UrlQuery r4 = this.urlQuery;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ArrayList<String> r7 = this.urlSchema;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final MicroAppInterceptConfig copy() {
        String r0 = this.urlPath;
        UrlQuery r1 = this.urlQuery;
        ArrayList r2 = null;
        if (r1 == null) goto L5;
        UrlQuery r3 = r1.copy();
    L6:
        ArrayList<String> r4 = this.urlSchema;
        if (r4 == null) goto L10;
        r2 = new ArrayList(r4);
    L10:
        return new MicroAppInterceptConfig(r0, r3, r2);
    L5:
        r3 = null;
        goto L6
    }

    public String toString() {
        return "MicroAppInterceptConfig(urlPath=" + this.urlPath + ", urlQuery=" + this.urlQuery + ", urlSchema=" + this.urlSchema + ')';
    }

    public final String getUrlPath() {
        return this.urlPath;
    }

    public final UrlQuery getUrlQuery() {
        return this.urlQuery;
    }

    public final ArrayList<String> getUrlSchema() {
        return this.urlSchema;
    }

    public final void setUrlPath(String r1) {
        this.urlPath = r1;
    }

    public final void setUrlQuery(UrlQuery r1) {
        this.urlQuery = r1;
    }

    public final void setUrlSchema(ArrayList<String> r1) {
        this.urlSchema = r1;
    }

    public MicroAppInterceptConfig(String r1, UrlQuery r2, ArrayList<String> r3) {
        this.urlPath = r1;
        this.urlQuery = r2;
        this.urlSchema = r3;
    }

    public /* synthetic */ MicroAppInterceptConfig(String r2, UrlQuery r3, ArrayList r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
