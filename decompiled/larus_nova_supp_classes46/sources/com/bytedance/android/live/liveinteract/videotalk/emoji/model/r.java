package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import android.text.TextUtils;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class r extends TalkRoomBaseDynamicEmoji implements vh7.c.a<j> {
    public static final int EMOJI_CATEGORY_AVATAR = 2;
    public static final int EMOJI_CATEGORY_EMOJI = 1;
    public static final int EMOJI_CATEGORY_QUICK_THANKS_GIFT = 4;
    public static final int EMOJI_CATEGORY_RANDOM_EMOJI = 6;
    public static final int EMOJI_CATEGORY_REWARD = 5;
    public static final int EMOJI_CATEGORY_UNKNOWN = 0;
    public static final int EMOJI_TYPE_COMBO = 3;
    public static final int EMOJI_TYPE_INTERACT = 2;
    public static final int EMOJI_TYPE_SELF = 1;
    public static final int EMOJI_TYPE_UNKNOWN = 0;
    private static final long MIN_SHOW_DURATION = 1000;

    @SerializedName("customized_random_resource")
    public a customizedRandomResource;
    private transient FlexModelDelegate<j> delegate;

    @SerializedName("avatar_resource")
    public TalkRoomDigitAvatarEmoji digitAvatarEmojiData;

    @SerializedName("emoji_dynamic_image")
    public py.k emojiDynamicImage;

    @SerializedName("emoji_image")
    public py.k emojiImage;

    @SerializedName("emoji_label")
    public String emojiLabel;

    @SerializedName("permission")
    public TalkRoomEmojiPermission emojiPermission;

    @SerializedName("emoji_status")
    public int emojiStatus;

    @SerializedName("emoji_tag")
    public b emojiTag;

    @SerializedName("interact_resource")
    public TalkRoomInteractEmoji interactEmoji;

    @SerializedName("need_reverse")
    public boolean needReverse;

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji
    public long getDynamicAnimDuration() {
        long r0 = this.animationDuration;
        if (r0 >= MIN_SHOW_DURATION) goto L5;
        return MIN_SHOW_DURATION;
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji
    public long getEmojiResultShowDuration() {
        long r0 = this.emojiResultShowDuration;
        if (r0 >= MIN_SHOW_DURATION) goto L5;
        return MIN_SHOW_DURATION;
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public boolean isInteractEmoji() {
        if (this.emojiType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji
    public boolean isNewRandomEmoji() {
        a r0 = this.customizedRandomResource;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getType() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public boolean isSoundEmoji() {
        return !TextUtils.isEmpty(this.emojiSoundUrl);
    }

    public r() {
        this.delegate = new FlexModelDelegate(j.class, this);
        this.type = TalkRoomBaseDynamicEmoji.Type.NormalEmoji;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public /* bridge */ /* synthetic */ h getDigitAvatarEmojiData() {
        return getDigitAvatarEmojiData();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public /* bridge */ /* synthetic */ l getEmojiPermission() {
        return getEmojiPermission();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public h digitAvatarEmojiData() {
        return this.digitAvatarEmojiData;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public py.k emojiDynamicImage() {
        return this.emojiDynamicImage;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public py.k emojiImage() {
        return this.emojiImage;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public l emojiPermission() {
        return this.emojiPermission;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public e emojiTag() {
        return this.emojiTag;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public a getCustomizedRandomResource() {
        return this.customizedRandomResource;
    }

    public FlexModelDelegate<j> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public boolean getDisable() {
        return this.disable;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public int getEmojiCategory() {
        return this.emojiCategory;
    }

    public py.k getEmojiDynamicImage() {
        return this.emojiDynamicImage;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public long getEmojiId() {
        return this.emojiId;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public py.k getEmojiImage() {
        return this.emojiImage;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji
    public String getEmojiLabelOrNull() {
        return this.emojiLabel;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public String getEmojiName() {
        return this.emojiName;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public String getEmojiSoundUrl() {
        return this.emojiSoundUrl;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public int getEmojiStatus() {
        return this.emojiStatus;
    }

    public b getEmojiTag() {
        return this.emojiTag;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public int getEmojiType() {
        return this.emojiType;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public m getInteractEmoji() {
        return this.interactEmoji;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public m interactEmoji() {
        return this.interactEmoji;
    }

    public boolean isNeedReverse() {
        return this.needReverse;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public boolean isRandomEmoji() {
        return this.isRandomEmoji;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public TalkRoomDigitAvatarEmoji getDigitAvatarEmojiData() {
        return this.digitAvatarEmojiData;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public TalkRoomEmojiPermission getEmojiPermission() {
        return this.emojiPermission;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public <R extends vh7.e<j>> R castTo(Class<R> r2) {
        return (R) this.delegate.castTo(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public <R extends vh7.e<j>> R castToOrNull(Class<R> r2) {
        return (R) this.delegate.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public void setRandomEmoji(boolean r1) {
        this.isRandomEmoji = r1;
    }
}
