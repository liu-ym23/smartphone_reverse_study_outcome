package fd2;

import com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.ConcertTuner;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface e {
    JsonObject handleDynamicJsbGetAction(JsonObject r1);

    JsonObject handleDynamicJsbUpdateAction(JsonObject r1);

    com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.e m1();

    void n1(d r1);

    void o1();

    void p1(ConcertTuner r1);

    void q1(ld2.b r1);

    void release();
}
