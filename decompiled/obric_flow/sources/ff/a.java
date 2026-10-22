package ff;

import com.bytedance.iesgurd.core.ReqType;
import com.lynx.tasm.utils.d;
import com.lynx.tasm.utils.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16895c;
    public String d;
    public boolean e;
    public ReqType f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f16896h;

    public final void a() {
        JSONObject r5 = d.k("api_version", "settings_v3");
        r5.put("http_status", this.f16893a);
        r5.put("err_msg", this.f16895c);
        r5.put("req_type", this.f.getType());
        r5.put("err_code", this.f16894b);
        r5.put("x_tlb_probe", null);
        r5.put("local_version", this.f16896h);
        r5.put("version", this.g);
        String r10 = this.d;
        if (r10 == null) goto L9;
        if (r10.length() == 0) goto L9;
        r5.put("x_tt_logid", this.d);
    L9:
        if (this.e == false) goto L11;
        r5.put("is_retry", 1);
    L11:
        j.g("geckosdk_query_settings", r5);
    }
}
