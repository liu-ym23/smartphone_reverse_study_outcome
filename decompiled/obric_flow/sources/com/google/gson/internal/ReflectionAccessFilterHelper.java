package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectionAccessFilterHelper {

    /* JADX INFO: renamed from: com.google.gson.internal.ReflectionAccessFilterHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class AccessChecker {
        static final AccessChecker INSTANCE = null;

        static {
            if (JavaVersion.isJava9OrLater() == true) goto L12;
        L6:
            AccessChecker r5 = null;
        L7:
            if (r5 != null) goto L9;
            r5 = new AnonymousClass2();
        L9:
            INSTANCE = r5;
            return;
        L12:
            final Method r10 = AccessibleObject.class.getDeclaredMethod("canAccess", new Class[]{Object.class});     // Catch: NoSuchMethodException -> L11
            r5 = new AnonymousClass1(r10);     // Catch: NoSuchMethodException -> L11
            goto L7
        }

        private AccessChecker() {
        }

        public abstract boolean canAccess(AccessibleObject r5, Object r10);

        public /* synthetic */ AccessChecker(AnonymousClass1 r5) {
            this();
        }
    }

    private ReflectionAccessFilterHelper() {
    }

    public static boolean canAccess(AccessibleObject r5, Object r10) {
        return AccessChecker.INSTANCE.canAccess(r5, r10);
    }

    public static ReflectionAccessFilter.FilterResult getFilterResult(List<ReflectionAccessFilter> r5, Class<?> r10) {
        Iterator<ReflectionAccessFilter> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        ReflectionAccessFilter.FilterResult r12 = r11.next().check(r10);
        if (r12 == ReflectionAccessFilter.FilterResult.INDECISIVE) goto L4;
        return r12;
    L9:
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }

    public static boolean isAndroidType(Class<?> r5) {
        return isAndroidType(r5.getName());
    }

    public static boolean isAnyPlatformType(Class<?> r5) {
        String r10 = r5.getName();
        if (isAndroidType(r10) == false) goto L5;
    L12:
        return true;
    L5:
        if (r10.startsWith("kotlin.") == true) goto L12;
        if (r10.startsWith("kotlinx.") == true) goto L12;
        if (r10.startsWith("scala.") == true) goto L12;
        return false;
    }

    public static boolean isJavaType(Class<?> r5) {
        return isJavaType(r5.getName());
    }

    private static boolean isAndroidType(String r5) {
        if (r5.startsWith("android.") == false) goto L5;
    L10:
        return true;
    L5:
        if (r5.startsWith("androidx.") == true) goto L10;
        if (isJavaType(r5) == true) goto L10;
        return false;
    }

    private static boolean isJavaType(String r5) {
        if (r5.startsWith("java.") == false) goto L5;
    L8:
        return true;
    L5:
        if (r5.startsWith("javax.") == true) goto L8;
        return false;
    }
}
