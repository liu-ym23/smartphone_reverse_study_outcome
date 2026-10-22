package g5;

import com.lynx.tasm.LynxEnv;
import org.json.JSONObject;
import x4.h;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f17050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f17051k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f17052l;

    public b() {
        this.f17051k = "";
        this.f17052l = LynxEnv.inst().getLynxVersion();
        this.f22975c = "lynx";
    }

    @Override // x4.h, sj.g
    public final void m(JSONObject r5) {
        super.m(r5);
        qo.a.e(this.f17050j, "template_state", r5);
        qo.a.t("lynx_version", this.f17052l, r5);
        qo.a.t("page_version", this.f17051k, r5);
    }
}
