package bk0;

import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o extends b {
    public o() {
    }

    @Override // bk0.b, bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if ((r2 instanceof o0) == false) goto L6;
        return true;
    L6:
        return super.a(r2);
    }
}
