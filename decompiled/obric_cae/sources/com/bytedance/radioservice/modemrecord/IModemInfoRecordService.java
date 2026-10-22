package com.bytedance.radioservice.modemrecord;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IModemInfoRecordService extends IInterface {

    public static class Default implements IModemInfoRecordService {
        public Default() {
        }

        @Override // com.bytedance.radioservice.modemrecord.IModemInfoRecordService
        public final List<ModemCellRecord> W1() {
            return null;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IModemInfoRecordService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f4038a = 0;

        public static class Proxy implements IModemInfoRecordService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f4039a;

            public Proxy(IBinder r8) {
                this.f4039a = r8;
            }

            @Override // com.bytedance.radioservice.modemrecord.IModemInfoRecordService
            public final List<ModemCellRecord> W1() {
                Parcel r8 = Parcel.obtain(asBinder());
                Parcel r10 = Parcel.obtain();
                r8.writeInterfaceToken("com.bytedance.radioservice.modemrecord.IModemInfoRecordService");     // Catch: Throwable -> L6
                this.f4039a.transact(1, r8, r10, 0);     // Catch: Throwable -> L6
                r10.readException();     // Catch: Throwable -> L6
                ArrayList r11 = r10.createTypedArrayList(ModemCellRecord.CREATOR);     // Catch: Throwable -> L6
                r10.recycle();
                r8.recycle();
                return r11;
            L6:
                th = move-exception;
                r10.recycle();
                r8.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f4039a;
            }
        }

        public Stub() {
            attachInterface(this, "com.bytedance.radioservice.modemrecord.IModemInfoRecordService");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int r8, Parcel r10, Parcel r11, int r12) {
            if (r8 < 1) goto L8;
            if (r8 > 16777215) goto L8;
            r10.enforceInterface("com.bytedance.radioservice.modemrecord.IModemInfoRecordService");
        L8:
            if (r8 != 1598968902) goto L11;
            r11.writeString("com.bytedance.radioservice.modemrecord.IModemInfoRecordService");
            return true;
        L11:
            if (r8 != 1) goto L13;
            List<ModemCellRecord> r13 = W1();
            r11.writeNoException();
            r11.writeTypedList(r13, 1);
            return true;
        L13:
            return super.onTransact(r8, r10, r11, r12);
        }
    }

    List<ModemCellRecord> W1();
}
