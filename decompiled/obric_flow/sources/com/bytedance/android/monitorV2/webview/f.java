package com.bytedance.android.monitorV2.webview;

import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher$DataType;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f3774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.monitorV2.dataprocessor.b f3775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TypedDataDispatcher$DataType f3776c;

    public f(c r5) {
        Intrinsics.checkNotNullParameter(r5, "mNavigation");
        this.f3774a = r5;
        com.bytedance.android.monitorV2.dataprocessor.b r10 = new com.bytedance.android.monitorV2.dataprocessor.b();
        this.f3775b = r10;
        TypedDataDispatcher$DataType r11 = TypedDataDispatcher$DataType.f3525a;
        this.f3776c = r11;
        e r12 = new e(this);
        Intrinsics.checkNotNullParameter(r11, "dataType");
        Intrinsics.checkNotNullParameter(r12, "dataProcessor");
        r10.f3533b.put(r11, r12);
    }

    public final void a(com.bytedance.android.monitorV2.event.d r5) {
        c r10 = this.f3774a;
        b r11 = (b) r10.f3754a.e.getValue();
        if (r11 == null) goto L7;
        JSONObject r12 = r11.g;
        if (r12 == null) goto L7;
        qo.a.q(r5.f.g, r12);
    L7:
        x4.h r13 = r5.f;
        b r14 = (b) r10.f3754a.e.getValue();
        String r15 = null;
        r13.f = null;
        if (StringsKt.isBlank(r10.f3754a.f3781c) == false) goto L19;
        b r16 = (b) r10.f3754a.e.getValue();
        if (r16 == null) goto L20;
        String r17 = r16.e;
        if (r17 != null) goto L14;
        return;
    L14:
        if (StringsKt.isBlank(r17) == true) goto L16;
        r15 = r17;
    L16:
        if (r15 == null) goto L22;
        r5.f3560h = new x4.a(0, MapsKt.mapOf(TuplesKt.to("container_name", "AnnieX")));
        return;
    L22:
        return;
    L20:
        return;
    }
}
