package com.facebook.imagepipeline.producers;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface ProducerListener2 {
    void a(ProducerContext r5, String r10);

    void a(ProducerContext r5, String r10, Throwable r11, Map r12);

    void a(ProducerContext r5, String r10, HashMap r11);

    void a(ProducerContext r5, String r10, Map r11);

    void a(ProducerContext r5, String r10, boolean r11);

    void b(ProducerContext r5);

    boolean b(ProducerContext r5, String r10);
}
