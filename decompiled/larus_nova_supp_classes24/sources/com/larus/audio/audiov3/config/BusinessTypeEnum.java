package com.larus.audio.audiov3.config;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/audiov3/config/BusinessTypeEnum;", "", "<init>", "(Ljava/lang/String;I)V", "ASR", "TTS_BY_MSG_ID", "TTS_BY_TEXT", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum BusinessTypeEnum extends Enum<BusinessTypeEnum> {
    public static final BusinessTypeEnum ASR = null;
    public static final BusinessTypeEnum TTS_BY_MSG_ID = null;
    public static final BusinessTypeEnum TTS_BY_TEXT = null;
    public static final /* synthetic */ BusinessTypeEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BusinessTypeEnum> getEntries() {
        return b;
    }

    static {
        BusinessTypeEnum r0 = new BusinessTypeEnum("ASR", 0);
        ASR = r0;
        BusinessTypeEnum r1 = new BusinessTypeEnum("TTS_BY_MSG_ID", 1);
        TTS_BY_MSG_ID = r1;
        BusinessTypeEnum r3 = new BusinessTypeEnum("TTS_BY_TEXT", 2);
        TTS_BY_TEXT = r3;
        BusinessTypeEnum[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static BusinessTypeEnum[] values() {
        return (BusinessTypeEnum[]) a.clone();
    }

    public static BusinessTypeEnum valueOf(String r1) {
        return (BusinessTypeEnum) a.a(BusinessTypeEnum.class, r1);
    }

    public BusinessTypeEnum(String r1, int r2) {
        super(r1, r2);
    }
}
