package com.obric.cae.libs.wifi.basicInfo;

import android.net.NetworkInfo;
import com.obric.cae.libs.utils.LogUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class WifiState {
    public static final int STATE_CONNECTED = 5;
    public static final int STATE_CONNECTING = 4;
    public static final int STATE_DISCONNECTED = 7;
    public static final int STATE_DISCONNECTING = 6;
    public static final int STATE_OFF = 1;
    public static final int STATE_ON = 3;
    public static final int STATE_TURNING_OFF = 0;
    public static final int STATE_TURNING_ON = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f5611a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5612a = null;

        static {
            int[] r8 = new int[NetworkInfo.DetailedState.values().length];
            f5612a = r8;
            r8[NetworkInfo.DetailedState.CONNECTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f5612a[NetworkInfo.DetailedState.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f5612a[NetworkInfo.DetailedState.DISCONNECTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f5612a[NetworkInfo.DetailedState.DISCONNECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public WifiState() {
        this.f5611a = new AtomicInteger(-1);
    }

    public int getState() {
        return this.f5611a.get();
    }

    public void handleConnectStateChanged(NetworkInfo.DetailedState r8) {
        int r10 = a.f5612a[r8.ordinal()];
        if (r10 != 1) goto L5;
        this.f5611a.set(4);
        return;
    L5:
        if (r10 != 2) goto L7;
        AtomicInteger r11 = this.f5611a;
        int r12 = 5;
    L13:
        r11.set(r12);
        return;
    L7:
        if (r10 == 3) goto L11;
        if (r10 == 4) goto L10;
        LogUtil.e("WifiState", "Set an invalid value for wifi connect state: " + r8);
        return;
    L10:
        r11 = this.f5611a;
        r12 = 7;
        goto L13
    L11:
        r11 = this.f5611a;
        r12 = 6;
        goto L13
    }

    public void handleWifiStateChanged(int r8) {
        if (r8 == 0) goto L11;
        int r10 = 1;
        if (r8 == 1) goto L10;
        r10 = 2;
        if (r8 == 2) goto L10;
        r10 = 3;
        if (r8 == 3) goto L10;
        LogUtil.e("WifiState", "Set an invalid value for wifi state: " + r8);
        return;
    L10:
        this.f5611a.set(r10);
        return;
    L11:
        this.f5611a.set(0);
    }

    public boolean isConnected() {
        if (this.f5611a.get() != 5) goto L5;
        return true;
    L5:
        return false;
    }
}
