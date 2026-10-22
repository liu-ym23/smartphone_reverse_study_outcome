package com.bytedance.forest.utils;

import com.lynx.tasm.ui.image.f0;
import java.util.Date;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4612c;
    public final /* synthetic */ Lambda d;
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f4613h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ HashMap f4614i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Throwable f4615j;

    /* JADX WARN: Multi-variable type inference failed */
    public c(d r5, long r10, String r11, Function0 r12, int r13, String r14, boolean r15, String r16, HashMap r17, Throwable r18) {
        this.f4610a = r5;
        this.f4611b = r10;
        this.f4612c = r11;
        this.d = (Lambda) r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f4613h = r16;
        this.f4614i = r17;
        this.f4615j = r18;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // java.lang.Runnable
    public final void run() {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        Object r10 = Result.m124constructorimpl(d.e.format(new Date(this.f4611b)));     // Catch: Throwable -> L4
    L7:
        if (Result.m130isFailureimpl(r10) == false) goto L9;
        r10 = null;
    L9:
        String r11 = (String) r10;
        if (r11 != null) goto L13;
        r11 = "";
    L13:
        String r12 = "[" + r11 + ']' + this.f4612c + ((String) this.d.invoke());
        String r13 = this.f;
        HashMap r14 = this.f4614i;
        d r15 = this.f4610a;
        int r16 = this.e;
        if (r16 != 3) goto L16;
        f0.k(r13, r12, this.g, r15.f4616a, this.f4613h, r14);
        return;
    L16:
        if (r16 == 4) goto L18;
        f0.j(r13, r12, this.f4615j, this.g, r15.f4616a, this.f4613h, r14);
        return;
    L18:
        f0.o(r13, r12, this.g, r15.f4616a, this.f4613h, r14);
        return;
    L4:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r10 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
