package com.obric.audio.enroll;

import com.obric.assistant.settings.voiceprint.v;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u0000 ,2\u00020\u0001:\u0001,J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J(\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J,\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u0006H&J\b\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H&J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\tH&J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\tH&J\u001a\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001d0\u001cH&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001cH&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tH&J(\u0010\"\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\t2\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH&J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\tH&J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020\u0003H&J&\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\tH&¨\u0006-"}, d2 = {"Lcom/obric/audio/enroll/IVoiceEnrollService;", "", "clearVoicePrint", "", "callback", "Lkotlin/Function1;", "", "clearVoicePrintForUid", "uid", "", "clearAllVoicePrintByUid", "fallbackUid", "releaseVoiceEnrollStateForAccountChange", "reason", "getDefaultVoicePrintEnrollStatus", "uploadDefaultVoicePrintToCloud", "deleteDefaultVoicePrintFromCloud", "setDefaultVoicePrintTrainable", "isTrainable", "isDefaultVoicePrintUploadedToCloud", "isDefaultVoicePrintRecordedWithMic0Flow", "migrateLegacyPhoneEnrollIfNeeded", "", "skipForEnterprise", "forceReEnrollWakeupSid", "getDeviceEnrollStatus", "sn", "getEnrolledDevices", "", "Lkotlin/Pair;", "getEnrolledDeviceInfos", "Lcom/obric/audio/enroll/EnrolledDeviceInfo;", "updateEnrolledDeviceName", "newName", "deleteEnrolledDevice", "addEnrolledDevice", "deviceName", "isBtHeadsetVoicePrintRecorded", "queryBtHeadsetVoicePrintCloudAndResetLocalStatus", "tryDeleteBtAndDoraVoicePrintOnce", "updateBtHeadsetEnrollModelPaths", "firstKwsModelPath", "sidEnrollModelPath", "silentFilePath", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IVoiceEnrollService {
    public static final a a = null;

    static {
        a = a.a;
    }

    boolean a(String r1);

    void b(String r1, String r2, String r3);

    boolean c();

    boolean d();

    void e(v r1);

    boolean f();

    void g(String r1, String r2);

    void h(boolean r1);

    void i(String r1);

    void j(String r1, com.obric.assistant.settings.voiceprint.g r2);

    void k();

    int l(boolean r1);

    List<d> m();

    void n();

    int o();

    void p();

    void q(String r1);

    boolean r(String r1);

    int s(String r1);

    void t(String r1);
}
