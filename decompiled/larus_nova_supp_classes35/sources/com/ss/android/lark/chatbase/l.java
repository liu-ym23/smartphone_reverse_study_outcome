package com.ss.android.lark.chatbase;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface l<E> {
    void a(Function1<? super E, ? extends E> r1);

    k filter(Function1 r1);

    l<E> query(String r1);

    List<E> toList();
}
