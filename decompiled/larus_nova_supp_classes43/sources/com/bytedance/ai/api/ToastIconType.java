package com.bytedance.ai.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/api/ToastIconType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "SUCCESS", "FAILURE", "WARNING", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ToastIconType extends Enum<ToastIconType> {
    public static final ToastIconType DEFAULT = null;
    public static final ToastIconType FAILURE = null;
    public static final ToastIconType SUCCESS = null;
    public static final ToastIconType WARNING = null;
    public static final /* synthetic */ ToastIconType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ToastIconType> getEntries() {
        return b;
    }

    static {
        ToastIconType r0 = new ToastIconType("DEFAULT", 0);
        DEFAULT = r0;
        ToastIconType r1 = new ToastIconType("SUCCESS", 1);
        SUCCESS = r1;
        ToastIconType r10 = new ToastIconType("FAILURE", 2);
        FAILURE = r10;
        ToastIconType r11 = new ToastIconType("WARNING", 3);
        WARNING = r11;
        ToastIconType[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static ToastIconType[] values() {
        return (ToastIconType[]) a.clone();
    }

    public static ToastIconType valueOf(String r1) {
        return (ToastIconType) r27.a.a(ToastIconType.class, r1);
    }

    public ToastIconType(String r1, int r10) {
        super(r1, r10);
    }
}
