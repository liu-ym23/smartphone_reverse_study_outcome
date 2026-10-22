package com.bytedance.android.live.liveinteract.voicechat.emoji.icon;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/bytedance/android/live/liveinteract/voicechat/emoji/icon/IconFilterFactory$Receiver", "", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/icon/IconFilterFactory$Receiver;", "NORMAL", "MYSTERY", "ANONYMOUS", "ANCHOR", "AI_GUEST", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IconFilterFactory$Receiver extends Enum<IconFilterFactory$Receiver> {
    public static final IconFilterFactory$Receiver AI_GUEST = null;
    public static final IconFilterFactory$Receiver ANCHOR = null;
    public static final IconFilterFactory$Receiver ANONYMOUS = null;
    public static final IconFilterFactory$Receiver MYSTERY = null;
    public static final IconFilterFactory$Receiver NORMAL = null;
    public static final /* synthetic */ IconFilterFactory$Receiver[] a = null;

    static {
        IconFilterFactory$Receiver r1 = new IconFilterFactory$Receiver("NORMAL", 0);
        NORMAL = r1;
        IconFilterFactory$Receiver r2 = new IconFilterFactory$Receiver("MYSTERY", 1);
        MYSTERY = r2;
        IconFilterFactory$Receiver r3 = new IconFilterFactory$Receiver("ANONYMOUS", 2);
        ANONYMOUS = r3;
        IconFilterFactory$Receiver r4 = new IconFilterFactory$Receiver("ANCHOR", 3);
        ANCHOR = r4;
        IconFilterFactory$Receiver r5 = new IconFilterFactory$Receiver("AI_GUEST", 4);
        AI_GUEST = r5;
        a = new IconFilterFactory$Receiver[]{r1, r2, r3, r4, r5};
    }

    public static IconFilterFactory$Receiver valueOf(String r1) {
        return (IconFilterFactory$Receiver) a.a(IconFilterFactory$Receiver.class, r1);
    }

    public static IconFilterFactory$Receiver[] values() {
        return (IconFilterFactory$Receiver[]) a.clone();
    }

    public IconFilterFactory$Receiver(String r1, int r2) {
        super(r1, r2);
    }
}
