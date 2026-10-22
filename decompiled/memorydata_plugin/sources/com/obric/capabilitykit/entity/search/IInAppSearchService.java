package com.obric.capabilitykit.entity.search;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface IInAppSearchService extends IInterface {

    public static class Default implements IInAppSearchService {
        public Default() {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void cancel(String r1) {
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void prepareSearch() {
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void registerEntityObserver(EntityChangeMonitorRequest r1, IEntityChangeCallback r2) {
            IEntityChangeCallback r0 = (IEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r2, IEntityChangeCallback.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void startAppSearch(String r1, InAppSearchRequest r2, IInAppSearchCallback r3) {
            IInAppSearchCallback r0 = (IInAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r3, IInAppSearchCallback.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void stopSearch() {
        }

        @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
        public void unregisterEntityObserver() {
        }
    }

    public static abstract class Stub extends Binder implements IInAppSearchService {
        private static final String DESCRIPTOR = "com.obric.capabilitykit.entity.search.IInAppSearchService";
        public static final int TRANSACTION_cancel = 2;
        public static final int TRANSACTION_prepareSearch = 3;
        public static final int TRANSACTION_registerEntityObserver = 5;
        public static final int TRANSACTION_startAppSearch = 1;
        public static final int TRANSACTION_stopSearch = 4;
        public static final int TRANSACTION_unregisterEntityObserver = 6;

        public static class Proxy implements IInAppSearchService {
            public static IInAppSearchService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder r3) {
                this.mRemote = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void cancel(String r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                r0.writeString(r5);     // Catch: Throwable -> L12
                if (this.mRemote.transact(2, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().cancel(r5);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void prepareSearch() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(3, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().prepareSearch();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void registerEntityObserver(EntityChangeMonitorRequest r5, IEntityChangeCallback r6) {
                IEntityChangeCallback r7 = (IEntityChangeCallback) ZeusTransformUtils.wrapperContextForParams(r6, IEntityChangeCallback.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L7:
                if (r7 == null) goto L9;
                IBinder r3 = r7.asBinder();     // Catch: Throwable -> L19
            L10:
                r0.writeStrongBinder(r3);     // Catch: Throwable -> L19
                if (this.mRemote.transact(5, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L19
            L15:
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().registerEntityObserver(r5, r7);     // Catch: Throwable -> L19
                goto L15
            L9:
                r3 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void startAppSearch(String r6, InAppSearchRequest r7, IInAppSearchCallback r8) {
                IInAppSearchCallback r9 = (IInAppSearchCallback) ZeusTransformUtils.wrapperContextForParams(r8, IInAppSearchCallback.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                r0.writeString(r6);     // Catch: Throwable -> L19
                if (r7 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L7:
                if (r9 == null) goto L9;
                IBinder r4 = r9.asBinder();     // Catch: Throwable -> L19
            L10:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L19
                if (this.mRemote.transact(1, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L19
            L15:
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().startAppSearch(r6, r7, r9);     // Catch: Throwable -> L19
                goto L15
            L9:
                r4 = null;
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void stopSearch() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(4, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().stopSearch();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.capabilitykit.entity.search.IInAppSearchService
            public void unregisterEntityObserver() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L12
                if (this.mRemote.transact(6, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L12
            L8:
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().unregisterEntityObserver();     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInAppSearchService asInterface(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, IInAppSearchService.class) == false) goto L13;
            return (IInAppSearchService) ZeusTransformUtils.preCheckCast(r0, IInAppSearchService.class, "com.obric.memorydata.plugin");
        L13:
            return new Proxy(r4);
        }

        public static IInAppSearchService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IInAppSearchService r2) {
            IInAppSearchService r3 = (IInAppSearchService) ZeusTransformUtils.wrapperContextForParams(r2, IInAppSearchService.class, "com.obric.memorydata.plugin");
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r3 == null) goto L9;
            Proxy.sDefaultImpl = r3;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r4, Parcel r5, Parcel r6, int r7) {
            if (r4 == 1598968902) goto L22;
            InAppSearchRequest r2 = null;
            EntityChangeMonitorRequest r3 = null;
            switch(r4) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L11;
                case 6: goto L8;
                default: goto L7;
            };
        L8:
            r5.enforceInterface(DESCRIPTOR);
            unregisterEntityObserver();
        L9:
            r6.writeNoException();
            return true;
        L11:
            r5.enforceInterface(DESCRIPTOR);
            if (r5.readInt() == 0) goto L14;
            r3 = EntityChangeMonitorRequest.CREATOR.createFromParcel(r5);
        L14:
            registerEntityObserver(r3, IEntityChangeCallback.Stub.asInterface(r5.readStrongBinder()));
            goto L9
        L15:
            r5.enforceInterface(DESCRIPTOR);
            stopSearch();
            goto L9
        L16:
            r5.enforceInterface(DESCRIPTOR);
            prepareSearch();
            goto L9
        L17:
            r5.enforceInterface(DESCRIPTOR);
            cancel(r5.readString());
            goto L9
        L18:
            r5.enforceInterface(DESCRIPTOR);
            String r8 = r5.readString();
            if (r5.readInt() == 0) goto L21;
            r2 = InAppSearchRequest.CREATOR.createFromParcel(r5);
        L21:
            startAppSearch(r8, r2, IInAppSearchCallback.Stub.asInterface(r5.readStrongBinder()));
            goto L9
        L7:
            return super.onTransact(r4, r5, r6, r7);
        L22:
            r6.writeString(DESCRIPTOR);
            return true;
        }
    }

    void cancel(String r1);

    void prepareSearch();

    void registerEntityObserver(EntityChangeMonitorRequest r1, IEntityChangeCallback r2);

    void startAppSearch(String r1, InAppSearchRequest r2, IInAppSearchCallback r3);

    void stopSearch();

    void unregisterEntityObserver();
}
