package com.ss.android.lark.chat.message.menu.context;

import aec.d;
import aec.e;
import android.graphics.Point;
import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import yya.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class HiveMessageListActionItemHook implements n {
    public final aec.c<?, ?> a;
    public final d b;
    public final Lazy c;

    public final Point c() {
        return null;
    }

    public final View a() {
        return ((e) this.b).a;
    }

    public final int b() {
        return ((e) this.b).b.getLayoutPosition();
    }

    public final void d() {
        View r0 = ((e) this.b).a.findViewById(2131365562);
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public final void f() {
        View r0 = ((e) this.b).a.findViewById(2131365562);
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    public final View o0() {
        View r0 = ((e) this.b).a.findViewById(2131364905);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ((e) this.b).a;
    }

    public HiveMessageListActionItemHook(aec.c<?, ?> r2, d r3, y6b.a<?> r4) {
        Intrinsics.checkNotNullParameter(r2, "hiveGroupCell");
        Intrinsics.checkNotNullParameter(r3, "hiveGroupHolder");
        Intrinsics.checkNotNullParameter(r4, "item");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new HiveMessageListActionItemHook$messageCellHiveHolder$2(this));
    }
}
