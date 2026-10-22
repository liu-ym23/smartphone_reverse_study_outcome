package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/cocreationreview/ModuleKey;", NameKeys.UnloadStrategy_No_Strategy, "raw", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "PROACTIVE_AGENT", "SCREEN_MEMORY", "AUDIO_MEMORY", "AUTO_MEMORY_PRO", "COLLECTION_MEMORY", "PERSONAL_MEMORY", "SEARCH_QA", "OMNI", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ModuleKey extends Enum<ModuleKey> {
    public static final ModuleKey AUDIO_MEMORY = null;
    public static final ModuleKey AUTO_MEMORY_PRO = null;
    public static final ModuleKey COLLECTION_MEMORY = null;
    public static final a Companion = null;
    public static final ModuleKey OMNI = null;
    public static final ModuleKey PERSONAL_MEMORY = null;
    public static final ModuleKey PROACTIVE_AGENT = null;
    public static final ModuleKey SCREEN_MEMORY = null;
    public static final ModuleKey SEARCH_QA = null;
    public static final /* synthetic */ ModuleKey[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String raw;

    public static EnumEntries<ModuleKey> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.cocreationreview.ModuleKey$a] */
    static {
        ModuleKey r0 = new ModuleKey("PROACTIVE_AGENT", 0, "proactive_agent");
        PROACTIVE_AGENT = r0;
        ModuleKey r1 = new ModuleKey("SCREEN_MEMORY", 1, "screen_memory");
        SCREEN_MEMORY = r1;
        ModuleKey r3 = new ModuleKey("AUDIO_MEMORY", 2, "audio_memory");
        AUDIO_MEMORY = r3;
        ModuleKey r5 = new ModuleKey("AUTO_MEMORY_PRO", 3, "auto_memory_pro");
        AUTO_MEMORY_PRO = r5;
        ModuleKey r7 = new ModuleKey("COLLECTION_MEMORY", 4, "collection_memory");
        COLLECTION_MEMORY = r7;
        ModuleKey r9 = new ModuleKey("PERSONAL_MEMORY", 5, "personal_memory");
        PERSONAL_MEMORY = r9;
        ModuleKey r11 = new ModuleKey("SEARCH_QA", 6, "search_qa");
        SEARCH_QA = r11;
        ModuleKey r13 = new ModuleKey("OMNI", 7, "omni");
        OMNI = r13;
        ModuleKey[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
        Companion = new a();
    }

    public static ModuleKey[] values() {
        return (ModuleKey[]) a.clone();
    }

    public final String getRaw() {
        return this.raw;
    }

    public static ModuleKey valueOf(String r1) {
        return (ModuleKey) r27.a.a(ModuleKey.class, r1);
    }

    public ModuleKey(String r1, int r2, String r3) {
        super(r1, r2);
        this.raw = r3;
    }
}
