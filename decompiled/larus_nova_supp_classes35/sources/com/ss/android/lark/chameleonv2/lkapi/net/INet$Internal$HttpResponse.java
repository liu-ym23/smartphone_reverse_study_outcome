package com.ss.android.lark.chameleonv2.lkapi.net;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/net/INet$Internal$HttpResponse;", "Lcom/bytedance/ee/util/io/NonProguard;", "body", BuildConfig.FLAVOR, "status", BuildConfig.FLAVOR, "headers", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/util/Map;)V", "getBody", "()Ljava/lang/String;", "setBody", "(Ljava/lang/String;)V", "getStatus", "()I", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class INet$Internal$HttpResponse implements NonProguard {
    private String body;
    private Map<String, String> headers;
    private final int status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ INet$Internal$HttpResponse copy$default(INet$Internal$HttpResponse r0, String r1, int r2, Map r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.body;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.status;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.headers;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.body;
    }

    public final int component2() {
        return this.status;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final INet$Internal$HttpResponse copy(String r2, int r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "body");
        return new INet$Internal$HttpResponse(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof INet$Internal$HttpResponse) == true) goto L8;
        return false;
    L8:
        INet$Internal$HttpResponse r6 = (INet$Internal$HttpResponse) r5;
        if (Intrinsics.areEqual(this.body, r6.body) == true) goto L12;
        return false;
    L12:
        if (this.status == r6.status) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.headers, r6.headers) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.body.hashCode() * 31) + this.status) * 31;
        Map<String, String> r1 = this.headers;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "HttpResponse(body=" + this.body + ", status=" + this.status + ", headers=" + this.headers + ')';
    }

    public final String getBody() {
        return this.body;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setBody(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.body = r2;
    }

    public final void setHeaders(Map<String, String> r1) {
        this.headers = r1;
    }

    public INet$Internal$HttpResponse(String r2, int r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "body");
        this.body = r2;
        this.status = r3;
        this.headers = r4;
    }
}
