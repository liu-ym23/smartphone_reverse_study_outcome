package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.room.RoomInteractionInfoResponse.ResponseData")
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/q;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/r;", "iconInfo", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/r;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/c;", "chatEmojiGuideInfo", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/c;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/d;", "chatImageGuideInfo", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/d;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/t;", "matchChatInfo", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/t;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/w;", "recommendShortcutEmoji", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/w;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/g;", "frequentChatInfo", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/g;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/InputFunctionList;", "inputFunctionList", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/InputFunctionList;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/FusionEmojiBanList;", "fusionEmojiBanList", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/FusionEmojiBanList;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/AIClone;", "aiClone", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/AIClone;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/MsgOptPanel;", "msgOptPanel", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/MsgOptPanel;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/b;", "audienceMsgOptPanel", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/b;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/h;", "highlightConfig", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/h;", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q implements vh7.h {

    @SerializedName("ai_clone")
    public AIClone aiClone;

    @SerializedName("audience_msg_opt_panel")
    public b audienceMsgOptPanel;

    @SerializedName("chat_emoji_guide_info")
    public c chatEmojiGuideInfo;

    @SerializedName("chat_image_guide_info")
    public d chatImageGuideInfo;

    @SerializedName("frequently_chat_info")
    public g frequentChatInfo;

    @SerializedName("fusion_emoji_ban_list")
    public FusionEmojiBanList fusionEmojiBanList;

    @SerializedName("highlight_data")
    public h highlightConfig;

    @SerializedName("like_icon_info")
    public r iconInfo;

    @SerializedName("chat_input_panel")
    public InputFunctionList inputFunctionList;

    @SerializedName("match_chat_info")
    public t matchChatInfo;

    @SerializedName("msg_opt_panel")
    public MsgOptPanel msgOptPanel;

    @SerializedName("recommend_shortcut_emoji")
    public w recommendShortcutEmoji;

    public q() {
    }

    public q(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L19;
        switch(r2) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L6;
            case 13: goto L7;
            default: goto L6;
        };
    L7:
        this.highlightConfig = new h(r5);
        goto L3
    L8:
        this.audienceMsgOptPanel = new b(r5);
        goto L3
    L9:
        this.aiClone = x.a(r5);
        goto L3
    L10:
        this.msgOptPanel = d0.a(r5);
        goto L3
    L11:
        this.fusionEmojiBanList = a0.a(r5);
        goto L3
    L12:
        this.inputFunctionList = b0.a(r5);
        goto L3
    L13:
        this.frequentChatInfo = z.a(r5);
        goto L3
    L14:
        this.recommendShortcutEmoji = new w(r5);
        goto L3
    L15:
        this.matchChatInfo = new t(r5);
        goto L3
    L16:
        this.chatImageGuideInfo = new d(r5);
        goto L3
    L17:
        this.chatEmojiGuideInfo = new c(r5);
        goto L3
    L18:
        this.iconInfo = new r(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L19:
        r5.d(r0);
    }
}
