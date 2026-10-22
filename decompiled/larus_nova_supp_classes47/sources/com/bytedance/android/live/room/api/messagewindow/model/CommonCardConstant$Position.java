package com.bytedance.android.live.room.api.messagewindow.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/android/live/room/api/messagewindow/model/CommonCardConstant$Position", "", "Lcom/bytedance/android/live/room/api/messagewindow/model/CommonCardConstant$Position;", "", "value", "I", "getValue", "()I", "UNKNOWN", "BOTTOM_RIGHT", "TOP_RIGHT", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommonCardConstant$Position extends Enum<CommonCardConstant$Position> {
    public static final CommonCardConstant$Position BOTTOM_RIGHT = null;
    public static final CommonCardConstant$Position TOP_RIGHT = null;
    public static final CommonCardConstant$Position UNKNOWN = null;
    public static final /* synthetic */ CommonCardConstant$Position[] a = null;
    private final int value;

    static {
        CommonCardConstant$Position r2 = new CommonCardConstant$Position("UNKNOWN", 0, 0);
        UNKNOWN = r2;
        CommonCardConstant$Position r3 = new CommonCardConstant$Position("BOTTOM_RIGHT", 1, 1);
        BOTTOM_RIGHT = r3;
        CommonCardConstant$Position r4 = new CommonCardConstant$Position("TOP_RIGHT", 2, 3);
        TOP_RIGHT = r4;
        a = new CommonCardConstant$Position[]{r2, r3, r4};
    }

    public static CommonCardConstant$Position valueOf(String r1) {
        return (CommonCardConstant$Position) a.a(CommonCardConstant$Position.class, r1);
    }

    public static CommonCardConstant$Position[] values() {
        return (CommonCardConstant$Position[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CommonCardConstant$Position(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
