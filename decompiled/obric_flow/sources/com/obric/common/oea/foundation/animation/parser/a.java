package com.obric.common.oea.foundation.animation.parser;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.spec.spring.b;
import java.util.ArrayList;
import java.util.Iterator;
import jp.c;
import jp.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static d a(float r16, View r17, RunMode r18, float r19, RepeatMode r20, ArrayList r21, Function3 r22, final Function2 r23) {
        Intrinsics.checkNotNullParameter(r18, "mode");
        Intrinsics.checkNotNullParameter(r20, "repeatMode");
        Intrinsics.checkNotNullParameter(r21, "animationCommands");
        ArrayList r10 = new ArrayList();
        Iterator r5 = r21.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        hp.a r11 = (hp.a) r5.next();
        Float r12 = r11.f17355b;
        Float r13 = r11.f17356c;
        b r14 = r11.e;
        KClass r15 = r11.d;
        r10.add(new fp.a(r14, r12, r13, r11.f, r11.f17354a, r15));
        goto L4
    L7:
        if (r17 == null) goto L25;
        ArrayList r24 = fp.b.f16971a;
        Intrinsics.checkNotNullParameter(r17, "view");
        fp.a r110 = (fp.a) fp.b.f16972b.get(r17);
        if (r110 == null) goto L11;
        float r111 = r110.f16970k;
    L12:
        Iterator r112 = r10.iterator();
    L14:
        if (r112.hasNext() == false) goto L25;
        fp.a r113 = (fp.a) r112.next();
        if (r113.f16968i != null) goto L21;
        Iterator r25 = r112;
        String r114 = "没指定初始速度，重设velocity " + r111;
        Intrinsics.checkNotNullParameter("AnimatableSubmitter", "tag");
        Intrinsics.checkNotNullParameter(r114, "msg");
        if (rp.b.f21793a == null) goto L20;
        androidx.constraintlayout.motion.widget.a.B(androidx.constraintlayout.motion.widget.a.D("AnimatableSubmitter", "tag", r114, "msg", "AnimatableSubmitter->"), r114, "OEA_SDK");
    L20:
        r113.f16968i = Float.valueOf(r111);
    L24:
        ArrayList r115 = fp.b.f16971a;
        Intrinsics.checkNotNullParameter(r17, "view");
        Intrinsics.checkNotNullParameter(r113, "animationInfo");
        fp.b.f16972b.put(r17, r113);
        r112 = r25;
        goto L14
    L21:
        r25 = r112;
        String r116 = "指定了初始速度，" + r113.f16968i;
        Intrinsics.checkNotNullParameter("AnimatableSubmitter", "tag");
        Intrinsics.checkNotNullParameter(r116, "msg");
        if (rp.b.f21793a == null) goto L24;
        androidx.constraintlayout.motion.widget.a.B(androidx.constraintlayout.motion.widget.a.D("AnimatableSubmitter", "tag", r116, "msg", "AnimatableSubmitter->"), r116, "OEA_SDK");
        goto L24
    L11:
        r111 = 0.0f;
    L25:
        final d r117 = new d();
        ArrayList r26 = fp.b.f16971a;
        Intrinsics.checkNotNullParameter(r117, "animationManager");
        ArrayList r27 = fp.b.f16971a;
        r27.add(r117);
        String r28 = "addAnimationManager, size: " + r27.size();
        Intrinsics.checkNotNullParameter("AnimationLifecycleListener", "tag");
        Intrinsics.checkNotNullParameter(r28, "msg");
        if (rp.b.f21793a == null) goto L28;
        StringBuilder r29 = androidx.constraintlayout.motion.widget.a.D("AnimationLifecycleListener", "tag", r28, "msg", "AnimationLifecycleListener->");
        r29.append(r28);
        Log.v("OEA_SDK", r29.toString());
    L28:
        Function2<Boolean, Throwable, Unit> r30 = new AnimatableSubmitter$animate$2(r23, r117);
        Intrinsics.checkNotNullParameter(r18, "mode");
        Intrinsics.checkNotNullParameter(r20, "repeatMode");
        Intrinsics.checkNotNullParameter(r10, "animationInfos");
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread()) == true) goto L31;
        new Handler(Looper.getMainLooper()).post(new c(r117, r16, r17, r18, r19, r20, r10, r22, r30));
    L32:
        return r117;
    L31:
        r117.b(r17, r18, r19, r20, r10, r22, r30);
        goto L32
    }
}
