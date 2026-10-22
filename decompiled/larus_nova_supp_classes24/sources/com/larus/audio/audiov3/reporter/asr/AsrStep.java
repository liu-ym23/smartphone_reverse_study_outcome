package com.larus.audio.audiov3.reporter.asr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/audio/audiov3/reporter/asr/AsrStep;", "", "traceName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTraceName", "()Ljava/lang/String;", "ASR_CREATE_AUDIO", "ASR_DATA_TRANSMISSION", "ASR_RECOGNITION_DELAY", "ASR_AUDIO_RECORD", "ASR_AUDIO_UPLOAD", "ASR_AUDIO_RECORD_LEAK", "ASR_AUDIO_RECORD_BIG_FILE", "ASR_STREAM_TO_FINAL", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AsrStep extends Enum<AsrStep> {
    public static final AsrStep ASR_AUDIO_RECORD = null;
    public static final AsrStep ASR_AUDIO_RECORD_BIG_FILE = null;
    public static final AsrStep ASR_AUDIO_RECORD_LEAK = null;
    public static final AsrStep ASR_AUDIO_UPLOAD = null;
    public static final AsrStep ASR_CREATE_AUDIO = null;
    public static final AsrStep ASR_DATA_TRANSMISSION = null;
    public static final AsrStep ASR_RECOGNITION_DELAY = null;
    public static final AsrStep ASR_STREAM_TO_FINAL = null;
    public static final /* synthetic */ AsrStep[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String traceName;

    public static EnumEntries<AsrStep> getEntries() {
        return b;
    }

    static {
        AsrStep r0 = new AsrStep("ASR_CREATE_AUDIO", 0, "asr_create_default_audio");
        ASR_CREATE_AUDIO = r0;
        AsrStep r1 = new AsrStep("ASR_DATA_TRANSMISSION", 1, "asr_data_transmission");
        ASR_DATA_TRANSMISSION = r1;
        AsrStep r2 = new AsrStep("ASR_RECOGNITION_DELAY", 2, "asr_recognition_delay");
        ASR_RECOGNITION_DELAY = r2;
        AsrStep r4 = new AsrStep("ASR_AUDIO_RECORD", 3, "asr_audio_record");
        ASR_AUDIO_RECORD = r4;
        AsrStep r6 = new AsrStep("ASR_AUDIO_UPLOAD", 4, "asr_audio_upload");
        ASR_AUDIO_UPLOAD = r6;
        AsrStep r8 = new AsrStep("ASR_AUDIO_RECORD_LEAK", 5, "asr_audio_record_leak");
        ASR_AUDIO_RECORD_LEAK = r8;
        AsrStep r10 = new AsrStep("ASR_AUDIO_RECORD_BIG_FILE", 6, "asr_audio_record_big_file");
        ASR_AUDIO_RECORD_BIG_FILE = r10;
        AsrStep r12 = new AsrStep("ASR_STREAM_TO_FINAL", 7, "asr_stream_to_final");
        ASR_STREAM_TO_FINAL = r12;
        AsrStep[] r14 = {r0, r1, r2, r4, r6, r8, r10, r12};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static AsrStep[] values() {
        return (AsrStep[]) a.clone();
    }

    public final String getTraceName() {
        return this.traceName;
    }

    public static AsrStep valueOf(String r1) {
        return (AsrStep) a.a(AsrStep.class, r1);
    }

    public AsrStep(String r1, int r2, String r3) {
        super(r1, r2);
        this.traceName = r3;
    }
}
