package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public abstract class WebSocketListener {
    public WebSocketListener() {
    }

    public void onClosed(WebSocket r1, int r2, String r3) {
    }

    public void onClosing(WebSocket r1, int r2, String r3) {
    }

    public void onFailure(WebSocket r1, Throwable r2, @Nullable Response r3) {
    }

    public void onMessage(WebSocket r1, String r2) {
    }

    public void onMessage(WebSocket r1, ByteString r2) {
    }

    public void onOpen(WebSocket r1, Response r2) {
    }
}
