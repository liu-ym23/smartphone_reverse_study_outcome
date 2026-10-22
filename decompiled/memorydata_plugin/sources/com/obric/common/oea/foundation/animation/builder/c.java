package com.obric.common.oea.foundation.animation.builder;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.d.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cBk\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u001e\b\u0002\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\u0010\u000fJ\b\u0010\u001a\u001a\u00020\u001bH\u0007R\u000e\u0010\u0010\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/obric/common/oea/foundation/animation/builder/ValueAnimatable;", "", "animationSpeed", "", "targetFps", "valueAnimationCommand", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "onUpdateCallback", "Lkotlin/Function3;", "", "", "onEndCallback", "Lkotlin/Function2;", "", "", "(FFLcom/obric/common/oea/foundation/animation/command/AnimationCommand;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "TAG", "getAnimationSpeed", "()F", "getOnEndCallback", "()Lkotlin/jvm/functions/Function2;", "getOnUpdateCallback", "()Lkotlin/jvm/functions/Function3;", "getTargetFps", "getValueAnimationCommand", "()Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", CommonConsts.APM_INNER_EVENT_COST_START, "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "Builder", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f7684b;
    private final float c;
    private final com.obric.common.oea.foundation.animation.b.a<?> d;
    private final Function3<String, Object, Object, Unit> e;
    private final Function2<Boolean, Throwable, Unit> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J5\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0018J5\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\u00020\u00002\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0006J&\u0010 \u001a\u00020\u00002\u001e\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/common/oea/foundation/animation/builder/ValueAnimatable$Builder;", "", "()V", "animationSpeed", "", "onEndCallback", "Lkotlin/Function2;", "", "", "", "onUpdateCallback", "Lkotlin/Function3;", "", "valueAnimationCommand", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "animator", "build", "Lcom/obric/common/oea/foundation/animation/builder/ValueAnimatable;", "of", "initialValue", "targetValue", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "initialVelocity", "(FFLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/ValueAnimatable$Builder;", "ofInt", "initialInt", "", "targetInt", "(IILcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/ValueAnimatable$Builder;", "onEnd", "callback", "onUpdate", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f7685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.obric.common.oea.foundation.animation.b.a<?> f7686b;
        private Function3<? super String, Object, Object, Unit> c;
        private Function2<? super Boolean, ? super Throwable, Unit> d;

        public a() {
            this.f7685a = 1.0f;
        }

        public static final /* synthetic */ com.obric.common.oea.foundation.animation.b.a a(a r1) {
            com.obric.common.oea.foundation.animation.b.a<?> r2 = r1.f7686b;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimationCommand");
        L5:
            return r2;
        }

        public static /* synthetic */ a a(a r1, float r2, float r3, com.obric.common.oea.foundation.animation.spec.a r4, Float r5, int r6, Object r7) {
            com.obric.common.oea.foundation.animation.spec.a<Float> r8 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
            if ((r6 & 8) == 0) goto L6;
            r5 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.memorydata.plugin");
        L6:
            return r1.a(r2, r3, r8, r5);
        }

        public static final /* synthetic */ void a(a r0, com.obric.common.oea.foundation.animation.b.a r1) {
            r0.f7686b = r1;
        }

        public final a a(float r1) {
            this.f7685a = r1;
            return this;
        }

        public final a a(float r10, float r11, com.obric.common.oea.foundation.animation.spec.a<Float> r12, Float r13) {
            com.obric.common.oea.foundation.animation.spec.a r7 = (com.obric.common.oea.foundation.animation.spec.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.spec.a.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "spec");
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.spec.a.a.class) == false) goto L7;
            Object r14 = new com.obric.common.oea.foundation.animation.b.a.b("valueAnimationPlaceholder", Float.valueOf(r10), Float.valueOf(r11), Reflection.getOrCreateKotlinClass(Float.TYPE), r7, r13);
        L9:
            this.f7686b = (com.obric.common.oea.foundation.animation.b.a) ZeusTransformUtils.preCheckCast(r14, com.obric.common.oea.foundation.animation.b.a.class, "com.obric.memorydata.plugin");
            return this;
        L7:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.spec.spring.b.class) == false) goto L12;
            r14 = new com.obric.common.oea.foundation.animation.b.a.C0371a("valueAnimationPlaceholder", Float.valueOf(r10), Float.valueOf(r11), Reflection.getOrCreateKotlinClass(Float.TYPE), r7, r13);
            goto L9
        L12:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("不支持的 spec 类型: " + r7.getClass().getSimpleName()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final a a(Function2<? super Boolean, ? super Throwable, Unit> r3) {
            Function2<? super Boolean, ? super Throwable, Unit> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "callback");
            this.d = r4;
            return this;
        }

        public final a a(Function3<? super String, Object, Object, Unit> r3) {
            Function3<? super String, Object, Object, Unit> r4 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "callback");
            this.c = r4;
            return this;
        }

        public final c a() {
            if (((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).f7686b != null) goto L5;
            com.obric.common.oea.foundation.animation.token.c.a("必须先调用方法ofXXX方法指定动画初始和目标值");
        L5:
            float r2 = this.f7685a;
            float r3 = 60.0f;
            com.obric.common.oea.foundation.animation.b.a<?> r4 = this.f7686b;
            if (r4 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimationCommand");
        L9:
            return new c(r2, r3, r4, this.c, this.d, null);
        }
    }

    private c(float r3, float r4, com.obric.common.oea.foundation.animation.b.a<?> r5, Function3<? super String, Object, Object, Unit> r6, Function2<? super Boolean, ? super Throwable, Unit> r7) {
        Function3<String, Object, Object, Unit> r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
        Function2<Boolean, Throwable, Unit> r9 = (Function2) ZeusTransformUtils.wrapperContextForParams(r7, Function2.class, "com.obric.memorydata.plugin");
        this.f7684b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r8;
        this.f = r9;
        this.f7683a = "ValueAnimatable";
    }

    public /* synthetic */ c(float r8, float r9, com.obric.common.oea.foundation.animation.b.a r10, Function3 r11, Function2 r12, DefaultConstructorMarker r13) {
        this(r8, r9, r10, (Function3) ZeusTransformUtils.wrapperContextForParams(r11, Function3.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.wrapperContextForParams(r12, Function2.class, "com.obric.memorydata.plugin"));
    }

    public final d a() {
        com.obric.common.oea.foundation.a.b.f7661a.b(this.f7683a, "执行start ");
        com.obric.common.oea.foundation.animation.parser.a r3 = com.obric.common.oea.foundation.animation.parser.a.f7717a;
        float r4 = this.c;
        RunMode r6 = RunMode.PARALLEL;
        float r7 = this.f7684b;
        RepeatMode r8 = RepeatMode.NORMAL;
        List<? extends com.obric.common.oea.foundation.animation.b.a<?>> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r9.add(this.d);
        Unit r0 = Unit.INSTANCE;
        return r3.a(r4, null, r6, r7, r8, r9, this.e, this.f);
    }
}
