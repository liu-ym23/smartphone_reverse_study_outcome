package com.cae.caed;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.cae.caed.events.AntDivParcel;
import com.cae.caed.events.BlockUidRejectParcel;
import com.cae.caed.events.CaeRoamParcel;
import com.cae.caed.events.WakePacketParcel;
import com.cae.caed.events.WlanCrashParcel;

/* JADX INFO: loaded from: classes.dex */
public interface IEventListener extends IInterface {

    public static class Default implements IEventListener {
        public Default() {
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IEventListener {
        static final int TRANSACTION_OnRecvAntDivEvent = 3;
        static final int TRANSACTION_OnRecvBlockUidRejectEvent = 4;
        static final int TRANSACTION_OnRecvCaeRoamEvent = 1;
        static final int TRANSACTION_OnRecvWakePacketEvent = 5;
        static final int TRANSACTION_OnRecvWlanCrashEvent = 2;

        public static class Proxy implements IEventListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4123a;

            public Proxy(IBinder r8) {
                this.f4123a = r8;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4123a;
            }
        }

        public Stub() {
            attachInterface(this, "com.cae.caed.IEventListener");
        }

        public static IEventListener asInterface(IBinder r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r8.queryLocalInterface("com.cae.caed.IEventListener");
            if (r10 == null) goto L12;
            if ((r10 instanceof IEventListener) == false) goto L12;
            return (IEventListener) r10;
        L12:
            return new Proxy(r8);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("com.cae.caed.IEventListener");
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.cae.caed.IEventListener");
            return true;
        L11:
            if (r8 != 1) goto L13;
            OnRecvCaeRoamEvent((CaeRoamParcel) r10.readTypedObject(CaeRoamParcel.CREATOR));
        L27:
            r11.writeNoException();
            return true;
        L13:
            if (r8 != 2) goto L15;
            OnRecvWlanCrashEvent((WlanCrashParcel) r10.readTypedObject(WlanCrashParcel.CREATOR));
            goto L27
        L15:
            if (r8 != 3) goto L17;
            OnRecvAntDivEvent((AntDivParcel) r10.readTypedObject(AntDivParcel.CREATOR));
            goto L27
        L17:
            if (r8 != 4) goto L19;
            OnRecvBlockUidRejectEvent((BlockUidRejectParcel) r10.readTypedObject(BlockUidRejectParcel.CREATOR));
            goto L27
        L19:
            if (r8 != 5) goto L21;
            OnRecvWakePacketEvent((WakePacketParcel) r10.readTypedObject(WakePacketParcel.CREATOR));
            goto L27
        L21:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    void OnRecvAntDivEvent(AntDivParcel r8);

    void OnRecvBlockUidRejectEvent(BlockUidRejectParcel r8);

    void OnRecvCaeRoamEvent(CaeRoamParcel r8);

    void OnRecvWakePacketEvent(WakePacketParcel r8);

    void OnRecvWlanCrashEvent(WlanCrashParcel r8);
}
