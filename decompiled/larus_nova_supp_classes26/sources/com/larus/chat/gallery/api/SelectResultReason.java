package com.larus.chat.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/chat/gallery/api/SelectResultReason;", "", "<init>", "(Ljava/lang/String;I)V", "OK", "LIMIT_REACHED", "ITEM_NOT_FOUND", "NOT_SUPPORTED", "REJECTED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SelectResultReason extends Enum<SelectResultReason> {
    public static final SelectResultReason ITEM_NOT_FOUND = null;
    public static final SelectResultReason LIMIT_REACHED = null;
    public static final SelectResultReason NOT_SUPPORTED = null;
    public static final SelectResultReason OK = null;
    public static final SelectResultReason REJECTED = null;
    public static final /* synthetic */ SelectResultReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SelectResultReason> getEntries() {
        return b;
    }

    static {
        SelectResultReason r0 = new SelectResultReason("OK", 0);
        OK = r0;
        SelectResultReason r1 = new SelectResultReason("LIMIT_REACHED", 1);
        LIMIT_REACHED = r1;
        SelectResultReason r3 = new SelectResultReason("ITEM_NOT_FOUND", 2);
        ITEM_NOT_FOUND = r3;
        SelectResultReason r5 = new SelectResultReason("NOT_SUPPORTED", 3);
        NOT_SUPPORTED = r5;
        SelectResultReason r7 = new SelectResultReason("REJECTED", 4);
        REJECTED = r7;
        SelectResultReason[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static SelectResultReason[] values() {
        return (SelectResultReason[]) a.clone();
    }

    public static SelectResultReason valueOf(String r1) {
        return (SelectResultReason) r27.a.a(SelectResultReason.class, r1);
    }

    public SelectResultReason(String r1, int r2) {
        super(r1, r2);
    }
}
