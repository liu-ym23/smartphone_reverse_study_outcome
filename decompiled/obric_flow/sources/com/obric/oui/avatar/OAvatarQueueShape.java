package com.obric.oui.avatar;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueShape;", "", "Queue", "Group", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OAvatarQueueShape extends Enum<OAvatarQueueShape> {
    public static final OAvatarQueueShape Group = null;
    public static final OAvatarQueueShape Queue = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OAvatarQueueShape[] f11955a = null;

    static {
        OAvatarQueueShape r5 = new OAvatarQueueShape("Queue", 0);
        Queue = r5;
        OAvatarQueueShape r10 = new OAvatarQueueShape("Group", 1);
        Group = r10;
        f11955a = new OAvatarQueueShape[]{r5, r10};
    }

    public static OAvatarQueueShape valueOf(String r5) {
        return (OAvatarQueueShape) Enum.valueOf(OAvatarQueueShape.class, r5);
    }

    public static OAvatarQueueShape[] values() {
        return (OAvatarQueueShape[]) f11955a.clone();
    }
}
