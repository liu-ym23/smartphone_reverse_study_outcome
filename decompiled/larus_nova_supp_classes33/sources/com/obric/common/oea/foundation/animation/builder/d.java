package com.obric.common.oea.foundation.animation.builder;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public final float a;
    public final float b;
    public final dja.a<?> c;
    public final Function3<String, Object, Object, Unit> d;
    public final Function2<Boolean, Throwable, Unit> e;

    public static final class a {
        public float a;
        public final float b;
        public dja.a<?> c;
        public Function3<? super String, Object, Object, Unit> d;
        public Function2<? super Boolean, ? super Throwable, Unit> e;

        public final d a() {
            dja.a<?> r3 = this.c;
            if (r3 != null) goto L5;
            int r0 = ija.b.a;
            Intrinsics.checkNotNullParameter("必须先调用方法ofXXX方法指定动画初始和目标值", "message");
            throw new IllegalArgumentException("必须先调用方法ofXXX方法指定动画初始和目标值");
        L5:
            return new d(this.a, this.b, r3, this.d, this.e);
        }

        public a() {
            this.a = 1.0f;
            this.b = 60.0f;
        }

        public final void b(float r9, float r10, gja.a r11, Float r12) {
            Intrinsics.checkNotNullParameter(r11, "spec");
            if ((r11 instanceof hja.a) == false) goto L6;
            dja.a<?> r0 = new dja.a.b("valueAnimationPlaceholder", Float.valueOf(r9), Float.valueOf(r10), Reflection.getOrCreateKotlinClass(Float.TYPE), r11, r12);
        L8:
            this.c = r0;
            return;
        L6:
            if ((r11 instanceof com.obric.common.oea.foundation.animation.spec.spring.b) == false) goto L11;
            r0 = new dja.a.C0052a("valueAnimationPlaceholder", Float.valueOf(r9), Float.valueOf(r10), Reflection.getOrCreateKotlinClass(Float.TYPE), r11, r12);
            goto L8
        L11:
            throw new IllegalStateException("不支持的 spec 类型: ".concat(r11.getClass().getSimpleName()));
        }
    }

    public final fja.d a() {
        RunMode r0 = RunMode.PARALLEL;
        RepeatMode r1 = RepeatMode.NORMAL;
        mja.a.C0063a r2 = mja.a.a;
        mja.a.a("ValueAnimatable", "执行start ");
        com.obric.common.oea.foundation.animation.builder.a r3 = new com.obric.common.oea.foundation.animation.builder.a(r0, r1, this.a, this.b);
        int r4 = com.obric.common.oea.foundation.animation.parser.a.a;
        ArrayList r5 = new ArrayList();
        r5.add(this.c);
        Unit r6 = Unit.INSTANCE;
        return com.obric.common.oea.foundation.animation.parser.a.a(r3, null, r5, this.d, this.e);
    }

    public d(float r1, float r2, dja.a r3, Function3 r4, Function2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
