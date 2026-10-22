package com.ss.android.lark.inline.ai.api;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ScenarioType;", "", "int", "", "<init>", "(Ljava/lang/String;II)V", "getInt", "()I", "UNKNOWN", "IM", "Doc", "Sheet", "Base", "VC", "Calendar", "Email", "Meego", "OpenWebContainer", "Search", "Slides", "GroupChat", "P2PChat", "Board", "PDFView", "WikiSpace", "VoiceInput", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ScenarioType extends Enum<ScenarioType> {
    public static final ScenarioType Base = null;
    public static final ScenarioType Board = null;
    public static final ScenarioType Calendar = null;
    public static final ScenarioType Doc = null;
    public static final ScenarioType Email = null;
    public static final ScenarioType GroupChat = null;
    public static final ScenarioType IM = null;
    public static final ScenarioType Meego = null;
    public static final ScenarioType OpenWebContainer = null;
    public static final ScenarioType P2PChat = null;
    public static final ScenarioType PDFView = null;
    public static final ScenarioType Search = null;
    public static final ScenarioType Sheet = null;
    public static final ScenarioType Slides = null;
    public static final ScenarioType UNKNOWN = null;
    public static final ScenarioType VC = null;
    public static final ScenarioType VoiceInput = null;
    public static final ScenarioType WikiSpace = null;
    public static final /* synthetic */ ScenarioType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    /* JADX INFO: renamed from: int, reason: not valid java name */
    private final int f0int;

    public static EnumEntries<ScenarioType> getEntries() {
        return b;
    }

    static {
        ScenarioType r0 = new ScenarioType("UNKNOWN", 0, -1);
        UNKNOWN = r0;
        ScenarioType r1 = new ScenarioType("IM", 1, 0);
        IM = r1;
        ScenarioType r2 = new ScenarioType("Doc", 2, 1);
        Doc = r2;
        ScenarioType r5 = new ScenarioType("Sheet", 3, 2);
        Sheet = r5;
        ScenarioType r7 = new ScenarioType("Base", 4, 3);
        Base = r7;
        ScenarioType r9 = new ScenarioType("VC", 5, 4);
        VC = r9;
        ScenarioType r11 = new ScenarioType("Calendar", 6, 5);
        Calendar = r11;
        ScenarioType r13 = new ScenarioType("Email", 7, 6);
        Email = r13;
        ScenarioType r15 = new ScenarioType("Meego", 8, 7);
        Meego = r15;
        ScenarioType r14 = new ScenarioType("OpenWebContainer", 9, 8);
        OpenWebContainer = r14;
        ScenarioType r12 = new ScenarioType("Search", 10, 9);
        Search = r12;
        ScenarioType r10 = new ScenarioType("Slides", 11, 10);
        Slides = r10;
        ScenarioType r8 = new ScenarioType("GroupChat", 12, 11);
        GroupChat = r8;
        ScenarioType r6 = new ScenarioType("P2PChat", 13, 12);
        P2PChat = r6;
        ScenarioType r4 = new ScenarioType("Board", 14, 13);
        Board = r4;
        ScenarioType r3 = new ScenarioType("PDFView", 15, 14);
        PDFView = r3;
        ScenarioType r16 = new ScenarioType("WikiSpace", 16, 15);
        WikiSpace = r16;
        ScenarioType r17 = new ScenarioType("VoiceInput", 17, 16);
        VoiceInput = r17;
        ScenarioType[] r18 = {r0, r1, r2, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r3, r16, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
    }

    public static ScenarioType[] values() {
        return (ScenarioType[]) a.clone();
    }

    public final int getInt() {
        return this.f0int;
    }

    public static ScenarioType valueOf(String r1) {
        return (ScenarioType) a.a(ScenarioType.class, r1);
    }

    public ScenarioType(String r1, int r2, int r3) {
        super(r1, r2);
        this.f0int = r3;
    }
}
