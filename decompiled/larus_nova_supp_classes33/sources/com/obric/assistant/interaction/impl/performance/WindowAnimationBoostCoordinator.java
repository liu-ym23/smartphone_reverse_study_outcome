package com.obric.assistant.interaction.impl.performance;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/interaction/impl/performance/WindowAnimationBoostCoordinator;", "", "<init>", "()V", "TAG", "", "SYS_FW_BRIDGE_CLASS", "ANIMA_PROMOTION_OPT_CLASS", "GET_FACTORY_METHOD", "GET_ANIMA_PROMOTION_OPT_METHOD", "APPLY_ANIMA_PROMOTION_BOOST_METHOD", "ANIMA_PROMOTION_TYPE_FIELD", "DEFAULT_WINDOW_ANIMATION_DURATION_MS", "", "SLIDE_WINDOW_ANIMATION_DURATION_MS", "resolveFailureLogged", "Ljava/util/concurrent/atomic/AtomicBoolean;", "applyFailureLogged", "animaPromotionApi", "Lcom/obric/assistant/interaction/impl/performance/WindowAnimationBoostCoordinator$AnimaPromotionApi;", "getAnimaPromotionApi", "()Lcom/obric/assistant/interaction/impl/performance/WindowAnimationBoostCoordinator$AnimaPromotionApi;", "animaPromotionApi$delegate", "Lkotlin/Lazy;", "boost", "", "source", "durationMs", "AnimaPromotionApi", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowAnimationBoostCoordinator {
    private static final String ANIMA_PROMOTION_OPT_CLASS = "android.view.IAnimaPromotionOpt";
    private static final String ANIMA_PROMOTION_TYPE_FIELD = "ANIMA_PROMOTION_ASSISTANT_WINDOW_POPUP";
    private static final String APPLY_ANIMA_PROMOTION_BOOST_METHOD = "applyAnimaPromotionBoost";
    public static final int DEFAULT_WINDOW_ANIMATION_DURATION_MS = 400;
    private static final String GET_ANIMA_PROMOTION_OPT_METHOD = "getAnimaPromotionOpt";
    private static final String GET_FACTORY_METHOD = "getFactory";
    public static final WindowAnimationBoostCoordinator INSTANCE = null;
    public static final int SLIDE_WINDOW_ANIMATION_DURATION_MS = 700;
    private static final String SYS_FW_BRIDGE_CLASS = "android.app.SysFwBridge";
    private static final String TAG = "WindowAnimationBoost";
    private static final Lazy animaPromotionApi$delegate = null;
    private static final AtomicBoolean applyFailureLogged = null;
    private static final AtomicBoolean resolveFailureLogged = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/interaction/impl/performance/WindowAnimationBoostCoordinator$AnimaPromotionApi;", "", "receiver", "applyMethod", "Ljava/lang/reflect/Method;", "type", "", "<init>", "(Ljava/lang/Object;Ljava/lang/reflect/Method;I)V", "getReceiver", "()Ljava/lang/Object;", "getApplyMethod", "()Ljava/lang/reflect/Method;", "getType", "()I", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnimaPromotionApi {
        private final Method applyMethod;
        private final Object receiver;
        private final int type;

        public static /* synthetic */ AnimaPromotionApi copy$default(AnimaPromotionApi r0, Object r1, Method r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.receiver;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.applyMethod;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.type;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final Object component1() {
            return this.receiver;
        }

        public final Method component2() {
            return this.applyMethod;
        }

        public final int component3() {
            return this.type;
        }

        public final AnimaPromotionApi copy(Object r2, Method r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "receiver");
            Intrinsics.checkNotNullParameter(r3, "applyMethod");
            return new AnimaPromotionApi(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AnimaPromotionApi) == true) goto L8;
            return false;
        L8:
            AnimaPromotionApi r6 = (AnimaPromotionApi) r5;
            if (Intrinsics.areEqual(this.receiver, r6.receiver) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.applyMethod, r6.applyMethod) == true) goto L15;
            return false;
        L15:
            if (this.type == r6.type) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.receiver.hashCode() * 31) + this.applyMethod.hashCode()) * 31) + this.type;
        }

        public String toString() {
            return "AnimaPromotionApi(receiver=" + this.receiver + ", applyMethod=" + this.applyMethod + ", type=" + this.type + ')';
        }

        public final Method getApplyMethod() {
            return this.applyMethod;
        }

        public final Object getReceiver() {
            return this.receiver;
        }

        public final int getType() {
            return this.type;
        }

        public AnimaPromotionApi(Object r2, Method r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "receiver");
            Intrinsics.checkNotNullParameter(r3, "applyMethod");
            this.receiver = r2;
            this.applyMethod = r3;
            this.type = r4;
        }
    }

    private WindowAnimationBoostCoordinator() {
    }

    public static /* synthetic */ AnimaPromotionApi a() {
        return animaPromotionApi_delegate$lambda$2();
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    private static final AnimaPromotionApi animaPromotionApi_delegate$lambda$2() {
        Object r1 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = INVOKESTATIC_com_obric_assistant_interaction_impl_performance_WindowAnimationBoostCoordinator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(SYS_FW_BRIDGE_CLASS).getMethod(GET_FACTORY_METHOD, new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L5
        Object r5 = r4.getClass().getMethod(GET_ANIMA_PROMOTION_OPT_METHOD, new Class[0]).invoke(r4, new Object[0]);     // Catch: Throwable -> L5
        Class<?> r6 = r5.getClass();     // Catch: Throwable -> L5
        Class<?> r7 = Integer.TYPE;     // Catch: Throwable -> L5
        Method r8 = r6.getMethod(APPLY_ANIMA_PROMOTION_BOOST_METHOD, new Class[]{r7, r7});     // Catch: Throwable -> L5
        int r9 = INVOKESTATIC_com_obric_assistant_interaction_impl_performance_WindowAnimationBoostCoordinator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(ANIMA_PROMOTION_OPT_CLASS).getField(ANIMA_PROMOTION_TYPE_FIELD).getInt(null);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl(new AnimaPromotionApi(r5, r8, r9));     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L13;
        if (resolveFailureLogged.compareAndSet(false, true) == false) goto L13;
        FLogger.a.d(TAG, "resolve anima promotion API failed, error=".concat(r11.getClass().getSimpleName()));
    L13:
        if (Result.isFailure-impl(r10) == true) goto L17;
        r1 = r10;
    L17:
        return (AnimaPromotionApi) r1;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    static {
        INSTANCE = new WindowAnimationBoostCoordinator();
        resolveFailureLogged = new AtomicBoolean(false);
        applyFailureLogged = new AtomicBoolean(false);
        animaPromotionApi$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new b());
    }

    private final AnimaPromotionApi getAnimaPromotionApi() {
        return (AnimaPromotionApi) animaPromotionApi$delegate.getValue();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_performance_WindowAnimationBoostCoordinator_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public final void boost(String r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "source");
        if (r10 > 0) goto L25;
        FLogger.a.w(TAG, "boost ignored, source=" + r9 + ", durationMs=" + r10);
        return;
    L25:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L13
        AnimaPromotionApi r5 = getAnimaPromotionApi();     // Catch: Throwable -> L13
        if (r5 != null) goto L10;
        boolean r6 = false;
    L11:
        Object r7 = Result.constructor-impl(Boolean.valueOf(r6));     // Catch: Throwable -> L13
    L15:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L21;
        if (applyFailureLogged.compareAndSet(false, true) == false) goto L21;
        FLogger.a.d(TAG, "applyAssistantWindowAnimationBoost failed, source=" + r9 + ", durationMs=" + r10 + ", error=" + r8.getClass().getSimpleName());
    L21:
        if (Result.isSuccess-impl(r7) == false) goto L23;
        ((Boolean) r7).booleanValue();
        applyFailureLogged.set(false);
    L23:
        Result.isFailure-impl(r7);
        return;
    L10:
        r5.getApplyMethod().invoke(r5.getReceiver(), new Object[]{Integer.valueOf(r5.getType()), Integer.valueOf(r10)});     // Catch: Throwable -> L13
        r6 = true;
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
