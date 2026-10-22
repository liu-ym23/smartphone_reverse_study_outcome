package com.bytedance.android.live.room.share.jsbridge;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/room/share/jsbridge/ShareLiveMethodType;", "", "", "value", "I", "getValue", "()I", "SHARE_DIALOG", "CHAT_DIALOG", "THIRD_DIALOG", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShareLiveMethodType extends Enum<ShareLiveMethodType> {
    public static final ShareLiveMethodType CHAT_DIALOG = null;
    public static final ShareLiveMethodType SHARE_DIALOG = null;
    public static final ShareLiveMethodType THIRD_DIALOG = null;
    public static final /* synthetic */ ShareLiveMethodType[] a = null;
    private final int value;

    static {
        ShareLiveMethodType r1 = new ShareLiveMethodType("SHARE_DIALOG", 0, 0);
        SHARE_DIALOG = r1;
        ShareLiveMethodType r2 = new ShareLiveMethodType("CHAT_DIALOG", 1, 1);
        CHAT_DIALOG = r2;
        ShareLiveMethodType r3 = new ShareLiveMethodType("THIRD_DIALOG", 2, 2);
        THIRD_DIALOG = r3;
        a = new ShareLiveMethodType[]{r1, r2, r3};
    }

    public static ShareLiveMethodType valueOf(String r1) {
        return (ShareLiveMethodType) r27.a.a(ShareLiveMethodType.class, r1);
    }

    public static ShareLiveMethodType[] values() {
        return (ShareLiveMethodType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public ShareLiveMethodType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
