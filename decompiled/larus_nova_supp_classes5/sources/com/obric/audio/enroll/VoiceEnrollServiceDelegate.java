package com.obric.audio.enroll;

import com.obric.assistant.settings.voiceprint.v;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J)\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J\u001f\u0010\u000e\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0096\u0001J'\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J'\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0016\u001a\u00020\rH\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0096\u0001J\u001b\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001c0\u0019H\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u001e\u001a\u00020\rH\u0096\u0001J\t\u0010\u001f\u001a\u00020\rH\u0096\u0001J\t\u0010 \u001a\u00020\u0014H\u0096\u0001J\u0011\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\rH\u0096\u0001J\t\u0010\"\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010#\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\rH\u0096\u0001J\t\u0010&\u001a\u00020\u0005H\u0096\u0001J'\u0010'\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u00072\b\u0010)\u001a\u0004\u0018\u00010\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0019\u0010+\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0096\u0001J\t\u0010-\u001a\u00020\u0005H\u0096\u0001¨\u0006."}, d2 = {"Lcom/obric/audio/enroll/VoiceEnrollServiceDelegate;", "Lcom/obric/audio/enroll/IVoiceEnrollService;", "<init>", "()V", "addEnrolledDevice", "", "sn", "", "deviceName", "clearAllVoicePrintByUid", "fallbackUid", "callback", "Lkotlin/Function1;", "", "clearVoicePrint", "clearVoicePrintForUid", "uid", "deleteDefaultVoicePrintFromCloud", "deleteEnrolledDevice", "forceReEnrollWakeupSid", "", "reason", "getDefaultVoicePrintEnrollStatus", "getDeviceEnrollStatus", "getEnrolledDeviceInfos", "", "Lcom/obric/audio/enroll/EnrolledDeviceInfo;", "getEnrolledDevices", "Lkotlin/Pair;", "isBtHeadsetVoicePrintRecorded", "isDefaultVoicePrintRecordedWithMic0Flow", "isDefaultVoicePrintUploadedToCloud", "migrateLegacyPhoneEnrollIfNeeded", "skipForEnterprise", "queryBtHeadsetVoicePrintCloudAndResetLocalStatus", "releaseVoiceEnrollStateForAccountChange", "setDefaultVoicePrintTrainable", "isTrainable", "tryDeleteBtAndDoraVoicePrintOnce", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "updateEnrolledDeviceName", "newName", "uploadDefaultVoicePrintToCloud", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceEnrollServiceDelegate implements IVoiceEnrollService {
    public static final VoiceEnrollServiceDelegate c = null;
    public final /* synthetic */ IVoiceEnrollService b;

    static {
        c = new VoiceEnrollServiceDelegate();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sn");
        return this.b.a(r2);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void b(String r2, String r3, String r4) {
        this.b.b(r2, r3, r4);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean c() {
        return this.b.c();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean d() {
        return this.b.d();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void e(v r2) {
        this.b.e(r2);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean f() {
        return this.b.f();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "sn");
        Intrinsics.checkNotNullParameter(r3, "deviceName");
        this.b.g(r2, r3);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void h(boolean r2) {
        this.b.h(r2);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void i(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.b.i(r2);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void j(String r2, com.obric.assistant.settings.voiceprint.g r3) {
        Intrinsics.checkNotNullParameter(r2, "sn");
        this.b.j(r2, r3);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void k() {
        this.b.k();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final int l(boolean r2) {
        return this.b.l(r2);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final List<d> m() {
        return this.b.m();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void n() {
        this.b.n();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final int o() {
        return this.b.o();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void p() {
        this.b.p();
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void q(String r2) {
        this.b.q(r2);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final boolean r(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sn");
        return this.b.r(r2);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final int s(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        return this.b.s(r2);
    }

    @Override // com.obric.audio.enroll.IVoiceEnrollService
    public final void t(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        this.b.t(r2);
    }

    private VoiceEnrollServiceDelegate() {
        this.b = (IVoiceEnrollService) ServiceManager.get().getService(IVoiceEnrollService.class);
    }
}
