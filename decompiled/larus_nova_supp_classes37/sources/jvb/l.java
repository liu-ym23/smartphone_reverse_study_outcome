package jvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.MmNetworkReqPath;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpContentType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpMethod;
import com.ss.android.lark.profile.v2.entity.UserInfo;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l implements gvb.a {
    public final boolean a;
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
    public final Map<String, String> f() {
        Pair[] r0 = new Pair[2];
        String r2 = "1";
        r0[0] = TuplesKt.to("option_type", "1");
        if (this.a == false) goto L5;
        r2 = UserInfo.NONE_NAME_CARD_ID;
    L5:
        r0[1] = TuplesKt.to("default_option", r2);
        return MapsKt.mapOf(r0);
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
        return MmRecordingSource.FEISHU_HARDWARE_D1204;
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

    public l(boolean r2) {
        this.a = r2;
        Lazy r3 = MmNetworkReqPath.a;
        this.b = MmNetworkReqPath.a(MmRecordingSource.FEISHU_HARDWARE_D1204) + "set-default-option";
        this.c = MmHttpMethod.POST;
    }
}
