package kh;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements bh.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f18644c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bh.b f18645b;

    static {
        HashMap r5 = new HashMap();
        f18644c = r5;
        r5.put("warmup.start", "pia_warmup_start");
        r5.put("warmup.end", "pia_warmup_end");
        r5.put("initialize.start", "pia_initialize_start");
        r5.put("request_html.start", "pia_request_html_start");
        r5.put("request_html.end", "pia_request_html_end");
        r5.put("intercept_html.start", "pia_intercept_html_start");
        r5.put("intercept_html.end", "pia_intercept_html_end");
        r5.put("manifest_parse.end", "pia_manifest_parsed");
        r5.put("request_worker.start", "pia_request_worker_start");
        r5.put("request_worker.end", "pia_request_worker_end");
    }

    public d(bh.b r5) {
        this.f18645b = r5;
    }

    @Override // bh.b
    public final void a(String r5, long r10) {
        bh.b r11 = this.f18645b;
        r11.a(r5, r10);
        String r12 = (String) f18644c.get(r5);
        if (r12 == null) goto L6;
        r11.a(r12, r10);
        return;
    }

    @Override // bh.b
    public final void a(String r5, Object r10) {
        this.f18645b.a(r5, r10);
    }
}
