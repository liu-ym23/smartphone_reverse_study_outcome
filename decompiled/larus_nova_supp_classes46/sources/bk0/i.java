package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.v0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends a {
    public i() {
    }

    @Override // bk0.a, bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if ((r2 instanceof v0) == false) goto L6;
        return true;
    L6:
        return super.a(r2);
    }
}
