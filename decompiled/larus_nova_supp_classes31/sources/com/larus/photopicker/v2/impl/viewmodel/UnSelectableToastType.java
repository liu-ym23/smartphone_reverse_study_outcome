package com.larus.photopicker.v2.impl.viewmodel;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/photopicker/v2/impl/viewmodel/UnSelectableToastType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "VIDEO_LIMIT", "IMAGE_LIMIT", "VIDEO_DURATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum UnSelectableToastType extends Enum<UnSelectableToastType> {
    public static final UnSelectableToastType DEFAULT = null;
    public static final UnSelectableToastType IMAGE_LIMIT = null;
    public static final UnSelectableToastType VIDEO_DURATION = null;
    public static final UnSelectableToastType VIDEO_LIMIT = null;
    public static final /* synthetic */ UnSelectableToastType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<UnSelectableToastType> getEntries() {
        return b;
    }

    static {
        UnSelectableToastType r0 = new UnSelectableToastType("DEFAULT", 0);
        DEFAULT = r0;
        UnSelectableToastType r1 = new UnSelectableToastType("VIDEO_LIMIT", 1);
        VIDEO_LIMIT = r1;
        UnSelectableToastType r3 = new UnSelectableToastType("IMAGE_LIMIT", 2);
        IMAGE_LIMIT = r3;
        UnSelectableToastType r5 = new UnSelectableToastType("VIDEO_DURATION", 3);
        VIDEO_DURATION = r5;
        UnSelectableToastType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static UnSelectableToastType[] values() {
        return (UnSelectableToastType[]) a.clone();
    }

    public static UnSelectableToastType valueOf(String r1) {
        return (UnSelectableToastType) r27.a.a(UnSelectableToastType.class, r1);
    }

    public UnSelectableToastType(String r1, int r2) {
        super(r1, r2);
    }
}
