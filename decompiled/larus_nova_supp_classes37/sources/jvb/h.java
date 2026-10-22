package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmRecordingUpdateStatus;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h implements gvb.a {
    public final String a;
    public final MmRecordingUpdateStatus b;
    public final MmRecordingSource c;
    public final Boolean d;
    public final Long e;
    public final boolean f;

    public static final class a {
    }

    static {
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
        return true;
    }

    @Override // gvb.a
    public final Map<String, String> f() {
        HashMap r0 = new HashMap();
        if (this.f == false) goto L5;
        r0.put("recording_id", this.a);
    L6:
        r0.put("status", String.valueOf(this.b.getValue()));
        Boolean r1 = this.d;
        if (r1 != null) goto L9;
    L13:
        Long r2 = this.e;
        if (r2 == null) goto L16;
        r0.put("duration_ms", String.valueOf(r2.longValue()));
    L16:
        return r0;
    L9:
        if (r1.booleanValue() == false) goto L11;
        String r3 = UserInfo.NONE_NAME_CARD_ID;
    L12:
        r0.put("save_artifact_type", r3);
        goto L13
    L11:
        r3 = "1";
        goto L12
    L5:
        r0.put("object_token", this.a);
        goto L6
    }

    @Override // gvb.a
    public final String getPath() {
        Lazy r0 = MmNetworkReqPath.a;
        return MmNetworkReqPath.c(this.c, this.f);
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
        return this.c;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return MmHttpContentType.FORM_URL_ENCODED;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return MmHttpMethod.POST;
    }

    public h(String r2, MmRecordingUpdateStatus r3, MmRecordingSource r4, Boolean r5, Long r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "recordingStatusIdentity");
        Intrinsics.checkNotNullParameter(r3, "status");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
