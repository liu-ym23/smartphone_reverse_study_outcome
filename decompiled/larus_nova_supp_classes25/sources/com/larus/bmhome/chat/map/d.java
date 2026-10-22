package com.larus.bmhome.chat.map;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.SsResponse;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wq9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements Callback<String> {
    public final /* synthetic */ Function1<List<a>, Unit> a;

    public d(l r1) {
        this.a = r1;
    }

    public final void onFailure(Call<String> r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "call");
        Intrinsics.checkNotNullParameter(r3, "t");
        this.a.invoke(null);
    }

    public final void onResponse(Call<String> r11, SsResponse<String> r12) {
        Intrinsics.checkNotNullParameter(r11, "call");
        Intrinsics.checkNotNullParameter(r12, "response");
        Gson r13 = e.a;
        Object r14 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L20
        DriveRouteSearchResult r15 = (DriveRouteSearchResult) e.a.fromJson((String) r12.body(), DriveRouteSearchResult.class);     // Catch: Throwable -> L20
        if (r15 == null) goto L27;
        Iterator<T> r16 = r15.getRoute().getPaths().iterator();     // Catch: Throwable -> L20
    L8:
        if (r16.hasNext() == false) goto L18;
        Iterator<T> r2 = ((DrivePath) r16.next()).getSteps().iterator();     // Catch: Throwable -> L20
    L11:
        if (r2.hasNext() == false) goto L8;
        Iterator r3 = StringsKt.split$default(((Step) r2.next()).getPolyline(), new String[]{";"}, false, 0, 6, null).iterator();     // Catch: Throwable -> L20
    L14:
        if (r3.hasNext() == false) goto L11;
        List r4 = StringsKt.split$default((String) r3.next(), new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L20
        if (r4.size() != 2) goto L14;
        r1.add(new a(CastDoubleProtector.parseDouble((String) ListProtector.get(r4, 1)), CastDoubleProtector.parseDouble((String) ListProtector.get(r4, 0))));     // Catch: Throwable -> L20
        goto L14
    L18:
        Object r17 = Result.constructor-impl(r1);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r17) == true) goto L26;
        r14 = r17;
    L26:
        r14 = (List) r14;
    L27:
        this.a.invoke(r14);
        return;
    L20:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
