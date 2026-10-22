package com.bytedance.forest.utils;

import com.lynx.tasm.ui.image.f0;
import java.util.Date;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f4607c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ HashMap f4608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Throwable f4609i;

    public b(d r5, long r10, Ref.ObjectRef r11, int r12, String r13, boolean r14, String r15, HashMap r16, Throwable r17) {
        this.f4605a = r5;
        this.f4606b = r10;
        this.f4607c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f4608h = r16;
        this.f4609i = r17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, java.lang.String] */
    @Override // java.lang.Runnable
    public final void run() {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        Object r10 = Result.m124constructorimpl(d.e.format(new Date(this.f4606b)));     // Catch: Throwable -> L4
    L7:
        if (Result.m130isFailureimpl(r10) == false) goto L9;
        r10 = null;
    L9:
        String r11 = (String) r10;
        if (r11 != null) goto L13;
        r11 = "";
    L13:
        StringBuilder r12 = new StringBuilder("[");
        r12.append(r11);
        r12.append(']');
        Ref.ObjectRef r13 = this.f4607c;
        r12.append((String) r13.element);
        ?? r14 = r12.toString();
        r13.element = r14;
        HashMap r15 = this.f4608h;
        d r16 = this.f4605a;
        int r17 = this.d;
        if (r17 != 3) goto L16;
        Function3 r18 = r16.f4616a;
        f0.k(this.e, r14, this.f, r18, this.g, r15);
        return;
    L16:
        if (r17 == 4) goto L18;
        Function3 r19 = r16.f4616a;
        Throwable r20 = this.f4609i;
        boolean r21 = this.f;
        f0.j(this.e, r14, r20, r21, r19, this.g, r15);
        return;
    L18:
        Function3 r22 = r16.f4616a;
        f0.o(this.e, r14, this.f, r22, this.g, r15);
        return;
    L4:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r10 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
