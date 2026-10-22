package mq1;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface u {
    void hidePlayerTip(String r1);

    PlayerTipsContext provideVSPlayTipsContext();

    void showPlayerTip(String r1, CharSequence r2, boolean r3);

    void showPlayerTipWithCustomView(String r1, View r2);
}
