package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import yoc.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FloatingCardItem<Card extends yoc.c> {
    public static final /* synthetic */ int h = 0;
    public final Card a;
    public final Context b;
    public final Lazy c;
    public final Lazy d;
    public final String e;
    public final int f;
    public final String g;

    public static final class a {
        public static String a(yoc.c r2) {
            Intrinsics.checkNotNullParameter(r2, "card");
            return r2.getType() + '_' + r2.getId();
        }
    }

    static {
    }

    public final Context getContext() {
        return this.b;
    }

    public FloatingCardItem(Card r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "card");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.NONE;
        this.c = LazyKt.lazy(r4, new FloatingCardItem$view$2(this));
        this.d = LazyKt.lazy(r4, new FloatingCardItem$lazyView$2(this));
        this.e = a.a(r2);
        this.f = r2.getType();
        this.g = r2.getId();
    }
}
