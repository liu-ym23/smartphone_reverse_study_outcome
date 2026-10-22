package com.bytedance.android.livesdk.chatroom.ui.livesticker;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/livesticker/StickerDecorationType;", "", "", "type", "I", "getType", "()I", "TEXT_STICKER", "IMAGE_STICKER", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StickerDecorationType extends Enum<StickerDecorationType> {
    public static final StickerDecorationType IMAGE_STICKER = null;
    public static final StickerDecorationType TEXT_STICKER = null;
    public static final /* synthetic */ StickerDecorationType[] a = null;
    private final int type;

    static {
        StickerDecorationType r1 = new StickerDecorationType("TEXT_STICKER", 0, 0);
        TEXT_STICKER = r1;
        StickerDecorationType r2 = new StickerDecorationType("IMAGE_STICKER", 1, 1);
        IMAGE_STICKER = r2;
        a = new StickerDecorationType[]{r1, r2};
    }

    public static StickerDecorationType valueOf(String r1) {
        return (StickerDecorationType) a.a(StickerDecorationType.class, r1);
    }

    public static StickerDecorationType[] values() {
        return (StickerDecorationType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public StickerDecorationType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
