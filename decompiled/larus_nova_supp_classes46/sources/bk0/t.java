package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Receiver;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Scene;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Sender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class t {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;

    static {
        int[] r0 = new int[IconFilterFactory$Sender.values().length];
        a = r0;
        r0[IconFilterFactory$Sender.ANCHOR.ordinal()] = 1;
        r0[IconFilterFactory$Sender.ADMIN.ordinal()] = 2;
        int[] r1 = new int[IconFilterFactory$Scene.values().length];
        b = r1;
        r1[IconFilterFactory$Scene.ROOM.ordinal()] = 1;
        r1[IconFilterFactory$Scene.CROSS_ROOM.ordinal()] = 2;
        r1[IconFilterFactory$Scene.KTV.ordinal()] = 3;
        int[] r2 = new int[IconFilterFactory$Receiver.values().length];
        c = r2;
        r2[IconFilterFactory$Receiver.NORMAL.ordinal()] = 1;
        r2[IconFilterFactory$Receiver.ANONYMOUS.ordinal()] = 2;
        r2[IconFilterFactory$Receiver.MYSTERY.ordinal()] = 3;
        r2[IconFilterFactory$Receiver.ANCHOR.ordinal()] = 4;
        r2[IconFilterFactory$Receiver.AI_GUEST.ordinal()] = 5;
    }
}
