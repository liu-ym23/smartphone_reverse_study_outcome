package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0004\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/AIWishGiftRoomScene;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "Ljava/lang/Number;", "getValue", "()Ljava/lang/Number;", "Unknown", "Video", "Audio", "External", "ScreenShot", "Media", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AIWishGiftRoomScene extends Enum<AIWishGiftRoomScene> {
    public static final AIWishGiftRoomScene Audio = null;
    public static final AIWishGiftRoomScene External = null;
    public static final AIWishGiftRoomScene Media = null;
    public static final AIWishGiftRoomScene ScreenShot = null;
    public static final AIWishGiftRoomScene Unknown = null;
    public static final AIWishGiftRoomScene Video = null;
    public static final /* synthetic */ AIWishGiftRoomScene[] a = null;
    private final Number value;

    static {
        AIWishGiftRoomScene r1 = new AIWishGiftRoomScene("Unknown", 0, -1);
        Unknown = r1;
        AIWishGiftRoomScene r2 = new AIWishGiftRoomScene("Video", 1, 0);
        Video = r2;
        AIWishGiftRoomScene r3 = new AIWishGiftRoomScene("Audio", 2, 1);
        Audio = r3;
        AIWishGiftRoomScene r4 = new AIWishGiftRoomScene("External", 3, 2);
        External = r4;
        AIWishGiftRoomScene r5 = new AIWishGiftRoomScene("ScreenShot", 4, 3);
        ScreenShot = r5;
        AIWishGiftRoomScene r6 = new AIWishGiftRoomScene("Media", 5, 5);
        Media = r6;
        a = new AIWishGiftRoomScene[]{r1, r2, r3, r4, r5, r6};
    }

    public static AIWishGiftRoomScene valueOf(String r1) {
        return (AIWishGiftRoomScene) r27.a.a(AIWishGiftRoomScene.class, r1);
    }

    public static AIWishGiftRoomScene[] values() {
        return (AIWishGiftRoomScene[]) a.clone();
    }

    public final Number getValue() {
        return this.value;
    }

    public AIWishGiftRoomScene(String r1, int r2, Number r3) {
        super(r1, r2);
        this.value = r3;
    }
}
