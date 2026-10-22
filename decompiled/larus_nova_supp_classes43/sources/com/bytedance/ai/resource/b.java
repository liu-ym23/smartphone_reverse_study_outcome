package com.bytedance.ai.resource;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements a.InterfaceC0047a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Continuation<Boolean> c;

    @Override // com.bytedance.ai.resource.a.InterfaceC0047a
    public final void a() {
    }

    @Override // com.bytedance.ai.resource.a.InterfaceC0047a
    public final void onFailed() {
        com.bytedance.ai.utils.g.a.i("AIPackageManager", "url: " + this.a + ", path: " + this.b + " ===> download failed");
        Continuation<Boolean> r0 = this.c;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(Boolean.FALSE));
    }

    @Override // com.bytedance.ai.resource.a.InterfaceC0047a
    public final void onSuccess() {
        com.bytedance.ai.utils.g.a.i("AIPackageManager", "url: " + this.a + ", path: " + this.b + " ===> download successful");
        Continuation<Boolean> r0 = this.c;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(Boolean.TRUE));
    }

    public b(String r1, String r10, SafeContinuation r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
