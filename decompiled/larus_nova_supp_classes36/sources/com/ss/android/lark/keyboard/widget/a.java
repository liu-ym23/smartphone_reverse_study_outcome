package com.ss.android.lark.keyboard.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements com.ss.android.lark.keyboard.keyboard2.f {
    public final int b;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.widget.a$a, reason: collision with other inner class name */
    public static final class C0167a {
    }

    static {
    }

    public a() {
        this.b = UIHelper.getDimens(2131166599);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.f
    public final void a(KBMenuContainerView r7, List<? extends View> r8) {
        Intrinsics.checkNotNullParameter(r7, "container");
        Intrinsics.checkNotNullParameter(r8, "visibleChildViews");
        int r0 = r8.size();
        Context r1 = r7.getContext();
        int r9 = r7.getMeasuredWidth();
        Resources r2 = r1.getResources();
        int r3 = MathKt.roundToInt(r9 / WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density);
        List<? extends View> r4 = r8;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.add(Integer.valueOf(((View) r6.next()).getMeasuredWidth()));
        goto L4
    L6:
        int r10 = r9 - CollectionsKt.sumOfInt(r5);
        if (r3 >= 304) goto L13;
        int r11 = r10 / r0;
        Iterator<T> r12 = r4.iterator();
    L10:
        if (r12.hasNext() == false) goto L28;
        m.a((View) r12.next(), r11);
        goto L10
    L28:
        return;
    L13:
        if (r3 >= 424) goto L19;
        int r13 = (r10 - (this.b * 3)) / (r0 + 1);
        Iterator<T> r14 = r4.iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        m.a((View) r14.next(), r13);
        goto L16
    L18:
        m.a((View) CollectionsKt.last(r8), r13 * 2);
        return;
    L19:
        int r15 = y9c.d.a(14);
        Iterator<T> r16 = r4.iterator();
    L21:
        if (r16.hasNext() == false) goto L29;
        m.a((View) r16.next(), r15);
        goto L21
    }
}
