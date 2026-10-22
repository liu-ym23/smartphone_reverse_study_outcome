package a7;

import com.bytedance.common.wschannel.WsConstants;
import java.util.HashMap;
import java.util.Observable;

/* JADX INFO: loaded from: classes.dex */
public final class j extends Observable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile j f117a;

    public j() {
    }

    public final void a(String r8, String r10, String r11, long r12, long r13) {
        HashMap r14 = new HashMap();
        r14.put(WsConstants.KEY_CONNECTION_URL, r8);
        r14.put("sent_bytes", Long.valueOf(r12));
        r14.put("received_bytes", Long.valueOf(r13));
        r14.put("content_type", r10);
        r14.put("request_log", r11);
        setChanged();
        notifyObservers(r14);
    }
}
