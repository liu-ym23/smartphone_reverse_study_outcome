package com.obric.common.oea.foundation.animation.parser;

import android.view.View;
import androidx.annotation.UiThread;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import j8.a;
import j8.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import n8.d;

/* JADX INFO: loaded from: classes2.dex */
public final class AnimatableSubmitter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnimatableSubmitter f5620a = null;

    static {
        f5620a = new AnimatableSubmitter();
    }

    private AnimatableSubmitter() {
    }

    @UiThread
    private final d a(float r11, View r12, RunMode r13, float r14, RepeatMode r15, List<? extends a<?>> r16, Function3<? super String, Object, ? super Float, Unit> r17, final Function2<? super Boolean, ? super Throwable, Unit> r18) {
        if (r12 == null) goto L15;
        a<?> r10 = b.f9790c.c(r12);
        float r19 = 0.0f;
        if (r10 == null) goto L7;
        r19 = r10.b();
    L7:
        Iterator<T> r20 = r16.iterator();
    L9:
        if (r20.hasNext() == false) goto L15;
        a<?> r21 = (a) r20.next();
        if (r21.e() != null) goto L13;
        t8.b.f12973c.a("AnimatableSubmitter", "没指定初始速度，重设velocity " + r19);
        r21.o(Float.valueOf(r19));
    L14:
        b.f9790c.a(r12, r21);
        goto L9
    L13:
        t8.b.f12973c.a("AnimatableSubmitter", "指定了初始速度，" + r21.e());
    L15:
        final d r22 = new d();
        b.f9790c.b(r22);
        r22.e(r11, r12, r13, r14, r15, r16, r17, new AnimatableSubmitter$animate$2(r18, r22));
        return r22;
    }

    private final a<?> b(l8.a<?> r10) {
        return r10.a();
    }

    @UiThread
    public final d c(float r11, View r12, RunMode r13, float r14, RepeatMode r15, List<? extends l8.a<?>> r16, Function3<? super String, Object, ? super Float, Unit> r17, Function2<? super Boolean, ? super Throwable, Unit> r18) {
        Intrinsics.checkNotNullParameter(r13, "mode");
        Intrinsics.checkNotNullParameter(r15, "repeatMode");
        Intrinsics.checkNotNullParameter(r16, "animationCommands");
        ArrayList r10 = new ArrayList();
        Iterator<T> r19 = r16.iterator();
    L4:
        if (r19.hasNext() == false) goto L7;
        l8.a<?> r20 = (l8.a) r19.next();
        r10.add(f5620a.b(r20));
        goto L4
    L7:
        return a(r11, r12, r13, r14, r15, r10, r17, r18);
    }
}
