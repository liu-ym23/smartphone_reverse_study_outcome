package kf;

import com.bytedance.common.wschannel.WsConstants;
import java.util.HashMap;
import java.util.Observable;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f9124a;

    public a() {
    }

    public final void a(String r8, long r10, long r11, boolean r12) {
        HashMap r13 = new HashMap();
        r13.put(WsConstants.KEY_CONNECTION_URL, r8);
        r13.put("sent_bytes", Long.valueOf(r10));
        r13.put("received_bytes", Long.valueOf(r11));
        r13.put("is_heartbeat_frame", Boolean.valueOf(r12));
        setChanged();
        notifyObservers(r13);
    }
}
