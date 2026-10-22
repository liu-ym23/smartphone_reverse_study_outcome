package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Receiver;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Scene;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory$Sender;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u {
    public static f a(IconFilterFactory$Sender r6, IconFilterFactory$Receiver r7, IconFilterFactory$Scene r8, d r9) {
        Intrinsics.checkNotNullParameter(r6, "senderType");
        Intrinsics.checkNotNullParameter(r7, "receiverType");
        Intrinsics.checkNotNullParameter(r8, "sceneType");
        Intrinsics.checkNotNullParameter(r9, "functionFilter");
        int r10 = t.a[r6.ordinal()];
        if (r10 == 1) goto L7;
        if (r10 == 2) goto L6;
        e r11 = new r();
    L8:
        int r12 = t.b[r8.ordinal()];
        if (r12 == 1) goto L16;
        if (r12 == 2) goto L15;
        if (r12 != 3) goto L14;
        e r13 = new n();
    L17:
        int r14 = t.c[r7.ordinal()];
        if (r14 == 1) goto L30;
        if (r14 == 2) goto L29;
        if (r14 == 3) goto L28;
        if (r14 != 4) goto L23;
        e r15 = new h();
    L32:
        return new f(CollectionsKt.listOf(new e[]{r11, r13, r15, r9}));
    L23:
        if (r14 != 5) goto L26;
        r15 = new g();
        goto L32
    L26:
        throw new NoWhenBranchMatchedException();
    L28:
        r15 = new j();
        goto L32
    L29:
        r15 = new i();
        goto L32
    L30:
        r15 = new k();
        goto L32
    L14:
        throw new NoWhenBranchMatchedException();
    L15:
        r13 = new m();
        goto L17
    L16:
        r13 = new l();
        goto L17
    L6:
        r11 = new p();
        goto L8
    L7:
        r11 = new q();
        goto L8
    }
}
