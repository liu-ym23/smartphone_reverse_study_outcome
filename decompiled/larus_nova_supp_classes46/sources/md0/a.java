package md0;

import com.bytedance.android.livesdkapi.model.SeiAppData;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a {

    /* JADX INFO: renamed from: md0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0236a {
        boolean isVersionSupported(int r1, int r2);

        void onBusinessAppSeiUpdate(JSONObject r1);

        void onSeiUpdated(SeiAppData r1);
    }

    public interface b {
        void onKtvSeiUpdate(String r1);
    }

    public interface c extends InterfaceC0236a {
        void onAudioMvControllerUpdate(String r1);

        void onAudioSubtitleUpdate(String r1);

        void onRadioSeiUpdate(JSONObject r1);

        void onRadioTextSeiUpdate(JSONObject r1);

        void onSpeechRecognitionSeiUpdate(String r1);

        void onSpeechRhythm(String r1);

        void onVideoStateSeiUpdate(ld0.a r1);
    }
}
