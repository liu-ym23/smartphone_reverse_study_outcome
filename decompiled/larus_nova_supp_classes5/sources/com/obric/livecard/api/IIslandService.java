package com.obric.livecard.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IIslandService extends IInterface {

    public static abstract class Stub extends Binder implements IIslandService {
        private static final String DESCRIPTOR = "com.obric.livecard.api.IIslandService";
        static final int TRANSACTION_addIIslandStatusCallback = 8;
        static final int TRANSACTION_addOnTopCardChangedListener = 18;
        static final int TRANSACTION_collapseNotificationPanel = 22;
        static final int TRANSACTION_createSession = 1;
        static final int TRANSACTION_destroySession = 2;
        static final int TRANSACTION_doCollapse = 7;
        static final int TRANSACTION_getIslandVersion = 16;
        static final int TRANSACTION_getPriority = 20;
        static final int TRANSACTION_onLauncherFocused = 11;
        static final int TRANSACTION_onNotificationVisible = 13;
        static final int TRANSACTION_onSysUIFlagsChanged = 15;
        static final int TRANSACTION_onVolumeButtonClick = 10;
        static final int TRANSACTION_refreshScene = 23;
        static final int TRANSACTION_removeIIslandStatusCallback = 9;
        static final int TRANSACTION_removeOnTopCardChangedListener = 19;
        static final int TRANSACTION_sendEvent = 5;
        static final int TRANSACTION_setKeyguardLocked = 12;
        static final int TRANSACTION_setPriority = 21;
        static final int TRANSACTION_setVisible = 6;
        static final int TRANSACTION_tryExpand = 14;
        static final int TRANSACTION_updateAudioAmplitude = 24;
        static final int TRANSACTION_updateSessionFlags = 17;
        static final int TRANSACTION_updateWidget = 3;
        static final int TRANSACTION_updateWidgetAnimation = 4;

        public static class Proxy implements IIslandService {
            public static IIslandService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void collapseNotificationPanel() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_collapseNotificationPanel, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().collapseNotificationPanel();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void doCollapse() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().doCollapse();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public Bundle getIslandVersion() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L17
                if (r1.readInt() == 0) goto L14;
                Bundle r2 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
            L15:
                r1.recycle();
                r0.recycle();
                return r2;
            L14:
                r2 = null;
                goto L15
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Bundle r3 = Stub.getDefaultImpl().getIslandVersion();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return r3;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onLauncherFocused() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onLauncherFocused();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onVolumeButtonClick() throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onVolumeButtonClick();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void addIIslandStatusCallback(IIslandStatusCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addIIslandStatusCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void addOnTopCardChangedListener(ITopSessionChangedCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().addOnTopCardChangedListener(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void destroySession(IslandSession r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L19
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L19
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L19
            L8:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L19
                if (r1.readInt() == 0) goto L17;
                r6.readFromParcel(r1);     // Catch: Throwable -> L19
            L17:
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().destroySession(r6);     // Catch: Throwable -> L19
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L19
            L19:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public Bundle getPriority(IslandSession r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L21
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L21
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L21
            L8:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L21
                if (r1.readInt() == 0) goto L18;
                Bundle r7 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L21
            L19:
                r1.recycle();
                r0.recycle();
                return r7;
            L18:
                r7 = null;
                goto L19
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Bundle r8 = Stub.getDefaultImpl().getPriority(r6);     // Catch: Throwable -> L21
                r1.recycle();
                r0.recycle();
                return r8;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L21
            L21:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onNotificationVisible(boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().onNotificationVisible(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void onSysUIFlagsChanged(long r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L13
                r0.writeLong(r6);     // Catch: Throwable -> L13
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, r1, 0) == false) goto L6;
            L10:
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L6:
                if (Stub.getDefaultImpl() == null) goto L10;
                Stub.getDefaultImpl().onSysUIFlagsChanged(r6);     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void refreshScene(IslandSession r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_refreshScene, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().refreshScene(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void removeIIslandStatusCallback(IIslandStatusCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeIIslandStatusCallback(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void removeOnTopCardChangedListener(ITopSessionChangedCallback r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                IBinder r2 = r6.asBinder();     // Catch: Throwable -> L17
            L7:
                r0.writeStrongBinder(r2);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().removeOnTopCardChangedListener(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r2 = null;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void setKeyguardLocked(boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setKeyguardLocked(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void setPriority(IslandSession r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_setPriority, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setPriority(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void setVisible(boolean r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == false) goto L6;
                int r3 = 1;
            L7:
                r0.writeInt(r3);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().setVisible(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r3 = 0;
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void updateSessionFlags(IslandSession r6) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L8:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateSessionFlags(r6);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void tryExpand(IslandSession r6, boolean r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                int r2 = 1;
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == true) goto L10;
                r2 = 0;
            L10:
                r0.writeInt(r2);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().tryExpand(r6, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void updateAudioAmplitude(IslandSession r6, float r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L17
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L17
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L17
            L7:
                r0.writeFloat(r7);     // Catch: Throwable -> L17
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, Stub.TRANSACTION_updateAudioAmplitude, r0, r1, 0) == false) goto L10;
            L14:
                r1.readException();     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L10:
                if (Stub.getDefaultImpl() == null) goto L14;
                Stub.getDefaultImpl().updateAudioAmplitude(r6, r7);     // Catch: Throwable -> L17
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L17
            L17:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void updateWidget(IslandSession r6, IslandWidget r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().updateWidget(r6, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void updateWidgetAnimation(IslandSession r6, IslandWidget r7) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L11:
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().updateWidgetAnimation(r6, r7);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void createSession(IslandSession r6, String r7, IIslandCardCallback r8) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L23
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L23
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L23
            L7:
                r0.writeString(r7);     // Catch: Throwable -> L23
                if (r8 == null) goto L10;
                IBinder r4 = r8.asBinder();     // Catch: Throwable -> L23
            L11:
                r0.writeStrongBinder(r4);     // Catch: Throwable -> L23
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L14;
            L18:
                r1.readException();     // Catch: Throwable -> L23
                if (r1.readInt() == 0) goto L21;
                r6.readFromParcel(r1);     // Catch: Throwable -> L23
            L21:
                r1.recycle();
                r0.recycle();
                return;
            L14:
                if (Stub.getDefaultImpl() == null) goto L18;
                Stub.getDefaultImpl().createSession(r6, r7, r8);     // Catch: Throwable -> L23
                r1.recycle();
                r0.recycle();
                return;
            L10:
                r4 = null;
                goto L11
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L23
            L23:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // com.obric.livecard.api.IIslandService
            public void sendEvent(IslandSession r6, IslandWidget r7, String r8, String r9) throws RemoteException {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L20
                if (r6 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L7:
                if (r7 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L20
                r7.writeToParcel(r0, 0);     // Catch: Throwable -> L20
            L10:
                r0.writeString(r8);     // Catch: Throwable -> L20
                r0.writeString(r9);     // Catch: Throwable -> L20
                if (INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L13;
            L17:
                r1.readException();     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L13:
                if (Stub.getDefaultImpl() == null) goto L17;
                Stub.getDefaultImpl().sendEvent(r6, r7, r8, r9);     // Catch: Throwable -> L20
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L20
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L20
            L20:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Skip({"com.obric.assistant.interaction.impl.performance"})
            public static boolean INVOKEINTERFACE_com_obric_livecard_api_IIslandService$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
                if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
                long r2 = SystemClock.uptimeMillis();
                boolean r0 = r15.transact(r16, r17, r18, r19);     // Catch: Throwable -> L12
                long r8 = SystemClock.uptimeMillis() - r2;
                if (r8 < 100) goto L11;
                BinderPerformanceReporter.report(r8, r15.getClass().getName(), r16, r19, new Throwable("Slow main-thread Binder transaction"));
            L11:
                return r0;
            L12:
                th = move-exception;
                long r9 = SystemClock.uptimeMillis() - r2;
                if (r9 < 100) goto L22;
                if (r15 != null) goto L17;
                String r1 = "";
            L18:
                BinderPerformanceReporter.report(r9, r1, r16, r19, new Throwable("Slow main-thread Binder transaction"));
                throw th;
            L17:
                r1 = r15.getClass().getName();
                goto L18
            L22:
                throw th;
            L5:
                return r15.transact(r16, r17, r18, r19);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IIslandService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IIslandService asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IIslandService) == false) goto L12;
            return (IIslandService) r0;
        L12:
            return new Proxy(r2);
        }

        public static boolean setDefaultImpl(IIslandService r1) {
            if (Proxy.sDefaultImpl != null) goto L7;
            if (r1 == null) goto L9;
            Proxy.sDefaultImpl = r1;
            return true;
        L9:
            return false;
        L7:
            return false;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) throws RemoteException {
            if (r5 == 1598968902) goto L125;
            boolean r0 = false;
            IslandSession r3 = null;
            switch(r5) {
                case 1: goto L117;
                case 2: goto L109;
                case 3: goto L100;
                case 4: goto L91;
                case 5: goto L82;
                case 6: goto L77;
                case 7: goto L75;
                case 8: goto L73;
                case 9: goto L71;
                case 10: goto L69;
                case 11: goto L67;
                case 12: goto L62;
                case 13: goto L57;
                case 14: goto L49;
                case 15: goto L47;
                case 16: goto L42;
                case 17: goto L37;
                case 18: goto L35;
                case 19: goto L33;
                case 20: goto L25;
                case 21: goto L20;
                case 22: goto L18;
                case 23: goto L13;
                case 24: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L11;
            r3 = IslandSession.CREATOR.createFromParcel(r6);
        L11:
            updateAudioAmplitude(r3, r6.readFloat());
            r7.writeNoException();
            return true;
        L13:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L16;
            r3 = IslandSession.CREATOR.createFromParcel(r6);
        L16:
            refreshScene(r3);
            r7.writeNoException();
            return true;
        L18:
            r6.enforceInterface(DESCRIPTOR);
            collapseNotificationPanel();
            r7.writeNoException();
            return true;
        L20:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L23;
            r3 = IslandSession.CREATOR.createFromParcel(r6);
        L23:
            setPriority(r3);
            r7.writeNoException();
            return true;
        L25:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L28;
            r3 = IslandSession.CREATOR.createFromParcel(r6);
        L28:
            Bundle r9 = getPriority(r3);
            r7.writeNoException();
            if (r9 == null) goto L31;
            r7.writeInt(1);
            r9.writeToParcel(r7, 1);
        L32:
            return true;
        L31:
            r7.writeInt(0);
            goto L32
        L33:
            r6.enforceInterface(DESCRIPTOR);
            removeOnTopCardChangedListener(ITopSessionChangedCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L35:
            r6.enforceInterface(DESCRIPTOR);
            addOnTopCardChangedListener(ITopSessionChangedCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L37:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L40;
            r3 = IslandSession.CREATOR.createFromParcel(r6);
        L40:
            updateSessionFlags(r3);
            r7.writeNoException();
            return true;
        L42:
            r6.enforceInterface(DESCRIPTOR);
            Bundle r10 = getIslandVersion();
            r7.writeNoException();
            if (r10 == null) goto L45;
            r7.writeInt(1);
            r10.writeToParcel(r7, 1);
        L46:
            return true;
        L45:
            r7.writeInt(0);
            goto L46
        L47:
            r6.enforceInterface(DESCRIPTOR);
            onSysUIFlagsChanged(r6.readLong());
            r7.writeNoException();
            return true;
        L49:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L53;
            r3 = IslandSession.CREATOR.createFromParcel(r6);
        L53:
            if (r6.readInt() == 0) goto L55;
            r0 = true;
        L55:
            tryExpand(r3, r0);
            r7.writeNoException();
            return true;
        L57:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L60;
            r0 = true;
        L60:
            onNotificationVisible(r0);
            r7.writeNoException();
            return true;
        L62:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L65;
            r0 = true;
        L65:
            setKeyguardLocked(r0);
            r7.writeNoException();
            return true;
        L67:
            r6.enforceInterface(DESCRIPTOR);
            onLauncherFocused();
            r7.writeNoException();
            return true;
        L69:
            r6.enforceInterface(DESCRIPTOR);
            onVolumeButtonClick();
            r7.writeNoException();
            return true;
        L71:
            r6.enforceInterface(DESCRIPTOR);
            removeIIslandStatusCallback(IIslandStatusCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L73:
            r6.enforceInterface(DESCRIPTOR);
            addIIslandStatusCallback(IIslandStatusCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            return true;
        L75:
            r6.enforceInterface(DESCRIPTOR);
            doCollapse();
            r7.writeNoException();
            return true;
        L77:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L80;
            r0 = true;
        L80:
            setVisible(r0);
            r7.writeNoException();
            return true;
        L82:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L85;
            IslandSession r11 = IslandSession.CREATOR.createFromParcel(r6);
        L87:
            if (r6.readInt() == 0) goto L89;
            r3 = IslandWidget.CREATOR.createFromParcel(r6);
        L89:
            sendEvent(r11, r3, r6.readString(), r6.readString());
            r7.writeNoException();
            return true;
        L85:
            r11 = null;
            goto L87
        L91:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L94;
            IslandSession r12 = IslandSession.CREATOR.createFromParcel(r6);
        L96:
            if (r6.readInt() == 0) goto L98;
            r3 = IslandWidget.CREATOR.createFromParcel(r6);
        L98:
            updateWidgetAnimation(r12, r3);
            r7.writeNoException();
            return true;
        L94:
            r12 = null;
            goto L96
        L100:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L103;
            IslandSession r13 = IslandSession.CREATOR.createFromParcel(r6);
        L105:
            if (r6.readInt() == 0) goto L107;
            r3 = IslandWidget.CREATOR.createFromParcel(r6);
        L107:
            updateWidget(r13, r3);
            r7.writeNoException();
            return true;
        L103:
            r13 = null;
            goto L105
        L109:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L112;
            r3 = IslandSession.CREATOR.createFromParcel(r6);
        L112:
            destroySession(r3);
            r7.writeNoException();
            if (r3 == null) goto L115;
            r7.writeInt(1);
            r3.writeToParcel(r7, 1);
        L116:
            return true;
        L115:
            r7.writeInt(0);
            goto L116
        L117:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L120;
            r3 = IslandSession.CREATOR.createFromParcel(r6);
        L120:
            createSession(r3, r6.readString(), IIslandCardCallback.Stub.asInterface(r6.readStrongBinder()));
            r7.writeNoException();
            if (r3 == null) goto L123;
            r7.writeInt(1);
            r3.writeToParcel(r7, 1);
        L124:
            return true;
        L123:
            r7.writeInt(0);
            goto L124
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L125:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    void addIIslandStatusCallback(IIslandStatusCallback r1) throws RemoteException;

    void addOnTopCardChangedListener(ITopSessionChangedCallback r1) throws RemoteException;

    void collapseNotificationPanel() throws RemoteException;

    void createSession(IslandSession r1, String r2, IIslandCardCallback r3) throws RemoteException;

    void destroySession(IslandSession r1) throws RemoteException;

    void doCollapse() throws RemoteException;

    Bundle getIslandVersion() throws RemoteException;

    Bundle getPriority(IslandSession r1) throws RemoteException;

    void onLauncherFocused() throws RemoteException;

    void onNotificationVisible(boolean r1) throws RemoteException;

    void onSysUIFlagsChanged(long r1) throws RemoteException;

    void onVolumeButtonClick() throws RemoteException;

    void refreshScene(IslandSession r1) throws RemoteException;

    void removeIIslandStatusCallback(IIslandStatusCallback r1) throws RemoteException;

    void removeOnTopCardChangedListener(ITopSessionChangedCallback r1) throws RemoteException;

    void sendEvent(IslandSession r1, IslandWidget r2, String r3, String r4) throws RemoteException;

    void setKeyguardLocked(boolean r1) throws RemoteException;

    void setPriority(IslandSession r1) throws RemoteException;

    void setVisible(boolean r1) throws RemoteException;

    void tryExpand(IslandSession r1, boolean r2) throws RemoteException;

    void updateAudioAmplitude(IslandSession r1, float r2) throws RemoteException;

    void updateSessionFlags(IslandSession r1) throws RemoteException;

    void updateWidget(IslandSession r1, IslandWidget r2) throws RemoteException;

    void updateWidgetAnimation(IslandSession r1, IslandWidget r2) throws RemoteException;
}
