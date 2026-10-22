package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f11311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f11312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f11313c;
    public Lambda d;
    public Lambda e;
    public final View f;

    public a(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.f = r5;
        this.f11311a = 1.0f;
        this.f11312b = 60.0f;
        this.f11313c = new ArrayList();
    }

    public static void a(a r5) {
        if (1.0f <= 0) goto L6;
        r5.f11311a = 1.0f;
        r5.f11312b = 1.0f;
        return;
    L6:
        int r10 = lp.c.f19690a;
        Intrinsics.checkNotNullParameter("animationSpeed必须大于 0", "message");
        throw new IllegalArgumentException("animationSpeed必须大于 0");
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    public final b b() {
        ArrayList r5 = this.f11313c;
        if (r5 != null) goto L5;
    L8:
        int r10 = lp.c.f19690a;
        Intrinsics.checkNotNullParameter("必须先调用方法ofXXX方法指定添加动画", "message");
        throw new IllegalArgumentException("必须先调用方法ofXXX方法指定添加动画");
    L5:
        if (r5.isEmpty() == true) goto L8;
        float r11 = this.f11311a;
        float r12 = this.f11312b;
        ?? r13 = this.d;
        ?? r14 = this.e;
        return new b(this.f, r11, r12, r5, r13, r14);
    }

    public final void c(AnimationProperty$FloatProperty r10, Float r11, float r12, com.obric.common.oea.foundation.animation.spec.spring.b r13, Float r14) {
        Intrinsics.checkNotNullParameter(r10, "property");
        Intrinsics.checkNotNullParameter(r13, "spec");
        if (r11 == null) goto L20;
        float r15 = r11.floatValue();
    L16:
        this.f11313c.add(new hp.a(r13, Float.valueOf(r15), Float.valueOf(r12), r14, r10.getPropertyName(), Reflection.getOrCreateKotlinClass(Float.TYPE)));
        return;
    L20:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L8
        Object r17 = a.a.t(this.f, r10.getPropertyName());     // Catch: Throwable -> L8
        if (r17 == null) goto L11;
        Object r18 = Result.m124constructorimpl((Float) r17);     // Catch: Throwable -> L8
    L13:
        Throwable r5 = Result.m127exceptionOrNullimpl(r18);
        if (r5 != null) goto L19;
        r15 = ((Number) r18).floatValue();
        goto L16
    L19:
        throw new IllegalArgumentException("获取属性 " + r10.getPropertyName() + " 的初始值时出错，请检查", r5);
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
