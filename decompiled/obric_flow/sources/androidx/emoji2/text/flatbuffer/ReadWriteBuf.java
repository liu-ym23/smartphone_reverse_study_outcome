package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte r5);

    void put(byte[] r5, int r10, int r11);

    void putBoolean(boolean r5);

    void putDouble(double r5);

    void putFloat(float r5);

    void putInt(int r5);

    void putLong(long r5);

    void putShort(short r5);

    boolean requestCapacity(int r5);

    void set(int r5, byte r10);

    void set(int r5, byte[] r10, int r11, int r12);

    void setBoolean(int r5, boolean r10);

    void setDouble(int r5, double r10);

    void setFloat(int r5, float r10);

    void setInt(int r5, int r10);

    void setLong(int r5, long r10);

    void setShort(int r5, short r10);

    int writePosition();
}
