package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p4 {
    public final Context a;
    public final q4 b;
    public final Function1<e4, Unit> c;
    public final Function1<CocreationTaskFilter, Unit> d;
    public final Function1<e4, Unit> e;
    public final Function1<View, Unit> f;
    public final Function0<Unit> g;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CocreationTaskFilter.values().length];
            r0[CocreationTaskFilter.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CocreationTaskFilter.PENDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CocreationTaskFilter.RUN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final TextView b(String r6, int r7) {
        Context r0 = this.a;
        TextView r8 = c4.f(r0, r6, 12.0f, r7, 1);
        r8.setGravity(17);
        r8.setMinHeight(c4.c(r0, 30));
        r8.setPadding(c4.c(r0, 16), 0, c4.c(r0, 16), 0);
        if (r7 != (-15656921)) goto L5;
        int r3 = -328967;
    L6:
        if (r7 != (-15656921)) goto L8;
        int r9 = -1512723;
    L9:
        r8.setBackground(c4.h(r0, r3, 18, r9, 1));
        return r8;
    L8:
        r9 = c4.i(r7);
        goto L9
    L5:
        r3 = c4.g(r7);
        goto L6
    }

    public static final void a(TextView r1, EditText r2, p4 r3) {
        boolean r0 = true;
        if ((!StringsKt.isBlank(r2.getText().toString())) == true) goto L5;
    L7:
        r0 = false;
    L8:
        r1.setEnabled(r0);
        if (r1.isEnabled() == false) goto L11;
        float r4 = 1.0f;
    L12:
        r1.setAlpha(r4);
        return;
    L11:
        r4 = 0.45f;
        goto L12
    L5:
        if (r3.b.g != null) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p4(CocreationReviewActivity r2, q4 r3, f2 r4, g2 r5, Function1 r6, Function1 r7, Function0 r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "onToggle");
        Intrinsics.checkNotNullParameter(r5, "onFilter");
        Intrinsics.checkNotNullParameter(r6, "onRun");
        Intrinsics.checkNotNullParameter(r7, "onInputFocus");
        Intrinsics.checkNotNullParameter(r8, "onRetry");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
