package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/VideoChatroomCastIntroDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoChatroomCastIntroDialog extends CommonBottomDialog {
    public final String a;
    public final String b;

    public final int getLayoutId() {
        return 2131565682;
    }

    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        int r0 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_game_screen_share_intro_show", null, new Object[]{Room.class});
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public VideoChatroomCastIntroDialog(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        StringBuilder r5 = new StringBuilder("https://");
        LiveCommonConstants r1 = LiveCommonConstants.INSTANCE;
        r5.append(r1.getObjectTosPath());
        r5.append("/obj/live-android/ttlive_bg_video_chatroom_game_cast_intro.png");
        this.a = r5.toString();
        this.b = "https://" + r1.getObjectTosPath() + "/obj/live-android/ttlive_bg_equal_chatroom_game_cast_intro.png";
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        ((TextView) findViewById(2131392071)).setOnClickListener(new e0(this));
        int r4 = jc1.k.n(IInteractService.class).getCurrentScene();
        if (r4 != 12) goto L6;
        M0((HSImageView) findViewById(2131365266), this.b);
        return;
    L6:
        if (r4 != 8) goto L10;
        M0((HSImageView) findViewById(2131365266), this.a);
        return;
    }

    public final void M0(HSImageView r3, String r4) {
        if (r3 == null) goto L4;
        r3.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse(r4)).build());
    L4:
        if (r3 == null) goto L9;
        GenericDraweeHierarchy r5 = r3.getHierarchy();
        if (r5 == null) goto L10;
        r5.setFailureImage(2131252514);
        return;
    L10:
        return;
    }
}
