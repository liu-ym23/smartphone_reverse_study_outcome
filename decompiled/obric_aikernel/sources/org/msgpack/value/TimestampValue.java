package org.msgpack.value;

import java.time.Instant;

/* JADX INFO: loaded from: classes3.dex */
public interface TimestampValue extends ExtensionValue {
    long getEpochSecond();

    int getNano();

    long toEpochMillis();

    Instant toInstant();
}
