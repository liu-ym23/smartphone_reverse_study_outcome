package com.larksuite.framework.section.utils;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {

    /* JADX INFO: renamed from: com.larksuite.framework.section.utils.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0050a implements View.OnClickListener {
        public final /* synthetic */ com.larksuite.framework.section.c a;
        public final /* synthetic */ com.ss.android.lark.todo.impl.features.detail.viewmodel.a b;

        public ViewOnClickListenerC0050a(com.larksuite.framework.section.c r1, com.ss.android.lark.todo.impl.features.detail.viewmodel.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.a(this.b);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] a;
        public final /* synthetic */ com.larksuite.framework.section.c b;

        public b(com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] r1, com.larksuite.framework.section.c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            com.ss.android.lark.todo.impl.features.detail.viewmodel.a[] r6 = this.a;
            com.larksuite.framework.section.c r0 = this.b;
            int r1 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            r0.a(r6[r2]);
            r2 = r2 + 1;
            goto L3
        }
    }

    public static final class c implements View.OnTouchListener {
        public final /* synthetic */ Function2<View, MotionEvent, Unit>[] a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function2<? super View, ? super MotionEvent, Unit>[] r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r6, MotionEvent r7) {
            if (r7.getAction() != 0) goto L7;
            Function2<View, MotionEvent, Unit>[] r0 = this.a;
            int r2 = r0.length;
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L7;
            Function2<View, MotionEvent, Unit> r4 = r0[r3];
            Intrinsics.checkNotNull(r6);
            Intrinsics.checkNotNull(r7);
            r4.invoke(r6, r7);
            r3 = r3 + 1;
        L7:
            return false;
        }
    }

    public static final void c(View r1, Function2<? super View, ? super MotionEvent, Unit>... r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "blocks");
        r1.setOnTouchListener(new c(r2));
    }

    public static final void d(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        r1.setVisibility(0);
        return;
    L5:
        r1.setVisibility(8);
    }

    public static final void e(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        r1.setVisibility(0);
        return;
    L5:
        r1.setVisibility(4);
    }

    public static final void a(View r1, com.larksuite.framework.section.c r2, com.ss.android.lark.todo.impl.features.detail.viewmodel.a r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "dispatcher");
        Intrinsics.checkNotNullParameter(r3, "action");
        r1.setOnClickListener(new ViewOnClickListenerC0050a(r2, r3));
    }

    public static final void b(View r1, com.larksuite.framework.section.c r2, com.ss.android.lark.todo.impl.features.detail.viewmodel.a... r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "dispatcher");
        Intrinsics.checkNotNullParameter(r3, "actions");
        r1.setOnClickListener(new b(r3, r2));
    }
}
