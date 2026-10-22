package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o implements gvb.a {
    public final String a;
    public final double b;
    public final double c;
    public final String d;
    public final MmRecordingSource e;
    public final boolean f;
    public final String g;
    public final MmHttpMethod h;

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
    public final Map<String, String> f() {
        if (this.f == false) goto L5;
        String r0 = "recording_id";
    L7:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(r0, this.a), TuplesKt.to("latitude", String.valueOf(this.b)), TuplesKt.to("longitude", String.valueOf(this.c)), TuplesKt.to(AppbrandHostConstants.Schema_BDP_LOG.FIELD_LOCATION, this.d)});
    L5:
        r0 = "object_token";
        goto L7
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
    public final MmRecordingSource getClientSource() {
        return this.e;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.h;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.g;
    }

    public o(String r2, double r3, double r5, String r7, MmRecordingSource r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "locationIdentity");
        Intrinsics.checkNotNullParameter(r7, AppbrandHostConstants.Schema_BDP_LOG.FIELD_LOCATION);
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        Lazy r4 = MmNetworkReqPath.a;
        if (r9 == false) goto L5;
        String r6 = MmNetworkReqPath.b(r8) + AppbrandHostConstants.Schema_BDP_LOG.FIELD_LOCATION;
    L6:
        this.g = r6;
        this.h = MmHttpMethod.POST;
        return;
    L5:
        r6 = MmNetworkReqPath.a(r8) + "audio/location";
        goto L6
    }
}
