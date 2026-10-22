package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/container/ListActionEnum;", "", "ADD", "REMOVE", "UPDATE", "REFRESH", "toolbarservice-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ListActionEnum extends Enum<ListActionEnum> {
    public static final ListActionEnum ADD = null;
    public static final ListActionEnum REFRESH = null;
    public static final ListActionEnum REMOVE = null;
    public static final ListActionEnum UPDATE = null;
    public static final /* synthetic */ ListActionEnum[] a = null;

    static {
        ListActionEnum r1 = new ListActionEnum("ADD", 0);
        ADD = r1;
        ListActionEnum r2 = new ListActionEnum("REMOVE", 1);
        REMOVE = r2;
        ListActionEnum r3 = new ListActionEnum("UPDATE", 2);
        UPDATE = r3;
        ListActionEnum r4 = new ListActionEnum("REFRESH", 3);
        REFRESH = r4;
        a = new ListActionEnum[]{r1, r2, r3, r4};
    }

    public static ListActionEnum valueOf(String r1) {
        return (ListActionEnum) a.a(ListActionEnum.class, r1);
    }

    public static ListActionEnum[] values() {
        return (ListActionEnum[]) a.clone();
    }

    public ListActionEnum(String r1, int r2) {
        super(r1, r2);
    }
}
