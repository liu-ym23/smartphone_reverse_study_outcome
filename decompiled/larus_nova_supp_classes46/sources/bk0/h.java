package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends a {
    public h() {
    }

    @Override // bk0.a, bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if ((r2 instanceof r0) == false) goto L6;
    L16:
        return true;
    L6:
        if ((r2 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q) == true) goto L16;
        if ((r2 instanceof a1) == true) goto L16;
        if ((r2 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r) == true) goto L16;
        if ((r2 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.d) == true) goto L16;
        return false;
    }
}
