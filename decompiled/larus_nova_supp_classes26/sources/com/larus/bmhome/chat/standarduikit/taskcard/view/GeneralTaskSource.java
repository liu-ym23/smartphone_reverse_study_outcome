package com.larus.bmhome.chat.standarduikit.taskcard.view;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/taskcard/view/GeneralTaskSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MAIN_CONVERSATION", "THREAD_CONVERSATION", "THREAD_CONVERSATION_V2", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GeneralTaskSource extends Enum<GeneralTaskSource> {
    public static final GeneralTaskSource MAIN_CONVERSATION = null;
    public static final GeneralTaskSource THREAD_CONVERSATION = null;
    public static final GeneralTaskSource THREAD_CONVERSATION_V2 = null;
    public static final GeneralTaskSource UNKNOWN = null;
    public static final /* synthetic */ GeneralTaskSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<GeneralTaskSource> getEntries() {
        return b;
    }

    static {
        GeneralTaskSource r0 = new GeneralTaskSource("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        GeneralTaskSource r1 = new GeneralTaskSource("MAIN_CONVERSATION", 1, 1);
        MAIN_CONVERSATION = r1;
        GeneralTaskSource r3 = new GeneralTaskSource("THREAD_CONVERSATION", 2, 2);
        THREAD_CONVERSATION = r3;
        GeneralTaskSource r5 = new GeneralTaskSource("THREAD_CONVERSATION_V2", 3, 3);
        THREAD_CONVERSATION_V2 = r5;
        GeneralTaskSource[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static GeneralTaskSource[] values() {
        return (GeneralTaskSource[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GeneralTaskSource valueOf(String r1) {
        return (GeneralTaskSource) a.a(GeneralTaskSource.class, r1);
    }

    public GeneralTaskSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
