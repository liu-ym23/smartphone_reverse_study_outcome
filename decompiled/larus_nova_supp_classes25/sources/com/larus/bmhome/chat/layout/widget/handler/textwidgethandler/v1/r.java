package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.larus.business.markdown.api.FullScreenDetailType;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r implements gw8.a {
    public final /* synthetic */ l a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ TextView c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FullScreenDetailType.values().length];
            r0[FullScreenDetailType.CODE_BLOCK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[FullScreenDetailType.TABLE_BLOCK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final void a(View r2, com.larus.business.markdown.impl.markwon.custom.title.c r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "span");
        if (r3.e == true) goto L6;
        FLogger.a.i("MarkdownTextViewWidgetHandlerV2", "FullScreenDetailSpanClickListener is uncompleted");
        return;
    L6:
        FullScreenDetailType r4 = r3.getType();
        int r5 = a.a[r4.ordinal()];
        if (r5 != 1) goto L9;
        l r6 = this.a;
        fh8.r r0 = r6.d;
        if (r0 == null) goto L23;
        Function2<Context, gw8.b, Unit> r1 = r0.c;
        if (r1 == null) goto L23;
        r1.invoke(this.b, r3);
    L24:
        l r7 = this.a;
        fh8.r r8 = r7.d;
        if (r8 == null) goto L29;
        Function2<gw8.b, View, Unit> r9 = r8.e;
        if (r9 == null) goto L29;
        r9.invoke(r3, this.c);
        return;
    L29:
        r7.h().i(r3, this.c);
        return;
    L23:
        r6.h().b(this.b, r3);
        goto L24
    L9:
        if (r5 != 2) goto L17;
        l r10 = this.a;
        fh8.r r11 = r10.d;
        if (r11 == null) goto L15;
        Function2<Context, gw8.b, Unit> r12 = r11.d;
        if (r12 == null) goto L15;
        r12.invoke(this.b, r3);
    L15:
        r10.h().c(this.b, r3);
        goto L24
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public r(l r1, Context r2, TextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
