package com.obric.memorydata.realtimecontext.screen;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/realtimecontext/screen/ViewTreeIllegalType;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ILLEGAL_TYPE_UNKNOWN", "ILLEGAL_TYPE_NO_TEXT", "ILLEGAL_TYPE_NO_A11Y", "ILLEGAL_TYPE_VIRTUAL_NOT_SUPPORT", "ILLEGAL_TYPE_VIRTUAL_A11Y_SWITCH_OFF", "ILLEGAL_TYPE_STRUCTURE_EXCEPTION", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ViewTreeIllegalType extends Enum<ViewTreeIllegalType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ViewTreeIllegalType[] $VALUES = null;
    public static final ViewTreeIllegalType ILLEGAL_TYPE_NO_A11Y = null;
    public static final ViewTreeIllegalType ILLEGAL_TYPE_NO_TEXT = null;
    public static final ViewTreeIllegalType ILLEGAL_TYPE_STRUCTURE_EXCEPTION = null;
    public static final ViewTreeIllegalType ILLEGAL_TYPE_UNKNOWN = null;
    public static final ViewTreeIllegalType ILLEGAL_TYPE_VIRTUAL_A11Y_SWITCH_OFF = null;
    public static final ViewTreeIllegalType ILLEGAL_TYPE_VIRTUAL_NOT_SUPPORT = null;
    private final int value;

    private static final /* synthetic */ ViewTreeIllegalType[] $values() {
        return new ViewTreeIllegalType[]{ILLEGAL_TYPE_UNKNOWN, ILLEGAL_TYPE_NO_TEXT, ILLEGAL_TYPE_NO_A11Y, ILLEGAL_TYPE_VIRTUAL_NOT_SUPPORT, ILLEGAL_TYPE_VIRTUAL_A11Y_SWITCH_OFF, ILLEGAL_TYPE_STRUCTURE_EXCEPTION};
    }

    static {
        ILLEGAL_TYPE_UNKNOWN = new ViewTreeIllegalType("ILLEGAL_TYPE_UNKNOWN", 0, -1);
        ILLEGAL_TYPE_NO_TEXT = new ViewTreeIllegalType("ILLEGAL_TYPE_NO_TEXT", 1, 0);
        ILLEGAL_TYPE_NO_A11Y = new ViewTreeIllegalType("ILLEGAL_TYPE_NO_A11Y", 2, 1);
        ILLEGAL_TYPE_VIRTUAL_NOT_SUPPORT = new ViewTreeIllegalType("ILLEGAL_TYPE_VIRTUAL_NOT_SUPPORT", 3, 2);
        ILLEGAL_TYPE_VIRTUAL_A11Y_SWITCH_OFF = new ViewTreeIllegalType("ILLEGAL_TYPE_VIRTUAL_A11Y_SWITCH_OFF", 4, 3);
        ILLEGAL_TYPE_STRUCTURE_EXCEPTION = new ViewTreeIllegalType("ILLEGAL_TYPE_STRUCTURE_EXCEPTION", 5, 4);
        ViewTreeIllegalType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ViewTreeIllegalType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<ViewTreeIllegalType> getEntries() {
        return $ENTRIES;
    }

    public static ViewTreeIllegalType valueOf(String r2) {
        return (ViewTreeIllegalType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ViewTreeIllegalType.class, r2), ViewTreeIllegalType.class, "com.obric.memorydata.plugin");
    }

    public static ViewTreeIllegalType[] values() {
        return (ViewTreeIllegalType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ViewTreeIllegalType[].class, "com.obric.memorydata.plugin");
    }

    public final int getValue() {
        return this.value;
    }
}
