package com.ss.android.lark.keyboard.base;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/keyboard/base/ChatAttachmentUploadState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "PROCESSING", "SUCCESS", "FAIL", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum ChatAttachmentUploadState extends Enum<ChatAttachmentUploadState> {
    public static final a Companion = null;
    public static final ChatAttachmentUploadState DEFAULT = null;
    public static final ChatAttachmentUploadState FAIL = null;
    public static final ChatAttachmentUploadState PROCESSING = null;
    public static final ChatAttachmentUploadState SUCCESS = null;
    public static final /* synthetic */ ChatAttachmentUploadState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<ChatAttachmentUploadState> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.keyboard.base.ChatAttachmentUploadState$a] */
    static {
        ChatAttachmentUploadState r0 = new ChatAttachmentUploadState("DEFAULT", 0, 0);
        DEFAULT = r0;
        ChatAttachmentUploadState r1 = new ChatAttachmentUploadState("PROCESSING", 1, 1);
        PROCESSING = r1;
        ChatAttachmentUploadState r3 = new ChatAttachmentUploadState("SUCCESS", 2, 2);
        SUCCESS = r3;
        ChatAttachmentUploadState r5 = new ChatAttachmentUploadState("FAIL", 3, 3);
        FAIL = r5;
        ChatAttachmentUploadState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static ChatAttachmentUploadState[] values() {
        return (ChatAttachmentUploadState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatAttachmentUploadState valueOf(String r1) {
        return (ChatAttachmentUploadState) r27.a.a(ChatAttachmentUploadState.class, r1);
    }

    public ChatAttachmentUploadState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
