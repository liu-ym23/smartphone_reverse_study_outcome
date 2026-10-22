package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum NoticeType extends Enum<NoticeType> implements WireEnum {
    private static final /* synthetic */ NoticeType[] $VALUES = null;
    public static final ProtoAdapter<NoticeType> ADAPTER = null;
    public static final NoticeType DIGITAL_NOTICE = null;
    public static final NoticeType Notice_default = null;
    public static final NoticeType RED_DOT_NOTICE = null;
    private final int value;

    static {
        NoticeType r0 = new NoticeType("Notice_default", 0, 0);
        Notice_default = r0;
        NoticeType r1 = new NoticeType("DIGITAL_NOTICE", 1, 1);
        DIGITAL_NOTICE = r1;
        NoticeType r3 = new NoticeType("RED_DOT_NOTICE", 2, 2);
        RED_DOT_NOTICE = r3;
        $VALUES = new NoticeType[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(NoticeType.class);
    }

    public static NoticeType[] values() {
        return (NoticeType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static NoticeType fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return RED_DOT_NOTICE;
    L12:
        return DIGITAL_NOTICE;
    L14:
        return Notice_default;
    }

    public static NoticeType valueOf(String r1) {
        return (NoticeType) a.a(NoticeType.class, r1);
    }

    private NoticeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
