package com.bytedance.android.live.revlink.impl.settings.config;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import r41.c;
import r41.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/PKAtmosphereAnimationUrlSerializableObjectImpl;", "Lr41/g;", "", "middleUrl", "Ljava/lang/String;", "getMiddleUrl", "()Ljava/lang/String;", "weakToRightUrl", "getWeakToRightUrl", "strongToRightUrl", "getStrongToRightUrl", "bigWinEmojiUrl", "getBigWinEmojiUrl", "smallWinEmojiUrl", "getSmallWinEmojiUrl", "bigLoseEmojiUrl", "getBigLoseEmojiUrl", "smallLoseEmojiUrl", "getSmallLoseEmojiUrl", "leftStarAnim", "getLeftStarAnim", "rightStarAnim", "getRightStarAnim", "multiAnchorPkStealTowerEmojiUrl", "getMultiAnchorPkStealTowerEmojiUrl", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKAtmosphereAnimationUrlSerializableObjectImpl implements g {

    @SerializedName("big_lose_emoji_url")
    private final String bigLoseEmojiUrl;

    @SerializedName("big_win_emoji_url")
    private final String bigWinEmojiUrl;

    @SerializedName("left_star_anim")
    private final String leftStarAnim;

    @SerializedName("middle_url")
    private final String middleUrl;

    @SerializedName("multi_anchor_pk_steal_tower_emoji_url")
    private final String multiAnchorPkStealTowerEmojiUrl;

    @SerializedName("right_star_anim")
    private final String rightStarAnim;

    @SerializedName("small_lose_emoji_url")
    private final String smallLoseEmojiUrl;

    @SerializedName("small_win_emoji_url")
    private final String smallWinEmojiUrl;

    @SerializedName("strong_to_right_url")
    private final String strongToRightUrl;

    @SerializedName("weak_to_right_url")
    private final String weakToRightUrl;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/config/PKAtmosphereAnimationUrlSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PKAtmosphereAnimationUrlSerializableObjectImpl.class);
        }
    }

    public PKAtmosphereAnimationUrlSerializableObjectImpl() {
        int r0 = c.a;
        this.middleUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_progressbar_middle.webp";
        this.weakToRightUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_progressbar_anim_weak_to_right.webp";
        this.strongToRightUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_progressbar_anim_strong_to_right.webp";
        this.bigWinEmojiUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_big_win_emoji.webp";
        this.smallWinEmojiUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_small_win_emoji.webp";
        this.bigLoseEmojiUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_big_lose_emoji.webp";
        this.smallLoseEmojiUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_small_lose_emoji.webp";
        this.leftStarAnim = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_atmosphere_left_anim_douyin.webp";
        this.rightStarAnim = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_atmosphere_right_anim.webp";
        this.multiAnchorPkStealTowerEmojiUrl = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/pk_atmosphere_steal_tower_rush_emoji.webp";
    }
}
