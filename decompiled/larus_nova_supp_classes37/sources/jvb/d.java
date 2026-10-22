package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements gvb.a {
    public final String a;
    public final String b;
    public final MmRecordingSource c;
    public final String d;
    public final boolean e;
    public final String f;

    @Override // gvb.a
    public final Map<String, String> a() {
        boolean r2 = false;
        HashMap r0 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("quota_type_list", this.b), TuplesKt.to("scene", "MinutesDetailForRealtimeRecording"), TuplesKt.to("language", this.d), TuplesKt.to("upgrade_optional", String.valueOf(this.e))});
        if (this.a.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r0.put("object_token", this.a);
    L9:
        if (this.f.length() <= 0) goto L11;
        r2 = true;
    L11:
        if (r2 == false) goto L13;
        r0.put("function_scene_list[]", this.f);
    L13:
        return r0;
    L5:
        r1 = false;
        goto L6
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
    public final String getPath() {
        Lazy r0 = MmNetworkReqPath.a;
        return MmNetworkReqPath.a(this.c) + "quota_data";
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
        return this.c;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return MmHttpMethod.GET;
    }

    public d(String r3, String r4, MmRecordingSource r5, String r6) {
        String r0 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.a.a();
        Intrinsics.checkNotNullParameter(r3, "objectToken");
        Intrinsics.checkNotNullParameter(r4, "quotaTypeList");
        Intrinsics.checkNotNullParameter(r0, "language");
        Intrinsics.checkNotNullParameter(r6, "functionScene");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r0;
        this.e = false;
        this.f = r6;
    }
}
