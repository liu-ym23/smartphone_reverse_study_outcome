package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import androidx.annotation.UiThread;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.parser.AnimatableSubmitter;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import n8.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f5607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f5608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f5609d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<l8.a<?>> f5610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function3<? super String, Object, Object, Unit> f5611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Function2<? super Boolean, ? super Throwable, Unit> f5612g;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.builder.a$a, reason: collision with other inner class name */
    public static final class C0123a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f5613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f5614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<l8.a<?>> f5615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Function3<? super String, Object, Object, Unit> f5616d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Function2<? super Boolean, ? super Throwable, Unit> f5617e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final View f5618f;

        public C0123a(View r10) {
            Intrinsics.checkNotNullParameter(r10, "view");
            this.f5618f = r10;
            this.f5613a = 1.0f;
            this.f5614b = 60.0f;
            this.f5615c = new ArrayList();
        }

        public static /* synthetic */ C0123a d(C0123a r10, AnimationProperty$FloatProperty r11, Float r12, float r13, o8.a r14, Float r15, int r16, Object r17) {
            if ((r16 & 16) == 0) goto L6;
            r15 = null;
        L6:
            return r10.c(r11, r12, r13, r14, r15);
        }

        public final C0123a a(float r10, float r11) {
            if (r10 > 0) goto L5;
            p8.b.e("animationSpeed必须大于 0");
        L5:
            this.f5613a = r10;
            this.f5614b = r11;
            return this;
        }

        public final a b() {
            List<l8.a<?>> r10 = this.f5615c;
            if (r10 != null) goto L5;
        L8:
            boolean r11 = true;
        L9:
            if (r11 == false) goto L12;
            p8.b.e("必须先调用方法ofXXX方法指定添加动画");
        L12:
            return new a(this.f5618f, this.f5613a, this.f5614b, this.f5615c, this.f5616d, this.f5617e, null);
        L5:
            if (r10.isEmpty() == true) goto L8;
            r11 = false;
            goto L9
        }

        public final C0123a c(AnimationProperty$FloatProperty r10, Float r11, float r12, o8.a<Float> r13, Float r14) {
            Intrinsics.checkNotNullParameter(r10, "property");
            Intrinsics.checkNotNullParameter(r13, "spec");
            if (r11 == null) goto L23;
            float r15 = r11.floatValue();
        L16:
            if ((r13 instanceof com.obric.common.oea.foundation.animation.spec.spring.b) == false) goto L20;
            this.f5615c.add(new l8.a.C0233a(r10.getPropertyName(), Float.valueOf(r15), Float.valueOf(r12), Reflection.getOrCreateKotlinClass(Float.TYPE), r13, r14));
            return this;
        L20:
            throw new IllegalStateException("不支持的 spec 类型: " + r13.getClass().getSimpleName());
        L23:
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L10
            Object r17 = defpackage.b.c(this.f5618f, r10.getPropertyName());     // Catch: Throwable -> L10
            if (r17 == null) goto L9;
            Object r18 = Result.m32constructorimpl(Float.valueOf(((Float) r17).floatValue()));     // Catch: Throwable -> L10
        L12:
            Throwable r19 = Result.m35exceptionOrNullimpl(r18);
            if (r19 != null) goto L22;
            r15 = ((Number) r18).floatValue();
            goto L16
        L22:
            throw new IllegalArgumentException("获取属性 " + r10.getPropertyName() + " 的初始值时出错，请检查", r19);
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            r18 = Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L12
        }

        public final C0123a e(Function3<? super String, Object, Object, Unit> r10) {
            Intrinsics.checkNotNullParameter(r10, "callback");
            this.f5616d = r10;
            return this;
        }
    }

    private a(View r10, float r11, float r12, List<l8.a<?>> r13, Function3<? super String, Object, Object, Unit> r14, Function2<? super Boolean, ? super Throwable, Unit> r15) {
        this.f5607b = r10;
        this.f5608c = r11;
        this.f5609d = r12;
        this.f5610e = r13;
        this.f5611f = r14;
        this.f5612g = r15;
        this.f5606a = "PropertyAnimatable";
    }

    public /* synthetic */ a(View r10, float r11, float r12, List r13, Function3 r14, Function2 r15, DefaultConstructorMarker r16) {
        this(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ d b(a r10, RunMode r11, RepeatMode r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = RunMode.PARALLEL;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = RepeatMode.NORMAL;
    L9:
        return r10.a(r11, r12);
    }

    @UiThread
    public final d a(RunMode r13, RepeatMode r14) {
        Intrinsics.checkNotNullParameter(r13, "mode");
        Intrinsics.checkNotNullParameter(r14, "repeatMode");
        t8.b.f12973c.a(this.f5606a, "执行start ");
        AnimatableSubmitter r10 = AnimatableSubmitter.f5620a;
        float r11 = this.f5609d;
        View r12 = this.f5607b;
        float r15 = this.f5608c;
        List<l8.a<?>> r16 = this.f5610e;
        Objects.requireNonNull(r16, "null cannot be cast to non-null type kotlin.collections.List<com.obric.common.oea.foundation.animation.command.AnimationCommand<kotlin.Any>>");
        return r10.c(r11, r12, r13, r15, r14, r16, this.f5611f, this.f5612g);
    }
}
