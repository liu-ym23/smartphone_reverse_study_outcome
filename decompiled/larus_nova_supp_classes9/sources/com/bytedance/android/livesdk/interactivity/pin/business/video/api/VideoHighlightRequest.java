package com.bytedance.android.livesdk.interactivity.pin.business.video.api;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/video/api/VideoHighlightRequest;", BuildConfig.FLAVOR, "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "toRequestFieldMap", "scene", "Ljava/lang/String;", BuildConfig.FLAVOR, "actionType", "I", BuildConfig.FLAVOR, "roomId", "J", "itemId", "msgId", "nickname", "commenterId", "videoPinId", "<init>", "()V", "Companion", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoHighlightRequest {
    public static final int ACTION_TYPE_NOT_SUPPORT = 0;
    public static final int ACTION_TYPE_SET = 1;
    public static final int ACTION_TYPE_UNSET = 2;
    public static final int ACTION_TYPE_UNSET_ALL = 4;
    public static final a Companion = null;

    @SerializedName("action_type")
    public int actionType;

    @SerializedName("commenter_id")
    public String commenterId;

    @SerializedName("item_id")
    public long itemId;

    @SerializedName("msg_id")
    public long msgId;

    @SerializedName("nick_name")
    public String nickname;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("scene")
    public String scene;

    @SerializedName("video_pin_id")
    public long videoPinId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final HashMap<String, String> toRequestFieldMap() {
        HashMap<String, String> r0 = new HashMap();
        String r1 = this.scene;
        if (r1 == null) goto L5;
        String r2 = r0.put("scene", r1);
    L5:
        r0.put("action_type", String.valueOf(this.actionType));
        r0.put("room_id", String.valueOf(this.roomId));
        r0.put("item_id", String.valueOf(this.itemId));
        r0.put("msg_id", String.valueOf(this.msgId));
        String r3 = this.nickname;
        if (r3 == null) goto L8;
        String r4 = r0.put("nick_name", r3);
    L8:
        r0.put("commenter_id", this.commenterId);
        r0.put("video_pin_id", String.valueOf(this.videoPinId));
        return r0;
    }

    public VideoHighlightRequest() {
        this.commenterId = BuildConfig.FLAVOR;
    }
}
