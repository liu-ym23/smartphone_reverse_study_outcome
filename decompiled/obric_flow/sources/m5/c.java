package m5;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends t4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f19998c;

    public c(String r5, JSONObject r10) {
        this.f19997b = 1;
        Intrinsics.checkNotNullParameter(r5, "eventType");
        Intrinsics.checkNotNullParameter(r10, "data");
        super(r5);
        this.f19998c = r10;
    }

    @Override // sj.g
    public final void m(JSONObject r5) {
        switch(this.f19997b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        qo.a.m(r5, (JSONObject) this.f19998c);
        return;
    L6:
        d r10 = (d) this.f19998c;
        qo.a.k("page_start", r10.e, r5);
        qo.a.k("page_finish", r10.f, r5);
        qo.a.k("page_progress_100", r10.g, r5);
        qo.a.k("show_start", r10.f20003i, r5);
        qo.a.k("show_end", r10.f20004j, r5);
        if (r10.f20006l == false) goto L9;
        qo.a.k("init_time", r10.f20005k, r5);
    L9:
        qo.a.k("inject_js_time", r10.f20002h, r5);
        qo.a.j(r10.f20008n, "event_counts", r5);
        qo.a.k("load_start", r10.f19999a.f19993j, r5);
        qo.a.j(Boolean.valueOf(r10.f20007m), "is_first_page_started", r5);
        qo.a.j(r10.f20010p, "ttwebview_timing", r5);
    }

    public c(d r5) {
        this.f19997b = 0;
        this.f19998c = r5;
        super("performance");
    }
}
