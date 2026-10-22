package com.bytedance.ai.applet.db;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface a {
    Object a(String r1, Continuation<? super i> r10);

    Object b(i r1, Continuation<? super Long> r10);

    Object delete(i r1, Continuation<? super Unit> r10);

    Object insert(i r1, Continuation<? super Unit> r10);

    Object update(i r1, Continuation<? super Unit> r10);
}
