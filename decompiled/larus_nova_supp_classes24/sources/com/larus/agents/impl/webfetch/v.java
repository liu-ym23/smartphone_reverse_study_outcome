package com.larus.agents.impl.webfetch;

import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface v extends Closeable {
    InputStream C4();

    int getStatus();

    String header(String r1);
}
