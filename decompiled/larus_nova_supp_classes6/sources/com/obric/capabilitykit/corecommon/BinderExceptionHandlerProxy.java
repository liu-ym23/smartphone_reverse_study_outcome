package com.obric.capabilitykit.corecommon;

import android.os.IInterface;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0007\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0014B#\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J0\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/corecommon/BinderExceptionHandlerProxy;", "T", "Landroid/os/IInterface;", "Ljava/lang/reflect/InvocationHandler;", "target", "tag", "", "targetClass", "Ljava/lang/Class;", "(Landroid/os/IInterface;Ljava/lang/String;Ljava/lang/Class;)V", "Landroid/os/IInterface;", "getDefaultReturnValue", "", "method", "Ljava/lang/reflect/Method;", "invoke", "proxy", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class BinderExceptionHandlerProxy<T extends IInterface> implements InvocationHandler {
    public static final Companion Companion = null;
    private final String tag;
    private final T target;
    private final Class<T> targetClass;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0001\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0086\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/corecommon/BinderExceptionHandlerProxy$Companion;", "", "()V", "createProxyInstance", "T", "Landroid/os/IInterface;", "api", "tag", "", "(Landroid/os/IInterface;Ljava/lang/String;)Landroid/os/IInterface;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final /* synthetic */ <T extends IInterface> T createProxyInstance(T r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "api");
            Intrinsics.checkNotNullParameter(r9, "tag");
            Intrinsics.reifiedOperationMarker(4, "T");     // Catch: Throwable -> L5
            ClassLoader r2 = IInterface.class.getClassLoader();     // Catch: Throwable -> L5
            Intrinsics.reifiedOperationMarker(4, "T");     // Catch: Throwable -> L5
            Intrinsics.reifiedOperationMarker(4, "T");     // Catch: Throwable -> L5
            Object r10 = Proxy.newProxyInstance(r2, new Class[]{IInterface.class}, new BinderExceptionHandlerProxy(r8, r9, IInterface.class));     // Catch: Throwable -> L5
            Intrinsics.reifiedOperationMarker(1, "T");     // Catch: Throwable -> L5
            return (T) r10;
        L5:
            th = move-exception;
            if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th))) == null) goto L9;
            r8.getClass().toString();
        L9:
            return r8;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BinderExceptionHandlerProxy(T r2, String r3, Class<T> r4) {
        Intrinsics.checkNotNullParameter(r2, "target");
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "targetClass");
        this.target = r2;
        this.tag = r3;
        this.targetClass = r4;
    }

    private final Object getDefaultReturnValue(Method r3) {
        Class<?> r4 = r3.getReturnType();
        if (Intrinsics.areEqual(r4, Boolean.TYPE) == false) goto L6;
        return Boolean.FALSE;
    L6:
        if (Intrinsics.areEqual(r4, Character.TYPE) == false) goto L9;
        return (char) 0;
    L9:
        if (Intrinsics.areEqual(r4, Byte.TYPE) == false) goto L12;
        return (byte) 0;
    L12:
        if (Intrinsics.areEqual(r4, Short.TYPE) == false) goto L15;
        return (short) 0;
    L15:
        if (Intrinsics.areEqual(r4, Integer.TYPE) == false) goto L18;
        return 0;
    L18:
        if (Intrinsics.areEqual(r4, Long.TYPE) == false) goto L21;
        return 0L;
    L21:
        if (Intrinsics.areEqual(r4, Float.TYPE) == false) goto L24;
        return Float.valueOf(0.0f);
    L24:
        if (Intrinsics.areEqual(r4, Double.TYPE) == false) goto L27;
        return Double.valueOf(0.0d);
    L27:
        if (Intrinsics.areEqual(r4, Void.class) == true) goto L39;
        return null;
    L39:
        return Unit.INSTANCE;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r2, Method r3, Object[] r4) {
        Intrinsics.checkNotNullParameter(r2, "proxy");
        Intrinsics.checkNotNullParameter(r3, "method");
    L17:
        th = move-exception;
        r3.getName();
        ExceptionsKt.stackTraceToString(th);
        return getDefaultReturnValue(r3);
    L4:
        if (Intrinsics.areEqual(r3.getDeclaringClass(), this.targetClass) == true) goto L10;
        T r5 = this.target;     // Catch: Throwable -> L17
        if (r4 != null) goto L21;
        r4 = new Object[0];     // Catch: Throwable -> L17
    L21:
        return r3.invoke(r5, Arrays.copyOf(r4, r4.length));
    L10:
        if (this.target.asBinder().isBinderAlive() == false) goto L15;
        T r6 = this.target;     // Catch: Throwable -> L17
        if (r4 != null) goto L22;
        r4 = new Object[0];     // Catch: Throwable -> L17
    L22:
        return r3.invoke(r6, Arrays.copyOf(r4, r4.length));
    L15:
        r3.getName();     // Catch: Throwable -> L17
        return getDefaultReturnValue(r3);
    }
}
