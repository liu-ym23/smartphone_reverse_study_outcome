package com.ss.android.lark.myai.chat.quickactions;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class QuickActionsTemplateFormatter {
    public final Lazy a;
    public final Lazy b;
    public final IntRange c;
    public final IntRange d;
    public final IntRange e;
    public final IntRange f;
    public final IntRange g;
    public final IntRange h;

    public static final class a {
    }

    static {
    }

    public QuickActionsTemplateFormatter() {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        Lazy r1 = LazyKt.lazy(r0, QuickActionsTemplateFormatter$quickActionParamTemplate$2.INSTANCE);
        this.a = r1;
        Lazy r2 = LazyKt.lazy(r0, QuickActionsTemplateFormatter$quickActionTemplate$2.INSTANCE);
        this.b = r2;
        int r3 = StringsKt.indexOf$default((String) r1.getValue(), "{value}", 0, false, 6, null);
        int r4 = StringsKt.indexOf$default((String) r2.getValue(), "{content}", 0, false, 6, null);
        this.c = new IntRange(0, 11);
        this.d = new IntRange(0, r3);
        this.e = new IntRange(r3, r3 + 7);
        this.f = new IntRange(0, 9);
        this.g = new IntRange(0, r4);
        this.h = new IntRange(r4, r4 + 9);
    }
}
