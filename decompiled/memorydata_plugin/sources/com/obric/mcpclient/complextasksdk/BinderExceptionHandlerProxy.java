package com.obric.mcpclient.complextasksdk;

import android.os.IInterface;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0007\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0014B#\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J0\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/BinderExceptionHandlerProxy;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/IInterface;", "Ljava/lang/reflect/InvocationHandler;", TypedValues.AttributesType.S_TARGET, LocationMonitorConst.TAG, "", "targetClass", "Ljava/lang/Class;", "(Landroid/os/IInterface;Ljava/lang/String;Ljava/lang/Class;)V", "Landroid/os/IInterface;", "getDefaultReturnValue", "", "method", "Ljava/lang/reflect/Method;", "invoke", "proxy", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Companion", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BinderExceptionHandlerProxy<T extends IInterface> implements InvocationHandler {
    public static final Companion Companion = null;
    private final String tag;
    private final T target;
    private final Class<T> targetClass;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0001\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/BinderExceptionHandlerProxy$Companion;", "", "()V", "createProxyInstance", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/IInterface;", "api", LocationMonitorConst.TAG, "", "(Landroid/os/IInterface;Ljava/lang/String;)Landroid/os/IInterface;", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final /* synthetic */ <T extends IInterface> T createProxyInstance(T r9, String r10) {
            T r11 = (T) ZeusTransformUtils.wrapperContextForParams(r9, IInterface.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r11, "api");
            Intrinsics.checkNotNullParameter(r10, LocationMonitorConst.TAG);
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L5
            ClassLoader r2 = ((Class) ZeusTransformUtils.preCheckCast(IInterface.class, Class.class, "com.obric.memorydata.plugin")).getClassLoader();     // Catch: Throwable -> L5
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L5
            Class[] r4 = {(Class) ZeusTransformUtils.preCheckCast(IInterface.class, Class.class, "com.obric.memorydata.plugin")};     // Catch: Throwable -> L5
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L5
            Object r1 = Proxy.newProxyInstance(r2, r4, (InvocationHandler) ZeusTransformUtils.preCheckCast(new BinderExceptionHandlerProxy(r11, r10, (Class) ZeusTransformUtils.preCheckCast(IInterface.class, Class.class, "com.obric.memorydata.plugin")), InvocationHandler.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Throwable -> L5
            return (T) ZeusTransformUtils.preCheckCast(r1, IInterface.class, "com.obric.memorydata.plugin");
        L5:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            Throwable r8 = Result.m1424exceptionOrNullimpl(Result.m1421constructorimpl(ResultKt.createFailure(th)));
            if (r8 == null) goto L9;
            Log.e(r10, "BinderExceptionHandlerProxy createProxyInstance for " + r11.getClass() + " fail", (Throwable) ZeusTransformUtils.preCheckCast(r8, Throwable.class, "com.obric.memorydata.plugin"));
        L9:
            return r11;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BinderExceptionHandlerProxy(T r3, String r4, Class<T> r5) {
        T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r3, IInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r4, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r5, "targetClass");
        this.target = r6;
        this.tag = r4;
        this.targetClass = r5;
    }

    private final Object getDefaultReturnValue(Method r2) {
        Class<?> r1 = r2.getReturnType();
        if (Intrinsics.areEqual(r1, Boolean.TYPE) == false) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r1, Character.TYPE) == false) goto L9;
        return (char) 0;
    L9:
        if (Intrinsics.areEqual(r1, Byte.TYPE) == false) goto L12;
        return (byte) 0;
    L12:
        if (Intrinsics.areEqual(r1, Short.TYPE) == false) goto L15;
        return (short) 0;
    L15:
        if (Intrinsics.areEqual(r1, Integer.TYPE) == false) goto L18;
        return 0;
    L18:
        if (Intrinsics.areEqual(r1, Long.TYPE) == false) goto L21;
        return 0L;
    L21:
        if (Intrinsics.areEqual(r1, Float.TYPE) == false) goto L24;
        return Float.valueOf(0.0f);
    L24:
        if (Intrinsics.areEqual(r1, Double.TYPE) == false) goto L27;
        return Double.valueOf(0.0d);
    L27:
        if (Intrinsics.areEqual(r1, Void.class) == true) goto L39;
        return null;
    L39:
        return Unit.INSTANCE;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r3, Method r4, Object[] r5) {
        Intrinsics.checkNotNullParameter(r3, "proxy");
        Intrinsics.checkNotNullParameter(r4, "method");
    L17:
        th = move-exception;
        Log.e(this.tag, "BinderExceptionHandlerProxy " + r4.getName() + " throw exception: " + ExceptionsKt.stackTraceToString(th));
        return getDefaultReturnValue(r4);
    L4:
        if (Intrinsics.areEqual(r4.getDeclaringClass(), this.targetClass) == true) goto L10;
        T r6 = this.target;     // Catch: Throwable -> L17
        if (r5 != null) goto L21;
        r5 = new Object[0];     // Catch: Throwable -> L17
    L21:
        return r4.invoke(r6, Arrays.copyOf(r5, r5.length));
    L10:
        if (this.target.asBinder().isBinderAlive() == false) goto L15;
        T r7 = this.target;     // Catch: Throwable -> L17
        if (r5 != null) goto L22;
        r5 = new Object[0];     // Catch: Throwable -> L17
    L22:
        return r4.invoke(r7, Arrays.copyOf(r5, r5.length));
    L15:
        Log.e(this.tag, "BinderExceptionHandlerProxy " + r4.getName() + " fail. Binder is already died.");     // Catch: Throwable -> L17
        return getDefaultReturnValue(r4);
    }
}
