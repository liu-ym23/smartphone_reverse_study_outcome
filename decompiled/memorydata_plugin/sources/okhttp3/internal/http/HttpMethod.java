package okhttp3.internal.http;

import com.bytedance.retrofit2.HttpMethodContrants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", "method", "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class HttpMethod {
    public static final HttpMethod INSTANCE = null;

    static {
        INSTANCE = new HttpMethod();
    }

    private HttpMethod() {
    }

    @JvmStatic
    public static final boolean permitsRequestBody(String r1) {
        Intrinsics.checkParameterIsNotNull(r1, "method");
        if (Intrinsics.areEqual(r1, HttpMethodContrants.GET) == false) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r1, HttpMethodContrants.HEAD) == true) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean requiresRequestBody(String r1) {
        Intrinsics.checkParameterIsNotNull(r1, "method");
        if (Intrinsics.areEqual(r1, "POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, HttpMethodContrants.PUT) == true) goto L14;
        if (Intrinsics.areEqual(r1, HttpMethodContrants.PATCH) == true) goto L14;
        if (Intrinsics.areEqual(r1, "PROPPATCH") == true) goto L14;
        if (Intrinsics.areEqual(r1, "REPORT") == true) goto L14;
        return false;
    }

    public final boolean invalidatesCache(String r1) {
        Intrinsics.checkParameterIsNotNull(r1, "method");
        if (Intrinsics.areEqual(r1, "POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, HttpMethodContrants.PATCH) == true) goto L14;
        if (Intrinsics.areEqual(r1, HttpMethodContrants.PUT) == true) goto L14;
        if (Intrinsics.areEqual(r1, HttpMethodContrants.DELETE) == true) goto L14;
        if (Intrinsics.areEqual(r1, "MOVE") == true) goto L14;
        return false;
    }

    public final boolean redirectsToGet(String r1) {
        Intrinsics.checkParameterIsNotNull(r1, "method");
        return !Intrinsics.areEqual(r1, "PROPFIND");
    }

    public final boolean redirectsWithBody(String r1) {
        Intrinsics.checkParameterIsNotNull(r1, "method");
        return Intrinsics.areEqual(r1, "PROPFIND");
    }
}
