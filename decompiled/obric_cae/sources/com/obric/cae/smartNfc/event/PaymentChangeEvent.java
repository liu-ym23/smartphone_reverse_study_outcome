package com.obric.cae.smartNfc.event;

import android.aimedia.a;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteCallbackList;
import android.provider.Settings;
import android.text.TextUtils;
import com.obric.cae.libs.nfc.ICaeNfcPaymentChangeCallback;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class PaymentChangeEvent implements EventComponent {
    private static final String KEY_DEFAULT_PAYMENT = "nfc_payment_default_component";
    private static final String TAG = "NFC:PaymentChangeEvent";
    private final RemoteCallbackList<ICaeNfcPaymentChangeCallback> mCallbacks;
    private final Context mContext;
    private volatile PaymentChangeListener mInternalListener;
    private SettingsObserver mObserver;
    private Handler mObserverHandler;
    private HandlerThread mObserverThread;

    public interface PaymentChangeListener {
        void onPaymentChanged(String r8);
    }

    public final class SettingsObserver extends ContentObserver {
        private final Uri mPaymentUri;
        final /* synthetic */ PaymentChangeEvent this$0;

        public SettingsObserver(PaymentChangeEvent r8, Handler r10) {
            this.this$0 = r8;
            super(r10);
            this.mPaymentUri = Settings.Secure.getUriFor(PaymentChangeEvent.KEY_DEFAULT_PAYMENT);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            PaymentChangeEvent r11 = this.this$0;
            PaymentChangeEvent.access$200(r11, PaymentChangeEvent.access$100(r11));
        }

        public void register() {
            PaymentChangeEvent.access$000(this.this$0).getContentResolver().registerContentObserver(this.mPaymentUri, false, this);
        }

        public void unregister() {
            PaymentChangeEvent.access$000(this.this$0).getContentResolver().unregisterContentObserver(this);     // Catch: Throwable -> L4
            return;
        }
    }

    public PaymentChangeEvent(Context r8) {
        this.mCallbacks = new RemoteCallbackList();
        this.mContext = r8.getApplicationContext();
    }

    public static /* synthetic */ Context access$000(PaymentChangeEvent r8) {
        return r8.mContext;
    }

    public static /* synthetic */ String access$100(PaymentChangeEvent r8) {
        return r8.getCurrentDefaultPayment();
    }

    public static /* synthetic */ void access$200(PaymentChangeEvent r8, String r10) {
        r8.notifyPaymentChanged(r10);
    }

    private String getCurrentDefaultPayment() {
        String r8 = Settings.Secure.getString(this.mContext.getContentResolver(), KEY_DEFAULT_PAYMENT);
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return "";
    L6:
        return r8;
    }

    private void notifyPaymentChanged(String r8) {
        PaymentChangeListener r10 = this.mInternalListener;
        if (r10 != null) goto L17;
    L8:
        int r11 = this.mCallbacks.beginBroadcast();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L15;
        ((ICaeNfcPaymentChangeCallback) this.mCallbacks.getBroadcastItem(r12)).onPaymentChanged(r8);     // Catch: Exception -> L12
    L14:
        r12 = r12 + 1;
    L12:
        e = move-exception;
        a.q("notifyPaymentChanged error: ", e, TAG);
        goto L14
    L15:
        this.mCallbacks.finishBroadcast();
        return;
    L17:
        r10.onPaymentChanged(r8);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        a.q("notifyPaymentChanged listener error: ", e, TAG);
        goto L8
    }

    private void notifySingleCallback(ICaeNfcPaymentChangeCallback r8, String r10) {
        r8.onPaymentChanged(r10);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        a.q("notifySingleCallback error: ", e, TAG);
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void cleanup() {
        SettingsObserver r8 = this.mObserver;
        if (r8 == null) goto L5;
        r8.unregister();
        this.mObserver = null;
    L5:
        HandlerThread r10 = this.mObserverThread;
        if (r10 == null) goto L8;
        r10.quitSafely();
        this.mObserverThread = null;
    L8:
        this.mCallbacks.kill();
    }

    @Override // com.obric.cae.smartNfc.event.EventComponent
    public void init() {
        if (this.mObserverThread == null) goto L5;
        return;
    L5:
        HandlerThread r8 = new HandlerThread("CaePaymentChangeObserver");
        this.mObserverThread = r8;
        r8.start();
        this.mObserverHandler = new Handler(this.mObserverThread.getLooper());
        SettingsObserver r10 = new SettingsObserver(this, this.mObserverHandler);
        this.mObserver = r10;
        r10.register();
        notifyPaymentChanged(getCurrentDefaultPayment());
    }

    public void registerCallback(ICaeNfcPaymentChangeCallback r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "registerCallback: callback is null");
        return;
    L5:
        this.mCallbacks.register(r8);
        notifySingleCallback(r8, getCurrentDefaultPayment());
    }

    public void setInternalListener(PaymentChangeListener r8) {
        this.mInternalListener = r8;
    }

    public void unregisterCallback(ICaeNfcPaymentChangeCallback r8) {
        if (r8 != null) goto L5;
        CaeLog.e(TAG, "unregisterCallback: callback is null");
        return;
    L5:
        this.mCallbacks.unregister(r8);
    }
}
