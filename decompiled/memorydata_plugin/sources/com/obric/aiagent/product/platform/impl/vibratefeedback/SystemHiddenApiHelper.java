package com.obric.aiagent.product.platform.impl.vibratefeedback;

import android.app.Application;
import android.os.Vibrator;
import com.obric.aiagent.platform.a.a;
import com.obric.aiagent.platform.a.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR!\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/vibratefeedback/SystemHiddenApiHelper;", "", "<init>", "()V", "TAG", "", "windowSessionObj", "getWindowSessionObj", "()Ljava/lang/Object;", "windowSessionObj$delegate", "Lkotlin/Lazy;", "vibrator", "Landroid/os/Vibrator;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator$delegate", "vibratorSmtClass", "Ljava/lang/Class;", "getVibratorSmtClass", "()Ljava/lang/Class;", "vibratorSmtClass$delegate", "vibratePlayer", "Ljava/lang/reflect/Method;", "getVibratePlayer", "()Ljava/lang/reflect/Method;", "vibratePlayer$delegate", "performVibratorSmtFeedback", "", "effect", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SystemHiddenApiHelper {
    public static final SystemHiddenApiHelper INSTANCE = null;
    private static final String TAG = "SystemHiddenApiHelper";
    private static final Lazy vibratePlayer$delegate = null;
    private static final Lazy vibrator$delegate = null;
    private static final Lazy vibratorSmtClass$delegate = null;
    private static final Lazy windowSessionObj$delegate = null;

    static {
        INSTANCE = new SystemHiddenApiHelper();
        windowSessionObj$delegate = LazyKt.lazy($$Lambda$SystemHiddenApiHelper$ucHM4XF0CPCMAb6ExE3a_r8MKnc.INSTANCE);
        vibrator$delegate = LazyKt.lazy($$Lambda$SystemHiddenApiHelper$VDSESBaVnaKpHzfe6oULEAn4otg.INSTANCE);
        vibratorSmtClass$delegate = LazyKt.lazy($$Lambda$SystemHiddenApiHelper$CjbuHhzskHvF1pJi6Xo23XaILg.INSTANCE);
        vibratePlayer$delegate = LazyKt.lazy($$Lambda$SystemHiddenApiHelper$uTri8QdQN6g2Mlbwjalrr1xW8.INSTANCE);
    }

    private SystemHiddenApiHelper() {
    }

    private final Method getVibratePlayer() {
        return (Method) ZeusTransformUtils.preCheckCast(vibratePlayer$delegate.getValue(), Method.class, "com.obric.memorydata.plugin");
    }

    private final Vibrator getVibrator() {
        return (Vibrator) ZeusTransformUtils.preCheckCast(vibrator$delegate.getValue(), Vibrator.class, "com.obric.memorydata.plugin");
    }

    private final Class<?> getVibratorSmtClass() {
        return (Class) ZeusTransformUtils.preCheckCast(vibratorSmtClass$delegate.getValue(), Class.class, "com.obric.memorydata.plugin");
    }

    private final Object getWindowSessionObj() {
        return windowSessionObj$delegate.getValue();
    }

    /* JADX INFO: renamed from: lambda$CjbuHhzskHvF1pJi6Xo2-3XaILg, reason: not valid java name */
    public static /* synthetic */ Class m180lambda$CjbuHhzskHvF1pJi6Xo23XaILg() {
        return vibratorSmtClass_delegate$lambda$2();
    }

    public static /* synthetic */ Vibrator lambda$VDSESBaVnaKpHzfe6oULEAn4otg() {
        return vibrator_delegate$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$uTri8QdQ-N6g2Ml-bwjalrr1xW8, reason: not valid java name */
    public static /* synthetic */ Method m181lambda$uTri8QdQN6g2Mlbwjalrr1xW8() {
        return vibratePlayer_delegate$lambda$3();
    }

    public static /* synthetic */ Object lambda$ucHM4XF0CPCMAb6ExE3a_r8MKnc() {
        return windowSessionObj_delegate$lambda$0();
    }

    private static final Method vibratePlayer_delegate$lambda$3() {
        Class<?> r1 = INSTANCE.getVibratorSmtClass();     // Catch: Throwable -> L7
        if (r1 == null) goto L12;
        return r1.getMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});
    L12:
        return null;
    L7:
        th = move-exception;
        f.f5958b.b(TAG, "get vibratePlayer error!", th);
        return null;
    }

    private static final Class vibratorSmtClass_delegate$lambda$2() {
        return ZeusTransformUtils.forName("bytedanceos.api.VibratorSmt", "com.obric.memorydata.plugin");
    L4:
        th = move-exception;
        f.f5958b.b(TAG, "get vibratorSmtClass error!", th);
        return null;
    }

    private static final Vibrator vibrator_delegate$lambda$1() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getSystemService("vibrator");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.Vibrator");
        return (Vibrator) ZeusTransformUtils.preCheckCast(r0, Vibrator.class, "com.obric.memorydata.plugin");
    }

    private static final Object windowSessionObj_delegate$lambda$0() {
        return ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.memorydata.plugin").getMethod("getWindowSession", new Class[0]).invoke(null, new Object[0]);
    L5:
        th = move-exception;
        f.f5958b.b(TAG, "get windowSessionObj error!", th);
        return null;
    }

    public final void performVibratorSmtFeedback(String r6) {
        Intrinsics.checkNotNullParameter(r6, "effect");
        f.f5958b.a(TAG, "performVibratorSmtFeedback " + r6);
        Class<?> r5 = getVibratorSmtClass();     // Catch: Throwable -> L14
        if (r5 == null) goto L8;
        Field r7 = r5.getField(r6);     // Catch: Throwable -> L14
        if (r7 == null) goto L8;
        Integer r8 = Integer.valueOf(r7.getInt(null));     // Catch: Throwable -> L14
    L9:
        if (r8 == null) goto L19;
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L14
        SystemHiddenApiHelper r10 = INSTANCE;     // Catch: Throwable -> L14
        Method r1 = r10.getVibratePlayer();     // Catch: Throwable -> L14
        if (r1 == null) goto L20;
        r1.invoke(null, new Object[]{r10.getVibrator(), Integer.valueOf(r9)});     // Catch: Throwable -> L14
        return;
    L20:
        return;
    L19:
        return;
    L8:
        r8 = null;
    L14:
        th = move-exception;
        f.f5958b.b(TAG, "vibrator invoke failed", th);
    }
}
