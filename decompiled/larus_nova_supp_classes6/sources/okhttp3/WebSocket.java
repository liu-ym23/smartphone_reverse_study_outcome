package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface WebSocket {
    void cancel();

    boolean close(int r1, @Nullable String r2);

    long queueSize();

    Request request();

    boolean send(String r1);

    boolean send(ByteString r1);
}
