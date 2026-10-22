package com.ss.ugc.effectplatform.cache;

import bytekn.foundation.io.file.b;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface j {
    void a(long r1, Function2<? super Integer, ? super Long, Unit> r3);

    long b(String r1, b r2);

    void c(List<String> r1);

    void clear();

    void d(String r1);

    boolean has(String r1);

    b queryToStream(String r1);

    String queryToValue(String r1);

    boolean remove(String r1);

    void removePattern(String r1);

    long save(String r1, String r2);
}
