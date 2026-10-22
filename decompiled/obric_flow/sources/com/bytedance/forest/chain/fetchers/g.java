package com.bytedance.forest.chain.fetchers;

import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GeckoFetcher f4293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Request f4294c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ w e;
    public final /* synthetic */ com.bytedance.forest.model.l f;
    public final /* synthetic */ Function1 g;

    public g(GeckoFetcher r5, Request r10, boolean r11, w r12, com.bytedance.forest.model.l r13, Function1 r14) {
        this.f4293b = r5;
        this.f4294c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
    }

    @Override // com.bytedance.forest.chain.fetchers.m
    public final void a(String r17, Long r18) {
        if (this.f4292a == false) goto L5;
        return;
    L5:
        this.f4292a = true;
        GeckoFetcher r5 = this.f4293b;
        r5.getContext$forest_release().b(new String[]{"gecko_update_finish"});
        com.bytedance.forest.utils.d r10 = r5.getContext$forest_release().g;
        StringBuilder r11 = new StringBuilder("download success with waitGeckoUpdate=");
        Request r12 = this.f4294c;
        r11.append(r12.getWaitGeckoUpdate());
        r11.append(" , channel=");
        r11.append(r17);
        r11.append(",bundle=");
        r11.append(r12.getGeckoModel().f4391c);
        com.bytedance.forest.utils.d.b(r10, 3, GeckoFetcher.TAG, r11.toString(), true, null, "gecko_update_finish", 16);
        if (this.d == false) goto L9;
        com.bytedance.forest.utils.d.b(r5.getContext$forest_release().g, 3, GeckoFetcher.TAG, "success, skip callbacks when onlyLocal is true", false, null, null, 56);
        return;
    L9:
        Function0<Unit> r15 = new GeckoFetcher$pullGeckoPackage$1$onUpdateSuccess$1(this);
        w r13 = this.e;
        com.bytedance.forest.model.l r14 = this.f;
        GeckoFetcher.access$loadGeckoFile(this.f4293b, this.f4294c, r13, false, r18, r14, r15);
    }

    @Override // com.bytedance.forest.chain.fetchers.m
    public final void a(String r17, Throwable r18) {
        if (this.f4292a == false) goto L5;
        return;
    L5:
        this.f4292a = true;
        GeckoFetcher r5 = this.f4293b;
        r5.getContext$forest_release().b(new String[]{"gecko_update_finish"});
        com.bytedance.forest.utils.d r10 = r5.getContext$forest_release().g;
        StringBuilder r11 = new StringBuilder("download failed with waitGeckoUpdate=");
        Request r12 = this.f4294c;
        r11.append(r12.getWaitGeckoUpdate());
        r11.append(" ,channel = ");
        r11.append(r17);
        r11.append(",bundle = ");
        r11.append(r12.getGeckoModel().f4391c);
        r11.append(',');
        r11.append(r18.getMessage());
        com.bytedance.forest.utils.d.b(r10, 6, GeckoFetcher.TAG, r11.toString(), true, null, "gecko_update_finish", 16);
        com.bytedance.forest.model.c r13 = this.e.s;
        ErrorInfo$Type r14 = ErrorInfo$Type.f4311c;
        String r15 = "CheckUpdate Failed:" + r18.getMessage();
        r13.getClass();
        r13.f4360a += r13.a(r14, 5, r15);
        if (this.d == false) goto L9;
        com.bytedance.forest.utils.d.b(r5.getContext$forest_release().g, 3, GeckoFetcher.TAG, "failed, skip callbacks when onlyLocal is true", false, null, null, 56);
        return;
    L9:
        Function0<Unit> r16 = new GeckoFetcher$pullGeckoPackage$1$onUpdateFailed$1(this);
        GeckoFetcher.access$loadGeckoFile(this.f4293b, this.f4294c, this.e, false, null, this.f, r16);
    }
}
