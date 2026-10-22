package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.d.d;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB{\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u001e\b\u0002\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0013\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable;", "", "view", "Landroid/view/View;", "animationSpeed", "", "targetFps", "animationCommands", "", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "onUpdateCallback", "Lkotlin/Function3;", "", "", "onEndCallback", "Lkotlin/Function2;", "", "", "(Landroid/view/View;FFLjava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "TAG", CommonConsts.APM_INNER_EVENT_COST_START, "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "mode", "Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "repeatMode", "Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "Builder", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f7680b;
    private float c;
    private float d;
    private final List<com.obric.common.oea.foundation.animation.b.a<?>> e;
    private Function3<? super String, Object, Object, Unit> f;
    private Function2<? super Boolean, ? super Throwable, Unit> g;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.builder.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0003J5\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\"J5\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\"J?\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010+J?\u0010,\u001a\u00020\u00002\u0006\u0010'\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020/2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020/0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u00101J?\u00102\u001a\u00020\u00002\u0006\u0010'\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020/2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020/0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u00101JK\u00102\u001a\u00020\u00002\u0006\u0010'\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020/2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020/0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\b\u0002\u00103\u001a\u00020\fH\u0002¢\u0006\u0002\u00104J\"\u00105\u001a\u00020\u00002\u001a\u00106\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\u000bJS\u00107\u001a\u00020\u00002K\u00106\u001aG\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u000e0\u0010J-\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0018J-\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0018J5\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\"J5\u0010A\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\"R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "animationCommands", "", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "animationSpeed", "", "onEndCallback", "Lkotlin/Function2;", "", "", "", "onUpdateCallback", "Lkotlin/Function3;", "", "targetFps", "alphaBy", "deltaAlpha", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "initialVelocity", "(FLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "alphaTo", "alpha", "animator", "build", "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable;", "getView", "moveBy", "dx", "dy", "(FFLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "moveTo", "x", "y", "of", "property", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty;", "initialValue", "targetValue", "(Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty;Ljava/lang/Float;FLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "ofColor", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;", "initialInt", "", "targetInt", "(Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;Ljava/lang/Integer;ILcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "ofInt", "isColor", "(Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;Ljava/lang/Integer;ILcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;Z)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "onEnd", "callback", "onUpdate", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "velocity", "rotateBy", Key.ROTATION, "rotateTo", "scaleBy", "scaleX", "scaleY", "scaleTo", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0372a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f7681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f7682b;
        private final List<com.obric.common.oea.foundation.animation.b.a<?>> c;
        private Function3<? super String, Object, Object, Unit> d;
        private Function2<? super Boolean, ? super Throwable, Unit> e;
        private final View f;

        public C0372a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.f = r3;
            this.f7681a = 1.0f;
            this.f7682b = 60.0f;
            this.c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        }

        public static /* synthetic */ C0372a a(C0372a r7, AnimationProperty.FloatProperty r8, Float r9, float r10, com.obric.common.oea.foundation.animation.spec.a r11, Float r12, int r13, Object r14) {
            com.obric.common.oea.foundation.animation.spec.a<Float> r5 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
            if ((r13 & 16) == 0) goto L6;
            r12 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.memorydata.plugin");
        L6:
            return r7.a(r8, r9, r10, r5, r12);
        }

        public final View a() {
            return this.f;
        }

        public final C0372a a(float r2, float r3) {
            if (r2 > 0) goto L5;
            com.obric.common.oea.foundation.animation.token.c.a("animationSpeed必须大于 0");
        L5:
            this.f7681a = r2;
            this.f7682b = r3;
            return this;
        }

        public final C0372a a(AnimationProperty.FloatProperty r10, Float r11, float r12, com.obric.common.oea.foundation.animation.spec.a<Float> r13, Float r14) {
            com.obric.common.oea.foundation.animation.spec.a r7 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "property");
            Intrinsics.checkNotNullParameter(r7, "spec");
            if (r11 == null) goto L28;
            float r15 = r11.floatValue();
        L16:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.spec.a.a.class) == false) goto L20;
            Object r16 = new com.obric.common.oea.foundation.animation.b.a.b(r10.getPropertyName(), Float.valueOf(r15), Float.valueOf(r12), Reflection.getOrCreateKotlinClass(Float.TYPE), r7, r14);
        L22:
            this.c.add((com.obric.common.oea.foundation.animation.b.a) ZeusTransformUtils.preCheckCast(r16, com.obric.common.oea.foundation.animation.b.a.class, "com.obric.memorydata.plugin"));
            return this;
        L20:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.spec.spring.b.class) == false) goto L25;
            r16 = new com.obric.common.oea.foundation.animation.b.a.C0371a(r10.getPropertyName(), Float.valueOf(r15), Float.valueOf(r12), Reflection.getOrCreateKotlinClass(Float.TYPE), r7, r14);
            goto L22
        L25:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("不支持的 spec 类型: " + r7.getClass().getSimpleName()), Throwable.class, "com.obric.memorydata.plugin"));
        L28:
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L10
            Object r18 = h.a(((C0372a) ZeusTransformUtils.preCheckCast(this, C0372a.class, "com.obric.memorydata.plugin")).f, r10.getPropertyName());     // Catch: Throwable -> L10
            if (r18 == null) goto L9;
            Object r19 = Result.m1421constructorimpl(Float.valueOf(((Float) ZeusTransformUtils.preCheckCast(r18, Float.class, "com.obric.memorydata.plugin")).floatValue()));     // Catch: Throwable -> L10
        L12:
            Throwable r110 = Result.m1424exceptionOrNullimpl(r19);
            if (r110 != null) goto L27;
            r15 = ((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.memorydata.plugin")).floatValue();
            goto L16
        L27:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("获取属性 " + r10.getPropertyName() + " 的初始值时出错，请检查", r110), Throwable.class, "com.obric.memorydata.plugin"));
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Result.Companion r111 = Result.Companion;
            r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L12
        }

        public final C0372a a(Function2<? super Boolean, ? super Throwable, Unit> r3) {
            Function2<? super Boolean, ? super Throwable, Unit> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "callback");
            this.e = r4;
            return this;
        }

        public final C0372a a(Function3<? super String, Object, Object, Unit> r3) {
            Function3<? super String, Object, Object, Unit> r4 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "callback");
            this.d = r4;
            return this;
        }

        public final a b() {
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(this.c, Collection.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            com.obric.common.oea.foundation.animation.token.c.a("必须先调用方法ofXXX方法指定添加动画");
        L12:
            return new a(this.f, this.f7681a, this.f7682b, this.c, this.d, this.e, null);
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    private a(View r3, float r4, float r5, List<com.obric.common.oea.foundation.animation.b.a<?>> r6, Function3<? super String, Object, Object, Unit> r7, Function2<? super Boolean, ? super Throwable, Unit> r8) {
        List<com.obric.common.oea.foundation.animation.b.a<?>> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Function3<? super String, Object, Object, Unit> r10 = (Function3) ZeusTransformUtils.wrapperContextForParams(r7, Function3.class, "com.obric.memorydata.plugin");
        Function2<? super Boolean, ? super Throwable, Unit> r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r8, Function2.class, "com.obric.memorydata.plugin");
        this.f7680b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r9;
        this.f = r10;
        this.g = r11;
        this.f7679a = "PropertyAnimatable";
    }

    public /* synthetic */ a(View r9, float r10, float r11, List r12, Function3 r13, Function2 r14, DefaultConstructorMarker r15) {
        this(r9, r10, r11, (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r13, Function3.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r14, Function2.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ d a(a r0, RunMode r1, RepeatMode r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = RunMode.PARALLEL;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = RepeatMode.NORMAL;
    L9:
        return r0.a(r1, r2);
    }

    public final d a(RunMode r13, RepeatMode r14) {
        Intrinsics.checkNotNullParameter(r13, "mode");
        Intrinsics.checkNotNullParameter(r14, "repeatMode");
        com.obric.common.oea.foundation.a.b.f7661a.b(this.f7679a, "执行start ");
        com.obric.common.oea.foundation.animation.parser.a r3 = com.obric.common.oea.foundation.animation.parser.a.f7717a;
        float r4 = this.d;
        View r5 = this.f7680b;
        float r7 = this.c;
        List<com.obric.common.oea.foundation.animation.b.a<?>> r9 = this.e;
        Objects.requireNonNull(r9, "null cannot be cast to non-null type kotlin.collections.List<com.obric.common.oea.foundation.animation.command.AnimationCommand<kotlin.Any>>");
        return r3.a(r4, r5, r13, r7, r14, r9, this.f, this.g);
    }
}
