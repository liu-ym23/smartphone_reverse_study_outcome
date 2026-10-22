package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.j0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.o0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k extends a {
    public k() {
    }

    @Override // bk0.a, bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if ((r2 instanceof r0) == false) goto L6;
    L22:
        return true;
    L6:
        if ((r2 instanceof o0) == true) goto L22;
        if ((r2 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q) == true) goto L22;
        if ((r2 instanceof a1) == true) goto L22;
        if ((r2 instanceof i0) == true) goto L22;
        if ((r2 instanceof j0) == true) goto L22;
        if ((r2 instanceof l0) == true) goto L22;
        return super.a(r2);
    }
}
