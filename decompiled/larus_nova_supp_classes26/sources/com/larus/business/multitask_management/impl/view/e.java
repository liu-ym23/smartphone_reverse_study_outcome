package com.larus.business.multitask_management.impl.view;

import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.larus.multitask_management.api.data.TaskStatus;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements jl9.a {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final View a(jl9.b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        AttributeSet r3 = null;
        return new OngoingTaskItemDefaultView(r5.getContext(), r3, 6, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(View r8, jl9.b r9, kl9.u r10) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "taskBasicInfo");
        Long r0 = null;
        if ((r8 instanceof OngoingTaskItemDefaultView) == false) goto L5;
        OngoingTaskItemDefaultView r11 = (OngoingTaskItemDefaultView) r8;
    L6:
        if (r11 == null) goto L55;
        Intrinsics.checkNotNullParameter(r10, "item");
        r11.e = r10;
        r11.R5();
        TextView r12 = r11.a.f;
        kl9.x r1 = r10.i;
        String r2 = "";
        if (r1 == null) goto L12;
        String r3 = r1.a;
        if (r3 == null) goto L12;
    L13:
        r12.setText(r3);
        kl9.x r13 = r10.i;
        if (r13 == null) goto L19;
        String r14 = r13.b;
        if (r14 == null) goto L19;
        r2 = r14;
    L19:
        r11.a.b.setText(r2);
        TextView r15 = r11.a.b;
        if (r2.length() <= 0) goto L22;
        boolean r4 = true;
    L24:
        if (r4 == false) goto L26;
        int r5 = 0;
    L27:
        r15.setVisibility(r5);
        String r16 = r10.a;
        kl9.c0 r6 = r10.m;
        if (r6 == null) goto L30;
        int r7 = r6.a;
    L31:
        TaskStatus r17 = r10.g;
        if (r17 != TaskStatus.FAILED) goto L38;
        c r18 = r11.d;
        if (r18 == null) goto L36;
        r18.d(r11.b);
    L36:
        r11.d = null;
        r11.c = null;
        Lazy r19 = TaskProgressMockCache.a;
        TaskProgressMockCache.b(r16);
        r11.a.c.setVisibility(8);
        r11.a.d.setImageResource(2131243085);
        r11.a.d.setVisibility(0);
        return;
    L38:
        if (r17 != TaskStatus.SUCCESS) goto L43;
        c r110 = r11.d;
        if (r110 == null) goto L42;
        r110.d(r11.b);
    L42:
        r11.d = null;
        r11.c = null;
        Lazy r111 = TaskProgressMockCache.a;
        TaskProgressMockCache.b(r16);
        r11.a.c.setVisibility(8);
        r11.a.d.setImageResource(2131243081);
        r11.a.d.setVisibility(0);
        return;
    L43:
        if (r7 < 0) goto L50;
        r11.a.c.setVisibility(0);
        r11.a.d.setVisibility(8);
        r11.a.d.setImageResource(2131243081);
        r11.S5(r16);
        kl9.c0 r112 = r10.m;
        if (r112 == null) goto L47;
        r0 = Long.valueOf(r112.b);
    L47:
        c r20 = r11.d;
        if (r20 == null) goto L58;
        r20.b(r16, r7, r0);
        return;
    L58:
        return;
    L50:
        c r113 = r11.d;
        if (r113 == null) goto L53;
        r113.d(r11.b);
    L53:
        r11.d = null;
        r11.c = null;
        Lazy r114 = TaskProgressMockCache.a;
        TaskProgressMockCache.b(r16);
        r11.a.c.setVisibility(8);
        r11.a.d.setVisibility(8);
        return;
    L30:
        r7 = -1;
        goto L31
    L26:
        r5 = 8;
        goto L27
    L22:
        r4 = false;
    L12:
        r3 = "";
        goto L13
    L55:
        return;
    L5:
        r11 = null;
        goto L6
    }
}
