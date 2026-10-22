package com.larus.voicecall.api.bean;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/voicecall/api/bean/SpeechAecLoadResult;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "META_NOT_LOAD", "VERSION_NOT_SUPPORT", "VERSION_NOT_MATCH", "MODEL_NAME_NOT_FOUND", "USE_PACKED_MODEL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SpeechAecLoadResult extends Enum<SpeechAecLoadResult> {
    public static final SpeechAecLoadResult META_NOT_LOAD = null;
    public static final SpeechAecLoadResult MODEL_NAME_NOT_FOUND = null;
    public static final SpeechAecLoadResult SUCCESS = null;
    public static final SpeechAecLoadResult USE_PACKED_MODEL = null;
    public static final SpeechAecLoadResult VERSION_NOT_MATCH = null;
    public static final SpeechAecLoadResult VERSION_NOT_SUPPORT = null;
    public static final /* synthetic */ SpeechAecLoadResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<SpeechAecLoadResult> getEntries() {
        return b;
    }

    static {
        SpeechAecLoadResult r0 = new SpeechAecLoadResult("SUCCESS", 0, 0);
        SUCCESS = r0;
        SpeechAecLoadResult r1 = new SpeechAecLoadResult("META_NOT_LOAD", 1, 1);
        META_NOT_LOAD = r1;
        SpeechAecLoadResult r3 = new SpeechAecLoadResult("VERSION_NOT_SUPPORT", 2, 2);
        VERSION_NOT_SUPPORT = r3;
        SpeechAecLoadResult r5 = new SpeechAecLoadResult("VERSION_NOT_MATCH", 3, 3);
        VERSION_NOT_MATCH = r5;
        SpeechAecLoadResult r7 = new SpeechAecLoadResult("MODEL_NAME_NOT_FOUND", 4, 4);
        MODEL_NAME_NOT_FOUND = r7;
        SpeechAecLoadResult r9 = new SpeechAecLoadResult("USE_PACKED_MODEL", 5, 5);
        USE_PACKED_MODEL = r9;
        SpeechAecLoadResult[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static SpeechAecLoadResult[] values() {
        return (SpeechAecLoadResult[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SpeechAecLoadResult valueOf(String r1) {
        return (SpeechAecLoadResult) a.a(SpeechAecLoadResult.class, r1);
    }

    public SpeechAecLoadResult(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
