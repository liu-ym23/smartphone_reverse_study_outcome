package com.obric.aikernel.res.downloader;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final /* synthetic */ int a(List r10, Object r11) {
        return e(r10, r11);
    }

    public static final int b(Collection<Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "taskCompletedStates");
        int r11 = 0;
        if (r10.isEmpty() == true) goto L13;
        Iterator<T> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        if ((!((Boolean) r12.next()).booleanValue()) == false) goto L7;
        r11 = r11 + 1;
        if (r11 >= 0) goto L7;
        CollectionsKt.throwCountOverflow();
    L13:
        return r11;
    }

    public static final <T> int c(List<T> r10, T r11, Function2<? super T, ? super T, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "orderedTasks");
        Intrinsics.checkNotNullParameter(r12, "shouldInsertBefore");
        int r13 = e(r10, r11);
        Iterator<T> r14 = r10.iterator();
        int r15 = 0;
    L4:
        if (r14.hasNext() == false) goto L9;
        if (r12.invoke(r11, r14.next()).booleanValue() == true) goto L10;
        r15 = r15 + 1;
    L10:
        if (r15 != (-1)) goto L12;
        r10.add(r11);
    L13:
        return r13;
    L12:
        r10.add(r15, r11);
        goto L13
    L9:
        r15 = -1;
        goto L10
    }

    public static final Integer d(Integer r10, int r11) {
        if (r11 < 100) goto L5;
        return null;
    L5:
        if (r11 < 10) goto L18;
        Integer r12 = Integer.valueOf((r11 / 10) * 10);
        int r13 = r12.intValue();
        boolean r14 = false;
        if (r10 == null) goto L10;
        int r15 = r10.intValue();
    L11:
        if (r13 <= r15) goto L13;
        r14 = true;
    L13:
        if (r14 == true) goto L15;
        return null;
    L15:
        return r12;
    L10:
        r15 = 0;
        goto L11
    L18:
        return null;
    }

    private static final <T> int e(List<T> r10, T r11) {
        int r12 = 0;
    L4:
        if (r10.remove(r11) == false) goto L6;
        r12 = r12 + 1;
        goto L4
    L6:
        return r12;
    }

    public static final boolean f(boolean r10, int r11) {
        if (r10 == false) goto L5;
        if (r11 <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
