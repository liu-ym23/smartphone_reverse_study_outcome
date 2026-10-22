package l68;

import com.bytedance.flow_audio.api.business.tts.config.FlowAudioTtsStreamType;
import com.bytedance.flow_audio.api.tracer.TtsTracer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface a {
    void a(int r1);

    void b(b r1);

    z58.a c();

    void cancel();

    void d(FlowAudioTtsStreamType r1, String r2);

    void e(z58.a r1, TtsTracer r2);

    b getListener();

    void release();

    void start();

    void stop();
}
