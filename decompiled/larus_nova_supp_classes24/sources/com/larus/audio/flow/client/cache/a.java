package com.larus.audio.flow.client.cache;

import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface a {
    void a(String r1, boolean r2);

    void b(String r1, byte[] r2);

    void c(String r1);

    boolean contains(String r1);

    void delete(String r1);

    Flow<byte[]> query(String r1, int r2);
}
