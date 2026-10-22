package com.obric.assistant.ability.chat.input;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/ability/chat/input/SkillSelectSource;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "ROW", "MENTION", "ROUTE_USE", "ROUTE_DEMO", "DRAFT", "INVALIDATED", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SkillSelectSource extends Enum<SkillSelectSource> {
    public static final SkillSelectSource DRAFT = null;
    public static final SkillSelectSource INVALIDATED = null;
    public static final SkillSelectSource MENTION = null;
    public static final SkillSelectSource ROUTE_DEMO = null;
    public static final SkillSelectSource ROUTE_USE = null;
    public static final SkillSelectSource ROW = null;
    public static final /* synthetic */ SkillSelectSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SkillSelectSource> getEntries() {
        return b;
    }

    static {
        SkillSelectSource r0 = new SkillSelectSource("ROW", 0);
        ROW = r0;
        SkillSelectSource r1 = new SkillSelectSource("MENTION", 1);
        MENTION = r1;
        SkillSelectSource r3 = new SkillSelectSource("ROUTE_USE", 2);
        ROUTE_USE = r3;
        SkillSelectSource r5 = new SkillSelectSource("ROUTE_DEMO", 3);
        ROUTE_DEMO = r5;
        SkillSelectSource r7 = new SkillSelectSource("DRAFT", 4);
        DRAFT = r7;
        SkillSelectSource r9 = new SkillSelectSource("INVALIDATED", 5);
        INVALIDATED = r9;
        SkillSelectSource[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static SkillSelectSource[] values() {
        return (SkillSelectSource[]) a.clone();
    }

    public static SkillSelectSource valueOf(String r1) {
        return (SkillSelectSource) a.a(SkillSelectSource.class, r1);
    }

    public SkillSelectSource(String r1, int r2) {
        super(r1, r2);
    }
}
