package com.ss.android.lark.coremd.impl.parse;

import android.view.View;
import com.ss.android.lark.coremd.base.parse.z;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MarkdownSpanSetterImpl$bindNodeClick$span$1 extends FunctionReferenceImpl implements Function1<View, z<View>> {
    public MarkdownSpanSetterImpl$bindNodeClick$span$1(Object r8) {
        super(1, r8, g.class, "findAdaptersForViewType", "findAdaptersForViewType(Landroid/view/View;)Lcom/ss/android/lark/coremd/base/parse/TextViewAdapter;", 0);
    }

    public final z<View> invoke(View r6) {
        Intrinsics.checkNotNullParameter(r6, "p0");
        g r0 = (g) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "view");
        Class<?> r7 = r6.getClass();
        z<View> r1 = r0.b.get(r7);
        if (r1 != null) goto L19;
        Iterator<T> r2 = r0.b.keySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        if (((Class) r3).isAssignableFrom(r7) == false) goto L6;
    L11:
        Class r4 = (Class) r3;
        if (r4 == null) goto L15;
        return r0.b.get(r4);
    L15:
        return null;
    L10:
        r3 = null;
        goto L11
    L19:
        return r1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }
}
