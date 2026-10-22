package com.obric.assistant.spi.notification;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.service.notification.StatusBarNotification;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class IObricInteractorNotificationCallback$Stub extends Binder implements IObricInteractorNotificationCallback {
    private static final String DESCRIPTOR = "com.obric.assistant.spi.notification.IObricInteractorNotificationCallback";
    static final int TRANSACTION_onListenerConnected = 3;
    static final int TRANSACTION_onListenerDisconnected = 4;
    static final int TRANSACTION_onNotificationPosted = 1;
    static final int TRANSACTION_onNotificationRemoved = 2;

    public IBinder asBinder() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IObricInteractorNotificationCallback$Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static IObricInteractorNotificationCallback getDefaultImpl() {
        return Proxy.sDefaultImpl;
    }

    public static IObricInteractorNotificationCallback asInterface(IBinder r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        IObricInteractorNotificationCallback r0 = r2.queryLocalInterface(DESCRIPTOR);
        if (r0 == null) goto L12;
        if ((r0 instanceof IObricInteractorNotificationCallback) == false) goto L12;
        return r0;
    L12:
        return new Proxy(r2);
    }

    public static boolean setDefaultImpl(IObricInteractorNotificationCallback r1) {
        if (Proxy.sDefaultImpl != null) goto L10;
        if (r1 == null) goto L7;
        Proxy.sDefaultImpl = r1;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalStateException("setDefaultImpl() called twice");
    }

    @Override // android.os.Binder
    public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
        StatusBarNotification r0 = null;
        if (r5 != 1) goto L5;
        r6.enforceInterface(DESCRIPTOR);
        if (r6.readInt() == 0) goto L28;
        r0 = (StatusBarNotification) StatusBarNotification.CREATOR.createFromParcel(r6);
    L28:
        onNotificationPosted(r0);
        r7.writeNoException();
        return true;
    L5:
        if (r5 != 2) goto L7;
        r6.enforceInterface(DESCRIPTOR);
        if (r6.readInt() == 0) goto L23;
        r0 = (StatusBarNotification) StatusBarNotification.CREATOR.createFromParcel(r6);
    L23:
        onNotificationRemoved(r0);
        r7.writeNoException();
        return true;
    L7:
        if (r5 != 3) goto L9;
        r6.enforceInterface(DESCRIPTOR);
        onListenerConnected();
        r7.writeNoException();
        return true;
    L9:
        if (r5 != 4) goto L11;
        r6.enforceInterface(DESCRIPTOR);
        onListenerDisconnected();
        r7.writeNoException();
        return true;
    L11:
        if (r5 != 1598968902) goto L13;
        r7.writeString(DESCRIPTOR);
        return true;
    L13:
        return super.onTransact(r5, r6, r7, r8);
    }
}
