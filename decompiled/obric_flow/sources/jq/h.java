package jq;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.animation.PathInterpolator;
import com.obric.common.oui.R$id;
import com.obric.flow.cardlistpage.ui.popup.OPopoverLayout;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f18429a = null;

    static {
        f18429a = new f();
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [T, com.obric.oui.animation.easy.d] */
    public static AnimatorSet a(final OPopoverLayout r14, boolean r15, int r16, float r17, float r18) {
        Intrinsics.checkNotNullParameter(r14, "view");
        final float r10 = r14.getY();
        AnimatorSet r11 = new AnimatorSet();
        if ((r16 & 112) == 48) goto L5;
        int r5 = 1;
    L6:
        r14.setPivotX(r17);
        r14.setPivotY(r18);
        float r12 = 1.0f;
        PathInterpolator r13 = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        PathInterpolator r19 = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
        float r20 = 0.99f;
        if (r15 == false) goto L9;
        float r110 = 0.0f;
    L10:
        if (r15 == true) goto L14;
        r20 = 0.0f;
    L14:
        if (r14.getAlpha() != 0.0f) goto L17;
    L20:
        ObjectAnimator r21 = ObjectAnimator.ofFloat(r14, "alpha", new float[]{r110, r20});
        if (r15 == true) goto L24;
        r13 = r19;
    L24:
        r21.setInterpolator(r13);
        if (r15 == false) goto L27;
        long r22 = 300;
    L28:
        r21.setDuration(r22);
        r14.setVisibility(0);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r11.play(r21);
        if (r15 == false) goto L31;
        final float r23 = 0.5f;
    L32:
        if (r15 == false) goto L34;
        final float r24 = 1.0f;
    L36:
        if (r15 == false) goto L38;
        float r25 = -TypedValue.applyDimension(1, 10, Resources.getSystem().getDisplayMetrics());
    L39:
        float r26 = r5;
        final float r27 = r25 * r26;
        if (r15 == false) goto L42;
        float r28 = 0.0f;
    L43:
        final float r112 = r28 * r26;
        if (r15 == false) goto L46;
        final float r29 = 0.0f;
    L47:
        if (r15 == false) goto L49;
        final float r30 = 10000.0f;
    L50:
        Collection r31 = wn.h.p(r14).f11946c.values();
        if ((r31 instanceof Collection) == true) goto L53;
    L55:
        Iterator r32 = r31.iterator();
    L57:
        if (r32.hasNext() == false) goto L61;
        if (((uq.d) r32.next()).f == false) goto L57;
    L62:
        if (r15 == false) goto L64;
        r12 = 0.8f;
    L64:
        ?? r113 = wn.h.p(r14);
        r113.d = r12;
        r113.e = 439.0f;
        com.obric.oui.animation.easy.d.b(r113, r30);
        uq.c r114 = new d(r14, r29, r30, r23, r24, r27, r112, r10);
        Intrinsics.checkNotNullParameter(r114, "listener");
        r113.g = r114;
        r111.element = r113;
        r11.addListener(new g(r111));
        return r11;
    L61:
        r14.setScaleX(r23);
        r14.setScaleY(r23);
        r14.setTranslationY(r27);
        int r33 = R$id.o_popover_anim_p;
        e r34 = new e();
        r34.f18427a = r29;
        r14.setTag(r33, r34);
        goto L62
    L53:
        if (r31.isEmpty() == false) goto L55;
    L49:
        r30 = 0.0f;
        goto L50
    L46:
        r29 = 10000.0f;
        goto L47
    L42:
        r28 = -TypedValue.applyDimension(1, 10, Resources.getSystem().getDisplayMetrics());
        goto L43
    L38:
        r25 = 0.0f;
        goto L39
    L34:
        r24 = 0.5f;
        goto L36
    L31:
        r23 = 1.0f;
        goto L32
    L27:
        r22 = 100;
        goto L28
    L17:
        if (r14.getAlpha() == 1.0f) goto L20;
        r110 = r14.getAlpha();
        goto L20
    L9:
        r110 = 0.99f;
        goto L10
    L5:
        r5 = -1;
        goto L6
    }
}
