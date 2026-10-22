package okhttp3;

import java.io.IOException;
import okio.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface Call extends Cloneable {

    public interface a {
        Call newCall(Request r1);
    }

    void cancel();

    /* JADX INFO: renamed from: clone */
    Call mo536clone();

    void enqueue(Callback r1);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    j0 timeout();
}
