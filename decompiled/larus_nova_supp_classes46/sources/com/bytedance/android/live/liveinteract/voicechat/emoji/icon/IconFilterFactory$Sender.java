package com.bytedance.android.live.liveinteract.voicechat.emoji.icon;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/live/liveinteract/voicechat/emoji/icon/IconFilterFactory$Sender", "", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/icon/IconFilterFactory$Sender;", "ANCHOR", "ADMIN", "GUEST", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IconFilterFactory$Sender extends Enum<IconFilterFactory$Sender> {
    public static final IconFilterFactory$Sender ADMIN = null;
    public static final IconFilterFactory$Sender ANCHOR = null;
    public static final IconFilterFactory$Sender GUEST = null;
    public static final /* synthetic */ IconFilterFactory$Sender[] a = null;

    static {
        IconFilterFactory$Sender r1 = new IconFilterFactory$Sender("ANCHOR", 0);
        ANCHOR = r1;
        IconFilterFactory$Sender r2 = new IconFilterFactory$Sender("ADMIN", 1);
        ADMIN = r2;
        IconFilterFactory$Sender r3 = new IconFilterFactory$Sender("GUEST", 2);
        GUEST = r3;
        a = new IconFilterFactory$Sender[]{r1, r2, r3};
    }

    public static IconFilterFactory$Sender valueOf(String r1) {
        return (IconFilterFactory$Sender) a.a(IconFilterFactory$Sender.class, r1);
    }

    public static IconFilterFactory$Sender[] values() {
        return (IconFilterFactory$Sender[]) a.clone();
    }

    public IconFilterFactory$Sender(String r1, int r2) {
        super(r1, r2);
    }
}
