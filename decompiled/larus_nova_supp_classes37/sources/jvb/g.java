package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements gvb.a {
    public final List<String> a;
    public final MmRecordingSource b;
    public final int c;
    public final String d;
    public final MmHttpMethod e;

    @Override // gvb.a
    public final Map<String, String> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("biz_id_list", CollectionsKt.joinToString$default(this.a, fyb.a.COMMA, null, null, 0, null, null, 62, null)), TuplesKt.to("minutes_biz_type", String.valueOf(this.c))});
    }

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
        return this.e;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.d;
    }

    public g(List<String> r2, MmRecordingSource r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "bizIdList");
        this.a = r2;
        this.b = r3;
        this.c = 2;
        Lazy r5 = MmNetworkReqPath.a;
        if (r4 == false) goto L5;
        String r6 = MmNetworkReqPath.b(r3) + "lookup_by_bizids";
    L6:
        this.d = r6;
        this.e = MmHttpMethod.GET;
        return;
    L5:
        r6 = MmNetworkReqPath.a(r3) + "recording/lookup_by_bizids";
        goto L6
    }
}
