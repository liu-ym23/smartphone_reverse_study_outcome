package com.bytedance.ai.view.input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/view/input/FloatingChatStatus;", "", "<init>", "(Ljava/lang/String;I)V", "READY_TO_INPUT", "READY_TO_SPEAK", "READY_TO_SEND", "ON_SPEAK", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FloatingChatStatus extends Enum<FloatingChatStatus> {
    public static final FloatingChatStatus ON_SPEAK = null;
    public static final FloatingChatStatus READY_TO_INPUT = null;
    public static final FloatingChatStatus READY_TO_SEND = null;
    public static final FloatingChatStatus READY_TO_SPEAK = null;
    public static final /* synthetic */ FloatingChatStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FloatingChatStatus> getEntries() {
        return b;
    }

    static {
        FloatingChatStatus r0 = new FloatingChatStatus("READY_TO_INPUT", 0);
        READY_TO_INPUT = r0;
        FloatingChatStatus r1 = new FloatingChatStatus("READY_TO_SPEAK", 1);
        READY_TO_SPEAK = r1;
        FloatingChatStatus r10 = new FloatingChatStatus("READY_TO_SEND", 2);
        READY_TO_SEND = r10;
        FloatingChatStatus r11 = new FloatingChatStatus("ON_SPEAK", 3);
        ON_SPEAK = r11;
        FloatingChatStatus[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static FloatingChatStatus[] values() {
        return (FloatingChatStatus[]) a.clone();
    }

    public static FloatingChatStatus valueOf(String r1) {
        return (FloatingChatStatus) r27.a.a(FloatingChatStatus.class, r1);
    }

    public FloatingChatStatus(String r1, int r10) {
        super(r1, r10);
    }
}
