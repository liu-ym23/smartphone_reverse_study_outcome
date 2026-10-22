package com.obric.oui.avatar;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueShape;", "", "<init>", "(Ljava/lang/String;I)V", "Queue", "Group", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum OAvatarQueueShape extends Enum<OAvatarQueueShape> {
    private static final /* synthetic */ OAvatarQueueShape[] $VALUES = null;
    public static final OAvatarQueueShape Group = null;
    public static final OAvatarQueueShape Queue = null;

    static {
        OAvatarQueueShape r10 = new OAvatarQueueShape("Queue", 0);
        Queue = r10;
        OAvatarQueueShape r11 = new OAvatarQueueShape("Group", 1);
        Group = r11;
        $VALUES = new OAvatarQueueShape[]{r10, r11};
    }

    private OAvatarQueueShape(String r10, int r11) {
        super(r10, r11);
    }

    public static OAvatarQueueShape valueOf(String r10) {
        return (OAvatarQueueShape) Enum.valueOf(OAvatarQueueShape.class, r10);
    }

    public static OAvatarQueueShape[] values() {
        return (OAvatarQueueShape[]) $VALUES.clone();
    }
}
