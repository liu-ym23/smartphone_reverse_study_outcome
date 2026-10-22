package com.bytedance.apm;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3858c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3859h;

    public /* synthetic */ c(long r5, long r10, String r11, String r12, String r13, int r14, JSONObject r15, int r16) {
        this.f3856a = r16;
        this.f3857b = r5;
        this.f3858c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.f3859h = r15;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3856a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        i6.c r5 = i6.b.f17505a;
        JSONObject r11 = ApmAgent.access$000(this.f3859h, false);
        r5.b(new j6.a("api_error", this.f3857b, this.f3858c, this.d, this.e, this.f, this.g, r11));
        return;
    L6:
        i6.c r10 = i6.b.f17505a;
        JSONObject r12 = ApmAgent.access$000(this.f3859h, false);
        r10.b(new j6.a("api_all", this.f3857b, this.f3858c, this.d, this.e, this.f, this.g, r12));
        return;
    L8:
        i6.c r13 = i6.b.f17505a;
        JSONObject r14 = ApmAgent.access$000(this.f3859h, false);
        r13.b(new j6.a("api_error", this.f3857b, this.f3858c, this.d, this.e, this.f, this.g, r14));
        return;
    L10:
        i6.c r15 = i6.b.f17505a;
        JSONObject r16 = ApmAgent.access$000(this.f3859h, false);
        r15.b(new j6.a("api_all", this.f3857b, this.f3858c, this.d, this.e, this.f, this.g, r16));
    }
}
