package okhttp3;

/* JADX INFO: loaded from: classes3.dex */
public interface Call extends Cloneable {
    void cancel();

    void enqueue(j r5);

    s0 execute();

    boolean isCanceled();

    Request request();

    nu.f0 timeout();
}
