package ua8;

import android.view.View;
import android.view.ViewGroup;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import jc8.d;
import jc8.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import lw8.l;
import zc9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c extends jc8.b<b> {
    public a d;

    @Override // jc8.b
    public final String c() {
        return "BasicTextBlockHolder";
    }

    @Override // jc8.b
    public final void i() {
        a r0 = this.d;
        if (r0 == null) goto L5;
        r0.setText(null);
    L5:
        this.d = null;
    }

    public c() {
    }

    @Override // jc8.b
    public final d f(jc8.a r2) {
        b r3 = (b) r2;
        Intrinsics.checkNotNullParameter(r3, "blockModel");
        return e.d(r3);
    }

    @Override // jc8.b
    public final void g(jc8.a r34) {
        b r0 = (b) r34;
        Intrinsics.checkNotNullParameter(r0, "blockModel");
        a r2 = this.d;
        if (r2 == null) goto L36;
        BlockContent r3 = r0.a.getContent();
        Object r4 = null;
        if (r3 == null) goto L9;
        TextBlock r5 = r3.getTextBlock();
        if (r5 == null) goto L9;
        String r6 = h.a(r5, r0.a.getBlockId(), r0.a.getMetaInfo());
    L10:
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        Boolean r7 = r0.e.e;
        if (r7 == null) goto L15;
        boolean r1 = r7.booleanValue();
    L16:
        Intrinsics.checkNotNullParameter(r6, "markdown");
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L23
        gw8.c.a.getClass();     // Catch: Throwable -> L23
        gw8.c r9 = gw8.c.a.b();     // Catch: Throwable -> L23
        if (r9 == null) goto L20;
        l r10 = gw8.c.b.b(r9, r2, r6, r1, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31));     // Catch: Throwable -> L23
    L21:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r11) == true) goto L29;
        r4 = r11;
    L29:
        l r12 = (l) r4;
        if (r12 != null) goto L32;
        r2.setText(r6);
        return;
    L32:
        r2.a = r12;
        r2.setText(r12.e());
        return;
    L20:
        r10 = null;
    L23:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L15:
        r1 = r0.a.isFinish();
    L9:
        r6 = null;
        goto L10
    }

    @Override // jc8.b
    public final View h(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "viewGroup");
        a r0 = new a(r2);
        this.d = r0;
        return r0;
    }
}
