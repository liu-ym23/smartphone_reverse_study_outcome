package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/cocreationreview/CardTemplateTagTone;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "NEUTRAL", "ACCENT", "SUCCESS", "WARNING", "DANGER", "METRIC", "FEEDBACK_UP", "FEEDBACK_DOWN", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CardTemplateTagTone extends Enum<CardTemplateTagTone> {
    public static final CardTemplateTagTone ACCENT = null;
    public static final CardTemplateTagTone DANGER = null;
    public static final CardTemplateTagTone FEEDBACK_DOWN = null;
    public static final CardTemplateTagTone FEEDBACK_UP = null;
    public static final CardTemplateTagTone METRIC = null;
    public static final CardTemplateTagTone NEUTRAL = null;
    public static final CardTemplateTagTone SUCCESS = null;
    public static final CardTemplateTagTone WARNING = null;
    public static final /* synthetic */ CardTemplateTagTone[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CardTemplateTagTone> getEntries() {
        return b;
    }

    static {
        CardTemplateTagTone r0 = new CardTemplateTagTone("NEUTRAL", 0);
        NEUTRAL = r0;
        CardTemplateTagTone r1 = new CardTemplateTagTone("ACCENT", 1);
        ACCENT = r1;
        CardTemplateTagTone r3 = new CardTemplateTagTone("SUCCESS", 2);
        SUCCESS = r3;
        CardTemplateTagTone r5 = new CardTemplateTagTone("WARNING", 3);
        WARNING = r5;
        CardTemplateTagTone r7 = new CardTemplateTagTone("DANGER", 4);
        DANGER = r7;
        CardTemplateTagTone r9 = new CardTemplateTagTone("METRIC", 5);
        METRIC = r9;
        CardTemplateTagTone r11 = new CardTemplateTagTone("FEEDBACK_UP", 6);
        FEEDBACK_UP = r11;
        CardTemplateTagTone r13 = new CardTemplateTagTone("FEEDBACK_DOWN", 7);
        FEEDBACK_DOWN = r13;
        CardTemplateTagTone[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static CardTemplateTagTone[] values() {
        return (CardTemplateTagTone[]) a.clone();
    }

    public static CardTemplateTagTone valueOf(String r1) {
        return (CardTemplateTagTone) r27.a.a(CardTemplateTagTone.class, r1);
    }

    public CardTemplateTagTone(String r1, int r2) {
        super(r1, r2);
    }
}
