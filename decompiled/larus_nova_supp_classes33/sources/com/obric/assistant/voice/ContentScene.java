package com.obric.assistant.voice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/voice/ContentScene;", "", "str", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStr", "()Ljava/lang/String;", "OAUTO_CALL_USER", "COMPLEX_ASK_USER", "PRIORITY_NOTIFICATION", "AI_ACTIVE_ASK", "UNKNOWN", "isValid", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContentScene extends Enum<ContentScene> {
    public static final ContentScene AI_ACTIVE_ASK = null;
    public static final ContentScene COMPLEX_ASK_USER = null;
    public static final a Companion = null;
    public static final ContentScene OAUTO_CALL_USER = null;
    public static final ContentScene PRIORITY_NOTIFICATION = null;
    public static final ContentScene UNKNOWN = null;
    public static final /* synthetic */ ContentScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String str;

    public static EnumEntries<ContentScene> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.voice.ContentScene$a] */
    static {
        ContentScene r0 = new ContentScene("OAUTO_CALL_USER", 0, "oauto_askuser");
        OAUTO_CALL_USER = r0;
        ContentScene r1 = new ContentScene("COMPLEX_ASK_USER", 1, "complex_askuser");
        COMPLEX_ASK_USER = r1;
        ContentScene r3 = new ContentScene("PRIORITY_NOTIFICATION", 2, "notification");
        PRIORITY_NOTIFICATION = r3;
        ContentScene r5 = new ContentScene("AI_ACTIVE_ASK", 3, "ai_active_ask");
        AI_ACTIVE_ASK = r5;
        ContentScene r7 = new ContentScene("UNKNOWN", 4, "unknown");
        UNKNOWN = r7;
        ContentScene[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static ContentScene[] values() {
        return (ContentScene[]) a.clone();
    }

    public final boolean isValid() {
        if (this == UNKNOWN) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getStr() {
        return this.str;
    }

    public static ContentScene valueOf(String r1) {
        return (ContentScene) r27.a.a(ContentScene.class, r1);
    }

    public ContentScene(String r1, int r2, String r3) {
        super(r1, r2);
        this.str = r3;
    }
}
