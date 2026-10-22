package xub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.MmMinutesCreateSource;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements gvb.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final MmRecordingSource h;
    public final String i;
    public final MmHttpMethod j;
    public final MmHttpContentType k;

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
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(AppbrandHostConstants.Schema_Meta.NAME, this.a);
        r0.put("file_size", this.b);
        r0.put("file_header", this.c);
        r0.put("drive_upload", "true");
        r0.put("upload_token", this.d);
        MmMinutesCreateSource r1 = ivb.a.a(this.h);
        if (r1 == null) goto L5;
        String r2 = Integer.valueOf(r1.getValue()).toString();
    L6:
        if (r2 == null) goto L8;
        r0.put("create_source", r2);
    L8:
        String r3 = this.e;
        boolean r4 = false;
        if (r3 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L17;
        r0.put("upload_unique_id", this.e);
    L17:
        String r6 = this.f;
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L26;
        r0.put("ext_data", this.f);
    L26:
        String r8 = this.g;
        if (r8 != null) goto L29;
    L30:
        r4 = true;
    L31:
        if (r4 == true) goto L33;
        r0.put("doubao_biz_info", this.g);
    L33:
        return r0;
    L29:
        if (r8.length() != 0) goto L31;
    L20:
        if (r6.length() == 0) goto L23;
        r7 = false;
        goto L24
    L11:
        if (r3.length() == 0) goto L14;
        r5 = false;
        goto L15
    L5:
        r2 = null;
        goto L6
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
        return this.h;
    }

    @Override // gvb.a
    public final MmHttpContentType getContentType() {
        return this.k;
    }

    @Override // gvb.a
    public final MmHttpMethod getMethod() {
        return this.j;
    }

    @Override // gvb.a
    public final String getPath() {
        return this.i;
    }

    public c(String r2, String r3, String r4, String r5, String r6, String r7, String r8, MmRecordingSource r9) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r3, "fileSize");
        Intrinsics.checkNotNullParameter(r4, "fileHeader");
        Intrinsics.checkNotNullParameter(r5, "uploadToken");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        Lazy r10 = MmNetworkReqPath.a;
        this.i = MmNetworkReqPath.a(r9) + "upload/prepare";
        this.j = MmHttpMethod.POST;
        this.k = MmHttpContentType.JSON;
    }
}
