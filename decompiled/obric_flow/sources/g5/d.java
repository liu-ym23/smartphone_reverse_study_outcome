package g5;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends t4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17057c;
    public String d;

    public d() {
        super("nativeError");
        this.f17056b = "lynx_error";
    }

    @Override // sj.g
    public final void m(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObject");
        qo.a.t("scene", this.f17056b, r5);
        qo.a.e(this.f17057c, WsConstants.ERROR_CODE, r5);
        qo.a.t("error_msg", this.d, r5);
    }
}
