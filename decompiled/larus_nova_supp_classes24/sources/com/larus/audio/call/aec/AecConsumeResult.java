package com.larus.audio.call.aec;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/audio/call/aec/AecConsumeResult;", "", "message", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "EMPTY_QUEUE", "EMPTY_QUEUE_EXCEPT_FLAG", "SENTENCE_END", "SENTENCE_END_NOVALID", "SENTENCE_PART", "SENTENCE_END_MORE_SENTENCE", "AHEAD_OF_SENTENCE", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum AecConsumeResult extends Enum<AecConsumeResult> {
    public static final AecConsumeResult AHEAD_OF_SENTENCE = null;
    public static final AecConsumeResult EMPTY_QUEUE = null;
    public static final AecConsumeResult EMPTY_QUEUE_EXCEPT_FLAG = null;
    public static final AecConsumeResult SENTENCE_END = null;
    public static final AecConsumeResult SENTENCE_END_MORE_SENTENCE = null;
    public static final AecConsumeResult SENTENCE_END_NOVALID = null;
    public static final AecConsumeResult SENTENCE_PART = null;
    public static final /* synthetic */ AecConsumeResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String message;

    public static EnumEntries<AecConsumeResult> getEntries() {
        return b;
    }

    static {
        AecConsumeResult r0 = new AecConsumeResult("EMPTY_QUEUE", 0, "empty");
        EMPTY_QUEUE = r0;
        AecConsumeResult r1 = new AecConsumeResult("EMPTY_QUEUE_EXCEPT_FLAG", 1, "empty_except_flag");
        EMPTY_QUEUE_EXCEPT_FLAG = r1;
        AecConsumeResult r2 = new AecConsumeResult("SENTENCE_END", 2, "sentence_end");
        SENTENCE_END = r2;
        AecConsumeResult r4 = new AecConsumeResult("SENTENCE_END_NOVALID", 3, "sentence_end_error");
        SENTENCE_END_NOVALID = r4;
        AecConsumeResult r6 = new AecConsumeResult("SENTENCE_PART", 4, "sentence_part");
        SENTENCE_PART = r6;
        AecConsumeResult r8 = new AecConsumeResult("SENTENCE_END_MORE_SENTENCE", 5, "sentence_end_more_ref");
        SENTENCE_END_MORE_SENTENCE = r8;
        AecConsumeResult r10 = new AecConsumeResult("AHEAD_OF_SENTENCE", 6, "ahead_of_sentence");
        AHEAD_OF_SENTENCE = r10;
        AecConsumeResult[] r12 = {r0, r1, r2, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static AecConsumeResult[] values() {
        return (AecConsumeResult[]) a.clone();
    }

    public final String getMessage() {
        return this.message;
    }

    public static AecConsumeResult valueOf(String r1) {
        return (AecConsumeResult) r27.a.a(AecConsumeResult.class, r1);
    }

    public AecConsumeResult(String r1, int r2, String r3) {
        super(r1, r2);
        this.message = r3;
    }
}
