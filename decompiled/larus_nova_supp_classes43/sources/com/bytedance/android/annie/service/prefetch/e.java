package com.bytedance.android.annie.service.prefetch;

import com.bytedance.android.annie.param.ReadonlyJSONObjectMap;
import com.bytedance.android.annie.param.UtilsKt;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e<V> implements Callable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ String c;
    public final /* synthetic */ d d;

    public e(JSONObject r1, JSONObject r10, String r11, d r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }

    @Override // java.util.concurrent.Callable
    public final Pair<JSONObject, Object> call() {
        JSONObject r0 = this.a;
        JSONObject r1 = this.b;
        Lazy r10 = UtilsKt.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (r1 == null) goto L6;
        JSONObject r11 = new JSONObject();
        UtilsKt.e(r0, r11, r1);
        r0 = r11;
    L6:
        String r12 = this.c;
        if (r12 != null) goto L9;
    L12:
        boolean r13 = true;
    L13:
        if (r13 == true) goto L17;
        r9.d r14 = this.d.e;
        if (r14 == null) goto L17;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Object r15 = r14.L(new ReadonlyJSONObjectMap(r0), this.c);
    L19:
        return new Pair(r0, r15);
    L17:
        r15 = null;
        goto L19
    L9:
        if (StringsKt.isBlank(r12) == true) goto L12;
        r13 = false;
        goto L13
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
