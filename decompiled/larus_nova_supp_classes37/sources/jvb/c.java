package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements gvb.a {
    public final MmRecordingSource a;
    public final String b;
    public final MmHttpMethod c;

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
        return MapsKt.emptyMap();
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
        return this.a;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.c;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.b;
    }

    public c(String r3, MmRecordingSource r4) {
        Intrinsics.checkNotNullParameter(r3, "meetingId");
        this.a = r4;
        StringBuilder r0 = new StringBuilder();
        Lazy r1 = MmNetworkReqPath.a;
        r0.append(MmNetworkReqPath.a(r4) + "bizid2token");
        r0.append("?biz_id_list=");
        r0.append(r3);
        r0.append("&minutes_biz_type=2");
        this.b = r0.toString();
        this.c = MmHttpMethod.GET;
    }
}
