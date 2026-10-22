package com.bytedance.android.monitorV2.webview;

import android.net.Uri;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f3821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3822c;
    public final String d;
    public final String e;

    public s(String r5) {
        this.f3820a = r5;
        this.f3821b = LazyKt.lazy(WebViewRootManager$weiViewStack$2.f3746a);
        this.f3822c = "rifle";
        this.d = "navigationStart";
        this.e = "res_loader_perf";
    }

    public final void a(m5.a r5, String r10, c r11) {
        r5.f19982k = "web";
        Uri.Builder r12 = Uri.parse(r10).buildUpon();
        r12.clearQuery();
        r5.f19983l = r12.build().toString();
        r5.f19984m = r10;
        Lazy r13 = this.f3821b;
        String r14 = null;
        if (((LinkedBlockingDeque) r13.getValue()).size() < 1) goto L5;
        String r15 = (String) ((LinkedBlockingDeque) r13.getValue()).getFirst();
    L6:
        r5.f19985n = r15;
        if (((LinkedBlockingDeque) r13.getValue()).size() <= 1) goto L9;
        r14 = (String) CollectionsKt.j((LinkedBlockingDeque) r13.getValue(), ((LinkedBlockingDeque) r13.getValue()).size() - 2);
    L9:
        r5.f19986o = r14;
        if (r11 == null) goto L12;
        r5.f22974b = r11.g.f22974b;
    L12:
        r5.f19987p = this.f3820a;
        return;
    L5:
        r15 = null;
        goto L6
    }
}
