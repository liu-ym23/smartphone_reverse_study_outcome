package jha;

import jha.o;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface i<S extends o> {
    q<S> a();

    Object b(q<S> r1, Long r2, Continuation<? super Boolean> r3);

    void destroy();

    a1 getEvents();
}
