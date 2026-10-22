package com.obric.oui.bouncelayout;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lambda f12111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lambda f12112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f12113c;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function0 r5, Function0 r10) {
        Intrinsics.checkNotNullParameter(r5, "sizePxProvider");
        Intrinsics.checkNotNullParameter(r10, "effectsProvider");
        this.f12111a = (Lambda) r5;
        this.f12112b = (Lambda) r10;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public final void a() {
        b[] r5 = (b[]) this.f12112b.invoke();
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        b r12 = r5[r11];
        r11 = r11 + 1;
        if (r12 == null) goto L3;
        r12.f12099c = this.f12113c;
        goto L3
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public final void b() {
        int r5 = ((Number) this.f12111a.invoke()).intValue();
        if (r5 <= 0) goto L5;
        this.f12113c = RangesKt.coerceAtLeast(r5, 0.0f);
        a();
        return;
    L5:
        a();
    }
}
