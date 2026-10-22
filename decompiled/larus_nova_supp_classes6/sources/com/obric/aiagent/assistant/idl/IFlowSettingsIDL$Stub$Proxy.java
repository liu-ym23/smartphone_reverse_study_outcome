package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.FeatureConfigMap;
import com.obric.aiagent.assistant.idl.bean.OComplexTaskConfig;
import com.obric.aiagent.assistant.idl.bean.OModelConfig;
import com.obric.aiagent.assistant.idl.bean.ObricMemoryDataCollectConfig;
import com.obric.assistant.interaction.impl.performance.BinderPerformanceReporter;
import java.util.HashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class IFlowSettingsIDL$Stub$Proxy implements IFlowSettingsIDL {
    public static IFlowSettingsIDL sDefaultImpl;
    private IBinder mRemote;

    public String getInterfaceDescriptor() {
        return "com.obric.aiagent.assistant.idl.IFlowSettingsIDL";
    }

    public Map getAutoExecuteAuthorizationStatusMap() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 27, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        HashMap r2 = r1.readHashMap(getClass().getClassLoader());     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        Map r3 = IFlowSettingsIDL.Stub.getDefaultImpl().getAutoExecuteAuthorizationStatusMap();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public int getAutoGuiEnabledScene() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 1, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        int r2 = r1.readInt();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        int r3 = IFlowSettingsIDL.Stub.getDefaultImpl().getAutoGuiEnabledScene();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public String getAutoGuiFastModeUseSettings() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 28, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r2 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        String r3 = IFlowSettingsIDL.Stub.getDefaultImpl().getAutoGuiFastModeUseSettings();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean getAutoImageUploadEnabled() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 20, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowSettingsIDL.Stub.getDefaultImpl().getAutoImageUploadEnabled();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public FeatureConfigMap getFeatureConfigMap() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 12, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        FeatureConfigMap r2 = FeatureConfigMap.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r2;
    L14:
        r2 = null;
        goto L15
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        FeatureConfigMap r3 = IFlowSettingsIDL.Stub.getDefaultImpl().getFeatureConfigMap();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r3;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public int getIntentUploadStrategyForDebug() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 7, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        int r2 = r1.readInt();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        int r3 = IFlowSettingsIDL.Stub.getDefaultImpl().getIntentUploadStrategyForDebug();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean getOAutoUseClipboardEnabled() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 25, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowSettingsIDL.Stub.getDefaultImpl().getOAutoUseClipboardEnabled();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean getOUseMemoryEnabled() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 17, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowSettingsIDL.Stub.getDefaultImpl().getOUseMemoryEnabled();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public OComplexTaskConfig getObricComplexTaskConfig() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 9, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        OComplexTaskConfig r2 = OComplexTaskConfig.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r2;
    L14:
        r2 = null;
        goto L15
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        OComplexTaskConfig r3 = IFlowSettingsIDL.Stub.getDefaultImpl().getObricComplexTaskConfig();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r3;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public ObricMemoryDataCollectConfig getObricMemoryDataCollectConfig() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 13, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        ObricMemoryDataCollectConfig r2 = ObricMemoryDataCollectConfig.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r2;
    L14:
        r2 = null;
        goto L15
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        ObricMemoryDataCollectConfig r3 = IFlowSettingsIDL.Stub.getDefaultImpl().getObricMemoryDataCollectConfig();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r3;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public OModelConfig getObricModelConfig() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L17
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 10, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L17
        if (r1.readInt() == 0) goto L14;
        OModelConfig r2 = OModelConfig.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L17
    L15:
        r1.recycle();
        r0.recycle();
        return r2;
    L14:
        r2 = null;
        goto L15
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        OModelConfig r3 = IFlowSettingsIDL.Stub.getDefaultImpl().getObricModelConfig();     // Catch: Throwable -> L17
        r1.recycle();
        r0.recycle();
        return r3;
    L17:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public int getObricPowerLockTimeoutInSeconds() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 8, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        int r2 = r1.readInt();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r2;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        int r3 = IFlowSettingsIDL.Stub.getDefaultImpl().getObricPowerLockTimeoutInSeconds();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r3;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean getPersonalContextEnabled() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 5, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowSettingsIDL.Stub.getDefaultImpl().getPersonalContextEnabled();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean getSemanticeScreenShotEnabled() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 3, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowSettingsIDL.Stub.getDefaultImpl().getSemanticeScreenShotEnabled();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isLarkKnowledgeAuthorizationEnable() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 18, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowSettingsIDL.Stub.getDefaultImpl().isLarkKnowledgeAuthorizationEnable();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isLarkSendConfirmEnabled() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 22, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowSettingsIDL.Stub.getDefaultImpl().isLarkSendConfirmEnabled();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isTtsPlayBackgroundEnabled() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 11, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowSettingsIDL.Stub.getDefaultImpl().isTtsPlayBackgroundEnabled();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public boolean isVoicePrintAuthenticateAutoGuiEnabled() throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L15
        boolean r4 = false;
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 24, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L15
        if (r1.readInt() == 0) goto L13;
        r4 = true;
    L13:
        r1.recycle();
        r0.recycle();
        return r4;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        boolean r2 = IFlowSettingsIDL.Stub.getDefaultImpl().isVoicePrintAuthenticateAutoGuiEnabled();     // Catch: Throwable -> L15
        r1.recycle();
        r0.recycle();
        return r2;
    L15:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public IBinder asBinder() {
        return this.mRemote;
    }

    public IFlowSettingsIDL$Stub$Proxy(IBinder r1) {
        this.mRemote = r1;
    }

    public int getAuthenticationTypeOnLockScreen(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 26, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        int r7 = r1.readInt();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r7;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        int r8 = IFlowSettingsIDL.Stub.getDefaultImpl().getAuthenticationTypeOnLockScreen(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public int getIntentAuthStatus(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 6, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        int r7 = r1.readInt();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r7;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        int r8 = IFlowSettingsIDL.Stub.getDefaultImpl().getIntentAuthStatus(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public String getObricCloudConfig(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 15, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r7 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r7;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        String r8 = IFlowSettingsIDL.Stub.getDefaultImpl().getObricCloudConfig(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public String getObricFlowSettingsJson(String r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        Parcel r1 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L13
        r0.writeString(r6);     // Catch: Throwable -> L13
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 14, r0, r1, 0) == false) goto L6;
    L10:
        r1.readException();     // Catch: Throwable -> L13
        String r7 = r1.readString();     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r7;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        String r8 = IFlowSettingsIDL.Stub.getDefaultImpl().getObricFlowSettingsJson(r6);     // Catch: Throwable -> L13
        r1.recycle();
        r0.recycle();
        return r8;
    L13:
        th = move-exception;
        r1.recycle();
        r0.recycle();
        throw th;
    }

    public void setAutoGuiEnabledScene(int r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L12
        r0.writeInt(r6);     // Catch: Throwable -> L12
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 2, r0, null, 1) == false) goto L6;
    L10:
        r0.recycle();
        return;
    L6:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L10;
        IFlowSettingsIDL.Stub.getDefaultImpl().setAutoGuiEnabledScene(r6);     // Catch: Throwable -> L12
        r0.recycle();
        return;
    L12:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void setAutoImageUploadEnabled(boolean r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L16
        if (r6 == false) goto L6;
        int r2 = 1;
    L7:
        r0.writeInt(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 21, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowSettingsIDL.Stub.getDefaultImpl().setAutoImageUploadEnabled(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = 0;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void setLarkKnowledgeAuthorizationEnabled(boolean r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L16
        if (r6 == false) goto L6;
        int r2 = 1;
    L7:
        r0.writeInt(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 19, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowSettingsIDL.Stub.getDefaultImpl().setLarkKnowledgeAuthorizationEnabled(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = 0;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void setOUseMemoryEnabled(boolean r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L16
        if (r6 == false) goto L6;
        int r2 = 1;
    L7:
        r0.writeInt(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 16, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowSettingsIDL.Stub.getDefaultImpl().setOUseMemoryEnabled(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = 0;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void setSemanticScreenShotEnabled(boolean r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L16
        if (r6 == false) goto L6;
        int r2 = 1;
    L7:
        r0.writeInt(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 4, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowSettingsIDL.Stub.getDefaultImpl().setSemanticScreenShotEnabled(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = 0;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    public void setVoicePrintAuthenticateAutoGuiEnabled(boolean r6) throws RemoteException {
        Parcel r0 = Parcel.obtain();
        r0.writeInterfaceToken("com.obric.aiagent.assistant.idl.IFlowSettingsIDL");     // Catch: Throwable -> L16
        if (r6 == false) goto L6;
        int r2 = 1;
    L7:
        r0.writeInt(r2);     // Catch: Throwable -> L16
        if (INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(this.mRemote, 23, r0, null, 1) == false) goto L10;
    L14:
        r0.recycle();
        return;
    L10:
        if (IFlowSettingsIDL.Stub.getDefaultImpl() == null) goto L14;
        IFlowSettingsIDL.Stub.getDefaultImpl().setVoicePrintAuthenticateAutoGuiEnabled(r6);     // Catch: Throwable -> L16
        r0.recycle();
        return;
    L6:
        r2 = 0;
    L16:
        th = move-exception;
        r0.recycle();
        throw th;
    }

    @Skip({"com.obric.assistant.interaction.impl.performance"})
    public static boolean INVOKEINTERFACE_com_obric_aiagent_assistant_idl_IFlowSettingsIDL$Stub$Proxy_com_obric_assistant_interaction_impl_BinderLancet_transact(IBinder r15, int r16, Parcel r17, Parcel r18, int r19) throws RemoteException {
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
