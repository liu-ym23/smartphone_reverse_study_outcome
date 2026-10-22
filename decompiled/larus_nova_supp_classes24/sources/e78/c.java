package e78;

import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.audio.controller.GlobalAudioStateEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c {
    void a();

    boolean b();

    void c();

    void d();

    boolean e();

    String getBizScene();

    @GlobalAudioSceneEnum
    String getScene();

    GlobalAudioStateEnum getState();

    boolean pause();

    boolean play();

    boolean stop();
}
