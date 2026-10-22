package com.obric.assistant.spi.audio;

import com.larus.audio.call.mgr.MajorState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J\t\u0010\u000f\u001a\u00020\rH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0013\u001a\u00020\rH\u0096\u0001J\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u0010\u0016\u001a\u00020\nH\u0096\u0001J\t\u0010\u0017\u001a\u00020\nH\u0096\u0001J\t\u0010\u0018\u001a\u00020\nH\u0096\u0001J\t\u0010\u0019\u001a\u00020\nH\u0096\u0001J\t\u0010\u001a\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\nH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0096\u0001J\u001d\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0019\u0010%\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\nH\u0096\u0001¨\u0006'"}, d2 = {"Lcom/obric/assistant/spi/audio/ObricAsrDelegate;", "Lcom/obric/assistant/spi/audio/IObricAsrService;", "<init>", "()V", "addVoiceAuthenSessionToMap", "", "taskid", "", "sessionId", "canUpdatePersonalContextToAsr", "", "enableBackTraceAudioRecorder", "getAsrAudioRecordSource", "", "audioSource", "getBusinessType", "getDeviceUuid", "getEnablePvadCheck", "getPersonalContextInfo", "getRealtimeBusinessType", "getVoiceAuthenSessionIdFromTaskId", "getVoicePrintAuthSessionIdOrNull", "isAccessibilityServiceEnabled", "isAiKeyPressing", "isDefaultAssistant", "isDoraPressing", "isPersonalContextCompleted", "onClickTalkStateChange", "value", "onCloseClickTalk", "onMajorStateChanged", "prev", "", "current", "setAudioFileUri", "msgId", "fileUri", "setVoicePrintState", "speakerMatch", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAsrDelegate implements IObricAsrService {
    public static final ObricAsrDelegate b = null;
    public final /* synthetic */ IObricAsrService a;

    static {
        b = new ObricAsrDelegate();
    }

    public final boolean a() {
        return this.a.a();
    }

    public final boolean b() {
        return this.a.b();
    }

    public final String c() {
        return this.a.c();
    }

    public final void d(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        this.a.d(r2, r3);
    }

    public final void e(MajorState r2, MajorState r3) {
        Intrinsics.checkNotNullParameter(r2, "prev");
        Intrinsics.checkNotNullParameter(r3, "current");
        this.a.e(r2, r3);
    }

    public final int f() {
        return this.a.f();
    }

    public final String g() {
        return this.a.g();
    }

    public final int getBusinessType() {
        return this.a.getBusinessType();
    }

    public final void h(String r2, String r3) {
        this.a.h(r2, r3);
    }

    public final String i(String r2) {
        return this.a.i(r2);
    }

    public final boolean isAiKeyPressing() {
        return this.a.isAiKeyPressing();
    }

    public final boolean j() {
        return this.a.j();
    }

    public final boolean k() {
        return this.a.k();
    }

    public final void l(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "taskid");
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        this.a.l(r2, r3);
    }

    public final boolean m() {
        return this.a.m();
    }

    public final int n() {
        return this.a.n();
    }

    public final void o() {
        this.a.o();
    }

    public final boolean p() {
        return this.a.p();
    }

    public final boolean q() {
        return this.a.q();
    }

    public final String r() {
        return this.a.r();
    }

    public final void s(boolean r2) {
        this.a.s(r2);
    }

    private ObricAsrDelegate() {
        DefaultObricAsrServiceImpl r0 = (IObricAsrService) ServiceManager.get().getService(IObricAsrService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricAsrServiceImpl();
    L5:
        this.a = r0;
    }
}
