package com.bytedance.android.live.liveinteract.voicechat.match.logger;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/match/logger/ChatMatchFailReason;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "OCCUPATION", "CANCEL", "NO_MATCH", "REQUEST_FAIL", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChatMatchFailReason extends Enum<ChatMatchFailReason> {
    public static final ChatMatchFailReason CANCEL = null;
    public static final ChatMatchFailReason NO_MATCH = null;
    public static final ChatMatchFailReason OCCUPATION = null;
    public static final ChatMatchFailReason REQUEST_FAIL = null;
    public static final /* synthetic */ ChatMatchFailReason[] a = null;
    private final String value;

    static {
        ChatMatchFailReason r1 = new ChatMatchFailReason("OCCUPATION", 0, "occupation");
        OCCUPATION = r1;
        ChatMatchFailReason r2 = new ChatMatchFailReason("CANCEL", 1, "cancel");
        CANCEL = r2;
        ChatMatchFailReason r3 = new ChatMatchFailReason("NO_MATCH", 2, "no_match");
        NO_MATCH = r3;
        ChatMatchFailReason r4 = new ChatMatchFailReason("REQUEST_FAIL", 3, "request_fail");
        REQUEST_FAIL = r4;
        a = new ChatMatchFailReason[]{r1, r2, r3, r4};
    }

    public static ChatMatchFailReason valueOf(String r1) {
        return (ChatMatchFailReason) a.a(ChatMatchFailReason.class, r1);
    }

    public static ChatMatchFailReason[] values() {
        return (ChatMatchFailReason[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ChatMatchFailReason(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
