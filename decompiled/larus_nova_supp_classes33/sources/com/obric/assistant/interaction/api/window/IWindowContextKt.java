package com.obric.assistant.interaction.api.window;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0017\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b\u001a\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\tH\u0002\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0011H\u0002\u001a\f\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001e\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"WINDOW_CONTEXT_TAG", "", "logWindowContextCheck", "", "msg", "Lkotlin/Function0;", "findFieldRecursive", "Ljava/lang/reflect/Field;", "clsStart", "Ljava/lang/Class;", "name", "OUTER_CONTEXT_ACCESSOR_CACHE", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/interaction/api/window/OuterContextAccessor;", "buildOuterContextAccessor", "cls", "tryGetOuterContextFromContextImpl", "Landroid/content/Context;", "isWindowContext", "", "api_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IWindowContextKt {
    private static final ConcurrentHashMap<Class<?>, OuterContextAccessor> OUTER_CONTEXT_ACCESSOR_CACHE = null;
    private static final String WINDOW_CONTEXT_TAG = "ObricWindowContext";

    public static /* synthetic */ OuterContextAccessor a(Function1 r0, Object r1) {
        return tryGetOuterContextFromContextImpl$lambda$9(r0, r1);
    }

    public static /* synthetic */ OuterContextAccessor b(Class r0) {
        return tryGetOuterContextFromContextImpl$lambda$8(r0);
    }

    private static final void logWindowContextCheck(Function0<String> r0) {
    }

    static {
        OUTER_CONTEXT_ACCESSOR_CACHE = new ConcurrentHashMap();
    }

    private static final OuterContextAccessor buildOuterContextAccessor(Class<?> r5) {
        if (StringsKt.endsWith$default(r5.getName(), "ContextImpl", false, 2, null) == false) goto L5;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Method r1 = r5.getDeclaredMethod("getOuterContext", new Class[0]);     // Catch: Throwable -> L8
        r1.setAccessible(true);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L8
        return new MethodOuterContextAccessor(r1);
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        Field r6 = findFieldRecursive(r5, "mOuterContext");     // Catch: Throwable -> L16
        if (r6 != null) goto L13;
        Object r7 = NoOuterContextAccessor.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L16
    L18:
        Result.exceptionOrNull-impl(r8);
        NoOuterContextAccessor r3 = NoOuterContextAccessor.INSTANCE;
        if (Result.isFailure-impl(r8) == false) goto L22;
        r8 = r3;
    L22:
        return (OuterContextAccessor) r8;
    L13:
        r7 = new FieldOuterContextAccessor(r6);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        return NoOuterContextAccessor.INSTANCE;
    }

    public static final boolean isWindowContext(Context r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof Application) == false) goto L8;
        return false;
    L8:
        IdentityHashMap r1 = new IdentityHashMap(8);
        int r2 = 0;
    L10:
        if (r1.put(r5, Boolean.TRUE) != null) goto L38;
        int r3 = r2 + 1;
        if (r2 >= 32) goto L38;
        if ((r5 instanceof IChatWindowActivity) == true) goto L43;
        if ((r5 instanceof IWindowContext) == true) goto L56;
        Context r4 = tryGetOuterContextFromContextImpl(r5);
        if (r4 == null) goto L31;
        if (r4 == r5) goto L31;
        if ((r4 instanceof Application) == true) goto L25;
        if (r1.containsKey(r4) == true) goto L38;
    L29:
        r5 = r4;
        r2 = r3;
        goto L10
    L25:
        return false;
    L31:
        if ((r5 instanceof ContextWrapper) == false) goto L33;
        ContextWrapper r6 = (ContextWrapper) r5;
    L34:
        if (r6 == null) goto L38;
        r4 = r6.getBaseContext();
        if (r4 == r5) goto L38;
        if ((r4 instanceof Application) == true) goto L41;
        Intrinsics.checkNotNull(r4);
        goto L29
    L41:
        return false;
    L33:
        r6 = null;
        goto L34
    L56:
        return true;
    L43:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.assistant.interaction.api.window.a] */
    private static final Context tryGetOuterContextFromContextImpl(Context r4) {
        Class<?> r0 = r4.getClass();
        ConcurrentHashMap<Class<?>, OuterContextAccessor> r1 = OUTER_CONTEXT_ACCESSOR_CACHE;
        final ?? r2 = new a();
        Context r5 = r1.computeIfAbsent(r0, new b(r2)).getOuter(r4);
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5;
    }

    private static final OuterContextAccessor tryGetOuterContextFromContextImpl$lambda$8(Class r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return buildOuterContextAccessor(r1);
    }

    private static final Field findFieldRecursive(Class<?> r2, String r3) {
    L2:
        if (r2 == null) goto L6;
        Field r0 = r2.getDeclaredField(r3);     // Catch: NoSuchFieldException -> L5
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return r0;
    L5:
        r2 = r2.getSuperclass();
        goto L2
    L6:
        return null;
    }

    private static final OuterContextAccessor tryGetOuterContextFromContextImpl$lambda$9(Function1 r0, Object r1) {
        return (OuterContextAccessor) r0.invoke(r1);
    }
}
