package com.bytedance.pia.nsr;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.PriorityQueue;
import ko.r;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f7185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ yg.b f7186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f7187c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ g e;

    public e(f r5, yg.b r10, long r11, boolean r12, g r13) {
        this.f7185a = r5;
        this.f7186b = r10;
        this.f7187c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // fh.a
    public final void accept(Object r10) {
        JsonObject r11 = (JsonObject) r10;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m124constructorimpl(r11.get("html").getAsString());     // Catch: Throwable -> L5
    L8:
        if (Result.m130isFailureimpl(r12) == false) goto L10;
        r12 = null;
    L10:
        String r13 = (String) r12;
        if (TextUtils.isEmpty(r13) == false) goto L13;
        this.f7185a.a("Save empty result");
        return;
    L13:
        r r14 = h.f7194a;
        String r15 = this.f7186b.f23260a.toString();
        Intrinsics.checkNotNull(r13);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "url");
        Intrinsics.checkNotNullParameter(r13, "result");
        i r16 = com.lynx.tasm.base.a.c(r15);
        if (r16 == null) goto L23;
        r14.i();
        HashMap r17 = (HashMap) r14.f18728b;
        boolean r18 = r17.containsKey(r16);
        PriorityQueue r19 = (PriorityQueue) r14.f18729c;
        if (r18 == false) goto L20;
        Intrinsics.checkNotNullParameter(r16, "entry");
        r17.remove(r16);
        CollectionsKt.x(r19, new RecordsCache$remove$1(r16));
    L20:
        if (r19.size() != 10) goto L22;
        r17.remove(((Pair) r19.poll()).getSecond());
    L22:
        r19.add(new Pair(Long.valueOf(System.currentTimeMillis() + this.f7187c), r16));
        r17.put(r16, new j(this.d, r13));
    L23:
        this.e.a(r13, true);
        return;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
