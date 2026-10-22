package com.bytedance.android.annie.business.container.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.annie.container.fragment.flavor.fail.FailSubFragmentProxy;
import ia.c;
import ia.i;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class CustomViewUtils {
    public static final /* synthetic */ int a = 0;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            c r11 = this.a;
            if (r11 == null) goto L6;
            r11.reload(null);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ c a;
        public final /* synthetic */ FailSubFragmentProxy b;

        public b(c r1, FailSubFragmentProxy r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            c r11 = this.a;
            if ((r11 instanceof i) == false) goto L5;
            this.b.c();
            return;
        L5:
            if (r11 == null) goto L9;
            r11.close();
            return;
        }
    }

    static {
    }

    public static View b(ViewGroup r10, Context r11, String r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "bizKey");
        v7.b r14 = u7.b.b(new u7.c(0), r10, r11, r12);
        if (r13 == null) goto L5;
        r13.invoke(r14);
    L5:
        View r15 = r14.b();
        r14.d();
        return r15;
    }

    public static View a(ViewGroup r1, Context r10, final c r11, Map r12, String r13) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "bizKey");
        FailSubFragmentProxy r14 = u7.b.a(r1, r10, r12, r13);
        View r15 = r14.b();
        r14.f(r15, new CustomViewUtils$createErrorView$1$1(r11));
        View r16 = r15.findViewById(2131393128);
        if (r16 == null) goto L5;
        r16.setOnClickListener(new a(r11));
    L5:
        View r17 = r15.findViewById(2131372061);
        if (r17 == null) goto L8;
        r17.setOnClickListener(new b(r11, r14));
    L8:
        return r15;
    }
}
