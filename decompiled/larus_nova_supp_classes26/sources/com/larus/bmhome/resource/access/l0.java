package com.larus.bmhome.resource.access;

import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface l0 {
    Object c(h0 r1, Continuation<? super g> r2);

    ResourcePhase d();

    boolean e(h0 r1);

    List<String> f();

    ResourceNodeCompletionMode g();

    String getKey();

    boolean h();
}
