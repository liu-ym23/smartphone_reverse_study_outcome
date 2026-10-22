package androidx.room.jarjarred.org.antlr.runtime;

/* JADX INFO: loaded from: classes.dex */
public interface IntStream {
    int LA(int r5);

    void consume();

    String getSourceName();

    int index();

    int mark();

    void release(int r5);

    void rewind();

    void rewind(int r5);

    void seek(int r5);

    int size();
}
