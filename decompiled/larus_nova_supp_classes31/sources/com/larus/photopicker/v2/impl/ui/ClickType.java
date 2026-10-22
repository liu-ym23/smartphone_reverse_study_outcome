package com.larus.photopicker.v2.impl.ui;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/ClickType;", "", "<init>", "(Ljava/lang/String;I)V", "ITEM", "SELECT", "ADD_MORE_PHOTO", "ON_FIRST_IMAGE_LOAD_SUCCESS", "ON_FIRST_IMAGE_LOAD_FAILURE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ClickType extends Enum<ClickType> {
    public static final ClickType ADD_MORE_PHOTO = null;
    public static final ClickType ITEM = null;
    public static final ClickType ON_FIRST_IMAGE_LOAD_FAILURE = null;
    public static final ClickType ON_FIRST_IMAGE_LOAD_SUCCESS = null;
    public static final ClickType SELECT = null;
    public static final /* synthetic */ ClickType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ClickType> getEntries() {
        return b;
    }

    static {
        ClickType r0 = new ClickType("ITEM", 0);
        ITEM = r0;
        ClickType r1 = new ClickType("SELECT", 1);
        SELECT = r1;
        ClickType r3 = new ClickType("ADD_MORE_PHOTO", 2);
        ADD_MORE_PHOTO = r3;
        ClickType r5 = new ClickType("ON_FIRST_IMAGE_LOAD_SUCCESS", 3);
        ON_FIRST_IMAGE_LOAD_SUCCESS = r5;
        ClickType r7 = new ClickType("ON_FIRST_IMAGE_LOAD_FAILURE", 4);
        ON_FIRST_IMAGE_LOAD_FAILURE = r7;
        ClickType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static ClickType[] values() {
        return (ClickType[]) a.clone();
    }

    public static ClickType valueOf(String r1) {
        return (ClickType) a.a(ClickType.class, r1);
    }

    public ClickType(String r1, int r2) {
        super(r1, r2);
    }
}
