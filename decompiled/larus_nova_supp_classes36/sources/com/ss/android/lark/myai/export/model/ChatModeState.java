package com.ss.android.lark.myai.export.model;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/myai/export/model/ChatModeState;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "UNKNOWN_STATE", "OPEN", "CLOSED", "Companion", "myai-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ChatModeState extends Enum<ChatModeState> {
    public static final ChatModeState CLOSED = null;
    public static final a Companion = null;
    public static final ChatModeState OPEN = null;
    public static final ChatModeState UNKNOWN_STATE = null;
    public static final /* synthetic */ ChatModeState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int number;

    public static EnumEntries<ChatModeState> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.myai.export.model.ChatModeState$a] */
    static {
        ChatModeState r0 = new ChatModeState("UNKNOWN_STATE", 0, 0);
        UNKNOWN_STATE = r0;
        ChatModeState r1 = new ChatModeState("OPEN", 1, 1);
        OPEN = r1;
        ChatModeState r3 = new ChatModeState("CLOSED", 2, 2);
        CLOSED = r3;
        ChatModeState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static ChatModeState[] values() {
        return (ChatModeState[]) a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static ChatModeState valueOf(String r1) {
        return (ChatModeState) r27.a.a(ChatModeState.class, r1);
    }

    public ChatModeState(String r1, int r2, int r3) {
        super(r1, r2);
        this.number = r3;
    }
}
