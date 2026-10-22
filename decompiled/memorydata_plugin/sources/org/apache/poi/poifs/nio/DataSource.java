package org.apache.poi.poifs.nio;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes7.dex */
public abstract class DataSource {
    public DataSource() {
    }

    public abstract void close();

    public abstract ByteBuffer read(int r1, long r2);

    public abstract long size();

    public abstract void write(ByteBuffer r1, long r2);
}
