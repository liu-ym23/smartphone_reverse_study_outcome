package com.ss.android.lark.coremdbiz.facade.table;

import android.content.Context;
import com.ss.android.lark.coremd.base.parse.e;
import com.ss.android.lark.coremd.base.parse.f;
import com.ss.android.lark.coremd.base.parse.g;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.light.layout.h;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class c implements a {
    public final List<g> a;
    public final j b;
    public final List<f> c;
    public final com.ss.android.lark.coremd.base.parse.b d;

    @Override // com.ss.android.lark.coremdbiz.facade.table.a
    public final b a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        t9b.b r0 = t9b.b.a;
        com.ss.android.lark.coremd.impl.parse.b.a r3 = t9b.b.a(r2);
        c(r3, new TableCellLayoutParserFactoryImpl$newParser$parserBuilder$1(this));
        return new b(new com.ss.android.lark.coremd.impl.parse.b(r3), this);
    }

    @Override // com.ss.android.lark.coremdbiz.facade.table.a
    public final TextLayoutBuilder b(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        TextLayoutBuilder r0 = new TextLayoutBuilder();
        new h(r9, 0, 0, 0.0f, 8190).a(r0);
        return r0;
    }

    public static void c(com.ss.android.lark.coremd.impl.parse.b.a r2, Function0 r3) {
        e r4 = (e) r3.invoke();
        Iterator<T> r0 = r4.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r2.e((g) r0.next());
        goto L4
    L6:
        List<f> r1 = r4.c;
        if (r1 == null) goto L12;
        Iterator<T> r5 = r1.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r2.b((f) r5.next());
    L12:
        r2.c(r4.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends g> r2, j r3, List<? extends f> r4, com.ss.android.lark.coremd.base.parse.b r5) {
        Intrinsics.checkNotNullParameter(r2, "plugins");
        Intrinsics.checkNotNullParameter(r3, "theme");
        Intrinsics.checkNotNullParameter(r5, "outerContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
