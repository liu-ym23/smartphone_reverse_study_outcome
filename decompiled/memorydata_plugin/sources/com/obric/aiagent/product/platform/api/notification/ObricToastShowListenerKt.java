package com.obric.aiagent.product.platform.api.notification;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a(\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a\u000e\u0010\f\u001a\u00020\b*\u0004\u0018\u00010\u0003H\u0002\u001a\u0018\u0010\r\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"TOAST_SHOW_CALLBACK_METHOD", "", "newObricToastShowListenerProxy", "", "listenerClass", "Ljava/lang/Class;", "onToastShown", "Lkotlin/Function1;", "Lcom/obric/aiagent/product/platform/api/notification/ToastShowInfo;", "", "defaultValueFor", "returnType", "toToastShowInfo", "readProperty", ActivityLifecycle.NAME, "product-platform_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ObricToastShowListenerKt {
    private static final String TOAST_SHOW_CALLBACK_METHOD = "onToastShow";

    private static final Object defaultValueFor(Class<?> r2) {
        if (Intrinsics.areEqual(r2, Boolean.TYPE) == false) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r2, Byte.TYPE) == false) goto L9;
        return (byte) 0;
    L9:
        if (Intrinsics.areEqual(r2, Short.TYPE) == false) goto L12;
        return (short) 0;
    L12:
        if (Intrinsics.areEqual(r2, Integer.TYPE) == false) goto L15;
        return 0;
    L15:
        if (Intrinsics.areEqual(r2, Long.TYPE) == false) goto L18;
        return 0L;
    L18:
        if (Intrinsics.areEqual(r2, Float.TYPE) == false) goto L21;
        return Float.valueOf(0.0f);
    L21:
        if (Intrinsics.areEqual(r2, Double.TYPE) == false) goto L24;
        return Double.valueOf(0.0d);
    L24:
        if (Intrinsics.areEqual(r2, Character.TYPE) == true) goto L35;
        return null;
    L35:
        return (char) 0;
    }

    /* JADX INFO: renamed from: lambda$SxIYfqD_lGfHxe4pBpV4F-5Zpa8, reason: not valid java name */
    public static /* synthetic */ Object m168lambda$SxIYfqD_lGfHxe4pBpV4F5Zpa8(Class r0, Function1 r1, Object r2, Method r3, Object[] r4) {
        return newObricToastShowListenerProxy$lambda$1(r0, r1, r2, r3, r4);
    }

    public static final Object newObricToastShowListenerProxy(final Class<?> r3, Function1<? super ToastShowInfo, Unit> r4) {
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "listenerClass");
        Intrinsics.checkNotNullParameter(r5, "onToastShown");
        if (r3.isInterface() == false) goto L7;
        Object r6 = Proxy.newProxyInstance(r3.getClassLoader(), new Class[]{r3}, new $$Lambda$ObricToastShowListenerKt$SxIYfqD_lGfHxe4pBpV4F5Zpa8(r3, r5));
        Intrinsics.checkNotNullExpressionValue(r6, "newProxyInstance(...)");
        return r6;
    L7:
        throw new IllegalArgumentException(("Toast listener must be an interface: " + r3.getName()).toString());
    }

    private static final Object newObricToastShowListenerProxy$lambda$1(Class r5, Function1 r6, Object r7, Method r8, Object[] r9) {
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (Intrinsics.areEqual(r8.getDeclaringClass(), Object.class) == false) goto L32;
        String r11 = r8.getName();
        if (r11 == null) goto L42;
        int r0 = r11.hashCode();
        if (r0 == (-1776922004)) goto L28;
        if (r0 == (-1295482945)) goto L18;
        if (r0 != 147696667) goto L42;
        if (r11.equals("hashCode") == false) goto L42;
        return Integer.valueOf(System.identityHashCode(r7));
    L18:
        if (r11.equals("equals") == false) goto L42;
        if (r9 == null) goto L22;
        Object r12 = ArraysKt.getOrNull(r9, 0);
    L23:
        if (r7 == r12) goto L45;
        r2 = false;
    L45:
        return Boolean.valueOf(r2);
    L22:
        r12 = null;
        goto L23
    L28:
        if (r11.equals("toString") == false) goto L42;
        return "ObricToastShowListenerProxy(" + r5.getName() + ')';
    L42:
        Class<?> r13 = r8.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r13, "getReturnType(...)");
        return defaultValueFor(r13);
    L32:
        if (Intrinsics.areEqual(r8.getName(), TOAST_SHOW_CALLBACK_METHOD) == false) goto L42;
        if (r8.getParameterTypes().length != 1) goto L42;
        if (r9 != null) goto L37;
    L39:
        r2 = false;
    L40:
        if (r2 == false) goto L42;
        r10.invoke(toToastShowInfo(r9[0]));
        goto L42
    L37:
        if (r9.length != 1) goto L39;
        goto L39
    }

    private static final Object readProperty(Object r6, String r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        StringBuilder r1 = new StringBuilder().append("get");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        char r3 = Character.toUpperCase(r7.charAt(0));
        String r4 = r7.substring(1);
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String).substring(startIndex)");
        String r5 = r3 + r4;
    L12:
        String r8 = r1.append(r5).toString();
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L15
        Object r10 = Result.m1421constructorimpl(r6.getClass().getField(r7).get(r6));     // Catch: Throwable -> L15
    L18:
        if (Result.m1424exceptionOrNullimpl(r10) == null) goto L26;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L22
        Object r12 = Result.m1421constructorimpl(r6.getClass().getMethod(r8, new Class[0]).invoke(r6, new Object[0]));     // Catch: Throwable -> L22
    L24:
        r10 = r12;
    L22:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L26:
        if (Result.m1427isFailureimpl(r10) == false) goto L29;
        return null;
    L29:
        return r10;
    L15:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    L11:
        r5 = r7;
        goto L12
    L8:
        r2 = false;
        goto L9
    }

    private static final ToastShowInfo toToastShowInfo(Object r8) {
        Object r0 = readProperty(r8, "type");
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.toString();
    L6:
        Object r9 = readProperty(r8, Params.CONTENT);
        if (r9 == null) goto L9;
        r1 = r9.toString();
    L9:
        if (r1 != null) goto L11;
        String r10 = "";
    L13:
        return new ToastShowInfo(r2, r10, 0, 4, null);
    L11:
        r10 = r1;
        goto L13
    L5:
        r2 = null;
        goto L6
    }
}
