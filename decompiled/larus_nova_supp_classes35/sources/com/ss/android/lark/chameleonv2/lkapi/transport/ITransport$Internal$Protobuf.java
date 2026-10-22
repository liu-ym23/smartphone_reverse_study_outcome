package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;", "Lcom/bytedance/ee/util/io/NonProguard;", "request", BuildConfig.FLAVOR, "response", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRequest", "()Ljava/lang/String;", "getResponse", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Internal$Protobuf implements NonProguard {
    private final String request;
    private final String response;

    public static /* synthetic */ ITransport$Internal$Protobuf copy$default(ITransport$Internal$Protobuf r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.request;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.response;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.request;
    }

    public final String component2() {
        return this.response;
    }

    public final ITransport$Internal$Protobuf copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        return new ITransport$Internal$Protobuf(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ITransport$Internal$Protobuf) == true) goto L8;
        return false;
    L8:
        ITransport$Internal$Protobuf r6 = (ITransport$Internal$Protobuf) r5;
        if (Intrinsics.areEqual(this.request, r6.request) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.response, r6.response) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.request.hashCode() * 31) + this.response.hashCode();
    }

    public String toString() {
        return "Protobuf(request=" + this.request + ", response=" + this.response + ')';
    }

    public final String getRequest() {
        return this.request;
    }

    public final String getResponse() {
        return this.response;
    }

    public ITransport$Internal$Protobuf(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "response");
        this.request = r2;
        this.response = r3;
    }
}
