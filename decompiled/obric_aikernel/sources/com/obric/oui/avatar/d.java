package com.obric.oui.avatar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f6222b = null;

    static {
        int[] r10 = new int[OAvatarQueueShape.values().length];
        f6221a = r10;
        OAvatarQueueShape r11 = OAvatarQueueShape.Group;
        r10[r11.ordinal()] = 1;
        OAvatarQueueShape r12 = OAvatarQueueShape.Queue;
        r10[r12.ordinal()] = 2;
        int[] r13 = new int[OAvatarQueueShape.values().length];
        f6222b = r13;
        r13[r11.ordinal()] = 1;
        r13[r12.ordinal()] = 2;
    }
}
