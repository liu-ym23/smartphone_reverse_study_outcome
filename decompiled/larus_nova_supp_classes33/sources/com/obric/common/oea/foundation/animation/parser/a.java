package com.obric.common.oea.foundation.animation.parser;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import bja.b;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fja.d;
import fja.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static d a(com.obric.common.oea.foundation.animation.builder.a r14, View r15, List r16, Function3 r17, final Function2 r18) {
        Intrinsics.checkNotNullParameter(r14, "animConfig");
        Intrinsics.checkNotNullParameter(r16, "animationCommands");
        ArrayList r8 = new ArrayList();
        Iterator r1 = r16.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r8.add(((dja.a) r1.next()).a());
        goto L4
    L6:
        if (r15 == null) goto L19;
        ArrayList<d> r2 = b.a;
        Intrinsics.checkNotNullParameter(r15, "view");
        bja.a<?> r3 = b.b.get(r15);
        if (r3 == null) goto L10;
        float r4 = r3.k;
    L11:
        Iterator r5 = r8.iterator();
    L13:
        if (r5.hasNext() == false) goto L19;
        bja.a<?> r6 = (bja.a) r5.next();
        if (r6.i != null) goto L17;
        mja.a.C0063a r7 = mja.a.a;
        mja.a.a("AnimatableSubmitter", "没指定初始速度，重设velocity " + r4);
        r6.i = Float.valueOf(r4);
    L18:
        ArrayList<d> r9 = b.a;
        Intrinsics.checkNotNullParameter(r15, "view");
        Intrinsics.checkNotNullParameter(r6, "animationInfo");
        b.b.put(r15, r6);
        goto L13
    L17:
        mja.a.C0063a r10 = mja.a.a;
        mja.a.a("AnimatableSubmitter", "指定了初始速度，" + r6.i);
        goto L18
    L10:
        r4 = 0.0f;
    L19:
        final d r11 = new d();
        ArrayList<d> r12 = b.a;
        Intrinsics.checkNotNullParameter(r11, "animationManager");
        ArrayList<d> r13 = b.a;
        r13.add(r11);
        mja.a.C0063a r19 = mja.a.a;
        String r20 = "addAnimationManager, size: " + r13.size();
        Intrinsics.checkNotNullParameter("AnimationLifecycleListener", "tag");
        Intrinsics.checkNotNullParameter(r20, "msg");
        if (mja.a.a == null) goto L22;
        Intrinsics.checkNotNullParameter("AnimationLifecycleListener", "tag");
        Intrinsics.checkNotNullParameter(r20, "msg");
    L22:
        Function2<Boolean, Throwable, Unit> r110 = new AnimatableSubmitter$animate$2(r18, r11);
        Intrinsics.checkNotNullParameter(r14, "animConfig");
        Intrinsics.checkNotNullParameter(r8, "animationInfos");
        float r21 = r14.d;
        boolean r22 = r14.e;
        RunMode r23 = r14.a;
        float r24 = r14.c;
        RepeatMode r25 = r14.b;
        if ((!Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread())) == false) goto L25;
        new Handler(Looper.getMainLooper()).post(new e(r11, r21, r22, r15, r23, r24, r25, r8, r17, r110));
    L26:
        return r11;
    L25:
        r11.b(r21, r22, r15, r23, r24, r25, r8, r17, r110);
        goto L26
    }
}
