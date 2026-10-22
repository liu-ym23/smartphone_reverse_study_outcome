package ac2;

import com.bytedance.android.livesdkapi.ws.LiveWsConnectState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final /* synthetic */ class b0 {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[LiveWsConnectState.values().length];
        a = r0;
        r0[LiveWsConnectState.CONNECTED.ordinal()] = 1;
        r0[LiveWsConnectState.CONNECT_CLOSED.ordinal()] = 2;
        r0[LiveWsConnectState.CONNECT_FAILED.ordinal()] = 3;
    }
}
