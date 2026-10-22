package xub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements gvb.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final MmRecordingSource f;
    public final String g;
    public final MmHttpMethod h;
    public final MmHttpContentType i;

    @Override // gvb.a
    public final ByteString b() {
        return null;
    }

    @Override // gvb.a
    public final boolean d() {
        return false;
    }

    @Override // gvb.a
    public final String c() {
        return new JSONObject().put("auto_transcribe", true).put("language", "mixed").put("object_token", this.a).put("upload_id", this.b).put("upload_token", this.c).put("vhid", this.d).put("upload_file_tokens", this.e).toString();
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
        return this.f;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return this.i;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.h;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.g;
    }

    public b(String r2, String r3, String r4, String r5, String r6, MmRecordingSource r7) {
        Intrinsics.checkNotNullParameter(r2, "objectToken");
        Intrinsics.checkNotNullParameter(r3, "uploadId");
        Intrinsics.checkNotNullParameter(r4, "uploadToken");
        Intrinsics.checkNotNullParameter(r5, "vhId");
        Intrinsics.checkNotNullParameter(r6, "uploadFileTokens");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        Lazy r8 = MmNetworkReqPath.a;
        this.g = MmNetworkReqPath.a(r7) + "upload/finish";
        this.h = MmHttpMethod.POST;
        this.i = MmHttpContentType.JSON;
    }
}
