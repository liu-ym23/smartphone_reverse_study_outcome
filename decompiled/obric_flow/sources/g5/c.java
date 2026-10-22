package g5;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sj.g;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f17053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f17054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17055c;
    public long d;
    public long e;
    public long f;
    public int g;

    @Override // sj.g
    public final void m(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        qo.a.k("load_start", this.f17053a, r10);
        qo.a.k("load_finish", this.f17054b, r10);
        qo.a.k("load_failed", 0, r10);
        qo.a.k("show_start", this.f17055c, r10);
        qo.a.k("show_end", this.d, r10);
        qo.a.k("receive_error", 0, r10);
        qo.a.k("first_screen", this.e, r10);
        qo.a.k("runtime_ready", this.f, r10);
    }
}
