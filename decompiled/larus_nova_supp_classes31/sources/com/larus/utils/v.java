package com.larus.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v {
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.activity.OnBackPressedCallback, com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1] */
    public static final FragmentExtKt$addOnBackPressed$callback$1 a(final Fragment r1, final Function0 r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "onBackPressed");
        ?? r0 = new FragmentExtKt$addOnBackPressed$callback$1(r2, r1);
        r1.requireActivity().getOnBackPressedDispatcher().addCallback(r1, r0);
        return r0;
    }

    public static final Fragment b(List r2, Class r3) {
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        Fragment r0 = (Fragment) r4.next();
        if (r3.isInstance(r0) == true) goto L7;
        if ((!r0.getChildFragmentManager().getFragments().isEmpty()) == false) goto L4;
        Fragment r1 = b(r0.getChildFragmentManager().getFragments(), r3);
        if (r1 == null) goto L4;
        return r1;
    L7:
        return r0;
    L13:
        return null;
    }

    public static final Fragment c(FragmentActivity r1, Class r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return b(r1.getSupportFragmentManager().getFragments(), r2);
    }
}
