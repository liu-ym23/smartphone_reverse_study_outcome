package com.bytedance.android.livesdk.interactivity.like.view;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p<T, R> implements Function {
    public final /* synthetic */ DiggCountFlipperLayout a;
    public final /* synthetic */ int b;

    public p(DiggCountFlipperLayout r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r10) {
        Long r11 = (Long) r10;
        Intrinsics.checkNotNullParameter(r11, "count");
        if (this.a.k == false) goto L44;
        long r0 = r11.longValue();
        int r13 = this.b;
        int r1 = (int) (r0 % ((long) r13));
        int r2 = ((r1 - 1) + r13) % r13;
        DiggCountFlipperLayout r14 = this.a;
        r14.getClass();
        if (r1 == r2) goto L14;
        if (r1 < 0) goto L14;
        if (r1 >= r14.v.size()) goto L14;
        if (r2 < 0) goto L14;
        if (r2 >= r14.v.size()) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L44;
        Iterator<ArrayList<View>> r5 = r14.v.iterator();
        int r6 = 0;
    L19:
        if (r5.hasNext() == false) goto L31;
        ArrayList<View> r7 = r5.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        ArrayList<View> r9 = r7;
        if (r6 == r1) goto L30;
        if (r6 == r2) goto L30;
        Iterator<T> r15 = r9.iterator();
    L28:
        if (r15.hasNext() == false) goto L30;
        View r16 = (View) r15.next();
        r16.clearAnimation();
        r16.setVisibility(8);
    L30:
        r6 = r8;
        goto L19
    L31:
        Iterator<T> r17 = ((Iterable) ListProtector.get(r14.v, r1)).iterator();
    L33:
        if (r17.hasNext() == false) goto L35;
        ((View) r17.next()).startAnimation(r14.g);
        goto L33
    L35:
        Iterator<T> r3 = ((Iterable) ListProtector.get(r14.v, r2)).iterator();
    L37:
        if (r3.hasNext() == false) goto L39;
        ((View) r3.next()).startAnimation(r14.h);
        goto L37
    L39:
        Iterator<T> r18 = ((Iterable) ListProtector.get(r14.v, r1)).iterator();
    L41:
        if (r18.hasNext() == false) goto L44;
        View r19 = (View) r18.next();
        r19.setVisibility(0);
        r14.g(r19, r1 + 1);
    L14:
        r4 = false;
    L44:
        return Unit.INSTANCE;
    }
}
