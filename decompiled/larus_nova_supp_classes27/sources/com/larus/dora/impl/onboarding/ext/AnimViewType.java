package com.larus.dora.impl.onboarding.ext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/onboarding/ext/AnimViewType;", "", "<init>", "(Ljava/lang/String;I)V", "AVATAR", "BUBBLE", "BUBBLE_BACKGROUND", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AnimViewType extends Enum<AnimViewType> {
    public static final AnimViewType AVATAR = null;
    public static final AnimViewType BUBBLE = null;
    public static final AnimViewType BUBBLE_BACKGROUND = null;
    public static final /* synthetic */ AnimViewType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AnimViewType> getEntries() {
        return b;
    }

    static {
        AnimViewType r0 = new AnimViewType("AVATAR", 0);
        AVATAR = r0;
        AnimViewType r1 = new AnimViewType("BUBBLE", 1);
        BUBBLE = r1;
        AnimViewType r3 = new AnimViewType("BUBBLE_BACKGROUND", 2);
        BUBBLE_BACKGROUND = r3;
        AnimViewType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AnimViewType[] values() {
        return (AnimViewType[]) a.clone();
    }

    public static AnimViewType valueOf(String r1) {
        return (AnimViewType) a.a(AnimViewType.class, r1);
    }

    public AnimViewType(String r1, int r2) {
        super(r1, r2);
    }
}
