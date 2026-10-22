package nj0;

import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.UpdateSubtitleType;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface b {
    void Cf();

    void Ck(Pair<Float, Float> r1);

    void N5(IAudioSubtitleContent r1, UpdateSubtitleType r2, c r3);

    void anchorAudioSubtitleSwitchSetting(boolean r1, String r2, c r3);

    void guestAudioSubtitleSwitchSetting(boolean r1);

    boolean isRecording();

    void sd(String r1);
}
