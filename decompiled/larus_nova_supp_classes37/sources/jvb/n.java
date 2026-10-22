package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.vfs.VFSFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n implements gvb.a {
    public final String a;
    public final String b;
    public final long c;
    public final int d;
    public final MmRecordingSource e;
    public final boolean f;
    public final Map<String, String> g;
    public final ByteString h;

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
        HashMap r0 = new HashMap();
        if (this.f == false) goto L5;
        r0.put("recording_id", this.a);
    L6:
        r0.put("start_ms", this.b);
        r0.put("duration", String.valueOf(this.c));
        r0.put("seg_id", String.valueOf(this.d));
        r0.put("recording_lang", "default");
        r0.put("recording_format", "3");
        return r0;
    L5:
        r0.put("object_token", this.a);
        goto L6
    }

    @Override // gvb.a
    public final String getPath() {
        Lazy r0 = MmNetworkReqPath.a;
        MmRecordingSource r1 = this.e;
        if (this.f == false) goto L6;
        return MmNetworkReqPath.b(r1) + "upload";
    L6:
        return MmNetworkReqPath.a(r1) + "audio/upload";
    }

    @Override // gvb.a
    public final Map<String, String> f() {
        return MapsKt.emptyMap();
    }

    @Override // gvb.a
    public final ByteString b() {
        return this.h;
    }

    @Override // gvb.a
    public final Map<String, String> e() {
        return this.g;
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

    public n(String r2, String r3, long r4, int r6, String r7, MmRecordingSource r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "uploadIdentity");
        Intrinsics.checkNotNullParameter(r3, "startTimeInMs");
        Intrinsics.checkNotNullParameter(r7, "audioPartFile");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r8;
        this.f = r9;
        okhttp3.k.a r5 = new okhttp3.k.a();
        r5.e(okhttp3.k.f);
        VFSFile r10 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r7);
        r5.b("payload", r10.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), r10.getAbsoluteFile()));
        okhttp3.k r11 = r5.d();
        String r12 = r11.a.utf8();
        Buffer r13 = new Buffer();
        HashMap r14 = new HashMap();
        r14.put("Content-Type", "multipart/form-data; boundary=" + r12);
        r14.put("Content-Length", String.valueOf(r11.contentLength()));
        r11.writeOrCountBytes(r13, false);
        ByteString.a r15 = ByteString.Companion;
        byte[] r16 = r13.readByteArray();
        byte[] r17 = Arrays.copyOf(r16, r16.length);
        r15.getClass();
        Pair r18 = TuplesKt.to(ByteString.a.c(r17), r14);
        this.h = (ByteString) r18.getFirst();
        this.g = (Map) r18.getSecond();
    }
}
