package com.obric.assistant.interaction.impl.window;

import com.larus.utils.logger.FLogger;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002\u001a\"\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002\u001a*\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002\u001a\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a.\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\u0012"}, d2 = {"findField", "Ljava/lang/reflect/Field;", "clsStart", "Ljava/lang/Class;", "name", "", "setPrivateFieldSafely", "", "target", "", "fieldName", "value", "setPrivateFieldIfExists", "setPrivateFieldOrLog", "logTag", "findDeclaredField", "owner", "setDeclaredFieldIfExists", "impl_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowActivityKt {
    public static final /* synthetic */ Field access$findDeclaredField(Class r0, String r1) {
        return findDeclaredField(r0, r1);
    }

    private static final Field findDeclaredField(Class<?> r1, String r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Field r3 = r1.getDeclaredField(r2);     // Catch: Throwable -> L4
        r3.setAccessible(true);     // Catch: Throwable -> L4
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r4) == false) goto L10;
        r4 = null;
    L10:
        return (Field) r4;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private static final Field findField(Class<?> r2, String r3) {
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

    public static final /* synthetic */ void access$setPrivateFieldIfExists(Object r0, String r1, Object r2) {
        setPrivateFieldIfExists(r0, r1, r2);
    }

    public static final /* synthetic */ void access$setPrivateFieldSafely(Object r0, String r1, Object r2) {
        setPrivateFieldSafely(r0, r1, r2);
    }

    private static final void setPrivateFieldIfExists(Object r1, String r2, Object r3) {
        Field r4 = findField(r1.getClass(), r2);
        if (r4 == null) goto L6;
        r4.set(r1, r3);
        return;
    }

    private static final void setPrivateFieldSafely(Object r2, String r3, Object r4) {
        Field r0 = findField(r2.getClass(), r3);
        if (r0 == null) goto L7;
        r0.set(r2, r4);
        return;
    L7:
        throw new IllegalStateException(("Field " + r3 + " not found in " + r2.getClass()).toString());
    }

    public static final /* synthetic */ void access$setDeclaredFieldIfExists(Object r0, Class r1, String r2, Object r3) {
        setDeclaredFieldIfExists(r0, r1, r2, r3);
    }

    public static final /* synthetic */ void access$setPrivateFieldOrLog(Object r0, String r1, Object r2, String r3) {
        setPrivateFieldOrLog(r0, r1, r2, r3);
    }

    private static final void setDeclaredFieldIfExists(Object r0, Class<?> r1, String r2, Object r3) {
        Field r4 = findDeclaredField(r1, r2);
        if (r4 == null) goto L6;
        r4.set(r0, r3);
        return;
    }

    private static final void setPrivateFieldOrLog(Object r2, String r3, Object r4, String r5) {
        Field r0 = findField(r2.getClass(), r3);
        if (r0 != null) goto L6;
        FLogger.a.w(r5, "Field " + r3 + " not found in " + r2.getClass().getName());
        return;
    L6:
        r0.set(r2, r4);
    }
}
