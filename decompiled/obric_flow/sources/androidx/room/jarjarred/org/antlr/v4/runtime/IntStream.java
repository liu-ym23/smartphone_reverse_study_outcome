package androidx.room.jarjarred.org.antlr.v4.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface IntStream {
    public static final int EOF = -1;
    public static final String UNKNOWN_SOURCE_NAME = "<unknown>";

    int LA(int r5);

    void consume();

    String getSourceName();

    int index();

    int mark();

    void release(int r5);

    void seek(int r5);

    int size();
}
