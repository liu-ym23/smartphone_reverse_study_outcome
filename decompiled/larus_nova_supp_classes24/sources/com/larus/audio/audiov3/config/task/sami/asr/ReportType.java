package com.larus.audio.audiov3.config.task.sami.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/audio/audiov3/config/task/sami/asr/ReportType;", "", "<init>", "(Ljava/lang/String;I)V", "ASR_ENDED", "UPLOAD_AUDIO_ENDED", "ASR_STREAM", "audiosdkapi_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ReportType extends Enum<ReportType> {
    public static final ReportType ASR_ENDED = null;
    public static final ReportType ASR_STREAM = null;
    public static final ReportType UPLOAD_AUDIO_ENDED = null;
    public static final /* synthetic */ ReportType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReportType> getEntries() {
        return b;
    }

    static {
        ReportType r0 = new ReportType("ASR_ENDED", 0);
        ASR_ENDED = r0;
        ReportType r1 = new ReportType("UPLOAD_AUDIO_ENDED", 1);
        UPLOAD_AUDIO_ENDED = r1;
        ReportType r3 = new ReportType("ASR_STREAM", 2);
        ASR_STREAM = r3;
        ReportType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ReportType[] values() {
        return (ReportType[]) a.clone();
    }

    public static ReportType valueOf(String r1) {
        return (ReportType) a.a(ReportType.class, r1);
    }

    public ReportType(String r1, int r2) {
        super(r1, r2);
    }
}
