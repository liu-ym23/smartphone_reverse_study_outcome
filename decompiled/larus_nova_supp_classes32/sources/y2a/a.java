package y2a;

import com.larus.audio.quality.AudioCheckerResult;
import com.larus.platform.service.g;
import com.larus.platform.service.o;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: y2a.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0124a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AudioCheckerResult.values().length];
            r0[AudioCheckerResult.INTERNAL_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[AudioCheckerResult.NETWORK_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[AudioCheckerResult.PASSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[AudioCheckerResult.SNR_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[AudioCheckerResult.WER_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[AudioCheckerResult.INIT_CONFIG_ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[AudioCheckerResult.INIT_METRIC_ERROR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[AudioCheckerResult.AUDIO_RECORD_SILENCED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
    }

    public static void a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        g.a.monitorEventForSlardar("voice_settings_clone_end", r3, null, null);
        o.a.reportEvent("voice_settings_clone_end", r3);
    }

    public static void b(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        g.a.monitorEventForSlardar("voice_settings_clone_sheet_end", r3, null, null);
        o.a.reportEvent("voice_settings_clone_sheet_end", r3);
    }

    public static void c(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        g.a.monitorEventForSlardar("voice_settings_clone_sheet_start", r3, null, null);
        o.a.reportEvent("voice_settings_clone_sheet_start", r3);
    }
}
