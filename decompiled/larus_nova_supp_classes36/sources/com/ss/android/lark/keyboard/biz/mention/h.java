package com.ss.android.lark.keyboard.biz.mention;

import android.text.Editable;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h extends com.ss.android.lark.keyboard.edittext2.edittors.at.a<g> implements com.ss.android.lark.keyboard.edittext2.edittors.at.b<hob.c> {
    public static final /* synthetic */ int e = 0;
    public final com.ss.android.lark.keyboard.edittext2.edittors.a c;
    public final g d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.b
    public final void b() {
        f(new FetchAllAtSpanHolder$prepareSpan$1(this, this.d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.a, com.ss.android.lark.keyboard.edittext2.edittors.at.d
    public final void c(FunctionEditText r8) {
        Intrinsics.checkNotNullParameter(r8, "editText");
        Editable r0 = r8.getEditableText();
        Intrinsics.checkNotNull(r0);
        Pair<Integer, Integer> r1 = g(r0);
        int r2 = ((Number) r1.component1()).intValue();
        int r3 = ((Number) r1.component2()).intValue();
        String r4 = f.a;
        g r5 = this.d;
        f.a(r5, r5.a);
        r0.setSpan(e(this.c).component2(), r2, r3, 33);
        com.ss.android.lark.keyboard.edittext2.edittors.at.a.j(this.d);
        RichTextElement.AtProperty r6 = this.d.g;
        if (r6 == null) goto L6;
        r0.setSpan(new p(RichTextElementCreator.h(r6), r0.subSequence(r2, r3).toString()), r2, r3, 33);
        super.c(r8);
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.b
    public final void d(hob.c r2) {
        hob.c r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "result");
        f(new FetchAllAtSpanHolder$prepareSpan$1(this, r3));
    }

    public h(FetchAllDataAtStrategy.b r2, com.ss.android.lark.keyboard.edittext2.edittors.a r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        Intrinsics.checkNotNullParameter(r3, "editor");
        Intrinsics.checkNotNullParameter(r4, "data");
        super(r4, "FetchAllAtSpanHolder");
        this.c = r3;
        this.d = r4;
        if (r4.e == false) goto L5;
        Log.i("FetchAllAtSpanHolder", "at chatter is anonymous and not load chatter");
        return;
    L5:
        r2.a(r4, this);
    }
}
