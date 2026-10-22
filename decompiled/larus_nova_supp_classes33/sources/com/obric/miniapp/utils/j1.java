package com.obric.miniapp.utils;

import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j1 {
    public final WidgetContainer a;
    public final Map<ot8.a, Function1<WidgetContainer, Unit>> b;

    public j1(WidgetContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "widgetContainer");
        this.a = r2;
        this.b = new LinkedHashMap();
    }
}
