package com.obric.aiagent.product.platform.api.memory;

import android.os.Bundle;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.platform.a.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001aH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG", "", "newMemoryActionCallbackWrapperProxy", "", "wrapperInterfaceName", "onAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "actionType", "Landroid/os/Bundle;", "extras", "", "product-platform_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ObricMemoryActionCallbackKt {
    private static final String TAG = "ObricMemoryActionCallback";

    public static /* synthetic */ Object lambda$CcLZm6fTbYwfvt3hrU9ecms5AkM(Function2 r0, String r1, Object r2, Method r3, Object[] r4) {
        return newMemoryActionCallbackWrapperProxy$lambda$1(r0, r1, r2, r3, r4);
    }

    private static final Object newMemoryActionCallbackWrapperProxy(final String r4, Function2<? super Integer, ? super Bundle, Unit> r5) {
        final Function2 r6 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Class r0 = ZeusTransformUtils.forName(r4, "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L10
        if (r0.isInterface() == false) goto L9;
        Object r7 = Proxy.newProxyInstance(r0.getClassLoader(), new Class[]{r0}, new $$Lambda$ObricMemoryActionCallbackKt$CcLZm6fTbYwfvt3hrU9ecms5AkM(r6, r4));
        Intrinsics.checkNotNullExpressionValue(r7, "newProxyInstance(...)");
        return r7;
    L9:
        throw new IllegalArgumentException(("Callback wrapper must be an interface for Proxy to work: " + r4).toString());
    L10:
        e = move-exception;
        d.f5954a.b(TAG, "Callback wrapper not found: " + r4, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        throw e;
    }

    private static final Object newMemoryActionCallbackWrapperProxy$lambda$1(Function2 r5, String r6, Object r7, Method r8, Object[] r9) {
        Function2 r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        String r11 = r8.getName();
        Object r0 = null;
        if (r11 == null) goto L56;
        boolean r3 = true;
        switch(r11.hashCode()) {
            case -1776922004: goto L52;
            case -1295482945: goto L43;
            case 147696667: goto L39;
            case 975459573: goto L8;
            default: goto L60;
        };
    L60:
        return null;
    L8:
        if (r11.equals("onAction") == false) goto L61;
        if (r9 == null) goto L12;
        Object r12 = ArraysKt.getOrNull(r9, 0);
    L14:
        if (ZeusTransformUtils.instanceOf(r12, Number.class) == false) goto L16;
        Number r13 = (Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin");
    L17:
        if (r13 == null) goto L33;
        int r14 = r13.intValue();
        if (r9 == null) goto L21;
        Object r15 = ArraysKt.getOrNull(r9, 1);
    L23:
        if (ZeusTransformUtils.instanceOf(r15, Bundle.class) == false) goto L25;
        Bundle r16 = (Bundle) ZeusTransformUtils.preCheckCast(r15, Bundle.class, "com.obric.memorydata.plugin");
    L26:
        if (r16 != null) goto L32;
        StringBuilder r17 = new StringBuilder().append("onAction[1] is not Bundle: ");
        if (r9 == null) goto L31;
        r0 = ArraysKt.getOrNull(r9, 1);
    L31:
        throw new IllegalArgumentException(r17.append(r0).toString());
    L32:
        r10.invoke(Integer.valueOf(r14), r16);
        return null;
    L25:
        r16 = null;
        goto L26
    L21:
        r15 = null;
        goto L23
    L33:
        StringBuilder r18 = new StringBuilder().append("onAction[0] is not a number: ");
        if (r9 == null) goto L37;
        r0 = ArraysKt.getOrNull(r9, 0);
    L37:
        throw new IllegalArgumentException(r18.append(r0).toString());
    L16:
        r13 = null;
        goto L17
    L12:
        r12 = null;
        goto L14
    L61:
        return null;
    L39:
        if (r11.equals("hashCode") == true) goto L58;
        return null;
    L58:
        return Integer.valueOf(System.identityHashCode(r7));
    L43:
        if (r11.equals("equals") == false) goto L63;
        if (r9 == null) goto L47;
        r0 = ArraysKt.getOrNull(r9, 0);
    L47:
        if (r7 == r0) goto L59;
        r3 = false;
    L59:
        return Boolean.valueOf(r3);
    L63:
        return null;
    L52:
        if (r11.equals("toString") == true) goto L55;
        return null;
    L55:
        return "Proxy(" + r6 + ')';
    L56:
        return null;
    }
}
