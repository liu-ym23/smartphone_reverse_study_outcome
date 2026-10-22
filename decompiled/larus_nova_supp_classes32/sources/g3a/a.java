package g3a;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.view.ZoomableTextureView;
import com.larus.im.bean.bot.BotModel;
import com.larus.voicecall.impl.subtitle.RealtimeCallScreenShareLayout;
import com.larus.voicecall.impl.subtitle.RealtimeCallSubtitleLayout;
import com.larus.voicecall.impl.ui.VoiceCallBgLayout;
import com.larus.voicecall.impl.ui.VoiceCallContentLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface a extends t1a.a {
    RealtimeCallScreenShareLayout Df();

    FrameLayout In();

    AppCompatImageView Km();

    VoiceCallBgLayout Nl();

    void No(com.larus.voicecall.impl.scene.m r1);

    void O1(boolean r1);

    View Tt();

    void dD(BotModel r1);

    VoiceCallContentLayout dg();

    ZoomableTextureView iB();

    View iZ();

    SimpleDraweeView kj();

    View nj();

    RealtimeCallSubtitleLayout ol();
}
