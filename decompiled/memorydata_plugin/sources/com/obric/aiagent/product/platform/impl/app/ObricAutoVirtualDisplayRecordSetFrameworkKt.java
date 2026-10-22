package com.obric.aiagent.product.platform.impl.app;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aJ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u000e0\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\fH\u0000\u001a\u001c\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\rH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"ASSISTANT_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API", "Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetApiShape;", "getASSISTANT_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API", "()Lcom/obric/aiagent/product/platform/impl/app/AutoVirtualDisplayRecordSetApiShape;", "OBRIC_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API", "getOBRIC_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API", "isAutoVirtualDisplayRecordSetApiSupported", "", "api", "classLoader", "Ljava/lang/ClassLoader;", "onResolved", "Lkotlin/Function1;", "Ljava/lang/Class;", "", "onUnavailable", "", "BEGIN_METHOD_NAME", "", "ADD_METHOD_NAME", "END_METHOD_NAME", "requireStaticMethod", "method", "Ljava/lang/reflect/Method;", "returnType", "product-platform_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ObricAutoVirtualDisplayRecordSetFrameworkKt {
    private static final String ADD_METHOD_NAME = "addAutoVirtualDisplayRecordPackages";
    private static final AutoVirtualDisplayRecordSetApiShape ASSISTANT_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API = null;
    private static final String BEGIN_METHOD_NAME = "beginAutoVirtualDisplayRecordSet";
    private static final String END_METHOD_NAME = "endAutoVirtualDisplayRecordSet";
    private static final AutoVirtualDisplayRecordSetApiShape OBRIC_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API = null;

    static {
        ASSISTANT_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API = new AutoVirtualDisplayRecordSetApiShape("assistant", "android.app.AssistantActivityManager", "android.app.IAssistantAutoVirtualDisplayRecordSetListener", "com.obric.aiagent.product.platform.impl.app.AssistantAutoVirtualDisplayRecordSetOfficialApi");
        OBRIC_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API = new AutoVirtualDisplayRecordSetApiShape("obric", "android.app.ObricActivityManager", "android.app.IObricAutoVirtualDisplayRecordSetListener", "com.obric.aiagent.product.platform.impl.app.ObricAutoVirtualDisplayRecordSetOfficialApi");
    }

    public static final AutoVirtualDisplayRecordSetApiShape getASSISTANT_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API() {
        return ASSISTANT_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API;
    }

    public static final AutoVirtualDisplayRecordSetApiShape getOBRIC_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API() {
        return OBRIC_AUTO_VIRTUAL_DISPLAY_RECORD_SET_API;
    }

    public static final boolean isAutoVirtualDisplayRecordSetApiSupported(AutoVirtualDisplayRecordSetApiShape r7, ClassLoader r8, Function1<? super Class<?>, Unit> r9, Function1<? super Throwable, Unit> r10) {
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "api");
        Intrinsics.checkNotNullParameter(r11, "onResolved");
        Intrinsics.checkNotNullParameter(r12, "onUnavailable");
        Class<?> r4 = Class.forName(r7.getManagerClassName(), false, r8);     // Catch: Throwable -> L8
        Class<?> r5 = Class.forName(r7.getListenerClassName(), false, r8);     // Catch: Throwable -> L8
        if (r5.isAssignableFrom(Class.forName(r7.getListenerClassName() + "$Stub", false, r8)) == false) goto L7;
        Method r13 = r4.getMethod(BEGIN_METHOD_NAME, new Class[]{Integer.TYPE, Integer.TYPE, r5});     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r13, "getMethod(...)");     // Catch: Throwable -> L8
        Class r14 = Long.TYPE;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r14, "TYPE");     // Catch: Throwable -> L8
        requireStaticMethod(r13, r14);     // Catch: Throwable -> L8
        Method r15 = r4.getMethod(ADD_METHOD_NAME, new Class[]{Long.TYPE, String[].class});     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r15, "getMethod(...)");     // Catch: Throwable -> L8
        Class r16 = Boolean.TYPE;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r16, "TYPE");     // Catch: Throwable -> L8
        requireStaticMethod(r15, r16);     // Catch: Throwable -> L8
        Method r17 = r4.getMethod(END_METHOD_NAME, new Class[]{Long.TYPE});     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r17, "getMethod(...)");     // Catch: Throwable -> L8
        Class r18 = Void.TYPE;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r18, "TYPE");     // Catch: Throwable -> L8
        requireStaticMethod(r17, r18);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L8
        r11.invoke(r4);     // Catch: Throwable -> L8
        return true;
    L7:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L8
    L8:
        e = move-exception;
        r12.invoke(e);
        return false;
    }

    public static /* synthetic */ boolean isAutoVirtualDisplayRecordSetApiSupported$default(AutoVirtualDisplayRecordSetApiShape r1, ClassLoader r2, Function1 r3, Function1 r4, int r5, Object r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r7 = $$Lambda$ObricAutoVirtualDisplayRecordSetFrameworkKt$4cy93SjzgpZf0Xyq4Nm1EkIxOE.INSTANCE;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r8 = $$Lambda$ObricAutoVirtualDisplayRecordSetFrameworkKt$wT8wUhHHNFv2i4LTcuP8H1sWRkQ.INSTANCE;
    L9:
        return isAutoVirtualDisplayRecordSetApiSupported(r1, r2, r7, r8);
    }

    private static final Unit isAutoVirtualDisplayRecordSetApiSupported$lambda$0(Class r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private static final Unit isAutoVirtualDisplayRecordSetApiSupported$lambda$1(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$4cy93Sjz-gpZf0Xyq4Nm1EkIxOE, reason: not valid java name */
    public static /* synthetic */ Unit m177lambda$4cy93SjzgpZf0Xyq4Nm1EkIxOE(Class r0) {
        return isAutoVirtualDisplayRecordSetApiSupported$lambda$0(r0);
    }

    public static /* synthetic */ Unit lambda$wT8wUhHHNFv2i4LTcuP8H1sWRkQ(Throwable r0) {
        return isAutoVirtualDisplayRecordSetApiSupported$lambda$1(r0);
    }

    private static final void requireStaticMethod(Method r2, Class<?> r3) {
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L10;
        if (Intrinsics.areEqual(r2.getReturnType(), r3) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
