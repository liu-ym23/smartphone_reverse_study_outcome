package xub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.MmMinutesCreateSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements gvb.a {
    public final String a;
    public final MmRecordingSource b;
    public final String c;
    public final MmHttpMethod d;

    @Override // gvb.a
    public final ByteString b() {
        return null;
    }

    @Override // gvb.a
    public final String c() {
        return null;
    }

    @Override // gvb.a
    public final boolean d() {
        return false;
    }

    @Override // gvb.a
    public final Map<String, String> a() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("file_info[]", this.a);
        MmMinutesCreateSource r1 = ivb.a.a(this.b);
        if (r1 == null) goto L5;
        String r2 = Integer.valueOf(r1.getValue()).toString();
    L6:
        if (r2 == null) goto L8;
        r0.put("create_source", r2);
    L8:
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    @Override // gvb.a
    public final Map<String, String> e() {
        return MapsKt.emptyMap();
    }

    @Override // gvb.a
    public final Map<String, String> f() {
        return MapsKt.emptyMap();
    }

    @Override // gvb.a
    public final MmRecordingSource getClientSource() {
        return this.b;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.d;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.c;
    }

    public a(String r2, MmRecordingSource r3) {
        Intrinsics.checkNotNullParameter(r2, "fileInfoStr");
        this.a = r2;
        this.b = r3;
        Lazy r4 = MmNetworkReqPath.a;
        this.c = MmNetworkReqPath.a(r3) + "quota";
        this.d = MmHttpMethod.GET;
    }
}
