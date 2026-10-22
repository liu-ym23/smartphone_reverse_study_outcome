package com.obric.common.oea.foundation.animation.easy;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4Jh\u00105\u001a\u0002012`\u00106\u001a\\\u0012\u0013\u0012\u001103¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020107JS\u0010=\u001a\u0002012K\u00106\u001aG\u0012\u0013\u0012\u001103¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u0002010>R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0004R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0004R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0004R\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR$\u0010\"\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0004R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010&\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0004R\u000e\u0010)\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010*\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0004R\u000e\u0010-\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/common/oea/foundation/animation/easy/SpringAnimationConfig;", "", "finalValue", "", "(F)V", "cancelIfRunning", "", "getCancelIfRunning", "()Z", "setCancelIfRunning", "(Z)V", EventBody.KEY_VALUE, "dampingRatio", "getDampingRatio", "()F", "setDampingRatio", "dampingRatioIsSet", "defaultDampingRatio", "getDefaultDampingRatio$foundation_standardRelease", "setDefaultDampingRatio$foundation_standardRelease", "defaultStiffness", "getDefaultStiffness$foundation_standardRelease", "setDefaultStiffness$foundation_standardRelease", "endListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationEndListener;", "maxValue", "getMaxValue", "setMaxValue", "minValue", "getMinValue", "setMinValue", "skipToEndIfRunning", "getSkipToEndIfRunning", "setSkipToEndIfRunning", "startValue", "getStartValue", "setStartValue", "startValueIsSet", "startVelocity", "getStartVelocity", "setStartVelocity", "startVelocityIsSet", "stiffness", "getStiffness", "setStiffness", "stiffnessIsSet", "updateListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "applyTo", "", "animation", "Lcom/obric/common/oea/foundation/animation/engine/SpringAnimation;", "applyTo$foundation_standardRelease", "onEnd", "function", "Lkotlin/Function4;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "spring", "canceled", "velocity", "onUpdate", "Lkotlin/Function3;", "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0376a f7715a = null;
    private static final float h = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7716b;
    private float c;
    private boolean d;
    private float e;
    private boolean f;
    private float g;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.easy.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/foundation/animation/easy/SpringAnimationConfig$Companion;", "", "()V", "NOT_SET", "", "getNOT_SET", "()F", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C0376a {
        private C0376a() {
        }

        public /* synthetic */ C0376a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f7715a = new C0376a(null);
        h = Float.MAX_VALUE;
    }

    public final void a(float r2) {
        this.f7716b = true;
        this.c = r2;
    }

    public final void b(float r2) {
        this.d = true;
        this.e = r2;
    }

    public final void c(float r2) {
        this.f = true;
        this.g = r2;
    }
}
