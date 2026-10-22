package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum Status extends Enum<Status> implements WireEnum {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final ProtoAdapter<Status> ADAPTER = null;
    public static final Status Fail = null;
    public static final Status Success = null;
    private final int value;

    static {
        Status r0 = new Status("Success", 0, 0);
        Success = r0;
        Status r1 = new Status("Fail", 1, 1);
        Fail = r1;
        $VALUES = new Status[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Status fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return Fail;
    L10:
        return Success;
    }

    public static Status valueOf(String r1) {
        return (Status) a.a(Status.class, r1);
    }

    private Status(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
