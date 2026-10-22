package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n extends b {
    public n() {
    }

    @Override // bk0.b, bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if ((r2 instanceof i0) == false) goto L6;
    L7:
        return true;
    L6:
        if ((r2 instanceof j0) == true) goto L7;
        return super.a(r2);
    }
}
