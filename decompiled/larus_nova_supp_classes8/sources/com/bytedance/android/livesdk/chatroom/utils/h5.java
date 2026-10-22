package com.bytedance.android.livesdk.chatroom.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.vr.VrMediaViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h5 {
    public static boolean a;
    public static final List<ph1.b> b = null;
    public static final List<Animator> c = null;

    public h5() {
    }

    static {
        a = true;
        b = new ArrayList();
        c = new ArrayList();
    }

    public static void b(boolean r14) {
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L8;
        com.bytedance.live.datacontext.m r6 = r5.isLandscapeLock();
        if (r6 == null) goto L8;
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L8;
    L14:
        boolean r1 = false;
    L17:
        if (a == r1) goto L55;
        ((ArrayList) c).clear();
        Iterator r2 = ((ArrayList) b).iterator();
    L21:
        if (r2.hasNext() == false) goto L47;
        ph1.b r3 = (ph1.b) r2.next();
        if (r14 == true) goto L25;
    L27:
        float r9 = 0.0f;
        if (r3.getType() == VrMediaViewType.TOP) goto L29;
        if (r1 == false) goto L39;
        float r4 = UtilityKotlinExtentionsKt.h(105);
    L40:
        if (r1 == false) goto L42;
        float r7 = 0.0f;
    L43:
        ObjectAnimator r8 = ObjectAnimator.ofFloat(r3.a, "translationY", new float[]{r4, r7});
        r8.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r8.setDuration(300);
        View r10 = r3.a;
        if (r1 == false) goto L46;
        r9 = 1.0f;
    L46:
        Animator r11 = a(r10, r9, 300);
        ArrayList r12 = (ArrayList) c;
        r12.add(r8);
        r12.add(r11);
        goto L21
    L42:
        r7 = UtilityKotlinExtentionsKt.h(105);
        goto L43
    L39:
        r4 = 0.0f;
        goto L40
    L29:
        if (r1 == false) goto L31;
        float r13 = 0.0f;
    L32:
        View r15 = r3.a;
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r15, "translationY", new float[]{r15.getTranslationY(), r13});
        r16.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r16.setDuration(300);
        View r17 = r3.a;
        if (r1 == false) goto L35;
        r9 = 1.0f;
    L35:
        Animator r18 = a(r17, r9, 300);
        ArrayList r19 = (ArrayList) c;
        r19.add(r16);
        r19.add(r18);
        goto L21
    L31:
        r13 = UtilityKotlinExtentionsKt.h(-65);
        goto L32
    L25:
        if (r3.a.getVisibility() == 0) goto L27;
        r3.a.setVisibility(0);
        goto L27
    L47:
        AnimatorSet r110 = new AnimatorSet();
        r110.playTogether(c);
        r110.start();
        a = r1;
        return;
    L55:
        return;
    L8:
        RoomContext r20 = RoomContext.a.c(r0, null, 0, 3);
        if (r20 == null) goto L15;
        com.bytedance.live.datacontext.m r21 = r20.getVrInImmersedMode();
        if (r21 == null) goto L15;
        if (((Boolean) r21.getValue()).booleanValue() == true) goto L14;
    L15:
        r1 = r14;
        goto L17
    }

    public static Animator a(View r3, float r4, long r5) {
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{r3.getAlpha(), r4});
        r6.setInterpolator(new com.bytedance.android.live.core.widget.g());
        r6.setDuration(r5);
        return r6;
    }

    public static void c(View r3, boolean r4, VrMediaViewType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        if (r3 != null) goto L5;
        return;
    L5:
        Object r0 = null;
        if (r4 == false) goto L16;
        Iterator r6 = ((ArrayList) b).iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        Object r1 = r6.next();
        if (Intrinsics.areEqual(((ph1.b) r1).a, r3) == false) goto L9;
        r0 = r1;
    L13:
        if (r0 == null) goto L15;
        return;
    L15:
        List<ph1.b> r7 = b;
        ArrayList r8 = (ArrayList) r7;
        r8.add(new ph1.b(r3, r5));
        return;
    L16:
        Iterator r9 = ((ArrayList) b).iterator();
    L18:
        if (r9.hasNext() == false) goto L22;
        Object r10 = r9.next();
        if (Intrinsics.areEqual(((ph1.b) r10).a, r3) == false) goto L18;
        r0 = r10;
    L22:
        ph1.b r2 = (ph1.b) r0;
        if (r2 == null) goto L33;
        ((ArrayList) b).remove(r2);
        return;
    }
}
