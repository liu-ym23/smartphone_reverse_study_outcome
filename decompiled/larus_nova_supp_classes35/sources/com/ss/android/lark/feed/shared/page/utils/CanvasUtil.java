package com.ss.android.lark.feed.shared.page.utils;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.ss.android.lark.feed.app.view.AdvanceAvatarView;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class CanvasUtil {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean c(View r6) {
        if ((r6 instanceof ViewGroup) == true) goto L5;
        return false;
    L5:
        ViewGroup r7 = (ViewGroup) r6;
        int r0 = r7.getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L23;
        View r3 = r7.getChildAt(r2);
        Intrinsics.checkNotNull(r3);
        if (r3.getVisibility() != 0) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L22;
        if (r3.getWidth() <= 0) goto L22;
        if (r3.getHeight() <= 0) goto L22;
        if ((r3 instanceof LarkAvatarView) == true) goto L21;
        if (c(r3) == false) goto L22;
    L21:
        return true;
    L22:
        r2 = r2 + 1;
        goto L6
    L10:
        r4 = false;
        goto L11
    L23:
        return false;
    }

    public static void a(Canvas r6, ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "avatarContainer");
        IntIterator r0 = RangesKt.until(0, r7.getChildCount()).iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        View r2 = r7.getChildAt(r0.nextInt());
        Intrinsics.checkNotNull(r2);
        if (r2.getVisibility() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        float r4 = r2.getX();
        float r5 = r2.getY();
        int r8 = r6.save();
        r6.translate(r4, r5);
        if ((r2 instanceof AdvanceAvatarView) == false) goto L14;
        b(r6, r2);     // Catch: Throwable -> L16
    L15:
        r6.restoreToCount(r8);
        goto L4
    L14:
        r2.draw(r6);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r6.restoreToCount(r8);
        throw th;
    L8:
        r3 = false;
        goto L9
    }

    public static void b(Canvas r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "view");
        Path r0 = new Path();
        r0.addOval(new RectF(0.0f, 0.0f, r6.getWidth(), r6.getHeight()), Path.Direction.CW);
        int r1 = r5.save();
        r5.clipPath(r0);
        r6.draw(r5);     // Catch: Throwable -> L6
        r5.restoreToCount(r1);
        return;
    L6:
        th = move-exception;
        r5.restoreToCount(r1);
        throw th;
    }

    public static void d(View r1, Canvas r2) {
        if ((r1 instanceof LarkAvatarView) == false) goto L6;
        b(r2, r1);
        return;
    L6:
        if ((r1 instanceof ViewGroup) == true) goto L8;
    L10:
        r1.draw(r2);
        return;
    L8:
        if (c(r1) == false) goto L10;
        e(r2, r1);
    }

    public static void e(Canvas r7, View r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "itemView");
        if ((r8 instanceof ViewGroup) == false) goto L5;
        final ViewGroup r9 = (ViewGroup) r8;
    L6:
        if (r9 == null) goto L22;
        Iterator r0 = CollectionsKt.sortedWith(RangesKt.until(0, r9.getChildCount()), ComparisonsKt.compareBy(new Function1[]{new CanvasUtil$redrawItemView$1$orderedChildIndices$1(r9), CanvasUtil$redrawItemView$1$orderedChildIndices$2.INSTANCE})).iterator();
    L9:
        if (r0.hasNext() == false) goto L30;
        View r2 = r9.getChildAt(((Number) r0.next()).intValue());
        Intrinsics.checkNotNull(r2);
        if (r2.getVisibility() != 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L9;
        float r4 = r2.getX();
        float r5 = r2.getY();
        int r6 = r7.save();
        r7.translate(r4, r5);
        d(r2, r7);     // Catch: Throwable -> L19
        r7.restoreToCount(r6);
    L19:
        th = move-exception;
        r7.restoreToCount(r6);
        throw th;
    L13:
        r3 = false;
        goto L14
    L30:
        return;
    L22:
        return;
    L5:
        r9 = null;
        goto L6
    }
}
