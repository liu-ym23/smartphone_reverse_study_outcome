package com.larus.audio.call.utils;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/call/utils/AvBizType;", "", "bizId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getBizId", "()Ljava/lang/String;", "VOICE_CALL", "DORA", "INTERPRETER", "OBRIC_CONTINUOUS_TALK", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AvBizType extends Enum<AvBizType> {
    public static final AvBizType DORA = null;
    public static final AvBizType INTERPRETER = null;
    public static final AvBizType OBRIC_CONTINUOUS_TALK = null;
    public static final AvBizType VOICE_CALL = null;
    public static final /* synthetic */ AvBizType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String bizId;

    public static EnumEntries<AvBizType> getEntries() {
        return b;
    }

    static {
        AvBizType r0 = new AvBizType("VOICE_CALL", 0, "voice_call");
        VOICE_CALL = r0;
        AvBizType r1 = new AvBizType("DORA", 1, "dora");
        DORA = r1;
        AvBizType r2 = new AvBizType("INTERPRETER", 2, "interpret");
        INTERPRETER = r2;
        AvBizType r4 = new AvBizType("OBRIC_CONTINUOUS_TALK", 3, "obric_continuous_talk");
        OBRIC_CONTINUOUS_TALK = r4;
        AvBizType[] r6 = {r0, r1, r2, r4};
        a = r6;
        b = EnumEntriesKt.enumEntries(r6);
    }

    public static AvBizType[] values() {
        return (AvBizType[]) a.clone();
    }

    public final String getBizId() {
        return this.bizId;
    }

    public static AvBizType valueOf(String r1) {
        return (AvBizType) a.a(AvBizType.class, r1);
    }

    public AvBizType(String r1, int r2, String r3) {
        super(r1, r2);
        this.bizId = r3;
    }
}
