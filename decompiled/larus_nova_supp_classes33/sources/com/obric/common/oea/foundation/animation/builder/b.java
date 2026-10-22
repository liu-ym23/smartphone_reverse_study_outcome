package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public final View a;
    public final float b;
    public final float c;
    public final List<dja.a<?>> d;
    public final Function3<? super String, Object, Object, Unit> e;
    public final Function2<? super Boolean, ? super Throwable, Unit> f;

    public static final class a {
        public float a;
        public float b;
        public final List<dja.a<?>> c;
        public Function3<? super String, Object, Object, Unit> d;
        public Function2<? super Boolean, ? super Throwable, Unit> e;
        public final View f;

        public final b a() {
            List<dja.a<?>> r0 = this.c;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L11;
            int r2 = ija.b.a;
            Intrinsics.checkNotNullParameter("必须先调用方法ofXXX方法指定添加动画", "message");
            throw new IllegalArgumentException("必须先调用方法ofXXX方法指定添加动画");
        L11:
            return new b(this.f, this.a, this.b, this.c, this.d, this.e);
        L5:
            if (((ArrayList) r0).isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }

        public a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.f = r2;
            this.a = 1.0f;
            this.b = 60.0f;
            this.c = new ArrayList();
        }

        public static /* synthetic */ void c(a r6, AnimationProperty$FloatProperty r7, Float r8, float r9, gja.a r10) {
            r6.b(r7, r8, r9, r10, null);
        }

        public final void b(AnimationProperty$FloatProperty r9, Float r10, float r11, gja.a r12, Float r13) {
            Intrinsics.checkNotNullParameter(r9, "property");
            Intrinsics.checkNotNullParameter(r12, "spec");
            if (r10 == null) goto L27;
            float r14 = r10.floatValue();
        L16:
            if ((r12 instanceof hja.a) == false) goto L19;
            Object r0 = new dja.a.b(r9.getPropertyName(), Float.valueOf(r14), Float.valueOf(r11), Reflection.getOrCreateKotlinClass(Float.TYPE), r12, r13);
        L21:
            ((ArrayList) this.c).add(r0);
            return;
        L19:
            if ((r12 instanceof com.obric.common.oea.foundation.animation.spec.spring.b) == false) goto L24;
            r0 = new dja.a.C0052a(r9.getPropertyName(), Float.valueOf(r14), Float.valueOf(r11), Reflection.getOrCreateKotlinClass(Float.TYPE), r12, r13);
            goto L21
        L24:
            throw new IllegalStateException("不支持的 spec 类型: ".concat(r12.getClass().getSimpleName()));
        L27:
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L10
            Object r16 = v0.c(this.f, r9.getPropertyName());     // Catch: Throwable -> L10
            if (r16 == null) goto L9;
            Object r17 = Result.constructor-impl(Float.valueOf(((Float) r16).floatValue()));     // Catch: Throwable -> L10
        L12:
            Throwable r1 = Result.exceptionOrNull-impl(r17);
            if (r1 != null) goto L26;
            r14 = ((Number) r17).floatValue();
            goto L16
        L26:
            throw new IllegalArgumentException("获取属性 " + r9.getPropertyName() + " 的初始值时出错，请检查", r1);
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r17 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
        }
    }

    public static fja.d a(b r5) {
        RunMode r0 = RunMode.PARALLEL;
        RepeatMode r1 = RepeatMode.NORMAL;
        Intrinsics.checkNotNullParameter(r0, "mode");
        Intrinsics.checkNotNullParameter(r1, "repeatMode");
        mja.a.C0063a r2 = mja.a.a;
        mja.a.a("PropertyAnimatable", "执行start ");
        com.obric.common.oea.foundation.animation.builder.a r3 = new com.obric.common.oea.foundation.animation.builder.a(r0, r1, r5.b, r5.c);
        int r4 = com.obric.common.oea.foundation.animation.parser.a.a;
        View r6 = r5.a;
        List<dja.a<?>> r7 = r5.d;
        if (r7 == null) goto L7;
        return com.obric.common.oea.foundation.animation.parser.a.a(r3, r6, r7, r5.e, r5.f);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.obric.common.oea.foundation.animation.command.AnimationCommand<kotlin.Any>>");
    }

    public b(View r1, float r2, float r3, List r4, Function3 r5, Function2 r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
