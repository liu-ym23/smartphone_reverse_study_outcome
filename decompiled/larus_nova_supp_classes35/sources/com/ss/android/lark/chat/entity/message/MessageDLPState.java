package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageDLPState;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "IN_PROGRESS", "PASS", "BLOCK", "INACTIVE", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageDLPState extends Enum<MessageDLPState> {
    public static final MessageDLPState BLOCK = null;
    public static final a Companion = null;
    public static final MessageDLPState INACTIVE = null;
    public static final MessageDLPState IN_PROGRESS = null;
    public static final MessageDLPState PASS = null;
    public static final MessageDLPState UNKNOWN = null;
    public static final /* synthetic */ MessageDLPState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MessageDLPState> getEntries() {
        return b;
    }

    static {
        MessageDLPState r0 = new MessageDLPState("UNKNOWN", 0, 0);
        UNKNOWN = r0;
        MessageDLPState r1 = new MessageDLPState("IN_PROGRESS", 1, 1);
        IN_PROGRESS = r1;
        MessageDLPState r3 = new MessageDLPState("PASS", 2, 2);
        PASS = r3;
        MessageDLPState r5 = new MessageDLPState("BLOCK", 3, 3);
        BLOCK = r5;
        MessageDLPState r7 = new MessageDLPState("INACTIVE", 4, 4);
        INACTIVE = r7;
        MessageDLPState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static MessageDLPState[] values() {
        return (MessageDLPState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final MessageDLPState fromValue(int r2) {
        Companion.getClass();
        MessageDLPState r0 = IN_PROGRESS;
        if (r2 == r0.getValue()) goto L16;
        MessageDLPState r1 = PASS;
        if (r2 == r1.getValue()) goto L17;
        MessageDLPState r3 = BLOCK;
        if (r2 == r3.getValue()) goto L18;
        MessageDLPState r4 = INACTIVE;
        if (r2 != r4.getValue()) goto L15;
        return r4;
    L15:
        return UNKNOWN;
    L18:
        return r3;
    L17:
        return r1;
    L16:
        return r0;
    }

    public static MessageDLPState valueOf(String r1) {
        return (MessageDLPState) r27.a.a(MessageDLPState.class, r1);
    }

    public MessageDLPState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
