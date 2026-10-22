package com.obric.assistant.cocreationreview.modules.memory;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/memory/MemoryReviewAudioTranscriptCode;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "OK", "EMPTY", "NOT_FOUND", "INVALID_CURSOR", "STALE_CURSOR", "TOO_LARGE", "INTERNAL_ERROR", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MemoryReviewAudioTranscriptCode extends Enum<MemoryReviewAudioTranscriptCode> {
    public static final a Companion = null;
    public static final MemoryReviewAudioTranscriptCode EMPTY = null;
    public static final MemoryReviewAudioTranscriptCode INTERNAL_ERROR = null;
    public static final MemoryReviewAudioTranscriptCode INVALID_CURSOR = null;
    public static final MemoryReviewAudioTranscriptCode NOT_FOUND = null;
    public static final MemoryReviewAudioTranscriptCode OK = null;
    public static final MemoryReviewAudioTranscriptCode STALE_CURSOR = null;
    public static final MemoryReviewAudioTranscriptCode TOO_LARGE = null;
    public static final /* synthetic */ MemoryReviewAudioTranscriptCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MemoryReviewAudioTranscriptCode> getEntries() {
        return b;
    }

    static {
        MemoryReviewAudioTranscriptCode r0 = new MemoryReviewAudioTranscriptCode("OK", 0);
        OK = r0;
        MemoryReviewAudioTranscriptCode r1 = new MemoryReviewAudioTranscriptCode("EMPTY", 1);
        EMPTY = r1;
        MemoryReviewAudioTranscriptCode r3 = new MemoryReviewAudioTranscriptCode("NOT_FOUND", 2);
        NOT_FOUND = r3;
        MemoryReviewAudioTranscriptCode r5 = new MemoryReviewAudioTranscriptCode("INVALID_CURSOR", 3);
        INVALID_CURSOR = r5;
        MemoryReviewAudioTranscriptCode r7 = new MemoryReviewAudioTranscriptCode("STALE_CURSOR", 4);
        STALE_CURSOR = r7;
        MemoryReviewAudioTranscriptCode r9 = new MemoryReviewAudioTranscriptCode("TOO_LARGE", 5);
        TOO_LARGE = r9;
        MemoryReviewAudioTranscriptCode r11 = new MemoryReviewAudioTranscriptCode("INTERNAL_ERROR", 6);
        INTERNAL_ERROR = r11;
        MemoryReviewAudioTranscriptCode[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
        Companion = new a();
    }

    public static MemoryReviewAudioTranscriptCode[] values() {
        return (MemoryReviewAudioTranscriptCode[]) a.clone();
    }

    public static MemoryReviewAudioTranscriptCode valueOf(String r1) {
        return (MemoryReviewAudioTranscriptCode) r27.a.a(MemoryReviewAudioTranscriptCode.class, r1);
    }

    public MemoryReviewAudioTranscriptCode(String r1, int r2) {
        super(r1, r2);
    }
}
