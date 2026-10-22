package com.obric.aivoice.core;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.AIVoiceBinder;
import com.obric.aivoice.AIVoiceListener;
import com.obric.aivoice.core.conn.ClientServiceConn;
import com.obric.aivoice.core.data.BundleExtKt;
import com.obric.aivoice.core.data.IdlKeys;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.aivoice.core.log.AIVoiceLog;
import com.obric.aivoice.sdk.AIVoiceConfig;
import com.obric.aivoice.sdk.FileAsrTaskListener;
import com.obric.aivoice.sdk.IConnectListener;
import com.obric.aivoice.sdk.IOfflineServerListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012J\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012J\"\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0010J\u0006\u0010%\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u001aJ\u0016\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004J\b\u0010,\u001a\u00020\u001aH\u0002J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0004J\u000e\u00100\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020.J\u0016\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0004J\u0016\u00107\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/aivoice/core/AIVoiceManagerInner;", NameKeys.UnloadStrategy_No_Strategy, "()V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "aiVoiceConfig", "Lcom/obric/aivoice/sdk/AIVoiceConfig;", "getAiVoiceConfig", "()Lcom/obric/aivoice/sdk/AIVoiceConfig;", "setAiVoiceConfig", "(Lcom/obric/aivoice/sdk/AIVoiceConfig;)V", "conn", "Lcom/obric/aivoice/core/conn/ClientServiceConn;", "connectListener", "Lcom/obric/aivoice/sdk/IConnectListener;", "offlineServerListener", "Lcom/obric/aivoice/sdk/IOfflineServerListener;", "createAsrTask", NameKeys.UnloadStrategy_No_Strategy, "asrConfig", "createFileAsrTask", "listener", "Lcom/obric/aivoice/sdk/FileAsrTaskListener;", "createTtsTask", "ttsConfig", "destroy", NameKeys.UnloadStrategy_No_Strategy, "enableOfflineServer", "enable", NameKeys.UnloadStrategy_No_Strategy, "type", "getBinder", "Lcom/obric/aivoice/AIVoiceBinder;", "getOfflineServerStatus", "init", "config", "statusListener", "onConnected", "onDisconnected", "onOfflineStatusChanged", "status", "mode", "queryFileAsrTask", "taskId", "reConn", "registerOfflineServerListener", "Lcom/obric/aivoice/AIVoiceListener;", "removeAsrTask", "removeTtsTask", "unregisterOfflineServerListener", "writeAsrData", LynxResourceModule.DATA_KEY, NameKeys.UnloadStrategy_No_Strategy, "asrData", "writeTtsEnd", "writeTtsText", "text", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceManagerInner {
    public static final AIVoiceManagerInner INSTANCE = null;
    private static final String TAG = null;
    private static AIVoiceConfig aiVoiceConfig;
    private static ClientServiceConn conn;
    private static IConnectListener connectListener;
    private static IOfflineServerListener offlineServerListener;

    private AIVoiceManagerInner() {
    }

    private final synchronized void reConn() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (conn != null) goto L6;
        conn = ClientServiceConn.Companion.getInstance(new ComponentName("com.obric.aivoice", "com.obric.aivoice.service.AIVoiceService"));     // Catch: Throwable -> L15
    L6:
        AIVoiceConfig r0 = aiVoiceConfig;     // Catch: Throwable -> L15
        Unit r1 = null;
        if (r0 == null) goto L11;
        ClientServiceConn r2 = conn;     // Catch: Throwable -> L15
        if (r2 == null) goto L11;
        r2.conn(r0.getContextGetter());     // Catch: Throwable -> L15
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r1 != null) goto L13;
        AIVoiceLog.INSTANCE.e(TAG, "config is null");     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    public final synchronized AIVoiceBinder getBinder() {
        monitor-enter(this);
        reConn();     // Catch: Throwable -> L10
        ClientServiceConn r0 = conn;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        AIVoiceBinder r1 = r0.getBinder();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r1;
    L7:
        r1 = null;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        INSTANCE = new AIVoiceManagerInner();
        TAG = "AIVoiceManagerInner";
    }

    public final void destroy() {
        AIVoiceConfig r0 = aiVoiceConfig;
        if (r0 == null) goto L8;
        ClientServiceConn r1 = conn;
        if (r1 == null) goto L9;
        r1.disconnect(r0.getContextGetter());
        return;
    L9:
        return;
    }

    public final void onConnected() {
        IConnectListener r0 = connectListener;
        if (r0 == null) goto L6;
        r0.onServerConnected();
        return;
    }

    public final void onDisconnected() {
        IConnectListener r0 = connectListener;
        if (r0 == null) goto L6;
        r0.onServerDisconnected();
        return;
    }

    public final AIVoiceConfig getAiVoiceConfig() {
        return aiVoiceConfig;
    }

    public final int createAsrTask(String r5) {
        Intrinsics.checkNotNullParameter(r5, "asrConfig");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_CreateAsrTask);
        r0.putString(IdlKeys.Args_AsrConfig, r5);
        AIVoiceBinder r1 = getBinder();     // Catch: RemoteException -> L15
        Integer r2 = null;
        if (r1 == null) goto L8;
        Bundle r3 = r1.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r3 == null) goto L8;
        Object r4 = r3.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r4 instanceof Integer) == false) goto L12;
        r2 = (Integer) r4;     // Catch: RemoteException -> L15
    L12:
        if (r2 == null) goto L25;
        return r2.intValue();
    L25:
        return -1;
    L8:
        r4 = null;
    L15:
        e = move-exception;
        AIVoiceLog r6 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        r6.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L26;
        r9.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final int createTtsTask(String r5) {
        Intrinsics.checkNotNullParameter(r5, "ttsConfig");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_CreateTtsTask);
        r0.putString(IdlKeys.Args_TtsConfig, r5);
        AIVoiceBinder r1 = getBinder();     // Catch: RemoteException -> L15
        Integer r2 = null;
        if (r1 == null) goto L8;
        Bundle r3 = r1.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r3 == null) goto L8;
        Object r4 = r3.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r4 instanceof Integer) == false) goto L12;
        r2 = (Integer) r4;     // Catch: RemoteException -> L15
    L12:
        if (r2 == null) goto L25;
        return r2.intValue();
    L25:
        return -1;
    L8:
        r4 = null;
    L15:
        e = move-exception;
        AIVoiceLog r6 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        r6.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L26;
        r9.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final int getOfflineServerStatus(int r5) {
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_GetOfflineServerStatus);
        r0.putInt(IdlKeys.Args_OfflineType, r5);
        AIVoiceBinder r1 = getBinder();     // Catch: RemoteException -> L15
        Integer r2 = null;
        if (r1 == null) goto L8;
        Bundle r3 = r1.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r3 == null) goto L8;
        Object r4 = r3.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r4 instanceof Integer) == false) goto L12;
        r2 = (Integer) r4;     // Catch: RemoteException -> L15
    L12:
        if (r2 == null) goto L25;
        return r2.intValue();
    L25:
        return -1;
    L8:
        r4 = null;
    L15:
        e = move-exception;
        AIVoiceLog r6 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        r6.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L26;
        r9.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final String queryFileAsrTask(String r5) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Bundle r1 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_QueryFileAsrTask);
        r1.putString(IdlKeys.Args_AsrTaskId, r5);
        AIVoiceBinder r6 = getBinder();     // Catch: RemoteException -> L15
        String r2 = null;
        if (r6 == null) goto L8;
        Bundle r7 = r6.callVoiceSync(r1);     // Catch: RemoteException -> L15
        if (r7 == null) goto L8;
        Object r8 = r7.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r8 instanceof String) == false) goto L12;
        r2 = (String) r8;     // Catch: RemoteException -> L15
    L12:
        if (r2 != null) goto L25;
        return NameKeys.UnloadStrategy_No_Strategy;
    L25:
        return r2;
    L8:
        r8 = null;
    L15:
        e = move-exception;
        AIVoiceLog r3 = AIVoiceLog.INSTANCE;
        String r4 = TAG;
        String r9 = e.getMessage();
        if (r9 != null) goto L19;
        r9 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        r3.e(r4, r9, e);
        ClientServiceConn r10 = conn;
        if (r10 == null) goto L26;
        r10.onBinderException();
        return NameKeys.UnloadStrategy_No_Strategy;
    L26:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void registerOfflineServerListener(AIVoiceListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_RegisterOfflineServerListener);
        AIVoiceBinder r1 = getBinder();     // Catch: RemoteException -> L7
        if (r1 == null) goto L17;
        r1.callVoice(r0, r4);     // Catch: RemoteException -> L7
        return;
    L17:
        return;
    L7:
        e = move-exception;
        AIVoiceLog r2 = AIVoiceLog.INSTANCE;
        String r3 = TAG;
        String r5 = e.getMessage();
        if (r5 != null) goto L11;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        r2.e(r3, r5, e);
        ClientServiceConn r6 = conn;
        if (r6 == null) goto L18;
        r6.onBinderException();
        return;
    }

    public final int removeAsrTask(String r5) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_RemoveAsrTask);
        r0.putString(IdlKeys.Args_AsrTaskId, r5);
        AIVoiceBinder r1 = getBinder();     // Catch: RemoteException -> L15
        Integer r2 = null;
        if (r1 == null) goto L8;
        Bundle r3 = r1.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r3 == null) goto L8;
        Object r4 = r3.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r4 instanceof Integer) == false) goto L12;
        r2 = (Integer) r4;     // Catch: RemoteException -> L15
    L12:
        if (r2 == null) goto L25;
        return r2.intValue();
    L25:
        return -1;
    L8:
        r4 = null;
    L15:
        e = move-exception;
        AIVoiceLog r6 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        r6.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L26;
        r9.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final int removeTtsTask(String r5) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_RemoveTtsTask);
        r0.putString(IdlKeys.Args_TtsTaskId, r5);
        AIVoiceBinder r1 = getBinder();     // Catch: RemoteException -> L15
        Integer r2 = null;
        if (r1 == null) goto L8;
        Bundle r3 = r1.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r3 == null) goto L8;
        Object r4 = r3.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r4 instanceof Integer) == false) goto L12;
        r2 = (Integer) r4;     // Catch: RemoteException -> L15
    L12:
        if (r2 == null) goto L25;
        return r2.intValue();
    L25:
        return -1;
    L8:
        r4 = null;
    L15:
        e = move-exception;
        AIVoiceLog r6 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        r6.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L26;
        r9.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final void setAiVoiceConfig(AIVoiceConfig r1) {
        aiVoiceConfig = r1;
    }

    public final void unregisterOfflineServerListener(AIVoiceListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_UnRegisterOfflineServerListener);
        AIVoiceBinder r1 = getBinder();     // Catch: RemoteException -> L7
        if (r1 == null) goto L17;
        r1.callVoice(r0, r4);     // Catch: RemoteException -> L7
        return;
    L17:
        return;
    L7:
        e = move-exception;
        AIVoiceLog r2 = AIVoiceLog.INSTANCE;
        String r3 = TAG;
        String r5 = e.getMessage();
        if (r5 != null) goto L11;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        r2.e(r3, r5, e);
        ClientServiceConn r6 = conn;
        if (r6 == null) goto L18;
        r6.onBinderException();
        return;
    }

    public final int writeTtsEnd(String r5) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_WriteTtsEnd);
        r0.putString(IdlKeys.Args_TtsTaskId, r5);
        AIVoiceBinder r1 = getBinder();     // Catch: RemoteException -> L15
        Integer r2 = null;
        if (r1 == null) goto L8;
        Bundle r3 = r1.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r3 == null) goto L8;
        Object r4 = r3.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r4 instanceof Integer) == false) goto L12;
        r2 = (Integer) r4;     // Catch: RemoteException -> L15
    L12:
        if (r2 == null) goto L25;
        return r2.intValue();
    L25:
        return -1;
    L8:
        r4 = null;
    L15:
        e = move-exception;
        AIVoiceLog r6 = AIVoiceLog.INSTANCE;
        String r7 = TAG;
        String r8 = e.getMessage();
        if (r8 != null) goto L19;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        r6.e(r7, r8, e);
        ClientServiceConn r9 = conn;
        if (r9 == null) goto L26;
        r9.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final String createFileAsrTask(String r4, FileAsrTaskListener r5) {
        Intrinsics.checkNotNullParameter(r4, "asrConfig");
        Bundle r1 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_CreateFileAsrTask);
        r1.putString(IdlKeys.Args_AsrConfig, r4);
        if (r5 == null) goto L25;
        r1.putBinder(IdlKeys.Args_TaskListener, r5.asBinder());
    L25:
        AIVoiceBinder r6 = getBinder();     // Catch: RemoteException -> L17
        String r7 = null;
        if (r6 == null) goto L10;
        Bundle r8 = r6.callVoiceSync(r1);     // Catch: RemoteException -> L17
        if (r8 == null) goto L10;
        Object r9 = r8.get(IdlKeys.Result);     // Catch: RemoteException -> L17
    L12:
        if ((r9 instanceof String) == false) goto L14;
        r7 = (String) r9;     // Catch: RemoteException -> L17
    L14:
        if (r7 != null) goto L27;
        return NameKeys.UnloadStrategy_No_Strategy;
    L27:
        return r7;
    L10:
        r9 = null;
    L17:
        e = move-exception;
        AIVoiceLog r10 = AIVoiceLog.INSTANCE;
        String r2 = TAG;
        String r3 = e.getMessage();
        if (r3 != null) goto L21;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L21:
        r10.e(r2, r3, e);
        ClientServiceConn r11 = conn;
        if (r11 == null) goto L28;
        r11.onBinderException();
        return NameKeys.UnloadStrategy_No_Strategy;
    L28:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final int enableOfflineServer(boolean r3, int r4) {
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_EnableOfflineServer);
        r0.putBoolean(IdlKeys.Args_EnableOffline, r3);
        r0.putInt(IdlKeys.Args_OfflineType, r4);
        AIVoiceConfig r5 = aiVoiceConfig;
        Integer r6 = null;
        if (r5 == null) goto L5;
        String r7 = r5.getPackageName();
    L6:
        r0.putString(IdlKeys.Args_PackageName, r7);
        AIVoiceBinder r8 = getBinder();     // Catch: RemoteException -> L20
        if (r8 == null) goto L12;
        Bundle r9 = r8.callVoiceSync(r0);     // Catch: RemoteException -> L20
        if (r9 == null) goto L12;
        Object r10 = r9.get(IdlKeys.Result);     // Catch: RemoteException -> L20
    L14:
        if ((r10 instanceof Integer) == false) goto L16;
        r6 = (Integer) r10;     // Catch: RemoteException -> L20
    L16:
        if (r6 == null) goto L19;
        return r6.intValue();
    L19:
        return -1;
    L12:
        r10 = null;
    L20:
        e = move-exception;
        AIVoiceLog r11 = AIVoiceLog.INSTANCE;
        String r1 = TAG;
        String r2 = e.getMessage();
        if (r2 != null) goto L24;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L24:
        r11.e(r1, r2, e);
        ClientServiceConn r12 = conn;
        if (r12 == null) goto L27;
        r12.onBinderException();
    L27:
        return 0;
    L5:
        r7 = null;
        goto L6
    }

    public final void onOfflineStatusChanged(boolean r5, int r6) {
        AIVoiceLog.INSTANCE.d(TAG, "onOfflineStatusChanged status:" + r5 + " mode:" + r6);
        IOfflineServerListener r0 = offlineServerListener;
        if (r0 == null) goto L6;
        r0.onOfflineServerStatusChanged(r5, r6);
        return;
    }

    public final int writeAsrData(byte[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r5, "asrData");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_WriteAsrData);
        r0.putByteArray(IdlKeys.Args_AudioBin, r4);
        r0.putString(IdlKeys.Args_AsrData, r5);
        AIVoiceBinder r6 = getBinder();     // Catch: RemoteException -> L15
        Integer r1 = null;
        if (r6 == null) goto L8;
        Bundle r7 = r6.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r7 == null) goto L8;
        Object r8 = r7.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r8 instanceof Integer) == false) goto L12;
        r1 = (Integer) r8;     // Catch: RemoteException -> L15
    L12:
        if (r1 == null) goto L25;
        return r1.intValue();
    L25:
        return -1;
    L8:
        r8 = null;
    L15:
        e = move-exception;
        AIVoiceLog r2 = AIVoiceLog.INSTANCE;
        String r3 = TAG;
        String r9 = e.getMessage();
        if (r9 != null) goto L19;
        r9 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        r2.e(r3, r9, e);
        ClientServiceConn r10 = conn;
        if (r10 == null) goto L26;
        r10.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final int writeTtsText(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "text");
        Bundle r0 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_WriteTtsText);
        r0.putString(IdlKeys.Args_TtsTaskId, r4);
        r0.putString(IdlKeys.Args_TtsText, r5);
        AIVoiceBinder r6 = getBinder();     // Catch: RemoteException -> L15
        Integer r1 = null;
        if (r6 == null) goto L8;
        Bundle r7 = r6.callVoiceSync(r0);     // Catch: RemoteException -> L15
        if (r7 == null) goto L8;
        Object r8 = r7.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r8 instanceof Integer) == false) goto L12;
        r1 = (Integer) r8;     // Catch: RemoteException -> L15
    L12:
        if (r1 == null) goto L25;
        return r1.intValue();
    L25:
        return -1;
    L8:
        r8 = null;
    L15:
        e = move-exception;
        AIVoiceLog r2 = AIVoiceLog.INSTANCE;
        String r3 = TAG;
        String r9 = e.getMessage();
        if (r9 != null) goto L19;
        r9 = NameKeys.UnloadStrategy_No_Strategy;
    L19:
        r2.e(r3, r9, e);
        ClientServiceConn r10 = conn;
        if (r10 == null) goto L26;
        r10.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final synchronized void init(AIVoiceConfig r2, IConnectListener r3, IOfflineServerListener r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "config");     // Catch: Throwable -> L6
        aiVoiceConfig = r2;     // Catch: Throwable -> L6
        connectListener = r3;     // Catch: Throwable -> L6
        offlineServerListener = r4;     // Catch: Throwable -> L6
        reConn();     // Catch: Throwable -> L6
        AIVoiceLog.INSTANCE.v(TAG, "initialize success.");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
