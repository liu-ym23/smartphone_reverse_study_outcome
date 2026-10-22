package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements gvb.a {
    public final a a;
    public final boolean b;
    public final MmRecordingSource c;

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
        return new HashMap();
    }

    @Override // gvb.a
    public final Map<String, String> f() {
        a r0 = this.a;
        if ((r0 instanceof a.b) == false) goto L6;
        String r1 = "recording_id";
    L8:
        Pair[] r2 = new Pair[3];
        r2[0] = TuplesKt.to(r1, r0.a());
        r2[1] = TuplesKt.to("status", "5");
        if (this.b == false) goto L11;
        String r3 = UserInfo.NONE_NAME_CARD_ID;
    L12:
        r2[2] = TuplesKt.to("save_audio_type", r3);
        return MapsKt.hashMapOf(r2);
    L11:
        r3 = "1";
        goto L12
    L6:
        if ((r0 instanceof a.C0156a) == false) goto L15;
        r1 = "object_token";
        goto L8
    L15:
        throw new NoWhenBranchMatchedException();
    }

    @Override // gvb.a
    public final String getPath() {
        Lazy r0 = MmNetworkReqPath.a;
        return MmNetworkReqPath.c(this.c, this.a instanceof a.b);
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

    public k(a r2, boolean r3, MmRecordingSource r4) {
        Intrinsics.checkNotNullParameter(r2, "audioSaveIdentity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
