package mp1;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Function0<List<? extends ToolbarButton>> {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public final List<ToolbarButton> a() {
        boolean r2 = false;
        ToolbarButton r1 = ToolbarButton.MANAGE;
        ToolbarButton r5 = ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE;
        ToolbarButton r6 = ToolbarButton.PLAY_SETTING;
        ToolbarButton r7 = ToolbarButton.DOU_PLUS_PROMOTE;
        List<ToolbarButton> r0 = CollectionsKt.mutableListOf(new ToolbarButton[]{ToolbarButton.BEAUTY, ToolbarButton.FILTER, ToolbarButton.STICKER, ToolbarButton.STICKER_NEW, ToolbarButton.GESTURE_MAGIC, ToolbarButton.DECORATION, ToolbarButton.INTERACTION_MORE, ToolbarButton.LIVE_IM_ENTRANCE_MORE, ToolbarButton.REVERSE_CAMERA, ToolbarButton.REVERSE_MIRROR, ToolbarButton.PROMPT, ToolbarButton.WISH_LIST, ToolbarButton.VOTE, r1, ToolbarButton.SHARE, ToolbarButton.BROADCAST_RESTART, ToolbarButton.SHARE_TO_DAILY, ToolbarButton.ROOM_CHANNEL, ToolbarButton.COMMERCE, ToolbarButton.VIDEO_PLAY, ToolbarButton.BARRAGE_SETTING, r5, ToolbarButton.GIFT_EFFECT, ToolbarButton.CLEAR_SCREEN, ToolbarButton.CLEAR_SCREEN_OPTIMIZE_OFF, ToolbarButton.CLEAR_SCREEN_OPTIMIZE_ON, ToolbarButton.CAST_SCREEN, ToolbarButton.PAD_AND_PC_PLAY, r6, ToolbarButton.LIVE_FLOAT_WINDOW_PLAY, ToolbarButton.AUDIENCE_RECORD, ToolbarButton.VIP_IM, ToolbarButton.PUSH_URL, ToolbarButton.MESSAGE_PUSH, r7, ToolbarButton.BROADCAST_TASK, ToolbarButton.HASH_TAG, ToolbarButton.POI, ToolbarButton.ADVANCE_ANNOUNCEMENT, ToolbarButton.BROADCAST_PAUSE, ToolbarButton.LIVE_CONTENT, ToolbarButton.QUESTION_AND_ANSWER, ToolbarButton.COLLECT, ToolbarButton.AUDIENCE_RESOLUTION, ToolbarButton.IN_ROOM_RESOLUTION, ToolbarButton.MESSAGE_BOX, ToolbarButton.SCHEDULE_CLOSE, ToolbarButton.PREDICTOR_GUESS, ToolbarButton.TASK_CENTER, ToolbarButton.REPORT, ToolbarButton.DISLIKE, ToolbarButton.GIFT_CONSUMER_TOAST, ToolbarButton.LIKE_FEEDBACK, ToolbarButton.GAME_PROMOTE_AUDIENCE_MORE, ToolbarButton.RECORD_COMBINE, ToolbarButton.MINOR_REFUND, ToolbarButton.LIVE_WIDGET, ToolbarButton.SHAKE_MATCH_SETTING, ToolbarButton.MARKETING_WIDGET_PIN_BUTTON, ToolbarButton.FLOW_FEEDBACK});
        RoomContext.a r8 = RoomContext.Companion;
        RoomContext r12 = RoomContext.a.c(r8, null, 0, 3);
        if (r12 == null) goto L9;
        i r13 = r12.isAnchor();
        if (r13 == null) goto L9;
        Boolean r14 = (Boolean) r13.getValue();
        if (r14 == null) goto L9;
        r2 = r14.booleanValue();
    L9:
        RoomContext r4 = RoomContext.a.c(r8, null, 0, 3);
        if (r4 == null) goto L15;
        i r9 = r4.getLiveMode();
        if (r9 == null) goto L15;
        LiveMode r10 = (LiveMode) r9.getValue();
        if (r10 == null) goto L15;
    L16:
        if (r2 == true) goto L18;
    L20:
        ListProtector.add(r0, r0.indexOf(r6), ToolbarButton.RECORD);
    L21:
        if (r2 == false) goto L23;
        int r3 = r0.indexOf(r7);
    L24:
        if (r3 < 0) goto L26;
        ListProtector.add(r0, r3 + 1, ToolbarButton.REN_QI_BAO);
    L26:
        return r0;
    L23:
        r3 = r0.indexOf(r5);
        goto L24
    L18:
        if (r10 == LiveMode.AUDIO) goto L20;
        ListProtector.add(r0, r0.indexOf(r1), ToolbarButton.RECORD);
    L15:
        r10 = LiveMode.VIDEO;
        goto L16
    }

    public final /* bridge */ /* synthetic */ Object invoke() {
        return a();
    }
}
