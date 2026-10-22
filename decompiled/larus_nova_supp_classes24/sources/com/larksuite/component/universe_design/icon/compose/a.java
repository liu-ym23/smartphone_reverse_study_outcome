package com.larksuite.component.universe_design.icon.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final Function2<Composer, Integer, Painter> a;

    public a(String r2, UDIconStyle r3, String r4, Function2<? super Composer, ? super Integer, ? extends Painter> r5) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "style");
        Intrinsics.checkNotNullParameter(r4, "resourceName");
        Intrinsics.checkNotNullParameter(r5, "painterProvider");
        this.a = r5;
    }
}
