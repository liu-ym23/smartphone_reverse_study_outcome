package xea;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ Long a;
    public final /* synthetic */ Long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Integer f;
    public final /* synthetic */ String g;

    public /* synthetic */ e(Long r1, Long r2, String r3, String r4, String r5, Integer r6, JSONObject r7, String r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d.b("obric_ttnet_api_error_event", "on monitor api error", this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }
}
