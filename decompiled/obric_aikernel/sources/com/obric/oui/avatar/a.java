package com.obric.oui.avatar;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6213a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f6214b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f6215c = null;

    static {
        int[] r10 = new int[OAvatar.AvatarSize.values().length];
        f6213a = r10;
        OAvatar.AvatarSize r11 = OAvatar.AvatarSize.DP_24;
        r10[r11.ordinal()] = 1;
        OAvatar.AvatarSize r12 = OAvatar.AvatarSize.DP_32;
        r10[r12.ordinal()] = 2;
        OAvatar.AvatarSize r13 = OAvatar.AvatarSize.DP_40;
        r10[r13.ordinal()] = 3;
        OAvatar.AvatarSize r14 = OAvatar.AvatarSize.DP_48;
        r10[r14.ordinal()] = 4;
        OAvatar.AvatarSize r15 = OAvatar.AvatarSize.DP_56;
        r10[r15.ordinal()] = 5;
        OAvatar.AvatarSize r16 = OAvatar.AvatarSize.DP_64;
        r10[r16.ordinal()] = 6;
        OAvatar.AvatarSize r17 = OAvatar.AvatarSize.DP_72;
        r10[r17.ordinal()] = 7;
        int[] r18 = new int[OAvatar.AvatarSize.values().length];
        f6214b = r18;
        r18[r11.ordinal()] = 1;
        r18[r12.ordinal()] = 2;
        r18[r13.ordinal()] = 3;
        r18[r14.ordinal()] = 4;
        r18[r15.ordinal()] = 5;
        r18[r16.ordinal()] = 6;
        r18[r17.ordinal()] = 7;
        int[] r19 = new int[OAvatar.IconType.values().length];
        f6215c = r19;
        r19[OAvatar.IconType.LOGO.ordinal()] = 1;
        r19[OAvatar.IconType.ONLINE.ordinal()] = 2;
    }
}
