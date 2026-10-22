package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "p1", BuildConfig.FLAVOR, "p2", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class InputFunctionManager$registerBehavior$1 extends FunctionReferenceImpl implements Function2<Boolean, Long, Unit> {
    public InputFunctionManager$registerBehavior$1(b r8) {
        super(2, r8, b.class, "changeStatus", "changeStatus(ZJ)V", 0);
    }

    public final void invoke(final boolean r17, long r18) {
        final b r4 = (b) ((CallableReference) this).receiver;
        int r5 = b.o;
        r4.getClass();
        AnimatorSet r6 = new AnimatorSet();
        ArrayList r7 = new ArrayList();
        if (r17 == false) goto L5;
        int r8 = Math.min(3, r4.b()) * r4.g;
    L6:
        if (r17 == false) goto L8;
        int r9 = r4.h;
    L9:
        int r10 = 2;
        ValueAnimator r11 = ValueAnimator.ofInt(new int[]{r8, r9});
        r11.setInterpolator(new AccelerateDecelerateInterpolator());
        r11.setDuration(r18);
        r11.addUpdateListener(new d(r11, r4));
        r7.add(r11);
        if (r17 == false) goto L12;
        int r13 = r4.i;
    L13:
        if (r17 == false) goto L15;
        int r14 = 0;
    L16:
        int r15 = r4.l.getChildCount();
        int r16 = 0;
    L17:
        if (r16 >= r15) goto L19;
        View r19 = r4.l.getChildAt(r16);
        int[] r1 = new int[r10];
        r1[0] = r14;
        r1[1] = r13;
        ValueAnimator r2 = ValueAnimator.ofInt(r1);
        r2.setDuration(r18);
        r2.addUpdateListener(new e(r2, r19));
        r7.add(r2);
        r16 = r16 + 1;
        r10 = 2;
        goto L17
    L19:
        com.bytedance.android.live.core.utils.h.b(r11, new InputFunctionManager$changeStatus$1(r4));
        com.bytedance.android.live.core.utils.h.a(r11, new InputFunctionManager$changeStatus$2(r4, r17));
        r6.playTogether(r7);
        r6.start();
        if (r17 == false) goto L22;
        r4.n.setImportantForAccessibility(4);
    L23:
        r4.m.setOnTouchListener(new f(r17));
        return;
    L22:
        r4.n.setImportantForAccessibility(1);
        goto L23
    L15:
        r14 = r4.i;
        goto L16
    L12:
        r13 = 0;
        goto L13
    L8:
        r9 = Math.min(3, r4.b()) * r4.g;
        goto L9
    L5:
        r8 = r4.h;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        invoke(((Boolean) r3).booleanValue(), ((Number) r4).longValue());
        return Unit.INSTANCE;
    }
}
