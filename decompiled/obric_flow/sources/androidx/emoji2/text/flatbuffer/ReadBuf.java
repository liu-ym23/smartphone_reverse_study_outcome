package androidx.emoji2.text.flatbuffer;

/* JADX INFO: loaded from: classes.dex */
interface ReadBuf {
    byte[] data();

    byte get(int r5);

    boolean getBoolean(int r5);

    double getDouble(int r5);

    float getFloat(int r5);

    int getInt(int r5);

    long getLong(int r5);

    short getShort(int r5);

    String getString(int r5, int r10);

    int limit();
}
