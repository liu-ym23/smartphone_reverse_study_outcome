package com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/interact/utils/AvatarType;", "", "", "value", "I", "getValue", "()I", "AVATAR_THUMB", "AVATAR_MEDIUM", "AVATAR_LARGE", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AvatarType extends Enum<AvatarType> {
    public static final AvatarType AVATAR_LARGE = null;
    public static final AvatarType AVATAR_MEDIUM = null;
    public static final AvatarType AVATAR_THUMB = null;
    public static final /* synthetic */ AvatarType[] a = null;
    private final int value;

    static {
        AvatarType r2 = new AvatarType("AVATAR_THUMB", 0, 1);
        AVATAR_THUMB = r2;
        AvatarType r3 = new AvatarType("AVATAR_MEDIUM", 1, 2);
        AVATAR_MEDIUM = r3;
        AvatarType r4 = new AvatarType("AVATAR_LARGE", 2, 3);
        AVATAR_LARGE = r4;
        a = new AvatarType[]{r2, r3, r4};
    }

    public static AvatarType valueOf(String r1) {
        return (AvatarType) a.a(AvatarType.class, r1);
    }

    public static AvatarType[] values() {
        return (AvatarType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AvatarType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
