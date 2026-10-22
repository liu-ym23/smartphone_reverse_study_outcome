package com.bytedance.android.ec.core.widget;

import android.view.View;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {

    public static final class a extends d {
        public final /* synthetic */ Function1 g;

        @Override // com.bytedance.android.ec.core.widget.d
        public final void a(View r10) {
            Intrinsics.checkNotNullParameter(r10, "v");
            this.g.invoke(r10);
        }

        public a(Function1 r1, Long r10, String r11) {
            this.g = r1;
            super(r10, r11);
        }
    }

    public static void a(Query r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$limitClickListener");
        r10.a(new e(r11, null, null));
    }

    public static final void b(View r1, Long r10, String r11, Function1<? super View, Unit> r12) {
        Intrinsics.checkNotNullParameter(r1, "$this$setOnLimitClickListener");
        Intrinsics.checkNotNullParameter(r12, "listener");
        r1.setOnClickListener(new a(r12, r10, r11));
    }

    public static /* synthetic */ void c(View r10, Long r11, String r12, Function1 r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r12 = null;
    L8:
        b(r10, r11, r12, r13);
    }
}
