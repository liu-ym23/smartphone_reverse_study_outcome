package qd0;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.JsonObject;
import gd0.p;
import hh1.w0;
import tf0.q;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends rj0.d {
    boolean B(String r1);

    void D5(int r1, int r2, boolean r3, boolean r4, int r5, xc.a r6);

    boolean L();

    void a(q r1);

    int b();

    void c(Context r1, String r2);

    BaseMultiLinkWidget createVoiceChatRoomGuestWidget(w0 r1, p r2);

    boolean d(String r1, boolean r2);

    boolean e(boolean r1, String r2);

    void finishAudioTalk(String r1);

    String getFunctionType();

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    JsonObject getTopLeftSeatFrameInfo();

    com.bytedance.android.live.pushstream.d guestLiveStream();

    void h(h80.a r1);

    void i(String r1);

    boolean isEngineOn();

    boolean isKtvOn();

    boolean isSelfVoiceChatRoomAudience();

    void ktvApply(KtvMusic r1, String r2, LinkApplyType r3, int r4, tf0.b r5);

    boolean ktvWillAutoSilenceSelf();

    void muteLocalAudio(boolean r1);

    void n();

    void openEmojiDialog(String r1, String r2);

    boolean p(User r1);

    boolean q(boolean r1, String r2);

    void r0(Context r1, IRoom r2, rj0.b r3);

    void switchVoiceSceneWithCheck(Context r1, String r2);

    void v();

    BaseMultiLinkWidget w(FragmentManager r1, com.bytedance.android.live.pushstream.d r2, w0 r3);
}
