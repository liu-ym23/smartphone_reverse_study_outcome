package com.obric.miniapp.alarm;

import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface b {
    Object a(Continuation<? super List<a>> r1);

    Object b(w r1, Continuation<? super List<a>> r2);

    Object c(String r1, Continuation<? super a> r2);

    Object d(Continuation<? super List<String>> r1);

    Object delete(String r1, String r2, Continuation<? super Integer> r3);

    Object e(Continuation<? super w> r1);

    Object insert(a r1, Continuation<? super Long> r2);

    Object update(String r1, w r2, int r3, String r4, Continuation<? super Integer> r5);
}
