package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentAppIntentIDLStubWrapper extends IAgentAppIntentIDL.Stub {
    boolean log;
    final IAgentAppIntentIDL.Stub origin;

    public boolean isAppIntentActive() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentAppIntentIDLStub", "isAppIntentActive()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "isAppIntentActive() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "isAppIntentActive", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentAppIntentIDLStub", "isAppIntentActive()");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.isAppIntentActive();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentAppIntentIDLStub", "isAppIntentActive = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "isAppIntentActive() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "isAppIntentActive", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public boolean isWifiEnabled() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentAppIntentIDLStub", "isWifiEnabled()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "isWifiEnabled() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "isWifiEnabled", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentAppIntentIDLStub", "isWifiEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.isWifiEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentAppIntentIDLStub", "isWifiEnabled = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "isWifiEnabled() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "isWifiEnabled", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public void jumpToSystemOtaPage() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentAppIntentIDLStub", "jumpToSystemOtaPage()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "jumpToSystemOtaPage() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "jumpToSystemOtaPage", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentAppIntentIDLStub", "jumpToSystemOtaPage()");     // Catch: Exception -> L11
    L6:
        this.origin.jumpToSystemOtaPage();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "jumpToSystemOtaPage = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "jumpToSystemOtaPage() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "jumpToSystemOtaPage", r14, r16);     // Catch: Exception -> L11
    }

    public void notifyCloseAutoGUISwitch() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch()");     // Catch: Exception -> L11
    L6:
        this.origin.notifyCloseAutoGUISwitch();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch", r14, r16);     // Catch: Exception -> L11
    }

    public void notifyUserAgreePrivacy() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentAppIntentIDLStub", "notifyUserAgreePrivacy()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "notifyUserAgreePrivacy() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "notifyUserAgreePrivacy", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentAppIntentIDLStub", "notifyUserAgreePrivacy()");     // Catch: Exception -> L11
    L6:
        this.origin.notifyUserAgreePrivacy();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "notifyUserAgreePrivacy = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "notifyUserAgreePrivacy() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "notifyUserAgreePrivacy", r14, r16);     // Catch: Exception -> L11
    }

    public int pauseMusic() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentAppIntentIDLStub", "pauseMusic()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "pauseMusic() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "pauseMusic", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentAppIntentIDLStub", "pauseMusic()");     // Catch: Exception -> L11
    L6:
        int r11 = this.origin.pauseMusic();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentAppIntentIDLStub", "pauseMusic = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "pauseMusic() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "pauseMusic", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public void showMusicPage() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentAppIntentIDLStub", "showMusicPage()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showMusicPage() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showMusicPage", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentAppIntentIDLStub", "showMusicPage()");     // Catch: Exception -> L11
    L6:
        this.origin.showMusicPage();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showMusicPage = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showMusicPage() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showMusicPage", r14, r16);     // Catch: Exception -> L11
    }

    public void terminateService() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentAppIntentIDLStub", "terminateService()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "terminateService() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "terminateService", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentAppIntentIDLStub", "terminateService()");     // Catch: Exception -> L11
    L6:
        this.origin.terminateService();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "terminateService = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "terminateService() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "terminateService", r14, r16);     // Catch: Exception -> L11
    }

    public AgentAppIntentIDLStubWrapper(IAgentAppIntentIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public void callShortLink(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "callShortLink(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "callShortLink(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "callShortLink", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "callShortLink(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.callShortLink(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "callShortLink = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "callShortLink(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "callShortLink", r14, r18);     // Catch: Exception -> L11
    }

    public void clearAllOmniTask(Map r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "clearAllOmniTask(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "clearAllOmniTask(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "clearAllOmniTask", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "clearAllOmniTask(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.clearAllOmniTask(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "clearAllOmniTask = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "clearAllOmniTask(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "clearAllOmniTask", r14, r18);     // Catch: Exception -> L11
    }

    public void drainOmniUploadImagesForFeedback(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.drainOmniUploadImagesForFeedback(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback", r14, r18);     // Catch: Exception -> L11
    }

    public List<AppEntity> getAppEntityList(Map r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "getAppEntityList(" + r23 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "getAppEntityList(" + r23 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "getAppEntityList", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r13 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "getAppEntityList(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        List<AppEntity> r14 = this.origin.getAppEntityList(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r15 = h.a;     // Catch: Exception -> L11
        h.d("AgentAppIntentIDLStub", "getAppEntityList = " + r14);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "getAppEntityList(" + r23 + ") = " + r14, r16);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "getAppEntityList", r16, r18);     // Catch: Exception -> L11
        return r14;
    }

    public List<String> getComplexTaskPanelInfoFromPC(int r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC(" + r23 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC(" + r23 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r13 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        List<String> r14 = this.origin.getComplexTaskPanelInfoFromPC(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r15 = h.a;     // Catch: Exception -> L11
        h.d("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC = " + r14);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC(" + r23 + ") = " + r14, r16);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC", r16, r18);     // Catch: Exception -> L11
        return r14;
    }

    public IntentDebugReport getIntentExecution(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "getIntentExecution(" + r23 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "getIntentExecution(" + r23 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "getIntentExecution", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r13 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "getIntentExecution(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        IntentDebugReport r14 = this.origin.getIntentExecution(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r15 = h.a;     // Catch: Exception -> L11
        h.d("AgentAppIntentIDLStub", "getIntentExecution = " + r14);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "getIntentExecution(" + r23 + ") = " + r14, r16);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "getIntentExecution", r16, r18);     // Catch: Exception -> L11
        return r14;
    }

    public Map getOmniExtraLog(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "getOmniExtraLog(" + r23 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "getOmniExtraLog(" + r23 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "getOmniExtraLog", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r13 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "getOmniExtraLog(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        Map r14 = this.origin.getOmniExtraLog(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r15 = h.a;     // Catch: Exception -> L11
        h.d("AgentAppIntentIDLStub", "getOmniExtraLog = " + r14);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "getOmniExtraLog(" + r23 + ") = " + r14, r16);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "getOmniExtraLog", r16, r18);     // Catch: Exception -> L11
        return r14;
    }

    public List<String> getOmniJournalPath(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "getOmniJournalPath(" + r23 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "getOmniJournalPath(" + r23 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "getOmniJournalPath", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r13 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "getOmniJournalPath(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        List<String> r14 = this.origin.getOmniJournalPath(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r15 = h.a;     // Catch: Exception -> L11
        h.d("AgentAppIntentIDLStub", "getOmniJournalPath = " + r14);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "getOmniJournalPath(" + r23 + ") = " + r14, r16);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "getOmniJournalPath", r16, r18);     // Catch: Exception -> L11
        return r14;
    }

    public void notifyStopComplexTask(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "notifyStopComplexTask(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "notifyStopComplexTask(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "notifyStopComplexTask", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "notifyStopComplexTask(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyStopComplexTask(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "notifyStopComplexTask = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "notifyStopComplexTask(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "notifyStopComplexTask", r14, r18);     // Catch: Exception -> L11
    }

    public void onLoginStateChange(boolean r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "onLoginStateChange(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "onLoginStateChange(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "onLoginStateChange", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "onLoginStateChange(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onLoginStateChange(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "onLoginStateChange = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "onLoginStateChange(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "onLoginStateChange", r14, r18);     // Catch: Exception -> L11
    }

    public void registerMusicStateListener(IMusicStateListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "registerMusicStateListener(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "registerMusicStateListener(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "registerMusicStateListener", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L24
        h.c("AgentAppIntentIDLStub", "registerMusicStateListener(" + r20 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r4 = this.origin;     // Catch: Exception -> L24
        if (r20 != null) goto L10;
    L18:
        IMusicStateListenerIDL r13 = r20;
    L19:
        r4.registerMusicStateListener(r13);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        h.d("AgentAppIntentIDLStub", "registerMusicStateListener = void");     // Catch: Exception -> L24
    L22:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L24
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "registerMusicStateListener(" + r20 + ") = void", r14);     // Catch: Exception -> L24
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "registerMusicStateListener", r14, r18);     // Catch: Exception -> L24
        return;
    L10:
        if ((r20 instanceof MusicStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r20 instanceof MusicStateListenerIDLStubWrapper) == true) goto L18;
        if ((r20 instanceof IMusicStateListenerIDL.Stub) == false) goto L17;
        r13 = e4.a((IMusicStateListenerIDL.Stub) r20);     // Catch: Exception -> L24
        goto L19
    L17:
        r13 = e4.b(r20);     // Catch: Exception -> L24
        goto L19
    }

    public void screenShot(IScreenshotCallbackIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "screenShot(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "screenShot(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "screenShot", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L24
        h.c("AgentAppIntentIDLStub", "screenShot(" + r20 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r4 = this.origin;     // Catch: Exception -> L24
        if (r20 != null) goto L10;
    L18:
        IScreenshotCallbackIDL r13 = r20;
    L19:
        r4.screenShot(r13);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        h.d("AgentAppIntentIDLStub", "screenShot = void");     // Catch: Exception -> L24
    L22:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L24
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "screenShot(" + r20 + ") = void", r14);     // Catch: Exception -> L24
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "screenShot", r14, r18);     // Catch: Exception -> L24
        return;
    L10:
        if ((r20 instanceof ScreenshotCallbackIDLIpcWrapper) == true) goto L18;
        if ((r20 instanceof ScreenshotCallbackIDLStubWrapper) == true) goto L18;
        if ((r20 instanceof IScreenshotCallbackIDL.Stub) == false) goto L17;
        r13 = u4.a((IScreenshotCallbackIDL.Stub) r20);     // Catch: Exception -> L24
        goto L19
    L17:
        r13 = u4.b(r20);     // Catch: Exception -> L24
        goto L19
    }

    public void setDebugReferImg(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "setDebugReferImg(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "setDebugReferImg(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "setDebugReferImg", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "setDebugReferImg(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setDebugReferImg(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "setDebugReferImg = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "setDebugReferImg(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "setDebugReferImg", r14, r18);     // Catch: Exception -> L11
    }

    public boolean setWifiEnabled(boolean r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "setWifiEnabled(" + r23 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "setWifiEnabled(" + r23 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "setWifiEnabled", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r13 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "setWifiEnabled(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        boolean r14 = this.origin.setWifiEnabled(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r15 = h.a;     // Catch: Exception -> L11
        h.d("AgentAppIntentIDLStub", "setWifiEnabled = " + r14);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "setWifiEnabled(" + r23 + ") = " + r14, r16);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "setWifiEnabled", r16, r18);     // Catch: Exception -> L11
        return r14;
    }

    public void showAlarm(AlarmEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showAlarm(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showAlarm(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showAlarm", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showAlarm(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showAlarm(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showAlarm = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showAlarm(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showAlarm", r14, r18);     // Catch: Exception -> L11
    }

    public void showAlbum(AlbumEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showAlbum(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showAlbum(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showAlbum", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showAlbum(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showAlbum(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showAlbum = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showAlbum(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showAlbum", r14, r18);     // Catch: Exception -> L11
    }

    public void showAuditoryRecording(AuditoryRecordingEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showAuditoryRecording(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showAuditoryRecording(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showAuditoryRecording", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showAuditoryRecording(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showAuditoryRecording(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showAuditoryRecording = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showAuditoryRecording(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showAuditoryRecording", r14, r18);     // Catch: Exception -> L11
    }

    public void showCallHistory(CallHistoryEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showCallHistory(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showCallHistory(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showCallHistory", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showCallHistory(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showCallHistory(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showCallHistory = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showCallHistory(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showCallHistory", r14, r18);     // Catch: Exception -> L11
    }

    public void showContact(ContactEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showContact(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showContact(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showContact", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showContact(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showContact(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showContact = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showContact(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showContact", r14, r18);     // Catch: Exception -> L11
    }

    public void showCountdown(CountdownEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showCountdown(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showCountdown(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showCountdown", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showCountdown(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showCountdown(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showCountdown = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showCountdown(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showCountdown", r14, r18);     // Catch: Exception -> L11
    }

    public void showFile(FileEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showFile(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showFile(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showFile", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showFile(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showFile(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showFile = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showFile(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showFile", r14, r18);     // Catch: Exception -> L11
    }

    public void showLarkUrl(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showLarkUrl(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showLarkUrl(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showLarkUrl", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showLarkUrl(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showLarkUrl(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showLarkUrl = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showLarkUrl(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showLarkUrl", r14, r18);     // Catch: Exception -> L11
    }

    public void showMemory(MemoryEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showMemory(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showMemory(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showMemory", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showMemory(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showMemory(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showMemory = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showMemory(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showMemory", r14, r18);     // Catch: Exception -> L11
    }

    public void showMessage(MessageEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showMessage(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showMessage(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showMessage", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showMessage(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showMessage(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showMessage = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showMessage(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showMessage", r14, r18);     // Catch: Exception -> L11
    }

    public void showNote(NoteEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showNote(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showNote(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showNote", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showNote(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showNote(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showNote = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showNote(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showNote", r14, r18);     // Catch: Exception -> L11
    }

    public void showProactiveMemory(ProactiveMemoryEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showProactiveMemory(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showProactiveMemory(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showProactiveMemory", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showProactiveMemory(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showProactiveMemory(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showProactiveMemory = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showProactiveMemory(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showProactiveMemory", r14, r18);     // Catch: Exception -> L11
    }

    public void showProxyCallHistory(String r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showProxyCallHistory(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showProxyCallHistory(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showProxyCallHistory", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showProxyCallHistory(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showProxyCallHistory(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showProxyCallHistory = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showProxyCallHistory(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showProxyCallHistory", r14, r18);     // Catch: Exception -> L11
    }

    public void showRecording(RecordingEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showRecording(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showRecording(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showRecording", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showRecording(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showRecording(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showRecording = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showRecording(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showRecording", r14, r18);     // Catch: Exception -> L11
    }

    public void showSchedule(ScheduleEntity r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "showSchedule(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showSchedule(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showSchedule", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showSchedule(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showSchedule(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showSchedule = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showSchedule(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showSchedule", r14, r18);     // Catch: Exception -> L11
    }

    public void takeScreenshot(IScreenshotCallbackIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "takeScreenshot(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "takeScreenshot(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "takeScreenshot", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L24
        h.c("AgentAppIntentIDLStub", "takeScreenshot(" + r20 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r4 = this.origin;     // Catch: Exception -> L24
        if (r20 != null) goto L10;
    L18:
        IScreenshotCallbackIDL r13 = r20;
    L19:
        r4.takeScreenshot(r13);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        h.d("AgentAppIntentIDLStub", "takeScreenshot = void");     // Catch: Exception -> L24
    L22:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L24
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "takeScreenshot(" + r20 + ") = void", r14);     // Catch: Exception -> L24
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "takeScreenshot", r14, r18);     // Catch: Exception -> L24
        return;
    L10:
        if ((r20 instanceof ScreenshotCallbackIDLIpcWrapper) == true) goto L18;
        if ((r20 instanceof ScreenshotCallbackIDLStubWrapper) == true) goto L18;
        if ((r20 instanceof IScreenshotCallbackIDL.Stub) == false) goto L17;
        r13 = u4.a((IScreenshotCallbackIDL.Stub) r20);     // Catch: Exception -> L24
        goto L19
    L17:
        r13 = u4.b(r20);     // Catch: Exception -> L24
        goto L19
    }

    public void unregisterMusicStateListener(IMusicStateListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "unregisterMusicStateListener(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "unregisterMusicStateListener(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "unregisterMusicStateListener", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L24
        h.c("AgentAppIntentIDLStub", "unregisterMusicStateListener(" + r20 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r4 = this.origin;     // Catch: Exception -> L24
        if (r20 != null) goto L10;
    L18:
        IMusicStateListenerIDL r13 = r20;
    L19:
        r4.unregisterMusicStateListener(r13);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        h.d("AgentAppIntentIDLStub", "unregisterMusicStateListener = void");     // Catch: Exception -> L24
    L22:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L24
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "unregisterMusicStateListener(" + r20 + ") = void", r14);     // Catch: Exception -> L24
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "unregisterMusicStateListener", r14, r18);     // Catch: Exception -> L24
        return;
    L10:
        if ((r20 instanceof MusicStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r20 instanceof MusicStateListenerIDLStubWrapper) == true) goto L18;
        if ((r20 instanceof IMusicStateListenerIDL.Stub) == false) goto L17;
        r13 = e4.a((IMusicStateListenerIDL.Stub) r20);     // Catch: Exception -> L24
        goto L19
    L17:
        r13 = e4.b(r20);     // Catch: Exception -> L24
        goto L19
    }

    public AgentAppIntentIDLStubWrapper(IAgentAppIntentIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void deleteEntities(AppEntity[] r22, IEntityDeleteCallbackIDL r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentAppIntentIDLStub", "deleteEntities(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "deleteEntities(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "deleteEntities", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L24
        h.c("AgentAppIntentIDLStub", "deleteEntities(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r3 = this.origin;     // Catch: Exception -> L24
        if (r23 != null) goto L10;
    L18:
        IEntityDeleteCallbackIDL r14 = r23;
    L19:
        r3.deleteEntities(r22, r14);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        h.d("AgentAppIntentIDLStub", "deleteEntities = void");     // Catch: Exception -> L24
    L22:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r15 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L24
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "deleteEntities(" + r22 + ", " + r23 + ") = void", r15);     // Catch: Exception -> L24
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "deleteEntities", r15, r110);     // Catch: Exception -> L24
        return;
    L10:
        if ((r23 instanceof EntityDeleteCallbackIDLIpcWrapper) == true) goto L18;
        if ((r23 instanceof EntityDeleteCallbackIDLStubWrapper) == true) goto L18;
        if ((r23 instanceof IEntityDeleteCallbackIDL.Stub) == false) goto L17;
        r14 = g0.a((IEntityDeleteCallbackIDL.Stub) r23);     // Catch: Exception -> L24
        goto L19
    L17:
        r14 = g0.b(r23);     // Catch: Exception -> L24
        goto L19
    }

    public void notifyLarkSendStausChanged(String r22, int r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentAppIntentIDLStub", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "notifyLarkSendStausChanged", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyLarkSendStausChanged(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "notifyLarkSendStausChanged = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "notifyLarkSendStausChanged", r14, r110);     // Catch: Exception -> L11
    }

    public void notifyStopAutoAction(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentAppIntentIDLStub", "notifyStopAutoAction(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "notifyStopAutoAction(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "notifyStopAutoAction", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "notifyStopAutoAction(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyStopAutoAction(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "notifyStopAutoAction = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "notifyStopAutoAction(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "notifyStopAutoAction", r14, r110);     // Catch: Exception -> L11
    }

    public void showPhoto(PhotoEntity[] r22, int r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentAppIntentIDLStub", "showPhoto(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showPhoto(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showPhoto", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showPhoto(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showPhoto(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showPhoto = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showPhoto(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showPhoto", r14, r110);     // Catch: Exception -> L11
    }

    public void showWeather(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentAppIntentIDLStub", "showWeather(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "showWeather(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "showWeather", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "showWeather(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showWeather(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "showWeather = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "showWeather(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "showWeather", r14, r110);     // Catch: Exception -> L11
    }

    public void turnOnOffAlarm(AlarmEntity r22, boolean r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentAppIntentIDLStub", "turnOnOffAlarm(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "turnOnOffAlarm(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "turnOnOffAlarm", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "turnOnOffAlarm(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.turnOnOffAlarm(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "turnOnOffAlarm = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "turnOnOffAlarm(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "turnOnOffAlarm", r14, r110);     // Catch: Exception -> L11
    }

    public void deleteRecordings(RecordingEntity[] r23, boolean r24, IRecordingDeleteCallbackIDL r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r11 = h.a;
        h.b("AgentAppIntentIDLStub", "deleteRecordings(" + r23 + ", " + r24 + ", " + r25 + ")", e);
        IPCException r5 = new IPCException(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r20 - r9) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "deleteRecordings(" + r23 + ", " + r24 + ", " + r25 + ") = fail", r5, r10);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "deleteRecordings", r5, r10, r20);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L24
        h.c("AgentAppIntentIDLStub", "deleteRecordings(" + r23 + ", " + r24 + ", " + r25 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r3 = this.origin;     // Catch: Exception -> L24
        if (r25 != null) goto L10;
    L18:
        IRecordingDeleteCallbackIDL r15 = r25;
    L19:
        r3.deleteRecordings(r23, r24, r15);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        h.d("AgentAppIntentIDLStub", "deleteRecordings = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L24
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "deleteRecordings(" + r23 + ", " + r24 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L24
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "deleteRecordings", r12, r21);     // Catch: Exception -> L24
        return;
    L10:
        if ((r25 instanceof RecordingDeleteCallbackIDLIpcWrapper) == true) goto L18;
        if ((r25 instanceof RecordingDeleteCallbackIDLStubWrapper) == true) goto L18;
        if ((r25 instanceof IRecordingDeleteCallbackIDL.Stub) == false) goto L17;
        r15 = o4.a((IRecordingDeleteCallbackIDL.Stub) r25);     // Catch: Exception -> L24
        goto L19
    L17:
        r15 = o4.b(r25);     // Catch: Exception -> L24
        goto L19
    }

    public int playMusic(String r26, MusicEntity[] r27, MusicEntity r28) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r11 = h.a;
        h.b("AgentAppIntentIDLStub", "playMusic(" + r26 + ", " + r27 + ", " + r28 + ")", e);
        IPCException r5 = new IPCException(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r23 - r9) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "playMusic(" + r26 + ", " + r27 + ", " + r28 + ") = fail", r5, r10);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "playMusic", r5, r10, r23);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        int r15 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "playMusic(" + r26 + ", " + r27 + ", " + r28 + ")");     // Catch: Exception -> L11
    L6:
        int r16 = this.origin.playMusic(r26, r27, r28);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentAppIntentIDLStub", "playMusic = " + r16);     // Catch: Exception -> L11
    L9:
        long r24 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r24 - r9) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "playMusic(" + r26 + ", " + r27 + ", " + r28 + ") = " + r16, r13);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "playMusic", r13, r24);     // Catch: Exception -> L11
        return r16;
    }

    public void callPhone(String r24, ContactEntity r25, String r26, String r27) throws RemoteException {
        long r10 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "callPhone(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")", e);
        IPCException r6 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r11 = Math.max(0, r17 - r10) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "callPhone(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = fail", r6, r11);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "callPhone", r6, r11, r17);
        throw r6;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "callPhone(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.callPhone(r24, r25, r26, r27);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "callPhone = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r21 - r10) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "callPhone(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = void", r13);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "callPhone", r13, r21);     // Catch: Exception -> L11
    }

    public void drainOmniUploadImagesForFeedbackWithType(String r24, String r25, List<String> r26, String r27) throws RemoteException {
        long r10 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")", e);
        IPCException r6 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r11 = Math.max(0, r17 - r10) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = fail", r6, r11);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType", r6, r11, r17);
        throw r6;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.drainOmniUploadImagesForFeedbackWithType(r24, r25, r26, r27);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r21 - r10) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = void", r13);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType", r13, r21);     // Catch: Exception -> L11
    }

    public void replyAskUser(String r24, String r25, String r26, Map r27) throws RemoteException {
        long r10 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "replyAskUser(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")", e);
        IPCException r6 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r11 = Math.max(0, r17 - r10) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "replyAskUser(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = fail", r6, r11);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "replyAskUser", r6, r11, r17);
        throw r6;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "replyAskUser(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.replyAskUser(r24, r25, r26, r27);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "replyAskUser = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r21 - r10) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "replyAskUser(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = void", r13);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "replyAskUser", r13, r21);     // Catch: Exception -> L11
    }

    public void sendSms(String r24, ContactEntity r25, String r26, String r27) throws RemoteException {
        long r10 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentAppIntentIDLStub", "sendSms(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")", e);
        IPCException r6 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r11 = Math.max(0, r17 - r10) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", "sendSms(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = fail", r6, r11);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "sendSms", r6, r11, r17);
        throw r6;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentAppIntentIDLStub", "sendSms(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.sendSms(r24, r25, r26, r27);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentAppIntentIDLStub", "sendSms = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r21 - r10) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", "sendSms(" + r24 + ", " + r25 + ", " + r26 + ", " + r27 + ") = void", r13);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "sendSms", r13, r21);     // Catch: Exception -> L11
    }

    public void drainOmniUploadImagesForFeedbackWithInfo(String r30, String r31, List<String> r32, String r33, boolean r34) throws RemoteException {
        long r16 = SystemClock.elapsedRealtimeNanos();
    L23:
        e = e;
        String r4 = "drainOmniUploadImagesForFeedbackWithInfo(";
        String r20 = ")";
        long r6 = 0;
        boolean r5 = r34;
    L25:
        int r2 = h.a;
        h.b("AgentAppIntentIDLStub", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + r20, e);
        IPCException r3 = new IPCException(e);
        long r25 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(r6, r25 - r16) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentAppIntentIDLStub", r4 + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r5 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo", r3, r7, r25);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r8 = h.a;     // Catch: Exception -> L23
        h.c("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo(" + r30 + ", " + r31 + ", " + r32 + ", " + r33 + ", " + r34 + ")");     // Catch: Exception -> L23
    L6:
        r20 = ")";
        this.origin.drainOmniUploadImagesForFeedbackWithInfo(r30, r31, r32, r33, r34);     // Catch: Exception -> L21
        if (this.log == false) goto L11;
        h.d("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo = void");     // Catch: Exception -> L21
    L11:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L21
        long r9 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L21
        int r10 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L21
        r4 = "drainOmniUploadImagesForFeedbackWithInfo(";
        StringBuilder r11 = new StringBuilder(r4);     // Catch: Exception -> L19
        r11.append(r30);     // Catch: Exception -> L19
        r11.append(", ");     // Catch: Exception -> L19
        r11.append(r31);     // Catch: Exception -> L19
        r11.append(", ");     // Catch: Exception -> L19
        r11.append(r32);     // Catch: Exception -> L19
        r11.append(", ");     // Catch: Exception -> L19
        r11.append(r33);     // Catch: Exception -> L19
        r11.append(", ");     // Catch: Exception -> L19
        r5 = r34;
        r6 = 0;
        r11.append(r5);     // Catch: Exception -> L17
        r11.append(") = void");     // Catch: Exception -> L17
        com.obric.aiagent.ipc.utils.i.d("AgentAppIntentIDLStub", r11.toString(), r9);     // Catch: Exception -> L17
        IPCAnomalyTrace.a.e("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo", r9, r27);     // Catch: Exception -> L17
        return;
    L17:
        e = e;
    L19:
        e = e;
        r5 = r34;
        r6 = 0;
    L21:
        e = e;
        r5 = r34;
        r6 = 0;
        r4 = "drainOmniUploadImagesForFeedbackWithInfo(";
        goto L25
    }
}
