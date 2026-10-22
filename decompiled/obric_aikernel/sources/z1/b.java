package z1;

import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.event.ConnectionState;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    protected final c.a f13752a;

    public b(@NonNull c.a r10) {
        this.f13752a = r10;
    }

    @NonNull
    protected ConnectionState b(int r10, int r11, boolean r12) {
        ConnectionState r13 = ConnectionState.CONNECTION_UNKNOWN;
        if (r11 == 0) goto L18;
        if (r11 != 1) goto L9;
        r13 = ConnectionState.CONNECTING;
        goto L18
    L9:
        if (r11 != 2) goto L12;
        r13 = ConnectionState.CONNECT_FAILED;
        goto L18
    L12:
        if (r11 != 3) goto L15;
        r13 = ConnectionState.CONNECT_CLOSED;
        goto L18
    L15:
        if (r11 != 4) goto L18;
        r13 = ConnectionState.CONNECTED;
    L18:
        if (Logger.debug() == false) goto L20;
        Logger.d("AbsWsClientService", "state = " + r11 + " connectionState = " + r13);
    L20:
        this.f13752a.e(r10, r13, r12);
        return r13;
    }
}
