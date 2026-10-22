package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.j0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.o0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p extends c {
    public p() {
    }

    @Override // bk0.c, bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if ((r2 instanceof n0) == false) goto L6;
    L31:
        return true;
    L6:
        if ((r2 instanceof b1) == true) goto L31;
        if ((r2 instanceof x0) == true) goto L31;
        if ((r2 instanceof c1) == true) goto L31;
        if ((r2 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a) == true) goto L31;
        if ((r2 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n) == true) goto L31;
        if ((r2 instanceof i0) == true) goto L31;
        if ((r2 instanceof j0) == true) goto L31;
        if ((r2 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.d) == true) goto L31;
        if ((r2 instanceof o0) == true) goto L31;
        return super.a(r2);
    }
}
