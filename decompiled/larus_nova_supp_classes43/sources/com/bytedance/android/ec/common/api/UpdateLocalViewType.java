package com.bytedance.android.ec.common.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/common/api/UpdateLocalViewType;", "", "UPDATE_ALL", "UPDATE_PRICE_INFO", "VIEW_RECYCLED", "HOT_ATMOSPHERE", "UPDATE_EXPOSE", "UPDATE_BUTTON_INFO", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public final enum UpdateLocalViewType extends Enum<UpdateLocalViewType> {
    public static final UpdateLocalViewType HOT_ATMOSPHERE = null;
    public static final UpdateLocalViewType UPDATE_ALL = null;
    public static final UpdateLocalViewType UPDATE_BUTTON_INFO = null;
    public static final UpdateLocalViewType UPDATE_EXPOSE = null;
    public static final UpdateLocalViewType UPDATE_PRICE_INFO = null;
    public static final UpdateLocalViewType VIEW_RECYCLED = null;
    public static final /* synthetic */ UpdateLocalViewType[] a = null;

    static {
        UpdateLocalViewType r1 = new UpdateLocalViewType("UPDATE_ALL", 0);
        UPDATE_ALL = r1;
        UpdateLocalViewType r10 = new UpdateLocalViewType("UPDATE_PRICE_INFO", 1);
        UPDATE_PRICE_INFO = r10;
        UpdateLocalViewType r11 = new UpdateLocalViewType("VIEW_RECYCLED", 2);
        VIEW_RECYCLED = r11;
        UpdateLocalViewType r12 = new UpdateLocalViewType("HOT_ATMOSPHERE", 3);
        HOT_ATMOSPHERE = r12;
        UpdateLocalViewType r13 = new UpdateLocalViewType("UPDATE_EXPOSE", 4);
        UPDATE_EXPOSE = r13;
        UpdateLocalViewType r14 = new UpdateLocalViewType("UPDATE_BUTTON_INFO", 5);
        UPDATE_BUTTON_INFO = r14;
        a = new UpdateLocalViewType[]{r1, r10, r11, r12, r13, r14};
    }

    public static UpdateLocalViewType valueOf(String r1) {
        return (UpdateLocalViewType) a.a(UpdateLocalViewType.class, r1);
    }

    public static UpdateLocalViewType[] values() {
        return (UpdateLocalViewType[]) a.clone();
    }

    public UpdateLocalViewType(String r1, int r10) {
        super(r1, r10);
    }
}
