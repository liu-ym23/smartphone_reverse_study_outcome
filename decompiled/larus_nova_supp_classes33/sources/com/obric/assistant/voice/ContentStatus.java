package com.obric.assistant.voice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/voice/ContentStatus;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "VOICE_AUTHEN", "ASR_RESULT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContentStatus extends Enum<ContentStatus> {
    public static final ContentStatus ASR_RESULT = null;
    public static final ContentStatus INIT = null;
    public static final ContentStatus VOICE_AUTHEN = null;
    public static final /* synthetic */ ContentStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ContentStatus> getEntries() {
        return b;
    }

    static {
        ContentStatus r0 = new ContentStatus("INIT", 0);
        INIT = r0;
        ContentStatus r1 = new ContentStatus("VOICE_AUTHEN", 1);
        VOICE_AUTHEN = r1;
        ContentStatus r3 = new ContentStatus("ASR_RESULT", 2);
        ASR_RESULT = r3;
        ContentStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ContentStatus[] values() {
        return (ContentStatus[]) a.clone();
    }

    public static ContentStatus valueOf(String r1) {
        return (ContentStatus) r27.a.a(ContentStatus.class, r1);
    }

    public ContentStatus(String r1, int r2) {
        super(r1, r2);
    }
}
