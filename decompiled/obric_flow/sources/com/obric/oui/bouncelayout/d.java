package com.obric.oui.bouncelayout;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lambda f12114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f12115b;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function0 r5, Function0 r10) {
        Intrinsics.checkNotNullParameter(r5, "getTotalTranslation");
        Intrinsics.checkNotNullParameter(r10, "effectsProvider");
        this.f12114a = (Lambda) r10;
        new BounceTranslationDelegate$callback$1(this);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public final void a() {
        b[] r5 = (b[]) this.f12114a.invoke();
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        b r12 = r5[r11];
        r11 = r11 + 1;
        goto L3
    }
}
