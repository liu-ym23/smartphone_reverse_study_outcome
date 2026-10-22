package org.apache.poi.ddf;

/* JADX INFO: loaded from: classes6.dex */
public interface EscherSerializationListener {
    void afterRecordSerialize(int r1, short r2, int r3, EscherRecord r4);

    void beforeRecordSerialize(int r1, short r2, EscherRecord r3);
}
