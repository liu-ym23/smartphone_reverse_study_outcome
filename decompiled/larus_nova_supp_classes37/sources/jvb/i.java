package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements gvb.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final MmRecordingSource e;

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
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("quota_type", this.b), TuplesKt.to("feature_key", this.c), TuplesKt.to("object_token", this.a), TuplesKt.to("license_plan_key", this.d)});
    }

    @Override // gvb.a
    public final String getPath() {
        return "/minutes/api/report_upgrade_event";
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
        return MmHttpMethod.POST;
    }

    public i(String r2, String r3, String r4, String r5, MmRecordingSource r6) {
        Intrinsics.checkNotNullParameter(r2, "objectToken");
        Intrinsics.checkNotNullParameter(r3, "quotaType");
        Intrinsics.checkNotNullParameter(r4, "featureKey");
        Intrinsics.checkNotNullParameter(r5, "licensePlanKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
