package com.obric.cae.libs.nfc;

import android.os.Bundle;
import android.os.RemoteException;
import com.obric.cae.libs.utils.LogUtil;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class CaeNfcEventManager {
    public static final int TRANSIT_AID_TYPE_ALL = 0;
    public static final int TRANSIT_AID_TYPE_BANK_CARD = 4;
    public static final int TRANSIT_AID_TYPE_CAR_KEY = 1;
    public static final int TRANSIT_AID_TYPE_TRANSIT_CARD = 2;
    public static final int TRANSIT_EVENT_SOURCE_BINDER = 2;
    public static final int TRANSIT_EVENT_SOURCE_BROADCAST = 1;
    public final ICaeNfcEventManager a;
    public final ConcurrentHashMap b;
    public final ConcurrentHashMap c;
    public final ConcurrentHashMap d;
    public final ConcurrentHashMap e;
    public final ConcurrentHashMap f;
    public final ConcurrentHashMap g;

    public static class DndConfigCallbackWrapper extends ICaeNfcDndConfigCallback.Stub {
        private final CaeNfcDndConfigCallback mCallback;

        public DndConfigCallbackWrapper(CaeNfcDndConfigCallback r1) {
            this.mCallback = r1;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcDndConfigCallback
        public void onDndConfigChanged(boolean r2, int r3) {
            this.mCallback.onDndConfigChanged(r2, r3);
        }
    }

    public static class ForceFwCallbackWrapper extends ICaeNfcForceFwEventCallback.Stub {
        private final CaeNfcForceFwEventCallback mCallback;

        @Override // com.obric.cae.libs.nfc.ICaeNfcForceFwEventCallback
        public void onForceFwDownload() {
            this.mCallback.onForceFwDownload();
        }

        public ForceFwCallbackWrapper(CaeNfcForceFwEventCallback r1) {
            this.mCallback = r1;
        }
    }

    public static class PaymentChangeCallbackWrapper extends ICaeNfcPaymentChangeCallback.Stub {
        private final CaeNfcPaymentChangeCallback mCallback;

        public PaymentChangeCallbackWrapper(CaeNfcPaymentChangeCallback r1) {
            this.mCallback = r1;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcPaymentChangeCallback
        public void onPaymentChanged(String r2) {
            this.mCallback.onPaymentChanged(r2);
        }
    }

    public static class TransitCallbackWrapper extends ICaeNfcTransitEventCallback.Stub {
        private final CaeNfcTransitEventCallback mCallback;

        public TransitCallbackWrapper(CaeNfcTransitEventCallback r1) {
            this.mCallback = r1;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcTransitEventCallback
        public void onTransitEvent(Bundle r2) {
            this.mCallback.onTransitEvent(r2);
        }
    }

    public static class VendorNciCallbackWrapper extends ICaeNfcVendorNciEventCallback.Stub {
        private final CaeNfcVendorNciEventCallback mCallback;

        public VendorNciCallbackWrapper(CaeNfcVendorNciEventCallback r1) {
            this.mCallback = r1;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcVendorNciEventCallback
        public void onVendorNciEvent(Bundle r2) {
            this.mCallback.onVendorNciEvent(r2);
        }
    }

    public int getTransitEventAllowedAidTypes() {
        ICaeNfcEventManager r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "getTransitEventAllowedAidTypes: service is null");
        return 0;
    L11:
        return r0.getTransitEventAllowedAidTypes();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return 0;
    }

    public int getTransitEventSource() {
        ICaeNfcEventManager r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "getTransitEventSource: service is null");
        return 1;
    L11:
        return r0.getTransitEventSource();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return 1;
    }

    public boolean isTransitEventFilterEnabled() {
        ICaeNfcEventManager r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "isTransitEventFilterEnabled: service is null");
        return true;
    L11:
        return r0.isTransitEventFilterEnabled();
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return true;
    }

    public CaeNfcEventManager(ICaeNfcEventManager r2) {
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.a = r2;
    }

    public boolean notifyTransitEvent(Bundle r4) {
        ICaeNfcEventManager r0 = this.a;
        if (r0 != null) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "notifyTransitEvent: service is null");
        return false;
    L12:
        r0.notifyTransitEvent(r4);     // Catch: RemoteException -> L9
        return true;
    L9:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerCloudConfigCallback(ICaeNfcCloudConfigCallback r4) {
        if (r4 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerCloudConfigCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerCloudConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcCloudConfigCallback r2 = (ICaeNfcCloudConfigCallback) this.b.get(r4);
        if (r2 != null) goto L13;
        this.b.put(r4, r4);
    L20:
        this.a.registerCloudConfigCallback(r4);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    L13:
        r4 = r2;
        goto L20
    }

    public boolean registerDndConfigCallback(CaeNfcDndConfigCallback r5) {
        if (r5 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerDndConfigCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerDndConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcDndConfigCallback r2 = (ICaeNfcDndConfigCallback) this.c.get(r5);
        if (r2 != null) goto L19;
        r2 = new DndConfigCallbackWrapper(r5);
        this.c.put(r5, r2);
    L19:
        this.a.registerDndConfigCallback(r2);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerForceFwCallback(CaeNfcForceFwEventCallback r5) {
        if (r5 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerForceFwCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerForceFwCallback: service is null");
        return false;
    L10:
        ICaeNfcForceFwEventCallback r2 = (ICaeNfcForceFwEventCallback) this.d.get(r5);
        if (r2 != null) goto L19;
        r2 = new ForceFwCallbackWrapper(r5);
        this.d.put(r5, r2);
    L19:
        this.a.registerForceFwEventCallback(r2);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerPaymentChangeCallback(CaeNfcPaymentChangeCallback r5) {
        if (r5 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerPaymentChangeCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerPaymentChangeCallback: service is null");
        return false;
    L10:
        ICaeNfcPaymentChangeCallback r2 = (ICaeNfcPaymentChangeCallback) this.g.get(r5);
        if (r2 != null) goto L19;
        r2 = new PaymentChangeCallbackWrapper(r5);
        this.g.put(r5, r2);
    L19:
        this.a.registerPaymentChangeCallback(r2);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerTransitCallback(CaeNfcTransitEventCallback r5) {
        if (r5 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerTransitCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerTransitCallback: service is null");
        return false;
    L10:
        ICaeNfcTransitEventCallback r2 = (ICaeNfcTransitEventCallback) this.e.get(r5);
        if (r2 != null) goto L19;
        r2 = new TransitCallbackWrapper(r5);
        this.e.put(r5, r2);
    L19:
        this.a.registerTransitEventCallback(r2);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerVendorNciCallback(CaeNfcVendorNciEventCallback r5) {
        if (r5 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerVendorNciCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerVendorNciCallback: service is null");
        return false;
    L10:
        ICaeNfcVendorNciEventCallback r2 = (ICaeNfcVendorNciEventCallback) this.f.get(r5);
        if (r2 != null) goto L19;
        r2 = new VendorNciCallbackWrapper(r5);
        this.f.put(r5, r2);
    L19:
        this.a.registerVendorNciEventCallback(r2);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean setTransitEventAllowedAidTypes(int r5) {
        if (r5 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventAllowedAidTypes: invalid mask " + r5);
        return false;
    L12:
        ICaeNfcEventManager r2 = this.a;
        if (r2 != null) goto L21;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventAllowedAidTypes: service is null");
        return false;
    L21:
        return r2.setTransitEventAllowedAidTypes(r5);
    L18:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    L5:
        if ((r5 & (-8)) != 0) goto L7;
        r1 = true;
        goto L9
    }

    public boolean setTransitEventFilterEnabled(boolean r4) {
        ICaeNfcEventManager r0 = this.a;
        if (r0 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventFilterEnabled: service is null");
        return false;
    L11:
        return r0.setTransitEventFilterEnabled(r4);
    L8:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean setTransitEventSource(int r5) {
        boolean r1 = true;
        if (r5 == 1) goto L9;
        if (r5 == 2) goto L9;
        r1 = false;
    L9:
        if (r1 == true) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventSource: invalid source " + r5);
        return false;
    L12:
        ICaeNfcEventManager r2 = this.a;
        if (r2 != null) goto L21;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventSource: service is null");
        return false;
    L21:
        return r2.setTransitEventSource(r5);
    L18:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r4) {
        if (r4 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcCloudConfigCallback r5 = (ICaeNfcCloudConfigCallback) this.b.remove(r4);
        if (r5 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: callback not found");
        return false;
    L20:
        this.a.unregisterCloudConfigCallback(r5);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterDndConfigCallback(CaeNfcDndConfigCallback r4) {
        if (r4 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcDndConfigCallback r5 = (ICaeNfcDndConfigCallback) this.c.remove(r4);
        if (r5 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: callback not found");
        return false;
    L20:
        this.a.unregisterDndConfigCallback(r5);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterForceFwCallback(CaeNfcForceFwEventCallback r4) {
        if (r4 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: service is null");
        return false;
    L10:
        ICaeNfcForceFwEventCallback r5 = (ICaeNfcForceFwEventCallback) this.d.remove(r4);
        if (r5 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: callback not found");
        return false;
    L20:
        this.a.unregisterForceFwEventCallback(r5);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterPaymentChangeCallback(CaeNfcPaymentChangeCallback r4) {
        if (r4 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: service is null");
        return false;
    L10:
        ICaeNfcPaymentChangeCallback r5 = (ICaeNfcPaymentChangeCallback) this.g.remove(r4);
        if (r5 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: callback not found");
        return false;
    L20:
        this.a.unregisterPaymentChangeCallback(r5);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterTransitCallback(CaeNfcTransitEventCallback r4) {
        if (r4 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: service is null");
        return false;
    L10:
        ICaeNfcTransitEventCallback r5 = (ICaeNfcTransitEventCallback) this.e.remove(r4);
        if (r5 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: callback not found");
        return false;
    L20:
        this.a.unregisterTransitEventCallback(r5);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterVendorNciCallback(CaeNfcVendorNciEventCallback r4) {
        if (r4 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: callback is null");
        return false;
    L7:
        if (this.a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: service is null");
        return false;
    L10:
        ICaeNfcVendorNciEventCallback r5 = (ICaeNfcVendorNciEventCallback) this.f.remove(r4);
        if (r5 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: callback not found");
        return false;
    L20:
        this.a.unregisterVendorNciEventCallback(r5);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }
}
