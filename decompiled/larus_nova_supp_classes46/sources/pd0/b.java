package pd0;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.livesdk.multilink.base.model.ReplyType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    public static String a(int r2) {
        if (r2 != 1) goto L5;
        return "emoji_category_emoji";
    L5:
        if (r2 != 2) goto L7;
        return "emoji_category_avatar";
    L7:
        if (r2 != 4) goto L13;
        return "emoji_category_quick_thanks_gift";
    L13:
        return "unknown(" + r2 + ')';
    }

    public static String b(int r2) {
        if (r2 != 1) goto L5;
        return "emoji_type_self";
    L5:
        if (r2 != 2) goto L10;
        return "emoji_type_interact";
    L10:
        return "unknown(" + r2 + ')';
    }

    public static String c(int r2) {
        if (r2 != 0) goto L4;
        return "normal";
    L4:
        if (r2 != 1) goto L9;
        return ChatMatchViewModel.ENTER_METHOD_SHAKE;
    L9:
        return "unknown(" + r2 + ')';
    }

    public static String d(LinkApplyType r2) {
        Intrinsics.checkNotNullParameter(r2, "applyType");
        switch(a.a[r2.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L13;
        };
    L5:
        return "prepare_apply";
    L6:
        return "strong_reach";
    L7:
        return "city_song";
    L8:
        return "city";
    L9:
        return ChatMatchViewModel.ENTER_METHOD_MATCH;
    L10:
        return "song";
    L11:
        return "normal";
    L13:
        return "unknown(" + r2.getValue() + ')';
    }

    public static String e(int r2) {
        if (r2 != 4) goto L5;
        return "audience_link";
    L5:
        if (r2 != 5) goto L7;
        return "audio_chat_room";
    L7:
        if (r2 != 8) goto L9;
        return "video_chat_room";
    L9:
        if (r2 != 9) goto L11;
        return "audio_ktv";
    L11:
        if (r2 != 12) goto L13;
        return "video_equal_room";
    L13:
        if (r2 != 16) goto L22;
        return "link_room";
    L22:
        return "unknown(" + r2 + ')';
    }

    public static String f(int r2) {
        if (r2 != 9) goto L5;
        return "ktv_singe_challenge";
    L5:
        if (r2 != 51) goto L7;
        return "video_6x6";
    L7:
        if (r2 != 61) goto L9;
        return "real_time_chorus";
    L9:
        if (r2 != 67) goto L11;
        return "video_9x9";
    L11:
        if (r2 != 21) goto L13;
        return "audio_top_1v8";
    L13:
        if (r2 == 22) goto L33;
        switch(r2) {
            case 0: goto L25;
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            default: goto L15;
        };
    L15:
        switch(r2) {
            case 24: goto L29;
            case 25: goto L28;
            case 26: goto L27;
            case 27: goto L26;
            default: goto L16;
        };
    L16:
        switch(r2) {
            case 56: goto L32;
            case 57: goto L31;
            case 58: goto L30;
            default: goto L40;
        };
    L30:
        return "video_1x1";
    L31:
        return "video_6x1";
    L32:
        return "video_1x6";
    L40:
        return "unknown(" + r2 + ')';
    L26:
        return "audio_top_1v8_new";
    L27:
        return "audio_top_2v4v4";
    L28:
        return "audio_dynamic_1v6";
    L29:
        return "audio_dynamic_island";
    L18:
        return "video_dynamic_anchor_1v6";
    L19:
        return "video_guest_1v6";
    L20:
        return "video_equal_3x3";
    L21:
        return "video_equal_top_1v8";
    L22:
        return "video_equal_left_1v8";
    L23:
        return "video_dynamic_equal";
    L24:
        return "video_anchor_1v6";
    L25:
        return "none";
    L33:
        return "audio_equal_3x3";
    }

    public static String g(int r2) {
        if (r2 != 1) goto L5;
        return "video";
    L5:
        if (r2 != 2) goto L7;
        return "audio";
    L7:
        if (r2 != 3) goto L13;
        return "digit_avatar";
    L13:
        return "unknown(" + r2 + ')';
    }

    public static String h(int r2) {
        if (r2 != LinkmicPositionItem.LinkmicPositionStatus.NORMAL.ordinal()) goto L6;
        return "normal";
    L6:
        if (r2 != LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal()) goto L9;
        return "locked";
    L9:
        return "unknown(" + r2 + ')';
    }

    public static String i(int r2) {
        if (r2 != ReplyType.Agree.ordinal()) goto L6;
        return "agree";
    L6:
        if (r2 != ReplyType.Reject.ordinal()) goto L9;
        return "reject";
    L9:
        return "unknown(" + r2 + ')';
    }
}
