package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import android.text.TextUtils;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class TalkRoomBaseDynamicEmoji implements i, j {
    public static final int EMOJI_CATEGORY_AVATAR = 2;
    public static final int EMOJI_CATEGORY_EMOJI = 1;
    public static final int EMOJI_CATEGORY_QUICK_THANKS_GIFT = 4;
    public static final int EMOJI_CATEGORY_REWARD = 5;
    public static final int EMOJI_CATEGORY_UNKNOWN = 0;
    public static final int EMOJI_TYPE_COMBO = 3;
    public static final int EMOJI_TYPE_INTERACT = 2;
    public static final int EMOJI_TYPE_SELF = 1;
    public static final int EMOJI_TYPE_UNKNOWN = 0;
    public static final int EmojiCategory_CUSTOMIZED_RANDOM = 6;
    private static final long MIN_SHOW_DURATION = 1000;

    @SerializedName("animation_duration_ms")
    public long animationDuration;

    @IgnoreProtoFieldCheck
    @SerializedName("disable")
    public boolean disable;

    @SerializedName("category_type")
    public int emojiCategory;

    @SerializedName("emoji_id")
    public long emojiId;

    @SerializedName("emoji_name")
    public String emojiName;

    @SerializedName("emoji_result_duration_ms")
    public long emojiResultShowDuration;

    @SerializedName("emoji_sound")
    public String emojiSoundUrl;

    @SerializedName("type")
    public int emojiType;

    @SerializedName("is_random")
    public boolean isRandomEmoji;
    public transient Type type;

    public static final enum Type extends Enum<Type> {
        public static final Type DummyEmoji = null;
        public static final Type NormalEmoji = null;
        public static final /* synthetic */ Type[] a = null;

        static {
            Type r0 = new Type("DummyEmoji", 0);
            DummyEmoji = r0;
            Type r1 = new Type("NormalEmoji", 1);
            NormalEmoji = r1;
            a = new Type[]{r0, r1};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ vh7.e castTo(Class r1);

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ vh7.e castToOrNull(Class r1);

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ h digitAvatarEmojiData();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ py.k emojiDynamicImage();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ py.k emojiImage();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ l emojiPermission();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ e emojiTag();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ a getCustomizedRandomResource();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ h getDigitAvatarEmojiData();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ boolean getDisable();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ int getEmojiCategory();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ long getEmojiId();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ py.k getEmojiImage();

    public String getEmojiLabelOrNull() {
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ String getEmojiName();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ l getEmojiPermission();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ String getEmojiSoundUrl();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ int getEmojiStatus();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ int getEmojiType();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ m getInteractEmoji();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ m interactEmoji();

    public boolean isNewRandomEmoji() {
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ boolean isRandomEmoji();

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public abstract /* synthetic */ void setRandomEmoji(boolean r1);

    public long getDynamicAnimDuration() {
        long r0 = this.animationDuration;
        if (r0 >= MIN_SHOW_DURATION) goto L5;
        return MIN_SHOW_DURATION;
    L5:
        return r0;
    }

    public long getEmojiResultShowDuration() {
        long r0 = this.emojiResultShowDuration;
        if (r0 >= MIN_SHOW_DURATION) goto L5;
        return MIN_SHOW_DURATION;
    L5:
        return r0;
    }

    public boolean isComboEmoji() {
        if (this.emojiType != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public boolean isDigitAvatarEmoji() {
        if (this.emojiCategory != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public boolean isInteractEmoji() {
        if (this.emojiType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.j
    public boolean isSoundEmoji() {
        return !TextUtils.isEmpty(this.emojiSoundUrl);
    }

    public boolean isThanksInteractEmoji() {
        if (this.emojiCategory != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public TalkRoomBaseDynamicEmoji() {
        this.type = Type.NormalEmoji;
        this.animationDuration = MIN_SHOW_DURATION;
        this.emojiResultShowDuration = MIN_SHOW_DURATION;
        this.emojiType = 0;
        this.emojiCategory = 0;
    }
}
