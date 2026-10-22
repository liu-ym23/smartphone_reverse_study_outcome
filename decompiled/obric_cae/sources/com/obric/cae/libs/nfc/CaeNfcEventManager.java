package com.obric.cae.libs.nfc;

import android.os.Bundle;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.a;
import com.obric.cae.libs.utils.LogUtil;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class CaeNfcEventManager {
    public static final int TRANSIT_AID_TYPE_ALL = 0;
    public static final int TRANSIT_AID_TYPE_BANK_CARD = 4;
    public static final int TRANSIT_AID_TYPE_CAR_KEY = 1;
    public static final int TRANSIT_AID_TYPE_TRANSIT_CARD = 2;
    public static final int TRANSIT_EVENT_SOURCE_BINDER = 2;
    public static final int TRANSIT_EVENT_SOURCE_BROADCAST = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICaeNfcEventManager f5439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f5440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f5441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f5442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f5443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f5444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap f5445g;

    public static class DndConfigCallbackWrapper extends ICaeNfcDndConfigCallback.Stub {
        private final CaeNfcDndConfigCallback mCallback;

        public DndConfigCallbackWrapper(CaeNfcDndConfigCallback r8) {
            this.mCallback = r8;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcDndConfigCallback
        public void onDndConfigChanged(boolean r8, int r10) {
            this.mCallback.onDndConfigChanged(r8, r10);
        }
    }

    public static class ForceFwCallbackWrapper extends ICaeNfcForceFwEventCallback.Stub {
        private final CaeNfcForceFwEventCallback mCallback;

        public ForceFwCallbackWrapper(CaeNfcForceFwEventCallback r8) {
            this.mCallback = r8;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcForceFwEventCallback
        public void onForceFwDownload() {
            this.mCallback.onForceFwDownload();
        }
    }

    public static class PaymentChangeCallbackWrapper extends ICaeNfcPaymentChangeCallback.Stub {
        private final CaeNfcPaymentChangeCallback mCallback;

        public PaymentChangeCallbackWrapper(CaeNfcPaymentChangeCallback r8) {
            this.mCallback = r8;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcPaymentChangeCallback
        public void onPaymentChanged(String r8) {
            this.mCallback.onPaymentChanged(r8);
        }
    }

    public static class TransitCallbackWrapper extends ICaeNfcTransitEventCallback.Stub {
        private final CaeNfcTransitEventCallback mCallback;

        public TransitCallbackWrapper(CaeNfcTransitEventCallback r8) {
            this.mCallback = r8;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcTransitEventCallback
        public void onTransitEvent(Bundle r8) {
            this.mCallback.onTransitEvent(r8);
        }
    }

    public static class VendorNciCallbackWrapper extends ICaeNfcVendorNciEventCallback.Stub {
        private final CaeNfcVendorNciEventCallback mCallback;

        public VendorNciCallbackWrapper(CaeNfcVendorNciEventCallback r8) {
            this.mCallback = r8;
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcVendorNciEventCallback
        public void onVendorNciEvent(Bundle r8) {
            this.mCallback.onVendorNciEvent(r8);
        }
    }

    public CaeNfcEventManager(ICaeNfcEventManager r8) {
        this.f5440b = new ConcurrentHashMap();
        this.f5441c = new ConcurrentHashMap();
        this.f5442d = new ConcurrentHashMap();
        this.f5443e = new ConcurrentHashMap();
        this.f5444f = new ConcurrentHashMap();
        this.f5445g = new ConcurrentHashMap();
        this.f5439a = r8;
    }

    public int getTransitEventAllowedAidTypes() {
        ICaeNfcEventManager r8 = this.f5439a;
        if (r8 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "getTransitEventAllowedAidTypes: service is null");
        return 0;
    L11:
        return r8.getTransitEventAllowedAidTypes();
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return 0;
    }

    public int getTransitEventSource() {
        ICaeNfcEventManager r8 = this.f5439a;
        if (r8 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "getTransitEventSource: service is null");
        return 1;
    L11:
        return r8.getTransitEventSource();
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return 1;
    }

    public boolean isTransitEventFilterEnabled() {
        ICaeNfcEventManager r8 = this.f5439a;
        if (r8 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "isTransitEventFilterEnabled: service is null");
        return true;
    L11:
        return r8.isTransitEventFilterEnabled();
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return true;
    }

    public boolean notifyTeaEvent(String r8, Bundle r10) {
        if (r8 != null) goto L5;
    L17:
        LogUtil.e("NFC:CaeNfcEventManager", "notifyTeaEvent: eventName is empty");
        return false;
    L5:
        if (r8.isEmpty() == true) goto L17;
        ICaeNfcEventManager r11 = this.f5439a;
        if (r11 != null) goto L19;
        LogUtil.e("NFC:CaeNfcEventManager", "notifyTeaEvent: service is null");
        return false;
    L19:
        r11.notifyTeaEvent(r8, r10);     // Catch: RemoteException -> L14
        return true;
    L14:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean notifyTransitEvent(Bundle r8) {
        ICaeNfcEventManager r10 = this.f5439a;
        if (r10 != null) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "notifyTransitEvent: service is null");
        return false;
    L12:
        r10.notifyTransitEvent(r8);     // Catch: RemoteException -> L9
        return true;
    L9:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerCloudConfigCallback(ICaeNfcCloudConfigCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerCloudConfigCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerCloudConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcCloudConfigCallback r10 = (ICaeNfcCloudConfigCallback) this.f5440b.get(r8);
        if (r10 != null) goto L13;
        this.f5440b.put(r8, r8);
    L20:
        this.f5439a.registerCloudConfigCallback(r8);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    L13:
        r8 = r10;
        goto L20
    }

    public boolean registerDndConfigCallback(CaeNfcDndConfigCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerDndConfigCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerDndConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcDndConfigCallback r10 = (ICaeNfcDndConfigCallback) this.f5441c.get(r8);
        if (r10 != null) goto L19;
        r10 = new DndConfigCallbackWrapper(r8);
        this.f5441c.put(r8, r10);
    L19:
        this.f5439a.registerDndConfigCallback(r10);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerForceFwCallback(CaeNfcForceFwEventCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerForceFwCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerForceFwCallback: service is null");
        return false;
    L10:
        ICaeNfcForceFwEventCallback r10 = (ICaeNfcForceFwEventCallback) this.f5442d.get(r8);
        if (r10 != null) goto L19;
        r10 = new ForceFwCallbackWrapper(r8);
        this.f5442d.put(r8, r10);
    L19:
        this.f5439a.registerForceFwEventCallback(r10);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerPaymentChangeCallback(CaeNfcPaymentChangeCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerPaymentChangeCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerPaymentChangeCallback: service is null");
        return false;
    L10:
        ICaeNfcPaymentChangeCallback r10 = (ICaeNfcPaymentChangeCallback) this.f5445g.get(r8);
        if (r10 != null) goto L19;
        r10 = new PaymentChangeCallbackWrapper(r8);
        this.f5445g.put(r8, r10);
    L19:
        this.f5439a.registerPaymentChangeCallback(r10);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerTransitCallback(CaeNfcTransitEventCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerTransitCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerTransitCallback: service is null");
        return false;
    L10:
        ICaeNfcTransitEventCallback r10 = (ICaeNfcTransitEventCallback) this.f5443e.get(r8);
        if (r10 != null) goto L19;
        r10 = new TransitCallbackWrapper(r8);
        this.f5443e.put(r8, r10);
    L19:
        this.f5439a.registerTransitEventCallback(r10);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerVendorNciCallback(CaeNfcVendorNciEventCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerVendorNciCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerVendorNciCallback: service is null");
        return false;
    L10:
        ICaeNfcVendorNciEventCallback r10 = (ICaeNfcVendorNciEventCallback) this.f5444f.get(r8);
        if (r10 != null) goto L19;
        r10 = new VendorNciCallbackWrapper(r8);
        this.f5444f.put(r8, r10);
    L19:
        this.f5439a.registerVendorNciEventCallback(r10);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean setTransitEventAllowedAidTypes(int r8) {
        if (r8 >= 0) goto L5;
    L7:
        boolean r10 = false;
    L9:
        if (r10 == true) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventAllowedAidTypes: invalid mask " + r8);
        return false;
    L12:
        ICaeNfcEventManager r11 = this.f5439a;
        if (r11 != null) goto L21;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventAllowedAidTypes: service is null");
        return false;
    L21:
        return r11.setTransitEventAllowedAidTypes(r8);
    L18:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    L5:
        if ((r8 & (-8)) != 0) goto L7;
        r10 = true;
        goto L9
    }

    public boolean setTransitEventFilterEnabled(boolean r8) {
        ICaeNfcEventManager r10 = this.f5439a;
        if (r10 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventFilterEnabled: service is null");
        return false;
    L11:
        return r10.setTransitEventFilterEnabled(r8);
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean setTransitEventSource(int r8) {
        boolean r10 = true;
        if (r8 == 1) goto L9;
        if (r8 == 2) goto L9;
        r10 = false;
    L9:
        if (r10 == true) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventSource: invalid source " + r8);
        return false;
    L12:
        ICaeNfcEventManager r11 = this.f5439a;
        if (r11 != null) goto L21;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventSource: service is null");
        return false;
    L21:
        return r11.setTransitEventSource(r8);
    L18:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcCloudConfigCallback r10 = (ICaeNfcCloudConfigCallback) this.f5440b.remove(r8);
        if (r10 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: callback not found");
        return false;
    L20:
        this.f5439a.unregisterCloudConfigCallback(r10);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterDndConfigCallback(CaeNfcDndConfigCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcDndConfigCallback r10 = (ICaeNfcDndConfigCallback) this.f5441c.remove(r8);
        if (r10 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: callback not found");
        return false;
    L20:
        this.f5439a.unregisterDndConfigCallback(r10);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterForceFwCallback(CaeNfcForceFwEventCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: service is null");
        return false;
    L10:
        ICaeNfcForceFwEventCallback r10 = (ICaeNfcForceFwEventCallback) this.f5442d.remove(r8);
        if (r10 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: callback not found");
        return false;
    L20:
        this.f5439a.unregisterForceFwEventCallback(r10);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterPaymentChangeCallback(CaeNfcPaymentChangeCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: service is null");
        return false;
    L10:
        ICaeNfcPaymentChangeCallback r10 = (ICaeNfcPaymentChangeCallback) this.f5445g.remove(r8);
        if (r10 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: callback not found");
        return false;
    L20:
        this.f5439a.unregisterPaymentChangeCallback(r10);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterTransitCallback(CaeNfcTransitEventCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: service is null");
        return false;
    L10:
        ICaeNfcTransitEventCallback r10 = (ICaeNfcTransitEventCallback) this.f5443e.remove(r8);
        if (r10 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: callback not found");
        return false;
    L20:
        this.f5439a.unregisterTransitEventCallback(r10);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterVendorNciCallback(CaeNfcVendorNciEventCallback r8) {
        if (r8 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: callback is null");
        return false;
    L7:
        if (this.f5439a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: service is null");
        return false;
    L10:
        ICaeNfcVendorNciEventCallback r10 = (ICaeNfcVendorNciEventCallback) this.f5444f.remove(r8);
        if (r10 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: callback not found");
        return false;
    L20:
        this.f5439a.unregisterVendorNciEventCallback(r10);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }
}
